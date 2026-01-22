package com.alibaba.sdk.android.push.notification;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.push.common.util.JSONUtils;
import com.aliyun.ams.emas.push.data.NotificationDataManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    static AmsLogger f٦٧٨٧a = AmsLogger.getLogger("MPS:MessageNotification");

    public Notification a(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        try {
            a aVar = new a();
            aVar.a(bVar.b());
            aVar.b(bVar.c());
            aVar.a(bVar.p());
            aVar.c(bVar.q());
            aVar.d(bVar.r());
            aVar.b(bVar.s());
            aVar.e(bVar.t());
            aVar.f(bVar.u());
            aVar.g(bVar.v());
            aVar.h(bVar.w());
            aVar.i(bVar.a());
            if (TextUtils.isEmpty(bVar.x())) {
                String y10 = bVar.y();
                if (!TextUtils.isEmpty(y10)) {
                    aVar.k(y10);
                }
            } else {
                aVar.j(bVar.x());
            }
            Notification b10 = aVar.b(context, pushData, notificationConfigure);
            if (b10 == null) {
                b10 = new Notification(R.drawable.stat_notify_chat, "", System.currentTimeMillis());
            }
            if (1 == bVar.g() || bVar.o()) {
                a(context, bVar, b10);
                if (bVar.e()) {
                    b10.flags |= 32;
                } else {
                    b10.flags |= 16;
                }
            } else {
                f٦٧٨٧a.d("custom notification option first");
                b(context, bVar, b10);
                b10.flags = bVar.h();
            }
            if (notificationConfigure != null) {
                notificationConfigure.configNotification(b10, pushData);
            }
            return b10;
        } catch (Throwable th) {
            f٦٧٨٧a.e("onNotification createSummaryNotification error", th);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00bc A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x001b, B:7:0x002c, B:8:0x003b, B:9:0x0059, B:11:0x009e, B:13:0x00af, B:15:0x00bc, B:16:0x00ca, B:18:0x00d0, B:20:0x00d6, B:22:0x00ff, B:26:0x00e7, B:28:0x00f0, B:29:0x00f7, B:30:0x00b6, B:31:0x0042, B:32:0x0047, B:34:0x004d, B:35:0x0054), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ff A[Catch: all -> 0x003f, TRY_LEAVE, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x001b, B:7:0x002c, B:8:0x003b, B:9:0x0059, B:11:0x009e, B:13:0x00af, B:15:0x00bc, B:16:0x00ca, B:18:0x00d0, B:20:0x00d6, B:22:0x00ff, B:26:0x00e7, B:28:0x00f0, B:29:0x00f7, B:30:0x00b6, B:31:0x0042, B:32:0x0047, B:34:0x004d, B:35:0x0054), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x001b, B:7:0x002c, B:8:0x003b, B:9:0x0059, B:11:0x009e, B:13:0x00af, B:15:0x00bc, B:16:0x00ca, B:18:0x00d0, B:20:0x00d6, B:22:0x00ff, B:26:0x00e7, B:28:0x00f0, B:29:0x00f7, B:30:0x00b6, B:31:0x0042, B:32:0x0047, B:34:0x004d, B:35:0x0054), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00f7 A[Catch: all -> 0x003f, TryCatch #0 {all -> 0x003f, blocks: (B:3:0x0001, B:5:0x001b, B:7:0x002c, B:8:0x003b, B:9:0x0059, B:11:0x009e, B:13:0x00af, B:15:0x00bc, B:16:0x00ca, B:18:0x00d0, B:20:0x00d6, B:22:0x00ff, B:26:0x00e7, B:28:0x00f0, B:29:0x00f7, B:30:0x00b6, B:31:0x0042, B:32:0x0047, B:34:0x004d, B:35:0x0054), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification b(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        String c10;
        Notification a10;
        try {
            a aVar = new a();
            String x10 = bVar.x();
            String y10 = bVar.y();
            aVar.a(bVar.b());
            if (TextUtils.isEmpty(x10)) {
                if (!TextUtils.isEmpty(y10)) {
                    aVar.k(bVar.y());
                }
                c10 = bVar.c();
            } else {
                aVar.j(bVar.x());
                int groupNotifyCount = NotificationDataManager.getInstance().getGroupNotifyCount(x10);
                c10 = groupNotifyCount > 1 ? context.getString(com.alibaba.sdk.android.push.R.string.unread_notification, Integer.valueOf(groupNotifyCount)) : bVar.c();
            }
            aVar.b(c10);
            aVar.a(bVar.p());
            aVar.c(bVar.q());
            aVar.d(bVar.r());
            aVar.b(bVar.s());
            aVar.e(bVar.t());
            aVar.f(bVar.u());
            aVar.g(bVar.v());
            aVar.h(bVar.w());
            aVar.i(bVar.a());
            if (1 != bVar.g()) {
                f٦٧٨٧a.d("building customNotification");
                a10 = CustomNotificationBuilder.getInstance().a(context, bVar, pushData, notificationConfigure);
                if (a10 == null) {
                    f٦٧٨٧a.e("build custom notification failed, build default notification");
                }
                if (a10 == null) {
                    a10 = new Notification(R.drawable.stat_notify_chat, "", System.currentTimeMillis());
                }
                if (1 != bVar.g() || bVar.o()) {
                    a(context, bVar, a10);
                    if (bVar.e()) {
                        a10.flags |= 16;
                    } else {
                        a10.flags |= 32;
                    }
                } else {
                    f٦٧٨٧a.d("custom notification option first");
                    b(context, bVar, a10);
                    a10.flags = bVar.h();
                }
                if (notificationConfigure != null) {
                    notificationConfigure.configNotification(a10, pushData);
                }
                return a10;
            }
            a10 = aVar.a(context, pushData, notificationConfigure);
            if (a10 == null) {
            }
            if (1 != bVar.g()) {
            }
            a(context, bVar, a10);
            if (bVar.e()) {
            }
            if (notificationConfigure != null) {
            }
            return a10;
        } catch (Throwable th) {
            f٦٧٨٧a.e("onNotification", th);
            return null;
        }
    }

    private Uri a(Context context, b bVar) {
        Uri uri;
        String a10;
        Uri uri2 = Uri.EMPTY;
        if (!TextUtils.isEmpty(bVar.a())) {
            String a11 = bVar.a();
            if (a11.startsWith("android.resource://")) {
                uri = Uri.parse(a11);
            } else {
                if (a11.startsWith("/raw/")) {
                    a10 = "android.resource://" + context.getPackageName() + a11;
                } else {
                    a10 = "android.resource://" + context.getPackageName() + "/raw/" + a11;
                }
                uri = Uri.parse(a10);
            }
        } else if (com.alibaba.sdk.android.push.common.a.b.a() != null) {
            a10 = com.alibaba.sdk.android.push.common.a.b.a();
            uri = Uri.parse(a10);
        } else {
            int identifier = context.getResources().getIdentifier("alicloud_notification_sound", "raw", context.getPackageName());
            f٦٧٨٧a.d("sound resId:" + identifier);
            if (identifier != 0) {
                uri = Uri.parse("android.resource://" + context.getPackageName() + "/" + identifier);
                f٦٧٨٧a.d("sound resId:" + identifier + "  ;uri:" + uri.toString());
            } else {
                uri = uri2;
            }
        }
        if (uri == uri2) {
            uri = RingtoneManager.getDefaultUri(2);
        }
        f٦٧٨٧a.d("soundUri:" + uri.toString());
        return uri;
    }

    private void b(Context context, b bVar, Notification notification) {
        f٦٧٨٧a.d("custom notification feedback");
        long[] jArr = {100, 250, 100, 250, 100, 250};
        if (bVar.i() == 0) {
            return;
        }
        if (2 == bVar.i()) {
            notification.sound = a(context, bVar);
            return;
        }
        if (1 != bVar.i()) {
            if (3 != bVar.i()) {
                notification.defaults = -1;
                return;
            }
            notification.sound = a(context, bVar);
        }
        notification.vibrate = jArr;
    }

    public b a(Context context, Map<String, String> map) {
        String str = map.get("title");
        String str2 = map.get("content");
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            f٦٧٨٧a.e("title or content of notify is empty: " + map);
            return null;
        }
        b bVar = new b();
        String str3 = map.get(PushData.KEY_NOTIFY_TYPE);
        if (StringUtil.isEmpty(str3)) {
            str3 = String.valueOf(3);
        }
        String str4 = map.get(PushData.KEY_MUSIC);
        String str5 = map.get(PushData.KEY_EXT);
        String str6 = map.get(PushData.KEY_CHANNEL);
        String str7 = map.get("style");
        String str8 = map.get("title");
        String str9 = map.get(PushData.KEY_BIG_BODY);
        String str10 = map.get(PushData.KEY_BIG_PICTURE);
        String str11 = map.get(PushData.KEY_INBOX_CONTENT);
        String str12 = map.get("group");
        String str13 = map.get("emas_group");
        bVar.b(str);
        bVar.d(str2);
        bVar.c(str2);
        bVar.a(Integer.parseInt(str3));
        bVar.f(str6);
        bVar.g(map.get("image"));
        bVar.l(str12);
        bVar.m(str13);
        if (!TextUtils.isEmpty(str7)) {
            try {
                bVar.k(Integer.parseInt(str7));
            } catch (Throwable unused) {
            }
        }
        bVar.h(str8);
        bVar.i(str9);
        bVar.j(str10);
        bVar.k(str11);
        bVar.a(StringUtil.isEmpty(str4) ? null : str4);
        if (!StringUtil.isEmpty(str5)) {
            try {
                Map<String, String> map2 = JSONUtils.toMap(new JSONObject(str5));
                bVar.e(map2.containsKey("_ALIYUN_NOTIFICATION_PRIORITY_") ? map2.get("_ALIYUN_NOTIFICATION_PRIORITY_") : String.valueOf(0));
                bVar.a(map2);
            } catch (JSONException e10) {
                f٦٧٨٧a.e("Parse inner json(ext) error:", e10);
            }
        }
        if (map.containsKey(PushData.KEY_CUSTOM_NOTIFICAITON_ID)) {
            int parseInt = Integer.parseInt(map.get(PushData.KEY_CUSTOM_NOTIFICAITON_ID));
            if (parseInt != 0) {
                BasicCustomPushNotification a10 = CustomNotificationBuilder.getInstance().a(parseInt);
                if (a10 == null) {
                    f٦٧٨٧a.w("custom notification is null");
                } else {
                    bVar.c(a10.getNotificationType());
                    bVar.b(a10.getStatusBarDrawable());
                    bVar.e(a10.getRemindType());
                    bVar.d(a10.getNotificationFlags());
                    bVar.a(a10.isServerOptionFirst());
                    if (3 == a10.getNotificationType()) {
                        AdvancedCustomPushNotification advancedCustomPushNotification = (AdvancedCustomPushNotification) a10;
                        bVar.i(advancedCustomPushNotification.getContentView());
                        bVar.f(advancedCustomPushNotification.getNotificationView());
                        bVar.h(advancedCustomPushNotification.getTitleView());
                        bVar.g(advancedCustomPushNotification.getIconView());
                        bVar.j(advancedCustomPushNotification.getIcon());
                    }
                }
            } else {
                f٦٧٨٧a.d("default notification");
            }
        }
        return bVar;
    }

    private void a(Context context, b bVar, Notification notification) {
        Uri uri;
        StringBuilder sb;
        String a10;
        long[] jArr = {100, 250, 100, 250, 100, 250};
        int d10 = bVar.d();
        if (d10 == 1) {
            notification.vibrate = jArr;
            return;
        }
        if (d10 != 2) {
            if (d10 != 3) {
                return;
            } else {
                notification.vibrate = jArr;
            }
        }
        Uri uri2 = Uri.EMPTY;
        if (!TextUtils.isEmpty(bVar.a())) {
            String a11 = bVar.a();
            if (a11.startsWith("android.resource://")) {
                uri = Uri.parse(a11);
            } else if (a11.startsWith("/raw/")) {
                sb = new StringBuilder();
                sb.append("android.resource://");
                sb.append(context.getPackageName());
                sb.append(a11);
                a10 = sb.toString();
                uri = Uri.parse(a10);
            } else {
                a10 = "android.resource://" + context.getPackageName() + "/raw/" + a11;
                uri = Uri.parse(a10);
            }
        } else if (com.alibaba.sdk.android.push.common.a.b.a() != null) {
            a10 = com.alibaba.sdk.android.push.common.a.b.a();
            uri = Uri.parse(a10);
        } else {
            int identifier = context.getResources().getIdentifier("alicloud_notification_sound", "raw", context.getPackageName());
            if (identifier != 0) {
                sb = new StringBuilder();
                sb.append("android.resource://");
                sb.append(context.getPackageName());
                sb.append("/");
                sb.append(identifier);
                a10 = sb.toString();
                uri = Uri.parse(a10);
            } else {
                uri = uri2;
            }
        }
        if (uri == uri2) {
            uri = RingtoneManager.getDefaultUri(2);
        }
        notification.sound = uri;
    }

    public static boolean a(Map<String, String> map) {
        int parseInt;
        BasicCustomPushNotification a10;
        if (!map.containsKey(PushData.KEY_CUSTOM_NOTIFICAITON_ID) || (parseInt = Integer.parseInt(map.get(PushData.KEY_CUSTOM_NOTIFICAITON_ID))) == 0 || (a10 = CustomNotificationBuilder.getInstance().a(parseInt)) == null) {
            return true;
        }
        return a10.isBuildWhenAppInForeground();
    }
}
