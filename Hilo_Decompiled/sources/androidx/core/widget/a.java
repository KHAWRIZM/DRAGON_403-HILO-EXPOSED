package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.d1;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    private static final int f٣٠٧٠r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    final View f٣٠٧٣c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f٣٠٧٤d;

    /* renamed from: g, reason: collision with root package name */
    private int f٣٠٧٧g;

    /* renamed from: h, reason: collision with root package name */
    private int f٣٠٧٨h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٣٠٨٢l;

    /* renamed from: m, reason: collision with root package name */
    boolean f٣٠٨٣m;

    /* renamed from: n, reason: collision with root package name */
    boolean f٣٠٨٤n;

    /* renamed from: o, reason: collision with root package name */
    boolean f٣٠٨٥o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f٣٠٨٦p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f٣٠٨٧q;

    /* renamed from: a, reason: collision with root package name */
    final C٠٠٣١a f٣٠٧١a = new C٠٠٣١a();

    /* renamed from: b, reason: collision with root package name */
    private final Interpolator f٣٠٧٢b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private float[] f٣٠٧٥e = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};

    /* renamed from: f, reason: collision with root package name */
    private float[] f٣٠٧٦f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    private float[] f٣٠٧٩i = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};

    /* renamed from: j, reason: collision with root package name */
    private float[] f٣٠٨٠j = {DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS};

    /* renamed from: k, reason: collision with root package name */
    private float[] f٣٠٨١k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٣١a {

        /* renamed from: a, reason: collision with root package name */
        private int f٣٠٨٨a;

        /* renamed from: b, reason: collision with root package name */
        private int f٣٠٨٩b;

        /* renamed from: c, reason: collision with root package name */
        private float f٣٠٩٠c;

        /* renamed from: d, reason: collision with root package name */
        private float f٣٠٩١d;

        /* renamed from: j, reason: collision with root package name */
        private float f٣٠٩٧j;

        /* renamed from: k, reason: collision with root package name */
        private int f٣٠٩٨k;

        /* renamed from: e, reason: collision with root package name */
        private long f٣٠٩٢e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f٣٠٩٦i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f٣٠٩٣f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f٣٠٩٤g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f٣٠٩٥h = 0;

        C٠٠٣١a() {
        }

        private float e(long j10) {
            long j11 = this.f٣٠٩٢e;
            if (j10 < j11) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            long j12 = this.f٣٠٩٦i;
            if (j12 >= 0 && j10 >= j12) {
                float f10 = this.f٣٠٩٧j;
                return (1.0f - f10) + (f10 * a.e(((float) (j10 - j12)) / this.f٣٠٩٨k, DownloadProgress.UNKNOWN_PROGRESS, 1.0f));
            }
            return a.e(((float) (j10 - j11)) / this.f٣٠٨٨a, DownloadProgress.UNKNOWN_PROGRESS, 1.0f) * 0.5f;
        }

        private float g(float f10) {
            return ((-4.0f) * f10 * f10) + (f10 * 4.0f);
        }

        public void a() {
            if (this.f٣٠٩٣f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g10 = g(e(currentAnimationTimeMillis));
                long j10 = currentAnimationTimeMillis - this.f٣٠٩٣f;
                this.f٣٠٩٣f = currentAnimationTimeMillis;
                float f10 = ((float) j10) * g10;
                this.f٣٠٩٤g = (int) (this.f٣٠٩٠c * f10);
                this.f٣٠٩٥h = (int) (f10 * this.f٣٠٩١d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f٣٠٩٤g;
        }

        public int c() {
            return this.f٣٠٩٥h;
        }

        public int d() {
            float f10 = this.f٣٠٩٠c;
            return (int) (f10 / Math.abs(f10));
        }

        public int f() {
            float f10 = this.f٣٠٩١d;
            return (int) (f10 / Math.abs(f10));
        }

        public boolean h() {
            if (this.f٣٠٩٦i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f٣٠٩٦i + this.f٣٠٩٨k) {
                return true;
            }
            return false;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f٣٠٩٨k = a.f((int) (currentAnimationTimeMillis - this.f٣٠٩٢e), 0, this.f٣٠٨٩b);
            this.f٣٠٩٧j = e(currentAnimationTimeMillis);
            this.f٣٠٩٦i = currentAnimationTimeMillis;
        }

        public void j(int i10) {
            this.f٣٠٨٩b = i10;
        }

        public void k(int i10) {
            this.f٣٠٨٨a = i10;
        }

        public void l(float f10, float f11) {
            this.f٣٠٩٠c = f10;
            this.f٣٠٩١d = f11;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f٣٠٩٢e = currentAnimationTimeMillis;
            this.f٣٠٩٦i = -1L;
            this.f٣٠٩٣f = currentAnimationTimeMillis;
            this.f٣٠٩٧j = 0.5f;
            this.f٣٠٩٤g = 0;
            this.f٣٠٩٥h = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (!aVar.f٣٠٨٥o) {
                return;
            }
            if (aVar.f٣٠٨٣m) {
                aVar.f٣٠٨٣m = false;
                aVar.f٣٠٧١a.m();
            }
            C٠٠٣١a r02 = a.this.f٣٠٧١a;
            if (!r02.h() && a.this.u()) {
                a aVar2 = a.this;
                if (aVar2.f٣٠٨٤n) {
                    aVar2.f٣٠٨٤n = false;
                    aVar2.c();
                }
                r02.a();
                a.this.j(r02.b(), r02.c());
                d1.i0(a.this.f٣٠٧٣c, this);
                return;
            }
            a.this.f٣٠٨٥o = false;
        }
    }

    public a(View view) {
        this.f٣٠٧٣c = view;
        float f10 = Resources.getSystem().getDisplayMetrics().density;
        float f11 = (int) ((1575.0f * f10) + 0.5f);
        o(f11, f11);
        float f12 = (int) ((f10 * 315.0f) + 0.5f);
        p(f12, f12);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f٣٠٧٠r);
        r(500);
        q(500);
    }

    private float d(int i10, float f10, float f11, float f12) {
        float h10 = h(this.f٣٠٧٥e[i10], f11, this.f٣٠٧٦f[i10], f10);
        if (h10 == DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f13 = this.f٣٠٧٩i[i10];
        float f14 = this.f٣٠٨٠j[i10];
        float f15 = this.f٣٠٨١k[i10];
        float f16 = f13 * f12;
        if (h10 > DownloadProgress.UNKNOWN_PROGRESS) {
            return e(h10 * f16, f14, f15);
        }
        return -e((-h10) * f16, f14, f15);
    }

    static float e(float f10, float f11, float f12) {
        return f10 > f12 ? f12 : f10 < f11 ? f11 : f10;
    }

    static int f(int i10, int i11, int i12) {
        return i10 > i12 ? i12 : i10 < i11 ? i11 : i10;
    }

    private float g(float f10, float f11) {
        if (f11 == DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        int i10 = this.f٣٠٧٧g;
        if (i10 != 0 && i10 != 1) {
            if (i10 == 2 && f10 < DownloadProgress.UNKNOWN_PROGRESS) {
                return f10 / (-f11);
            }
        } else if (f10 < f11) {
            if (f10 >= DownloadProgress.UNKNOWN_PROGRESS) {
                return 1.0f - (f10 / f11);
            }
            if (this.f٣٠٨٥o && i10 == 1) {
                return 1.0f;
            }
        }
        return DownloadProgress.UNKNOWN_PROGRESS;
    }

    private float h(float f10, float f11, float f12, float f13) {
        float interpolation;
        float e10 = e(f10 * f11, DownloadProgress.UNKNOWN_PROGRESS, f12);
        float g10 = g(f11 - f13, e10) - g(f13, e10);
        if (g10 < DownloadProgress.UNKNOWN_PROGRESS) {
            interpolation = -this.f٣٠٧٢b.getInterpolation(-g10);
        } else {
            if (g10 <= DownloadProgress.UNKNOWN_PROGRESS) {
                return DownloadProgress.UNKNOWN_PROGRESS;
            }
            interpolation = this.f٣٠٧٢b.getInterpolation(g10);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f٣٠٨٣m) {
            this.f٣٠٨٥o = false;
        } else {
            this.f٣٠٧١a.i();
        }
    }

    private void v() {
        int i10;
        if (this.f٣٠٧٤d == null) {
            this.f٣٠٧٤d = new b();
        }
        this.f٣٠٨٥o = true;
        this.f٣٠٨٣m = true;
        if (!this.f٣٠٨٢l && (i10 = this.f٣٠٧٨h) > 0) {
            d1.j0(this.f٣٠٧٣c, this.f٣٠٧٤d, i10);
        } else {
            this.f٣٠٧٤d.run();
        }
        this.f٣٠٨٢l = true;
    }

    public abstract boolean a(int i10);

    public abstract boolean b(int i10);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 0);
        this.f٣٠٧٣c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i10, int i11);

    public a k(int i10) {
        this.f٣٠٧٨h = i10;
        return this;
    }

    public a l(int i10) {
        this.f٣٠٧٧g = i10;
        return this;
    }

    public a m(boolean z10) {
        if (this.f٣٠٨٦p && !z10) {
            i();
        }
        this.f٣٠٨٦p = z10;
        return this;
    }

    public a n(float f10, float f11) {
        float[] fArr = this.f٣٠٧٦f;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a o(float f10, float f11) {
        float[] fArr = this.f٣٠٨١k;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L٢٠;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f٣٠٨٦p) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            i();
            if (!this.f٣٠٨٧q && this.f٣٠٨٥o) {
                return true;
            }
        }
        this.f٣٠٨٤n = true;
        this.f٣٠٨٢l = false;
        this.f٣٠٧١a.l(d(0, motionEvent.getX(), view.getWidth(), this.f٣٠٧٣c.getWidth()), d(1, motionEvent.getY(), view.getHeight(), this.f٣٠٧٣c.getHeight()));
        if (!this.f٣٠٨٥o && u()) {
            v();
        }
        return !this.f٣٠٨٧q ? false : false;
    }

    public a p(float f10, float f11) {
        float[] fArr = this.f٣٠٨٠j;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    public a q(int i10) {
        this.f٣٠٧١a.j(i10);
        return this;
    }

    public a r(int i10) {
        this.f٣٠٧١a.k(i10);
        return this;
    }

    public a s(float f10, float f11) {
        float[] fArr = this.f٣٠٧٥e;
        fArr[0] = f10;
        fArr[1] = f11;
        return this;
    }

    public a t(float f10, float f11) {
        float[] fArr = this.f٣٠٧٩i;
        fArr[0] = f10 / 1000.0f;
        fArr[1] = f11 / 1000.0f;
        return this;
    }

    boolean u() {
        C٠٠٣١a r02 = this.f٣٠٧١a;
        int f10 = r02.f();
        int d10 = r02.d();
        if ((f10 != 0 && b(f10)) || (d10 != 0 && a(d10))) {
            return true;
        }
        return false;
    }
}
