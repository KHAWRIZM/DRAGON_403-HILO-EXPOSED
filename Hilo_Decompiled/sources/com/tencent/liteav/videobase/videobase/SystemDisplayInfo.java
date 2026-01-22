package com.tencent.liteav.videobase.videobase;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.qiahao.nextvideo.ui.profile.report.SuperAdminReportActivity;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.base.util.k;

@JNINamespace("liteav::video")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SystemDisplayInfo {
    private static final String TAG = "SystemDisplayInfo";

    private static Display getDefaultDisplayByWindowManager() {
        return getDefaultDisplayByWindowManager(ContextUtils.getApplicationContext());
    }

    public static Display getDisplay() {
        if (nativeGetDisplayRotationObtainMethod() == 0) {
            return getDisplayByDisplayManager();
        }
        Display defaultDisplayByWindowManager = getDefaultDisplayByWindowManager();
        if (defaultDisplayByWindowManager != null) {
            return defaultDisplayByWindowManager;
        }
        return getDisplayByDisplayManager();
    }

    private static Display getDisplayByDisplayManager() {
        Context c = i.a().c();
        if (c == null) {
            c = ContextUtils.getApplicationContext();
        }
        if (c == null) {
            LiteavLog.e(TAG, "context is null.");
            return null;
        }
        if (LiteavSystemInfo.getSystemOSVersionInt() < 32) {
            return getDefaultDisplayByWindowManager(c);
        }
        try {
            return ((DisplayManager) c.getSystemService("display")).getDisplay(0);
        } catch (Throwable th) {
            LiteavLog.e(TAG, "error getting display from display service.", th);
            return getDefaultDisplayByWindowManager(c);
        }
    }

    public static k getDisplayRotation() {
        k displayRotationCorrection = getDisplayRotationCorrection();
        if (displayRotationCorrection != null) {
            return displayRotationCorrection;
        }
        try {
            Display display = getDisplay();
            if (display != null) {
                return surfaceRotationEnumToRotation(display.getRotation());
            }
        } catch (Exception e) {
            LiteavLog.e(TAG, "error getting display rotation.", e);
        }
        return k.NORMAL;
    }

    private static k getDisplayRotationCorrection() {
        int nativeGetDisplayRotationCorrection = nativeGetDisplayRotationCorrection();
        if (k.b(nativeGetDisplayRotationCorrection)) {
            return k.a(nativeGetDisplayRotationCorrection);
        }
        return null;
    }

    public static int getDisplayRotationDegree() {
        return getDisplayRotation().mValue;
    }

    public static Size getDisplaySize() {
        try {
            Display display = getDisplay();
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e) {
            LiteavLog.e(TAG, "error getting display size.", e);
        }
        return new Size(SuperAdminReportActivity.THIRTY_DAY, 1280);
    }

    private static native synchronized int nativeGetDisplayRotationCorrection();

    private static native synchronized int nativeGetDisplayRotationObtainMethod();

    private static k surfaceRotationEnumToRotation(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return k.NORMAL;
                }
                return k.ROTATION_270;
            }
            return k.ROTATION_180;
        }
        return k.ROTATION_90;
    }

    private static Display getDefaultDisplayByWindowManager(Context context) {
        if (context == null) {
            LiteavLog.e(TAG, "context is null.");
            return null;
        }
        try {
            return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        } catch (Throwable th) {
            LiteavLog.e(TAG, "error getting display from window service.", th);
            return null;
        }
    }
}
