package com.tencent.qgame.animplayer;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qgame.animplayer.file.IFileContainer;
import com.tencent.qgame.animplayer.util.ALog;
import com.tencent.qgame.animplayer.util.MediaUtil;
import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\r\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u001f\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J@\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u00106\u001a\u00020\u0007H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/tencent/qgame/animplayer/HardDecoder;", "Lcom/tencent/qgame/animplayer/Decoder;", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "player", "Lcom/tencent/qgame/animplayer/AnimPlayer;", "(Lcom/tencent/qgame/animplayer/AnimPlayer;)V", "alignHeight", "", "alignWidth", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "getBufferInfo", "()Landroid/media/MediaCodec$BufferInfo;", "bufferInfo$delegate", "Lkotlin/Lazy;", "glTexture", "Landroid/graphics/SurfaceTexture;", "needDestroy", "", "needYUV", "outputFormat", "Landroid/media/MediaFormat;", "surface", "Landroid/view/Surface;", "videoHeight", "videoWidth", TUIConstants.TUIBeauty.METHOD_DESTROY_XMAGIC, "", "destroyInner", "onFrameAvailable", "surfaceTexture", "release", "decoder", "Landroid/media/MediaCodec;", "extractor", "Landroid/media/MediaExtractor;", "renderData", "start", "fileContainer", "Lcom/tencent/qgame/animplayer/file/IFileContainer;", "startDecode", "startPlay", "yuv420spTop", "", "yuv420sp", "yuvCopy", "src", "srcOffset", "inWidth", "inHeight", "dest", "outWidth", "outHeight", "yuvProcess", "outputIndex", "Companion", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class HardDecoder extends Decoder implements SurfaceTexture.OnFrameAvailableListener {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(HardDecoder.class), "bufferInfo", "getBufferInfo()Landroid/media/MediaCodec$BufferInfo;"))};
    private static final String TAG = "AnimPlayer.HardDecoder";
    private int alignHeight;
    private int alignWidth;

    /* renamed from: bufferInfo$delegate, reason: from kotlin metadata */
    private final Lazy bufferInfo;
    private SurfaceTexture glTexture;
    private boolean needDestroy;
    private boolean needYUV;
    private MediaFormat outputFormat;
    private Surface surface;
    private int videoHeight;
    private int videoWidth;

    public HardDecoder(@NotNull AnimPlayer animPlayer) {
        super(animPlayer);
        this.bufferInfo = LazyKt.lazy(new Function0<MediaCodec.BufferInfo>() { // from class: com.tencent.qgame.animplayer.HardDecoder$bufferInfo$2
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final MediaCodec.BufferInfo m١٦٣invoke() {
                return new MediaCodec.BufferInfo();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyInner() {
        ALog.INSTANCE.i(TAG, "destroyInner");
        Handler handler = getRenderThread().getHandler();
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.HardDecoder$destroyInner$1
                @Override // java.lang.Runnable
                public final void run() {
                    HardDecoder.this.getPlayer().getPluginManager().onDestroy();
                    IRenderListener render = HardDecoder.this.getRender();
                    if (render != null) {
                        render.destroyRender();
                    }
                    HardDecoder.this.setRender(null);
                    HardDecoder.this.onVideoDestroy();
                    HardDecoder.this.destroyThread();
                }
            });
        }
    }

    private final MediaCodec.BufferInfo getBufferInfo() {
        Lazy lazy = this.bufferInfo;
        KProperty kProperty = $$delegatedProperties[0];
        return (MediaCodec.BufferInfo) lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void release(final MediaCodec decoder, final MediaExtractor extractor) {
        Handler handler = getRenderThread().getHandler();
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.HardDecoder$release$1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z;
                    SurfaceTexture surfaceTexture;
                    Surface surface;
                    IRenderListener render = HardDecoder.this.getRender();
                    if (render != null) {
                        render.clearFrame();
                    }
                    try {
                        ALog.INSTANCE.i("AnimPlayer.HardDecoder", "release");
                        MediaCodec mediaCodec = decoder;
                        if (mediaCodec != null) {
                            mediaCodec.stop();
                            mediaCodec.release();
                        }
                        MediaExtractor mediaExtractor = extractor;
                        if (mediaExtractor != null) {
                            mediaExtractor.release();
                        }
                        surfaceTexture = HardDecoder.this.glTexture;
                        if (surfaceTexture != null) {
                            surfaceTexture.release();
                        }
                        HardDecoder.this.glTexture = null;
                        HardDecoder.this.getSpeedControlUtil().reset();
                        HardDecoder.this.getPlayer().getPluginManager().onRelease();
                        IRenderListener render2 = HardDecoder.this.getRender();
                        if (render2 != null) {
                            render2.releaseTexture();
                        }
                        surface = HardDecoder.this.surface;
                        if (surface != null) {
                            surface.release();
                        }
                        HardDecoder.this.surface = null;
                    } catch (Throwable th) {
                        ALog.INSTANCE.e("AnimPlayer.HardDecoder", "release e=" + th, th);
                    }
                    HardDecoder.this.setRunning(false);
                    HardDecoder.this.onVideoComplete();
                    z = HardDecoder.this.needDestroy;
                    if (z) {
                        HardDecoder.this.destroyInner();
                    }
                }
            });
        }
    }

    private final void renderData() {
        Handler handler = getRenderThread().getHandler();
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.HardDecoder$renderData$1
                @Override // java.lang.Runnable
                public final void run() {
                    SurfaceTexture surfaceTexture;
                    try {
                        surfaceTexture = HardDecoder.this.glTexture;
                        if (surfaceTexture != null) {
                            surfaceTexture.updateTexImage();
                            IRenderListener render = HardDecoder.this.getRender();
                            if (render != null) {
                                render.renderFrame();
                            }
                            HardDecoder.this.getPlayer().getPluginManager().onRendering();
                            IRenderListener render2 = HardDecoder.this.getRender();
                            if (render2 != null) {
                                render2.swapBuffers();
                            }
                        }
                    } catch (Throwable th) {
                        ALog.INSTANCE.e("AnimPlayer.HardDecoder", "render exception=" + th, th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void startDecode(MediaExtractor extractor, MediaCodec decoder) {
        String str;
        boolean z;
        int i;
        boolean z2;
        ByteBuffer[] inputBuffers = decoder.getInputBuffers();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        boolean z5 = false;
        while (!z4) {
            if (getIsStopReq()) {
                ALog.INSTANCE.i(TAG, "stop decode");
                release(decoder, extractor);
                return;
            }
            if (!z3) {
                int dequeueInputBuffer = decoder.dequeueInputBuffer(10000L);
                if (dequeueInputBuffer >= 0) {
                    int readSampleData = extractor.readSampleData(inputBuffers[dequeueInputBuffer], i2);
                    if (readSampleData < 0) {
                        str = TAG;
                        decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        ALog.INSTANCE.d(str, "decode EOS");
                        z = true;
                        if (!z4) {
                            int dequeueOutputBuffer = decoder.dequeueOutputBuffer(getBufferInfo(), 10000L);
                            if (dequeueOutputBuffer == -1) {
                                ALog.INSTANCE.d(str, "no output from decoder available");
                            } else if (dequeueOutputBuffer == -3) {
                                ALog.INSTANCE.d(str, "decoder output buffers changed");
                            } else if (dequeueOutputBuffer == -2) {
                                MediaFormat outputFormat = decoder.getOutputFormat();
                                this.outputFormat = outputFormat;
                                if (outputFormat != null) {
                                    try {
                                        int integer = outputFormat.getInteger("stride");
                                        int integer2 = outputFormat.getInteger("slice-height");
                                        if (integer > 0 && integer2 > 0) {
                                            this.alignWidth = integer;
                                            this.alignHeight = integer2;
                                        }
                                    } catch (Throwable th) {
                                        ALog.INSTANCE.e(str, String.valueOf(th), th);
                                    }
                                }
                                ALog.INSTANCE.i(str, "decoder output format changed: " + this.outputFormat);
                            } else if (dequeueOutputBuffer >= 0) {
                                if ((getBufferInfo().flags & 4) != 0) {
                                    setPlayLoop(getPlayLoop() - 1);
                                    i = getPlayLoop();
                                    getPlayer().setPlayLoop(getPlayLoop());
                                    if (getPlayLoop() <= 0) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                } else {
                                    i = 0;
                                }
                                if (!z4) {
                                    getSpeedControlUtil().preRender(getBufferInfo().presentationTimeUs);
                                }
                                if (this.needYUV && !z4) {
                                    yuvProcess(decoder, dequeueOutputBuffer);
                                }
                                if (!z4 && !this.needYUV) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                decoder.releaseOutputBuffer(dequeueOutputBuffer, z2);
                                if (i4 == 0 && !z5) {
                                    onVideoStart();
                                }
                                getPlayer().getPluginManager().onDecoding(i4);
                                onVideoRender(i4, getPlayer().getConfigManager().getConfig());
                                i4++;
                                ALog aLog = ALog.INSTANCE;
                                aLog.d(str, "decode frameIndex=" + i4);
                                if (i > 0) {
                                    aLog.d(str, "Reached EOD, looping");
                                    getPlayer().getPluginManager().onLoopStart();
                                    extractor.seekTo(0L, 2);
                                    decoder.flush();
                                    getSpeedControlUtil().reset();
                                    z = false;
                                    i4 = 0;
                                    z5 = true;
                                }
                                if (z4) {
                                    release(decoder, extractor);
                                }
                            } else {
                                throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                            }
                        }
                        z3 = z;
                        i2 = 0;
                    } else {
                        str = TAG;
                        decoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, extractor.getSampleTime(), 0);
                        ALog.INSTANCE.d(str, "submitted frame " + i3 + " to dec, size=" + readSampleData);
                        i3++;
                        extractor.advance();
                    }
                } else {
                    str = TAG;
                    ALog.INSTANCE.d(str, "input buffer not available");
                }
            } else {
                str = TAG;
            }
            z = z3;
            if (!z4) {
            }
            z3 = z;
            i2 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPlay(IFileContainer fileContainer) {
        boolean z;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = null;
        try {
            MediaUtil mediaUtil = MediaUtil.INSTANCE;
            MediaExtractor extractor = mediaUtil.getExtractor(fileContainer);
            objectRef.element = extractor;
            int selectVideoTrack = mediaUtil.selectVideoTrack(extractor);
            if (selectVideoTrack >= 0) {
                ((MediaExtractor) objectRef.element).selectTrack(selectVideoTrack);
                MediaFormat trackFormat = ((MediaExtractor) objectRef.element).getTrackFormat(selectVideoTrack);
                objectRef3.element = trackFormat;
                if (trackFormat != null) {
                    if (mediaUtil.checkIsHevc(trackFormat)) {
                        int i = Build.VERSION.SDK_INT;
                        if (!mediaUtil.checkSupportCodec(MediaUtil.MIME_HEVC)) {
                            onFailed(10008, "0x8 hevc not support sdk:" + i + ",support hevc:" + mediaUtil.checkSupportCodec(MediaUtil.MIME_HEVC));
                            release(null, null);
                            return;
                        }
                    }
                    this.videoWidth = ((MediaFormat) objectRef3.element).getInteger("width");
                    int integer = ((MediaFormat) objectRef3.element).getInteger("height");
                    this.videoHeight = integer;
                    this.alignWidth = this.videoWidth;
                    this.alignHeight = integer;
                    ALog aLog = ALog.INSTANCE;
                    aLog.i(TAG, "Video size is " + this.videoWidth + " x " + this.videoHeight);
                    if (this.videoWidth % 16 != 0 && getPlayer().getEnableVersion1()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.needYUV = z;
                    try {
                        if (prepareRender(z)) {
                            preparePlay(this.videoWidth, this.videoHeight);
                            IRenderListener render = getRender();
                            if (render != null) {
                                SurfaceTexture surfaceTexture = new SurfaceTexture(render.getExternalTexture());
                                surfaceTexture.setOnFrameAvailableListener(this);
                                surfaceTexture.setDefaultBufferSize(this.videoWidth, this.videoHeight);
                                this.glTexture = surfaceTexture;
                                render.clearFrame();
                            }
                            try {
                                String string = ((MediaFormat) objectRef3.element).getString("mime");
                                if (string == null) {
                                    string = "";
                                }
                                aLog.i(TAG, "Video MIME is " + string);
                                final MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
                                if (this.needYUV) {
                                    ((MediaFormat) objectRef3.element).setInteger("color-format", 19);
                                    createDecoderByType.configure((MediaFormat) objectRef3.element, (Surface) null, (MediaCrypto) null, 0);
                                } else {
                                    Surface surface = new Surface(this.glTexture);
                                    this.surface = surface;
                                    createDecoderByType.configure((MediaFormat) objectRef3.element, surface, (MediaCrypto) null, 0);
                                }
                                createDecoderByType.start();
                                Handler handler = getDecodeThread().getHandler();
                                if (handler != null) {
                                    handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.HardDecoder$startPlay$$inlined$apply$lambda$1
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            try {
                                                HardDecoder hardDecoder = this;
                                                MediaExtractor mediaExtractor = (MediaExtractor) objectRef.element;
                                                MediaCodec mediaCodec = createDecoderByType;
                                                Intrinsics.checkExpressionValueIsNotNull(mediaCodec, "this");
                                                hardDecoder.startDecode(mediaExtractor, mediaCodec);
                                            } catch (Throwable th) {
                                                ALog.INSTANCE.e("AnimPlayer.HardDecoder", "MediaCodec exception e=" + th, th);
                                                this.onFailed(10002, "0x2 MediaCodec exception e=" + th);
                                                this.release((MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
                                            }
                                        }
                                    });
                                }
                                objectRef2.element = createDecoderByType;
                                return;
                            } catch (Throwable th) {
                                ALog.INSTANCE.e(TAG, "MediaCodec configure exception e=" + th, th);
                                onFailed(10002, "0x2 MediaCodec exception e=" + th);
                                release((MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
                                return;
                            }
                        }
                        throw new RuntimeException("render create fail");
                    } catch (Throwable th2) {
                        onFailed(10004, "0x4 render create fail e=" + th2);
                        release(null, null);
                        return;
                    }
                }
                throw new RuntimeException("format is null");
            }
            throw new RuntimeException("No video track found");
        } catch (Throwable th3) {
            ALog.INSTANCE.e(TAG, "MediaExtractor exception e=" + th3, th3);
            onFailed(Constant.REPORT_ERROR_TYPE_EXTRACTOR_EXC, "0x1 MediaExtractor exception e=" + th3);
            release((MediaCodec) objectRef2.element, (MediaExtractor) objectRef.element);
        }
    }

    private final byte[] yuv420spTop(byte[] yuv420sp) {
        byte[] bArr = new byte[yuv420sp.length];
        int i = this.alignWidth;
        int i2 = this.alignHeight;
        int i3 = i * i2;
        System.arraycopy(yuv420sp, 0, bArr, 0, i * i2);
        int i4 = i3;
        int i5 = i4;
        while (i4 < (i3 * 3) / 2) {
            bArr[i5] = yuv420sp[i4];
            bArr[(i3 / 4) + i5] = yuv420sp[i4 + 1];
            i4 += 2;
            i5++;
        }
        return bArr;
    }

    private final void yuvCopy(byte[] src, int srcOffset, int inWidth, int inHeight, byte[] dest, int outWidth, int outHeight) {
        for (int i = 0; i < inHeight; i++) {
            if (i < outHeight) {
                System.arraycopy(src, (i * inWidth) + srcOffset, dest, i * outWidth, outWidth);
            }
        }
    }

    private final void yuvProcess(MediaCodec decoder, int outputIndex) {
        ByteBuffer byteBuffer = decoder.getOutputBuffers()[outputIndex];
        if (byteBuffer != null) {
            boolean z = false;
            byteBuffer.position(0);
            byteBuffer.limit(getBufferInfo().offset + getBufferInfo().size);
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr);
            if (remaining == 0) {
                z = true;
            }
            if (!z) {
                int i = this.videoWidth;
                int i2 = this.videoHeight;
                byte[] bArr2 = new byte[i * i2];
                byte[] bArr3 = new byte[(i * i2) / 4];
                byte[] bArr4 = new byte[(i * i2) / 4];
                MediaFormat mediaFormat = this.outputFormat;
                if (mediaFormat != null && mediaFormat.getInteger("color-format") == 21) {
                    bArr = yuv420spTop(bArr);
                }
                yuvCopy(bArr, 0, this.alignWidth, this.alignHeight, bArr2, this.videoWidth, this.videoHeight);
                int i3 = this.alignWidth;
                int i4 = this.alignHeight;
                yuvCopy(bArr, i3 * i4, i3 / 2, i4 / 2, bArr3, this.videoWidth / 2, this.videoHeight / 2);
                int i5 = this.alignWidth;
                int i6 = this.alignHeight;
                yuvCopy(bArr, ((i5 * i6) * 5) / 4, i5 / 2, i6 / 2, bArr4, this.videoWidth / 2, this.videoHeight / 2);
                IRenderListener render = getRender();
                if (render != null) {
                    render.setYUVData(this.videoWidth, this.videoHeight, bArr2, bArr3, bArr4);
                }
                renderData();
            }
        }
    }

    @Override // com.tencent.qgame.animplayer.Decoder
    public void destroy() {
        if (getIsRunning()) {
            this.needDestroy = true;
            stop();
        } else {
            destroyInner();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(@Nullable SurfaceTexture surfaceTexture) {
        if (getIsStopReq()) {
            return;
        }
        ALog.INSTANCE.d(TAG, "onFrameAvailable");
        renderData();
    }

    @Override // com.tencent.qgame.animplayer.Decoder
    public void start(@NotNull final IFileContainer fileContainer) {
        setStopReq(false);
        this.needDestroy = false;
        setRunning(true);
        Handler handler = getRenderThread().getHandler();
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.qgame.animplayer.HardDecoder$start$1
                @Override // java.lang.Runnable
                public final void run() {
                    HardDecoder.this.startPlay(fileContainer);
                }
            });
        }
    }
}
