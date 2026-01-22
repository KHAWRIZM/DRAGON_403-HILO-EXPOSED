package com.google.android.material.floatingactionbutton;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.x;
import com.google.android.material.drawable.g;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import f8.p;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class c extends Drawable {

    /* renamed from: b, reason: collision with root package name */
    private final Paint f٩٠٧٥b;

    /* renamed from: h, reason: collision with root package name */
    float f٩٠٨١h;

    /* renamed from: i, reason: collision with root package name */
    private int f٩٠٨٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٠٨٣j;

    /* renamed from: k, reason: collision with root package name */
    private int f٩٠٨٤k;

    /* renamed from: l, reason: collision with root package name */
    private int f٩٠٨٥l;

    /* renamed from: m, reason: collision with root package name */
    private int f٩٠٨٦m;

    /* renamed from: o, reason: collision with root package name */
    private o f٩٠٨٨o;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f٩٠٨٩p;

    /* renamed from: a, reason: collision with root package name */
    private final p f٩٠٧٤a = p.l();

    /* renamed from: c, reason: collision with root package name */
    private final Path f٩٠٧٦c = new Path();

    /* renamed from: d, reason: collision with root package name */
    private final Rect f٩٠٧٧d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private final RectF f٩٠٧٨e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private final RectF f٩٠٧٩f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private final b f٩٠٨٠g = new b();

    /* renamed from: n, reason: collision with root package name */
    private boolean f٩٠٨٧n = true;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class b extends Drawable.ConstantState {
        private b() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return c.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(o oVar) {
        this.f٩٠٨٨o = oVar;
        Paint paint = new Paint(1);
        this.f٩٠٧٥b = paint;
        paint.setStyle(Paint.Style.STROKE);
    }

    private Shader a() {
        copyBounds(this.f٩٠٧٧d);
        float height = this.f٩٠٨١h / r1.height();
        return new LinearGradient(DownloadProgress.UNKNOWN_PROGRESS, r1.top, DownloadProgress.UNKNOWN_PROGRESS, r1.bottom, new int[]{x.g(this.f٩٠٨٢i, this.f٩٠٨٦m), x.g(this.f٩٠٨٣j, this.f٩٠٨٦m), x.g(x.l(this.f٩٠٨٣j, 0), this.f٩٠٨٦m), x.g(x.l(this.f٩٠٨٥l, 0), this.f٩٠٨٦m), x.g(this.f٩٠٨٥l, this.f٩٠٨٦m), x.g(this.f٩٠٨٤k, this.f٩٠٨٦m)}, new float[]{DownloadProgress.UNKNOWN_PROGRESS, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }

    protected RectF b() {
        this.f٩٠٧٩f.set(getBounds());
        return this.f٩٠٧٩f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f٩٠٨٦m = colorStateList.getColorForState(getState(), this.f٩٠٨٦m);
        }
        this.f٩٠٨٩p = colorStateList;
        this.f٩٠٨٧n = true;
        invalidateSelf();
    }

    public void d(float f10) {
        if (this.f٩٠٨١h != f10) {
            this.f٩٠٨١h = f10;
            this.f٩٠٧٥b.setStrokeWidth(f10 * 1.3333f);
            this.f٩٠٨٧n = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f٩٠٨٧n) {
            this.f٩٠٧٥b.setShader(a());
            this.f٩٠٨٧n = false;
        }
        float strokeWidth = this.f٩٠٧٥b.getStrokeWidth() / 2.0f;
        copyBounds(this.f٩٠٧٧d);
        this.f٩٠٧٨e.set(this.f٩٠٧٧d);
        float min = Math.min(this.f٩٠٨٨o.r().a(b()), this.f٩٠٧٨e.width() / 2.0f);
        if (this.f٩٠٨٨o.v(b())) {
            this.f٩٠٧٨e.inset(strokeWidth, strokeWidth);
            canvas.drawRoundRect(this.f٩٠٧٨e, min, min, this.f٩٠٧٥b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(int i10, int i11, int i12, int i13) {
        this.f٩٠٨٢i = i10;
        this.f٩٠٨٣j = i11;
        this.f٩٠٨٤k = i12;
        this.f٩٠٨٥l = i13;
    }

    public void f(o oVar) {
        this.f٩٠٨٨o = oVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f٩٠٨٠g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f٩٠٨١h > DownloadProgress.UNKNOWN_PROGRESS) {
            return -3;
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f٩٠٨٨o.v(b())) {
            outline.setRoundRect(getBounds(), this.f٩٠٨٨o.r().a(b()));
        } else {
            copyBounds(this.f٩٠٧٧d);
            this.f٩٠٧٨e.set(this.f٩٠٧٧d);
            this.f٩٠٧٤a.d(this.f٩٠٨٨o, 1.0f, this.f٩٠٧٨e, this.f٩٠٧٦c);
            g.l(outline, this.f٩٠٧٦c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.f٩٠٨٨o.v(b())) {
            int round = Math.round(this.f٩٠٨١h);
            rect.set(round, round, round, round);
            return true;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = this.f٩٠٨٩p;
        if ((colorStateList != null && colorStateList.isStateful()) || super.isStateful()) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f٩٠٨٧n = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        ColorStateList colorStateList = this.f٩٠٨٩p;
        if (colorStateList != null && (colorForState = colorStateList.getColorForState(iArr, this.f٩٠٨٦m)) != this.f٩٠٨٦m) {
            this.f٩٠٨٧n = true;
            this.f٩٠٨٦m = colorForState;
        }
        if (this.f٩٠٨٧n) {
            invalidateSelf();
        }
        return this.f٩٠٨٧n;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f٩٠٧٥b.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f٩٠٧٥b.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
