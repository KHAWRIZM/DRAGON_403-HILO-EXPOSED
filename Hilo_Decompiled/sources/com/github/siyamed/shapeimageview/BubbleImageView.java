package com.github.siyamed.shapeimageview;

import android.content.Context;
import android.util.AttributeSet;
import y6.a;
import y6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class BubbleImageView extends ShaderImageView {

    /* renamed from: b, reason: collision with root package name */
    private a f٨٠٨٠b;

    public BubbleImageView(Context context) {
        super(context);
    }

    @Override // com.github.siyamed.shapeimageview.ShaderImageView
    public d a() {
        a aVar = new a();
        this.f٨٠٨٠b = aVar;
        return aVar;
    }

    public a.b getArrowPosition() {
        a aVar = this.f٨٠٨٠b;
        if (aVar != null) {
            return aVar.s();
        }
        return a.b.LEFT;
    }

    public int getTriangleHeightPx() {
        a aVar = this.f٨٠٨٠b;
        if (aVar != null) {
            return aVar.t();
        }
        return 0;
    }

    public void setArrowPosition(a.b bVar) {
        a aVar = this.f٨٠٨٠b;
        if (aVar != null) {
            aVar.u(bVar);
            invalidate();
        }
    }

    public void setTriangleHeightPx(int i10) {
        a aVar = this.f٨٠٨٠b;
        if (aVar != null) {
            aVar.v(i10);
            invalidate();
        }
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
