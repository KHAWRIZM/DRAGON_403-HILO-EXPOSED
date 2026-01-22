package com.google.common.collect;

import com.google.common.collect.q;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class s extends q implements List, RandomAccess {

    /* renamed from: b, reason: collision with root package name */
    private static final n0 f١٠٤٧٩b = new b(f0.f١٠٤٠٦e, 0);

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class a extends q.a {
        public a() {
            this(4);
        }

        public a e(Object... objArr) {
            super.b(objArr);
            return this;
        }

        public s f() {
            this.f١٠٤٧٦c = true;
            return s.l(this.f١٠٤٧٤a, this.f١٠٤٧٥b);
        }

        a(int i10) {
            super(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b extends com.google.common.collect.a {

        /* renamed from: c, reason: collision with root package name */
        private final s f١٠٤٨٠c;

        b(s sVar, int i10) {
            super(sVar.size(), i10);
            this.f١٠٤٨٠c = sVar;
        }

        @Override // com.google.common.collect.a
        protected Object a(int i10) {
            return this.f١٠٤٨٠c.get(i10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class c implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        final Object[] f١٠٤٨١a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Object[] objArr) {
            this.f١٠٤٨١a = objArr;
        }

        Object readResolve() {
            return s.n(this.f١٠٤٨١a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d extends s {

        /* renamed from: c, reason: collision with root package name */
        final transient int f١٠٤٨٢c;

        /* renamed from: d, reason: collision with root package name */
        final transient int f١٠٤٨٣d;

        d(int i10, int i11) {
            this.f١٠٤٨٢c = i10;
            this.f١٠٤٨٣d = i11;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q
        public Object[] e() {
            return s.this.e();
        }

        @Override // com.google.common.collect.q
        int f() {
            return s.this.h() + this.f١٠٤٨٢c + this.f١٠٤٨٣d;
        }

        @Override // java.util.List
        public Object get(int i10) {
            k8.h.g(i10, this.f١٠٤٨٣d);
            return s.this.get(i10 + this.f١٠٤٨٢c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.q
        public int h() {
            return s.this.h() + this.f١٠٤٨٢c;
        }

        @Override // com.google.common.collect.s, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.s, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f١٠٤٨٣d;
        }

        @Override // com.google.common.collect.s, java.util.List
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public s subList(int i10, int i11) {
            k8.h.m(i10, i11, this.f١٠٤٨٣d);
            s sVar = s.this;
            int i12 = this.f١٠٤٨٢c;
            return sVar.subList(i10 + i12, i11 + i12);
        }

        @Override // com.google.common.collect.s, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return super.listIterator(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s k(Object[] objArr) {
        return l(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s l(Object[] objArr, int i10) {
        if (i10 == 0) {
            return q();
        }
        return new f0(objArr, i10);
    }

    private static s m(Object... objArr) {
        return k(c0.b(objArr));
    }

    public static s n(Object[] objArr) {
        if (objArr.length == 0) {
            return q();
        }
        return m((Object[]) objArr.clone());
    }

    public static s q() {
        return f0.f١٠٤٠٦e;
    }

    public static s r(Object obj, Object obj2) {
        return m(obj, obj2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static s s(Object obj, Object obj2, Object obj3) {
        return m(obj, obj2, obj3);
    }

    public static s t(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
        return m(obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    public static s u(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, Object obj12, Object... objArr) {
        boolean z10;
        if (objArr.length <= 2147483635) {
            z10 = true;
        } else {
            z10 = false;
        }
        k8.h.e(z10, "the total number of elements must fit in an int");
        Object[] objArr2 = new Object[objArr.length + 12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        objArr2[6] = obj7;
        objArr2[7] = obj8;
        objArr2[8] = obj9;
        objArr2[9] = obj10;
        objArr2[10] = obj11;
        objArr2[11] = obj12;
        System.arraycopy(objArr, 0, objArr2, 12, objArr.length);
        return m(objArr2);
    }

    @Override // java.util.List
    public final void add(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.q
    public int d(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return w.a(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public m0 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return w.b(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return w.d(this, obj);
    }

    @Override // java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public n0 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public n0 listIterator(int i10) {
        k8.h.k(i10, size());
        if (isEmpty()) {
            return f١٠٤٧٩b;
        }
        return new b(this, i10);
    }

    @Override // java.util.List
    public final Object remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object set(int i10, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    /* renamed from: v */
    public s subList(int i10, int i11) {
        k8.h.m(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return q();
        }
        return w(i10, i11);
    }

    s w(int i10, int i11) {
        return new d(i10, i11 - i10);
    }

    @Override // com.google.common.collect.q
    Object writeReplace() {
        return new c(toArray());
    }
}
