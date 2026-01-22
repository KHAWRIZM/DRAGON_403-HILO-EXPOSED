package f;

import java.util.HashMap;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudListenerReportStatsEvent;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f١٤٠٢٣a = "";

    /* renamed from: b, reason: collision with root package name */
    public static ISudListenerReportStatsEvent f١٤٠٢٤b;

    /* renamed from: c, reason: collision with root package name */
    public static final c f١٤٠٢٥c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f١٤٠٢٦d = new HashMap();

    public static String a(String str) {
        String str2;
        if (!str.isEmpty()) {
            str2 = (String) f١٤٠٢٥c.get(str);
        } else {
            str2 = null;
        }
        if (str2 != null && !str2.isEmpty()) {
            return str2;
        }
        return "UNSPECIFIED";
    }

    public static void b(a aVar) {
        ThreadUtils.postUITask(new b(aVar.toString(), false, aVar.f١٣٩٩٨a, aVar.f١٤٠٠٢e));
    }
}
