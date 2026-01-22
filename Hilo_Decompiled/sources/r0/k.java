package r0;

import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k implements d {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f١٧٣٠٢a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f١٧٣٠٣b;

    /* renamed from: c, reason: collision with root package name */
    public final f f١٧٣٠٤c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f١٧٣٠٥d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f١٧٣٠٦e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f١٧٣٠٧f;

    public k() {
        SparseArray sparseArray = new SparseArray();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        this.f١٧٣٠٥d = new SparseArray();
        this.f١٧٣٠٢a = sparseArray;
        this.f١٧٣٠٧f = arrayList;
        this.f١٧٣٠٣b = hashMap;
        this.f١٧٣٠٤c = new f();
        int size = sparseArray.size();
        this.f١٧٣٠٦e = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            this.f١٧٣٠٦e.add(Integer.valueOf(((g) sparseArray.valueAt(i10)).f١٧٢٨٢a));
        }
        Collections.sort(this.f١٧٣٠٦e);
    }

    @Override // r0.d
    public final g b(n0.e eVar) {
        int i10 = eVar.f١٦١١٣b;
        g gVar = new g(i10, eVar.f١٦١١٤c, eVar.f١٦١٣٢u, eVar.f١٦١٣٠s.f١٨٨٢٤a);
        synchronized (this) {
            this.f١٧٣٠٢a.put(i10, gVar);
            this.f١٧٣٠٥d.remove(i10);
        }
        return gVar;
    }

    @Override // r0.d
    public final boolean c(g gVar) {
        String str = gVar.f١٧٢٨٧f.f١٨٨٢٤a;
        if (gVar.f١٧٢٨٩h && str != null) {
            this.f١٧٣٠٣b.put(gVar.f١٧٢٨٣b, str);
        }
        g gVar2 = (g) this.f١٧٣٠٢a.get(gVar.f١٧٢٨٢a);
        if (gVar2 != null) {
            if (gVar2 == gVar) {
                return true;
            }
            synchronized (this) {
                this.f١٧٣٠٢a.put(gVar.f١٧٢٨٢a, gVar.a());
            }
            return true;
        }
        return false;
    }

    @Override // r0.d
    public final boolean d(int i10) {
        boolean remove;
        synchronized (this.f١٧٣٠٧f) {
            remove = this.f١٧٣٠٧f.remove(Integer.valueOf(i10));
        }
        return remove;
    }

    @Override // r0.d
    public final void e(int i10, int i11) {
        if (i11 == 1) {
            remove(i10);
        }
    }

    @Override // r0.d
    public final boolean f(int i10) {
        if (!this.f١٧٣٠٧f.contains(Integer.valueOf(i10))) {
            synchronized (this.f١٧٣٠٧f) {
                try {
                    if (!this.f١٧٣٠٧f.contains(Integer.valueOf(i10))) {
                        this.f١٧٣٠٧f.add(Integer.valueOf(i10));
                        return true;
                    }
                    return false;
                } finally {
                }
            }
        }
        return false;
    }

    @Override // r0.d
    public final void g(g gVar, int i10, long j10) {
        g gVar2 = (g) this.f١٧٣٠٢a.get(gVar.f١٧٢٨٢a);
        if (gVar == gVar2) {
            ((e) gVar2.f١٧٢٨٨g.get(i10)).f١٧٢٧٩c.addAndGet(j10);
            return;
        }
        throw new IOException("Info not on store!");
    }

    @Override // r0.d
    public final g get(int i10) {
        return (g) this.f١٧٣٠٢a.get(i10);
    }

    public final g h(n0.e eVar, g gVar) {
        SparseArray clone;
        synchronized (this) {
            clone = this.f١٧٣٠٢a.clone();
        }
        int size = clone.size();
        for (int i10 = 0; i10 < size; i10++) {
            g gVar2 = (g) clone.valueAt(i10);
            if (gVar2 != gVar && gVar2.b(eVar)) {
                return gVar2;
            }
        }
        return null;
    }

    public final synchronized int i() {
        int nextInt;
        Random random = new Random();
        while (true) {
            nextInt = random.nextInt(Integer.MAX_VALUE) + 1;
            if (!this.f١٧٣٠٦e.contains(Integer.valueOf(nextInt)) && !n0.f.a().f١٦١٣٧a.f(nextInt)) {
                this.f١٧٣٠٦e.add(Integer.valueOf(nextInt));
            }
        }
        return nextInt;
    }

    @Override // r0.d
    public final synchronized void remove(int i10) {
        try {
            this.f١٧٣٠٢a.remove(i10);
            if (this.f١٧٣٠٥d.get(i10) == null) {
                this.f١٧٣٠٦e.remove(Integer.valueOf(i10));
            }
            f fVar = this.f١٧٣٠٤c;
            String str = (String) fVar.f١٧٢٨١b.get(i10);
            if (str != null) {
                fVar.f١٧٢٨٠a.remove(str);
                fVar.f١٧٢٨١b.remove(i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // r0.d
    public final void a() {
    }
}
