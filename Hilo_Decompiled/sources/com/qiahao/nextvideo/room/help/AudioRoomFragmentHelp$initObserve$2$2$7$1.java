package com.qiahao.nextvideo.room.help;

import com.qiahao.nextvideo.utilities.animation.AnimationQueueManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.help.AudioRoomFragmentHelp$initObserve$2$2$7$1", f = "AudioRoomFragmentHelp.kt", i = {}, l = {1752}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class AudioRoomFragmentHelp$initObserve$2$2$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserProxy1.GlobalGameBanner $it1;
    int label;
    final /* synthetic */ AudioRoomFragmentHelp this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioRoomFragmentHelp$initObserve$2$2$7$1(AudioRoomFragmentHelp audioRoomFragmentHelp, UserProxy1.GlobalGameBanner globalGameBanner, Continuation<? super AudioRoomFragmentHelp$initObserve$2$2$7$1> continuation) {
        super(2, continuation);
        this.this$0 = audioRoomFragmentHelp;
        this.$it1 = globalGameBanner;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AudioRoomFragmentHelp$initObserve$2$2$7$1(this.this$0, this.$it1, continuation);
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
            AnimationQueueManager<UserProxy1.GlobalGameBanner> gameManager = this.this$0.getGameManager();
            UserProxy1.GlobalGameBanner globalGameBanner = this.$it1;
            this.label = 1;
            if (gameManager.addData(globalGameBanner, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
