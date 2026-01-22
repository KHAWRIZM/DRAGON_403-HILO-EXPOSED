package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    private static final o0 f٣٤٤٤a = c();

    /* renamed from: b, reason: collision with root package name */
    private static final o0 f٣٤٤٥b = new p0();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o0 a() {
        return f٣٤٤٤a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o0 b() {
        return f٣٤٤٥b;
    }

    private static o0 c() {
        if (t0.f٣٥٠٥d) {
            return null;
        }
        try {
            return (o0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }
}
