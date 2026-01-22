package androidx.transition;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class p0 extends n0 {

    /* renamed from: f, reason: collision with root package name */
    private static boolean f٤٣٥١f = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {
        static void a(View view, int i10, int i11, int i12, int i13) {
            view.setLeftTopRightBottom(i10, i11, i12, i13);
        }
    }

    @Override // androidx.transition.j0
    public void d(View view, int i10, int i11, int i12, int i13) {
        if (f٤٣٥١f) {
            try {
                a.a(view, i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f٤٣٥١f = false;
            }
        }
    }
}
