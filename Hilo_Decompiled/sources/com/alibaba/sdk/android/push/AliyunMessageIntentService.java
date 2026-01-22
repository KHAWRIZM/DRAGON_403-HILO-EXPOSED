package com.alibaba.sdk.android.push;

import android.app.Notification;
import android.content.Context;
import com.alibaba.sdk.android.push.b.b;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.alibaba.sdk.android.push.notification.NotificationConfigure;
import com.alibaba.sdk.android.push.notification.PushData;
import com.alibaba.sdk.android.push.notification.d;
import com.alibaba.sdk.android.push.notification.e;
import com.aliyun.ams.emas.push.AgooMessageIntentService;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class AliyunMessageIntentService extends AgooMessageIntentService {
    private final d mMessageNotification = new d();

    @Override // com.aliyun.ams.emas.push.c
    public boolean checkNotificationShowInInnerGroup(Map<String, String> map) {
        boolean c10 = b.a().c();
        if (c10) {
            map.put("emas_group", "emas_accs_push");
        }
        return c10;
    }

    public Notification customNotificationUI(Context context, PushData pushData) {
        return null;
    }

    @Override // com.aliyun.ams.emas.push.c
    public Notification customSummaryNotification(Context context, Map<String, String> map) {
        PushData parse = PushData.parse(context, map);
        NotificationConfigure hookNotificationBuild = hookNotificationBuild();
        return this.mMessageNotification.a(context, this.mMessageNotification.a(context, map), parse, hookNotificationBuild);
    }

    public NotificationConfigure hookNotificationBuild() {
        return null;
    }

    protected abstract void onMessage(Context context, CPushMessage cPushMessage);

    @Override // com.aliyun.ams.emas.push.b
    public void onMessageArrived(Context context, com.aliyun.ams.emas.push.notification.CPushMessage cPushMessage) {
        onMessage(context, CPushMessage.from(cPushMessage));
    }

    protected abstract void onNotification(Context context, String str, String str2, Map<String, String> map);

    protected abstract void onNotificationClickedWithNoAction(Context context, String str, String str2, String str3);

    protected abstract void onNotificationOpened(Context context, String str, String str2, String str3);

    @Override // com.aliyun.ams.emas.push.b
    public void onNotificationOpened(Context context, String str, String str2, String str3, int i10) {
        if (i10 == 4) {
            onNotificationClickedWithNoAction(context, str, str2, str3);
        } else {
            onNotificationOpened(context, str, str2, str3);
        }
    }

    protected abstract void onNotificationReceivedInApp(Context context, String str, String str2, Map<String, String> map, int i10, String str3, String str4);

    @Override // com.aliyun.ams.emas.push.b
    public void onNotificationReceivedWithoutShow(Context context, String str, String str2, Map<String, String> map, int i10, String str3, String str4) {
        onNotificationReceivedInApp(context, str, str2, map, i10, str3, str4);
    }

    protected abstract void onNotificationRemoved(Context context, String str);

    @Override // com.aliyun.ams.emas.push.b
    public void onNotificationRemoved(Context context, String str, String str2, String str3, int i10, String str4) {
        onNotificationRemoved(context, str4);
    }

    @Override // com.aliyun.ams.emas.push.b
    public void onNotificationShow(Context context, String str, String str2, Map<String, String> map) {
        onNotification(context, str, str2, map);
    }

    @Override // com.aliyun.ams.emas.push.c
    public boolean showNotificationNow(Context context, Map<String, String> map) {
        return d.a(map) || !e.a(context);
    }

    @Override // com.aliyun.ams.emas.push.c
    public Notification customNotificationUI(Context context, Map<String, String> map) {
        PushData parse = PushData.parse(context, map);
        NotificationConfigure hookNotificationBuild = hookNotificationBuild();
        Notification customNotificationUI = customNotificationUI(context, parse);
        if (customNotificationUI != null) {
            return customNotificationUI;
        }
        return this.mMessageNotification.b(getApplicationContext(), this.mMessageNotification.a(getApplicationContext(), map), parse, hookNotificationBuild);
    }
}
