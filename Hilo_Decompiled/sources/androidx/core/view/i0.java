package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i0 {

    /* renamed from: a, reason: collision with root package name */
    private int f٢٩٨٤a;

    /* renamed from: b, reason: collision with root package name */
    private int f٢٩٨٥b;

    public i0(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f٢٩٨٤a | this.f٢٩٨٥b;
    }

    public void b(View view, View view2, int i10) {
        c(view, view2, i10, 0);
    }

    public void c(View view, View view2, int i10, int i11) {
        if (i11 == 1) {
            this.f٢٩٨٥b = i10;
        } else {
            this.f٢٩٨٤a = i10;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i10) {
        if (i10 == 1) {
            this.f٢٩٨٥b = 0;
        } else {
            this.f٢٩٨٤a = 0;
        }
    }
}
