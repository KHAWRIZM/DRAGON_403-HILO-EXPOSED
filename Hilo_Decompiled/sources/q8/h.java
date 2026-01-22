package q8;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h extends AbstractMap implements Serializable {

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator f١٧٢١٢i = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Comparator f١٧٢١٣a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f١٧٢١٤b;

    /* renamed from: c, reason: collision with root package name */
    e f١٧٢١٥c;

    /* renamed from: d, reason: collision with root package name */
    int f١٧٢١٦d;

    /* renamed from: e, reason: collision with root package name */
    int f١٧٢١٧e;

    /* renamed from: f, reason: collision with root package name */
    final e f١٧٢١٨f;

    /* renamed from: g, reason: collision with root package name */
    private b f١٧٢١٩g;

    /* renamed from: h, reason: collision with root package name */
    private c f١٧٢٢٠h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b extends AbstractSet {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && h.this.e((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e e10;
            if (!(obj instanceof Map.Entry) || (e10 = h.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.h(e10, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f١٧٢١٦d;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    final class c extends AbstractSet {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a extends d {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public Object next() {
                return a().f١٧٢٣٤f;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (h.this.i(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f١٧٢١٦d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public abstract class d implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        e f١٧٢٢٥a;

        /* renamed from: b, reason: collision with root package name */
        e f١٧٢٢٦b = null;

        /* renamed from: c, reason: collision with root package name */
        int f١٧٢٢٧c;

        d() {
            this.f١٧٢٢٥a = h.this.f١٧٢١٨f.f١٧٢٣٢d;
            this.f١٧٢٢٧c = h.this.f١٧٢١٧e;
        }

        final e a() {
            e eVar = this.f١٧٢٢٥a;
            h hVar = h.this;
            if (eVar != hVar.f١٧٢١٨f) {
                if (hVar.f١٧٢١٧e == this.f١٧٢٢٧c) {
                    this.f١٧٢٢٥a = eVar.f١٧٢٣٢d;
                    this.f١٧٢٢٦b = eVar;
                    return eVar;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f١٧٢٢٥a != h.this.f١٧٢١٨f) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e eVar = this.f١٧٢٢٦b;
            if (eVar != null) {
                h.this.h(eVar, true);
                this.f١٧٢٢٦b = null;
                this.f١٧٢٢٧c = h.this.f١٧٢١٧e;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public h() {
        this(f١٧٢١٢i, true);
    }

    private boolean c(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private void g(e eVar, boolean z10) {
        int i10;
        int i11;
        int i12;
        int i13;
        while (eVar != null) {
            e eVar2 = eVar.f١٧٢٣٠b;
            e eVar3 = eVar.f١٧٢٣١c;
            int i14 = 0;
            if (eVar2 != null) {
                i10 = eVar2.f١٧٢٣٧i;
            } else {
                i10 = 0;
            }
            if (eVar3 != null) {
                i11 = eVar3.f١٧٢٣٧i;
            } else {
                i11 = 0;
            }
            int i15 = i10 - i11;
            if (i15 == -2) {
                e eVar4 = eVar3.f١٧٢٣٠b;
                e eVar5 = eVar3.f١٧٢٣١c;
                if (eVar5 != null) {
                    i13 = eVar5.f١٧٢٣٧i;
                } else {
                    i13 = 0;
                }
                if (eVar4 != null) {
                    i14 = eVar4.f١٧٢٣٧i;
                }
                int i16 = i14 - i13;
                if (i16 != -1 && (i16 != 0 || z10)) {
                    l(eVar3);
                    k(eVar);
                } else {
                    k(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 2) {
                e eVar6 = eVar2.f١٧٢٣٠b;
                e eVar7 = eVar2.f١٧٢٣١c;
                if (eVar7 != null) {
                    i12 = eVar7.f١٧٢٣٧i;
                } else {
                    i12 = 0;
                }
                if (eVar6 != null) {
                    i14 = eVar6.f١٧٢٣٧i;
                }
                int i17 = i14 - i12;
                if (i17 != 1 && (i17 != 0 || z10)) {
                    k(eVar2);
                    l(eVar);
                } else {
                    l(eVar);
                }
                if (z10) {
                    return;
                }
            } else if (i15 == 0) {
                eVar.f١٧٢٣٧i = i10 + 1;
                if (z10) {
                    return;
                }
            } else {
                eVar.f١٧٢٣٧i = Math.max(i10, i11) + 1;
                if (!z10) {
                    return;
                }
            }
            eVar = eVar.f١٧٢٢٩a;
        }
    }

    private void j(e eVar, e eVar2) {
        e eVar3 = eVar.f١٧٢٢٩a;
        eVar.f١٧٢٢٩a = null;
        if (eVar2 != null) {
            eVar2.f١٧٢٢٩a = eVar3;
        }
        if (eVar3 != null) {
            if (eVar3.f١٧٢٣٠b == eVar) {
                eVar3.f١٧٢٣٠b = eVar2;
                return;
            } else {
                eVar3.f١٧٢٣١c = eVar2;
                return;
            }
        }
        this.f١٧٢١٥c = eVar2;
    }

    private void k(e eVar) {
        int i10;
        int i11;
        e eVar2 = eVar.f١٧٢٣٠b;
        e eVar3 = eVar.f١٧٢٣١c;
        e eVar4 = eVar3.f١٧٢٣٠b;
        e eVar5 = eVar3.f١٧٢٣١c;
        eVar.f١٧٢٣١c = eVar4;
        if (eVar4 != null) {
            eVar4.f١٧٢٢٩a = eVar;
        }
        j(eVar, eVar3);
        eVar3.f١٧٢٣٠b = eVar;
        eVar.f١٧٢٢٩a = eVar3;
        int i12 = 0;
        if (eVar2 != null) {
            i10 = eVar2.f١٧٢٣٧i;
        } else {
            i10 = 0;
        }
        if (eVar4 != null) {
            i11 = eVar4.f١٧٢٣٧i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f١٧٢٣٧i = max;
        if (eVar5 != null) {
            i12 = eVar5.f١٧٢٣٧i;
        }
        eVar3.f١٧٢٣٧i = Math.max(max, i12) + 1;
    }

    private void l(e eVar) {
        int i10;
        int i11;
        e eVar2 = eVar.f١٧٢٣٠b;
        e eVar3 = eVar.f١٧٢٣١c;
        e eVar4 = eVar2.f١٧٢٣٠b;
        e eVar5 = eVar2.f١٧٢٣١c;
        eVar.f١٧٢٣٠b = eVar5;
        if (eVar5 != null) {
            eVar5.f١٧٢٢٩a = eVar;
        }
        j(eVar, eVar2);
        eVar2.f١٧٢٣١c = eVar;
        eVar.f١٧٢٢٩a = eVar2;
        int i12 = 0;
        if (eVar3 != null) {
            i10 = eVar3.f١٧٢٣٧i;
        } else {
            i10 = 0;
        }
        if (eVar5 != null) {
            i11 = eVar5.f١٧٢٣٧i;
        } else {
            i11 = 0;
        }
        int max = Math.max(i10, i11) + 1;
        eVar.f١٧٢٣٧i = max;
        if (eVar4 != null) {
            i12 = eVar4.f١٧٢٣٧i;
        }
        eVar2.f١٧٢٣٧i = Math.max(max, i12) + 1;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f١٧٢١٥c = null;
        this.f١٧٢١٦d = 0;
        this.f١٧٢١٧e++;
        e eVar = this.f١٧٢١٨f;
        eVar.f١٧٢٣٣e = eVar;
        eVar.f١٧٢٣٢d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (f(obj) != null) {
            return true;
        }
        return false;
    }

    e d(Object obj, boolean z10) {
        int i10;
        e eVar;
        Comparable comparable;
        e eVar2;
        Comparator comparator = this.f١٧٢١٣a;
        e eVar3 = this.f١٧٢١٥c;
        if (eVar3 != null) {
            if (comparator == f١٧٢١٢i) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i10 = comparable.compareTo(eVar3.f١٧٢٣٤f);
                } else {
                    i10 = comparator.compare(obj, eVar3.f١٧٢٣٤f);
                }
                if (i10 == 0) {
                    return eVar3;
                }
                if (i10 < 0) {
                    eVar2 = eVar3.f١٧٢٣٠b;
                } else {
                    eVar2 = eVar3.f١٧٢٣١c;
                }
                if (eVar2 == null) {
                    break;
                }
                eVar3 = eVar2;
            }
        } else {
            i10 = 0;
        }
        if (!z10) {
            return null;
        }
        e eVar4 = this.f١٧٢١٨f;
        if (eVar3 == null) {
            if (comparator == f١٧٢١٢i && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName() + " is not Comparable");
            }
            eVar = new e(this.f١٧٢١٤b, eVar3, obj, eVar4, eVar4.f١٧٢٣٣e);
            this.f١٧٢١٥c = eVar;
        } else {
            eVar = new e(this.f١٧٢١٤b, eVar3, obj, eVar4, eVar4.f١٧٢٣٣e);
            if (i10 < 0) {
                eVar3.f١٧٢٣٠b = eVar;
            } else {
                eVar3.f١٧٢٣١c = eVar;
            }
            g(eVar3, true);
        }
        this.f١٧٢١٦d++;
        this.f١٧٢١٧e++;
        return eVar;
    }

    e e(Map.Entry entry) {
        e f10 = f(entry.getKey());
        if (f10 == null || !c(f10.f١٧٢٣٦h, entry.getValue())) {
            return null;
        }
        return f10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        b bVar = this.f١٧٢١٩g;
        if (bVar == null) {
            b bVar2 = new b();
            this.f١٧٢١٩g = bVar2;
            return bVar2;
        }
        return bVar;
    }

    e f(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        e f10 = f(obj);
        if (f10 != null) {
            return f10.f١٧٢٣٦h;
        }
        return null;
    }

    void h(e eVar, boolean z10) {
        e a10;
        int i10;
        if (z10) {
            e eVar2 = eVar.f١٧٢٣٣e;
            eVar2.f١٧٢٣٢d = eVar.f١٧٢٣٢d;
            eVar.f١٧٢٣٢d.f١٧٢٣٣e = eVar2;
        }
        e eVar3 = eVar.f١٧٢٣٠b;
        e eVar4 = eVar.f١٧٢٣١c;
        e eVar5 = eVar.f١٧٢٢٩a;
        int i11 = 0;
        if (eVar3 != null && eVar4 != null) {
            if (eVar3.f١٧٢٣٧i > eVar4.f١٧٢٣٧i) {
                a10 = eVar3.b();
            } else {
                a10 = eVar4.a();
            }
            h(a10, false);
            e eVar6 = eVar.f١٧٢٣٠b;
            if (eVar6 != null) {
                i10 = eVar6.f١٧٢٣٧i;
                a10.f١٧٢٣٠b = eVar6;
                eVar6.f١٧٢٢٩a = a10;
                eVar.f١٧٢٣٠b = null;
            } else {
                i10 = 0;
            }
            e eVar7 = eVar.f١٧٢٣١c;
            if (eVar7 != null) {
                i11 = eVar7.f١٧٢٣٧i;
                a10.f١٧٢٣١c = eVar7;
                eVar7.f١٧٢٢٩a = a10;
                eVar.f١٧٢٣١c = null;
            }
            a10.f١٧٢٣٧i = Math.max(i10, i11) + 1;
            j(eVar, a10);
            return;
        }
        if (eVar3 != null) {
            j(eVar, eVar3);
            eVar.f١٧٢٣٠b = null;
        } else if (eVar4 != null) {
            j(eVar, eVar4);
            eVar.f١٧٢٣١c = null;
        } else {
            j(eVar, null);
        }
        g(eVar5, false);
        this.f١٧٢١٦d--;
        this.f١٧٢١٧e++;
    }

    e i(Object obj) {
        e f10 = f(obj);
        if (f10 != null) {
            h(f10, true);
        }
        return f10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        c cVar = this.f١٧٢٢٠h;
        if (cVar == null) {
            c cVar2 = new c();
            this.f١٧٢٢٠h = cVar2;
            return cVar2;
        }
        return cVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        if (obj != null) {
            if (obj2 == null && !this.f١٧٢١٤b) {
                throw new NullPointerException("value == null");
            }
            e d10 = d(obj, true);
            Object obj3 = d10.f١٧٢٣٦h;
            d10.f١٧٢٣٦h = obj2;
            return obj3;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        e i10 = i(obj);
        if (i10 != null) {
            return i10.f١٧٢٣٦h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f١٧٢١٦d;
    }

    public h(boolean z10) {
        this(f١٧٢١٢i, z10);
    }

    public h(Comparator comparator, boolean z10) {
        this.f١٧٢١٦d = 0;
        this.f١٧٢١٧e = 0;
        this.f١٧٢١٣a = comparator == null ? f١٧٢١٢i : comparator;
        this.f١٧٢١٤b = z10;
        this.f١٧٢١٨f = new e(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class e implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        e f١٧٢٢٩a;

        /* renamed from: b, reason: collision with root package name */
        e f١٧٢٣٠b;

        /* renamed from: c, reason: collision with root package name */
        e f١٧٢٣١c;

        /* renamed from: d, reason: collision with root package name */
        e f١٧٢٣٢d;

        /* renamed from: e, reason: collision with root package name */
        e f١٧٢٣٣e;

        /* renamed from: f, reason: collision with root package name */
        final Object f١٧٢٣٤f;

        /* renamed from: g, reason: collision with root package name */
        final boolean f١٧٢٣٥g;

        /* renamed from: h, reason: collision with root package name */
        Object f١٧٢٣٦h;

        /* renamed from: i, reason: collision with root package name */
        int f١٧٢٣٧i;

        e(boolean z10) {
            this.f١٧٢٣٤f = null;
            this.f١٧٢٣٥g = z10;
            this.f١٧٢٣٣e = this;
            this.f١٧٢٣٢d = this;
        }

        public e a() {
            e eVar = this;
            for (e eVar2 = this.f١٧٢٣٠b; eVar2 != null; eVar2 = eVar2.f١٧٢٣٠b) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e b() {
            e eVar = this;
            for (e eVar2 = this.f١٧٢٣١c; eVar2 != null; eVar2 = eVar2.f١٧٢٣١c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = this.f١٧٢٣٤f;
            if (obj2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!obj2.equals(entry.getKey())) {
                return false;
            }
            Object obj3 = this.f١٧٢٣٦h;
            if (obj3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!obj3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f١٧٢٣٤f;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f١٧٢٣٦h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            Object obj = this.f١٧٢٣٤f;
            int i10 = 0;
            if (obj == null) {
                hashCode = 0;
            } else {
                hashCode = obj.hashCode();
            }
            Object obj2 = this.f١٧٢٣٦h;
            if (obj2 != null) {
                i10 = obj2.hashCode();
            }
            return hashCode ^ i10;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj == null && !this.f١٧٢٣٥g) {
                throw new NullPointerException("value == null");
            }
            Object obj2 = this.f١٧٢٣٦h;
            this.f١٧٢٣٦h = obj;
            return obj2;
        }

        public String toString() {
            return this.f١٧٢٣٤f + "=" + this.f١٧٢٣٦h;
        }

        e(boolean z10, e eVar, Object obj, e eVar2, e eVar3) {
            this.f١٧٢٢٩a = eVar;
            this.f١٧٢٣٤f = obj;
            this.f١٧٢٣٥g = z10;
            this.f١٧٢٣٧i = 1;
            this.f١٧٢٣٢d = eVar2;
            this.f١٧٢٣٣e = eVar3;
            eVar3.f١٧٢٣٢d = this;
            eVar2.f١٧٢٣٣e = this;
        }
    }
}
