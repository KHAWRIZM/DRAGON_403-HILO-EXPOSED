package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.core.view.p1;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class e {
    public static void a(Window window, boolean z10, Integer num, Integer num2) {
        boolean z11;
        boolean z12 = false;
        if (num != null && num.intValue() != 0) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (num2 == null || num2.intValue() == 0) {
            z12 = true;
        }
        if (z11 || z12) {
            int b10 = v7.a.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z11) {
                num = Integer.valueOf(b10);
            }
            if (z12) {
                num2 = Integer.valueOf(b10);
            }
        }
        p1.b(window, !z10);
        int c10 = c(window.getContext(), z10);
        int b11 = b(window.getContext(), z10);
        window.setStatusBarColor(c10);
        window.setNavigationBarColor(b11);
        f(window, d(c10, v7.a.i(num.intValue())));
        e(window, d(b11, v7.a.i(num2.intValue())));
    }

    private static int b(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 27) {
            return androidx.core.graphics.x.l(v7.a.b(context, R.attr.navigationBarColor, -16777216), 128);
        }
        if (z10) {
            return 0;
        }
        return v7.a.b(context, R.attr.navigationBarColor, -16777216);
    }

    private static int c(Context context, boolean z10) {
        if (z10 && Build.VERSION.SDK_INT < 23) {
            return androidx.core.graphics.x.l(v7.a.b(context, R.attr.statusBarColor, -16777216), 128);
        }
        if (z10) {
            return 0;
        }
        return v7.a.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i10, boolean z10) {
        if (!v7.a.i(i10) && (i10 != 0 || !z10)) {
            return false;
        }
        return true;
    }

    public static void e(Window window, boolean z10) {
        p1.a(window, window.getDecorView()).c(z10);
    }

    public static void f(Window window, boolean z10) {
        p1.a(window, window.getDecorView()).d(z10);
    }
}
