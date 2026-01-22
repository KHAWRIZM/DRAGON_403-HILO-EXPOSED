package c8;

import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import com.google.android.material.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static TypedValue a(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean b(Context context, int i10, boolean z10) {
        TypedValue a10 = a(context, i10);
        if (a10 != null && a10.type == 18) {
            if (a10.data != 0) {
                return true;
            }
            return false;
        }
        return z10;
    }

    public static int c(Context context, int i10, int i11) {
        float dimension;
        TypedValue a10 = a(context, i10);
        if (a10 != null && a10.type == 5) {
            dimension = a10.getDimension(context.getResources().getDisplayMetrics());
        } else {
            dimension = context.getResources().getDimension(i11);
        }
        return (int) dimension;
    }

    public static int d(Context context, int i10, int i11) {
        TypedValue a10 = a(context, i10);
        if (a10 != null && a10.type == 16) {
            return a10.data;
        }
        return i11;
    }

    public static int e(Context context) {
        return c(context, R.attr.minTouchTargetSize, R.dimen.mtrl_min_touch_target_size);
    }

    public static int f(Context context, int i10, String str) {
        return g(context, i10, str).data;
    }

    public static TypedValue g(Context context, int i10, String str) {
        TypedValue a10 = a(context, i10);
        if (a10 != null) {
            return a10;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i10)));
    }

    public static TypedValue h(View view, int i10) {
        return g(view.getContext(), i10, view.getClass().getCanonicalName());
    }
}
