package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class e1 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f٣٢٨٤a = 100;

    private final void l(Object obj, w0 w0Var, int i10) {
        while (w0Var.z() != Integer.MAX_VALUE && m(obj, w0Var, i10)) {
        }
    }

    abstract void a(Object obj, int i10, int i11);

    abstract void b(Object obj, int i10, long j10);

    abstract void c(Object obj, int i10, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj, int i10, f fVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Object obj, int i10, long j10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object k(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(Object obj, w0 w0Var, int i10) {
        int tag = w0Var.getTag();
        int a10 = j1.a(tag);
        int b10 = j1.b(tag);
        if (b10 != 0) {
            if (b10 != 1) {
                if (b10 != 2) {
                    if (b10 != 3) {
                        if (b10 != 4) {
                            if (b10 == 5) {
                                a(obj, a10, w0Var.t());
                                return true;
                            }
                            throw v.e();
                        }
                        return false;
                    }
                    Object n10 = n();
                    int c10 = j1.c(a10, 4);
                    int i11 = i10 + 1;
                    if (i11 < f٣٢٨٤a) {
                        l(n10, w0Var, i11);
                        if (c10 == w0Var.getTag()) {
                            c(obj, a10, r(n10));
                            return true;
                        }
                        throw v.b();
                    }
                    throw v.i();
                }
                d(obj, a10, w0Var.n());
                return true;
            }
            b(obj, a10, w0Var.a());
            return true;
        }
        e(obj, a10, w0Var.G());
        return true;
    }

    abstract Object n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(w0 w0Var);

    abstract Object r(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(Object obj, k1 k1Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(Object obj, k1 k1Var);
}
