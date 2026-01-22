package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Property;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinVersion;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class g extends Drawable implements Animatable {

    /* renamed from: q, reason: collision with root package name */
    private static final Property f٩٦٦٣q = new c(Float.class, "growFraction");

    /* renamed from: a, reason: collision with root package name */
    final Context f٩٦٦٤a;

    /* renamed from: b, reason: collision with root package name */
    final com.google.android.material.progressindicator.a f٩٦٦٥b;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f٩٦٦٧d;

    /* renamed from: e, reason: collision with root package name */
    private ValueAnimator f٩٦٦٨e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٩٦٦٩f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٩٦٧٠g;

    /* renamed from: h, reason: collision with root package name */
    private float f٩٦٧١h;

    /* renamed from: j, reason: collision with root package name */
    private List f٩٦٧٣j;

    /* renamed from: k, reason: collision with root package name */
    private androidx.vectordrawable.graphics.drawable.b f٩٦٧٤k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f٩٦٧٥l;

    /* renamed from: m, reason: collision with root package name */
    private float f٩٦٧٦m;

    /* renamed from: o, reason: collision with root package name */
    private int f٩٦٧٨o;

    /* renamed from: i, reason: collision with root package name */
    private float f٩٦٧٢i = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    final Paint f٩٦٧٧n = new Paint();

    /* renamed from: p, reason: collision with root package name */
    Rect f٩٦٧٩p = new Rect();

    /* renamed from: c, reason: collision with root package name */
    b8.a f٩٦٦٦c = new b8.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            g.this.f();
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
            g.super.setVisible(false, false);
            g.this.e();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(g gVar) {
            return Float.valueOf(gVar.h());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(g gVar, Float f10) {
            gVar.p(f10.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Context context, com.google.android.material.progressindicator.a aVar) {
        this.f٩٦٦٤a = context;
        this.f٩٦٦٥b = aVar;
        setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
    }

    private void d(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f٩٦٧٥l;
        this.f٩٦٧٥l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f٩٦٧٥l = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f٩٦٧٤k;
        if (bVar != null) {
            bVar.b(this);
        }
        List list = this.f٩٦٧٣j;
        if (list != null && !this.f٩٦٧٥l) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((androidx.vectordrawable.graphics.drawable.b) it.next()).b(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        androidx.vectordrawable.graphics.drawable.b bVar = this.f٩٦٧٤k;
        if (bVar != null) {
            bVar.c(this);
        }
        List list = this.f٩٦٧٣j;
        if (list != null && !this.f٩٦٧٥l) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((androidx.vectordrawable.graphics.drawable.b) it.next()).c(this);
            }
        }
    }

    private void g(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f٩٦٧٥l;
        this.f٩٦٧٥l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f٩٦٧٥l = z10;
    }

    private boolean k() {
        return this instanceof f;
    }

    private void n() {
        if (this.f٩٦٦٧d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<g, Float>) f٩٦٦٣q, DownloadProgress.UNKNOWN_PROGRESS, 1.0f);
            this.f٩٦٦٧d = ofFloat;
            ofFloat.setDuration(500L);
            this.f٩٦٦٧d.setInterpolator(p7.a.f١٦٩٤٨b);
            r(this.f٩٦٦٧d);
        }
        if (this.f٩٦٦٨e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, (Property<g, Float>) f٩٦٦٣q, 1.0f, DownloadProgress.UNKNOWN_PROGRESS);
            this.f٩٦٦٨e = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f٩٦٦٨e.setInterpolator(p7.a.f١٦٩٤٨b);
            q(this.f٩٦٦٨e);
        }
    }

    private void q(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f٩٦٦٨e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f٩٦٦٨e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    private void r(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f٩٦٦٧d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f٩٦٦٧d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f٩٦٧٨o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        if (!this.f٩٦٦٥b.d() && !this.f٩٦٦٥b.c()) {
            return 1.0f;
        }
        if (!this.f٩٦٧٠g && !this.f٩٦٦٩f) {
            return this.f٩٦٧٦m;
        }
        return this.f٩٦٧١h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        int i10;
        float f10 = this.f٩٦٧٢i;
        if (f10 > DownloadProgress.UNKNOWN_PROGRESS) {
            return f10;
        }
        if (!this.f٩٦٦٥b.b(k()) || this.f٩٦٦٥b.f٩٦٠٤m == 0) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        float a10 = this.f٩٦٦٦c.a(this.f٩٦٦٤a.getContentResolver());
        if (a10 <= DownloadProgress.UNKNOWN_PROGRESS) {
            return DownloadProgress.UNKNOWN_PROGRESS;
        }
        if (k()) {
            i10 = this.f٩٦٦٥b.f٩٦٠١j;
        } else {
            i10 = this.f٩٦٦٥b.f٩٦٠٢k;
        }
        int i11 = (int) (((i10 * 1000.0f) / this.f٩٦٦٥b.f٩٦٠٤m) * a10);
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() % i11)) / i11;
        if (uptimeMillis < DownloadProgress.UNKNOWN_PROGRESS) {
            return (uptimeMillis % 1.0f) + 1.0f;
        }
        return uptimeMillis;
    }

    public boolean isRunning() {
        if (!m() && !l()) {
            return false;
        }
        return true;
    }

    public boolean j() {
        return s(false, false, false);
    }

    public boolean l() {
        ValueAnimator valueAnimator = this.f٩٦٦٨e;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f٩٦٧٠g) {
            return true;
        }
        return false;
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.f٩٦٦٧d;
        if ((valueAnimator != null && valueAnimator.isRunning()) || this.f٩٦٦٩f) {
            return true;
        }
        return false;
    }

    public void o(androidx.vectordrawable.graphics.drawable.b bVar) {
        if (this.f٩٦٧٣j == null) {
            this.f٩٦٧٣j = new ArrayList();
        }
        if (!this.f٩٦٧٣j.contains(bVar)) {
            this.f٩٦٧٣j.add(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(float f10) {
        if (this.f٩٦٧٦m != f10) {
            this.f٩٦٧٦m = f10;
            invalidateSelf();
        }
    }

    public boolean s(boolean z10, boolean z11, boolean z12) {
        boolean z13;
        float a10 = this.f٩٦٦٦c.a(this.f٩٦٦٤a.getContentResolver());
        if (z12 && a10 > DownloadProgress.UNKNOWN_PROGRESS) {
            z13 = true;
        } else {
            z13 = false;
        }
        return t(z10, z11, z13);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f٩٦٧٨o = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f٩٦٧٧n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return s(z10, z11, true);
    }

    public void start() {
        t(true, true, false);
    }

    public void stop() {
        t(false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(boolean z10, boolean z11, boolean z12) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        boolean z13;
        boolean c10;
        n();
        if (!isVisible() && !z10) {
            return false;
        }
        if (z10) {
            valueAnimator = this.f٩٦٦٧d;
        } else {
            valueAnimator = this.f٩٦٦٨e;
        }
        if (z10) {
            valueAnimator2 = this.f٩٦٦٨e;
        } else {
            valueAnimator2 = this.f٩٦٦٧d;
        }
        if (!z12) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z10, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        if (z10 && !super.setVisible(z10, false)) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z10) {
            c10 = this.f٩٦٦٥b.d();
        } else {
            c10 = this.f٩٦٦٥b.c();
        }
        if (!c10) {
            g(valueAnimator);
            return z13;
        }
        if (!z11 && valueAnimator.isPaused()) {
            valueAnimator.resume();
        } else {
            valueAnimator.start();
        }
        return z13;
    }

    public boolean u(androidx.vectordrawable.graphics.drawable.b bVar) {
        List list = this.f٩٦٧٣j;
        if (list != null && list.contains(bVar)) {
            this.f٩٦٧٣j.remove(bVar);
            if (this.f٩٦٧٣j.isEmpty()) {
                this.f٩٦٧٣j = null;
                return true;
            }
            return true;
        }
        return false;
    }
}
