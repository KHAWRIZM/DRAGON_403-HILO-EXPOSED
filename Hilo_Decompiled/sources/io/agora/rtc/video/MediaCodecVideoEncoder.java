package io.agora.rtc.video;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Range;
import android.view.Surface;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.liulishuo.okdownload.DownloadTask;
import com.tencent.liteav.videoconsumer2.b;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.EglBase10;
import io.agora.rtc.gl.EglBase14;
import io.agora.rtc.gl.GlRectDrawer;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.ATrace;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGLContext;

@TargetApi(19)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class MediaCodecVideoEncoder extends MediaCodecBase {
    private static final int BASE_FRAME_RATE_FOR_AMLOGIC = 30;
    private static final int BASE_FRAME_RATE_FOR_EXYNOS = 30;
    private static final int BASE_FRAME_RATE_FOR_HIS_HISI = 30;
    private static final int BASE_FRAME_RATE_FOR_HIS_K3 = 30;
    private static final int BASE_FRAME_RATE_FOR_HIS_TOPAZ = 30;
    private static final int BASE_FRAME_RATE_FOR_MTK = 30;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String H265_MIME_TYPE = "video/hevc";
    private static final int INT_INTERVAL_UPPER_LIMIT = 100;
    private static final int INT_SETTING_INTERVAL_VALUE = 10;
    private static final int KBPS_TO_BPS_FACTOR = 900;
    private static final int KBPS_TO_BPS_FACTOR_QCOM = 950;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 3000;
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final boolean VERBOSE = false;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final int VIDEO_ControlRateVariable = 1;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static MediaCodecVideoEncoderErrorCallback errorCallback;
    private int SDKVer;
    private MediaCodecEncoderCallback asyncEncoderCallback;
    private int bitrateAdjustmentType;
    private String codecName;
    private int colorFormat;
    private int converted_bps;
    private String cpuModel;
    private HandlerThread dedicatedHandlerThread;
    private String deviceModel;
    private GlRectDrawer drawer;
    private EglBase eglBase;
    private int height;
    private Surface inputSurface;
    private int lastSetFps;
    private MediaCodec mediaCodec;
    private long nativeHandle;

    @Deprecated
    private ByteBuffer[] outputBuffers;
    private int outputFrameRotation;
    private VideoCodecType type;
    private int width;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static String codecOmxName = null;
    private static final String[] supportedVp8HwCodecPrefixes = {"OMX.qcom.", "OMX.Intel."};
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom."};
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.IMG.TOPAZ.", "OMX.hisi.", "OMX.k3.", "OMX.amlogic.", "OMX.rk.", "OMX.MS."};
    private static final String[] supportedH265HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.IMG.TOPAZ.", "OMX.hisi.", "OMX.k3.", "OMX.amlogic.", "OMX.rk."};
    private static final String[] H264_HW_EXCEPTION_MODELS = {"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "P6-C00", "HM 2A", "XT105", "XT109", "XT1060"};
    private static final String[] H264_HW_QCOM_EXCEPTION_MODELS = {"mi note lte", "redmi note 4x", "1605-a01", "aosp on hammerhead", "lm-x210", "oppo r9s"};
    private static final String[] MTK_NO_ADJUSTMENT_MODELS = {"vivo y83a", "vivo x21i", "vivo X21i A"};
    private static final String[] INTERVAL_HW_EXCEPTION_MODELS = {"vivo X21A", "MI 8", "MI 6", "MI 8 Lite", "Redmi Note 7"};
    private static final String[] H265_HW_EXCEPTION_MODELS = new String[0];
    private static final String[] H265_HW_EXCEPTION_HARDWARES = {"mt6771", "mt6762"};
    private static final String[] ASYNC_EXCLUDED_MODELS = {"SM-G7810"};
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int[] supportedColorList = {19, 21, 2141391872, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m};
    private static final int[] supportedSurfaceColorList = {2130708361};
    private static int mH264SupportProfileHigh = 0;
    private final Matrix rotateMatrix = new Matrix();
    private boolean useAsyncMode = false;
    private Handler dedicatedHandler = null;
    private boolean isInitialized = false;
    private final Object callbackLock = new Object();
    private final LinkedHashSet<Integer> availableInputIndexes = new LinkedHashSet<>();
    private ByteBuffer configData = null;
    private long lastKeyFrameTimeMs = 0;
    private int keyFrameIntervalInMsec = 0;
    private boolean hasPendingKeyFrame = false;
    private int keyFrameEncodeMinInterval = 100;
    private long lastResetForQcomTimeMs = 0;
    private boolean qcomExceptionModel = false;
    private int profile = 66;
    private int supportCodecs = 0;
    private int maxSupportedWidth = 32768;
    private int maxSupportedHeight = 32768;
    private int minSupportedWidth = 2;
    private int minSupportedHeight = 2;
    private int maxSupportedBitrate = 0;
    private int minSupportedBitrate = 0;
    private int widthAlignment = 16;
    private int heightAlignment = 4;
    private int memoryType = 0;
    private int bitrateMode = 2;
    private boolean eglAttachedOnDedicatedThread = false;
    private int settingMaxWidth = -1;
    private int settingMaxHeight = -1;
    private int settingMaxFPS = -1;
    private int settingHighProfile = -1;
    private int settingBitrateMode = -1;
    private int settingBitrateAdjustmentType = -1;
    private int settingBitrateBaseFPS = -1;
    private int settingBitrateFactor = -1;
    private int settingAdjustmentReset = -1;
    private String settingInitConfs = null;
    private String settingAdjustmentConfs = null;
    private int settingCodecParameterForExynos = -1;
    private ChipProperties chipProperties = null;
    private FileOutputStream fos = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.agora.rtc.video.MediaCodecVideoEncoder$1CaughtException, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class C1CaughtException {

        /* renamed from: e, reason: collision with root package name */
        Exception f١٤٩٥٤e;

        C1CaughtException() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        ACTUAL_FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class ChipProperties {
        public int baseFrameRate;
        public BitrateAdjustmentType bitrateAdjustmentType;
        public String chipName;
        public int highProfileMinSdkVersion;
        public int initFrameRate;
        public boolean isNeedResetWhenDownBps;

        ChipProperties(String str, BitrateAdjustmentType bitrateAdjustmentType, boolean z10, int i10, int i11, int i12) {
            this.chipName = str;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
            this.isNeedResetWhenDownBps = z10;
            this.baseFrameRate = i10;
            this.initFrameRate = i11;
            this.highProfileMinSdkVersion = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class EncoderProperties {
        public final String codecName;
        public final int colorFormat;
        public final boolean supportedList;

        public EncoderProperties(String str, int i10, boolean z10) {
            this.codecName = str;
            this.colorFormat = i10;
            this.supportedList = z10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class InitParameters {
        int bitrateKbps;
        int codec;
        String customConfigJson;
        boolean fallbackToBaselineProfile;
        int fps;
        int height;
        int init_fps;
        int keyInterval;
        int profile;
        EGLContext sharedEgl10Context;
        android.opengl.EGLContext sharedEgl14Context;
        boolean useAsyncMode;
        boolean useSurface;
        int width;

        public InitParameters(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z10, boolean z11, boolean z12, android.opengl.EGLContext eGLContext, EGLContext eGLContext2, String str) {
            this.codec = i10;
            this.width = i11;
            this.height = i12;
            this.bitrateKbps = i13;
            this.fps = i14;
            this.init_fps = i15;
            this.keyInterval = i16;
            this.fallbackToBaselineProfile = z10;
            this.profile = i17;
            this.useAsyncMode = z11;
            this.useSurface = z12;
            this.sharedEgl14Context = eGLContext;
            this.sharedEgl10Context = eGLContext2;
            if (!TextUtils.isEmpty(str)) {
                this.customConfigJson = new String(Base64.decode(str, 0));
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(VideoCodecType.values()[this.codec]);
            sb.append(" : " + this.width + " x " + this.height);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" @ ");
            sb2.append(this.bitrateKbps);
            sb2.append(" Kbps,");
            sb.append(sb2.toString());
            sb.append(" Fps: ");
            sb.append(this.fps + ",");
            sb.append(" Key interval: " + this.keyInterval + "s,");
            sb.append(" Encode from texture : " + this.useSurface + ",");
            sb.append(" Async mode: " + this.useAsyncMode + InstructionFileId.DOT);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" Shared ctx: ");
            Object obj = this.sharedEgl14Context;
            if (obj == null) {
                obj = this.sharedEgl10Context;
            }
            sb3.append(obj);
            sb3.append(InstructionFileId.DOT);
            sb.append(sb3.toString());
            sb.append(" Custom config: " + this.customConfigJson);
            return sb.toString();
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

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(21)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public class MediaCodecEncoderCallback extends MediaCodec.Callback {
        boolean stale;

        private MediaCodecEncoderCallback() {
            this.stale = false;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            Logging.e(MediaCodecVideoEncoder.TAG, "onError " + codecException);
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
            MediaCodecVideoEncoder.this.verboseLog("onInputBufferAvailable " + i10);
            synchronized (MediaCodecVideoEncoder.this.callbackLock) {
                try {
                    if (this.stale) {
                        Logging.w(MediaCodecVideoEncoder.TAG, "discard stale available input buffer");
                    } else {
                        MediaCodecVideoEncoder.this.availableInputIndexes.add(Integer.valueOf(i10));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
            MediaCodecVideoEncoder.this.verboseLog("onOutputBufferAvailable: " + i10);
            synchronized (MediaCodecVideoEncoder.this.callbackLock) {
                if (this.stale) {
                    Logging.w(MediaCodecVideoEncoder.TAG, "discard stale available output buffer");
                    return;
                }
                try {
                    ByteBuffer outputBuffer = MediaCodecVideoEncoder.this.mediaCodec.getOutputBuffer(i10);
                    if (outputBuffer == null) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "failed to get output buffer, index: " + i10);
                        return;
                    }
                    try {
                        if ((bufferInfo.flags & 2) != 0) {
                            Logging.d(MediaCodecVideoEncoder.TAG, "[async] Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                            MediaCodecVideoEncoder.this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                            MediaCodecVideoEncoder.this.configData.put(outputBuffer);
                        } else {
                            OutputBufferInfo createOutputBufferInfo = MediaCodecVideoEncoder.this.createOutputBufferInfo(bufferInfo, i10, outputBuffer);
                            MediaCodecVideoEncoder mediaCodecVideoEncoder = MediaCodecVideoEncoder.this;
                            mediaCodecVideoEncoder.onAsyncEncodeFrameResult(mediaCodecVideoEncoder.nativeHandle, true, createOutputBufferInfo);
                        }
                    } catch (Exception e10) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "handle output buffer error", e10);
                    }
                    MediaCodecVideoEncoder.this.verboseLog("releaseOutputBuffer: " + i10);
                    MediaCodecVideoEncoder.this.mediaCodec.releaseOutputBuffer(i10, false);
                    return;
                } catch (IllegalStateException e11) {
                    Logging.e(MediaCodecVideoEncoder.TAG, "getOutputBuffer exception, index: " + i10, e11);
                    return;
                }
            }
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            Logging.w(MediaCodecVideoEncoder.TAG, "onOutputFormatChanged " + mediaFormat);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class OutputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;
        public final int size;

        public OutputBufferInfo(int i10, ByteBuffer byteBuffer, boolean z10, long j10, int i11) {
            this.index = i10;
            this.buffer = byteBuffer;
            this.isKeyFrame = z10;
            this.presentationTimestampUs = j10;
            this.size = i11;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum VideoCodecType {
        VIDEO_CODEC_VP8,
        VIDEO_CODEC_VP9,
        VIDEO_CODEC_H264,
        VIDEO_CODEC_H265
    }

    private static boolean checkMinSDKVersion(String str, boolean z10) {
        if (z10 || str.startsWith("OMX.qcom.") || str.startsWith("OMX.MTK.") || str.startsWith("OMX.Exynos.") || str.startsWith("OMX.IMG.TOPAZ.")) {
            return true;
        }
        str.startsWith("OMX.k3.");
        return true;
    }

    private int convertBitRate(int i10, int i11) {
        ChipProperties chipProperties = this.chipProperties;
        if (chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT) {
            i10 = (i10 * chipProperties.baseFrameRate) / i11;
        }
        int i12 = this.settingBitrateFactor;
        if (i12 <= 0) {
            if (!chipProperties.chipName.startsWith("OMX.rk.") && this.type != VideoCodecType.VIDEO_CODEC_H265) {
                if (this.chipProperties.chipName.startsWith("OMX.qcom.")) {
                    i12 = KBPS_TO_BPS_FACTOR_QCOM;
                } else {
                    i12 = 900;
                }
            } else {
                i12 = 1000;
            }
        }
        return i12 * i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception e10) {
            Logging.e(TAG, "create media encoder failed, ", e10);
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    private boolean createEncoder(InitParameters initParameters) throws RuntimeException {
        EncoderProperties encoderProperties;
        String str;
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        String str2 = TAG;
        Logging.i(str2, "Java initEncode: " + initParameters.toString());
        int i10 = initParameters.width;
        this.width = i10;
        int i11 = initParameters.height;
        this.height = i11;
        if (i10 >= this.minSupportedWidth && i11 >= this.minSupportedHeight) {
            if (initParameters.fps < 1) {
                initParameters.fps = 1;
            }
            if (initParameters.keyInterval < 1) {
                initParameters.keyInterval = 1;
            }
            this.lastSetFps = initParameters.fps;
            this.keyFrameIntervalInMsec = initParameters.keyInterval * 1000;
            this.lastKeyFrameTimeMs = 0L;
            this.lastResetForQcomTimeMs = SystemClock.elapsedRealtime();
            VideoCodecType videoCodecType = VideoCodecType.values()[initParameters.codec];
            this.type = videoCodecType;
            if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP8) {
                String[] strArr = supportedVp8HwCodecPrefixes;
                if (initParameters.useSurface) {
                    iArr4 = supportedSurfaceColorList;
                } else {
                    iArr4 = supportedColorList;
                }
                str = VP8_MIME_TYPE;
                encoderProperties = findHwEncoder(VP8_MIME_TYPE, strArr, iArr4);
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_VP9) {
                String[] strArr2 = supportedH264HwCodecPrefixes;
                if (initParameters.useSurface) {
                    iArr3 = supportedSurfaceColorList;
                } else {
                    iArr3 = supportedColorList;
                }
                str = VP9_MIME_TYPE;
                encoderProperties = findHwEncoder(VP9_MIME_TYPE, strArr2, iArr3);
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                String[] strArr3 = supportedH264HwCodecPrefixes;
                if (initParameters.useSurface) {
                    iArr2 = supportedSurfaceColorList;
                } else {
                    iArr2 = supportedColorList;
                }
                str = H264_MIME_TYPE;
                encoderProperties = findHwEncoder(H264_MIME_TYPE, strArr3, iArr2);
            } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H265) {
                String[] strArr4 = supportedH265HwCodecPrefixes;
                if (initParameters.useSurface) {
                    iArr = supportedSurfaceColorList;
                } else {
                    iArr = supportedColorList;
                }
                str = H265_MIME_TYPE;
                encoderProperties = findHwEncoder(H265_MIME_TYPE, strArr4, iArr);
            } else {
                encoderProperties = null;
                str = null;
            }
            if (encoderProperties != null) {
                ChipProperties chipProperties = getChipProperties(encoderProperties.codecName, initParameters.fps);
                this.chipProperties = chipProperties;
                if (this.settingBitrateAdjustmentType > 0) {
                    chipProperties.bitrateAdjustmentType = BitrateAdjustmentType.values()[this.settingBitrateAdjustmentType];
                }
                int i12 = this.settingBitrateBaseFPS;
                if (i12 > 0) {
                    ChipProperties chipProperties2 = this.chipProperties;
                    chipProperties2.baseFrameRate = i12;
                    chipProperties2.initFrameRate = i12;
                }
                this.converted_bps = convertBitRate(initParameters.bitrateKbps, initParameters.fps);
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.width, this.height);
                if ((this.settingHighProfile > 0 || Build.VERSION.SDK_INT >= this.chipProperties.highProfileMinSdkVersion) && initParameters.profile == 100) {
                    Logging.i(str2, "Set high profile and level");
                    VideoCodecType videoCodecType2 = this.type;
                    if (videoCodecType2 == VideoCodecType.VIDEO_CODEC_H264) {
                        createVideoFormat.setInteger("profile", 8);
                        createVideoFormat.setInteger(FirebaseAnalytics.Param.LEVEL, 512);
                    } else if (videoCodecType2 == VideoCodecType.VIDEO_CODEC_H265) {
                        createVideoFormat.setInteger("profile", 1);
                        createVideoFormat.setInteger(FirebaseAnalytics.Param.LEVEL, 256);
                    }
                    this.profile = 100;
                } else {
                    this.profile = 66;
                }
                createVideoFormat.setInteger("bitrate", this.converted_bps);
                int i13 = this.settingBitrateMode;
                if (i13 > 0) {
                    this.bitrateMode = i13;
                } else if (!encoderProperties.codecName.startsWith("OMX.rk.") && this.type != VideoCodecType.VIDEO_CODEC_H265) {
                    if (!this.qcomExceptionModel) {
                        this.bitrateMode = 1;
                    }
                } else {
                    this.bitrateMode = 2;
                }
                createVideoFormat.setInteger("bitrate-mode", this.bitrateMode);
                createVideoFormat.setInteger("color-format", encoderProperties.colorFormat);
                ChipProperties chipProperties3 = this.chipProperties;
                if (chipProperties3.bitrateAdjustmentType == BitrateAdjustmentType.NO_ADJUSTMENT) {
                    createVideoFormat.setInteger("frame-rate", initParameters.init_fps);
                } else {
                    createVideoFormat.setInteger("frame-rate", chipProperties3.initFrameRate);
                }
                List asList = Arrays.asList(INTERVAL_HW_EXCEPTION_MODELS);
                String str3 = Build.MODEL;
                if (asList.contains(str3) && initParameters.keyInterval >= 100) {
                    Logging.i(str2, "keyInterval: " + initParameters.keyInterval);
                    Logging.i(str2, "Model: " + str3 + " ,need to modify interval.");
                    initParameters.keyInterval = 10;
                }
                if (this.chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT) {
                    createVideoFormat.setInteger("i-frame-interval", initParameters.keyInterval);
                } else {
                    createVideoFormat.setInteger("i-frame-interval", initParameters.keyInterval + 1);
                }
                if (!TextUtils.isEmpty(initParameters.customConfigJson)) {
                    applyCustomConfig(createVideoFormat, initParameters.customConfigJson);
                }
                Logging.d(str2, "Format: " + createVideoFormat);
                MediaCodec createByCodecName = createByCodecName(encoderProperties.codecName);
                this.mediaCodec = createByCodecName;
                if (createByCodecName != null) {
                    if (this.useAsyncMode) {
                        MediaCodecEncoderCallback mediaCodecEncoderCallback = new MediaCodecEncoderCallback();
                        this.asyncEncoderCallback = mediaCodecEncoderCallback;
                        b.a(this.mediaCodec, mediaCodecEncoderCallback, this.dedicatedHandler);
                    }
                    this.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
                    this.codecName = encoderProperties.codecName;
                    Logging.i(str2, "codecName: " + this.codecName);
                    this.colorFormat = encoderProperties.colorFormat;
                    if (initParameters.useSurface) {
                        this.memoryType = 11;
                    } else {
                        this.memoryType = 0;
                    }
                    this.bitrateAdjustmentType = this.chipProperties.bitrateAdjustmentType.ordinal();
                    return true;
                }
                throw new RuntimeException("Can not create media encoder");
            }
            throw new RuntimeException("Can not find HW encoder for " + this.type);
        }
        Logging.w(str2, "Not supported size:" + this.width + "x" + this.height);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OutputBufferInfo createOutputBufferInfo(MediaCodec.BufferInfo bufferInfo, int i10, ByteBuffer byteBuffer) {
        boolean z10;
        VideoCodecType videoCodecType;
        byteBuffer.position(bufferInfo.offset);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        if ((bufferInfo.flags & 1) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            Logging.d(TAG, "Sync frame generated");
        }
        if (z10 && ((videoCodecType = this.type) == VideoCodecType.VIDEO_CODEC_H264 || videoCodecType == VideoCodecType.VIDEO_CODEC_H265)) {
            Logging.d(TAG, "Appending config frame of size " + this.configData.capacity() + " to output buffer with offset " + bufferInfo.offset + ", size " + bufferInfo.size);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.configData.capacity() + bufferInfo.size);
            this.configData.rewind();
            allocateDirect.put(this.configData);
            allocateDirect.put(byteBuffer);
            allocateDirect.position(0);
            return new OutputBufferInfo(i10, allocateDirect, z10, bufferInfo.presentationTimeUs, bufferInfo.size + this.configData.capacity());
        }
        return new OutputBufferInfo(i10, byteBuffer.slice(), z10, bufferInfo.presentationTimeUs, bufferInfo.size);
    }

    public static void disableH264HwCodec() {
        Logging.w(TAG, "H.264 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(H264_MIME_TYPE);
    }

    public static void disableH265HwCodec() {
        Logging.w(TAG, "H.265 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(H265_MIME_TYPE);
    }

    public static void disableVp8HwCodec() {
        Logging.w(TAG, "VP8 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(VP8_MIME_TYPE);
    }

    public static void disableVp9HwCodec() {
        Logging.w(TAG, "VP9 encoding is disabled by application.");
        hwEncoderDisabledTypes.add(VP9_MIME_TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doInitEncoder(InitParameters initParameters) {
        if (this.isInitialized) {
            Logging.w(TAG, "already initialized!");
            return true;
        }
        try {
            if (!createEncoder(initParameters)) {
                Logging.e(TAG, "failed to create hardware encoder!!");
                return false;
            }
            this.isInitialized = true;
            initEglForEncoderIfNeeded(initParameters);
            this.mediaCodec.start();
            if (!this.useAsyncMode) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                Logging.d(TAG, "Output buffers: " + this.outputBuffers.length);
            }
            return true;
        } catch (Exception e10) {
            Logging.e(TAG, "failed to create hardware encoder,", e10);
            try {
                release();
            } catch (Exception e11) {
                Logging.e(TAG, "failed to release hardware encoder,", e11);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doReleaseEncoder() {
        if (!this.isInitialized) {
            Logging.e(TAG, "doReleaseEncoder: encoder is not initialized!");
            return;
        }
        boolean z10 = false;
        this.isInitialized = false;
        releaseEglForEncoderIfNeeded();
        final C1CaughtException c1CaughtException = new C1CaughtException();
        final MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: io.agora.rtc.video.MediaCodecVideoEncoder.4
                @Override // java.lang.Runnable
                public void run() {
                    Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
                    try {
                        Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder: MediaCodec.stop");
                        mediaCodec.stop();
                    } catch (Exception e10) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder stop failed", e10);
                    }
                    try {
                        Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder: MediaCodec.release");
                        mediaCodec.release();
                    } catch (Exception e11) {
                        Logging.e(MediaCodecVideoEncoder.TAG, "Media encoder release failed", e11);
                        c1CaughtException.f١٤٩٥٤e = e11;
                    }
                    Logging.i(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
                    countDownLatch.countDown();
                }
            }).start();
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 3000L)) {
                Logging.e(TAG, "Media encoder release timeout");
                z10 = true;
            }
            this.mediaCodec = null;
        }
        if (z10) {
            codecErrors++;
            if (errorCallback != null) {
                Logging.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
            }
            throw new RuntimeException("Media encoder release timeout.");
        }
        if (c1CaughtException.f١٤٩٥٤e == null) {
            Logging.i(TAG, "Java releaseEncoder done");
        } else {
            RuntimeException runtimeException = new RuntimeException(c1CaughtException.f١٤٩٥٤e);
            runtimeException.setStackTrace(ThreadUtils.concatStackTraces(c1CaughtException.f١٤٩٥٤e.getStackTrace(), runtimeException.getStackTrace()));
            throw runtimeException;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static EncoderProperties do_findHwEncoder(String str, String[] strArr, int[] iArr) {
        boolean z10;
        String str2;
        boolean z11 = false;
        int i10 = 2130708361;
        ?? r52 = 1;
        if (iArr[0] == 2130708361) {
            z10 = true;
        } else {
            z10 = false;
        }
        String str3 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Model: ");
        String str4 = Build.MODEL;
        sb.append(str4);
        sb.append(", hardware: ");
        String str5 = Build.HARDWARE;
        sb.append(str5);
        Logging.i(str3, sb.toString());
        EncoderProperties encoderProperties = null;
        if (str.equals(H264_MIME_TYPE)) {
            if (Arrays.asList(H264_HW_EXCEPTION_MODELS).contains(str4)) {
                Logging.w(str3, "Model: " + str4 + " has black listed H.264 encoder.");
                return null;
            }
            if (str5.equalsIgnoreCase("kirin970") && !z10) {
                return null;
            }
        } else if (str.equals(H265_MIME_TYPE) && Arrays.asList(H265_HW_EXCEPTION_HARDWARES).contains(str5)) {
            Logging.w(str3, "Hardware: " + str5 + " has black listed H.265 encoder.");
            return null;
        }
        int i11 = 0;
        while (i11 < MediaCodecList.getCodecCount()) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i11);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                int length = supportedTypes.length;
                int i12 = 0;
                while (true) {
                    if (i12 < length) {
                        if (supportedTypes[i12].equals(str)) {
                            str2 = codecInfoAt.getName();
                            break;
                        }
                        i12++;
                    } else {
                        str2 = encoderProperties;
                        break;
                    }
                }
                if (str2 == 0) {
                    continue;
                } else if (!checkMinSDKVersion(str2, z10)) {
                    Logging.e(TAG, "Check min sdk version failed, " + str2);
                } else {
                    Logging.i(TAG, "Found candidate encoder " + str2);
                    if (str2.startsWith("OMX.") || z10) {
                        codecOmxName = str2;
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                        if (str.equals(H264_MIME_TYPE)) {
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                if (codecProfileLevel.profile == 8) {
                                    mH264SupportProfileHigh = r52;
                                }
                            }
                        }
                        if (str2.startsWith("OMX.amlogic.")) {
                            if (z10) {
                                return new EncoderProperties(str2, i10, r52);
                            }
                            return new EncoderProperties(str2, 19, r52);
                        }
                        String str6 = "   Color:";
                        for (int i13 : capabilitiesForType.colorFormats) {
                            if (21 == i13) {
                                z11 = true;
                            }
                            str6 = str6 + " 0x" + Integer.toHexString(i13) + ", ";
                        }
                        Logging.d(TAG, str6);
                        int length2 = iArr.length;
                        int i14 = 0;
                        r52 = r52;
                        while (i14 < length2) {
                            int i15 = iArr[i14];
                            boolean z12 = r52;
                            for (int i16 : capabilitiesForType.colorFormats) {
                                if (i16 == i15) {
                                    if (i16 == 19 && z11 && (str2.startsWith("OMX.IMG.TOPAZ.") || str2.startsWith("OMX.hisi.") || str2.startsWith("OMX.k3."))) {
                                        String str7 = TAG;
                                        Logging.i(str7, "TOPAZ,force use COLOR_FormatYUV420SemiPlanar");
                                        Logging.i(str7, "Found target encoder for mime " + str + " : " + str2 + ". Color: 0x" + Integer.toHexString(21));
                                        return new EncoderProperties(str2, 21, true);
                                    }
                                    Logging.i(TAG, "Found target encoder for mime " + str + " : " + str2 + ". Color: 0x" + Integer.toHexString(i16));
                                    return new EncoderProperties(str2, i16, true);
                                }
                                z12 = true;
                            }
                            i14++;
                            r52 = z12;
                        }
                    }
                }
            }
            i11++;
            z11 = false;
            i10 = 2130708361;
            encoderProperties = null;
            r52 = r52;
        }
        return encoderProperties;
    }

    private static EncoderProperties findHwEncoder(String str, String[] strArr, int[] iArr) {
        try {
            return do_findHwEncoder(str, strArr, iArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private ChipProperties getChipProperties(String str, int i10) {
        if (str.startsWith("OMX.qcom.")) {
            List asList = Arrays.asList(H264_HW_QCOM_EXCEPTION_MODELS);
            String str2 = Build.MODEL;
            if (asList.contains(str2.toLowerCase())) {
                Logging.w(TAG, "Qcom Exception Model: " + str2);
                this.qcomExceptionModel = true;
                return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, true, i10, i10, 21);
            }
            this.qcomExceptionModel = false;
            return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i10, i10, 21);
        }
        if (str.startsWith("OMX.MTK.")) {
            String str3 = Build.HARDWARE;
            Logging.i(TAG, "MTK hardware: " + str3);
            if (!str3.equalsIgnoreCase("mt6763") && !str3.equalsIgnoreCase("mt6763t")) {
                if (Arrays.asList(MTK_NO_ADJUSTMENT_MODELS).contains(Build.MODEL)) {
                    return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i10, i10, 21);
                }
                if (!str3.equalsIgnoreCase("mt6735") && !str3.equalsIgnoreCase("mt8167")) {
                    return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, 21);
                }
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, Integer.MAX_VALUE);
            }
            return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i10, i10, 21);
        }
        if (str.startsWith("OMX.Exynos.")) {
            String str4 = Build.MODEL;
            if (str4.equalsIgnoreCase("MX4 Pro")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, Integer.MAX_VALUE);
            }
            if (Build.MANUFACTURER.equalsIgnoreCase("vivo") && str4.equalsIgnoreCase("V1938CT")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, 21);
            }
            if (this.settingCodecParameterForExynos > 0 && Build.VERSION.SDK_INT > 28) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, 21);
            }
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, 21);
        }
        if (str.startsWith("OMX.IMG.TOPAZ.")) {
            if (Build.HARDWARE.equalsIgnoreCase("hi6250")) {
                return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, Integer.MAX_VALUE);
            }
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        }
        if (str.startsWith("OMX.hisi.")) {
            return new ChipProperties(str, BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT, false, i10, i10, Integer.MAX_VALUE);
        }
        if (str.startsWith("OMX.k3.")) {
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, 21);
        }
        if (str.startsWith("OMX.amlogic.")) {
            Logging.i(TAG, "getChipProperties for amlogic");
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        }
        if (str.startsWith("OMX.rk.")) {
            return new ChipProperties(str, BitrateAdjustmentType.FRAMERATE_ADJUSTMENT, false, 30, 30, Integer.MAX_VALUE);
        }
        Logging.i(TAG, "getChipProperties from unsupported chip list");
        return new ChipProperties(str, BitrateAdjustmentType.NO_ADJUSTMENT, false, i10, i10, 23);
    }

    private void getEncoderProperties(int i10) {
        String[] strArr = {VP8_MIME_TYPE, VP9_MIME_TYPE, H264_MIME_TYPE, H265_MIME_TYPE};
        this.supportCodecs = 0;
        String str = null;
        for (int i11 = 0; i11 < MediaCodecList.getCodecCount(); i11++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i11);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equals(VP8_MIME_TYPE)) {
                        this.supportCodecs |= 1;
                    } else if (str2.equals(H264_MIME_TYPE)) {
                        this.supportCodecs |= 2;
                    } else if (str2.equals(H265_MIME_TYPE)) {
                        this.supportCodecs |= 4;
                    }
                    if (str == null && str2.equals(strArr[i10])) {
                        str = codecInfoAt.getName();
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(strArr[i10]);
                        if (isA50OrHigher()) {
                            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
                            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
                            this.maxSupportedWidth = supportedWidths.getUpper().intValue();
                            this.maxSupportedHeight = supportedHeights.getUpper().intValue();
                            this.minSupportedWidth = supportedWidths.getLower().intValue();
                            this.minSupportedHeight = supportedHeights.getLower().intValue();
                            this.widthAlignment = videoCapabilities.getWidthAlignment();
                            this.heightAlignment = videoCapabilities.getHeightAlignment();
                            Range<Integer> bitrateRange = videoCapabilities.getBitrateRange();
                            this.maxSupportedBitrate = bitrateRange.getUpper().intValue();
                            this.minSupportedBitrate = bitrateRange.getLower().intValue();
                            Logging.i(TAG, "max supported size:" + this.maxSupportedWidth + "x" + this.maxSupportedHeight + " min supported size:" + this.minSupportedWidth + "x" + this.minSupportedHeight + " align size: " + this.widthAlignment + "x" + this.heightAlignment + " bitrate range: " + this.maxSupportedBitrate + " -> " + this.minSupportedBitrate);
                        }
                    }
                }
            }
        }
        this.SDKVer = Build.VERSION.SDK_INT;
        this.deviceModel = Build.MODEL;
        this.cpuModel = Build.HARDWARE;
    }

    public static int getHWEncoderManufactor() {
        if (codecOmxName.startsWith("OMX.qcom.")) {
            return 0;
        }
        if (codecOmxName.startsWith("OMX.MTK.")) {
            return 1;
        }
        if (codecOmxName.startsWith("OMX.Exynos.")) {
            return 2;
        }
        if (codecOmxName.startsWith("OMX.IMG.TOPAZ.")) {
            return 3;
        }
        if (codecOmxName.startsWith("OMX.k3.")) {
            return 4;
        }
        if (codecOmxName.startsWith("OMX.hisi.")) {
            return 5;
        }
        if (codecOmxName.startsWith("OMX.amlogic.")) {
            return 6;
        }
        if (codecOmxName.startsWith("OMX.rk.")) {
            return 7;
        }
        return -1;
    }

    private void initEglForEncoderIfNeeded(InitParameters initParameters) {
        if (!initParameters.useSurface) {
            return;
        }
        this.eglAttachedOnDedicatedThread = false;
        android.opengl.EGLContext eGLContext = initParameters.sharedEgl14Context;
        if (eGLContext != null) {
            this.eglBase = new EglBase14(new EglBase14.Context(eGLContext), EglBase.CONFIG_RECORDABLE);
        } else {
            EGLContext eGLContext2 = initParameters.sharedEgl10Context;
            if (eGLContext2 != null) {
                this.eglBase = new EglBase10(new EglBase10.Context(eGLContext2), EglBase.CONFIG_RECORDABLE);
            }
        }
        if (this.eglBase != null) {
            Surface createInputSurface = this.mediaCodec.createInputSurface();
            this.inputSurface = createInputSurface;
            this.eglBase.createSurface(createInputSurface);
            this.drawer = new GlRectDrawer();
            Logging.i(TAG, "init egl done, ctx: " + this.eglBase.getEglBaseContext().getRealEglContext() + " hasSurface: " + this.eglBase.hasSurface());
            return;
        }
        Logging.e(TAG, "init egl failed, no shared context provided.");
    }

    private static boolean isA50OrHigher() {
        return true;
    }

    public static boolean isAsyncModeSupported() {
        if (Build.VERSION.SDK_INT < 23 || Arrays.asList(ASYNC_EXCLUDED_MODELS).contains(Build.MODEL)) {
            return false;
        }
        return true;
    }

    public static int isH264HwHighProfileSupported() {
        return mH264SupportProfileHigh;
    }

    public static boolean isH264HwSupported() {
        try {
            if (hwEncoderDisabledTypes.contains(H264_MIME_TYPE)) {
                return false;
            }
            if (findHwEncoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes, supportedColorList) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Logging.e(TAG, "isH264HwSupported failed!");
            return false;
        }
    }

    public static boolean isH264HwSupportedUsingTextures() {
        try {
            if (hwEncoderDisabledTypes.contains(H264_MIME_TYPE)) {
                return false;
            }
            if (findHwEncoder(H264_MIME_TYPE, supportedH264HwCodecPrefixes, supportedSurfaceColorList) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Logging.e(TAG, "isH264HwSupportedUsingTextures failed!");
            return false;
        }
    }

    public static boolean isH265HwSupported() {
        try {
            if (hwEncoderDisabledTypes.contains(H265_MIME_TYPE)) {
                return false;
            }
            if (findHwEncoder(H265_MIME_TYPE, supportedH265HwCodecPrefixes, supportedColorList) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Logging.e(TAG, "isH265HwSupported failed!");
            return false;
        }
    }

    public static boolean isH265HwSupportedUsingTextures() {
        try {
            if (hwEncoderDisabledTypes.contains(H265_MIME_TYPE)) {
                return false;
            }
            if (findHwEncoder(H265_MIME_TYPE, supportedH265HwCodecPrefixes, supportedSurfaceColorList) == null) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            Logging.e(TAG, "isH265HwSupportedUsingTextures failed!");
            return false;
        }
    }

    private boolean isOnDedicatedHandlerThread() {
        HandlerThread handlerThread = this.dedicatedHandlerThread;
        if (handlerThread != null && handlerThread.getId() == Thread.currentThread().getId()) {
            return true;
        }
        return false;
    }

    public static boolean isQcomHWEncoder() {
        String str = codecOmxName;
        if (str != null && !str.startsWith("OMX.qcom.")) {
            Logging.i(TAG, "Qualcomm HW encoder false");
            return false;
        }
        Logging.i(TAG, "Qualcomm HW encoder true");
        return true;
    }

    public static boolean isVp8HwSupported() {
        if (!hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) && findHwEncoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, supportedColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp8HwSupportedUsingTextures() {
        if (!hwEncoderDisabledTypes.contains(VP8_MIME_TYPE) && findHwEncoder(VP8_MIME_TYPE, supportedVp8HwCodecPrefixes, supportedSurfaceColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp9HwSupported() {
        if (!hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) && findHwEncoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes, supportedColorList) != null) {
            return true;
        }
        return false;
    }

    public static boolean isVp9HwSupportedUsingTextures() {
        if (!hwEncoderDisabledTypes.contains(VP9_MIME_TYPE) && findHwEncoder(VP9_MIME_TYPE, supportedVp9HwCodecPrefixes, supportedSurfaceColorList) != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void onAsyncEncodeFrameResult(long j10, boolean z10, OutputBufferInfo outputBufferInfo);

    private void releaseEglForEncoderIfNeeded() {
        if (this.eglBase != null) {
            if (!isOnDedicatedHandlerThread() || !this.eglAttachedOnDedicatedThread) {
                this.eglBase.makeCurrent();
            }
            GlRectDrawer glRectDrawer = this.drawer;
            if (glRectDrawer != null) {
                glRectDrawer.release();
                this.drawer = null;
            }
            this.eglBase.release();
            this.eglBase = null;
        }
        Surface surface = this.inputSurface;
        if (surface != null) {
            surface.release();
            this.inputSurface = null;
        }
        this.eglAttachedOnDedicatedThread = false;
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        Logging.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    private int setRates(int i10, int i11) {
        boolean z10;
        int i12;
        if (!this.isInitialized) {
            Logging.e(TAG, "setRates: encoder is not initialized!");
            return -1;
        }
        String str = TAG;
        Logging.d(str, "setRates: " + i10 + " Kbps " + i11 + " fps");
        if (i11 > 0 && i11 != this.lastSetFps) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (i11 <= 0) {
            i11 = this.lastSetFps;
        }
        this.lastSetFps = i11;
        int convertBitRate = convertBitRate(i10, i11);
        if (z10) {
            try {
                if (this.settingAdjustmentReset <= 0) {
                    if (this.chipProperties.bitrateAdjustmentType == BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT) {
                    }
                }
                this.converted_bps = convertBitRate;
                return 0;
            } catch (IllegalStateException e10) {
                Logging.e(TAG, "setRates failed", e10);
                return 0;
            }
        }
        String str2 = "";
        if (convertBitRate > this.converted_bps) {
            this.converted_bps = convertBitRate;
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", this.converted_bps);
            this.mediaCodec.setParameters(bundle);
            StringBuilder sb = new StringBuilder();
            if (this.useAsyncMode) {
                str2 = "[async] ";
            }
            sb.append(str2);
            sb.append("setRates up to : ");
            sb.append(this.converted_bps);
            sb.append(" bps(converted) ");
            sb.append(this.lastSetFps);
            sb.append(" fps");
            Logging.i(str, sb.toString());
            return 1;
        }
        if (this.chipProperties.chipName.startsWith("OMX.qcom.")) {
            i12 = 25000;
            if (!this.qcomExceptionModel && this.converted_bps <= 200000) {
                i12 = 15000;
            }
        } else {
            i12 = 0;
        }
        if (convertBitRate < this.converted_bps - i12) {
            this.converted_bps = convertBitRate;
            if (this.chipProperties.isNeedResetWhenDownBps) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - this.lastResetForQcomTimeMs >= 2000) {
                    this.lastResetForQcomTimeMs = elapsedRealtime;
                    return 0;
                }
                return 2;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putInt("video-bitrate", this.converted_bps);
            this.mediaCodec.setParameters(bundle2);
            StringBuilder sb2 = new StringBuilder();
            if (this.useAsyncMode) {
                str2 = "[async] ";
            }
            sb2.append(str2);
            sb2.append("setRates down to : ");
            sb2.append(this.converted_bps);
            sb2.append(" bps(converted) ");
            sb2.append(this.lastSetFps);
            sb2.append(" fps");
            Logging.i(str, sb2.toString());
        }
        return 1;
    }

    private int supportedEncoderConfig(int i10, int i11, int i12, int i13) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verboseLog(String str) {
    }

    boolean checkKeyFrame(boolean z10) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.hasPendingKeyFrame) {
            if (elapsedRealtime - this.lastKeyFrameTimeMs > this.keyFrameEncodeMinInterval) {
                this.hasPendingKeyFrame = false;
                return true;
            }
        } else if (z10) {
            long j10 = this.lastKeyFrameTimeMs;
            if (j10 != 0 && elapsedRealtime - j10 <= this.keyFrameEncodeMinInterval) {
                this.hasPendingKeyFrame = true;
            } else {
                return z10;
            }
        } else {
            return z10;
        }
        return false;
    }

    @Deprecated
    int dequeueInputBuffer() {
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (IllegalStateException e10) {
            Logging.e(TAG, "dequeueIntputBuffer failed", e10);
            return -2;
        }
    }

    @TargetApi(21)
    InputBufferInfo dequeueInputBufferAvailable() {
        InputBufferInfo inputBufferInfo;
        synchronized (this.callbackLock) {
            Iterator<Integer> it = this.availableInputIndexes.iterator();
            if (!it.hasNext()) {
                Logging.e(TAG, "no input buffer available");
                inputBufferInfo = new InputBufferInfo(-1, null);
            } else {
                try {
                    int intValue = it.next().intValue();
                    it.remove();
                    inputBufferInfo = new InputBufferInfo(intValue, this.mediaCodec.getInputBuffer(intValue));
                } catch (IllegalStateException e10) {
                    Logging.e(TAG, "codec exception: " + e10.getMessage());
                    inputBufferInfo = new InputBufferInfo(-2, null);
                }
            }
        }
        verboseLog("dequeueInputBufferAvailable index: " + inputBufferInfo.index);
        return inputBufferInfo;
    }

    @Deprecated
    OutputBufferInfo dequeueOutputBuffer() {
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            if (dequeueOutputBuffer >= 0 && (bufferInfo.flags & 2) != 0) {
                Logging.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                this.outputBuffers[dequeueOutputBuffer].position(bufferInfo.offset);
                this.outputBuffers[dequeueOutputBuffer].limit(bufferInfo.offset + bufferInfo.size);
                this.configData.put(this.outputBuffers[dequeueOutputBuffer]);
                this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            }
            if (dequeueOutputBuffer >= 0) {
                return createOutputBufferInfo(bufferInfo, dequeueOutputBuffer, this.outputBuffers[dequeueOutputBuffer].duplicate());
            }
            if (dequeueOutputBuffer == -3) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                return dequeueOutputBuffer();
            }
            if (dequeueOutputBuffer == -2) {
                return dequeueOutputBuffer();
            }
            if (dequeueOutputBuffer == -1) {
                return null;
            }
            throw new RuntimeException("dequeueOutputBuffer: " + dequeueOutputBuffer);
        } catch (IllegalStateException e10) {
            Logging.e(TAG, "dequeueOutputBuffer failed", e10);
            return new OutputBufferInfo(-1, null, false, -1L, 0);
        }
    }

    void dumpIntoFile(OutputBufferInfo outputBufferInfo, VideoCodecType videoCodecType) {
        String format;
        if (this.fos == null) {
            String str = null;
            try {
                if (videoCodecType == VideoCodecType.VIDEO_CODEC_H264) {
                    format = String.format("/sdcard/java_dump_video_%d_%d.h264", Integer.valueOf(this.width), Integer.valueOf(this.height));
                } else if (videoCodecType == VideoCodecType.VIDEO_CODEC_H265) {
                    format = String.format("/sdcard/java_dump_video_%d_%d.h265", Integer.valueOf(this.width), Integer.valueOf(this.height));
                } else {
                    format = String.format("/sdcard/java_dump_video_%d_%d.raw", Integer.valueOf(this.width), Integer.valueOf(this.height));
                }
                str = format;
                this.fos = new FileOutputStream(str, true);
            } catch (Exception unused) {
                Logging.i(TAG, "dumpIntoFile: failed to open " + str);
                return;
            }
        }
        if (outputBufferInfo != null && outputBufferInfo.index >= 0) {
            Logging.i(TAG, "Dump nal: " + outputBufferInfo.buffer);
            try {
                byte[] bArr = new byte[outputBufferInfo.buffer.remaining()];
                outputBufferInfo.buffer.get(bArr);
                this.fos.write(bArr, 0, outputBufferInfo.size);
            } catch (Exception e10) {
                Logging.e(TAG, "Run: 4.1 Exception ", e10);
            }
        }
    }

    boolean encodeBuffer(boolean z10, int i10, int i11, int i12, long j10) {
        verboseLog("encodeBuffer isKeyframe: " + z10 + " index: " + i10);
        if (!this.isInitialized) {
            Logging.e(TAG, "encodeBuffer: encoder is not initialized!");
            return false;
        }
        boolean checkKeyFrame = checkKeyFrame(z10);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastKeyFrameTimeMs == 0) {
            this.lastKeyFrameTimeMs = elapsedRealtime;
        }
        this.outputFrameRotation = i12;
        if (!checkKeyFrame) {
            try {
                if (this.chipProperties.bitrateAdjustmentType != BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT && elapsedRealtime - this.lastKeyFrameTimeMs >= this.keyFrameIntervalInMsec) {
                }
                this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
                return true;
            } catch (IllegalStateException e10) {
                Logging.e(TAG, "encodeBuffer failed", e10);
                return false;
            }
        }
        if (checkKeyFrame) {
            Logging.i(TAG, "Sync frame request");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mediaCodec.setParameters(bundle);
        this.lastKeyFrameTimeMs = elapsedRealtime;
        this.mediaCodec.queueInputBuffer(i10, 0, i11, j10, 0);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080 A[Catch: all -> 0x0054, RuntimeException -> 0x0057, TryCatch #0 {RuntimeException -> 0x0057, blocks: (B:62:0x0040, B:64:0x0048, B:15:0x0074, B:17:0x0080, B:18:0x0091, B:27:0x00bb, B:29:0x00e0, B:31:0x00ef, B:34:0x0127, B:36:0x0141, B:37:0x0146, B:55:0x0109, B:58:0x0086, B:60:0x008a, B:13:0x005c, B:14:0x0063), top: B:61:0x0040, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb A[Catch: all -> 0x0054, RuntimeException -> 0x0057, TryCatch #0 {RuntimeException -> 0x0057, blocks: (B:62:0x0040, B:64:0x0048, B:15:0x0074, B:17:0x0080, B:18:0x0091, B:27:0x00bb, B:29:0x00e0, B:31:0x00ef, B:34:0x0127, B:36:0x0141, B:37:0x0146, B:55:0x0109, B:58:0x0086, B:60:0x008a, B:13:0x005c, B:14:0x0063), top: B:61:0x0040, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ef A[Catch: all -> 0x0054, RuntimeException -> 0x0057, TryCatch #0 {RuntimeException -> 0x0057, blocks: (B:62:0x0040, B:64:0x0048, B:15:0x0074, B:17:0x0080, B:18:0x0091, B:27:0x00bb, B:29:0x00e0, B:31:0x00ef, B:34:0x0127, B:36:0x0141, B:37:0x0146, B:55:0x0109, B:58:0x0086, B:60:0x008a, B:13:0x005c, B:14:0x0063), top: B:61:0x0040, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0141 A[Catch: all -> 0x0054, RuntimeException -> 0x0057, TryCatch #0 {RuntimeException -> 0x0057, blocks: (B:62:0x0040, B:64:0x0048, B:15:0x0074, B:17:0x0080, B:18:0x0091, B:27:0x00bb, B:29:0x00e0, B:31:0x00ef, B:34:0x0127, B:36:0x0141, B:37:0x0146, B:55:0x0109, B:58:0x0086, B:60:0x008a, B:13:0x005c, B:14:0x0063), top: B:61:0x0040, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109 A[Catch: all -> 0x0054, RuntimeException -> 0x0057, TryCatch #0 {RuntimeException -> 0x0057, blocks: (B:62:0x0040, B:64:0x0048, B:15:0x0074, B:17:0x0080, B:18:0x0091, B:27:0x00bb, B:29:0x00e0, B:31:0x00ef, B:34:0x0127, B:36:0x0141, B:37:0x0146, B:55:0x0109, B:58:0x0086, B:60:0x008a, B:13:0x005c, B:14:0x0063), top: B:61:0x0040, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0086 A[Catch: all -> 0x0054, RuntimeException -> 0x0057, TryCatch #0 {RuntimeException -> 0x0057, blocks: (B:62:0x0040, B:64:0x0048, B:15:0x0074, B:17:0x0080, B:18:0x0091, B:27:0x00bb, B:29:0x00e0, B:31:0x00ef, B:34:0x0127, B:36:0x0141, B:37:0x0146, B:55:0x0109, B:58:0x0086, B:60:0x008a, B:13:0x005c, B:14:0x0063), top: B:61:0x0040, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean encodeTexture(boolean z10, int i10, int i11, float[] fArr, int i12, int i13, int i14, int i15, int i16, boolean z11, long j10, Runnable runnable) {
        boolean isOnDedicatedHandlerThread;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21 = i16;
        verboseLog("encode texture, pts_us: " + j10);
        boolean z12 = false;
        if (!this.isInitialized) {
            Logging.e(TAG, "encodeTexture: encoder is not initialized!");
            if (runnable != null) {
                runnable.run();
            }
            return false;
        }
        boolean checkKeyFrame = checkKeyFrame(z10);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastKeyFrameTimeMs == 0) {
            this.lastKeyFrameTimeMs = elapsedRealtime;
        }
        if (!checkKeyFrame) {
            try {
                try {
                    if (this.chipProperties.bitrateAdjustmentType != BitrateAdjustmentType.ACTUAL_FRAMERATE_ADJUSTMENT && elapsedRealtime - this.lastKeyFrameTimeMs >= this.keyFrameIntervalInMsec) {
                    }
                    ATrace.beginSection("makeCurrent@enc");
                    isOnDedicatedHandlerThread = isOnDedicatedHandlerThread();
                    if (isOnDedicatedHandlerThread) {
                        this.eglBase.makeCurrent();
                    } else if (!this.eglAttachedOnDedicatedThread) {
                        this.eglBase.makeCurrent();
                        this.eglAttachedOnDedicatedThread = true;
                    }
                    ATrace.endSection();
                    ATrace.beginSection("glClear@enc");
                    GLES20.glClear(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
                    ATrace.endSection();
                    Matrix convertMatrixToAndroidGraphicsMatrix = RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr);
                    if (z11) {
                        i17 = i12;
                        i18 = i13;
                    } else {
                        if (i21 != 90 && i21 != 270) {
                            i20 = i12;
                            i19 = i13;
                            if (i21 != 0) {
                                this.rotateMatrix.reset();
                                this.rotateMatrix.preTranslate(0.5f, 0.5f);
                                this.rotateMatrix.preRotate(i21);
                                this.rotateMatrix.preTranslate(-0.5f, -0.5f);
                                convertMatrixToAndroidGraphicsMatrix.preConcat(this.rotateMatrix);
                            }
                            i17 = i20;
                            i18 = i19;
                        }
                        i19 = i12;
                        i20 = i13;
                        if (i21 != 0) {
                        }
                        i17 = i20;
                        i18 = i19;
                    }
                    float[] convertMatrixFromAndroidGraphicsMatrix = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(convertMatrixToAndroidGraphicsMatrix);
                    ATrace.beginSection("draw@enc");
                    if (i11 != 10) {
                        this.memoryType = 10;
                        this.drawer.drawRgb(i10, convertMatrixFromAndroidGraphicsMatrix, i17, i18, 0, 0, this.width, this.height, i14, i15);
                    } else {
                        this.memoryType = 11;
                        this.drawer.drawOes(i10, convertMatrixFromAndroidGraphicsMatrix, i17, i18, 0, 0, this.width, this.height, i14, i15);
                    }
                    if (z11) {
                        i21 = 0;
                    }
                    this.outputFrameRotation = i21;
                    ATrace.endSection();
                    ATrace.beginSection("swapBuffers@enc");
                    this.eglBase.swapBuffers();
                    ATrace.endSection();
                    ATrace.beginSection("detachCurrent");
                    if (!isOnDedicatedHandlerThread) {
                        this.eglBase.detachCurrent();
                    }
                    ATrace.endSection();
                    if (runnable != null) {
                        runnable.run();
                    }
                    z12 = true;
                } catch (RuntimeException e10) {
                    Logging.e(TAG, "encodeTexture failed", e10);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
                verboseLog("done encoding texture, pts_us: " + j10);
                return z12;
            } catch (Throwable th) {
                if (runnable != null) {
                    runnable.run();
                }
                throw th;
            }
        }
        if (checkKeyFrame) {
            Logging.i(TAG, "Sync frame request");
        }
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.mediaCodec.setParameters(bundle);
        this.lastKeyFrameTimeMs = elapsedRealtime;
        ATrace.beginSection("makeCurrent@enc");
        isOnDedicatedHandlerThread = isOnDedicatedHandlerThread();
        if (isOnDedicatedHandlerThread) {
        }
        ATrace.endSection();
        ATrace.beginSection("glClear@enc");
        GLES20.glClear(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        ATrace.endSection();
        Matrix convertMatrixToAndroidGraphicsMatrix2 = RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr);
        if (z11) {
        }
        float[] convertMatrixFromAndroidGraphicsMatrix2 = RendererCommon.convertMatrixFromAndroidGraphicsMatrix(convertMatrixToAndroidGraphicsMatrix2);
        ATrace.beginSection("draw@enc");
        if (i11 != 10) {
        }
        if (z11) {
        }
        this.outputFrameRotation = i21;
        ATrace.endSection();
        ATrace.beginSection("swapBuffers@enc");
        this.eglBase.swapBuffers();
        ATrace.endSection();
        ATrace.beginSection("detachCurrent");
        if (!isOnDedicatedHandlerThread) {
        }
        ATrace.endSection();
        if (runnable != null) {
        }
        z12 = true;
        verboseLog("done encoding texture, pts_us: " + j10);
        return z12;
    }

    boolean encodeTextureBuffer(final VideoFrame.TextureBuffer textureBuffer, final boolean z10, final int i10, final int i11, final int i12, final boolean z11, final long j10) {
        verboseLog("encodeTextureBuffer: " + textureBuffer + " isKeyframe: " + z10 + " rotation: " + i12 + " pts_us: " + j10 + " this: " + this);
        textureBuffer.retain();
        try {
            return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.dedicatedHandler, new Callable<Boolean>() { // from class: io.agora.rtc.video.MediaCodecVideoEncoder.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    return Boolean.valueOf(MediaCodecVideoEncoder.this.encodeTexture(z10, textureBuffer.getTextureId(), VideoFrame.getAgoraFormat(textureBuffer), RendererCommon.convertMatrixFromAndroidGraphicsMatrix(textureBuffer.getTransformMatrix()), textureBuffer.getWidth(), textureBuffer.getHeight(), i10, i11, i12, z11, j10, new Runnable() { // from class: io.agora.rtc.video.MediaCodecVideoEncoder.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MediaCodecVideoEncoder.this.verboseLog("releasing " + textureBuffer);
                            textureBuffer.release();
                        }
                    }));
                }
            })).booleanValue();
        } catch (Exception e10) {
            Logging.e(TAG, "encode texture buffer exception: " + e10);
            textureBuffer.release();
            return false;
        }
    }

    @Deprecated
    ByteBuffer[] getInputBuffers() {
        ByteBuffer[] inputBuffers = this.mediaCodec.getInputBuffers();
        Logging.d(TAG, "Input buffers: " + inputBuffers.length);
        return inputBuffers;
    }

    int getOutputFrameRotation() {
        return this.outputFrameRotation;
    }

    boolean initEncoder(final InitParameters initParameters) {
        boolean z10;
        String str;
        boolean z11 = initParameters.useAsyncMode;
        this.useAsyncMode = z11;
        if (z11 || initParameters.useSurface) {
            if (this.dedicatedHandlerThread == null) {
                HandlerThread handlerThread = new HandlerThread("encodeHandler");
                this.dedicatedHandlerThread = handlerThread;
                handlerThread.start();
            }
            this.dedicatedHandler = new Handler(this.dedicatedHandlerThread.getLooper());
        }
        Callable<Boolean> callable = new Callable<Boolean>() { // from class: io.agora.rtc.video.MediaCodecVideoEncoder.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                boolean doInitEncoder = MediaCodecVideoEncoder.this.doInitEncoder(initParameters);
                if (!doInitEncoder) {
                    InitParameters initParameters2 = initParameters;
                    if (initParameters2.fallbackToBaselineProfile && initParameters2.profile != 66) {
                        initParameters2.profile = 66;
                        Logging.w(MediaCodecVideoEncoder.TAG, "Init encoder: retry with baseline profile");
                        doInitEncoder = MediaCodecVideoEncoder.this.doInitEncoder(initParameters);
                    }
                }
                return Boolean.valueOf(doInitEncoder);
            }
        };
        Handler handler = this.dedicatedHandler;
        if (handler != null) {
            z10 = ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler, callable)).booleanValue();
        } else {
            try {
                z10 = callable.call().booleanValue();
            } catch (Exception e10) {
                e10.printStackTrace();
                z10 = false;
            }
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Init encoder done: ");
        if (z10) {
            str = "success";
        } else {
            str = "failed";
        }
        sb.append(str);
        Logging.i(str2, sb.toString());
        return z10;
    }

    void nativeCreate(long j10) {
        this.nativeHandle = j10;
        Logging.i(TAG, "nativeCreate handle: " + j10);
    }

    void nativeDestroy() {
        Logging.i(TAG, "nativeDestroy");
        HandlerThread handlerThread = this.dedicatedHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
            this.dedicatedHandlerThread = null;
        }
        this.dedicatedHandler = null;
        this.nativeHandle = 0L;
    }

    void release() {
        Logging.i(TAG, "Java releaseEncoder");
        Runnable runnable = new Runnable() { // from class: io.agora.rtc.video.MediaCodecVideoEncoder.3
            @Override // java.lang.Runnable
            public void run() {
                if (MediaCodecVideoEncoder.this.useAsyncMode) {
                    synchronized (MediaCodecVideoEncoder.this.callbackLock) {
                        try {
                            MediaCodecVideoEncoder.this.availableInputIndexes.clear();
                            if (MediaCodecVideoEncoder.this.asyncEncoderCallback != null) {
                                MediaCodecVideoEncoder.this.asyncEncoderCallback.stale = true;
                            }
                            MediaCodecVideoEncoder.this.doReleaseEncoder();
                        } finally {
                        }
                    }
                    return;
                }
                MediaCodecVideoEncoder.this.doReleaseEncoder();
            }
        };
        Handler handler = this.dedicatedHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, runnable);
        } else {
            runnable.run();
        }
    }

    @Deprecated
    boolean releaseOutputBuffer(int i10) {
        verboseLog("releaseOutputBuffer: " + i10);
        try {
            this.mediaCodec.releaseOutputBuffer(i10, false);
            return true;
        } catch (IllegalStateException e10) {
            Logging.e(TAG, "releaseOutputBuffer failed", e10);
            return false;
        }
    }

    boolean encodeTexture(boolean z10, int i10, int i11, float[] fArr, int i12, int i13, int i14, int i15, int i16, long j10) {
        return encodeTexture(z10, i10, i11, fArr, i12, i13, i14, i15, i16, true, j10, null);
    }
}
