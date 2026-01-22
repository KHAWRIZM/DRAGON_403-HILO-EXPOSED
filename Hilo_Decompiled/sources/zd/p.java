package zd;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p extends zd.a implements io.reactivex.rxjava3.core.g0 {

    /* renamed from: k, reason: collision with root package name */
    static final a[] f٢٠٢٧٠k = new a[0];

    /* renamed from: l, reason: collision with root package name */
    static final a[] f٢٠٢٧١l = new a[0];

    /* renamed from: b, reason: collision with root package name */
    final AtomicBoolean f٢٠٢٧٢b;

    /* renamed from: c, reason: collision with root package name */
    final int f٢٠٢٧٣c;

    /* renamed from: d, reason: collision with root package name */
    final AtomicReference f٢٠٢٧٤d;

    /* renamed from: e, reason: collision with root package name */
    volatile long f٢٠٢٧٥e;

    /* renamed from: f, reason: collision with root package name */
    final b f٢٠٢٧٦f;

    /* renamed from: g, reason: collision with root package name */
    b f٢٠٢٧٧g;

    /* renamed from: h, reason: collision with root package name */
    int f٢٠٢٧٨h;

    /* renamed from: i, reason: collision with root package name */
    Throwable f٢٠٢٧٩i;

    /* renamed from: j, reason: collision with root package name */
    volatile boolean f٢٠٢٨٠j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a extends AtomicInteger implements nd.c {
        private static final long serialVersionUID = 6770240836423125754L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٢٨١a;

        /* renamed from: b, reason: collision with root package name */
        final p f٢٠٢٨٢b;

        /* renamed from: c, reason: collision with root package name */
        b f٢٠٢٨٣c;

        /* renamed from: d, reason: collision with root package name */
        int f٢٠٢٨٤d;

        /* renamed from: e, reason: collision with root package name */
        long f٢٠٢٨٥e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f٢٠٢٨٦f;

        a(io.reactivex.rxjava3.core.g0 g0Var, p pVar) {
            this.f٢٠٢٨١a = g0Var;
            this.f٢٠٢٨٢b = pVar;
            this.f٢٠٢٨٣c = pVar.f٢٠٢٧٦f;
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٢٨٦f) {
                this.f٢٠٢٨٦f = true;
                this.f٢٠٢٨٢b.e(this);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٢٨٦f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Object[] f٢٠٢٨٧a;

        /* renamed from: b, reason: collision with root package name */
        volatile b f٢٠٢٨٨b;

        b(int i10) {
            this.f٢٠٢٨٧a = new Object[i10];
        }
    }

    public p(io.reactivex.rxjava3.core.z zVar, int i10) {
        super(zVar);
        this.f٢٠٢٧٣c = i10;
        this.f٢٠٢٧٢b = new AtomicBoolean();
        b bVar = new b(i10);
        this.f٢٠٢٧٦f = bVar;
        this.f٢٠٢٧٧g = bVar;
        this.f٢٠٢٧٤d = new AtomicReference(f٢٠٢٧٠k);
    }

    void d(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f٢٠٢٧٤d.get();
            if (aVarArr == f٢٠٢٧١l) {
                return;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!androidx.lifecycle.a.a(this.f٢٠٢٧٤d, aVarArr, aVarArr2));
    }

    void e(a aVar) {
        a[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = (a[]) this.f٢٠٢٧٤d.get();
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
            if (length == 1) {
                aVarArr2 = f٢٠٢٧٠k;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!androidx.lifecycle.a.a(this.f٢٠٢٧٤d, aVarArr, aVarArr2));
    }

    void f(a aVar) {
        boolean z10;
        if (aVar.getAndIncrement() != 0) {
            return;
        }
        long j10 = aVar.f٢٠٢٨٥e;
        int i10 = aVar.f٢٠٢٨٤d;
        b bVar = aVar.f٢٠٢٨٣c;
        io.reactivex.rxjava3.core.g0 g0Var = aVar.f٢٠٢٨١a;
        int i11 = this.f٢٠٢٧٣c;
        int i12 = 1;
        while (!aVar.f٢٠٢٨٦f) {
            boolean z11 = this.f٢٠٢٨٠j;
            if (this.f٢٠٢٧٥e == j10) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z11 && z10) {
                aVar.f٢٠٢٨٣c = null;
                Throwable th = this.f٢٠٢٧٩i;
                if (th != null) {
                    g0Var.onError(th);
                    return;
                } else {
                    g0Var.onComplete();
                    return;
                }
            }
            if (!z10) {
                if (i10 == i11) {
                    bVar = bVar.f٢٠٢٨٨b;
                    i10 = 0;
                }
                g0Var.onNext(bVar.f٢٠٢٨٧a[i10]);
                i10++;
                j10++;
            } else {
                aVar.f٢٠٢٨٥e = j10;
                aVar.f٢٠٢٨٤d = i10;
                aVar.f٢٠٢٨٣c = bVar;
                i12 = aVar.addAndGet(-i12);
                if (i12 == 0) {
                    return;
                }
            }
        }
        aVar.f٢٠٢٨٣c = null;
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
    public void onComplete() {
        this.f٢٠٢٨٠j = true;
        for (a aVar : (a[]) this.f٢٠٢٧٤d.getAndSet(f٢٠٢٧١l)) {
            f(aVar);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onError(Throwable th) {
        this.f٢٠٢٧٩i = th;
        this.f٢٠٢٨٠j = true;
        for (a aVar : (a[]) this.f٢٠٢٧٤d.getAndSet(f٢٠٢٧١l)) {
            f(aVar);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0
    public void onNext(Object obj) {
        int i10 = this.f٢٠٢٧٨h;
        if (i10 == this.f٢٠٢٧٣c) {
            b bVar = new b(i10);
            bVar.f٢٠٢٨٧a[0] = obj;
            this.f٢٠٢٧٨h = 1;
            this.f٢٠٢٧٧g.f٢٠٢٨٨b = bVar;
            this.f٢٠٢٧٧g = bVar;
        } else {
            this.f٢٠٢٧٧g.f٢٠٢٨٧a[i10] = obj;
            this.f٢٠٢٧٨h = i10 + 1;
        }
        this.f٢٠٢٧٥e++;
        for (a aVar : (a[]) this.f٢٠٢٧٤d.get()) {
            f(aVar);
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        a aVar = new a(g0Var, this);
        g0Var.onSubscribe(aVar);
        d(aVar);
        if (!this.f٢٠٢٧٢b.get() && this.f٢٠٢٧٢b.compareAndSet(false, true)) {
            this.f١٩٥٣٢a.subscribe(this);
        } else {
            f(aVar);
        }
    }

    @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
    public void onSubscribe(nd.c cVar) {
    }
}
