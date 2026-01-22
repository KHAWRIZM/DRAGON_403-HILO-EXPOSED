package zd;

import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f١٩٨٣٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٤٠a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f١٩٨٤١b;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٩٨٤٢c;

        /* renamed from: d, reason: collision with root package name */
        nd.c f١٩٨٤٣d;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar) {
            this.f١٩٨٤٠a = g0Var;
            this.f١٩٨٤١b = oVar;
        }

        @Override // nd.c
        public void dispose() {
            this.f١٩٨٤٣d.dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٤٣d.isDisposed();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٤٢c) {
                return;
            }
            this.f١٩٨٤٢c = true;
            this.f١٩٨٤٠a.onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٤٢c) {
                ie.a.s(th);
            } else {
                this.f١٩٨٤٢c = true;
                this.f١٩٨٤٠a.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٤٢c) {
                if (obj instanceof io.reactivex.rxjava3.core.o) {
                    io.reactivex.rxjava3.core.o oVar = (io.reactivex.rxjava3.core.o) obj;
                    if (oVar.g()) {
                        ie.a.s(oVar.d());
                        return;
                    }
                    return;
                }
                return;
            }
            try {
                Object apply = this.f١٩٨٤١b.apply(obj);
                Objects.requireNonNull(apply, "The selector returned a null Notification");
                io.reactivex.rxjava3.core.o oVar2 = (io.reactivex.rxjava3.core.o) apply;
                if (oVar2.g()) {
                    this.f١٩٨٤٣d.dispose();
                    onError(oVar2.d());
                } else if (oVar2.f()) {
                    this.f١٩٨٤٣d.dispose();
                    onComplete();
                } else {
                    this.f١٩٨٤٠a.onNext(oVar2.e());
                }
            } catch (Throwable th) {
                od.b.b(th);
                this.f١٩٨٤٣d.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨٤٣d, cVar)) {
                this.f١٩٨٤٣d = cVar;
                this.f١٩٨٤٠a.onSubscribe(this);
            }
        }
    }

    public h0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar) {
        super(e0Var);
        this.f١٩٨٣٩b = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f١٩٨٣٩b));
    }
}
