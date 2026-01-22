package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class o extends d implements j0.b, RandomAccess, s1 {

    /* renamed from: d, reason: collision with root package name */
    private static final o f١١٨٥٠d;

    /* renamed from: b, reason: collision with root package name */
    private double[] f١١٨٥١b;

    /* renamed from: c, reason: collision with root package name */
    private int f١١٨٥٢c;

    static {
        o oVar = new o(new double[0], 0);
        f١١٨٥٠d = oVar;
        oVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this(new double[10], 0);
    }

    private void i(int i10, double d10) {
        int i11;
        d();
        if (i10 >= 0 && i10 <= (i11 = this.f١١٨٥٢c)) {
            double[] dArr = this.f١١٨٥١b;
            if (i11 < dArr.length) {
                System.arraycopy(dArr, i10, dArr, i10 + 1, i11 - i10);
            } else {
                double[] dArr2 = new double[((i11 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i10);
                System.arraycopy(this.f١١٨٥١b, i10, dArr2, i10 + 1, this.f١١٨٥٢c - i10);
                this.f١١٨٥١b = dArr2;
            }
            this.f١١٨٥١b[i10] = d10;
            this.f١١٨٥٢c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i10));
    }

    public static o k() {
        return f١١٨٥٠d;
    }

    private void l(int i10) {
        if (i10 >= 0 && i10 < this.f١١٨٥٢c) {
        } else {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f١١٨٥٢c;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        d();
        j0.a(collection);
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i10 = oVar.f١١٨٥٢c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f١١٨٥٢c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            double[] dArr = this.f١١٨٥١b;
            if (i12 > dArr.length) {
                this.f١١٨٥١b = Arrays.copyOf(dArr, i12);
            }
            System.arraycopy(oVar.f١١٨٥١b, 0, this.f١١٨٥١b, this.f١١٨٥٢c, oVar.f١١٨٥٢c);
            this.f١١٨٥٢c = i12;
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
    public void add(int i10, Double d10) {
        i(i10, d10.doubleValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.f١١٨٥٢c != oVar.f١١٨٥٢c) {
            return false;
        }
        double[] dArr = oVar.f١١٨٥١b;
        for (int i10 = 0; i10 < this.f١١٨٥٢c; i10++) {
            if (Double.doubleToLongBits(this.f١١٨٥١b[i10]) != Double.doubleToLongBits(dArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d10) {
        h(d10.doubleValue());
        return true;
    }

    public void h(double d10) {
        d();
        int i10 = this.f١١٨٥٢c;
        double[] dArr = this.f١١٨٥١b;
        if (i10 == dArr.length) {
            double[] dArr2 = new double[((i10 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i10);
            this.f١١٨٥١b = dArr2;
        }
        double[] dArr3 = this.f١١٨٥١b;
        int i11 = this.f١١٨٥٢c;
        this.f١١٨٥٢c = i11 + 1;
        dArr3[i11] = d10;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f١١٨٥٢c; i11++) {
            i10 = (i10 * 31) + j0.h(Double.doubleToLongBits(this.f١١٨٥١b[i11]));
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f١١٨٥١b[i10] == doubleValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Double get(int i10) {
        return Double.valueOf(n(i10));
    }

    public double n(int i10) {
        l(i10);
        return this.f١١٨٥١b[i10];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Double remove(int i10) {
        d();
        l(i10);
        double[] dArr = this.f١١٨٥١b;
        double d10 = dArr[i10];
        if (i10 < this.f١١٨٥٢c - 1) {
            System.arraycopy(dArr, i10 + 1, dArr, i10, (r3 - i10) - 1);
        }
        this.f١١٨٥٢c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Double set(int i10, Double d10) {
        return Double.valueOf(r(i10, d10.doubleValue()));
    }

    public double r(int i10, double d10) {
        d();
        l(i10);
        double[] dArr = this.f١١٨٥١b;
        double d11 = dArr[i10];
        dArr[i10] = d10;
        return d11;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i10, int i11) {
        d();
        if (i11 >= i10) {
            double[] dArr = this.f١١٨٥١b;
            System.arraycopy(dArr, i11, dArr, i10, this.f١١٨٥٢c - i11);
            this.f١١٨٥٢c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١١٨٥٢c;
    }

    private o(double[] dArr, int i10) {
        this.f١١٨٥١b = dArr;
        this.f١١٨٥٢c = i10;
    }

    @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
    public j0.b a(int i10) {
        if (i10 >= this.f١١٨٥٢c) {
            return new o(Arrays.copyOf(this.f١١٨٥١b, i10), this.f١١٨٥٢c);
        }
        throw new IllegalArgumentException();
    }
}
