package com.qhqc.lib.indicate;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.lib.indicate.IndicateService$getIndicateAsync$1", f = "IndicateService.kt", i = {0}, l = {66, 67}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class IndicateService$getIndicateAsync$1 extends SuspendLambda implements Function2<FlowCollector<? super String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ IndicateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndicateService$getIndicateAsync$1(IndicateService indicateService, Continuation<? super IndicateService$getIndicateAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = indicateService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IndicateService$getIndicateAsync$1 indicateService$getIndicateAsync$1 = new IndicateService$getIndicateAsync$1(this.this$0, continuation);
        indicateService$getIndicateAsync$1.L$0 = obj;
        return indicateService$getIndicateAsync$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object buildIndicateInfoSync;
        FlowCollector flowCollector;
        Security security;
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
            Security security2 = (Security) this.L$1;
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            security = security2;
            flowCollector = flowCollector2;
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector3 = (FlowCollector) this.L$0;
            Security security3 = Security.INSTANCE;
            IndicateService indicateService = this.this$0;
            this.L$0 = flowCollector3;
            this.L$1 = security3;
            this.label = 1;
            buildIndicateInfoSync = indicateService.buildIndicateInfoSync(this);
            if (buildIndicateInfoSync == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector3;
            obj = buildIndicateInfoSync;
            security = security3;
        }
        String encryptToken$default = Security.encryptToken$default(security, (String) obj, null, null, 6, null);
        if (encryptToken$default == null) {
            encryptToken$default = "";
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (flowCollector.emit(encryptToken$default, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FlowCollector<? super String> flowCollector, Continuation<? super Unit> continuation) {
        return ((IndicateService$getIndicateAsync$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
