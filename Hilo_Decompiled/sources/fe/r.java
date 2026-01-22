package fe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class r extends AtomicInteger implements List, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;

    /* renamed from: a, reason: collision with root package name */
    final ArrayList f١٤٣١٩a = new ArrayList();

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        boolean add = this.f١٤٣١٩a.add(obj);
        lazySet(this.f١٤٣١٩a.size());
        return add;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        boolean addAll = this.f١٤٣١٩a.addAll(collection);
        lazySet(this.f١٤٣١٩a.size());
        return addAll;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f١٤٣١٩a.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f١٤٣١٩a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f١٤٣١٩a.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f١٤٣١٩a.equals(((r) obj).f١٤٣١٩a);
        }
        return this.f١٤٣١٩a.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i10) {
        return this.f١٤٣١٩a.get(i10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f١٤٣١٩a.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f١٤٣١٩a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (get() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f١٤٣١٩a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f١٤٣١٩a.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return this.f١٤٣١٩a.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        boolean remove = this.f١٤٣١٩a.remove(obj);
        lazySet(this.f١٤٣١٩a.size());
        return remove;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        boolean removeAll = this.f١٤٣١٩a.removeAll(collection);
        lazySet(this.f١٤٣١٩a.size());
        return removeAll;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        boolean retainAll = this.f١٤٣١٩a.retainAll(collection);
        lazySet(this.f١٤٣١٩a.size());
        return retainAll;
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        return this.f١٤٣١٩a.set(i10, obj);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List subList(int i10, int i11) {
        return this.f١٤٣١٩a.subList(i10, i11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f١٤٣١٩a.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.f١٤٣١٩a.toString();
    }

    @Override // java.util.List
    public ListIterator listIterator(int i10) {
        return this.f١٤٣١٩a.listIterator(i10);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return this.f١٤٣١٩a.toArray(objArr);
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        this.f١٤٣١٩a.add(i10, obj);
        lazySet(this.f١٤٣١٩a.size());
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection collection) {
        boolean addAll = this.f١٤٣١٩a.addAll(i10, collection);
        lazySet(this.f١٤٣١٩a.size());
        return addAll;
    }

    @Override // java.util.List
    public Object remove(int i10) {
        Object remove = this.f١٤٣١٩a.remove(i10);
        lazySet(this.f١٤٣١٩a.size());
        return remove;
    }
}
