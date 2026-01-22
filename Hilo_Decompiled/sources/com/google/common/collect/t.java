package com.google.common.collect;

import com.google.common.collect.q;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class t implements Map, Serializable {

    /* renamed from: d, reason: collision with root package name */
    static final Map.Entry[] f١٠٤٨٥d = new Map.Entry[0];

    /* renamed from: a, reason: collision with root package name */
    private transient u f١٠٤٨٦a;

    /* renamed from: b, reason: collision with root package name */
    private transient u f١٠٤٨٧b;

    /* renamed from: c, reason: collision with root package name */
    private transient q f١٠٤٨٨c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Comparator f١٠٤٨٩a;

        /* renamed from: b, reason: collision with root package name */
        Object[] f١٠٤٩٠b;

        /* renamed from: c, reason: collision with root package name */
        int f١٠٤٩١c;

        /* renamed from: d, reason: collision with root package name */
        boolean f١٠٤٩٢d;

        /* renamed from: e, reason: collision with root package name */
        C٠١٢٦a f١٠٤٩٣e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.t$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class C٠١٢٦a {

            /* renamed from: a, reason: collision with root package name */
            private final Object f١٠٤٩٤a;

            /* renamed from: b, reason: collision with root package name */
            private final Object f١٠٤٩٥b;

            /* renamed from: c, reason: collision with root package name */
            private final Object f١٠٤٩٦c;

            /* JADX INFO: Access modifiers changed from: package-private */
            public C٠١٢٦a(Object obj, Object obj2, Object obj3) {
                this.f١٠٤٩٤a = obj;
                this.f١٠٤٩٥b = obj2;
                this.f١٠٤٩٦c = obj3;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                String valueOf = String.valueOf(this.f١٠٤٩٤a);
                String valueOf2 = String.valueOf(this.f١٠٤٩٥b);
                String valueOf3 = String.valueOf(this.f١٠٤٩٤a);
                String valueOf4 = String.valueOf(this.f١٠٤٩٦c);
                StringBuilder sb = new StringBuilder(valueOf.length() + 39 + valueOf2.length() + valueOf3.length() + valueOf4.length());
                sb.append("Multiple entries with same key: ");
                sb.append(valueOf);
                sb.append("=");
                sb.append(valueOf2);
                sb.append(" and ");
                sb.append(valueOf3);
                sb.append("=");
                sb.append(valueOf4);
                return new IllegalArgumentException(sb.toString());
            }
        }

        public a() {
            this(4);
        }

        private t b(boolean z10) {
            Object[] objArr;
            C٠١٢٦a r62;
            C٠١٢٦a r02;
            if (z10 && (r02 = this.f١٠٤٩٣e) != null) {
                throw r02.a();
            }
            int i10 = this.f١٠٤٩١c;
            if (this.f١٠٤٨٩a == null) {
                objArr = this.f١٠٤٩٠b;
            } else {
                if (this.f١٠٤٩٢d) {
                    this.f١٠٤٩٠b = Arrays.copyOf(this.f١٠٤٩٠b, i10 * 2);
                }
                objArr = this.f١٠٤٩٠b;
                if (!z10) {
                    objArr = e(objArr, this.f١٠٤٩١c);
                    if (objArr.length < this.f١٠٤٩٠b.length) {
                        i10 = objArr.length >>> 1;
                    }
                }
                j(objArr, i10, this.f١٠٤٨٩a);
            }
            this.f١٠٤٩٢d = true;
            g0 p10 = g0.p(i10, objArr, this);
            if (z10 && (r62 = this.f١٠٤٩٣e) != null) {
                throw r62.a();
            }
            return p10;
        }

        private void d(int i10) {
            int i11 = i10 * 2;
            Object[] objArr = this.f١٠٤٩٠b;
            if (i11 > objArr.length) {
                this.f١٠٤٩٠b = Arrays.copyOf(objArr, q.b.a(objArr.length, i11));
                this.f١٠٤٩٢d = false;
            }
        }

        private Object[] e(Object[] objArr, int i10) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                Object obj = objArr[i11 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i11);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i10 - bitSet.cardinality()) * 2];
            int i12 = 0;
            int i13 = 0;
            while (i12 < i10 * 2) {
                if (bitSet.get(i12 >>> 1)) {
                    i12 += 2;
                } else {
                    int i14 = i13 + 1;
                    int i15 = i12 + 1;
                    Object obj2 = objArr[i12];
                    Objects.requireNonNull(obj2);
                    objArr2[i13] = obj2;
                    i13 += 2;
                    i12 += 2;
                    Object obj3 = objArr[i15];
                    Objects.requireNonNull(obj3);
                    objArr2[i14] = obj3;
                }
            }
            return objArr2;
        }

        static void j(Object[] objArr, int i10, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * 2;
                Object obj = objArr[i12];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i12 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i11] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i10, d0.a(comparator).b(y.h()));
            for (int i13 = 0; i13 < i10; i13++) {
                int i14 = i13 * 2;
                objArr[i14] = entryArr[i13].getKey();
                objArr[i14 + 1] = entryArr[i13].getValue();
            }
        }

        public t a() {
            return c();
        }

        public t c() {
            return b(true);
        }

        public a f(Object obj, Object obj2) {
            d(this.f١٠٤٩١c + 1);
            h.a(obj, obj2);
            Object[] objArr = this.f١٠٤٩٠b;
            int i10 = this.f١٠٤٩١c;
            objArr[i10 * 2] = obj;
            objArr[(i10 * 2) + 1] = obj2;
            this.f١٠٤٩١c = i10 + 1;
            return this;
        }

        public a g(Map.Entry entry) {
            return f(entry.getKey(), entry.getValue());
        }

        public a h(Iterable iterable) {
            if (iterable instanceof Collection) {
                d(this.f١٠٤٩١c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                g((Map.Entry) it.next());
            }
            return this;
        }

        public a i(Map map) {
            return h(map.entrySet());
        }

        a(int i10) {
            this.f١٠٤٩٠b = new Object[i10 * 2];
            this.f١٠٤٩١c = 0;
            this.f١٠٤٩٢d = false;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    static class b implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: a, reason: collision with root package name */
        private final Object f١٠٤٩٧a;

        /* renamed from: b, reason: collision with root package name */
        private final Object f١٠٤٩٨b;

        b(t tVar) {
            Object[] objArr = new Object[tVar.size()];
            Object[] objArr2 = new Object[tVar.size()];
            m0 it = tVar.entrySet().iterator();
            int i10 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                objArr[i10] = entry.getKey();
                objArr2[i10] = entry.getValue();
                i10++;
            }
            this.f١٠٤٩٧a = objArr;
            this.f١٠٤٩٨b = objArr2;
        }

        final Object a() {
            Object[] objArr = (Object[]) this.f١٠٤٩٧a;
            Object[] objArr2 = (Object[]) this.f١٠٤٩٨b;
            a b10 = b(objArr.length);
            for (int i10 = 0; i10 < objArr.length; i10++) {
                b10.f(objArr[i10], objArr2[i10]);
            }
            return b10.c();
        }

        a b(int i10) {
            return new a(i10);
        }

        final Object readResolve() {
            Object obj = this.f١٠٤٩٧a;
            if (!(obj instanceof u)) {
                return a();
            }
            u uVar = (u) obj;
            q qVar = (q) this.f١٠٤٩٨b;
            a b10 = b(uVar.size());
            m0 it = uVar.iterator();
            m0 it2 = qVar.iterator();
            while (it.hasNext()) {
                b10.f(it.next(), it2.next());
            }
            return b10.c();
        }
    }

    public static a c() {
        return new a();
    }

    public static t d(Iterable iterable) {
        int i10;
        if (iterable instanceof Collection) {
            i10 = ((Collection) iterable).size();
        } else {
            i10 = 4;
        }
        a aVar = new a(i10);
        aVar.h(iterable);
        return aVar.a();
    }

    public static t j() {
        return g0.f١٠٤١١h;
    }

    public static t k(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        h.a(obj, obj2);
        h.a(obj3, obj4);
        h.a(obj5, obj6);
        h.a(obj7, obj8);
        return g0.o(4, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8});
    }

    public static t l(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        h.a(obj, obj2);
        h.a(obj3, obj4);
        h.a(obj5, obj6);
        h.a(obj7, obj8);
        h.a(obj9, obj10);
        return g0.o(5, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10});
    }

    public static t m(Map.Entry... entryArr) {
        return d(Arrays.asList(entryArr));
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    abstract u e();

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return y.b(this, obj);
    }

    abstract u f();

    abstract q g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        if (obj3 != null) {
            return obj3;
        }
        return obj2;
    }

    @Override // java.util.Map
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public u entrySet() {
        u uVar = this.f١٠٤٨٦a;
        if (uVar == null) {
            u e10 = e();
            this.f١٠٤٨٦a = e10;
            return e10;
        }
        return uVar;
    }

    @Override // java.util.Map
    public int hashCode() {
        return j0.b(entrySet());
    }

    @Override // java.util.Map
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public u keySet() {
        u uVar = this.f١٠٤٨٧b;
        if (uVar == null) {
            u f10 = f();
            this.f١٠٤٨٧b = f10;
            return f10;
        }
        return uVar;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Map
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public q values() {
        q qVar = this.f١٠٤٨٨c;
        if (qVar == null) {
            q g10 = g();
            this.f١٠٤٨٨c = g10;
            return g10;
        }
        return qVar;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return y.g(this);
    }

    Object writeReplace() {
        return new b(this);
    }
}
