package com.qiahao.nextvideo.service;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.o;
import com.bumptech.glide.Glide;
import com.bumptech.glide.i;
import com.google.android.gms.common.b;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.oudi.core.support.ActivityLifecycleManager;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.MainActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.NotificationKt;
import com.taobao.accs.common.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import na.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J:\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0016\b\u0001\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/service/MyFireBaseMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "<init>", "()V", "onNewToken", "", "token", "", "onMessageReceived", Constants.SHARED_MESSAGE_ID_FILE, "Lcom/google/firebase/messaging/RemoteMessage;", "sendNotification", "title", "messageBody", "data", "", "imageUrl", "Landroid/net/Uri;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyFireBaseMessagingService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyFireBaseMessagingService.kt\ncom/qiahao/nextvideo/service/MyFireBaseMessagingService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n1#2:107\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyFireBaseMessagingService extends FirebaseMessagingService {
    /* JADX WARN: Multi-variable type inference failed */
    private final void sendNotification(String title, String messageBody, Map<String, String> data, Uri imageUrl) {
        String str;
        Activity currentActivity;
        Bitmap bitmap = null;
        String str2 = null;
        bitmap = null;
        if (imageUrl != null) {
            str = imageUrl.toString();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str) && (currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity()) != null) {
            i b = Glide.with(currentActivity).b();
            if (imageUrl != null) {
                str2 = imageUrl.toString();
            }
            bitmap = (Bitmap) b.K0(str2).c().z0(100, 100).get();
        }
        Intent intent = new Intent((Context) this, (Class<?>) MainActivity.class);
        int i = 67108864;
        intent.addFlags(67108864);
        if (data != null) {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : data.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            intent.putExtras(bundle);
        }
        if (!HiloUtils.INSTANCE.checkVersion(31)) {
            i = 1073741824;
        }
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, i);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        o.e v = new o.e(this, NotificationKt.NOTIFICATION_CHANNEL_ID).v(R.mipmap.ic_launcher);
        if (TextUtils.isEmpty(title)) {
            title = getString(2131952013);
        }
        o.e h = v.j(title).i(messageBody).e(true).w(defaultUri).h(activity);
        Intrinsics.checkNotNullExpressionValue(h, "setContentIntent(...)");
        if (bitmap != null) {
            h.n(bitmap);
        }
        Object systemService = getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            e.a();
            b.a(notificationManager, com.google.android.gms.common.e.a(NotificationKt.NOTIFICATION_CHANNEL_ID, "Hilo Notification", 3));
        }
        notificationManager.notify(0, h.b());
    }

    public void onMessageReceived(@NotNull RemoteMessage message) {
        String str;
        String body;
        Intrinsics.checkNotNullParameter(message, Constants.SHARED_MESSAGE_ID_FILE);
        super.onMessageReceived(message);
        RemoteMessage.Notification notification = message.getNotification();
        String str2 = "";
        if (notification == null || (str = notification.getTitle()) == null) {
            str = "";
        }
        RemoteMessage.Notification notification2 = message.getNotification();
        if (notification2 != null && (body = notification2.getBody()) != null) {
            str2 = body;
        }
        Map<String, String> data = message.getData();
        Uri uri = null;
        if (data.isEmpty()) {
            data = null;
        }
        RemoteMessage.Notification notification3 = message.getNotification();
        if (notification3 != null) {
            uri = notification3.getImageUrl();
        }
        sendNotification(str, str2, data, uri);
    }

    public void onNewToken(@NotNull String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        super.onNewToken(token);
        AppRequestUtils.INSTANCE.uploadToken(token);
    }
}
