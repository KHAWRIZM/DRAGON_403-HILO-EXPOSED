package com.tencent.liteav.videoconsumer2;

import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.util.Range;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.common.MediaCodecAbility;
import com.tencent.liteav.videobase.utils.d;
import com.tencent.liteav.videoconsumer.a.a;
import com.tencent.qgame.animplayer.util.MediaUtil;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HardwareVideoDecoder2 implements SurfaceTexture.OnFrameAvailableListener {
    private static final int DRAIN_ERROR = -1;
    private static final int DRAIN_SUCCESS = 0;
    private static final int DRAIN_SUCCESS_MEET_END_OF_STREAM = 1;
    private static final int INVALID_COLOR_FORMAT = 0;
    private Surface mExternalSurface;
    private int mHeight;
    private boolean mIsHevc;
    private boolean mIsRealTime;
    private boolean mIsStarted;
    private long mNativeVideoDecoderImplAndroid;
    private Surface mOutputSurface;
    private SurfaceTexture mSurfaceTexture;
    private final String mTAG;
    private boolean mUseAsyncMode;
    private boolean mUseByteBuffer;
    private boolean mUseSoftwareDecoder;
    private int mWidth;
    private final com.tencent.liteav.base.b.b mThrottlers = new com.tencent.liteav.base.b.b();
    private MediaCodec mMediaCodec = null;
    private final Queue<Integer> mInputBufferQueue = new LinkedList();
    private final Queue<Pair<Integer, MediaCodec.BufferInfo>> mOutputBufferQueue = new LinkedList();
    private boolean mEnableLimitMaxDecFrameBufferingInH264Sps = true;
    private final com.tencent.liteav.videoconsumer.a.a mSPSModifier = new com.tencent.liteav.videoconsumer.a.a();
    private long mLastPresentationTimeUs = 0;

    HardwareVideoDecoder2(String str, boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, long j) {
        this.mUseSoftwareDecoder = false;
        this.mUseByteBuffer = false;
        this.mUseAsyncMode = false;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mIsHevc = false;
        this.mTAG = str + "HardwareVideoDecoder2";
        this.mIsRealTime = z;
        this.mUseSoftwareDecoder = z3;
        this.mUseByteBuffer = z4;
        this.mUseAsyncMode = z5;
        this.mNativeVideoDecoderImplAndroid = j;
        this.mWidth = i;
        this.mHeight = i2;
        this.mIsHevc = z2;
    }

    private boolean configureDecoder(MediaCodec mediaCodec, MediaFormat mediaFormat, Surface surface) {
        try {
            mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, 0);
            mediaCodec.setVideoScalingMode(1);
            mediaCodec.start();
            LiteavLog.i(this.mTAG, "Start MediaCodec(%s) success.", mediaCodec.getName());
            return true;
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "Configure MediaCodec failed: ", th);
            return false;
        }
    }

    private void destroyMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                try {
                    LiteavLog.i(this.mTAG, "mediaCodec stop");
                    mediaCodec.stop();
                    LiteavLog.i(this.mTAG, "mediaCodec release");
                    mediaCodec.release();
                } catch (Throwable th) {
                    try {
                        LiteavLog.e(this.mTAG, "Stop MediaCodec failed." + th.getMessage());
                        LiteavLog.i(this.mTAG, "mediaCodec release");
                        mediaCodec.release();
                    } catch (Throwable th2) {
                        try {
                            LiteavLog.i(this.mTAG, "mediaCodec release");
                            mediaCodec.release();
                        } catch (Throwable th3) {
                            LiteavLog.e(this.mTAG, "release MediaCodec failed.", th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                LiteavLog.e(this.mTAG, "release MediaCodec failed.", th4);
            }
        }
    }

    private int drainDecodedFrameAsyncMode() {
        int i;
        if (this.mOutputBufferQueue.isEmpty()) {
            return -1;
        }
        Pair<Integer, MediaCodec.BufferInfo> poll = this.mOutputBufferQueue.poll();
        int intValue = ((Integer) poll.first).intValue();
        MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) poll.second;
        this.mLastPresentationTimeUs = bufferInfo.presentationTimeUs;
        if ((bufferInfo.flags & 4) != 0) {
            LiteavLog.i(this.mTAG, "meet end of stream.");
            this.mMediaCodec.releaseOutputBuffer(intValue, true);
            return 1;
        }
        if (this.mUseByteBuffer) {
            i = handleOutputBuffer(intValue, bufferInfo);
        } else {
            i = 0;
        }
        this.mMediaCodec.releaseOutputBuffer(intValue, true);
        if (this.mExternalSurface != null) {
            long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
            long j = this.mNativeVideoDecoderImplAndroid;
            if (j != 0) {
                nativeOnDecodedFrameWithSurface(j, millis);
            }
        }
        return i;
    }

    private int drainDecodedFrameSyncMode() {
        MediaCodec.BufferInfo bufferInfo;
        int dequeueOutputBuffer;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= 3 || (dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer((bufferInfo = new MediaCodec.BufferInfo()), TimeUnit.MILLISECONDS.toMicros(10L))) == -1) {
                return -1;
            }
            if (dequeueOutputBuffer == -3) {
                LiteavLog.i(this.mTAG, "on output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                outputFormatChange();
            } else {
                if (dequeueOutputBuffer >= 0) {
                    this.mLastPresentationTimeUs = bufferInfo.presentationTimeUs;
                    if ((bufferInfo.flags & 4) != 0) {
                        LiteavLog.i(this.mTAG, "meet end of stream.");
                        this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                        return 1;
                    }
                    if (this.mUseByteBuffer) {
                        i = handleOutputBuffer(dequeueOutputBuffer, bufferInfo);
                    }
                    this.mMediaCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
                    if (this.mExternalSurface != null) {
                        long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                        long j = this.mNativeVideoDecoderImplAndroid;
                        if (j != 0) {
                            nativeOnDecodedFrameWithSurface(j, millis);
                        }
                    }
                    return i;
                }
                LiteavLog.d(this.mTAG, "dequeueOutputBuffer get invalid index: %d", Integer.valueOf(dequeueOutputBuffer));
            }
            i2++;
        }
    }

    private boolean feedDataToMediaCodec(EncodedVideoFrame encodedVideoFrame) {
        ByteBuffer byteBuffer;
        int i;
        ByteBuffer byteBuffer2;
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        }
        if (encodedVideoFrame != null && (encodedVideoFrame.isEosFrame || ((byteBuffer2 = encodedVideoFrame.data) != null && byteBuffer2.remaining() != 0))) {
            if (this.mUseAsyncMode) {
                if (this.mInputBufferQueue.isEmpty()) {
                    return false;
                }
                int intValue = this.mInputBufferQueue.poll().intValue();
                byteBuffer = this.mMediaCodec.getInputBuffer(intValue);
                i = intValue;
            } else {
                ByteBuffer[] inputBuffers = this.mMediaCodec.getInputBuffers();
                if (inputBuffers != null && inputBuffers.length != 0) {
                    int dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(10000L);
                    if (dequeueInputBuffer < 0) {
                        return false;
                    }
                    byteBuffer = inputBuffers[dequeueInputBuffer];
                    i = dequeueInputBuffer;
                } else {
                    LiteavLog.e(this.mTAG, "get invalid input buffers.");
                    return false;
                }
            }
            if (!encodedVideoFrame.isEosFrame) {
                limitMaxDecFrameBufferingInH264Sps(encodedVideoFrame);
                int remaining = encodedVideoFrame.data.remaining();
                byteBuffer.put(encodedVideoFrame.data);
                this.mMediaCodec.queueInputBuffer(i, 0, remaining, TimeUnit.MILLISECONDS.toMicros(encodedVideoFrame.pts), 0);
            } else {
                LiteavLog.i(this.mTAG, "feedDataToMediaCodec BUFFER_FLAG_END_OF_STREAM");
                this.mMediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
            }
            return true;
        }
        LiteavLog.w(this.mTAG, "receive empty buffer.");
        return true;
    }

    private byte[] getSpsData(byte[] bArr, int[] iArr) {
        int i = 0;
        while (true) {
            if (i + 4 >= bArr.length || (i = EncodedVideoFrame.getNextNALHeaderPos(i, ByteBuffer.wrap(bArr))) < 0) {
                break;
            }
            if ((bArr[i] & 31) == 7) {
                iArr[0] = i;
                break;
            }
        }
        int i2 = iArr[0];
        if (i2 < 0) {
            return null;
        }
        int length = bArr.length - i2;
        while (true) {
            int i3 = i2 + 3;
            if (i3 >= bArr.length) {
                break;
            }
            byte b = bArr[i2];
            if ((b != 0 || bArr[i2 + 1] != 0 || bArr[i2 + 2] != 1) && (b != 0 || bArr[i2 + 1] != 0 || bArr[i2 + 2] != 0 || bArr[i3] != 1)) {
                i2++;
            }
        }
        length = i2 - iArr[0];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, iArr[0], bArr2, 0, length);
        return bArr2;
    }

    private int getSupportedByteBufferColorFormat(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        boolean z = false;
        boolean z2 = false;
        for (int i : codecCapabilities.colorFormats) {
            if (i == 19) {
                z = true;
            } else if (i == 21) {
                z2 = true;
            }
        }
        if (z) {
            return 19;
        }
        if (z2) {
            return 21;
        }
        LiteavLog.e(this.mTAG, "I420/NV12 not found, formats: " + Arrays.toString(codecCapabilities.colorFormats));
        return 0;
    }

    private void handleDecoderError(int i) {
        long j = this.mNativeVideoDecoderImplAndroid;
        if (j != 0) {
            nativeOnDecodedFrameFailed(j, i);
        }
    }

    private int handleOutputBuffer(int i, MediaCodec.BufferInfo bufferInfo) {
        int value;
        int i2;
        int i3;
        int i4;
        synchronized (this) {
            try {
                ByteBuffer outputBuffer = this.mMediaCodec.getOutputBuffer(i);
                outputBuffer.position(bufferInfo.offset);
                outputBuffer.limit(bufferInfo.offset + bufferInfo.size);
                outputBuffer.rewind();
                MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
                int integer = outputFormat.getInteger("color-format");
                if (integer == 19) {
                    value = GLConstants.PixelFormatType.I420.getValue();
                } else if (integer == 21) {
                    value = GLConstants.PixelFormatType.NV12.getValue();
                } else {
                    LiteavLog.e(this.mTAG, "Unsupported color format:".concat(String.valueOf(integer)));
                    handleDecoderError(6);
                    return -1;
                }
                int i5 = value;
                int integer2 = outputFormat.getInteger("width");
                int integer3 = outputFormat.getInteger("height");
                if (outputFormat.containsKey("crop-right") && outputFormat.containsKey("crop-left")) {
                    i2 = Math.abs(outputFormat.getInteger("crop-right") - outputFormat.getInteger("crop-left")) + 1;
                } else {
                    i2 = integer2;
                }
                if (outputFormat.containsKey("crop-bottom") && outputFormat.containsKey("crop-top")) {
                    i3 = Math.abs(outputFormat.getInteger("crop-bottom") - outputFormat.getInteger("crop-top")) + 1;
                } else {
                    i3 = integer3;
                }
                if (outputFormat.containsKey("stride")) {
                    integer2 = outputFormat.getInteger("stride");
                }
                int i6 = integer2;
                if (outputFormat.containsKey("slice-height")) {
                    i4 = outputFormat.getInteger("slice-height");
                } else {
                    i4 = integer3;
                }
                long millis = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
                long j = this.mNativeVideoDecoderImplAndroid;
                if (j != 0) {
                    nativeOnByteBuffer(j, i5, outputBuffer, bufferInfo.size, i2, i3, i6, i4, millis);
                }
                return 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean initializeSurface(int i) {
        synchronized (this) {
            try {
                this.mSurfaceTexture = new SurfaceTexture(i);
                this.mOutputSurface = new Surface(this.mSurfaceTexture);
                this.mSurfaceTexture.setOnFrameAvailableListener(this);
            } catch (Surface.OutOfResourcesException e) {
                LiteavLog.e(this.mTAG, "Initialize surface failed: ", e);
                return false;
            }
        }
        LiteavLog.i(this.mTAG, "Initialize surface ok.");
        return true;
    }

    private boolean isResolutionSupported(MediaCodecInfo.CodecCapabilities codecCapabilities, int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21 || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return true;
        }
        Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
        Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
        if (supportedWidths == null || supportedHeights == null) {
            return true;
        }
        if (i >= supportedWidths.getLower().intValue() && i2 >= supportedHeights.getLower().intValue()) {
            if (i > supportedWidths.getUpper().intValue() || i2 > supportedHeights.getUpper().intValue()) {
                LiteavLog.w(this.mTAG, "Resolution %dx%d above range: %sx%s", Integer.valueOf(i), Integer.valueOf(i2), supportedWidths.toString(), supportedHeights.toString());
            }
            return true;
        }
        LiteavLog.e(this.mTAG, "Resolution %dx%d below range: %sx%s", Integer.valueOf(i), Integer.valueOf(i2), supportedWidths.toString(), supportedHeights.toString());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$limitMaxDecFrameBufferingInH264Sps$0(HardwareVideoDecoder2 hardwareVideoDecoder2, int i, int i2, int i3, int i4) {
        LiteavLog.e(hardwareVideoDecoder2.mTAG, "frame cropping flag exist, crop[l:" + i + ",r:" + i2 + ",t:" + i3 + ",b:" + i4 + "]");
        hardwareVideoDecoder2.mEnableLimitMaxDecFrameBufferingInH264Sps = false;
        long j = hardwareVideoDecoder2.mNativeVideoDecoderImplAndroid;
        if (j != 0) {
            hardwareVideoDecoder2.nativeOnFrameFlagCropExist(j, i, i2, i3, i4);
        }
        return false;
    }

    private void limitMaxDecFrameBufferingInH264Sps(EncodedVideoFrame encodedVideoFrame) {
        byte[] a;
        byte[] bArr;
        ByteBuffer b;
        byte[] bArr2;
        boolean z;
        byte b2;
        if (!encodedVideoFrame.isIDRFrame() || encodedVideoFrame.codecType != CodecType.H264 || !this.mEnableLimitMaxDecFrameBufferingInH264Sps || !this.mIsRealTime || (a = d.a(encodedVideoFrame.data.remaining())) == null) {
            return;
        }
        encodedVideoFrame.data.get(a);
        encodedVideoFrame.data.rewind();
        int[] iArr = {-1};
        byte[] spsData = getSpsData(a, iArr);
        if (spsData != null && iArr[0] >= 0) {
            try {
                com.tencent.liteav.videoconsumer.a.a aVar = this.mSPSModifier;
                a.InterfaceC٠٠١٧a r8 = new a.InterfaceC٠٠١٧a(this) { // from class: com.tencent.liteav.videoconsumer2.a
                    private final HardwareVideoDecoder2 a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = this;
                    }

                    @Override // com.tencent.liteav.videoconsumer.a.a.InterfaceC٠٠١٧a
                    public final boolean a(int i, int i2, int i3, int i4) {
                        return HardwareVideoDecoder2.lambda$limitMaxDecFrameBufferingInH264Sps$0(this.a, i, i2, i3, i4);
                    }
                };
                byte[] bArr3 = new byte[spsData.length];
                int i = 0;
                int i2 = 0;
                while (i < spsData.length) {
                    if (i < spsData.length - 3 && (b2 = spsData[i]) == 0) {
                        int i3 = i + 1;
                        if (spsData[i3] == 0 && spsData[i + 2] == 3) {
                            int i4 = i + 3;
                            if (spsData[i4] <= 3) {
                                int i5 = i2 + 1;
                                bArr3[i2] = b2;
                                i2 += 2;
                                bArr3[i5] = spsData[i3];
                                i = i4;
                            }
                        }
                    }
                    bArr3[i2] = spsData[i];
                    i++;
                    i2++;
                }
                if (i2 != spsData.length) {
                    bArr2 = new byte[i2];
                    System.arraycopy(bArr3, 0, bArr2, 0, i2);
                } else {
                    bArr2 = null;
                }
                if (bArr2 != null) {
                    z = true;
                } else {
                    bArr2 = spsData;
                    z = false;
                }
                byte[] a2 = aVar.a(new ByteArrayInputStream(bArr2), r8);
                if (a2 != null && z) {
                    a2 = com.tencent.liteav.videoconsumer.a.a.a(a2);
                }
                bArr = a2;
            } catch (Throwable th) {
                LiteavLog.e(this.mTAG, "modify dec buffer error ", th);
                bArr = null;
            }
            if (bArr == null || (b = d.b((a.length - spsData.length) + bArr.length)) == null) {
                return;
            }
            encodedVideoFrame.data = b;
            int i6 = iArr[0];
            if (i6 > 0) {
                b.put(a, 0, i6);
            }
            encodedVideoFrame.data.put(bArr);
            ByteBuffer byteBuffer = encodedVideoFrame.data;
            int i7 = iArr[0];
            byteBuffer.put(a, spsData.length + i7, (a.length - i7) - spsData.length);
            encodedVideoFrame.data.rewind();
        }
    }

    private native void nativeOnByteBuffer(long j, int i, ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, int i6, long j2);

    private native void nativeOnDecodedFrameFailed(long j, int i);

    private native void nativeOnDecodedFrameWithSurface(long j, long j2);

    private native void nativeOnFrameAvailable(long j, long j2);

    private native void nativeOnFrameFlagCropExist(long j, int i, int i2, int i3, int i4);

    private native void nativeOnInputBufferAvailable(long j);

    private native void nativeOnOutputBufferAvailable(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public void onMediaCodecError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        if (mediaCodec != this.mMediaCodec) {
            LiteavLog.w(this.mTAG, "onMediaCodecOutputBufferAvailable: MediaCodec changed.");
            return;
        }
        LiteavLog.e(this.mTAG, "onMediaCodecError: " + codecException.toString());
        handleDecoderError(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMediaCodecInputBufferAvailable(MediaCodec mediaCodec, int i) {
        if (mediaCodec != this.mMediaCodec) {
            LiteavLog.w(this.mTAG, "onMediaCodecInputBufferAvailable: MediaCodec changed.");
            return;
        }
        this.mInputBufferQueue.offer(Integer.valueOf(i));
        long j = this.mNativeVideoDecoderImplAndroid;
        if (j != 0) {
            nativeOnInputBufferAvailable(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMediaCodecOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        if (mediaCodec != this.mMediaCodec) {
            LiteavLog.w(this.mTAG, "onMediaCodecOutputBufferAvailable: MediaCodec changed.");
            return;
        }
        this.mOutputBufferQueue.offer(new Pair<>(Integer.valueOf(i), bufferInfo));
        long j = this.mNativeVideoDecoderImplAndroid;
        if (j != 0) {
            nativeOnOutputBufferAvailable(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMediaCodecOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        if (mediaCodec != this.mMediaCodec) {
            LiteavLog.w(this.mTAG, "onMediaCodecOutputFormatChanged: MediaCodec changed.");
        } else {
            LiteavLog.i(this.mTAG, "onMediaCodecOutputFormatChanged: ".concat(String.valueOf(mediaFormat)));
        }
    }

    private void outputFormatChange() {
        LiteavLog.i(this.mTAG, "decode output format changed: ".concat(String.valueOf(this.mMediaCodec.getOutputFormat())));
    }

    private void setCallback(MediaCodec mediaCodec) {
        MediaCodec.Callback callback = new MediaCodec.Callback() { // from class: com.tencent.liteav.videoconsumer2.HardwareVideoDecoder2.1
            @Override // android.media.MediaCodec.Callback
            public final void onError(MediaCodec mediaCodec2, MediaCodec.CodecException codecException) {
                HardwareVideoDecoder2.this.onMediaCodecError(mediaCodec2, codecException);
            }

            @Override // android.media.MediaCodec.Callback
            public final void onInputBufferAvailable(MediaCodec mediaCodec2, int i) {
                HardwareVideoDecoder2.this.onMediaCodecInputBufferAvailable(mediaCodec2, i);
            }

            @Override // android.media.MediaCodec.Callback
            public final void onOutputBufferAvailable(MediaCodec mediaCodec2, int i, MediaCodec.BufferInfo bufferInfo) {
                HardwareVideoDecoder2.this.onMediaCodecOutputBufferAvailable(mediaCodec2, i, bufferInfo);
            }

            @Override // android.media.MediaCodec.Callback
            public final void onOutputFormatChanged(MediaCodec mediaCodec2, MediaFormat mediaFormat) {
                HardwareVideoDecoder2.this.onMediaCodecOutputFormatChanged(mediaCodec2, mediaFormat);
            }
        };
        if (LiteavSystemInfo.getSystemOSVersionInt() >= 23) {
            mediaCodec.setCallback(callback, new Handler(Looper.myLooper()));
        } else {
            mediaCodec.setCallback(callback);
        }
    }

    private int startInternal() {
        String str;
        Surface surface;
        int i;
        try {
            if (this.mIsHevc) {
                str = MediaUtil.MIME_HEVC;
            } else {
                str = "video/avc";
            }
            MediaCodec createMediaCodecInternal = createMediaCodecInternal(this.mUseSoftwareDecoder, str);
            this.mMediaCodec = createMediaCodecInternal;
            MediaCodecInfo.CodecCapabilities capabilitiesForType = createMediaCodecInternal.getCodecInfo().getCapabilitiesForType(str);
            int i2 = this.mWidth;
            if (i2 > 0 && (i = this.mHeight) > 0 && !isResolutionSupported(capabilitiesForType, i2, i)) {
                return 18;
            }
            com.tencent.liteav.videobase.utils.b bVar = new com.tencent.liteav.videobase.utils.b();
            bVar.c = str;
            bVar.a = this.mWidth;
            bVar.b = this.mHeight;
            bVar.e = capabilitiesForType;
            bVar.d = this.mIsRealTime;
            MediaFormat a = bVar.a();
            if (this.mUseByteBuffer) {
                int supportedByteBufferColorFormat = getSupportedByteBufferColorFormat(capabilitiesForType);
                if (supportedByteBufferColorFormat == 0) {
                    return 6;
                }
                a.setInteger("color-format", supportedByteBufferColorFormat);
            }
            if (this.mUseAsyncMode) {
                setCallback(this.mMediaCodec);
            }
            LiteavLog.i(this.mTAG, "Start with media format: ".concat(String.valueOf(a)));
            if (this.mUseByteBuffer) {
                surface = null;
            } else {
                surface = this.mExternalSurface;
                if (surface == null) {
                    surface = this.mOutputSurface;
                }
            }
            if (!configureDecoder(this.mMediaCodec, a, surface)) {
                return 1;
            }
            this.mIsStarted = true;
            return 0;
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "Start MediaCodec failed: ", th);
            return 1;
        }
    }

    private void uninitializeSurface() {
        LiteavLog.i(this.mTAG, "Uninitialize surface");
        synchronized (this) {
            try {
                Surface surface = this.mOutputSurface;
                if (surface != null) {
                    surface.release();
                    this.mOutputSurface = null;
                }
                SurfaceTexture surfaceTexture = this.mSurfaceTexture;
                if (surfaceTexture != null) {
                    surfaceTexture.release();
                    this.mSurfaceTexture = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public MediaCodec createMediaCodecInternal(boolean z, String str) throws IOException {
        if (!z) {
            return MediaCodec.createDecoderByType(str);
        }
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
            if (!mediaCodecInfo.isEncoder()) {
                for (String str2 : supportedTypes) {
                    if (str2.contains(str) && MediaCodecAbility.isSoftOnlyDecoder(mediaCodecInfo)) {
                        LiteavLog.i(this.mTAG, "Use soft only decoder:%s", mediaCodecInfo.getName());
                        return MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    }
                }
            }
        }
        return MediaCodec.createDecoderByType(str);
    }

    public boolean decodeFrame(EncodedVideoFrame encodedVideoFrame) {
        if (this.mMediaCodec == null) {
            LiteavLog.w(this.mTAG, "MediaCodec is stopped.");
            return false;
        }
        if (encodedVideoFrame == null) {
            return true;
        }
        try {
            if (!feedDataToMediaCodec(encodedVideoFrame)) {
                encodedVideoFrame.release();
                return false;
            }
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "Feed data failed: ", th);
            handleDecoderError(4);
        }
        encodedVideoFrame.release();
        return true;
    }

    public int drainDecodedFrame() {
        try {
            if (this.mUseAsyncMode) {
                return drainDecodedFrameAsyncMode();
            }
            return drainDecodedFrameSyncMode();
        } catch (Throwable th) {
            LiteavLog.e(this.mTAG, "Drain frame failed: ", th);
            handleDecoderError(4);
            return -1;
        }
    }

    public int getValidInputBufferCount() {
        return this.mInputBufferQueue.size();
    }

    public int getValidOutputBufferCount() {
        return this.mOutputBufferQueue.size();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
            if (surfaceTexture2 != null && surfaceTexture2 == surfaceTexture) {
                long millis = TimeUnit.MICROSECONDS.toMillis(this.mLastPresentationTimeUs);
                long j = this.mNativeVideoDecoderImplAndroid;
                if (j != 0) {
                    nativeOnFrameAvailable(j, millis);
                }
            }
        }
    }

    public void resetNativeHandle() {
        this.mNativeVideoDecoderImplAndroid = 0L;
    }

    public void setEnableVui(boolean z) {
        this.mEnableLimitMaxDecFrameBufferingInH264Sps = z;
    }

    public int start(int i) {
        if (this.mIsStarted) {
            return 0;
        }
        LiteavLog.i(this.mTAG, "Start: texture_id = %d", Integer.valueOf(i));
        if (!this.mUseByteBuffer && !initializeSurface(i)) {
            return 16;
        }
        int start = start();
        if (start != 0) {
            uninitializeSurface();
        }
        return start;
    }

    public void stop() {
        LiteavLog.i(this.mTAG, "stop");
        if (!this.mIsStarted) {
            return;
        }
        destroyMediaCodec(this.mMediaCodec);
        this.mMediaCodec = null;
        uninitializeSurface();
        this.mIsStarted = false;
        this.mExternalSurface = null;
    }

    public float[] updateTexImage() {
        SurfaceTexture surfaceTexture = this.mSurfaceTexture;
        if (surfaceTexture == null) {
            return null;
        }
        try {
            float[] fArr = new float[16];
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(fArr);
            return fArr;
        } catch (Throwable th) {
            LiteavLog.w(this.mThrottlers.a("updateImage"), this.mTAG, "updateTexImage exception: ".concat(String.valueOf(th)), new Object[0]);
            return null;
        }
    }

    public int start(Surface surface) {
        if (this.mIsStarted) {
            return 0;
        }
        LiteavLog.i(this.mTAG, "Start with surface ".concat(String.valueOf(surface)));
        if (surface == null) {
            return 17;
        }
        this.mExternalSurface = surface;
        return start();
    }

    private int start() {
        int startInternal = startInternal();
        if (startInternal != 0 && this.mIsRealTime) {
            destroyMediaCodec(this.mMediaCodec);
            this.mMediaCodec = null;
            this.mIsRealTime = false;
            startInternal = startInternal();
        }
        if (startInternal != 0) {
            destroyMediaCodec(this.mMediaCodec);
            this.mMediaCodec = null;
        }
        return startInternal;
    }
}
