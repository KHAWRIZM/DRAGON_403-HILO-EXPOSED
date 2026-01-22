package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class a extends e {

    /* renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f٩٩٠٠a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SideSheetBehavior sideSheetBehavior) {
        this.f٩٩٠٠a = sideSheetBehavior;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public float b(int i10) {
        float e10 = e();
        return (i10 - e10) / (d() - e10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int d() {
        return Math.max(0, this.f٩٩٠٠a.q0() + this.f٩٩٠٠a.o0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int e() {
        return (-this.f٩٩٠٠a.h0()) - this.f٩٩٠٠a.o0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int f() {
        return this.f٩٩٠٠a.o0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int g() {
        return -this.f٩٩٠٠a.h0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int h(View view) {
        return view.getRight() + this.f٩٩٠٠a.o0();
    }

    @Override // com.google.android.material.sidesheet.e
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public int j() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean k(float f10) {
        return f10 > DownloadProgress.UNKNOWN_PROGRESS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean l(View view) {
        if (view.getRight() < (d() - e()) / 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean m(float f10, float f11) {
        if (g.a(f10, f11) && Math.abs(f10) > this.f٩٩٠٠a.s0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public boolean n(View view, float f10) {
        if (Math.abs(view.getLeft() + (f10 * this.f٩٩٠٠a.m0())) > this.f٩٩٠٠a.n0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i10) {
        marginLayoutParams.leftMargin = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.e
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i10, int i11) {
        if (i10 <= this.f٩٩٠٠a.r0()) {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
