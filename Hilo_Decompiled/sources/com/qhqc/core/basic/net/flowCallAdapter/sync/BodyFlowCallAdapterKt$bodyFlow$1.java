package com.qhqc.core.basic.net.flowCallAdapter.sync;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.basic.net.flowCallAdapter.sync.BodyFlowCallAdapterKt$bodyFlow$1", f = "BodyFlowCallAdapter.kt", i = {0}, l = {38, 35}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
@SourceDebugExtension({"SMAP\nBodyFlowCallAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BodyFlowCallAdapter.kt\ncom/qhqc/core/basic/net/flowCallAdapter/sync/BodyFlowCallAdapterKt$bodyFlow$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,37:1\n318#2,11:38\n*S KotlinDebug\n*F\n+ 1 BodyFlowCallAdapter.kt\ncom/qhqc/core/basic/net/flowCallAdapter/sync/BodyFlowCallAdapterKt$bodyFlow$1\n*L\n20#1:38,11\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class BodyFlowCallAdapterKt$bodyFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Call<R> $call;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodyFlowCallAdapterKt$bodyFlow$1(Call<R> call, Continuation<? super BodyFlowCallAdapterKt$bodyFlow$1> continuation) {
        super(2, continuation);
        this.$call = call;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BodyFlowCallAdapterKt$bodyFlow$1 bodyFlowCallAdapterKt$bodyFlow$1 = new BodyFlowCallAdapterKt$bodyFlow$1(this.$call, continuation);
        bodyFlowCallAdapterKt$bodyFlow$1.L$0 = obj;
        return bodyFlowCallAdapterKt$bodyFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
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
            final Call<R> call = this.$call;
            this.L$0 = flowCollector;
            this.L$1 = call;
            this.label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.qhqc.core.basic.net.flowCallAdapter.sync.BodyFlowCallAdapterKt$bodyFlow$1$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th) {
                    call.cancel();
                }
            });
            try {
                Response execute = call.execute();
                if (execute.isSuccessful()) {
                    Result.Companion companion = Result.INSTANCE;
                    Object body = execute.body();
                    Intrinsics.checkNotNull(body);
                    cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(body));
                } else {
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(new HttpException(execute))));
                }
            } catch (Exception e10) {
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(e10)));
            }
            obj = cancellableContinuationImpl.getResult();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (flowCollector.emit(obj, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super R> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((BodyFlowCallAdapterKt$bodyFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
