package com.alibaba.sdk.android.push.notification;

import android.app.Notification;
import androidx.core.app.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface NotificationConfigure {
    void configBuilder(Notification.Builder builder, PushData pushData);

    void configBuilder(o.e eVar, PushData pushData);

    void configNotification(Notification notification, PushData pushData);
}
