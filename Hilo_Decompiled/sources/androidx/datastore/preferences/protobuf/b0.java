package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b0 implements y0 {

    /* renamed from: b, reason: collision with root package name */
    private static final i0 f٣٢٦٥b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final i0 f٣٢٦٦a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements i0 {
        a() {
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public h0 a(Class cls) {
            throw new IllegalStateException("This should never be called.");
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public boolean b(Class cls) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f٣٢٦٧a;

        static {
            int[] iArr = new int[s0.values().length];
            f٣٢٦٧a = iArr;
            try {
                iArr[s0.PROTO3.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements i0 {

        /* renamed from: a, reason: collision with root package name */
        private i0[] f٣٢٦٨a;

        c(i0... i0VarArr) {
            this.f٣٢٦٨a = i0VarArr;
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public h0 a(Class cls) {
            for (i0 i0Var : this.f٣٢٦٨a) {
                if (i0Var.b(cls)) {
                    return i0Var.a(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
        }

        @Override // androidx.datastore.preferences.protobuf.i0
        public boolean b(Class cls) {
            for (i0 i0Var : this.f٣٢٦٨a) {
                if (i0Var.b(cls)) {
                    return true;
                }
            }
            return false;
        }
    }

    public b0() {
        this(c());
    }

    private static boolean b(h0 h0Var) {
        if (b.f٣٢٦٧a[h0Var.getSyntax().ordinal()] != 1) {
            return true;
        }
        return false;
    }

    private static i0 c() {
        return new c(s.c(), d());
    }

    private static i0 d() {
        if (t0.f٣٥٠٥d) {
            return f٣٢٦٥b;
        }
        try {
            return (i0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return f٣٢٦٥b;
        }
    }

    private static x0 e(Class cls, h0 h0Var) {
        n nVar = null;
        if (f(cls)) {
            o0 b10 = q0.b();
            y b11 = a0.b();
            e1 K = z0.K();
            if (b(h0Var)) {
                nVar = p.b();
            }
            return m0.N(cls, h0Var, b10, b11, K, nVar, g0.b());
        }
        o0 a10 = q0.a();
        y a11 = a0.a();
        e1 J = z0.J();
        if (b(h0Var)) {
            nVar = p.a();
        }
        return m0.N(cls, h0Var, a10, a11, J, nVar, g0.a());
    }

    private static boolean f(Class cls) {
        if (!t0.f٣٥٠٥d && !t.class.isAssignableFrom(cls)) {
            return false;
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public x0 a(Class cls) {
        z0.G(cls);
        h0 a10 = this.f٣٢٦٦a.a(cls);
        if (a10.a()) {
            if (f(cls)) {
                return n0.l(z0.K(), p.b(), a10.b());
            }
            return n0.l(z0.J(), p.a(), a10.b());
        }
        return e(cls, a10);
    }

    private b0(i0 i0Var) {
        this.f٣٢٦٦a = (i0) u.b(i0Var, "messageInfoFactory");
    }
}
