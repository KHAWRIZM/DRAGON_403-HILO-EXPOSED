package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b1 extends io.reactivex.rxjava3.core.z implements pd.r {

    /* renamed from: a, reason: collision with root package name */
    final pd.a f١٩٥٧٤a;

    public b1(pd.a aVar) {
        this.f١٩٥٧٤a = aVar;
    }

    @Override // pd.r
    public Object get() {
        this.f١٩٥٧٤a.run();
        return null;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        sd.b bVar = new sd.b();
        g0Var.onSubscribe(bVar);
        if (!bVar.isDisposed()) {
            try {
                this.f١٩٥٧٤a.run();
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
