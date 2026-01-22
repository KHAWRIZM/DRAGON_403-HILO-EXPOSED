package com.alibaba.sdk.android.push.register;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.push.register.ReporterFactory;
import com.google.firebase.messaging.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ThirdPushManager {
    private static final String TAG = "com.alibaba.sdk.android.push.register.ThirdPushManager";

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum ThirdPushReportKeyword {
        HONOR("HONOR_TOKEN", "honor", "ho_"),
        HUAWEI("HW_TOKEN", "huawei", "h_"),
        XIAOMI("MI_TOKEN", "xiaomi", "mi_"),
        OPPO("OPPO_TOKEN", "oppo", "o_"),
        VIVO("VIVO_TOKEN", "vivo", "v_"),
        MEIZU("MZ_TOKEN", "meizu", "mz_"),
        FCM(Constants.MessageTypes.MESSAGE, Constants.MessageTypes.MESSAGE, "g_");

        public final String thirdMsgKeyword;
        public final String thirdSdkVersionPrefix;
        public final String thirdTokenKeyword;

        ThirdPushReportKeyword(String str, String str2, String str3) {
            this.thirdTokenKeyword = str;
            this.thirdMsgKeyword = str2;
            this.thirdSdkVersionPrefix = str3;
        }
    }

    public static void onPushMsg(Context context, String str, String str2) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ReporterFactory.getMsgReporter().sendMsgToDecrypt(context, str, str2.getBytes("UTF-8"), null);
                return;
            } catch (Throwable th) {
                ALog.e(TAG, "onPushMsg", th, new Object[0]);
                return;
            }
        }
        ALog.e(TAG, "Incorrect parameter", new Object[0]);
    }

    public static void registerImpl(BaseNotifyClickActivity.INotifyListener iNotifyListener) {
        if (iNotifyListener != null) {
            BaseNotifyClickActivity.addNotifyListener(iNotifyListener);
        } else {
            ALog.e(TAG, "BaseNotifyClickActivity.INotifyListener cannot be empty.", new Object[0]);
        }
    }

    public static void reportToken(Context context, String str, String str2, String str3) {
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ReporterFactory.ITokenReporter tokenReporter = ReporterFactory.getTokenReporter();
            String addPrefix = ReporterFactory.addPrefix(str, str3);
            if (tokenReporter instanceof ReporterFactory.ITokenReporterV2) {
                try {
                    ALog.i(TAG, "report sdkVer:3.8.6.1, source: " + str + ", ThirdToken: " + str2 + ", version: " + addPrefix, new Object[0]);
                    ((ReporterFactory.ITokenReporterV2) tokenReporter).reportToken(context, "3.8.6.1", str, addPrefix, str2);
                    return;
                } catch (Throwable th) {
                    ALog.e(TAG, "reportToken", th, new Object[0]);
                    return;
                }
            }
            try {
                ALog.i(TAG, "report " + str + " ThirdToken: " + str2 + ", version: " + addPrefix, new Object[0]);
                tokenReporter.reportToken(context, str, addPrefix, str2);
                return;
            } catch (Throwable th2) {
                ALog.e(TAG, "reportToken", th2, new Object[0]);
                return;
            }
        }
        ALog.e(TAG, "Incorrect parameter", new Object[0]);
    }
}
