package ae;

import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٦٧a;

    /* renamed from: b, reason: collision with root package name */
    final pd.g f٤٦٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements k0 {

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٦٩a;

        /* renamed from: b, reason: collision with root package name */
        final pd.g f٤٧٠b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٤٧١c;

        a(k0 k0Var, pd.g gVar) {
            this.f٤٦٩a = k0Var;
            this.f٤٧٠b = gVar;
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٤٧١c) {
                ie.a.s(th);
            } else {
                this.f٤٦٩a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            try {
                this.f٤٧٠b.accept(cVar);
                this.f٤٦٩a.onSubscribe(cVar);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٤٧١c = true;
                cVar.dispose();
                qd.d.g(th, this.f٤٦٩a);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            if (this.f٤٧١c) {
                return;
            }
            this.f٤٦٩a.onSuccess(obj);
        }
    }

    public c(m0 m0Var, pd.g gVar) {
        this.f٤٦٧a = m0Var;
        this.f٤٦٨b = gVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        this.f٤٦٧a.a(new a(k0Var, this.f٤٦٨b));
    }
}
