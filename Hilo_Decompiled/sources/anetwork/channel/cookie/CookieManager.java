package anetwork.channel.cookie;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.config.NetworkConfigCenter;
import anetwork.channel.http.NetworkSdkSetting;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CookieManager {
    public static final String TAG = "anet.CookieManager";

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f٥١٦٣a = false;

    /* renamed from: b, reason: collision with root package name */
    private static android.webkit.CookieManager f٥١٦٤b = null;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f٥١٦٥c = true;

    /* renamed from: d, reason: collision with root package name */
    private static a f٥١٦٦d;

    /* renamed from: e, reason: collision with root package name */
    private static SharedPreferences f٥١٦٧e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        String f٥١٦٨a;

        /* renamed from: b, reason: collision with root package name */
        String f٥١٦٩b;

        /* renamed from: c, reason: collision with root package name */
        String f٥١٧٠c;

        /* renamed from: d, reason: collision with root package name */
        String f٥١٧١d;

        /* renamed from: e, reason: collision with root package name */
        long f٥١٧٢e;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str) {
            this.f٥١٦٨a = str;
            String string = CookieManager.f٥١٦٧e.getString("networksdk_cookie_monitor", null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (!TextUtils.isEmpty(this.f٥١٦٨a) && this.f٥١٦٨a.equals(jSONObject.getString("cookieName"))) {
                        this.f٥١٧٢e = jSONObject.getLong("time");
                        if (System.currentTimeMillis() - this.f٥١٧٢e < 86400000) {
                            this.f٥١٦٩b = jSONObject.getString("cookieText");
                            this.f٥١٧٠c = jSONObject.getString("setCookie");
                            this.f٥١٧١d = jSONObject.getString("domain");
                        } else {
                            this.f٥١٧٢e = 0L;
                            CookieManager.f٥١٦٧e.edit().remove("networksdk_cookie_monitor").apply();
                        }
                    }
                } catch (JSONException e10) {
                    ALog.e(CookieManager.TAG, "cookie json parse error.", null, e10, new Object[0]);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("cookieName", this.f٥١٦٨a);
                jSONObject.put("cookieText", this.f٥١٦٩b);
                jSONObject.put("setCookie", this.f٥١٧٠c);
                long currentTimeMillis = System.currentTimeMillis();
                this.f٥١٧٢e = currentTimeMillis;
                jSONObject.put("time", currentTimeMillis);
                jSONObject.put("domain", this.f٥١٧١d);
                CookieManager.f٥١٦٧e.edit().putString("networksdk_cookie_monitor", jSONObject.toString()).apply();
            } catch (Exception e10) {
                ALog.e(CookieManager.TAG, "cookie json save error.", null, e10, new Object[0]);
            }
        }
    }

    private static boolean d() {
        if (!f٥١٦٣a && NetworkSdkSetting.getContext() != null) {
            setup(NetworkSdkSetting.getContext());
        }
        return f٥١٦٣a;
    }

    private static void e() {
        ThreadPoolExecutorFactory.submitCookieMonitor(new anetwork.channel.cookie.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f() {
        SharedPreferences sharedPreferences = f٥١٦٧e;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("networksdk_target_cookie_name", null);
    }

    public static synchronized String getCookie(String str) {
        synchronized (CookieManager.class) {
            String str2 = null;
            if (!NetworkConfigCenter.isCookieEnable()) {
                return null;
            }
            if (!d() || !f٥١٦٥c) {
                return null;
            }
            try {
                str2 = f٥١٦٤b.getCookie(str);
            } catch (Throwable th) {
                ALog.e(TAG, "get cookie failed. url=" + str, null, th, new Object[0]);
            }
            a(str, str2);
            return str2;
        }
    }

    public static synchronized void setCookie(String str, String str2) {
        synchronized (CookieManager.class) {
            if (NetworkConfigCenter.isCookieEnable()) {
                if (d() && f٥١٦٥c) {
                    try {
                        f٥١٦٤b.setCookie(str, str2);
                        f٥١٦٤b.flush();
                    } catch (Throwable th) {
                        ALog.e(TAG, "set cookie failed.", null, th, "url", str, "cookies", str2);
                    }
                }
            }
        }
    }

    public static void setTargetMonitorCookieName(String str) {
        SharedPreferences sharedPreferences;
        if (str != null && (sharedPreferences = f٥١٦٧e) != null) {
            sharedPreferences.edit().putString("networksdk_target_cookie_name", str).apply();
        }
    }

    public static synchronized void setup(Context context) {
        synchronized (CookieManager.class) {
            if (!NetworkConfigCenter.isCookieEnable()) {
                return;
            }
            if (f٥١٦٣a) {
                return;
            }
            try {
                long currentTimeMillis = System.currentTimeMillis();
                android.webkit.CookieManager cookieManager = android.webkit.CookieManager.getInstance();
                f٥١٦٤b = cookieManager;
                cookieManager.setAcceptCookie(true);
                f٥١٦٧e = PreferenceManager.getDefaultSharedPreferences(context);
                e();
                ALog.e(TAG, "CookieManager setup.", null, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable th) {
                f٥١٦٥c = false;
                ALog.e(TAG, "Cookie Manager setup failed!!!", null, th, new Object[0]);
            }
            f٥١٦٣a = true;
        }
    }

    private static void a(String str) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new b(str));
    }

    private static void a(String str, String str2) {
        ThreadPoolExecutorFactory.submitCookieMonitor(new c(str, str2));
    }

    public static void setCookie(String str, Map<String, List<String>> map) {
        if (!NetworkConfigCenter.isCookieEnable() || str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key != null) {
                    if (!key.equalsIgnoreCase(HttpConstant.SET_COOKIE) && !key.equalsIgnoreCase(HttpConstant.SET_COOKIE2)) {
                    }
                    for (String str2 : entry.getValue()) {
                        setCookie(str, str2);
                        a(str2);
                    }
                }
            }
        } catch (Exception e10) {
            ALog.e(TAG, "set cookie failed", null, e10, "url", str, "\nheaders", map);
        }
    }
}
