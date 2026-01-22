package com.qiahao.nextvideo.data.service.match;

import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketKtKt$handleRoomMessageReceiver$2", f = "WebSocketKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class WebSocketKtKt$handleRoomMessageReceiver$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ RoomMessageMulti $messageData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebSocketKtKt$handleRoomMessageReceiver$2(RoomMessageMulti roomMessageMulti, Continuation<? super WebSocketKtKt$handleRoomMessageReceiver$2> continuation) {
        super(2, continuation);
        this.$messageData = roomMessageMulti;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebSocketKtKt$handleRoomMessageReceiver$2(this.$messageData, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (meetingRoomManager.isRoomOpen()) {
                return Boxing.boxBoolean(meetingRoomManager.getWsFlow().tryEmit(new RoomEvent().roomEvent(RoomEvent.ROOM_MESSAGE_RECEIVER, this.$messageData)));
            }
            if (meetingRoomManager.getMRoomMessageData().size() > 300) {
                List<RoomMessageMulti> subList = meetingRoomManager.getMRoomMessageData().subList(100, meetingRoomManager.getMRoomMessageData().size());
                Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
                meetingRoomManager.getMRoomMessageData().clear();
                meetingRoomManager.getMRoomMessageData().addAll(subList);
                meetingRoomManager.addRoomMessage(this.$messageData);
            } else {
                meetingRoomManager.addRoomMessage(this.$messageData);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
