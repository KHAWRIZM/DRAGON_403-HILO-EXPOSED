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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.loading.ILoadingKt$showLoadingInMain$1", f = "ILoading.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ILoadingKt$showLoadingInMain$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $id;
    final /* synthetic */ CharSequence $message;
    final /* synthetic */ ILoading $this_showLoadingInMain;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ILoadingKt$showLoadingInMain$1(ILoading iLoading, Integer num, CharSequence charSequence, Continuation<? super ILoadingKt$showLoadingInMain$1> continuation) {
        super(2, continuation);
        this.$this_showLoadingInMain = iLoading;
        this.$id = num;
        this.$message = charSequence;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ILoadingKt$showLoadingInMain$1(this.$this_showLoadingInMain, this.$id, this.$message, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ILoading iLoading = this.$this_showLoadingInMain;
            if (iLoading != null) {
                iLoading.showLoading(this.$id, this.$message);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ILoadingKt$showLoadingInMain$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
