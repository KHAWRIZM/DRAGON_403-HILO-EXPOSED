package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class t0 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final pd.r f٢٠٥٠٥a;

    public t0(pd.r rVar) {
        this.f٢٠٥٠٥a = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            th = (Throwable) fe.j.c(this.f٢٠٥٠٥a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            od.b.b(th);
        }
        qd.d.f(th, g0Var);
    }
}
