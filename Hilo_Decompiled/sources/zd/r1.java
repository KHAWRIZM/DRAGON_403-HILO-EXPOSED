package zd;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class r1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a implements pd.r {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.z f٢٠٣٩٣a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٠٣٩٤b;

        /* renamed from: c, reason: collision with root package name */
        final boolean f٢٠٣٩٥c;

        a(io.reactivex.rxjava3.core.z zVar, int i10, boolean z10) {
            this.f٢٠٣٩٣a = zVar;
            this.f٢٠٣٩٤b = i10;
            this.f٢٠٣٩٥c = z10;
        }

        @Override // pd.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ge.a get() {
            return this.f٢٠٣٩٣a.replay(this.f٢٠٣٩٤b, this.f٢٠٣٩٥c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements pd.r {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.z f٢٠٣٩٦a;

        /* renamed from: b, reason: collision with root package name */
        final int f٢٠٣٩٧b;

        /* renamed from: c, reason: collision with root package name */
        final long f٢٠٣٩٨c;

        /* renamed from: d, reason: collision with root package name */
        final TimeUnit f٢٠٣٩٩d;

        /* renamed from: e, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٤٠٠e;

        /* renamed from: f, reason: collision with root package name */
        final boolean f٢٠٤٠١f;

        b(io.reactivex.rxjava3.core.z zVar, int i10, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
            this.f٢٠٣٩٦a = zVar;
            this.f٢٠٣٩٧b = i10;
            this.f٢٠٣٩٨c = j10;
            this.f٢٠٣٩٩d = timeUnit;
            this.f٢٠٤٠٠e = h0Var;
            this.f٢٠٤٠١f = z10;
        }

        @Override // pd.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ge.a get() {
            return this.f٢٠٣٩٦a.replay(this.f٢٠٣٩٧b, this.f٢٠٣٩٨c, this.f٢٠٣٩٩d, this.f٢٠٤٠٠e, this.f٢٠٤٠١f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        private final pd.o f٢٠٤٠٢a;

        c(pd.o oVar) {
            this.f٢٠٤٠٢a = oVar;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.rxjava3.core.e0 apply(Object obj) {
            Object apply = this.f٢٠٤٠٢a.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null Iterable");
            return new g1((Iterable) apply);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class d implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        private final pd.c f٢٠٤٠٣a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f٢٠٤٠٤b;

        d(pd.c cVar, Object obj) {
            this.f٢٠٤٠٣a = cVar;
            this.f٢٠٤٠٤b = obj;
        }

        @Override // pd.o
        public Object apply(Object obj) {
            return this.f٢٠٤٠٣a.apply(this.f٢٠٤٠٤b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class e implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        private final pd.c f٢٠٤٠٥a;

        /* renamed from: b, reason: collision with root package name */
        private final pd.o f٢٠٤٠٦b;

        e(pd.c cVar, pd.o oVar) {
            this.f٢٠٤٠٥a = cVar;
            this.f٢٠٤٠٦b = oVar;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.rxjava3.core.e0 apply(Object obj) {
            Object apply = this.f٢٠٤٠٦b.apply(obj);
            Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
            return new z1((io.reactivex.rxjava3.core.e0) apply, new d(this.f٢٠٤٠٥a, obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class f implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        final pd.o f٢٠٤٠٧a;

        f(pd.o oVar) {
            this.f٢٠٤٠٧a = oVar;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public io.reactivex.rxjava3.core.e0 apply(Object obj) {
            Object apply = this.f٢٠٤٠٧a.apply(obj);
            Objects.requireNonNull(apply, "The itemDelay returned a null ObservableSource");
            return new r3((io.reactivex.rxjava3.core.e0) apply, 1L).map(rd.a.k(obj)).defaultIfEmpty(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class g implements pd.a {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٠٨a;

        g(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٤٠٨a = g0Var;
        }

        @Override // pd.a
        public void run() {
            this.f٢٠٤٠٨a.onComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class h implements pd.g {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤٠٩a;

        h(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٤٠٩a = g0Var;
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            this.f٢٠٤٠٩a.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class i implements pd.g {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.g0 f٢٠٤١٠a;

        i(io.reactivex.rxjava3.core.g0 g0Var) {
            this.f٢٠٤١٠a = g0Var;
        }

        @Override // pd.g
        public void accept(Object obj) {
            this.f٢٠٤١٠a.onNext(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class j implements pd.r {

        /* renamed from: a, reason: collision with root package name */
        private final io.reactivex.rxjava3.core.z f٢٠٤١١a;

        j(io.reactivex.rxjava3.core.z zVar) {
            this.f٢٠٤١١a = zVar;
        }

        @Override // pd.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ge.a get() {
            return this.f٢٠٤١١a.replay();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class k implements pd.c {

        /* renamed from: a, reason: collision with root package name */
        final pd.b f٢٠٤١٢a;

        k(pd.b bVar) {
            this.f٢٠٤١٢a = bVar;
        }

        @Override // pd.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, io.reactivex.rxjava3.core.g gVar) {
            this.f٢٠٤١٢a.accept(obj, gVar);
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class l implements pd.c {

        /* renamed from: a, reason: collision with root package name */
        final pd.g f٢٠٤١٣a;

        l(pd.g gVar) {
            this.f٢٠٤١٣a = gVar;
        }

        @Override // pd.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object obj, io.reactivex.rxjava3.core.g gVar) {
            this.f٢٠٤١٣a.accept(gVar);
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class m implements pd.r {

        /* renamed from: a, reason: collision with root package name */
        final io.reactivex.rxjava3.core.z f٢٠٤١٤a;

        /* renamed from: b, reason: collision with root package name */
        final long f٢٠٤١٥b;

        /* renamed from: c, reason: collision with root package name */
        final TimeUnit f٢٠٤١٦c;

        /* renamed from: d, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f٢٠٤١٧d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f٢٠٤١٨e;

        m(io.reactivex.rxjava3.core.z zVar, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
            this.f٢٠٤١٤a = zVar;
            this.f٢٠٤١٥b = j10;
            this.f٢٠٤١٦c = timeUnit;
            this.f٢٠٤١٧d = h0Var;
            this.f٢٠٤١٨e = z10;
        }

        @Override // pd.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ge.a get() {
            return this.f٢٠٤١٤a.replay(this.f٢٠٤١٥b, this.f٢٠٤١٦c, this.f٢٠٤١٧d, this.f٢٠٤١٨e);
        }
    }

    public static pd.o a(pd.o oVar) {
        return new c(oVar);
    }

    public static pd.o b(pd.o oVar, pd.c cVar) {
        return new e(cVar, oVar);
    }

    public static pd.o c(pd.o oVar) {
        return new f(oVar);
    }

    public static pd.a d(io.reactivex.rxjava3.core.g0 g0Var) {
        return new g(g0Var);
    }

    public static pd.g e(io.reactivex.rxjava3.core.g0 g0Var) {
        return new h(g0Var);
    }

    public static pd.g f(io.reactivex.rxjava3.core.g0 g0Var) {
        return new i(g0Var);
    }

    public static pd.r g(io.reactivex.rxjava3.core.z zVar) {
        return new j(zVar);
    }

    public static pd.r h(io.reactivex.rxjava3.core.z zVar, int i10, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
        return new b(zVar, i10, j10, timeUnit, h0Var, z10);
    }

    public static pd.r i(io.reactivex.rxjava3.core.z zVar, int i10, boolean z10) {
        return new a(zVar, i10, z10);
    }

    public static pd.r j(io.reactivex.rxjava3.core.z zVar, long j10, TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var, boolean z10) {
        return new m(zVar, j10, timeUnit, h0Var, z10);
    }

    public static pd.c k(pd.b bVar) {
        return new k(bVar);
    }

    public static pd.c l(pd.g gVar) {
        return new l(gVar);
    }
}
