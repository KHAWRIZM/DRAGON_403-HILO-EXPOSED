package c0;

import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String f٥٦٤٩a = "SudGIP ".concat(l.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f٥٦٥٠b = new ArrayList();

    public static String a(int i10, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret_code", i10);
            jSONObject.put("ret_msg", str);
            return jSONObject.toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
