package io.reactivex.rxjava3.core;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class i0<T> implements m0 {
    public static i0 d(l0 l0Var) {
        Objects.requireNonNull(l0Var, "source is null");
        return ie.a.p(new ae.a(l0Var));
    }

    public static i0 g(Throwable th) {
        Objects.requireNonNull(th, "throwable is null");
        return h(rd.a.l(th));
    }

    public static i0 h(pd.r rVar) {
        Objects.requireNonNull(rVar, "supplier is null");
        return ie.a.p(new ae.d(rVar));
    }

    public static i0 i(Object obj) {
        Objects.requireNonNull(obj, "item is null");
        return ie.a.p(new ae.f(obj));
    }

    public static i0 r(m0 m0Var) {
        Objects.requireNonNull(m0Var, "source is null");
        if (m0Var instanceof i0) {
            return ie.a.p((i0) m0Var);
        }
        return ie.a.p(new ae.e(m0Var));
    }

    @Override // io.reactivex.rxjava3.core.m0
    public final void a(k0 k0Var) {
        Objects.requireNonNull(k0Var, "observer is null");
        k0 y10 = ie.a.y(this, k0Var);
        Objects.requireNonNull(y10, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            o(y10);
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

    public final i0 e(pd.a aVar) {
        Objects.requireNonNull(aVar, "onAfterTerminate is null");
        return ie.a.p(new ae.b(this, aVar));
    }

    public final i0 f(pd.g gVar) {
        Objects.requireNonNull(gVar, "onSubscribe is null");
        return ie.a.p(new ae.c(this, gVar));
    }

    public final i0 j(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.p(new ae.g(this, oVar));
    }

    public final i0 k(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.p(new ae.h(this, h0Var));
    }

    public final i0 l(pd.o oVar) {
        Objects.requireNonNull(oVar, "fallbackSupplier is null");
        return ie.a.p(new ae.i(this, oVar));
    }

    public final nd.c m() {
        return n(rd.a.g(), rd.a.f١٧٥٠٥f);
    }

    public final nd.c n(pd.g gVar, pd.g gVar2) {
        Objects.requireNonNull(gVar, "onSuccess is null");
        Objects.requireNonNull(gVar2, "onError is null");
        ud.i iVar = new ud.i(gVar, gVar2);
        a(iVar);
        return iVar;
    }

    protected abstract void o(k0 k0Var);

    public final i0 p(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.p(new ae.j(this, h0Var));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final z q() {
        if (this instanceof sd.d) {
            return ((sd.d) this).b();
        }
        return ie.a.o(new ae.k(this));
    }
}
