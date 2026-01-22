package com.github.gzuliyujiang.wheelview.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NumberWheelView extends WheelView {
    public NumberWheelView(Context context) {
        super(context);
    }

    public void M(int i10, int i11, int i12) {
        int min = Math.min(i10, i11);
        int max = Math.max(i10, i11);
        ArrayList arrayList = new ArrayList((max - min) / i12);
        while (min <= max) {
            arrayList.add(Integer.valueOf(min));
            min += i12;
        }
        super.setData(arrayList);
    }

    @Override // com.github.gzuliyujiang.wheelview.widget.WheelView
    @Deprecated
    public void setData(List<?> list) {
        if (isInEditMode()) {
            super.setData(v());
            return;
        }
        throw new UnsupportedOperationException("Use setRange instead");
    }

    @Override // com.github.gzuliyujiang.wheelview.widget.WheelView
    protected List v() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 1; i10 <= 10; i10++) {
            arrayList.add(Integer.valueOf(i10));
        }
        return arrayList;
    }

    public NumberWheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberWheelView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
