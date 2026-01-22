package ud;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e extends d {
    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        if (this.f١٨٢٨٧a == null) {
            this.f١٨٢٨٨b = th;
        }
        countDown();
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٨٢٨٧a == null) {
            this.f١٨٢٨٧a = obj;
            this.f١٨٢٨٩c.dispose();
            countDown();
        }
    }
}
