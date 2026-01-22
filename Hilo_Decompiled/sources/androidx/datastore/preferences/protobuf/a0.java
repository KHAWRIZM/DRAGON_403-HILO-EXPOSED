package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final y f٣٢٤٤a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final y f٣٢٤٥b = new z();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y a() {
        return f٣٢٤٤a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y b() {
        return f٣٢٤٥b;
    }

    private static y c() {
        if (t0.f٣٥٠٥d) {
            return null;
        }
        try {
            return (y) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
