package com.qiahao.base_common.wedgit.polygon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.a;
import com.qiahao.base_common.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import gb.b;
import gb.c;
import gb.d;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class PolygonImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Paint f١٢٦٦٥a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f١٢٦٦٦b;

    /* renamed from: c, reason: collision with root package name */
    private Path f١٢٦٦٧c;

    /* renamed from: d, reason: collision with root package name */
    private b f١٢٦٦٨d;

    /* renamed from: e, reason: collision with root package name */
    private c f١٢٦٦٩e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٢٦٧٠f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٢٦٧١g;

    public PolygonImageView(Context context) {
        this(context, null);
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i10 = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i10 = intrinsicHeight;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i10, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            Log.e("PolygonImageView", "OutOfMemory during bitmap creation");
            return null;
        }
    }

    private void b() {
        Paint paint = new Paint(1);
        this.f١٢٦٦٥a = paint;
        paint.setPathEffect(new CornerPathEffect(this.f١٢٦٦٩e.f()));
        Paint paint2 = new Paint(1);
        this.f١٢٦٦٦b = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f١٢٦٦٦b.setPathEffect(new CornerPathEffect(this.f١٢٦٦٩e.f()));
        if (this.f١٢٦٦٩e.n()) {
            this.f١٢٦٦٦b.setColor(this.f١٢٦٦٩e.b());
            this.f١٢٦٦٦b.setStrokeWidth(this.f١٢٦٦٩e.c());
        }
        if (this.f١٢٦٦٩e.o()) {
            this.f١٢٦٦٦b.setShadowLayer(this.f١٢٦٦٩e.k(), this.f١٢٦٦٩e.l(), this.f١٢٦٦٩e.m(), this.f١٢٦٦٩e.j());
        }
        setLayerType(1, null);
        this.f١٢٦٦٨d = new d();
    }

    private int c(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            return Math.min(this.f١٢٦٧٠f, this.f١٢٦٧١g);
        }
        return size;
    }

    private int d(int i10) {
        return c(i10) + 2;
    }

    private int e(int i10) {
        return c(i10);
    }

    private void f() {
        float f10;
        boolean n10 = this.f١٢٦٦٩e.n();
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        if (n10) {
            f10 = this.f١٢٦٦٩e.c();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.f١٢٦٦٩e.o()) {
            f11 = this.f١٢٦٦٩e.k();
        }
        c cVar = this.f١٢٦٦٩e;
        cVar.r((cVar.g() / 2.0f) + ((getPaddingLeft() + getPaddingRight()) / 2.0f) + f10 + f11);
        c cVar2 = this.f١٢٦٦٩e;
        cVar2.s((cVar2.g() / 2.0f) + ((getPaddingTop() + getPaddingBottom()) / 2.0f) + f10 + f11);
        if (this.f١٢٦٦٩e.h() < 3) {
            return;
        }
        this.f١٢٦٦٧c = this.f١٢٦٦٨d.a(this.f١٢٦٦٩e);
    }

    private void g() {
        Bitmap a10 = a(getDrawable());
        int min = Math.min(this.f١٢٦٧٠f, this.f١٢٦٧١g);
        if (min > 0 && a10 != null) {
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(a10, min, min);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f١٢٦٦٥a.setShader(new BitmapShader(extractThumbnail, tileMode, tileMode));
        }
    }

    private void h() {
        if (this.f١٢٦٦٩e.n()) {
            this.f١٢٦٦٦b.setStrokeWidth(this.f١٢٦٦٩e.c());
            this.f١٢٦٦٦b.setColor(this.f١٢٦٦٩e.b());
        } else {
            this.f١٢٦٦٦b.setStrokeWidth(DownloadProgress.UNKNOWN_PROGRESS);
            this.f١٢٦٦٦b.setColor(0);
        }
        i();
        invalidate();
    }

    private void i() {
        j(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    private void j(int i10, int i11, int i12, int i13) {
        float f10;
        c cVar = this.f١٢٦٦٩e;
        if (cVar == null) {
            return;
        }
        boolean n10 = cVar.n();
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        if (n10) {
            f10 = this.f١٢٦٦٩e.c();
        } else {
            f10 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (this.f١٢٦٦٩e.o()) {
            f11 = this.f١٢٦٦٩e.k();
        }
        float f12 = f10 * 2.0f;
        float f13 = f11 * 2.0f;
        float min = Math.min(this.f١٢٦٧٠f - (((i10 + i12) + f12) + f13), this.f١٢٦٧١g - (((i11 + i13) + f12) + f13));
        if (min != this.f١٢٦٦٩e.g()) {
            this.f١٢٦٦٩e.u(min);
            f();
        }
    }

    public b getPolygonShape() {
        return this.f١٢٦٦٨d;
    }

    public c getPolygonShapeSpec() {
        return this.f١٢٦٦٩e;
    }

    public float getRotationAngle() {
        return this.f١٢٦٦٩e.i();
    }

    public int getVertices() {
        return this.f١٢٦٦٩e.h();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null && getDrawable().getIntrinsicWidth() != 0 && getDrawable().getIntrinsicHeight() != 0) {
            int h10 = this.f١٢٦٦٩e.h();
            if (h10 != 0) {
                if (h10 != 1) {
                    if (h10 != 2) {
                        if (this.f١٢٦٦٩e.o() || this.f١٢٦٦٩e.n()) {
                            canvas.drawPath(this.f١٢٦٦٧c, this.f١٢٦٦٦b);
                        }
                        canvas.drawPath(this.f١٢٦٦٧c, this.f١٢٦٦٥a);
                        return;
                    }
                    if (this.f١٢٦٦٩e.o() || this.f١٢٦٦٩e.n()) {
                        canvas.drawRect(this.f١٢٦٦٩e.d() - (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٩e.e() - (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٩e.d() + (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٩e.e() + (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٦b);
                    }
                    canvas.drawRect(this.f١٢٦٦٩e.d() - (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٩e.e() - (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٩e.d() + (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٩e.e() + (this.f١٢٦٦٩e.g() / 2.0f), this.f١٢٦٦٥a);
                    return;
                }
                super.onDraw(canvas);
                return;
            }
            if (this.f١٢٦٦٩e.o() || this.f١٢٦٦٩e.n()) {
                canvas.drawCircle(this.f١٢٦٦٩e.d(), this.f١٢٦٦٩e.e(), this.f١٢٦٦٩e.g() / 2.0f, this.f١٢٦٦٦b);
            }
            canvas.drawCircle(this.f١٢٦٦٩e.d(), this.f١٢٦٦٩e.e(), this.f١٢٦٦٩e.g() / 2.0f, this.f١٢٦٦٥a);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(e(i10), d(i11));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f١٢٦٧٠f = i10;
        this.f١٢٦٧١g = i11;
        i();
        if (Math.min(this.f١٢٦٧٠f, this.f١٢٦٧١g) != Math.min(i12, i13)) {
            g();
        }
    }

    public void setBorder(boolean z10) {
        this.f١٢٦٦٩e.v(z10);
        h();
    }

    public void setBorderColor(int i10) {
        this.f١٢٦٦٩e.p(i10);
        this.f١٢٦٦٦b.setColor(i10);
        invalidate();
    }

    public void setBorderColorResource(int i10) {
        setBorderColor(getResources().getColor(i10));
    }

    public void setBorderWidth(float f10) {
        this.f١٢٦٦٩e.q(f10 * getResources().getDisplayMetrics().density);
        h();
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        this.f١٢٦٦٥a.setColorFilter(colorFilter);
        invalidate();
    }

    public void setColorFilterWithBorder(ColorFilter colorFilter) {
        this.f١٢٦٦٥a.setColorFilter(colorFilter);
        this.f١٢٦٦٦b.setColorFilter(colorFilter);
        invalidate();
    }

    public void setCornerRadius(float f10) {
        this.f١٢٦٦٩e.t(f10);
        this.f١٢٦٦٦b.setPathEffect(new CornerPathEffect(f10));
        this.f١٢٦٦٥a.setPathEffect(new CornerPathEffect(f10));
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        g();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        g();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        setImageDrawable(a.getDrawable(getContext(), i10));
        g();
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        g();
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        j(i10, i11, i12, i13);
        invalidate(i10, i11, i12, i13);
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
        i();
        invalidate();
    }

    public void setPolygonShape(b bVar) {
        this.f١٢٦٦٨d = bVar;
        f();
        invalidate();
    }

    public void setPolygonShapeSpec(c cVar) {
        this.f١٢٦٦٩e = cVar;
    }

    public void setRotationAngle(float f10) {
        this.f١٢٦٦٩e.y(f10);
        f();
        invalidate();
    }

    public void setVertices(int i10) {
        this.f١٢٦٦٩e.x(i10);
        f();
        invalidate();
    }

    public PolygonImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.polygonImageViewStyle);
    }

    public PolygonImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٦٦٩e = new c();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PolygonImageView, i10, 0);
        try {
            this.f١٢٦٦٩e.y(obtainStyledAttributes.getFloat(R.styleable.PolygonImageView_poly_rotation_angle, DownloadProgress.UNKNOWN_PROGRESS));
            this.f١٢٦٦٩e.x(obtainStyledAttributes.getInteger(R.styleable.PolygonImageView_poly_vertices, 6));
            this.f١٢٦٦٩e.t(obtainStyledAttributes.getFloat(R.styleable.PolygonImageView_poly_corner_radius, DownloadProgress.UNKNOWN_PROGRESS));
            this.f١٢٦٦٩e.w(obtainStyledAttributes.getBoolean(R.styleable.PolygonImageView_poly_shadow, false));
            this.f١٢٦٦٩e.z(obtainStyledAttributes.getColor(R.styleable.PolygonImageView_poly_shadow_color, -16777216));
            this.f١٢٦٦٩e.v(obtainStyledAttributes.getBoolean(R.styleable.PolygonImageView_poly_border, false));
            this.f١٢٦٦٩e.p(obtainStyledAttributes.getColor(R.styleable.PolygonImageView_poly_border_color, -1));
            this.f١٢٦٦٩e.q(obtainStyledAttributes.getDimension(R.styleable.PolygonImageView_poly_border_width, 4.0f));
            obtainStyledAttributes.recycle();
            b();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }
}
