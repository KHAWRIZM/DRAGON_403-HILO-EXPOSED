package zd;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class v2 extends ge.a {

    /* renamed from: e, reason: collision with root package name */
    static final b f٢٠٦٤٧e = new n();

    /* renamed from: a, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٦٤٨a;

    /* renamed from: b, reason: collision with root package name */
    final AtomicReference f٢٠٦٤٩b;

    /* renamed from: c, reason: collision with root package name */
    final b f٢٠٦٥٠c;

    /* renamed from: d, reason: collision with root package name */
    final io.reactivex.rxjava3.core.e0 f٢٠٦٥١d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        g call();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class c implements pd.g {

        /* renamed from: a, reason: collision with root package name */
        private final r4 f٢٠٦٥٥a;

        c(r4 r4Var) {
            this.f٢٠٦٥٥a = r4Var;
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(nd.c cVar) {
            this.f٢٠٦٥٥a.a(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class d extends AtomicInteger implements nd.c {
        private static final long serialVersionUID = 2728361546769921047L;

        /* renamed from: a, reason: collision with root package name */
        final i f٢٠٦٥٦a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٦٥٧b;

        /* renamed from: c, reason: collision with root package name */
        Object f٢٠٦٥٨c;

        /* renamed from: d, reason: collision with root package name */
        volatile boolean f٢٠٦٥٩d;

        d(i iVar, io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٦٥٦a = iVar;
            this.f٢٠٦٥٧b = g0Var;
        }

        Object a() {
            return this.f٢٠٦٥٨c;
        }

        @Override // nd.c
        public void dispose() {
            if (!this.f٢٠٦٥٩d) {
                this.f٢٠٦٥٩d = true;
                this.f٢٠٦٥٦a.b(this);
                this.f٢٠٦٥٨c = null;
            }
        }

        @Override // nd.c
        public boolean isDisposed() {
            return this.f٢٠٦٥٩d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class e extends io.reactivex.rxjava3.core.z {

        /* renamed from: a, reason: collision with root package name */
        private final pd.r f٢٠٦٦٠a;

        /* renamed from: b, reason: collision with root package name */
        private final pd.o f٢٠٦٦١b;

        e(pd.r rVar, pd.o oVar) {
            this.f٢٠٦٦٠a = rVar;
            this.f٢٠٦٦١b = oVar;
        }

        @Override // io.reactivex.rxjava3.core.z
        protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
            try {
                Object obj = this.f٢٠٦٦٠a.get();
                Objects.requireNonNull(obj, "The connectableFactory returned a null ConnectableObservable");
                ge.a aVar = (ge.a) obj;
                Object apply = this.f٢٠٦٦١b.apply(aVar);
                Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
                io.reactivex.rxjava3.core.e0 e0Var = (io.reactivex.rxjava3.core.e0) apply;
                r4 r4Var = new r4(g0Var);
                e0Var.subscribe(r4Var);
                aVar.d(new c(r4Var));
            } catch (Throwable th) {
                od.b.b(th);
                qd.d.f(th, g0Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class f extends AtomicReference {
        private static final long serialVersionUID = 245354315435971818L;

        /* renamed from: a, reason: collision with root package name */
        final Object f٢٠٦٦٢a;

        f(Object obj) {
            this.f٢٠٦٦٢a = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface g {
        void complete();

        void d(Throwable th);

        void e(d dVar);

        void f(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class h implements b {

        /* renamed from: a, reason: collision with root package name */
        final int f٢٠٦٦٣a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f٢٠٦٦٤b;

        h(int i10, boolean z10) {
            this.f٢٠٦٦٣a = i10;
            this.f٢٠٦٦٤b = z10;
        }

        @Override // zd.v2.b
        public g call() {
            return new m(this.f٢٠٦٦٣a, this.f٢٠٦٦٤b);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class i extends AtomicReference implements io.reactivex.rxjava3.core.g0, nd.c {

        /* renamed from: f, reason: collision with root package name */
        static final d[] f٢٠٦٦٥f = new d[0];

        /* renamed from: g, reason: collision with root package name */
        static final d[] f٢٠٦٦٦g = new d[0];
        private static final long serialVersionUID = -533785617179540163L;

        /* renamed from: a, reason: collision with root package name */
        final g f٢٠٦٦٧a;

        /* renamed from: b, reason: collision with root package name */
        boolean f٢٠٦٦٨b;

        /* renamed from: c, reason: collision with root package name */
        final AtomicReference f٢٠٦٦٩c = new AtomicReference(f٢٠٦٦٥f);

        /* renamed from: d, reason: collision with root package name */
        final AtomicBoolean f٢٠٦٧٠d = new AtomicBoolean();

        /* renamed from: e, reason: collision with root package name */
        final AtomicReference f٢٠٦٧١e;

        i(g gVar, AtomicReference atomicReference) {
            this.f٢٠٦٦٧a = gVar;
            this.f٢٠٦٧١e = atomicReference;
        }

        boolean a(d dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = (d[]) this.f٢٠٦٦٩c.get();
                if (dVarArr == f٢٠٦٦٦g) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!androidx.lifecycle.a.a(this.f٢٠٦٦٩c, dVarArr, dVarArr2));
            return true;
        }

        void b(d dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = (d[]) this.f٢٠٦٦٩c.get();
                int length = dVarArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = 0;
                while (true) {
                    if (i10 < length) {
                        if (dVarArr[i10].equals(dVar)) {
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
                    dVarArr2 = f٢٠٦٦٥f;
                } else {
                    d[] dVarArr3 = new d[length - 1];
                    System.arraycopy(dVarArr, 0, dVarArr3, 0, i10);
                    System.arraycopy(dVarArr, i10 + 1, dVarArr3, i10, (length - i10) - 1);
                    dVarArr2 = dVarArr3;
                }
            } while (!androidx.lifecycle.a.a(this.f٢٠٦٦٩c, dVarArr, dVarArr2));
        }

        void c() {
            for (d dVar : (d[]) this.f٢٠٦٦٩c.get()) {
                this.f٢٠٦٦٧a.e(dVar);
            }
        }

        void d() {
            for (d dVar : (d[]) this.f٢٠٦٦٩c.getAndSet(f٢٠٦٦٦g)) {
                this.f٢٠٦٦٧a.e(dVar);
            }
        }

        @Override // nd.c
        public void dispose() {
            this.f٢٠٦٦٩c.set(f٢٠٦٦٦g);
            androidx.lifecycle.a.a(this.f٢٠٦٧١e, this, null);
            qd.c.a(this);
        }

        @Override // nd.c
        public boolean isDisposed() {
            if (this.f٢٠٦٦٩c.get() == f٢٠٦٦٦g) {
                return true;
            }
            return false;
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.d
        public void onComplete() {
            if (!this.f٢٠٦٦٨b) {
                this.f٢٠٦٦٨b = true;
                this.f٢٠٦٦٧a.complete();
                d();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onError(Throwable th) {
            if (!this.f٢٠٦٦٨b) {
                this.f٢٠٦٦٨b = true;
                this.f٢٠٦٦٧a.d(th);
                d();
                return;
            }
            ie.a.s(th);
        }

        @Override // io.reactivex.rxjava3.core.g0
        public void onNext(Object obj) {
            if (!this.f٢٠٦٦٨b) {
                this.f٢٠٦٦٧a.f(obj);
                c();
            }
        }

        @Override // io.reactivex.rxjava3.core.g0, io.reactivex.rxjava3.core.l, io.reactivex.rxjava3.core.k0
        public void onSubscribe(nd.c cVar) {
            if (qd.c.g(this, cVar)) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class j implements io.reactivex.rxjava3.core.e0 {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference f٢٠٦٧٢a;

        /* renamed from: b, reason: collision with root package name */
        private final b f٢٠٦٧٣b;

        j(AtomicReference atomicReference, b bVar) {
            this.f٢٠٦٧٢a = atomicReference;
            this.f٢٠٦٧٣b = bVar;
        }

        @Override // io.reactivex.rxjava3.core.e0
        public void subscribe(io.reactivex.rxjava3.core.g0 g0Var) {
            i iVar;
            while (true) {
                iVar = (i) this.f٢٠٦٧٢a.get();
                if (iVar != null) {
                    break;
                }
                i iVar2 = new i(this.f٢٠٦٧٣b.call(), this.f٢٠٦٧٢a);
                if (androidx.lifecycle.a.a(this.f٢٠٦٧٢a, null, iVar2)) {
                    iVar = iVar2;
                    break;
                }
            }
            d dVar = new d(iVar, g0Var);
            g0Var.onSubscribe(dVar);
            iVar.a(dVar);
            if (dVar.isDisposed()) {
                iVar.b(dVar);
            } else {
                iVar.f٢٠٦٦٧a.e(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class k implements b {

        /* renamed from: a, reason: collision with root package name */
        private final int f٢٠٦٧٤a;

        /* renamed from: b, reason: collision with root package name */
        private final long f٢٠٦٧٥b;

        /* renamed from: c, reason: collision with root package name */
        private final TimeUnit f٢٠٦٧٦c;

        /* renamed from: d, reason: collision with root package name */
        private final io.reactivex.rxjava3.core.h0 f٢٠٦٧٧d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f٢٠٦٧٨e;

        k(int i10, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
            this.f٢٠٦٧٤a = i10;
            this.f٢٠٦٧٥b = j10;
            this.f٢٠٦٧٦c = timeUnit;
            this.f٢٠٦٧٧d = h0Var;
            this.f٢٠٦٧٨e = z10;
        }

        @Override // zd.v2.b
        public g call() {
            return new l(this.f٢٠٦٧٤a, this.f٢٠٦٧٥b, this.f٢٠٦٧٦c, this.f٢٠٦٧٧d, this.f٢٠٦٧٨e);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class l extends a {
        private static final long serialVersionUID = 3457957419649567404L;

        /* renamed from: d, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٦٧٩d;

        /* renamed from: e, reason: collision with root package name */
        final long f٢٠٦٨٠e;

        /* renamed from: f, reason: collision with root package name */
        final TimeUnit f٢٠٦٨١f;

        /* renamed from: g, reason: collision with root package name */
        final int f٢٠٦٨٢g;

        l(int i10, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
            super(z10);
            this.f٢٠٦٧٩d = h0Var;
            this.f٢٠٦٨٢g = i10;
            this.f٢٠٦٨٠e = j10;
            this.f٢٠٦٨١f = timeUnit;
        }

        @Override // zd.v2.a
        Object b(Object obj) {
            return new ke.b(obj, this.f٢٠٦٧٩d.now(this.f٢٠٦٨١f), this.f٢٠٦٨١f);
        }

        @Override // zd.v2.a
        f c() {
            f fVar;
            long now = this.f٢٠٦٧٩d.now(this.f٢٠٦٨١f) - this.f٢٠٦٨٠e;
            f fVar2 = (f) get();
            Object obj = fVar2.get();
            while (true) {
                f fVar3 = (f) obj;
                fVar = fVar2;
                fVar2 = fVar3;
                if (fVar2 != null) {
                    ke.b bVar = (ke.b) fVar2.f٢٠٦٦٢a;
                    if (fe.m.j(bVar.b()) || fe.m.k(bVar.b()) || bVar.a() > now) {
                        break;
                    }
                    obj = fVar2.get();
                } else {
                    break;
                }
            }
            return fVar;
        }

        @Override // zd.v2.a
        Object g(Object obj) {
            return ((ke.b) obj).b();
        }

        @Override // zd.v2.a
        void k() {
            f fVar;
            long now = this.f٢٠٦٧٩d.now(this.f٢٠٦٨١f) - this.f٢٠٦٨٠e;
            f fVar2 = (f) get();
            f fVar3 = (f) fVar2.get();
            int i10 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                int i11 = this.f٢٠٦٥٣b;
                if (i11 > 1) {
                    if (i11 > this.f٢٠٦٨٢g) {
                        i10++;
                        this.f٢٠٦٥٣b = i11 - 1;
                        fVar3 = (f) fVar2.get();
                    } else {
                        if (((ke.b) fVar2.f٢٠٦٦٢a).a() > now) {
                            break;
                        }
                        i10++;
                        this.f٢٠٦٥٣b--;
                        fVar3 = (f) fVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i10 != 0) {
                i(fVar);
            }
        }

        @Override // zd.v2.a
        void l() {
            f fVar;
            long now = this.f٢٠٦٧٩d.now(this.f٢٠٦٨١f) - this.f٢٠٦٨٠e;
            f fVar2 = (f) get();
            f fVar3 = (f) fVar2.get();
            int i10 = 0;
            while (true) {
                f fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (this.f٢٠٦٥٣b <= 1 || ((ke.b) fVar2.f٢٠٦٦٢a).a() > now) {
                    break;
                }
                i10++;
                this.f٢٠٦٥٣b--;
                fVar3 = (f) fVar2.get();
            }
            if (i10 != 0) {
                i(fVar);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class m extends a {
        private static final long serialVersionUID = -5898283885385201806L;

        /* renamed from: d, reason: collision with root package name */
        final int f٢٠٦٨٣d;

        m(int i10, boolean z10) {
            super(z10);
            this.f٢٠٦٨٣d = i10;
        }

        @Override // zd.v2.a
        void k() {
            if (this.f٢٠٦٥٣b > this.f٢٠٦٨٣d) {
                h();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class n implements b {
        n() {
        }

        @Override // zd.v2.b
        public g call() {
            return new o(16);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class o extends ArrayList implements g {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: a, reason: collision with root package name */
        volatile int f٢٠٦٨٤a;

        o(int i10) {
            super(i10);
        }

        @Override // zd.v2.g
        public void complete() {
            add(fe.m.e());
            this.f٢٠٦٨٤a++;
        }

        @Override // zd.v2.g
        public void d(Throwable th) {
            add(fe.m.g(th));
            this.f٢٠٦٨٤a++;
        }

        @Override // zd.v2.g
        public void e(d dVar) {
            int i10;
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            io.reactivex.rxjava3.core.g0 g0Var = dVar.f٢٠٦٥٧b;
            int i11 = 1;
            while (!dVar.isDisposed()) {
                int i12 = this.f٢٠٦٨٤a;
                Integer num = (Integer) dVar.a();
                if (num != null) {
                    i10 = num.intValue();
                } else {
                    i10 = 0;
                }
                while (i10 < i12) {
                    if (fe.m.a(get(i10), g0Var) || dVar.isDisposed()) {
                        return;
                    } else {
                        i10++;
                    }
                }
                dVar.f٢٠٦٥٨c = Integer.valueOf(i10);
                i11 = dVar.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }

        @Override // zd.v2.g
        public void f(Object obj) {
            add(fe.m.l(obj));
            this.f٢٠٦٨٤a++;
        }
    }

    private v2(io.reactivex.rxjava3.core.e0 e0Var, io.reactivex.rxjava3.core.e0 e0Var2, AtomicReference atomicReference, b bVar) {
        this.f٢٠٦٥١d = e0Var;
        this.f٢٠٦٤٨a = e0Var2;
        this.f٢٠٦٤٩b = atomicReference;
        this.f٢٠٦٥٠c = bVar;
    }

    public static ge.a g(io.reactivex.rxjava3.core.e0 e0Var, int i10, boolean z10) {
        if (i10 == Integer.MAX_VALUE) {
            return k(e0Var);
        }
        return j(e0Var, new h(i10, z10));
    }

    public static ge.a h(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, int i10, boolean z10) {
        return j(e0Var, new k(i10, j10, timeUnit, h0Var, z10));
    }

    public static ge.a i(io.reactivex.rxjava3.core.e0 e0Var, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
        return h(e0Var, j10, timeUnit, h0Var, Integer.MAX_VALUE, z10);
    }

    static ge.a j(io.reactivex.rxjava3.core.e0 e0Var, b bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return ie.a.k(new v2(new j(atomicReference, bVar), e0Var, atomicReference, bVar));
    }

    public static ge.a k(io.reactivex.rxjava3.core.e0 e0Var) {
        return j(e0Var, f٢٠٦٤٧e);
    }

    public static io.reactivex.rxjava3.core.z l(pd.r rVar, pd.o oVar) {
        return ie.a.o(new e(rVar, oVar));
    }

    @Override // ge.a
    public void d(pd.g gVar) {
        i iVar;
        boolean z10;
        while (true) {
            iVar = (i) this.f٢٠٦٤٩b.get();
            if (iVar != null && !iVar.isDisposed()) {
                break;
            }
            i iVar2 = new i(this.f٢٠٦٥٠c.call(), this.f٢٠٦٤٩b);
            if (androidx.lifecycle.a.a(this.f٢٠٦٤٩b, iVar, iVar2)) {
                iVar = iVar2;
                break;
            }
        }
        if (!iVar.f٢٠٦٧٠d.get() && iVar.f٢٠٦٧٠d.compareAndSet(false, true)) {
            z10 = true;
        } else {
            z10 = false;
        }
        try {
            gVar.accept(iVar);
            if (z10) {
                this.f٢٠٦٤٨a.subscribe(iVar);
            }
        } catch (Throwable th) {
            od.b.b(th);
            if (z10) {
                iVar.f٢٠٦٧٠d.compareAndSet(true, false);
            }
            od.b.b(th);
            throw fe.j.g(th);
        }
    }

    @Override // ge.a
    public void f() {
        i iVar = (i) this.f٢٠٦٤٩b.get();
        if (iVar != null && iVar.isDisposed()) {
            androidx.lifecycle.a.a(this.f٢٠٦٤٩b, iVar, null);
        }
    }

    @Override // io.reactivex.rxjava3.core.z
    protected void subscribeActual(io.reactivex.rxjava3.core.g0 g0Var) {
        this.f٢٠٦٥١d.subscribe(g0Var);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static abstract class a extends AtomicReference implements g {
        private static final long serialVersionUID = 2346567790059478686L;

        /* renamed from: a, reason: collision with root package name */
        f f٢٠٦٥٢a;

        /* renamed from: b, reason: collision with root package name */
        int f٢٠٦٥٣b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f٢٠٦٥٤c;

        a(boolean z10) {
            this.f٢٠٦٥٤c = z10;
            f fVar = new f(null);
            this.f٢٠٦٥٢a = fVar;
            set(fVar);
        }

        final void a(f fVar) {
            this.f٢٠٦٥٢a.set(fVar);
            this.f٢٠٦٥٢a = fVar;
            this.f٢٠٦٥٣b++;
        }

        f c() {
            return (f) get();
        }

        @Override // zd.v2.g
        public final void complete() {
            a(new f(b(fe.m.e())));
            l();
        }

        @Override // zd.v2.g
        public final void d(Throwable th) {
            a(new f(b(fe.m.g(th))));
            l();
        }

        @Override // zd.v2.g
        public final void e(d dVar) {
            if (dVar.getAndIncrement() != 0) {
                return;
            }
            int i10 = 1;
            do {
                f fVar = (f) dVar.a();
                if (fVar == null) {
                    fVar = c();
                    dVar.f٢٠٦٥٨c = fVar;
                }
                while (!dVar.isDisposed()) {
                    f fVar2 = (f) fVar.get();
                    if (fVar2 != null) {
                        if (fe.m.a(g(fVar2.f٢٠٦٦٢a), dVar.f٢٠٦٥٧b)) {
                            dVar.f٢٠٦٥٨c = null;
                            return;
                        }
                        fVar = fVar2;
                    } else {
                        dVar.f٢٠٦٥٨c = fVar;
                        i10 = dVar.addAndGet(-i10);
                    }
                }
                dVar.f٢٠٦٥٨c = null;
                return;
            } while (i10 != 0);
        }

        @Override // zd.v2.g
        public final void f(Object obj) {
            a(new f(b(fe.m.l(obj))));
            k();
        }

        final void h() {
            this.f٢٠٦٥٣b--;
            i((f) ((f) get()).get());
        }

        final void i(f fVar) {
            if (this.f٢٠٦٥٤c) {
                f fVar2 = new f(null);
                fVar2.lazySet(fVar.get());
                fVar = fVar2;
            }
            set(fVar);
        }

        final void j() {
            f fVar = (f) get();
            if (fVar.f٢٠٦٦٢a != null) {
                f fVar2 = new f(null);
                fVar2.lazySet(fVar.get());
                set(fVar2);
            }
        }

        abstract void k();

        void l() {
            j();
        }

        Object b(Object obj) {
            return obj;
        }

        Object g(Object obj) {
            return obj;
        }
    }
}
