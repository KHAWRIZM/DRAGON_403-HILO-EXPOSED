package com.qiahao.nextvideo.utilities.alicloud.push;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Vibrator;
import android.provider.Settings;
import android.util.Log;
import androidx.core.app.o;
import androidx.core.app.r;
import androidx.core.content.a;
import com.alibaba.sdk.android.push.AliyunMessageIntentService;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.p;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.utilities.ColorUtility;
import com.qiahao.nextvideo.utilities.NotificationKt;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import la.b;
import na.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0012H\u0014J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J(\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0014J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u000fH\u0014JL\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u00122\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/push/HiloAliyunMessageIntentService;", "Lcom/alibaba/sdk/android/push/AliyunMessageIntentService;", "<init>", "()V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "onNotification", "", "context", "Landroid/content/Context;", "title", "", "summary", "extraMap", "", "onMessage", "cPushMessage", "Lcom/alibaba/sdk/android/push/notification/CPushMessage;", "onNotificationOpened", "onNotificationClickedWithNoAction", "onNotificationRemoved", "messageId", "onNotificationReceivedInApp", "openType", "", "openActivity", "openUrl", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloAliyunMessageIntentService extends AliyunMessageIntentService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "MyMessageIntentService";

    @NotNull
    private static final b hiloAssistantOrSystemInformationEventRelay;

    @NotNull
    private CoroutineScope coroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/push/HiloAliyunMessageIntentService$Companion;", "", "<init>", "()V", "Lla/b;", "", "kotlin.jvm.PlatformType", "hiloAssistantOrSystemInformationEventRelay", "Lla/b;", "getHiloAssistantOrSystemInformationEventRelay", "()Lla/b;", "", "TAG", "Ljava/lang/String;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b getHiloAssistantOrSystemInformationEventRelay() {
            return HiloAliyunMessageIntentService.hiloAssistantOrSystemInformationEventRelay;
        }

        private Companion() {
        }
    }

    static {
        b e = b.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        hiloAssistantOrSystemInformationEventRelay = e;
    }

    @NotNull
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    protected void onMessage(@NotNull Context context, @NotNull CPushMessage cPushMessage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cPushMessage, "cPushMessage");
        BuildersKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new HiloAliyunMessageIntentService$onMessage$1(null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onNotification(@NotNull Context context, @NotNull String title, @NotNull String summary, @NotNull Map<String, String> extraMap) {
        Vibrator vibrator;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Log.i(TAG, "onNotification ：  : " + title + " : " + summary + " : " + extraMap);
        if (ActivityLifecycleManager.INSTANCE.isAppOnBackground()) {
            r d = r.d(context);
            Intrinsics.checkNotNullExpressionValue(d, "from(...)");
            o.e eVar = new o.e(context, NotificationKt.NOTIFICATION_CHANNEL_ID);
            int i = Build.VERSION.SDK_INT;
            if (i >= 26) {
                e.a();
                NotificationChannel a = com.google.android.gms.common.e.a(NotificationKt.NOTIFICATION_CHANNEL_ID, "com.qiahao.nextvideo_channel", 4);
                a.setDescription("com.qiahao.nextvideo_channel_description");
                d.c(a);
            }
            o.e y = eVar.k(-1).B(System.currentTimeMillis()).j(title).i(summary).y("Hilo");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            Drawable drawable = ResourceUtilsKt.getDrawable(resources, R.mipmap.ic_launcher, 0);
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            y.n(((BitmapDrawable) drawable).getBitmap()).t(2).e(true).h(NotificationKt.makeMoodIntent(context, "CALL_UNION_USER", 0)).z(new long[]{1000, 1000, 1000, 1000, 1000}).w(Settings.System.DEFAULT_NOTIFICATION_URI).o(ColorUtility.INSTANCE.getPrimaryColor(), 1000, HonorResultCode.ADVANCED_RECORD_SUCCESS).t(2);
            Object systemService = context.getSystemService("vibrator");
            if (systemService instanceof Vibrator) {
                vibrator = (Vibrator) systemService;
            } else {
                vibrator = null;
            }
            if (i >= 26) {
                if (vibrator != null) {
                    p.a(vibrator, com.oudi.utils.o.a(800L, -1));
                }
            } else if (vibrator != null) {
                vibrator.vibrate(800L);
            }
            eVar.v(R.drawable.ic_status_bar_icon);
            eVar.g(0);
            if (a.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
                return;
            }
            d.f(NotificationKt.getNOTIFICATION_MAX_ID().getAndDecrement(), eVar.b());
        }
    }

    protected void onNotificationClickedWithNoAction(@NotNull Context context, @NotNull String title, @NotNull String summary, @NotNull String extraMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Log.i(TAG, "onNotificationClickedWithNoAction ：  : " + title + " : " + summary + " : " + extraMap);
    }

    protected void onNotificationOpened(@NotNull Context context, @NotNull String title, @NotNull String summary, @NotNull String extraMap) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Log.i(TAG, "onNotificationOpened ：  : " + title + " : " + summary + " : " + extraMap);
    }

    protected void onNotificationReceivedInApp(@NotNull Context context, @NotNull String title, @NotNull String summary, @NotNull Map<String, String> extraMap, int openType, @NotNull String openActivity, @NotNull String openUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(extraMap, "extraMap");
        Intrinsics.checkNotNullParameter(openActivity, "openActivity");
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
    }

    protected void onNotificationRemoved(@NotNull Context context, @NotNull String messageId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        Log.i(TAG, "onNotificationRemoved ： " + messageId);
    }

    public final void setCoroutineScope(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.coroutineScope = coroutineScope;
    }
}
