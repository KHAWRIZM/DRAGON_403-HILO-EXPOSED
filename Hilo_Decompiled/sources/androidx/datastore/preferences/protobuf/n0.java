package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class n0 implements x0 {

    /* renamed from: a, reason: collision with root package name */
    private final j0 f٣٤٣٢a;

    /* renamed from: b, reason: collision with root package name */
    private final e1 f٣٤٣٣b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f٣٤٣٤c;

    /* renamed from: d, reason: collision with root package name */
    private final n f٣٤٣٥d;

    private n0(e1 e1Var, n nVar, j0 j0Var) {
        this.f٣٤٣٣b = e1Var;
        this.f٣٤٣٤c = nVar.e(j0Var);
        this.f٣٤٣٥d = nVar;
        this.f٣٤٣٢a = j0Var;
    }

    private int j(e1 e1Var, Object obj) {
        return e1Var.i(e1Var.g(obj));
    }

    private void k(e1 e1Var, n nVar, Object obj, w0 w0Var, m mVar) {
        Object f10 = e1Var.f(obj);
        q d10 = nVar.d(obj);
        do {
            try {
                if (w0Var.z() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                e1Var.o(obj, f10);
            }
        } while (m(w0Var, mVar, nVar, d10, e1Var, f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n0 l(e1 e1Var, n nVar, j0 j0Var) {
        return new n0(e1Var, nVar, j0Var);
    }

    private boolean m(w0 w0Var, m mVar, n nVar, q qVar, e1 e1Var, Object obj) {
        int tag = w0Var.getTag();
        int i10 = 0;
        if (tag != j1.f٣٣٦٧a) {
            if (j1.b(tag) == 2) {
                Object b10 = nVar.b(mVar, this.f٣٤٣٢a, j1.a(tag));
                if (b10 != null) {
                    nVar.h(w0Var, b10, mVar, qVar);
                    return true;
                }
                return e1Var.m(obj, w0Var, 0);
            }
            return w0Var.C();
        }
        Object obj2 = null;
        f fVar = null;
        while (w0Var.z() != Integer.MAX_VALUE) {
            int tag2 = w0Var.getTag();
            if (tag2 == j1.f٣٣٦٩c) {
                i10 = w0Var.g();
                obj2 = nVar.b(mVar, this.f٣٤٣٢a, i10);
            } else if (tag2 == j1.f٣٣٧٠d) {
                if (obj2 != null) {
                    nVar.h(w0Var, obj2, mVar, qVar);
                } else {
                    fVar = w0Var.n();
                }
            } else if (!w0Var.C()) {
                break;
            }
        }
        if (w0Var.getTag() == j1.f٣٣٦٨b) {
            if (fVar != null) {
                if (obj2 != null) {
                    nVar.i(fVar, obj2, mVar, qVar);
                } else {
                    e1Var.d(obj, i10, fVar);
                }
            }
            return true;
        }
        throw v.b();
    }

    private void n(e1 e1Var, Object obj, k1 k1Var) {
        e1Var.s(e1Var.g(obj), k1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void a(Object obj, Object obj2) {
        z0.F(this.f٣٤٣٣b, obj, obj2);
        if (this.f٣٤٣٤c) {
            z0.D(this.f٣٤٣٥d, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void b(Object obj) {
        this.f٣٤٣٣b.j(obj);
        this.f٣٤٣٥d.f(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int c(Object obj) {
        int j10 = j(this.f٣٤٣٣b, obj);
        if (this.f٣٤٣٤c) {
            return j10 + this.f٣٤٣٥d.c(obj).f();
        }
        return j10;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public Object d() {
        j0 j0Var = this.f٣٤٣٢a;
        if (j0Var instanceof t) {
            return ((t) j0Var).E();
        }
        return j0Var.newBuilderForType().buildPartial();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void e(Object obj, w0 w0Var, m mVar) {
        k(this.f٣٤٣٣b, this.f٣٤٣٥d, obj, w0Var, mVar);
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public final boolean f(Object obj) {
        return this.f٣٤٣٥d.c(obj).k();
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public int g(Object obj) {
        int hashCode = this.f٣٤٣٣b.g(obj).hashCode();
        if (this.f٣٤٣٤c) {
            return (hashCode * 53) + this.f٣٤٣٥d.c(obj).hashCode();
        }
        return hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public void h(Object obj, k1 k1Var) {
        Iterator n10 = this.f٣٤٣٥d.c(obj).n();
        if (!n10.hasNext()) {
            n(this.f٣٤٣٣b, obj, k1Var);
        } else {
            androidx.appcompat.app.a0.a(((Map.Entry) n10.next()).getKey());
            throw null;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.x0
    public boolean i(Object obj, Object obj2) {
        if (!this.f٣٤٣٣b.g(obj).equals(this.f٣٤٣٣b.g(obj2))) {
            return false;
        }
        if (this.f٣٤٣٤c) {
            return this.f٣٤٣٥d.c(obj).equals(this.f٣٤٣٥d.c(obj2));
        }
        return true;
    }
}
