package t4;

import androidx.core.util.Pools;
import com.bumptech.glide.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class r {

    /* renamed from: e, reason: collision with root package name */
    private static final c f١٨١٠٠e = new c();

    /* renamed from: f, reason: collision with root package name */
    private static final n f١٨١٠١f = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List f١٨١٠٢a;

    /* renamed from: b, reason: collision with root package name */
    private final c f١٨١٠٣b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f١٨١٠٤c;

    /* renamed from: d, reason: collision with root package name */
    private final Pools.Pool f١٨١٠٥d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a implements n {
        a() {
        }

        @Override // t4.n
        public n.a buildLoadData(Object obj, int i10, int i11, m4.i iVar) {
            return null;
        }

        @Override // t4.n
        public boolean handles(Object obj) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final Class f١٨١٠٦a;

        /* renamed from: b, reason: collision with root package name */
        final Class f١٨١٠٧b;

        /* renamed from: c, reason: collision with root package name */
        final o f١٨١٠٨c;

        public b(Class cls, Class cls2, o oVar) {
            this.f١٨١٠٦a = cls;
            this.f١٨١٠٧b = cls2;
            this.f١٨١٠٨c = oVar;
        }

        public boolean a(Class cls) {
            return this.f١٨١٠٦a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            if (a(cls) && this.f١٨١٠٧b.isAssignableFrom(cls2)) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class c {
        c() {
        }

        public q a(List list, Pools.Pool pool) {
            return new q(list, pool);
        }
    }

    public r(Pools.Pool pool) {
        this(pool, f١٨١٠٠e);
    }

    private void a(Class cls, Class cls2, o oVar, boolean z10) {
        int i10;
        b bVar = new b(cls, cls2, oVar);
        List list = this.f١٨١٠٢a;
        if (z10) {
            i10 = list.size();
        } else {
            i10 = 0;
        }
        list.add(i10, bVar);
    }

    private n e(b bVar) {
        return (n) f5.k.d(bVar.f١٨١٠٨c.build(this));
    }

    private static n f() {
        return f١٨١٠١f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(Class cls, Class cls2, o oVar) {
        a(cls, cls2, oVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List c(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b bVar : this.f١٨١٠٢a) {
                if (!this.f١٨١٠٤c.contains(bVar) && bVar.a(cls)) {
                    this.f١٨١٠٤c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f١٨١٠٤c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.f١٨١٠٤c.clear();
            throw th;
        }
        return arrayList;
    }

    public synchronized n d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b bVar : this.f١٨١٠٢a) {
                if (this.f١٨١٠٤c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f١٨١٠٤c.add(bVar);
                    arrayList.add(e(bVar));
                    this.f١٨١٠٤c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f١٨١٠٣b.a(arrayList, this.f١٨١٠٥d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (z10) {
                return f();
            }
            throw new g.c(cls, cls2);
        } catch (Throwable th) {
            this.f١٨١٠٤c.clear();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b bVar : this.f١٨١٠٢a) {
            if (!arrayList.contains(bVar.f١٨١٠٧b) && bVar.a(cls)) {
                arrayList.add(bVar.f١٨١٠٧b);
            }
        }
        return arrayList;
    }

    r(Pools.Pool pool, c cVar) {
        this.f١٨١٠٢a = new ArrayList();
        this.f١٨١٠٤c = new HashSet();
        this.f١٨١٠٥d = pool;
        this.f١٨١٠٣b = cVar;
    }
}
