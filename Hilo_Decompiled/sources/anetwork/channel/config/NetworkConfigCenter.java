package anetwork.channel.config;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.utils.c;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpUrl;
import anetwork.channel.cache.CacheManager;
import anetwork.channel.http.NetworkSdkSetting;
import com.oudi.utils.date.DateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NetworkConfigCenter {
    public static final String SERVICE_OPTIMIZE = "SERVICE_OPTIMIZE";
    public static final String SESSION_ASYNC_OPTIMIZE = "SESSION_ASYNC_OPTIMIZE";

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f٥١٣٩a = true;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f٥١٤٠b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f٥١٤١c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile int f٥١٤٢d = 5;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f٥١٤٣e = true;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f٥١٤٤f = true;

    /* renamed from: g, reason: collision with root package name */
    private static volatile boolean f٥١٤٥g;

    /* renamed from: h, reason: collision with root package name */
    private static volatile long f٥١٤٦h;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f٥١٤٧i;

    /* renamed from: j, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, List<String>> f٥١٤٨j;

    /* renamed from: k, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f٥١٤٩k;

    /* renamed from: l, reason: collision with root package name */
    private static final List<String> f٥١٥٠l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private static volatile int f٥١٥١m = 10000;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f٥١٥٢n = true;

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f٥١٥٣o = false;

    /* renamed from: p, reason: collision with root package name */
    private static volatile int f٥١٥٤p = DateUtils.MINUTE;

    /* renamed from: q, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f٥١٥٥q = null;

    /* renamed from: r, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, List<String>> f٥١٥٦r = null;

    /* renamed from: s, reason: collision with root package name */
    private static volatile boolean f٥١٥٧s = true;

    /* renamed from: t, reason: collision with root package name */
    private static volatile boolean f٥١٥٨t = false;

    /* renamed from: u, reason: collision with root package name */
    private static volatile boolean f٥١٥٩u = false;

    /* renamed from: v, reason: collision with root package name */
    private static volatile boolean f٥١٦٠v = true;

    /* renamed from: w, reason: collision with root package name */
    private static volatile boolean f٥١٦١w = true;

    /* renamed from: x, reason: collision with root package name */
    private static volatile IRemoteConfig f٥١٦٢x;

    public static void enableNetworkSdkOptimizeTest(boolean z10) {
        if (z10) {
            setGetSessionAsyncEnable(true);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(16);
            AwcnConfig.registerPresetSessions("[{\"host\":\"trade-acs.m.taobao.com\", \"protocol\":\"http2\", \"rtt\":\"0rtt\", \"publicKey\": \"acs\", \"isKeepAlive\":true}]");
        } else {
            setGetSessionAsyncEnable(false);
            ThreadPoolExecutorFactory.setNormalExecutorPoolSize(6);
        }
    }

    public static int getBgForbidRequestThreshold() {
        return f٥١٥٤p;
    }

    public static int getRequestStatisticSampleRate() {
        return f٥١٥١m;
    }

    public static int getServiceBindWaitTime() {
        return f٥١٤٢d;
    }

    public static void init() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext());
        f٥١٤٦h = defaultSharedPreferences.getLong("Cache.Flag", 0L);
        f٥١٥٩u = defaultSharedPreferences.getBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", false);
        f٥١٦٠v = defaultSharedPreferences.getBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", true);
    }

    public static boolean isAllowHttpIpRetry() {
        if (f٥١٤٣e && f٥١٤٥g) {
            return true;
        }
        return false;
    }

    public static boolean isAllowSpdyWhenBindServiceFailed() {
        return f٥١٦٠v;
    }

    public static boolean isBgRequestForbidden() {
        return f٥١٤٧i;
    }

    public static boolean isBindServiceOptimize() {
        return f٥١٥٨t;
    }

    public static boolean isBizInWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList = f٥١٤٩k;
        if (f٥١٤٩k == null) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isChannelLocalInstanceEnable() {
        return f٥١٥٩u;
    }

    public static boolean isCookieEnable() {
        return f٥١٦١w;
    }

    public static boolean isGetSessionAsyncEnable() {
        return f٥١٥٣o;
    }

    public static boolean isHttpCacheEnable() {
        return f٥١٤٤f;
    }

    public static boolean isHttpSessionEnable() {
        return f٥١٤٣e;
    }

    public static boolean isRemoteNetworkServiceEnable() {
        return f٥١٤١c;
    }

    public static boolean isRequestDelayRetryForNoNetwork() {
        return f٥١٥٧s;
    }

    public static boolean isRequestInMonitorList(RequestStatistic requestStatistic) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (requestStatistic == null || (copyOnWriteArrayList = f٥١٥٥q) == null || TextUtils.isEmpty(requestStatistic.host)) {
            return false;
        }
        Iterator<String> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (requestStatistic.host.equalsIgnoreCase(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isResponseBufferEnable() {
        return f٥١٥٢n;
    }

    public static boolean isSSLEnabled() {
        return f٥١٣٩a;
    }

    public static boolean isSpdyEnabled() {
        return f٥١٤٠b;
    }

    public static boolean isUrlInDegradeList(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f٥١٥٦r) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == f٥١٥٠l) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUrlInWhiteList(HttpUrl httpUrl) {
        ConcurrentHashMap<String, List<String>> concurrentHashMap;
        List<String> list;
        if (httpUrl == null || (concurrentHashMap = f٥١٤٨j) == null || (list = concurrentHashMap.get(httpUrl.host())) == null) {
            return false;
        }
        if (list == f٥١٥٠l) {
            return true;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (httpUrl.path().startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static void setAllowHttpIpRetry(boolean z10) {
        f٥١٤٥g = z10;
    }

    public static void setAllowSpdyWhenBindServiceFailed(boolean z10) {
        f٥١٦٠v = z10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("ALLOW_SPDY_WHEN_BIND_SERVICE_FAILED", f٥١٦٠v);
        edit.apply();
    }

    public static void setAmdcPresetHosts(String str) {
        if (!GlobalAppRuntimeInfo.isTargetProcess()) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (c.c(string)) {
                    arrayList.add(string);
                }
            }
            HttpDispatcher.getInstance().addHosts(arrayList);
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e10, new Object[0]);
        }
    }

    public static void setBgForbidRequestThreshold(int i10) {
        f٥١٥٤p = i10;
    }

    public static void setBgRequestForbidden(boolean z10) {
        f٥١٤٧i = z10;
    }

    public static void setBindServiceOptimize(boolean z10) {
        f٥١٥٨t = z10;
    }

    public static void setCacheFlag(long j10) {
        if (j10 != f٥١٤٦h) {
            ALog.i("anet.NetworkConfigCenter", "set cache flag", null, "old", Long.valueOf(f٥١٤٦h), "new", Long.valueOf(j10));
            f٥١٤٦h = j10;
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
            edit.putLong("Cache.Flag", f٥١٤٦h);
            edit.apply();
            CacheManager.clearAllCache();
        }
    }

    public static void setChannelLocalInstanceEnable(boolean z10) {
        f٥١٥٩u = z10;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(NetworkSdkSetting.getContext()).edit();
        edit.putBoolean("CHANNEL_LOCAL_INSTANCE_ENABLE", f٥١٥٩u);
        edit.apply();
    }

    public static void setCookieEnable(boolean z10) {
        f٥١٦١w = z10;
    }

    public static void setDegradeRequestList(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "setDegradeRequestList", null, "Degrade List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f٥١٥٦r = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, f٥١٥٠l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i10 = 0; i10 < length; i10++) {
                            Object obj2 = jSONArray.get(i10);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e10, new Object[0]);
        }
        f٥١٥٦r = concurrentHashMap;
    }

    public static void setGetSessionAsyncEnable(boolean z10) {
        f٥١٥٣o = z10;
    }

    public static void setHttpCacheEnable(boolean z10) {
        f٥١٤٤f = z10;
    }

    public static void setHttpSessionEnable(boolean z10) {
        f٥١٤٣e = z10;
    }

    @Deprecated
    public static void setHttpsValidationEnabled(boolean z10) {
    }

    public static void setMonitorRequestList(String str) {
        if (TextUtils.isEmpty(str)) {
            f٥١٥٥q = null;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("host");
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (c.c(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f٥١٥٥q = copyOnWriteArrayList;
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse hosts failed", null, e10, new Object[0]);
        }
    }

    public static void setRemoteConfig(IRemoteConfig iRemoteConfig) {
        if (f٥١٦٢x != null) {
            f٥١٦٢x.unRegister();
        }
        if (iRemoteConfig != null) {
            iRemoteConfig.register();
        }
        f٥١٦٢x = iRemoteConfig;
    }

    public static void setRemoteNetworkServiceEnable(boolean z10) {
        f٥١٤١c = z10;
    }

    public static void setRequestDelayRetryForNoNetwork(boolean z10) {
        f٥١٥٧s = z10;
    }

    public static void setRequestStatisticSampleRate(int i10) {
        f٥١٥١m = i10;
    }

    public static void setResponseBufferEnable(boolean z10) {
        f٥١٥٢n = z10;
    }

    public static void setSSLEnabled(boolean z10) {
        ALog.i("anet.NetworkConfigCenter", "[setSSLEnabled]", null, "enable", Boolean.valueOf(z10));
        f٥١٣٩a = z10;
    }

    public static void setServiceBindWaitTime(int i10) {
        f٥١٤٢d = i10;
    }

    public static void setSpdyEnabled(boolean z10) {
        ALog.i("anet.NetworkConfigCenter", "[setSpdyEnabled]", null, "enable", Boolean.valueOf(z10));
        f٥١٤٠b = z10;
    }

    public static void updateBizWhiteList(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateRequestWhiteList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f٥١٤٩k = null;
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (int i10 = 0; i10 < length; i10++) {
                String string = jSONArray.getString(i10);
                if (!string.isEmpty()) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f٥١٤٩k = copyOnWriteArrayList;
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse bizId failed", null, e10, new Object[0]);
        }
    }

    public static void updateWhiteListMap(String str) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkConfigCenter", "updateWhiteUrlList", null, "White List", str);
        }
        if (TextUtils.isEmpty(str)) {
            f٥١٤٨j = null;
            return;
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = jSONObject.get(next);
                try {
                    if ("*".equals(obj)) {
                        concurrentHashMap.put(next, f٥١٥٠l);
                    } else if (obj instanceof JSONArray) {
                        JSONArray jSONArray = (JSONArray) obj;
                        int length = jSONArray.length();
                        ArrayList arrayList = new ArrayList(length);
                        for (int i10 = 0; i10 < length; i10++) {
                            Object obj2 = jSONArray.get(i10);
                            if (obj2 instanceof String) {
                                arrayList.add((String) obj2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            concurrentHashMap.put(next, arrayList);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException e10) {
            ALog.e("anet.NetworkConfigCenter", "parse jsonObject failed", null, e10, new Object[0]);
        }
        f٥١٤٨j = concurrentHashMap;
    }
}
