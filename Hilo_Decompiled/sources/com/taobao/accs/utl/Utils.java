package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class Utils {
    public static final String SP_AGOO_BIND_FILE_NAME = "EMAS_AGOO_BIND";
    private static final String TAG = "Utils";
    private static int debugMode = 0;
    private static final byte[] mLock = new byte[0];
    private static int targetSdkVersion = -1;

    public static void clearAgooBindCache(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("EMAS_AGOO_BIND", 0).edit();
            edit.clear();
            edit.apply();
        } catch (Exception e) {
            ALog.e(TAG, "clearAgooBindCache", e, new Object[0]);
        }
    }

    public static void clearAllSharePreferences(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e(TAG, "clearAllSharePreferences", th, new Object[0]);
        }
    }

    public static Bundle getMetaInfo(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.metaData;
        } catch (Throwable th) {
            ALog.e(TAG, "getMetaInfo", th, new Object[0]);
            return null;
        }
    }

    public static int getMode(Context context) {
        return debugMode;
    }

    public static String getSpValue(Context context, String str, String str2) {
        String str3 = null;
        try {
            synchronized (mLock) {
                str3 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getString(str, null);
            }
            ALog.i(TAG, "getSpValue", "value", str3);
            if (TextUtils.isEmpty(str3)) {
                ALog.e(TAG, "getSpValue use default!", new Object[0]);
                return str2;
            }
        } catch (Throwable th) {
            ALog.e(TAG, "getSpValue fail", th, new Object[0]);
        }
        return str3;
    }

    public static boolean isIPV6Address(String str) {
        int i;
        boolean z;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        if (charArray.length < 2) {
            return false;
        }
        if (charArray[0] == ':') {
            if (charArray[1] != ':') {
                return false;
            }
            i = 1;
            z = false;
            i2 = 1;
        } else {
            i = 0;
            z = false;
            i2 = 0;
        }
        int i3 = 0;
        boolean z2 = true;
        while (i < charArray.length) {
            char c = charArray[i];
            int digit = Character.digit(c, 16);
            if (digit != -1) {
                i3 = (i3 << 4) + digit;
                if (i3 > 65535) {
                    return false;
                }
                z2 = false;
            } else {
                if (c != ':' || (i2 = i2 + 1) > 7) {
                    return false;
                }
                if (z2) {
                    if (z) {
                        return false;
                    }
                    z = true;
                } else {
                    i3 = 0;
                    z2 = true;
                }
            }
            i++;
        }
        if (!z && i2 < 7) {
            return false;
        }
        return true;
    }

    public static boolean isTarget26(Context context) {
        if (context == null) {
            return false;
        }
        if (targetSdkVersion == -1) {
            targetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        }
        if (targetSdkVersion < 26 || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return true;
    }

    public static void killService(Context context) {
        try {
            Class<?> loadClass = com.taobao.accs.b.a.a().b().loadClass("com.taobao.accs.utl.UtilityImpl");
            loadClass.getMethod("killService", Context.class).invoke(loadClass, context);
        } catch (Throwable th) {
            ALog.e(TAG, "killService", th, new Object[0]);
        }
    }

    public static void setAgooAppkey(Context context, String str) {
        try {
            Class<?> loadClass = com.taobao.accs.b.a.a().b().loadClass("org.android.agoo.common.Config");
            loadClass.getMethod("setAgooAppKey", Context.class, String.class).invoke(loadClass, context, str);
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppkey", th, new Object[0]);
            th.printStackTrace();
        }
    }

    public static void setMode(Context context, int i) {
        debugMode = i;
    }

    public static void setSpValue(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            ALog.e(TAG, "setSpValue null", new Object[0]);
            return;
        }
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putString(str, str2);
                edit.apply();
            }
            ALog.i(TAG, "setSpValue", "key", str, "value", str2);
        } catch (Exception e) {
            ALog.e(TAG, "setSpValue fail", e, new Object[0]);
        }
    }
}
