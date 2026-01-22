package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.material.R;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d extends i {

    /* renamed from: k, reason: collision with root package name */
    private static final TimeInterpolator f٩٦٣٣k = p7.a.f١٦٩٤٨b;

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f٩٦٣٤l = {0, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, 3000, 4500};

    /* renamed from: m, reason: collision with root package name */
    private static final float[] f٩٦٣٥m = {0.1f, 0.87f};

    /* renamed from: n, reason: collision with root package name */
    private static final Property f٩٦٣٦n = new c(Float.class, "animationFraction");

    /* renamed from: o, reason: collision with root package name */
    private static final Property f٩٦٣٧o = new C٠١١٨d(Float.class, "completeEndFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f٩٦٣٨c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f٩٦٣٩d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f٩٦٤٠e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.a f٩٦٤١f;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٦٤٢g;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٦٤٣h;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٦٤٤i;

    /* renamed from: j, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f٩٦٤٥j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f٩٦٤٢g = (dVar.f٩٦٤٢g + d.f٩٦٣٤l.length) % d.this.f٩٦٤١f.f٩٥٩٦e.length;
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
            d.this.a();
            d dVar = d.this;
            androidx.vectordrawable.graphics.drawable.b bVar = dVar.f٩٦٤٥j;
            if (bVar != null) {
                bVar.b(dVar.f٩٦٩٩a);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f10) {
            dVar.u(f10.floatValue());
        }
    }

    /* renamed from: com.google.android.material.progressindicator.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class C٠١١٨d extends Property {
        C٠١١٨d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(d dVar) {
            return Float.valueOf(dVar.q());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(d dVar, Float f10) {
            dVar.v(f10.floatValue());
        }
    }

    public d(Context context, e eVar) {
        super(1);
        this.f٩٦٤٢g = 0;
        this.f٩٦٤٥j = null;
        this.f٩٦٤١f = eVar;
        this.f٩٦٤٠e = a8.k.g(context, R.attr.motionEasingStandardInterpolator, f٩٦٣٣k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float p() {
        return this.f٩٦٤٣h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float q() {
        return this.f٩٦٤٤i;
    }

    private void r() {
        if (this.f٩٦٣٨c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<d, Float>) f٩٦٣٦n, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٣٨c = ofFloat;
            ofFloat.setDuration(this.f٩٦٤١f.f٩٦٠٥n * 6000.0f);
            this.f٩٦٣٨c.setInterpolator(null);
            this.f٩٦٣٨c.setRepeatCount(-1);
            this.f٩٦٣٨c.addListener(new a());
        }
        if (this.f٩٦٣٩d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<d, Float>) f٩٦٣٧o, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٣٩d = ofFloat2;
            ofFloat2.setDuration(this.f٩٦٤١f.f٩٦٠٥n * 500.0f);
            this.f٩٦٣٩d.addListener(new b());
        }
    }

    private void s(int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = f٩٦٣٤l;
            if (i11 < iArr.length) {
                float b10 = b(i10, iArr[i11], 100);
                if (b10 >= DownloadProgress.UNKNOWN_PROGRESS && b10 <= 1.0f) {
                    int i12 = i11 + this.f٩٦٤٢g;
                    int[] iArr2 = this.f٩٦٤١f.f٩٥٩٦e;
                    int length = i12 % iArr2.length;
                    int length2 = (length + 1) % iArr2.length;
                    int i13 = iArr2[length];
                    int i14 = iArr2[length2];
                    float interpolation = this.f٩٦٤٠e.getInterpolation(b10);
                    ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٩c = p7.c.b().evaluate(interpolation, Integer.valueOf(i13), Integer.valueOf(i14)).intValue();
                    return;
                }
                i11++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(float f10) {
        this.f٩٦٤٤i = f10;
    }

    private void w() {
        r();
        this.f٩٦٣٨c.setDuration(this.f٩٦٤١f.f٩٦٠٥n * 6000.0f);
        this.f٩٦٣٩d.setDuration(this.f٩٦٤١f.f٩٦٠٥n * 500.0f);
    }

    private void x(int i10) {
        h.a aVar = (h.a) this.f٩٧٠٠b.get(0);
        float f10 = this.f٩٦٤٣h * 1080.0f;
        int[] iArr = f٩٦٣٤l;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        for (int i11 : iArr) {
            f11 += this.f٩٦٤٠e.getInterpolation(b(i10, i11, 500)) * 90.0f;
        }
        aVar.f٩٦٩٣g = f10 + f11;
        float interpolation = this.f٩٦٤٠e.getInterpolation(b(i10, 0, 3000)) - this.f٩٦٤٠e.getInterpolation(b(i10, 3000, 3000));
        aVar.f٩٦٨٧a = DownloadProgress.UNKNOWN_PROGRESS;
        float[] fArr = f٩٦٣٥m;
        float f12 = z7.a.f(fArr[0], fArr[1], interpolation);
        aVar.f٩٦٨٨b = f12;
        float f13 = this.f٩٦٤٤i;
        if (f13 > DownloadProgress.UNKNOWN_PROGRESS) {
            aVar.f٩٦٨٨b = f12 * (1.0f - f13);
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void a() {
        ObjectAnimator objectAnimator = this.f٩٦٣٨c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void c() {
        w();
        t();
    }

    @Override // com.google.android.material.progressindicator.i
    public void d(androidx.vectordrawable.graphics.drawable.b bVar) {
        this.f٩٦٤٥j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    void f() {
        ObjectAnimator objectAnimator = this.f٩٦٣٩d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            if (this.f٩٦٩٩a.isVisible()) {
                this.f٩٦٣٩d.start();
            } else {
                a();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.i
    void g() {
        r();
        t();
        this.f٩٦٣٨c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f٩٦٤٥j = null;
    }

    void t() {
        this.f٩٦٤٢g = 0;
        ((h.a) this.f٩٧٠٠b.get(0)).f٩٦٨٩c = this.f٩٦٤١f.f٩٥٩٦e[0];
        this.f٩٦٤٤i = DownloadProgress.UNKNOWN_PROGRESS;
    }

    void u(float f10) {
        this.f٩٦٤٣h = f10;
        int i10 = (int) (f10 * 6000.0f);
        x(i10);
        s(i10);
        this.f٩٦٩٩a.invalidateSelf();
    }
}
