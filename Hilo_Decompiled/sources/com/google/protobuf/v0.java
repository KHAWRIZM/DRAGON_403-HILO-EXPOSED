package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class v0 implements k1 {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f١١٩٧٤a;

    /* renamed from: b, reason: collision with root package name */
    private volatile d f١١٩٧٥b;

    /* renamed from: c, reason: collision with root package name */
    private c f١١٩٧٦c;

    /* renamed from: d, reason: collision with root package name */
    private List f١١٩٧٧d;

    /* renamed from: e, reason: collision with root package name */
    private final a f١١٩٧٨e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface a {
        b1 a(Object obj, Object obj2);

        b1 b();

        void c(b1 b1Var, Map map);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class b implements a {
        public b(t0 t0Var) {
        }

        @Override // com.google.protobuf.v0.a
        public b1 a(Object obj, Object obj2) {
            throw null;
        }

        @Override // com.google.protobuf.v0.a
        public b1 b() {
            return null;
        }

        @Override // com.google.protobuf.v0.a
        public void c(b1 b1Var, Map map) {
            androidx.appcompat.app.a0.a(b1Var);
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements Map {

        /* renamed from: a, reason: collision with root package name */
        private final k1 f١١٩٧٩a;

        /* renamed from: b, reason: collision with root package name */
        private final Map f١١٩٨٠b;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static class a implements Collection {

            /* renamed from: a, reason: collision with root package name */
            private final k1 f١١٩٨١a;

            /* renamed from: b, reason: collision with root package name */
            private final Collection f١١٩٨٢b;

            a(k1 k1Var, Collection collection) {
                this.f١١٩٨١a = k1Var;
                this.f١١٩٨٢b = collection;
            }

            @Override // java.util.Collection
            public boolean add(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public void clear() {
                this.f١١٩٨١a.a();
                this.f١١٩٨٢b.clear();
            }

            @Override // java.util.Collection
            public boolean contains(Object obj) {
                return this.f١١٩٨٢b.contains(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection collection) {
                return this.f١١٩٨٢b.containsAll(collection);
            }

            @Override // java.util.Collection
            public boolean equals(Object obj) {
                return this.f١١٩٨٢b.equals(obj);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.f١١٩٨٢b.hashCode();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.f١١٩٨٢b.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return new b(this.f١١٩٨١a, this.f١١٩٨٢b.iterator());
            }

            @Override // java.util.Collection
            public boolean remove(Object obj) {
                this.f١١٩٨١a.a();
                return this.f١١٩٨٢b.remove(obj);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection collection) {
                this.f١١٩٨١a.a();
                return this.f١١٩٨٢b.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection collection) {
                this.f١١٩٨١a.a();
                return this.f١١٩٨٢b.retainAll(collection);
            }

            @Override // java.util.Collection
            public int size() {
                return this.f١١٩٨٢b.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.f١١٩٨٢b.toArray();
            }

            public String toString() {
                return this.f١١٩٨٢b.toString();
            }

            @Override // java.util.Collection
            public Object[] toArray(Object[] objArr) {
                return this.f١١٩٨٢b.toArray(objArr);
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        private static class b implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            private final k1 f١١٩٨٣a;

            /* renamed from: b, reason: collision with root package name */
            private final Iterator f١١٩٨٤b;

            b(k1 k1Var, Iterator it) {
                this.f١١٩٨٣a = k1Var;
                this.f١١٩٨٤b = it;
            }

            public boolean equals(Object obj) {
                return this.f١١٩٨٤b.equals(obj);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f١١٩٨٤b.hasNext();
            }

            public int hashCode() {
                return this.f١١٩٨٤b.hashCode();
            }

            @Override // java.util.Iterator
            public Object next() {
                return this.f١١٩٨٤b.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f١١٩٨٣a.a();
                this.f١١٩٨٤b.remove();
            }

            public String toString() {
                return this.f١١٩٨٤b.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.google.protobuf.v0$c$c, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static class C٠١٤٣c implements Set {

            /* renamed from: a, reason: collision with root package name */
            private final k1 f١١٩٨٥a;

            /* renamed from: b, reason: collision with root package name */
            private final Set f١١٩٨٦b;

            C٠١٤٣c(k1 k1Var, Set set) {
                this.f١١٩٨٥a = k1Var;
                this.f١١٩٨٦b = set;
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(Object obj) {
                this.f١١٩٨٥a.a();
                return this.f١١٩٨٦b.add(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection collection) {
                this.f١١٩٨٥a.a();
                return this.f١١٩٨٦b.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.f١١٩٨٥a.a();
                this.f١١٩٨٦b.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object obj) {
                return this.f١١٩٨٦b.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection collection) {
                return this.f١١٩٨٦b.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object obj) {
                return this.f١١٩٨٦b.equals(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.f١١٩٨٦b.hashCode();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.f١١٩٨٦b.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator iterator() {
                return new b(this.f١١٩٨٥a, this.f١١٩٨٦b.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object obj) {
                this.f١١٩٨٥a.a();
                return this.f١١٩٨٦b.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection collection) {
                this.f١١٩٨٥a.a();
                return this.f١١٩٨٦b.removeAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection collection) {
                this.f١١٩٨٥a.a();
                return this.f١١٩٨٦b.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.f١١٩٨٦b.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.f١١٩٨٦b.toArray();
            }

            public String toString() {
                return this.f١١٩٨٦b.toString();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray(Object[] objArr) {
                return this.f١١٩٨٦b.toArray(objArr);
            }
        }

        c(k1 k1Var, Map map) {
            this.f١١٩٧٩a = k1Var;
            this.f١١٩٨٠b = map;
        }

        @Override // java.util.Map
        public void clear() {
            this.f١١٩٧٩a.a();
            this.f١١٩٨٠b.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.f١١٩٨٠b.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.f١١٩٨٠b.containsValue(obj);
        }

        @Override // java.util.Map
        public Set entrySet() {
            return new C٠١٤٣c(this.f١١٩٧٩a, this.f١١٩٨٠b.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.f١١٩٨٠b.equals(obj);
        }

        @Override // java.util.Map
        public Object get(Object obj) {
            return this.f١١٩٨٠b.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.f١١٩٨٠b.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f١١٩٨٠b.isEmpty();
        }

        @Override // java.util.Map
        public Set keySet() {
            return new C٠١٤٣c(this.f١١٩٧٩a, this.f١١٩٨٠b.keySet());
        }

        @Override // java.util.Map
        public Object put(Object obj, Object obj2) {
            this.f١١٩٧٩a.a();
            j0.a(obj);
            j0.a(obj2);
            return this.f١١٩٨٠b.put(obj, obj2);
        }

        @Override // java.util.Map
        public void putAll(Map map) {
            this.f١١٩٧٩a.a();
            for (Object obj : map.keySet()) {
                j0.a(obj);
                j0.a(map.get(obj));
            }
            this.f١١٩٨٠b.putAll(map);
        }

        @Override // java.util.Map
        public Object remove(Object obj) {
            this.f١١٩٧٩a.a();
            return this.f١١٩٨٠b.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.f١١٩٨٠b.size();
        }

        public String toString() {
            return this.f١١٩٨٠b.toString();
        }

        @Override // java.util.Map
        public Collection values() {
            return new a(this.f١١٩٧٩a, this.f١١٩٨٠b.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum d {
        MAP,
        LIST,
        BOTH
    }

    private v0(a aVar, d dVar, Map map) {
        this.f١١٩٧٨e = aVar;
        this.f١١٩٧٤a = true;
        this.f١١٩٧٥b = dVar;
        this.f١١٩٧٦c = new c(this, map);
        this.f١١٩٧٧d = null;
    }

    private b1 b(Object obj, Object obj2) {
        return this.f١١٩٧٨e.a(obj, obj2);
    }

    private c c(List list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e((b1) it.next(), linkedHashMap);
        }
        return new c(this, linkedHashMap);
    }

    private List d(c cVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : cVar.entrySet()) {
            arrayList.add(b(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private void e(b1 b1Var, Map map) {
        this.f١١٩٧٨e.c(b1Var, map);
    }

    public static v0 o(t0 t0Var) {
        return new v0(t0Var, d.MAP, new LinkedHashMap());
    }

    @Override // com.google.protobuf.k1
    public void a() {
        if (l()) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof v0)) {
            return false;
        }
        return w0.k(h(), ((v0) obj).h());
    }

    public v0 f() {
        return new v0(this.f١١٩٧٨e, d.MAP, w0.g(h()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List g() {
        d dVar = this.f١١٩٧٥b;
        d dVar2 = d.MAP;
        if (dVar == dVar2) {
            synchronized (this) {
                try {
                    if (this.f١١٩٧٥b == dVar2) {
                        this.f١١٩٧٧d = d(this.f١١٩٧٦c);
                        this.f١١٩٧٥b = d.BOTH;
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableList(this.f١١٩٧٧d);
    }

    public Map h() {
        d dVar = this.f١١٩٧٥b;
        d dVar2 = d.LIST;
        if (dVar == dVar2) {
            synchronized (this) {
                try {
                    if (this.f١١٩٧٥b == dVar2) {
                        this.f١١٩٧٦c = c(this.f١١٩٧٧d);
                        this.f١١٩٧٥b = d.BOTH;
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableMap(this.f١١٩٧٦c);
    }

    public int hashCode() {
        return w0.c(h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1 i() {
        return this.f١١٩٧٨e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List j() {
        d dVar = this.f١١٩٧٥b;
        d dVar2 = d.LIST;
        if (dVar != dVar2) {
            if (this.f١١٩٧٥b == d.MAP) {
                this.f١١٩٧٧d = d(this.f١١٩٧٦c);
            }
            this.f١١٩٧٦c = null;
            this.f١١٩٧٥b = dVar2;
        }
        return this.f١١٩٧٧d;
    }

    public Map k() {
        d dVar = this.f١١٩٧٥b;
        d dVar2 = d.MAP;
        if (dVar != dVar2) {
            if (this.f١١٩٧٥b == d.LIST) {
                this.f١١٩٧٦c = c(this.f١١٩٧٧d);
            }
            this.f١١٩٧٧d = null;
            this.f١١٩٧٥b = dVar2;
        }
        return this.f١١٩٧٦c;
    }

    public boolean l() {
        return this.f١١٩٧٤a;
    }

    public void m() {
        this.f١١٩٧٤a = false;
    }

    public void n(v0 v0Var) {
        k().putAll(w0.g(v0Var.h()));
    }

    private v0(t0 t0Var, d dVar, Map map) {
        this(new b(t0Var), dVar, map);
    }
}
