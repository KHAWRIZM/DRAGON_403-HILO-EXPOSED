package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class l extends i {

    /* renamed from: i, reason: collision with root package name */
    private static final Property f٩٧١٤i = new b(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f٩٧١٥c;

    /* renamed from: d, reason: collision with root package name */
    private z2.b f٩٧١٦d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.material.progressindicator.a f٩٧١٧e;

    /* renamed from: f, reason: collision with root package name */
    private int f٩٧١٨f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٩٧١٩g;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٧٢٠h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f٩٧١٨f = (lVar.f٩٧١٨f + 1) % l.this.f٩٧١٧e.f٩٥٩٦e.length;
            l.this.f٩٧١٩g = true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(l lVar) {
            return Float.valueOf(lVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(l lVar, Float f10) {
            lVar.r(f10.floatValue());
        }
    }

    public l(n nVar) {
        super(3);
        this.f٩٧١٨f = 1;
        this.f٩٧١٧e = nVar;
        this.f٩٧١٦d = new z2.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f٩٧٢٠h;
    }

    private void o() {
        if (this.f٩٧١٥c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<l, Float>) f٩٧١٤i, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٧١٥c = ofFloat;
            ofFloat.setDuration(this.f٩٧١٧e.f٩٦٠٥n * 333.0f);
            this.f٩٧١٥c.setInterpolator(null);
            this.f٩٧١٥c.setRepeatCount(-1);
            this.f٩٧١٥c.addListener(new a());
        }
    }

    private void p() {
        if (this.f٩٧١٩g && ((h.a) this.f٩٧٠٠b.get(1)).f٩٦٨٨b < 1.0f) {
            ((h.a) this.f٩٧٠٠b.get(2)).f٩٦٨٩c = ((h.a) this.f٩٧٠٠b.get(1)).f٩٦٨٩c;
            ((h.a) this.f٩٧٠٠b.get(1)).f٩٦٨٩c = ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٩c;
            ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٩c = this.f٩٧١٧e.f٩٥٩٦e[this.f٩٧١٨f];
            this.f٩٧١٩g = false;
        }
    }

    private void s() {
        o();
        this.f٩٧١٥c.setDuration(this.f٩٧١٧e.f٩٦٠٥n * 333.0f);
    }

    private void t(int i10) {
        ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٧a = DownloadProgress.UNKNOWN_PROGRESS;
        float b10 = b(i10, 0, 667);
        h.a aVar = (h.a) this.f٩٧٠٠b.get(0);
        h.a aVar2 = (h.a) this.f٩٧٠٠b.get(1);
        float interpolation = this.f٩٧١٦d.getInterpolation(b10);
        aVar2.f٩٦٨٧a = interpolation;
        aVar.f٩٦٨٨b = interpolation;
        h.a aVar3 = (h.a) this.f٩٧٠٠b.get(1);
        h.a aVar4 = (h.a) this.f٩٧٠٠b.get(2);
        float interpolation2 = this.f٩٧١٦d.getInterpolation(b10 + 0.49925038f);
        aVar4.f٩٦٨٧a = interpolation2;
        aVar3.f٩٦٨٨b = interpolation2;
        ((h.a) this.f٩٧٠٠b.get(2)).f٩٦٨٨b = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f٩٧١٥c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        s();
        q();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(androidx.vectordrawable.graphics.drawable.b bVar) {
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        o();
        q();
        this.f٩٧١٥c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
    }

    void q() {
        this.f٩٧١٩g = true;
        this.f٩٧١٨f = 1;
        for (h.a aVar : this.f٩٧٠٠b) {
            com.google.android.material.progressindicator.a aVar2 = this.f٩٧١٧e;
            aVar.f٩٦٨٩c = aVar2.f٩٥٩٦e[0];
            aVar.f٩٦٩٠d = aVar2.f٩٦٠٠i / 2;
        }
    }

    void r(float f10) {
        this.f٩٧٢٠h = f10;
        t((int) (f10 * 333.0f));
        p();
        this.f٩٦٩٩a.invalidateSelf();
    }
}
