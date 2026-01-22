package com.qhqc.lib.indicate;

import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", HeaderInterceptor.TOKEN, ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.lib.indicate.IndicateService$getIndicateAsync$3", f = "IndicateService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class IndicateService$getIndicateAsync$3 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $block;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public IndicateService$getIndicateAsync$3(Function1<? super String, Unit> function1, Continuation<? super IndicateService$getIndicateAsync$3> continuation) {
        super(2, continuation);
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IndicateService$getIndicateAsync$3 indicateService$getIndicateAsync$3 = new IndicateService$getIndicateAsync$3(this.$block, continuation);
        indicateService$getIndicateAsync$3.L$0 = obj;
        return indicateService$getIndicateAsync$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = (String) this.L$0;
            this.$block.invoke(str);
            LogUtils.d$default(LogUtils.INSTANCE, "getIndicateSuccess: " + str, null, 2, null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(String str, Continuation<? super Unit> continuation) {
        return ((IndicateService$getIndicateAsync$3) create(str, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
