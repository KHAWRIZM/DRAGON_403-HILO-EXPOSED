package zd;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class h extends io.reactivex.rxjava3.core.z {

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0[] f١٩٨٣٠a;

    /* renamed from: b, reason: collision with root package name */
    final Iterable f١٩٨٣١b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a implements nd.c {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٣٢a;

        /* renamed from: b, reason: collision with root package name */
        final b[] f١٩٨٣٣b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicInteger f١٩٨٣٤c = new AtomicInteger();

        a(io.reactivex.rxjava3.core.g0 g0Var, int i10) {
            this.f١٩٨٣٢a = g0Var;
            this.f١٩٨٣٣b = new b[i10];
        }

        public void a(io.reactivex.rxjava3.core.e0[] e0VarArr) {
            b[] bVarArr = this.f١٩٨٣٣b;
            int length = bVarArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                bVarArr[i10] = new b(this, i11, this.f١٩٨٣٢a);
                i10 = i11;
            }
            this.f١٩٨٣٤c.lazySet(0);
            this.f١٩٨٣٢a.onSubscribe(this);
            for (int i12 = 0; i12 < length && this.f١٩٨٣٤c.get() == 0; i12++) {
                e0VarArr[i12].subscribe(bVarArr[i12]);
            }
        }

        public boolean b(int i10) {
            int i11 = 0;
            if (this.f١٩٨٣٤c.get() != 0 || !this.f١٩٨٣٤c.compareAndSet(0, i10)) {
                return false;
            }
            b[] bVarArr = this.f١٩٨٣٣b;
            int length = bVarArr.length;
            while (i11 < length) {
                int i12 = i11 + 1;
                if (i12 != i10) {
                    bVarArr[i11].a();
                }
                i11 = i12;
            }
            return true;
        }

        @Override // nd.c
        public void dispose() {
            if (this.f١٩٨٣٤c.get() != -1) {
                this.f١٩٨٣٤c.lazySet(-1);
                for (b bVar : this.f١٩٨٣٣b) {
                    bVar.a();
                }
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f١٩٨٣٤c.get() == -1) {
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = -1185974347409665484L;

        /* renamed from: a, reason: collision with root package name */
        final a f١٩٨٣٥a;

        /* renamed from: b, reason: collision with root package name */
        final int f١٩٨٣٦b;

        /* renamed from: c, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f١٩٨٣٧c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٩٨٣٨d;

        b(a aVar, int i10, io.reactivex.rxjava3.core.g0 g0Var) {
            this.f١٩٨٣٥a = aVar;
            this.f١٩٨٣٦b = i10;
            this.f١٩٨٣٧c = g0Var;
        }

        public void a() {
            qd.c.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (this.f١٩٨٣٨d) {
                this.f١٩٨٣٧c.onComplete();
            } else if (this.f١٩٨٣٥a.b(this.f١٩٨٣٦b)) {
                this.f١٩٨٣٨d = true;
                this.f١٩٨٣٧c.onComplete();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f١٩٨٣٨d) {
                this.f١٩٨٣٧c.onError(th);
            } else if (this.f١٩٨٣٥a.b(this.f١٩٨٣٦b)) {
                this.f١٩٨٣٨d = true;
                this.f١٩٨٣٧c.onError(th);
            } else {
                ie.a.s(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f١٩٨٣٨d) {
                this.f١٩٨٣٧c.onNext(obj);
            } else if (this.f١٩٨٣٥a.b(this.f١٩٨٣٦b)) {
                this.f١٩٨٣٨d = true;
                this.f١٩٨٣٧c.onNext(obj);
            } else {
                ((nd.c) get()).dispose();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    public h(io.reactivex.rxjava3.core.e0[] e0VarArr, Iterable iterable) {
        this.f١٩٨٣٠a = e0VarArr;
        this.f١٩٨٣١b = iterable;
    }

    @Override // io.reactivex.rxjava3.core.z
    public void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        int length;
        io.reactivex.rxjava3.core.e0[] e0VarArr = this.f١٩٨٣٠a;
        if (e0VarArr == null) {
            e0VarArr = new io.reactivex.rxjava3.core.e0[8];
            try {
                length = 0;
                for (io.reactivex.rxjava3.core.e0 e0Var : this.f١٩٨٣١b) {
                    if (e0Var == null) {
                        qd.d.f(new NullPointerException("One of the sources is null"), g0Var);
                        return;
                    }
                    if (length == e0VarArr.length) {
                        io.reactivex.rxjava3.core.e0[] e0VarArr2 = new io.reactivex.rxjava3.core.e0[(length >> 2) + length];
                        System.arraycopy(e0VarArr, 0, e0VarArr2, 0, length);
                        e0VarArr = e0VarArr2;
                    }
                    int i10 = length + 1;
                    e0VarArr[length] = e0Var;
                    length = i10;
                }
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
                return;
            }
        } else {
            length = e0VarArr.length;
        }
        if (length == 0) {
            qd.d.d(g0Var);
        } else if (length == 1) {
            e0VarArr[0].subscribe(g0Var);
        } else {
            new a(g0Var, length).a(e0VarArr);
        }
    }
}
