package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class g {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private volatile d0 f٧٠٤٥a;

        /* renamed from: b, reason: collision with root package name */
        private final Context f٧٠٤٦b;

        /* renamed from: c, reason: collision with root package name */
        private volatile i0 f٧٠٤٧c;

        /* renamed from: d, reason: collision with root package name */
        private volatile boolean f٧٠٤٨d;

        /* renamed from: e, reason: collision with root package name */
        private volatile boolean f٧٠٤٩e;

        /* synthetic */ a(Context context, j3 j3Var) {
            this.f٧٠٤٦b = context;
        }

        public g a() {
            if (this.f٧٠٤٦b != null) {
                if (this.f٧٠٤٧c == null) {
                    if (!this.f٧٠٤٨d && !this.f٧٠٤٩e) {
                        throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
                    }
                    return new h(null, this.f٧٠٤٦b, null, null);
                }
                if (this.f٧٠٤٥a != null && this.f٧٠٤٥a.a()) {
                    if (this.f٧٠٤٧c != null) {
                        return new h(null, this.f٧٠٤٥a, this.f٧٠٤٦b, this.f٧٠٤٧c, null, null, null);
                    }
                    return new h(null, this.f٧٠٤٥a, this.f٧٠٤٦b, null, null, null);
                }
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }

        public a b(d0 d0Var) {
            this.f٧٠٤٥a = d0Var;
            return this;
        }

        public a c(i0 i0Var) {
            this.f٧٠٤٧c = i0Var;
            return this;
        }
    }

    public static a i(Context context) {
        return new a(context, null);
    }

    public abstract void a(com.android.billingclient.api.a aVar, b bVar);

    public abstract void b(x xVar, y yVar);

    public abstract void c(b0 b0Var);

    @KeepForSdk
    public abstract void createAlternativeBillingOnlyReportingDetailsAsync(f fVar);

    public abstract void d();

    public abstract void e(z zVar);

    public abstract w f(String str);

    public abstract boolean g();

    public abstract w h(Activity activity, v vVar);

    @KeepForSdk
    public abstract void isAlternativeBillingOnlyAvailableAsync(c cVar);

    public abstract void j(j0 j0Var, f0 f0Var);

    public abstract void k(k0 k0Var, g0 g0Var);

    public abstract void l(String str, g0 g0Var);

    public abstract void m(l0 l0Var, h0 h0Var);

    public abstract void n(String str, h0 h0Var);

    public abstract void o(m0 m0Var, n0 n0Var);

    public abstract void p(u uVar);
}
