package com.github.siyamed.shapeimageview.mask;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import com.github.siyamed.shapeimageview.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class PorterImageView extends ImageView {

    /* renamed from: i, reason: collision with root package name */
    private static final String f٨٠٨٦i = "PorterImageView";

    /* renamed from: j, reason: collision with root package name */
    private static final PorterDuffXfermode f٨٠٨٧j = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

    /* renamed from: a, reason: collision with root package name */
    private Canvas f٨٠٨٨a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f٨٠٨٩b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f٨٠٩٠c;

    /* renamed from: d, reason: collision with root package name */
    private Canvas f٨٠٩١d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f٨٠٩٢e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f٨٠٩٣f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٨٠٩٤g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٨٠٩٥h;

    public PorterImageView(Context context) {
        super(context);
        this.f٨٠٩٤g = true;
        this.f٨٠٩٥h = false;
        c(context, null, 0);
    }

    private void a(int i10, int i11, int i12, int i13) {
        boolean z10;
        if (i10 == i12 && i11 == i13) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i10 > 0 && i11 > 0) {
            if (this.f٨٠٨٨a == null || z10) {
                this.f٨٠٨٨a = new Canvas();
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Bitmap createBitmap = Bitmap.createBitmap(i10, i11, config);
                this.f٨٠٨٩b = createBitmap;
                this.f٨٠٨٨a.setBitmap(createBitmap);
                this.f٨٠٩٠c.reset();
                b(this.f٨٠٨٨a, this.f٨٠٩٠c, i10, i11);
                this.f٨٠٩١d = new Canvas();
                Bitmap createBitmap2 = Bitmap.createBitmap(i10, i11, config);
                this.f٨٠٩٢e = createBitmap2;
                this.f٨٠٩١d.setBitmap(createBitmap2);
                this.f٨٠٩٣f = new Paint(1);
                this.f٨٠٩٤g = true;
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i10, 0);
            this.f٨٠٩٥h = obtainStyledAttributes.getBoolean(R.styleable.ShaderImageView_siSquare, false);
            obtainStyledAttributes.recycle();
        }
        if (getScaleType() == ImageView.ScaleType.FIT_CENTER) {
            setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        Paint paint = new Paint(1);
        this.f٨٠٩٠c = paint;
        paint.setColor(-16777216);
    }

    protected abstract void b(Canvas canvas, Paint paint, int i10, int i11);

    @Override // android.view.View
    public void invalidate() {
        this.f٨٠٩٤g = true;
        super.invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        if (!isInEditMode()) {
            int saveLayer = canvas.saveLayer(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight(), null, 31);
            try {
                try {
                    if (this.f٨٠٩٤g && (drawable = getDrawable()) != null) {
                        this.f٨٠٩٤g = false;
                        Matrix imageMatrix = getImageMatrix();
                        if (imageMatrix == null) {
                            drawable.draw(this.f٨٠٩١d);
                        } else {
                            int saveCount = this.f٨٠٩١d.getSaveCount();
                            this.f٨٠٩١d.save();
                            this.f٨٠٩١d.concat(imageMatrix);
                            drawable.draw(this.f٨٠٩١d);
                            this.f٨٠٩١d.restoreToCount(saveCount);
                        }
                        this.f٨٠٩٣f.reset();
                        this.f٨٠٩٣f.setFilterBitmap(false);
                        this.f٨٠٩٣f.setXfermode(f٨٠٨٧j);
                        this.f٨٠٩١d.drawBitmap(this.f٨٠٨٩b, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٨٠٩٣f);
                    }
                    if (!this.f٨٠٩٤g) {
                        this.f٨٠٩٣f.setXfermode(null);
                        canvas.drawBitmap(this.f٨٠٩٢e, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f٨٠٩٣f);
                    }
                } catch (Exception e10) {
                    Log.e(f٨٠٨٦i, "Exception occured while drawing " + getId(), e10);
                }
                canvas.restoreToCount(saveLayer);
                return;
            } catch (Throwable th) {
                canvas.restoreToCount(saveLayer);
                throw th;
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f٨٠٩٥h) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a(i10, i11, i12, i13);
    }

    public void setSquare(boolean z10) {
        this.f٨٠٩٥h = z10;
    }

    public PorterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٨٠٩٤g = true;
        this.f٨٠٩٥h = false;
        c(context, attributeSet, 0);
    }

    public PorterImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٨٠٩٤g = true;
        this.f٨٠٩٥h = false;
        c(context, attributeSet, i10);
    }
}
