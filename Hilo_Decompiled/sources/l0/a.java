package l0;

import java.io.File;
import n0.e;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final File f١٥٦٨٣a = new File("");

    public abstract String a();

    public final boolean c(e eVar) {
        if (g().equals(eVar.f١٦١١٤c) && !g().equals("") && !d().equals(f١٥٦٨٣a)) {
            if (f().equals(eVar.f١٦١٣١t)) {
                return true;
            }
            if (!d().equals(eVar.f١٦١٣٢u)) {
                return false;
            }
            String a10 = a();
            String str = eVar.f١٦١٣٠s.f١٨٨٢٤a;
            if (str != null && a10 != null && str.equals(a10)) {
                return true;
            }
        }
        return false;
    }

    public abstract File d();

    public abstract int e();

    public abstract File f();

    public abstract String g();
}
