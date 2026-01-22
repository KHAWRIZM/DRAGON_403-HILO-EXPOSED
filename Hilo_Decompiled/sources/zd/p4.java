package zd;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class p4 extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0[] f٢٠٣١٣a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable f٢٠٣١٤b;

    /* renamed from: c, reason: collision with root package name */
    final pd.o f٢٠٣١٥c;

    /* renamed from: d, reason: collision with root package name */
    final int f٢٠٣١٦d;

    /* renamed from: e, reason: collision with root package name */
    final boolean f٢٠٣١٧e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends AtomicInteger implements nd.c {
        private static final long serialVersionUID = 2983708048395377667L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٣١٨a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٣١٩b;

        /* renamed from: c, reason: collision with root package name */
        final b[] f٢٠٣٢٠c;

        /* renamed from: d, reason: collision with root package name */
        final Object[] f٢٠٣٢١d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f٢٠٣٢٢e;

        /* renamed from: f, reason: collision with root package name */
        volatile boolean f٢٠٣٢٣f;

        a(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10, boolean z10) {
            this.f٢٠٣١٨a = g0Var;
            this.f٢٠٣١٩b = oVar;
            this.f٢٠٣٢٠c = new b[i10];
            this.f٢٠٣٢١d = new Object[i10];
            this.f٢٠٣٢٢e = z10;
        }

        void a() {
            d();
            b();
        }

        void b() {
            for (b bVar : this.f٢٠٣٢٠c) {
                bVar.a();
            }
        }

        boolean c(boolean z10, boolean z11, io.reactivex.rxjava3.core.g0 g0Var, boolean z12, b bVar) {
            if (this.f٢٠٣٢٣f) {
                a();
                return true;
            }
            if (z10) {
                if (z12) {
                    if (z11) {
                        Throwable th = bVar.f٢٠٣٢٧d;
                        this.f٢٠٣٢٣f = true;
                        a();
                        if (th != null) {
                            g0Var.onError(th);
                        } else {
                            g0Var.onComplete();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = bVar.f٢٠٣٢٧d;
                if (th2 != null) {
                    this.f٢٠٣٢٣f = true;
                    a();
                    g0Var.onError(th2);
                    return true;
                }
                if (z11) {
                    this.f٢٠٣٢٣f = true;
                    a();
                    g0Var.onComplete();
                    return true;
                }
                return false;
            }
            return false;
        }

        void d() {
            for (b bVar : this.f٢٠٣٢٠c) {
                bVar.f٢٠٣٢٥b.clear();
            }
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٣٢٣f) {
                this.f٢٠٣٢٣f = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void e() {
            Throwable th;
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            b[] bVarArr = this.f٢٠٣٢٠c;
            io.reactivex.rxjava3.core.g0 g0Var = this.f٢٠٣١٨a;
            Object[] objArr = this.f٢٠٣٢١d;
            boolean z11 = this.f٢٠٣٢٢e;
            int i10 = 1;
            while (true) {
                int i11 = 0;
                int i12 = 0;
                for (b bVar : bVarArr) {
                    if (objArr[i12] == null) {
                        boolean z12 = bVar.f٢٠٣٢٦c;
                        Object poll = bVar.f٢٠٣٢٥b.poll();
                        if (poll == null) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (c(z12, z10, g0Var, z11, bVar)) {
                            return;
                        }
                        if (!z10) {
                            objArr[i12] = poll;
                        } else {
                            i11++;
                        }
                    } else if (bVar.f٢٠٣٢٦c && !z11 && (th = bVar.f٢٠٣٢٧d) != null) {
                        this.f٢٠٣٢٣f = true;
                        a();
                        g0Var.onError(th);
                        return;
                    }
                    i12++;
                }
                if (i11 != 0) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    try {
                        Object apply = this.f٢٠٣١٩b.apply(objArr.clone());
                        Objects.requireNonNull(apply, "The zipper returned a null value");
                        g0Var.onNext(apply);
                        Arrays.fill(objArr, (Object) null);
                    } catch (Throwable th2) {
                        od.b.b(th2);
                        a();
                        g0Var.onError(th2);
                        return;
                    }
                }
            }
        }

        public void f(io.reactivex.rxjava3.core.e0[] e0VarArr, int i10) {
            b[] bVarArr = this.f٢٠٣٢٠c;
            int length = bVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                bVarArr[i11] = new b(this, i10);
            }
            lazySet(0);
            this.f٢٠٣١٨a.onSubscribe(this);
            for (int i12 = 0; i12 < length && !this.f٢٠٣٢٣f; i12++) {
                e0VarArr[i12].subscribe(bVarArr[i12]);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٣٢٣f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements io.reactivex.rxjava3.core.g0 {

        /* renamed from: a, reason: collision with root package name */
        final a f٢٠٣٢٤a;

        /* renamed from: b, reason: collision with root package name */
        final be.c f٢٠٣٢٥b;

        /* renamed from: c, reason: collision with root package name */
        volatile boolean f٢٠٣٢٦c;

        /* renamed from: d, reason: collision with root package name */
        Throwable f٢٠٣٢٧d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f٢٠٣٢٨e = new AtomicReference();

        b(a aVar, int i10) {
            this.f٢٠٣٢٤a = aVar;
            this.f٢٠٣٢٥b = new be.c(i10);
        }

        public void a() {
            qd.c.a(this.f٢٠٣٢٨e);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٣٢٦c = true;
            this.f٢٠٣٢٤a.e();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٣٢٧d = th;
            this.f٢٠٣٢٦c = true;
            this.f٢٠٣٢٤a.e();
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            this.f٢٠٣٢٥b.offer(obj);
            this.f٢٠٣٢٤a.e();
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٣٢٨e, cVar);
        }
    }

    public p4(io.reactivex.rxjava3.core.e0[] e0VarArr, Iterable iterable, pd.o oVar, int i10, boolean z10) {
        this.f٢٠٣١٣a = e0VarArr;
        this.f٢٠٣١٤b = iterable;
        this.f٢٠٣١٥c = oVar;
        this.f٢٠٣١٦d = i10;
        this.f٢٠٣١٧e = z10;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        int length;
        io.reactivex.rxjava3.core.e0[] e0VarArr = this.f٢٠٣١٣a;
        if (e0VarArr == null) {
            e0VarArr = new io.reactivex.rxjava3.core.e0[8];
            length = 0;
            for (io.reactivex.rxjava3.core.e0 e0Var : this.f٢٠٣١٤b) {
                if (length == e0VarArr.length) {
                    io.reactivex.rxjava3.core.e0[] e0VarArr2 = new io.reactivex.rxjava3.core.e0[(length >> 2) + length];
                    System.arraycopy(e0VarArr, 0, e0VarArr2, 0, length);
                    e0VarArr = e0VarArr2;
                }
                e0VarArr[length] = e0Var;
                length++;
            }
        } else {
            length = e0VarArr.length;
        }
        if (length == 0) {
            qd.d.d(g0Var);
        } else {
            new a(g0Var, this.f٢٠٣١٥c, length, this.f٢٠٣١٧e).f(e0VarArr, this.f٢٠٣١٦d);
        }
    }
}
