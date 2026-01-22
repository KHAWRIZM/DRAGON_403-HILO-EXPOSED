package com.qiahao.nextvideo.data.service.match;

import com.qiahao.base_common.model.MessageTaskData;
import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import okio.ByteString;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", Constants.SHARED_MESSAGE_ID_FILE, "Lcom/qiahao/base_common/model/MessageTaskData;", "Lokio/ByteString;", "workerId", "", "priority"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.nextvideo.data.service.match.WebSocketProvide$mSystem$1", f = "WebSocketProvide.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
final class WebSocketProvide$mSystem$1 extends SuspendLambda implements Function4<MessageTaskData<ByteString>, Integer, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketProvide$mSystem$1(Continuation<? super WebSocketProvide$mSystem$1> continuation) {
        super(4, continuation);
    }

    public final Object invoke(MessageTaskData<ByteString> messageTaskData, int i, int i2, Continuation<? super Unit> continuation) {
        WebSocketProvide$mSystem$1 webSocketProvide$mSystem$1 = new WebSocketProvide$mSystem$1(continuation);
        webSocketProvide$mSystem$1.L$0 = messageTaskData;
        return webSocketProvide$mSystem$1.invokeSuspend(Unit.INSTANCE);
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
            ByteString byteString = (ByteString) ((MessageTaskData) this.L$0).getContent();
            this.label = 1;
            if (WebSocketKtKt.unpack(byteString, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((MessageTaskData<ByteString>) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue(), (Continuation<? super Unit>) obj4);
    }
}
