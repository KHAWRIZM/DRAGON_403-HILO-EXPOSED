package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class z {

    /* renamed from: a, reason: collision with root package name */
    private static final w f١٢٠٠٦a = new y();

    /* renamed from: b, reason: collision with root package name */
    private static final w f١٢٠٠٧b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w a() {
        w wVar = f١٢٠٠٧b;
        if (wVar != null) {
            return wVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static w b() {
        return f١٢٠٠٦a;
    }

    private static w c() {
        try {
            int i10 = x.f١١٩٩٤b;
            return (w) x.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
