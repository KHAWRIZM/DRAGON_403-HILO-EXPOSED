package com.google.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class o2 extends AbstractList implements p0, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final p0 f١١٨٥٨a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements ListIterator {

        /* renamed from: a, reason: collision with root package name */
        ListIterator f١١٨٥٩a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f١١٨٦٠b;

        a(int i10) {
            this.f١١٨٦٠b = i10;
            this.f١١٨٥٩a = o2.this.f١١٨٥٨a.listIterator(i10);
        }

        @Override // java.util.ListIterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f١١٨٥٩a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return (String) this.f١١٨٥٩a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f١١٨٥٩a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f١١٨٥٩a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f١١٨٥٩a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f١١٨٥٩a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class b implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        Iterator f١١٨٦٢a;

        b() {
            this.f١١٨٦٢a = o2.this.f١١٨٥٨a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            return (String) this.f١١٨٦٢a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f١١٨٦٢a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public o2(p0 p0Var) {
        this.f١١٨٥٨a = p0Var;
    }

    @Override // com.google.protobuf.p0
    public Object S(int i10) {
        return this.f١١٨٥٨a.S(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public String get(int i10) {
        return (String) this.f١١٨٥٨a.get(i10);
    }

    @Override // com.google.protobuf.p0
    public List getUnderlyingElements() {
        return this.f١١٨٥٨a.getUnderlyingElements();
    }

    @Override // com.google.protobuf.p0
    public p0 getUnmodifiableView() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    @Override // com.google.protobuf.p0
    public void j(h hVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i10) {
        return new a(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١١٨٥٨a.size();
    }
}
