package dc;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.qmuiteam.qmui.R;
import dc.e;
import ic.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static f f١٣٦٦٨a = f.a();

    public static int a(View view, int i10) {
        return i.c(d(view), i10);
    }

    public static ColorStateList b(View view, int i10) {
        return i.d(view.getContext(), d(view), i10);
    }

    public static Drawable c(View view, int i10) {
        return i.g(view.getContext(), d(view), i10);
    }

    public static Resources.Theme d(View view) {
        e.g i10 = e.i(view);
        if (i10 != null && i10.f١٣٦٨٩b >= 0) {
            return e.j(i10.f١٣٦٨٨a, view.getContext()).h(i10.f١٣٦٨٩b);
        }
        return view.getContext().getTheme();
    }

    public static void e(View view) {
        e.g i10 = e.i(view);
        if (i10 != null) {
            e.j(i10.f١٣٦٨٨a, view.getContext()).l(view, i10.f١٣٦٨٩b);
        }
    }

    public static void f(View view, fc.a aVar) {
        view.setTag(R.id.qmui_skin_default_attr_provider, aVar);
    }

    public static void g(View view, f fVar) {
        h(view, fVar.c());
    }

    public static void h(View view, String str) {
        view.setTag(R.id.qmui_skin_value, str);
        e(view);
    }

    public static void i(View view, String str) {
        yb.b.c("QMUISkinManager", view.getClass().getSimpleName() + " does't support " + str, new Object[0]);
    }
}
