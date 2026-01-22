package androidx.coordinatorlayout.widget;

import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Pools.Pool f٢٥٧٩a = new Pools.SimplePool(10);

    /* renamed from: b, reason: collision with root package name */
    private final SimpleArrayMap f٢٥٨٠b = new SimpleArrayMap();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f٢٥٨١c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final HashSet f٢٥٨٢d = new HashSet();

    private void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (!hashSet.contains(obj)) {
            hashSet.add(obj);
            ArrayList arrayList2 = (ArrayList) this.f٢٥٨٠b.get(obj);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    e(arrayList2.get(i10), arrayList, hashSet);
                }
            }
            hashSet.remove(obj);
            arrayList.add(obj);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }

    private ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f٢٥٧٩a.acquire();
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private void k(ArrayList arrayList) {
        arrayList.clear();
        this.f٢٥٧٩a.release(arrayList);
    }

    public void a(Object obj, Object obj2) {
        if (this.f٢٥٨٠b.containsKey(obj) && this.f٢٥٨٠b.containsKey(obj2)) {
            ArrayList arrayList = (ArrayList) this.f٢٥٨٠b.get(obj);
            if (arrayList == null) {
                arrayList = f();
                this.f٢٥٨٠b.put(obj, arrayList);
            }
            arrayList.add(obj2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public void b(Object obj) {
        if (!this.f٢٥٨٠b.containsKey(obj)) {
            this.f٢٥٨٠b.put(obj, null);
        }
    }

    public void c() {
        int size = this.f٢٥٨٠b.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList = (ArrayList) this.f٢٥٨٠b.valueAt(i10);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.f٢٥٨٠b.clear();
    }

    public boolean d(Object obj) {
        return this.f٢٥٨٠b.containsKey(obj);
    }

    public List g(Object obj) {
        return (List) this.f٢٥٨٠b.get(obj);
    }

    public List h(Object obj) {
        int size = this.f٢٥٨٠b.getSize();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList2 = (ArrayList) this.f٢٥٨٠b.valueAt(i10);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f٢٥٨٠b.keyAt(i10));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.f٢٥٨١c.clear();
        this.f٢٥٨٢d.clear();
        int size = this.f٢٥٨٠b.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f٢٥٨٠b.keyAt(i10), this.f٢٥٨١c, this.f٢٥٨٢d);
        }
        return this.f٢٥٨١c;
    }

    public boolean j(Object obj) {
        int size = this.f٢٥٨٠b.getSize();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList = (ArrayList) this.f٢٥٨٠b.valueAt(i10);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }
}
