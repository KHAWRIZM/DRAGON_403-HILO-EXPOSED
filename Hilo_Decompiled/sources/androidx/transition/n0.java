package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class n0 extends j0 {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f٤٣٤٩d = true;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f٤٣٥٠e = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static void a(View view, Matrix matrix) {
            view.setAnimationMatrix(matrix);
        }

        static void b(View view, Matrix matrix) {
            view.transformMatrixToGlobal(matrix);
        }

        static void c(View view, Matrix matrix) {
            view.transformMatrixToLocal(matrix);
        }
    }

    @Override // androidx.transition.j0
    public void g(View view, Matrix matrix) {
        if (f٤٣٤٩d) {
            try {
                a.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f٤٣٤٩d = false;
            }
        }
    }

    @Override // androidx.transition.j0
    public void h(View view, Matrix matrix) {
        if (f٤٣٥٠e) {
            try {
                a.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f٤٣٥٠e = false;
            }
        }
    }
}
