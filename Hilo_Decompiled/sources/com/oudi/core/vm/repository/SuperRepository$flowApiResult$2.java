package com.oudi.core.vm.repository;

import com.oudi.core.model.SuperResult;
import com.oudi.core.vm.adapter.ExceptionConverter;
import com.oudi.core.vm.adapter.ResponseAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/oudi/core/model/SuperResult;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.vm.repository.SuperRepository$flowApiResult$2", f = "SuperRepository.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperRepository$flowApiResult$2<T> extends SuspendLambda implements Function3<FlowCollector<? super SuperResult<? extends T>>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ ResponseAdapter $adapter;
    final /* synthetic */ ExceptionConverter $converter;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperRepository$flowApiResult$2(ResponseAdapter responseAdapter, ExceptionConverter exceptionConverter, Continuation<? super SuperRepository$flowApiResult$2> continuation) {
        super(3, continuation);
        this.$adapter = responseAdapter;
        this.$converter = exceptionConverter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            SuperResult throwableToResult = this.$adapter.throwableToResult(this.$converter.convert((Throwable) this.L$1));
            this.L$0 = null;
            this.label = 1;
            if (flowCollector.emit(throwableToResult, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super SuperResult<? extends T>> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        SuperRepository$flowApiResult$2 superRepository$flowApiResult$2 = new SuperRepository$flowApiResult$2(this.$adapter, this.$converter, continuation);
        superRepository$flowApiResult$2.L$0 = flowCollector;
        superRepository$flowApiResult$2.L$1 = th;
        return superRepository$flowApiResult$2.invokeSuspend(Unit.INSTANCE);
    }
}
