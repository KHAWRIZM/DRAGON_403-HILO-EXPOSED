package zd;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g0 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٩٧a;

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٧٩٨b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class a implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final qd.f f١٩٧٩٩a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٠٠b;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٩٨٠١c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: zd.g0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public final class C٠٢٦٤a implements io.reactivex.rxjava3.core.g0 {
            C٠٢٦٤a() {
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
            public void onComplete() {
                a.this.f١٩٨٠٠b.onComplete();
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onError(Throwable th) {
                a.this.f١٩٨٠٠b.onError(th);
            }

            @Override // io.reactivex.rxjava3.core.g0
            public void onNext(Object obj) {
                a.this.f١٩٨٠٠b.onNext(obj);
            }

            @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
            public void onSubscribe(nd.c cVar) {
                a.this.f١٩٧٩٩a.b(cVar);
            }
        }

        a(qd.f fVar, io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٧٩٩a = fVar;
            this.f١٩٨٠٠b = g0Var;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٠١c) {
                return;
            }
            this.f١٩٨٠١c = true;
            g0.this.f١٩٧٩٧a.subscribe(new C٠٢٦٤a());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٠١c) {
                ie.a.s(th);
            } else {
                this.f١٩٨٠١c = true;
                this.f١٩٨٠٠b.onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            onComplete();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            this.f١٩٧٩٩a.b(cVar);
        }
    }

    public g0(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2) {
        this.f١٩٧٩٧a = e0Var;
        this.f١٩٧٩٨b = e0Var2;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        qd.f fVar = new qd.f();
        g0Var.onSubscribe(fVar);
        this.f١٩٧٩٨b.subscribe(new a(fVar, g0Var));
    }
}
