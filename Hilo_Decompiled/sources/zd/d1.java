package zd;

import java.util.concurrent.Callable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d1 extends io.reactivex.rxjava3.core.z implements pd.r {

    /* renamed from: a, reason: collision with root package name */
    final Callable f١٩٦٧٤a;

    public d1(Callable callable) {
        this.f١٩٦٧٤a = callable;
    }

    @Override // pd.r
    public Object get() {
        return fe.j.c(this.f١٩٦٧٤a.call(), "The Callable returned a null value.");
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        ud.j jVar = new ud.j(g0Var);
        g0Var.onSubscribe(jVar);
        if (jVar.isDisposed()) {
            return;
        }
        try {
            jVar.c(fe.j.c(this.f١٩٦٧٤a.call(), "Callable returned a null value."));
        } catch (Throwable th) {
            od.b.b(th);
            if (!jVar.isDisposed()) {
                g0Var.onError(th);
            } else {
                ie.a.s(th);
            }
        }
    }
}
