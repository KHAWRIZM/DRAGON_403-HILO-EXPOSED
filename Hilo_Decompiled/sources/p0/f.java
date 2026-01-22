package p0;

import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class f implements e {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f١٦٨٤١a = new TreeMap(String.CASE_INSENSITIVE_ORDER);

    public final String a(String str) {
        String str2 = (String) this.f١٦٨٤١a.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }
}
