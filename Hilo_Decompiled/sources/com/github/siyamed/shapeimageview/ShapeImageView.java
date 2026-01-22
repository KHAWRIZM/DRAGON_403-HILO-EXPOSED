package com.github.siyamed.shapeimageview;

import android.content.Context;
import android.util.AttributeSet;
import y6.d;
import y6.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ShapeImageView extends ShaderImageView {

    /* renamed from: b, reason: collision with root package name */
    private e f٨٠٨٤b;

    public ShapeImageView(Context context) {
        super(context);
    }

    @Override // com.github.siyamed.shapeimageview.ShaderImageView
    public d a() {
        e eVar = new e();
        this.f٨٠٨٤b = eVar;
        return eVar;
    }

    public void setBorderType(int i10) {
        e eVar = this.f٨٠٨٤b;
        if (eVar != null) {
            eVar.s(i10);
            invalidate();
        }
    }

    public void setShapeResId(int i10) {
        e eVar = this.f٨٠٨٤b;
        if (eVar != null) {
            eVar.t(getContext(), i10);
            invalidate();
        }
    }

    public void setStrokeCap(int i10) {
        e eVar = this.f٨٠٨٤b;
        if (eVar != null) {
            eVar.u(i10);
            invalidate();
        }
    }

    public void setStrokeJoin(int i10) {
        e eVar = this.f٨٠٨٤b;
        if (eVar != null) {
            eVar.v(i10);
            invalidate();
        }
    }

    public void setStrokeMiter(int i10) {
        e eVar = this.f٨٠٨٤b;
        if (eVar != null) {
            eVar.w(i10);
            invalidate();
        }
    }

    public ShapeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ShapeImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
