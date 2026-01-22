package ce;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class m extends h0 implements nd.c {

    /* renamed from: d, reason: collision with root package name */
    static final nd.c f٦٠٨٠d = new g();

    /* renamed from: e, reason: collision with root package name */
    static final nd.c f٦٠٨١e = nd.b.a();

    /* renamed from: a, reason: collision with root package name */
    private final h0 f٦٠٨٢a;

    /* renamed from: b, reason: collision with root package name */
    private final je.a f٦٠٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private nd.c f٦٠٨٤c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        final h0.c f٦٠٨٥a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: ce.m$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public final class C٠٠٧٤a extends io.reactivex.rxjava3.core.b {

            /* renamed from: a, reason: collision with root package name */
            final f f٦٠٨٦a;

            C٠٠٧٤a(f fVar) {
                this.f٦٠٨٦a = fVar;
            }

            @Override // io.reactivex.rxjava3.core.b
            protected void e(io.reactivex.rxjava3.core.d dVar) {
                dVar.onSubscribe(this.f٦٠٨٦a);
                this.f٦٠٨٦a.a(a.this.f٦٠٨٥a, dVar);
            }
        }

        a(h0.c cVar) {
            this.f٦٠٨٥a = cVar;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.rxjava3.core.b apply(f fVar) {
            return new C٠٠٧٤a(fVar);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class b extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f٦٠٨٨a;

        /* renamed from: b, reason: collision with root package name */
        private final long f٦٠٨٩b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f٦٠٩٠c;

        b(Runnable runnable, long j10, TimeUnit timeUnit) {
            this.f٦٠٨٨a = runnable;
            this.f٦٠٨٩b = j10;
            this.f٦٠٩٠c = timeUnit;
        }

        @Override // ce.m.f
        protected nd.c b(h0.c cVar, io.reactivex.rxjava3.core.d dVar) {
            return cVar.schedule(new d(this.f٦٠٨٨a, dVar), this.f٦٠٨٩b, this.f٦٠٩٠c);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class c extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f٦٠٩١a;

        c(Runnable runnable) {
            this.f٦٠٩١a = runnable;
        }

        @Override // ce.m.f
        protected nd.c b(h0.c cVar, io.reactivex.rxjava3.core.d dVar) {
            return cVar.schedule(new d(this.f٦٠٩١a, dVar));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.d f٦٠٩٢a;

        /* renamed from: b, reason: collision with root package name */
        final Runnable f٦٠٩٣b;

        d(Runnable runnable, io.reactivex.rxjava3.core.d dVar) {
            this.f٦٠٩٣b = runnable;
            this.f٦٠٩٢a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f٦٠٩٣b.run();
            } finally {
                this.f٦٠٩٢a.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static abstract class f extends AtomicReference implements nd.c {
        f() {
            super(m.f٦٠٨٠d);
        }

        void a(h0.c cVar, io.reactivex.rxjava3.core.d dVar) {
            nd.c cVar2;
            nd.c cVar3 = (nd.c) get();
            if (cVar3 == m.f٦٠٨١e || cVar3 != (cVar2 = m.f٦٠٨٠d)) {
                return;
            }
            nd.c b10 = b(cVar, dVar);
            if (!compareAndSet(cVar2, b10)) {
                b10.dispose();
            }
        }

        protected abstract nd.c b(h0.c cVar, io.reactivex.rxjava3.core.d dVar);

        @Override // nd.c
        public void dispose() {
            ((nd.c) getAndSet(m.f٦٠٨١e)).dispose();
        }

        @Override // nd.c
        public boolean isDisposed() {
            return ((nd.c) get()).isDisposed();
        }
    }

    public m(pd.o oVar, h0 h0Var) {
        this.f٦٠٨٢a = h0Var;
        je.a s10 = je.d.u().s();
        this.f٦٠٨٣b = s10;
        try {
            this.f٦٠٨٤c = ((io.reactivex.rxjava3.core.b) oVar.apply(s10)).d();
        } catch (Throwable th) {
            throw fe.j.g(th);
        }
    }

    @Override // io.reactivex.rxjava3.core.h0
    public h0.c createWorker() {
        h0.c createWorker = this.f٦٠٨٢a.createWorker();
        je.a s10 = je.d.u().s();
        io.reactivex.rxjava3.core.h e10 = s10.e(new a(createWorker));
        e eVar = new e(s10, createWorker);
        this.f٦٠٨٣b.onNext(e10);
        return eVar;
    }

    @Override // nd.c
    public void dispose() {
        this.f٦٠٨٤c.dispose();
    }

    @Override // nd.c
    public boolean isDisposed() {
        return this.f٦٠٨٤c.isDisposed();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class e extends h0.c {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicBoolean f٦٠٩٤a = new AtomicBoolean();

        /* renamed from: b, reason: collision with root package name */
        private final je.a f٦٠٩٥b;

        /* renamed from: c, reason: collision with root package name */
        private final h0.c f٦٠٩٦c;

        e(je.a aVar, h0.c cVar) {
            this.f٦٠٩٥b = aVar;
            this.f٦٠٩٦c = cVar;
        }

        @Override // nd.c
        public void dispose() {
            if (this.f٦٠٩٤a.compareAndSet(false, true)) {
                this.f٦٠٩٥b.onComplete();
                this.f٦٠٩٦c.dispose();
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٦٠٩٤a.get();
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
            b bVar = new b(runnable, j10, timeUnit);
            this.f٦٠٩٥b.onNext(bVar);
            return bVar;
        }

        @Override // io.reactivex.rxjava3.core.h0.c
        public nd.c schedule(Runnable runnable) {
            c cVar = new c(runnable);
            this.f٦٠٩٥b.onNext(cVar);
            return cVar;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class g implements nd.c {
        g() {
        }

        @Override // nd.c
        public boolean isDisposed() {
            return false;
        }

        @Override // nd.c
        public void dispose() {
        }
    }
}
