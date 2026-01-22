package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class s implements i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final s f٣٤٨٨a = new s();

    private s() {
    }

    public static s c() {
        return f٣٤٨٨a;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public h0 a(Class cls) {
        if (t.class.isAssignableFrom(cls)) {
            try {
                return (h0) t.q(cls.asSubclass(t.class)).f();
            } catch (Exception e10) {
                throw new RuntimeException("Unable to get message info for " + cls.getName(), e10);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public boolean b(Class cls) {
        return t.class.isAssignableFrom(cls);
    }
}
