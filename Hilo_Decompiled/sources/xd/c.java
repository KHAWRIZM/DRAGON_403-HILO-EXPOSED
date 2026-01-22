package xd;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.l;
import io.reactivex.rxjava3.core.n;
import io.reactivex.rxjava3.core.z;
import ud.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class c extends z {

    /* renamed from: a, reason: collision with root package name */
    final n f١٩٠٣٩a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends j implements l {
        private static final long serialVersionUID = 7603343402964826922L;

        /* renamed from: c, reason: collision with root package name */
        nd.c f١٩٠٤٠c;

        a(g0 g0Var) {
            super(g0Var);
        }

        @Override // ud.j, nd.c
        public void dispose() {
            super.dispose();
            this.f١٩٠٤٠c.dispose();
        }

        @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            b();
        }

        @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            d(th);
        }

        @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٠٤٠c, cVar)) {
                this.f١٩٠٤٠c = cVar;
                this.f١٨٢٩٩a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            c(obj);
        }
    }

    public c(n nVar) {
        this.f١٩٠٣٩a = nVar;
    }

    public static l d(g0 g0Var) {
        return new a(g0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        this.f١٩٠٣٩a.a(d(g0Var));
    }
}
