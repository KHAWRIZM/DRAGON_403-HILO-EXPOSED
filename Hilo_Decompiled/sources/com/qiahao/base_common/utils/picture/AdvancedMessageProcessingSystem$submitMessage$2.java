package com.qiahao.base_common.utils.picture;

import com.qiahao.base_common.model.MessageTaskData;
import java.util.concurrent.atomic.AtomicInteger;
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
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem$submitMessage$2", f = "AdvancedMessageProcessingSystem.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystem$submitMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ MessageTaskData<T> $messageTaskData;
    final /* synthetic */ int $priority;
    int label;
    final /* synthetic */ AdvancedMessageProcessingSystem<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedMessageProcessingSystem$submitMessage$2(AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem, int i10, MessageTaskData<T> messageTaskData, Continuation<? super AdvancedMessageProcessingSystem$submitMessage$2> continuation) {
        super(2, continuation);
        this.this$0 = advancedMessageProcessingSystem;
        this.$priority = i10;
        this.$messageTaskData = messageTaskData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvancedMessageProcessingSystem$submitMessage$2(this.this$0, this.$priority, this.$messageTaskData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel[] channelArr;
        AtomicInteger[] atomicIntegerArr;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            channelArr = ((AdvancedMessageProcessingSystem) this.this$0).priorityChannels;
            Channel channel = channelArr[this.$priority];
            Object obj2 = this.$messageTaskData;
            this.label = 1;
            if (channel.send(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        atomicIntegerArr = ((AdvancedMessageProcessingSystem) this.this$0).channelMessageCounts;
        atomicIntegerArr[this.$priority].incrementAndGet();
        return Boxing.boxBoolean(true);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((AdvancedMessageProcessingSystem$submitMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
