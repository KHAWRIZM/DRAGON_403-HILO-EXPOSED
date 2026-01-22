package he;

import fe.h;
import io.reactivex.rxjava3.core.g0;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class c implements g0, nd.c {

    /* renamed from: a, reason: collision with root package name */
    final AtomicReference f١٤٥٧٤a = new AtomicReference();

    @Override // nd.c
    public final void dispose() {
        qd.c.a(this.f١٤٥٧٤a);
    }

    @Override // nd.c
    public final boolean isDisposed() {
        if (this.f١٤٥٧٤a.get() == qd.c.DISPOSED) {
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public final void onSubscribe(nd.c cVar) {
        if (h.c(this.f١٤٥٧٤a, cVar, getClass())) {
            a();
        }
    }

    protected void a() {
    }
}
