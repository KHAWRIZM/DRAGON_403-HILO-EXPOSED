package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class OrangeAdapter {
    public static final String NAMESPACE = "accs";
    private static final String TAG = "OrangeAdapter";
    private static final String TNET_LOG_KEY = "tnet_log_off";
    public static final boolean mOrangeValid = false;

    public static String getConfig(String str, String str2, String str3) {
        return str3;
    }

    private static boolean getConfigFromSP(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(str, z);
        } catch (Exception e) {
            ALog.e(TAG, "getConfigFromSP fail:", e, "key", str);
            return z;
        }
    }

    public static boolean isBindService(Context context) {
        boolean z;
        try {
            z = getConfigFromSP(context, Constants.SP_KEY_BIND_SERVICE_ENABLE, true);
        } catch (Throwable th) {
            ALog.e(TAG, "isBindService", th, new Object[0]);
            z = true;
        }
        ALog.d(TAG, "isBindService", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSmartHb() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), Constants.SP_KEY_HB_SMART_ENABLE, true);
        } catch (Throwable th) {
            ALog.e(TAG, "isSmartHb", th, new Object[0]);
            z = true;
        }
        ALog.d(TAG, "isSmartHb", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isTnetLogOff(boolean z) {
        boolean z2;
        String config;
        boolean z3;
        if (!z) {
            config = "default";
        } else {
            try {
                config = getConfig("accs", "tnet_log_off", "default");
            } catch (Throwable th) {
                th = th;
                z2 = true;
                ALog.e(TAG, "isTnetLogOff", th, new Object[0]);
                z3 = z2;
                ALog.i(TAG, "isTnetLogOff", "result", Boolean.valueOf(z3));
                return z3;
            }
        }
        if (config.equals("default")) {
            z3 = getConfigFromSP(GlobalClientInfo.getContext(), "tnet_log_off", true);
        } else {
            z3 = Boolean.valueOf(config).booleanValue();
            try {
                saveConfigToSP(GlobalClientInfo.getContext(), "tnet_log_off", z3);
            } catch (Throwable th2) {
                z2 = z3;
                th = th2;
                ALog.e(TAG, "isTnetLogOff", th, new Object[0]);
                z3 = z2;
                ALog.i(TAG, "isTnetLogOff", "result", Boolean.valueOf(z3));
                return z3;
            }
        }
        ALog.i(TAG, "isTnetLogOff", "result", Boolean.valueOf(z3));
        return z3;
    }

    private static void saveConfigToSP(Context context, String str, boolean z) {
        try {
        } catch (Exception e) {
            ALog.e(TAG, "saveConfigToSP fail:", e, "key", str, "value", Boolean.valueOf(z));
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, "value", Boolean.valueOf(z));
    }

    public static void saveConfigToSP(Context context, String str, int i) {
        try {
        } catch (Exception e) {
            ALog.e(TAG, "saveConfigToSP fail:", e, "key", str, "value", Integer.valueOf(i));
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
        edit.putInt(str, i);
        edit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, "value", Integer.valueOf(i));
    }
}
