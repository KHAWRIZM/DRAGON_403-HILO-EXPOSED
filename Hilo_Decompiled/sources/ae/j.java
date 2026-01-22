package ae;

import io.reactivex.rxjava3.core.h0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٨٩a;

    /* renamed from: b, reason: collision with root package name */
    final h0 f٤٩٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements k0, nd.c, Runnable {
        private static final long serialVersionUID = 7000911171163930287L;

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٩١a;

        /* renamed from: b, reason: collision with root package name */
        final qd.f f٤٩٢b = new qd.f();

        /* renamed from: c, reason: collision with root package name */
        final m0 f٤٩٣c;

        a(k0 k0Var, m0 m0Var) {
            this.f٤٩١a = k0Var;
            this.f٤٩٣c = m0Var;
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
            this.f٤٩٢b.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٤٩١a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            this.f٤٩١a.onSuccess(obj);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f٤٩٣c.a(this);
        }
    }

    public j(m0 m0Var, h0 h0Var) {
        this.f٤٨٩a = m0Var;
        this.f٤٩٠b = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        a aVar = new a(k0Var, this.f٤٨٩a);
        k0Var.onSubscribe(aVar);
        aVar.f٤٩٢b.a(this.f٤٩٠b.scheduleDirect(aVar));
    }
}
