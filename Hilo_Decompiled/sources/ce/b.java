package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class b extends h0 {

    /* renamed from: c, reason: collision with root package name */
    static final C٠٠٧٣b f٦٠٢٥c;

    /* renamed from: d, reason: collision with root package name */
    static final h f٦٠٢٦d;

    /* renamed from: e, reason: collision with root package name */
    static final int f٦٠٢٧e = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx3.computation-threads", 0).intValue());

    /* renamed from: f, reason: collision with root package name */
    static final c f٦٠٢٨f;

    /* renamed from: a, reason: collision with root package name */
    final ThreadFactory f٦٠٢٩a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f٦٠٣٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ce.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class C٠٠٧٣b {

        /* renamed from: a, reason: collision with root package name */
        final int f٦٠٣٦a;

        /* renamed from: b, reason: collision with root package name */
        final c[] f٦٠٣٧b;

        /* renamed from: c, reason: collision with root package name */
        long f٦٠٣٨c;

        C٠٠٧٣b(int i10, ThreadFactory threadFactory) {
            this.f٦٠٣٦a = i10;
            this.f٦٠٣٧b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f٦٠٣٧b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f٦٠٣٦a;
            if (i10 == 0) {
                return b.f٦٠٢٨f;
            }
            c[] cVarArr = this.f٦٠٣٧b;
            long j10 = this.f٦٠٣٨c;
            this.f٦٠٣٨c = 1 + j10;
            return cVarArr[(int) (j10 % i10)];
        }

        public void b() {
            for (c cVar : this.f٦٠٣٧b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new h("RxComputationShutdown"));
        f٦٠٢٨f = cVar;
        cVar.dispose();
        h hVar = new h("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);
        f٦٠٢٦d = hVar;
        C٠٠٧٣b r02 = new C٠٠٧٣b(0, hVar);
        f٦٠٢٥c = r02;
        r02.b();
    }

    public b() {
        this(f٦٠٢٦d);
    }

    static int a(int i10, int i11) {
        if (i11 > 0 && i11 <= i10) {
            return i11;
        }
        return i10;
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        return new a(((C٠٠٧٣b) this.f٦٠٣٠b.get()).a());
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c scheduleDirect(Runnable runnable, long j10, TimeUnit timeUnit) {
        return ((C٠٠٧٣b) this.f٦٠٣٠b.get()).a().b(runnable, j10, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.h0
    public nd.c schedulePeriodicallyDirect(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return ((C٠٠٧٣b) this.f٦٠٣٠b.get()).a().c(runnable, j10, j11, timeUnit);
    }

    @Override // io.reactivex.rxjava3.core.h0
    public void start() {
        C٠٠٧٣b r02 = new C٠٠٧٣b(f٦٠٢٧e, this.f٦٠٢٩a);
        if (!androidx.lifecycle.a.a(this.f٦٠٣٠b, f٦٠٢٥c, r02)) {
            r02.b();
        }
    }

    public b(ThreadFactory threadFactory) {
        this.f٦٠٢٩a = threadFactory;
        this.f٦٠٣٠b = new AtomicReference(f٦٠٢٥c);
        start();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends h0.c {

        /* renamed from: a, reason: collision with root package name */
        private final qd.e f٦٠٣١a;

        /* renamed from: b, reason: collision with root package name */
        private final nd.a f٦٠٣٢b;

        /* renamed from: c, reason: collision with root package name */
        private final qd.e f٦٠٣٣c;

        /* renamed from: d, reason: collision with root package name */
        private final c f٦٠٣٤d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f٦٠٣٥e;

        a(c cVar) {
            this.f٦٠٣٤d = cVar;
            qd.e eVar = new qd.e();
            this.f٦٠٣١a = eVar;
            nd.a aVar = new nd.a();
            this.f٦٠٣٢b = aVar;
            qd.e eVar2 = new qd.e();
            this.f٦٠٣٣c = eVar2;
            eVar2.a(eVar);
            eVar2.a(aVar);
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٦٠٣٥e) {
                this.f٦٠٣٥e = true;
                this.f٦٠٣٣c.dispose();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٦٠٣٥e;
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable) {
            if (this.f٦٠٣٥e) {
                return qd.d.INSTANCE;
            }
            return this.f٦٠٣٤d.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f٦٠٣١a);
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f٦٠٣٥e) {
                return qd.d.INSTANCE;
            }
            return this.f٦٠٣٤d.a(runnable, j10, timeUnit, this.f٦٠٣٢b);
        }
    }
}
