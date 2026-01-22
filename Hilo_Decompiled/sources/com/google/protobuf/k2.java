package com.google.protobuf;

import com.google.protobuf.e1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class k2 implements e1 {

    /* renamed from: b, reason: collision with root package name */
    private static final k2 f١١١٨٥b = new k2(new TreeMap());

    /* renamed from: c, reason: collision with root package name */
    private static final d f١١١٨٦c = new d();

    /* renamed from: a, reason: collision with root package name */
    private final TreeMap f١١١٨٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b implements e1.a {

        /* renamed from: a, reason: collision with root package name */
        private TreeMap f١١١٨٨a = new TreeMap();

        private b() {
        }

        static /* synthetic */ b a() {
            return f();
        }

        private static b f() {
            return new b();
        }

        private c.a g(int i10) {
            if (i10 == 0) {
                return null;
            }
            c.a aVar = (c.a) this.f١١١٨٨a.get(Integer.valueOf(i10));
            if (aVar == null) {
                c.a s10 = c.s();
                this.f١١١٨٨a.put(Integer.valueOf(i10), s10);
                return s10;
            }
            return aVar;
        }

        public b b(int i10, c cVar) {
            if (i10 > 0) {
                this.f١١١٨٨a.put(Integer.valueOf(i10), c.t(cVar));
                return this;
            }
            throw new IllegalArgumentException(i10 + " is not a valid field number.");
        }

        @Override // com.google.protobuf.e1.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public k2 build() {
            if (this.f١١١٨٨a.isEmpty()) {
                return k2.c();
            }
            TreeMap treeMap = new TreeMap();
            for (Map.Entry entry : this.f١١١٨٨a.entrySet()) {
                treeMap.put(entry.getKey(), ((c.a) entry.getValue()).g());
            }
            return new k2(treeMap);
        }

        @Override // com.google.protobuf.e1.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public k2 buildPartial() {
            return build();
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b clone() {
            b e10 = k2.e();
            for (Map.Entry entry : this.f١١١٨٨a.entrySet()) {
                e10.f١١١٨٨a.put((Integer) entry.getKey(), ((c.a) entry.getValue()).clone());
            }
            return e10;
        }

        public boolean h(int i10) {
            return this.f١١١٨٨a.containsKey(Integer.valueOf(i10));
        }

        public b i(int i10, c cVar) {
            if (i10 > 0) {
                if (h(i10)) {
                    g(i10).j(cVar);
                } else {
                    b(i10, cVar);
                }
                return this;
            }
            throw new IllegalArgumentException(i10 + " is not a valid field number.");
        }

        @Override // com.google.protobuf.f1
        public boolean isInitialized() {
            return true;
        }

        public boolean j(int i10, i iVar) {
            int a10 = r2.a(i10);
            int b10 = r2.b(i10);
            if (b10 != 0) {
                if (b10 != 1) {
                    if (b10 != 2) {
                        if (b10 != 3) {
                            if (b10 != 4) {
                                if (b10 == 5) {
                                    g(a10).b(iVar.u());
                                    return true;
                                }
                                throw k0.d();
                            }
                            return false;
                        }
                        b e10 = k2.e();
                        iVar.x(a10, e10, t.e());
                        g(a10).d(e10.build());
                        return true;
                    }
                    g(a10).e(iVar.r());
                    return true;
                }
                g(a10).c(iVar.v());
                return true;
            }
            g(a10).f(iVar.z());
            return true;
        }

        public b k(h hVar) {
            try {
                i u10 = hVar.u();
                l(u10);
                u10.a(0);
                return this;
            } catch (k0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e11);
            }
        }

        public b l(i iVar) {
            int K;
            do {
                K = iVar.K();
                if (K == 0) {
                    break;
                }
            } while (j(K, iVar));
            return this;
        }

        @Override // com.google.protobuf.e1.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(i iVar, v vVar) {
            return l(iVar);
        }

        public b n(k2 k2Var) {
            if (k2Var != k2.c()) {
                for (Map.Entry entry : k2Var.f١١١٨٧a.entrySet()) {
                    i(((Integer) entry.getKey()).intValue(), (c) entry.getValue());
                }
            }
            return this;
        }

        @Override // com.google.protobuf.e1.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(byte[] bArr) {
            try {
                i l10 = i.l(bArr);
                l(l10);
                l10.a(0);
                return this;
            } catch (k0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e11);
            }
        }

        public b p(int i10, h hVar) {
            if (i10 > 0) {
                g(i10).e(hVar);
                return this;
            }
            throw new IllegalArgumentException(i10 + " is not a valid field number.");
        }

        public b q(int i10, int i11) {
            if (i10 > 0) {
                g(i10).f(i11);
                return this;
            }
            throw new IllegalArgumentException(i10 + " is not a valid field number.");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class c {

        /* renamed from: f, reason: collision with root package name */
        private static final c f١١١٨٩f = s().g();

        /* renamed from: a, reason: collision with root package name */
        private List f١١١٩٠a;

        /* renamed from: b, reason: collision with root package name */
        private List f١١١٩١b;

        /* renamed from: c, reason: collision with root package name */
        private List f١١١٩٢c;

        /* renamed from: d, reason: collision with root package name */
        private List f١١١٩٣d;

        /* renamed from: e, reason: collision with root package name */
        private List f١١١٩٤e;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private c f١١١٩٥a = new c();

            private a() {
            }

            static /* synthetic */ a a() {
                return i();
            }

            private static a i() {
                return new a();
            }

            public a b(int i10) {
                if (this.f١١١٩٥a.f١١١٩١b == null) {
                    this.f١١١٩٥a.f١١١٩١b = new ArrayList();
                }
                this.f١١١٩٥a.f١١١٩١b.add(Integer.valueOf(i10));
                return this;
            }

            public a c(long j10) {
                if (this.f١١١٩٥a.f١١١٩٢c == null) {
                    this.f١١١٩٥a.f١١١٩٢c = new ArrayList();
                }
                this.f١١١٩٥a.f١١١٩٢c.add(Long.valueOf(j10));
                return this;
            }

            public a d(k2 k2Var) {
                if (this.f١١١٩٥a.f١١١٩٤e == null) {
                    this.f١١١٩٥a.f١١١٩٤e = new ArrayList();
                }
                this.f١١١٩٥a.f١١١٩٤e.add(k2Var);
                return this;
            }

            public a e(h hVar) {
                if (this.f١١١٩٥a.f١١١٩٣d == null) {
                    this.f١١١٩٥a.f١١١٩٣d = new ArrayList();
                }
                this.f١١١٩٥a.f١١١٩٣d.add(hVar);
                return this;
            }

            public a f(long j10) {
                if (this.f١١١٩٥a.f١١١٩٠a == null) {
                    this.f١١١٩٥a.f١١١٩٠a = new ArrayList();
                }
                this.f١١١٩٥a.f١١١٩٠a.add(Long.valueOf(j10));
                return this;
            }

            public c g() {
                c cVar = new c();
                if (this.f١١١٩٥a.f١١١٩٠a == null) {
                    cVar.f١١١٩٠a = Collections.emptyList();
                } else {
                    cVar.f١١١٩٠a = Collections.unmodifiableList(new ArrayList(this.f١١١٩٥a.f١١١٩٠a));
                }
                if (this.f١١١٩٥a.f١١١٩١b == null) {
                    cVar.f١١١٩١b = Collections.emptyList();
                } else {
                    cVar.f١١١٩١b = Collections.unmodifiableList(new ArrayList(this.f١١١٩٥a.f١١١٩١b));
                }
                if (this.f١١١٩٥a.f١١١٩٢c == null) {
                    cVar.f١١١٩٢c = Collections.emptyList();
                } else {
                    cVar.f١١١٩٢c = Collections.unmodifiableList(new ArrayList(this.f١١١٩٥a.f١١١٩٢c));
                }
                if (this.f١١١٩٥a.f١١١٩٣d == null) {
                    cVar.f١١١٩٣d = Collections.emptyList();
                } else {
                    cVar.f١١١٩٣d = Collections.unmodifiableList(new ArrayList(this.f١١١٩٥a.f١١١٩٣d));
                }
                if (this.f١١١٩٥a.f١١١٩٤e == null) {
                    cVar.f١١١٩٤e = Collections.emptyList();
                } else {
                    cVar.f١١١٩٤e = Collections.unmodifiableList(new ArrayList(this.f١١١٩٥a.f١١١٩٤e));
                }
                return cVar;
            }

            /* renamed from: h, reason: merged with bridge method [inline-methods] */
            public a clone() {
                c cVar = new c();
                if (this.f١١١٩٥a.f١١١٩٠a == null) {
                    cVar.f١١١٩٠a = null;
                } else {
                    cVar.f١١١٩٠a = new ArrayList(this.f١١١٩٥a.f١١١٩٠a);
                }
                if (this.f١١١٩٥a.f١١١٩١b == null) {
                    cVar.f١١١٩١b = null;
                } else {
                    cVar.f١١١٩١b = new ArrayList(this.f١١١٩٥a.f١١١٩١b);
                }
                if (this.f١١١٩٥a.f١١١٩٢c == null) {
                    cVar.f١١١٩٢c = null;
                } else {
                    cVar.f١١١٩٢c = new ArrayList(this.f١١١٩٥a.f١١١٩٢c);
                }
                if (this.f١١١٩٥a.f١١١٩٣d == null) {
                    cVar.f١١١٩٣d = null;
                } else {
                    cVar.f١١١٩٣d = new ArrayList(this.f١١١٩٥a.f١١١٩٣d);
                }
                if (this.f١١١٩٥a.f١١١٩٤e == null) {
                    cVar.f١١١٩٤e = null;
                } else {
                    cVar.f١١١٩٤e = new ArrayList(this.f١١١٩٥a.f١١١٩٤e);
                }
                a aVar = new a();
                aVar.f١١١٩٥a = cVar;
                return aVar;
            }

            public a j(c cVar) {
                if (!cVar.f١١١٩٠a.isEmpty()) {
                    if (this.f١١١٩٥a.f١١١٩٠a == null) {
                        this.f١١١٩٥a.f١١١٩٠a = new ArrayList();
                    }
                    this.f١١١٩٥a.f١١١٩٠a.addAll(cVar.f١١١٩٠a);
                }
                if (!cVar.f١١١٩١b.isEmpty()) {
                    if (this.f١١١٩٥a.f١١١٩١b == null) {
                        this.f١١١٩٥a.f١١١٩١b = new ArrayList();
                    }
                    this.f١١١٩٥a.f١١١٩١b.addAll(cVar.f١١١٩١b);
                }
                if (!cVar.f١١١٩٢c.isEmpty()) {
                    if (this.f١١١٩٥a.f١١١٩٢c == null) {
                        this.f١١١٩٥a.f١١١٩٢c = new ArrayList();
                    }
                    this.f١١١٩٥a.f١١١٩٢c.addAll(cVar.f١١١٩٢c);
                }
                if (!cVar.f١١١٩٣d.isEmpty()) {
                    if (this.f١١١٩٥a.f١١١٩٣d == null) {
                        this.f١١١٩٥a.f١١١٩٣d = new ArrayList();
                    }
                    this.f١١١٩٥a.f١١١٩٣d.addAll(cVar.f١١١٩٣d);
                }
                if (!cVar.f١١١٩٤e.isEmpty()) {
                    if (this.f١١١٩٥a.f١١١٩٤e == null) {
                        this.f١١١٩٥a.f١١١٩٤e = new ArrayList();
                    }
                    this.f١١١٩٥a.f١١١٩٤e.addAll(cVar.f١١١٩٤e);
                }
                return this;
            }
        }

        private Object[] n() {
            return new Object[]{this.f١١١٩٠a, this.f١١١٩١b, this.f١١١٩٢c, this.f١١١٩٣d, this.f١١١٩٤e};
        }

        public static a s() {
            return a.a();
        }

        public static a t(c cVar) {
            return s().j(cVar);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            return Arrays.equals(n(), ((c) obj).n());
        }

        public int hashCode() {
            return Arrays.hashCode(n());
        }

        public List k() {
            return this.f١١١٩١b;
        }

        public List l() {
            return this.f١١١٩٢c;
        }

        public List m() {
            return this.f١١١٩٤e;
        }

        public List o() {
            return this.f١١١٩٣d;
        }

        public int p(int i10) {
            Iterator it = this.f١١١٩٠a.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                i11 += k.Z(i10, ((Long) it.next()).longValue());
            }
            Iterator it2 = this.f١١١٩١b.iterator();
            while (it2.hasNext()) {
                i11 += k.n(i10, ((Integer) it2.next()).intValue());
            }
            Iterator it3 = this.f١١١٩٢c.iterator();
            while (it3.hasNext()) {
                i11 += k.p(i10, ((Long) it3.next()).longValue());
            }
            Iterator it4 = this.f١١١٩٣d.iterator();
            while (it4.hasNext()) {
                i11 += k.h(i10, (h) it4.next());
            }
            Iterator it5 = this.f١١١٩٤e.iterator();
            while (it5.hasNext()) {
                i11 += k.t(i10, (k2) it5.next());
            }
            return i11;
        }

        public int q(int i10) {
            Iterator it = this.f١١١٩٣d.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                i11 += k.L(i10, (h) it.next());
            }
            return i11;
        }

        public List r() {
            return this.f١١١٩٠a;
        }

        public void u(int i10, k kVar) {
            Iterator it = this.f١١١٩٣d.iterator();
            while (it.hasNext()) {
                kVar.K0(i10, (h) it.next());
            }
        }

        public void v(int i10, k kVar) {
            Iterator it = this.f١١١٩٠a.iterator();
            while (it.hasNext()) {
                kVar.U0(i10, ((Long) it.next()).longValue());
            }
            Iterator it2 = this.f١١١٩١b.iterator();
            while (it2.hasNext()) {
                kVar.v0(i10, ((Integer) it2.next()).intValue());
            }
            Iterator it3 = this.f١١١٩٢c.iterator();
            while (it3.hasNext()) {
                kVar.x0(i10, ((Long) it3.next()).longValue());
            }
            Iterator it4 = this.f١١١٩٣d.iterator();
            while (it4.hasNext()) {
                kVar.p0(i10, (h) it4.next());
            }
            Iterator it5 = this.f١١١٩٤e.iterator();
            while (it5.hasNext()) {
                kVar.B0(i10, (k2) it5.next());
            }
        }

        private c() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d extends com.google.protobuf.c {
        @Override // com.google.protobuf.r1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public k2 parsePartialFrom(i iVar, v vVar) {
            b e10 = k2.e();
            try {
                e10.l(iVar);
                return e10.buildPartial();
            } catch (k0 e11) {
                throw e11.j(e10.buildPartial());
            } catch (IOException e12) {
                throw new k0(e12).j(e10.buildPartial());
            }
        }
    }

    public static k2 c() {
        return f١١١٨٥b;
    }

    public static b e() {
        return b.a();
    }

    public static b f(k2 k2Var) {
        return e().n(k2Var);
    }

    public static k2 h(h hVar) {
        return e().k(hVar).build();
    }

    public Map b() {
        return (Map) this.f١١١٨٧a.clone();
    }

    public int d() {
        int i10 = 0;
        for (Map.Entry entry : this.f١١١٨٧a.entrySet()) {
            i10 += ((c) entry.getValue()).q(((Integer) entry.getKey()).intValue());
        }
        return i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof k2) && this.f١١١٨٧a.equals(((k2) obj).f١١١٨٧a)) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.e1
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return e();
    }

    @Override // com.google.protobuf.e1
    public int getSerializedSize() {
        int i10 = 0;
        if (!this.f١١١٨٧a.isEmpty()) {
            for (Map.Entry entry : this.f١١١٨٧a.entrySet()) {
                i10 += ((c) entry.getValue()).p(((Integer) entry.getKey()).intValue());
            }
        }
        return i10;
    }

    public int hashCode() {
        if (this.f١١١٨٧a.isEmpty()) {
            return 0;
        }
        return this.f١١١٨٧a.hashCode();
    }

    @Override // com.google.protobuf.e1
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return e().n(this);
    }

    @Override // com.google.protobuf.f1
    public boolean isInitialized() {
        return true;
    }

    public void j(k kVar) {
        for (Map.Entry entry : this.f١١١٨٧a.entrySet()) {
            ((c) entry.getValue()).u(((Integer) entry.getKey()).intValue(), kVar);
        }
    }

    @Override // com.google.protobuf.e1
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            k h02 = k.h0(bArr);
            writeTo(h02);
            h02.d();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e10);
        }
    }

    public String toString() {
        return e2.o().k(this);
    }

    @Override // com.google.protobuf.e1
    public void writeTo(k kVar) {
        for (Map.Entry entry : this.f١١١٨٧a.entrySet()) {
            ((c) entry.getValue()).v(((Integer) entry.getKey()).intValue(), kVar);
        }
    }

    private k2(TreeMap treeMap) {
        this.f١١١٨٧a = treeMap;
    }
}
