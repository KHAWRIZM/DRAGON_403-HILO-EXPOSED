package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIWrapContentScrollView extends QMUIObservableScrollView {

    /* renamed from: c, reason: collision with root package name */
    private int f١٣١١٥c;

    public QMUIWrapContentScrollView(Context context) {
        super(context);
        this.f١٣١١٥c = 536870911;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int makeMeasureSpec;
        int i12;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int min = Math.min(View.MeasureSpec.getSize(i11), this.f١٣١١٥c);
        if (layoutParams != null && (i12 = layoutParams.height) > 0 && i12 <= this.f١٣١١٥c) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(min, Integer.MIN_VALUE);
        }
        super.onMeasure(i10, makeMeasureSpec);
    }

    public void setMaxHeight(int i10) {
        if (this.f١٣١١٥c != i10) {
            this.f١٣١١٥c = i10;
            requestLayout();
        }
    }

    public QMUIWrapContentScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣١١٥c = 536870911;
    }

    public QMUIWrapContentScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١١٥c = 536870911;
    }
}
