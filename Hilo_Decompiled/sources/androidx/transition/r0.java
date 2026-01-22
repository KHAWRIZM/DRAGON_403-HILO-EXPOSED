package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class r0 extends p0 {

    /* renamed from: g, reason: collision with root package name */
    private static boolean f٤٣٥٢g = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static void a(View view, int i10) {
            view.setTransitionVisibility(i10);
        }
    }

    @Override // androidx.transition.j0
    public void f(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i10);
        } else if (f٤٣٥٢g) {
            try {
                a.a(view, i10);
            } catch (NoSuchMethodError unused) {
                f٤٣٥٢g = false;
            }
        }
    }
}
