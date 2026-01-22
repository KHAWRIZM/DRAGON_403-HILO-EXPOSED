package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import r6.k;
import r6.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class NumberWheelLayout extends OptionWheelLayout {
    public NumberWheelLayout(Context context) {
        super(context);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, u6.a
    public void d(WheelView wheelView, int i10) {
        super.d(wheelView, i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public void g(Context context, AttributeSet attributeSet) {
        super.g(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NumberWheelLayout);
        float f10 = obtainStyledAttributes.getFloat(R.styleable.NumberWheelLayout_wheel_minNumber, DownloadProgress.UNKNOWN_PROGRESS);
        float f11 = obtainStyledAttributes.getFloat(R.styleable.NumberWheelLayout_wheel_maxNumber, 10.0f);
        float f12 = obtainStyledAttributes.getFloat(R.styleable.NumberWheelLayout_wheel_stepNumber, 1.0f);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.NumberWheelLayout_wheel_isDecimal, false);
        obtainStyledAttributes.recycle();
        if (z10) {
            k(f10, f11, f12);
        } else {
            l((int) f10, (int) f11, (int) f12);
        }
    }

    public void k(float f10, float f11, float f12) {
        float min = Math.min(f10, f11);
        float max = Math.max(f10, f11);
        ArrayList arrayList = new ArrayList((int) ((max - min) / f12));
        while (min <= max) {
            arrayList.add(Float.valueOf(min));
            min += f12;
        }
        super.setData(arrayList);
    }

    public void l(int i10, int i11, int i12) {
        int min = Math.min(i10, i11);
        int max = Math.max(i10, i11);
        ArrayList arrayList = new ArrayList((max - min) / i12);
        while (min <= max) {
            arrayList.add(Integer.valueOf(min));
            min += i12;
        }
        super.setData(arrayList);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout
    @Deprecated
    public void setData(List<?> list) {
        throw new UnsupportedOperationException("Use setRange instead");
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.OptionWheelLayout
    @Deprecated
    public void setOnOptionSelectedListener(m mVar) {
        throw new UnsupportedOperationException("Use setOnNumberSelectedListener instead");
    }

    public NumberWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NumberWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public void setOnNumberSelectedListener(k kVar) {
    }
}
