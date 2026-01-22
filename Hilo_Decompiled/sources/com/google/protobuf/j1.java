package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class j1 implements y1 {

    /* renamed from: a, reason: collision with root package name */
    private final e1 f١١١٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private final j2 f١١١٦٨b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١١١٦٩c;

    /* renamed from: d, reason: collision with root package name */
    private final w f١١١٧٠d;

    private j1(j2 j2Var, w wVar, e1 e1Var) {
        this.f١١١٦٨b = j2Var;
        this.f١١١٦٩c = wVar.d(e1Var);
        this.f١١١٧٠d = wVar;
        this.f١١١٦٧a = e1Var;
    }

    private int f(j2 j2Var, Object obj) {
        return j2Var.i(j2Var.g(obj));
    }

    private void g(j2 j2Var, w wVar, Object obj, w1 w1Var, v vVar) {
        Object f10 = j2Var.f(obj);
        b0 c10 = wVar.c(obj);
        do {
            try {
                if (w1Var.z() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                j2Var.o(obj, f10);
            }
        } while (i(w1Var, vVar, wVar, c10, j2Var, f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j1 h(j2 j2Var, w wVar, e1 e1Var) {
        return new j1(j2Var, wVar, e1Var);
    }

    private boolean i(w1 w1Var, v vVar, w wVar, b0 b0Var, j2 j2Var, Object obj) {
        int tag = w1Var.getTag();
        if (tag != r2.f١١٩٠٩a) {
            if (r2.b(tag) == 2) {
                Object a10 = wVar.a(vVar, this.f١١١٦٧a, r2.a(tag));
                if (a10 != null) {
                    wVar.g(w1Var, a10, vVar, b0Var);
                    return true;
                }
                return j2Var.m(obj, w1Var);
            }
            return w1Var.C();
        }
        Object obj2 = null;
        h hVar = null;
        int i10 = 0;
        while (w1Var.z() != Integer.MAX_VALUE) {
            int tag2 = w1Var.getTag();
            if (tag2 == r2.f١١٩١١c) {
                i10 = w1Var.g();
                obj2 = wVar.a(vVar, this.f١١١٦٧a, i10);
            } else if (tag2 == r2.f١١٩١٢d) {
                if (obj2 != null) {
                    wVar.g(w1Var, obj2, vVar, b0Var);
                } else {
                    hVar = w1Var.n();
                }
            } else if (!w1Var.C()) {
                break;
            }
        }
        if (w1Var.getTag() == r2.f١١٩١٠b) {
            if (hVar != null) {
                if (obj2 != null) {
                    wVar.h(hVar, obj2, vVar, b0Var);
                } else {
                    j2Var.d(obj, i10, hVar);
                }
            }
            return true;
        }
        throw k0.a();
    }

    @Override // com.google.protobuf.y1
    public void a(Object obj, Object obj2) {
        a2.G(this.f١١١٦٨b, obj, obj2);
        if (this.f١١١٦٩c) {
            a2.E(this.f١١١٧٠d, obj, obj2);
        }
    }

    @Override // com.google.protobuf.y1
    public void b(Object obj) {
        this.f١١١٦٨b.j(obj);
        this.f١١١٧٠d.e(obj);
    }

    @Override // com.google.protobuf.y1
    public int c(Object obj) {
        int f10 = f(this.f١١١٦٨b, obj);
        if (this.f١١١٦٩c) {
            return f10 + this.f١١١٧٠d.b(obj).r();
        }
        return f10;
    }

    @Override // com.google.protobuf.y1
    public Object d() {
        return this.f١١١٦٧a.newBuilderForType().buildPartial();
    }

    @Override // com.google.protobuf.y1
    public void e(Object obj, w1 w1Var, v vVar) {
        g(this.f١١١٦٨b, this.f١١١٧٠d, obj, w1Var, vVar);
    }
}
