package com.github.siyamed.shapeimageview;

import android.content.Context;
import android.util.AttributeSet;
import y6.d;
import y6.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PentagonImageView extends ShaderImageView {
    public PentagonImageView(Context context) {
        super(context);
    }

    @Override // com.github.siyamed.shapeimageview.ShaderImageView
    public d a() {
        return new e(R.raw.imgview_pentagon);
    }

    public PentagonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PentagonImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
