package com.alibaba.sdk.android.push.notification;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CustomNotificationBuilder {
    public static final String NOTIFICATION_ICON_RES_TYPE = "drawable";
    public static final String NOTIFICATION_LARGE_ICON_FILE = "alicloud_notification_largeicon";
    public static final String NOTIFICATION_SMALL_ICON_FILE = "alicloud_notification_smallicon";

    /* renamed from: a, reason: collision with root package name */
    static AmsLogger f٦٧٤٣a = AmsLogger.getLogger("MPS:CustomNotificationBuilder");

    /* renamed from: c, reason: collision with root package name */
    private static CustomNotificationBuilder f٦٧٤٤c = null;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, Object> f٦٧٤٥b;

    private CustomNotificationBuilder() {
        this.f٦٧٤٥b = null;
        this.f٦٧٤٥b = new HashMap();
    }

    private int a(Context context, b bVar) {
        int i10;
        int f10 = bVar.f();
        if (f10 != 0) {
            return f10;
        }
        int c10 = com.alibaba.sdk.android.push.common.a.b.c() != 0 ? com.alibaba.sdk.android.push.common.a.b.c() : context.getResources().getIdentifier(NOTIFICATION_SMALL_ICON_FILE, NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e10) {
            f٦٧٤٣a.e("Get system icon error, package name not found, ", e10);
            i10 = R.drawable.stat_notify_chat;
        }
        return c10 == 0 ? i10 : c10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0129  */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.app.Notification$Style] */
    /* JADX WARN: Type inference failed for: r0v27, types: [android.app.Notification$BigTextStyle] */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.app.Notification$BigPictureStyle] */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.app.Notification$Builder] */
    /* JADX WARN: Type inference failed for: r19v0, types: [com.alibaba.sdk.android.push.notification.NotificationConfigure] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Notification b(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        ?? bigPicture;
        int i10;
        Uri parse;
        f٦٧٤٣a.d("building basic custom notification");
        int s10 = bVar.s();
        String t10 = bVar.t();
        String u10 = bVar.u();
        String w10 = bVar.w();
        String a10 = bVar.a();
        Bitmap a11 = !TextUtils.isEmpty(bVar.v()) ? com.alibaba.sdk.android.push.f.a.a(context, bVar.v(), PushData.KEY_BIG_PICTURE) : null;
        Bitmap b10 = b(context, bVar);
        String x10 = bVar.x();
        String y10 = bVar.y();
        ?? builder = new Notification.Builder(context);
        builder.setContentTitle(bVar.b()).setContentText(bVar.c()).setSmallIcon(a(context, bVar)).setPriority(bVar.p()).setLargeIcon(b10).setTicker("").setWhen(System.currentTimeMillis());
        if (!TextUtils.isEmpty(x10)) {
            builder.setGroup(x10);
        } else if (!TextUtils.isEmpty(y10)) {
            builder.setGroup(y10);
        }
        if (s10 == 1) {
            bigPicture = new Notification.BigTextStyle().bigText(u10);
            if (!TextUtils.isEmpty(t10)) {
                bigPicture.setBigContentTitle(t10);
            }
        } else {
            if (s10 != 2) {
                if (s10 == 3) {
                    Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                    try {
                        JSONArray jSONArray = new JSONArray(w10);
                        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                            inboxStyle.addLine(jSONArray.getString(i11));
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(t10)) {
                        inboxStyle.setBigContentTitle(t10);
                    }
                    builder.setStyle(inboxStyle);
                }
                i10 = Build.VERSION.SDK_INT;
                builder.setShowWhen(true);
                if (i10 >= 26 && !TextUtils.isEmpty(bVar.q())) {
                    builder.setChannelId(bVar.q());
                }
                if (e.b()) {
                    builder.setGroupSummary(false);
                    builder.setGroup("group");
                } else {
                    builder.setGroupSummary(true);
                    builder.setGroup("group" + e.a());
                }
                if (!TextUtils.isEmpty(a10)) {
                    if (a10.startsWith("android.resource://")) {
                        parse = Uri.parse(a10);
                    } else {
                        parse = Uri.parse(a10.startsWith("/raw/") ? "android.resource://" + context.getPackageName() + a10 : "android.resource://" + context.getPackageName() + "/raw/" + a10);
                    }
                    builder.setSound(parse);
                }
                if (notificationConfigure != 0) {
                    notificationConfigure.configBuilder(builder, pushData);
                }
                return builder.build();
            }
            bigPicture = new Notification.BigPictureStyle().bigPicture(a11);
            if (!TextUtils.isEmpty(t10)) {
                bigPicture.setBigContentTitle(t10);
            }
            if (b10 != null) {
                bigPicture.bigLargeIcon(b10);
            }
        }
        builder.setStyle(bigPicture);
        i10 = Build.VERSION.SDK_INT;
        builder.setShowWhen(true);
        if (i10 >= 26) {
            builder.setChannelId(bVar.q());
        }
        if (e.b()) {
        }
        if (!TextUtils.isEmpty(a10)) {
        }
        if (notificationConfigure != 0) {
        }
        return builder.build();
    }

    private Notification c(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        int k10;
        int i10;
        String str;
        Uri parse;
        String a10 = bVar.a();
        f٦٧٤٣a.d("building advanced custom notification");
        if (bVar.j() == 0) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), bVar.j());
        remoteViews.setTextViewText(bVar.l(), bVar.b());
        remoteViews.setTextViewText(bVar.m(), bVar.c());
        if (bVar.n() != 0) {
            k10 = bVar.k();
            i10 = bVar.n();
        } else {
            k10 = bVar.k();
            i10 = R.drawable.stat_notify_chat;
        }
        remoteViews.setImageViewResource(k10, i10);
        String x10 = bVar.x();
        String y10 = bVar.y();
        int i11 = Build.VERSION.SDK_INT;
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContent(remoteViews).setPriority(bVar.p()).setSmallIcon(a(context, bVar)).setTicker("").setWhen(System.currentTimeMillis());
        if (!TextUtils.isEmpty(x10)) {
            builder.setGroup(x10);
        } else if (!TextUtils.isEmpty(y10)) {
            builder.setGroup(y10);
        }
        builder.setShowWhen(true);
        if (i11 >= 26 && !TextUtils.isEmpty(bVar.q())) {
            builder.setChannelId(bVar.q());
        }
        if (!TextUtils.isEmpty(a10)) {
            if (a10.startsWith("android.resource://")) {
                parse = Uri.parse(a10);
            } else {
                if (a10.startsWith("/raw/")) {
                    str = "android.resource://" + context.getPackageName() + a10;
                } else {
                    str = "android.resource://" + context.getPackageName() + "/raw/" + a10;
                }
                parse = Uri.parse(str);
            }
            builder.setSound(parse);
        }
        if (notificationConfigure != null) {
            notificationConfigure.configBuilder(builder, pushData);
        }
        return builder.build();
    }

    public static CustomNotificationBuilder getInstance() {
        if (f٦٧٤٤c == null) {
            f٦٧٤٤c = new CustomNotificationBuilder();
        }
        return f٦٧٤٤c;
    }

    public boolean setCustomNotification(int i10, BasicCustomPushNotification basicCustomPushNotification) {
        AmsLogger amsLogger;
        String str;
        boolean z10 = false;
        if (i10 <= 0) {
            amsLogger = f٦٧٤٣a;
            str = "custom notification id must be an integer greater than 0";
        } else {
            if (basicCustomPushNotification != null) {
                SharedPreferences j10 = com.alibaba.sdk.android.ams.common.a.a.j();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(basicCustomPushNotification);
                    String encode = URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    SharedPreferences.Editor edit = j10.edit();
                    edit.putString(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, encode);
                    edit.commit();
                    z10 = true;
                } catch (IOException e10) {
                    f٦٧٤٣a.e("get custom notification failed", e10);
                }
                if (z10) {
                    if (this.f٦٧٤٥b.containsKey(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10)) {
                        this.f٦٧٤٥b.remove(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10);
                    }
                    f٦٧٤٣a.d("save the notification to cache");
                    this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification);
                }
                return z10;
            }
            amsLogger = f٦٧٤٣a;
            str = "notification cannot be null";
        }
        amsLogger.e(str);
        return false;
    }

    private Bitmap b(Context context, b bVar) {
        int i10;
        Bitmap a10 = !TextUtils.isEmpty(bVar.r()) ? com.alibaba.sdk.android.push.f.a.a(context, bVar.r(), "image") : null;
        if (a10 == null) {
            if (com.alibaba.sdk.android.push.common.a.b.b() != null) {
                a10 = com.alibaba.sdk.android.push.common.a.b.b();
            } else {
                int identifier = context.getResources().getIdentifier(NOTIFICATION_LARGE_ICON_FILE, NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
                if (identifier != 0) {
                    a10 = a(context.getResources().getDrawable(identifier));
                }
            }
        }
        if (a10 != null) {
            return a10;
        }
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e10) {
            f٦٧٤٣a.e("Get system icon error, package name not found, ", e10);
            i10 = R.drawable.stat_notify_chat;
        }
        return a(context.getResources().getDrawable(i10));
    }

    public Notification a(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        if (2 == bVar.g()) {
            return b(context, bVar, pushData, notificationConfigure);
        }
        if (3 == bVar.g()) {
            return c(context, bVar, pushData, notificationConfigure);
        }
        return null;
    }

    private Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public BasicCustomPushNotification a(int i10) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        BasicCustomPushNotification basicCustomPushNotification;
        if (this.f٦٧٤٥b.containsKey(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10)) {
            f٦٧٤٣a.d("find custom notification from cache");
            return (BasicCustomPushNotification) this.f٦٧٤٥b.get(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10);
        }
        f٦٧٤٣a.d("do not find custom notification from cache, find it from SharedPreferences");
        BasicCustomPushNotification basicCustomPushNotification2 = null;
        String string = com.alibaba.sdk.android.ams.common.a.a.j().getString(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, null);
        try {
            if (string == null) {
                f٦٧٤٣a.e("no corresponding custom notificaiton");
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(string, "UTF-8").getBytes("ISO-8859-1"));
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                basicCustomPushNotification = (BasicCustomPushNotification) objectInputStream.readObject();
            } catch (OptionalDataException e10) {
                e = e10;
            } catch (StreamCorruptedException e11) {
                e = e11;
            } catch (UnsupportedEncodingException e12) {
                e = e12;
            } catch (IOException e13) {
                e = e13;
            } catch (ClassNotFoundException e14) {
                e = e14;
            }
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                f٦٧٤٣a.d(basicCustomPushNotification.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification);
                return basicCustomPushNotification;
            } catch (OptionalDataException e15) {
                e = e15;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f٦٧٤٣a.e("get custom notification failed", e);
                f٦٧٤٣a.d(basicCustomPushNotification2.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (StreamCorruptedException e16) {
                e = e16;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f٦٧٤٣a.e("get custom notification failed", e);
                f٦٧٤٣a.d(basicCustomPushNotification2.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (UnsupportedEncodingException e17) {
                e = e17;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f٦٧٤٣a.e("get custom notification failed", e);
                f٦٧٤٣a.d(basicCustomPushNotification2.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (IOException e18) {
                e = e18;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f٦٧٤٣a.e("get custom notification failed", e);
                f٦٧٤٣a.d(basicCustomPushNotification2.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (ClassNotFoundException e19) {
                e = e19;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f٦٧٤٣a.e("get custom notification failed", e);
                f٦٧٤٣a.d(basicCustomPushNotification2.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (Throwable unused) {
                basicCustomPushNotification2 = basicCustomPushNotification;
                f٦٧٤٣a.d(basicCustomPushNotification2.toString());
                this.f٦٧٤٥b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i10, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            }
        } catch (Throwable unused2) {
        }
    }
}
