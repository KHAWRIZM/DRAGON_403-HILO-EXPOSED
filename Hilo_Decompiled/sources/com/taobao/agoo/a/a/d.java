package com.taobao.agoo.a.a;

import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class d extends b {
    public static final String JSON_CMD_DISABLEPUSH = "disablePush";
    public static final String JSON_CMD_ENABLEPUSH = "enablePush";
    public String a;
    public String b;
    public String c;

    public byte[] a() {
        try {
            JsonUtility.JsonObjectBuilder jsonObjectBuilder = new JsonUtility.JsonObjectBuilder();
            jsonObjectBuilder.put(b.JSON_CMD, this.e).put(Constants.KEY_APP_KEY, this.a);
            if (TextUtils.isEmpty(this.b)) {
                jsonObjectBuilder.put("utdid", this.c);
            } else {
                jsonObjectBuilder.put("deviceId", this.b);
            }
            String jSONObject = jsonObjectBuilder.build().toString();
            ALog.i("SwitchDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("SwitchDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3, boolean z) {
        d dVar = new d();
        dVar.a = str;
        dVar.b = str2;
        dVar.c = str3;
        if (z) {
            dVar.e = JSON_CMD_ENABLEPUSH;
        } else {
            dVar.e = JSON_CMD_DISABLEPUSH;
        }
        return dVar.a();
    }
}
