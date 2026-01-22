package je;

import fe.j;
import io.reactivex.rxjava3.core.h;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d extends je.a {

    /* renamed from: b, reason: collision with root package name */
    final be.c f١٥٣٩٢b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f١٥٣٩٣c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f١٥٣٩٤d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f١٥٣٩٥e;

    /* renamed from: f, reason: collision with root package name */
    Throwable f١٥٣٩٦f;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f١٥٣٩٨h;

    /* renamed from: l, reason: collision with root package name */
    boolean f١٥٤٠٢l;

    /* renamed from: g, reason: collision with root package name */
    final AtomicReference f١٥٣٩٧g = new AtomicReference();

    /* renamed from: i, reason: collision with root package name */
    final AtomicBoolean f١٥٣٩٩i = new AtomicBoolean();

    /* renamed from: j, reason: collision with root package name */
    final ee.a f١٥٤٠٠j = new a();

    /* renamed from: k, reason: collision with root package name */
    final AtomicLong f١٥٤٠١k = new AtomicLong();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class a extends ee.a {
        private static final long serialVersionUID = -4896760517184205454L;

        a() {
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 2) != 0) {
                d.this.f١٥٤٠٢l = true;
                return 2;
            }
            return 0;
        }

        public void cancel() {
            if (d.this.f١٥٣٩٨h) {
                return;
            }
            d.this.f١٥٣٩٨h = true;
            d.this.v();
            d.this.f١٥٣٩٧g.lazySet(null);
            if (d.this.f١٥٤٠٠j.getAndIncrement() == 0) {
                d.this.f١٥٣٩٧g.lazySet(null);
                d dVar = d.this;
                if (!dVar.f١٥٤٠٢l) {
                    dVar.f١٥٣٩٢b.clear();
                }
            }
        }

        @Override // sd.j
        public void clear() {
            d.this.f١٥٣٩٢b.clear();
        }

        @Override // sd.j
        public boolean isEmpty() {
            return d.this.f١٥٣٩٢b.isEmpty();
        }

        @Override // sd.j
        public Object poll() {
            return d.this.f١٥٣٩٢b.poll();
        }

        public void request(long j10) {
            if (ee.c.g(j10)) {
                fe.d.a(d.this.f١٥٤٠١k, j10);
                d.this.w();
            }
        }
    }

    d(int i10, Runnable runnable, boolean z10) {
        this.f١٥٣٩٢b = new be.c(i10);
        this.f١٥٣٩٣c = new AtomicReference(runnable);
        this.f١٥٣٩٤d = z10;
    }

    public static d u() {
        return new d(h.b(), null, true);
    }

    public void onComplete() {
        if (!this.f١٥٣٩٥e && !this.f١٥٣٩٨h) {
            this.f١٥٣٩٥e = true;
            v();
            w();
        }
    }

    public void onError(Throwable th) {
        j.c(th, "onError called with a null Throwable.");
        if (!this.f١٥٣٩٥e && !this.f١٥٣٩٨h) {
            this.f١٥٣٩٦f = th;
            this.f١٥٣٩٥e = true;
            v();
            w();
            return;
        }
        ie.a.s(th);
    }

    public void onNext(Object obj) {
        j.c(obj, "onNext called with a null value.");
        if (!this.f١٥٣٩٥e && !this.f١٥٣٩٨h) {
            this.f١٥٣٩٢b.offer(obj);
            w();
        }
    }

    @Override // io.reactivex.rxjava3.core.i
    public void onSubscribe(kf.c cVar) {
        if (!this.f١٥٣٩٥e && !this.f١٥٣٩٨h) {
            cVar.request(LongCompanionObject.MAX_VALUE);
        } else {
            cVar.cancel();
        }
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        if (!this.f١٥٣٩٩i.get() && this.f١٥٣٩٩i.compareAndSet(false, true)) {
            bVar.onSubscribe(this.f١٥٤٠٠j);
            this.f١٥٣٩٧g.set(bVar);
            if (this.f١٥٣٩٨h) {
                this.f١٥٣٩٧g.lazySet(null);
                return;
            } else {
                w();
                return;
            }
        }
        ee.b.c(new IllegalStateException("This processor allows only a single Subscriber"), bVar);
    }

    boolean t(boolean z10, boolean z11, boolean z12, kf.b bVar, be.c cVar) {
        if (this.f١٥٣٩٨h) {
            cVar.clear();
            this.f١٥٣٩٧g.lazySet(null);
            return true;
        }
        if (z11) {
            if (z10 && this.f١٥٣٩٦f != null) {
                cVar.clear();
                this.f١٥٣٩٧g.lazySet(null);
                bVar.onError(this.f١٥٣٩٦f);
                return true;
            }
            if (z12) {
                Throwable th = this.f١٥٣٩٦f;
                this.f١٥٣٩٧g.lazySet(null);
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
            return false;
        }
        return false;
    }

    void v() {
        Runnable runnable = (Runnable) this.f١٥٣٩٣c.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }

    void w() {
        if (this.f١٥٤٠٠j.getAndIncrement() != 0) {
            return;
        }
        kf.b bVar = (kf.b) this.f١٥٣٩٧g.get();
        int i10 = 1;
        while (bVar == null) {
            i10 = this.f١٥٤٠٠j.addAndGet(-i10);
            if (i10 == 0) {
                return;
            } else {
                bVar = (kf.b) this.f١٥٣٩٧g.get();
            }
        }
        if (this.f١٥٤٠٢l) {
            x(bVar);
        } else {
            y(bVar);
        }
    }

    void x(kf.b bVar) {
        be.c cVar = this.f١٥٣٩٢b;
        boolean z10 = this.f١٥٣٩٤d;
        int i10 = 1;
        while (!this.f١٥٣٩٨h) {
            boolean z11 = this.f١٥٣٩٥e;
            if (!z10 && z11 && this.f١٥٣٩٦f != null) {
                cVar.clear();
                this.f١٥٣٩٧g.lazySet(null);
                bVar.onError(this.f١٥٣٩٦f);
                return;
            }
            bVar.onNext((Object) null);
            if (z11) {
                this.f١٥٣٩٧g.lazySet(null);
                Throwable th = this.f١٥٣٩٦f;
                if (th != null) {
                    bVar.onError(th);
                    return;
                } else {
                    bVar.onComplete();
                    return;
                }
            }
            i10 = this.f١٥٤٠٠j.addAndGet(-i10);
            if (i10 == 0) {
                return;
            }
        }
        this.f١٥٣٩٧g.lazySet(null);
    }

    void y(kf.b bVar) {
        long j10;
        boolean z10;
        be.c cVar = this.f١٥٣٩٢b;
        boolean z11 = !this.f١٥٣٩٤d;
        int i10 = 1;
        do {
            long j11 = this.f١٥٤٠١k.get();
            long j12 = 0;
            while (true) {
                if (j11 != j12) {
                    boolean z12 = this.f١٥٣٩٥e;
                    Object poll = cVar.poll();
                    if (poll == null) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    j10 = j12;
                    if (t(z11, z12, z10, bVar, cVar)) {
                        return;
                    }
                    if (z10) {
                        break;
                    }
                    bVar.onNext(poll);
                    j12 = 1 + j10;
                } else {
                    j10 = j12;
                    break;
                }
            }
            if (j11 == j12 && t(z11, this.f١٥٣٩٥e, cVar.isEmpty(), bVar, cVar)) {
                return;
            }
            if (j10 != 0 && j11 != LongCompanionObject.MAX_VALUE) {
                this.f١٥٤٠١k.addAndGet(-j10);
            }
            i10 = this.f١٥٤٠٠j.addAndGet(-i10);
        } while (i10 != 0);
    }
}
