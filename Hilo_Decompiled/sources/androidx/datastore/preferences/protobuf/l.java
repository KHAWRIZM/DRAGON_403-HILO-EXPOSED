package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    static final Class f٣٤٠٦a = c();

    public static m a() {
        m b10 = b("getEmptyRegistry");
        if (b10 == null) {
            return m.f٣٤٠٩c;
        }
        return b10;
    }

    private static final m b(String str) {
        Class cls = f٣٤٠٦a;
        if (cls == null) {
            return null;
        }
        try {
            return (m) cls.getDeclaredMethod(str, null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    static Class c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
