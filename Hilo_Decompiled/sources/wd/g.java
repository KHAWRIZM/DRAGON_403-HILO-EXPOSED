package wd;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class g extends wd.a {

    /* renamed from: c, reason: collision with root package name */
    final int f١٨٧٦٧c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f١٨٧٦٨d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f١٨٧٦٩e;

    /* renamed from: f, reason: collision with root package name */
    final pd.a f١٨٧٧٠f;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends ee.a implements io.reactivex.rxjava3.core.i {
        private static final long serialVersionUID = -2514538129242366402L;

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٨٧٧١a;

        /* renamed from: b, reason: collision with root package name */
        final sd.i f١٨٧٧٢b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f١٨٧٧٣c;

        /* renamed from: d, reason: collision with root package name */
        final pd.a f١٨٧٧٤d;

        /* renamed from: e, reason: collision with root package name */
        kf.c f١٨٧٧٥e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f١٨٧٧٦f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f١٨٧٧٧g;

        /* renamed from: h, reason: collision with root package name */
        Throwable f١٨٧٧٨h;

        /* renamed from: i, reason: collision with root package name */
        final AtomicLong f١٨٧٧٩i = new AtomicLong();

        /* renamed from: j, reason: collision with root package name */
        boolean f١٨٧٨٠j;

        a(kf.b bVar, int i10, boolean z10, boolean z11, pd.a aVar) {
            sd.i bVar2;
            this.f١٨٧٧١a = bVar;
            this.f١٨٧٧٤d = aVar;
            this.f١٨٧٧٣c = z11;
            if (z10) {
                bVar2 = new be.c(i10);
            } else {
                bVar2 = new be.b(i10);
            }
            this.f١٨٧٧٢b = bVar2;
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 2) != 0) {
                this.f١٨٧٨٠j = true;
                return 2;
            }
            return 0;
        }

        boolean b(boolean z10, boolean z11, kf.b bVar) {
            if (this.f١٨٧٧٦f) {
                this.f١٨٧٧٢b.clear();
                return true;
            }
            if (z10) {
                if (this.f١٨٧٧٣c) {
                    if (z11) {
                        Throwable th = this.f١٨٧٧٨h;
                        if (th != null) {
                            bVar.onError(th);
                        } else {
                            bVar.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f١٨٧٧٨h;
                if (th2 != null) {
                    this.f١٨٧٧٢b.clear();
                    bVar.onError(th2);
                    return true;
                }
                if (z11) {
                    bVar.onComplete();
                    return true;
                }
                return false;
            }
            return false;
        }

        public void cancel() {
            if (!this.f١٨٧٧٦f) {
                this.f١٨٧٧٦f = true;
                this.f١٨٧٧٥e.cancel();
                if (!this.f١٨٧٨٠j && getAndIncrement() == 0) {
                    this.f١٨٧٧٢b.clear();
                }
            }
        }

        @Override // sd.j
        public void clear() {
            this.f١٨٧٧٢b.clear();
        }

        void d() {
            boolean z10;
            if (getAndIncrement() == 0) {
                sd.i iVar = this.f١٨٧٧٢b;
                kf.b bVar = this.f١٨٧٧١a;
                int i10 = 1;
                while (!b(this.f١٨٧٧٧g, iVar.isEmpty(), bVar)) {
                    long j10 = this.f١٨٧٧٩i.get();
                    long j11 = 0;
                    while (j11 != j10) {
                        boolean z11 = this.f١٨٧٧٧g;
                        Object poll = iVar.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (b(z11, z10, bVar)) {
                            return;
                        }
                        if (z10) {
                            break;
                        }
                        bVar.onNext(poll);
                        j11++;
                    }
                    if (j11 == j10 && b(this.f١٨٧٧٧g, iVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j11 != 0 && j10 != LongCompanionObject.MAX_VALUE) {
                        this.f١٨٧٧٩i.addAndGet(-j11);
                    }
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        @Override // sd.j
        public boolean isEmpty() {
            return this.f١٨٧٧٢b.isEmpty();
        }

        public void onComplete() {
            this.f١٨٧٧٧g = true;
            if (this.f١٨٧٨٠j) {
                this.f١٨٧٧١a.onComplete();
            } else {
                d();
            }
        }

        public void onError(Throwable th) {
            this.f١٨٧٧٨h = th;
            this.f١٨٧٧٧g = true;
            if (this.f١٨٧٨٠j) {
                this.f١٨٧٧١a.onError(th);
            } else {
                d();
            }
        }

        public void onNext(Object obj) {
            if (!this.f١٨٧٧٢b.offer(obj)) {
                this.f١٨٧٧٥e.cancel();
                od.c cVar = new od.c("Buffer is full");
                try {
                    this.f١٨٧٧٤d.run();
                } catch (Throwable th) {
                    od.b.b(th);
                    cVar.initCause(th);
                }
                onError(cVar);
                return;
            }
            if (this.f١٨٧٨٠j) {
                this.f١٨٧٧١a.onNext((Object) null);
            } else {
                d();
            }
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٨٧٧٥e, cVar)) {
                this.f١٨٧٧٥e = cVar;
                this.f١٨٧٧١a.onSubscribe(this);
                cVar.request(LongCompanionObject.MAX_VALUE);
            }
        }

        @Override // sd.j
        public Object poll() {
            return this.f١٨٧٧٢b.poll();
        }

        public void request(long j10) {
            if (!this.f١٨٧٨٠j && ee.c.g(j10)) {
                fe.d.a(this.f١٨٧٧٩i, j10);
                d();
            }
        }
    }

    public g(io.reactivex.rxjava3.core.h hVar, int i10, boolean z10, boolean z11, pd.a aVar) {
        super(hVar);
        this.f١٨٧٦٧c = i10;
        this.f١٨٧٦٨d = z10;
        this.f١٨٧٦٩e = z11;
        this.f١٨٧٧٠f = aVar;
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        this.f١٨٧٣٨b.o(new a(bVar, this.f١٨٧٦٧c, this.f١٨٧٦٨d, this.f١٨٧٦٩e, this.f١٨٧٧٠f));
    }
}
