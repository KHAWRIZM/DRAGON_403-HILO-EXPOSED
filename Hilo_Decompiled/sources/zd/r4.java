package zd;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class r4 extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {
    private static final long serialVersionUID = -8612022020200669122L;

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.g0 f٢٠٤٣٩a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f٢٠٤٤٠b = new AtomicReference();

    public r4(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f٢٠٤٣٩a = g0Var;
    }

    public void a(nd.c cVar) {
        qd.c.f(this, cVar);
    }

    @Override // nd.c
    public void dispose() {
        qd.c.a(this.f٢٠٤٤٠b);
        qd.c.a(this);
    }

    @Override // nd.c
    public boolean isDisposed() {
        if (this.f٢٠٤٤٠b.get() == qd.c.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        dispose();
        this.f٢٠٤٣٩a.onComplete();
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        dispose();
        this.f٢٠٤٣٩a.onError(th);
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        this.f٢٠٤٣٩a.onNext(obj);
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (qd.c.g(this.f٢٠٤٤٠b, cVar)) {
            this.f٢٠٤٣٩a.onSubscribe(this);
        }
    }
}
