package androidx.datastore.preferences.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class g1 extends e1 {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public f1 g(Object obj) {
        return ((t) obj).unknownFields;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public int h(f1 f1Var) {
        return f1Var.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public int i(f1 f1Var) {
        return f1Var.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public f1 k(f1 f1Var, f1 f1Var2) {
        if (f1.c().equals(f1Var2)) {
            return f1Var;
        }
        if (f1.c().equals(f1Var)) {
            return f1.j(f1Var, f1Var2);
        }
        return f1Var.i(f1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public f1 n() {
        return f1.k();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void o(Object obj, f1 f1Var) {
        p(obj, f1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void p(Object obj, f1 f1Var) {
        ((t) obj).unknownFields = f1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public f1 r(f1 f1Var) {
        f1Var.h();
        return f1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void s(f1 f1Var, k1 k1Var) {
        f1Var.p(k1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void t(f1 f1Var, k1 k1Var) {
        f1Var.r(k1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    public void j(Object obj) {
        g(obj).h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    public boolean q(w0 w0Var) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(f1 f1Var, int i10, int i11) {
        f1Var.n(j1.c(i10, 5), Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(f1 f1Var, int i10, long j10) {
        f1Var.n(j1.c(i10, 1), Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void c(f1 f1Var, int i10, f1 f1Var2) {
        f1Var.n(j1.c(i10, 3), f1Var2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void d(f1 f1Var, int i10, f fVar) {
        f1Var.n(j1.c(i10, 2), fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void e(f1 f1Var, int i10, long j10) {
        f1Var.n(j1.c(i10, 0), Long.valueOf(j10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.e1
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public f1 f(Object obj) {
        f1 g10 = g(obj);
        if (g10 == f1.c()) {
            f1 k10 = f1.k();
            p(obj, k10);
            return k10;
        }
        return g10;
    }
}
