package x3;

import android.view.Choreographer;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i extends c implements Choreographer.FrameCallback {

    /* renamed from: l, reason: collision with root package name */
    private com.airbnb.lottie.j f١٨٩١٧l;

    /* renamed from: d, reason: collision with root package name */
    private float f١٨٩٠٩d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private boolean f١٨٩١٠e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f١٨٩١١f = 0;

    /* renamed from: g, reason: collision with root package name */
    private float f١٨٩١٢g = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: h, reason: collision with root package name */
    private float f١٨٩١٣h = DownloadProgress.UNKNOWN_PROGRESS;

    /* renamed from: i, reason: collision with root package name */
    private int f١٨٩١٤i = 0;

    /* renamed from: j, reason: collision with root package name */
    private float f١٨٩١٥j = -2.1474836E9f;

    /* renamed from: k, reason: collision with root package name */
    private float f١٨٩١٦k = 2.1474836E9f;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f١٨٩١٨m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١٨٩١٩n = false;

    private void E() {
        if (this.f١٨٩١٧l == null) {
            return;
        }
        float f10 = this.f١٨٩١٣h;
        if (f10 >= this.f١٨٩١٥j && f10 <= this.f١٨٩١٦k) {
        } else {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f١٨٩١٥j), Float.valueOf(this.f١٨٩١٦k), Float.valueOf(this.f١٨٩١٣h)));
        }
    }

    private float l() {
        com.airbnb.lottie.j jVar = this.f١٨٩١٧l;
        if (jVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / jVar.i()) / Math.abs(this.f١٨٩٠٩d);
    }

    private boolean p() {
        if (o() < DownloadProgress.UNKNOWN_PROGRESS) {
            return true;
        }
        return false;
    }

    public void A(float f10, float f11) {
        float p10;
        float f12;
        if (f10 <= f11) {
            com.airbnb.lottie.j jVar = this.f١٨٩١٧l;
            if (jVar == null) {
                p10 = -3.4028235E38f;
            } else {
                p10 = jVar.p();
            }
            com.airbnb.lottie.j jVar2 = this.f١٨٩١٧l;
            if (jVar2 == null) {
                f12 = Float.MAX_VALUE;
            } else {
                f12 = jVar2.f();
            }
            float b10 = k.b(f10, p10, f12);
            float b11 = k.b(f11, p10, f12);
            if (b10 != this.f١٨٩١٥j || b11 != this.f١٨٩١٦k) {
                this.f١٨٩١٥j = b10;
                this.f١٨٩١٦k = b11;
                y((int) k.b(this.f١٨٩١٣h, b10, b11));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f10), Float.valueOf(f11)));
    }

    public void B(int i10) {
        A(i10, (int) this.f١٨٩١٦k);
    }

    public void C(float f10) {
        this.f١٨٩٠٩d = f10;
    }

    public void D(boolean z10) {
        this.f١٨٩١٩n = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // x3.c
    public void a() {
        super.a();
        b(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        t();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j10) {
        float n10;
        float m10;
        s();
        if (this.f١٨٩١٧l != null && isRunning()) {
            com.airbnb.lottie.e.b("LottieValueAnimator#doFrame");
            long j11 = this.f١٨٩١١f;
            long j12 = 0;
            if (j11 != 0) {
                j12 = j10 - j11;
            }
            float l10 = ((float) j12) / l();
            float f10 = this.f١٨٩١٢g;
            if (p()) {
                l10 = -l10;
            }
            float f11 = f10 + l10;
            boolean d10 = k.d(f11, n(), m());
            float f12 = this.f١٨٩١٢g;
            float b10 = k.b(f11, n(), m());
            this.f١٨٩١٢g = b10;
            if (this.f١٨٩١٩n) {
                b10 = (float) Math.floor(b10);
            }
            this.f١٨٩١٣h = b10;
            this.f١٨٩١١f = j10;
            if (!this.f١٨٩١٩n || this.f١٨٩١٢g != f12) {
                g();
            }
            if (!d10) {
                if (getRepeatCount() != -1 && this.f١٨٩١٤i >= getRepeatCount()) {
                    if (this.f١٨٩٠٩d < DownloadProgress.UNKNOWN_PROGRESS) {
                        m10 = n();
                    } else {
                        m10 = m();
                    }
                    this.f١٨٩١٢g = m10;
                    this.f١٨٩١٣h = m10;
                    t();
                    b(p());
                } else {
                    d();
                    this.f١٨٩١٤i++;
                    if (getRepeatMode() == 2) {
                        this.f١٨٩١٠e = !this.f١٨٩١٠e;
                        w();
                    } else {
                        if (p()) {
                            n10 = m();
                        } else {
                            n10 = n();
                        }
                        this.f١٨٩١٢g = n10;
                        this.f١٨٩١٣h = n10;
                    }
                    this.f١٨٩١١f = j10;
                }
            }
            E();
            com.airbnb.lottie.e.c("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float n10;
        float m10;
        float n11;
        if (this.f١٨٩١٧l == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (p()) {
            n10 = m() - this.f١٨٩١٣h;
            m10 = m();
            n11 = n();
        } else {
            n10 = this.f١٨٩١٣h - n();
            m10 = m();
            n11 = n();
        }
        return n10 / (m10 - n11);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(j());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.f١٨٩١٧l == null) {
            return 0L;
        }
        return r0.d();
    }

    public void h() {
        this.f١٨٩١٧l = null;
        this.f١٨٩١٥j = -2.1474836E9f;
        this.f١٨٩١٦k = 2.1474836E9f;
    }

    public void i() {
        t();
        b(p());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f١٨٩١٨m;
    }

    public float j() {
        com.airbnb.lottie.j jVar = this.f١٨٩١٧l;
        if (jVar == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return (this.f١٨٩١٣h - jVar.p()) / (this.f١٨٩١٧l.f() - this.f١٨٩١٧l.p());
    }

    public float k() {
        return this.f١٨٩١٣h;
    }

    public float m() {
        com.airbnb.lottie.j jVar = this.f١٨٩١٧l;
        if (jVar == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f10 = this.f١٨٩١٦k;
        if (f10 == 2.1474836E9f) {
            return jVar.f();
        }
        return f10;
    }

    public float n() {
        com.airbnb.lottie.j jVar = this.f١٨٩١٧l;
        if (jVar == null) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float f10 = this.f١٨٩١٥j;
        if (f10 == -2.1474836E9f) {
            return jVar.p();
        }
        return f10;
    }

    public float o() {
        return this.f١٨٩٠٩d;
    }

    public void q() {
        t();
        c();
    }

    public void r() {
        float n10;
        this.f١٨٩١٨m = true;
        f(p());
        if (p()) {
            n10 = m();
        } else {
            n10 = n();
        }
        y((int) n10);
        this.f١٨٩١١f = 0L;
        this.f١٨٩١٤i = 0;
        s();
    }

    protected void s() {
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i10) {
        super.setRepeatMode(i10);
        if (i10 != 2 && this.f١٨٩١٠e) {
            this.f١٨٩١٠e = false;
            w();
        }
    }

    protected void t() {
        u(true);
    }

    protected void u(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f١٨٩١٨m = false;
        }
    }

    public void v() {
        this.f١٨٩١٨m = true;
        s();
        this.f١٨٩١١f = 0L;
        if (p() && k() == n()) {
            y(m());
        } else if (!p() && k() == m()) {
            y(n());
        }
        e();
    }

    public void w() {
        C(-o());
    }

    public void x(com.airbnb.lottie.j jVar) {
        boolean z10;
        if (this.f١٨٩١٧l == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f١٨٩١٧l = jVar;
        if (z10) {
            A(Math.max(this.f١٨٩١٥j, jVar.p()), Math.min(this.f١٨٩١٦k, jVar.f()));
        } else {
            A((int) jVar.p(), (int) jVar.f());
        }
        float f10 = this.f١٨٩١٣h;
        this.f١٨٩١٣h = DownloadProgress.UNKNOWN_PROGRESS;
        this.f١٨٩١٢g = DownloadProgress.UNKNOWN_PROGRESS;
        y((int) f10);
        g();
    }

    public void y(float f10) {
        if (this.f١٨٩١٢g == f10) {
            return;
        }
        float b10 = k.b(f10, n(), m());
        this.f١٨٩١٢g = b10;
        if (this.f١٨٩١٩n) {
            b10 = (float) Math.floor(b10);
        }
        this.f١٨٩١٣h = b10;
        this.f١٨٩١١f = 0L;
        g();
    }

    public void z(float f10) {
        A(this.f١٨٩١٥j, f10);
    }
}
