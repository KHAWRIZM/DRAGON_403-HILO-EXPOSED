package com.oudi.core.vm.repository;

import com.oudi.core.model.SuperResponse;
import com.oudi.core.vm.adapter.ResponseAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.vm.repository.SuperRepository$flowApi$1", f = "SuperRepository.kt", i = {0}, l = {62, 64}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperRepository$flowApi$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseAdapter $adapter;
    final /* synthetic */ Function1<Continuation<? super SuperResponse<? extends T>>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperRepository$flowApi$1(Function1<? super Continuation<? super SuperResponse<? extends T>>, ? extends Object> function1, ResponseAdapter responseAdapter, Continuation<? super SuperRepository$flowApi$1> continuation) {
        super(2, continuation);
        this.$block = function1;
        this.$adapter = responseAdapter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuperRepository$flowApi$1 superRepository$flowApi$1 = new SuperRepository$flowApi$1(this.$block, this.$adapter, continuation);
        superRepository$flowApi$1.L$0 = obj;
        return superRepository$flowApi$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            Function1<Continuation<? super SuperResponse<? extends T>>, Object> function1 = this.$block;
            this.L$0 = flowCollector;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Object responseBody = this.$adapter.getResponseBody((SuperResponse) obj);
        this.L$0 = null;
        this.label = 2;
        if (flowCollector.emit(responseBody, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return ((SuperRepository$flowApi$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
