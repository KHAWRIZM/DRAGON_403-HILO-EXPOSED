package io.reactivex.rxjava3.core;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class j<T> implements n {
    public static j d(m mVar) {
        Objects.requireNonNull(mVar, "onSubscribe is null");
        return ie.a.n(new xd.b(mVar));
    }

    public static j g(n nVar) {
        if (nVar instanceof j) {
            return ie.a.n((j) nVar);
        }
        Objects.requireNonNull(nVar, "source is null");
        return ie.a.n(new xd.d(nVar));
    }

    @Override // io.reactivex.rxjava3.core.n
    public final void a(l lVar) {
        Objects.requireNonNull(lVar, "observer is null");
        l w10 = ie.a.w(this, lVar);
        Objects.requireNonNull(w10, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            e(w10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            od.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final Object c() {
        ud.g gVar = new ud.g();
        a(gVar);
        return gVar.a();
    }

    protected abstract void e(l lVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final z f() {
        if (this instanceof sd.d) {
            return ((sd.d) this).b();
        }
        return ie.a.o(new xd.c(this));
    }
}
