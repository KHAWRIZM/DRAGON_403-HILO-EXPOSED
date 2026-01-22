package b4;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.entity.ConnType;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.notification.PushData;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.aliyun.ams.emas.push.MsgService;
import com.aliyun.ams.emas.push.NotificationActivity;
import com.aliyun.ams.emas.push.l;
import com.aliyun.ams.emas.push.notification.CPushMessage;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.JsonUtility;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {
    private PendingIntent a(Context context, a aVar, int i10) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), MsgService.class.getName());
        intent.setAction(l.f٦٨٩٩b);
        intent.putExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, "notification_delete");
        intent.putExtra("task_id", aVar.x());
        intent.putExtra("extData", aVar.z());
        intent.putExtra("msgId", aVar.n());
        intent.putExtra("title", aVar.e());
        intent.putExtra(AgooMessageReceiver.SUMMARY, aVar.h());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, aVar.a());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_ID, aVar.t());
        intent.putExtra("group", aVar.E());
        if (aVar.l() != null) {
            intent.putExtra(AgooMessageReceiver.EXTRA_MAP, new JSONObject(aVar.l()).toString());
        }
        ALog.d("MPS:MessageNotification", "delete content messageId:" + aVar.n(), new Object[0]);
        intent.putExtra(RemoteConfigConstants.RequestFieldKey.APP_ID, aVar.p());
        if (Build.VERSION.SDK_INT >= 23) {
            return PendingIntent.getService(context, i10, intent, 201326592);
        }
        return PendingIntent.getService(context, i10, intent, 134217728);
    }

    private PendingIntent b(Context context, a aVar, Intent intent, int i10) {
        Intent intent2 = new Intent();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 30 && context.getApplicationInfo().targetSdkVersion <= 30) {
            intent2.setClassName(context.getPackageName(), MsgService.class.getName());
        } else {
            intent2.setClassName(context.getPackageName(), NotificationActivity.class.getName());
        }
        intent2.setAction(l.f٦٨٩٩b);
        intent2.putExtra(ShareConstants.WEB_DIALOG_PARAM_ACTION_TYPE, "notification_open");
        intent2.putExtra("task_id", aVar.x());
        intent2.putExtra("extData", aVar.z());
        String E = aVar.E();
        if (!TextUtils.isEmpty(E)) {
            intent2.putExtra("group", E);
        }
        intent.putExtra("title", aVar.e());
        intent.putExtra(AgooMessageReceiver.SUMMARY, aVar.h());
        intent.putExtra("msgId", aVar.n());
        intent.putExtra(RemoteConfigConstants.RequestFieldKey.APP_ID, aVar.p());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_OPEN_TYPE, aVar.a());
        intent.putExtra(AgooMessageReceiver.NOTIFICATION_ID, aVar.t());
        if (!TextUtils.isEmpty(E)) {
            intent.putExtra("group", E);
        }
        intent2.putExtra("msgId", aVar.n());
        if (aVar.l() != null) {
            intent.putExtra(AgooMessageReceiver.EXTRA_MAP, new JSONObject(aVar.l()).toString());
        }
        ALog.d("MPS:MessageNotification", "build content messageId:" + aVar.n(), new Object[0]);
        intent2.putExtra("realIntent", intent);
        if (i11 <= 30 && context.getApplicationInfo().targetSdkVersion <= 30) {
            if (i11 >= 23) {
                return PendingIntent.getService(context, i10, intent2, 201326592);
            }
            return PendingIntent.getService(context, i10, intent2, 134217728);
        }
        return PendingIntent.getActivity(context, i10, intent2, 201326592);
    }

    public CPushMessage c(Map map, String str, String str2) {
        String str3 = (String) map.get("title");
        String str4 = (String) map.get("content");
        String str5 = (String) map.get("extData");
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            CPushMessage cPushMessage = new CPushMessage();
            cPushMessage.i(str2);
            cPushMessage.f(str);
            cPushMessage.j(str3);
            cPushMessage.g(str4);
            cPushMessage.l(str5);
            return cPushMessage;
        }
        ALog.e("MPS:MessageNotification", "Message title or content is empty:" + map.toString(), new Object[0]);
        return null;
    }

    public void d(Context context, Notification notification, Notification notification2, a aVar) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
            String str = "";
            if (notification == null) {
                c cVar = new c();
                cVar.d(aVar.e());
                cVar.f(aVar.h());
                cVar.c(aVar.v());
                cVar.h(aVar.B());
                cVar.j(aVar.E());
                notification = cVar.a(context);
                if (notification == null) {
                    notification = new Notification(R.drawable.stat_notify_chat, "", System.currentTimeMillis());
                }
            }
            Intent intent = new Intent();
            intent.putExtra(RemoteConfigConstants.RequestFieldKey.APP_ID, aVar.p());
            intent.putExtra("msgId", aVar.n());
            intent.putExtra("task_id", aVar.x());
            intent.putExtra("extData", aVar.z());
            intent.putExtra("message_source", aVar.D());
            intent.setFlags(270532608);
            try {
                int a10 = aVar.a();
                if (a10 != 1) {
                    if (a10 != 2) {
                        if (a10 != 3) {
                            if (a10 == 4) {
                                str = "no action";
                            }
                        } else {
                            str = "url";
                            intent.setAction("android.intent.action.VIEW");
                            intent.setData(Uri.parse(aVar.j()));
                        }
                    } else {
                        str = "activity";
                        try {
                            intent.setClass(context, Class.forName(aVar.r()));
                        } catch (Throwable th) {
                            ALog.e("MPS:MessageNotification", "can't find certain activity class: ", th, new Object[0]);
                        }
                    }
                } else {
                    str = "app";
                    intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                }
                ALog.i("MPS:MessageNotification", "open type:" + str, new Object[0]);
            } catch (Throwable th2) {
                ALog.e("MPS:MessageNotification", "openType exception", th2, new Object[0]);
            }
            notification.contentIntent = b(context, aVar, intent, l.l());
            notification.deleteIntent = a(context, aVar, l.l());
            try {
                ALog.i("MPS:MessageNotification", "messageId=" + aVar.n() + ";appId=" + aVar.p() + ";messageType=notify", new Object[]{null, 1});
            } catch (Throwable th3) {
                ALog.e("MPS:MessageNotification", "ut log error", th3, new Object[0]);
            }
            a4.a.a().b(aVar.t());
            notificationManager.notify(aVar.t(), notification);
            l.f٦٨٩٨a.d("push notify notification");
            String E = aVar.E();
            String F = aVar.F();
            if (notification2 != null) {
                if (!TextUtils.isEmpty(E)) {
                    notificationManager.notify(aVar.t() + 66, notification2);
                } else if (!TextUtils.isEmpty(F)) {
                    notificationManager.notify(0, notification2);
                }
            }
        } catch (Throwable th4) {
            l.f٦٨٩٨a.e("onNotification", th4);
            Log.e("MPS:MessageNotification", Log.getStackTraceString(th4));
        }
    }

    public a e(Map map, String str, String str2) {
        int k10;
        String str3 = (String) map.get("title");
        String str4 = (String) map.get("content");
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            a aVar = new a();
            String str5 = (String) map.get(ConnType.PK_OPEN);
            if (TextUtils.isEmpty(str5)) {
                str5 = String.valueOf(1);
            }
            String str6 = (String) map.get("url");
            String str7 = (String) map.get("activity");
            String str8 = (String) map.get(PushData.KEY_EXT);
            String str9 = (String) map.get("task_id");
            String str10 = (String) map.get("extData");
            String str11 = (String) map.get(PushData.KEY_CHANNEL);
            String str12 = (String) map.get(PushData.KEY_NOTIFY_ID);
            String str13 = (String) map.get("group");
            if (!TextUtils.isEmpty(str13)) {
                k10 = str13.hashCode();
            } else if (!TextUtils.isEmpty(str12)) {
                k10 = Integer.parseInt(str12);
            } else {
                k10 = l.k();
            }
            aVar.m(str);
            aVar.k(str2);
            aVar.s(str9);
            aVar.u(str10);
            aVar.y((String) map.get("message_source"));
            aVar.c(str3);
            aVar.g(str4);
            aVar.b(Integer.parseInt(str5));
            if (TextUtils.isEmpty(str6)) {
                str6 = null;
            }
            aVar.i(str6);
            if (TextUtils.isEmpty(str7)) {
                str7 = null;
            }
            aVar.o(str7);
            aVar.f(k10);
            aVar.w(str11);
            aVar.A(str13);
            if (!TextUtils.isEmpty(str8)) {
                try {
                    Map map2 = JsonUtility.toMap(new JSONObject(str8));
                    map2.put(CloudPushService.NOTIFICATION_ID, String.valueOf(aVar.t()));
                    if (map2.containsKey("_ALIYUN_NOTIFICATION_PRIORITY_")) {
                        aVar.q((String) map2.get("_ALIYUN_NOTIFICATION_PRIORITY_"));
                    } else {
                        aVar.q(String.valueOf(0));
                    }
                    map2.put("_ALIYUN_NOTIFICATION_MSG_ID_", map.get("_ALIYUN_NOTIFICATION_MSG_ID_"));
                    aVar.d(map2);
                } catch (JSONException e10) {
                    ALog.e("MPS:MessageNotification", "Parse inner json(ext) error:", e10, new Object[0]);
                }
            }
            return aVar;
        }
        ALog.e("MPS:MessageNotification", "title or content of notify is empty: " + map, new Object[0]);
        return null;
    }
}
