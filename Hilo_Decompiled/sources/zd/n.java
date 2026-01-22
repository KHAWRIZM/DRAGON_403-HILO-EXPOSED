package zd;

import java.util.Collection;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class n extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠١٤٠b;

    /* renamed from: c, reason: collision with root package name */
    final pd.r f٢٠١٤١c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends he.c {

        /* renamed from: b, reason: collision with root package name */
        final b f٢٠١٤٢b;

        a(b bVar) {
            this.f٢٠١٤٢b = bVar;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠١٤٢b.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠١٤٢b.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠١٤٢b.j();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends ud.r implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: g, reason: collision with root package name */
        final pd.r f٢٠١٤٣g;

        /* renamed from: h, reason: collision with root package name */
        final io.reactivex.rxjava3.core.e0 f٢٠١٤٤h;

        /* renamed from: i, reason: collision with root package name */
        nd.c f٢٠١٤٥i;

        /* renamed from: j, reason: collision with root package name */
        nd.c f٢٠١٤٦j;

        /* renamed from: k, reason: collision with root package name */
        Collection f٢٠١٤٧k;

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.r rVar, io.reactivex.rxjava3.core.e0 e0Var) {
            super(g0Var, new be.a());
            this.f٢٠١٤٣g = rVar;
            this.f٢٠١٤٤h = e0Var;
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٨٣٢٣d) {
                this.f١٨٣٢٣d = true;
                this.f٢٠١٤٦j.dispose();
                this.f٢٠١٤٥i.dispose();
                if (a()) {
                    this.f١٨٣٢٢c.clear();
                }
            }
        }

        @Override // ud.r, fe.n
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void e(io.reactivex.rxjava3.core.g0 g0Var, Collection collection) {
            this.f١٨٣٢١b.onNext(collection);
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٨٣٢٣d;
        }

        void j() {
            try {
                Object obj = this.f٢٠١٤٣g.get();
                Objects.requireNonNull(obj, "The buffer supplied is null");
                Collection collection = (Collection) obj;
                synchronized (this) {
                    try {
                        Collection collection2 = this.f٢٠١٤٧k;
                        if (collection2 == null) {
                            return;
                        }
                        this.f٢٠١٤٧k = collection;
                        b(collection2, false, this);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                od.b.b(th2);
                dispose();
                this.f١٨٣٢١b.onError(th2);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            synchronized (this) {
                try {
                    Collection collection = this.f٢٠١٤٧k;
                    if (collection == null) {
                        return;
                    }
                    this.f٢٠١٤٧k = null;
                    this.f١٨٣٢٢c.offer(collection);
                    this.f١٨٣٢٤e = true;
                    if (a()) {
                        fe.q.c(this.f١٨٣٢٢c, this.f١٨٣٢١b, false, this, this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            dispose();
            this.f١٨٣٢١b.onError(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            synchronized (this) {
                try {
                    Collection collection = this.f٢٠١٤٧k;
                    if (collection == null) {
                        return;
                    }
                    collection.add(obj);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠١٤٥i, cVar)) {
                this.f٢٠١٤٥i = cVar;
                try {
                    Object obj = this.f٢٠١٤٣g.get();
                    Objects.requireNonNull(obj, "The buffer supplied is null");
                    this.f٢٠١٤٧k = (Collection) obj;
                    a aVar = new a(this);
                    this.f٢٠١٤٦j = aVar;
                    this.f١٨٣٢١b.onSubscribe(this);
                    if (!this.f١٨٣٢٣d) {
                        this.f٢٠١٤٤h.subscribe(aVar);
                    }
                } catch (Throwable th) {
                    od.b.b(th);
                    this.f١٨٣٢٣d = true;
                    cVar.dispose();
                    qd.d.f(th, this.f١٨٣٢١b);
                }
            }
        }
    }

    public n(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, pd.r rVar) {
        super(e0Var);
        this.f٢٠١٤٠b = e0Var2;
        this.f٢٠١٤١c = rVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new b(new he.e(g0Var), this.f٢٠١٤١c, this.f٢٠١٤٠b));
    }
}
