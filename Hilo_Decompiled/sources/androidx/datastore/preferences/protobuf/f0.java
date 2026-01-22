package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
final class f0 implements e0 {
    private static int i(int i10, Object obj, Object obj2) {
        d0 d0Var = (d0) obj;
        c0 c0Var = (c0) obj2;
        int i11 = 0;
        if (d0Var.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : d0Var.entrySet()) {
            i11 += c0Var.a(i10, entry.getKey(), entry.getValue());
        }
        return i11;
    }

    private static d0 j(Object obj, Object obj2) {
        d0 d0Var = (d0) obj;
        d0 d0Var2 = (d0) obj2;
        if (!d0Var2.isEmpty()) {
            if (!d0Var.j()) {
                d0Var = d0Var.m();
            }
            d0Var.l(d0Var2);
        }
        return d0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Object a(Object obj, Object obj2) {
        return j(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public c0.a b(Object obj) {
        return ((c0) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Map c(Object obj) {
        return (d0) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Object d(Object obj) {
        return d0.f().m();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Object e(Object obj) {
        ((d0) obj).k();
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public int f(int i10, Object obj, Object obj2) {
        return i(i10, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public boolean g(Object obj) {
        return !((d0) obj).j();
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public Map h(Object obj) {
        return (d0) obj;
    }
}
