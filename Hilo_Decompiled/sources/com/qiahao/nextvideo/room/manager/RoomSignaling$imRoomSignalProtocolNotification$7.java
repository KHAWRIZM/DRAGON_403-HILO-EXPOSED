package com.qiahao.nextvideo.room.manager;

import com.qiahao.base_common.BaseApplication;
import com.qiahao.nextvideo.data.model.MeetingRoomCustomData;
import com.qiahao.nextvideo.data.room.RoomPK;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.manager.RoomSignaling$imRoomSignalProtocolNotification$7", f = "RoomSignaling.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomSignaling$imRoomSignalProtocolNotification$7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MeetingRoomCustomData $roomSignalData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomSignaling$imRoomSignalProtocolNotification$7(MeetingRoomCustomData meetingRoomCustomData, Continuation<? super RoomSignaling$imRoomSignalProtocolNotification$7> continuation) {
        super(2, continuation);
        this.$roomSignalData = meetingRoomCustomData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomSignaling$imRoomSignalProtocolNotification$7(this.$roomSignalData, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.isRoomOpen()) {
                meetingRoomManager.emptyMicInit(10);
            }
            meetingRoomManager.setMPK((RoomPK) BaseApplication.Companion.getGSON().j(this.$roomSignalData.getContent(), RoomPK.class));
            return Boxing.boxBoolean(meetingRoomManager.getWsFlow().tryEmit(RoomEvent.roomEvent$default(new RoomEvent(), RoomEvent.ROOM_PK_MATCH_SUCCESS, null, 2, null)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
