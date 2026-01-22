package com.google.protobuf;

import com.google.protobuf.a;
import com.google.protobuf.b0;
import com.google.protobuf.b1;
import com.google.protobuf.n;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class q extends com.google.protobuf.a {

    /* renamed from: a, reason: collision with root package name */
    private final n.b f١١٨٨٩a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f١١٨٩٠b;

    /* renamed from: c, reason: collision with root package name */
    private final n.g[] f١١٨٩١c;

    /* renamed from: d, reason: collision with root package name */
    private final k2 f١١٨٩٢d;

    /* renamed from: e, reason: collision with root package name */
    private int f١١٨٩٣e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٨٩٤a;

        static {
            int[] iArr = new int[n.g.c.values().length];
            f١١٨٩٤a = iArr;
            try {
                iArr[n.g.c.f١١٨١٠o.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١١٨٩٤a[n.g.c.f١١٨٠٧l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class b extends a.AbstractC٠١٣٢a {

        /* renamed from: a, reason: collision with root package name */
        private final n.b f١١٨٩٥a;

        /* renamed from: b, reason: collision with root package name */
        private b0.b f١١٨٩٦b;

        /* renamed from: c, reason: collision with root package name */
        private final n.g[] f١١٨٩٧c;

        /* renamed from: d, reason: collision with root package name */
        private k2 f١١٨٩٨d;

        /* synthetic */ b(n.b bVar, p pVar) {
            this(bVar);
        }

        private static b1.a m(Object obj) {
            if (obj instanceof b1.a) {
                return (b1.a) obj;
            }
            if (obj instanceof m0) {
                obj = ((m0) obj).d();
            }
            if (obj instanceof b1) {
                return ((b1) obj).toBuilder();
            }
            throw new IllegalArgumentException(String.format("Cannot convert %s to Message.Builder", obj.getClass()));
        }

        private void n(n.g gVar) {
            if (gVar.l() == this.f١١٨٩٥a) {
            } else {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }

        private void o(n.g gVar, Object obj) {
            int i10 = a.f١١٨٩٤a[gVar.t().ordinal()];
            if (i10 != 1) {
                if (i10 == 2 && (obj instanceof b1.a)) {
                    throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(gVar.getNumber()), gVar.getLiteType().c(), obj.getClass().getName()));
                }
            } else {
                j0.a(obj);
                if (obj instanceof n.f) {
                } else {
                    throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                }
            }
        }

        private void p(n.g gVar, Object obj) {
            if (gVar.isRepeated()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    o(gVar, it.next());
                }
                return;
            }
            o(gVar, obj);
        }

        @Override // com.google.protobuf.b1.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b addRepeatedField(n.g gVar, Object obj) {
            n(gVar);
            o(gVar, obj);
            this.f١١٨٩٦b.a(gVar, obj);
            return this;
        }

        @Override // com.google.protobuf.e1.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public q build() {
            if (isInitialized()) {
                return buildPartial();
            }
            n.b bVar = this.f١١٨٩٥a;
            b0 b10 = this.f١١٨٩٦b.b();
            n.g[] gVarArr = this.f١١٨٩٧c;
            throw a.AbstractC٠١٣٢a.newUninitializedMessageException((b1) new q(bVar, b10, (n.g[]) Arrays.copyOf(gVarArr, gVarArr.length), this.f١١٨٩٨d));
        }

        @Override // com.google.protobuf.e1.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public q buildPartial() {
            if (this.f١١٨٩٥a.m().C()) {
                for (n.g gVar : this.f١١٨٩٥a.j()) {
                    if (gVar.x() && !this.f١١٨٩٦b.m(gVar)) {
                        if (gVar.q() == n.g.b.MESSAGE) {
                            this.f١١٨٩٦b.u(gVar, q.k(gVar.r()));
                        } else {
                            this.f١١٨٩٦b.u(gVar, gVar.m());
                        }
                    }
                }
            }
            n.b bVar = this.f١١٨٩٥a;
            b0 d10 = this.f١١٨٩٦b.d();
            n.g[] gVarArr = this.f١١٨٩٧c;
            return new q(bVar, d10, (n.g[]) Arrays.copyOf(gVarArr, gVarArr.length), this.f١١٨٩٨d);
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public b clone() {
            b bVar = new b(this.f١١٨٩٥a);
            bVar.f١١٨٩٦b.o(this.f١١٨٩٦b.b());
            bVar.mergeUnknownFields(this.f١١٨٩٨d);
            n.g[] gVarArr = this.f١١٨٩٧c;
            System.arraycopy(gVarArr, 0, bVar.f١١٨٩٧c, 0, gVarArr.length);
            return bVar;
        }

        @Override // com.google.protobuf.f1
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public q getDefaultInstanceForType() {
            return q.k(this.f١١٨٩٥a);
        }

        @Override // com.google.protobuf.g1
        public Map getAllFields() {
            return this.f١١٨٩٦b.g();
        }

        @Override // com.google.protobuf.b1.a, com.google.protobuf.g1
        public n.b getDescriptorForType() {
            return this.f١١٨٩٥a;
        }

        @Override // com.google.protobuf.g1
        public Object getField(n.g gVar) {
            n(gVar);
            Object h10 = this.f١١٨٩٦b.h(gVar);
            if (h10 == null) {
                if (gVar.isRepeated()) {
                    return Collections.emptyList();
                }
                if (gVar.q() == n.g.b.MESSAGE) {
                    return q.k(gVar.r());
                }
                return gVar.m();
            }
            return h10;
        }

        @Override // com.google.protobuf.b1.a
        public b1.a getFieldBuilder(n.g gVar) {
            b1.a m10;
            n(gVar);
            if (!gVar.w()) {
                if (gVar.q() == n.g.b.MESSAGE) {
                    Object i10 = this.f١١٨٩٦b.i(gVar);
                    if (i10 == null) {
                        m10 = new b(gVar.r());
                    } else {
                        m10 = m(i10);
                    }
                    this.f١١٨٩٦b.u(gVar, m10);
                    return m10;
                }
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }
            throw new UnsupportedOperationException("Nested builder not supported for map fields.");
        }

        @Override // com.google.protobuf.g1
        public k2 getUnknownFields() {
            return this.f١١٨٩٨d;
        }

        @Override // com.google.protobuf.b1.a
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public b mergeFrom(b1 b1Var) {
            if (b1Var instanceof q) {
                q qVar = (q) b1Var;
                if (qVar.f١١٨٨٩a == this.f١١٨٩٥a) {
                    this.f١١٨٩٦b.o(qVar.f١١٨٩٠b);
                    mergeUnknownFields(qVar.f١١٨٩٢d);
                    int i10 = 0;
                    while (true) {
                        n.g[] gVarArr = this.f١١٨٩٧c;
                        if (i10 < gVarArr.length) {
                            if (gVarArr[i10] == null) {
                                gVarArr[i10] = qVar.f١١٨٩١c[i10];
                            } else if (qVar.f١١٨٩١c[i10] != null && this.f١١٨٩٧c[i10] != qVar.f١١٨٩١c[i10]) {
                                this.f١١٨٩٦b.e(this.f١١٨٩٧c[i10]);
                                this.f١١٨٩٧c[i10] = qVar.f١١٨٩١c[i10];
                            }
                            i10++;
                        } else {
                            return this;
                        }
                    }
                } else {
                    throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
                }
            } else {
                return (b) super.mergeFrom(b1Var);
            }
        }

        @Override // com.google.protobuf.g1
        public boolean hasField(n.g gVar) {
            n(gVar);
            return this.f١١٨٩٦b.m(gVar);
        }

        @Override // com.google.protobuf.a.AbstractC٠١٣٢a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public b mergeUnknownFields(k2 k2Var) {
            this.f١١٨٩٨d = k2.f(this.f١١٨٩٨d).n(k2Var).build();
            return this;
        }

        @Override // com.google.protobuf.f1
        public boolean isInitialized() {
            for (n.g gVar : this.f١١٨٩٥a.j()) {
                if (gVar.z() && !this.f١١٨٩٦b.m(gVar)) {
                    return false;
                }
            }
            return this.f١١٨٩٦b.n();
        }

        @Override // com.google.protobuf.b1.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public b newBuilderForField(n.g gVar) {
            n(gVar);
            if (gVar.q() == n.g.b.MESSAGE) {
                return new b(gVar.r());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.google.protobuf.b1.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public b setField(n.g gVar, Object obj) {
            n(gVar);
            p(gVar, obj);
            n.l k10 = gVar.k();
            if (k10 != null) {
                int m10 = k10.m();
                n.g gVar2 = this.f١١٨٩٧c[m10];
                if (gVar2 != null && gVar2 != gVar) {
                    this.f١١٨٩٦b.e(gVar2);
                }
                this.f١١٨٩٧c[m10] = gVar;
            } else if (gVar.a().n() == n.h.a.PROTO3 && !gVar.isRepeated() && gVar.q() != n.g.b.MESSAGE && obj.equals(gVar.m())) {
                this.f١١٨٩٦b.e(gVar);
                return this;
            }
            this.f١١٨٩٦b.u(gVar, obj);
            return this;
        }

        @Override // com.google.protobuf.b1.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public b setUnknownFields(k2 k2Var) {
            this.f١١٨٩٨d = k2Var;
            return this;
        }

        private b(n.b bVar) {
            this.f١١٨٩٥a = bVar;
            this.f١١٨٩٦b = b0.I();
            this.f١١٨٩٨d = k2.c();
            this.f١١٨٩٧c = new n.g[bVar.e().Y()];
        }
    }

    q(n.b bVar, b0 b0Var, n.g[] gVarArr, k2 k2Var) {
        this.f١١٨٨٩a = bVar;
        this.f١١٨٩٠b = b0Var;
        this.f١١٨٩١c = gVarArr;
        this.f١١٨٩٢d = k2Var;
    }

    public static q k(n.b bVar) {
        return new q(bVar, b0.o(), new n.g[bVar.e().Y()], k2.c());
    }

    static boolean m(n.b bVar, b0 b0Var) {
        for (n.g gVar : bVar.j()) {
            if (gVar.z() && !b0Var.x(gVar)) {
                return false;
            }
        }
        return b0Var.A();
    }

    public static b n(n.b bVar) {
        return new b(bVar, null);
    }

    private void q(n.g gVar) {
        if (gVar.l() == this.f١١٨٨٩a) {
        } else {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    @Override // com.google.protobuf.g1
    public Map getAllFields() {
        return this.f١١٨٩٠b.p();
    }

    @Override // com.google.protobuf.g1
    public n.b getDescriptorForType() {
        return this.f١١٨٨٩a;
    }

    @Override // com.google.protobuf.g1
    public Object getField(n.g gVar) {
        q(gVar);
        Object q10 = this.f١١٨٩٠b.q(gVar);
        if (q10 == null) {
            if (gVar.isRepeated()) {
                return Collections.emptyList();
            }
            if (gVar.q() == n.g.b.MESSAGE) {
                return k(gVar.r());
            }
            return gVar.m();
        }
        return q10;
    }

    @Override // com.google.protobuf.e1
    public int getSerializedSize() {
        int v10;
        int serializedSize;
        int i10 = this.f١١٨٩٣e;
        if (i10 != -1) {
            return i10;
        }
        if (this.f١١٨٨٩a.m().D()) {
            v10 = this.f١١٨٩٠b.r();
            serializedSize = this.f١١٨٩٢d.d();
        } else {
            v10 = this.f١١٨٩٠b.v();
            serializedSize = this.f١١٨٩٢d.getSerializedSize();
        }
        int i11 = v10 + serializedSize;
        this.f١١٨٩٣e = i11;
        return i11;
    }

    @Override // com.google.protobuf.g1
    public k2 getUnknownFields() {
        return this.f١١٨٩٢d;
    }

    @Override // com.google.protobuf.g1
    public boolean hasField(n.g gVar) {
        q(gVar);
        return this.f١١٨٩٠b.x(gVar);
    }

    @Override // com.google.protobuf.f1
    public boolean isInitialized() {
        return m(this.f١١٨٨٩a, this.f١١٨٩٠b);
    }

    @Override // com.google.protobuf.f1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public q getDefaultInstanceForType() {
        return k(this.f١١٨٨٩a);
    }

    @Override // com.google.protobuf.e1
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public b newBuilderForType() {
        return new b(this.f١١٨٨٩a, null);
    }

    @Override // com.google.protobuf.e1
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public b toBuilder() {
        return newBuilderForType().mergeFrom(this);
    }

    @Override // com.google.protobuf.e1
    public void writeTo(k kVar) {
        if (this.f١١٨٨٩a.m().D()) {
            this.f١١٨٩٠b.P(kVar);
            this.f١١٨٩٢d.j(kVar);
        } else {
            this.f١١٨٩٠b.R(kVar);
            this.f١١٨٩٢d.writeTo(kVar);
        }
    }
}
