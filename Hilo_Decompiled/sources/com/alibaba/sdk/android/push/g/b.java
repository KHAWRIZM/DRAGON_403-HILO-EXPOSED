package com.alibaba.sdk.android.push.g;

import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {
    public static void a(CommonCallback commonCallback, e eVar) {
        ErrorCode a10 = eVar.a();
        AmsLogger.getImportantLogger().i("errorCode:" + a10);
        if (a10.getCode().contains(com.alibaba.sdk.android.push.common.a.d.f٦٥٨٩a.getCode())) {
            if (commonCallback != null) {
                commonCallback.onSuccess(a10.getMsg());
            }
        } else {
            if (commonCallback != null) {
                commonCallback.onFailed(a10.getCode(), a10.getMsg());
            }
            a(a10.getCode(), a10.getMsg());
        }
    }

    private static void a(String str, String str2) {
        com.alibaba.sdk.android.ams.common.b.b a10 = com.alibaba.sdk.android.ams.common.b.c.a();
        com.alibaba.sdk.android.push.d.a a11 = com.alibaba.sdk.android.push.d.a.a();
        if (a11 == null || a10 == null) {
            return;
        }
        a11.a(str, str2, a10.b());
    }
}
