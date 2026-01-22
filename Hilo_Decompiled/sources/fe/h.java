package fe;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class h {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void b(Class cls) {
        ie.a.s(new od.e(a(cls.getName())));
    }

    public static boolean c(AtomicReference atomicReference, nd.c cVar, Class cls) {
        Objects.requireNonNull(cVar, "next is null");
        if (!androidx.lifecycle.a.a(atomicReference, null, cVar)) {
            cVar.dispose();
            if (atomicReference.get() != qd.c.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean d(nd.c cVar, nd.c cVar2, Class cls) {
        Objects.requireNonNull(cVar2, "next is null");
        if (cVar != null) {
            cVar2.dispose();
            if (cVar != qd.c.DISPOSED) {
                b(cls);
                return false;
            }
            return false;
        }
        return true;
    }
}
