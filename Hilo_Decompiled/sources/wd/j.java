package wd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class j extends wd.a {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements io.reactivex.rxjava3.core.i, kf.c {
        private static final long serialVersionUID = 163080509307634843L;

        /* renamed from: a, reason: collision with root package name */
        final kf.b f١٨٧٨٩a;

        /* renamed from: b, reason: collision with root package name */
        kf.c f١٨٧٩٠b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f١٨٧٩١c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f١٨٧٩٢d;

        /* renamed from: e, reason: collision with root package name */
        volatile boolean f١٨٧٩٣e;

        /* renamed from: f, reason: collision with root package name */
        final AtomicLong f١٨٧٩٤f = new AtomicLong();

        /* renamed from: g, reason: collision with root package name */
        final AtomicReference f١٨٧٩٥g = new AtomicReference();

        a(kf.b bVar) {
            this.f١٨٧٨٩a = bVar;
        }

        boolean a(boolean z10, boolean z11, kf.b bVar, AtomicReference atomicReference) {
            if (this.f١٨٧٩٣e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (z10) {
                Throwable th = this.f١٨٧٩٢d;
                if (th != null) {
                    atomicReference.lazySet(null);
                    bVar.onError(th);
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

        void b() {
            boolean z10;
            boolean z11;
            if (getAndIncrement() != 0) {
                return;
            }
            kf.b bVar = this.f١٨٧٨٩a;
            AtomicLong atomicLong = this.f١٨٧٩٤f;
            AtomicReference atomicReference = this.f١٨٧٩٥g;
            int i10 = 1;
            do {
                long j10 = 0;
                while (true) {
                    z10 = false;
                    if (j10 == atomicLong.get()) {
                        break;
                    }
                    boolean z12 = this.f١٨٧٩١c;
                    Object andSet = atomicReference.getAndSet(null);
                    if (andSet == null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (a(z12, z11, bVar, atomicReference)) {
                        return;
                    }
                    if (z11) {
                        break;
                    }
                    bVar.onNext(andSet);
                    j10++;
                }
                if (j10 == atomicLong.get()) {
                    boolean z13 = this.f١٨٧٩١c;
                    if (atomicReference.get() == null) {
                        z10 = true;
                    }
                    if (a(z13, z10, bVar, atomicReference)) {
                        return;
                    }
                }
                if (j10 != 0) {
                    fe.d.d(atomicLong, j10);
                }
                i10 = addAndGet(-i10);
            } while (i10 != 0);
        }

        public void cancel() {
            if (!this.f١٨٧٩٣e) {
                this.f١٨٧٩٣e = true;
                this.f١٨٧٩٠b.cancel();
                if (getAndIncrement() == 0) {
                    this.f١٨٧٩٥g.lazySet(null);
                }
            }
        }

        public void onComplete() {
            this.f١٨٧٩١c = true;
            b();
        }

        public void onError(Throwable th) {
            this.f١٨٧٩٢d = th;
            this.f١٨٧٩١c = true;
            b();
        }

        public void onNext(Object obj) {
            this.f١٨٧٩٥g.lazySet(obj);
            b();
        }

        @Override // io.reactivex.rxjava3.core.i
        public void onSubscribe(kf.c cVar) {
            if (ee.c.h(this.f١٨٧٩٠b, cVar)) {
                this.f١٨٧٩٠b = cVar;
                this.f١٨٧٨٩a.onSubscribe(this);
                cVar.request(LongCompanionObject.MAX_VALUE);
            }
        }

        public void request(long j10) {
            if (ee.c.g(j10)) {
                fe.d.a(this.f١٨٧٩٤f, j10);
                b();
            }
        }
    }

    public j(io.reactivex.rxjava3.core.h hVar) {
        super(hVar);
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        this.f١٨٧٣٨b.o(new a(bVar));
    }
}
