package com.qiahao.nextvideo.flowingdrawer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class FlowingMenuLayout extends FrameLayout {
    private Path a;
    private float b;
    private int c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private double k;
    private double l;
    private double m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private int s;
    private int t;
    private Paint u;
    private int v;

    public FlowingMenuLayout(Context context) {
        this(context, null);
    }

    private void a() {
        switch (this.c) {
            case 0:
                this.a.moveTo(0.0f, 0.0f);
                this.a.lineTo(this.i, 0.0f);
                this.a.lineTo(this.i, this.j);
                this.a.lineTo(0.0f, this.j);
                this.a.lineTo(0.0f, 0.0f);
                return;
            case 1:
                float f = this.d * 2.0f;
                double abs = Math.abs((f - r1) / this.j);
                this.k = abs;
                double d = (3.0d * abs) + 1.0d;
                this.l = d;
                double d2 = (abs * 5.0d) + 1.0d;
                this.m = d2;
                float f2 = this.d;
                int i = this.j;
                if (f2 - (i / 2) >= 0.0f) {
                    float f3 = this.b;
                    this.h = (int) (f2 + ((i * 0.7d) / (d + 1.0d)) + ((f3 * 6.0f) / (d2 + 1.0d)));
                    this.g = (int) ((f2 - ((i * 0.7d) / ((1.0d / d) + 1.0d))) - ((f3 * 6.0f) / ((1.0d / d2) + 1.0d)));
                    this.e = (int) (((-r8) / 4) + ((5.0f * f2) / 4.0f));
                    this.f = (int) ((r8 / 4) + ((f2 * 3.0f) / 4.0f));
                } else {
                    float f4 = this.b;
                    this.h = (int) (f2 + ((i * 0.7d) / ((1.0d / d) + 1.0d)) + ((f4 * 6.0f) / ((1.0d / d2) + 1.0d)));
                    this.g = (int) ((f2 - ((i * 0.7d) / (d + 1.0d))) - ((f4 * 6.0f) / (d2 + 1.0d)));
                    this.e = (int) ((r2 / 4) + ((f2 * 3.0f) / 4.0f));
                    this.f = (int) (((-r2) / 4) + ((f2 * 5.0f) / 4.0f));
                }
                this.a.moveTo(this.i - this.b, this.g);
                Path path = this.a;
                int i2 = this.i;
                float f5 = i2 - this.b;
                int i3 = this.e;
                path.cubicTo(f5, i3, i2, i3, i2, this.d);
                Path path2 = this.a;
                int i4 = this.i;
                int i5 = this.f;
                float f6 = this.b;
                path2.cubicTo(i4, i5, i4 - f6, i5, i4 - f6, this.h);
                this.a.lineTo(this.i - this.b, this.g);
                return;
            case 2:
                float f7 = this.b;
                int i6 = this.i;
                float f8 = (f7 - (i6 / 2)) / (i6 / 2);
                this.n = f8;
                if (f8 <= 0.5d) {
                    this.q = (float) (Math.pow(f8, 2.0d) * 2.0d);
                    this.p = (float) ((1.0d / Math.sqrt(2.0d)) * Math.sqrt(this.n));
                } else {
                    this.q = (float) ((((1.0d / (2.0d - Math.sqrt(2.0d))) * Math.sqrt(this.n)) + 1.0d) - (1.0d / (2.0d - Math.sqrt(2.0d))));
                    this.p = (float) (((Math.pow(this.n, 2.0d) * 2.0d) / 3.0d) + 0.3333333432674408d);
                }
                int i7 = this.i;
                this.s = (int) ((i7 / 2) + (this.q * ((i7 / 2) + UserProxyUtility.cpUpgrades)));
                this.t = (int) ((i7 * 0.75d) + (this.p * ((i7 / 4) + 100)));
                this.a.moveTo(i7 - this.b, 0.0f);
                this.a.lineTo(this.t, 0.0f);
                this.a.quadTo(this.s, this.d, this.t, this.j);
                this.a.lineTo(this.i - this.b, this.j);
                this.a.lineTo(this.i - this.b, 0.0f);
                return;
            case 3:
                int i8 = this.i;
                float f9 = i8 + UserProxyUtility.cpUpgrades;
                float f10 = this.o;
                this.s = (int) (f9 - (150.0f * f10));
                this.t = (int) ((i8 + 100) - (f10 * 100.0f));
                this.a.moveTo(i8 - this.b, 0.0f);
                this.a.lineTo(this.t, 0.0f);
                this.a.quadTo(this.s, this.d, this.t, this.j);
                this.a.lineTo(this.i - this.b, this.j);
                this.a.lineTo(this.i - this.b, 0.0f);
                return;
            case 4:
                float f11 = this.b;
                int i9 = this.i;
                float f12 = 1.0f - (f11 / i9);
                this.r = f12;
                this.s = (int) (i9 - ((i9 * 0.5d) * f12));
                this.a.moveTo(i9 - f11, 0.0f);
                this.a.lineTo(this.i, 0.0f);
                this.a.quadTo(this.s, this.d, this.i, this.j);
                this.a.lineTo(this.i - this.b, this.j);
                this.a.lineTo(this.i - this.b, 0.0f);
                return;
            case 5:
                float f13 = this.b;
                int i10 = this.i;
                float f14 = 1.0f - (f13 / i10);
                this.r = f14;
                this.s = (int) (i10 - ((i10 * 0.5d) * f14));
                this.a.moveTo(i10 - f13, 0.0f);
                this.a.lineTo(this.i, 0.0f);
                this.a.quadTo(this.s, this.d, this.i, this.j);
                this.a.lineTo(this.i - this.b, this.j);
                this.a.lineTo(this.i - this.b, 0.0f);
                return;
            case 6:
                this.h = this.h + 10;
                int i11 = this.g - 10;
                this.g = i11;
                float f15 = this.d;
                if (f15 - (this.j / 2) >= 0.0f) {
                    this.e = (int) (((-r1) / 4) + ((5.0f * f15) / 4.0f));
                    this.f = (int) ((r1 / 4) + ((f15 * 3.0f) / 4.0f));
                } else {
                    this.e = (int) ((i11 / 4) + ((3.0f * f15) / 4.0f));
                    this.f = (int) (((-i11) / 4) + ((f15 * 5.0f) / 4.0f));
                }
                this.a.moveTo(this.i - this.b, i11);
                Path path3 = this.a;
                int i12 = this.i;
                float f16 = i12 - this.b;
                int i13 = this.e;
                path3.cubicTo(f16, i13, i12, i13, i12, this.d);
                Path path4 = this.a;
                int i14 = this.i;
                int i15 = this.f;
                float f17 = this.b;
                path4.cubicTo(i14, i15, i14 - f17, i15, i14 - f17, this.h);
                this.a.lineTo(this.i - this.b, this.g);
                return;
            default:
                return;
        }
    }

    private void b() {
        switch (this.c) {
            case 0:
                this.a.moveTo(this.i, 0.0f);
                this.a.lineTo(0.0f, 0.0f);
                this.a.lineTo(0.0f, this.j);
                this.a.lineTo(this.i, this.j);
                this.a.lineTo(this.i, 0.0f);
                return;
            case 1:
                float f = this.d * 2.0f;
                double abs = Math.abs((f - r1) / this.j);
                this.k = abs;
                double d = (3.0d * abs) + 1.0d;
                this.l = d;
                double d2 = (abs * 5.0d) + 1.0d;
                this.m = d2;
                float f2 = this.d;
                int i = this.j;
                if (f2 - (i / 2) >= 0.0f) {
                    float f3 = this.b;
                    this.h = (int) ((f2 + ((i * 0.7d) / (d + 1.0d))) - ((f3 * 6.0f) / (d2 + 1.0d)));
                    this.g = (int) ((f2 - ((i * 0.7d) / ((1.0d / d) + 1.0d))) + ((f3 * 6.0f) / ((1.0d / d2) + 1.0d)));
                    this.e = (int) (((-r8) / 4) + ((5.0f * f2) / 4.0f));
                    this.f = (int) ((r8 / 4) + ((f2 * 3.0f) / 4.0f));
                } else {
                    float f4 = this.b;
                    this.h = (int) ((f2 + ((i * 0.7d) / ((1.0d / d) + 1.0d))) - ((f4 * 6.0f) / ((1.0d / d2) + 1.0d)));
                    this.g = (int) ((f2 - ((i * 0.7d) / (d + 1.0d))) + ((f4 * 6.0f) / (d2 + 1.0d)));
                    this.e = (int) ((r2 / 4) + ((f2 * 3.0f) / 4.0f));
                    this.f = (int) (((-r2) / 4) + ((f2 * 5.0f) / 4.0f));
                }
                this.a.moveTo(-this.b, this.g);
                Path path = this.a;
                float f5 = -this.b;
                int i2 = this.e;
                path.cubicTo(f5, i2, 0.0f, i2, 0.0f, this.d);
                Path path2 = this.a;
                int i3 = this.f;
                float f6 = this.b;
                path2.cubicTo(0.0f, i3, -f6, i3, -f6, this.h);
                this.a.lineTo(-this.b, this.g);
                return;
            case 2:
                float f7 = -this.b;
                int i4 = this.i;
                float f8 = (f7 - (i4 / 2)) / (i4 / 2);
                this.n = f8;
                if (f8 <= 0.5d) {
                    this.q = (float) (Math.pow(f8, 2.0d) * 2.0d);
                    this.p = (float) ((1.0d / Math.sqrt(2.0d)) * Math.sqrt(this.n));
                } else {
                    this.q = (float) ((((1.0d / (2.0d - Math.sqrt(2.0d))) * Math.sqrt(this.n)) + 1.0d) - (1.0d / (2.0d - Math.sqrt(2.0d))));
                    this.p = (float) (((Math.pow(this.n, 2.0d) * 2.0d) / 3.0d) + 0.3333333432674408d);
                }
                int i5 = this.i;
                this.s = (int) ((i5 / 2) + (this.q * ((i5 / 2) + UserProxyUtility.cpUpgrades)));
                this.t = (int) ((i5 * 0.75d) + (this.p * ((i5 / 4) + 100)));
                this.a.moveTo(-this.b, 0.0f);
                this.a.lineTo(this.i - this.t, 0.0f);
                Path path3 = this.a;
                int i6 = this.i;
                path3.quadTo(i6 - this.s, this.d, i6 - this.t, this.j);
                this.a.lineTo(-this.b, this.j);
                this.a.lineTo(-this.b, 0.0f);
                return;
            case 3:
                float f9 = this.i + UserProxyUtility.cpUpgrades;
                float f10 = this.o;
                this.s = (int) (f9 - (150.0f * f10));
                this.t = (int) ((r1 + 100) - (f10 * 100.0f));
                this.a.moveTo(-this.b, 0.0f);
                this.a.lineTo(this.i - this.t, 0.0f);
                Path path4 = this.a;
                int i7 = this.i;
                path4.quadTo(i7 - this.s, this.d, i7 - this.t, this.j);
                this.a.lineTo(-this.b, this.j);
                this.a.lineTo(-this.b, 0.0f);
                return;
            case 4:
                float f11 = this.b;
                int i8 = this.i;
                float f12 = (f11 / i8) + 1.0f;
                this.r = f12;
                this.s = (int) (i8 - ((i8 * 0.5d) * f12));
                this.a.moveTo(-f11, 0.0f);
                this.a.lineTo(0.0f, 0.0f);
                this.a.quadTo(this.i - this.s, this.d, 0.0f, this.j);
                this.a.lineTo(-this.b, this.j);
                this.a.lineTo(-this.b, 0.0f);
                return;
            case 5:
                float f13 = this.b;
                int i9 = this.i;
                float f14 = (f13 / i9) + 1.0f;
                this.r = f14;
                this.s = (int) (i9 - ((i9 * 0.5d) * f14));
                this.a.moveTo(-f13, 0.0f);
                this.a.lineTo(0.0f, 0.0f);
                this.a.quadTo(this.i - this.s, this.d, 0.0f, this.j);
                this.a.lineTo(-this.b, this.j);
                this.a.lineTo(-this.b, 0.0f);
                return;
            case 6:
                this.h = this.h + 10;
                int i10 = this.g - 10;
                this.g = i10;
                float f15 = this.d;
                if (f15 - (this.j / 2) >= 0.0f) {
                    this.e = (int) (((-r1) / 4) + ((5.0f * f15) / 4.0f));
                    this.f = (int) ((r1 / 4) + ((f15 * 3.0f) / 4.0f));
                } else {
                    this.e = (int) ((i10 / 4) + ((3.0f * f15) / 4.0f));
                    this.f = (int) (((-i10) / 4) + ((f15 * 5.0f) / 4.0f));
                }
                this.a.moveTo(-this.b, i10);
                Path path5 = this.a;
                float f16 = -this.b;
                int i11 = this.e;
                path5.cubicTo(f16, i11, 0.0f, i11, 0.0f, this.d);
                Path path6 = this.a;
                int i12 = this.f;
                float f17 = this.b;
                path6.cubicTo(0.0f, i12, -f17, i12, -f17, this.h);
                this.a.lineTo(-this.b, this.g);
                return;
            default:
                return;
        }
    }

    public void c(float f, float f2, int i) {
        this.b = f;
        this.c = i;
        this.d = f2;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.i = getWidth();
        this.j = getHeight();
        this.a.reset();
        if (this.v == 1) {
            a();
        } else {
            b();
        }
        canvas.save();
        canvas.drawPath(this.a, this.u);
        canvas.clipPath(this.a, Region.Op.INTERSECT);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void setMenuPosition(int i) {
        this.v = i;
    }

    public void setPaintColor(int i) {
        this.u.setColor(i);
    }

    public void setUpDownFraction(float f) {
        this.o = f;
        this.c = 3;
        invalidate();
    }

    public FlowingMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowingMenuLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0.0f;
        this.c = 0;
        this.d = 0.0f;
        this.a = new Path();
        Paint paint = new Paint();
        this.u = paint;
        paint.setAntiAlias(true);
        this.u.setStyle(Paint.Style.FILL);
    }
}
