package w;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f١٨٦٣٢a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f١٨٦٣٣b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f١٨٦٣٤c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f١٨٦٣٥d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f١٨٦٣٦e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicInteger f١٨٦٣٧f;

    /* renamed from: g, reason: collision with root package name */
    public volatile ThreadPoolExecutor f١٨٦٣٨g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicInteger f١٨٦٣٩h;

    /* renamed from: i, reason: collision with root package name */
    public r0.d f١٨٦٤٠i;

    public a() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        this.f١٨٦٣٢a = 5;
        this.f١٨٦٣٧f = new AtomicInteger();
        this.f١٨٦٣٩h = new AtomicInteger();
        this.f١٨٦٣٣b = arrayList;
        this.f١٨٦٣٤c = arrayList2;
        this.f١٨٦٣٥d = arrayList3;
        this.f١٨٦٣٦e = arrayList4;
    }

    public final synchronized ExecutorService a() {
        try {
            if (this.f١٨٦٣٨g == null) {
                this.f١٨٦٣٨g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new l0.b("OkDownload Download"));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f١٨٦٣٨g;
    }

    public final synchronized void b(ArrayList arrayList, ArrayList arrayList2) {
        try {
            arrayList2.size();
            int i10 = 0;
            if (!arrayList2.isEmpty()) {
                int size = arrayList2.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList2.get(i11);
                    i11++;
                    x.j jVar = (x.j) obj;
                    if (!jVar.e()) {
                        arrayList.remove(jVar);
                    }
                }
            }
            arrayList.size();
            if (!arrayList.isEmpty()) {
                if (arrayList.size() <= 1) {
                    n0.f.a().f١٦١٣٨b.f١٨٦٦٣a.d(((x.j) arrayList.get(0)).f١٨٨٥٩b, 3, null);
                    return;
                }
                ArrayList arrayList3 = new ArrayList();
                int size2 = arrayList.size();
                while (i10 < size2) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList3.add(((x.j) obj2).f١٨٨٥٩b);
                }
                o oVar = n0.f.a().f١٦١٣٨b;
                if (arrayList3.size() > 0) {
                    arrayList3.size();
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        n0.e eVar = (n0.e) it.next();
                        if (!eVar.f١٦١٢٥n) {
                            eVar.f١٦١٢٧p.i(eVar, 3, null);
                            it.remove();
                        }
                    }
                    oVar.f١٨٦٦٤b.post(new e(arrayList3));
                }
            }
        } finally {
        }
    }

    public final synchronized void c(n0.e eVar) {
        x.j jVar = new x.j(eVar, this.f١٨٦٤٠i);
        if (this.f١٨٦٣٤c.size() - this.f١٨٦٣٧f.get() < this.f١٨٦٣٢a) {
            this.f١٨٦٣٤c.add(jVar);
            ((ThreadPoolExecutor) a()).execute(jVar);
        } else {
            this.f١٨٦٣٣b.add(jVar);
        }
    }

    public final synchronized void d(n0.e eVar, ArrayList arrayList, ArrayList arrayList2) {
        try {
            Iterator it = this.f١٨٦٣٣b.iterator();
            while (it.hasNext()) {
                x.j jVar = (x.j) it.next();
                n0.e eVar2 = jVar.f١٨٨٥٩b;
                if (eVar2 != eVar && eVar2.f١٦١١٣b != eVar.f١٦١١٣b) {
                }
                if (!jVar.f١٨٨٦٣f && !jVar.f١٨٨٦٤g) {
                    it.remove();
                    arrayList.add(jVar);
                    return;
                }
            }
            ArrayList arrayList3 = this.f١٨٦٣٤c;
            int size = arrayList3.size();
            int i10 = 0;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList3.get(i11);
                i11++;
                x.j jVar2 = (x.j) obj;
                n0.e eVar3 = jVar2.f١٨٨٥٩b;
                if (eVar3 == eVar || eVar3.f١٦١١٣b == eVar.f١٦١١٣b) {
                    arrayList.add(jVar2);
                    arrayList2.add(jVar2);
                    return;
                }
            }
            ArrayList arrayList4 = this.f١٨٦٣٥d;
            int size2 = arrayList4.size();
            while (i10 < size2) {
                Object obj2 = arrayList4.get(i10);
                i10++;
                x.j jVar3 = (x.j) obj2;
                n0.e eVar4 = jVar3.f١٨٨٥٩b;
                if (eVar4 == eVar || eVar4.f١٦١١٣b == eVar.f١٦١١٣b) {
                    arrayList.add(jVar3);
                    arrayList2.add(jVar3);
                    return;
                }
            }
        } finally {
        }
    }

    public final synchronized void e(x.j jVar) {
        int i10 = jVar.f١٨٨٥٩b.f١٦١١٣b;
        if (jVar.f١٨٨٦٠c) {
            this.f١٨٦٣٧f.incrementAndGet();
        }
    }

    public final synchronized boolean f(int i10) {
        ArrayList arrayList = this.f١٨٦٣٣b;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            if (i10 == ((x.j) obj).f١٨٨٥٩b.f١٦١١٣b) {
                return true;
            }
        }
        ArrayList arrayList2 = this.f١٨٦٣٤c;
        int size2 = arrayList2.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList2.get(i12);
            i12++;
            if (i10 == ((x.j) obj2).f١٨٨٥٩b.f١٦١١٣b) {
                return true;
            }
        }
        ArrayList arrayList3 = this.f١٨٦٣٥d;
        int size3 = arrayList3.size();
        int i13 = 0;
        while (i13 < size3) {
            Object obj3 = arrayList3.get(i13);
            i13++;
            if (i10 == ((x.j) obj3).f١٨٨٥٩b.f١٦١١٣b) {
                return true;
            }
        }
        return false;
    }

    public final boolean g(n0.e eVar, Collection collection) {
        o oVar = n0.f.a().f١٦١٣٨b;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            x.j jVar = (x.j) it.next();
            if (!jVar.f١٨٨٦٣f) {
                if (jVar.f١٨٨٥٩b.equals(eVar)) {
                    if (jVar.f١٨٨٦٤g) {
                        int i10 = eVar.f١٦١١٣b;
                        this.f١٨٦٣٦e.add(jVar);
                        it.remove();
                        return false;
                    }
                    oVar.f١٨٦٦٣a.d(eVar, 5, null);
                    return true;
                }
                File h10 = jVar.f١٨٨٥٩b.h();
                File h11 = eVar.h();
                if (h10 != null && h11 != null && h10.equals(h11)) {
                    oVar.f١٨٦٦٣a.d(eVar, 4, null);
                    return true;
                }
            }
        }
        return false;
    }

    public final synchronized void h() {
        try {
            if (this.f١٨٦٣٩h.get() <= 0 && this.f١٨٦٣٤c.size() - this.f١٨٦٣٧f.get() < this.f١٨٦٣٢a && !this.f١٨٦٣٣b.isEmpty()) {
                Iterator it = this.f١٨٦٣٣b.iterator();
                while (it.hasNext()) {
                    x.j jVar = (x.j) it.next();
                    it.remove();
                    n0.e eVar = jVar.f١٨٨٥٩b;
                    if (i(eVar)) {
                        n0.f.a().f١٦١٣٨b.f١٨٦٦٣a.d(eVar, 4, null);
                    } else {
                        this.f١٨٦٣٤c.add(jVar);
                        ((ThreadPoolExecutor) a()).execute(jVar);
                        if (this.f١٨٦٣٤c.size() - this.f١٨٦٣٧f.get() >= this.f١٨٦٣٢a) {
                            break;
                        }
                    }
                }
            }
        } finally {
        }
    }

    public final synchronized boolean i(n0.e eVar) {
        n0.e eVar2;
        File h10;
        n0.e eVar3;
        File h11;
        int i10 = eVar.f١٦١١٣b;
        File h12 = eVar.h();
        if (h12 == null) {
            return false;
        }
        ArrayList arrayList = this.f١٨٦٣٥d;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            x.j jVar = (x.j) obj;
            if (!jVar.f١٨٨٦٣f && (eVar3 = jVar.f١٨٨٥٩b) != eVar && (h11 = eVar3.h()) != null && h12.equals(h11)) {
                return true;
            }
        }
        ArrayList arrayList2 = this.f١٨٦٣٤c;
        int size2 = arrayList2.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList2.get(i12);
            i12++;
            x.j jVar2 = (x.j) obj2;
            if (!jVar2.f١٨٨٦٣f && (eVar2 = jVar2.f١٨٨٥٩b) != eVar && (h10 = eVar2.h()) != null && h12.equals(h10)) {
                return true;
            }
        }
        return false;
    }
}
