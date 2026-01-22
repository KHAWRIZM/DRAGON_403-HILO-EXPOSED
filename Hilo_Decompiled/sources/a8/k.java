package a8;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.d0;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import v2.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class k {
    private static float a(String[] strArr, int i10) {
        float parseFloat = Float.parseFloat(strArr[i10]);
        if (parseFloat >= DownloadProgress.UNKNOWN_PROGRESS && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static TimeInterpolator c(String str) {
        if (e(str, "cubic-bezier")) {
            String[] split = b(str, "cubic-bezier").split(",");
            if (split.length == 4) {
                return new PathInterpolator(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        }
        if (e(str, "path")) {
            return new PathInterpolator(d0.e(b(str, "path")));
        }
        throw new IllegalArgumentException("Invalid motion easing type: " + str);
    }

    private static boolean d(String str) {
        if (!e(str, "cubic-bezier") && !e(str, "path")) {
            return false;
        }
        return true;
    }

    private static boolean e(String str, String str2) {
        if (str.startsWith(str2 + "(") && str.endsWith(")")) {
            return true;
        }
        return false;
    }

    public static int f(Context context, int i10, int i11) {
        return c8.b.d(context, i10, i11);
    }

    public static TimeInterpolator g(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (d(valueOf)) {
                return c(valueOf);
            }
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }

    public static m h(Context context, int i10, int i11) {
        TypedArray obtainStyledAttributes;
        TypedValue a10 = c8.b.a(context, i10);
        if (a10 == null) {
            obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialSpring, 0, i11);
        } else {
            obtainStyledAttributes = context.obtainStyledAttributes(a10.resourceId, R.styleable.MaterialSpring);
        }
        m mVar = new m();
        try {
            float f10 = obtainStyledAttributes.getFloat(R.styleable.MaterialSpring_stiffness, Float.MIN_VALUE);
            if (f10 != Float.MIN_VALUE) {
                float f11 = obtainStyledAttributes.getFloat(R.styleable.MaterialSpring_damping, Float.MIN_VALUE);
                if (f11 != Float.MIN_VALUE) {
                    mVar.h(f10);
                    mVar.f(f11);
                    return mVar;
                }
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
