package he;

import fe.h;
import io.reactivex.rxjava3.core.g0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class b implements g0 {

    /* renamed from: a, reason: collision with root package name */
    private nd.c f١٤٥٧٣a;

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public final void onSubscribe(nd.c cVar) {
        if (h.d(this.f١٤٥٧٣a, cVar, getClass())) {
            this.f١٤٥٧٣a = cVar;
            a();
        }
    }

    protected void a() {
    }
}
