package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f٤٢٩٤a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Field f٤٢٩٥b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f٤٢٩٦c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static float a(View view) {
            float transitionAlpha;
            transitionAlpha = view.getTransitionAlpha();
            return transitionAlpha;
        }

        static void b(View view, float f10) {
            view.setTransitionAlpha(f10);
        }
    }

    public void a(View view) {
    }

    public float b(View view) {
        if (f٤٢٩٤a) {
            try {
                return a.a(view);
            } catch (NoSuchMethodError unused) {
                f٤٢٩٤a = false;
            }
        }
        return view.getAlpha();
    }

    public void c(View view) {
    }

    public abstract void d(View view, int i10, int i11, int i12, int i13);

    public void e(View view, float f10) {
        if (f٤٢٩٤a) {
            try {
                a.b(view, f10);
                return;
            } catch (NoSuchMethodError unused) {
                f٤٢٩٤a = false;
            }
        }
        view.setAlpha(f10);
    }

    public void f(View view, int i10) {
        if (!f٤٢٩٦c) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f٤٢٩٥b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f٤٢٩٦c = true;
        }
        Field field = f٤٢٩٥b;
        if (field != null) {
            try {
                f٤٢٩٥b.setInt(view, i10 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void g(View view, Matrix matrix);

    public abstract void h(View view, Matrix matrix);
}
