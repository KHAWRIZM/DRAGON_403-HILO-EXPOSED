package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class i0 extends d implements j0.g, RandomAccess, s1 {

    /* renamed from: d, reason: collision with root package name */
    private static final i0 f١١١٣٤d;

    /* renamed from: b, reason: collision with root package name */
    private int[] f١١١٣٥b;

    /* renamed from: c, reason: collision with root package name */
    private int f١١١٣٦c;

    static {
        i0 i0Var = new i0(new int[0], 0);
        f١١١٣٤d = i0Var;
        i0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0() {
        this(new int[10], 0);
    }

    private void h(int i10, int i11) {
        int i12;
        d();
        if (i10 >= 0 && i10 <= (i12 = this.f١١١٣٦c)) {
            int[] iArr = this.f١١١٣٥b;
            if (i12 < iArr.length) {
                System.arraycopy(iArr, i10, iArr, i10 + 1, i12 - i10);
            } else {
                int[] iArr2 = new int[((i12 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i10);
                System.arraycopy(this.f١١١٣٥b, i10, iArr2, i10 + 1, this.f١١١٣٦c - i10);
                this.f١١١٣٥b = iArr2;
            }
            this.f١١١٣٥b[i10] = i11;
            this.f١١١٣٦c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m(i10));
    }

    public static i0 i() {
        return f١١١٣٤d;
    }

    private void k(int i10) {
        if (i10 >= 0 && i10 < this.f١١١٣٦c) {
        } else {
            throw new IndexOutOfBoundsException(m(i10));
        }
    }

    private String m(int i10) {
        return "Index:" + i10 + ", Size:" + this.f١١١٣٦c;
    }

    @Override // com.google.protobuf.j0.g
    public void E(int i10) {
        d();
        int i11 = this.f١١١٣٦c;
        int[] iArr = this.f١١١٣٥b;
        if (i11 == iArr.length) {
            int[] iArr2 = new int[((i11 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            this.f١١١٣٥b = iArr2;
        }
        int[] iArr3 = this.f١١١٣٥b;
        int i12 = this.f١١١٣٦c;
        this.f١١١٣٦c = i12 + 1;
        iArr3[i12] = i10;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        d();
        j0.a(collection);
        if (!(collection instanceof i0)) {
            return super.addAll(collection);
        }
        i0 i0Var = (i0) collection;
        int i10 = i0Var.f١١١٣٦c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f١١١٣٦c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            int[] iArr = this.f١١١٣٥b;
            if (i12 > iArr.length) {
                this.f١١١٣٥b = Arrays.copyOf(iArr, i12);
            }
            System.arraycopy(i0Var.f١١١٣٥b, 0, this.f١١١٣٥b, this.f١١١٣٦c, i0Var.f١١١٣٦c);
            this.f١١١٣٦c = i12;
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
    public void add(int i10, Integer num) {
        h(i10, num.intValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i0)) {
            return super.equals(obj);
        }
        i0 i0Var = (i0) obj;
        if (this.f١١١٣٦c != i0Var.f١١١٣٦c) {
            return false;
        }
        int[] iArr = i0Var.f١١١٣٥b;
        for (int i10 = 0; i10 < this.f١١١٣٦c; i10++) {
            if (this.f١١١٣٥b[i10] != iArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        E(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.j0.g
    public int getInt(int i10) {
        k(i10);
        return this.f١١١٣٥b[i10];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f١١١٣٦c; i11++) {
            i10 = (i10 * 31) + this.f١١١٣٥b[i11];
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f١١١٣٥b[i10] == intValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Integer get(int i10) {
        return Integer.valueOf(getInt(i10));
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i10) {
        d();
        k(i10);
        int[] iArr = this.f١١١٣٥b;
        int i11 = iArr[i10];
        if (i10 < this.f١١١٣٦c - 1) {
            System.arraycopy(iArr, i10 + 1, iArr, i10, (r2 - i10) - 1);
        }
        this.f١١١٣٦c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer set(int i10, Integer num) {
        return Integer.valueOf(p(i10, num.intValue()));
    }

    public int p(int i10, int i11) {
        d();
        k(i10);
        int[] iArr = this.f١١١٣٥b;
        int i12 = iArr[i10];
        iArr[i10] = i11;
        return i12;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i10, int i11) {
        d();
        if (i11 >= i10) {
            int[] iArr = this.f١١١٣٥b;
            System.arraycopy(iArr, i11, iArr, i10, this.f١١١٣٦c - i11);
            this.f١١١٣٦c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١١١٣٦c;
    }

    private i0(int[] iArr, int i10) {
        this.f١١١٣٥b = iArr;
        this.f١١١٣٦c = i10;
    }

    @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
    public j0.g a(int i10) {
        if (i10 >= this.f١١١٣٦c) {
            return new i0(Arrays.copyOf(this.f١١١٣٥b, i10), this.f١١١٣٦c);
        }
        throw new IllegalArgumentException();
    }
}
