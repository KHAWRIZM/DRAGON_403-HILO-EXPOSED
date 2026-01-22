package com.luck.picture.lib.immersive;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.d1;
import com.luck.picture.lib.utils.DensityUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ImmersiveManager {
    private static final String TAG_FAKE_STATUS_BAR_VIEW = "TAG_FAKE_STATUS_BAR_VIEW";
    private static final String TAG_MARGIN_ADDED = "TAG_MARGIN_ADDED";
    private static final String TAG_NAVIGATION_BAR_VIEW = "TAG_NAVIGATION_BAR_VIEW";

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int i10, int i11, boolean z10) {
        immersiveAboveAPI23(appCompatActivity, false, false, i10, i11, z10);
    }

    private static void initBarBelowLOLLIPOP(Activity activity) {
        Window window = activity.getWindow();
        window.addFlags(67108864);
        setupStatusBarView(activity);
        if (DensityUtil.isNavBarVisible(activity)) {
            window.addFlags(134217728);
            setupNavBarView(activity);
        }
    }

    private static void setupNavBarView(Activity activity) {
        FrameLayout.LayoutParams layoutParams;
        Window window = activity.getWindow();
        View findViewWithTag = window.getDecorView().findViewWithTag(TAG_NAVIGATION_BAR_VIEW);
        if (findViewWithTag == null) {
            findViewWithTag = new View(activity);
            findViewWithTag.setTag(TAG_NAVIGATION_BAR_VIEW);
            ((ViewGroup) window.getDecorView()).addView(findViewWithTag);
        }
        if (DensityUtil.isNavigationAtBottom(activity)) {
            layoutParams = new FrameLayout.LayoutParams(-1, DensityUtil.getNavigationBarHeight(activity));
            layoutParams.gravity = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(DensityUtil.getNavigationBarWidth(activity), -1);
            layoutParams.gravity = 8388613;
        }
        findViewWithTag.setLayoutParams(layoutParams);
        findViewWithTag.setBackgroundColor(0);
        findViewWithTag.setVisibility(0);
    }

    private static void setupStatusBarView(Activity activity) {
        Window window = activity.getWindow();
        View findViewWithTag = window.getDecorView().findViewWithTag(TAG_FAKE_STATUS_BAR_VIEW);
        if (findViewWithTag == null) {
            findViewWithTag = new View(activity);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DensityUtil.getStatusBarHeight(activity));
            layoutParams.gravity = 48;
            findViewWithTag.setLayoutParams(layoutParams);
            findViewWithTag.setVisibility(0);
            findViewWithTag.setTag(TAG_MARGIN_ADDED);
            ((ViewGroup) window.getDecorView()).addView(findViewWithTag);
        }
        findViewWithTag.setBackgroundColor(0);
    }

    public static void translucentStatusBar(Activity activity, boolean z10) {
        Window window = activity.getWindow();
        int i10 = Build.VERSION.SDK_INT;
        window.addFlags(Integer.MIN_VALUE);
        window.clearFlags(67108864);
        window.setStatusBarColor(0);
        View decorView = window.getDecorView();
        if (i10 >= 23) {
            if (z10) {
                decorView.setSystemUiVisibility(9472);
            } else {
                window.getDecorView().setSystemUiVisibility(1280);
            }
        } else if (z10) {
            initBarBelowLOLLIPOP(activity);
        } else {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        View childAt = ((ViewGroup) window.findViewById(R.id.content)).getChildAt(0);
        if (childAt != null) {
            childAt.setFitsSystemWindows(false);
            d1.n0(childAt);
        }
    }

    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean z10, boolean z11, int i10, int i11, boolean z12) {
        try {
            Window window = appCompatActivity.getWindow();
            int i12 = Build.VERSION.SDK_INT;
            boolean z13 = true;
            if (z10 && z11) {
                window.clearFlags(201326592);
                LightStatusBarUtils.setLightStatusBar(appCompatActivity, true, true, i10 == 0, z12);
                window.addFlags(Integer.MIN_VALUE);
            } else if (z10 || z11) {
                if (z10) {
                    return;
                }
                window.requestFeature(1);
                window.clearFlags(201326592);
                LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, true, i10 == 0, z12);
                window.addFlags(Integer.MIN_VALUE);
            } else if (i12 < 23 && z12) {
                initBarBelowLOLLIPOP(appCompatActivity);
            } else {
                window.requestFeature(1);
                window.clearFlags(201326592);
                if (i10 != 0) {
                    z13 = false;
                }
                LightStatusBarUtils.setLightStatusBar(appCompatActivity, false, false, z13, z12);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setStatusBarColor(i10);
            window.setNavigationBarColor(i11);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
