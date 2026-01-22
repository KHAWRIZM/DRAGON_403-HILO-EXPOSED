package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: d, reason: collision with root package name */
    private ImageFilterView.c f٢١٨٨d;

    /* renamed from: e, reason: collision with root package name */
    private float f٢١٨٩e;

    /* renamed from: f, reason: collision with root package name */
    private float f٢١٩٠f;

    /* renamed from: g, reason: collision with root package name */
    private float f٢١٩١g;

    /* renamed from: h, reason: collision with root package name */
    private Path f٢١٩٢h;

    /* renamed from: i, reason: collision with root package name */
    ViewOutlineProvider f٢١٩٣i;

    /* renamed from: j, reason: collision with root package name */
    RectF f٢١٩٤j;

    /* renamed from: k, reason: collision with root package name */
    Drawable[] f٢١٩٥k;

    /* renamed from: l, reason: collision with root package name */
    LayerDrawable f٢١٩٦l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f٢١٩٧m;

    /* renamed from: n, reason: collision with root package name */
    private Drawable f٢١٩٨n;

    /* renamed from: o, reason: collision with root package name */
    private Drawable f٢١٩٩o;

    /* renamed from: p, reason: collision with root package name */
    private float f٢٢٠٠p;

    /* renamed from: q, reason: collision with root package name */
    private float f٢٢٠١q;

    /* renamed from: r, reason: collision with root package name */
    private float f٢٢٠٢r;

    /* renamed from: s, reason: collision with root package name */
    private float f٢٢٠٣s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), (Math.min(r3, r4) * ImageFilterButton.this.f٢١٩٠f) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f٢١٩١g);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f٢١٨٨d = new ImageFilterView.c();
        this.f٢١٨٩e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩٠f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩١g = Float.NaN;
        this.f٢١٩٥k = new Drawable[2];
        this.f٢١٩٧m = true;
        this.f٢١٩٨n = null;
        this.f٢١٩٩o = null;
        this.f٢٢٠٠p = Float.NaN;
        this.f٢٢٠١q = Float.NaN;
        this.f٢٢٠٢r = Float.NaN;
        this.f٢٢٠٣s = Float.NaN;
        c(context, null);
    }

    private void c(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f٢١٩٨n = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f٢١٨٩e = obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f٢١٩٧m));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f٢٢٠٠p));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f٢٢٠١q));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f٢٢٠٣s));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f٢٢٠٢r));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f٢١٩٩o = drawable;
            if (this.f٢١٩٨n != null && drawable != null) {
                Drawable[] drawableArr = this.f٢١٩٥k;
                Drawable mutate = getDrawable().mutate();
                this.f٢١٩٩o = mutate;
                drawableArr[0] = mutate;
                this.f٢١٩٥k[1] = this.f٢١٩٨n.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(this.f٢١٩٥k);
                this.f٢١٩٦l = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f٢١٨٩e * 255.0f));
                if (!this.f٢١٩٧m) {
                    this.f٢١٩٦l.getDrawable(0).setAlpha((int) ((1.0f - this.f٢١٨٩e) * 255.0f));
                }
                super.setImageDrawable(this.f٢١٩٦l);
                return;
            }
            Drawable drawable2 = getDrawable();
            this.f٢١٩٩o = drawable2;
            if (drawable2 != null) {
                Drawable[] drawableArr2 = this.f٢١٩٥k;
                Drawable mutate2 = drawable2.mutate();
                this.f٢١٩٩o = mutate2;
                drawableArr2[0] = mutate2;
            }
        }
    }

    private void d() {
        float f10;
        float f11;
        float f12;
        float f13;
        if (Float.isNaN(this.f٢٢٠٠p) && Float.isNaN(this.f٢٢٠١q) && Float.isNaN(this.f٢٢٠٢r) && Float.isNaN(this.f٢٢٠٣s)) {
            return;
        }
        boolean isNaN = Float.isNaN(this.f٢٢٠٠p);
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        if (isNaN) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = this.f٢٢٠٠p;
        }
        if (Float.isNaN(this.f٢٢٠١q)) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f11 = this.f٢٢٠١q;
        }
        if (Float.isNaN(this.f٢٢٠٢r)) {
            f12 = 1.0f;
        } else {
            f12 = this.f٢٢٠٢r;
        }
        if (!Float.isNaN(this.f٢٢٠٣s)) {
            f14 = this.f٢٢٠٣s;
        }
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        if (intrinsicWidth * height < intrinsicHeight * width) {
            f13 = width / intrinsicWidth;
        } else {
            f13 = height / intrinsicHeight;
        }
        float f15 = f12 * f13;
        matrix.postScale(f15, f15);
        float f16 = intrinsicWidth * f15;
        float f17 = f15 * intrinsicHeight;
        matrix.postTranslate((((f10 * (width - f16)) + width) - f16) * 0.5f, (((f11 * (height - f17)) + height) - f17) * 0.5f);
        matrix.postRotate(f14, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void e() {
        if (Float.isNaN(this.f٢٢٠٠p) && Float.isNaN(this.f٢٢٠١q) && Float.isNaN(this.f٢٢٠٢r) && Float.isNaN(this.f٢٢٠٣s)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            d();
        }
    }

    private void setOverlay(boolean z10) {
        this.f٢١٩٧m = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getContrast() {
        return this.f٢١٨٨d.f٢٢٢٩f;
    }

    public float getCrossfade() {
        return this.f٢١٨٩e;
    }

    public float getImagePanX() {
        return this.f٢٢٠٠p;
    }

    public float getImagePanY() {
        return this.f٢٢٠١q;
    }

    public float getImageRotate() {
        return this.f٢٢٠٣s;
    }

    public float getImageZoom() {
        return this.f٢٢٠٢r;
    }

    public float getRound() {
        return this.f٢١٩١g;
    }

    public float getRoundPercent() {
        return this.f٢١٩٠f;
    }

    public float getSaturation() {
        return this.f٢١٨٨d.f٢٢٢٨e;
    }

    public float getWarmth() {
        return this.f٢١٨٨d.f٢٢٣٠g;
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        d();
    }

    public void setAltImageResource(int i10) {
        Drawable mutate = r1.a.b(getContext(), i10).mutate();
        this.f٢١٩٨n = mutate;
        Drawable[] drawableArr = this.f٢١٩٥k;
        drawableArr[0] = this.f٢١٩٩o;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f٢١٩٥k);
        this.f٢١٩٦l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f٢١٨٩e);
    }

    public void setBrightness(float f10) {
        ImageFilterView.c cVar = this.f٢١٨٨d;
        cVar.f٢٢٢٧d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        ImageFilterView.c cVar = this.f٢١٨٨d;
        cVar.f٢٢٢٩f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f٢١٨٩e = f10;
        if (this.f٢١٩٥k != null) {
            if (!this.f٢١٩٧m) {
                this.f٢١٩٦l.getDrawable(0).setAlpha((int) ((1.0f - this.f٢١٨٩e) * 255.0f));
            }
            this.f٢١٩٦l.getDrawable(1).setAlpha((int) (this.f٢١٨٩e * 255.0f));
            super.setImageDrawable(this.f٢١٩٦l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f٢١٩٨n != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f٢١٩٩o = mutate;
            Drawable[] drawableArr = this.f٢١٩٥k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f٢١٩٨n;
            LayerDrawable layerDrawable = new LayerDrawable(this.f٢١٩٥k);
            this.f٢١٩٦l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f٢١٨٩e);
            return;
        }
        super.setImageDrawable(drawable);
    }

    public void setImagePanX(float f10) {
        this.f٢٢٠٠p = f10;
        e();
    }

    public void setImagePanY(float f10) {
        this.f٢٢٠١q = f10;
        e();
    }

    @Override // androidx.appcompat.widget.AppCompatImageButton, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f٢١٩٨n != null) {
            Drawable mutate = r1.a.b(getContext(), i10).mutate();
            this.f٢١٩٩o = mutate;
            Drawable[] drawableArr = this.f٢١٩٥k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f٢١٩٨n;
            LayerDrawable layerDrawable = new LayerDrawable(this.f٢١٩٥k);
            this.f٢١٩٦l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f٢١٨٩e);
            return;
        }
        super.setImageResource(i10);
    }

    public void setImageRotate(float f10) {
        this.f٢٢٠٣s = f10;
        e();
    }

    public void setImageZoom(float f10) {
        this.f٢٢٠٢r = f10;
        e();
    }

    @RequiresApi(21)
    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.f٢١٩١g = f10;
            float f11 = this.f٢١٩٠f;
            this.f٢١٩٠f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.f٢١٩١g != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢١٩١g = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢١٩٢h == null) {
                this.f٢١٩٢h = new Path();
            }
            if (this.f٢١٩٤j == null) {
                this.f٢١٩٤j = new RectF();
            }
            if (this.f٢١٩٣i == null) {
                b bVar = new b();
                this.f٢١٩٣i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f٢١٩٤j.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight());
            this.f٢١٩٢h.reset();
            Path path = this.f٢١٩٢h;
            RectF rectF = this.f٢١٩٤j;
            float f12 = this.f٢١٩١g;
            path.addRoundRect(rectF, f12, f12, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f10) {
        boolean z10;
        if (this.f٢١٩٠f != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢١٩٠f = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢١٩٢h == null) {
                this.f٢١٩٢h = new Path();
            }
            if (this.f٢١٩٤j == null) {
                this.f٢١٩٤j = new RectF();
            }
            if (this.f٢١٩٣i == null) {
                a aVar = new a();
                this.f٢١٩٣i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f٢١٩٠f) / 2.0f;
            this.f٢١٩٤j.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
            this.f٢١٩٢h.reset();
            this.f٢١٩٢h.addRoundRect(this.f٢١٩٤j, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        ImageFilterView.c cVar = this.f٢١٨٨d;
        cVar.f٢٢٢٨e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        ImageFilterView.c cVar = this.f٢١٨٨d;
        cVar.f٢٢٣٠g = f10;
        cVar.c(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢١٨٨d = new ImageFilterView.c();
        this.f٢١٨٩e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩٠f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩١g = Float.NaN;
        this.f٢١٩٥k = new Drawable[2];
        this.f٢١٩٧m = true;
        this.f٢١٩٨n = null;
        this.f٢١٩٩o = null;
        this.f٢٢٠٠p = Float.NaN;
        this.f٢٢٠١q = Float.NaN;
        this.f٢٢٠٢r = Float.NaN;
        this.f٢٢٠٣s = Float.NaN;
        c(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢١٨٨d = new ImageFilterView.c();
        this.f٢١٨٩e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩٠f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢١٩١g = Float.NaN;
        this.f٢١٩٥k = new Drawable[2];
        this.f٢١٩٧m = true;
        this.f٢١٩٨n = null;
        this.f٢١٩٩o = null;
        this.f٢٢٠٠p = Float.NaN;
        this.f٢٢٠١q = Float.NaN;
        this.f٢٢٠٢r = Float.NaN;
        this.f٢٢٠٣s = Float.NaN;
        c(context, attributeSet);
    }
}
