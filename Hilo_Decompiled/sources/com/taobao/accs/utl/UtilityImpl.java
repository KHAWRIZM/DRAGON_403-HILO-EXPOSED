package com.taobao.accs.utl;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.util.HMacUtil;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class UtilityImpl {
    public static final String NET_TYPE_MOBILE = "mobile";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    public static final int TNET_FILE_NUM = 5;
    public static final int TNET_FILE_SIZE = 5242880;
    private static final byte[] a = new byte[0];

    public static byte[] a() {
        return null;
    }

    public static int b(Context context) {
        int i = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getInt(Constants.KEY_PROXY_PORT, -1);
        if (i > 0) {
            return i;
        }
        if (a(context) == null) {
            return -1;
        }
        try {
            return e();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c(Context context) {
        String str;
        int i;
        synchronized (a) {
            try {
                PackageInfo packageInfo = GlobalClientInfo.getInstance(context).getPackageInfo();
                int i2 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.KEY_APP_VERSION_CODE, -1);
                String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.KEY_APP_VERSION_NAME, "");
                if (packageInfo != null) {
                    i = packageInfo.versionCode;
                    str = packageInfo.versionName;
                } else {
                    str = null;
                    i = 0;
                }
                if (i2 == i && string.equals(str)) {
                    return false;
                }
                n(context);
                ALog.i("UtilityImpl", "appVersionChanged", "oldV", Integer.valueOf(i2), "nowV", Integer.valueOf(i), "oldN", string, "nowN", str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void clearSharePreferences(Context context) {
        try {
            synchronized (a) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
                    String string = sharedPreferences.getString(Constants.SP_KEY_APPKEY, null);
                    String string2 = sharedPreferences.getString("app_sercet", null);
                    String string3 = sharedPreferences.getString(Constants.KEY_PROXY_HOST, null);
                    int i = sharedPreferences.getInt(Constants.KEY_PROXY_PORT, -1);
                    int i2 = sharedPreferences.getInt(Constants.SP_KEY_VERSION, -1);
                    SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                    edit.clear();
                    if (!TextUtils.isEmpty(string)) {
                        edit.putString(Constants.SP_KEY_APPKEY, string);
                    }
                    if (!TextUtils.isEmpty(string2)) {
                        edit.putString("app_sercet", string2);
                    }
                    if (!TextUtils.isEmpty(string3)) {
                        edit.putString(Constants.KEY_PROXY_HOST, string3);
                    }
                    if (i > 0) {
                        edit.putInt(Constants.KEY_PROXY_PORT, i);
                    }
                    if (i2 > 0) {
                        edit.putInt(Constants.SP_KEY_VERSION, i2);
                    }
                    edit.apply();
                } finally {
                }
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "clearSharePreferences", th, new Object[0]);
        }
    }

    public static boolean d(Context context) {
        String agooCustomServiceName = AdapterGlobalClientInfo.getAgooCustomServiceName(context);
        if (TextUtils.isEmpty(agooCustomServiceName)) {
            return false;
        }
        ComponentName componentName = new ComponentName(context, agooCustomServiceName);
        PackageManager packageManager = context.getPackageManager();
        if (!componentName.getPackageName().equals("!")) {
            return packageManager.getServiceInfo(componentName, 128).enabled;
        }
        ALog.e("UtilityImpl", "getAgooServiceEnabled,exception,comptName.getPackageName()=" + componentName.getPackageName(), new Object[0]);
        return false;
    }

    public static void disableService(Context context) {
        try {
            b(context, AdapterUtilityImpl.channelService);
        } catch (Throwable unused) {
        }
    }

    public static String e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return NET_TYPE_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 1) {
                return NET_TYPE_WIFI;
            }
            if (activeNetworkInfo.getType() != 0) {
                return NET_TYPE_UNKNOWN;
            }
            return NET_TYPE_MOBILE;
        } catch (Throwable th) {
            th.printStackTrace();
            return NET_TYPE_UNKNOWN;
        }
    }

    public static void enableService(Context context) {
        a(context, AdapterUtilityImpl.channelService);
    }

    public static String f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return NET_TYPE_UNKNOWN;
            }
            if (activeNetworkInfo.getType() == 1) {
                return NET_TYPE_WIFI;
            }
            if (activeNetworkInfo.getType() != 0) {
                return NET_TYPE_UNKNOWN;
            }
            return NET_TYPE_MOBILE;
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getNetworkTypeExt", th, new Object[0]);
            return null;
        }
    }

    public static boolean g(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = GlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String getDeviceId(Context context) {
        return "GRATECH_GHOST_403_SULIMAN";
    }

    public static String getUtdid(String str, Context context) {
        String string;
        try {
            synchronized (a) {
                string = context.getSharedPreferences(str, 0).getString("utdid", getDeviceId(context));
            }
            return string;
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getUtdid", th, new Object[0]);
            return "";
        }
    }

    public static List<String> getUtdids(String str, Context context) {
        ArrayList arrayList;
        try {
            synchronized (a) {
                try {
                    String string = context.getSharedPreferences(str, 0).getString(Constants.SP_KEY_UTDID_LIST, null);
                    arrayList = new ArrayList();
                    if (string != null) {
                        JSONArray jSONArray = new JSONArray(string);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.getString(i));
                        }
                    }
                    arrayList.add(getDeviceId(context));
                } catch (Throwable th) {
                    throw th;
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            ALog.e("UtilityImpl", "getUtdidList", th2, new Object[0]);
            return null;
        }
    }

    public static long h(Context context) {
        long j;
        long j2 = 0;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0);
            long j3 = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_START, 0L);
            long j4 = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_END, 0L);
            if (j3 > 0) {
                j = j4 - j3;
            } else {
                j = 0;
            }
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(Constants.SP_KEY_SERVICE_START, 0L);
                edit.putLong(Constants.SP_KEY_SERVICE_END, 0L);
                edit.apply();
                return j;
            } catch (Throwable th) {
                th = th;
                j2 = j;
                ALog.e("UtilityImpl", "getServiceAliveTime:", th, new Object[0]);
                return j2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void hitUtdid(String str, Context context, String str2) {
        try {
            synchronized (a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str2);
                edit.putString(Constants.SP_KEY_UTDID_LIST, jSONArray.toString());
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "hitUtdid", th, new Object[0]);
        }
    }

    public static String i(Context context) {
        try {
            return GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String j(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Exception e) {
            ALog.e("UtilityImpl", "reStoreCookie fail", e, new Object[0]);
            return null;
        }
    }

    public static String k(Context context) {
        return AdapterUtilityImpl.isNotificationEnabled(context);
    }

    public static boolean l(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(Constants.SP_KEY_ENABLE_CHANNEL_PROCESS, true);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static List<String> m(Context context) {
        try {
            String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(Constants.SP_KEY_CHANNEL_INIT, null);
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                return arrayList;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void n(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.KEY_APP_VERSION_CODE, GlobalClientInfo.getInstance(context).getPackageInfo().versionCode);
            edit.putString(Constants.KEY_APP_VERSION_NAME, GlobalClientInfo.getInstance(context).getPackageInfo().versionName);
            edit.apply();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "saveAppVersion", th, new Object[0]);
        }
    }

    public static void saveChannelInitClass(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(Constants.SP_KEY_CHANNEL_INIT, null);
            ArrayList arrayList = new ArrayList();
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            if (!arrayList.contains(str)) {
                arrayList.add(str);
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    jSONArray2.put(arrayList.get(i2));
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(Constants.SP_KEY_CHANNEL_INIT, jSONArray2.toString());
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }

    public static void saveUtdid(String str, Context context) {
        JSONArray jSONArray;
        try {
            synchronized (a) {
                try {
                    String deviceId = getDeviceId(context);
                    SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    String string = sharedPreferences.getString(Constants.SP_KEY_UTDID_LIST, null);
                    if (string != null) {
                        if (!string.contains(deviceId)) {
                        }
                        edit.putString("utdid", deviceId);
                        edit.apply();
                    }
                    if (string == null) {
                        jSONArray = new JSONArray();
                    } else {
                        jSONArray = new JSONArray(string);
                    }
                    jSONArray.put(deviceId);
                    edit.putString(Constants.SP_KEY_UTDID_LIST, jSONArray.toString());
                    edit.putString("utdid", deviceId);
                    edit.apply();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            ALog.e("UtilityImpl", "saveUtdid", th2, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean utdidChanged(String str, Context context) {
        String str2;
        boolean z;
        try {
        } catch (Throwable th) {
            th = th;
            str2 = null;
        }
        try {
            synchronized (a) {
                try {
                    String deviceId = getDeviceId(context);
                    z = !context.getSharedPreferences(str, 0).getString("utdid", deviceId).equals(deviceId);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.e("UtilityImpl", "saveUtdid", th, new Object[0]);
                        z = str2;
                        return z;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            str2 = str;
        }
    }

    public static String a(Context context) {
        String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String d = d();
        if (TextUtils.isEmpty(d)) {
            return null;
        }
        return d;
    }

    public static boolean b(Context context, String str) {
        ComponentName componentName = new ComponentName(context, str);
        PackageManager packageManager = context.getPackageManager();
        try {
            ALog.d("UtilityImpl", "disableComponent,comptName=" + componentName.toString(), new Object[0]);
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String g() {
        Class<?>[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            ALog.d("UtilityImpl", "getEmuiVersion", "result", str);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e) {
            ALog.e("UtilityImpl", "getEmuiVersion", e, new Object[0]);
            return "";
        }
    }

    public static void a(Context context, String str) {
        ComponentName componentName = new ComponentName(context, str);
        ALog.d("UtilityImpl", "enableComponent", "comptName", componentName);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
            ALog.w("UtilityImpl", "enableComponent", th, new Object[0]);
        }
    }

    public static String d() {
        return System.getProperty("http.proxyHost");
    }

    public static int e() {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static String b() {
        return "null";
    }

    public static String d(Context context, String str) {
        try {
            File externalFilesDir = context.getExternalFilesDir("emastnetlogs");
            if (externalFilesDir != null) {
                if (externalFilesDir.exists()) {
                    if (!externalFilesDir.canWrite()) {
                    }
                    ALog.d("UtilityImpl", "getTnetLogFilePath :" + externalFilesDir, new Object[0]);
                    return externalFilesDir + "/" + str.toLowerCase();
                }
            }
            externalFilesDir = context.getDir("emaslogs", 0);
            ALog.d("UtilityImpl", "getTnetLogFilePath :" + externalFilesDir, new Object[0]);
            return externalFilesDir + "/" + str.toLowerCase();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getTnetLogFilePath", th, new Object[0]);
            return null;
        }
    }

    public static void e(Context context, String str) {
        try {
            synchronized (a) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
                    String string = sharedPreferences.getString(Constants.SP_KEY_APPKEY, "");
                    if (!TextUtils.isEmpty(str) && !string.equals(str) && !string.contains(str)) {
                        if (!TextUtils.isEmpty(string)) {
                            str = string + "|" + str;
                        }
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(Constants.SP_KEY_APPKEY, str);
                        edit.apply();
                    }
                } finally {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String f() {
        String str = d() + ":" + e();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("UtilityImpl", "getProxy:" + str, new Object[0]);
        }
        return str;
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static String a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j));
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "formatDay", th, new Object[0]);
            return "";
        }
    }

    public static boolean b(Context context, boolean z) {
        if (l(context)) {
            return false;
        }
        ALog.d("UtilityImpl", "channel process is disabled, kill it", new Object[0]);
        if (!z) {
            return true;
        }
        Process.killProcess(Process.myPid());
        return true;
    }

    public static boolean c(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            ALog.e("UtilityImpl", "package not exist", "pkg", str);
            return false;
        }
    }

    public static String a(String str, String str2, String str3) {
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            ALog.e("UtilityImpl", "getAppsign appkey null", new Object[0]);
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                str4 = HMacUtil.hmacSha1Hex(str2.getBytes(), (str + str3).getBytes());
            } else {
                ALog.e("UtilityImpl", "getAppsign secret null", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getAppsign", th, new Object[0]);
        }
        return str4;
    }

    public static long c() {
        return AdapterUtilityImpl.getUsableSpace();
    }

    public static int a(Context context, String str, String str2, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        TextUtils.isEmpty(str2);
        return -1;
    }

    public static byte[] a(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            return null;
        }
        ALog.i("UtilityImpl", "get sslticket input null", new Object[0]);
        return null;
    }

    public static void a(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            edit.putLong(str, j);
            edit.apply();
            ALog.d("UtilityImpl", "setServiceTime:" + j, new Object[0]);
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "setServiceTime:", th, new Object[0]);
        }
    }

    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a(Throwable th) {
        return AdapterUtilityImpl.getStackMsg(th);
    }

    public static String a(int i) {
        try {
            return String.valueOf(i);
        } catch (Exception e) {
            ALog.e("UtilityImpl", "int2String", e, new Object[0]);
            return null;
        }
    }

    public static final Map<String, String> a(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String a2 = a(entry.getValue());
                    if (!TextUtils.isEmpty(a2)) {
                        if (!key.startsWith(":")) {
                            key = key.toLowerCase(Locale.US);
                        }
                        hashMap.put(key, a2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static final String a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i));
            if (i < size - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    public static void a(Context context, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putBoolean(Constants.SP_KEY_ENABLE_CHANNEL_PROCESS, z);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, List<String> list) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            String string = sharedPreferences.getString(Constants.SP_KEY_CHANNEL_INIT, null);
            ArrayList arrayList = new ArrayList();
            if (string != null) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            if (arrayList.removeAll(list)) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    jSONArray2.put(arrayList.get(i2));
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(Constants.SP_KEY_CHANNEL_INIT, jSONArray2.toString());
                edit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
