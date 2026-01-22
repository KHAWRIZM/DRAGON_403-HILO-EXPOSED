package td;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j extends z {

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٨١٨٨c;

    /* renamed from: d, reason: collision with root package name */
    final Object f١٨١٨٩d;

    public j(boolean z10, Object obj) {
        this.f١٨١٨٨c = z10;
        this.f١٨١٨٩d = obj;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        boolean isDone;
        isDone = isDone();
        if (!isDone) {
            a();
            if (this.f١٨١٨٨c) {
                complete(this.f١٨١٨٩d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        complete(obj);
    }
}
