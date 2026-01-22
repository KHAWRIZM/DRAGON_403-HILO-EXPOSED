package com.taobao.agoo.a.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a extends b {
    public static final String INVALID_TOKEN = "deprecated_alias_token_should_be_ignored";
    public static final String JSON_ALIAS_TOKEN_MAP = "aliasTokenMap";
    public static final String JSON_CMD_ADDALIAS = "setAlias";
    public static final String JSON_CMD_LISTALIAS = "getAliasTokenMap";
    public static final String JSON_CMD_REMOVEALIAS = "removeAlias";
    public static final String JSON_CMD_REMOVEALLALIAS = "unbindAllAliasByDeviceId";
    public static final String JSON_CMD_REMOVEALLALIASANDADDALIAS = "resetDeviceAndBindCurrentAlias";
    public static final String JSON_CMD_RESETALIASDEVICEONE2ONE = "resetDeviceAndAliasToSingleBind";
    public static final String JSON_CMD_RESETAlIASANDBINDCURRENT = "resetAliasAndBindCurrentDevice";
    public String a;
    public String b;
    public String c;
    public String d;

    public static byte[] b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.e = JSON_CMD_ADDALIAS;
        return aVar.a();
    }

    public static byte[] c(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.e = JSON_CMD_REMOVEALLALIASANDADDALIAS;
        return aVar.a();
    }

    public static byte[] d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.e = JSON_CMD_RESETALIASDEVICEONE2ONE;
        return aVar.a();
    }

    public byte[] a() {
        try {
            String jSONObject = new JsonUtility.JsonObjectBuilder().put(b.JSON_CMD, this.e).put(Constants.KEY_APP_KEY, this.a).put("deviceId", this.b).put("alias", this.c).put("pushAliasToken", this.d).build().toString();
            ALog.i("AliasDO", "buildData", "data", jSONObject);
            return jSONObject.getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("AliasDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    public static byte[] b(String str, String str2) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.e = JSON_CMD_LISTALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2, String str3) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.e = JSON_CMD_RESETAlIASANDBINDCURRENT;
        return aVar.a();
    }

    public static byte[] a(String str, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.c = str3;
        aVar.d = str4;
        aVar.e = JSON_CMD_REMOVEALIAS;
        return aVar.a();
    }

    public static byte[] a(String str, String str2) {
        a aVar = new a();
        aVar.a = str;
        aVar.b = str2;
        aVar.e = JSON_CMD_REMOVEALLALIAS;
        return aVar.a();
    }
}
