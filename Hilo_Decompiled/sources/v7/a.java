package v7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.x;
import c8.b;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static int a(int i10, int i11) {
        return x.l(i10, (Color.alpha(i10) * i11) / KotlinVersion.MAX_COMPONENT_VALUE);
    }

    public static int b(Context context, int i10, int i11) {
        Integer f10 = f(context, i10);
        if (f10 != null) {
            return f10.intValue();
        }
        return i11;
    }

    public static int c(Context context, int i10, String str) {
        return m(context, b.g(context, i10, str));
    }

    public static int d(View view, int i10) {
        return m(view.getContext(), b.h(view, i10));
    }

    public static int e(View view, int i10, int i11) {
        return b(view.getContext(), i10, i11);
    }

    public static Integer f(Context context, int i10) {
        TypedValue a10 = b.a(context, i10);
        if (a10 != null) {
            return Integer.valueOf(m(context, a10));
        }
        return null;
    }

    public static ColorStateList g(Context context, int i10, ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        TypedValue a10 = b.a(context, i10);
        if (a10 != null) {
            colorStateList2 = n(context, a10);
        } else {
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        return colorStateList;
    }

    public static ColorStateList h(Context context, int i10) {
        TypedValue a10 = b.a(context, i10);
        if (a10 == null) {
            return null;
        }
        int i11 = a10.resourceId;
        if (i11 != 0) {
            return androidx.core.content.a.getColorStateList(context, i11);
        }
        int i12 = a10.data;
        if (i12 == 0) {
            return null;
        }
        return ColorStateList.valueOf(i12);
    }

    public static boolean i(int i10) {
        if (i10 != 0 && x.d(i10) > 0.5d) {
            return true;
        }
        return false;
    }

    public static int j(int i10, int i11) {
        return x.g(i11, i10);
    }

    public static int k(int i10, int i11, float f10) {
        return j(i10, x.l(i11, Math.round(Color.alpha(i11) * f10)));
    }

    public static int l(View view, int i10, int i11, float f10) {
        return k(d(view, i10), d(view, i11), f10);
    }

    private static int m(Context context, TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        if (i10 != 0) {
            return androidx.core.content.a.getColor(context, i10);
        }
        return typedValue.data;
    }

    private static ColorStateList n(Context context, TypedValue typedValue) {
        int i10 = typedValue.resourceId;
        if (i10 != 0) {
            return androidx.core.content.a.getColorStateList(context, i10);
        }
        return ColorStateList.valueOf(typedValue.data);
    }
}
