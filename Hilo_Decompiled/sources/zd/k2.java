package zd;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class k2 extends ge.a {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f١٩٩٤٧a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f١٩٩٤٨b = new AtomicReference();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicReference implements nd.c {
        private static final long serialVersionUID = 7463222674719692880L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٩٤٩a;

        a(io.reactivex.rxjava3.core.g0 g0Var, b bVar) {
            this.f١٩٩٤٩a = g0Var;
            lazySet(bVar);
        }

        @Override // nd.c
        public void dispose() {
            b bVar = (b) getAndSet(null);
            if (bVar != null) {
                bVar.b(this);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: e, reason: collision with root package name */
        static final a[] f١٩٩٥٠e = new a[0];

        /* renamed from: f, reason: collision with root package name */
        static final a[] f١٩٩٥١f = new a[0];
        private static final long serialVersionUID = -3251430252873581268L;

        /* renamed from: b, reason: collision with root package name */
        final AtomicReference f١٩٩٥٣b;

        /* renamed from: d, reason: collision with root package name */
        Throwable f١٩٩٥٥d;

        /* renamed from: a, reason: collision with root package name */
        final AtomicBoolean f١٩٩٥٢a = new AtomicBoolean();

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference f١٩٩٥٤c = new AtomicReference();

        b(AtomicReference atomicReference) {
            this.f١٩٩٥٣b = atomicReference;
            lazySet(f١٩٩٥٠e);
        }

        public boolean a(a aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
                if (aVarArr == f١٩٩٥١f) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        public void b(a aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        if (aVarArr[i10] == aVar) {
                            break;
                        } else {
                            i10++;
                        }
                    } else {
                        i10 = -1;
                        break;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                aVarArr2 = f١٩٩٥٠e;
                if (length != 1) {
                    aVarArr2 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, i10);
                    System.arraycopy(aVarArr, i10 + 1, aVarArr2, i10, (length - i10) - 1);
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // nd.c
        public void dispose() {
            getAndSet(f١٩٩٥١f);
            androidx.lifecycle.a.a(this.f١٩٩٥٣b, this, null);
            qd.c.a(this.f١٩٩٥٤c);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (get() == f١٩٩٥١f) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f١٩٩٥٤c.lazySet(qd.c.DISPOSED);
            for (a aVar : (a[]) getAndSet(f١٩٩٥١f)) {
                aVar.f١٩٩٤٩a.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            Object obj = this.f١٩٩٥٤c.get();
            qd.c cVar = qd.c.DISPOSED;
            if (obj != cVar) {
                this.f١٩٩٥٥d = th;
                this.f١٩٩٥٤c.lazySet(cVar);
                for (a aVar : (a[]) getAndSet(f١٩٩٥١f)) {
                    aVar.f١٩٩٤٩a.onError(th);
                }
                return;
            }
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            for (a aVar : (a[]) get()) {
                aVar.f١٩٩٤٩a.onNext(obj);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f١٩٩٥٤c, cVar);
        }
    }

    public k2(io.reactivex.rxjava3.core.e0 e0Var) {
        this.f١٩٩٤٧a = e0Var;
    }

    @Override // ge.a
    public void d(pd.g gVar) {
        b bVar;
        while (true) {
            bVar = (b) this.f١٩٩٤٨b.get();
            if (bVar != null && !bVar.isDisposed()) {
                break;
            }
            b bVar2 = new b(this.f١٩٩٤٨b);
            if (androidx.lifecycle.a.a(this.f١٩٩٤٨b, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z10 = false;
        if (!bVar.f١٩٩٥٢a.get() && bVar.f١٩٩٥٢a.compareAndSet(false, true)) {
            z10 = true;
        }
        try {
            gVar.accept(bVar);
            if (z10) {
                this.f١٩٩٤٧a.subscribe(bVar);
            }
        } catch (Throwable th) {
            od.b.b(th);
            throw fe.j.g(th);
        }
    }

    @Override // ge.a
    public void f() {
        b bVar = (b) this.f١٩٩٤٨b.get();
        if (bVar != null && bVar.isDisposed()) {
            androidx.lifecycle.a.a(this.f١٩٩٤٨b, bVar, null);
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        b bVar;
        while (true) {
            bVar = (b) this.f١٩٩٤٨b.get();
            if (bVar != null) {
                break;
            }
            b bVar2 = new b(this.f١٩٩٤٨b);
            if (androidx.lifecycle.a.a(this.f١٩٩٤٨b, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        a aVar = new a(g0Var, bVar);
        g0Var.onSubscribe(aVar);
        if (bVar.a(aVar)) {
            if (aVar.isDisposed()) {
                bVar.b(aVar);
            }
        } else {
            Throwable th = bVar.f١٩٩٥٥d;
            if (th != null) {
                g0Var.onError(th);
            } else {
                g0Var.onComplete();
            }
        }
    }
}
