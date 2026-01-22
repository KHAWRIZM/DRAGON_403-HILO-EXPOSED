package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.List;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private int f١٠٣٤١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٠٣٤٢a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f١٠٣٤٣b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ y7.a f١٠٣٤٤c;

        a(View view, int i10, y7.a aVar) {
            this.f١٠٣٤٢a = view;
            this.f١٠٣٤٣b = i10;
            this.f١٠٣٤٤c = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f١٠٣٤٢a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (ExpandableBehavior.this.f١٠٣٤١a == this.f١٠٣٤٣b) {
                ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                y7.a aVar = this.f١٠٣٤٤c;
                expandableBehavior.N((View) aVar, this.f١٠٣٤٢a, aVar.a(), false);
            }
            return false;
        }
    }

    public ExpandableBehavior() {
        this.f١٠٣٤١a = 0;
    }

    private boolean L(boolean z10) {
        if (z10) {
            int i10 = this.f١٠٣٤١a;
            if (i10 != 0 && i10 != 2) {
                return false;
            }
            return true;
        }
        if (this.f١٠٣٤١a != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected y7.a M(CoordinatorLayout coordinatorLayout, View view) {
        List x10 = coordinatorLayout.x(view);
        int size = x10.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) x10.get(i10);
            if (k(coordinatorLayout, view, view2)) {
                return (y7.a) view2;
            }
        }
        return null;
    }

    protected abstract boolean N(View view, View view2, boolean z10, boolean z11);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public abstract boolean k(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
        int i10;
        y7.a aVar = (y7.a) view2;
        if (L(aVar.a())) {
            if (aVar.a()) {
                i10 = 1;
            } else {
                i10 = 2;
            }
            this.f١٠٣٤١a = i10;
            return N((View) aVar, view, aVar.a(), true);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i10) {
        y7.a M;
        int i11;
        if (!view.isLaidOut() && (M = M(coordinatorLayout, view)) != null && L(M.a())) {
            if (M.a()) {
                i11 = 1;
            } else {
                i11 = 2;
            }
            this.f١٠٣٤١a = i11;
            view.getViewTreeObserver().addOnPreDrawListener(new a(view, i11, M));
            return false;
        }
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٠٣٤١a = 0;
    }
}
