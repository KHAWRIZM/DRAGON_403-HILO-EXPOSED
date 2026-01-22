package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class f extends d implements j0.a, RandomAccess, s1 {

    /* renamed from: d, reason: collision with root package name */
    private static final f f١١٠٠١d;

    /* renamed from: b, reason: collision with root package name */
    private boolean[] f١١٠٠٢b;

    /* renamed from: c, reason: collision with root package name */
    private int f١١٠٠٣c;

    static {
        f fVar = new f(new boolean[0], 0);
        f١١٠٠١d = fVar;
        fVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f() {
        this(new boolean[10], 0);
    }

    private void h(int i10, boolean z10) {
        int i11;
        d();
        if (i10 >= 0 && i10 <= (i11 = this.f١١٠٠٣c)) {
            boolean[] zArr = this.f١١٠٠٢b;
            if (i11 < zArr.length) {
                System.arraycopy(zArr, i10, zArr, i10 + 1, i11 - i10);
            } else {
                boolean[] zArr2 = new boolean[((i11 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i10);
                System.arraycopy(this.f١١٠٠٢b, i10, zArr2, i10 + 1, this.f١١٠٠٣c - i10);
                this.f١١٠٠٢b = zArr2;
            }
            this.f١١٠٠٢b[i10] = z10;
            this.f١١٠٠٣c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i10));
    }

    public static f k() {
        return f١١٠٠١d;
    }

    private void l(int i10) {
        if (i10 >= 0 && i10 < this.f١١٠٠٣c) {
        } else {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f١١٠٠٣c;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        d();
        j0.a(collection);
        if (!(collection instanceof f)) {
            return super.addAll(collection);
        }
        f fVar = (f) collection;
        int i10 = fVar.f١١٠٠٣c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f١١٠٠٣c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            boolean[] zArr = this.f١١٠٠٢b;
            if (i12 > zArr.length) {
                this.f١١٠٠٢b = Arrays.copyOf(zArr, i12);
            }
            System.arraycopy(fVar.f١١٠٠٢b, 0, this.f١١٠٠٢b, this.f١١٠٠٣c, fVar.f١١٠٠٣c);
            this.f١١٠٠٣c = i12;
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
    public void add(int i10, Boolean bool) {
        h(i10, bool.booleanValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return super.equals(obj);
        }
        f fVar = (f) obj;
        if (this.f١١٠٠٣c != fVar.f١١٠٠٣c) {
            return false;
        }
        boolean[] zArr = fVar.f١١٠٠٢b;
        for (int i10 = 0; i10 < this.f١١٠٠٣c; i10++) {
            if (this.f١١٠٠٢b[i10] != zArr[i10]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        i(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f١١٠٠٣c; i11++) {
            i10 = (i10 * 31) + j0.c(this.f١١٠٠٢b[i11]);
        }
        return i10;
    }

    public void i(boolean z10) {
        d();
        int i10 = this.f١١٠٠٣c;
        boolean[] zArr = this.f١١٠٠٢b;
        if (i10 == zArr.length) {
            boolean[] zArr2 = new boolean[((i10 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i10);
            this.f١١٠٠٢b = zArr2;
        }
        boolean[] zArr3 = this.f١١٠٠٢b;
        int i11 = this.f١١٠٠٣c;
        this.f١١٠٠٣c = i11 + 1;
        zArr3[i11] = z10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f١١٠٠٢b[i10] == booleanValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i10) {
        return Boolean.valueOf(n(i10));
    }

    public boolean n(int i10) {
        l(i10);
        return this.f١١٠٠٢b[i10];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i10) {
        d();
        l(i10);
        boolean[] zArr = this.f١١٠٠٢b;
        boolean z10 = zArr[i10];
        if (i10 < this.f١١٠٠٣c - 1) {
            System.arraycopy(zArr, i10 + 1, zArr, i10, (r2 - i10) - 1);
        }
        this.f١١٠٠٣c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i10, Boolean bool) {
        return Boolean.valueOf(r(i10, bool.booleanValue()));
    }

    public boolean r(int i10, boolean z10) {
        d();
        l(i10);
        boolean[] zArr = this.f١١٠٠٢b;
        boolean z11 = zArr[i10];
        zArr[i10] = z10;
        return z11;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i10, int i11) {
        d();
        if (i11 >= i10) {
            boolean[] zArr = this.f١١٠٠٢b;
            System.arraycopy(zArr, i11, zArr, i10, this.f١١٠٠٣c - i11);
            this.f١١٠٠٣c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١١٠٠٣c;
    }

    private f(boolean[] zArr, int i10) {
        this.f١١٠٠٢b = zArr;
        this.f١١٠٠٣c = i10;
    }

    @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
    public j0.a a(int i10) {
        if (i10 >= this.f١١٠٠٣c) {
            return new f(Arrays.copyOf(this.f١١٠٠٢b, i10), this.f١١٠٠٣c);
        }
        throw new IllegalArgumentException();
    }
}
