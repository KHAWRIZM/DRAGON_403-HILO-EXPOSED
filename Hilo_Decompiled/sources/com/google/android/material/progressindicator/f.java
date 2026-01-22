package com.google.android.material.progressindicator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import com.google.android.material.R;
import com.google.android.material.progressindicator.f;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import v2.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f extends g {
    private static final v2.i C = new a("indicatorLevel");
    private TimeInterpolator A;

    /* renamed from: B, reason: collision with root package name */
    private TimeInterpolator f٩٦٥٣B;

    /* renamed from: r, reason: collision with root package name */
    private h f٩٦٥٤r;

    /* renamed from: s, reason: collision with root package name */
    private final v2.m f٩٦٥٥s;

    /* renamed from: t, reason: collision with root package name */
    private final v2.l f٩٦٥٦t;

    /* renamed from: u, reason: collision with root package name */
    private final h.a f٩٦٥٧u;

    /* renamed from: v, reason: collision with root package name */
    private float f٩٦٥٨v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f٩٦٥٩w;

    /* renamed from: x, reason: collision with root package name */
    private final ValueAnimator f٩٦٦٠x;

    /* renamed from: y, reason: collision with root package name */
    private ValueAnimator f٩٦٦١y;

    /* renamed from: z, reason: collision with root package name */
    private TimeInterpolator f٩٦٦٢z;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends v2.i {
        a(String str) {
            super(str);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(f fVar) {
            return fVar.E() * 10000.0f;
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(f fVar, float f10) {
            fVar.M(f10 / 10000.0f);
            fVar.I((int) f10);
        }
    }

    f(Context context, final com.google.android.material.progressindicator.a aVar, h hVar) {
        super(context, aVar);
        this.f٩٦٥٩w = false;
        K(hVar);
        h.a aVar2 = new h.a();
        this.f٩٦٥٧u = aVar2;
        aVar2.f٩٦٩٤h = true;
        v2.m mVar = new v2.m();
        this.f٩٦٥٥s = mVar;
        mVar.f(1.0f);
        mVar.h(50.0f);
        v2.l lVar = new v2.l(this, C);
        this.f٩٦٥٦t = lVar;
        lVar.y(mVar);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f٩٦٦٠x = valueAnimator;
        valueAnimator.setDuration(1000L);
        valueAnimator.setFloatValues(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        valueAnimator.setRepeatCount(-1);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b8.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                f.this.G(aVar, valueAnimator2);
            }
        });
        if (aVar.b(true) && aVar.f٩٦٠٤m != 0) {
            valueAnimator.start();
        }
        p(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f A(Context context, e eVar, b bVar) {
        return new f(context, eVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f B(Context context, n nVar, k kVar) {
        return new f(context, nVar, kVar);
    }

    private float C(int i10) {
        float f10 = i10;
        if (f10 < 1000.0f || f10 > 9000.0f) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float E() {
        return this.f٩٦٥٧u.f٩٦٨٨b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        this.f٩٦٥٧u.f٩٦٩١e = this.f٩٦٦٢z.getInterpolation(this.f٩٦٦١y.getAnimatedFraction());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(com.google.android.material.progressindicator.a aVar, ValueAnimator valueAnimator) {
        if (aVar.b(true) && aVar.f٩٦٠٤m != 0 && isVisible()) {
            invalidateSelf();
        }
    }

    private void H() {
        if (this.f٩٦٦١y != null) {
            return;
        }
        Context context = this.f٩٦٦٤a;
        int i10 = R.attr.motionEasingStandardInterpolator;
        TimeInterpolator timeInterpolator = p7.a.f١٦٩٤٧a;
        this.A = a8.k.g(context, i10, timeInterpolator);
        this.f٩٦٥٣B = a8.k.g(this.f٩٦٦٤a, R.attr.motionEasingEmphasizedAccelerateInterpolator, timeInterpolator);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f٩٦٦١y = valueAnimator;
        valueAnimator.setDuration(500L);
        this.f٩٦٦١y.setFloatValues(DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        this.f٩٦٦١y.setInterpolator(null);
        this.f٩٦٦١y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: b8.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                f.this.F(valueAnimator2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i10) {
        if (!this.f٩٦٦٥b.b(true)) {
            return;
        }
        H();
        float C2 = C(i10);
        if (C2 != this.f٩٦٥٨v) {
            if (this.f٩٦٦١y.isRunning()) {
                this.f٩٦٦١y.cancel();
            }
            this.f٩٦٥٨v = C2;
            if (C2 == 1.0f) {
                this.f٩٦٦٢z = this.A;
                this.f٩٦٦١y.start();
                return;
            } else {
                this.f٩٦٦٢z = this.f٩٦٥٣B;
                this.f٩٦٦١y.reverse();
                return;
            }
        }
        if (!this.f٩٦٦١y.isRunning()) {
            J(C2);
        }
    }

    private void J(float f10) {
        this.f٩٦٥٧u.f٩٦٩١e = f10;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(float f10) {
        this.f٩٦٥٧u.f٩٦٨٨b = f10;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h D() {
        return this.f٩٦٥٤r;
    }

    void K(h hVar) {
        this.f٩٦٥٤r = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z10) {
        if (z10 && !this.f٩٦٦٠x.isRunning()) {
            this.f٩٦٦٠x.start();
        } else if (!z10 && this.f٩٦٦٠x.isRunning()) {
            this.f٩٦٦٠x.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(float f10) {
        setLevel((int) (f10 * 10000.0f));
    }

    public void addSpringAnimationEndListener(h.q qVar) {
        this.f٩٦٥٦t.b(qVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.f٩٦٧٩p)) {
            canvas.save();
            this.f٩٦٥٤r.h(canvas, getBounds(), h(), m(), l());
            this.f٩٦٥٧u.f٩٦٩٢f = i();
            this.f٩٦٧٧n.setStyle(Paint.Style.FILL);
            this.f٩٦٧٧n.setAntiAlias(true);
            h.a aVar = this.f٩٦٥٧u;
            com.google.android.material.progressindicator.a aVar2 = this.f٩٦٦٥b;
            aVar.f٩٦٨٩c = aVar2.f٩٥٩٦e[0];
            int i10 = aVar2.f٩٦٠٠i;
            if (i10 > 0) {
                if (!(this.f٩٦٥٤r instanceof k)) {
                    i10 = (int) ((i10 * j2.a.a(E(), DownloadProgress.UNKNOWN_PROGRESS, 0.01f)) / 0.01f);
                }
                this.f٩٦٥٤r.d(canvas, this.f٩٦٧٧n, E(), 1.0f, this.f٩٦٦٥b.f٩٥٩٧f, getAlpha(), i10);
            } else {
                this.f٩٦٥٤r.d(canvas, this.f٩٦٧٧n, DownloadProgress.UNKNOWN_PROGRESS, 1.0f, aVar2.f٩٥٩٧f, getAlpha(), 0);
            }
            this.f٩٦٥٤r.c(canvas, this.f٩٦٧٧n, this.f٩٦٥٧u, getAlpha());
            this.f٩٦٥٤r.b(canvas, this.f٩٦٧٧n, this.f٩٦٦٥b.f٩٥٩٦e[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f٩٦٥٤r.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f٩٦٥٤r.f();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f٩٦٥٦t.z();
        M(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ void o(androidx.vectordrawable.graphics.drawable.b bVar) {
        super.o(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        float C2 = C(i10);
        if (this.f٩٦٥٩w) {
            this.f٩٦٥٦t.z();
            M(i10 / 10000.0f);
            J(C2);
            return true;
        }
        this.f٩٦٥٦t.o(E() * 10000.0f);
        this.f٩٦٥٦t.u(i10);
        return true;
    }

    public void removeSpringAnimationEndListener(h.q qVar) {
        this.f٩٦٥٦t.removeEndListener(qVar);
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean s(boolean z10, boolean z11, boolean z12) {
        return super.s(z10, z11, z12);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.g, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.g
    public boolean t(boolean z10, boolean z11, boolean z12) {
        boolean t10 = super.t(z10, z11, z12);
        float a10 = this.f٩٦٦٦c.a(this.f٩٦٦٤a.getContentResolver());
        if (a10 == DownloadProgress.UNKNOWN_PROGRESS) {
            this.f٩٦٥٩w = true;
        } else {
            this.f٩٦٥٩w = false;
            this.f٩٦٥٥s.h(50.0f / a10);
        }
        return t10;
    }

    @Override // com.google.android.material.progressindicator.g
    public /* bridge */ /* synthetic */ boolean u(androidx.vectordrawable.graphics.drawable.b bVar) {
        return super.u(bVar);
    }
}
