package com.tencent.liteav.videoproducer2;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.CustomHandler;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.egl.EGLCore;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.h;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.b;
import com.tencent.liteav.videoproducer.encoder.e;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HardwareVideoEncoder2 {
    private EGLCore mEGLCore;
    private Surface mInputSurface;
    private long mNativeHandler;
    private final VideoEncodeParams mParams;
    private h mPixelFrameRenderer;
    private HWEncoderServerConfig mServerConfig;
    private b mSurfaceInputVideoEncoder;
    private String mTAG;
    private String mTraceId;
    private final Size mSurfaceSize = new Size(0, 0);
    private final AtomicBoolean mNeedRestart = new AtomicBoolean(false);
    private final Bundle mSessionStates = new Bundle();
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private long mPreFrameTimeStamp = 0;
    private final e.a mVideoEncoderListener = new e.a() { // from class: com.tencent.liteav.videoproducer2.HardwareVideoEncoder2.1
        @Override // com.tencent.liteav.videoproducer.encoder.e.a
        public final void a() {
            HardwareVideoEncoder2.this.mNeedRestart.set(true);
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
        public final void onBitrateModeUpdated(VideoEncoderDef.BitrateMode bitrateMode) {
            HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
            hardwareVideoEncoder2.nativeOnBitrateModeUpdated(hardwareVideoEncoder2.mNativeHandler, bitrateMode.mValue);
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
        public final void onEncodedFail(e.a aVar) {
            e.a aVar2 = e.a.ERR_CODE_NONE;
            HardwareVideoEncoder2.this.notifyEncodeFail();
        }

        @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.b
        public final synchronized void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
            boolean z2;
            int intValue;
            if (HardwareVideoEncoder2.this.mNativeHandler != 0 && !z) {
                HardwareVideoEncoder2 hardwareVideoEncoder2 = HardwareVideoEncoder2.this;
                long j = hardwareVideoEncoder2.mNativeHandler;
                ByteBuffer byteBuffer = encodedVideoFrame.data;
                int i = encodedVideoFrame.nalType.mValue;
                int i2 = encodedVideoFrame.profileType.mValue;
                int i3 = encodedVideoFrame.codecType.mValue;
                int i4 = encodedVideoFrame.rotation;
                long j2 = encodedVideoFrame.dts;
                long j3 = encodedVideoFrame.pts;
                long j4 = encodedVideoFrame.gopIndex;
                long j5 = encodedVideoFrame.gopFrameIndex;
                long j6 = encodedVideoFrame.frameIndex;
                long j7 = encodedVideoFrame.refFrameIndex;
                int i5 = encodedVideoFrame.width;
                int i6 = encodedVideoFrame.height;
                Integer num = encodedVideoFrame.svcInfo;
                if (num != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (num == null) {
                    intValue = 0;
                } else {
                    intValue = num.intValue();
                }
                hardwareVideoEncoder2.nativeOnEncodedNAL(j, encodedVideoFrame, byteBuffer, i, i2, i3, i4, j2, j3, j4, j5, j6, j7, i5, i6, z2, intValue);
                return;
            }
            LiteavLog.d(HardwareVideoEncoder2.this.mTAG, "onEncodedNAL mNativeHandler=%d,isEos=%b", Long.valueOf(HardwareVideoEncoder2.this.mNativeHandler), Boolean.valueOf(z));
        }
    };

    public HardwareVideoEncoder2(long j, String str, VideoEncodeParams videoEncodeParams) {
        this.mTraceId = str;
        this.mTAG = str + "HardwareVideoEncoder2_" + hashCode();
        this.mNativeHandler = j;
        this.mParams = videoEncodeParams;
    }

    public static PixelFrame createPixelFrameByTexture(int i, int i2, int i3, int i4, long j, int i5, boolean z, boolean z2, int i6, Object obj) {
        int i7 = GLConstants.a.TEXTURE_2D.mValue;
        GLConstants.PixelFormatType.RGBA.getValue();
        PixelFrame pixelFrame = new PixelFrame(i, i2, 0, i3, i4);
        pixelFrame.setMirrorHorizontal(z);
        pixelFrame.setMirrorVertical(z2);
        pixelFrame.setTextureId(i6);
        pixelFrame.setGLContext(obj);
        pixelFrame.setRotation(k.a(i5));
        pixelFrame.setTimestamp(j);
        return pixelFrame;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0042 A[Catch: d -> 0x0029, TryCatch #0 {d -> 0x0029, blocks: (B:6:0x0005, B:8:0x0016, B:11:0x001f, B:12:0x0035, B:14:0x0042, B:15:0x0048, B:17:0x0056, B:18:0x005f, B:20:0x007b, B:21:0x009c, B:24:0x002c), top: B:5:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0056 A[Catch: d -> 0x0029, TryCatch #0 {d -> 0x0029, blocks: (B:6:0x0005, B:8:0x0016, B:11:0x001f, B:12:0x0035, B:14:0x0042, B:15:0x0048, B:17:0x0056, B:18:0x005f, B:20:0x007b, B:21:0x009c, B:24:0x002c), top: B:5:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b A[Catch: d -> 0x0029, TryCatch #0 {d -> 0x0029, blocks: (B:6:0x0005, B:8:0x0016, B:11:0x001f, B:12:0x0035, B:14:0x0042, B:15:0x0048, B:17:0x0056, B:18:0x005f, B:20:0x007b, B:21:0x009c, B:24:0x002c), top: B:5:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void drawFrameToInputSurface(PixelFrame pixelFrame) {
        h hVar;
        b bVar;
        EGLCore eGLCore = this.mEGLCore;
        if (eGLCore == null) {
            return;
        }
        try {
            eGLCore.makeCurrent();
            PixelFrame pixelFrame2 = new PixelFrame(pixelFrame);
            if (pixelFrame2.getRotation() != k.ROTATION_90 && pixelFrame2.getRotation() != k.ROTATION_270) {
                pixelFrame2.setMirrorVertical(!pixelFrame2.isMirrorVertical());
                Size size = this.mSurfaceSize;
                OpenGlUtils.glViewport(0, 0, size.width, size.height);
                hVar = this.mPixelFrameRenderer;
                if (hVar != null) {
                    hVar.a(pixelFrame2, GLConstants.GLScaleType.CENTER_CROP, (d) null);
                }
                bVar = this.mSurfaceInputVideoEncoder;
                long timestamp = pixelFrame2.getTimestamp();
                if (bVar.i.isEmpty()) {
                    bVar.j.set(SystemClock.elapsedRealtime());
                }
                bVar.i.addLast(Long.valueOf(timestamp));
                bVar.c.sendEmptyMessageDelayed(10, 10L);
                if (pixelFrame2.getTimestamp() < this.mPreFrameTimeStamp) {
                    LiteavLog.e(this.mTAG, "timestamp is not increase. pre: " + this.mPreFrameTimeStamp + ", cur: " + pixelFrame2.getTimestamp());
                }
                this.mPreFrameTimeStamp = pixelFrame2.getTimestamp();
                this.mEGLCore.setPresentationTime(TimeUnit.MILLISECONDS.toNanos(pixelFrame2.getTimestamp()));
                this.mEGLCore.swapBuffers();
            }
            pixelFrame2.setMirrorHorizontal(!pixelFrame2.isMirrorHorizontal());
            Size size2 = this.mSurfaceSize;
            OpenGlUtils.glViewport(0, 0, size2.width, size2.height);
            hVar = this.mPixelFrameRenderer;
            if (hVar != null) {
            }
            bVar = this.mSurfaceInputVideoEncoder;
            long timestamp2 = pixelFrame2.getTimestamp();
            if (bVar.i.isEmpty()) {
            }
            bVar.i.addLast(Long.valueOf(timestamp2));
            bVar.c.sendEmptyMessageDelayed(10, 10L);
            if (pixelFrame2.getTimestamp() < this.mPreFrameTimeStamp) {
            }
            this.mPreFrameTimeStamp = pixelFrame2.getTimestamp();
            this.mEGLCore.setPresentationTime(TimeUnit.MILLISECONDS.toNanos(pixelFrame2.getTimestamp()));
            this.mEGLCore.swapBuffers();
        } catch (com.tencent.liteav.videobase.egl.d e) {
            LiteavLog.e(this.mThrottlers.a("EncodeFrameError"), this.mTAG, "makeCurrent failed. error = ".concat(String.valueOf("VideoEncode: swapBuffer error, EGLCode:" + e.mErrorCode + " message:" + e.getMessage())), e);
            notifyEncodeFail();
        }
    }

    public static Object getCurrentContext() {
        return OpenGlUtils.getCurrentContext();
    }

    private ServerVideoProducerConfig getServerVideoProducerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        ServerVideoProducerConfig serverVideoProducerConfig = new ServerVideoProducerConfig();
        serverVideoProducerConfig.setHardwareEncodeType(hWEncoderServerConfig.getHardwareEncodeType());
        serverVideoProducerConfig.setHardwareEncoderHighProfileEnable(hWEncoderServerConfig.getHardwareEncoderHighProfileEnable());
        serverVideoProducerConfig.setHardwareEncoderHighProfileSupport(hWEncoderServerConfig.getHardwareEncoderHighProfileSupport());
        Boolean isHardwareEncoderBitrateModeCBRSupported = hWEncoderServerConfig.isHardwareEncoderBitrateModeCBRSupported();
        if (isHardwareEncoderBitrateModeCBRSupported != null) {
            serverVideoProducerConfig.setHardwareEncoderBitrateModeCBRSupported(isHardwareEncoderBitrateModeCBRSupported.booleanValue());
        }
        return serverVideoProducerConfig;
    }

    private boolean initOpenGLComponents(Object obj, Surface surface) {
        if (surface == null) {
            LiteavLog.w(this.mThrottlers.a("NoSurface"), this.mTAG, "init opengl: surface is null.", new Object[0]);
            return false;
        }
        LiteavLog.d(this.mThrottlers.a("initGL"), this.mTAG, "initOpenGLComponents", new Object[0]);
        EGLCore eGLCore = new EGLCore();
        this.mEGLCore = eGLCore;
        try {
            Size size = this.mSurfaceSize;
            eGLCore.initialize(obj, surface, size.width, size.height);
            Size size2 = this.mSurfaceSize;
            this.mPixelFrameRenderer = new h(size2.width, size2.height);
            return true;
        } catch (com.tencent.liteav.videobase.egl.d e) {
            LiteavLog.e(this.mThrottlers.a("initGLError"), this.mTAG, "create EGLCore failed. error = ".concat(String.valueOf("VideoEncode: create EGLCore failed, EGLCode:" + e.mErrorCode + " message:" + e.getMessage())), e);
            notifyStartEncodedFail();
            this.mEGLCore = null;
            return false;
        }
    }

    public static boolean isInUIThread() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnBitrateModeUpdated(long j, int i);

    private native void nativeOnEncodedFail(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnEncodedNAL(long j, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, int i5, int i6, boolean z, int i7);

    private native void nativeOnStartEncodedFail(long j);

    private boolean restart() {
        LiteavLog.d(this.mTAG, "reStart");
        stop();
        return start();
    }

    private boolean start() {
        if (this.mSurfaceInputVideoEncoder != null) {
            if (this.mInputSurface == null) {
                return false;
            }
            return true;
        }
        LiteavLog.i(this.mTAG, "Start hw video encoder. %s", this.mParams);
        b bVar = new b(this.mSessionStates, new com.tencent.liteav.videobase.videobase.d(), this.mTraceId);
        this.mSurfaceInputVideoEncoder = bVar;
        bVar.c = new CustomHandler(Looper.myLooper()) { // from class: com.tencent.liteav.videoproducer.encoder.b.1
            public AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 10) {
                    b.this.c();
                }
            }
        };
        this.mSurfaceInputVideoEncoder.a(getServerVideoProducerConfig(this.mServerConfig));
        b bVar2 = this.mSurfaceInputVideoEncoder;
        VideoEncodeParams videoEncodeParams = this.mParams;
        e.a aVar = this.mVideoEncoderListener;
        LiteavLog.d(bVar2.a, "start");
        bVar2.e = aVar;
        Surface a = bVar2.a(videoEncodeParams);
        LiteavLog.i(bVar2.a, "startCodecInternal success");
        Size size = new Size(SuperAdminReportActivity.THIRTY_DAY, 1280);
        VideoEncodeParams videoEncodeParams2 = bVar2.f;
        if (videoEncodeParams2 != null) {
            size.set(videoEncodeParams2.width, videoEncodeParams2.height);
        }
        Pair pair = new Pair(a, size);
        this.mInputSurface = (Surface) pair.first;
        this.mSurfaceSize.set((Size) pair.second);
        if (this.mInputSurface != null) {
            return true;
        }
        notifyStartEncodedFail();
        return false;
    }

    private void stop() {
        uninitOpenGLComponents();
        Surface surface = this.mInputSurface;
        if (surface != null) {
            surface.release();
            this.mInputSurface = null;
        }
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            LiteavLog.i(bVar.a, "stop");
            bVar.b();
            bVar.a();
            this.mSurfaceInputVideoEncoder.a();
            this.mSurfaceInputVideoEncoder = null;
        }
    }

    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        if (this.mNeedRestart.getAndSet(false) && !restart()) {
            return;
        }
        if (this.mSurfaceInputVideoEncoder == null && !start()) {
            return;
        }
        pixelFrame.getGLContext();
        if (this.mEGLCore == null && !initOpenGLComponents(pixelFrame.getGLContext(), this.mInputSurface)) {
            return;
        }
        this.mSurfaceInputVideoEncoder.c();
        drawFrameToInputSurface(pixelFrame);
    }

    public synchronized void notifyEncodeFail() {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnEncodedFail(j);
        }
    }

    public synchronized void notifyStartEncodedFail() {
        long j = this.mNativeHandler;
        if (j != 0) {
            nativeOnStartEncodedFail(j);
        }
    }

    public synchronized void release() {
        LiteavLog.d(this.mTAG, "release");
        this.mNativeHandler = 0L;
        stop();
    }

    public void requestKeyFrame() {
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void setBitrate(int i) {
        MediaCodec mediaCodec;
        LiteavLog.i(this.mTAG, "SetBitrate ".concat(String.valueOf(i)));
        this.mParams.bitrate = i;
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar == null) {
            return;
        }
        VideoEncodeParams videoEncodeParams = bVar.f;
        if (videoEncodeParams == null) {
            LiteavLog.w(bVar.a, "encoder not started yet. set bitrate to " + i + " kbps will not take effect.");
            return;
        }
        if (videoEncodeParams.bitrate != i) {
            LiteavLog.i(bVar.a, "set bitrate to " + i + " kbps");
            boolean z = false;
            if (i < bVar.f.bitrate) {
                if (bVar.b.getBoolean("need_restart_when_down_bitrate", false)) {
                    z = true;
                } else {
                    bVar.a(i);
                }
            }
            bVar.f.bitrate = i;
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 19 && (mediaCodec = bVar.d) != null) {
                if (z) {
                    bVar.c.removeCallbacks(bVar.k);
                    long elapsedRealtime = SystemClock.elapsedRealtime() - bVar.g;
                    if (elapsedRealtime >= TimeUnit.SECONDS.toMillis(2L)) {
                        bVar.k.run();
                        return;
                    } else {
                        bVar.c.postDelayed(bVar.k, 2000 - elapsedRealtime);
                        return;
                    }
                }
                bVar.a(mediaCodec, i);
            }
        }
    }

    public void setHWEncoderServerConfig(HWEncoderServerConfig hWEncoderServerConfig) {
        this.mServerConfig = hWEncoderServerConfig;
        b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            bVar.a(getServerVideoProducerConfig(hWEncoderServerConfig));
        }
    }

    public void signalEndOfStream() {
        final b bVar = this.mSurfaceInputVideoEncoder;
        if (bVar != null) {
            LiteavLog.i(bVar.a, "signalEndOfStream");
            MediaCodec mediaCodec = bVar.d;
            if (mediaCodec != null) {
                try {
                    mediaCodec.signalEndOfInputStream();
                } catch (Throwable th) {
                    LiteavLog.e(bVar.a, "signalEndOfStream failed.", th);
                }
            }
            if (bVar.h == null) {
                r rVar = new r(Looper.myLooper(), new r.a(bVar) { // from class: com.tencent.liteav.videoproducer.encoder.d
                    private final b a;

                    {
                        this.a = bVar;
                    }

                    @Override // com.tencent.liteav.base.util.r.a
                    public final void onTimeout() {
                        this.a.c();
                    }
                });
                bVar.h = rVar;
                rVar.a(30);
            }
        }
    }

    public void uninitOpenGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        LiteavLog.d(this.mThrottlers.a("uninitGL"), this.mTAG, "uninitOpenGLComponents", new Object[0]);
        try {
            this.mEGLCore.makeCurrent();
            h hVar = this.mPixelFrameRenderer;
            if (hVar != null) {
                hVar.a();
                this.mPixelFrameRenderer = null;
            }
        } catch (com.tencent.liteav.videobase.egl.d e) {
            LiteavLog.e(this.mThrottlers.a("unintGLError"), this.mTAG, "makeCurrent failed.", e);
        }
        EGLCore.destroy(this.mEGLCore);
        this.mEGLCore = null;
    }
}
