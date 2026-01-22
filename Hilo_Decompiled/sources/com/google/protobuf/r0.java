package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class r0 extends d implements j0.h, RandomAccess, s1 {

    /* renamed from: d, reason: collision with root package name */
    private static final r0 f١١٩٠٦d;

    /* renamed from: b, reason: collision with root package name */
    private long[] f١١٩٠٧b;

    /* renamed from: c, reason: collision with root package name */
    private int f١١٩٠٨c;

    static {
        r0 r0Var = new r0(new long[0], 0);
        f١١٩٠٦d = r0Var;
        r0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0() {
        this(new long[10], 0);
    }

    private void h(int i10, long j10) {
        int i11;
        d();
        if (i10 >= 0 && i10 <= (i11 = this.f١١٩٠٨c)) {
            long[] jArr = this.f١١٩٠٧b;
            if (i11 < jArr.length) {
                System.arraycopy(jArr, i10, jArr, i10 + 1, i11 - i10);
            } else {
                long[] jArr2 = new long[((i11 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i10);
                System.arraycopy(this.f١١٩٠٧b, i10, jArr2, i10 + 1, this.f١١٩٠٨c - i10);
                this.f١١٩٠٧b = jArr2;
            }
            this.f١١٩٠٧b[i10] = j10;
            this.f١١٩٠٨c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m(i10));
    }

    public static r0 i() {
        return f١١٩٠٦d;
    }

    private void k(int i10) {
        if (i10 >= 0 && i10 < this.f١١٩٠٨c) {
        } else {
            throw new IndexOutOfBoundsException(m(i10));
        }
    }

    private String m(int i10) {
        return "Index:" + i10 + ", Size:" + this.f١١٩٠٨c;
    }

    @Override // com.google.protobuf.j0.h
    public void I(long j10) {
        d();
        int i10 = this.f١١٩٠٨c;
        long[] jArr = this.f١١٩٠٧b;
        if (i10 == jArr.length) {
            long[] jArr2 = new long[((i10 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i10);
            this.f١١٩٠٧b = jArr2;
        }
        long[] jArr3 = this.f١١٩٠٧b;
        int i11 = this.f١١٩٠٨c;
        this.f١١٩٠٨c = i11 + 1;
        jArr3[i11] = j10;
    }

    @Override // com.google.protobuf.j0.h
    public long O(int i10, long j10) {
        d();
        k(i10);
        long[] jArr = this.f١١٩٠٧b;
        long j11 = jArr[i10];
        jArr[i10] = j10;
        return j11;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        d();
        j0.a(collection);
        if (!(collection instanceof r0)) {
            return super.addAll(collection);
        }
        r0 r0Var = (r0) collection;
        int i10 = r0Var.f١١٩٠٨c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f١١٩٠٨c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            long[] jArr = this.f١١٩٠٧b;
            if (i12 > jArr.length) {
                this.f١١٩٠٧b = Arrays.copyOf(jArr, i12);
            }
            System.arraycopy(r0Var.f١١٩٠٧b, 0, this.f١١٩٠٧b, this.f١١٩٠٨c, r0Var.f١١٩٠٨c);
            this.f١١٩٠٨c = i12;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void add(int i10, Long l10) {
        h(i10, l10.longValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return super.equals(obj);
        }
        r0 r0Var = (r0) obj;
        if (this.f١١٩٠٨c != r0Var.f١١٩٠٨c) {
            return false;
        }
        long[] jArr = r0Var.f١١٩٠٧b;
        for (int i10 = 0; i10 < this.f١١٩٠٨c; i10++) {
            if (this.f١١٩٠٧b[i10] != jArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l10) {
        I(l10.longValue());
        return true;
    }

    @Override // com.google.protobuf.j0.h
    public long getLong(int i10) {
        k(i10);
        return this.f١١٩٠٧b[i10];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f١١٩٠٨c; i11++) {
            i10 = (i10 * 31) + j0.h(this.f١١٩٠٧b[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f١١٩٠٧b[i10] == longValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Long get(int i10) {
        return Long.valueOf(getLong(i10));
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Long remove(int i10) {
        d();
        k(i10);
        long[] jArr = this.f١١٩٠٧b;
        long j10 = jArr[i10];
        if (i10 < this.f١١٩٠٨c - 1) {
            System.arraycopy(jArr, i10 + 1, jArr, i10, (r3 - i10) - 1);
        }
        this.f١١٩٠٨c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long set(int i10, Long l10) {
        return Long.valueOf(O(i10, l10.longValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i10, int i11) {
        d();
        if (i11 >= i10) {
            long[] jArr = this.f١١٩٠٧b;
            System.arraycopy(jArr, i11, jArr, i10, this.f١١٩٠٨c - i11);
            this.f١١٩٠٨c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١١٩٠٨c;
    }

    private r0(long[] jArr, int i10) {
        this.f١١٩٠٧b = jArr;
        this.f١١٩٠٨c = i10;
    }

    @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
    public j0.h a(int i10) {
        if (i10 >= this.f١١٩٠٨c) {
            return new r0(Arrays.copyOf(this.f١١٩٠٧b, i10), this.f١١٩٠٨c);
        }
        throw new IllegalArgumentException();
    }
}
