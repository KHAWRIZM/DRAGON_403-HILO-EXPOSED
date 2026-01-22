package com.facebook.rebound.ui;

import android.content.res.Resources;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class Util {
    public static final FrameLayout.LayoutParams createLayoutParams(int i10, int i11) {
        return new FrameLayout.LayoutParams(i10, i11);
    }

    public static final FrameLayout.LayoutParams createMatchParams() {
        return createLayoutParams(-1, -1);
    }

    public static final FrameLayout.LayoutParams createMatchWrapParams() {
        return createLayoutParams(-1, -2);
    }

    public static final FrameLayout.LayoutParams createWrapMatchParams() {
        return createLayoutParams(-2, -1);
    }

    public static final FrameLayout.LayoutParams createWrapParams() {
        return createLayoutParams(-2, -2);
    }

    public static final int dpToPx(float f10, Resources resources) {
        return (int) TypedValue.applyDimension(1, f10, resources.getDisplayMetrics());
    }
}
