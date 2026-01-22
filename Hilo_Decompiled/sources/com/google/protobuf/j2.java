package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class j2 {
    abstract void a(Object obj, int i10, int i11);

    abstract void b(Object obj, int i10, long j10);

    abstract void c(Object obj, int i10, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(Object obj, int i10, h hVar);

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

    final void l(Object obj, w1 w1Var) {
        while (w1Var.z() != Integer.MAX_VALUE && m(obj, w1Var)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(Object obj, w1 w1Var) {
        int tag = w1Var.getTag();
        int a10 = r2.a(tag);
        int b10 = r2.b(tag);
        if (b10 != 0) {
            if (b10 != 1) {
                if (b10 != 2) {
                    if (b10 != 3) {
                        if (b10 != 4) {
                            if (b10 == 5) {
                                a(obj, a10, w1Var.t());
                                return true;
                            }
                            throw k0.d();
                        }
                        return false;
                    }
                    Object n10 = n();
                    int c10 = r2.c(a10, 4);
                    l(n10, w1Var);
                    if (c10 == w1Var.getTag()) {
                        c(obj, a10, r(n10));
                        return true;
                    }
                    throw k0.a();
                }
                d(obj, a10, w1Var.n());
                return true;
            }
            b(obj, a10, w1Var.a());
            return true;
        }
        e(obj, a10, w1Var.G());
        return true;
    }

    abstract Object n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, Object obj2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(w1 w1Var);

    abstract Object r(Object obj);
}
