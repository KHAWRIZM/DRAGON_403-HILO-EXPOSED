package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class c extends i {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f٩٦١٨k = {0, 1350, 2700, 4050};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f٩٦١٩l = {667, 2017, 3367, 4717};

    /* renamed from: m, reason: collision with root package name */
    private static final int[] f٩٦٢٠m = {1000, 2350, 3700, 5050};

    /* renamed from: n, reason: collision with root package name */
    private static final Property f٩٦٢١n = new C٠١١٧c(Float.class, "animationFraction");

    /* renamed from: o, reason: collision with root package name */
    private static final Property f٩٦٢٢o = new d(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f٩٦٢٣c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f٩٦٢٤d;

    /* renamed from: e, reason: collision with root package name */
    private final z2.b f٩٦٢٥e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.a f٩٦٢٦f;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٦٢٧g;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٦٢٨h;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٦٢٩i;

    /* renamed from: j, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f٩٦٣٠j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            c cVar = c.this;
            cVar.f٩٦٢٧g = (cVar.f٩٦٢٧g + 4) % c.this.f٩٦٢٦f.f٩٥٩٦e.length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            c.this.a();
            c cVar = c.this;
            androidx.vectordrawable.graphics.drawable.b bVar = cVar.f٩٦٣٠j;
            if (bVar != null) {
                bVar.b(cVar.f٩٦٩٩a);
            }
        }
    }

    /* renamed from: com.google.android.material.progressindicator.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١١٧c extends Property {
        C٠١١٧c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            return Float.valueOf(cVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f10) {
            cVar.t(f10.floatValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(c cVar) {
            return Float.valueOf(cVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(c cVar, Float f10) {
            cVar.u(f10.floatValue());
        }
    }

    public c(e eVar) {
        super(1);
        this.f٩٦٢٧g = 0;
        this.f٩٦٣٠j = null;
        this.f٩٦٢٦f = eVar;
        this.f٩٦٢٥e = new z2.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float o() {
        return this.f٩٦٢٨h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f٩٦٢٩i;
    }

    private void q() {
        if (this.f٩٦٢٣c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<c, Float>) f٩٦٢١n, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٢٣c = ofFloat;
            ofFloat.setDuration(this.f٩٦٢٦f.f٩٦٠٥n * 5400.0f);
            this.f٩٦٢٣c.setInterpolator(null);
            this.f٩٦٢٣c.setRepeatCount(-1);
            this.f٩٦٢٣c.addListener(new a());
        }
        if (this.f٩٦٢٤d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<c, Float>) f٩٦٢٢o, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٢٤d = ofFloat2;
            ofFloat2.setDuration(this.f٩٦٢٦f.f٩٦٠٥n * 333.0f);
            this.f٩٦٢٤d.setInterpolator(this.f٩٦٢٥e);
            this.f٩٦٢٤d.addListener(new b());
        }
    }

    private void r(int i10) {
        for (int i11 = 0; i11 < 4; i11++) {
            float b10 = b(i10, f٩٦٢٠m[i11], 333);
            if (b10 > DownloadProgress.UNKNOWN_PROGRESS && b10 < 1.0f) {
                int i12 = i11 + this.f٩٦٢٧g;
                int[] iArr = this.f٩٦٢٦f.f٩٥٩٦e;
                int length = i12 % iArr.length;
                int length2 = (length + 1) % iArr.length;
                int i13 = iArr[length];
                int i14 = iArr[length2];
                float interpolation = this.f٩٦٢٥e.getInterpolation(b10);
                ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٩c = p7.c.b().evaluate(interpolation, Integer.valueOf(i13), Integer.valueOf(i14)).intValue();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(float f10) {
        this.f٩٦٢٩i = f10;
    }

    private void v() {
        q();
        this.f٩٦٢٣c.setDuration(this.f٩٦٢٦f.f٩٦٠٥n * 5400.0f);
        this.f٩٦٢٤d.setDuration(this.f٩٦٢٦f.f٩٦٠٥n * 333.0f);
    }

    private void w(int i10) {
        h.a aVar = (h.a) this.f٩٧٠٠b.get(0);
        float f10 = this.f٩٦٢٨h;
        aVar.f٩٦٨٧a = (f10 * 1520.0f) - 20.0f;
        aVar.f٩٦٨٨b = f10 * 1520.0f;
        for (int i11 = 0; i11 < 4; i11++) {
            aVar.f٩٦٨٨b += this.f٩٦٢٥e.getInterpolation(b(i10, f٩٦١٨k[i11], 667)) * 250.0f;
            aVar.f٩٦٨٧a += this.f٩٦٢٥e.getInterpolation(b(i10, f٩٦١٩l[i11], 667)) * 250.0f;
        }
        float f11 = aVar.f٩٦٨٧a;
        float f12 = aVar.f٩٦٨٨b;
        aVar.f٩٦٨٧a = (f11 + ((f12 - f11) * this.f٩٦٢٩i)) / 360.0f;
        aVar.f٩٦٨٨b = f12 / 360.0f;
    }

    @Override // com.google.android.material.progressindicator.i
    void a() {
        ObjectAnimator objectAnimator = this.f٩٦٢٣c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        v();
        s();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(androidx.vectordrawable.graphics.drawable.b bVar) {
        this.f٩٦٣٠j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    void f() {
        ObjectAnimator objectAnimator = this.f٩٦٢٤d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f٩٦٩٩a.isVisible()) {
                this.f٩٦٢٤d.start();
            } else {
                a();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void g() {
        q();
        s();
        this.f٩٦٢٣c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f٩٦٣٠j = null;
    }

    void s() {
        this.f٩٦٢٧g = 0;
        ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٩c = this.f٩٦٢٦f.f٩٥٩٦e[0];
        this.f٩٦٢٩i = DownloadProgress.UNKNOWN_PROGRESS;
    }

    void t(float f10) {
        this.f٩٦٢٨h = f10;
        int i10 = (int) (f10 * 5400.0f);
        w(i10);
        r(i10);
        this.f٩٦٩٩a.invalidateSelf();
    }
}
