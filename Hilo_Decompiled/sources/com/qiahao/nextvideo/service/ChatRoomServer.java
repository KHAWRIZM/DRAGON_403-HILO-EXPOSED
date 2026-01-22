package com.qiahao.nextvideo.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.core.app.o;
import androidx.core.app.u;
import com.google.android.gms.common.b;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.room.activity.RoomActivity;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.taobao.accs.messenger.MessengerService;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import na.e;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/service/ChatRoomServer;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", MessengerService.INTENT, "Landroid/content/Intent;", "showNotification", "", "getChatRoomNotification", "Landroid/app/Notification;", "context", "Landroid/content/Context;", "ChatRoomBinder", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatRoomServer extends Service {

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/service/ChatRoomServer$ChatRoomBinder;", "Landroid/os/Binder;", "Lcom/qiahao/nextvideo/service/IChatRoomService;", "server", "Lcom/qiahao/nextvideo/service/ChatRoomServer;", "<init>", "(Lcom/qiahao/nextvideo/service/ChatRoomServer;)V", "wf", "Ljava/lang/ref/WeakReference;", "onNotificationState", "", "isShow", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    private static final class ChatRoomBinder extends Binder implements IChatRoomService {

        @Nullable
        private WeakReference<ChatRoomServer> wf;

        public ChatRoomBinder(@NotNull ChatRoomServer chatRoomServer) {
            Intrinsics.checkNotNullParameter(chatRoomServer, "server");
            this.wf = new WeakReference<>(chatRoomServer);
        }

        @Override // com.qiahao.nextvideo.service.IChatRoomService
        public void onNotificationState(boolean isShow) {
            ChatRoomServer chatRoomServer;
            ChatRoomServer chatRoomServer2;
            if (isShow) {
                WeakReference<ChatRoomServer> weakReference = this.wf;
                if (weakReference != null && (chatRoomServer2 = weakReference.get()) != null) {
                    chatRoomServer2.showNotification();
                    return;
                }
                return;
            }
            WeakReference<ChatRoomServer> weakReference2 = this.wf;
            if (weakReference2 != null && (chatRoomServer = weakReference2.get()) != null) {
                chatRoomServer.stopForeground(true);
            }
        }
    }

    private final Notification getChatRoomNotification(Context context) {
        Intent intent;
        String str;
        Object systemService = context.getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int i = 67108864;
        if (!TextUtils.isEmpty(meetingRoomManager.getMGroupId())) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, RoomActivity.SERVICE_OPEN, meetingRoomManager.getMGroupId(), (String) null, 4, (Object) null);
            intent = new Intent(this, (Class<?>) RoomActivity.class);
            intent.addFlags(67108864);
            intent.putExtra(RoomActivity.SERVICE_OPEN, meetingRoomManager.getMGroupId());
        } else {
            intent = null;
        }
        o.e v = new o.e(context, MessageService.MSG_DB_NOTIFY_CLICK).v(R.mipmap.ic_launcher);
        String stringById = ResourcesKtxKt.getStringById(this, 2131953111);
        GroupDetailBean mGroupDetailBean = meetingRoomManager.getMGroupDetailBean();
        if (mGroupDetailBean != null) {
            str = mGroupDetailBean.getCode();
        } else {
            str = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        o.e q = v.j(format).i(ResourcesKtxKt.getStringById(this, 2131954294)).u(false).s(true).q();
        Intrinsics.checkNotNullExpressionValue(q, "setNotificationSilent(...)");
        if (intent != null) {
            if (!HiloUtils.INSTANCE.checkVersion(31)) {
                i = 1073741824;
            }
            PendingIntent activity = PendingIntent.getActivity(this, 0, intent, i);
            Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
            q.h(activity);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            e.a();
            NotificationChannel a = com.google.android.gms.common.e.a(MessageService.MSG_DB_NOTIFY_CLICK, "Room", 3);
            a.setSound(null, null);
            a.setDescription("Room status");
            b.a(notificationManager, a);
        }
        Notification b = q.b();
        Intrinsics.checkNotNullExpressionValue(b, "build(...)");
        return b;
    }

    @Override // android.app.Service
    @NotNull
    public IBinder onBind(@Nullable Intent intent) {
        return new ChatRoomBinder(this);
    }

    public final void showNotification() {
        try {
            Notification chatRoomNotification = getChatRoomNotification(this);
            if (HiloUtils.INSTANCE.checkVersion(30)) {
                if (MeetingRoomManager.INSTANCE.getMicPermission()) {
                    u.a(this, 1, chatRoomNotification, 128);
                }
            } else {
                startForeground(1, chatRoomNotification);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
