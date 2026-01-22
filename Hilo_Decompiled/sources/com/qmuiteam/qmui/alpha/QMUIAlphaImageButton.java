package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageButton;
import zb.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class QMUIAlphaImageButton extends AppCompatImageButton {

    /* renamed from: d, reason: collision with root package name */
    private a f١٢٧١٠d;

    public QMUIAlphaImageButton(Context context) {
        super(context);
    }

    private a getAlphaViewHelper() {
        if (this.f١٢٧١٠d == null) {
            this.f١٢٧١٠d = new a(this);
        }
        return this.f١٢٧١٠d;
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

    public QMUIAlphaImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaImageButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
