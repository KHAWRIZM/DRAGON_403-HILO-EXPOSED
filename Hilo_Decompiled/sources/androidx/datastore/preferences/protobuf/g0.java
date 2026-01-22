package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static final e0 f٣٣٢٤a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final e0 f٣٣٢٥b = new f0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 a() {
        return f٣٣٢٤a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e0 b() {
        return f٣٣٢٥b;
    }

    private static e0 c() {
        if (t0.f٣٥٠٥d) {
            return null;
        }
        try {
            return (e0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
