package com.google.protobuf;

import com.google.protobuf.j0;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class d0 extends d implements j0.f, RandomAccess, s1 {

    /* renamed from: d, reason: collision with root package name */
    private static final d0 f١٠٩٥٧d;

    /* renamed from: b, reason: collision with root package name */
    private float[] f١٠٩٥٨b;

    /* renamed from: c, reason: collision with root package name */
    private int f١٠٩٥٩c;

    static {
        d0 d0Var = new d0(new float[0], 0);
        f١٠٩٥٧d = d0Var;
        d0Var.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0() {
        this(new float[10], 0);
    }

    private void i(int i10, float f10) {
        int i11;
        d();
        if (i10 >= 0 && i10 <= (i11 = this.f١٠٩٥٩c)) {
            float[] fArr = this.f١٠٩٥٨b;
            if (i11 < fArr.length) {
                System.arraycopy(fArr, i10, fArr, i10 + 1, i11 - i10);
            } else {
                float[] fArr2 = new float[((i11 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i10);
                System.arraycopy(this.f١٠٩٥٨b, i10, fArr2, i10 + 1, this.f١٠٩٥٩c - i10);
                this.f١٠٩٥٨b = fArr2;
            }
            this.f١٠٩٥٨b[i10] = f10;
            this.f١٠٩٥٩c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(o(i10));
    }

    public static d0 k() {
        return f١٠٩٥٧d;
    }

    private void l(int i10) {
        if (i10 >= 0 && i10 < this.f١٠٩٥٩c) {
        } else {
            throw new IndexOutOfBoundsException(o(i10));
        }
    }

    private String o(int i10) {
        return "Index:" + i10 + ", Size:" + this.f١٠٩٥٩c;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        d();
        j0.a(collection);
        if (!(collection instanceof d0)) {
            return super.addAll(collection);
        }
        d0 d0Var = (d0) collection;
        int i10 = d0Var.f١٠٩٥٩c;
        if (i10 == 0) {
            return false;
        }
        int i11 = this.f١٠٩٥٩c;
        if (Integer.MAX_VALUE - i11 >= i10) {
            int i12 = i11 + i10;
            float[] fArr = this.f١٠٩٥٨b;
            if (i12 > fArr.length) {
                this.f١٠٩٥٨b = Arrays.copyOf(fArr, i12);
            }
            System.arraycopy(d0Var.f١٠٩٥٨b, 0, this.f١٠٩٥٨b, this.f١٠٩٥٩c, d0Var.f١٠٩٥٩c);
            this.f١٠٩٥٩c = i12;
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
    public void add(int i10, Float f10) {
        i(i10, f10.floatValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return super.equals(obj);
        }
        d0 d0Var = (d0) obj;
        if (this.f١٠٩٥٩c != d0Var.f١٠٩٥٩c) {
            return false;
        }
        float[] fArr = d0Var.f١٠٩٥٨b;
        for (int i10 = 0; i10 < this.f١٠٩٥٩c; i10++) {
            if (Float.floatToIntBits(this.f١٠٩٥٨b[i10]) != Float.floatToIntBits(fArr[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f10) {
        h(f10.floatValue());
        return true;
    }

    public void h(float f10) {
        d();
        int i10 = this.f١٠٩٥٩c;
        float[] fArr = this.f١٠٩٥٨b;
        if (i10 == fArr.length) {
            float[] fArr2 = new float[((i10 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i10);
            this.f١٠٩٥٨b = fArr2;
        }
        float[] fArr3 = this.f١٠٩٥٨b;
        int i11 = this.f١٠٩٥٩c;
        this.f١٠٩٥٩c = i11 + 1;
        fArr3[i11] = f10;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i10 = 1;
        for (int i11 = 0; i11 < this.f١٠٩٥٩c; i11++) {
            i10 = (i10 * 31) + Float.floatToIntBits(this.f١٠٩٥٨b[i11]);
        }
        return i10;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.f١٠٩٥٨b[i10] == floatValue) {
                return i10;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Float get(int i10) {
        return Float.valueOf(n(i10));
    }

    public float n(int i10) {
        l(i10);
        return this.f١٠٩٥٨b[i10];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Float remove(int i10) {
        d();
        l(i10);
        float[] fArr = this.f١٠٩٥٨b;
        float f10 = fArr[i10];
        if (i10 < this.f١٠٩٥٩c - 1) {
            System.arraycopy(fArr, i10 + 1, fArr, i10, (r2 - i10) - 1);
        }
        this.f١٠٩٥٩c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Float set(int i10, Float f10) {
        return Float.valueOf(r(i10, f10.floatValue()));
    }

    public float r(int i10, float f10) {
        d();
        l(i10);
        float[] fArr = this.f١٠٩٥٨b;
        float f11 = fArr[i10];
        fArr[i10] = f10;
        return f11;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i10, int i11) {
        d();
        if (i11 >= i10) {
            float[] fArr = this.f١٠٩٥٨b;
            System.arraycopy(fArr, i11, fArr, i10, this.f١٠٩٥٩c - i11);
            this.f١٠٩٥٩c -= i11 - i10;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f١٠٩٥٩c;
    }

    private d0(float[] fArr, int i10) {
        this.f١٠٩٥٨b = fArr;
        this.f١٠٩٥٩c = i10;
    }

    @Override // com.google.protobuf.j0.i, com.google.protobuf.j0.f
    public j0.f a(int i10) {
        if (i10 >= this.f١٠٩٥٩c) {
            return new d0(Arrays.copyOf(this.f١٠٩٥٨b, i10), this.f١٠٩٥٩c);
        }
        throw new IllegalArgumentException();
    }
}
