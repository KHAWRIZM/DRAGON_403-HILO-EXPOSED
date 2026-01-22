package com.tencent.qcloud.tuicore.util;

import android.graphics.Rect;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.tencent.qcloud.tuicore.TUIConfig;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SoftKeyBoardUtil {
    private static int getNavigateBarHeight(WindowManager windowManager) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            return i2 - i;
        }
        return 0;
    }

    public static void hideKeyBoard(IBinder iBinder) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(iBinder, 0);
        }
    }

    private static boolean isSoftInputShown(Window window) {
        View decorView = window.getDecorView();
        int height = decorView.getHeight();
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        if ((height - rect.bottom) - getNavigateBarHeight(window.getWindowManager()) >= 0) {
            return true;
        }
        return false;
    }

    public static void showKeyBoard(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager != null && !isSoftInputShown(window)) {
            inputMethodManager.toggleSoftInput(0, 0);
        }
    }

    public static void hideKeyBoard(Window window) {
        InputMethodManager inputMethodManager = (InputMethodManager) TUIConfig.getAppContext().getSystemService("input_method");
        if (inputMethodManager == null || !isSoftInputShown(window)) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 0);
    }
}
