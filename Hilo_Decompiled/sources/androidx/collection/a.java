package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends SimpleArrayMap implements Map {

    /* renamed from: a, reason: collision with root package name */
    C٠٠١٢a f١٧٤٠a;

    /* renamed from: b, reason: collision with root package name */
    c f١٧٤١b;

    /* renamed from: c, reason: collision with root package name */
    e f١٧٤٢c;

    /* renamed from: androidx.collection.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class C٠٠١٢a extends AbstractSet {
        C٠٠١٢a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.getSize();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class b extends IndexBasedArrayIterator {
        b() {
            super(a.this.getSize());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected Object elementAt(int i10) {
            return a.this.keyAt(i10);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int i10) {
            a.this.removeAt(i10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class d implements Iterator, Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        int f١٧٤٦a;

        /* renamed from: b, reason: collision with root package name */
        int f١٧٤٧b = -1;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٧٤٨c;

        d() {
            this.f١٧٤٦a = a.this.getSize() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (hasNext()) {
                this.f١٧٤٧b++;
                this.f١٧٤٨c = true;
                return this;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this.f١٧٤٨c) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!ContainerHelpersKt.equal(entry.getKey(), a.this.keyAt(this.f١٧٤٧b)) || !ContainerHelpersKt.equal(entry.getValue(), a.this.valueAt(this.f١٧٤٧b))) {
                    return false;
                }
                return true;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f١٧٤٨c) {
                return a.this.keyAt(this.f١٧٤٧b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f١٧٤٨c) {
                return a.this.valueAt(this.f١٧٤٧b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١٧٤٧b < this.f١٧٤٦a) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            if (this.f١٧٤٨c) {
                Object keyAt = a.this.keyAt(this.f١٧٤٧b);
                Object valueAt = a.this.valueAt(this.f١٧٤٧b);
                int i10 = 0;
                if (keyAt == null) {
                    hashCode = 0;
                } else {
                    hashCode = keyAt.hashCode();
                }
                if (valueAt != null) {
                    i10 = valueAt.hashCode();
                }
                return hashCode ^ i10;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f١٧٤٨c) {
                a.this.removeAt(this.f١٧٤٧b);
                this.f١٧٤٧b--;
                this.f١٧٤٦a--;
                this.f١٧٤٨c = false;
                return;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f١٧٤٨c) {
                return a.this.setValueAt(this.f١٧٤٧b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class f extends IndexBasedArrayIterator {
        f() {
            super(a.this.getSize());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected Object elementAt(int i10) {
            return a.this.valueAt(i10);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void removeAt(int i10) {
            a.this.removeAt(i10);
        }
    }

    public a() {
    }

    static boolean d(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public boolean c(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public boolean e(Collection collection) {
        int size = getSize();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        if (size != getSize()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public Set entrySet() {
        C٠٠١٢a r02 = this.f١٧٤٠a;
        if (r02 == null) {
            C٠٠١٢a r03 = new C٠٠١٢a();
            this.f١٧٤٠a = r03;
            return r03;
        }
        return r02;
    }

    public boolean f(Collection collection) {
        int size = getSize();
        for (int size2 = getSize() - 1; size2 >= 0; size2--) {
            if (!collection.contains(keyAt(size2))) {
                removeAt(size2);
            }
        }
        if (size != getSize()) {
            return true;
        }
        return false;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public Object get(Object obj) {
        return super.get(obj);
    }

    @Override // java.util.Map
    public Set keySet() {
        c cVar = this.f١٧٤١b;
        if (cVar == null) {
            c cVar2 = new c();
            this.f١٧٤١b = cVar2;
            return cVar2;
        }
        return cVar;
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        ensureCapacity(getSize() + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.Map
    public Collection values() {
        e eVar = this.f١٧٤٢c;
        if (eVar == null) {
            e eVar2 = new e();
            this.f١٧٤٢c = eVar2;
            return eVar2;
        }
        return eVar;
    }

    public a(int i10) {
        super(i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class c implements Set {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return a.this.c(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return a.d(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int hashCode;
            int i10 = 0;
            for (int size = a.this.getSize() - 1; size >= 0; size--) {
                Object keyAt = a.this.keyAt(size);
                if (keyAt == null) {
                    hashCode = 0;
                } else {
                    hashCode = keyAt.hashCode();
                }
                i10 += hashCode;
            }
            return i10;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int indexOfKey = a.this.indexOfKey(obj);
            if (indexOfKey >= 0) {
                a.this.removeAt(indexOfKey);
                return true;
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return a.this.e(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return a.this.f(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return a.this.getSize();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = a.this.getSize();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = a.this.keyAt(i10);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = a.this.keyAt(i10);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    final class e implements Collection {
        e() {
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
            a.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            if (a.this.__restricted$indexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int __restricted$indexOfValue = a.this.__restricted$indexOfValue(obj);
            if (__restricted$indexOfValue >= 0) {
                a.this.removeAt(__restricted$indexOfValue);
                return true;
            }
            return false;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int size = a.this.getSize();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < size) {
                if (collection.contains(a.this.valueAt(i10))) {
                    a.this.removeAt(i10);
                    i10--;
                    size--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int size = a.this.getSize();
            int i10 = 0;
            boolean z10 = false;
            while (i10 < size) {
                if (!collection.contains(a.this.valueAt(i10))) {
                    a.this.removeAt(i10);
                    i10--;
                    size--;
                    z10 = true;
                }
                i10++;
            }
            return z10;
        }

        @Override // java.util.Collection
        public int size() {
            return a.this.getSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = a.this.getSize();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = a.this.valueAt(i10);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i10 = 0; i10 < size; i10++) {
                objArr[i10] = a.this.valueAt(i10);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    public a(SimpleArrayMap simpleArrayMap) {
        super(simpleArrayMap);
    }
}
