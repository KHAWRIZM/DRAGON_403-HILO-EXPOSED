package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.l1;
import androidx.core.view.m1;
import androidx.core.view.n1;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f٨٧٩c;

    /* renamed from: d, reason: collision with root package name */
    m1 f٨٨٠d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٨٨١e;

    /* renamed from: b, reason: collision with root package name */
    private long f٨٧٨b = -1;

    /* renamed from: f, reason: collision with root package name */
    private final n1 f٨٨٢f = new a();

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f٨٧٧a = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends n1 {

        /* renamed from: a, reason: collision with root package name */
        private boolean f٨٨٣a = false;

        /* renamed from: b, reason: collision with root package name */
        private int f٨٨٤b = 0;

        a() {
        }

        void a() {
            this.f٨٨٤b = 0;
            this.f٨٨٣a = false;
            h.this.b();
        }

        @Override // androidx.core.view.m1
        public void onAnimationEnd(View view) {
            int i10 = this.f٨٨٤b + 1;
            this.f٨٨٤b = i10;
            if (i10 == h.this.f٨٧٧a.size()) {
                m1 m1Var = h.this.f٨٨٠d;
                if (m1Var != null) {
                    m1Var.onAnimationEnd(null);
                }
                a();
            }
        }

        @Override // androidx.core.view.n1, androidx.core.view.m1
        public void onAnimationStart(View view) {
            if (this.f٨٨٣a) {
                return;
            }
            this.f٨٨٣a = true;
            m1 m1Var = h.this.f٨٨٠d;
            if (m1Var != null) {
                m1Var.onAnimationStart(null);
            }
        }
    }

    public void a() {
        if (!this.f٨٨١e) {
            return;
        }
        Iterator it = this.f٨٧٧a.iterator();
        while (it.hasNext()) {
            ((l1) it.next()).c();
        }
        this.f٨٨١e = false;
    }

    void b() {
        this.f٨٨١e = false;
    }

    public h c(l1 l1Var) {
        if (!this.f٨٨١e) {
            this.f٨٧٧a.add(l1Var);
        }
        return this;
    }

    public h d(l1 l1Var, l1 l1Var2) {
        this.f٨٧٧a.add(l1Var);
        l1Var2.j(l1Var.d());
        this.f٨٧٧a.add(l1Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f٨٨١e) {
            this.f٨٧٨b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f٨٨١e) {
            this.f٨٧٩c = interpolator;
        }
        return this;
    }

    public h g(m1 m1Var) {
        if (!this.f٨٨١e) {
            this.f٨٨٠d = m1Var;
        }
        return this;
    }

    public void h() {
        if (this.f٨٨١e) {
            return;
        }
        Iterator it = this.f٨٧٧a.iterator();
        while (it.hasNext()) {
            l1 l1Var = (l1) it.next();
            long j10 = this.f٨٧٨b;
            if (j10 >= 0) {
                l1Var.f(j10);
            }
            Interpolator interpolator = this.f٨٧٩c;
            if (interpolator != null) {
                l1Var.g(interpolator);
            }
            if (this.f٨٨٠d != null) {
                l1Var.h(this.f٨٨٢f);
            }
            l1Var.l();
        }
        this.f٨٨١e = true;
    }
}
