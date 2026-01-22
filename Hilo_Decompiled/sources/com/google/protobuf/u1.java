package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class u1 {

    /* renamed from: c, reason: collision with root package name */
    private static final u1 f١١٩٦٤c = new u1();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f١١٩٦٦b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final z1 f١١٩٦٥a = new s0();

    private u1() {
    }

    public static u1 a() {
        return f١١٩٦٤c;
    }

    public y1 b(Class cls, y1 y1Var) {
        j0.b(cls, "messageType");
        j0.b(y1Var, "schema");
        return (y1) this.f١١٩٦٦b.putIfAbsent(cls, y1Var);
    }

    public y1 c(Class cls) {
        j0.b(cls, "messageType");
        y1 y1Var = (y1) this.f١١٩٦٦b.get(cls);
        if (y1Var == null) {
            y1 a10 = this.f١١٩٦٥a.a(cls);
            y1 b10 = b(cls, a10);
            if (b10 != null) {
                return b10;
            }
            return a10;
        }
        return y1Var;
    }

    public y1 d(Object obj) {
        return c(obj.getClass());
    }
}
