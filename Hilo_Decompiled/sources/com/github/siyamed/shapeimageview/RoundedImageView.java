package com.github.siyamed.shapeimageview;

import android.content.Context;
import android.util.AttributeSet;
import y6.c;
import y6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RoundedImageView extends ShaderImageView {

    /* renamed from: b, reason: collision with root package name */
    private c f٨٠٨٢b;

    public RoundedImageView(Context context) {
        super(context);
    }

    @Override // com.github.siyamed.shapeimageview.ShaderImageView
    public d a() {
        c cVar = new c();
        this.f٨٠٨٢b = cVar;
        return cVar;
    }

    public final int getRadius() {
        c cVar = this.f٨٠٨٢b;
        if (cVar != null) {
            return cVar.s();
        }
        return 0;
    }

    public final void setRadius(int i10) {
        c cVar = this.f٨٠٨٢b;
        if (cVar != null) {
            cVar.t(i10);
            invalidate();
        }
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
