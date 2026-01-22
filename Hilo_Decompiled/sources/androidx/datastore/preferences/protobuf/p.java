package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    private static final n f٣٤٣٦a = new o();

    /* renamed from: b, reason: collision with root package name */
    private static final n f٣٤٣٧b = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a() {
        n nVar = f٣٤٣٧b;
        if (nVar != null) {
            return nVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n b() {
        return f٣٤٣٦a;
    }

    private static n c() {
        if (t0.f٣٥٠٥d) {
            return null;
        }
        try {
            return (n) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
