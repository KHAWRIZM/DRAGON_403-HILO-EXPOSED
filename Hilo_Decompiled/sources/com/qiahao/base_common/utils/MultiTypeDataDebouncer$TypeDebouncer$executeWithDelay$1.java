package com.qiahao.base_common.utils;

import com.qiahao.base_common.utils.MultiTypeDataDebouncer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qiahao.base_common.utils.MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1", f = "MultiTypeDataDebouncer.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiTypeDataDebouncer.TypeDebouncer<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1(MultiTypeDataDebouncer.TypeDebouncer<T> typeDebouncer, Continuation<? super MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1> continuation) {
        super(2, continuation);
        this.this$0 = typeDebouncer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AtomicBoolean atomicBoolean;
        long j10;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
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
            atomicBoolean = ((MultiTypeDataDebouncer.TypeDebouncer) this.this$0).isExecuting;
            atomicBoolean.set(true);
            j10 = ((MultiTypeDataDebouncer.TypeDebouncer) this.this$0).delay;
            this.label = 1;
            if (DelayKt.delay(j10, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.this$0.executeDataProcessing();
        atomicBoolean2 = ((MultiTypeDataDebouncer.TypeDebouncer) this.this$0).hasPendingData;
        if (atomicBoolean2.get()) {
            this.this$0.executeWithDelay();
        } else {
            atomicBoolean3 = ((MultiTypeDataDebouncer.TypeDebouncer) this.this$0).isExecuting;
            atomicBoolean3.set(false);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiTypeDataDebouncer$TypeDebouncer$executeWithDelay$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
