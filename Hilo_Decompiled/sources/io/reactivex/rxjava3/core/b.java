package io.reactivex.rxjava3.core;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class b implements f {
    public static b c(e eVar) {
        Objects.requireNonNull(eVar, "source is null");
        return ie.a.l(new vd.a(eVar));
    }

    private static NullPointerException f(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b h(f fVar) {
        Objects.requireNonNull(fVar, "source is null");
        if (fVar instanceof b) {
            return ie.a.l((b) fVar);
        }
        return ie.a.l(new vd.b(fVar));
    }

    @Override // io.reactivex.rxjava3.core.f
    public final void a(d dVar) {
        Objects.requireNonNull(dVar, "observer is null");
        try {
            d v10 = ie.a.v(this, dVar);
            Objects.requireNonNull(v10, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            e(v10);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th) {
            od.b.b(th);
            ie.a.s(th);
            throw f(th);
        }
    }

    public final nd.c d() {
        ud.l lVar = new ud.l();
        a(lVar);
        return lVar;
    }

    protected abstract void e(d dVar);

    /* JADX WARN: Multi-variable type inference failed */
    public final z g() {
        if (this instanceof sd.d) {
            return ((sd.d) this).b();
        }
        return ie.a.o(new vd.c(this));
    }
}
