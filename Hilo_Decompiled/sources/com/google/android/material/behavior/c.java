package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class c extends d {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.d
    public int a(View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        return view.getMeasuredWidth() + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.d
    public int b() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.d
    public int c() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.d
    public ViewPropertyAnimator d(View view, int i10) {
        return view.animate().translationX(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.behavior.d
    public void e(View view, int i10) {
        view.setTranslationX(i10);
    }
}
