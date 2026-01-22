package com.oudi.utils;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0010\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005¨\u0006\f"}, d2 = {"getStatusBarHeight", "", "translucentStatusBar", "", "activity", "Landroid/app/Activity;", "setLightTranslucentStatusBar", "setLightStatusBar", "setDarkTranslucentStatusBar", "setDarkStatusBar", "isNavigationBarExist", "", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BarUtilsKt {
    public static final int getStatusBarHeight() {
        int identifier = AppUtils.getApp().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return AppUtils.getApp().getResources().getDimensionPixelSize(identifier);
        }
        return -1;
    }

    public static final boolean isNavigationBarExist(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) decorView;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            viewGroup.getChildAt(i10).getContext().getPackageName();
            if (viewGroup.getChildAt(i10).getId() != -1 && Intrinsics.areEqual("navigationBarBackground", activity.getResources().getResourceEntryName(viewGroup.getChildAt(i10).getId()))) {
                return true;
            }
        }
        return false;
    }

    public static final void setDarkStatusBar(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(0);
        window.setStatusBarColor(-16777216);
    }

    public static final void setDarkTranslucentStatusBar(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(1024);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public static final void setLightStatusBar(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        int i10 = Build.VERSION.SDK_INT;
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(0);
        if (i10 >= 23) {
            window.getDecorView().setSystemUiVisibility(8192);
        }
        window.setStatusBarColor(-1);
    }

    public static final void setLightTranslucentStatusBar(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        int i10 = Build.VERSION.SDK_INT;
        window.clearFlags(67108864);
        if (i10 >= 23) {
            window.getDecorView().setSystemUiVisibility(9216);
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public static final void translucentStatusBar(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= 23) {
            window.addFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1024);
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
            window.setStatusBarColor(0);
        }
    }
}
