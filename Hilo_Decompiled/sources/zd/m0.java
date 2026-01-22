package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class m0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.a f٢٠٠٥٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.b implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = 4109457741734051389L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٥٤a;

        /* renamed from: b, reason: collision with root package name */
        final pd.a f٢٠٠٥٥b;

        /* renamed from: c, reason: collision with root package name */
        nd.c f٢٠٠٥٦c;

        /* renamed from: d, reason: collision with root package name */
        sd.e f٢٠٠٥٧d;

        /* renamed from: e, reason: collision with root package name */
        boolean f٢٠٠٥٨e;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.a aVar) {
            this.f٢٠٠٥٤a = g0Var;
            this.f٢٠٠٥٥b = aVar;
        }

        @Override // sd.f
        public int a(int i10) {
            sd.e eVar = this.f٢٠٠٥٧d;
            boolean z10 = false;
            if (eVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int a10 = eVar.a(i10);
            if (a10 != 0) {
                if (a10 == 1) {
                    z10 = true;
                }
                this.f٢٠٠٥٨e = z10;
            }
            return a10;
        }

        void b() {
            if (compareAndSet(0, 1)) {
                try {
                    this.f٢٠٠٥٥b.run();
                } catch (Throwable th) {
                    od.b.b(th);
                    ie.a.s(th);
                }
            }
        }

        @Override // sd.j
        public void clear() {
            this.f٢٠٠٥٧d.clear();
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٠٥٦c.dispose();
            b();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٠٥٦c.isDisposed();
        }

        @Override // sd.j
        public boolean isEmpty() {
            return this.f٢٠٠٥٧d.isEmpty();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٠٥٤a.onComplete();
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٠٥٤a.onError(th);
            b();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٠٥٤a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٠٥٦c, cVar)) {
                this.f٢٠٠٥٦c = cVar;
                if (cVar instanceof sd.e) {
                    this.f٢٠٠٥٧d = (sd.e) cVar;
                }
                this.f٢٠٠٥٤a.onSubscribe(this);
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f٢٠٠٥٧d.poll();
            if (poll == null && this.f٢٠٠٥٨e) {
                b();
            }
            return poll;
        }
    }

    public m0(io.reactivex.rxjava3.core.e0 e0Var, pd.a aVar) {
        super(e0Var);
        this.f٢٠٠٥٣b = aVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٠٥٣b));
    }
}
