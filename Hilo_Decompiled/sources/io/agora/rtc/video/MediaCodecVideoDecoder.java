package io.agora.rtc.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.view.Surface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tencent.liteav.videoconsumer2.b;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.SurfaceTextureHelper;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class MediaCodecVideoDecoder extends MediaCodecBase {
    private static final int DEQUEUE_INPUT_TIMEOUT = 100000;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String H265_MIME_TYPE = "video/hevc";
    private static final long MAX_DECODE_TIME_MS = 2000;
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MAX_TEXTURE_BUFFER_COUNT = 16;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final boolean VERBOSE = false;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static MediaCodecVideoDecoderErrorCallback errorCallback;
    private static MediaCodecVideoDecoder runningInstance;
    private HandlerThread asyncHandlerThread;
    private String codecName;
    private int colorFormat;
    private int cropHeight;
    private int cropWidth;
    private int droppedFrames;
    private boolean hasDecodedFirstFrame;
    private int height;
    ByteBuffer[] inputBuffers;
    private boolean isOMXHisi;
    private MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private long nativeHandle;
    ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private int supportCodecs;
    private SurfaceTextureHelper surfaceTextureHelper;
    private TextureListener textureListener;
    private boolean useSurface;
    private int width;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static final String[] supportedVp8HwCodecPrefixes = {"OMX.qcom.", "OMX.Nvidia.", "OMX.Exynos.", "OMX.Intel."};
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos."};
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.rk.", "OMX.sprd.", "OMX.amlogic.", "OMX.IMG.TOPAZ.", "OMX.IMG.MSVDX.", "OMX.hisi.", "OMX.k3.", "OMX.allwinner.", "OMX.MTK.", "OMX.Nvidia.", "OMX.Intel.", "OMX.MS.", "OMX.NVT."};
    private static final String[] supportedH265HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.rk.", "OMX.sprd.", "OMX.amlogic.", "OMX.IMG.TOPAZ.", "OMX.IMG.MSVDX.", "OMX.hisi.", "OMX.k3.", "OMX.allwinner.", "OMX.MTK.", "OMX.Nvidia.", "OMX.Intel.", "OMX.MS.", "OMX.google."};
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final List<Integer> supportedColorList = Arrays.asList(19, 21, 2141391872, Integer.valueOf(COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m));
    private static final List<Integer> supportedColorListAddOn = Arrays.asList(2135033992);
    private static AtomicInteger currentInstances = new AtomicInteger(0);
    private static boolean preferGoogleSoftwareDecoder = false;
    private boolean useAsyncMode = false;
    private MediaCodecDecoderCallback decoderCallback = null;
    private int supportInstances = 1;
    private final Queue<TimeStamps> decodeStartTimeMsQueue = new ConcurrentLinkedQueue();
    private Surface surface = null;
    private final Queue<DecodedOutputBuffer> dequeuedSurfaceOutputBuffers = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class DecodedOutputBuffer {
        public final ByteBuffer buffer;
        private final long bufferedFrames;
        private final long decodeTimeMs;
        private final long endDecodeTimeMs;
        private final int imageFormat;
        private final int index;
        private final long ntpTimeStampMs;
        private final int offset;
        private final long presentationTimeStampMs;
        private final int size;
        private final long timeStamp;

        public DecodedOutputBuffer(int i10, ByteBuffer byteBuffer, int i11, int i12, int i13, long j10, long j11, long j12, long j13, long j14, long j15) {
            this.index = i10;
            this.offset = i11;
            this.size = i12;
            this.buffer = byteBuffer;
            this.imageFormat = i13;
            this.presentationTimeStampMs = j10;
            this.timeStamp = j11;
            this.ntpTimeStampMs = j12;
            this.decodeTimeMs = j13;
            this.endDecodeTimeMs = j14;
            this.bufferedFrames = j15;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class DecodedTextureBuffer {
        private final long bufferedFrames;
        private final long decodeTimeMs;
        private final long frameDelayMs;
        private final long ntpTimeStampMs;
        private final long presentationTimeStampMs;
        VideoFrame.TextureBuffer textureBuffer;
        private final long timeStamp;
        private final float[] transformMatrix;

        public DecodedTextureBuffer(float[] fArr, long j10, long j11, long j12, long j13, long j14, VideoFrame.TextureBuffer textureBuffer, long j15) {
            this.transformMatrix = fArr;
            this.presentationTimeStampMs = j10;
            this.timeStamp = j11;
            this.ntpTimeStampMs = j12;
            this.decodeTimeMs = j13;
            this.frameDelayMs = j14;
            this.textureBuffer = textureBuffer;
            this.bufferedFrames = j15;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i10) {
            this.codecName = str;
            this.colorFormat = i10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class InputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;

        public InputBufferInfo(int i10, ByteBuffer byteBuffer) {
            this.index = i10;
            this.buffer = byteBuffer;
        }
    }

    @TargetApi(21)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class MediaCodecDecoderCallback extends MediaCodec.Callback implements TextureListener.DecodedTextureBufferCallback {
        boolean isObsolete = false;
        final LinkedHashSet<Integer> availableInputIndexes = new LinkedHashSet<>();

        MediaCodecDecoderCallback() {
        }

        @Override // io.agora.rtc.video.MediaCodecVideoDecoder.TextureListener.DecodedTextureBufferCallback
        public void onDecodedTextureBufferAvailable(DecodedTextureBuffer decodedTextureBuffer) {
            MediaCodecVideoDecoder.this.MaybeRenderDecodedTextureBuffer();
            MediaCodecVideoDecoder mediaCodecVideoDecoder = MediaCodecVideoDecoder.this;
            mediaCodecVideoDecoder.deliverOutputTextureReady(decodedTextureBuffer, mediaCodecVideoDecoder.nativeHandle);
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            Logging.e(MediaCodecVideoDecoder.TAG, "onError " + codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
            synchronized (this.availableInputIndexes) {
                this.availableInputIndexes.add(Integer.valueOf(i10));
                this.availableInputIndexes.notifyAll();
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
            synchronized (this) {
                try {
                    if (!this.isObsolete) {
                        int bufferColorFormat = MediaCodecVideoDecoder.this.getBufferColorFormat(i10);
                        if (MediaCodecVideoDecoder.this.useSurface) {
                            DecodedOutputBuffer handleOutputBufferAvailable = MediaCodecVideoDecoder.this.handleOutputBufferAvailable(i10, null, bufferInfo, bufferColorFormat);
                            if (handleOutputBufferAvailable == null) {
                                MediaCodecVideoDecoder.this.mediaCodec.releaseOutputBuffer(i10, false);
                            } else {
                                MediaCodecVideoDecoder.this.dequeuedSurfaceOutputBuffers.offer(handleOutputBufferAvailable);
                                MediaCodecVideoDecoder.this.MaybeRenderDecodedTextureBuffer();
                            }
                        } else {
                            try {
                                ByteBuffer outputBuffer = MediaCodecVideoDecoder.this.mediaCodec.getOutputBuffer(i10);
                                if (outputBuffer != null) {
                                    DecodedOutputBuffer handleOutputBufferAvailable2 = MediaCodecVideoDecoder.this.handleOutputBufferAvailable(i10, outputBuffer, bufferInfo, bufferColorFormat);
                                    if (handleOutputBufferAvailable2 != null) {
                                        MediaCodecVideoDecoder mediaCodecVideoDecoder = MediaCodecVideoDecoder.this;
                                        mediaCodecVideoDecoder.deliverOutputYuvReady(handleOutputBufferAvailable2, mediaCodecVideoDecoder.nativeHandle);
                                    }
                                    MediaCodecVideoDecoder.this.mediaCodec.releaseOutputBuffer(i10, false);
                                } else {
                                    Logging.e(MediaCodecVideoDecoder.TAG, "failed to get output buffer, index: " + i10);
                                    return;
                                }
                            } catch (IllegalStateException e10) {
                                Logging.e(MediaCodecVideoDecoder.TAG, "getOutputBuffer exception, index: " + i10, e10);
                                return;
                            }
                        }
                        return;
                    }
                    Logging.w(MediaCodecVideoDecoder.TAG, "discarding output as this callback is obsolete.");
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            Logging.w(MediaCodecVideoDecoder.TAG, "onOutputFormatChanged " + mediaFormat);
            MediaCodecVideoDecoder.this.handleOutputFormatChanged(mediaFormat);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class TextureListener implements SurfaceTextureHelper.OnTextureFrameAvailableListener {
        private final Queue<DecodedOutputBuffer> decodedOutputBuffers;
        private final DecodedTextureBufferCallback decodedTextureBufferCallback;
        private final Queue<DecodedTextureBuffer> decodedTextureBuffers;
        private int height;
        private final Object newFrameLock = new Object();
        private final SurfaceTextureHelper surfaceTextureHelper;
        private int width;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        private interface DecodedTextureBufferCallback {
            void onDecodedTextureBufferAvailable(DecodedTextureBuffer decodedTextureBuffer);
        }

        public TextureListener(SurfaceTextureHelper surfaceTextureHelper, DecodedTextureBufferCallback decodedTextureBufferCallback) {
            LinkedList linkedList = new LinkedList();
            this.decodedOutputBuffers = linkedList;
            this.decodedTextureBuffers = new LinkedList();
            this.surfaceTextureHelper = surfaceTextureHelper;
            surfaceTextureHelper.startListening(this);
            linkedList.clear();
            this.decodedTextureBufferCallback = decodedTextureBufferCallback;
        }

        public void addBufferToRender(DecodedOutputBuffer decodedOutputBuffer) {
            synchronized (this.newFrameLock) {
                this.decodedOutputBuffers.offer(decodedOutputBuffer);
            }
        }

        public DecodedTextureBuffer dequeueTextureBuffer() {
            DecodedTextureBuffer poll;
            synchronized (this.newFrameLock) {
                if (this.decodedTextureBuffers.isEmpty() && !this.decodedOutputBuffers.isEmpty()) {
                    try {
                        this.newFrameLock.wait(6);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                poll = this.decodedTextureBuffers.poll();
            }
            return poll;
        }

        public boolean isWaitingForTexture() {
            return false;
        }

        @Override // io.agora.rtc.gl.SurfaceTextureHelper.OnTextureFrameAvailableListener
        public void onTextureFrameAvailable(int i10, float[] fArr, long j10) {
            synchronized (this.newFrameLock) {
                try {
                    DecodedOutputBuffer poll = this.decodedOutputBuffers.poll();
                    if (poll == null) {
                        Logging.d(MediaCodecVideoDecoder.TAG, "texture_dec:null output buffer.");
                        return;
                    }
                    VideoFrame.TextureBuffer createTextureBuffer = this.surfaceTextureHelper.createTextureBuffer(this.width, this.height, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr));
                    VideoFrame.TextureBuffer textureCopy = this.surfaceTextureHelper.textureCopy(createTextureBuffer);
                    createTextureBuffer.release();
                    DecodedTextureBuffer decodedTextureBuffer = new DecodedTextureBuffer(fArr, poll.presentationTimeStampMs, poll.timeStamp, poll.ntpTimeStampMs, poll.decodeTimeMs, SystemClock.elapsedRealtime() - poll.endDecodeTimeMs, textureCopy, poll.bufferedFrames);
                    DecodedTextureBufferCallback decodedTextureBufferCallback = this.decodedTextureBufferCallback;
                    if (decodedTextureBufferCallback != null) {
                        decodedTextureBufferCallback.onDecodedTextureBufferAvailable(decodedTextureBuffer);
                    } else {
                        this.decodedTextureBuffers.offer(decodedTextureBuffer);
                        this.newFrameLock.notifyAll();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void release() {
            this.surfaceTextureHelper.stopListening();
            synchronized (this.newFrameLock) {
                try {
                    this.surfaceTextureHelper.returnTextureFrame();
                    this.decodedOutputBuffers.clear();
                    Iterator<DecodedTextureBuffer> it = this.decodedTextureBuffers.iterator();
                    while (it.hasNext()) {
                        VideoFrame.TextureBuffer textureBuffer = it.next().textureBuffer;
                        if (textureBuffer != null) {
                            textureBuffer.release();
                        }
                    }
                    this.decodedTextureBuffers.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void updateResolution(int i10, int i11) {
            this.width = i10;
            this.height = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class TimeStamps {
        private final long decodeStartTimeMs;
        private final long ntpTimeStamp;
        private final long timeStamp;

        public TimeStamps(long j10, long j11, long j12) {
            this.decodeStartTimeMs = j10;
            this.timeStamp = j11;
            this.ntpTimeStamp = j12;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264,
        VIDEO_CODEC_H265
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void MaybeRenderDecodedTextureBuffer() {
        DecodedOutputBuffer poll;
        if (this.textureListener.isWaitingForTexture() || (poll = this.dequeuedSurfaceOutputBuffers.poll()) == null) {
            return;
        }
        this.textureListener.addBufferToRender(poll);
        this.textureListener.updateResolution(this.cropWidth, this.cropHeight);
        this.mediaCodec.releaseOutputBuffer(poll.index, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void deliverOutputTextureReady(DecodedTextureBuffer decodedTextureBuffer, long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public native void deliverOutputYuvReady(DecodedOutputBuffer decodedOutputBuffer, long j10);

    private int dequeueInputBuffer() {
        try {
            return this.mediaCodec.dequeueInputBuffer(100000L);
        } catch (IllegalStateException e10) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e10);
            return -2;
        }
    }

    @TargetApi(21)
    private InputBufferInfo dequeueInputBufferAvailable() {
        InputBufferInfo inputBufferInfo;
        synchronized (this.decoderCallback.availableInputIndexes) {
            if (this.decoderCallback.availableInputIndexes.isEmpty()) {
                try {
                    this.decoderCallback.availableInputIndexes.wait(100000L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            Iterator<Integer> it = this.decoderCallback.availableInputIndexes.iterator();
            if (!it.hasNext()) {
                Logging.e(TAG, "no input buffer available");
                inputBufferInfo = new InputBufferInfo(-1, null);
            } else {
                int intValue = it.next().intValue();
                it.remove();
                try {
                    inputBufferInfo = new InputBufferInfo(intValue, this.mediaCodec.getInputBuffer(intValue));
                } catch (IllegalStateException e11) {
                    Logging.e(TAG, "failed to get input buffer for index " + intValue + " : " + e11);
                    inputBufferInfo = new InputBufferInfo(-2, null);
                }
            }
        }
        return inputBufferInfo;
    }

    private DecodedOutputBuffer dequeueOutputBuffer(int i10) {
        if (this.decodeStartTimeMsQueue.isEmpty()) {
            return null;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i10));
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer == -1) {
                        return null;
                    }
                    return handleOutputBufferAvailable(dequeueOutputBuffer, this.outputBuffers[dequeueOutputBuffer], bufferInfo, getBufferColorFormat(dequeueOutputBuffer));
                }
                handleOutputFormatChanged(this.mediaCodec.getOutputFormat());
            } else {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                Logging.i(TAG, "Decoder output buffers changed: " + this.outputBuffers.length);
                if (this.hasDecodedFirstFrame) {
                    throw new RuntimeException("Unexpected output buffer change event.");
                }
            }
        }
    }

    private DecodedTextureBuffer dequeueTextureBuffer(int i10) {
        if (this.useSurface) {
            DecodedOutputBuffer dequeueOutputBuffer = dequeueOutputBuffer(i10);
            if (dequeueOutputBuffer != null) {
                this.dequeuedSurfaceOutputBuffers.offer(dequeueOutputBuffer);
            }
            MaybeRenderDecodedTextureBuffer();
            DecodedTextureBuffer dequeueTextureBuffer = this.textureListener.dequeueTextureBuffer();
            if (dequeueTextureBuffer != null) {
                MaybeRenderDecodedTextureBuffer();
                return dequeueTextureBuffer;
            }
            if (this.dequeuedSurfaceOutputBuffers.size() >= Math.min(3, this.outputBuffers.length)) {
                this.droppedFrames++;
                DecodedOutputBuffer poll = this.dequeuedSurfaceOutputBuffers.poll();
                this.mediaCodec.releaseOutputBuffer(poll.index, false);
                return new DecodedTextureBuffer(null, poll.presentationTimeStampMs, poll.timeStamp, poll.ntpTimeStampMs, poll.decodeTimeMs, SystemClock.elapsedRealtime() - poll.endDecodeTimeMs, null, poll.bufferedFrames);
            }
            return null;
        }
        throw new IllegalStateException("dequeueTexture() called for byte buffer decoding.");
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(H264_MIME_TYPE);
    }

    public static void disableH265HwCodec() {
        Logging.w(TAG, "H.265 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(H265_MIME_TYPE);
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 decoding is disabled by application.");
        hwDecoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0088 A[LOOP:2: B:22:0x0086->B:23:0x0088, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static DecoderProperties findDecoder(String str, String[] strArr) {
        MediaCodecInfo mediaCodecInfo;
        Logging.i(TAG, "Trying to find HW decoder for mime " + str);
        int i10 = 0;
        while (true) {
            String str2 = null;
            if (i10 < MediaCodecList.getCodecCount()) {
                try {
                    mediaCodecInfo = MediaCodecList.getCodecInfoAt(i10);
                } catch (IllegalArgumentException e10) {
                    Logging.e(TAG, "Cannot retrieve decoder codec info", e10);
                    mediaCodecInfo = null;
                }
                if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        if (supportedTypes[i11].equals(str)) {
                            str2 = mediaCodecInfo.getName();
                            break;
                        }
                        i11++;
                    }
                    if (str2 == null) {
                        continue;
                    } else {
                        Logging.i(TAG, "Found candidate decoder: " + str2);
                        if (preferGoogleSoftwareDecoder) {
                            if (!str2.startsWith("OMX.google.")) {
                                continue;
                            }
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            for (int i12 : capabilitiesForType.colorFormats) {
                                Logging.d(TAG, "   Color: 0x" + Integer.toHexString(i12));
                            }
                            if (!str2.startsWith("OMX.rk.")) {
                                return new DecoderProperties(str2, 21);
                            }
                            Iterator<Integer> it = supportedColorList.iterator();
                            while (it.hasNext()) {
                                int intValue = it.next().intValue();
                                for (int i13 : capabilitiesForType.colorFormats) {
                                    if (i13 == intValue) {
                                        Logging.i(TAG, "Found target decoder " + str2 + ". Color: 0x" + Integer.toHexString(i13));
                                        return new DecoderProperties(str2, i13);
                                    }
                                }
                            }
                            Iterator<Integer> it2 = supportedColorListAddOn.iterator();
                            while (it2.hasNext()) {
                                int intValue2 = it2.next().intValue();
                                for (int i14 : capabilitiesForType.colorFormats) {
                                    if (i14 == intValue2) {
                                        Logging.d(TAG, "Found target decoder " + str2 + ". Color: 0x" + Integer.toHexString(i14));
                                        return new DecoderProperties(str2, i14);
                                    }
                                }
                            }
                        } else {
                            for (String str3 : strArr) {
                                if (str2.startsWith(str3)) {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType(str);
                                    while (r7 < r6) {
                                    }
                                    if (!str2.startsWith("OMX.rk.")) {
                                    }
                                }
                            }
                        }
                    }
                }
                i10++;
            } else {
                Logging.i(TAG, "No HW decoder found for mime " + str);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBufferColorFormat(int i10) {
        if (i10 < 0 || this.colorFormat != 2135033992) {
            return 0;
        }
        int integer = this.mediaCodec.getOutputFormat(i10).getInteger("color-format");
        if (this.isOMXHisi && integer == 47) {
            return 17;
        }
        return integer;
    }

    private void getDecoderProperties(int i10) {
        MediaCodecInfo mediaCodecInfo;
        int maxSupportedInstances;
        String[] strArr = {VP8_MIME_TYPE, VP9_MIME_TYPE, H264_MIME_TYPE, H265_MIME_TYPE};
        this.supportCodecs = 0;
        String str = null;
        for (int i11 = 0; i11 < MediaCodecList.getCodecCount(); i11++) {
            try {
                mediaCodecInfo = MediaCodecList.getCodecInfoAt(i11);
            } catch (IllegalArgumentException e10) {
                Logging.e(TAG, "Cannot retrieve decoder codec info", e10);
                mediaCodecInfo = null;
            }
            if (mediaCodecInfo != null && !mediaCodecInfo.isEncoder()) {
                for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                    if (str2.equals(VP8_MIME_TYPE)) {
                        this.supportCodecs |= 1;
                    } else if (str2.equals(H264_MIME_TYPE)) {
                        this.supportCodecs |= 2;
                    } else if (str2.equals(H265_MIME_TYPE)) {
                        this.supportCodecs |= 4;
                    }
                    if (str == null && str2.equals(strArr[i10])) {
                        str = mediaCodecInfo.getName();
                        this.codecName = str;
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(strArr[i10]);
                        if (Build.VERSION.SDK_INT >= 23) {
                            maxSupportedInstances = capabilitiesForType.getMaxSupportedInstances();
                            this.supportInstances = maxSupportedInstances;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DecodedOutputBuffer handleOutputBufferAvailable(int i10, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i11) {
        long j10;
        TimeStamps poll = this.decodeStartTimeMsQueue.poll();
        if (poll == null) {
            Logging.e(TAG, "decodeStartTimeMs empty, dropping decoded output");
            return null;
        }
        this.hasDecodedFirstFrame = true;
        long elapsedRealtime = SystemClock.elapsedRealtime() - poll.decodeStartTimeMs;
        if (elapsedRealtime > MAX_DECODE_TIME_MS) {
            Logging.w(TAG, "Very high decode time: " + elapsedRealtime + "ms.");
            j10 = 2000L;
        } else {
            j10 = elapsedRealtime;
        }
        return new DecodedOutputBuffer(i10, byteBuffer, bufferInfo.offset, bufferInfo.size, i11, TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs), poll.timeStamp, poll.ntpTimeStamp, j10, SystemClock.elapsedRealtime(), this.decodeStartTimeMsQueue.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOutputFormatChanged(MediaFormat mediaFormat) {
        Logging.i(TAG, "Decoder format changed: " + mediaFormat.toString());
        int integer = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int integer2 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (this.hasDecodedFirstFrame && (integer != this.width || integer2 != this.height)) {
            Logging.w(TAG, "Decoder format changed. Configured " + this.width + "*" + this.height + ". New " + integer + "*" + integer2);
        }
        this.width = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.height = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (mediaFormat.containsKey("stride")) {
            this.stride = mediaFormat.getInteger("stride");
        }
        if (mediaFormat.containsKey("slice-height")) {
            this.sliceHeight = mediaFormat.getInteger("slice-height");
        }
        if (mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-right")) {
            this.cropWidth = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            this.cropWidth = this.width;
        }
        if (mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            this.cropHeight = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            this.cropHeight = this.height;
        }
        Logging.i(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
        Logging.i(TAG, "Crop width and height: " + this.cropWidth + " x " + this.cropHeight);
        this.stride = Math.max(this.width, this.stride);
        this.sliceHeight = Math.max(this.height, this.sliceHeight);
    }

    @SuppressLint({"NewApi"})
    private boolean initDecode(int i10, int i11, int i12, SurfaceTextureHelper surfaceTextureHelper, boolean z10, Looper looper, long j10, boolean z11, EglBase.Context context, String str) {
        String[] strArr;
        String str2;
        Looper looper2;
        String str3;
        if (this.mediaCodecThread == null) {
            if (currentInstances.get() >= this.supportInstances) {
                return false;
            }
            currentInstances.incrementAndGet();
            if (z11) {
                if (surfaceTextureHelper == null) {
                    this.surfaceTextureHelper = SurfaceTextureHelper.create("ahwdectex", context, 16);
                } else {
                    this.surfaceTextureHelper = surfaceTextureHelper;
                }
                if (this.surfaceTextureHelper == null) {
                    Logging.e(TAG, "failed to init decoder for surface output");
                    return false;
                }
            }
            this.useSurface = z11;
            VideoCodecType videoCodecType = VideoCodecType.values()[i10];
            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                strArr = supportedVp8HwCodecPrefixes;
                str2 = VP8_MIME_TYPE;
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                strArr = supportedVp9HwCodecPrefixes;
                str2 = VP9_MIME_TYPE;
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                strArr = supportedH264HwCodecPrefixes;
                str2 = H264_MIME_TYPE;
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H265) {
                strArr = supportedH265HwCodecPrefixes;
                str2 = H265_MIME_TYPE;
            } else {
                throw new RuntimeException("initDecode: Non-supported codec " + videoCodecType);
            }
            DecoderProperties findDecoder = findDecoder(str2, strArr);
            if (findDecoder != null) {
                Logging.i(TAG, "Java initDecode: " + videoCodecType + " : " + i11 + " x " + i12 + ". Color: 0x" + Integer.toHexString(findDecoder.colorFormat) + ". Use Surface: " + z11 + ". Use async mode: " + z10 + ". nativeHandle: " + j10);
                runningInstance = this;
                this.mediaCodecThread = Thread.currentThread();
                try {
                    this.width = i11;
                    this.height = i12;
                    this.stride = i11;
                    this.sliceHeight = i12;
                    this.cropWidth = i11;
                    this.cropHeight = i12;
                    String str4 = findDecoder.codecName;
                    if (str4 != null && (str3 = Build.HARDWARE) != null && str4.startsWith("OMX.hisi.") && str3.startsWith("bigfish")) {
                        this.isOMXHisi = true;
                        Logging.d(TAG, " bigfish isOMXHisi: " + this.isOMXHisi);
                    } else {
                        this.isOMXHisi = false;
                    }
                    MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str2, i11, i12);
                    if (!z11) {
                        createVideoFormat.setInteger("color-format", findDecoder.colorFormat);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        applyCustomConfig(createVideoFormat, new String(Base64.decode(str, 0)));
                    }
                    Logging.d(TAG, "Format: " + createVideoFormat);
                    MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(findDecoder.codecName);
                    this.mediaCodec = createByCodecName;
                    if (createByCodecName == null) {
                        Logging.e(TAG, "Can not create media decoder");
                        return false;
                    }
                    this.nativeHandle = j10;
                    this.useAsyncMode = z10;
                    if (z10) {
                        this.decoderCallback = new MediaCodecDecoderCallback();
                        if (looper == null) {
                            HandlerThread handlerThread = new HandlerThread("decoderAsyncHandler");
                            this.asyncHandlerThread = handlerThread;
                            handlerThread.start();
                            looper2 = this.asyncHandlerThread.getLooper();
                        } else {
                            looper2 = looper;
                        }
                        b.a(this.mediaCodec, this.decoderCallback, new Handler(looper2));
                    }
                    if (z11) {
                        this.textureListener = new TextureListener(this.surfaceTextureHelper, this.decoderCallback);
                        this.surface = new Surface(this.surfaceTextureHelper.getSurfaceTexture());
                    }
                    this.mediaCodec.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
                    this.mediaCodec.start();
                    Logging.d(TAG, "MediaCodec started");
                    this.colorFormat = findDecoder.colorFormat;
                    if (!z10) {
                        this.outputBuffers = this.mediaCodec.getOutputBuffers();
                        this.inputBuffers = this.mediaCodec.getInputBuffers();
                        Logging.i(TAG, "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
                    }
                    this.decodeStartTimeMsQueue.clear();
                    this.hasDecodedFirstFrame = false;
                    this.dequeuedSurfaceOutputBuffers.clear();
                    this.droppedFrames = 0;
                    return true;
                } catch (IllegalStateException e10) {
                    Logging.e(TAG, "initDecode failed", e10);
                    return false;
                }
            }
            throw new RuntimeException("Cannot find HW decoder for " + videoCodecType);
        }
        throw new RuntimeException("initDecode: Forgot to release()?");
    }

    public static boolean isAsyncModeSupported() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public static boolean isH264HwSupported() {
        if (!hwDecoderDisabledTypes.contains(H264_MIME_TYPE) && findDecoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes) != null) {
            return true;
        }
        return false;
    }

    public static boolean isH265HwSupported() {
        if (!hwDecoderDisabledTypes.contains(H265_MIME_TYPE) && findDecoder(H265_MIME_TYPE, supportedH265HwCodecPrefixes) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp8HwSupported() {
        if (!hwDecoderDisabledTypes.contains(VP8_MIME_TYPE) && findDecoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp9HwSupported() {
        if (!hwDecoderDisabledTypes.contains(VP9_MIME_TYPE) && findDecoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes) != null) {
            return true;
        }
        return false;
    }

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder != null && (thread = mediaCodecVideoDecoder.mediaCodecThread) != null) {
            StackTraceElement[] stackTrace = thread.getStackTrace();
            if (stackTrace.length > 0) {
                Logging.d(TAG, "MediaCodecVideoDecoder stacks trace:");
                for (StackTraceElement stackTraceElement : stackTrace) {
                    Logging.d(TAG, stackTraceElement.toString());
                }
            }
        }
    }

    private boolean queueInputBuffer(int i10, int i11, long j10, long j11, long j12) {
        try {
            this.decodeStartTimeMsQueue.add(new TimeStamps(SystemClock.elapsedRealtime(), j11, j12));
            if (!this.useAsyncMode) {
                this.inputBuffers[i10].position(0);
                this.inputBuffers[i10].limit(i11);
            }
            this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
            return true;
        } catch (IllegalStateException e10) {
            Logging.e(TAG, "decode failed", e10);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    private void release() {
        Logging.i(TAG, "Java releaseDecoder. Total number of dropped frames: " + this.droppedFrames);
        if (this.useAsyncMode) {
            HandlerThread handlerThread = this.asyncHandlerThread;
            if (handlerThread != null) {
                handlerThread.quit();
                this.asyncHandlerThread = null;
            }
            synchronized (this.decoderCallback) {
                this.decoderCallback.isObsolete = true;
            }
            this.decoderCallback = null;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final MediaCodec mediaCodec = this.mediaCodec;
        new Thread(new Runnable() { // from class: io.agora.rtc.video.MediaCodecVideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Logging.i(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                    mediaCodec.stop();
                    mediaCodec.release();
                    Logging.i(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                } catch (Exception e10) {
                    Logging.e(MediaCodecVideoDecoder.TAG, "Media decoder release failed", e10);
                }
                countDownLatch.countDown();
            }
        }).start();
        if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
            Logging.e(TAG, "Media decoder release timeout");
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
            }
        }
        this.mediaCodec = null;
        this.mediaCodecThread = null;
        runningInstance = null;
        currentInstances.decrementAndGet();
        if (this.useSurface) {
            this.surface.release();
            this.surface = null;
            this.textureListener.release();
            this.surfaceTextureHelper.dispose();
            this.surfaceTextureHelper = null;
        }
        Logging.d(TAG, "Java releaseDecoder done");
    }

    private void reset(int i10, int i11) {
        if (this.mediaCodecThread != null && this.mediaCodec != null) {
            Logging.i(TAG, "Java reset: " + i10 + " x " + i11);
            if (this.useAsyncMode) {
                this.mediaCodec.flush();
                synchronized (this.decoderCallback.availableInputIndexes) {
                    this.decoderCallback.availableInputIndexes.clear();
                }
                this.mediaCodec.start();
                Logging.d(TAG, "MediaCodec restarted");
            } else {
                this.mediaCodec.flush();
            }
            this.width = i10;
            this.height = i11;
            this.decodeStartTimeMsQueue.clear();
            this.dequeuedSurfaceOutputBuffers.clear();
            this.hasDecodedFirstFrame = false;
            this.droppedFrames = 0;
            return;
        }
        throw new RuntimeException("Incorrect reset call for non-initialized decoder.");
    }

    private void returnDecodedOutputBuffer(int i10) throws IllegalStateException, MediaCodec.CodecException {
        if (!this.useSurface) {
            this.mediaCodec.releaseOutputBuffer(i10, false);
            return;
        }
        throw new IllegalStateException("returnDecodedOutputBuffer() called for surface decoding.");
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }
}
