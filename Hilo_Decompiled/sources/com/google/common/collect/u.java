package com.google.common.collect;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class u extends q implements Set {

    /* renamed from: b, reason: collision with root package name */
    private transient s f١٠٤٩٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        final Object[] f١٠٥٠٠a;

        a(Object[] objArr) {
            this.f١٠٥٠٠a = objArr;
        }

        Object readResolve() {
            return u.n(this.f١٠٥٠٠a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(int i10) {
        int max = Math.max(i10, 2);
        boolean z10 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z10 = false;
        }
        k8.h.e(z10, "collection too large");
        return 1073741824;
    }

    private static u m(int i10, Object... objArr) {
        if (i10 != 0) {
            if (i10 != 1) {
                int l10 = l(i10);
                Object[] objArr2 = new Object[l10];
                int i11 = l10 - 1;
                int i12 = 0;
                int i13 = 0;
                for (int i14 = 0; i14 < i10; i14++) {
                    Object a10 = c0.a(objArr[i14], i14);
                    int hashCode = a10.hashCode();
                    int b10 = p.b(hashCode);
                    while (true) {
                        int i15 = b10 & i11;
                        Object obj = objArr2[i15];
                        if (obj == null) {
                            objArr[i13] = a10;
                            objArr2[i15] = a10;
                            i12 += hashCode;
                            i13++;
                            break;
                        }
                        if (obj.equals(a10)) {
                            break;
                        }
                        b10++;
                    }
                }
                Arrays.fill(objArr, i13, i10, (Object) null);
                if (i13 == 1) {
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    return new k0(obj2);
                }
                if (l(i13) < l10 / 2) {
                    return m(i13, objArr);
                }
                if (u(i13, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i13);
                }
                return new h0(objArr, i12, objArr2, i11, i13);
            }
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return r(obj3);
        }
        return q();
    }

    public static u n(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            if (length != 1) {
                return m(objArr.length, (Object[]) objArr.clone());
            }
            return r(objArr[0]);
        }
        return q();
    }

    public static u q() {
        return h0.f١٠٤٢٦i;
    }

    public static u r(Object obj) {
        return new k0(obj);
    }

    public static u s(Object obj, Object obj2, Object obj3) {
        return m(3, obj, obj2, obj3);
    }

    public static u t(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        boolean z10;
        if (objArr.length <= 2147483641) {
            z10 = true;
        } else {
            z10 = false;
        }
        k8.h.e(z10, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return m(length, objArr2);
    }

    private static boolean u(int i10, int i11) {
        return i10 < (i11 >> 1) + (i11 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof u) && p() && ((u) obj).p() && hashCode() != obj.hashCode()) {
            return false;
        }
        return j0.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return j0.b(this);
    }

    @Override // com.google.common.collect.q
    /* renamed from: i */
    public abstract m0 iterator();

    public s k() {
        s sVar = this.f١٠٤٩٩b;
        if (sVar == null) {
            s o10 = o();
            this.f١٠٤٩٩b = o10;
            return o10;
        }
        return sVar;
    }

    s o() {
        return s.k(toArray());
    }

    boolean p() {
        return false;
    }

    @Override // com.google.common.collect.q
    Object writeReplace() {
        return new a(toArray());
    }
}
