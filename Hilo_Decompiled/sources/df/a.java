package df;

import cf.g;
import cf.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public abstract class a {
    private static final a c;
    public final g a;
    public final h b;

    static {
        a aVar;
        if (b.c()) {
            aVar = b.b();
        } else {
            aVar = null;
        }
        c = aVar;
    }

    public a(g gVar, h hVar) {
        this.a = gVar;
        this.b = hVar;
    }

    public static boolean a() {
        if (c != null) {
            return true;
        }
        return false;
    }

    public static a b() {
        return c;
    }
}
