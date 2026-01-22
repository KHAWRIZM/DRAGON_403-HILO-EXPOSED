package ae;

import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import pd.r;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final r f٤٧٢a;

    public d(r rVar) {
        this.f٤٧٢a = rVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        try {
            th = (Throwable) fe.j.c(this.f٤٧٢a.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            od.b.b(th);
        }
        qd.d.g(th, k0Var);
    }
}
