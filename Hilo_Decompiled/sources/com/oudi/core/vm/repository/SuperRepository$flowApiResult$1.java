package com.oudi.core.vm.repository;

import com.oudi.core.model.SuperResponse;
import com.oudi.core.model.SuperResult;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/oudi/core/model/SuperResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.vm.repository.SuperRepository$flowApiResult$1", f = "SuperRepository.kt", i = {}, l = {84, 84}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperRepository$flowApiResult$1<T> extends SuspendLambda implements Function2<FlowCollector<? super SuperResult<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseAdapter $adapter;
    final /* synthetic */ Function1<Continuation<? super SuperResponse<? extends T>>, Object> $block;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperRepository$flowApiResult$1(ResponseAdapter responseAdapter, Function1<? super Continuation<? super SuperResponse<? extends T>>, ? extends Object> function1, Continuation<? super SuperRepository$flowApiResult$1> continuation) {
        super(2, continuation);
        this.$adapter = responseAdapter;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuperRepository$flowApiResult$1 superRepository$flowApiResult$1 = new SuperRepository$flowApiResult$1(this.$adapter, this.$block, continuation);
        superRepository$flowApiResult$1.L$0 = obj;
        return superRepository$flowApiResult$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ResponseAdapter responseAdapter;
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
            responseAdapter = (ResponseAdapter) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            responseAdapter = this.$adapter;
            Function1<Continuation<? super SuperResponse<? extends T>>, Object> function1 = this.$block;
            this.L$0 = flowCollector2;
            this.L$1 = responseAdapter;
            this.label = 1;
            Object invoke = function1.invoke(this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
            obj = invoke;
        }
        SuperResult<T> responseToResult = responseAdapter.responseToResult((SuperResponse) obj);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (flowCollector.emit(responseToResult, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super SuperResult<? extends T>> flowCollector, Continuation<? super Unit> continuation) {
        return ((SuperRepository$flowApiResult$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
