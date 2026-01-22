package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class z1 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٨٠٣b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.a {

        /* renamed from: f, reason: collision with root package name */
        final pd.o f٢٠٨٠٤f;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            super(g0Var);
            this.f٢٠٨٠٤f = oVar;
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
                this.f١٨٢٨٢a.onNext(null);
                return;
            }
            try {
                Object apply = this.f٢٠٨٠٤f.apply(obj);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.f١٨٢٨٢a.onNext(apply);
            } catch (Throwable th) {
                d(th);
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f١٨٢٨٤c.poll();
            if (poll != null) {
                Object apply = this.f٢٠٨٠٤f.apply(poll);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return apply;
            }
            return null;
        }
    }

    public z1(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f٢٠٨٠٣b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٨٠٣b));
    }
}
