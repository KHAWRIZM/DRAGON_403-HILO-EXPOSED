package com.qmuiteam.qmui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qmuiteam.qmui.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class QMUIRadiusImageView extends AppCompatImageView {

    /* renamed from: x, reason: collision with root package name */
    private static final Bitmap.Config f١٣٠١٣x = Bitmap.Config.ARGB_8888;

    /* renamed from: a, reason: collision with root package name */
    private boolean f١٣٠١٤a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f١٣٠١٥b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f١٣٠١٦c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٣٠١٧d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٣٠١٨e;

    /* renamed from: f, reason: collision with root package name */
    private int f١٣٠١٩f;

    /* renamed from: g, reason: collision with root package name */
    private int f١٣٠٢٠g;

    /* renamed from: h, reason: collision with root package name */
    private int f١٣٠٢١h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f١٣٠٢٢i;

    /* renamed from: j, reason: collision with root package name */
    private int f١٣٠٢٣j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f١٣٠٢٤k;

    /* renamed from: l, reason: collision with root package name */
    private Paint f١٣٠٢٥l;

    /* renamed from: m, reason: collision with root package name */
    private ColorFilter f١٣٠٢٦m;

    /* renamed from: n, reason: collision with root package name */
    private ColorFilter f١٣٠٢٧n;

    /* renamed from: o, reason: collision with root package name */
    private BitmapShader f١٣٠٢٨o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f١٣٠٢٩p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f١٣٠٣٠q;

    /* renamed from: r, reason: collision with root package name */
    private RectF f١٣٠٣١r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f١٣٠٣٢s;

    /* renamed from: t, reason: collision with root package name */
    private Matrix f١٣٠٣٣t;

    /* renamed from: u, reason: collision with root package name */
    private int f١٣٠٣٤u;

    /* renamed from: v, reason: collision with root package name */
    private int f١٣٠٣٥v;

    /* renamed from: w, reason: collision with root package name */
    private ImageView.ScaleType f١٣٠٣٦w;

    public QMUIRadiusImageView(Context context) {
        this(context, null, R.attr.QMUIRadiusImageViewStyle);
    }

    private Bitmap getBitmap() {
        Bitmap createBitmap;
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null) {
                return null;
            }
            float width = bitmap.getWidth();
            float height = bitmap.getHeight();
            if (width == DownloadProgress.UNKNOWN_PROGRESS || height == DownloadProgress.UNKNOWN_PROGRESS) {
                return null;
            }
            float minimumWidth = getMinimumWidth() / width;
            float minimumHeight = getMinimumHeight() / height;
            if (minimumWidth <= 1.0f && minimumHeight <= 1.0f) {
                return bitmap;
            }
            float max = Math.max(minimumWidth, minimumHeight);
            Matrix matrix = new Matrix();
            matrix.postScale(max, max);
            return Bitmap.createBitmap(bitmap, 0, 0, (int) width, (int) height, matrix, false);
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, f١٣٠١٣x);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f١٣٠١٣x);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private void k(Canvas canvas, int i10) {
        ColorFilter colorFilter;
        float f10 = (i10 * 1.0f) / 2.0f;
        Paint paint = this.f١٣٠٢٤k;
        if (this.f١٣٠١٤a) {
            colorFilter = this.f١٣٠٢٧n;
        } else {
            colorFilter = this.f١٣٠٢٦m;
        }
        paint.setColorFilter(colorFilter);
        if (this.f١٣٠١٦c) {
            canvas.drawCircle(this.f١٣٠٣٠q.centerX(), this.f١٣٠٣٠q.centerY(), Math.min(this.f١٣٠٣٠q.width() / 2.0f, this.f١٣٠٣٠q.height() / 2.0f) - f10, this.f١٣٠٢٤k);
            return;
        }
        RectF rectF = this.f١٣٠٣١r;
        RectF rectF2 = this.f١٣٠٣٠q;
        rectF.left = rectF2.left + f10;
        rectF.top = rectF2.top + f10;
        rectF.right = rectF2.right - f10;
        rectF.bottom = rectF2.bottom - f10;
        if (this.f١٣٠١٥b) {
            canvas.drawOval(rectF, this.f١٣٠٢٤k);
        } else {
            int i11 = this.f١٣٠٢٣j;
            canvas.drawRoundRect(rectF, i11, i11, this.f١٣٠٢٤k);
        }
    }

    private void l(Canvas canvas, int i10) {
        int i11;
        if (i10 <= 0) {
            return;
        }
        float f10 = i10;
        float f11 = (1.0f * f10) / 2.0f;
        Paint paint = this.f١٣٠٢٥l;
        if (this.f١٣٠١٤a) {
            i11 = this.f١٣٠٢٠g;
        } else {
            i11 = this.f١٣٠١٨e;
        }
        paint.setColor(i11);
        this.f١٣٠٢٥l.setStrokeWidth(f10);
        if (this.f١٣٠١٦c) {
            canvas.drawCircle(this.f١٣٠٣٠q.centerX(), this.f١٣٠٣٠q.centerY(), (Math.min(this.f١٣٠٣٠q.width(), this.f١٣٠٣٠q.height()) / 2.0f) - f11, this.f١٣٠٢٥l);
            return;
        }
        RectF rectF = this.f١٣٠٣١r;
        RectF rectF2 = this.f١٣٠٣٠q;
        rectF.left = rectF2.left + f11;
        rectF.top = rectF2.top + f11;
        rectF.right = rectF2.right - f11;
        rectF.bottom = rectF2.bottom - f11;
        if (this.f١٣٠١٥b) {
            canvas.drawOval(rectF, this.f١٣٠٢٥l);
        } else {
            int i12 = this.f١٣٠٢٣j;
            canvas.drawRoundRect(rectF, i12, i12, this.f١٣٠٢٥l);
        }
    }

    private void n() {
        Bitmap bitmap;
        this.f١٣٠٣٣t.reset();
        this.f١٣٠٢٩p = false;
        if (this.f١٣٠٢٨o != null && (bitmap = this.f١٣٠٣٢s) != null) {
            o(this.f١٣٠٣٣t, bitmap, this.f١٣٠٣٠q);
            this.f١٣٠٢٨o.setLocalMatrix(this.f١٣٠٣٣t);
            this.f١٣٠٢٤k.setShader(this.f١٣٠٢٨o);
        }
    }

    private void o(Matrix matrix, Bitmap bitmap, RectF rectF) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        ImageView.ScaleType scaleType = getScaleType();
        if (scaleType == ImageView.ScaleType.MATRIX) {
            p(matrix, bitmap, rectF);
            return;
        }
        if (scaleType == ImageView.ScaleType.CENTER) {
            float f10 = (this.f١٣٠٣٤u - width) / 2.0f;
            float f11 = (this.f١٣٠٣٥v - height) / 2.0f;
            matrix.postTranslate(f10, f11);
            rectF.set(Math.max(DownloadProgress.UNKNOWN_PROGRESS, f10), Math.max(DownloadProgress.UNKNOWN_PROGRESS, f11), Math.min(f10 + width, this.f١٣٠٣٤u), Math.min(f11 + height, this.f١٣٠٣٥v));
            return;
        }
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(this.f١٣٠٣٤u / width, this.f١٣٠٣٥v / height);
            matrix.setScale(max, max);
            matrix.postTranslate((-((width * max) - this.f١٣٠٣٤u)) / 2.0f, (-((max * height) - this.f١٣٠٣٥v)) / 2.0f);
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f١٣٠٣٤u, this.f١٣٠٣٥v);
            return;
        }
        if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            int i10 = this.f١٣٠٣٤u;
            float f12 = i10 / width;
            int i11 = this.f١٣٠٣٥v;
            float f13 = i11 / height;
            if (f12 >= 1.0f && f13 >= 1.0f) {
                float f14 = (i10 - width) / 2.0f;
                float f15 = (i11 - height) / 2.0f;
                matrix.postTranslate(f14, f15);
                rectF.set(f14, f15, width + f14, height + f15);
                return;
            }
            float min = Math.min(f12, f13);
            matrix.setScale(min, min);
            float f16 = width * min;
            float f17 = height * min;
            float f18 = (this.f١٣٠٣٤u - f16) / 2.0f;
            float f19 = (this.f١٣٠٣٥v - f17) / 2.0f;
            matrix.postTranslate(f18, f19);
            rectF.set(f18, f19, f16 + f18, f17 + f19);
            return;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            matrix.setScale(this.f١٣٠٣٤u / width, this.f١٣٠٣٥v / height);
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f١٣٠٣٤u, this.f١٣٠٣٥v);
            return;
        }
        float min2 = Math.min(this.f١٣٠٣٤u / width, this.f١٣٠٣٥v / height);
        matrix.setScale(min2, min2);
        float f20 = width * min2;
        float f21 = height * min2;
        if (scaleType == ImageView.ScaleType.FIT_START) {
            rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f20, f21);
            return;
        }
        if (scaleType == ImageView.ScaleType.FIT_CENTER) {
            float f22 = (this.f١٣٠٣٤u - f20) / 2.0f;
            float f23 = (this.f١٣٠٣٥v - f21) / 2.0f;
            matrix.postTranslate(f22, f23);
            rectF.set(f22, f23, f20 + f22, f21 + f23);
            return;
        }
        matrix.postTranslate(this.f١٣٠٣٤u - f20, this.f١٣٠٣٥v - f21);
        int i12 = this.f١٣٠٣٤u;
        float f24 = i12 - f20;
        int i13 = this.f١٣٠٣٥v;
        rectF.set(f24, i13 - f21, i12, i13);
    }

    public int getBorderColor() {
        return this.f١٣٠١٨e;
    }

    public int getBorderWidth() {
        return this.f١٣٠١٧d;
    }

    public int getCornerRadius() {
        return this.f١٣٠٢٣j;
    }

    public int getSelectedBorderColor() {
        return this.f١٣٠٢٠g;
    }

    public int getSelectedBorderWidth() {
        return this.f١٣٠١٩f;
    }

    public int getSelectedMaskColor() {
        return this.f١٣٠٢١h;
    }

    @Override // android.view.View
    public boolean isSelected() {
        return this.f١٣٠١٤a;
    }

    public void m() {
        Bitmap bitmap = getBitmap();
        if (bitmap == this.f١٣٠٣٢s) {
            return;
        }
        this.f١٣٠٣٢s = bitmap;
        if (bitmap == null) {
            this.f١٣٠٢٨o = null;
            invalidate();
            return;
        }
        this.f١٣٠٢٩p = true;
        Bitmap bitmap2 = this.f١٣٠٣٢s;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.f١٣٠٢٨o = new BitmapShader(bitmap2, tileMode, tileMode);
        if (this.f١٣٠٢٤k == null) {
            Paint paint = new Paint();
            this.f١٣٠٢٤k = paint;
            paint.setAntiAlias(true);
        }
        this.f١٣٠٢٤k.setShader(this.f١٣٠٢٨o);
        requestLayout();
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            if (this.f١٣٠١٤a) {
                i10 = this.f١٣٠١٩f;
            } else {
                i10 = this.f١٣٠١٧d;
            }
            if (this.f١٣٠٣٢s != null && this.f١٣٠٢٨o != null) {
                if (this.f١٣٠٣٤u != width || this.f١٣٠٣٥v != height || this.f١٣٠٣٦w != getScaleType() || this.f١٣٠٢٩p) {
                    this.f١٣٠٣٤u = width;
                    this.f١٣٠٣٥v = height;
                    this.f١٣٠٣٦w = getScaleType();
                    n();
                }
                k(canvas, i10);
                l(canvas, i10);
                return;
            }
            l(canvas, i10);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (mode == 1073741824 && mode2 == 1073741824) {
            setMeasuredDimension(size, size2);
            return;
        }
        if (this.f١٣٠١٦c) {
            if (mode == 1073741824) {
                setMeasuredDimension(size, size);
                return;
            }
            if (mode2 == 1073741824) {
                setMeasuredDimension(size2, size2);
                return;
            }
            Bitmap bitmap = this.f١٣٠٣٢s;
            if (bitmap == null) {
                setMeasuredDimension(0, 0);
                return;
            } else {
                int min = Math.min(Math.min(bitmap.getWidth(), size), Math.min(this.f١٣٠٣٢s.getHeight(), size2));
                setMeasuredDimension(min, min);
                return;
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isClickable()) {
            setSelected(false);
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f١٣٠٢٢i) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action == 3 || action == 4 || action == 8) {
                setSelected(false);
            }
        } else {
            setSelected(true);
        }
        return super.onTouchEvent(motionEvent);
    }

    protected void p(Matrix matrix, Bitmap bitmap, RectF rectF) {
        matrix.set(getImageMatrix());
        rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, this.f١٣٠٣٤u, this.f١٣٠٣٥v);
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z10) {
        if (!z10) {
        } else {
            throw new IllegalArgumentException("不支持adjustViewBounds");
        }
    }

    public void setBorderColor(int i10) {
        if (this.f١٣٠١٨e != i10) {
            this.f١٣٠١٨e = i10;
            invalidate();
        }
    }

    public void setBorderWidth(int i10) {
        if (this.f١٣٠١٧d != i10) {
            this.f١٣٠١٧d = i10;
            invalidate();
        }
    }

    public void setCircle(boolean z10) {
        if (this.f١٣٠١٦c != z10) {
            this.f١٣٠١٦c = z10;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f١٣٠٢٦m == colorFilter) {
            return;
        }
        this.f١٣٠٢٦m = colorFilter;
        if (!this.f١٣٠١٤a) {
            invalidate();
        }
    }

    public void setCornerRadius(int i10) {
        if (this.f١٣٠٢٣j != i10) {
            this.f١٣٠٢٣j = i10;
            if (!this.f١٣٠١٦c && !this.f١٣٠١٥b) {
                invalidate();
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m();
    }

    public void setOval(boolean z10) {
        boolean z11 = false;
        if (z10 && this.f١٣٠١٦c) {
            this.f١٣٠١٦c = false;
            z11 = true;
        }
        if (this.f١٣٠١٥b != z10 || z11) {
            this.f١٣٠١٥b = z10;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z10) {
        if (this.f١٣٠١٤a != z10) {
            this.f١٣٠١٤a = z10;
            invalidate();
        }
    }

    public void setSelectedBorderColor(int i10) {
        if (this.f١٣٠٢٠g != i10) {
            this.f١٣٠٢٠g = i10;
            if (this.f١٣٠١٤a) {
                invalidate();
            }
        }
    }

    public void setSelectedBorderWidth(int i10) {
        if (this.f١٣٠١٩f != i10) {
            this.f١٣٠١٩f = i10;
            if (this.f١٣٠١٤a) {
                invalidate();
            }
        }
    }

    public void setSelectedColorFilter(ColorFilter colorFilter) {
        if (this.f١٣٠٢٧n == colorFilter) {
            return;
        }
        this.f١٣٠٢٧n = colorFilter;
        if (this.f١٣٠١٤a) {
            invalidate();
        }
    }

    public void setSelectedMaskColor(int i10) {
        if (this.f١٣٠٢١h != i10) {
            this.f١٣٠٢١h = i10;
            if (i10 != 0) {
                this.f١٣٠٢٧n = new PorterDuffColorFilter(this.f١٣٠٢١h, PorterDuff.Mode.DARKEN);
            } else {
                this.f١٣٠٢٧n = null;
            }
            if (this.f١٣٠١٤a) {
                invalidate();
            }
        }
        this.f١٣٠٢١h = i10;
    }

    public void setTouchSelectModeEnabled(boolean z10) {
        this.f١٣٠٢٢i = z10;
    }

    public QMUIRadiusImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.QMUIRadiusImageViewStyle);
    }

    public QMUIRadiusImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٣٠١٤a = false;
        this.f١٣٠١٥b = false;
        this.f١٣٠١٦c = false;
        this.f١٣٠٢٢i = true;
        this.f١٣٠٢٩p = false;
        this.f١٣٠٣٠q = new RectF();
        this.f١٣٠٣١r = new RectF();
        Paint paint = new Paint();
        this.f١٣٠٢٥l = paint;
        paint.setAntiAlias(true);
        this.f١٣٠٢٥l.setStyle(Paint.Style.STROKE);
        this.f١٣٠٣٣t = new Matrix();
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUIRadiusImageView, i10, 0);
        this.f١٣٠١٧d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_border_width, 0);
        this.f١٣٠١٨e = obtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView_qmui_border_color, -7829368);
        this.f١٣٠١٩f = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_selected_border_width, this.f١٣٠١٧d);
        this.f١٣٠٢٠g = obtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView_qmui_selected_border_color, this.f١٣٠١٨e);
        int color = obtainStyledAttributes.getColor(R.styleable.QMUIRadiusImageView_qmui_selected_mask_color, 0);
        this.f١٣٠٢١h = color;
        if (color != 0) {
            this.f١٣٠٢٧n = new PorterDuffColorFilter(this.f١٣٠٢١h, PorterDuff.Mode.DARKEN);
        }
        this.f١٣٠٢٢i = obtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_touch_select_mode_enabled, true);
        boolean z10 = obtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_circle, false);
        this.f١٣٠١٦c = z10;
        if (!z10) {
            this.f١٣٠١٥b = obtainStyledAttributes.getBoolean(R.styleable.QMUIRadiusImageView_qmui_is_oval, false);
        }
        if (!this.f١٣٠١٥b) {
            this.f١٣٠٢٣j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.QMUIRadiusImageView_qmui_corner_radius, 0);
        }
        obtainStyledAttributes.recycle();
    }
}
