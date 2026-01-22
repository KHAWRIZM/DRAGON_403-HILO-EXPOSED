package com.google.common.collect;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class j extends AbstractMap implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    private static final Object f١٠٤٣٢j = new Object();

    /* renamed from: a, reason: collision with root package name */
    private transient Object f١٠٤٣٣a;

    /* renamed from: b, reason: collision with root package name */
    transient int[] f١٠٤٣٤b;

    /* renamed from: c, reason: collision with root package name */
    transient Object[] f١٠٤٣٥c;

    /* renamed from: d, reason: collision with root package name */
    transient Object[] f١٠٤٣٦d;

    /* renamed from: e, reason: collision with root package name */
    private transient int f١٠٤٣٧e;

    /* renamed from: f, reason: collision with root package name */
    private transient int f١٠٤٣٨f;

    /* renamed from: g, reason: collision with root package name */
    private transient Set f١٠٤٣٩g;

    /* renamed from: h, reason: collision with root package name */
    private transient Set f١٠٤٤٠h;

    /* renamed from: i, reason: collision with root package name */
    private transient Collection f١٠٤٤١i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends e {
        a() {
            super(j.this, null);
        }

        @Override // com.google.common.collect.j.e
        Object b(int i10) {
            return j.this.I(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b extends e {
        b() {
            super(j.this, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.j.e
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry b(int i10) {
            return new g(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends e {
        c() {
            super(j.this, null);
        }

        @Override // com.google.common.collect.j.e
        Object b(int i10) {
            return j.this.Y(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d extends AbstractSet {
        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            j.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map y10 = j.this.y();
            if (y10 != null) {
                return y10.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int F = j.this.F(entry.getKey());
            if (F == -1 || !k8.f.a(j.this.Y(F), entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return j.this.A();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map y10 = j.this.y();
            if (y10 != null) {
                return y10.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!j.this.L()) {
                int D = j.this.D();
                int f10 = l.f(entry.getKey(), entry.getValue(), D, j.this.P(), j.this.N(), j.this.O(), j.this.Q());
                if (f10 == -1) {
                    return false;
                }
                j.this.K(f10, D);
                j.g(j.this);
                j.this.E();
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return j.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class f extends AbstractSet {
        f() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            j.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return j.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return j.this.J();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map y10 = j.this.y();
            if (y10 != null) {
                return y10.keySet().remove(obj);
            }
            if (j.this.M(obj) != j.f١٠٤٣٢j) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return j.this.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public final class g extends com.google.common.collect.d {

        /* renamed from: a, reason: collision with root package name */
        private final Object f١٠٤٥١a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٠٤٥٢b;

        g(int i10) {
            this.f١٠٤٥١a = j.this.I(i10);
            this.f١٠٤٥٢b = i10;
        }

        private void a() {
            int i10 = this.f١٠٤٥٢b;
            if (i10 == -1 || i10 >= j.this.size() || !k8.f.a(this.f١٠٤٥١a, j.this.I(this.f١٠٤٥٢b))) {
                this.f١٠٤٥٢b = j.this.F(this.f١٠٤٥١a);
            }
        }

        @Override // com.google.common.collect.d, java.util.Map.Entry
        public Object getKey() {
            return this.f١٠٤٥١a;
        }

        @Override // com.google.common.collect.d, java.util.Map.Entry
        public Object getValue() {
            Map y10 = j.this.y();
            if (y10 != null) {
                return b0.a(y10.get(this.f١٠٤٥١a));
            }
            a();
            int i10 = this.f١٠٤٥٢b;
            if (i10 != -1) {
                return j.this.Y(i10);
            }
            return b0.b();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Map y10 = j.this.y();
            if (y10 != null) {
                return b0.a(y10.put(this.f١٠٤٥١a, obj));
            }
            a();
            int i10 = this.f١٠٤٥٢b;
            if (i10 != -1) {
                Object Y = j.this.Y(i10);
                j.this.X(this.f١٠٤٥٢b, obj);
                return Y;
            }
            j.this.put(this.f١٠٤٥١a, obj);
            return b0.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class h extends AbstractCollection {
        h() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            j.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return j.this.Z();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return j.this.size();
        }
    }

    j(int i10) {
        G(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() {
        return (1 << (this.f١٠٤٣٧e & 31)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(Object obj) {
        if (L()) {
            return -1;
        }
        int c10 = p.c(obj);
        int D = D();
        int h10 = l.h(P(), c10 & D);
        if (h10 == 0) {
            return -1;
        }
        int b10 = l.b(c10, D);
        do {
            int i10 = h10 - 1;
            int z10 = z(i10);
            if (l.b(z10, D) == b10 && k8.f.a(obj, I(i10))) {
                return i10;
            }
            h10 = l.c(z10, D);
        } while (h10 != 0);
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object I(int i10) {
        return O()[i10];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object M(Object obj) {
        if (L()) {
            return f١٠٤٣٢j;
        }
        int D = D();
        int f10 = l.f(obj, null, D, P(), N(), O(), null);
        if (f10 == -1) {
            return f١٠٤٣٢j;
        }
        Object Y = Y(f10);
        K(f10, D);
        this.f١٠٤٣٨f--;
        E();
        return Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] N() {
        int[] iArr = this.f١٠٤٣٤b;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] O() {
        Object[] objArr = this.f١٠٤٣٥c;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object P() {
        Object obj = this.f١٠٤٣٣a;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] Q() {
        Object[] objArr = this.f١٠٤٣٦d;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private void S(int i10) {
        int min;
        int length = N().length;
        if (i10 > length && (min = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            R(min);
        }
    }

    private int T(int i10, int i11, int i12, int i13) {
        Object a10 = l.a(i11);
        int i14 = i11 - 1;
        if (i13 != 0) {
            l.i(a10, i12 & i14, i13 + 1);
        }
        Object P = P();
        int[] N = N();
        for (int i15 = 0; i15 <= i10; i15++) {
            int h10 = l.h(P, i15);
            while (h10 != 0) {
                int i16 = h10 - 1;
                int i17 = N[i16];
                int b10 = l.b(i17, i10) | i15;
                int i18 = b10 & i14;
                int h11 = l.h(a10, i18);
                l.i(a10, i18, h10);
                N[i16] = l.d(b10, h11, i14);
                h10 = l.c(i17, i10);
            }
        }
        this.f١٠٤٣٣a = a10;
        V(i14);
        return i14;
    }

    private void U(int i10, int i11) {
        N()[i10] = i11;
    }

    private void V(int i10) {
        this.f١٠٤٣٧e = l.d(this.f١٠٤٣٧e, 32 - Integer.numberOfLeadingZeros(i10), 31);
    }

    private void W(int i10, Object obj) {
        O()[i10] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(int i10, Object obj) {
        Q()[i10] = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object Y(int i10) {
        return Q()[i10];
    }

    static /* synthetic */ int g(j jVar) {
        int i10 = jVar.f١٠٤٣٨f;
        jVar.f١٠٤٣٨f = i10 - 1;
        return i10;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            G(readInt);
            for (int i10 = 0; i10 < readInt; i10++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        StringBuilder sb = new StringBuilder(25);
        sb.append("Invalid size: ");
        sb.append(readInt);
        throw new InvalidObjectException(sb.toString());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator A = A();
        while (A.hasNext()) {
            Map.Entry entry = (Map.Entry) A.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static j x(int i10) {
        return new j(i10);
    }

    private int z(int i10) {
        return N()[i10];
    }

    Iterator A() {
        Map y10 = y();
        if (y10 != null) {
            return y10.entrySet().iterator();
        }
        return new b();
    }

    int B() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    int C(int i10) {
        int i11 = i10 + 1;
        if (i11 >= this.f١٠٤٣٨f) {
            return -1;
        }
        return i11;
    }

    void E() {
        this.f١٠٤٣٧e += 32;
    }

    void G(int i10) {
        boolean z10;
        if (i10 >= 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        k8.h.e(z10, "Expected size must be >= 0");
        this.f١٠٤٣٧e = l8.a.a(i10, 1, 1073741823);
    }

    void H(int i10, Object obj, Object obj2, int i11, int i12) {
        U(i10, l.d(i11, 0, i12));
        W(i10, obj);
        X(i10, obj2);
    }

    Iterator J() {
        Map y10 = y();
        if (y10 != null) {
            return y10.keySet().iterator();
        }
        return new a();
    }

    void K(int i10, int i11) {
        Object P = P();
        int[] N = N();
        Object[] O = O();
        Object[] Q = Q();
        int size = size();
        int i12 = size - 1;
        if (i10 < i12) {
            Object obj = O[i12];
            O[i10] = obj;
            Q[i10] = Q[i12];
            O[i12] = null;
            Q[i12] = null;
            N[i10] = N[i12];
            N[i12] = 0;
            int c10 = p.c(obj) & i11;
            int h10 = l.h(P, c10);
            if (h10 == size) {
                l.i(P, c10, i10 + 1);
                return;
            }
            while (true) {
                int i13 = h10 - 1;
                int i14 = N[i13];
                int c11 = l.c(i14, i11);
                if (c11 == size) {
                    N[i13] = l.d(i14, i10 + 1, i11);
                    return;
                }
                h10 = c11;
            }
        } else {
            O[i10] = null;
            Q[i10] = null;
            N[i10] = 0;
        }
    }

    boolean L() {
        if (this.f١٠٤٣٣a == null) {
            return true;
        }
        return false;
    }

    void R(int i10) {
        this.f١٠٤٣٤b = Arrays.copyOf(N(), i10);
        this.f١٠٤٣٥c = Arrays.copyOf(O(), i10);
        this.f١٠٤٣٦d = Arrays.copyOf(Q(), i10);
    }

    Iterator Z() {
        Map y10 = y();
        if (y10 != null) {
            return y10.values().iterator();
        }
        return new c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (L()) {
            return;
        }
        E();
        Map y10 = y();
        if (y10 != null) {
            this.f١٠٤٣٧e = l8.a.a(size(), 3, 1073741823);
            y10.clear();
            this.f١٠٤٣٣a = null;
            this.f١٠٤٣٨f = 0;
            return;
        }
        Arrays.fill(O(), 0, this.f١٠٤٣٨f, (Object) null);
        Arrays.fill(Q(), 0, this.f١٠٤٣٨f, (Object) null);
        l.g(P());
        Arrays.fill(N(), 0, this.f١٠٤٣٨f, 0);
        this.f١٠٤٣٨f = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Map y10 = y();
        if (y10 != null) {
            return y10.containsKey(obj);
        }
        if (F(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        Map y10 = y();
        if (y10 != null) {
            return y10.containsValue(obj);
        }
        for (int i10 = 0; i10 < this.f١٠٤٣٨f; i10++) {
            if (k8.f.a(obj, Y(i10))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f١٠٤٤٠h;
        if (set == null) {
            Set t10 = t();
            this.f١٠٤٤٠h = t10;
            return t10;
        }
        return set;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        Map y10 = y();
        if (y10 != null) {
            return y10.get(obj);
        }
        int F = F(obj);
        if (F == -1) {
            return null;
        }
        p(F);
        return Y(F);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f١٠٤٣٩g;
        if (set == null) {
            Set v10 = v();
            this.f١٠٤٣٩g = v10;
            return v10;
        }
        return set;
    }

    void p(int i10) {
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        int T;
        int i10;
        if (L()) {
            r();
        }
        Map y10 = y();
        if (y10 != null) {
            return y10.put(obj, obj2);
        }
        int[] N = N();
        Object[] O = O();
        Object[] Q = Q();
        int i11 = this.f١٠٤٣٨f;
        int i12 = i11 + 1;
        int c10 = p.c(obj);
        int D = D();
        int i13 = c10 & D;
        int h10 = l.h(P(), i13);
        if (h10 == 0) {
            if (i12 > D) {
                T = T(D, l.e(D), c10, i11);
                i10 = T;
            } else {
                l.i(P(), i13, i12);
                i10 = D;
            }
        } else {
            int b10 = l.b(c10, D);
            int i14 = 0;
            while (true) {
                int i15 = h10 - 1;
                int i16 = N[i15];
                if (l.b(i16, D) == b10 && k8.f.a(obj, O[i15])) {
                    Object obj3 = Q[i15];
                    Q[i15] = obj2;
                    p(i15);
                    return obj3;
                }
                int c11 = l.c(i16, D);
                i14++;
                if (c11 == 0) {
                    if (i14 >= 9) {
                        return s().put(obj, obj2);
                    }
                    if (i12 > D) {
                        T = T(D, l.e(D), c10, i11);
                    } else {
                        N[i15] = l.d(i16, i12, D);
                    }
                } else {
                    h10 = c11;
                }
            }
        }
        S(i12);
        H(i11, obj, obj2, c10, i10);
        this.f١٠٤٣٨f = i12;
        E();
        return null;
    }

    int q(int i10, int i11) {
        return i10 - 1;
    }

    int r() {
        k8.h.o(L(), "Arrays already allocated");
        int i10 = this.f١٠٤٣٧e;
        int j10 = l.j(i10);
        this.f١٠٤٣٣a = l.a(j10);
        V(j10 - 1);
        this.f١٠٤٣٤b = new int[i10];
        this.f١٠٤٣٥c = new Object[i10];
        this.f١٠٤٣٦d = new Object[i10];
        return i10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        Map y10 = y();
        if (y10 != null) {
            return y10.remove(obj);
        }
        Object M = M(obj);
        if (M == f١٠٤٣٢j) {
            return null;
        }
        return M;
    }

    Map s() {
        Map u10 = u(D() + 1);
        int B2 = B();
        while (B2 >= 0) {
            u10.put(I(B2), Y(B2));
            B2 = C(B2);
        }
        this.f١٠٤٣٣a = u10;
        this.f١٠٤٣٤b = null;
        this.f١٠٤٣٥c = null;
        this.f١٠٤٣٦d = null;
        E();
        return u10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        Map y10 = y();
        if (y10 != null) {
            return y10.size();
        }
        return this.f١٠٤٣٨f;
    }

    Set t() {
        return new d();
    }

    Map u(int i10) {
        return new LinkedHashMap(i10, 1.0f);
    }

    Set v() {
        return new f();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f١٠٤٤١i;
        if (collection == null) {
            Collection w10 = w();
            this.f١٠٤٤١i = w10;
            return w10;
        }
        return collection;
    }

    Collection w() {
        return new h();
    }

    Map y() {
        Object obj = this.f١٠٤٣٣a;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private abstract class e implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        int f١٠٤٤٦a;

        /* renamed from: b, reason: collision with root package name */
        int f١٠٤٤٧b;

        /* renamed from: c, reason: collision with root package name */
        int f١٠٤٤٨c;

        private e() {
            this.f١٠٤٤٦a = j.this.f١٠٤٣٧e;
            this.f١٠٤٤٧b = j.this.B();
            this.f١٠٤٤٨c = -1;
        }

        private void a() {
            if (j.this.f١٠٤٣٧e == this.f١٠٤٤٦a) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        abstract Object b(int i10);

        void c() {
            this.f١٠٤٤٦a += 32;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f١٠٤٤٧b >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            a();
            if (hasNext()) {
                int i10 = this.f١٠٤٤٧b;
                this.f١٠٤٤٨c = i10;
                Object b10 = b(i10);
                this.f١٠٤٤٧b = j.this.C(this.f١٠٤٤٧b);
                return b10;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z10;
            a();
            if (this.f١٠٤٤٨c >= 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            com.google.common.collect.h.c(z10);
            c();
            j jVar = j.this;
            jVar.remove(jVar.I(this.f١٠٤٤٨c));
            this.f١٠٤٤٧b = j.this.q(this.f١٠٤٤٧b, this.f١٠٤٤٨c);
            this.f١٠٤٤٨c = -1;
        }

        /* synthetic */ e(j jVar, a aVar) {
            this();
        }
    }
}
