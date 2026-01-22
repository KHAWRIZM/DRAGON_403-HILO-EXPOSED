package zd;

import io.reactivex.rxjava3.core.h0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g2 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f١٩٨١١b;

    /* renamed from: c, reason: collision with root package name */
    final boolean f١٩٨١٢c;

    /* renamed from: d, reason: collision with root package name */
    final int f١٩٨١٣d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ud.b implements io.reactivex.rxjava3.core.g0, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨١٤a;

        /* renamed from: b, reason: collision with root package name */
        final h0.c f١٩٨١٥b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f١٩٨١٦c;

        /* renamed from: d, reason: collision with root package name */
        final int f١٩٨١٧d;

        /* renamed from: e, reason: collision with root package name */
        sd.j f١٩٨١٨e;

        /* renamed from: f, reason: collision with root package name */
        nd.c f١٩٨١٩f;

        /* renamed from: g, reason: collision with root package name */
        Throwable f١٩٨٢٠g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f١٩٨٢١h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f١٩٨٢٢i;

        /* renamed from: j, reason: collision with root package name */
        int f١٩٨٢٣j;

        /* renamed from: k, reason: collision with root package name */
        boolean f١٩٨٢٤k;

        a(io.reactivex.rxjava3.core.g0 g0Var, h0.c cVar, boolean z10, int i10) {
            this.f١٩٨١٤a = g0Var;
            this.f١٩٨١٥b = cVar;
            this.f١٩٨١٦c = z10;
            this.f١٩٨١٧d = i10;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 2) != 0) {
                this.f١٩٨٢٤k = true;
                return 2;
            }
            return 0;
        }

        boolean b(boolean z10, boolean z11, io.reactivex.rxjava3.core.g0 g0Var) {
            if (this.f١٩٨٢٢i) {
                this.f١٩٨١٨e.clear();
                return true;
            }
            if (z10) {
                Throwable th = this.f١٩٨٢٠g;
                if (this.f١٩٨١٦c) {
                    if (z11) {
                        this.f١٩٨٢٢i = true;
                        if (th != null) {
                            g0Var.onError(th);
                        } else {
                            g0Var.onComplete();
                        }
                        this.f١٩٨١٥b.dispose();
                        return true;
                    }
                    return false;
                }
                if (th != null) {
                    this.f١٩٨٢٢i = true;
                    this.f١٩٨١٨e.clear();
                    g0Var.onError(th);
                    this.f١٩٨١٥b.dispose();
                    return true;
                }
                if (z11) {
                    this.f١٩٨٢٢i = true;
                    g0Var.onComplete();
                    this.f١٩٨١٥b.dispose();
                    return true;
                }
                return false;
            }
            return false;
        }

        void c() {
            int i10 = 1;
            while (!this.f١٩٨٢٢i) {
                boolean z10 = this.f١٩٨٢١h;
                Throwable th = this.f١٩٨٢٠g;
                if (!this.f١٩٨١٦c && z10 && th != null) {
                    this.f١٩٨٢٢i = true;
                    this.f١٩٨١٤a.onError(this.f١٩٨٢٠g);
                    this.f١٩٨١٥b.dispose();
                    return;
                }
                this.f١٩٨١٤a.onNext(null);
                if (z10) {
                    this.f١٩٨٢٢i = true;
                    Throwable th2 = this.f١٩٨٢٠g;
                    if (th2 != null) {
                        this.f١٩٨١٤a.onError(th2);
                    } else {
                        this.f١٩٨١٤a.onComplete();
                    }
                    this.f١٩٨١٥b.dispose();
                    return;
                }
                i10 = addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }

        @Override // sd.j
        public void clear() {
            this.f١٩٨١٨e.clear();
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r3 != 0) goto L٢٧;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void d() {
            boolean z10;
            sd.j jVar = this.f١٩٨١٨e;
            io.reactivex.rxjava3.core.g0 g0Var = this.f١٩٨١٤a;
            int i10 = 1;
            while (!b(this.f١٩٨٢١h, jVar.isEmpty(), g0Var)) {
                while (true) {
                    boolean z11 = this.f١٩٨٢١h;
                    try {
                        Object poll = jVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (b(z11, z10, g0Var)) {
                            return;
                        }
                        if (z10) {
                            break;
                        } else {
                            g0Var.onNext(poll);
                        }
                    } catch (Throwable th) {
                        od.b.b(th);
                        this.f١٩٨٢٢i = true;
                        this.f١٩٨١٩f.dispose();
                        jVar.clear();
                        g0Var.onError(th);
                        this.f١٩٨١٥b.dispose();
                        return;
                    }
                }
            }
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f١٩٨٢٢i) {
                this.f١٩٨٢٢i = true;
                this.f١٩٨١٩f.dispose();
                this.f١٩٨١٥b.dispose();
                if (!this.f١٩٨٢٤k && getAndIncrement() == 0) {
                    this.f١٩٨١٨e.clear();
                }
            }
        }

        void e() {
            if (getAndIncrement() == 0) {
                this.f١٩٨١٥b.schedule(this);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f١٩٨٢٢i;
        }

        @Override // sd.j
        public boolean isEmpty() {
            return this.f١٩٨١٨e.isEmpty();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٢١h) {
                return;
            }
            this.f١٩٨٢١h = true;
            e();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٢١h) {
                ie.a.s(th);
                return;
            }
            this.f١٩٨٢٠g = th;
            this.f١٩٨٢١h = true;
            e();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٢١h) {
                return;
            }
            if (this.f١٩٨٢٣j != 2) {
                this.f١٩٨١٨e.offer(obj);
            }
            e();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f١٩٨١٩f, cVar)) {
                this.f١٩٨١٩f = cVar;
                if (cVar instanceof sd.e) {
                    sd.e eVar = (sd.e) cVar;
                    int a10 = eVar.a(7);
                    if (a10 == 1) {
                        this.f١٩٨٢٣j = a10;
                        this.f١٩٨١٨e = eVar;
                        this.f١٩٨٢١h = true;
                        this.f١٩٨١٤a.onSubscribe(this);
                        e();
                        return;
                    }
                    if (a10 == 2) {
                        this.f١٩٨٢٣j = a10;
                        this.f١٩٨١٨e = eVar;
                        this.f١٩٨١٤a.onSubscribe(this);
                        return;
                    }
                }
                this.f١٩٨١٨e = new be.c(this.f١٩٨١٧d);
                this.f١٩٨١٤a.onSubscribe(this);
            }
        }

        @Override // sd.j
        public Object poll() {
            return this.f١٩٨١٨e.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f١٩٨٢٤k) {
                c();
            } else {
                d();
            }
        }
    }

    public g2(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.h0 h0Var, boolean z10, int i10) {
        super(e0Var);
        this.f١٩٨١١b = h0Var;
        this.f١٩٨١٢c = z10;
        this.f١٩٨١٣d = i10;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        io.reactivex.rxjava3.core.h0 h0Var = this.f١٩٨١١b;
        if (h0Var instanceof ce.o) {
            this.f١٩٥٣٢a.subscribe(g0Var);
        } else {
            this.f١٩٥٣٢a.subscribe(new a(g0Var, h0Var.createWorker(), this.f١٩٨١٢c, this.f١٩٨١٣d));
        }
    }
}
