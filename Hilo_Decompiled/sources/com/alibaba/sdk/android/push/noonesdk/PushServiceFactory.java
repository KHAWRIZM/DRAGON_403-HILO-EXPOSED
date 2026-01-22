package com.alibaba.sdk.android.push.noonesdk;

import android.app.Application;
import android.content.Context;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.PushControlService;
import com.alibaba.sdk.android.push.b.b;
import com.alibaba.sdk.android.push.b.e;
import com.alibaba.sdk.android.push.g.a;
import com.taobao.accs.ACCSClient;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PushServiceFactory {
    public static CloudPushService getCloudPushService() {
        return b.a();
    }

    public static PushControlService getPushControlService() {
        return e.a();
    }

    public static void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            com.alibaba.sdk.android.ams.common.a.b.a((Application) applicationContext);
        }
        com.alibaba.sdk.android.ams.common.a.b.a(applicationContext);
        b a10 = b.a();
        a10.a(applicationContext);
        ACCSClient.enableChannelProcess(applicationContext, true);
        a10.setPushIntentService(null);
        a.a().b();
    }

    @Deprecated
    public static void init(Context context, String str, String str2) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            com.alibaba.sdk.android.ams.common.a.b.a((Application) applicationContext);
        }
        com.alibaba.sdk.android.ams.common.a.b.a(applicationContext);
        b a10 = b.a();
        a10.a(applicationContext);
        a10.setAppkey(str);
        a10.setAppSecret(str2);
        a10.setPushIntentService(null);
        a.a().b();
    }

    @Deprecated
    public static void init(Context context, String str, String str2, boolean z10) {
        ACCSClient.enableChannelProcess(context, z10);
        init(context, str, str2);
    }

    @Deprecated
    public static void init(Context context, boolean z10) {
        ACCSClient.enableChannelProcess(context, z10);
        init(context);
    }

    public static void init(PushInitConfig pushInitConfig) {
        com.alibaba.sdk.android.ams.common.a.b.a(pushInitConfig.getApplication());
        com.alibaba.sdk.android.ams.common.a.b.a(pushInitConfig.getApplication().getApplicationContext());
        com.alibaba.sdk.android.ams.common.a.b.a(pushInitConfig.isDisableForegroundCheck());
        com.alibaba.sdk.android.ams.common.a.b.a(pushInitConfig.getPushHost());
        com.alibaba.sdk.android.ams.common.a.b.b(pushInitConfig.getAccsAppConnectHost());
        com.alibaba.sdk.android.ams.common.a.b.c(pushInitConfig.getAccsSilentConnectHost());
        com.alibaba.sdk.android.ams.common.a.b.d(pushInitConfig.getAmdcHost());
        b a10 = b.a();
        a10.a(pushInitConfig.getApplication().getApplicationContext());
        a10.setPushIntentService(null);
        if (pushInitConfig.getAppKey() != null) {
            a10.setAppkey(pushInitConfig.getAppKey());
        }
        if (pushInitConfig.getAppSecret() != null) {
            a10.setAppSecret(pushInitConfig.getAppSecret());
        }
        if (pushInitConfig.getLargeIconDownloadListener() != null) {
            a10.setLargeIconDownloadListener(pushInitConfig.getLargeIconDownloadListener());
        }
        ACCSClient.enableChannelProcess(pushInitConfig.getApplication(), !pushInitConfig.isDisableChannelProcess());
        ACCSClient.enableChannelProcessHeartbeat(pushInitConfig.getApplication(), !pushInitConfig.isDisableChannelProcessHeartbeat());
        a.a().a(pushInitConfig.isLoopStartChannel(), pushInitConfig.getLoopInterval());
    }
}
