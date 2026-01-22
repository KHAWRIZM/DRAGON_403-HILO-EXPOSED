package zd;

import zd.b3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class v1 extends io.reactivex.rxjava3.core.z implements sd.h {

    /* renamed from: a, reason: collision with root package name */
    private final Object f٢٠٦٤٦a;

    public v1(Object obj) {
        this.f٢٠٦٤٦a = obj;
    }

    @Override // sd.h, pd.r
    public Object get() {
        return this.f٢٠٦٤٦a;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        b3.a aVar = new b3.a(g0Var, this.f٢٠٦٤٦a);
        g0Var.onSubscribe(aVar);
        aVar.run();
    }
}
