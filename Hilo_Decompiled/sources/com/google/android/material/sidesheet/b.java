package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f٩٩٠١a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SideSheetBehavior sideSheetBehavior) {
        this.f٩٩٠١a = sideSheetBehavior;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public float b(int i10) {
        float e10 = e();
        return (e10 - i10) / (e10 - d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int d() {
        return Math.max(0, (e() - this.f٩٩٠١a.h0()) - this.f٩٩٠١a.o0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int e() {
        return this.f٩٩٠١a.r0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int f() {
        return this.f٩٩٠١a.r0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int g() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int h(View view) {
        return view.getLeft() - this.f٩٩٠١a.o0();
    }

    @Override // com.google.android.material.sidesheet.e
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int j() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean k(float f10) {
        return f10 < DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean l(View view) {
        if (view.getLeft() > (e() + d()) / 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean m(float f10, float f11) {
        if (g.a(f10, f11) && Math.abs(f10) > this.f٩٩٠١a.s0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean n(View view, float f10) {
        if (Math.abs(view.getRight() + (f10 * this.f٩٩٠١a.m0())) > this.f٩٩٠١a.n0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.rightMargin = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        int r02 = this.f٩٩٠١a.r0();
        if (i10 <= r02) {
            marginLayoutParams.rightMargin = r02 - i10;
        }
    }
}
