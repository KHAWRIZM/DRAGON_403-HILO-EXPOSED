package com.qiahao.nextvideo.room.help;

import com.qiahao.nextvideo.utilities.animation.AnimationQueueManager;
import com.qiahao.nextvideo.utilities.animation.GiftNoticeUIModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.GameRoomFragmentHelp$dispatchGiftShow$1$2", f = "GameRoomFragmentHelp.kt", i = {}, l = {1980}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GameRoomFragmentHelp$dispatchGiftShow$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GiftNoticeUIModel $giftNoticeUIModel;
    int label;
    final /* synthetic */ GameRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameRoomFragmentHelp$dispatchGiftShow$1$2(GameRoomFragmentHelp gameRoomFragmentHelp, GiftNoticeUIModel giftNoticeUIModel, Continuation<? super GameRoomFragmentHelp$dispatchGiftShow$1$2> continuation) {
        super(2, continuation);
        this.this$0 = gameRoomFragmentHelp;
        this.$giftNoticeUIModel = giftNoticeUIModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GameRoomFragmentHelp$dispatchGiftShow$1$2(this.this$0, this.$giftNoticeUIModel, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AnimationQueueManager<GiftNoticeUIModel> manager = this.this$0.getManager();
            GiftNoticeUIModel giftNoticeUIModel = this.$giftNoticeUIModel;
            this.label = 1;
            if (manager.addData(giftNoticeUIModel, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
