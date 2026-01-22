package com.qmuiteam.qmui.widget.dialog;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIBottomSheetBehavior<V extends ViewGroup> extends BottomSheetBehavior<V> {

    /* renamed from: m0, reason: collision with root package name */
    private boolean f١٣١٢٤m0 = true;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f١٣١٢٥n0 = true;

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: q1, reason: merged with bridge method [inline-methods] */
    public boolean q(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, MotionEvent motionEvent) {
        if (!this.f١٣١٢٤m0) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f١٣١٢٥n0 = true;
        }
        if (!this.f١٣١٢٥n0) {
            return false;
        }
        return super.q(coordinatorLayout, viewGroup, motionEvent);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: r1, reason: merged with bridge method [inline-methods] */
    public boolean G(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, View view, View view2, int i10, int i11) {
        if (!this.f١٣١٢٤m0) {
            return false;
        }
        return super.G(coordinatorLayout, viewGroup, view, view2, i10, i11);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public boolean J(CoordinatorLayout coordinatorLayout, ViewGroup viewGroup, MotionEvent motionEvent) {
        if (!this.f١٣١٢٤m0) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f١٣١٢٥n0 = true;
        }
        if (!this.f١٣١٢٥n0) {
            return false;
        }
        return super.J(coordinatorLayout, viewGroup, motionEvent);
    }

    public void t1(boolean z10) {
        this.f١٣١٢٤m0 = z10;
    }
}
