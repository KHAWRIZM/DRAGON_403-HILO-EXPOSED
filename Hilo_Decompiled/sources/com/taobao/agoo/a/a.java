package com.taobao.agoo.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "EMAS_AGOO_BIND";
    private ConcurrentMap<String, Integer> a = new ConcurrentHashMap();
    private long b;
    private Context c;
    private String d;

    public a(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
            StringBuilder sb2 = new StringBuilder();
            try {
                sb2.append("EMAS_AGOO_BIND");
                sb2.append(Config.d(context));
                sb2.append(AccsClientConfig.getConfigByTag(Config.d(context)).getInappHost());
                this.d = sb2.toString();
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        throw new RuntimeException("Context is null!!");
    }

    public void a(String str) {
        Integer num = this.a.get(str);
        if (num == null || num.intValue() != 2) {
            this.a.put(str, 2);
            a(this.c, this.d, this.b, this.a);
        }
    }

    public boolean b(String str) {
        if (this.a.isEmpty()) {
            b();
        }
        Integer num = this.a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", Constants.KEY_PACKAGE_NAME, str, "appStatus", num, "agooBindStatus", this.a);
        return (UtilityImpl.utdidChanged(Config.PREFERENCES, this.c) || num == null || num.intValue() != 2) ? false : true;
    }

    private void a(Context context, String str, long j, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j > 0 && j < System.currentTimeMillis()) {
                jSONArray.put(j);
            } else {
                jSONArray.put(System.currentTimeMillis() - (Math.random() * 8.64E7d));
            }
            for (String str2 : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", str2);
                jSONObject.put("s", map.get(str2).intValue());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString("bind_status", jSONArray.toString());
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void b() {
        try {
            String string = this.c.getSharedPreferences(this.d, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.b = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.b;
            if (currentTimeMillis < Constants.CLIENT_FLUSH_INTERVAL + j) {
                for (int i = 1; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.a.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(j));
            this.b = 0L;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.a.clear();
        this.b = 0L;
        try {
            this.c.getSharedPreferences(this.d, 0).edit().clear().commit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
