package com.google.common.collect;

import com.google.common.collect.t;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import kotlin.UByte;
import kotlin.UShort;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class g0 extends t {

    /* renamed from: h, reason: collision with root package name */
    static final t f١٠٤١١h = new g0(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    /* renamed from: e, reason: collision with root package name */
    private final transient Object f١٠٤١٢e;

    /* renamed from: f, reason: collision with root package name */
    final transient Object[] f١٠٤١٣f;

    /* renamed from: g, reason: collision with root package name */
    private final transient int f١٠٤١٤g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends u {

        /* renamed from: c, reason: collision with root package name */
        private final transient t f١٠٤١٥c;

        /* renamed from: d, reason: collision with root package name */
        private final transient Object[] f١٠٤١٦d;

        /* renamed from: e, reason: collision with root package name */
        private final transient int f١٠٤١٧e;

        /* renamed from: f, reason: collision with root package name */
        private final transient int f١٠٤١٨f;

        /* renamed from: com.google.common.collect.g0$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        class C٠١٢٤a extends s {
            C٠١٢٤a() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return a.this.f١٠٤١٨f;
            }

            @Override // java.util.List
            /* renamed from: x, reason: merged with bridge method [inline-methods] */
            public Map.Entry get(int i10) {
                k8.h.g(i10, a.this.f١٠٤١٨f);
                int i11 = i10 * 2;
                Object obj = a.this.f١٠٤١٦d[a.this.f١٠٤١٧e + i11];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f١٠٤١٦d[i11 + (a.this.f١٠٤١٧e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        a(t tVar, Object[] objArr, int i10, int i11) {
            this.f١٠٤١٥c = tVar;
            this.f١٠٤١٦d = objArr;
            this.f١٠٤١٧e = i10;
            this.f١٠٤١٨f = i11;
        }

        @Override // com.google.common.collect.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f١٠٤١٥c.get(key))) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.q
        int d(Object[] objArr, int i10) {
            return k().d(objArr, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: i */
        public m0 iterator() {
            return k().iterator();
        }

        @Override // com.google.common.collect.u
        s o() {
            return new C٠١٢٤a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f١٠٤١٨f;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class b extends u {

        /* renamed from: c, reason: collision with root package name */
        private final transient t f١٠٤٢٠c;

        /* renamed from: d, reason: collision with root package name */
        private final transient s f١٠٤٢١d;

        b(t tVar, s sVar) {
            this.f١٠٤٢٠c = tVar;
            this.f١٠٤٢١d = sVar;
        }

        @Override // com.google.common.collect.q, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (this.f١٠٤٢٠c.get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.q
        int d(Object[] objArr, int i10) {
            return k().d(objArr, i10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: i */
        public m0 iterator() {
            return k().iterator();
        }

        @Override // com.google.common.collect.u
        public s k() {
            return this.f١٠٤٢١d;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f١٠٤٢٠c.size();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static final class c extends s {

        /* renamed from: c, reason: collision with root package name */
        private final transient Object[] f١٠٤٢٢c;

        /* renamed from: d, reason: collision with root package name */
        private final transient int f١٠٤٢٣d;

        /* renamed from: e, reason: collision with root package name */
        private final transient int f١٠٤٢٤e;

        c(Object[] objArr, int i10, int i11) {
            this.f١٠٤٢٢c = objArr;
            this.f١٠٤٢٣d = i10;
            this.f١٠٤٢٤e = i11;
        }

        @Override // java.util.List
        public Object get(int i10) {
            k8.h.g(i10, this.f١٠٤٢٤e);
            Object obj = this.f١٠٤٢٢c[(i10 * 2) + this.f١٠٤٢٣d];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f١٠٤٢٤e;
        }
    }

    private g0(Object obj, Object[] objArr, int i10) {
        this.f١٠٤١٢e = obj;
        this.f١٠٤١٣f = objArr;
        this.f١٠٤١٤g = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g0 o(int i10, Object[] objArr) {
        return p(i10, objArr, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g0 p(int i10, Object[] objArr, t.a aVar) {
        if (i10 == 0) {
            return (g0) f١٠٤١١h;
        }
        if (i10 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            h.a(obj, obj2);
            return new g0(null, objArr, 1);
        }
        k8.h.k(i10, objArr.length >> 1);
        Object q10 = q(objArr, i10, u.l(i10), 0);
        if (q10 instanceof Object[]) {
            Object[] objArr2 = (Object[]) q10;
            t.a.C٠١٢٦a r42 = (t.a.C٠١٢٦a) objArr2[2];
            if (aVar != null) {
                aVar.f١٠٤٩٣e = r42;
                Object obj3 = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                q10 = obj3;
                i10 = intValue;
            } else {
                throw r42.a();
            }
        }
        return new g0(q10, objArr, i10);
    }

    private static Object q(Object[] objArr, int i10, int i11, int i12) {
        t.a.C٠١٢٦a r22 = null;
        if (i10 == 1) {
            Object obj = objArr[i12];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i12 ^ 1];
            Objects.requireNonNull(obj2);
            h.a(obj, obj2);
            return null;
        }
        int i13 = i11 - 1;
        int i14 = -1;
        if (i11 <= 128) {
            byte[] bArr = new byte[i11];
            Arrays.fill(bArr, (byte) -1);
            int i15 = 0;
            for (int i16 = 0; i16 < i10; i16++) {
                int i17 = (i16 * 2) + i12;
                int i18 = (i15 * 2) + i12;
                Object obj3 = objArr[i17];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i17 ^ 1];
                Objects.requireNonNull(obj4);
                h.a(obj3, obj4);
                int b10 = p.b(obj3.hashCode());
                while (true) {
                    int i19 = b10 & i13;
                    int i20 = bArr[i19] & UByte.MAX_VALUE;
                    if (i20 == 255) {
                        bArr[i19] = (byte) i18;
                        if (i15 < i16) {
                            objArr[i18] = obj3;
                            objArr[i18 ^ 1] = obj4;
                        }
                        i15++;
                    } else {
                        if (obj3.equals(objArr[i20])) {
                            int i21 = i20 ^ 1;
                            Object obj5 = objArr[i21];
                            Objects.requireNonNull(obj5);
                            r22 = new t.a.C٠١٢٦a(obj3, obj4, obj5);
                            objArr[i21] = obj4;
                            break;
                        }
                        b10 = i19 + 1;
                    }
                }
            }
            if (i15 != i10) {
                return new Object[]{bArr, Integer.valueOf(i15), r22};
            }
            return bArr;
        }
        if (i11 <= 32768) {
            short[] sArr = new short[i11];
            Arrays.fill(sArr, (short) -1);
            int i22 = 0;
            for (int i23 = 0; i23 < i10; i23++) {
                int i24 = (i23 * 2) + i12;
                int i25 = (i22 * 2) + i12;
                Object obj6 = objArr[i24];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i24 ^ 1];
                Objects.requireNonNull(obj7);
                h.a(obj6, obj7);
                int b11 = p.b(obj6.hashCode());
                while (true) {
                    int i26 = b11 & i13;
                    int i27 = sArr[i26] & UShort.MAX_VALUE;
                    if (i27 == 65535) {
                        sArr[i26] = (short) i25;
                        if (i22 < i23) {
                            objArr[i25] = obj6;
                            objArr[i25 ^ 1] = obj7;
                        }
                        i22++;
                    } else {
                        if (obj6.equals(objArr[i27])) {
                            int i28 = i27 ^ 1;
                            Object obj8 = objArr[i28];
                            Objects.requireNonNull(obj8);
                            r22 = new t.a.C٠١٢٦a(obj6, obj7, obj8);
                            objArr[i28] = obj7;
                            break;
                        }
                        b11 = i26 + 1;
                    }
                }
            }
            if (i22 != i10) {
                return new Object[]{sArr, Integer.valueOf(i22), r22};
            }
            return sArr;
        }
        int[] iArr = new int[i11];
        Arrays.fill(iArr, -1);
        int i29 = 0;
        int i30 = 0;
        while (i29 < i10) {
            int i31 = (i29 * 2) + i12;
            int i32 = (i30 * 2) + i12;
            Object obj9 = objArr[i31];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i31 ^ 1];
            Objects.requireNonNull(obj10);
            h.a(obj9, obj10);
            int b12 = p.b(obj9.hashCode());
            while (true) {
                int i33 = b12 & i13;
                int i34 = iArr[i33];
                if (i34 == i14) {
                    iArr[i33] = i32;
                    if (i30 < i29) {
                        objArr[i32] = obj9;
                        objArr[i32 ^ 1] = obj10;
                    }
                    i30++;
                } else {
                    if (obj9.equals(objArr[i34])) {
                        int i35 = i34 ^ 1;
                        Object obj11 = objArr[i35];
                        Objects.requireNonNull(obj11);
                        r22 = new t.a.C٠١٢٦a(obj9, obj10, obj11);
                        objArr[i35] = obj10;
                        break;
                    }
                    b12 = i33 + 1;
                    i14 = -1;
                }
            }
            i29++;
            i14 = -1;
        }
        if (i30 != i10) {
            return new Object[]{iArr, Integer.valueOf(i30), r22};
        }
        return iArr;
    }

    static Object r(Object obj, Object[] objArr, int i10, int i11, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i10 == 1) {
            Object obj3 = objArr[i11];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i11 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int b10 = p.b(obj2.hashCode());
            while (true) {
                int i12 = b10 & length;
                int i13 = bArr[i12] & UByte.MAX_VALUE;
                if (i13 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i13])) {
                    return objArr[i13 ^ 1];
                }
                b10 = i12 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int b11 = p.b(obj2.hashCode());
            while (true) {
                int i14 = b11 & length2;
                int i15 = sArr[i14] & UShort.MAX_VALUE;
                if (i15 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i15])) {
                    return objArr[i15 ^ 1];
                }
                b11 = i14 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int b12 = p.b(obj2.hashCode());
            while (true) {
                int i16 = b12 & length3;
                int i17 = iArr[i16];
                if (i17 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i17])) {
                    return objArr[i17 ^ 1];
                }
                b12 = i16 + 1;
            }
        }
    }

    @Override // com.google.common.collect.t
    u e() {
        return new a(this, this.f١٠٤١٣f, 0, this.f١٠٤١٤g);
    }

    @Override // com.google.common.collect.t
    u f() {
        return new b(this, new c(this.f١٠٤١٣f, 0, this.f١٠٤١٤g));
    }

    @Override // com.google.common.collect.t
    q g() {
        return new c(this.f١٠٤١٣f, 1, this.f١٠٤١٤g);
    }

    @Override // com.google.common.collect.t, java.util.Map
    public Object get(Object obj) {
        Object r10 = r(this.f١٠٤١٢e, this.f١٠٤١٣f, this.f١٠٤١٤g, 0, obj);
        if (r10 == null) {
            return null;
        }
        return r10;
    }

    @Override // java.util.Map
    public int size() {
        return this.f١٠٤١٤g;
    }
}
