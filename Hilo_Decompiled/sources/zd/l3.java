package zd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class l3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٠١٨b;

    /* renamed from: c, reason: collision with root package name */
    final TimeUnit f٢٠٠١٩c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٠٢٠d;

    /* renamed from: e, reason: collision with root package name */
    final int f٢٠٠٢١e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f٢٠٠٢٢f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٠٢٣a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٠٢٤b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f٢٠٠٢٥c;

        /* renamed from: d, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٠٢٦d;

        /* renamed from: e, reason: collision with root package name */
        final be.c f٢٠٠٢٧e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f٢٠٠٢٨f;

        /* renamed from: g, reason: collision with root package name */
        nd.c f٢٠٠٢٩g;

        /* renamed from: h, reason: collision with root package name */
        volatile boolean f٢٠٠٣٠h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٠٣١i;

        /* renamed from: j, reason: collision with root package name */
        Throwable f٢٠٠٣٢j;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10, boolean z10) {
            this.f٢٠٠٢٣a = g0Var;
            this.f٢٠٠٢٤b = j10;
            this.f٢٠٠٢٥c = timeUnit;
            this.f٢٠٠٢٦d = h0Var;
            this.f٢٠٠٢٧e = new be.c(i10);
            this.f٢٠٠٢٨f = z10;
        }

        void a() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٠٢٣a;
            be.c cVar = this.f٢٠٠٢٧e;
            boolean z11 = this.f٢٠٠٢٨f;
            TimeUnit timeUnit = this.f٢٠٠٢٥c;
            io.reactivex.rxjava3.core.h0 h0Var = this.f٢٠٠٢٦d;
            long j10 = this.f٢٠٠٢٤b;
            int i10 = 1;
            while (!this.f٢٠٠٣٠h) {
                boolean z12 = this.f٢٠٠٣١i;
                Long l10 = (Long) cVar.n();
                if (l10 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                long now = h0Var.now(timeUnit);
                if (!z10 && l10.longValue() > now - j10) {
                    z10 = true;
                }
                if (z12) {
                    if (z11) {
                        if (z10) {
                            Throwable th = this.f٢٠٠٣٢j;
                            if (th != null) {
                                g0Var.onError(th);
                                return;
                            } else {
                                g0Var.onComplete();
                                return;
                            }
                        }
                    } else {
                        Throwable th2 = this.f٢٠٠٣٢j;
                        if (th2 != null) {
                            this.f٢٠٠٢٧e.clear();
                            g0Var.onError(th2);
                            return;
                        } else if (z10) {
                            g0Var.onComplete();
                            return;
                        }
                    }
                }
                if (z10) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    cVar.poll();
                    g0Var.onNext(cVar.poll());
                }
            }
            this.f٢٠٠٢٧e.clear();
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٠٣٠h) {
                this.f٢٠٠٣٠h = true;
                this.f٢٠٠٢٩g.dispose();
                if (getAndIncrement() == 0) {
                    this.f٢٠٠٢٧e.clear();
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٠٣٠h;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٠٣١i = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٠٣٢j = th;
            this.f٢٠٠٣١i = true;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٠٢٧e.m(Long.valueOf(this.f٢٠٠٢٦d.now(this.f٢٠٠٢٥c)), obj);
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٠٢٩g, cVar)) {
                this.f٢٠٠٢٩g = cVar;
                this.f٢٠٠٢٣a.onSubscribe(this);
            }
        }
    }

    public l3(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10, boolean z10) {
        super(e0Var);
        this.f٢٠٠١٨b = j10;
        this.f٢٠٠١٩c = timeUnit;
        this.f٢٠٠٢٠d = h0Var;
        this.f٢٠٠٢١e = i10;
        this.f٢٠٠٢٢f = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٠١٨b, this.f٢٠٠١٩c, this.f٢٠٠٢٠d, this.f٢٠٠٢١e, this.f٢٠٠٢٢f));
    }
}
