package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class s0 implements z1 {

    /* renamed from: b, reason: collision with root package name */
    private static final d1 f١١٩٥٠b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final d1 f١١٩٥١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements d1 {
        a() {
        }

        @Override // com.google.protobuf.d1
        public c1 a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // com.google.protobuf.d1
        public boolean b(Class cls) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class b implements d1 {

        /* renamed from: a, reason: collision with root package name */
        private d1[] f١١٩٥٢a;

        b(d1... d1VarArr) {
            this.f١١٩٥٢a = d1VarArr;
        }

        @Override // com.google.protobuf.d1
        public c1 a(Class cls) {
            for (d1 d1Var : this.f١١٩٥٢a) {
                if (d1Var.b(cls)) {
                    return d1Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // com.google.protobuf.d1
        public boolean b(Class cls) {
            for (d1 d1Var : this.f١١٩٥٢a) {
                if (d1Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public s0() {
        this(b());
    }

    private static d1 b() {
        return new b(f0.c(), c());
    }

    private static d1 c() {
        try {
            int i10 = l.f١١١٩٩d;
            return (d1) l.class.getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f١١٩٥٠b;
        }
    }

    private static boolean d(c1 c1Var) {
        if (c1Var.getSyntax() == t1.PROTO2) {
            return true;
        }
        return false;
    }

    private static y1 e(Class cls, c1 c1Var) {
        if (g0.class.isAssignableFrom(cls)) {
            if (d(c1Var)) {
                return i1.A(cls, c1Var, o1.b(), q0.b(), a2.M(), z.b(), a1.b());
            }
            return i1.A(cls, c1Var, o1.b(), q0.b(), a2.M(), null, a1.b());
        }
        if (d(c1Var)) {
            return i1.A(cls, c1Var, o1.a(), q0.a(), a2.H(), z.a(), a1.a());
        }
        return i1.A(cls, c1Var, o1.a(), q0.a(), a2.I(), null, a1.a());
    }

    @Override // com.google.protobuf.z1
    public y1 a(Class cls) {
        a2.J(cls);
        c1 a10 = this.f١١٩٥١a.a(cls);
        if (a10.a()) {
            if (g0.class.isAssignableFrom(cls)) {
                return j1.h(a2.M(), z.b(), a10.b());
            }
            return j1.h(a2.H(), z.a(), a10.b());
        }
        return e(cls, a10);
    }

    private s0(d1 d1Var) {
        this.f١١٩٥١a = (d1) j0.b(d1Var, "messageInfoFactory");
    }
}
