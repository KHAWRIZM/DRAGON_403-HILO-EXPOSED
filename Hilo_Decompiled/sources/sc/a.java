package sc;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import tech.sud.gip.core.view.round.RoundedDrawable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a extends Drawable implements Animatable {
    private static final Interpolator j = new LinearInterpolator();
    static final Interpolator k = new z2.b();
    private static final int[] l = {RoundedDrawable.DEFAULT_BORDER_COLOR};
    private final c a = new c();
    private float b;
    private final View c;
    private Animation d;
    float e;
    private float f;
    private float g;
    boolean h;
    boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: sc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class C٠٠٥٤a extends Animation {
        final /* synthetic */ c a;

        C٠٠٥٤a(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            a aVar = a.this;
            if (aVar.h) {
                aVar.a(f, this.a);
                return;
            }
            float c = aVar.c(this.a);
            c cVar = this.a;
            float f2 = cVar.l;
            float f3 = cVar.k;
            float f4 = cVar.m;
            a.this.l(f, cVar);
            if (f <= 0.5f) {
                this.a.d = f3 + ((0.8f - c) * a.k.getInterpolation(f / 0.5f));
            }
            if (f > 0.5f) {
                this.a.e = f2 + ((0.8f - c) * a.k.getInterpolation((f - 0.5f) / 0.5f));
            }
            a.this.f(f4 + (0.25f * f));
            a aVar2 = a.this;
            aVar2.g((f * 216.0f) + ((aVar2.e / 5.0f) * 1080.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class c {
        final RectF a = new RectF();
        final Paint b;
        final Paint c;
        float d;
        float e;
        float f;
        float g;
        float h;
        int[] i;
        int j;
        float k;
        float l;
        float m;
        boolean n;
        Path o;
        float p;
        double q;
        int r;
        int s;
        int t;

        c() {
            Paint paint = new Paint();
            this.b = paint;
            Paint paint2 = new Paint();
            this.c = paint2;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
            this.g = 5.0f;
            this.h = 2.5f;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        private void b(Canvas canvas, float f, float f2, Rect rect) {
            if (this.n) {
                Path path = this.o;
                if (path == null) {
                    Path path2 = new Path();
                    this.o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.h) / 2) * this.p;
                float cos = (float) ((this.q * Math.cos(0.0d)) + rect.exactCenterX());
                float sin = (float) ((this.q * Math.sin(0.0d)) + rect.exactCenterY());
                this.o.moveTo(0.0f, 0.0f);
                this.o.lineTo(this.r * this.p, 0.0f);
                Path path3 = this.o;
                float f4 = this.r;
                float f5 = this.p;
                path3.lineTo((f4 * f5) / 2.0f, this.s * f5);
                this.o.offset(cos - f3, sin);
                this.o.close();
                this.c.setColor(this.t);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.o, this.c);
            }
        }

        private int d() {
            return (this.j + 1) % this.i.length;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.a;
            rectF.set(rect);
            float f = this.h;
            rectF.inset(f, f);
            float f2 = this.d;
            float f3 = this.f;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.e + f3) * 360.0f) - f4;
            if (f5 != 0.0f) {
                this.b.setColor(this.t);
                canvas.drawArc(rectF, f4, f5, false, this.b);
            }
            b(canvas, f4, f5, rect);
        }

        public int c() {
            return this.i[d()];
        }

        public int e() {
            return this.i[this.j];
        }

        public void f() {
            h(d());
        }

        public void g() {
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.d = 0.0f;
            this.e = 0.0f;
            this.f = 0.0f;
        }

        public void h(int i) {
            this.j = i;
            this.t = this.i[i];
        }

        public void i(int i, int i2) {
            double ceil;
            float min = Math.min(i, i2);
            double d = this.q;
            if (d > 0.0d && min >= 0.0f) {
                ceil = (min / 2.0f) - d;
            } else {
                ceil = Math.ceil(this.g / 2.0f);
            }
            this.h = (float) ceil;
        }

        public void j() {
            this.k = this.d;
            this.l = this.e;
            this.m = this.f;
        }
    }

    public a(View view) {
        this.c = view;
        e(l);
        m(1);
        j();
    }

    private int b(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((i >> 8) & 255) + ((int) ((((i2 >> 8) & 255) - r2) * f))) << 8) | ((i & 255) + ((int) (f * ((i2 & 255) - r8))));
    }

    private void h(int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        this.f = i * f5;
        this.g = i2 * f5;
        this.a.h(0);
        float f6 = f2 * f5;
        this.a.b.setStrokeWidth(f6);
        c cVar = this.a;
        cVar.g = f6;
        cVar.q = f * f5;
        cVar.r = (int) (f3 * f5);
        cVar.s = (int) (f4 * f5);
        cVar.i((int) this.f, (int) this.g);
        invalidateSelf();
    }

    private void j() {
        c cVar = this.a;
        C٠٠٥٤a r1 = new C٠٠٥٤a(cVar);
        r1.setRepeatCount(-1);
        r1.setRepeatMode(1);
        r1.setInterpolator(j);
        r1.setAnimationListener(new b(cVar));
        this.d = r1;
    }

    void a(float f, c cVar) {
        l(f, cVar);
        float floor = (float) (Math.floor(cVar.m / 0.8f) + 1.0d);
        float c2 = c(cVar);
        float f2 = cVar.k;
        float f3 = cVar.l;
        i(f2 + (((f3 - c2) - f2) * f), f3);
        float f4 = cVar.m;
        f(f4 + ((floor - f4) * f));
    }

    float c(c cVar) {
        return (float) Math.toRadians(cVar.g / (cVar.q * 6.283185307179586d));
    }

    public void d(float f) {
        c cVar = this.a;
        if (cVar.p != f) {
            cVar.p = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.b, bounds.exactCenterX(), bounds.exactCenterY());
        this.a.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void e(int... iArr) {
        c cVar = this.a;
        cVar.i = iArr;
        cVar.h(0);
    }

    public void f(float f) {
        this.a.f = f;
        invalidateSelf();
    }

    void g(float f) {
        this.b = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void i(float f, float f2) {
        c cVar = this.a;
        cVar.d = f;
        cVar.e = f2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.i;
    }

    public void k(boolean z) {
        c cVar = this.a;
        if (cVar.n != z) {
            cVar.n = z;
            invalidateSelf();
        }
    }

    void l(float f, c cVar) {
        if (f > 0.75f) {
            cVar.t = b((f - 0.75f) / 0.25f, cVar.e(), cVar.c());
        }
    }

    public void m(int i) {
        if (i == 0) {
            h(56, 56, 12.5f, 3.0f, 12.0f, 6.0f);
        } else {
            h(40, 40, 8.75f, 2.5f, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (!this.i) {
            this.d.reset();
            this.a.j();
            c cVar = this.a;
            if (cVar.e != cVar.d) {
                this.h = true;
                this.d.setDuration(666L);
                this.c.startAnimation(this.d);
            } else {
                cVar.h(0);
                this.a.g();
                this.d.setDuration(1332L);
                this.c.startAnimation(this.d);
            }
            this.i = true;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.i) {
            this.c.clearAnimation();
            this.a.h(0);
            this.a.g();
            k(false);
            g(0.0f);
            this.i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public class b implements Animation.AnimationListener {
        final /* synthetic */ c a;

        b(c cVar) {
            this.a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.a.j();
            this.a.f();
            c cVar = this.a;
            cVar.d = cVar.e;
            a aVar = a.this;
            if (aVar.h) {
                aVar.h = false;
                animation.setDuration(1332L);
                a.this.k(false);
                return;
            }
            aVar.e = (aVar.e + 1.0f) % 5.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            a.this.e = 0.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }
}
