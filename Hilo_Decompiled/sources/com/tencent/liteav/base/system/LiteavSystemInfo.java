package com.tencent.liteav.base.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.taobao.accs.utl.UtilityImpl;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class LiteavSystemInfo {
    private static final int APP_SYSTEM_METHOD_DEFAULT_GET_INTERVAL_MS = 1000;
    private static final String EXT_KEY_APP_BACKGROUND = "isAppBackground";
    private static final String EXT_KEY_APP_NAME = "appName";
    private static final String EXT_KEY_APP_PACKAGE_NAME = "appPackageName";
    private static final String EXT_KEY_APP_VERSION = "appVersion";
    private static final String EXT_KEY_BUILD_BOARD = "buildBoard";
    private static final String EXT_KEY_BUILD_BRAND = "buildBrand";
    private static final String EXT_KEY_BUILD_HARDWARE = "buildHardware";
    private static final String EXT_KEY_BUILD_MANUFACTURER = "buildManufacturer";
    private static final String EXT_KEY_BUILD_MODEL = "buildModel";
    private static final String EXT_KEY_BUILD_VERSION = "buildVersion";
    private static final String EXT_KEY_BUILD_VERSION_INT = "buildVersionInt";
    private static final int NETWORK_TYPE_2G = 4;
    private static final int NETWORK_TYPE_3G = 3;
    private static final int NETWORK_TYPE_4G = 2;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final int NETWORK_TYPE_WIRED = 5;
    private static final String TAG = "LiteavBaseSystemInfo";
    private static final com.tencent.liteav.base.util.p<String> sModel = new com.tencent.liteav.base.util.p<>(h.a());
    private static final com.tencent.liteav.base.util.p<String> sBrand = new com.tencent.liteav.base.util.p<>(i.a());
    private static final com.tencent.liteav.base.util.p<String> sManufacturer = new com.tencent.liteav.base.util.p<>(j.a());
    private static final com.tencent.liteav.base.util.p<String> sHardware = new com.tencent.liteav.base.util.p<>(k.a());
    private static final com.tencent.liteav.base.util.p<String> sSystemOSVersion = new com.tencent.liteav.base.util.p<>(l.a());
    private static final com.tencent.liteav.base.util.p<Integer> sSystemOSVersionInt = new com.tencent.liteav.base.util.p<>(m.a());
    private static final com.tencent.liteav.base.util.p<String> sBoard = new com.tencent.liteav.base.util.p<>(n.a());
    private static final com.tencent.liteav.base.util.p<String> sAppPackageName = new com.tencent.liteav.base.util.p<>(o.a());
    private static final com.tencent.liteav.base.util.p<String> sAppName = new com.tencent.liteav.base.util.p<>(d.a());
    private static final com.tencent.liteav.base.util.p<String> sAppVersion = new com.tencent.liteav.base.util.p<>(e.a());
    private static final com.tencent.liteav.base.util.p<String> sUUID = new com.tencent.liteav.base.util.p<>(f.a());
    private static final com.tencent.liteav.base.util.p<String[]> sCpuABIs = new com.tencent.liteav.base.util.p<>(g.a());
    private static int sLastNetworkType = 0;
    private static final com.tencent.liteav.base.b.a sNetworkTypeThrottler = new com.tencent.liteav.base.b.a(1000);
    private static int sLastGateway = 0;
    private static final com.tencent.liteav.base.b.a sGatewayThrottler = new com.tencent.liteav.base.b.a(1000);
    private static boolean sLastMicPermission = false;
    private static final com.tencent.liteav.base.b.a sMicPermissionThrottler = new com.tencent.liteav.base.b.a(1000);

    public static synchronized int getAppBackgroundState() {
        boolean b;
        synchronized (LiteavSystemInfo.class) {
            b = com.tencent.liteav.base.util.i.a().b();
        }
        if (b) {
            return 1;
        }
        return 0;
    }

    public static String getAppName() {
        return sAppName.a();
    }

    public static String getAppPackageName() {
        return sAppPackageName.a();
    }

    public static synchronized int getAppThreadSize() {
        int activeCount;
        synchronized (LiteavSystemInfo.class) {
            try {
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                while (threadGroup.getParent() != null) {
                    threadGroup = threadGroup.getParent();
                }
                activeCount = threadGroup.activeCount();
            } catch (Throwable th) {
                throw th;
            }
        }
        return activeCount;
    }

    public static String getAppVersion() {
        return sAppVersion.a();
    }

    public static synchronized boolean getAudioRecordPermission() {
        boolean z;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sMicPermissionThrottler.a()) {
                    sLastMicPermission = getAudioRecordPermissionFromSystem();
                }
                z = sLastMicPermission;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    private static boolean getAudioRecordPermissionFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || applicationContext.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) != 0) {
            return false;
        }
        return true;
    }

    public static String getBoard() {
        return sBoard.a();
    }

    public static String getBrand() {
        return sBrand.a();
    }

    public static String getDeviceUuid() {
        return sUUID.a();
    }

    public static synchronized int getGateway() {
        int i;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sGatewayThrottler.a()) {
                    sLastGateway = getGatewayFromSystem();
                }
                i = sLastGateway;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    private static int getGatewayFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        try {
            return ((WifiManager) applicationContext.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getDhcpInfo().gateway;
        } catch (Throwable th) {
            Log.e(TAG, "getGateway error " + th.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static String getHardware() {
        return sHardware.a();
    }

    public static String getManufacturer() {
        return sManufacturer.a();
    }

    public static String getModel() {
        return sModel.a();
    }

    public static synchronized int getNetworkType() {
        int i;
        synchronized (LiteavSystemInfo.class) {
            try {
                if (sNetworkTypeThrottler.a()) {
                    sLastNetworkType = getNetworkTypeFromSystem();
                }
                i = sLastNetworkType;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x004b. Please report as an issue. */
    private static int getNetworkTypeFromSystem() {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null || (connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity")) == null) {
            return 0;
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        if (networkInfo.getType() == 9) {
            return 5;
        }
        if (networkInfo.getType() == 1) {
            return 1;
        }
        if (networkInfo.getType() != 0) {
            return 0;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            if (telephonyManager == null) {
                return 0;
            }
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 4;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                default:
                    if (getSystemOSVersionInt() >= 29 && networkType == 20) {
                        return 6;
                    }
                    break;
                case 13:
                    return 2;
            }
        } catch (Exception unused2) {
            return 2;
        }
    }

    public static synchronized String getProperty(String str) {
        String str2;
        synchronized (LiteavSystemInfo.class) {
            try {
                str2 = System.getProperty(str);
                try {
                    Log.i(TAG, "Get " + str + " property is " + str2, new Object[0]);
                } catch (Throwable th) {
                    th = th;
                    Log.e(TAG, "Get property failed. ".concat(String.valueOf(th)), new Object[0]);
                    return str2;
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
            }
        }
        return str2;
    }

    public static int[] getScreenSizeInPixels() {
        int[] iArr = {0, 0};
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e(TAG, "Context is null.", new Object[0]);
            return iArr;
        }
        try {
            WindowManager windowManager = (WindowManager) applicationContext.getSystemService("window");
            if (windowManager == null) {
                Log.e(TAG, "WindowManager is null.", new Object[0]);
                return iArr;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            iArr[1] = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
            return iArr;
        } catch (Throwable th) {
            Log.e(TAG, "Get display from window service failed. ".concat(String.valueOf(th)), new Object[0]);
            return iArr;
        }
    }

    public static String[] getSupportABIs() {
        return sCpuABIs.a();
    }

    public static String getSystemOSVersion() {
        return sSystemOSVersion.a();
    }

    public static int getSystemOSVersionInt() {
        return sSystemOSVersionInt.a().intValue();
    }

    public static synchronized String getSystemProperty(String str) {
        String str2;
        synchronized (LiteavSystemInfo.class) {
            str2 = null;
            try {
                Object invoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
                if (invoke != null) {
                    String str3 = (String) invoke;
                    try {
                        Log.i(TAG, "Get " + str + " property is " + str3, new Object[0]);
                        str2 = str3;
                    } catch (Throwable th) {
                        th = th;
                        str2 = str3;
                        Log.e(TAG, "Get system property failed. ".concat(String.valueOf(th)), new Object[0]);
                        return str2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return str2;
    }

    public static synchronized void listenAppBackgroundState() {
        synchronized (LiteavSystemInfo.class) {
            com.tencent.liteav.base.util.i.a().a(c.a());
        }
    }

    private static native void nativeOnAppBackgroundStateChanged(int i);

    public static void onAppBackgroundStateChanged(boolean z) {
        nativeOnAppBackgroundStateChanged(z ? 1 : 0);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x009e. Please report as an issue. */
    public static boolean setExtID(String str, String str2) {
        boolean z;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1978299099:
                    if (str.equals(EXT_KEY_APP_BACKGROUND)) {
                        c = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (str.equals(EXT_KEY_BUILD_VERSION)) {
                        c = 1;
                        break;
                    }
                    break;
                case -794136500:
                    if (str.equals(EXT_KEY_APP_NAME)) {
                        c = 2;
                        break;
                    }
                    break;
                case -589756065:
                    if (str.equals(EXT_KEY_BUILD_MANUFACTURER)) {
                        c = 3;
                        break;
                    }
                    break;
                case -497349352:
                    if (str.equals(EXT_KEY_BUILD_BOARD)) {
                        c = 4;
                        break;
                    }
                    break;
                case -497260103:
                    if (str.equals(EXT_KEY_BUILD_BRAND)) {
                        c = 5;
                        break;
                    }
                    break;
                case -487188133:
                    if (str.equals(EXT_KEY_BUILD_MODEL)) {
                        c = 6;
                        break;
                    }
                    break;
                case -441921776:
                    if (str.equals(EXT_KEY_APP_PACKAGE_NAME)) {
                        c = 7;
                        break;
                    }
                    break;
                case -391134602:
                    if (str.equals(EXT_KEY_BUILD_HARDWARE)) {
                        c = '\b';
                        break;
                    }
                    break;
                case 725329157:
                    if (str.equals(EXT_KEY_BUILD_VERSION_INT)) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1484112759:
                    if (str.equals("appVersion")) {
                        c = '\n';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    try {
                        if (Integer.parseInt(str2) == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.tencent.liteav.base.util.i.a(z);
                        return true;
                    } catch (Exception e) {
                        Log.e(TAG, "set app background state failed. ".concat(String.valueOf(e)), new Object[0]);
                        break;
                    }
                case 1:
                    sSystemOSVersion.a(str2);
                    return true;
                case 2:
                    sAppName.a(str2);
                    return true;
                case 3:
                    sManufacturer.a(str2);
                    return true;
                case 4:
                    sBoard.a(str2);
                    return true;
                case 5:
                    sBrand.a(str2);
                    return true;
                case 6:
                    sModel.a(str2);
                    return true;
                case 7:
                    sAppPackageName.a(str2);
                    return true;
                case '\b':
                    sHardware.a(str2);
                    return true;
                case '\t':
                    try {
                        sSystemOSVersionInt.a(Integer.valueOf(Integer.parseInt(str2)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return true;
                case '\n':
                    sAppVersion.a(str2);
                    return true;
                default:
                    return false;
            }
        }
        return false;
    }
}
