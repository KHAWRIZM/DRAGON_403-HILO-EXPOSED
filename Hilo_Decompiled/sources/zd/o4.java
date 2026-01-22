package zd;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class o4 extends zd.a {

    /* renamed from: b, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0[] f٢٠٢٥٦b;

    /* renamed from: c, reason: collision with root package name */
    final Iterable f٢٠٢٥٧c;

    /* renamed from: d, reason: collision with root package name */
    final pd.o f٢٠٢٥٨d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    final class a implements pd.o {
        a() {
        }

        @Override // pd.o
        public Object apply(Object obj) {
            Object apply = o4.this.f٢٠٢٥٨d.apply(new Object[]{obj});
            Objects.requireNonNull(apply, "The combiner returned a null value");
            return apply;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends AtomicInteger implements io.reactivex.rxjava3.core.g0, nd.c {
        private static final long serialVersionUID = 1577321883966341961L;

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٢٦٠a;

        /* renamed from: b, reason: collision with root package name */
        final pd.o f٢٠٢٦١b;

        /* renamed from: c, reason: collision with root package name */
        final c[] f٢٠٢٦٢c;

        /* renamed from: d, reason: collision with root package name */
        final AtomicReferenceArray f٢٠٢٦٣d;

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f٢٠٢٦٤e;

        /* renamed from: f, reason: collision with root package name */
        final fe.c f٢٠٢٦٥f;

        /* renamed from: g, reason: collision with root package name */
        volatile boolean f٢٠٢٦٦g;

        b(io.reactivex.rxjava3.core.g0 g0Var, pd.o oVar, int i10) {
            this.f٢٠٢٦٠a = g0Var;
            this.f٢٠٢٦١b = oVar;
            c[] cVarArr = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cVarArr[i11] = new c(this, i11);
            }
            this.f٢٠٢٦٢c = cVarArr;
            this.f٢٠٢٦٣d = new AtomicReferenceArray(i10);
            this.f٢٠٢٦٤e = new AtomicReference();
            this.f٢٠٢٦٥f = new fe.c();
        }

        void a(int i10) {
            c[] cVarArr = this.f٢٠٢٦٢c;
            for (int i11 = 0; i11 < cVarArr.length; i11++) {
                if (i11 != i10) {
                    cVarArr[i11].a();
                }
            }
        }

        void b(int i10, boolean z10) {
            if (!z10) {
                this.f٢٠٢٦٦g = true;
                a(i10);
                fe.k.a(this.f٢٠٢٦٠a, this, this.f٢٠٢٦٥f);
            }
        }

        void c(int i10, Throwable th) {
            this.f٢٠٢٦٦g = true;
            qd.c.a(this.f٢٠٢٦٤e);
            a(i10);
            fe.k.c(this.f٢٠٢٦٠a, th, this, this.f٢٠٢٦٥f);
        }

        void d(int i10, Object obj) {
            this.f٢٠٢٦٣d.set(i10, obj);
        }

        @Override // nd.c
        public void dispose() {
            qd.c.a(this.f٢٠٢٦٤e);
            for (c cVar : this.f٢٠٢٦٢c) {
                cVar.a();
            }
        }

        void e(io.reactivex.rxjava3.core.e0[] e0VarArr, int i10) {
            c[] cVarArr = this.f٢٠٢٦٢c;
            AtomicReference atomicReference = this.f٢٠٢٦٤e;
            for (int i11 = 0; i11 < i10 && !qd.c.c((nd.c) atomicReference.get()) && !this.f٢٠٢٦٦g; i11++) {
                e0VarArr[i11].subscribe(cVarArr[i11]);
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return qd.c.c((nd.c) this.f٢٠٢٦٤e.get());
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٢٦٦g) {
                this.f٢٠٢٦٦g = true;
                a(-1);
                fe.k.a(this.f٢٠٢٦٠a, this, this.f٢٠٢٦٥f);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (this.f٢٠٢٦٦g) {
                ie.a.s(th);
                return;
            }
            this.f٢٠٢٦٦g = true;
            a(-1);
            fe.k.c(this.f٢٠٢٦٠a, th, this, this.f٢٠٢٦٥f);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (this.f٢٠٢٦٦g) {
                return;
            }
            AtomicReferenceArray atomicReferenceArray = this.f٢٠٢٦٣d;
            int length = atomicReferenceArray.length();
            Object[] objArr = new Object[length + 1];
            int i10 = 0;
            objArr[0] = obj;
            while (i10 < length) {
                Object obj2 = atomicReferenceArray.get(i10);
                if (obj2 == null) {
                    return;
                }
                i10++;
                objArr[i10] = obj2;
            }
            try {
                Object apply = this.f٢٠٢٦١b.apply(objArr);
                Objects.requireNonNull(apply, "combiner returned a null value");
                fe.k.e(this.f٢٠٢٦٠a, apply, this, this.f٢٠٢٦٥f);
            } catch (Throwable th) {
                od.b.b(th);
                dispose();
                onError(th);
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this.f٢٠٢٦٤e, cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c extends AtomicReference implements io.reactivex.rxjava3.core.g0 {
        private static final long serialVersionUID = 3256684027868224024L;

        /* renamed from: a, reason: collision with root package name */
        final b f٢٠٢٦٧a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٠٢٦٨b;

        /* renamed from: c, reason: collision with root package name */
        boolean f٢٠٢٦٩c;

        c(b bVar, int i10) {
            this.f٢٠٢٦٧a = bVar;
            this.f٢٠٢٦٨b = i10;
        }

        public void a() {
            qd.c.a(this);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            this.f٢٠٢٦٧a.b(this.f٢٠٢٦٨b, this.f٢٠٢٦٩c);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            this.f٢٠٢٦٧a.c(this.f٢٠٢٦٨b, th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f٢٠٢٦٩c) {
                this.f٢٠٢٦٩c = true;
            }
            this.f٢٠٢٦٧a.d(this.f٢٠٢٦٨b, obj);
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            qd.c.g(this, cVar);
        }
    }

    public o4(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0[] e0VarArr, pd.o oVar) {
        super(e0Var);
        this.f٢٠٢٥٦b = e0VarArr;
        this.f٢٠٢٥٧c = null;
        this.f٢٠٢٥٨d = oVar;
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        int length;
        io.reactivex.rxjava3.core.e0[] e0VarArr = this.f٢٠٢٥٦b;
        if (e0VarArr == null) {
            e0VarArr = new io.reactivex.rxjava3.core.e0[8];
            try {
                length = 0;
                for (io.reactivex.rxjava3.core.e0 e0Var : this.f٢٠٢٥٧c) {
                    if (length == e0VarArr.length) {
                        e0VarArr = (io.reactivex.rxjava3.core.e0[]) Arrays.copyOf(e0VarArr, (length >> 1) + length);
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
            new z1(this.f١٩٥٣٢a, new a()).subscribeActual(g0Var);
            return;
        }
        b bVar = new b(g0Var, this.f٢٠٢٥٨d, length);
        g0Var.onSubscribe(bVar);
        bVar.e(e0VarArr, length);
        this.f١٩٥٣٢a.subscribe(bVar);
    }

    public o4(io.reactivex.rxjava3.core.e0 e0Var, Iterable iterable, pd.o oVar) {
        super(e0Var);
        this.f٢٠٢٥٦b = null;
        this.f٢٠٢٥٧c = iterable;
        this.f٢٠٢٥٨d = oVar;
    }
}
