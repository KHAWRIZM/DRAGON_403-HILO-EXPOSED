package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import zb.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class QMUIAlphaConstraintLayout extends ConstraintLayout {

    /* renamed from: a, reason: collision with root package name */
    private a f١٢٧٠٨a;

    public QMUIAlphaConstraintLayout(Context context) {
        super(context);
    }

    private a getAlphaViewHelper() {
        if (this.f١٢٧٠٨a == null) {
            this.f١٢٧٠٨a = new a(this);
        }
        return this.f١٢٧٠٨a;
    }

    public void setChangeAlphaWhenDisable(boolean z10) {
        getAlphaViewHelper().c(z10);
    }

    public void setChangeAlphaWhenPress(boolean z10) {
        getAlphaViewHelper().d(z10);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        getAlphaViewHelper().a(this, z10);
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        super.setPressed(z10);
        getAlphaViewHelper().b(this, z10);
    }

    public QMUIAlphaConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
