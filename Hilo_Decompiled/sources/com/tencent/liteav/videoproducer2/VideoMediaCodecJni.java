package com.tencent.liteav.videoproducer2;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videobase.common.c;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.a;
import com.tencent.qgame.animplayer.util.MediaUtil;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class VideoMediaCodecJni {
    public static final int DRAIN_CODEC_CONFIG_ONLY = 2;
    public static final int DRAIN_ERROR = -1;
    public static final int DRAIN_KEY_FRAME_WITH_CODEC_CONFIG = 1;
    public static final int DRAIN_SUCCESS = 0;
    public static final int DRAIN_TRY_AGAIN_LATER = 4;
    public static final int DRAIN_TRY_AGAIN_ONCE = 3;
    public static final int FEED_ERROR = -1;
    public static final int FEED_SUCCESS = 0;
    public static final int FEED_TRY_AGAIN_LATER = 1;
    private static final String TAG = "VideoMediaCodecJni";

    public static MediaFormat configureMediaCodec(MediaCodecExceptionJni mediaCodecExceptionJni, MediaCodec mediaCodec, VideoEncodeParams videoEncodeParams, boolean z, int i, boolean z2) {
        String str;
        boolean z3;
        MediaFormat a;
        if (videoEncodeParams.codecType == CodecType.H265) {
            str = MediaUtil.MIME_HEVC;
        } else {
            str = "video/avc";
        }
        a aVar = new a(mediaCodec, str, videoEncodeParams, null);
        if (videoEncodeParams.bitrateMode == VideoEncoderDef.BitrateMode.CBR) {
            z3 = true;
        } else {
            z3 = false;
        }
        aVar.a = z3;
        aVar.b = z;
        if (z2) {
            a = aVar.b();
            if (a == null) {
                a = null;
            } else {
                aVar.a(a);
            }
        } else {
            a = aVar.a();
        }
        if (a == null) {
            return null;
        }
        try {
            setMaxBFramesToMediaFormat(a, i);
            mediaCodec.configure(a, (Surface) null, (MediaCrypto) null, 1);
            LiteavLog.i(TAG, "Configure MediaCodec success, MediaFormat: ".concat(String.valueOf(a)));
            return a;
        } catch (Exception e) {
            handleException(mediaCodecExceptionJni, e);
            LiteavLog.e(TAG, "MediaCodec configure failed.".concat(String.valueOf(e)));
            return null;
        } catch (Throwable th) {
            handleThrowable(mediaCodecExceptionJni, th);
            LiteavLog.e(TAG, "MediaCodec configure failed.".concat(String.valueOf(th)));
            return null;
        }
    }

    public static Surface createInputSurface(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                return mediaCodec.createInputSurface();
            } catch (Throwable th) {
                LiteavLog.e(TAG, "MediaCodec create input surface failed.".concat(String.valueOf(th)));
                return null;
            }
        }
        return null;
    }

    public static MediaCodec createMediaCodec(MediaCodecExceptionJni mediaCodecExceptionJni, String str) {
        MediaCodec mediaCodec;
        try {
            mediaCodec = MediaCodec.createEncoderByType(str);
        } catch (Exception e) {
            e = e;
            mediaCodec = null;
        } catch (Throwable th) {
            th = th;
            mediaCodec = null;
        }
        try {
            LiteavLog.i(TAG, "Use mediacodec name:%s", mediaCodec.getName());
            if (!isSoftOnlyEncoder(mediaCodec.getCodecInfo())) {
                return mediaCodec;
            }
            throw new Exception("Shouldn't use software encoder");
        } catch (Exception e2) {
            e = e2;
            handleException(mediaCodecExceptionJni, e);
            LiteavLog.e(TAG, "create MediaCodec failed.".concat(String.valueOf(e)));
            destroyMediaCodec(mediaCodec);
            return null;
        } catch (Throwable th2) {
            th = th2;
            handleThrowable(mediaCodecExceptionJni, th);
            LiteavLog.e(TAG, "create MediaCodec failed.".concat(String.valueOf(th)));
            destroyMediaCodec(mediaCodec);
            return null;
        }
    }

    public static void destroyMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            return;
        }
        try {
            mediaCodec.stop();
        } catch (Throwable th) {
            LiteavLog.e(TAG, "Stop MediaCodec failed.".concat(String.valueOf(th)));
        }
        try {
            mediaCodec.release();
        } catch (Throwable th2) {
            LiteavLog.e(TAG, "Destroy MediaCodec failed.".concat(String.valueOf(th2)));
        }
        LiteavLog.i(TAG, "Destroy MediaCodec success: ".concat(String.valueOf(mediaCodec)));
    }

    public static int drainOutputBuffer(MediaCodecExceptionJni mediaCodecExceptionJni, MediaCodec mediaCodec, MediaCodecFrameJni mediaCodecFrameJni, int i) {
        ByteBuffer byteBuffer;
        boolean z;
        boolean z2;
        c cVar;
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i));
            if (dequeueOutputBuffer == -1) {
                return 4;
            }
            if (dequeueOutputBuffer == -2) {
                try {
                    LiteavLog.i(TAG, "encoder output buffers changed %s", mediaCodec.getOutputFormat());
                } catch (Throwable unused) {
                }
                return 3;
            }
            if (dequeueOutputBuffer == -3) {
                return 3;
            }
            if (dequeueOutputBuffer < 0) {
                return -1;
            }
            if (bufferInfo.size == 0 && (4 & bufferInfo.flags) == 0) {
                LiteavLog.e(TAG, "size is zero, but it isn't end of stream");
                return -1;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 21) {
                byteBuffer = mediaCodec.getOutputBuffer(dequeueOutputBuffer);
            } else {
                byteBuffer = mediaCodec.getOutputBuffers()[dequeueOutputBuffer];
            }
            if (byteBuffer == null) {
                return -1;
            }
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bufferInfo.size);
            mediaCodecFrameJni.data = allocateDirect;
            allocateDirect.put(byteBuffer);
            int i2 = bufferInfo.flags;
            if ((i2 & 1) > 0) {
                z = true;
            } else {
                z = false;
            }
            if ((i2 & 2) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                cVar = c.IDR;
            } else {
                cVar = c.P;
            }
            mediaCodecFrameJni.nalType = cVar;
            mediaCodecFrameJni.pts = TimeUnit.MICROSECONDS.toMillis(bufferInfo.presentationTimeUs);
            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
            if (z2 && z) {
                return 1;
            }
            if (!z2) {
                return 0;
            }
            return 2;
        } catch (Exception e) {
            handleException(mediaCodecExceptionJni, e);
            LiteavLog.e(TAG, "Drain output from MediaCodec failed.", e);
            return -1;
        } catch (Throwable th) {
            handleThrowable(mediaCodecExceptionJni, th);
            LiteavLog.e(TAG, "Drain output from MediaCodec failed.", th);
            return -1;
        }
    }

    public static int feedYuvBufferToMediaCodec(MediaCodecExceptionJni mediaCodecExceptionJni, MediaCodec mediaCodec, ByteBuffer byteBuffer, long j, int i) {
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(timeUnit.toMicros(i));
            if (dequeueInputBuffer < 0) {
                return 1;
            }
            ByteBuffer byteBuffer2 = mediaCodec.getInputBuffers()[dequeueInputBuffer];
            byteBuffer2.clear();
            byteBuffer2.put(byteBuffer);
            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, byteBuffer.capacity(), timeUnit.toMicros(j), 0);
            return 0;
        } catch (Exception e) {
            handleException(mediaCodecExceptionJni, e);
            LiteavLog.e(TAG, "Feed yuv buffer to MediaCodec failed.".concat(String.valueOf(e)));
            return -1;
        } catch (Throwable th) {
            handleThrowable(mediaCodecExceptionJni, th);
            LiteavLog.e(TAG, "Feed yuv buffer to MediaCodec failed.".concat(String.valueOf(th)));
            return -1;
        }
    }

    public static int getIntFromMediaFormat(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(str);
            } catch (Throwable th) {
                LiteavLog.e(TAG, "Get %s from MediaFormat failed.".concat(String.valueOf(th)));
            }
        }
        return i;
    }

    private static void handleException(MediaCodecExceptionJni mediaCodecExceptionJni, Exception exc) {
        int errorCode;
        boolean z = false;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            mediaCodecExceptionJni.hasException = true;
            mediaCodecExceptionJni.systemErrorCode = -1;
            mediaCodecExceptionJni.isErrorRecoverable = false;
        } else {
            if (exc instanceof MediaCodec.CodecException) {
                mediaCodecExceptionJni.hasException = true;
                MediaCodec.CodecException codecException = (MediaCodec.CodecException) exc;
                errorCode = codecException.getErrorCode();
                mediaCodecExceptionJni.systemErrorCode = errorCode;
                if (codecException.isRecoverable() || codecException.isTransient()) {
                    z = true;
                }
                mediaCodecExceptionJni.isErrorRecoverable = z;
                return;
            }
            mediaCodecExceptionJni.hasException = true;
            mediaCodecExceptionJni.systemErrorCode = -1;
            mediaCodecExceptionJni.isErrorRecoverable = false;
        }
    }

    public static void handleThrowable(MediaCodecExceptionJni mediaCodecExceptionJni, Throwable th) {
        mediaCodecExceptionJni.hasException = true;
        mediaCodecExceptionJni.systemErrorCode = -2;
        mediaCodecExceptionJni.isErrorRecoverable = false;
    }

    private static boolean isSoftOnlyEncoder(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        if (LiteavSystemInfo.getSystemOSVersionInt() > 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            return isSoftwareOnly;
        }
        if (!mediaCodecInfo.getName().contains("android") && !mediaCodecInfo.getName().contains("google")) {
            return false;
        }
        return true;
    }

    public static void releaseSurface(Surface surface) {
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                LiteavLog.e(TAG, "Release surface failed.".concat(String.valueOf(th)));
            }
        }
    }

    public static void requestKeyFrame(MediaCodec mediaCodec) {
        if (LiteavSystemInfo.getSystemOSVersionInt() > 19 && mediaCodec != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                mediaCodec.setParameters(bundle);
            } catch (Throwable th) {
                LiteavLog.e(TAG, "requestSyncFrame failed.", th);
            }
        }
    }

    private static void setMaxBFramesToMediaFormat(MediaFormat mediaFormat, int i) {
        if (i > 0 && LiteavSystemInfo.getSystemOSVersionInt() >= 29) {
            mediaFormat.setInteger("max-bframes", i);
        }
    }

    public static boolean startMediaCodec(MediaCodecExceptionJni mediaCodecExceptionJni, MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.start();
                return true;
            } catch (Exception e) {
                handleException(mediaCodecExceptionJni, e);
                LiteavLog.e(TAG, "MediaCodec start failed.".concat(String.valueOf(e)));
                return false;
            } catch (Throwable th) {
                handleThrowable(mediaCodecExceptionJni, th);
                LiteavLog.e(TAG, "MediaCodec start failed.".concat(String.valueOf(th)));
                return false;
            }
        }
        return false;
    }

    public static void stopMediaCodec(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
            } catch (Throwable th) {
                LiteavLog.e(TAG, "Stop MediaCodec failed.".concat(String.valueOf(th)));
            }
        }
    }

    public static boolean updateBitrate(MediaCodec mediaCodec, int i) {
        if (mediaCodec != null && LiteavSystemInfo.getSystemOSVersionInt() >= 19) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("video-bitrate", i);
                mediaCodec.setParameters(bundle);
                return true;
            } catch (Throwable th) {
                LiteavLog.e(TAG, "update bitrate to MediaCodec failed.".concat(String.valueOf(th)));
            }
        }
        return false;
    }
}
