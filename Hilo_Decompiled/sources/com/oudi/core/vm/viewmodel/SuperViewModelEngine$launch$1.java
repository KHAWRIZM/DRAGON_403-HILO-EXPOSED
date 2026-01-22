package com.oudi.core.vm.viewmodel;

import com.oudi.core.loading.ILoading;
import com.oudi.core.loading.ILoadingKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launch$1", f = "SuperViewModelEngine.kt", i = {0, 2}, l = {124, 126, 128}, m = "invokeSuspend", n = {"$this$launch", "e"}, s = {"L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperViewModelEngine$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Function2<Exception, Continuation<? super Unit>, Object> $catch;
    final /* synthetic */ ILoading $loading;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperViewModelEngine$launch$1(ILoading iLoading, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Function2<? super Exception, ? super Continuation<? super Unit>, ? extends Object> function22, Continuation<? super SuperViewModelEngine$launch$1> continuation) {
        super(2, continuation);
        this.$loading = iLoading;
        this.$block = function2;
        this.$catch = function22;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuperViewModelEngine$launch$1 superViewModelEngine$launch$1 = new SuperViewModelEngine$launch$1(this.$loading, this.$block, this.$catch, continuation);
        superViewModelEngine$launch$1.L$0 = obj;
        return superViewModelEngine$launch$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        try {
        } catch (Exception e10) {
            Function2<Exception, Continuation<? super Unit>, Object> function2 = this.$catch;
            if (function2 != null) {
                this.L$0 = e10;
                this.label = 3;
                if (function2.invoke(e10, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                e10.printStackTrace();
            }
        }
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            ILoading iLoading = this.$loading;
            Integer boxInt = Boxing.boxInt(coroutineScope.hashCode());
            this.L$0 = coroutineScope;
            this.label = 1;
            if (ILoadingKt.showLoadingInCoroutine$default(iLoading, boxInt, null, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Function2<CoroutineScope, Continuation<? super Unit>, Object> function22 = this.$block;
        this.L$0 = null;
        this.label = 2;
        if (function22.invoke(coroutineScope, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuperViewModelEngine$launch$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
