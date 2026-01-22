package u;

import android.os.Build;
import android.text.TextUtils;
import java.util.UUID;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f١٨٢٢٣a;

    public static String a() {
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append("_");
        String str = Build.MODEL;
        String str2 = "";
        if (str != null) {
            str2 = str.trim().replaceAll("\\s*", "");
        }
        sb.append(str2);
        return sb.toString();
    }

    public static String b(String str, String str2) {
        String str3;
        if (str2.equals("")) {
            str3 = str + UUID.randomUUID().toString().replace("-", "");
        } else {
            str3 = str + UUID.nameUUIDFromBytes(str2.getBytes()).toString().replace("-", "");
        }
        f١٨٢٢٣a = str3;
        d0.a.a("TechSudMGPGlobal.sp").c("key_device_id", f١٨٢٢٣a, false);
        return f١٨٢٢٣a;
    }

    public static String c() {
        String b10;
        if (f١٨٢٢٣a == null) {
            synchronized (h.class) {
                if (f١٨٢٢٣a == null) {
                    String string = d0.a.a("TechSudMGPGlobal.sp").f١٣٥٣٩a.getString("key_device_id", null);
                    if (string != null) {
                        f١٨٢٢٣a = string;
                        return f١٨٢٢٣a;
                    }
                    if (!TextUtils.isEmpty(null)) {
                        String string2 = d0.a.a("TechSudMGPGlobal.sp").f١٣٥٣٩a.getString("key_device_id", null);
                        if (string2 != null) {
                            f١٨٢٢٣a = string2;
                            b10 = f١٨٢٢٣a;
                            return b10;
                        }
                        b("2", null);
                        throw null;
                    }
                    b10 = b("9", "");
                    return b10;
                }
            }
        }
        return f١٨٢٢٣a;
    }

    public static String d() {
        return Build.VERSION.SDK_INT + "";
    }
}
