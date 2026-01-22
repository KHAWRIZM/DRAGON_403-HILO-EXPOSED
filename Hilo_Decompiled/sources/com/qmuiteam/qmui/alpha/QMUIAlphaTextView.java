package com.qmuiteam.qmui.alpha;

import android.content.Context;
import android.util.AttributeSet;
import com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView;
import zb.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class QMUIAlphaTextView extends QMUISpanTouchFixTextView {

    /* renamed from: e, reason: collision with root package name */
    private a f١٢٧١٣e;

    public QMUIAlphaTextView(Context context) {
        super(context);
    }

    private a getAlphaViewHelper() {
        if (this.f١٢٧١٣e == null) {
            this.f١٢٧١٣e = new a(this);
        }
        return this.f١٢٧١٣e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView
    public void k(boolean z10) {
        super.k(z10);
        getAlphaViewHelper().b(this, z10);
    }

    public void setChangeAlphaWhenDisable(boolean z10) {
        getAlphaViewHelper().c(z10);
    }

    public void setChangeAlphaWhenPress(boolean z10) {
        getAlphaViewHelper().d(z10);
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        getAlphaViewHelper().a(this, z10);
    }

    public QMUIAlphaTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIAlphaTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
