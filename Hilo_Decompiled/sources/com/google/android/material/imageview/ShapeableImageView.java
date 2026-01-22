package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.Dimension;
import androidx.appcompat.widget.AppCompatImageView;
import c8.c;
import com.google.android.material.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.i;
import f8.o;
import f8.p;
import f8.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ShapeableImageView extends AppCompatImageView implements r {

    /* renamed from: s, reason: collision with root package name */
    private static final int f٩١٤٩s = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: a, reason: collision with root package name */
    private final p f٩١٥٠a;

    /* renamed from: b, reason: collision with root package name */
    private final RectF f٩١٥١b;

    /* renamed from: c, reason: collision with root package name */
    private final RectF f٩١٥٢c;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f٩١٥٣d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f٩١٥٤e;

    /* renamed from: f, reason: collision with root package name */
    private final Path f٩١٥٥f;

    /* renamed from: g, reason: collision with root package name */
    private ColorStateList f٩١٥٦g;

    /* renamed from: h, reason: collision with root package name */
    private i f٩١٥٧h;

    /* renamed from: i, reason: collision with root package name */
    private o f٩١٥٨i;

    /* renamed from: j, reason: collision with root package name */
    private float f٩١٥٩j;

    /* renamed from: k, reason: collision with root package name */
    private Path f٩١٦٠k;

    /* renamed from: l, reason: collision with root package name */
    private int f٩١٦١l;

    /* renamed from: m, reason: collision with root package name */
    private int f٩١٦٢m;

    /* renamed from: n, reason: collision with root package name */
    private int f٩١٦٣n;

    /* renamed from: o, reason: collision with root package name */
    private int f٩١٦٤o;

    /* renamed from: p, reason: collision with root package name */
    private int f٩١٦٥p;

    /* renamed from: q, reason: collision with root package name */
    private int f٩١٦٦q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٩١٦٧r;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        private final Rect f٩١٦٨a = new Rect();

        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f٩١٥٨i == null) {
                return;
            }
            if (ShapeableImageView.this.f٩١٥٧h == null) {
                ShapeableImageView.this.f٩١٥٧h = new i(ShapeableImageView.this.f٩١٥٨i);
            }
            ShapeableImageView.this.f٩١٥١b.round(this.f٩١٦٨a);
            ShapeableImageView.this.f٩١٥٧h.setBounds(this.f٩١٦٨a);
            ShapeableImageView.this.f٩١٥٧h.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context) {
        this(context, null, 0);
    }

    private void o(Canvas canvas) {
        if (this.f٩١٥٦g == null) {
            return;
        }
        this.f٩١٥٣d.setStrokeWidth(this.f٩١٥٩j);
        int colorForState = this.f٩١٥٦g.getColorForState(getDrawableState(), this.f٩١٥٦g.getDefaultColor());
        if (this.f٩١٥٩j > DownloadProgress.UNKNOWN_PROGRESS && colorForState != 0) {
            this.f٩١٥٣d.setColor(colorForState);
            canvas.drawPath(this.f٩١٥٥f, this.f٩١٥٣d);
        }
    }

    private boolean p() {
        if (this.f٩١٦٥p == Integer.MIN_VALUE && this.f٩١٦٦q == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    private boolean q() {
        if (getLayoutDirection() == 1) {
            return true;
        }
        return false;
    }

    private void r(int i10, int i11) {
        this.f٩١٥١b.set(getPaddingLeft(), getPaddingTop(), i10 - getPaddingRight(), i11 - getPaddingBottom());
        this.f٩١٥٠a.d(this.f٩١٥٨i, 1.0f, this.f٩١٥١b, this.f٩١٥٥f);
        this.f٩١٦٠k.rewind();
        this.f٩١٦٠k.addPath(this.f٩١٥٥f);
        this.f٩١٥٢c.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i11);
        this.f٩١٦٠k.addRect(this.f٩١٥٢c, Path.Direction.CCW);
    }

    @Dimension
    public int getContentPaddingBottom() {
        return this.f٩١٦٤o;
    }

    @Dimension
    public final int getContentPaddingEnd() {
        int i10 = this.f٩١٦٦q;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (q()) {
            return this.f٩١٦١l;
        }
        return this.f٩١٦٣n;
    }

    @Dimension
    public int getContentPaddingLeft() {
        int i10;
        int i11;
        if (p()) {
            if (q() && (i11 = this.f٩١٦٦q) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!q() && (i10 = this.f٩١٦٥p) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f٩١٦١l;
    }

    @Dimension
    public int getContentPaddingRight() {
        int i10;
        int i11;
        if (p()) {
            if (q() && (i11 = this.f٩١٦٥p) != Integer.MIN_VALUE) {
                return i11;
            }
            if (!q() && (i10 = this.f٩١٦٦q) != Integer.MIN_VALUE) {
                return i10;
            }
        }
        return this.f٩١٦٣n;
    }

    @Dimension
    public final int getContentPaddingStart() {
        int i10 = this.f٩١٦٥p;
        if (i10 != Integer.MIN_VALUE) {
            return i10;
        }
        if (q()) {
            return this.f٩١٦٣n;
        }
        return this.f٩١٦١l;
    }

    @Dimension
    public int getContentPaddingTop() {
        return this.f٩١٦٢m;
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    @Dimension
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // f8.r
    public o getShapeAppearanceModel() {
        return this.f٩١٥٨i;
    }

    public ColorStateList getStrokeColor() {
        return this.f٩١٥٦g;
    }

    @Dimension
    public float getStrokeWidth() {
        return this.f٩١٥٩j;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f٩١٦٠k, this.f٩١٥٤e);
        o(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f٩١٦٧r || !isLayoutDirectionResolved()) {
            return;
        }
        this.f٩١٦٧r = true;
        if (!isPaddingRelative() && !p()) {
            setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
        } else {
            setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        r(i10, i11);
    }

    @Override // android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10 + getContentPaddingLeft(), i11 + getContentPaddingTop(), i12 + getContentPaddingRight(), i13 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10 + getContentPaddingStart(), i11 + getContentPaddingTop(), i12 + getContentPaddingEnd(), i13 + getContentPaddingBottom());
    }

    @Override // f8.r
    public void setShapeAppearanceModel(o oVar) {
        this.f٩١٥٨i = oVar;
        i iVar = this.f٩١٥٧h;
        if (iVar != null) {
            iVar.setShapeAppearanceModel(oVar);
        }
        r(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f٩١٥٦g = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i10) {
        setStrokeColor(r1.a.a(getContext(), i10));
    }

    public void setStrokeWidth(@Dimension float f10) {
        if (this.f٩١٥٩j != f10) {
            this.f٩١٥٩j = f10;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i10) {
        setStrokeWidth(getResources().getDimensionPixelSize(i10));
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ShapeableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(g8.a.d(context, attributeSet, i10, r0), attributeSet, i10);
        int i11 = f٩١٤٩s;
        this.f٩١٥٠a = p.l();
        this.f٩١٥٥f = new Path();
        this.f٩١٦٧r = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f٩١٥٤e = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f٩١٥١b = new RectF();
        this.f٩١٥٢c = new RectF();
        this.f٩١٦٠k = new Path();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.ShapeableImageView, i10, i11);
        setLayerType(2, null);
        this.f٩١٥٦g = c.a(context2, obtainStyledAttributes, R.styleable.ShapeableImageView_strokeColor);
        this.f٩١٥٩j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_strokeWidth, 0);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPadding, 0);
        this.f٩١٦١l = dimensionPixelSize;
        this.f٩١٦٢m = dimensionPixelSize;
        this.f٩١٦٣n = dimensionPixelSize;
        this.f٩١٦٤o = dimensionPixelSize;
        this.f٩١٦١l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingLeft, dimensionPixelSize);
        this.f٩١٦٢m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingTop, dimensionPixelSize);
        this.f٩١٦٣n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingRight, dimensionPixelSize);
        this.f٩١٦٤o = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingBottom, dimensionPixelSize);
        this.f٩١٦٥p = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingStart, Integer.MIN_VALUE);
        this.f٩١٦٦q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ShapeableImageView_contentPaddingEnd, Integer.MIN_VALUE);
        obtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f٩١٥٣d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f٩١٥٨i = o.e(context2, attributeSet, i10, i11).m();
        setOutlineProvider(new a());
    }
}
