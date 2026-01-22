package com.google.protobuf;

import com.google.protobuf.h0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class x extends w {

    /* renamed from: a, reason: collision with root package name */
    private static final long f١١٩٩٣a = i();

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f١١٩٩٤b = 0;

    x() {
    }

    private static long i() {
        return p2.M(h0.e.class.getDeclaredField("a"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public Object a(v vVar, e1 e1Var, int i10) {
        ((t) vVar).d(((b1) e1Var).getDescriptorForType(), i10);
        return null;
    }

    @Override // com.google.protobuf.w
    public b0 b(Object obj) {
        return (b0) p2.G(obj, f١١٩٩٣a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public b0 c(Object obj) {
        b0 b10 = b(obj);
        if (b10.z()) {
            b0 clone = b10.clone();
            j(obj, clone);
            return clone;
        }
        return b10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public boolean d(e1 e1Var) {
        return e1Var instanceof h0.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public void e(Object obj) {
        b(obj).F();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public Object f(Object obj, w1 w1Var, Object obj2, v vVar, b0 b0Var, Object obj3, j2 j2Var) {
        androidx.appcompat.app.a0.a(obj2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public void g(w1 w1Var, Object obj, v vVar, b0 b0Var) {
        androidx.appcompat.app.a0.a(obj);
        if (v.c()) {
            throw null;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.w
    public void h(h hVar, Object obj, v vVar, b0 b0Var) {
        androidx.appcompat.app.a0.a(obj);
        throw null;
    }

    void j(Object obj, b0 b0Var) {
        p2.X(obj, f١١٩٩٣a, b0Var);
    }
}
