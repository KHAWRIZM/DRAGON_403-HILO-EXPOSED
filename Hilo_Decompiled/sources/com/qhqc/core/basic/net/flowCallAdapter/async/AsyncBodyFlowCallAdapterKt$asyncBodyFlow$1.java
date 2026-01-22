package com.qhqc.core.basic.net.flowCallAdapter.async;

import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.basic.net.flowCallAdapter.async.AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1", f = "AsyncBodyFlowCallAdapter.kt", i = {0, 2}, l = {58, 42, 45}, m = "invokeSuspend", n = {"$this$flow", "e"}, s = {"L$0", "L$0"})
@SourceDebugExtension({"SMAP\nAsyncBodyFlowCallAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncBodyFlowCallAdapter.kt\ncom/qhqc/core/basic/net/flowCallAdapter/async/AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,57:1\n318#2,11:58\n*S KotlinDebug\n*F\n+ 1 AsyncBodyFlowCallAdapter.kt\ncom/qhqc/core/basic/net/flowCallAdapter/async/AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1\n*L\n24#1:58,11\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Call<R> $call;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1(Call<R> call, Continuation<? super AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1> continuation) {
        super(2, continuation);
        this.$call = call;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1 asyncBodyFlowCallAdapterKt$asyncBodyFlow$1 = new AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1(this.$call, continuation);
        asyncBodyFlowCallAdapterKt$asyncBodyFlow$1.L$0 = obj;
        return asyncBodyFlowCallAdapterKt$asyncBodyFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
        } catch (Exception e10) {
            this.L$0 = e10;
            this.L$1 = null;
            this.label = 3;
            Dispatchers.getDefault().dispatch(getContext(), new Runnable() { // from class: com.qhqc.core.basic.net.flowCallAdapter.async.AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1$3$1
                @Override // java.lang.Runnable
                public final void run() {
                    Continuation intercepted = IntrinsicsKt.intercepted(this);
                    Result.Companion companion = Result.INSTANCE;
                    intercepted.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(e10)));
                }
            });
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (coroutine_suspended2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (coroutine_suspended2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    throw new KotlinNothingValueException();
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
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
            final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
            cancellableContinuationImpl.initCancellability();
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.qhqc.core.basic.net.flowCallAdapter.async.AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1$1$1
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
            call.enqueue(new Callback<R>() { // from class: com.qhqc.core.basic.net.flowCallAdapter.async.AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1$1$2
                public void onFailure(@NotNull Call<R> call2, @NotNull Throwable t10) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(t10, "t");
                    CancellableContinuation<R> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(t10)));
                }

                public void onResponse(@NotNull Call<R> call2, @NotNull Response<R> response) {
                    Intrinsics.checkNotNullParameter(call2, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSuccessful()) {
                        CancellableContinuation<R> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.INSTANCE;
                        Object body = response.body();
                        Intrinsics.checkNotNull(body);
                        cancellableContinuation.resumeWith(Result.m٥٤٤constructorimpl(body));
                        return;
                    }
                    CancellableContinuation<R> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.INSTANCE;
                    cancellableContinuation2.resumeWith(Result.m٥٤٤constructorimpl(ResultKt.createFailure(new HttpException(response))));
                }
            });
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
        return ((AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
