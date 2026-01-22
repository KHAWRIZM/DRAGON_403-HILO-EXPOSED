package rd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    static final pd.o f١٧٥٠٠a = new v();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f١٧٥٠١b = new q();

    /* renamed from: c, reason: collision with root package name */
    public static final pd.a f١٧٥٠٢c = new n();

    /* renamed from: d, reason: collision with root package name */
    static final pd.g f١٧٥٠٣d = new o();

    /* renamed from: e, reason: collision with root package name */
    public static final pd.g f١٧٥٠٤e = new s();

    /* renamed from: f, reason: collision with root package name */
    public static final pd.g f١٧٥٠٥f = new e0();

    /* renamed from: g, reason: collision with root package name */
    public static final pd.p f١٧٥٠٦g = new p();

    /* renamed from: h, reason: collision with root package name */
    static final pd.q f١٧٥٠٧h = new j0();

    /* renamed from: i, reason: collision with root package name */
    static final pd.q f١٧٥٠٨i = new t();

    /* renamed from: j, reason: collision with root package name */
    static final pd.r f١٧٥٠٩j = new d0();

    /* renamed from: k, reason: collision with root package name */
    public static final pd.g f١٧٥١٠k = new y();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: rd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class C٠٢٢١a implements pd.g {

        /* renamed from: a, reason: collision with root package name */
        final pd.a f١٧٥١١a;

        C٠٢٢١a(pd.a aVar) {
            this.f١٧٥١١a = aVar;
        }

        @Override // pd.g
        public void accept(Object obj) {
            this.f١٧٥١١a.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class a0 implements pd.a {

        /* renamed from: a, reason: collision with root package name */
        final pd.g f١٧٥١٢a;

        a0(pd.g gVar) {
            this.f١٧٥١٢a = gVar;
        }

        @Override // pd.a
        public void run() {
            this.f١٧٥١٢a.accept(io.reactivex.rxjava3.core.o.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        final pd.c f١٧٥١٣a;

        b(pd.c cVar) {
            this.f١٧٥١٣a = cVar;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f١٧٥١٣a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class b0 implements pd.g {

        /* renamed from: a, reason: collision with root package name */
        final pd.g f١٧٥١٤a;

        b0(pd.g gVar) {
            this.f١٧٥١٤a = gVar;
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            this.f١٧٥١٤a.accept(io.reactivex.rxjava3.core.o.b(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c implements pd.o {
        c(pd.h hVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 3) {
                throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class c0 implements pd.g {

        /* renamed from: a, reason: collision with root package name */
        final pd.g f١٧٥١٥a;

        c0(pd.g gVar) {
            this.f١٧٥١٥a = gVar;
        }

        @Override // pd.g
        public void accept(Object obj) {
            this.f١٧٥١٥a.accept(io.reactivex.rxjava3.core.o.c(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class d implements pd.o {
        d(pd.i iVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class d0 implements pd.r {
        d0() {
        }

        @Override // pd.r
        public Object get() {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class e implements pd.o {
        e(pd.j jVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class e0 implements pd.g {
        e0() {
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            ie.a.s(new od.d(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class f implements pd.o {
        f(pd.k kVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class f0 implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        final TimeUnit f١٧٥١٦a;

        /* renamed from: b, reason: collision with root package name */
        final io.reactivex.rxjava3.core.h0 f١٧٥١٧b;

        f0(TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
            this.f١٧٥١٦a = timeUnit;
            this.f١٧٥١٧b = h0Var;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ke.b apply(Object obj) {
            return new ke.b(obj, this.f١٧٥١٧b.now(this.f١٧٥١٦a), this.f١٧٥١٦a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class g implements pd.o {
        g(pd.l lVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class g0 implements pd.b {

        /* renamed from: a, reason: collision with root package name */
        private final pd.o f١٧٥١٨a;

        g0(pd.o oVar) {
            this.f١٧٥١٨a = oVar;
        }

        @Override // pd.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map map, Object obj) {
            map.put(this.f١٧٥١٨a.apply(obj), obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class h implements pd.o {
        h(pd.m mVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            Object obj8 = objArr[7];
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class h0 implements pd.b {

        /* renamed from: a, reason: collision with root package name */
        private final pd.o f١٧٥١٩a;

        /* renamed from: b, reason: collision with root package name */
        private final pd.o f١٧٥٢٠b;

        h0(pd.o oVar, pd.o oVar2) {
            this.f١٧٥١٩a = oVar;
            this.f١٧٥٢٠b = oVar2;
        }

        @Override // pd.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map map, Object obj) {
            map.put(this.f١٧٥٢٠b.apply(obj), this.f١٧٥١٩a.apply(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class i implements pd.o {
        i(pd.n nVar) {
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Object obj3 = objArr[2];
            Object obj4 = objArr[3];
            Object obj5 = objArr[4];
            Object obj6 = objArr[5];
            Object obj7 = objArr[6];
            Object obj8 = objArr[7];
            Object obj9 = objArr[8];
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class i0 implements pd.b {

        /* renamed from: a, reason: collision with root package name */
        private final pd.o f١٧٥٢١a;

        /* renamed from: b, reason: collision with root package name */
        private final pd.o f١٧٥٢٢b;

        /* renamed from: c, reason: collision with root package name */
        private final pd.o f١٧٥٢٣c;

        i0(pd.o oVar, pd.o oVar2, pd.o oVar3) {
            this.f١٧٥٢١a = oVar;
            this.f١٧٥٢٢b = oVar2;
            this.f١٧٥٢٣c = oVar3;
        }

        @Override // pd.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map map, Object obj) {
            Object apply = this.f١٧٥٢٣c.apply(obj);
            Collection collection = (Collection) map.get(apply);
            if (collection == null) {
                collection = (Collection) this.f١٧٥٢١a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f١٧٥٢٢b.apply(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class j implements pd.r {

        /* renamed from: a, reason: collision with root package name */
        final int f١٧٥٢٤a;

        j(int i10) {
            this.f١٧٥٢٤a = i10;
        }

        @Override // pd.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List get() {
            return new ArrayList(this.f١٧٥٢٤a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class j0 implements pd.q {
        j0() {
        }

        @Override // pd.q
        public boolean test(Object obj) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class k implements pd.q {
        k(pd.e eVar) {
        }

        @Override // pd.q
        public boolean test(Object obj) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class l implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        final Class f١٧٥٢٥a;

        l(Class cls) {
            this.f١٧٥٢٥a = cls;
        }

        @Override // pd.o
        public Object apply(Object obj) {
            return this.f١٧٥٢٥a.cast(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class m implements pd.q {

        /* renamed from: a, reason: collision with root package name */
        final Class f١٧٥٢٦a;

        m(Class cls) {
            this.f١٧٥٢٦a = cls;
        }

        @Override // pd.q
        public boolean test(Object obj) {
            return this.f١٧٥٢٦a.isInstance(obj);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class p implements pd.p {
        p() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class r implements pd.q {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٧٥٢٧a;

        r(Object obj) {
            this.f١٧٥٢٧a = obj;
        }

        @Override // pd.q
        public boolean test(Object obj) {
            return Objects.equals(obj, this.f١٧٥٢٧a);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class s implements pd.g {
        s() {
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            ie.a.s(th);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class t implements pd.q {
        t() {
        }

        @Override // pd.q
        public boolean test(Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum u implements pd.r {
        INSTANCE;

        @Override // pd.r
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Set get() {
            return new HashSet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class w implements Callable, pd.r, pd.o {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٧٥٣٠a;

        w(Object obj) {
            this.f١٧٥٣٠a = obj;
        }

        @Override // pd.o
        public Object apply(Object obj) {
            return this.f١٧٥٣٠a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.f١٧٥٣٠a;
        }

        @Override // pd.r
        public Object get() {
            return this.f١٧٥٣٠a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class x implements pd.o {

        /* renamed from: a, reason: collision with root package name */
        final Comparator f١٧٥٣١a;

        x(Comparator comparator) {
            this.f١٧٥٣١a = comparator;
        }

        @Override // pd.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List apply(List list) {
            Collections.sort(list, this.f١٧٥٣١a);
            return list;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class y implements pd.g {
        y() {
        }

        @Override // pd.g
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(kf.c cVar) {
            cVar.request(LongCompanionObject.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public enum z implements Comparator {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static pd.o A(pd.m mVar) {
        return new h(mVar);
    }

    public static pd.o B(pd.n nVar) {
        return new i(nVar);
    }

    public static pd.b C(pd.o oVar) {
        return new g0(oVar);
    }

    public static pd.b D(pd.o oVar, pd.o oVar2) {
        return new h0(oVar2, oVar);
    }

    public static pd.b E(pd.o oVar, pd.o oVar2, pd.o oVar3) {
        return new i0(oVar3, oVar2, oVar);
    }

    public static pd.g a(pd.a aVar) {
        return new C٠٢٢١a(aVar);
    }

    public static pd.q b() {
        return f١٧٥٠٨i;
    }

    public static pd.q c() {
        return f١٧٥٠٧h;
    }

    public static pd.o d(Class cls) {
        return new l(cls);
    }

    public static pd.r e(int i10) {
        return new j(i10);
    }

    public static pd.r f() {
        return u.INSTANCE;
    }

    public static pd.g g() {
        return f١٧٥٠٣d;
    }

    public static pd.q h(Object obj) {
        return new r(obj);
    }

    public static pd.o i() {
        return f١٧٥٠٠a;
    }

    public static pd.q j(Class cls) {
        return new m(cls);
    }

    public static pd.o k(Object obj) {
        return new w(obj);
    }

    public static pd.r l(Object obj) {
        return new w(obj);
    }

    public static pd.o m(Comparator comparator) {
        return new x(comparator);
    }

    public static Comparator n() {
        return z.INSTANCE;
    }

    public static pd.a o(pd.g gVar) {
        return new a0(gVar);
    }

    public static pd.g p(pd.g gVar) {
        return new b0(gVar);
    }

    public static pd.g q(pd.g gVar) {
        return new c0(gVar);
    }

    public static pd.r r() {
        return f١٧٥٠٩j;
    }

    public static pd.q s(pd.e eVar) {
        return new k(eVar);
    }

    public static pd.o t(TimeUnit timeUnit, io.reactivex.rxjava3.core.h0 h0Var) {
        return new f0(timeUnit, h0Var);
    }

    public static pd.o u(pd.c cVar) {
        return new b(cVar);
    }

    public static pd.o v(pd.h hVar) {
        return new c(hVar);
    }

    public static pd.o w(pd.i iVar) {
        return new d(iVar);
    }

    public static pd.o x(pd.j jVar) {
        return new e(jVar);
    }

    public static pd.o y(pd.k kVar) {
        return new f(kVar);
    }

    public static pd.o z(pd.l lVar) {
        return new g(lVar);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class n implements pd.a {
        n() {
        }

        public String toString() {
            return "EmptyAction";
        }

        @Override // pd.a
        public void run() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class q implements Runnable {
        q() {
        }

        public String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class o implements pd.g {
        o() {
        }

        public String toString() {
            return "EmptyConsumer";
        }

        @Override // pd.g
        public void accept(Object obj) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class v implements pd.o {
        v() {
        }

        public String toString() {
            return "IdentityFunction";
        }

        @Override // pd.o
        public Object apply(Object obj) {
            return obj;
        }
    }
}
