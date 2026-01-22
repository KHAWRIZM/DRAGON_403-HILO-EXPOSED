package com.aliyun.ams.emas.push;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.sdk.android.push.notification.PushData;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
abstract class f {
    public static void a(Context context, Intent intent, b bVar) {
        try {
            String stringExtra = intent.getStringExtra(AgooMessageReceiver.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra("title");
            String stringExtra3 = intent.getStringExtra(AgooMessageReceiver.SUMMARY);
            String stringExtra4 = intent.getStringExtra(AgooMessageReceiver.EXTRA_MAP);
            String stringExtra5 = intent.getStringExtra("group");
            int intExtra = intent.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1);
            l.f٦٨٩٨a.d("notification opened " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra5)) {
                a4.a.a().d(stringExtra5);
            }
            bVar.onNotificationOpened(context, stringExtra2, stringExtra3, stringExtra4, intExtra);
        } catch (Throwable th) {
            ALog.e("AgooPushHandler", "Handle notification open action failed.", th, new Object[0]);
        }
    }

    public static void b(Context context, Intent intent, c cVar, b bVar) {
        Map map;
        try {
            String stringExtra = intent.getStringExtra("id");
            if (TextUtils.isEmpty(stringExtra)) {
                ALog.e("AgooPushHandler", "handle message Null messageId!", new Object[0]);
                return;
            }
            String stringExtra2 = intent.getStringExtra("body");
            String stringExtra3 = intent.getStringExtra("task_id");
            String stringExtra4 = intent.getStringExtra("extData");
            String stringExtra5 = intent.getStringExtra("message_source");
            if (TextUtils.isEmpty(stringExtra2)) {
                ALog.e("AgooPushHandler", "handle message json body is Empty!", new Object[0]);
                return;
            }
            try {
                map = JsonUtility.toMap(new JSONObject(stringExtra2));
            } catch (JSONException e10) {
                ALog.e("AgooPushHandler", "Parse json error:", e10, new Object[0]);
                map = null;
            }
            Map map2 = map;
            try {
                int parseInt = Integer.parseInt((String) map2.get("type"));
                l.f٦٨٩٨a.d("handle message, messageId:" + stringExtra + ", type:" + parseInt + ", msg receive:" + stringExtra2);
                for (Map.Entry entry : map2.entrySet()) {
                    l.f٦٨٩٨a.d(((String) entry.getKey()) + " --> " + ((String) entry.getValue()));
                }
                String str = (String) map2.get(PushData.KEY_MSG_ID);
                map2.put("task_id", stringExtra3);
                map2.put("extData", stringExtra4);
                map2.put("message_source", stringExtra5);
                map2.put("_ALIYUN_NOTIFICATION_MSG_ID_", str);
                if (l.j()) {
                    l.f٦٨٩٨a.d("Push received in DoNotDisturb time window, ignored.");
                } else {
                    c(context, cVar, bVar, stringExtra, map2, parseInt);
                }
            } catch (Throwable th) {
                ALog.e("AgooPushHandler", "Wrong message Type Define!", th, new Object[0]);
            }
        } catch (Throwable th2) {
            ALog.e("AgooPushHandler", "onHandleCallException", th2, new Object[0]);
        }
    }

    private static void c(Context context, c cVar, b bVar, String str, Map map, int i10) {
        b4.b bVar2 = new b4.b();
        if (i10 != 1) {
            if (i10 != 2) {
                ALog.e("AgooPushHandler", "Wrong message Type Define!", new Object[0]);
                return;
            }
            try {
                CPushMessage c10 = bVar2.c(map, Config.b(context), str);
                if (c10 != null) {
                    l.d(context, c10.c(), i10);
                    try {
                        ALog.i("AgooPushHandler", "messageId=" + c10.c() + ";appId=" + c10.a() + ";messageType=msg", new Object[]{null, 1});
                    } catch (Throwable th) {
                        ALog.e("AgooPushHandler", "ut log error", th, new Object[0]);
                    }
                    bVar.onMessageArrived(context, c10);
                    return;
                }
                return;
            } catch (Throwable th2) {
                ALog.e("AgooPushHandler", "Custom message parse error:", th2, new Object[0]);
                return;
            }
        }
        try {
            String b10 = Config.b(context);
            b4.a e10 = bVar2.e(map, b10, str);
            if (e10 != null) {
                l.d(context, e10.n(), i10);
                if (cVar.showNotificationNow(context, map)) {
                    String E = e10.E();
                    if (!TextUtils.isEmpty(E)) {
                        a4.a.a().e(E, e10);
                    }
                    d(context, cVar, map, new i(map, e10, bVar2, context, bVar));
                    return;
                }
                l.f٦٨٩٨a.i("do not build notification as user request");
                bVar.onNotificationReceivedWithoutShow(context, e10.e(), e10.h(), e10.l(), e10.a(), e10.r(), e10.j());
                return;
            }
            ALog.e("AgooPushHandler", "Notify title is null or server push data Error appId =  " + b10, new Object[0]);
        } catch (Throwable th3) {
            ALog.e("AgooPushHandler", "Notify message error:", th3, new Object[0]);
        }
    }

    private static void d(Context context, c cVar, Map map, k kVar) {
        Handler handler;
        String str = (String) map.get("image");
        String str2 = (String) map.get(PushData.KEY_BIG_PICTURE);
        String str3 = (String) map.get("group");
        boolean checkNotificationShowInInnerGroup = cVar.checkNotificationShowInInnerGroup(map);
        Notification notification = null;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            Notification customNotificationUI = cVar.customNotificationUI(context, map);
            if (!TextUtils.isEmpty(str3) || checkNotificationShowInInnerGroup) {
                notification = cVar.customSummaryNotification(context, map);
            }
            kVar.a(customNotificationUI, notification);
            return;
        }
        if (Looper.myLooper() != null) {
            handler = new Handler(Looper.myLooper());
        } else {
            handler = null;
        }
        ThreadPoolExecutorFactory.execute(new g(cVar, context, map, str3, checkNotificationShowInInnerGroup, handler, kVar));
    }

    public static void e(Context context, Intent intent, b bVar) {
        try {
            String stringExtra = intent.getStringExtra(AgooMessageReceiver.MESSAGE_ID);
            String stringExtra2 = intent.getStringExtra("title");
            String stringExtra3 = intent.getStringExtra(AgooMessageReceiver.SUMMARY);
            String stringExtra4 = intent.getStringExtra(AgooMessageReceiver.EXTRA_MAP);
            int intExtra = intent.getIntExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, 1);
            String stringExtra5 = intent.getStringExtra("group");
            l.f٦٨٩٨a.d("notification deleted " + stringExtra);
            if (!TextUtils.isEmpty(stringExtra5)) {
                a4.a.a().d(stringExtra5);
            }
            bVar.onNotificationRemoved(context, stringExtra2, stringExtra3, stringExtra4, intExtra, stringExtra);
        } catch (Throwable th) {
            ALog.e("AgooPushHandler", "Handle notification delete action failed.", th, new Object[0]);
        }
    }
}
