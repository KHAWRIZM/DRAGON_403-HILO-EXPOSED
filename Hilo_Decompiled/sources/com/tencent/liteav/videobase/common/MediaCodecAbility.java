package com.tencent.liteav.videobase.common;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Range;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.qgame.animplayer.util.MediaUtil;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class MediaCodecAbility {
    private static final String TAG = "MediaCodecAbility";

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0067, code lost:
    
        if (r1 == null) goto L٢٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getMediaCodecDecoderSupportLowResolution() {
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        int i = 0;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return 0;
        }
        MediaCodec mediaCodec = null;
        try {
            mediaCodec = MediaCodec.createDecoderByType("video/avc");
            capabilitiesForType = mediaCodec.getCodecInfo().getCapabilitiesForType("video/avc");
        } catch (Throwable th) {
            try {
                LiteavLog.e(TAG, "get low resolution error:".concat(String.valueOf(th)));
            } catch (Throwable th2) {
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw th2;
            }
        }
        if (capabilitiesForType == null) {
            mediaCodec.release();
            return 0;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
        if (videoCapabilities == null) {
            mediaCodec.release();
            return 0;
        }
        Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
        Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
        if (supportedWidths != null && supportedHeights != null) {
            i = Math.max(supportedWidths.getLower().intValue(), supportedHeights.getLower().intValue());
            mediaCodec.release();
            return i;
        }
        mediaCodec.release();
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        com.tencent.liteav.base.util.LiteavLog.i(com.tencent.liteav.videobase.common.MediaCodecAbility.TAG, "got hevc decoder:%s", r7.getName());
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0042, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isDecoderSupportHevc() {
        boolean z = true;
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
            int length = codecInfos.length;
            boolean z2 = false;
            for (int i = 0; i < length; i++) {
                try {
                    MediaCodecInfo mediaCodecInfo = codecInfos[i];
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    if (!mediaCodecInfo.isEncoder()) {
                        int length2 = supportedTypes.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length2) {
                                break;
                            }
                            if (supportedTypes[i2].contains(MediaUtil.MIME_HEVC)) {
                                try {
                                    break;
                                } catch (Throwable th) {
                                    th = th;
                                    LiteavLog.e(TAG, "get hevc decode error:".concat(String.valueOf(th)));
                                    return z;
                                }
                            }
                            i2++;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    z = z2;
                }
            }
            return z2;
        } catch (Throwable th3) {
            th = th3;
            z = false;
        }
    }

    public static boolean isEncoderSupportHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
                if (mediaCodecInfo.isEncoder()) {
                    for (String str : mediaCodecInfo.getSupportedTypes()) {
                        if (str.contains(MediaUtil.MIME_HEVC)) {
                            LiteavLog.i(TAG, "get hevc encoder");
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            LiteavLog.w(TAG, "failed to get hevc encoder:".concat(String.valueOf(th)));
        }
        LiteavLog.w(TAG, "not got hevc encoder");
        return false;
    }

    public static boolean isMediaCodecDecodeSupportSWHevc() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
            return false;
        }
        try {
            for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (!mediaCodecInfo.isEncoder()) {
                    for (String str : supportedTypes) {
                        if (str.contains(MediaUtil.MIME_HEVC) && isSoftOnlyDecoder(mediaCodecInfo)) {
                            LiteavLog.i(TAG, "got soft only hevc decoder:%s", mediaCodecInfo.getName());
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable th) {
            LiteavLog.e(TAG, "get hevc decode error:".concat(String.valueOf(th)));
        }
        return false;
    }

    public static boolean isSoftOnlyDecoder(MediaCodecInfo mediaCodecInfo) {
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
}
