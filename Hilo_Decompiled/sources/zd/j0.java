package zd;

import java.util.Collection;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٩١٢b;

    /* renamed from: c, reason: collision with root package name */
    final pd.r f١٩٩١٣c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.a {

        /* renamed from: f, reason: collision with root package name */
        final Collection f١٩٩١٤f;

        /* renamed from: g, reason: collision with root package name */
        final pd.o f١٩٩١٥g;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, Collection collection) {
            super(g0Var);
            this.f١٩٩١٥g = oVar;
            this.f١٩٩١٤f = collection;
        }

        @Override // sd.f
        public int a(int i10) {
            return e(i10);
        }

        @Override // ud.a, sd.j
        public void clear() {
            this.f١٩٩١٤f.clear();
            super.clear();
        }

        @Override // ud.a, io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f١٨٢٨٥d) {
                this.f١٨٢٨٥d = true;
                this.f١٩٩١٤f.clear();
                this.f١٨٢٨٢a.onComplete();
            }
        }

        @Override // ud.a, io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٨٢٨٥d) {
                ie.a.s(th);
                return;
            }
            this.f١٨٢٨٥d = true;
            this.f١٩٩١٤f.clear();
            this.f١٨٢٨٢a.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٨٢٨٥d) {
                return;
            }
            if (this.f١٨٢٨٦e == 0) {
                try {
                    Object apply = this.f١٩٩١٥g.apply(obj);
                    Objects.requireNonNull(apply, "The keySelector returned a null key");
                    if (this.f١٩٩١٤f.add(apply)) {
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
            Collection collection;
            Object apply;
            do {
                poll = this.f١٨٢٨٤c.poll();
                if (poll == null) {
                    break;
                }
                collection = this.f١٩٩١٤f;
                apply = this.f١٩٩١٥g.apply(poll);
                Objects.requireNonNull(apply, "The keySelector returned a null key");
            } while (!collection.add(apply));
            return poll;
        }
    }

    public j0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, pd.r rVar) {
        super(e0Var);
        this.f١٩٩١٢b = oVar;
        this.f١٩٩١٣c = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        try {
            this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٩١٢b, (Collection) fe.j.c(this.f١٩٩١٣c.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            od.b.b(th);
            qd.d.f(th, g0Var);
        }
    }
}
