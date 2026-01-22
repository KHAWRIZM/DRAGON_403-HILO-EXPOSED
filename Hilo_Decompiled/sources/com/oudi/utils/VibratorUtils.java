package com.oudi.utils;

import android.app.Application;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lcom/oudi/utils/VibratorUtils;", "", "<init>", "()V", "vibrator", "", "milliseconds", "", "amplitude", "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class VibratorUtils {
    public static final VibratorUtils INSTANCE = new VibratorUtils();

    private VibratorUtils() {
    }

    public static /* synthetic */ void vibrator$default(VibratorUtils vibratorUtils, long j10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = -1;
        }
        vibratorUtils.vibrator(j10, i10);
    }

    public final void vibrator(long milliseconds, int amplitude) {
        Object obj;
        VibrationEffect createOneShot;
        Application app = AppUtils.getApp();
        Vibrator vibrator = null;
        if (app != null) {
            obj = app.getSystemService("vibrator");
        } else {
            obj = null;
        }
        if (obj instanceof Vibrator) {
            vibrator = (Vibrator) obj;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (vibrator != null) {
                createOneShot = VibrationEffect.createOneShot(milliseconds, amplitude);
                vibrator.vibrate(createOneShot);
                return;
            }
            return;
        }
        if (vibrator != null) {
            vibrator.vibrate(milliseconds);
        }
    }
}
