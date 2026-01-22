package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    private c f٢٢٠٦a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٢٢٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f٢٢٠٨c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f٢٢٠٩d;

    /* renamed from: e, reason: collision with root package name */
    private float f٢٢١٠e;

    /* renamed from: f, reason: collision with root package name */
    private float f٢٢١١f;

    /* renamed from: g, reason: collision with root package name */
    private float f٢٢١٢g;

    /* renamed from: h, reason: collision with root package name */
    private Path f٢٢١٣h;

    /* renamed from: i, reason: collision with root package name */
    ViewOutlineProvider f٢٢١٤i;

    /* renamed from: j, reason: collision with root package name */
    RectF f٢٢١٥j;

    /* renamed from: k, reason: collision with root package name */
    Drawable[] f٢٢١٦k;

    /* renamed from: l, reason: collision with root package name */
    LayerDrawable f٢٢١٧l;

    /* renamed from: m, reason: collision with root package name */
    float f٢٢١٨m;

    /* renamed from: n, reason: collision with root package name */
    float f٢٢١٩n;

    /* renamed from: o, reason: collision with root package name */
    float f٢٢٢٠o;

    /* renamed from: p, reason: collision with root package name */
    float f٢٢٢١p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r3, r4) * ImageFilterView.this.f٢٢١١f) / 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f٢٢١٢g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        float[] f٢٢٢٤a = new float[20];

        /* renamed from: b, reason: collision with root package name */
        ColorMatrix f٢٢٢٥b = new ColorMatrix();

        /* renamed from: c, reason: collision with root package name */
        ColorMatrix f٢٢٢٦c = new ColorMatrix();

        /* renamed from: d, reason: collision with root package name */
        float f٢٢٢٧d = 1.0f;

        /* renamed from: e, reason: collision with root package name */
        float f٢٢٢٨e = 1.0f;

        /* renamed from: f, reason: collision with root package name */
        float f٢٢٢٩f = 1.0f;

        /* renamed from: g, reason: collision with root package name */
        float f٢٢٣٠g = 1.0f;

        private void a(float f10) {
            float[] fArr = this.f٢٢٢٤a;
            fArr[0] = f10;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f10;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f10) {
            float f11 = 1.0f - f10;
            float f12 = 0.2999f * f11;
            float f13 = 0.587f * f11;
            float f14 = f11 * 0.114f;
            float[] fArr = this.f٢٢٢٤a;
            fArr[0] = f12 + f10;
            fArr[1] = f13;
            fArr[2] = f14;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f12;
            fArr[6] = f13 + f10;
            fArr[7] = f14;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f12;
            fArr[11] = f13;
            fArr[12] = f14 + f10;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void d(float f10) {
            float log;
            float f11;
            float f12;
            if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                f10 = 0.01f;
            }
            float f13 = (5000.0f / f10) / 100.0f;
            if (f13 > 66.0f) {
                double d10 = f13 - 60.0f;
                f11 = ((float) Math.pow(d10, -0.13320475816726685d)) * 329.69873f;
                log = ((float) Math.pow(d10, 0.07551484555006027d)) * 288.12216f;
            } else {
                log = (((float) Math.log(f13)) * 99.4708f) - 161.11957f;
                f11 = 255.0f;
            }
            if (f13 < 66.0f) {
                if (f13 > 19.0f) {
                    f12 = (((float) Math.log(f13 - 10.0f)) * 138.51773f) - 305.0448f;
                } else {
                    f12 = DownloadProgress.UNKNOWN_PROGRESS;
                }
            } else {
                f12 = 255.0f;
            }
            float min = Math.min(255.0f, Math.max(f11, DownloadProgress.UNKNOWN_PROGRESS));
            float min2 = Math.min(255.0f, Math.max(log, DownloadProgress.UNKNOWN_PROGRESS));
            float min3 = Math.min(255.0f, Math.max(f12, DownloadProgress.UNKNOWN_PROGRESS));
            float log2 = (((float) Math.log(50.0f)) * 99.4708f) - 161.11957f;
            float log3 = (((float) Math.log(40.0f)) * 138.51773f) - 305.0448f;
            float min4 = Math.min(255.0f, Math.max(255.0f, DownloadProgress.UNKNOWN_PROGRESS));
            float min5 = Math.min(255.0f, Math.max(log2, DownloadProgress.UNKNOWN_PROGRESS));
            float min6 = min3 / Math.min(255.0f, Math.max(log3, DownloadProgress.UNKNOWN_PROGRESS));
            float[] fArr = this.f٢٢٢٤a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c(ImageView imageView) {
            boolean z10;
            this.f٢٢٢٥b.reset();
            float f10 = this.f٢٢٢٨e;
            boolean z11 = true;
            if (f10 != 1.0f) {
                b(f10);
                this.f٢٢٢٥b.set(this.f٢٢٢٤a);
                z10 = true;
            } else {
                z10 = false;
            }
            float f11 = this.f٢٢٢٩f;
            if (f11 != 1.0f) {
                this.f٢٢٢٦c.setScale(f11, f11, f11, 1.0f);
                this.f٢٢٢٥b.postConcat(this.f٢٢٢٦c);
                z10 = true;
            }
            float f12 = this.f٢٢٣٠g;
            if (f12 != 1.0f) {
                d(f12);
                this.f٢٢٢٦c.set(this.f٢٢٢٤a);
                this.f٢٢٢٥b.postConcat(this.f٢٢٢٦c);
                z10 = true;
            }
            float f13 = this.f٢٢٢٧d;
            if (f13 != 1.0f) {
                a(f13);
                this.f٢٢٢٦c.set(this.f٢٢٢٤a);
                this.f٢٢٢٥b.postConcat(this.f٢٢٢٦c);
            } else {
                z11 = z10;
            }
            if (z11) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f٢٢٢٥b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f٢٢٠٦a = new c();
        this.f٢٢٠٧b = true;
        this.f٢٢٠٨c = null;
        this.f٢٢٠٩d = null;
        this.f٢٢١٠e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢١١f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢١٢g = Float.NaN;
        this.f٢٢١٦k = new Drawable[2];
        this.f٢٢١٨m = Float.NaN;
        this.f٢٢١٩n = Float.NaN;
        this.f٢٢٢٠o = Float.NaN;
        this.f٢٢٢١p = Float.NaN;
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.f٢٢٠٨c = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f٢٢١٠e = obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, DownloadProgress.UNKNOWN_PROGRESS));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f٢٢٠٧b));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.f٢٢١٨m));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.f٢٢١٩n));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.f٢٢٢١p));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.f٢٢٢٠o));
                }
            }
            obtainStyledAttributes.recycle();
            Drawable drawable = getDrawable();
            this.f٢٢٠٩d = drawable;
            if (this.f٢٢٠٨c != null && drawable != null) {
                Drawable[] drawableArr = this.f٢٢١٦k;
                Drawable mutate = getDrawable().mutate();
                this.f٢٢٠٩d = mutate;
                drawableArr[0] = mutate;
                this.f٢٢١٦k[1] = this.f٢٢٠٨c.mutate();
                LayerDrawable layerDrawable = new LayerDrawable(this.f٢٢١٦k);
                this.f٢٢١٧l = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f٢٢١٠e * 255.0f));
                if (!this.f٢٢٠٧b) {
                    this.f٢٢١٧l.getDrawable(0).setAlpha((int) ((1.0f - this.f٢٢١٠e) * 255.0f));
                }
                super.setImageDrawable(this.f٢٢١٧l);
                return;
            }
            Drawable drawable2 = getDrawable();
            this.f٢٢٠٩d = drawable2;
            if (drawable2 != null) {
                Drawable[] drawableArr2 = this.f٢٢١٦k;
                Drawable mutate2 = drawable2.mutate();
                this.f٢٢٠٩d = mutate2;
                drawableArr2[0] = mutate2;
            }
        }
    }

    private void m() {
        float f10;
        float f11;
        float f12;
        float f13;
        if (Float.isNaN(this.f٢٢١٨m) && Float.isNaN(this.f٢٢١٩n) && Float.isNaN(this.f٢٢٢٠o) && Float.isNaN(this.f٢٢٢١p)) {
            return;
        }
        boolean isNaN = Float.isNaN(this.f٢٢١٨m);
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        if (isNaN) {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f10 = this.f٢٢١٨m;
        }
        if (Float.isNaN(this.f٢٢١٩n)) {
            f11 = DownloadProgress.UNKNOWN_PROGRESS;
        } else {
            f11 = this.f٢٢١٩n;
        }
        if (Float.isNaN(this.f٢٢٢٠o)) {
            f12 = 1.0f;
        } else {
            f12 = this.f٢٢٢٠o;
        }
        if (!Float.isNaN(this.f٢٢٢١p)) {
            f14 = this.f٢٢٢١p;
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

    private void n() {
        if (Float.isNaN(this.f٢٢١٨m) && Float.isNaN(this.f٢٢١٩n) && Float.isNaN(this.f٢٢٢٠o) && Float.isNaN(this.f٢٢٢١p)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            m();
        }
    }

    private void setOverlay(boolean z10) {
        this.f٢٢٠٧b = z10;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getBrightness() {
        return this.f٢٢٠٦a.f٢٢٢٧d;
    }

    public float getContrast() {
        return this.f٢٢٠٦a.f٢٢٢٩f;
    }

    public float getCrossfade() {
        return this.f٢٢١٠e;
    }

    public float getImagePanX() {
        return this.f٢٢١٨m;
    }

    public float getImagePanY() {
        return this.f٢٢١٩n;
    }

    public float getImageRotate() {
        return this.f٢٢٢١p;
    }

    public float getImageZoom() {
        return this.f٢٢٢٠o;
    }

    public float getRound() {
        return this.f٢٢١٢g;
    }

    public float getRoundPercent() {
        return this.f٢٢١١f;
    }

    public float getSaturation() {
        return this.f٢٢٠٦a.f٢٢٢٨e;
    }

    public float getWarmth() {
        return this.f٢٢٠٦a.f٢٢٣٠g;
    }

    @Override // android.view.View
    public void layout(int i10, int i11, int i12, int i13) {
        super.layout(i10, i11, i12, i13);
        m();
    }

    public void setAltImageResource(int i10) {
        Drawable mutate = r1.a.b(getContext(), i10).mutate();
        this.f٢٢٠٨c = mutate;
        Drawable[] drawableArr = this.f٢٢١٦k;
        drawableArr[0] = this.f٢٢٠٩d;
        drawableArr[1] = mutate;
        LayerDrawable layerDrawable = new LayerDrawable(this.f٢٢١٦k);
        this.f٢٢١٧l = layerDrawable;
        super.setImageDrawable(layerDrawable);
        setCrossfade(this.f٢٢١٠e);
    }

    public void setBrightness(float f10) {
        c cVar = this.f٢٢٠٦a;
        cVar.f٢٢٢٧d = f10;
        cVar.c(this);
    }

    public void setContrast(float f10) {
        c cVar = this.f٢٢٠٦a;
        cVar.f٢٢٢٩f = f10;
        cVar.c(this);
    }

    public void setCrossfade(float f10) {
        this.f٢٢١٠e = f10;
        if (this.f٢٢١٦k != null) {
            if (!this.f٢٢٠٧b) {
                this.f٢٢١٧l.getDrawable(0).setAlpha((int) ((1.0f - this.f٢٢١٠e) * 255.0f));
            }
            this.f٢٢١٧l.getDrawable(1).setAlpha((int) (this.f٢٢١٠e * 255.0f));
            super.setImageDrawable(this.f٢٢١٧l);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.f٢٢٠٨c != null && drawable != null) {
            Drawable mutate = drawable.mutate();
            this.f٢٢٠٩d = mutate;
            Drawable[] drawableArr = this.f٢٢١٦k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f٢٢٠٨c;
            LayerDrawable layerDrawable = new LayerDrawable(this.f٢٢١٦k);
            this.f٢٢١٧l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f٢٢١٠e);
            return;
        }
        super.setImageDrawable(drawable);
    }

    public void setImagePanX(float f10) {
        this.f٢٢١٨m = f10;
        n();
    }

    public void setImagePanY(float f10) {
        this.f٢٢١٩n = f10;
        n();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.f٢٢٠٨c != null) {
            Drawable mutate = r1.a.b(getContext(), i10).mutate();
            this.f٢٢٠٩d = mutate;
            Drawable[] drawableArr = this.f٢٢١٦k;
            drawableArr[0] = mutate;
            drawableArr[1] = this.f٢٢٠٨c;
            LayerDrawable layerDrawable = new LayerDrawable(this.f٢٢١٦k);
            this.f٢٢١٧l = layerDrawable;
            super.setImageDrawable(layerDrawable);
            setCrossfade(this.f٢٢١٠e);
            return;
        }
        super.setImageResource(i10);
    }

    public void setImageRotate(float f10) {
        this.f٢٢٢١p = f10;
        n();
    }

    public void setImageZoom(float f10) {
        this.f٢٢٢٠o = f10;
        n();
    }

    @RequiresApi(21)
    public void setRound(float f10) {
        boolean z10;
        if (Float.isNaN(f10)) {
            this.f٢٢١٢g = f10;
            float f11 = this.f٢٢١١f;
            this.f٢٢١١f = -1.0f;
            setRoundPercent(f11);
            return;
        }
        if (this.f٢٢١٢g != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢٢١٢g = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢٢١٣h == null) {
                this.f٢٢١٣h = new Path();
            }
            if (this.f٢٢١٥j == null) {
                this.f٢٢١٥j = new RectF();
            }
            if (this.f٢٢١٤i == null) {
                b bVar = new b();
                this.f٢٢١٤i = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f٢٢١٥j.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, getWidth(), getHeight());
            this.f٢٢١٣h.reset();
            Path path = this.f٢٢١٣h;
            RectF rectF = this.f٢٢١٥j;
            float f12 = this.f٢٢١٢g;
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
        if (this.f٢٢١١f != f10) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٢٢١١f = f10;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS) {
            if (this.f٢٢١٣h == null) {
                this.f٢٢١٣h = new Path();
            }
            if (this.f٢٢١٥j == null) {
                this.f٢٢١٥j = new RectF();
            }
            if (this.f٢٢١٤i == null) {
                a aVar = new a();
                this.f٢٢١٤i = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f٢٢١١f) / 2.0f;
            this.f٢٢١٥j.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, width, height);
            this.f٢٢١٣h.reset();
            this.f٢٢١٣h.addRoundRect(this.f٢٢١٥j, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f10) {
        c cVar = this.f٢٢٠٦a;
        cVar.f٢٢٢٨e = f10;
        cVar.c(this);
    }

    public void setWarmth(float f10) {
        c cVar = this.f٢٢٠٦a;
        cVar.f٢٢٣٠g = f10;
        cVar.c(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f٢٢٠٦a = new c();
        this.f٢٢٠٧b = true;
        this.f٢٢٠٨c = null;
        this.f٢٢٠٩d = null;
        this.f٢٢١٠e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢١١f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢١٢g = Float.NaN;
        this.f٢٢١٦k = new Drawable[2];
        this.f٢٢١٨m = Float.NaN;
        this.f٢٢١٩n = Float.NaN;
        this.f٢٢٢٠o = Float.NaN;
        this.f٢٢٢١p = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f٢٢٠٦a = new c();
        this.f٢٢٠٧b = true;
        this.f٢٢٠٨c = null;
        this.f٢٢٠٩d = null;
        this.f٢٢١٠e = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢١١f = DownloadProgress.UNKNOWN_PROGRESS;
        this.f٢٢١٢g = Float.NaN;
        this.f٢٢١٦k = new Drawable[2];
        this.f٢٢١٨m = Float.NaN;
        this.f٢٢١٩n = Float.NaN;
        this.f٢٢٢٠o = Float.NaN;
        this.f٢٢٢١p = Float.NaN;
        init(context, attributeSet);
    }
}
