package com.alibaba.sdk.android.push.notification;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a extends c {

    /* renamed from: n, reason: collision with root package name */
    private static final AmsLogger f٦٧٤٦n = AmsLogger.getLogger("MPS:BasicNotificationBuilder");

    /* JADX WARN: Removed duplicated region for block: B:36:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c4  */
    @Override // com.alibaba.sdk.android.push.notification.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Notification a(Context context, PushData pushData, NotificationConfigure notificationConfigure) {
        int i10;
        int i11;
        StringBuilder sb;
        String sb2;
        Notification.Style style;
        Bitmap a10 = !TextUtils.isEmpty(this.f٦٧٧٩f) ? com.alibaba.sdk.android.push.f.a.a(context, this.f٦٧٧٩f, "image") : null;
        Bitmap a11 = TextUtils.isEmpty(this.f٦٧٨٣j) ? null : com.alibaba.sdk.android.push.f.a.a(context, this.f٦٧٨٣j, PushData.KEY_BIG_PICTURE);
        if (a10 == null) {
            if (com.alibaba.sdk.android.push.common.a.b.b() != null) {
                a10 = com.alibaba.sdk.android.push.common.a.b.b();
            } else {
                int identifier = context.getResources().getIdentifier(CustomNotificationBuilder.NOTIFICATION_LARGE_ICON_FILE, CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
                if (identifier != 0) {
                    a10 = a(context.getResources().getDrawable(identifier));
                }
            }
        }
        int c10 = com.alibaba.sdk.android.push.common.a.b.c() != 0 ? com.alibaba.sdk.android.push.common.a.b.c() : context.getResources().getIdentifier(CustomNotificationBuilder.NOTIFICATION_SMALL_ICON_FILE, CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e10) {
            f٦٧٤٦n.e("Get system icon error, package name not found, ", e10);
            i10 = R.drawable.stat_notify_chat;
        }
        if (a10 == null) {
            a10 = a(context.getResources().getDrawable(i10));
        }
        if (c10 == 0) {
            c10 = i10;
        }
        String e11 = e();
        String f10 = f();
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(a()).setContentText(b()).setSmallIcon(c10).setPriority(c()).setLargeIcon(a10).setWhen(System.currentTimeMillis()).setTicker("");
        if (!TextUtils.isEmpty(e11)) {
            builder.setGroup(e11);
        } else if (!TextUtils.isEmpty(f10)) {
            builder.setGroup(f10);
        }
        int i12 = this.f٦٧٨٠g;
        if (i12 != 1) {
            if (i12 == 2) {
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle().bigPicture(a11);
                if (!TextUtils.isEmpty(this.f٦٧٨١h)) {
                    bigPicture.setBigContentTitle(this.f٦٧٨١h);
                }
                if (a10 != null) {
                    bigPicture.bigLargeIcon(a10);
                }
                builder.setStyle(bigPicture);
            } else if (i12 == 3) {
                Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                try {
                    JSONArray jSONArray = new JSONArray(this.f٦٧٨٤k);
                    for (int i13 = 0; i13 < jSONArray.length(); i13++) {
                        inboxStyle.addLine(jSONArray.getString(i13));
                    }
                } catch (JSONException e12) {
                    e12.printStackTrace();
                }
                style = inboxStyle;
                if (!TextUtils.isEmpty(this.f٦٧٨١h)) {
                    inboxStyle.setBigContentTitle(this.f٦٧٨١h);
                    style = inboxStyle;
                }
            }
            if (!TextUtils.isEmpty(this.f٦٧٧٨e)) {
                if (this.f٦٧٧٨e.startsWith("android.resource://")) {
                    sb2 = this.f٦٧٧٨e;
                } else {
                    if (this.f٦٧٧٨e.startsWith("/raw/")) {
                        sb = new StringBuilder();
                        sb.append("android.resource://");
                        sb.append(context.getPackageName());
                    } else {
                        sb = new StringBuilder();
                        sb.append("android.resource://");
                        sb.append(context.getPackageName());
                        sb.append("/raw/");
                    }
                    sb.append(this.f٦٧٧٨e);
                    sb2 = sb.toString();
                }
                builder.setSound(Uri.parse(sb2));
            }
            i11 = Build.VERSION.SDK_INT;
            builder.setShowWhen(true);
            if (i11 >= 26 && !TextUtils.isEmpty(d())) {
                builder.setChannelId(d());
            }
            if (notificationConfigure != null) {
                notificationConfigure.configBuilder(builder, pushData);
            }
            return builder.build();
        }
        Notification.BigTextStyle bigText = new Notification.BigTextStyle().bigText(this.f٦٧٨٢i);
        style = bigText;
        if (!TextUtils.isEmpty(this.f٦٧٨١h)) {
            bigText.setBigContentTitle(this.f٦٧٨١h);
            style = bigText;
        }
        builder.setStyle(style);
        if (!TextUtils.isEmpty(this.f٦٧٧٨e)) {
        }
        i11 = Build.VERSION.SDK_INT;
        builder.setShowWhen(true);
        if (i11 >= 26) {
            builder.setChannelId(d());
        }
        if (notificationConfigure != null) {
        }
        return builder.build();
    }

    @Override // com.alibaba.sdk.android.push.notification.c
    public Notification b(Context context, PushData pushData, NotificationConfigure notificationConfigure) {
        int i10;
        String e10 = e();
        String f10 = f();
        if (TextUtils.isEmpty(e10) && TextUtils.isEmpty(f10)) {
            f٦٧٤٦n.d("body group and emas group all empty");
            return null;
        }
        int c10 = com.alibaba.sdk.android.push.common.a.b.c() != 0 ? com.alibaba.sdk.android.push.common.a.b.c() : context.getResources().getIdentifier(CustomNotificationBuilder.NOTIFICATION_SMALL_ICON_FILE, CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
        try {
            i10 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e11) {
            f٦٧٤٦n.e("Get system icon error, package name not found, ", e11);
            i10 = R.drawable.stat_notify_chat;
        }
        if (c10 == 0) {
            c10 = i10;
        }
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(c10);
        if (!TextUtils.isEmpty(e10)) {
            builder.setGroup(e10);
        } else if (!TextUtils.isEmpty(f10)) {
            builder.setGroup(f10);
        }
        builder.setGroupSummary(true);
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
        if (!TextUtils.isEmpty(this.f٦٧٨٤k)) {
            try {
                JSONArray jSONArray = new JSONArray(this.f٦٧٨٤k);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    inboxStyle.addLine(jSONArray.getString(i11));
                }
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        builder.setStyle(inboxStyle);
        if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(d())) {
            builder.setChannelId(d());
        }
        return builder.build();
    }

    private Bitmap a(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }
}
