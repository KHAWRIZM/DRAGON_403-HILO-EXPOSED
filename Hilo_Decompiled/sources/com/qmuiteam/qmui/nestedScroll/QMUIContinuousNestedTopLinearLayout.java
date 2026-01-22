package com.qmuiteam.qmui.nestedScroll;

import android.content.Context;
import android.util.AttributeSet;
import com.qmuiteam.qmui.layout.QMUILinearLayout;
import com.qmuiteam.qmui.nestedScroll.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIContinuousNestedTopLinearLayout extends QMUILinearLayout implements c {
    public QMUIContinuousNestedTopLinearLayout(Context context) {
        super(context);
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int a(int i10) {
        return i10;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.b
    public void c(b.a aVar) {
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getCurrentScroll() {
        return 0;
    }

    @Override // com.qmuiteam.qmui.nestedScroll.c
    public int getScrollOffsetRange() {
        return 0;
    }

    public QMUIContinuousNestedTopLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QMUIContinuousNestedTopLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
