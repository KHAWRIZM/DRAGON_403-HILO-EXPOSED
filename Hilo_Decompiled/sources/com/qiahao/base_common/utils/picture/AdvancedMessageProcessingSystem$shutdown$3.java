package com.qiahao.base_common.utils.picture;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem$shutdown$3", f = "AdvancedMessageProcessingSystem.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nAdvancedMessageProcessingSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdvancedMessageProcessingSystem.kt\ncom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem$shutdown$3\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,250:1\n12637#2,2:251\n*S KotlinDebug\n*F\n+ 1 AdvancedMessageProcessingSystem.kt\ncom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem$shutdown$3\n*L\n165#1:251,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystem$shutdown$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdvancedMessageProcessingSystem<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedMessageProcessingSystem$shutdown$3(AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem, Continuation<? super AdvancedMessageProcessingSystem$shutdown$3> continuation) {
        super(2, continuation);
        this.this$0 = advancedMessageProcessingSystem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvancedMessageProcessingSystem$shutdown$3(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Channel[] channelArr;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0 && i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        do {
            channelArr = ((AdvancedMessageProcessingSystem) this.this$0).priorityChannels;
            for (Channel channel : channelArr) {
                if (!channel.isEmpty()) {
                    this.label = 1;
                }
            }
            return Unit.INSTANCE;
        } while (DelayKt.delay(100L, this) != coroutine_suspended);
        return coroutine_suspended;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdvancedMessageProcessingSystem$shutdown$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
