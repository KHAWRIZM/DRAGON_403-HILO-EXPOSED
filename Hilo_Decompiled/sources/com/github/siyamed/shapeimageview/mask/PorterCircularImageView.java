package com.github.siyamed.shapeimageview.mask;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class PorterCircularImageView extends PorterImageView {

    /* renamed from: k, reason: collision with root package name */
    private final RectF f٨٠٨٥k;

    public PorterCircularImageView(Context context) {
        super(context);
        this.f٨٠٨٥k = new RectF();
        d();
    }

    private void d() {
        setSquare(true);
    }

    @Override // com.github.siyamed.shapeimageview.mask.PorterImageView
    protected void b(Canvas canvas, Paint paint, int i10, int i11) {
        this.f٨٠٨٥k.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i11);
        canvas.drawCircle(this.f٨٠٨٥k.centerX(), this.f٨٠٨٥k.centerY(), Math.min(i10, i11) / 2.0f, paint);
    }

    public PorterCircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٠٨٥k = new RectF();
        d();
    }

    public PorterCircularImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٨٠٨٥k = new RectF();
        d();
    }
}
