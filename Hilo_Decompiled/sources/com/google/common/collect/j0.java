package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class j0 {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Set f١٠٤٥٥a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set f١٠٤٥٦b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.j0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public class C٠١٢٥a extends com.google.common.collect.b {

            /* renamed from: c, reason: collision with root package name */
            final Iterator f١٠٤٥٧c;

            /* renamed from: d, reason: collision with root package name */
            final Iterator f١٠٤٥٨d;

            C٠١٢٥a() {
                this.f١٠٤٥٧c = a.this.f١٠٤٥٥a.iterator();
                this.f١٠٤٥٨d = a.this.f١٠٤٥٦b.iterator();
            }

            @Override // com.google.common.collect.b
            protected Object a() {
                if (this.f١٠٤٥٧c.hasNext()) {
                    return this.f١٠٤٥٧c.next();
                }
                while (this.f١٠٤٥٨d.hasNext()) {
                    Object next = this.f١٠٤٥٨d.next();
                    if (!a.this.f١٠٤٥٥a.contains(next)) {
                        return next;
                    }
                }
                return b();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Set set, Set set2) {
            super(null);
            this.f١٠٤٥٥a = set;
            this.f١٠٤٥٦b = set2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!this.f١٠٤٥٥a.contains(obj) && !this.f١٠٤٥٦b.contains(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public m0 iterator() {
            return new C٠١٢٥a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            if (this.f١٠٤٥٥a.isEmpty() && this.f١٠٤٥٦b.isEmpty()) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f١٠٤٥٥a.size();
            Iterator it = this.f١٠٤٥٦b.iterator();
            while (it.hasNext()) {
                if (!this.f١٠٤٥٥a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static abstract class b extends AbstractSet {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            return j0.e(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            return super.retainAll((Collection) k8.h.i(collection));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class c extends AbstractSet {
        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: d */
        public abstract m0 iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        private c() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set set, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Set set) {
        int i10;
        int i11 = 0;
        for (Object obj : set) {
            if (obj != null) {
                i10 = obj.hashCode();
            } else {
                i10 = 0;
            }
            i11 = ~(~(i11 + i10));
        }
        return i11;
    }

    public static HashSet c() {
        return new HashSet();
    }

    public static HashSet d(int i10) {
        return new HashSet(y.a(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(Set set, Collection collection) {
        k8.h.i(collection);
        if ((collection instanceof Set) && collection.size() > set.size()) {
            return v.c(set.iterator(), collection);
        }
        return f(set, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Set set, Iterator it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return z10;
    }

    public static c g(Set set, Set set2) {
        k8.h.j(set, "set1");
        k8.h.j(set2, "set2");
        return new a(set, set2);
    }
}
