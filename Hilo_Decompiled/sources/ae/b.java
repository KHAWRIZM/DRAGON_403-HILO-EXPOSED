package ae;

import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.m0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends i0 {

    /* renamed from: a, reason: collision with root package name */
    final m0 f٤٦٢a;

    /* renamed from: b, reason: collision with root package name */
    final pd.a f٤٦٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements k0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final k0 f٤٦٤a;

        /* renamed from: b, reason: collision with root package name */
        final pd.a f٤٦٥b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٤٦٦c;

        a(k0 k0Var, pd.a aVar) {
            this.f٤٦٤a = k0Var;
            this.f٤٦٥b = aVar;
        }

        private void a() {
            try {
                this.f٤٦٥b.run();
            } catch (Throwable th) {
                od.b.b(th);
                ie.a.s(th);
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f٤٦٦c.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٤٦٦c.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٤٦٤a.onError(th);
            a();
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٤٦٦c, cVar)) {
                this.f٤٦٦c = cVar;
                this.f٤٦٤a.onSubscribe(this);
            }
        }

        @Override // io.reactivex.rxjava3.core.k0
        public void onSuccess(Object obj) {
            this.f٤٦٤a.onSuccess(obj);
            a();
        }
    }

    public b(m0 m0Var, pd.a aVar) {
        this.f٤٦٢a = m0Var;
        this.f٤٦٣b = aVar;
    }

    @Override // io.reactivex.rxjava3.core.i0
    protected void o(k0 k0Var) {
        this.f٤٦٢a.a(new a(k0Var, this.f٤٦٣b));
    }
}
