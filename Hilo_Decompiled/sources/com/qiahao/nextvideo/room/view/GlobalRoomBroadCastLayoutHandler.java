package com.qiahao.nextvideo.room.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayoutHandler;", "Landroid/os/Handler;", "globalRoomBroadCastLayout", "Lcom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayout;", "<init>", "(Lcom/qiahao/nextvideo/room/view/GlobalRoomBroadCastLayout;)V", "mGlobalRoomBroadCastLayout", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalRoomBroadCastLayoutHandler extends Handler {

    @NotNull
    private final WeakReference<GlobalRoomBroadCastLayout> mGlobalRoomBroadCastLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalRoomBroadCastLayoutHandler(@NotNull GlobalRoomBroadCastLayout globalRoomBroadCastLayout) {
        super(Looper.getMainLooper());
        Intrinsics.checkNotNullParameter(globalRoomBroadCastLayout, "globalRoomBroadCastLayout");
        this.mGlobalRoomBroadCastLayout = new WeakReference<>(globalRoomBroadCastLayout);
    }

    @Override // android.os.Handler
    public void handleMessage(@NotNull Message msg) {
        GlobalRoomBroadCastLayout globalRoomBroadCastLayout;
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.handleMessage(msg);
        if (msg.what == 1 && (globalRoomBroadCastLayout = this.mGlobalRoomBroadCastLayout.get()) != null) {
            globalRoomBroadCastLayout.showBroadCastView();
        }
    }
}
