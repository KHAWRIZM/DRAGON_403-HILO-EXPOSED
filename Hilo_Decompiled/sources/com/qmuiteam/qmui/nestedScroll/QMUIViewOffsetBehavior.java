package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import ic.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIViewOffsetBehavior<V extends View> extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private l f١٢٨٣٨a;

    /* renamed from: b, reason: collision with root package name */
    private int f١٢٨٣٩b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٢٨٤٠c;

    public QMUIViewOffsetBehavior() {
        this.f١٢٨٣٩b = 0;
        this.f١٢٨٤٠c = 0;
    }

    public int K() {
        l lVar = this.f١٢٨٣٨a;
        if (lVar != null) {
            return lVar.b();
        }
        return 0;
    }

    public int L() {
        l lVar = this.f١٢٨٣٨a;
        if (lVar != null) {
            return lVar.d();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(CoordinatorLayout coordinatorLayout, View view, int i10) {
        coordinatorLayout.O(view, i10);
    }

    public boolean N(int i10) {
        l lVar = this.f١٢٨٣٨a;
        if (lVar != null) {
            return lVar.h(i10);
        }
        this.f١٢٨٣٩b = i10;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        M(coordinatorLayout, view, i10);
        if (this.f١٢٨٣٨a == null) {
            this.f١٢٨٣٨a = new l(view);
        }
        this.f١٢٨٣٨a.e();
        int i11 = this.f١٢٨٣٩b;
        if (i11 != 0) {
            this.f١٢٨٣٨a.h(i11);
            this.f١٢٨٣٩b = 0;
        }
        int i12 = this.f١٢٨٤٠c;
        if (i12 != 0) {
            this.f١٢٨٣٨a.g(i12);
            this.f١٢٨٤٠c = 0;
            return true;
        }
        return true;
    }

    public QMUIViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٢٨٣٩b = 0;
        this.f١٢٨٤٠c = 0;
    }
}
