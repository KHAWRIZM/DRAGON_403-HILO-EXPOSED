package zd;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f1 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final Future f١٩٧٦٤a;

    /* renamed from: b, reason: collision with root package name */
    final long f١٩٧٦٥b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f١٩٧٦٦c;

    public f1(Future future, long j10, TimeUnit timeUnit) {
        this.f١٩٧٦٤a = future;
        this.f١٩٧٦٥b = j10;
        this.f١٩٧٦٦c = timeUnit;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        Object obj;
        ud.j jVar = new ud.j(g0Var);
        g0Var.onSubscribe(jVar);
        if (!jVar.isDisposed()) {
            try {
                TimeUnit timeUnit = this.f١٩٧٦٦c;
                if (timeUnit != null) {
                    obj = this.f١٩٧٦٤a.get(this.f١٩٧٦٥b, timeUnit);
                } else {
                    obj = this.f١٩٧٦٤a.get();
                }
                jVar.c(fe.j.c(obj, "Future returned a null value."));
            } catch (Throwable th) {
                od.b.b(th);
                if (!jVar.isDisposed()) {
                    g0Var.onError(th);
                }
            }
        }
    }
}
