package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.g f٢٠٠٠١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.a {

        /* renamed from: f, reason: collision with root package name */
        final pd.g f٢٠٠٠٢f;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.g gVar) {
            super(g0Var);
            this.f٢٠٠٠٢f = gVar;
        }

        @Override // sd.f
        public int a(int i10) {
            return e(i10);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f١٨٢٨٢a.onNext(obj);
            if (this.f١٨٢٨٦e == 0) {
                try {
                    this.f٢٠٠٠٢f.accept(obj);
                } catch (Throwable th) {
                    d(th);
                }
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f١٨٢٨٤c.poll();
            if (poll != null) {
                this.f٢٠٠٠٢f.accept(poll);
            }
            return poll;
        }
    }

    public l0(io.reactivex.rxjava3.core.e0 e0Var, pd.g gVar) {
        super(e0Var);
        this.f٢٠٠٠١b = gVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٠٠١b));
    }
}
