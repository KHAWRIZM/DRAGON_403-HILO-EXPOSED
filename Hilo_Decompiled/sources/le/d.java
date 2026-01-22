package le;

import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.z;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sd.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class d extends c {

    /* renamed from: a, reason: collision with root package name */
    final be.c f١٥٨٨٧a;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference f١٥٨٨٩c;

    /* renamed from: d, reason: collision with root package name */
    final boolean f١٥٨٩٠d;

    /* renamed from: e, reason: collision with root package name */
    volatile boolean f١٥٨٩١e;

    /* renamed from: f, reason: collision with root package name */
    volatile boolean f١٥٨٩٢f;

    /* renamed from: g, reason: collision with root package name */
    Throwable f١٥٨٩٣g;

    /* renamed from: j, reason: collision with root package name */
    boolean f١٥٨٩٦j;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f١٥٨٨٨b = new AtomicReference();

    /* renamed from: h, reason: collision with root package name */
    final AtomicBoolean f١٥٨٩٤h = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    final ud.b f١٥٨٩٥i = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class a extends ud.b {
        private static final long serialVersionUID = 7926949470189395511L;

        a() {
        }

        @Override // sd.f
        public int a(int i10) {
            if ((i10 & 2) != 0) {
                d.this.f١٥٨٩٦j = true;
                return 2;
            }
            return 0;
        }

        @Override // sd.j
        public void clear() {
            d.this.f١٥٨٨٧a.clear();
        }

        @Override // nd.c
        public void dispose() {
            if (!d.this.f١٥٨٩١e) {
                d.this.f١٥٨٩١e = true;
                d.this.g();
                d.this.f١٥٨٨٨b.lazySet(null);
                if (d.this.f١٥٨٩٥i.getAndIncrement() == 0) {
                    d.this.f١٥٨٨٨b.lazySet(null);
                    d dVar = d.this;
                    if (!dVar.f١٥٨٩٦j) {
                        dVar.f١٥٨٨٧a.clear();
                    }
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return d.this.f١٥٨٩١e;
        }

        @Override // sd.j
        public boolean isEmpty() {
            return d.this.f١٥٨٨٧a.isEmpty();
        }

        @Override // sd.j
        public Object poll() {
            return d.this.f١٥٨٨٧a.poll();
        }
    }

    d(int i10, Runnable runnable, boolean z10) {
        this.f١٥٨٨٧a = new be.c(i10);
        this.f١٥٨٨٩c = new AtomicReference(runnable);
        this.f١٥٨٩٠d = z10;
    }

    public static d e() {
        return new d(z.bufferSize(), null, true);
    }

    public static d f(int i10, Runnable runnable) {
        rd.b.b(i10, "capacityHint");
        Objects.requireNonNull(runnable, "onTerminate");
        return new d(i10, runnable, true);
    }

    void g() {
        Runnable runnable = (Runnable) this.f١٥٨٨٩c.get();
        if (runnable != null && androidx.lifecycle.a.a(this.f١٥٨٨٩c, runnable, null)) {
            runnable.run();
        }
    }

    void h() {
        if (this.f١٥٨٩٥i.getAndIncrement() != 0) {
            return;
        }
        g0 g0Var = (g0) this.f١٥٨٨٨b.get();
        int i10 = 1;
        while (g0Var == null) {
            i10 = this.f١٥٨٩٥i.addAndGet(-i10);
            if (i10 == 0) {
                return;
            } else {
                g0Var = (g0) this.f١٥٨٨٨b.get();
            }
        }
        if (this.f١٥٨٩٦j) {
            i(g0Var);
        } else {
            j(g0Var);
        }
    }

    void i(g0 g0Var) {
        be.c cVar = this.f١٥٨٨٧a;
        boolean z10 = this.f١٥٨٩٠d;
        int i10 = 1;
        while (!this.f١٥٨٩١e) {
            boolean z11 = this.f١٥٨٩٢f;
            if (!z10 && z11 && l(cVar, g0Var)) {
                return;
            }
            g0Var.onNext(null);
            if (z11) {
                k(g0Var);
                return;
            } else {
                i10 = this.f١٥٨٩٥i.addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            }
        }
        this.f١٥٨٨٨b.lazySet(null);
    }

    void j(g0 g0Var) {
        boolean z10;
        be.c cVar = this.f١٥٨٨٧a;
        boolean z11 = this.f١٥٨٩٠d;
        boolean z12 = true;
        int i10 = 1;
        while (!this.f١٥٨٩١e) {
            boolean z13 = this.f١٥٨٩٢f;
            Object poll = this.f١٥٨٨٧a.poll();
            if (poll == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z13) {
                if (!z11 && z12) {
                    if (l(cVar, g0Var)) {
                        return;
                    } else {
                        z12 = false;
                    }
                }
                if (z10) {
                    k(g0Var);
                    return;
                }
            }
            if (z10) {
                i10 = this.f١٥٨٩٥i.addAndGet(-i10);
                if (i10 == 0) {
                    return;
                }
            } else {
                g0Var.onNext(poll);
            }
        }
        this.f١٥٨٨٨b.lazySet(null);
        cVar.clear();
    }

    void k(g0 g0Var) {
        this.f١٥٨٨٨b.lazySet(null);
        Throwable th = this.f١٥٨٩٣g;
        if (th != null) {
            g0Var.onError(th);
        } else {
            g0Var.onComplete();
        }
    }

    boolean l(j jVar, g0 g0Var) {
        Throwable th = this.f١٥٨٩٣g;
        if (th != null) {
            this.f١٥٨٨٨b.lazySet(null);
            jVar.clear();
            g0Var.onError(th);
            return true;
        }
        return false;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        if (!this.f١٥٨٩٢f && !this.f١٥٨٩١e) {
            this.f١٥٨٩٢f = true;
            g();
            h();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        fe.j.c(th, "onError called with a null Throwable.");
        if (!this.f١٥٨٩٢f && !this.f١٥٨٩١e) {
            this.f١٥٨٩٣g = th;
            this.f١٥٨٩٢f = true;
            g();
            h();
            return;
        }
        ie.a.s(th);
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        fe.j.c(obj, "onNext called with a null value.");
        if (!this.f١٥٨٩٢f && !this.f١٥٨٩١e) {
            this.f١٥٨٨٧a.offer(obj);
            h();
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
        if (this.f١٥٨٩٢f || this.f١٥٨٩١e) {
            cVar.dispose();
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(g0 g0Var) {
        if (!this.f١٥٨٩٤h.get() && this.f١٥٨٩٤h.compareAndSet(false, true)) {
            g0Var.onSubscribe(this.f١٥٨٩٥i);
            this.f١٥٨٨٨b.lazySet(g0Var);
            if (this.f١٥٨٩١e) {
                this.f١٥٨٨٨b.lazySet(null);
                return;
            } else {
                h();
                return;
            }
        }
        qd.d.f(new IllegalStateException("Only a single observer allowed."), g0Var);
    }
}
