package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIWrapContentListView extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private int f١٣١١٤a;

    public QMUIWrapContentListView(Context context) {
        super(context);
        this.f١٣١١٤a = 536870911;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(this.f١٣١١٤a, Integer.MIN_VALUE));
    }

    public void setMaxHeight(int i10) {
        if (this.f١٣١١٤a != i10) {
            this.f١٣١١٤a = i10;
            requestLayout();
        }
    }

    public QMUIWrapContentListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٣١١٤a = 536870911;
    }

    public QMUIWrapContentListView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣١١٤a = 536870911;
    }
}
