package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GlobalAppRuntimeInfo {

    /* renamed from: a, reason: collision with root package name */
    private static Context f٤٥٩٨a;

    /* renamed from: e, reason: collision with root package name */
    private static String f٤٦٠٢e;

    /* renamed from: f, reason: collision with root package name */
    private static String f٤٦٠٣f;

    /* renamed from: g, reason: collision with root package name */
    private static String f٤٦٠٤g;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f٤٦٠٨k;

    /* renamed from: l, reason: collision with root package name */
    private static String f٤٦٠٩l;

    /* renamed from: b, reason: collision with root package name */
    private static ENV f٤٥٩٩b = ENV.ONLINE;

    /* renamed from: c, reason: collision with root package name */
    private static String f٤٦٠٠c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f٤٦٠١d = "";

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f٤٦٠٥h = true;

    /* renamed from: i, reason: collision with root package name */
    private static SharedPreferences f٤٦٠٦i = null;

    /* renamed from: j, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f٤٦٠٧j = null;

    public static void addBucketInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.length() <= 32 && str2.length() <= 32) {
            synchronized (GlobalAppRuntimeInfo.class) {
                try {
                    if (f٤٦٠٧j == null) {
                        f٤٦٠٧j = new CopyOnWriteArrayList<>();
                    }
                    f٤٦٠٧j.add(str);
                    f٤٦٠٧j.add(str2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f٤٦٠٧j;
    }

    public static Context getContext() {
        return f٤٥٩٨a;
    }

    public static String getCurrentProcess() {
        return f٤٦٠١d;
    }

    public static ENV getEnv() {
        return f٤٥٩٩b;
    }

    @Deprecated
    public static long getInitTime() {
        return f٤٦٠٨k;
    }

    @Deprecated
    public static int getStartType() {
        anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.f٤٧٨٠a;
        }
        return -1;
    }

    public static String getTtid() {
        return f٤٦٠٢e;
    }

    public static String getUserId() {
        return f٤٦٠٣f;
    }

    public static String getUtdid() {
        Context context;
        if (f٤٦٠٤g == null && (context = f٤٥٩٨a) != null) {
            f٤٦٠٤g = Utils.getDeviceId(context);
        }
        return f٤٦٠٤g;
    }

    public static boolean isAppBackground() {
        if (f٤٥٩٨a == null) {
            return true;
        }
        return f٤٦٠٥h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f٤٦٠٠c) || TextUtils.isEmpty(f٤٦٠١d)) {
            return true;
        }
        return f٤٦٠٠c.equalsIgnoreCase(f٤٦٠١d);
    }

    public static void setBackground(boolean z10) {
        f٤٦٠٥h = z10;
    }

    public static void setContext(Context context) {
        f٤٥٩٨a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f٤٦٠١d)) {
                f٤٦٠١d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f٤٦٠٠c)) {
                f٤٦٠٠c = Utils.getMainProcessName(context);
            }
            if (f٤٦٠٦i == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                f٤٦٠٦i = defaultSharedPreferences;
                f٤٦٠٣f = defaultSharedPreferences.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f٤٦٠١d, "TargetProcess", f٤٦٠٠c);
        }
    }

    public static void setCurrentProcess(String str) {
        f٤٦٠١d = str;
    }

    public static void setEnv(ENV env) {
        f٤٥٩٩b = env;
    }

    @Deprecated
    public static void setInitTime(long j10) {
        f٤٦٠٨k = j10;
    }

    public static void setTargetProcess(String str) {
        f٤٦٠٠c = str;
    }

    public static void setTtid(String str) {
        String str2;
        f٤٦٠٢e = str;
        try {
            if (!TextUtils.isEmpty(str)) {
                int indexOf = str.indexOf("@");
                String str3 = null;
                if (indexOf != -1) {
                    str2 = str.substring(0, indexOf);
                } else {
                    str2 = null;
                }
                String substring = str.substring(indexOf + 1);
                int lastIndexOf = substring.lastIndexOf("_");
                if (lastIndexOf != -1) {
                    String substring2 = substring.substring(0, lastIndexOf);
                    str3 = substring.substring(lastIndexOf + 1);
                    substring = substring2;
                }
                f٤٦٠٩l = str3;
                AmdcRuntimeInfo.setAppInfo(substring, str3, str2);
            }
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f٤٦٠٣f;
        if (str2 == null || !str2.equals(str)) {
            f٤٦٠٣f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f٤٦٠٦i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f٤٦٠٤g;
        if (str2 == null || !str2.equals(str)) {
            f٤٦٠٤g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f٤٦٠٠c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f٤٦٠٠c.equalsIgnoreCase(str);
    }
}
