package f8;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.k0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class j {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                return b();
            }
            return new f();
        }
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        return new n();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g c() {
        return new g();
    }

    public static void d(View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            ((i) background).g0(f10);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof i) {
            f(view, (i) background);
        }
    }

    public static void f(View view, i iVar) {
        if (iVar.X()) {
            iVar.l0(k0.k(view));
        }
    }
}
