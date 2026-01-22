package com.amazonaws.mobile.auth.core.signin.ui;

import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.DisplayMetrics;
import io.agora.rtc.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DisplayUtils {
    private static int dpMultiplier;
    private static final DisplayMetrics metrics;

    static {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        metrics = displayMetrics;
        dpMultiplier = displayMetrics.densityDpi / Constants.ERR_ALREADY_IN_RECORDING;
    }

    public static int dp(int i10) {
        return i10 * dpMultiplier;
    }

    public static ShapeDrawable getRoundedRectangleBackground(int i10, int i11) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(getRoundedRectangleShape(i10));
        shapeDrawable.getPaint().setColor(i11);
        return shapeDrawable;
    }

    public static Shape getRoundedRectangleShape(int i10) {
        float f10 = i10;
        return new RoundRectShape(new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, null, null);
    }
}
