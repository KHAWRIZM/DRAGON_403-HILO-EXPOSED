package com.qiahao.nextvideo.utilities;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.view.g3;
import androidx.core.view.w0;
import androidx.core.view.w2;
import androidx.core.view.x2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"setSystemBarsVisibility", "", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/app/Activity;", "showStatusBar", "", "showNavBar", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivityUtilKt {
    public static final void setSystemBarsVisibility(@NotNull Activity activity, boolean z, boolean z2) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController a = g3.a(window);
            if (a != null) {
                if (z) {
                    androidx.core.view.t0.a(a, w2.a());
                } else {
                    w0.a(a, w2.a());
                }
                if (z2) {
                    androidx.core.view.t0.a(a, x2.a());
                    return;
                } else {
                    w0.a(a, x2.a());
                    return;
                }
            }
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z) {
            i = systemUiVisibility & (-5);
        } else {
            i = systemUiVisibility | 4;
        }
        if (z2) {
            i2 = i & (-3);
        } else {
            i2 = i | 2;
        }
        window.getDecorView().setSystemUiVisibility(i2);
    }
}
