package com.google.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class e {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f١٠٩٧١a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class f١٠٩٧٢b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f١٠٩٧٣c;

    static {
        boolean z10;
        if (!f١٠٩٧١a && a("org.robolectric.Robolectric") != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f١٠٩٧٣c = z10;
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class b() {
        return f١٠٩٧٢b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (!f١٠٩٧١a && (f١٠٩٧٢b == null || f١٠٩٧٣c)) {
            return false;
        }
        return true;
    }
}
