package io.agora.rtc.audio;

import android.content.Context;
import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class HardwareEarbackController {
    private static HardwareEarbackController mInstance;
    private final String TAG = "HardwareEarbackController Java";
    private IHardwareEarback mHardwareEarback;

    private HardwareEarbackController(Context context) {
        this.mHardwareEarback = null;
        String str = Build.MANUFACTURER;
        if (!str.trim().contains("vivo")) {
            if (str.trim().contains("HUAWEI") && HuaweiHardwareEarback.hasHwAudioKitClass()) {
                this.mHardwareEarback = new HuaweiHardwareEarback(context);
            } else if (str.trim().contains("OPPO") && OppoHardwareEarback.hasMediaUnitClass()) {
                this.mHardwareEarback = new OppoHardwareEarback(context);
            }
        }
    }

    public static HardwareEarbackController getInstance(Context context) {
        if (mInstance == null) {
            synchronized (HardwareEarbackController.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new HardwareEarbackController(context);
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public int enableHardwareEarback(boolean z10) {
        IHardwareEarback iHardwareEarback = this.mHardwareEarback;
        if (iHardwareEarback != null) {
            return iHardwareEarback.enableEarbackFeature(z10);
        }
        return -7;
    }

    public boolean isHardwareEarbackSupported() {
        IHardwareEarback iHardwareEarback = this.mHardwareEarback;
        if (iHardwareEarback != null) {
            return iHardwareEarback.isHardwareEarbackSupported();
        }
        return false;
    }

    public int setHardwareEarbackVolume(int i10) {
        IHardwareEarback iHardwareEarback = this.mHardwareEarback;
        if (iHardwareEarback != null) {
            return iHardwareEarback.setHardwareEarbackVolume(i10);
        }
        return -7;
    }
}
