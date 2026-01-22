package com.google.protobuf;

import com.google.protobuf.b0;
import com.google.protobuf.b1;
import com.google.protobuf.e1;
import com.google.protobuf.k2;
import com.google.protobuf.n;
import com.google.protobuf.r2;
import com.google.protobuf.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class h1 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١١٠٩٠a;

        static {
            int[] iArr = new int[n.g.c.values().length];
            f١١٠٩٠a = iArr;
            try {
                iArr[n.g.c.f١١٨٠٦k.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١١٠٩٠a[n.g.c.f١١٨٠٧l.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١١٠٩٠a[n.g.c.f١١٨١٠o.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        private final b1.a f١١٠٩١a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١١٠٩٢b = true;

        public b(b1.a aVar) {
            this.f١١٠٩١a = aVar;
        }

        private b1.a g(n.g gVar) {
            if (this.f١١٠٩٢b) {
                try {
                    return this.f١١٠٩١a.getFieldBuilder(gVar);
                } catch (UnsupportedOperationException unused) {
                    this.f١١٠٩٢b = false;
                    return null;
                }
            }
            return null;
        }

        private b1.a i(n.g gVar, b1 b1Var) {
            if (b1Var != null) {
                return b1Var.newBuilderForType();
            }
            return this.f١١٠٩١a.newBuilderForField(gVar);
        }

        @Override // com.google.protobuf.h1.e
        public t.b a(t tVar, n.b bVar, int i10) {
            tVar.d(bVar, i10);
            return null;
        }

        @Override // com.google.protobuf.h1.e
        public e addRepeatedField(n.g gVar, Object obj) {
            if (obj instanceof e1.a) {
                obj = ((e1.a) obj).buildPartial();
            }
            this.f١١٠٩١a.addRepeatedField(gVar, obj);
            return this;
        }

        @Override // com.google.protobuf.h1.e
        public r2.d b(n.g gVar) {
            if (gVar.A()) {
                return r2.d.f١١٩٤٧b;
            }
            gVar.isRepeated();
            return r2.d.f١١٩٤٦a;
        }

        @Override // com.google.protobuf.h1.e
        public e.a c() {
            return e.a.MESSAGE;
        }

        @Override // com.google.protobuf.h1.e
        public void d(i iVar, v vVar, n.g gVar, b1 b1Var) {
            b1.a i10;
            if (!gVar.isRepeated()) {
                if (h(gVar)) {
                    b1.a g10 = g(gVar);
                    if (g10 != null) {
                        iVar.B(g10, vVar);
                        return;
                    } else {
                        i10 = i(gVar, b1Var);
                        i10.mergeFrom((b1) f(gVar));
                    }
                } else {
                    i10 = i(gVar, b1Var);
                }
                iVar.B(i10, vVar);
                setField(gVar, i10.buildPartial());
                return;
            }
            b1.a i11 = i(gVar, b1Var);
            iVar.B(i11, vVar);
            addRepeatedField(gVar, i11.buildPartial());
        }

        @Override // com.google.protobuf.h1.e
        public void e(i iVar, v vVar, n.g gVar, b1 b1Var) {
            b1.a i10;
            if (!gVar.isRepeated()) {
                if (h(gVar)) {
                    b1.a g10 = g(gVar);
                    if (g10 != null) {
                        iVar.x(gVar.getNumber(), g10, vVar);
                        return;
                    } else {
                        i10 = i(gVar, b1Var);
                        i10.mergeFrom((b1) f(gVar));
                    }
                } else {
                    i10 = i(gVar, b1Var);
                }
                iVar.x(gVar.getNumber(), i10, vVar);
                setField(gVar, i10.buildPartial());
                return;
            }
            b1.a i11 = i(gVar, b1Var);
            iVar.x(gVar.getNumber(), i11, vVar);
            addRepeatedField(gVar, i11.buildPartial());
        }

        public Object f(n.g gVar) {
            return this.f١١٠٩١a.getField(gVar);
        }

        public boolean h(n.g gVar) {
            return this.f١١٠٩١a.hasField(gVar);
        }

        @Override // com.google.protobuf.h1.e
        public e setField(n.g gVar, Object obj) {
            if (!gVar.isRepeated() && (obj instanceof e1.a)) {
                if (obj != g(gVar)) {
                    this.f١١٠٩١a.setField(gVar, ((e1.a) obj).buildPartial());
                }
                return this;
            }
            this.f١١٠٩١a.setField(gVar, obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class c implements e {

        /* renamed from: a, reason: collision with root package name */
        private final b0 f١١٠٩٣a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(b0 b0Var) {
            this.f١١٠٩٣a = b0Var;
        }

        @Override // com.google.protobuf.h1.e
        public t.b a(t tVar, n.b bVar, int i10) {
            tVar.d(bVar, i10);
            return null;
        }

        @Override // com.google.protobuf.h1.e
        public e addRepeatedField(n.g gVar, Object obj) {
            this.f١١٠٩٣a.g(gVar, obj);
            return this;
        }

        @Override // com.google.protobuf.h1.e
        public r2.d b(n.g gVar) {
            if (gVar.A()) {
                return r2.d.f١١٩٤٧b;
            }
            return r2.d.f١١٩٤٦a;
        }

        @Override // com.google.protobuf.h1.e
        public e.a c() {
            return e.a.EXTENSION_SET;
        }

        @Override // com.google.protobuf.h1.e
        public void d(i iVar, v vVar, n.g gVar, b1 b1Var) {
            if (!gVar.isRepeated()) {
                if (g(gVar)) {
                    e1.a builder = ((e1) f(gVar)).toBuilder();
                    iVar.B(builder, vVar);
                    setField(gVar, builder.buildPartial());
                    return;
                } else {
                    b1.a newBuilderForType = b1Var.newBuilderForType();
                    iVar.B(newBuilderForType, vVar);
                    setField(gVar, newBuilderForType.buildPartial());
                    return;
                }
            }
            b1.a newBuilderForType2 = b1Var.newBuilderForType();
            iVar.B(newBuilderForType2, vVar);
            addRepeatedField(gVar, newBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.h1.e
        public void e(i iVar, v vVar, n.g gVar, b1 b1Var) {
            if (!gVar.isRepeated()) {
                if (g(gVar)) {
                    e1.a builder = ((e1) f(gVar)).toBuilder();
                    iVar.x(gVar.getNumber(), builder, vVar);
                    setField(gVar, builder.buildPartial());
                    return;
                } else {
                    b1.a newBuilderForType = b1Var.newBuilderForType();
                    iVar.x(gVar.getNumber(), newBuilderForType, vVar);
                    setField(gVar, newBuilderForType.buildPartial());
                    return;
                }
            }
            b1.a newBuilderForType2 = b1Var.newBuilderForType();
            iVar.x(gVar.getNumber(), newBuilderForType2, vVar);
            addRepeatedField(gVar, newBuilderForType2.buildPartial());
        }

        public Object f(n.g gVar) {
            return this.f١١٠٩٣a.q(gVar);
        }

        public boolean g(n.g gVar) {
            return this.f١١٠٩٣a.x(gVar);
        }

        @Override // com.google.protobuf.h1.e
        public e setField(n.g gVar, Object obj) {
            this.f١١٠٩٣a.K(gVar, obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class d implements e {

        /* renamed from: a, reason: collision with root package name */
        private final b0.b f١١٠٩٤a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(b0.b bVar) {
            this.f١١٠٩٤a = bVar;
        }

        @Override // com.google.protobuf.h1.e
        public t.b a(t tVar, n.b bVar, int i10) {
            tVar.d(bVar, i10);
            return null;
        }

        @Override // com.google.protobuf.h1.e
        public e addRepeatedField(n.g gVar, Object obj) {
            this.f١١٠٩٤a.a(gVar, obj);
            return this;
        }

        @Override // com.google.protobuf.h1.e
        public r2.d b(n.g gVar) {
            if (gVar.A()) {
                return r2.d.f١١٩٤٧b;
            }
            return r2.d.f١١٩٤٦a;
        }

        @Override // com.google.protobuf.h1.e
        public e.a c() {
            return e.a.EXTENSION_SET;
        }

        @Override // com.google.protobuf.h1.e
        public void d(i iVar, v vVar, n.g gVar, b1 b1Var) {
            e1.a builder;
            if (!gVar.isRepeated()) {
                if (f(gVar)) {
                    Object i10 = this.f١١٠٩٤a.i(gVar);
                    if (i10 instanceof e1.a) {
                        builder = (e1.a) i10;
                    } else {
                        builder = ((e1) i10).toBuilder();
                        this.f١١٠٩٤a.u(gVar, builder);
                    }
                    iVar.B(builder, vVar);
                    return;
                }
                b1.a newBuilderForType = b1Var.newBuilderForType();
                iVar.B(newBuilderForType, vVar);
                setField(gVar, newBuilderForType);
                return;
            }
            b1.a newBuilderForType2 = b1Var.newBuilderForType();
            iVar.B(newBuilderForType2, vVar);
            addRepeatedField(gVar, newBuilderForType2.buildPartial());
        }

        @Override // com.google.protobuf.h1.e
        public void e(i iVar, v vVar, n.g gVar, b1 b1Var) {
            e1.a builder;
            if (!gVar.isRepeated()) {
                if (f(gVar)) {
                    Object i10 = this.f١١٠٩٤a.i(gVar);
                    if (i10 instanceof e1.a) {
                        builder = (e1.a) i10;
                    } else {
                        builder = ((e1) i10).toBuilder();
                        this.f١١٠٩٤a.u(gVar, builder);
                    }
                    iVar.x(gVar.getNumber(), builder, vVar);
                    return;
                }
                b1.a newBuilderForType = b1Var.newBuilderForType();
                iVar.x(gVar.getNumber(), newBuilderForType, vVar);
                setField(gVar, newBuilderForType);
                return;
            }
            b1.a newBuilderForType2 = b1Var.newBuilderForType();
            iVar.x(gVar.getNumber(), newBuilderForType2, vVar);
            addRepeatedField(gVar, newBuilderForType2.buildPartial());
        }

        public boolean f(n.g gVar) {
            return this.f١١٠٩٤a.m(gVar);
        }

        @Override // com.google.protobuf.h1.e
        public e setField(n.g gVar, Object obj) {
            this.f١١٠٩٤a.u(gVar, obj);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
        public enum a {
            MESSAGE,
            EXTENSION_SET
        }

        t.b a(t tVar, n.b bVar, int i10);

        e addRepeatedField(n.g gVar, Object obj);

        r2.d b(n.g gVar);

        a c();

        void d(i iVar, v vVar, n.g gVar, b1 b1Var);

        void e(i iVar, v vVar, n.g gVar, b1 b1Var);

        e setField(n.g gVar, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List b(g1 g1Var) {
        ArrayList arrayList = new ArrayList();
        c(g1Var, "", arrayList);
        return arrayList;
    }

    private static void c(g1 g1Var, String str, List list) {
        for (n.g gVar : g1Var.getDescriptorForType().j()) {
            if (gVar.z() && !g1Var.hasField(gVar)) {
                list.add(str + gVar.d());
            }
        }
        for (Map.Entry entry : g1Var.getAllFields().entrySet()) {
            n.g gVar2 = (n.g) entry.getKey();
            Object value = entry.getValue();
            if (gVar2.q() == n.g.b.MESSAGE) {
                if (gVar2.isRepeated()) {
                    Iterator it = ((List) value).iterator();
                    int i10 = 0;
                    while (it.hasNext()) {
                        c((g1) it.next(), g(str, gVar2, i10), list);
                        i10++;
                    }
                } else if (g1Var.hasField(gVar2)) {
                    c((g1) value, g(str, gVar2, -1), list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean d(i iVar, k2.b bVar, v vVar, n.b bVar2, e eVar, int i10) {
        n.g i11;
        boolean z10;
        boolean z11;
        Object obj;
        if (bVar2.m().D() && i10 == r2.f١١٩٠٩a) {
            f(iVar, bVar, vVar, bVar2, eVar);
            return true;
        }
        int b10 = r2.b(i10);
        int a10 = r2.a(i10);
        if (bVar2.o(a10)) {
            if (vVar instanceof t) {
                eVar.a((t) vVar, bVar2, a10);
            }
        } else if (eVar.c() == e.a.MESSAGE) {
            i11 = bVar2.i(a10);
            z10 = false;
            if (i11 != null) {
                if (b10 == b0.w(i11.getLiteType(), false)) {
                    z11 = false;
                } else if (i11.y() && b10 == b0.w(i11.getLiteType(), true)) {
                    z11 = true;
                }
                if (z10) {
                    if (bVar != null) {
                        return bVar.j(i10, iVar);
                    }
                    return iVar.O(i10);
                }
                if (z11) {
                    int p10 = iVar.p(iVar.C());
                    if (i11.getLiteType() == r2.b.f١١٩٢٧p) {
                        while (iVar.e() > 0) {
                            int t10 = iVar.t();
                            if (i11.a().q()) {
                                eVar.addRepeatedField(i11, i11.n().i(t10));
                            } else {
                                n.f h10 = i11.n().h(t10);
                                if (h10 == null) {
                                    if (bVar != null) {
                                        bVar.q(a10, t10);
                                    }
                                } else {
                                    eVar.addRepeatedField(i11, h10);
                                }
                            }
                        }
                    } else {
                        while (iVar.e() > 0) {
                            eVar.addRepeatedField(i11, r2.d(iVar, i11.getLiteType(), eVar.b(i11)));
                        }
                    }
                    iVar.o(p10);
                } else {
                    int i12 = a.f١١٠٩٠a[i11.t().ordinal()];
                    if (i12 != 1) {
                        if (i12 != 2) {
                            if (i12 != 3) {
                                obj = r2.d(iVar, i11.getLiteType(), eVar.b(i11));
                            } else {
                                int t11 = iVar.t();
                                if (i11.a().q()) {
                                    obj = i11.n().i(t11);
                                } else {
                                    n.f h11 = i11.n().h(t11);
                                    if (h11 == null) {
                                        if (bVar != null) {
                                            bVar.q(a10, t11);
                                        }
                                        return true;
                                    }
                                    obj = h11;
                                }
                            }
                            if (i11.isRepeated()) {
                                eVar.addRepeatedField(i11, obj);
                            } else {
                                eVar.setField(i11, obj);
                            }
                        } else {
                            eVar.d(iVar, vVar, i11, null);
                            return true;
                        }
                    } else {
                        eVar.e(iVar, vVar, i11, null);
                        return true;
                    }
                }
                return true;
            }
            z11 = false;
            z10 = true;
            if (z10) {
            }
        }
        i11 = null;
        z10 = false;
        if (i11 != null) {
        }
        z11 = false;
        z10 = true;
        if (z10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(b1.a aVar, k2.b bVar, i iVar, v vVar) {
        int K;
        b bVar2 = new b(aVar);
        n.b descriptorForType = aVar.getDescriptorForType();
        do {
            K = iVar.K();
            if (K == 0) {
                return;
            }
        } while (d(iVar, bVar, vVar, descriptorForType, bVar2, K));
    }

    private static void f(i iVar, k2.b bVar, v vVar, n.b bVar2, e eVar) {
        int i10 = 0;
        h hVar = null;
        while (true) {
            int K = iVar.K();
            if (K == 0) {
                break;
            }
            if (K == r2.f١١٩١١c) {
                i10 = iVar.L();
                if (i10 != 0 && (vVar instanceof t)) {
                    eVar.a((t) vVar, bVar2, i10);
                }
            } else if (K == r2.f١١٩١٢d) {
                hVar = iVar.r();
            } else if (!iVar.O(K)) {
                break;
            }
        }
        iVar.a(r2.f١١٩١٠b);
        if (hVar != null && i10 != 0 && bVar != null) {
            bVar.i(i10, k2.c.s().e(hVar).g());
        }
    }

    private static String g(String str, n.g gVar, int i10) {
        StringBuilder sb = new StringBuilder(str);
        if (gVar.v()) {
            sb.append('(');
            sb.append(gVar.c());
            sb.append(')');
        } else {
            sb.append(gVar.d());
        }
        if (i10 != -1) {
            sb.append('[');
            sb.append(i10);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }
}
