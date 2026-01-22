package io.reactivex.rxjava3.core;

import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class h<T> implements kf.a {

    /* renamed from: a, reason: collision with root package name */
    static final int f١٤٩٦٣a = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    public static int b() {
        return f١٤٩٦٣a;
    }

    public static h d(kf.a aVar) {
        if (aVar instanceof h) {
            return ie.a.m((h) aVar);
        }
        Objects.requireNonNull(aVar, "publisher is null");
        return ie.a.m(new wd.c(aVar));
    }

    public final Object a() {
        de.d dVar = new de.d();
        o(dVar);
        Object a10 = dVar.a();
        if (a10 != null) {
            return a10;
        }
        throw new NoSuchElementException();
    }

    public final h e(pd.o oVar) {
        Objects.requireNonNull(oVar, "mapper is null");
        return ie.a.m(new wd.e(this, oVar));
    }

    public final h f(h0 h0Var) {
        return g(h0Var, false, b());
    }

    public final h g(h0 h0Var, boolean z10, int i10) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        rd.b.b(i10, "bufferSize");
        return ie.a.m(new wd.f(this, h0Var, z10, i10));
    }

    public final h h() {
        return i(b(), false, true);
    }

    public final h i(int i10, boolean z10, boolean z11) {
        rd.b.b(i10, "capacity");
        return ie.a.m(new wd.g(this, i10, z11, z10, rd.a.f١٧٥٠٢c));
    }

    public final h j() {
        return ie.a.m(new wd.h(this));
    }

    public final h k() {
        return ie.a.m(new wd.j(this));
    }

    public final nd.c l(pd.g gVar) {
        return n(gVar, rd.a.f١٧٥٠٥f, rd.a.f١٧٥٠٢c);
    }

    public final nd.c m(pd.g gVar, pd.g gVar2) {
        return n(gVar, gVar2, rd.a.f١٧٥٠٢c);
    }

    public final nd.c n(pd.g gVar, pd.g gVar2, pd.a aVar) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        de.e eVar = new de.e(gVar, gVar2, aVar, wd.d.INSTANCE);
        o(eVar);
        return eVar;
    }

    public final void o(i iVar) {
        Objects.requireNonNull(iVar, "subscriber is null");
        try {
            kf.b z10 = ie.a.z(this, iVar);
            Objects.requireNonNull(z10, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            p(z10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    protected abstract void p(kf.b bVar);

    public final h q(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        return r(h0Var, true);
    }

    public final h r(h0 h0Var, boolean z10) {
        Objects.requireNonNull(h0Var, "scheduler is null");
        return ie.a.m(new wd.k(this, h0Var, z10));
    }

    public final void subscribe(kf.b bVar) {
        if (bVar instanceof i) {
            o((i) bVar);
        } else {
            Objects.requireNonNull(bVar, "subscriber is null");
            o(new de.f(bVar));
        }
    }
}
