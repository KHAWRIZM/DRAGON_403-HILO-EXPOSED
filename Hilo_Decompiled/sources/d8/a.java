package d8;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.core.graphics.x;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f١٣٦٥٤a = {R.attr.state_pressed};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f١٣٦٥٥b = {R.attr.state_focused};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f١٣٦٥٦c = {R.attr.state_selected, R.attr.state_pressed};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f١٣٦٥٧d = {R.attr.state_selected};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f١٣٦٥٨e = {R.attr.state_enabled, R.attr.state_pressed};

    /* renamed from: f, reason: collision with root package name */
    static final String f١٣٦٥٩f = a.class.getSimpleName();

    /* renamed from: d8.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class C٠١٥٢a {
        /* JADX INFO: Access modifiers changed from: private */
        public static Drawable b(Context context, int i10) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(v7.a.g(context, androidx.appcompat.R.attr.colorControlHighlight, ColorStateList.valueOf(0)), null, new InsetDrawable((Drawable) gradientDrawable, i10, i10, i10, i10));
        }
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        int[] iArr = f١٣٦٥٥b;
        return new ColorStateList(new int[][]{f١٣٦٥٧d, iArr, StateSet.NOTHING}, new int[]{d(colorStateList, f١٣٦٥٦c), d(colorStateList, iArr), d(colorStateList, f١٣٦٥٤a)});
    }

    public static Drawable b(Context context, int i10) {
        return C٠١٥٢a.b(context, i10);
    }

    private static int c(int i10) {
        return x.l(i10, Math.min(Color.alpha(i10) * 2, KotlinVersion.MAX_COMPONENT_VALUE));
    }

    private static int d(ColorStateList colorStateList, int[] iArr) {
        int i10;
        if (colorStateList != null) {
            i10 = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        } else {
            i10 = 0;
        }
        return c(i10);
    }

    public static ColorStateList e(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f١٣٦٥٨e, 0)) != 0) {
                Log.w(f١٣٦٥٩f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
            }
            return colorStateList;
        }
        return ColorStateList.valueOf(0);
    }

    public static boolean f(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        if (!z10 || !z11) {
            return false;
        }
        return true;
    }
}
