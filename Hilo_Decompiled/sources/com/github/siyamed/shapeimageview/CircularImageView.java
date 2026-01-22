package com.github.siyamed.shapeimageview;

import android.content.Context;
import android.util.AttributeSet;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import y6.b;
import y6.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class CircularImageView extends ShaderImageView {

    /* renamed from: b, reason: collision with root package name */
    private b f٨٠٨١b;

    public CircularImageView(Context context) {
        super(context);
    }

    @Override // com.github.siyamed.shapeimageview.ShaderImageView
    public d a() {
        b bVar = new b();
        this.f٨٠٨١b = bVar;
        return bVar;
    }

    public float getBorderRadius() {
        b bVar = this.f٨٠٨١b;
        if (bVar != null) {
            return bVar.s();
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    public void setBorderRadius(float f10) {
        b bVar = this.f٨٠٨١b;
        if (bVar != null) {
            bVar.t(f10);
            invalidate();
        }
    }

    public CircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
