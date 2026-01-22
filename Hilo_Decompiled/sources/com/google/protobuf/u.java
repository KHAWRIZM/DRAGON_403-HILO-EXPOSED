package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    static final Class f١١٩٦٣a = c();

    public static v a() {
        v b10 = b("getEmptyRegistry");
        if (b10 == null) {
            return v.f١١٩٧٠e;
        }
        return b10;
    }

    private static final v b(String str) {
        Class cls = f١١٩٦٣a;
        if (cls == null) {
            return null;
        }
        try {
            return (v) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class c() {
        try {
            t tVar = t.f١١٩٥٣j;
            return t.class;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
