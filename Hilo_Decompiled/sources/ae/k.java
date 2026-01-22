package ae;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;
import io.reactivex.rxjava3.core.z;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k extends z {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٩٤a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends ud.j implements k0 {
        private static final long serialVersionUID = 3786543492451018833L;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٤٩٥c;

        a(g0 g0Var) {
            super(g0Var);
        }

        @Override // ud.j, nd.c
        public void dispose() {
            super.dispose();
            this.f٤٩٥c.dispose();
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            d(th);
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٤٩٥c, cVar)) {
                this.f٤٩٥c = cVar;
                this.f١٨٢٩٩a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            c(obj);
        }
    }

    public k(m0 m0Var) {
        this.f٤٩٤a = m0Var;
    }

    public static k0 d(g0 g0Var) {
        return new a(g0Var);
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(g0 g0Var) {
        this.f٤٩٤a.a(d(g0Var));
    }
}
