package ud;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class f extends d {
    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        this.f١٨٢٨٧a = null;
        this.f١٨٢٨٨b = th;
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        this.f١٨٢٨٧a = obj;
    }
}
