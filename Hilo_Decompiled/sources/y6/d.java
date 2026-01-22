package y6;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.github.siyamed.shapeimageview.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    protected int f١٩١٧٢a;

    /* renamed from: b, reason: collision with root package name */
    protected int f١٩١٧٣b;

    /* renamed from: g, reason: collision with root package name */
    protected final Paint f١٩١٧٨g;

    /* renamed from: h, reason: collision with root package name */
    protected final Paint f١٩١٧٩h;

    /* renamed from: i, reason: collision with root package name */
    protected BitmapShader f١٩١٨٠i;

    /* renamed from: j, reason: collision with root package name */
    protected Drawable f١٩١٨١j;

    /* renamed from: c, reason: collision with root package name */
    protected int f١٩١٧٤c = -16777216;

    /* renamed from: d, reason: collision with root package name */
    protected int f١٩١٧٥d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected float f١٩١٧٦e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f١٩١٧٧f = false;

    /* renamed from: k, reason: collision with root package name */
    protected final Matrix f١٩١٨٢k = new Matrix();

    public d() {
        Paint paint = new Paint();
        this.f١٩١٧٨g = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f١٩١٧٩h = paint2;
        paint2.setAntiAlias(true);
    }

    public abstract void a(int i10, int i11, float f10, float f11, float f12, float f13, float f14);

    public Bitmap b() {
        float f10;
        float round;
        Bitmap f11 = f();
        if (f11 != null) {
            int width = f11.getWidth();
            int height = f11.getHeight();
            if (width > 0 && height > 0) {
                float round2 = Math.round(this.f١٩١٧٢a - (this.f١٩١٧٥d * 2.0f));
                float round3 = Math.round(this.f١٩١٧٣b - (this.f١٩١٧٥d * 2.0f));
                float f12 = width;
                float f13 = f12 * round3;
                float f14 = height;
                float f15 = round2 * f14;
                float f16 = DownloadProgress.UNKNOWN_PROGRESS;
                if (f13 > f15) {
                    f10 = round3 / f14;
                    f16 = Math.round(((round2 / f10) - f12) / 2.0f);
                    round = DownloadProgress.UNKNOWN_PROGRESS;
                } else {
                    float f17 = round2 / f12;
                    f10 = f17;
                    round = Math.round(((round3 / f17) - f14) / 2.0f);
                }
                this.f١٩١٨٢k.setScale(f10, f10);
                this.f١٩١٨٢k.preTranslate(f16, round);
                Matrix matrix = this.f١٩١٨٢k;
                int i10 = this.f١٩١٧٥d;
                matrix.postTranslate(i10, i10);
                a(width, height, round2, round3, f10, f16, round);
                return f11;
            }
        }
        n();
        return null;
    }

    protected void c() {
        Bitmap b10 = b();
        if (b10 != null && b10.getWidth() > 0 && b10.getHeight() > 0) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(b10, tileMode, tileMode);
            this.f١٩١٨٠i = bitmapShader;
            this.f١٩١٧٩h.setShader(bitmapShader);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int d(DisplayMetrics displayMetrics, int i10) {
        return Math.round(i10 * (displayMetrics.xdpi / 160.0f));
    }

    public abstract void e(Canvas canvas, Paint paint, Paint paint2);

    protected Bitmap f() {
        Drawable drawable = this.f١٩١٨١j;
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    public final float g() {
        return this.f١٩١٧٦e;
    }

    public final int h() {
        return this.f١٩١٧٥d;
    }

    public void i(Context context, AttributeSet attributeSet, int i10) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShaderImageView, i10, 0);
            this.f١٩١٧٤c = obtainStyledAttributes.getColor(R.styleable.ShaderImageView_siBorderColor, this.f١٩١٧٤c);
            this.f١٩١٧٥d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShaderImageView_siBorderWidth, this.f١٩١٧٥d);
            this.f١٩١٧٦e = obtainStyledAttributes.getFloat(R.styleable.ShaderImageView_siBorderAlpha, this.f١٩١٧٦e);
            this.f١٩١٧٧f = obtainStyledAttributes.getBoolean(R.styleable.ShaderImageView_siSquare, this.f١٩١٧٧f);
            obtainStyledAttributes.recycle();
        }
        this.f١٩١٧٨g.setColor(this.f١٩١٧٤c);
        this.f١٩١٧٨g.setAlpha(Float.valueOf(this.f١٩١٧٦e * 255.0f).intValue());
        this.f١٩١٧٨g.setStrokeWidth(this.f١٩١٧٥d);
    }

    public final boolean j() {
        return this.f١٩١٧٧f;
    }

    public boolean k(Canvas canvas) {
        if (this.f١٩١٨٠i == null) {
            c();
        }
        if (this.f١٩١٨٠i != null && this.f١٩١٧٢a > 0 && this.f١٩١٧٣b > 0) {
            e(canvas, this.f١٩١٧٩h, this.f١٩١٧٨g);
            return true;
        }
        return false;
    }

    public final void l(Drawable drawable) {
        this.f١٩١٨١j = drawable;
        this.f١٩١٨٠i = null;
        this.f١٩١٧٩h.setShader(null);
    }

    public void m(int i10, int i11) {
        if (this.f١٩١٧٢a == i10 && this.f١٩١٧٣b == i11) {
            return;
        }
        this.f١٩١٧٢a = i10;
        this.f١٩١٧٣b = i11;
        if (j()) {
            int min = Math.min(i10, i11);
            this.f١٩١٧٣b = min;
            this.f١٩١٧٢a = min;
        }
        if (this.f١٩١٨٠i != null) {
            b();
        }
    }

    public abstract void n();

    public final void o(float f10) {
        this.f١٩١٧٦e = f10;
        Paint paint = this.f١٩١٧٨g;
        if (paint != null) {
            paint.setAlpha(Float.valueOf(f10 * 255.0f).intValue());
        }
    }

    public final void p(int i10) {
        this.f١٩١٧٤c = i10;
        Paint paint = this.f١٩١٧٨g;
        if (paint != null) {
            paint.setColor(i10);
        }
    }

    public final void q(int i10) {
        this.f١٩١٧٥d = i10;
        Paint paint = this.f١٩١٧٨g;
        if (paint != null) {
            paint.setStrokeWidth(i10);
        }
    }

    public final void r(boolean z10) {
        this.f١٩١٧٧f = z10;
    }
}
