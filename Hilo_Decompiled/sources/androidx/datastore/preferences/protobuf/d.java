package androidx.datastore.preferences.protobuf;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f٣٢٧٨a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class f٣٢٧٩b = a("libcore.io.Memory");

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f٣٢٨٠c;

    static {
        boolean z10;
        if (!f٣٢٧٨a && a("org.robolectric.Robolectric") != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        f٣٢٨٠c = z10;
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
        return f٣٢٧٩b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (!f٣٢٧٨a && (f٣٢٧٩b == null || f٣٢٨٠c)) {
            return false;
        }
        return true;
    }
}
