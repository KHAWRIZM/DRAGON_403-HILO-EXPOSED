package com.qiahao.base_common.utils.picture;

import com.facebook.share.internal.ShareConstants;
import com.qiahao.base_common.model.MessageTaskData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "T", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Lcom/qiahao/base_common/model/MessageTaskData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem$start$2$1$1$1$1", f = "AdvancedMessageProcessingSystem.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class AdvancedMessageProcessingSystem$start$2$1$1$1$1<T> extends SuspendLambda implements Function2<MessageTaskData<T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $priority;
    final /* synthetic */ int $workerId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AdvancedMessageProcessingSystem<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdvancedMessageProcessingSystem$start$2$1$1$1$1(AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem, int i10, int i11, Continuation<? super AdvancedMessageProcessingSystem$start$2$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = advancedMessageProcessingSystem;
        this.$workerId = i10;
        this.$priority = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AdvancedMessageProcessingSystem$start$2$1$1$1$1 advancedMessageProcessingSystem$start$2$1$1$1$1 = new AdvancedMessageProcessingSystem$start$2$1$1$1$1(this.this$0, this.$workerId, this.$priority, continuation);
        advancedMessageProcessingSystem$start$2$1$1$1$1.L$0 = obj;
        return advancedMessageProcessingSystem$start$2$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(MessageTaskData<T> messageTaskData, Continuation<? super Unit> continuation) {
        return ((AdvancedMessageProcessingSystem$start$2$1$1$1$1) create(messageTaskData, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object processMessage;
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
            MessageTaskData messageTaskData = (MessageTaskData) this.L$0;
            AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem = this.this$0;
            int i11 = this.$workerId;
            int i12 = this.$priority;
            this.label = 1;
            processMessage = advancedMessageProcessingSystem.processMessage(messageTaskData, i11, i12, this);
            if (processMessage == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
