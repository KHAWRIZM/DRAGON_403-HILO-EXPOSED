package com.qiahao.nextvideo.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/service/ChatRoomServiceConnection;", "Landroid/content/ServiceConnection;", "<init>", "()V", "iChatRoomService", "Lcom/qiahao/nextvideo/service/IChatRoomService;", "getIChatRoomService", "()Lcom/qiahao/nextvideo/service/IChatRoomService;", "setIChatRoomService", "(Lcom/qiahao/nextvideo/service/IChatRoomService;)V", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatRoomServiceConnection implements ServiceConnection {

    @Nullable
    private IChatRoomService iChatRoomService;

    @Nullable
    public final IChatRoomService getIChatRoomService() {
        return this.iChatRoomService;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(@NotNull ComponentName name, @NotNull IBinder service) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(service, "service");
        if (service instanceof IChatRoomService) {
            this.iChatRoomService = (IChatRoomService) service;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(@Nullable ComponentName name) {
        IChatRoomService iChatRoomService = this.iChatRoomService;
        if (iChatRoomService == null) {
            return;
        }
        if (iChatRoomService != null) {
            iChatRoomService.onNotificationState(true);
        }
        this.iChatRoomService = null;
    }

    public final void setIChatRoomService(@Nullable IChatRoomService iChatRoomService) {
        this.iChatRoomService = iChatRoomService;
    }
}
