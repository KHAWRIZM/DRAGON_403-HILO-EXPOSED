package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class t0 {

    /* renamed from: c, reason: collision with root package name */
    private static final t0 f٣٥٠٤c = new t0();

    /* renamed from: d, reason: collision with root package name */
    static boolean f٣٥٠٥d = false;

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f٣٥٠٧b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final y0 f٣٥٠٦a = new b0();

    private t0() {
    }

    public static t0 a() {
        return f٣٥٠٤c;
    }

    public x0 b(Class cls, x0 x0Var) {
        u.b(cls, "messageType");
        u.b(x0Var, "schema");
        return (x0) this.f٣٥٠٧b.putIfAbsent(cls, x0Var);
    }

    public x0 c(Class cls) {
        u.b(cls, "messageType");
        x0 x0Var = (x0) this.f٣٥٠٧b.get(cls);
        if (x0Var == null) {
            x0 a10 = this.f٣٥٠٦a.a(cls);
            x0 b10 = b(cls, a10);
            if (b10 != null) {
                return b10;
            }
            return a10;
        }
        return x0Var;
    }

    public x0 d(Object obj) {
        return c(obj.getClass());
    }
}
