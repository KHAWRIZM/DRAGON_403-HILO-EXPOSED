package td;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class s extends z {

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٨٢٠٦c;

    /* renamed from: d, reason: collision with root package name */
    final Object f١٨٢٠٧d;

    public s(boolean z10, Object obj) {
        this.f١٨٢٠٦c = z10;
        this.f١٨٢٠٧d = obj;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        boolean isDone;
        isDone = isDone();
        if (!isDone) {
            Object obj = this.f١٨٢١٤b;
            a();
            if (obj != null) {
                complete(obj);
            } else if (this.f١٨٢٠٦c) {
                complete(this.f١٨٢٠٧d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        this.f١٨٢١٤b = obj;
    }
}
