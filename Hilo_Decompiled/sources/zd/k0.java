package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٩٤٠b;

    /* renamed from: c, reason: collision with root package name */
    final pd.d f١٩٩٤١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.a {

        /* renamed from: f, reason: collision with root package name */
        final pd.o f١٩٩٤٢f;

        /* renamed from: g, reason: collision with root package name */
        final pd.d f١٩٩٤٣g;

        /* renamed from: h, reason: collision with root package name */
        Object f١٩٩٤٤h;

        /* renamed from: i, reason: collision with root package name */
        boolean f١٩٩٤٥i;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, pd.d dVar) {
            super(g0Var);
            this.f١٩٩٤٢f = oVar;
            this.f١٩٩٤٣g = dVar;
        }

        @Override // sd.f
        public int a(int i10) {
            return e(i10);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٨٢٨٥d) {
                return;
            }
            if (this.f١٨٢٨٦e != 0) {
                this.f١٨٢٨٢a.onNext(obj);
                return;
            }
            try {
                Object apply = this.f١٩٩٤٢f.apply(obj);
                if (this.f١٩٩٤٥i) {
                    boolean a10 = this.f١٩٩٤٣g.a(this.f١٩٩٤٤h, apply);
                    this.f١٩٩٤٤h = apply;
                    if (a10) {
                        return;
                    }
                } else {
                    this.f١٩٩٤٥i = true;
                    this.f١٩٩٤٤h = apply;
                }
                this.f١٨٢٨٢a.onNext(obj);
            } catch (Throwable th) {
                d(th);
            }
        }

        @Override // sd.j
        public Object poll() {
            while (true) {
                Object poll = this.f١٨٢٨٤c.poll();
                if (poll == null) {
                    return null;
                }
                Object apply = this.f١٩٩٤٢f.apply(poll);
                if (!this.f١٩٩٤٥i) {
                    this.f١٩٩٤٥i = true;
                    this.f١٩٩٤٤h = apply;
                    return poll;
                }
                if (!this.f١٩٩٤٣g.a(this.f١٩٩٤٤h, apply)) {
                    this.f١٩٩٤٤h = apply;
                    return poll;
                }
                this.f١٩٩٤٤h = apply;
            }
        }
    }

    public k0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, pd.d dVar) {
        super(e0Var);
        this.f١٩٩٤٠b = oVar;
        this.f١٩٩٤١c = dVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٩٤٠b, this.f١٩٩٤١c));
    }
}
