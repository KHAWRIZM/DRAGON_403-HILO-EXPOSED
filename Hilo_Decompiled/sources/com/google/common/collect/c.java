package com.google.common.collect;

import com.google.common.collect.y;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c extends e implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: c, reason: collision with root package name */
    private transient Map f١٠٣٨٣c;

    /* renamed from: d, reason: collision with root package name */
    private transient int f١٠٣٨٤d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends y.f {

        /* renamed from: c, reason: collision with root package name */
        final transient Map f١٠٣٨٥c;

        /* renamed from: com.google.common.collect.c$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠١٢٢a extends y.c {
            C٠١٢٢a() {
            }

            @Override // com.google.common.collect.y.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return i.b(a.this.f١٠٣٨٥c.entrySet(), obj);
            }

            @Override // com.google.common.collect.y.c
            Map d() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                c.this.q(entry.getKey());
                return true;
            }
        }

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class b implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            final Iterator f١٠٣٨٨a;

            /* renamed from: b, reason: collision with root package name */
            Collection f١٠٣٨٩b;

            b() {
                this.f١٠٣٨٨a = a.this.f١٠٣٨٥c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f١٠٣٨٨a.next();
                this.f١٠٣٨٩b = (Collection) entry.getValue();
                return a.this.g(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f١٠٣٨٨a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z10;
                if (this.f١٠٣٨٩b != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                k8.h.o(z10, "no calls to next() since the last call to remove()");
                this.f١٠٣٨٨a.remove();
                c.j(c.this, this.f١٠٣٨٩b.size());
                this.f١٠٣٨٩b.clear();
                this.f١٠٣٨٩b = null;
            }
        }

        a(Map map) {
            this.f١٠٣٨٥c = map;
        }

        @Override // com.google.common.collect.y.f
        protected Set c() {
            return new C٠١٢٢a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f١٠٣٨٥c == c.this.f١٠٣٨٣c) {
                c.this.l();
            } else {
                v.a(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return y.d(this.f١٠٣٨٥c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection get(Object obj) {
            Collection collection = (Collection) y.e(this.f١٠٣٨٥c, obj);
            if (collection == null) {
                return null;
            }
            return c.this.s(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            if (this != obj && !this.f١٠٣٨٥c.equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.f١٠٣٨٥c.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection m10 = c.this.m();
            m10.addAll(collection);
            c.j(c.this, collection.size());
            collection.clear();
            return m10;
        }

        Map.Entry g(Map.Entry entry) {
            Object key = entry.getKey();
            return y.c(key, c.this.s(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f١٠٣٨٥c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return c.this.d();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f١٠٣٨٥c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f١٠٣٨٥c.toString();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class b extends y.d {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            Map.Entry f١٠٣٩٢a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f١٠٣٩٣b;

            a(Iterator it) {
                this.f١٠٣٩٣b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f١٠٣٩٣b.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.f١٠٣٩٣b.next();
                this.f١٠٣٩٢a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z10;
                if (this.f١٠٣٩٢a != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                k8.h.o(z10, "no calls to next() since the last call to remove()");
                Collection collection = (Collection) this.f١٠٣٩٢a.getValue();
                this.f١٠٣٩٣b.remove();
                c.j(c.this, collection.size());
                collection.clear();
                this.f١٠٣٩٢a = null;
            }
        }

        b(Map map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            v.a(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return d().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            if (this != obj && !d().keySet().equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return d().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(d().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i10;
            Collection collection = (Collection) d().remove(obj);
            if (collection != null) {
                i10 = collection.size();
                collection.clear();
                c.j(c.this, i10);
            } else {
                i10 = 0;
            }
            if (i10 <= 0) {
                return false;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.c$c, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class C٠١٢٣c extends AbstractCollection {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٠٣٩٥a;

        /* renamed from: b, reason: collision with root package name */
        Collection f١٠٣٩٦b;

        /* renamed from: c, reason: collision with root package name */
        final C٠١٢٣c f١٠٣٩٧c;

        /* renamed from: d, reason: collision with root package name */
        final Collection f١٠٣٩٨d;

        /* renamed from: com.google.common.collect.c$c$a */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class a implements Iterator {

            /* renamed from: a, reason: collision with root package name */
            final Iterator f١٠٤٠٠a;

            /* renamed from: b, reason: collision with root package name */
            final Collection f١٠٤٠١b;

            a() {
                Collection collection = C٠١٢٣c.this.f١٠٣٩٦b;
                this.f١٠٤٠١b = collection;
                this.f١٠٤٠٠a = c.o(collection);
            }

            void a() {
                C٠١٢٣c.this.f();
                if (C٠١٢٣c.this.f١٠٣٩٦b == this.f١٠٤٠١b) {
                } else {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return this.f١٠٤٠٠a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                a();
                return this.f١٠٤٠٠a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f١٠٤٠٠a.remove();
                c.h(c.this);
                C٠١٢٣c.this.h();
            }
        }

        C٠١٢٣c(Object obj, Collection collection, C٠١٢٣c r42) {
            Collection e10;
            this.f١٠٣٩٥a = obj;
            this.f١٠٣٩٦b = collection;
            this.f١٠٣٩٧c = r42;
            if (r42 == null) {
                e10 = null;
            } else {
                e10 = r42.e();
            }
            this.f١٠٣٩٨d = e10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            f();
            boolean isEmpty = this.f١٠٣٩٦b.isEmpty();
            boolean add = this.f١٠٣٩٦b.add(obj);
            if (add) {
                c.g(c.this);
                if (isEmpty) {
                    d();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f١٠٣٩٦b.addAll(collection);
            if (addAll) {
                c.i(c.this, this.f١٠٣٩٦b.size() - size);
                if (size == 0) {
                    d();
                }
            }
            return addAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f١٠٣٩٦b.clear();
            c.j(c.this, size);
            h();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            f();
            return this.f١٠٣٩٦b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            f();
            return this.f١٠٣٩٦b.containsAll(collection);
        }

        void d() {
            C٠١٢٣c r02 = this.f١٠٣٩٧c;
            if (r02 != null) {
                r02.d();
            } else {
                c.this.f١٠٣٨٣c.put(this.f١٠٣٩٥a, this.f١٠٣٩٦b);
            }
        }

        Collection e() {
            return this.f١٠٣٩٦b;
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            f();
            return this.f١٠٣٩٦b.equals(obj);
        }

        void f() {
            Collection collection;
            C٠١٢٣c r02 = this.f١٠٣٩٧c;
            if (r02 != null) {
                r02.f();
                if (this.f١٠٣٩٧c.e() != this.f١٠٣٩٨d) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f١٠٣٩٦b.isEmpty() && (collection = (Collection) c.this.f١٠٣٨٣c.get(this.f١٠٣٩٥a)) != null) {
                this.f١٠٣٩٦b = collection;
            }
        }

        void h() {
            C٠١٢٣c r02 = this.f١٠٣٩٧c;
            if (r02 != null) {
                r02.h();
            } else if (this.f١٠٣٩٦b.isEmpty()) {
                c.this.f١٠٣٨٣c.remove(this.f١٠٣٩٥a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            f();
            return this.f١٠٣٩٦b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            f();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            f();
            boolean remove = this.f١٠٣٩٦b.remove(obj);
            if (remove) {
                c.h(c.this);
                h();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            k8.h.i(collection);
            int size = size();
            boolean retainAll = this.f١٠٣٩٦b.retainAll(collection);
            if (retainAll) {
                c.i(c.this, this.f١٠٣٩٦b.size() - size);
                h();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            f();
            return this.f١٠٣٩٦b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            f();
            return this.f١٠٣٩٦b.toString();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class d extends C٠١٢٣c implements Set {
        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Object obj, Set set) {
            super(obj, set, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean e10 = j0.e((Set) this.f١٠٣٩٦b, collection);
            if (e10) {
                c.i(c.this, this.f١٠٣٩٦b.size() - size);
                h();
            }
            return e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Map map) {
        k8.h.d(map.isEmpty());
        this.f١٠٣٨٣c = map;
    }

    static /* synthetic */ int g(c cVar) {
        int i10 = cVar.f١٠٣٨٤d;
        cVar.f١٠٣٨٤d = i10 + 1;
        return i10;
    }

    static /* synthetic */ int h(c cVar) {
        int i10 = cVar.f١٠٣٨٤d;
        cVar.f١٠٣٨٤d = i10 - 1;
        return i10;
    }

    static /* synthetic */ int i(c cVar, int i10) {
        int i11 = cVar.f١٠٣٨٤d + i10;
        cVar.f١٠٣٨٤d = i11;
        return i11;
    }

    static /* synthetic */ int j(c cVar, int i10) {
        int i11 = cVar.f١٠٣٨٤d - i10;
        cVar.f١٠٣٨٤d = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator o(Collection collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Object obj) {
        Collection collection = (Collection) y.f(this.f١٠٣٨٣c, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f١٠٣٨٤d -= size;
        }
    }

    @Override // com.google.common.collect.e
    Map b() {
        return new a(this.f١٠٣٨٣c);
    }

    @Override // com.google.common.collect.e
    Set c() {
        return new b(this.f١٠٣٨٣c);
    }

    @Override // com.google.common.collect.z
    public Collection get(Object obj) {
        Collection collection = (Collection) this.f١٠٣٨٣c.get(obj);
        if (collection == null) {
            collection = n(obj);
        }
        return s(obj, collection);
    }

    public void l() {
        Iterator it = this.f١٠٣٨٣c.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f١٠٣٨٣c.clear();
        this.f١٠٣٨٤d = 0;
    }

    abstract Collection m();

    Collection n(Object obj) {
        return m();
    }

    public boolean p(Object obj, Object obj2) {
        Collection collection = (Collection) this.f١٠٣٨٣c.get(obj);
        if (collection == null) {
            Collection n10 = n(obj);
            if (n10.add(obj2)) {
                this.f١٠٣٨٤d++;
                this.f١٠٣٨٣c.put(obj, n10);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        }
        if (collection.add(obj2)) {
            this.f١٠٣٨٤d++;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(Map map) {
        this.f١٠٣٨٣c = map;
        this.f١٠٣٨٤d = 0;
        for (Collection collection : map.values()) {
            k8.h.d(!collection.isEmpty());
            this.f١٠٣٨٤d += collection.size();
        }
    }

    abstract Collection s(Object obj, Collection collection);
}
