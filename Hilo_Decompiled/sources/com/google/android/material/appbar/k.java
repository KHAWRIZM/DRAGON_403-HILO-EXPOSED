package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class k extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private l f٨٢٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private int f٨٢٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private int f٨٢٣١c;

    public k() {
        this.f٨٢٣٠b = 0;
        this.f٨٢٣١c = 0;
    }

    public int K() {
        l lVar = this.f٨٢٢٩a;
        if (lVar != null) {
            return lVar.c();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(CoordinatorLayout coordinatorLayout, View view, int i10) {
        coordinatorLayout.O(view, i10);
    }

    public boolean M(int i10) {
        l lVar = this.f٨٢٢٩a;
        if (lVar != null) {
            return lVar.f(i10);
        }
        this.f٨٢٣٠b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        L(coordinatorLayout, view, i10);
        if (this.f٨٢٢٩a == null) {
            this.f٨٢٢٩a = new l(view);
        }
        this.f٨٢٢٩a.d();
        this.f٨٢٢٩a.a();
        int i11 = this.f٨٢٣٠b;
        if (i11 != 0) {
            this.f٨٢٢٩a.f(i11);
            this.f٨٢٣٠b = 0;
        }
        int i12 = this.f٨٢٣١c;
        if (i12 != 0) {
            this.f٨٢٢٩a.e(i12);
            this.f٨٢٣١c = 0;
            return true;
        }
        return true;
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٢٣٠b = 0;
        this.f٨٢٣١c = 0;
    }
}
