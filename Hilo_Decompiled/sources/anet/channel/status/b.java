package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: t, reason: collision with root package name */
    private static Method f٤٩٣٨t;

    /* renamed from: m, reason: collision with root package name */
    private static String[] f٤٩٣١m = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};

    /* renamed from: a, reason: collision with root package name */
    static volatile Context f٤٩١٩a = null;

    /* renamed from: b, reason: collision with root package name */
    static volatile boolean f٤٩٢٠b = false;

    /* renamed from: c, reason: collision with root package name */
    static volatile NetworkStatusHelper.NetworkStatus f٤٩٢١c = NetworkStatusHelper.NetworkStatus.NONE;

    /* renamed from: d, reason: collision with root package name */
    static volatile String f٤٩٢٢d = "unknown";

    /* renamed from: e, reason: collision with root package name */
    static volatile String f٤٩٢٣e = "";

    /* renamed from: f, reason: collision with root package name */
    static volatile String f٤٩٢٤f = "";

    /* renamed from: g, reason: collision with root package name */
    static volatile String f٤٩٢٥g = "";

    /* renamed from: h, reason: collision with root package name */
    static volatile String f٤٩٢٦h = "unknown";

    /* renamed from: i, reason: collision with root package name */
    static volatile String f٤٩٢٧i = "";

    /* renamed from: j, reason: collision with root package name */
    static volatile Pair<String, Integer> f٤٩٢٨j = null;

    /* renamed from: k, reason: collision with root package name */
    static volatile boolean f٤٩٢٩k = false;

    /* renamed from: l, reason: collision with root package name */
    static volatile List<InetAddress> f٤٩٣٠l = Collections.EMPTY_LIST;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f٤٩٣٢n = false;

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f٤٩٣٣o = false;

    /* renamed from: p, reason: collision with root package name */
    private static ConnectivityManager f٤٩٣٤p = null;

    /* renamed from: q, reason: collision with root package name */
    private static TelephonyManager f٤٩٣٥q = null;

    /* renamed from: r, reason: collision with root package name */
    private static WifiManager f٤٩٣٦r = null;

    /* renamed from: s, reason: collision with root package name */
    private static SubscriptionManager f٤٩٣٧s = null;

    /* renamed from: u, reason: collision with root package name */
    private static BroadcastReceiver f٤٩٣٩u = new BroadcastReceiver() { // from class: anet.channel.status.NetworkStatusMonitor$2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this));
        }
    };

    b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        if (f٤٩٣٢n || f٤٩١٩a == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            f٤٩١٩a.registerReceiver(f٤٩٣٩u, intentFilter);
        } catch (Exception unused) {
            ALog.e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
        }
        d();
        f٤٩٣٢n = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        if (f٤٩١٩a != null) {
            f٤٩١٩a.unregisterReceiver(f٤٩٣٩u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 24 && !f٤٩٣٣o) {
            NetworkInfo e10 = e();
            if (e10 != null && e10.isConnected()) {
                z10 = true;
            } else {
                z10 = false;
            }
            f٤٩٢٠b = z10;
            f٤٩٣٤p.registerDefaultNetworkCallback(new c());
            f٤٩٣٣o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        NetworkInfo networkInfo;
        boolean z10;
        WifiInfo i10;
        ALog.d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = f٤٩٢١c;
        String str = f٤٩٢٣e;
        String str2 = f٤٩٢٤f;
        try {
            try {
                networkInfo = e();
                z10 = false;
            } catch (Exception e10) {
                ALog.e("awcn.NetworkStatusMonitor", "getNetworkInfo exception", null, e10, new Object[0]);
                a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfo = null;
                z10 = true;
            }
            if (!z10) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(networkInfo.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfo.isAvailable()), "info.getType", Integer.valueOf(networkInfo.getType()));
                    if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        String str3 = "";
                        if (!TextUtils.isEmpty(subtypeName)) {
                            str3 = subtypeName.replace(" ", "");
                        }
                        a(a(networkInfo.getSubtype(), str3), str3);
                        f٤٩٢٣e = a(networkInfo.getExtraInfo());
                        h();
                    } else if (networkInfo.getType() == 1) {
                        a(NetworkStatusHelper.NetworkStatus.WIFI, "wifi");
                        if (AwcnConfig.isWifiInfoEnable() && (i10 = i()) != null && b("android.permission.ACCESS_FINE_LOCATION")) {
                            f٤٩٢٥g = i10.getBSSID();
                            f٤٩٢٤f = i10.getSSID();
                        }
                        f٤٩٢٦h = "wifi";
                        f٤٩٢٧i = "wifi";
                        f٤٩٢٨j = j();
                    } else {
                        a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    f٤٩٢٩k = networkInfo.isRoaming();
                    anet.channel.util.c.e();
                }
                a(NetworkStatusHelper.NetworkStatus.NO, "no network");
                ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "no network");
            }
            if (f٤٩٢١c != networkStatus || !f٤٩٢٣e.equalsIgnoreCase(str) || !f٤٩٢٤f.equalsIgnoreCase(str2)) {
                if (ALog.isPrintLog(2)) {
                    NetworkStatusHelper.printNetworkDetail();
                }
                NetworkStatusHelper.notifyStatusChanged(f٤٩٢١c);
            }
        } catch (Exception e11) {
            ALog.e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e11, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NetworkInfo e() {
        if (f٤٩٣٤p == null) {
            f٤٩٣٤p = (ConnectivityManager) f٤٩١٩a.getSystemService("connectivity");
        }
        return f٤٩٣٤p.getActiveNetworkInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            for (String str : f٤٩٣١m) {
                String str2 = (String) method.invoke(null, str);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g() {
        int restrictBackgroundStatus;
        if (f٤٩٣٤p != null && Build.VERSION.SDK_INT >= 24) {
            restrictBackgroundStatus = f٤٩٣٤p.getRestrictBackgroundStatus();
            return restrictBackgroundStatus;
        }
        return -1;
    }

    private static void h() {
        try {
            if (!AwcnConfig.isCarrierInfoEnable() || !b("android.permission.READ_PHONE_STATE")) {
                return;
            }
            if (f٤٩٣٥q == null) {
                f٤٩٣٥q = (TelephonyManager) f٤٩١٩a.getSystemService("phone");
            }
            f٤٩٢٧i = f٤٩٣٥q.getSimOperator();
            if (f٤٩٣٧s == null) {
                SubscriptionManager from = SubscriptionManager.from(f٤٩١٩a);
                f٤٩٣٧s = from;
                f٤٩٣٨t = from.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", null);
            }
            Method method = f٤٩٣٨t;
            if (method != null) {
                f٤٩٢٦h = ((SubscriptionInfo) method.invoke(f٤٩٣٧s, null)).getCarrierName().toString();
            }
        } catch (Exception unused) {
        }
    }

    private static WifiInfo i() {
        try {
            if (f٤٩٣٦r == null) {
                f٤٩٣٦r = (WifiManager) f٤٩١٩a.getSystemService("wifi");
            }
            return f٤٩٣٦r.getConnectionInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static Pair<String, Integer> j() {
        try {
            String property = System.getProperty("http.proxyHost");
            if (!TextUtils.isEmpty(property)) {
                return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        checkSelfPermission = f٤٩١٩a.checkSelfPermission(str);
        return checkSelfPermission == 0;
    }

    private static void a(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        f٤٩٢١c = networkStatus;
        f٤٩٢٢d = str;
        f٤٩٢٣e = "";
        f٤٩٢٤f = "";
        f٤٩٢٥g = "";
        f٤٩٢٨j = null;
        f٤٩٢٦h = "";
        f٤٩٢٧i = "";
    }

    private static NetworkStatusHelper.NetworkStatus a(int i10, String str) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatusHelper.NetworkStatus.G2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkStatusHelper.NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatusHelper.NetworkStatus.G4;
            case 20:
                return NetworkStatusHelper.NetworkStatus.G5;
            default:
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA") && !str.equalsIgnoreCase("CDMA2000")) {
                    return NetworkStatusHelper.NetworkStatus.NONE;
                }
                return NetworkStatusHelper.NetworkStatus.G3;
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }
}
