package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import com.google.android.material.R;
import com.google.android.material.progressindicator.h;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class m extends i {

    /* renamed from: k, reason: collision with root package name */
    private static final int[] f٩٧٢٢k = {533, 567, 850, 750};

    /* renamed from: l, reason: collision with root package name */
    private static final int[] f٩٧٢٣l = {1267, 1000, 333, 0};

    /* renamed from: m, reason: collision with root package name */
    private static final Property f٩٧٢٤m = new c(Float.class, "animationFraction");

    /* renamed from: c, reason: collision with root package name */
    private ObjectAnimator f٩٧٢٥c;

    /* renamed from: d, reason: collision with root package name */
    private ObjectAnimator f٩٧٢٦d;

    /* renamed from: e, reason: collision with root package name */
    private final Interpolator[] f٩٧٢٧e;

    /* renamed from: f, reason: collision with root package name */
    private final com.google.android.material.progressindicator.a f٩٧٢٨f;

    /* renamed from: g, reason: collision with root package name */
    private int f٩٧٢٩g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f٩٧٣٠h;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٧٣١i;

    /* renamed from: j, reason: collision with root package name */
    androidx.vectordrawable.graphics.drawable.b f٩٧٣٢j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            m mVar = m.this;
            mVar.f٩٧٢٩g = (mVar.f٩٧٢٩g + 1) % m.this.f٩٧٢٨f.f٩٥٩٦e.length;
            m.this.f٩٧٣٠h = true;
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
            m.this.a();
            m mVar = m.this;
            androidx.vectordrawable.graphics.drawable.b bVar = mVar.f٩٧٣٢j;
            if (bVar != null) {
                bVar.b(mVar.f٩٦٩٩a);
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
        public Float get(m mVar) {
            return Float.valueOf(mVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(m mVar, Float f10) {
            mVar.r(f10.floatValue());
        }
    }

    public m(Context context, n nVar) {
        super(2);
        this.f٩٧٢٩g = 0;
        this.f٩٧٣٢j = null;
        this.f٩٧٢٨f = nVar;
        this.f٩٧٢٧e = new Interpolator[]{androidx.vectordrawable.graphics.drawable.f.a(context, R.anim.linear_indeterminate_line1_head_interpolator), androidx.vectordrawable.graphics.drawable.f.a(context, R.anim.linear_indeterminate_line1_tail_interpolator), androidx.vectordrawable.graphics.drawable.f.a(context, R.anim.linear_indeterminate_line2_head_interpolator), androidx.vectordrawable.graphics.drawable.f.a(context, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.f٩٧٣١i;
    }

    private void o() {
        if (this.f٩٧٢٥c == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<m, Float>) f٩٧٢٤m, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٧٢٥c = ofFloat;
            ofFloat.setDuration(this.f٩٧٢٨f.f٩٦٠٥n * 1800.0f);
            this.f٩٧٢٥c.setInterpolator(null);
            this.f٩٧٢٥c.setRepeatCount(-1);
            this.f٩٧٢٥c.addListener(new a());
        }
        if (this.f٩٧٢٦d == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<m, Float>) f٩٧٢٤m, 1.0f);
            this.f٩٧٢٦d = ofFloat2;
            ofFloat2.setDuration(this.f٩٧٢٨f.f٩٦٠٥n * 1800.0f);
            this.f٩٧٢٦d.setInterpolator(null);
            this.f٩٧٢٦d.addListener(new b());
        }
    }

    private void p() {
        if (this.f٩٧٣٠h) {
            Iterator it = this.f٩٧٠٠b.iterator();
            while (it.hasNext()) {
                ((h.a) it.next()).f٩٦٨٩c = this.f٩٧٢٨f.f٩٥٩٦e[this.f٩٧٢٩g];
            }
            this.f٩٧٣٠h = false;
        }
    }

    private void s() {
        o();
        this.f٩٧٢٥c.setDuration(this.f٩٧٢٨f.f٩٦٠٥n * 1800.0f);
        this.f٩٧٢٦d.setDuration(this.f٩٧٢٨f.f٩٦٠٥n * 1800.0f);
    }

    private void t(int i10) {
        for (int i11 = 0; i11 < this.f٩٧٠٠b.size(); i11++) {
            h.a aVar = (h.a) this.f٩٧٠٠b.get(i11);
            int[] iArr = f٩٧٢٣l;
            int i12 = i11 * 2;
            int i13 = iArr[i12];
            int[] iArr2 = f٩٧٢٢k;
            aVar.f٩٦٨٧a = j2.a.a(this.f٩٧٢٧e[i12].getInterpolation(b(i10, i13, iArr2[i12])), DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            int i14 = i12 + 1;
            aVar.f٩٦٨٨b = j2.a.a(this.f٩٧٢٧e[i14].getInterpolation(b(i10, iArr[i14], iArr2[i14])), DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void a() {
        ObjectAnimator objectAnimator = this.f٩٧٢٥c;
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
        this.f٩٧٣٢j = bVar;
    }

    @Override // com.google.android.material.progressindicator.i
    public void f() {
        ObjectAnimator objectAnimator = this.f٩٧٢٦d;
        if (objectAnimator != null && !objectAnimator.isRunning()) {
            a();
            if (this.f٩٦٩٩a.isVisible()) {
                this.f٩٧٢٦d.setFloatValues(this.f٩٧٣١i, 1.0f);
                this.f٩٧٢٦d.setDuration((1.0f - this.f٩٧٣١i) * 1800.0f);
                this.f٩٧٢٦d.start();
            }
        }
    }

    @Override // com.google.android.material.progressindicator.i
    public void g() {
        o();
        q();
        this.f٩٧٢٥c.start();
    }

    @Override // com.google.android.material.progressindicator.i
    public void h() {
        this.f٩٧٣٢j = null;
    }

    void q() {
        this.f٩٧٢٩g = 0;
        Iterator it = this.f٩٧٠٠b.iterator();
        while (it.hasNext()) {
            ((h.a) it.next()).f٩٦٨٩c = this.f٩٧٢٨f.f٩٥٩٦e[0];
        }
    }

    void r(float f10) {
        this.f٩٧٣١i = f10;
        t((int) (f10 * 1800.0f));
        p();
        this.f٩٦٩٩a.invalidateSelf();
    }
}
