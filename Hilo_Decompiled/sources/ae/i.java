package ae;

import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import pd.o;
import ud.v;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٨٥a;

    /* renamed from: b, reason: collision with root package name */
    final o f٤٨٦b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements k0, nd.c {
        private static final long serialVersionUID = -5314538511045349925L;

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٨٧a;

        /* renamed from: b, reason: collision with root package name */
        final o f٤٨٨b;

        a(k0 k0Var, o oVar) {
            this.f٤٨٧a = k0Var;
            this.f٤٨٨b = oVar;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            try {
                Object apply = this.f٤٨٨b.apply(th);
                Objects.requireNonNull(apply, "The nextFunction returned a null SingleSource.");
                ((m0) apply).a(new v(this, this.f٤٨٧a));
            } catch (Throwable th2) {
                od.b.b(th2);
                this.f٤٨٧a.onError(new od.a(th, th2));
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar)) {
                this.f٤٨٧a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            this.f٤٨٧a.onSuccess(obj);
        }
    }

    public i(m0 m0Var, o oVar) {
        this.f٤٨٥a = m0Var;
        this.f٤٨٦b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        this.f٤٨٥a.a(new a(k0Var, this.f٤٨٦b));
    }
}
