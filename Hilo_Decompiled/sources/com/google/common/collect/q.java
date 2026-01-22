package com.google.common.collect;

import com.google.common.collect.s;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class q extends AbstractCollection implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private static final Object[] f١٠٤٧٣a = new Object[0];

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static abstract class a extends b {

        /* renamed from: a, reason: collision with root package name */
        Object[] f١٠٤٧٤a;

        /* renamed from: b, reason: collision with root package name */
        int f١٠٤٧٥b;

        /* renamed from: c, reason: collision with root package name */
        boolean f١٠٤٧٦c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10) {
            h.b(i10, "initialCapacity");
            this.f١٠٤٧٤a = new Object[i10];
            this.f١٠٤٧٥b = 0;
        }

        private void d(int i10) {
            Object[] objArr = this.f١٠٤٧٤a;
            if (objArr.length < i10) {
                this.f١٠٤٧٤a = Arrays.copyOf(objArr, b.a(objArr.length, i10));
                this.f١٠٤٧٦c = false;
            } else if (this.f١٠٤٧٦c) {
                this.f١٠٤٧٤a = (Object[]) objArr.clone();
                this.f١٠٤٧٦c = false;
            }
        }

        public b b(Object... objArr) {
            c(objArr, objArr.length);
            return this;
        }

        final void c(Object[] objArr, int i10) {
            c0.c(objArr, i10);
            d(this.f١٠٤٧٥b + i10);
            System.arraycopy(objArr, 0, this.f١٠٤٧٤a, this.f١٠٤٧٥b, i10);
            this.f١٠٤٧٥b += i10;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static int a(int i10, int i11) {
            if (i11 >= 0) {
                int i12 = i10 + (i10 >> 1) + 1;
                if (i12 < i11) {
                    i12 = Integer.highestOneBit(i11 - 1) << 1;
                }
                if (i12 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i12;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(Object obj);

    abstract int d(Object[] objArr, int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] e() {
        return null;
    }

    int f() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: i */
    public abstract m0 iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f١٠٤٧٣a);
    }

    Object writeReplace() {
        return new s.c(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        k8.h.i(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] e10 = e();
            if (e10 != null) {
                return e0.a(e10, h(), f(), objArr);
            }
            objArr = c0.d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        d(objArr, 0);
        return objArr;
    }
}
