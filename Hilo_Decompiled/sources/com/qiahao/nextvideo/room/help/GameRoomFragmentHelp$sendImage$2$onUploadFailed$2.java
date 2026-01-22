package com.qiahao.nextvideo.room.help;

import com.qiahao.hilo_message.data.RoomMessageMulti;
import com.qiahao.hilo_message.message.RoomMessageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$sendImage$2$onUploadFailed$2", f = "GameRoomFragmentHelp.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class GameRoomFragmentHelp$sendImage$2$onUploadFailed$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RoomMessageMulti $message;
    int label;
    final /* synthetic */ GameRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRoomFragmentHelp$sendImage$2$onUploadFailed$2(GameRoomFragmentHelp gameRoomFragmentHelp, RoomMessageMulti roomMessageMulti, Continuation<? super GameRoomFragmentHelp$sendImage$2$onUploadFailed$2> continuation) {
        super(2, continuation);
        this.this$0 = gameRoomFragmentHelp;
        this.$message = roomMessageMulti;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameRoomFragmentHelp$sendImage$2$onUploadFailed$2(this.this$0, this.$message, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RoomMessageView mChatLayout = this.this$0.getFragment().getMChatLayout();
            if (mChatLayout != null) {
                mChatLayout.refreshMessageStatus(this.$message);
                return Unit.INSTANCE;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
