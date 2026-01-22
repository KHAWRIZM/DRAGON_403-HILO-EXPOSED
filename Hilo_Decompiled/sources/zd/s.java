package zd;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class s extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0[] f٢٠٤٤١a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable f٢٠٤٤٢b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f٢٠٤٤٣c;

    /* renamed from: d, reason: collision with root package name */
    final int f٢٠٤٤٤d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f٢٠٤٤٥e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -4823716997131257941L;

        /* renamed from: a, reason: collision with root package name */
        final b f٢٠٤٤٦a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٠٤٤٧b;

        a(b bVar, int i10) {
            this.f٢٠٤٤٦a = bVar;
            this.f٢٠٤٤٧b = i10;
        }

        public void a() {
            qd.c.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٤٤٦a.d(this.f٢٠٤٤٧b);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٤٤٦a.e(this.f٢٠٤٤٧b, th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٤٤٦a.f(this.f٢٠٤٤٧b, obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements nd.c {
        private static final long serialVersionUID = 8567835998786448817L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٤٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٤٤٩b;

        /* renamed from: c, reason: collision with root package name */
        final a[] f٢٠٤٥٠c;

        /* renamed from: d, reason: collision with root package name */
        Object[] f٢٠٤٥١d;

        /* renamed from: e, reason: collision with root package name */
        final be.c f٢٠٤٥٢e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f٢٠٤٥٣f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٤٥٤g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٤٥٥h;

        /* renamed from: i, reason: collision with root package name */
        final fe.c f٢٠٤٥٦i = new fe.c();

        /* renamed from: j, reason: collision with root package name */
        int f٢٠٤٥٧j;

        /* renamed from: k, reason: collision with root package name */
        int f٢٠٤٥٨k;

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, int i11, boolean z10) {
            this.f٢٠٤٤٨a = g0Var;
            this.f٢٠٤٤٩b = oVar;
            this.f٢٠٤٥٣f = z10;
            this.f٢٠٤٥١d = new Object[i10];
            a[] aVarArr = new a[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                aVarArr[i12] = new a(this, i12);
            }
            this.f٢٠٤٥٠c = aVarArr;
            this.f٢٠٤٥٢e = new be.c(i11);
        }

        void a() {
            for (a aVar : this.f٢٠٤٥٠c) {
                aVar.a();
            }
        }

        void b(be.c cVar) {
            synchronized (this) {
                this.f٢٠٤٥١d = null;
            }
            cVar.clear();
        }

        void c() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            be.c cVar = this.f٢٠٤٥٢e;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٤٤٨a;
            boolean z11 = this.f٢٠٤٥٣f;
            int i10 = 1;
            while (!this.f٢٠٤٥٤g) {
                if (!z11 && this.f٢٠٤٥٦i.get() != null) {
                    a();
                    b(cVar);
                    this.f٢٠٤٥٦i.f(g0Var);
                    return;
                }
                boolean z12 = this.f٢٠٤٥٥h;
                Object[] objArr = (Object[]) cVar.poll();
                if (objArr == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z12 && z10) {
                    b(cVar);
                    this.f٢٠٤٥٦i.f(g0Var);
                    return;
                }
                if (z10) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    try {
                        Object apply = this.f٢٠٤٤٩b.apply(objArr);
                        Objects.requireNonNull(apply, "The combiner returned a null value");
                        g0Var.onNext(apply);
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f٢٠٤٥٦i.c(th);
                        a();
                        b(cVar);
                        this.f٢٠٤٥٦i.f(g0Var);
                        return;
                    }
                }
            }
            b(cVar);
            this.f٢٠٤٥٦i.d();
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
        
            if (r2 == r0.length) goto L١٦;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void d(int i10) {
            boolean z10;
            synchronized (this) {
                try {
                    Object[] objArr = this.f٢٠٤٥١d;
                    if (objArr == null) {
                        return;
                    }
                    if (objArr[i10] == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        int i11 = this.f٢٠٤٥٨k + 1;
                        this.f٢٠٤٥٨k = i11;
                    }
                    this.f٢٠٤٥٥h = true;
                    if (z10) {
                        a();
                    }
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٤٥٤g) {
                this.f٢٠٤٥٤g = true;
                a();
                c();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        
            if (r1 == r4.length) goto L٢٠;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void e(int i10, Throwable th) {
            boolean z10;
            if (this.f٢٠٤٥٦i.c(th)) {
                boolean z11 = true;
                if (this.f٢٠٤٥٣f) {
                    synchronized (this) {
                        try {
                            Object[] objArr = this.f٢٠٤٥١d;
                            if (objArr == null) {
                                return;
                            }
                            if (objArr[i10] == null) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            if (!z10) {
                                int i11 = this.f٢٠٤٥٨k + 1;
                                this.f٢٠٤٥٨k = i11;
                            }
                            this.f٢٠٤٥٥h = true;
                            z11 = z10;
                        } finally {
                        }
                    }
                }
                if (z11) {
                    a();
                }
                c();
            }
        }

        void f(int i10, Object obj) {
            boolean z10;
            synchronized (this) {
                try {
                    Object[] objArr = this.f٢٠٤٥١d;
                    if (objArr == null) {
                        return;
                    }
                    Object obj2 = objArr[i10];
                    int i11 = this.f٢٠٤٥٧j;
                    if (obj2 == null) {
                        i11++;
                        this.f٢٠٤٥٧j = i11;
                    }
                    objArr[i10] = obj;
                    if (i11 == objArr.length) {
                        this.f٢٠٤٥٢e.offer(objArr.clone());
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void g(io.reactivex.rxjava3.core.e0[] e0VarArr) {
            a[] aVarArr = this.f٢٠٤٥٠c;
            int length = aVarArr.length;
            this.f٢٠٤٤٨a.onSubscribe(this);
            for (int i10 = 0; i10 < length && !this.f٢٠٤٥٥h && !this.f٢٠٤٥٤g; i10++) {
                e0VarArr[i10].subscribe(aVarArr[i10]);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٤٥٤g;
        }
    }

    public s(io.reactivex.rxjava3.core.e0[] e0VarArr, Iterable iterable, pd.o oVar, int i10, boolean z10) {
        this.f٢٠٤٤١a = e0VarArr;
        this.f٢٠٤٤٢b = iterable;
        this.f٢٠٤٤٣c = oVar;
        this.f٢٠٤٤٤d = i10;
        this.f٢٠٤٤٥e = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        int length;
        io.reactivex.rxjava3.core.e0[] e0VarArr = this.f٢٠٤٤١a;
        if (e0VarArr == null) {
            e0VarArr = new io.reactivex.rxjava3.core.e0[8];
            try {
                length = 0;
                for (io.reactivex.rxjava3.core.e0 e0Var : this.f٢٠٤٤٢b) {
                    if (length == e0VarArr.length) {
                        io.reactivex.rxjava3.core.e0[] e0VarArr2 = new io.reactivex.rxjava3.core.e0[(length >> 2) + length];
                        System.arraycopy(e0VarArr, 0, e0VarArr2, 0, length);
                        e0VarArr = e0VarArr2;
                    }
                    int i10 = length + 1;
                    Objects.requireNonNull(e0Var, "The Iterator returned a null ObservableSource");
                    e0VarArr[length] = e0Var;
                    length = i10;
                }
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
                return;
            }
        } else {
            length = e0VarArr.length;
        }
        int i11 = length;
        if (i11 == 0) {
            qd.d.d(g0Var);
        } else {
            new b(g0Var, this.f٢٠٤٤٣c, i11, this.f٢٠٤٤٤d, this.f٢٠٤٤٥e).g(e0VarArr);
        }
    }
}
