package zd;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class l4 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final le.c f٢٠٠٣٣a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicBoolean f٢٠٠٣٤b = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l4(le.c cVar) {
        this.f٢٠٠٣٣a = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        if (this.f٢٠٠٣٤b.get() || !this.f٢٠٠٣٤b.compareAndSet(false, true)) {
            return false;
        }
        return true;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f٢٠٠٣٣a.subscribe(g0Var);
        this.f٢٠٠٣٤b.set(true);
    }
}
