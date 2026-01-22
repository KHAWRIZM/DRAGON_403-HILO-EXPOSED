package q9;

import android.content.Context;
import i9.d;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {
    public static void a(Context context, boolean z10) {
        d.h().s(context, z10);
    }

    public static boolean b(Context context) {
        return d.h().u(context);
    }

    public static void c(Context context, String str, String str2, JSONObject jSONObject, r9.a aVar) {
        d.h().w(context, str, str2, jSONObject, aVar);
    }

    public static void d(Context context, String str, String str2, r9.a aVar) {
        c(context, str, str2, null, aVar);
    }
}
