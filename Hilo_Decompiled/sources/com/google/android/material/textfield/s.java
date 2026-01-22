package com.google.android.material.textfield;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    final TextInputLayout f١٠٢٣٢a;

    /* renamed from: b, reason: collision with root package name */
    final EndCompoundLayout f١٠٢٣٣b;

    /* renamed from: c, reason: collision with root package name */
    final Context f١٠٢٣٤c;

    /* renamed from: d, reason: collision with root package name */
    final CheckableImageButton f١٠٢٣٥d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(EndCompoundLayout endCompoundLayout) {
        this.f١٠٢٣٢a = endCompoundLayout.f١٠٠٧٥a;
        this.f١٠٢٣٣b = endCompoundLayout;
        this.f١٠٢٣٤c = endCompoundLayout.getContext();
        this.f١٠٢٣٥d = endCompoundLayout.r();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Editable editable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CharSequence charSequence, int i10, int i11, int i12) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnFocusChangeListener e() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnClickListener f() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View.OnFocusChangeListener g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccessibilityManager.TouchExplorationStateChangeListener h() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(int i10) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(EditText editText) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view, AccessibilityEvent accessibilityEvent) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r() {
        this.f١٠٢٣٣b.L(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(View view, m2.g0 g0Var) {
    }
}
