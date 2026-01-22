package com.oudi.core.loading;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.loading.ILoadingKt$dismissLoadingInCoroutine$2", f = "ILoading.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ILoadingKt$dismissLoadingInCoroutine$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $id;
    final /* synthetic */ ILoading $this_dismissLoadingInCoroutine;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ILoadingKt$dismissLoadingInCoroutine$2(ILoading iLoading, Integer num, Continuation<? super ILoadingKt$dismissLoadingInCoroutine$2> continuation) {
        super(2, continuation);
        this.$this_dismissLoadingInCoroutine = iLoading;
        this.$id = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ILoadingKt$dismissLoadingInCoroutine$2(this.$this_dismissLoadingInCoroutine, this.$id, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ILoading iLoading = this.$this_dismissLoadingInCoroutine;
            if (iLoading != null) {
                iLoading.dismissLoading(this.$id);
                return Unit.INSTANCE;
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ILoadingKt$dismissLoadingInCoroutine$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
