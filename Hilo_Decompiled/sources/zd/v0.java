package zd;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class v0 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final pd.o f٢٠٦٢٠b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f٢٠٦٢١c;

    /* renamed from: d, reason: collision with root package name */
    final int f٢٠٦٢٢d;

    /* renamed from: e, reason: collision with root package name */
    final int f٢٠٦٢٣e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -4606175640614850599L;

        /* renamed from: a, reason: collision with root package name */
        final long f٢٠٦٢٤a;

        /* renamed from: b, reason: collision with root package name */
        final b f٢٠٦٢٥b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f٢٠٦٢٦c;

        /* renamed from: d, reason: collision with root package name */
        volatile sd.j f٢٠٦٢٧d;

        /* renamed from: e, reason: collision with root package name */
        int f٢٠٦٢٨e;

        a(b bVar, long j10) {
            this.f٢٠٦٢٤a = j10;
            this.f٢٠٦٢٥b = bVar;
        }

        public void a() {
            qd.c.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٦٢٦c = true;
            this.f٢٠٦٢٥b.d();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٦٢٥b.f٢٠٦٣٨h.c(th)) {
                b bVar = this.f٢٠٦٢٥b;
                if (!bVar.f٢٠٦٣٣c) {
                    bVar.c();
                }
                this.f٢٠٦٢٦c = true;
                this.f٢٠٦٢٥b.d();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٦٢٨e == 0) {
                this.f٢٠٦٢٥b.i(obj, this);
            } else {
                this.f٢٠٦٢٥b.d();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar) && (cVar instanceof sd.e)) {
                sd.e eVar = (sd.e) cVar;
                int a10 = eVar.a(7);
                if (a10 == 1) {
                    this.f٢٠٦٢٨e = a10;
                    this.f٢٠٦٢٧d = eVar;
                    this.f٢٠٦٢٦c = true;
                    this.f٢٠٦٢٥b.d();
                    return;
                }
                if (a10 == 2) {
                    this.f٢٠٦٢٨e = a10;
                    this.f٢٠٦٢٧d = eVar;
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements nd.c, io.reactivex.rxjava3.core.g0 {

        /* renamed from: p, reason: collision with root package name */
        static final a[] f٢٠٦٢٩p = new a[0];

        /* renamed from: q, reason: collision with root package name */
        static final a[] f٢٠٦٣٠q = new a[0];
        private static final long serialVersionUID = -2117620485640801370L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٦٣١a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٦٣٢b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f٢٠٦٣٣c;

        /* renamed from: d, reason: collision with root package name */
        final int f٢٠٦٣٤d;

        /* renamed from: e, reason: collision with root package name */
        final int f٢٠٦٣٥e;

        /* renamed from: f, reason: collision with root package name */
        volatile sd.i f٢٠٦٣٦f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٦٣٧g;

        /* renamed from: h, reason: collision with root package name */
        final fe.c f٢٠٦٣٨h = new fe.c();

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٦٣٩i;

        /* renamed from: j, reason: collision with root package name */
        final AtomicReference f٢٠٦٤٠j;

        /* renamed from: k, reason: collision with root package name */
        nd.c f٢٠٦٤١k;

        /* renamed from: l, reason: collision with root package name */
        long f٢٠٦٤٢l;

        /* renamed from: m, reason: collision with root package name */
        int f٢٠٦٤٣m;

        /* renamed from: n, reason: collision with root package name */
        Queue f٢٠٦٤٤n;

        /* renamed from: o, reason: collision with root package name */
        int f٢٠٦٤٥o;

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, boolean z10, int i10, int i11) {
            this.f٢٠٦٣١a = g0Var;
            this.f٢٠٦٣٢b = oVar;
            this.f٢٠٦٣٣c = z10;
            this.f٢٠٦٣٤d = i10;
            this.f٢٠٦٣٥e = i11;
            if (i10 != Integer.MAX_VALUE) {
                this.f٢٠٦٤٤n = new ArrayDeque(i10);
            }
            this.f٢٠٦٤٠j = new AtomicReference(f٢٠٦٢٩p);
        }

        boolean a(a aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f٢٠٦٤٠j.get();
                if (aVarArr == f٢٠٦٣٠q) {
                    aVar.a();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!androidx.lifecycle.a.a(this.f٢٠٦٤٠j, aVarArr, aVarArr2));
            return true;
        }

        boolean b() {
            if (this.f٢٠٦٣٩i) {
                return true;
            }
            Throwable th = (Throwable) this.f٢٠٦٣٨h.get();
            if (!this.f٢٠٦٣٣c && th != null) {
                c();
                this.f٢٠٦٣٨h.f(this.f٢٠٦٣١a);
                return true;
            }
            return false;
        }

        boolean c() {
            this.f٢٠٦٤١k.dispose();
            AtomicReference atomicReference = this.f٢٠٦٤٠j;
            a[] aVarArr = f٢٠٦٣٠q;
            a[] aVarArr2 = (a[]) atomicReference.getAndSet(aVarArr);
            if (aVarArr2 == aVarArr) {
                return false;
            }
            for (a aVar : aVarArr2) {
                aVar.a();
            }
            return true;
        }

        void d() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٦٣٩i = true;
            if (c()) {
                this.f٢٠٦٣٨h.d();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        
            if (r10 != null) goto L٧٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00ad, code lost:
        
            r10 = r9.f٢٠٦٢٦c;
            r11 = r9.f٢٠٦٢٧d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
        
            if (r10 == false) goto L٦٥;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x00b3, code lost:
        
            if (r11 == null) goto L٦٤;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
        
            if (r11.isEmpty() == false) goto L٦٥;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00bb, code lost:
        
            f(r9);
            r4 = r4 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00c0, code lost:
        
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x00c2, code lost:
        
            if (r5 != r8) goto L١٠٤;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00c4, code lost:
        
            r5 = 0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00c5, code lost:
        
            r6 = r6 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x007f, code lost:
        
            r11 = r10.poll();
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0083, code lost:
        
            if (r11 != null) goto L٤٩;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0086, code lost:
        
            r0.onNext(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x008d, code lost:
        
            if (b() == false) goto L١٠٦;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x008f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x0090, code lost:
        
            r10 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0091, code lost:
        
            od.b.b(r10);
            r9.a();
            r12.f٢٠٦٣٨h.c(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00a0, code lost:
        
            if (b() != false) goto L٨٦;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x00a3, code lost:
        
            f(r9);
            r4 = r4 + 1;
            r5 = r5 + 1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00aa, code lost:
        
            if (r5 != r8) goto L١٠٣;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void e() {
            int i10;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٦٣١a;
            int i11 = 1;
            while (!b()) {
                sd.i iVar = this.f٢٠٦٣٦f;
                int i12 = 0;
                if (iVar != null) {
                    while (!b()) {
                        Object poll = iVar.poll();
                        if (poll != null) {
                            g0Var.onNext(poll);
                            i12++;
                        }
                    }
                    return;
                }
                if (i12 != 0) {
                    if (this.f٢٠٦٣٤d != Integer.MAX_VALUE) {
                        h(i12);
                    }
                } else {
                    boolean z10 = this.f٢٠٦٣٧g;
                    sd.i iVar2 = this.f٢٠٦٣٦f;
                    a[] aVarArr = (a[]) this.f٢٠٦٤٠j.get();
                    int length = aVarArr.length;
                    if (this.f٢٠٦٣٤d != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i10 = this.f٢٠٦٤٤n.size();
                        }
                    } else {
                        i10 = 0;
                    }
                    if (z10 && ((iVar2 == null || iVar2.isEmpty()) && length == 0 && i10 == 0)) {
                        this.f٢٠٦٣٨h.f(this.f٢٠٦٣١a);
                        return;
                    }
                    if (length != 0) {
                        int min = Math.min(length - 1, this.f٢٠٦٤٣m);
                        int i13 = 0;
                        while (i13 < length) {
                            if (b()) {
                                return;
                            }
                            a aVar = aVarArr[min];
                            sd.j jVar = aVar.f٢٠٦٢٧d;
                        }
                        this.f٢٠٦٤٣m = min;
                    }
                    if (i12 != 0) {
                        if (this.f٢٠٦٣٤d != Integer.MAX_VALUE) {
                            h(i12);
                        }
                    } else {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    }
                }
            }
        }

        void f(a aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f٢٠٦٤٠j.get();
                int length = aVarArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        if (aVarArr[i10] == aVar) {
                            break;
                        } else {
                            i10++;
                        }
                    } else {
                        i10 = -1;
                        break;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f٢٠٦٢٩p;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                    System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!androidx.lifecycle.a.a(this.f٢٠٦٤٠j, aVarArr, aVarArr2));
        }

        void g(io.reactivex.rxjava3.core.e0 e0Var) {
            boolean z10;
            while (e0Var instanceof pd.r) {
                if (j((pd.r) e0Var) && this.f٢٠٦٣٤d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            e0Var = (io.reactivex.rxjava3.core.e0) this.f٢٠٦٤٤n.poll();
                            if (e0Var == null) {
                                z10 = true;
                                this.f٢٠٦٤٥o--;
                            } else {
                                z10 = false;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (z10) {
                        d();
                        return;
                    }
                } else {
                    return;
                }
            }
            long j10 = this.f٢٠٦٤٢l;
            this.f٢٠٦٤٢l = 1 + j10;
            a aVar = new a(this, j10);
            if (a(aVar)) {
                e0Var.subscribe(aVar);
            }
        }

        void h(int i10) {
            while (true) {
                int i11 = i10 - 1;
                if (i10 != 0) {
                    synchronized (this) {
                        try {
                            io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) this.f٢٠٦٤٤n.poll();
                            if (e0Var == null) {
                                this.f٢٠٦٤٥o--;
                            } else {
                                g(e0Var);
                            }
                        } finally {
                        }
                    }
                    i10 = i11;
                } else {
                    return;
                }
            }
        }

        void i(Object obj, a aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f٢٠٦٣١a.onNext(obj);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                sd.j jVar = aVar.f٢٠٦٢٧d;
                if (jVar == null) {
                    jVar = new be.c(this.f٢٠٦٣٥e);
                    aVar.f٢٠٦٢٧d = jVar;
                }
                jVar.offer(obj);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            e();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٦٣٩i;
        }

        boolean j(pd.r rVar) {
            try {
                Object obj = rVar.get();
                if (obj == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f٢٠٦٣١a.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    sd.i iVar = this.f٢٠٦٣٦f;
                    if (iVar == null) {
                        if (this.f٢٠٦٣٤d == Integer.MAX_VALUE) {
                            iVar = new be.c(this.f٢٠٦٣٥e);
                        } else {
                            iVar = new be.b(this.f٢٠٦٣٤d);
                        }
                        this.f٢٠٦٣٦f = iVar;
                    }
                    iVar.offer(obj);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                e();
                return true;
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٦٣٨h.c(th);
                d();
                return true;
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f٢٠٦٣٧g) {
                return;
            }
            this.f٢٠٦٣٧g = true;
            d();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٦٣٧g) {
                ie.a.s(th);
            } else if (this.f٢٠٦٣٨h.c(th)) {
                this.f٢٠٦٣٧g = true;
                d();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٦٣٧g) {
                return;
            }
            try {
                Object apply = this.f٢٠٦٣٢b.apply(obj);
                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                if (this.f٢٠٦٣٤d != Integer.MAX_VALUE) {
                    synchronized (this) {
                        try {
                            int i10 = this.f٢٠٦٤٥o;
                            if (i10 == this.f٢٠٦٣٤d) {
                                this.f٢٠٦٤٤n.offer(e0Var);
                                return;
                            }
                            this.f٢٠٦٤٥o = i10 + 1;
                        } finally {
                        }
                    }
                }
                g(e0Var);
            } catch (Throwable th) {
                od.b.b(th);
                this.f٢٠٦٤١k.dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٦٤١k, cVar)) {
                this.f٢٠٦٤١k = cVar;
                this.f٢٠٦٣١a.onSubscribe(this);
            }
        }
    }

    public v0(io.reactivex.rxjava3.core.e0 e0Var, pd.o oVar, boolean z10, int i10, int i11) {
        super(e0Var);
        this.f٢٠٦٢٠b = oVar;
        this.f٢٠٦٢١c = z10;
        this.f٢٠٦٢٢d = i10;
        this.f٢٠٦٢٣e = i11;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        if (b3.b(this.f١٩٥٣٢a, g0Var, this.f٢٠٦٢٠b)) {
            return;
        }
        this.f١٩٥٣٢a.subscribe(new b(g0Var, this.f٢٠٦٢٠b, this.f٢٠٦٢١c, this.f٢٠٦٢٢d, this.f٢٠٦٢٣e));
    }
}
