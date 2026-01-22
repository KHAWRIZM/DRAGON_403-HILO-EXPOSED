package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class u0 extends c implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    private static final u0 f٣٥١٤d = new u0(new Object[0], 0, false);

    /* renamed from: b, reason: collision with root package name */
    private Object[] f٣٥١٥b;

    /* renamed from: c, reason: collision with root package name */
    private int f٣٥١٦c;

    private u0(Object[] objArr, int i10, boolean z10) {
        super(z10);
        this.f٣٥١٥b = objArr;
        this.f٣٥١٦c = i10;
    }

    private static Object[] e(int i10) {
        return new Object[i10];
    }

    public static u0 f() {
        return f٣٥١٤d;
    }

    private void h(int i10) {
        if (i10 >= 0 && i10 < this.f٣٥١٦c) {
        } else {
            throw new IndexOutOfBoundsException(i(i10));
        }
    }

    private String i(int i10) {
        return "Index:" + i10 + ", Size:" + this.f٣٥١٦c;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        d();
        int i10 = this.f٣٥١٦c;
        Object[] objArr = this.f٣٥١٥b;
        if (i10 == objArr.length) {
            this.f٣٥١٥b = Arrays.copyOf(objArr, ((i10 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f٣٥١٥b;
        int i11 = this.f٣٥١٦c;
        this.f٣٥١٦c = i11 + 1;
        objArr2[i11] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i10) {
        h(i10);
        return this.f٣٥١٥b[i10];
    }

    @Override // androidx.datastore.preferences.protobuf.u.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public u0 a(int i10) {
        if (i10 >= this.f٣٥١٦c) {
            return new u0(Arrays.copyOf(this.f٣٥١٥b, i10), this.f٣٥١٦c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.datastore.preferences.protobuf.c, java.util.AbstractList, java.util.List
    public Object remove(int i10) {
        d();
        h(i10);
        Object[] objArr = this.f٣٥١٥b;
        Object obj = objArr[i10];
        if (i10 < this.f٣٥١٦c - 1) {
            System.arraycopy(objArr, i10 + 1, objArr, i10, (r2 - i10) - 1);
        }
        this.f٣٥١٦c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i10, Object obj) {
        d();
        h(i10);
        Object[] objArr = this.f٣٥١٥b;
        Object obj2 = objArr[i10];
        objArr[i10] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f٣٥١٦c;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, Object obj) {
        int i11;
        d();
        if (i10 >= 0 && i10 <= (i11 = this.f٣٥١٦c)) {
            Object[] objArr = this.f٣٥١٥b;
            if (i11 < objArr.length) {
                System.arraycopy(objArr, i10, objArr, i10 + 1, i11 - i10);
            } else {
                Object[] e10 = e(((i11 * 3) / 2) + 1);
                System.arraycopy(this.f٣٥١٥b, 0, e10, 0, i10);
                System.arraycopy(this.f٣٥١٥b, i10, e10, i10 + 1, this.f٣٥١٦c - i10);
                this.f٣٥١٥b = e10;
            }
            this.f٣٥١٥b[i10] = obj;
            this.f٣٥١٦c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(i(i10));
    }
}
