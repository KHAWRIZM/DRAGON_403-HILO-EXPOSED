package com.tencent.liteav.videobase.common;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.l;
import com.tencent.qgame.animplayer.util.MediaUtil;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class HDRCapability {
    private static final String TAG = "HDRCapability";
    private static Boolean sIsHDR10Supported;
    private static final l sSequenceTaskRunner = new l();

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkIsHDR10Supported() {
        boolean z;
        synchronized (HDRCapability.class) {
            try {
                if (sIsHDR10Supported != null) {
                    return;
                }
                try {
                    boolean isDisplaySupportHDR10 = isDisplaySupportHDR10();
                    boolean isDecoderSupportHDR10 = isDecoderSupportHDR10();
                    synchronized (HDRCapability.class) {
                        if (isDisplaySupportHDR10 && isDecoderSupportHDR10) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Boolean valueOf = Boolean.valueOf(z);
                        sIsHDR10Supported = valueOf;
                        LiteavLog.i(TAG, "the device supports hdr10 %b", valueOf);
                    }
                } catch (Throwable th) {
                    LiteavLog.e(TAG, "check hdr capability error ", th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static boolean hasHDR10ProfileLevel(MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr) {
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == 4096) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDecoderSupportHDR10() {
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            for (String str : mediaCodecInfo.getSupportedTypes()) {
                if (str.contains(MediaUtil.MIME_HEVC) && hasHDR10ProfileLevel(mediaCodecInfo.getCapabilitiesForType(MediaUtil.MIME_HEVC).profileLevels)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        r0 = r0.getDefaultDisplay().getHdrCapabilities();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isDisplaySupportHDR10() {
        Display.HdrCapabilities hdrCapabilities;
        int[] supportedHdrTypes;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext != null && (r0 = (WindowManager) applicationContext.getSystemService("window")) != null && hdrCapabilities != null) {
            supportedHdrTypes = hdrCapabilities.getSupportedHdrTypes();
            for (int i : supportedHdrTypes) {
                if (i == 2) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static synchronized boolean isHDRSupported(int i) {
        synchronized (HDRCapability.class) {
            if (LiteavSystemInfo.getSystemOSVersionInt() < 24) {
                return false;
            }
            if (i != b.HDR10.mValue) {
                return false;
            }
            Boolean bool = sIsHDR10Supported;
            if (bool != null) {
                return bool.booleanValue();
            }
            sSequenceTaskRunner.a(a.a());
            return false;
        }
    }
}
