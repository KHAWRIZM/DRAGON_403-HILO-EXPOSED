package td;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class y extends z {

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٨٢١١c;

    /* renamed from: d, reason: collision with root package name */
    final Object f١٨٢١٢d;

    public y(boolean z10, Object obj) {
        this.f١٨٢١١c = z10;
        this.f١٨٢١٢d = obj;
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
            } else if (this.f١٨٢١١c) {
                complete(this.f١٨٢١٢d);
            } else {
                completeExceptionally(new NoSuchElementException());
            }
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        if (this.f١٨٢١٤b != null) {
            this.f١٨٢١٤b = null;
            completeExceptionally(new IllegalArgumentException("Sequence contains more than one element!"));
        } else {
            this.f١٨٢١٤b = obj;
        }
    }
}
