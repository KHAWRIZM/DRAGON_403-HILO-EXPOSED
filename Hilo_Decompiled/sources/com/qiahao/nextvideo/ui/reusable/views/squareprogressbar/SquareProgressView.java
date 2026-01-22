package com.qiahao.nextvideo.ui.reusable.views.squareprogressbar;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.base_common.utils.Dimens;
import java.text.DecimalFormat;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class SquareProgressView extends View {
    private float a;
    private Paint b;
    private Paint c;
    private Paint d;
    private float e;
    private float f;
    private Canvas g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private float m;
    private PercentStyle n;
    private boolean o;
    private boolean p;
    private int q;
    private final float r;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public class a {
        private b a;
        private float b;

        public a() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public enum b {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    public SquareProgressView(Context context) {
        super(context);
        this.e = 10.0f;
        this.f = 0.0f;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = 10.0f;
        this.n = new PercentStyle(Paint.Align.CENTER, 150.0f, true);
        this.o = false;
        this.p = false;
        this.q = 1;
        this.r = 20.0f;
        f(context);
    }

    private void a(float f) {
        float f2 = f / 2.0f;
        Path path = new Path();
        path.moveTo(f2, f2);
        path.lineTo(getWidth() - f2, f2);
        path.lineTo(getWidth() - f2, getHeight() - f2);
        path.lineTo(f2, getHeight() - f2);
        path.lineTo(f2, f2);
        this.g.drawPath(path, this.c);
    }

    private void b() {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo(getWidth(), 0.0f);
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0.0f, getHeight());
        path.lineTo(0.0f, 0.0f);
        this.c.setStyle(Paint.Style.FILL);
        this.g.drawPath(path, this.c);
    }

    private void c(PercentStyle percentStyle) {
        this.d.setTextAlign(percentStyle.getAlign());
        if (percentStyle.getTextSize() == 0.0f) {
            this.d.setTextSize((getHeight() / 10) * 4);
        } else {
            this.d.setTextSize(percentStyle.getTextSize());
        }
        String format = new DecimalFormat("###").format(getProgress());
        if (percentStyle.getIsPercentSign()) {
            format = format + this.n.getCustomText();
        }
        this.d.setColor(this.n.getTextColor());
        this.g.drawText(format, getWidth() / 2, (int) ((getHeight() / 2) - ((this.d.descent() + this.d.ascent()) / 2.0f)), this.d);
    }

    private void d() {
        Path path = new Path();
        path.moveTo(getWidth() / 2, 0.0f);
        path.lineTo(getWidth() / 2, this.f);
        this.g.drawPath(path, this.c);
    }

    private void f(Context context) {
        Paint paint = new Paint();
        this.b = paint;
        paint.setColor(context.getResources().getColor(R.color.holo_green_dark));
        this.b.setStrokeWidth(Dimens.INSTANCE.dpToPx((int) this.e));
        this.b.setAntiAlias(true);
        Paint paint2 = this.b;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setColor(context.getResources().getColor(R.color.black));
        this.c.setStrokeWidth(1.0f);
        this.c.setAntiAlias(true);
        this.c.setStyle(style);
        Paint paint4 = new Paint();
        this.d = paint4;
        paint4.setColor(context.getResources().getColor(R.color.black));
        this.d.setAntiAlias(true);
        this.d.setStyle(style);
    }

    public a e(float f, Canvas canvas) {
        a aVar = new a();
        this.f = Dimens.INSTANCE.dpToPx((int) this.e);
        float width = getWidth() / 2;
        if (f <= width) {
            aVar.a = b.TOP;
            aVar.b = width + f;
        } else {
            float f2 = f - width;
            if (f2 <= getHeight() - this.f) {
                aVar.a = b.RIGHT;
                aVar.b = this.f + f2;
            } else {
                float height = f2 - (getHeight() - this.f);
                if (height <= getWidth() - this.f) {
                    aVar.a = b.BOTTOM;
                    aVar.b = (getWidth() - this.f) - height;
                } else {
                    float width2 = height - (getWidth() - this.f);
                    if (width2 <= getHeight() - this.f) {
                        aVar.a = b.LEFT;
                        aVar.b = (getHeight() - this.f) - width2;
                    } else {
                        float height2 = width2 - (getHeight() - this.f);
                        if (height2 == width) {
                            aVar.a = b.TOP;
                            aVar.b = width;
                        } else {
                            aVar.a = b.TOP;
                            aVar.b = this.f + height2;
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public boolean g() {
        return this.k;
    }

    public PercentStyle getPercentStyle() {
        return this.n;
    }

    public float getProgress() {
        return this.a;
    }

    public boolean h() {
        return this.o;
    }

    public boolean i() {
        return this.p;
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.i;
    }

    public void m(boolean z, float f) {
        this.l = z;
        this.m = f;
        if (z) {
            this.b.setPathEffect(new CornerPathEffect(this.m));
        } else {
            this.b.setPathEffect(null);
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.g = canvas;
        super.onDraw(canvas);
        this.f = Dimens.INSTANCE.dpToPx((int) this.e);
        int width = getWidth();
        int height = getHeight();
        float f = this.f;
        float f2 = ((width * 2) + (height * 2)) - (4.0f * f);
        float f3 = f / 2.0f;
        if (j()) {
            b();
        }
        if (l()) {
            d();
        }
        if (k()) {
            c(this.n);
        }
        if (g()) {
            a(this.f);
        }
        if ((h() && this.a == 100.0d) || this.a <= 0.0d) {
            return;
        }
        if (i()) {
            Path path = new Path();
            a e = e((f2 / 100.0f) * Float.valueOf(String.valueOf(this.q)).floatValue(), canvas);
            if (e.a == b.TOP) {
                path.moveTo((e.b - 20.0f) - this.f, f3);
                path.lineTo(e.b, f3);
                canvas.drawPath(path, this.b);
            }
            if (e.a == b.RIGHT) {
                float f4 = width - f3;
                path.moveTo(f4, e.b - 20.0f);
                path.lineTo(f4, this.f + e.b);
                canvas.drawPath(path, this.b);
            }
            if (e.a == b.BOTTOM) {
                float f5 = height - f3;
                path.moveTo((e.b - 20.0f) - this.f, f5);
                path.lineTo(e.b, f5);
                canvas.drawPath(path, this.b);
            }
            if (e.a == b.LEFT) {
                path.moveTo(f3, (e.b - 20.0f) - this.f);
                path.lineTo(f3, e.b);
                canvas.drawPath(path, this.b);
            }
            int i = this.q + 1;
            this.q = i;
            if (i > 100) {
                this.q = 0;
            }
            invalidate();
            return;
        }
        Path path2 = new Path();
        a e2 = e((f2 / 100.0f) * Float.valueOf(String.valueOf(this.a)).floatValue(), canvas);
        if (e2.a == b.TOP) {
            float f6 = width / 2;
            if (e2.b > f6 && this.a < 100.0d) {
                path2.moveTo(f6, f3);
                path2.lineTo(e2.b, f3);
            } else {
                path2.moveTo(f6, f3);
                float f7 = width - f3;
                path2.lineTo(f7, f3);
                float f8 = height - f3;
                path2.lineTo(f7, f8);
                path2.lineTo(f3, f8);
                path2.lineTo(f3, f3);
                path2.lineTo(this.f, f3);
                path2.lineTo(e2.b, f3);
            }
            canvas.drawPath(path2, this.b);
        }
        if (e2.a == b.RIGHT) {
            path2.moveTo(width / 2, f3);
            float f9 = width - f3;
            path2.lineTo(f9, f3);
            path2.lineTo(f9, e2.b + 0.0f);
            canvas.drawPath(path2, this.b);
        }
        if (e2.a == b.BOTTOM) {
            path2.moveTo(width / 2, f3);
            float f10 = width;
            float f11 = f10 - f3;
            path2.lineTo(f11, f3);
            float f12 = height - f3;
            path2.lineTo(f11, f12);
            path2.lineTo(f10 - this.f, f12);
            path2.lineTo(e2.b, f12);
            canvas.drawPath(path2, this.b);
        }
        if (e2.a == b.LEFT) {
            path2.moveTo(width / 2, f3);
            float f13 = width - f3;
            path2.lineTo(f13, f3);
            float f14 = height;
            float f15 = f14 - f3;
            path2.lineTo(f13, f15);
            path2.lineTo(f3, f15);
            path2.lineTo(f3, f14 - this.f);
            path2.lineTo(f3, e2.b);
            canvas.drawPath(path2, this.b);
        }
    }

    public void setCenterline(boolean z) {
        this.k = z;
        invalidate();
    }

    public void setClearOnHundred(boolean z) {
        this.o = z;
        invalidate();
    }

    public void setColor(int i) {
        this.b.setColor(i);
        invalidate();
    }

    public void setIndeterminate(boolean z) {
        this.p = z;
        invalidate();
    }

    public void setOutline(boolean z) {
        this.h = z;
        invalidate();
    }

    public void setPercentStyle(PercentStyle percentStyle) {
        this.n = percentStyle;
        invalidate();
    }

    public void setProgress(float f) {
        this.a = f;
        invalidate();
    }

    public void setProgressBarColor(int i) {
        this.b.setColor(i);
    }

    public void setShowProgress(boolean z) {
        this.j = z;
        invalidate();
    }

    public void setStartline(boolean z) {
        this.i = z;
        invalidate();
    }

    public void setWidthInDp(int i) {
        this.e = i;
        this.b.setStrokeWidth(Dimens.INSTANCE.dpToPx((int) r3));
        invalidate();
    }

    public SquareProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 10.0f;
        this.f = 0.0f;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = 10.0f;
        this.n = new PercentStyle(Paint.Align.CENTER, 150.0f, true);
        this.o = false;
        this.p = false;
        this.q = 1;
        this.r = 20.0f;
        f(context);
    }

    public SquareProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 10.0f;
        this.f = 0.0f;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = 10.0f;
        this.n = new PercentStyle(Paint.Align.CENTER, 150.0f, true);
        this.o = false;
        this.p = false;
        this.q = 1;
        this.r = 20.0f;
        f(context);
    }
}
