package com.google.protobuf;

import com.google.protobuf.u0;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class y0 implements x0 {
    y0() {
    }

    private static int h(int i10, Object obj, Object obj2) {
        if (obj == null) {
            return 0;
        }
        Map h10 = ((v0) obj).h();
        androidx.appcompat.app.a0.a(obj2);
        if (h10.isEmpty()) {
            return 0;
        }
        Iterator it = h10.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        k.W(i10);
        throw null;
    }

    private static Object i(Object obj, Object obj2) {
        v0 v0Var = (v0) obj;
        v0 v0Var2 = (v0) obj2;
        if (!v0Var.l()) {
            v0Var.f();
        }
        v0Var.n(v0Var2);
        return v0Var;
    }

    @Override // com.google.protobuf.x0
    public Object a(Object obj, Object obj2) {
        return i(obj, obj2);
    }

    @Override // com.google.protobuf.x0
    public u0.a b(Object obj) {
        androidx.appcompat.app.a0.a(obj);
        throw null;
    }

    @Override // com.google.protobuf.x0
    public Map c(Object obj) {
        return ((v0) obj).k();
    }

    @Override // com.google.protobuf.x0
    public Object d(Object obj) {
        androidx.appcompat.app.a0.a(obj);
        return v0.o(null);
    }

    @Override // com.google.protobuf.x0
    public Object e(Object obj) {
        ((v0) obj).m();
        return obj;
    }

    @Override // com.google.protobuf.x0
    public int f(int i10, Object obj, Object obj2) {
        return h(i10, obj, obj2);
    }

    @Override // com.google.protobuf.x0
    public boolean g(Object obj) {
        return !((v0) obj).l();
    }
}
