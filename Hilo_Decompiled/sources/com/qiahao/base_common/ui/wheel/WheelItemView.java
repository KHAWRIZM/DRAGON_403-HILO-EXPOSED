package com.qiahao.base_common.ui.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bb.a;
import bb.b;
import com.qiahao.base_common.ui.wheel.WheelView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class WheelItemView extends FrameLayout implements b {

    /* renamed from: a, reason: collision with root package name */
    private WheelView f١٢٥٣٤a;

    /* renamed from: b, reason: collision with root package name */
    private WheelMaskView f١٢٥٣٥b;

    public WheelItemView(Context context) {
        super(context);
        a(context, null, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i10) {
        WheelView wheelView = new WheelView(context);
        this.f١٢٥٣٤a = wheelView;
        wheelView.r(context, attributeSet, i10);
        WheelMaskView wheelMaskView = new WheelMaskView(context);
        this.f١٢٥٣٥b = wheelMaskView;
        wheelMaskView.a(context, attributeSet, i10);
        addView(this.f١٢٥٣٤a, new FrameLayout.LayoutParams(-1, -2));
        addView(this.f١٢٥٣٥b, new FrameLayout.LayoutParams(-1, -2));
    }

    public void b(int i10, boolean z10) {
        this.f١٢٥٣٤a.x(i10, z10);
    }

    public int getSelectedIndex() {
        return this.f١٢٥٣٤a.getSelectedIndex();
    }

    public WheelMaskView getWheelMaskView() {
        return this.f١٢٥٣٥b;
    }

    public WheelView getWheelView() {
        return this.f١٢٥٣٤a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        ViewGroup.LayoutParams layoutParams = this.f١٢٥٣٥b.getLayoutParams();
        layoutParams.height = this.f١٢٥٣٤a.getMeasuredHeight();
        this.f١٢٥٣٥b.setLayoutParams(layoutParams);
        this.f١٢٥٣٥b.b(this.f١٢٥٣٤a.getShowCount(), this.f١٢٥٣٤a.getItemHeight());
    }

    public void setItemVerticalSpace(int i10) {
        this.f١٢٥٣٤a.setItemVerticalSpace(i10);
    }

    public void setItems(a[] aVarArr) {
        this.f١٢٥٣٤a.setItems(aVarArr);
    }

    public void setMaskLineColor(int i10) {
        this.f١٢٥٣٥b.setLineColor(i10);
    }

    @Override // bb.b
    public void setOnSelectedListener(WheelView.c cVar) {
        this.f١٢٥٣٤a.setOnSelectedListener(cVar);
    }

    public void setSelectedIndex(int i10) {
        b(i10, true);
    }

    public void setShowCount(int i10) {
        this.f١٢٥٣٤a.setShowCount(i10);
    }

    public void setTextColor(int i10) {
        this.f١٢٥٣٤a.setTextColor(i10);
    }

    public void setTextSize(float f10) {
        this.f١٢٥٣٤a.setTextSize(f10);
    }

    public void setTotalOffsetX(int i10) {
        this.f١٢٥٣٤a.setTotalOffsetX(i10);
    }

    public WheelItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public WheelItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet, i10);
    }
}
