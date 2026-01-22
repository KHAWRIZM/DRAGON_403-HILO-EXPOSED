package com.google.protobuf;

import com.google.protobuf.u0;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class z0 implements x0 {
    private static int h(int i10, Object obj, Object obj2) {
        w0 w0Var = (w0) obj;
        androidx.appcompat.app.a0.a(obj2);
        if (w0Var.isEmpty()) {
            return 0;
        }
        Iterator it = w0Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw null;
    }

    private static w0 i(Object obj, Object obj2) {
        w0 w0Var = (w0) obj;
        w0 w0Var2 = (w0) obj2;
        if (!w0Var2.isEmpty()) {
            if (!w0Var.l()) {
                w0Var = w0Var.o();
            }
            w0Var.n(w0Var2);
        }
        return w0Var;
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
        return (w0) obj;
    }

    @Override // com.google.protobuf.x0
    public Object d(Object obj) {
        return w0.h().o();
    }

    @Override // com.google.protobuf.x0
    public Object e(Object obj) {
        ((w0) obj).m();
        return obj;
    }

    @Override // com.google.protobuf.x0
    public int f(int i10, Object obj, Object obj2) {
        return h(i10, obj, obj2);
    }

    @Override // com.google.protobuf.x0
    public boolean g(Object obj) {
        return !((w0) obj).l();
    }
}
