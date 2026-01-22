package anet.channel;

import android.text.TextUtils;
import anet.channel.strategy.ConnProtocol;
import anet.channel.strategy.StrategyTemplate;
import anet.channel.util.ALog;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AwcnConfig {
    public static final String HTTP3_ENABLE = "HTTP3_ENABLE";
    public static final String NEXT_LAUNCH_FORBID = "NEXT_LAUNCH_FORBID";

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f٤٥٦٣a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f٤٥٦٤b = true;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f٤٥٦٥c = true;

    /* renamed from: d, reason: collision with root package name */
    private static volatile boolean f٤٥٦٦d = true;

    /* renamed from: e, reason: collision with root package name */
    private static volatile boolean f٤٥٦٧e = false;

    /* renamed from: f, reason: collision with root package name */
    private static volatile boolean f٤٥٦٨f = true;

    /* renamed from: g, reason: collision with root package name */
    private static volatile long f٤٥٦٩g = 43200000;

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f٤٥٧٠h = true;

    /* renamed from: i, reason: collision with root package name */
    private static volatile boolean f٤٥٧١i = true;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f٤٥٧٢j = true;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f٤٥٧٣k = false;

    /* renamed from: l, reason: collision with root package name */
    private static volatile boolean f٤٥٧٤l = false;

    /* renamed from: m, reason: collision with root package name */
    private static volatile boolean f٤٥٧٥m = true;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f٤٥٧٦n = false;

    /* renamed from: o, reason: collision with root package name */
    private static volatile int f٤٥٧٧o = 10000;

    /* renamed from: p, reason: collision with root package name */
    private static volatile boolean f٤٥٧٨p = false;

    /* renamed from: q, reason: collision with root package name */
    private static volatile boolean f٤٥٧٩q = true;

    /* renamed from: r, reason: collision with root package name */
    private static volatile int f٤٥٨٠r = -1;

    /* renamed from: s, reason: collision with root package name */
    private static volatile boolean f٤٥٨١s = true;

    /* renamed from: t, reason: collision with root package name */
    private static volatile boolean f٤٥٨٢t = true;

    /* renamed from: u, reason: collision with root package name */
    private static volatile boolean f٤٥٨٣u = false;

    /* renamed from: v, reason: collision with root package name */
    private static volatile boolean f٤٥٨٤v = true;

    /* renamed from: w, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f٤٥٨٥w = null;

    /* renamed from: x, reason: collision with root package name */
    private static volatile boolean f٤٥٨٦x = true;

    /* renamed from: y, reason: collision with root package name */
    private static volatile boolean f٤٥٨٧y = true;

    public static int getAccsReconnectionDelayPeriod() {
        return f٤٥٧٧o;
    }

    public static long getIpv6BlackListTtl() {
        return f٤٥٦٩g;
    }

    public static int getXquicCongControl() {
        return f٤٥٨٠r;
    }

    public static boolean isAccsSessionCreateForbiddenInBg() {
        return f٤٥٦٣a;
    }

    public static boolean isAllowHttpDnsNotify(String str) {
        if (f٤٥٨٥w != null && !TextUtils.isEmpty(str)) {
            return f٤٥٨٥w.contains(str);
        }
        return false;
    }

    public static boolean isAppLifeCycleListenerEnable() {
        return f٤٥٧٢j;
    }

    public static boolean isAsyncLoadStrategyEnable() {
        return f٤٥٧٣k;
    }

    public static boolean isCarrierInfoEnable() {
        return f٤٥٨٧y;
    }

    public static boolean isCookieHeaderRedundantFix() {
        return f٤٥٨٢t;
    }

    public static boolean isHorseRaceEnable() {
        return f٤٥٦٥c;
    }

    public static boolean isHttp3Enable() {
        return f٤٥٧٨p;
    }

    public static boolean isHttp3OrangeEnable() {
        return f٤٥٧٩q;
    }

    public static boolean isHttpsSniEnable() {
        return f٤٥٦٤b;
    }

    public static boolean isIdleSessionCloseEnable() {
        return f٤٥٦٨f;
    }

    public static boolean isIpStackDetectByUdpConnect() {
        return f٤٥٨١s;
    }

    public static boolean isIpv6BlackListEnable() {
        return f٤٥٧١i;
    }

    public static boolean isIpv6Enable() {
        return f٤٥٧٠h;
    }

    public static boolean isNetworkDetectEnable() {
        return f٤٥٧٦n;
    }

    public static boolean isPing6Enable() {
        return f٤٥٧٥m;
    }

    public static boolean isQuicEnable() {
        return f٤٥٦٧e;
    }

    public static boolean isSendConnectInfoByBroadcast() {
        return f٤٥٨٣u;
    }

    public static boolean isSendConnectInfoByService() {
        return f٤٥٨٤v;
    }

    public static boolean isTbNextLaunch() {
        return f٤٥٧٤l;
    }

    public static boolean isTnetHeaderCacheEnable() {
        return f٤٥٦٦d;
    }

    public static boolean isWifiInfoEnable() {
        return f٤٥٨٦x;
    }

    public static void registerPresetSessions(String str) {
        if (!GlobalAppRuntimeInfo.isTargetProcess() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String string = jSONObject.getString("host");
                if (anet.channel.strategy.utils.c.c(string)) {
                    StrategyTemplate.getInstance().registerConnProtocol(string, ConnProtocol.valueOf(jSONObject.getString("protocol"), jSONObject.getString("rtt"), jSONObject.getString("publicKey")));
                    if (jSONObject.getBoolean("isKeepAlive")) {
                        SessionCenter.getInstance().registerSessionInfo(SessionInfo.create(string, true, false, null, null, null));
                    }
                } else {
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void setAccsReconnectionDelayPeriod(int i10) {
        if (i10 < 0) {
            i10 = 0;
        }
        if (i10 > 10000) {
            i10 = 10000;
        }
        f٤٥٧٧o = i10;
    }

    public static void setAccsSessionCreateForbiddenInBg(boolean z10) {
        f٤٥٦٣a = z10;
    }

    public static void setAppLifeCycleListenerEnable(boolean z10) {
        f٤٥٧٢j = z10;
    }

    public static void setAsyncLoadStrategyEnable(boolean z10) {
        f٤٥٧٣k = z10;
    }

    public static void setCarrierInfoEnable(boolean z10) {
        f٤٥٨٧y = z10;
    }

    public static void setCookieHeaderRedundantFix(boolean z10) {
        f٤٥٨٢t = z10;
    }

    public static void setHorseRaceEnable(boolean z10) {
        f٤٥٦٥c = z10;
    }

    public static void setHttp3Enable(boolean z10) {
        f٤٥٧٨p = z10;
        ALog.e("awcn.AwcnConfig", "[setHttp3Enable]", null, "enable", Boolean.valueOf(z10));
    }

    public static void setHttp3OrangeEnable(boolean z10) {
        f٤٥٧٩q = z10;
    }

    public static void setHttpDnsNotifyWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                String string = jSONArray.getString(i10);
                if (!TextUtils.isEmpty(string)) {
                    copyOnWriteArrayList.add(string);
                }
            }
            f٤٥٨٥w = copyOnWriteArrayList;
        } catch (Exception e10) {
            ALog.e("awcn.AwcnConfig", "[setHttpDnsNotifyWhiteList] error", null, e10, new Object[0]);
        }
    }

    public static void setHttpsSniEnable(boolean z10) {
        f٤٥٦٤b = z10;
    }

    public static void setIdleSessionCloseEnable(boolean z10) {
        f٤٥٦٨f = z10;
    }

    public static void setIpStackDetectByUdpConnect(boolean z10) {
        f٤٥٨١s = z10;
    }

    public static void setIpv6BlackListEnable(boolean z10) {
        f٤٥٧١i = z10;
    }

    public static void setIpv6BlackListTtl(long j10) {
        f٤٥٦٩g = j10;
    }

    public static void setIpv6Enable(boolean z10) {
        f٤٥٧٠h = z10;
    }

    public static void setNetworkDetectEnable(boolean z10) {
        f٤٥٧٦n = z10;
    }

    public static void setPing6Enable(boolean z10) {
        f٤٥٧٥m = z10;
    }

    public static void setQuicEnable(boolean z10) {
        f٤٥٦٧e = z10;
    }

    public static void setSendConnectInfoByBroadcast(boolean z10) {
        f٤٥٨٣u = z10;
    }

    public static void setSendConnectInfoByService(boolean z10) {
        f٤٥٨٤v = z10;
    }

    public static void setTbNextLaunch(boolean z10) {
        f٤٥٧٤l = z10;
    }

    public static void setTnetHeaderCacheEnable(boolean z10) {
        f٤٥٦٦d = z10;
    }

    public static void setWifiInfoEnable(boolean z10) {
        f٤٥٨٦x = z10;
    }

    public static void setXquicCongControl(int i10) {
        if (i10 < 0) {
            return;
        }
        f٤٥٨٠r = i10;
    }
}
