package com.luck.picture.lib.utils;

import android.os.Build;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SdkVersionUtils {
    public static boolean isMaxN() {
        if (Build.VERSION.SDK_INT >= 24) {
            return true;
        }
        return false;
    }

    public static boolean isMinM() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return false;
    }

    public static boolean isN() {
        if (Build.VERSION.SDK_INT == 24) {
            return true;
        }
        return false;
    }

    public static boolean isO() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static boolean isP() {
        if (Build.VERSION.SDK_INT >= 28) {
            return true;
        }
        return false;
    }

    public static boolean isQ() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return false;
    }

    public static boolean isR() {
        if (Build.VERSION.SDK_INT >= 30) {
            return true;
        }
        return false;
    }

    public static boolean isTIRAMISU() {
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }

    public static boolean isUPSIDE_DOWN_CAKE() {
        if (Build.VERSION.SDK_INT >= 34) {
            return true;
        }
        return false;
    }
}
