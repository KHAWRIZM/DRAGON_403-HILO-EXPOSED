package com.aliyun.ams.emas.push;

import android.app.Notification;
import android.content.Context;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface c {
    boolean checkNotificationShowInInnerGroup(Map map);

    Notification customNotificationUI(Context context, Map map);

    Notification customSummaryNotification(Context context, Map map);

    boolean showNotificationNow(Context context, Map map);
}
