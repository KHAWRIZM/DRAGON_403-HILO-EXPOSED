package com.taobao.agoo.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.AdapterUtilityImpl;
import com.taobao.accs.utl.JsonUtility;
import com.taobao.accs.utl.RomInfoCollecter;
import com.taobao.accs.utl.UtilityImpl;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";
    public String a;
    public String b;
    public String c;
    public String d = String.valueOf(Constants.SDK_VERSION_CODE);
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public byte[] a() {
        try {
            String jSONObject = new JsonUtility.JsonObjectBuilder().put(b.JSON_CMD, this.e).put(Constants.KEY_APP_KEY, this.a).put("utdid", this.b).put(Constants.KEY_APP_VERSION, this.c).put(Constants.KEY_SDK_VERSION, this.d).put(Constants.KEY_TTID, this.f).put(Constants.KEY_PACKAGE_NAME, this.g).put("notifyEnable", this.h).put("romInfo", this.i).put("c0", this.j).put("c1", this.k).put("c2", this.l).put("c3", this.m).put("c4", this.n).put("c5", this.o).put("c6", this.p).build().toString();
            ALog.i("RegisterDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] a(Context context, String str, String str2) {
        c cVar;
        String deviceId;
        String packageName;
        String str3;
        try {
            deviceId = UtilityImpl.getDeviceId(context);
            packageName = context.getPackageName();
            str3 = GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Throwable th) {
            th = th;
            cVar = null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(deviceId) && !TextUtils.isEmpty(str3)) {
            cVar = new c();
            try {
                cVar.e = JSON_CMD_REGISTER;
                cVar.a = str;
                cVar.b = deviceId;
                cVar.c = str3;
                cVar.f = str2;
                cVar.g = packageName;
                cVar.j = Build.BRAND;
                cVar.k = Build.MODEL;
                cVar.l = null;
                cVar.m = null;
                cVar.h = AdapterUtilityImpl.isNotificationEnabled(context);
                cVar.i = RomInfoCollecter.getCollecter().collect();
            } catch (Throwable th2) {
                th = th2;
                try {
                    ALog.w("RegisterDO", "buildRegister", th.getMessage());
                    if (cVar == null) {
                        return null;
                    }
                    return cVar.a();
                } finally {
                    if (cVar != null) {
                        cVar.a();
                    }
                }
            }
            return cVar.a();
        }
        ALog.e("RegisterDO", "buildRegister param null", Constants.KEY_APP_KEY, str, "utdid", deviceId, Constants.KEY_APP_VERSION, str3);
        return null;
    }
}
