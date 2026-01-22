package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal f١٥٩٩a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    static final int[] f١٦٠٠b = {-16842910};

    /* renamed from: c, reason: collision with root package name */
    static final int[] f١٦٠١c = {R.attr.state_focused};

    /* renamed from: d, reason: collision with root package name */
    static final int[] f١٦٠٢d = {R.attr.state_activated};

    /* renamed from: e, reason: collision with root package name */
    static final int[] f١٦٠٣e = {R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final int[] f١٦٠٤f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    static final int[] f١٦٠٥g = {R.attr.state_selected};

    /* renamed from: h, reason: collision with root package name */
    static final int[] f١٦٠٦h = {-16842919, -16842908};

    /* renamed from: i, reason: collision with root package name */
    static final int[] f١٦٠٧i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f١٦٠٨j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i10) {
        ColorStateList e10 = e(context, i10);
        if (e10 != null && e10.isStateful()) {
            return e10.getColorForState(f١٦٠٠b, e10.getDefaultColor());
        }
        TypedValue f10 = f();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, f10, true);
        return d(context, i10, f10.getFloat());
    }

    public static int c(Context context, int i10) {
        int[] iArr = f١٦٠٨j;
        iArr[0] = i10;
        p0 u10 = p0.u(context, null, iArr);
        try {
            return u10.b(0, 0);
        } finally {
            u10.x();
        }
    }

    static int d(Context context, int i10, float f10) {
        return androidx.core.graphics.x.l(c(context, i10), Math.round(Color.alpha(r0) * f10));
    }

    public static ColorStateList e(Context context, int i10) {
        int[] iArr = f١٦٠٨j;
        iArr[0] = i10;
        p0 u10 = p0.u(context, null, iArr);
        try {
            return u10.c(0);
        } finally {
            u10.x();
        }
    }

    private static TypedValue f() {
        ThreadLocal threadLocal = f١٥٩٩a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }
}
