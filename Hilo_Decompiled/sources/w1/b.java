package w1;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    c f١٨٦٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private c f١٨٦٦٨b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f١٨٦٦٩c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    private int f١٨٦٧٠d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends e {
        a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // w1.b.e
        c b(c cVar) {
            return cVar.f١٨٦٧٤d;
        }

        @Override // w1.b.e
        c c(c cVar) {
            return cVar.f١٨٦٧٣c;
        }
    }

    /* renamed from: w1.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class C٠٢٤٠b extends e {
        C٠٢٤٠b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // w1.b.e
        c b(c cVar) {
            return cVar.f١٨٦٧٣c;
        }

        @Override // w1.b.e
        c c(c cVar) {
            return cVar.f١٨٦٧٤d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٨٦٧١a;

        /* renamed from: b, reason: collision with root package name */
        final Object f١٨٦٧٢b;

        /* renamed from: c, reason: collision with root package name */
        c f١٨٦٧٣c;

        /* renamed from: d, reason: collision with root package name */
        c f١٨٦٧٤d;

        c(Object obj, Object obj2) {
            this.f١٨٦٧١a = obj;
            this.f١٨٦٧٢b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f١٨٦٧١a.equals(cVar.f١٨٦٧١a) && this.f١٨٦٧٢b.equals(cVar.f١٨٦٧٢b)) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f١٨٦٧١a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f١٨٦٧٢b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f١٨٦٧١a.hashCode() ^ this.f١٨٦٧٢b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f١٨٦٧١a + "=" + this.f١٨٦٧٢b;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        private c f١٨٦٧٥a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٨٦٧٦b = true;

        d() {
        }

        @Override // w1.b.f
        void a(c cVar) {
            boolean z10;
            c cVar2 = this.f١٨٦٧٥a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f١٨٦٧٤d;
                this.f١٨٦٧٥a = cVar3;
                if (cVar3 == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                this.f١٨٦٧٦b = z10;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar;
            if (this.f١٨٦٧٦b) {
                this.f١٨٦٧٦b = false;
                this.f١٨٦٧٥a = b.this.f١٨٦٦٧a;
            } else {
                c cVar2 = this.f١٨٦٧٥a;
                if (cVar2 != null) {
                    cVar = cVar2.f١٨٦٧٣c;
                } else {
                    cVar = null;
                }
                this.f١٨٦٧٥a = cVar;
            }
            return this.f١٨٦٧٥a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١٨٦٧٦b) {
                if (b.this.f١٨٦٦٧a == null) {
                    return false;
                }
                return true;
            }
            c cVar = this.f١٨٦٧٥a;
            if (cVar == null || cVar.f١٨٦٧٣c == null) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static abstract class e extends f implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        c f١٨٦٧٨a;

        /* renamed from: b, reason: collision with root package name */
        c f١٨٦٧٩b;

        e(c cVar, c cVar2) {
            this.f١٨٦٧٨a = cVar2;
            this.f١٨٦٧٩b = cVar;
        }

        private c e() {
            c cVar = this.f١٨٦٧٩b;
            c cVar2 = this.f١٨٦٧٨a;
            if (cVar != cVar2 && cVar2 != null) {
                return c(cVar);
            }
            return null;
        }

        @Override // w1.b.f
        public void a(c cVar) {
            if (this.f١٨٦٧٨a == cVar && cVar == this.f١٨٦٧٩b) {
                this.f١٨٦٧٩b = null;
                this.f١٨٦٧٨a = null;
            }
            c cVar2 = this.f١٨٦٧٨a;
            if (cVar2 == cVar) {
                this.f١٨٦٧٨a = b(cVar2);
            }
            if (this.f١٨٦٧٩b == cVar) {
                this.f١٨٦٧٩b = e();
            }
        }

        abstract c b(c cVar);

        abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f١٨٦٧٩b;
            this.f١٨٦٧٩b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١٨٦٧٩b != null) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class f {
        abstract void a(c cVar);
    }

    public Map.Entry d() {
        return this.f١٨٦٦٧a;
    }

    public Iterator descendingIterator() {
        C٠٢٤٠b r02 = new C٠٢٤٠b(this.f١٨٦٦٨b, this.f١٨٦٦٧a);
        this.f١٨٦٦٩c.put(r02, Boolean.FALSE);
        return r02;
    }

    protected c e(Object obj) {
        c cVar = this.f١٨٦٦٧a;
        while (cVar != null && !cVar.f١٨٦٧١a.equals(obj)) {
            cVar = cVar.f١٨٦٧٣c;
        }
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        if (!it.hasNext() && !it2.hasNext()) {
            return true;
        }
        return false;
    }

    public d f() {
        d dVar = new d();
        this.f١٨٦٦٩c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry h() {
        return this.f١٨٦٦٨b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Map.Entry) it.next()).hashCode();
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c i(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f١٨٦٧٠d++;
        c cVar2 = this.f١٨٦٦٨b;
        if (cVar2 == null) {
            this.f١٨٦٦٧a = cVar;
            this.f١٨٦٦٨b = cVar;
            return cVar;
        }
        cVar2.f١٨٦٧٣c = cVar;
        cVar.f١٨٦٧٤d = cVar2;
        this.f١٨٦٦٨b = cVar;
        return cVar;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f١٨٦٦٧a, this.f١٨٦٦٨b);
        this.f١٨٦٦٩c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Object k(Object obj, Object obj2) {
        c e10 = e(obj);
        if (e10 != null) {
            return e10.f١٨٦٧٢b;
        }
        i(obj, obj2);
        return null;
    }

    public Object l(Object obj) {
        c e10 = e(obj);
        if (e10 == null) {
            return null;
        }
        this.f١٨٦٧٠d--;
        if (!this.f١٨٦٦٩c.isEmpty()) {
            Iterator it = this.f١٨٦٦٩c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(e10);
            }
        }
        c cVar = e10.f١٨٦٧٤d;
        if (cVar != null) {
            cVar.f١٨٦٧٣c = e10.f١٨٦٧٣c;
        } else {
            this.f١٨٦٦٧a = e10.f١٨٦٧٣c;
        }
        c cVar2 = e10.f١٨٦٧٣c;
        if (cVar2 != null) {
            cVar2.f١٨٦٧٤d = cVar;
        } else {
            this.f١٨٦٦٨b = cVar;
        }
        e10.f١٨٦٧٣c = null;
        e10.f١٨٦٧٤d = null;
        return e10.f١٨٦٧٢b;
    }

    public int size() {
        return this.f١٨٦٧٠d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
