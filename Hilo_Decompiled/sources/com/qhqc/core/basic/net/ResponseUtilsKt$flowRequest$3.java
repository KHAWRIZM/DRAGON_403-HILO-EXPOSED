package com.qhqc.core.basic.net;

import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.net.handler.ExceptionHandler;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.basic.net.ResponseUtilsKt$flowRequest$3", f = "ResponseUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class ResponseUtilsKt$flowRequest$3<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<ApiErrorException, Unit> $onError;
    final /* synthetic */ boolean $throwError;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ResponseUtilsKt$flowRequest$3(Function1<? super ApiErrorException, Unit> function1, boolean z10, Continuation<? super ResponseUtilsKt$flowRequest$3> continuation) {
        super(3, continuation);
        this.$onError = function1;
        this.$throwError = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable th = (Throwable) this.L$0;
            ApiErrorException handleException = ExceptionHandler.INSTANCE.handleException(th);
            Function1<ApiErrorException, Unit> function1 = this.$onError;
            if (function1 != null) {
                function1.invoke(handleException);
            }
            if (!this.$throwError) {
                return Unit.INSTANCE;
            }
            throw th;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, @Nullable Continuation<? super Unit> continuation) {
        ResponseUtilsKt$flowRequest$3 responseUtilsKt$flowRequest$3 = new ResponseUtilsKt$flowRequest$3(this.$onError, this.$throwError, continuation);
        responseUtilsKt$flowRequest$3.L$0 = th;
        return responseUtilsKt$flowRequest$3.invokeSuspend(Unit.INSTANCE);
    }
}
