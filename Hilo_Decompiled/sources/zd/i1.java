package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class i1 extends io.reactivex.rxjava3.core.z implements pd.r {

    /* renamed from: a, reason: collision with root package name */
    final Runnable f١٩٨٧٢a;

    public i1(Runnable runnable) {
        this.f١٩٨٧٢a = runnable;
    }

    @Override // pd.r
    public Object get() {
        this.f١٩٨٧٢a.run();
        return null;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        sd.b bVar = new sd.b();
        g0Var.onSubscribe(bVar);
        if (!bVar.isDisposed()) {
            try {
                this.f١٩٨٧٢a.run();
                if (!bVar.isDisposed()) {
                    g0Var.onComplete();
                }
            } catch (Throwable th) {
                od.b.b(th);
                if (!bVar.isDisposed()) {
                    g0Var.onError(th);
                } else {
                    ie.a.s(th);
                }
            }
        }
    }
}
