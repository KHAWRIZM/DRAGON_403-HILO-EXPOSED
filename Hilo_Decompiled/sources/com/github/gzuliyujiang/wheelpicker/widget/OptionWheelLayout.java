package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.github.gzuliyujiang.wheelpicker.R;
import com.github.gzuliyujiang.wheelview.widget.WheelView;
import java.util.Collections;
import java.util.List;
import r6.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class OptionWheelLayout extends BaseWheelLayout {

    /* renamed from: b, reason: collision with root package name */
    private WheelView f٨٠١٤b;

    /* renamed from: c, reason: collision with root package name */
    private TextView f٨٠١٥c;

    public OptionWheelLayout(Context context) {
        super(context);
    }

    public void d(WheelView wheelView, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public void g(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OptionWheelLayout);
        this.f٨٠١٥c.setText(obtainStyledAttributes.getString(R.styleable.OptionWheelLayout_wheel_label));
        obtainStyledAttributes.recycle();
    }

    public final TextView getLabelView() {
        return this.f٨٠١٥c;
    }

    public final WheelView getWheelView() {
        return this.f٨٠١٤b;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected void h(Context context) {
        this.f٨٠١٤b = (WheelView) findViewById(R.id.wheel_picker_option_wheel);
        this.f٨٠١٥c = (TextView) findViewById(R.id.wheel_picker_option_label);
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected int i() {
        return R.layout.wheel_picker_option;
    }

    @Override // com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    protected List j() {
        return Collections.singletonList(this.f٨٠١٤b);
    }

    public void setData(List<?> list) {
        this.f٨٠١٤b.setData(list);
    }

    public void setDefaultPosition(int i10) {
        this.f٨٠١٤b.setDefaultPosition(i10);
    }

    public void setDefaultValue(Object obj) {
        this.f٨٠١٤b.setDefaultValue(obj);
    }

    public OptionWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OptionWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public void setOnOptionSelectedListener(m mVar) {
    }
}
