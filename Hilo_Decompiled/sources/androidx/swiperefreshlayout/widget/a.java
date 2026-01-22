package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    private static final Interpolator f٤١٨٦g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    private static final Interpolator f٤١٨٧h = new z2.b();

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f٤١٨٨i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    private final c f٤١٨٩a;

    /* renamed from: b, reason: collision with root package name */
    private float f٤١٩٠b;

    /* renamed from: c, reason: collision with root package name */
    private Resources f٤١٩١c;

    /* renamed from: d, reason: collision with root package name */
    private Animator f٤١٩٢d;

    /* renamed from: e, reason: collision with root package name */
    float f٤١٩٣e;

    /* renamed from: f, reason: collision with root package name */
    boolean f٤١٩٤f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.swiperefreshlayout.widget.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class C٠٠٥٥a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f٤١٩٥a;

        C٠٠٥٥a(c cVar) {
            this.f٤١٩٥a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.n(floatValue, this.f٤١٩٥a);
            a.this.b(floatValue, this.f٤١٩٥a, false);
            a.this.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f٤١٩٧a;

        b(c cVar) {
            this.f٤١٩٧a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            a.this.b(1.0f, this.f٤١٩٧a, true);
            this.f٤١٩٧a.A();
            this.f٤١٩٧a.l();
            a aVar = a.this;
            if (aVar.f٤١٩٤f) {
                aVar.f٤١٩٤f = false;
                animator.cancel();
                animator.setDuration(1332L);
                animator.start();
                this.f٤١٩٧a.x(false);
                return;
            }
            aVar.f٤١٩٣e += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f٤١٩٣e = DownloadProgress.UNKNOWN_PROGRESS;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final RectF f٤١٩٩a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        final Paint f٤٢٠٠b;

        /* renamed from: c, reason: collision with root package name */
        final Paint f٤٢٠١c;

        /* renamed from: d, reason: collision with root package name */
        final Paint f٤٢٠٢d;

        /* renamed from: e, reason: collision with root package name */
        float f٤٢٠٣e;

        /* renamed from: f, reason: collision with root package name */
        float f٤٢٠٤f;

        /* renamed from: g, reason: collision with root package name */
        float f٤٢٠٥g;

        /* renamed from: h, reason: collision with root package name */
        float f٤٢٠٦h;

        /* renamed from: i, reason: collision with root package name */
        int[] f٤٢٠٧i;

        /* renamed from: j, reason: collision with root package name */
        int f٤٢٠٨j;

        /* renamed from: k, reason: collision with root package name */
        float f٤٢٠٩k;

        /* renamed from: l, reason: collision with root package name */
        float f٤٢١٠l;

        /* renamed from: m, reason: collision with root package name */
        float f٤٢١١m;

        /* renamed from: n, reason: collision with root package name */
        boolean f٤٢١٢n;

        /* renamed from: o, reason: collision with root package name */
        Path f٤٢١٣o;

        /* renamed from: p, reason: collision with root package name */
        float f٤٢١٤p;

        /* renamed from: q, reason: collision with root package name */
        float f٤٢١٥q;

        /* renamed from: r, reason: collision with root package name */
        int f٤٢١٦r;

        /* renamed from: s, reason: collision with root package name */
        int f٤٢١٧s;

        /* renamed from: t, reason: collision with root package name */
        int f٤٢١٨t;

        /* renamed from: u, reason: collision with root package name */
        int f٤٢١٩u;

        c() {
            Paint paint = new Paint();
            this.f٤٢٠٠b = paint;
            Paint paint2 = new Paint();
            this.f٤٢٠١c = paint2;
            Paint paint3 = new Paint();
            this.f٤٢٠٢d = paint3;
            this.f٤٢٠٣e = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٢٠٤f = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٢٠٥g = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٢٠٦h = 5.0f;
            this.f٤٢١٤p = 1.0f;
            this.f٤٢١٨t = KotlinVersion.MAX_COMPONENT_VALUE;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void A() {
            this.f٤٢٠٩k = this.f٤٢٠٣e;
            this.f٤٢١٠l = this.f٤٢٠٤f;
            this.f٤٢١١m = this.f٤٢٠٥g;
        }

        void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f٤١٩٩a;
            float f10 = this.f٤٢١٥q;
            float f11 = (this.f٤٢٠٦h / 2.0f) + f10;
            if (f10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                f11 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f٤٢١٦r * this.f٤٢١٤p) / 2.0f, this.f٤٢٠٦h / 2.0f);
            }
            rectF.set(rect.centerX() - f11, rect.centerY() - f11, rect.centerX() + f11, rect.centerY() + f11);
            float f12 = this.f٤٢٠٣e;
            float f13 = this.f٤٢٠٥g;
            float f14 = (f12 + f13) * 360.0f;
            float f15 = ((this.f٤٢٠٤f + f13) * 360.0f) - f14;
            this.f٤٢٠٠b.setColor(this.f٤٢١٩u);
            this.f٤٢٠٠b.setAlpha(this.f٤٢١٨t);
            float f16 = this.f٤٢٠٦h / 2.0f;
            rectF.inset(f16, f16);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f٤٢٠٢d);
            float f17 = -f16;
            rectF.inset(f17, f17);
            canvas.drawArc(rectF, f14, f15, false, this.f٤٢٠٠b);
            b(canvas, f14, f15, rectF);
        }

        void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f٤٢١٢n) {
                Path path = this.f٤٢١٣o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f٤٢١٣o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f12 = (this.f٤٢١٦r * this.f٤٢١٤p) / 2.0f;
                this.f٤٢١٣o.moveTo(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
                this.f٤٢١٣o.lineTo(this.f٤٢١٦r * this.f٤٢١٤p, DownloadProgress.UNKNOWN_PROGRESS);
                Path path3 = this.f٤٢١٣o;
                float f13 = this.f٤٢١٦r;
                float f14 = this.f٤٢١٤p;
                path3.lineTo((f13 * f14) / 2.0f, this.f٤٢١٧s * f14);
                this.f٤٢١٣o.offset((min + rectF.centerX()) - f12, rectF.centerY() + (this.f٤٢٠٦h / 2.0f));
                this.f٤٢١٣o.close();
                this.f٤٢٠١c.setColor(this.f٤٢١٩u);
                this.f٤٢٠١c.setAlpha(this.f٤٢١٨t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f٤٢١٣o, this.f٤٢٠١c);
                canvas.restore();
            }
        }

        int c() {
            return this.f٤٢١٨t;
        }

        float d() {
            return this.f٤٢٠٤f;
        }

        int e() {
            return this.f٤٢٠٧i[f()];
        }

        int f() {
            return (this.f٤٢٠٨j + 1) % this.f٤٢٠٧i.length;
        }

        float g() {
            return this.f٤٢٠٣e;
        }

        int h() {
            return this.f٤٢٠٧i[this.f٤٢٠٨j];
        }

        float i() {
            return this.f٤٢١٠l;
        }

        float j() {
            return this.f٤٢١١m;
        }

        float k() {
            return this.f٤٢٠٩k;
        }

        void l() {
            t(f());
        }

        void m() {
            this.f٤٢٠٩k = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٢١٠l = DownloadProgress.UNKNOWN_PROGRESS;
            this.f٤٢١١m = DownloadProgress.UNKNOWN_PROGRESS;
            y(DownloadProgress.UNKNOWN_PROGRESS);
            v(DownloadProgress.UNKNOWN_PROGRESS);
            w(DownloadProgress.UNKNOWN_PROGRESS);
        }

        void n(int i10) {
            this.f٤٢١٨t = i10;
        }

        void o(float f10, float f11) {
            this.f٤٢١٦r = (int) f10;
            this.f٤٢١٧s = (int) f11;
        }

        void p(float f10) {
            if (f10 != this.f٤٢١٤p) {
                this.f٤٢١٤p = f10;
            }
        }

        void q(float f10) {
            this.f٤٢١٥q = f10;
        }

        void r(int i10) {
            this.f٤٢١٩u = i10;
        }

        void s(ColorFilter colorFilter) {
            this.f٤٢٠٠b.setColorFilter(colorFilter);
        }

        void t(int i10) {
            this.f٤٢٠٨j = i10;
            this.f٤٢١٩u = this.f٤٢٠٧i[i10];
        }

        void u(int[] iArr) {
            this.f٤٢٠٧i = iArr;
            t(0);
        }

        void v(float f10) {
            this.f٤٢٠٤f = f10;
        }

        void w(float f10) {
            this.f٤٢٠٥g = f10;
        }

        void x(boolean z10) {
            if (this.f٤٢١٢n != z10) {
                this.f٤٢١٢n = z10;
            }
        }

        void y(float f10) {
            this.f٤٢٠٣e = f10;
        }

        void z(float f10) {
            this.f٤٢٠٦h = f10;
            this.f٤٢٠٠b.setStrokeWidth(f10);
        }
    }

    public a(Context context) {
        this.f٤١٩١c = ((Context) h.g(context)).getResources();
        c cVar = new c();
        this.f٤١٨٩a = cVar;
        cVar.u(f٤١٨٨i);
        k(2.5f);
        m();
    }

    private void a(float f10, c cVar) {
        n(f10, cVar);
        float floor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((floor - cVar.j()) * f10));
    }

    private int c(float f10, int i10, int i11) {
        return ((((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE) + ((int) ((((i11 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE) - r0) * f10))) << 24) | ((((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE) + ((int) ((((i11 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE) - r1) * f10))) << 16) | ((((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE) + ((int) ((((i11 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE) - r2) * f10))) << 8) | ((i10 & KotlinVersion.MAX_COMPONENT_VALUE) + ((int) (f10 * ((i11 & KotlinVersion.MAX_COMPONENT_VALUE) - r8))));
    }

    private void h(float f10) {
        this.f٤١٩٠b = f10;
    }

    private void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f٤١٨٩a;
        float f14 = this.f٤١٩١c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    private void m() {
        c cVar = this.f٤١٨٩a;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        ofFloat.addUpdateListener(new C٠٠٥٥a(cVar));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f٤١٨٦g);
        ofFloat.addListener(new b(cVar));
        this.f٤١٩٢d = ofFloat;
    }

    void b(float f10, c cVar, boolean z10) {
        float interpolation;
        float f11;
        if (this.f٤١٩٤f) {
            a(f10, cVar);
            return;
        }
        if (f10 != 1.0f || z10) {
            float j10 = cVar.j();
            if (f10 < 0.5f) {
                interpolation = cVar.k();
                f11 = (f٤١٨٧h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float k10 = cVar.k() + 0.79f;
                interpolation = k10 - (((1.0f - f٤١٨٧h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f11 = k10;
            }
            float f12 = j10 + (0.20999998f * f10);
            float f13 = (f10 + this.f٤١٩٣e) * 216.0f;
            cVar.y(interpolation);
            cVar.v(f11);
            cVar.w(f12);
            h(f13);
        }
    }

    public void d(boolean z10) {
        this.f٤١٨٩a.x(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f٤١٩٠b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f٤١٨٩a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f٤١٨٩a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f٤١٨٩a.u(iArr);
        this.f٤١٨٩a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f٤١٨٩a.w(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f٤١٨٩a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f٤١٩٢d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f٤١٨٩a.y(f10);
        this.f٤١٨٩a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f٤١٨٩a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        if (i10 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    void n(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.r(c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f٤١٨٩a.n(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f٤١٨٩a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f٤١٩٢d.cancel();
        this.f٤١٨٩a.A();
        if (this.f٤١٨٩a.d() != this.f٤١٨٩a.g()) {
            this.f٤١٩٤f = true;
            this.f٤١٩٢d.setDuration(666L);
            this.f٤١٩٢d.start();
        } else {
            this.f٤١٨٩a.t(0);
            this.f٤١٨٩a.m();
            this.f٤١٩٢d.setDuration(1332L);
            this.f٤١٩٢d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f٤١٩٢d.cancel();
        h(DownloadProgress.UNKNOWN_PROGRESS);
        this.f٤١٨٩a.x(false);
        this.f٤١٨٩a.t(0);
        this.f٤١٨٩a.m();
        invalidateSelf();
    }
}
