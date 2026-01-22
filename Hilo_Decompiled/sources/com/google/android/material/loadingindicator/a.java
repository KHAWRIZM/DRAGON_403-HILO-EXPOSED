package com.google.android.material.loadingindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import com.google.android.material.loadingindicator.c;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import v2.i;
import v2.l;
import v2.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a {

    /* renamed from: i, reason: collision with root package name */
    private static final Property f٩٣٧٠i = new b(Float.class, "animationFraction");

    /* renamed from: j, reason: collision with root package name */
    private static final i f٩٣٧١j = new c("morphFactor");

    /* renamed from: a, reason: collision with root package name */
    private int f٩٣٧٢a;

    /* renamed from: b, reason: collision with root package name */
    private float f٩٣٧٣b;

    /* renamed from: c, reason: collision with root package name */
    private float f٩٣٧٤c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f٩٣٧٥d;

    /* renamed from: e, reason: collision with root package name */
    private l f٩٣٧٦e;

    /* renamed from: f, reason: collision with root package name */
    d f٩٣٧٧f;

    /* renamed from: g, reason: collision with root package name */
    com.google.android.material.loadingindicator.b f٩٣٧٨g;

    /* renamed from: h, reason: collision with root package name */
    c.a f٩٣٧٩h = new c.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.loadingindicator.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class C٠١١٦a extends AnimatorListenerAdapter {
        C٠١١٦a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            a.this.f٩٣٧٦e.u(a.a(a.this));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(a aVar) {
            return Float.valueOf(aVar.f());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(a aVar, Float f10) {
            aVar.l(f10.floatValue());
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends i {
        c(String str) {
            super(str);
        }

        @Override // v2.i
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(a aVar) {
            return aVar.g();
        }

        @Override // v2.i
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(a aVar, float f10) {
            aVar.m(f10);
        }
    }

    public a(d dVar) {
        this.f٩٣٧٧f = dVar;
    }

    static /* synthetic */ int a(a aVar) {
        int i10 = aVar.f٩٣٧٢a + 1;
        aVar.f٩٣٧٢a = i10;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float f() {
        return this.f٩٣٧٣b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float g() {
        return this.f٩٣٧٤c;
    }

    private void i() {
        if (this.f٩٣٧٦e == null) {
            this.f٩٣٧٦e = (l) new l(this, f٩٣٧١j).y(new m().h(200.0f).f(0.6f)).m(0.01f);
        }
        if (this.f٩٣٧٥d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<a, Float>) f٩٣٧٠i, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٣٧٥d = ofFloat;
            ofFloat.setDuration(650L);
            this.f٩٣٧٥d.setInterpolator(null);
            this.f٩٣٧٥d.setRepeatCount(-1);
            this.f٩٣٧٥d.addListener(new C٠١١٦a());
        }
    }

    private void o(int i10) {
        float f10 = this.f٩٣٧٢a - 1;
        float f11 = this.f٩٣٧٤c - f10;
        float f12 = i10 / 650.0f;
        if (f12 == 1.0f) {
            f12 = DownloadProgress.UNKNOWN_PROGRESS;
        }
        this.f٩٣٧٩h.f٩٣٩٦c = (((f10 * 140.0f) + (f12 * 50.0f)) + (f11 * 90.0f)) % 360.0f;
    }

    private void p() {
        c.a aVar = this.f٩٣٧٩h;
        aVar.f٩٣٩٥b = this.f٩٣٧٤c;
        int i10 = this.f٩٣٧٢a - 1;
        int[] iArr = this.f٩٣٧٧f.f٩٤٠١e;
        int length = i10 % iArr.length;
        aVar.f٩٣٩٤a = p7.c.b().evaluate(j2.a.a(this.f٩٣٧٤c - (this.f٩٣٧٢a - 1), DownloadProgress.UNKNOWN_PROGRESS, 1.0f), Integer.valueOf(iArr[length]), Integer.valueOf(iArr[(length + 1) % iArr.length])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        ObjectAnimator objectAnimator = this.f٩٣٧٥d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        l lVar = this.f٩٣٧٦e;
        if (lVar != null) {
            lVar.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(com.google.android.material.loadingindicator.b bVar) {
        this.f٩٣٧٨g = bVar;
    }

    void k() {
        this.f٩٣٧٢a = 1;
        m(DownloadProgress.UNKNOWN_PROGRESS);
        this.f٩٣٧٩h.f٩٣٩٤a = this.f٩٣٧٧f.f٩٤٠١e[0];
    }

    void l(float f10) {
        this.f٩٣٧٣b = f10;
        o((int) (f10 * 650.0f));
        com.google.android.material.loadingindicator.b bVar = this.f٩٣٧٨g;
        if (bVar != null) {
            bVar.invalidateSelf();
        }
    }

    void m(float f10) {
        this.f٩٣٧٤c = f10;
        p();
        com.google.android.material.loadingindicator.b bVar = this.f٩٣٧٨g;
        if (bVar != null) {
            bVar.invalidateSelf();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        i();
        k();
        this.f٩٣٧٦e.u(this.f٩٣٧٢a);
        this.f٩٣٧٥d.start();
    }
}
