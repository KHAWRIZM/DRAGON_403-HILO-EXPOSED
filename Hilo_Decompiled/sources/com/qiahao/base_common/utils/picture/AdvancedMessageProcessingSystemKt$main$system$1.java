package com.qiahao.base_common.utils.picture;

import com.facebook.share.internal.ShareConstants;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.MessageTaskData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "Lcom/qiahao/base_common/model/MessageTaskData;", "", "workerId", "", "priority"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystemKt$main$system$1", f = "AdvancedMessageProcessingSystem.kt", i = {0, 0}, l = {226}, m = "invokeSuspend", n = {ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "workerId"}, s = {"L$0", "I$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystemKt$main$system$1 extends SuspendLambda implements Function4<MessageTaskData<String>, Integer, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdvancedMessageProcessingSystemKt$main$system$1(Continuation<? super AdvancedMessageProcessingSystemKt$main$system$1> continuation) {
        super(4, continuation);
    }

    public final Object invoke(MessageTaskData<String> messageTaskData, int i10, int i11, Continuation<? super Unit> continuation) {
        AdvancedMessageProcessingSystemKt$main$system$1 advancedMessageProcessingSystemKt$main$system$1 = new AdvancedMessageProcessingSystemKt$main$system$1(continuation);
        advancedMessageProcessingSystemKt$main$system$1.L$0 = messageTaskData;
        advancedMessageProcessingSystemKt$main$system$1.I$0 = i10;
        return advancedMessageProcessingSystemKt$main$system$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MessageTaskData messageTaskData;
        int i10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                i10 = this.I$0;
                messageTaskData = (MessageTaskData) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            messageTaskData = (MessageTaskData) this.L$0;
            int i12 = this.I$0;
            this.L$0 = messageTaskData;
            this.I$0 = i12;
            this.label = 1;
            if (DelayKt.delay(100L, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            i10 = i12;
        }
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "自定义处理: Worker " + i10 + " 处理订单 " + messageTaskData.getId(), false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(MessageTaskData<String> messageTaskData, Integer num, Integer num2, Continuation<? super Unit> continuation) {
        return invoke(messageTaskData, num.intValue(), num2.intValue(), continuation);
    }
}
