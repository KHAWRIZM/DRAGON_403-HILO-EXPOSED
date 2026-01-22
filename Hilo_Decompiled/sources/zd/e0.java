package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e0 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final pd.r f١٩٧٠٧a;

    public e0(pd.r rVar) {
        this.f١٩٧٠٧a = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            Object obj = this.f١٩٧٠٧a.get();
            Objects.requireNonNull(obj, "The supplier returned a null ObservableSource");
            ((io.reactivex.rxjava3.core.e0) obj).subscribe(g0Var);
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
