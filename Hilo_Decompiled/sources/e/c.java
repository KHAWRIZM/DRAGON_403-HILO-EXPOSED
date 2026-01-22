package e;

import java.io.Serializable;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class c implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f١٣٧١٧a = new HashMap();

    public final String a(String str) {
        String str2;
        if (str == null && (str2 = (String) this.f١٣٧١٧a.get("default")) != null) {
            return str2;
        }
        String str3 = (String) this.f١٣٧١٧a.get(str);
        if (str3 != null) {
            return str3;
        }
        String str4 = (String) this.f١٣٧١٧a.get("default");
        if (str4 != null) {
            return str4;
        }
        return "";
    }
}
