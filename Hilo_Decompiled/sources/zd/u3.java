package zd;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class u3 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final long f٢٠٥٧٢b;

    /* renamed from: c, reason: collision with root package name */
    final long f٢٠٥٧٣c;

    /* renamed from: d, reason: collision with root package name */
    final TimeUnit f٢٠٥٧٤d;

    /* renamed from: e, reason: collision with root package name */
    final io.reactivex.rxjava3.core.h0 f٢٠٥٧٥e;

    /* renamed from: f, reason: collision with root package name */
    final int f٢٠٥٧٦f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f٢٠٥٧٧g;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicBoolean implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = -5677354903406201275L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٥٧٨a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٥٧٩b;

        /* renamed from: c, reason: collision with root package name */
        final long f٢٠٥٨٠c;

        /* renamed from: d, reason: collision with root package name */
        final TimeUnit f٢٠٥٨١d;

        /* renamed from: e, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٥٨٢e;

        /* renamed from: f, reason: collision with root package name */
        final be.c f٢٠٥٨٣f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f٢٠٥٨٤g;

        /* renamed from: h, reason: collision with root package name */
        nd.c f٢٠٥٨٥h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f٢٠٥٨٦i;

        /* renamed from: j, reason: collision with root package name */
        Throwable f٢٠٥٨٧j;

        a(io.reactivex.rxjava3.core.g0 g0Var, long j10, long j11, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10, boolean z10) {
            this.f٢٠٥٧٨a = g0Var;
            this.f٢٠٥٧٩b = j10;
            this.f٢٠٥٨٠c = j11;
            this.f٢٠٥٨١d = timeUnit;
            this.f٢٠٥٨٢e = h0Var;
            this.f٢٠٥٨٣f = new be.c(i10);
            this.f٢٠٥٨٤g = z10;
        }

        void a() {
            Throwable th;
            if (!compareAndSet(false, true)) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٥٧٨a;
            be.c cVar = this.f٢٠٥٨٣f;
            boolean z10 = this.f٢٠٥٨٤g;
            long now = this.f٢٠٥٨٢e.now(this.f٢٠٥٨١d) - this.f٢٠٥٨٠c;
            while (!this.f٢٠٥٨٦i) {
                if (!z10 && (th = this.f٢٠٥٨٧j) != null) {
                    cVar.clear();
                    g0Var.onError(th);
                    return;
                }
                Object poll = cVar.poll();
                if (poll == null) {
                    Throwable th2 = this.f٢٠٥٨٧j;
                    if (th2 != null) {
                        g0Var.onError(th2);
                        return;
                    } else {
                        g0Var.onComplete();
                        return;
                    }
                }
                Object poll2 = cVar.poll();
                if (((Long) poll).longValue() >= now) {
                    g0Var.onNext(poll2);
                }
            }
            cVar.clear();
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٥٨٦i) {
                this.f٢٠٥٨٦i = true;
                this.f٢٠٥٨٥h.dispose();
                if (compareAndSet(false, true)) {
                    this.f٢٠٥٨٣f.clear();
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٥٨٦i;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٥٨٧j = th;
            a();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            boolean z10;
            be.c cVar = this.f٢٠٥٨٣f;
            long now = this.f٢٠٥٨٢e.now(this.f٢٠٥٨١d);
            long j10 = this.f٢٠٥٨٠c;
            long j11 = this.f٢٠٥٧٩b;
            if (j11 == LongCompanionObject.MAX_VALUE) {
                z10 = true;
            } else {
                z10 = false;
            }
            cVar.m(Long.valueOf(now), obj);
            while (!cVar.isEmpty()) {
                if (((Long) cVar.n()).longValue() <= now - j10 || (!z10 && (cVar.p() >> 1) > j11)) {
                    cVar.poll();
                    cVar.poll();
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.i(this.f٢٠٥٨٥h, cVar)) {
                this.f٢٠٥٨٥h = cVar;
                this.f٢٠٥٧٨a.onSubscribe(this);
            }
        }
    }

    public u3(io.reactivex.rxjava3.core.e0 e0Var, long j10, long j11, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10, boolean z10) {
        super(e0Var);
        this.f٢٠٥٧٢b = j10;
        this.f٢٠٥٧٣c = j11;
        this.f٢٠٥٧٤d = timeUnit;
        this.f٢٠٥٧٥e = h0Var;
        this.f٢٠٥٧٦f = i10;
        this.f٢٠٥٧٧g = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f١٩٥٣٢a.subscribe(new a(g0Var, this.f٢٠٥٧٢b, this.f٢٠٥٧٣c, this.f٢٠٥٧٤d, this.f٢٠٥٧٥e, this.f٢٠٥٧٦f, this.f٢٠٥٧٧g));
    }
}
