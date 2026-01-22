package wd;

import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k extends wd.a {

    /* renamed from: c, reason: collision with root package name */
    final h0 f١٨٧٩٦c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f١٨٧٩٧d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicReference implements io.reactivex.rxjava3.core.i, kf.c, Runnable {
        private static final long serialVersionUID = 8094547886072529208L;

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٨٧٩٨a;

        /* renamed from: b, reason: collision with root package name */
        final h0.c f١٨٧٩٩b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference f١٨٨٠٠c = new AtomicReference();

        /* renamed from: d, reason: collision with root package name */
        final AtomicLong f١٨٨٠١d = new AtomicLong();

        /* renamed from: e, reason: collision with root package name */
        final boolean f١٨٨٠٢e;

        /* renamed from: f, reason: collision with root package name */
        kf.a f١٨٨٠٣f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: wd.k$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class RunnableC٠٢٤٢a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final kf.c f١٨٨٠٤a;

            /* renamed from: b, reason: collision with root package name */
            final long f١٨٨٠٥b;

            RunnableC٠٢٤٢a(kf.c cVar, long j10) {
                this.f١٨٨٠٤a = cVar;
                this.f١٨٨٠٥b = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f١٨٨٠٤a.request(this.f١٨٨٠٥b);
            }
        }

        a(kf.b bVar, h0.c cVar, kf.a aVar, boolean z10) {
            this.f١٨٧٩٨a = bVar;
            this.f١٨٧٩٩b = cVar;
            this.f١٨٨٠٣f = aVar;
            this.f١٨٨٠٢e = !z10;
        }

        void a(long j10, kf.c cVar) {
            if (!this.f١٨٨٠٢e && Thread.currentThread() != get()) {
                this.f١٨٧٩٩b.schedule(new RunnableC٠٢٤٢a(cVar, j10));
            } else {
                cVar.request(j10);
            }
        }

        public void cancel() {
            ee.c.a(this.f١٨٨٠٠c);
            this.f١٨٧٩٩b.dispose();
        }

        public void onComplete() {
            this.f١٨٧٩٨a.onComplete();
            this.f١٨٧٩٩b.dispose();
        }

        public void onError(Throwable th) {
            this.f١٨٧٩٨a.onError(th);
            this.f١٨٧٩٩b.dispose();
        }

        public void onNext(Object obj) {
            this.f١٨٧٩٨a.onNext(obj);
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.f(this.f١٨٨٠٠c, cVar)) {
                long andSet = this.f١٨٨٠١d.getAndSet(0L);
                if (andSet != 0) {
                    a(andSet, cVar);
                }
            }
        }

        public void request(long j10) {
            if (ee.c.g(j10)) {
                kf.c cVar = (kf.c) this.f١٨٨٠٠c.get();
                if (cVar != null) {
                    a(j10, cVar);
                    return;
                }
                fe.d.a(this.f١٨٨٠١d, j10);
                kf.c cVar2 = (kf.c) this.f١٨٨٠٠c.get();
                if (cVar2 != null) {
                    long andSet = this.f١٨٨٠١d.getAndSet(0L);
                    if (andSet != 0) {
                        a(andSet, cVar2);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            lazySet(Thread.currentThread());
            kf.a aVar = this.f١٨٨٠٣f;
            this.f١٨٨٠٣f = null;
            aVar.subscribe(this);
        }
    }

    public k(io.reactivex.rxjava3.core.h hVar, h0 h0Var, boolean z10) {
        super(hVar);
        this.f١٨٧٩٦c = h0Var;
        this.f١٨٧٩٧d = z10;
    }

    @Override // io.reactivex.rxjava3.core.h
    public void p(kf.b bVar) {
        h0.c createWorker = this.f١٨٧٩٦c.createWorker();
        a aVar = new a(bVar, createWorker, this.f١٨٧٣٨b, this.f١٨٧٩٧d);
        bVar.onSubscribe(aVar);
        createWorker.schedule(aVar);
    }
}
