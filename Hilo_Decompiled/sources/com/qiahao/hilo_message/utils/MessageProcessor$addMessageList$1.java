package com.qiahao.hilo_message.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.hilo_message.utils.MessageProcessor$addMessageList$1", f = "MessageProcessor.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nMessageProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MessageProcessor.kt\ncom/qiahao/hilo_message/utils/MessageProcessor$addMessageList$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,91:1\n1869#2,2:92\n*S KotlinDebug\n*F\n+ 1 MessageProcessor.kt\ncom/qiahao/hilo_message/utils/MessageProcessor$addMessageList$1\n*L\n42#1:92,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MessageProcessor$addMessageList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<T> $messageList;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MessageProcessor<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageProcessor$addMessageList$1(List<? extends T> list, MessageProcessor<T> messageProcessor, Continuation<? super MessageProcessor$addMessageList$1> continuation) {
        super(2, continuation);
        this.$messageList = list;
        this.this$0 = messageProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageProcessor$addMessageList$1(this.$messageList, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MessageProcessor messageProcessor;
        Iterator it;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                it = (Iterator) this.L$1;
                messageProcessor = (MessageProcessor) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Collection collection = this.$messageList;
            messageProcessor = this.this$0;
            it = collection.iterator();
        }
        while (it.hasNext()) {
            Object next = it.next();
            Function1 checkContain = messageProcessor.getCheckContain();
            if (checkContain == null || !((Boolean) checkContain.invoke(next)).booleanValue()) {
                channel = messageProcessor.messageChannel;
                this.L$0 = messageProcessor;
                this.L$1 = it;
                this.label = 1;
                if (channel.send(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageProcessor$addMessageList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
