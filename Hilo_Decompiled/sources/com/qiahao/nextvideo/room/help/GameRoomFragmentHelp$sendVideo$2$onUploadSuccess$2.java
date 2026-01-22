package com.qiahao.nextvideo.room.help;

import com.qiahao.nextvideo.utilities.im.RoomMessageUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import roomMessage.RoomMessage;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$sendVideo$2$onUploadSuccess$2", f = "GameRoomFragmentHelp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class GameRoomFragmentHelp$sendVideo$2$onUploadSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $addMessage;
    final /* synthetic */ RoomMessage.GroupMessageSend $message;
    int label;
    final /* synthetic */ GameRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRoomFragmentHelp$sendVideo$2$onUploadSuccess$2(GameRoomFragmentHelp gameRoomFragmentHelp, RoomMessage.GroupMessageSend groupMessageSend, boolean z, Continuation<? super GameRoomFragmentHelp$sendVideo$2$onUploadSuccess$2> continuation) {
        super(2, continuation);
        this.this$0 = gameRoomFragmentHelp;
        this.$message = groupMessageSend;
        this.$addMessage = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameRoomFragmentHelp$sendVideo$2$onUploadSuccess$2(this.this$0, this.$message, this.$addMessage, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RoomMessageUtil.INSTANCE.sendMessage(this.this$0.getFragment().getMChatLayout(), this.$message, this.$addMessage);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
