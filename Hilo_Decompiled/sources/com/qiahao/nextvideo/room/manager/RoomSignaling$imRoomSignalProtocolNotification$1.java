package com.qiahao.nextvideo.room.manager;

import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.manager.RoomSignaling", f = "RoomSignaling.kt", i = {}, l = {UserProxyUtility.roomOnLine, 202, 234, 801}, m = "imRoomSignalProtocolNotification", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomSignaling$imRoomSignalProtocolNotification$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomSignaling this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomSignaling$imRoomSignalProtocolNotification$1(RoomSignaling roomSignaling, Continuation<? super RoomSignaling$imRoomSignalProtocolNotification$1> continuation) {
        super(continuation);
        this.this$0 = roomSignaling;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.imRoomSignalProtocolNotification(null, this);
    }
}
