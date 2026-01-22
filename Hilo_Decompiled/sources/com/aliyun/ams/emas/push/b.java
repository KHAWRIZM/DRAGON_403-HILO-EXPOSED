package com.aliyun.ams.emas.push;

import android.content.Context;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface b {
    void onMessageArrived(Context context, CPushMessage cPushMessage);

    void onNotificationOpened(Context context, String str, String str2, String str3, int i10);

    void onNotificationReceivedWithoutShow(Context context, String str, String str2, Map map, int i10, String str3, String str4);

    void onNotificationRemoved(Context context, String str, String str2, String str3, int i10, String str4);

    void onNotificationShow(Context context, String str, String str2, Map map);
}
