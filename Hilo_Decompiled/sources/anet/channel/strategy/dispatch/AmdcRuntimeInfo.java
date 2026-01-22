package anet.channel.strategy.dispatch;

import android.content.Context;
import anet.channel.util.ALog;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AmdcRuntimeInfo {
    private static final String TAG = "awcn.AmdcRuntimeInfo";
    private static volatile int amdcLimitLevel;
    private static volatile long amdcLimitTime;
    public static volatile String appChannel;
    public static volatile String appName;
    public static volatile String appVersion;
    private static volatile Context context;
    private static volatile boolean forceHttps;
    private static IAmdcSign iSign;
    public static volatile double latitude;
    public static volatile double longitude;
    private static Map<String, String> params;

    public static int getAmdcLimitLevel() {
        if (amdcLimitLevel > 0 && System.currentTimeMillis() - amdcLimitTime > 0) {
            amdcLimitTime = 0L;
            amdcLimitLevel = 0;
        }
        return amdcLimitLevel;
    }

    public static Context getContext() {
        return context;
    }

    public static synchronized Map<String, String> getParams() {
        synchronized (AmdcRuntimeInfo.class) {
            if (params == null) {
                return Collections.EMPTY_MAP;
            }
            return new HashMap(params);
        }
    }

    public static IAmdcSign getSign() {
        return iSign;
    }

    public static boolean isForceHttps() {
        return forceHttps;
    }

    public static void setAppInfo(String str, String str2, String str3) {
        appName = str;
        appVersion = str2;
        appChannel = str3;
    }

    public static void setContext(Context context2) {
        context = context2;
    }

    public static void setForceHttps(boolean z10) {
        forceHttps = z10;
    }

    public static synchronized void setParam(String str, String str2) {
        synchronized (AmdcRuntimeInfo.class) {
            try {
                if (params == null) {
                    params = new HashMap();
                }
                params.put(str, str2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setSign(IAmdcSign iAmdcSign) {
        iSign = iAmdcSign;
    }

    public static void updateAmdcLimit(int i10, int i11) {
        ALog.i(TAG, "set amdc limit", null, FirebaseAnalytics.Param.LEVEL, Integer.valueOf(i10), "time", Integer.valueOf(i11));
        if (i10 >= 0 && i10 <= 3) {
            amdcLimitLevel = i10;
            amdcLimitTime = System.currentTimeMillis() + (i11 * 1000);
        }
    }

    public static void updateLocation(double d10, double d11) {
        latitude = d10;
        longitude = d11;
    }
}
