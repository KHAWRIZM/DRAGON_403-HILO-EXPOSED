package com.alibaba.sdk.android.push.register;

import android.content.Context;
import com.alibaba.sdk.android.push.impl.OppoMsgParseImpl;
import com.alibaba.sdk.android.push.oppo.BuildConfig;
import com.alibaba.sdk.android.push.register.ThirdPushManager;
import com.alibaba.sdk.android.push.utils.SysUtils;
import com.alibaba.sdk.android.push.utils.ThreadUtil;
import com.taobao.accs.utl.ALog;
import q9.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class OppoRegister {
    public static final String TAG = "MPS:OPush";

    public static boolean register(Context context, String str, String str2) {
        final Context applicationContext;
        boolean z10;
        try {
            applicationContext = context.getApplicationContext();
        } catch (Throwable th) {
            ALog.e(TAG, "register error", th, new Object[0]);
        }
        if (!SysUtils.isTargetProcess(applicationContext)) {
            ALog.i(TAG, "not in target process, return", new Object[0]);
            return false;
        }
        if ((applicationContext.getApplicationInfo().flags & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        a.a(applicationContext, z10);
        if (a.b(applicationContext)) {
            ThirdPushManager.registerImpl(new OppoMsgParseImpl());
            ALog.i(TAG, "register oppo begin ", new Object[0]);
            a.d(applicationContext, str, str2, new r9.a() { // from class: com.alibaba.sdk.android.push.register.OppoRegister.2
                @Override // r9.a
                public void onError(int i10, String str3) {
                    ALog.e(OppoRegister.TAG, "onError code=" + i10 + " msg=" + str3, new Object[0]);
                }

                @Override // r9.a
                public void onGetNotificationStatus(int i10, int i11) {
                    ALog.i(OppoRegister.TAG, "onGetNotificationStatus code=" + i10 + " status=" + i11, new Object[0]);
                }

                @Override // r9.a
                public void onGetPushStatus(int i10, int i11) {
                    ALog.i(OppoRegister.TAG, "onGetPushStatus code=" + i10 + " status=" + i11, new Object[0]);
                }

                @Override // r9.a
                public void onRegister(int i10, String str3) {
                    ALog.i(OppoRegister.TAG, "onRegister code=" + i10 + " regid=" + str3, new Object[0]);
                    if (i10 == 0) {
                        if (!str3.contains("APP Not prepared") && !str3.contains("Invalid App Key") && !str3.contains("deviceID is invalid") && !str3.contains("Missing App Key")) {
                            ThirdPushManager.reportToken(applicationContext, ThirdPushManager.ThirdPushReportKeyword.OPPO.thirdTokenKeyword, str3, BuildConfig.OPPO_VERSION);
                            return;
                        } else {
                            ALog.i(OppoRegister.TAG, "OPPO token is invalid", new Object[0]);
                            return;
                        }
                    }
                    ThirdPushManager.reportToken(applicationContext, ThirdPushManager.ThirdPushReportKeyword.OPPO.thirdTokenKeyword, "", BuildConfig.OPPO_VERSION);
                }

                @Override // r9.a
                public void onSetPushTime(int i10, String str3) {
                    ALog.i(OppoRegister.TAG, "onSetPushTime code=" + i10 + " pushTime is " + str3, new Object[0]);
                }

                @Override // r9.a
                public void onUnRegister(int i10) {
                    ALog.e(OppoRegister.TAG, "onUnRegister code=" + i10, new Object[0]);
                }
            });
            return true;
        }
        ALog.i(TAG, "not1003 support oppo push", new Object[0]);
        return false;
    }

    public static void registerAsync(final Context context, final String str, final String str2) {
        ThreadUtil.getExecutor().execute(new Runnable() { // from class: com.alibaba.sdk.android.push.register.OppoRegister.1
            @Override // java.lang.Runnable
            public void run() {
                OppoRegister.register(context, str, str2);
            }
        });
    }
}
