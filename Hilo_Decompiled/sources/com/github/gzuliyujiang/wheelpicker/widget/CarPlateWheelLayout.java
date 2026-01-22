package com.github.gzuliyujiang.wheelpicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import t6.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CarPlateWheelLayout extends LinkageWheelLayout {

    /* renamed from: p, reason: collision with root package name */
    private b f٧٩٧٧p;

    public CarPlateWheelLayout(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public void g(Context context, AttributeSet attributeSet) {
        super.g(context, attributeSet);
        setFirstVisible(this.f٧٩٧٧p.h());
        setThirdVisible(this.f٧٩٧٧p.f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.github.gzuliyujiang.wheelpicker.widget.LinkageWheelLayout, com.github.gzuliyujiang.wheelpicker.widget.BaseWheelLayout
    public void h(Context context) {
        super.h(context);
        b bVar = new b();
        this.f٧٩٧٧p = bVar;
        setData(bVar);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CarPlateWheelLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
