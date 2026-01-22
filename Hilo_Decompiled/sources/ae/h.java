package ae;

import io.reactivex.rxjava3.core.h0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٧٩a;

    /* renamed from: b, reason: collision with root package name */
    final h0 f٤٨٠b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements k0, nd.c, Runnable {
        private static final long serialVersionUID = 3528003840217436037L;

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٨١a;

        /* renamed from: b, reason: collision with root package name */
        final h0 f٤٨٢b;

        /* renamed from: c, reason: collision with root package name */
        Object f٤٨٣c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f٤٨٤d;

        a(k0 k0Var, h0 h0Var) {
            this.f٤٨١a = k0Var;
            this.f٤٨٢b = h0Var;
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
            this.f٤٨٤d = th;
            qd.c.d(this, this.f٤٨٢b.scheduleDirect(this));
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar)) {
                this.f٤٨١a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            this.f٤٨٣c = obj;
            qd.c.d(this, this.f٤٨٢b.scheduleDirect(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f٤٨٤d;
            if (th != null) {
                this.f٤٨١a.onError(th);
            } else {
                this.f٤٨١a.onSuccess(this.f٤٨٣c);
            }
        }
    }

    public h(m0 m0Var, h0 h0Var) {
        this.f٤٧٩a = m0Var;
        this.f٤٨٠b = h0Var;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        this.f٤٧٩a.a(new a(k0Var, this.f٤٨٠b));
    }
}
