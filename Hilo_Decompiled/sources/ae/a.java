package ae;

import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.j0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.l0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class a extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final l0 f٤٦٠a;

    /* renamed from: ae.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class C٠٠٠٤a extends AtomicReference implements j0, nd.c {
        private static final long serialVersionUID = -2467358622224974244L;

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٦١a;

        C٠٠٠٤a(k0 k0Var) {
            this.f٤٦١a = k0Var;
        }

        @Override // io.reactivex.rxjava3.core.j0
        public void a(pd.f fVar) {
            c(new qd.b(fVar));
        }

        @Override // io.reactivex.rxjava3.core.j0
        public boolean b(Throwable th) {
            nd.c cVar;
            if (th == null) {
                th = fe.j.b("onError called with a null Throwable.");
            }
            Object obj = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    this.f٤٦١a.onError(th);
                } finally {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                }
            }
            return false;
        }

        public void c(nd.c cVar) {
            qd.c.f(this, cVar);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) get());
        }

        @Override // io.reactivex.rxjava3.core.j0
        public void onError(Throwable th) {
            if (!b(th)) {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.j0
        public void onSuccess(Object obj) {
            nd.c cVar;
            Object obj2 = get();
            qd.c cVar2 = qd.c.DISPOSED;
            if (obj2 != cVar2 && (cVar = (nd.c) getAndSet(cVar2)) != cVar2) {
                try {
                    if (obj == null) {
                        this.f٤٦١a.onError(fe.j.b("onSuccess called with a null value."));
                    } else {
                        this.f٤٦١a.onSuccess(obj);
                    }
                    if (cVar != null) {
                        cVar.dispose();
                    }
                } catch (Throwable th) {
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    throw th;
                }
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", C٠٠٠٤a.class.getSimpleName(), super.toString());
        }
    }

    public a(l0 l0Var) {
        this.f٤٦٠a = l0Var;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        C٠٠٠٤a r02 = new C٠٠٠٤a(k0Var);
        k0Var.onSubscribe(r02);
        try {
            this.f٤٦٠a.a(r02);
        } catch (Throwable th) {
            od.b.b(th);
            r02.onError(th);
        }
    }
}
