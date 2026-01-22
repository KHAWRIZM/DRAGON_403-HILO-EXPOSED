package zd;

import java.util.Objects;
import zd.p2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class q2 extends io.reactivex.rxjava3.core.i0 {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٣٤٦a;

    /* renamed from: b, reason: collision with root package name */
    final pd.r f٢٠٣٤٧b;

    /* renamed from: c, reason: collision with root package name */
    final pd.c f٢٠٣٤٨c;

    public q2(io.reactivex.rxjava3.core.e0 e0Var, pd.r rVar, pd.c cVar) {
        this.f٢٠٣٤٦a = e0Var;
        this.f٢٠٣٤٧b = rVar;
        this.f٢٠٣٤٨c = cVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(io.reactivex.rxjava3.core.k0 k0Var) {
        try {
            Object obj = this.f٢٠٣٤٧b.get();
            Objects.requireNonNull(obj, "The seedSupplier returned a null value");
            this.f٢٠٣٤٦a.subscribe(new p2.a(k0Var, this.f٢٠٣٤٨c, obj));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.g(th, k0Var);
        }
    }
}
