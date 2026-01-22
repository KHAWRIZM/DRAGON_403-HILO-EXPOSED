package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class u0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.q f٢٠٥٣٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.a {

        /* renamed from: f, reason: collision with root package name */
        final pd.q f٢٠٥٤٠f;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.q qVar) {
            super(g0Var);
            this.f٢٠٥٤٠f = qVar;
        }

        @Override // sd.f
        public int a(int i10) {
            return e(i10);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٨٢٨٦e == 0) {
                try {
                    if (this.f٢٠٥٤٠f.test(obj)) {
                        this.f١٨٢٨٢a.onNext(obj);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    d(th);
                    return;
                }
            }
            this.f١٨٢٨٢a.onNext(null);
        }

        @Override // sd.j
        public Object poll() {
            Object poll;
            do {
                poll = this.f١٨٢٨٤c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f٢٠٥٤٠f.test(poll));
            return poll;
        }
    }

    public u0(io.reactivex.rxjava3.core.e0 e0Var, pd.q qVar) {
        super(e0Var);
        this.f٢٠٥٣٩b = qVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٥٣٩b));
    }
}
