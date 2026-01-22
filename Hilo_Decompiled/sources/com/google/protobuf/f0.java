package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
class f0 implements d1 {

    /* renamed from: a, reason: collision with root package name */
    private static final f0 f١١٠٠٤a = new f0();

    private f0() {
    }

    public static f0 c() {
        return f١١٠٠٤a;
    }

    @Override // com.google.protobuf.d1
    public c1 a(Class cls) {
        if (!g0.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            g0.b(cls.asSubclass(g0.class));
            throw null;
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
        }
    }

    @Override // com.google.protobuf.d1
    public boolean b(Class cls) {
        return g0.class.isAssignableFrom(cls);
    }
}
