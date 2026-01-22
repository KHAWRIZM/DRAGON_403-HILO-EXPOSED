package com.qiahao.nextvideo.room.manager;

import com.qiahao.base_common.model.MessageTaskData;
import com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.room.manager.RoomSignaling$V2TIMGroupListener$1$onReceiveRESTCustomData$1", f = "RoomSignaling.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class RoomSignaling$V2TIMGroupListener$1$onReceiveRESTCustomData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $customData;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomSignaling$V2TIMGroupListener$1$onReceiveRESTCustomData$1(byte[] bArr, Continuation<? super RoomSignaling$V2TIMGroupListener$1$onReceiveRESTCustomData$1> continuation) {
        super(2, continuation);
        this.$customData = bArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomSignaling$V2TIMGroupListener$1$onReceiveRESTCustomData$1(this.$customData, continuation);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
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
            byte[] bArr = this.$customData;
            if (bArr == null || (str = StringsKt.decodeToString(bArr)) == null) {
                str = "";
            }
            AdvancedMessageProcessingSystem<String> mSystem = RoomSignaling.INSTANCE.getMSystem();
            MessageTaskData messageTaskData = new MessageTaskData(str, str, 1);
            this.label = 1;
            if (mSystem.submitMessage(messageTaskData, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }
}
