package com.qiahao.nextvideo.ui.reusable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.qiahao.nextvideo.R;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class CircleImageView extends AppCompatImageView {
    private static final ImageView.ScaleType u = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config v = Bitmap.Config.ARGB_8888;
    private final RectF a;
    private final RectF b;
    private final Matrix c;
    private final Paint d;
    private final Paint e;
    private final Paint f;
    private int g;
    private int h;
    private int i;
    private Bitmap j;
    private BitmapShader k;
    private int l;
    private int m;
    private float n;
    private float o;
    private ColorFilter p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Rect rect = new Rect();
            CircleImageView.this.b.roundOut(rect);
            outline.setRoundRect(rect, rect.width() / 2.0f);
        }

        private a() {
        }
    }

    public CircleImageView(Context context) {
        super(context);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.h = 0;
        this.i = 0;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void init() {
        super/*android.widget.ImageView*/.setScaleType(u);
        this.q = true;
        setOutlineProvider(new a());
        if (this.r) {
            q();
            this.r = false;
        }
    }

    private void l() {
        this.d.setColorFilter(this.p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private RectF m() {
        int min = Math.min((getWidth() - getPaddingLeft()) - getPaddingRight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        float paddingLeft = getPaddingLeft() + ((r0 - min) / 2.0f);
        float paddingTop = getPaddingTop() + ((r1 - min) / 2.0f);
        float f = min;
        return new RectF(paddingLeft, paddingTop, paddingLeft + f, f + paddingTop);
    }

    private Bitmap n(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(2, 2, v);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), v);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean o(float f, float f2) {
        if (Math.pow(f - this.b.centerX(), 2.0d) + Math.pow(f2 - this.b.centerY(), 2.0d) <= Math.pow(this.o, 2.0d)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void p() {
        if (this.t) {
            this.j = null;
        } else {
            this.j = n(getDrawable());
        }
        q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void q() {
        int i;
        if (!this.q) {
            this.r = true;
            return;
        }
        if (getWidth() == 0 && getHeight() == 0) {
            return;
        }
        if (this.j == null) {
            invalidate();
            return;
        }
        Bitmap bitmap = this.j;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.k = new BitmapShader(bitmap, tileMode, tileMode);
        this.d.setAntiAlias(true);
        this.d.setShader(this.k);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setAntiAlias(true);
        this.e.setColor(this.g);
        this.e.setStrokeWidth(this.h);
        this.f.setStyle(Paint.Style.FILL);
        this.f.setAntiAlias(true);
        this.f.setColor(this.i);
        this.m = this.j.getHeight();
        this.l = this.j.getWidth();
        this.b.set(m());
        this.o = Math.min((this.b.height() - this.h) / 2.0f, (this.b.width() - this.h) / 2.0f);
        this.a.set(this.b);
        if (!this.s && (i = this.h) > 0) {
            this.a.inset(i - 1.0f, i - 1.0f);
        }
        this.n = Math.min(this.a.height() / 2.0f, this.a.width() / 2.0f);
        l();
        r();
        invalidate();
    }

    private void r() {
        float width;
        float height;
        this.c.set(null);
        float f = 0.0f;
        if (this.l * this.a.height() > this.a.width() * this.m) {
            width = this.a.height() / this.m;
            f = (this.a.width() - (this.l * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = this.a.width() / this.l;
            height = (this.a.height() - (this.m * width)) * 0.5f;
        }
        this.c.setScale(width, width);
        Matrix matrix = this.c;
        RectF rectF = this.a;
        matrix.postTranslate(((int) (f + 0.5f)) + rectF.left, ((int) (height + 0.5f)) + rectF.top);
        this.k.setLocalMatrix(this.c);
    }

    public int getBorderColor() {
        return this.g;
    }

    public int getBorderWidth() {
        return this.h;
    }

    public int getCircleBackgroundColor() {
        return this.i;
    }

    public ColorFilter getColorFilter() {
        return this.p;
    }

    public ImageView.ScaleType getScaleType() {
        return u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(Canvas canvas) {
        if (this.t) {
            super/*android.widget.ImageView*/.onDraw(canvas);
            return;
        }
        if (this.j == null) {
            return;
        }
        if (this.i != 0) {
            canvas.drawCircle(this.a.centerX(), this.a.centerY(), this.n, this.f);
        }
        canvas.drawCircle(this.a.centerX(), this.a.centerY(), this.n, this.d);
        if (this.h > 0) {
            canvas.drawCircle(this.b.centerX(), this.b.centerY(), this.o, this.e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super/*android.widget.ImageView*/.onSizeChanged(i, i2, i3, i4);
        q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (o(motionEvent.getX(), motionEvent.getY()) && super/*android.widget.ImageView*/.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setAdjustViewBounds(boolean z) {
        if (!z) {
        } else {
            throw new IllegalArgumentException("adjustViewBounds not supported.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBorderColor(int i) {
        if (i == this.g) {
            return;
        }
        this.g = i;
        this.e.setColor(i);
        invalidate();
    }

    public void setBorderOverlay(boolean z) {
        if (z == this.s) {
            return;
        }
        this.s = z;
        q();
    }

    public void setBorderWidth(int i) {
        if (i == this.h) {
            return;
        }
        this.h = i;
        q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCircleBackgroundColor(int i) {
        if (i == this.i) {
            return;
        }
        this.i = i;
        this.f.setColor(i);
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setCircleBackgroundColorResource(int i) {
        setCircleBackgroundColor(getContext().getResources().getColor(i));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setColorFilter(ColorFilter colorFilter) {
        if (colorFilter == this.p) {
            return;
        }
        this.p = colorFilter;
        l();
        invalidate();
    }

    public void setDisableCircularTransformation(boolean z) {
        if (this.t == z) {
            return;
        }
        this.t = z;
        p();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        p();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setImageResource(int i) {
        setImageDrawable(androidx.core.content.a.getDrawable(getContext(), i));
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        p();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPadding(int i, int i2, int i3, int i4) {
        super/*android.widget.ImageView*/.setPadding(i, i2, i3, i4);
        q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super/*android.widget.ImageView*/.setPaddingRelative(i, i2, i3, i4);
        q();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == u) {
        } else {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new RectF();
        this.b = new RectF();
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new Paint();
        this.g = RoundedDrawable.DEFAULT_BORDER_COLOR;
        this.h = 0;
        this.i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.g = obtainStyledAttributes.getColor(0, RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.s = obtainStyledAttributes.getBoolean(1, false);
        this.i = obtainStyledAttributes.getColor(3, 0);
        obtainStyledAttributes.recycle();
        init();
    }
}
