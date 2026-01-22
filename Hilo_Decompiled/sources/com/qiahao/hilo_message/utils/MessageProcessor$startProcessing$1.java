package com.qiahao.hilo_message.utils;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.hilo_message.utils.MessageProcessor$startProcessing$1", f = "MessageProcessor.kt", i = {0, 1}, l = {56, 69}, m = "invokeSuspend", n = {"batch", "batch"}, s = {"L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MessageProcessor$startProcessing$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MessageProcessor<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageProcessor$startProcessing$1(MessageProcessor<T> messageProcessor, Continuation<? super MessageProcessor$startProcessing$1> continuation) {
        super(2, continuation);
        this.this$0 = messageProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MessageProcessor$startProcessing$1(this.this$0, continuation);
    }

    /* JADX WARN: Incorrect condition in loop: B:15:0x0055 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0039  */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007e -> B:7:0x0031). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x008f -> B:6:0x0092). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        Channel channel;
        Object processMessages;
        Channel channel2;
        Object obj2;
        boolean z10;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    ?? r12 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    arrayList = r12;
                    arrayList.clear();
                    z10 = this.this$0.isProcessing;
                    if (!z10) {
                        this.L$0 = arrayList;
                        this.label = 1;
                        if (DelayKt.delay(100L, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Ref.IntRef intRef = new Ref.IntRef();
                        while (!channel.isEmpty() && intRef.element < 100) {
                            channel2 = this.this$0.messageChannel;
                            obj2 = ChannelResult.m٢١٧٦getOrNullimpl(channel2.mo٢١٩٣tryReceivePtdJZtk());
                            if (obj2 == null) {
                                arrayList.add(obj2);
                                int i11 = intRef.element;
                                intRef.element = i11 + 1;
                                Boxing.boxInt(i11);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            MessageProcessor messageProcessor = this.this$0;
                            ArrayList arrayList2 = new ArrayList(arrayList);
                            this.L$0 = arrayList;
                            this.label = 2;
                            processMessages = messageProcessor.processMessages(arrayList2, this);
                            if (processMessages == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            arrayList.clear();
                        }
                        z10 = this.this$0.isProcessing;
                        if (!z10) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ?? r13 = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                arrayList = r13;
                Ref.IntRef intRef2 = new Ref.IntRef();
                while (!channel.isEmpty()) {
                    channel2 = this.this$0.messageChannel;
                    obj2 = ChannelResult.m٢١٧٦getOrNullimpl(channel2.mo٢١٩٣tryReceivePtdJZtk());
                    if (obj2 == null) {
                    }
                }
                if (!arrayList.isEmpty()) {
                }
                z10 = this.this$0.isProcessing;
                if (!z10) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            arrayList = new ArrayList();
            z10 = this.this$0.isProcessing;
            if (!z10) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MessageProcessor$startProcessing$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
