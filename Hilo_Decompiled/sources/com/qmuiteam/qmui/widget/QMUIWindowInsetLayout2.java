package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.d2;
import com.qmuiteam.qmui.layout.QMUIConstraintLayout;
import ic.n;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIWindowInsetLayout2 extends QMUIConstraintLayout {
    public QMUIWindowInsetLayout2(Context context) {
        this(context, null);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        n.d(view, d2.m.f() | d2.m.a());
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
    }

    public QMUIWindowInsetLayout2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUIWindowInsetLayout2(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
