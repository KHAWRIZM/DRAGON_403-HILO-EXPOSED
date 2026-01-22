package com.ta.a.a;

import android.content.Context;
import com.ta.utdid2.a.a.d;
import com.taobao.accs.common.Constants;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public static String a(String str) {
        Context context = com.ta.a.a.a().getContext();
        if (context == null) {
            return "";
        }
        return d.e(String.format("{\"type\":\"%s\",\"timestamp\":%s,\"data\":%s}", "audid", com.ta.a.a.a().m١٢٤a(), a(str, "", "", context.getPackageName())));
    }

    private static String a(String str, String str2, String str3, String str4) {
        HashMap hashMap = new HashMap();
        hashMap.put("audid", str2);
        hashMap.put("utdid", str);
        hashMap.put(Constants.SP_KEY_APPKEY, str3);
        hashMap.put("appName", str4);
        return new JSONObject(d.a(hashMap)).toString();
    }
}
