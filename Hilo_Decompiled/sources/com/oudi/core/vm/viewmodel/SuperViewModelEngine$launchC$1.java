package com.oudi.core.vm.viewmodel;

import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.component.IDispatchers;
import com.oudi.core.loading.ILoading;
import com.oudi.core.loading.ILoadingKt;
import com.oudi.core.vm.adapter.ExceptionAnalyzer;
import io.agora.rtc.Constants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchC$1", f = "SuperViewModelEngine.kt", i = {0, 1, 2, 2, 3, 4, 4}, l = {Constants.ERR_PUBLISH_STREAM_INTERNAL_SERVER_ERROR, Constants.ERR_PUBLISH_STREAM_FORMAT_NOT_SUPPORTED, 159, 167, 169}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "result", "$this$launch", "$this$launch", "exception"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0", "L$0", "L$1"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperViewModelEngine$launchC$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExceptionAnalyzer $analyzer;
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> $block;
    final /* synthetic */ SuperCallBack<T> $callBack;
    final /* synthetic */ ILoading $loading;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SuperViewModelEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperViewModelEngine$launchC$1(ILoading iLoading, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, SuperCallBack<T> superCallBack, ExceptionAnalyzer exceptionAnalyzer, SuperViewModelEngine superViewModelEngine, Continuation<? super SuperViewModelEngine$launchC$1> continuation) {
        super(2, continuation);
        this.$loading = iLoading;
        this.$block = function2;
        this.$callBack = superCallBack;
        this.$analyzer = exceptionAnalyzer;
        this.this$0 = superViewModelEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuperViewModelEngine$launchC$1 superViewModelEngine$launchC$1 = new SuperViewModelEngine$launchC$1(this.$loading, this.$block, this.$callBack, this.$analyzer, this.this$0, continuation);
        superViewModelEngine$launchC$1.L$0 = obj;
        return superViewModelEngine$launchC$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a1 A[Catch: Exception -> 0x003f, TRY_LEAVE, TryCatch #0 {Exception -> 0x003f, blocks: (B:27:0x003a, B:29:0x0045, B:30:0x007f, B:32:0x0083, B:34:0x0089, B:37:0x009d, B:39:0x00a1, B:41:0x0072), top: B:2:0x000c }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        CoroutineContext coroutineContext;
        CoroutineScope coroutineScope2;
        IDispatchers iDispatchers;
        SuperCallBack<T> superCallBack;
        CoroutineContext coroutineContext2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r12 = this.label;
        try {
        } catch (Exception e10) {
            ExceptionAnalyzer exceptionAnalyzer = this.$analyzer;
            SuperViewModelEngine superViewModelEngine = this.this$0;
            this.L$0 = r12;
            this.L$1 = null;
            this.label = 4;
            obj = exceptionAnalyzer.analysisException(superViewModelEngine, e10, this);
            coroutineScope = r12;
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (r12 != 0) {
            if (r12 != 1) {
                if (r12 != 2) {
                    if (r12 != 3) {
                        if (r12 != 4) {
                            if (r12 == 5) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            coroutineScope = coroutineScope3;
                            Throwable th = (Throwable) obj;
                            IDispatchers iDispatchers2 = this.$callBack;
                            if (iDispatchers2 != null && (coroutineContext = iDispatchers2.getCoroutineContext()) != null) {
                                SuperViewModelEngine$launchC$1$3$1 superViewModelEngine$launchC$1$3$1 = new SuperViewModelEngine$launchC$1$3$1(this.$callBack, th, null);
                                this.L$0 = coroutineScope;
                                this.L$1 = th;
                                this.label = 5;
                                if (BuildersKt.withContext(coroutineContext, superViewModelEngine$launchC$1$3$1, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                SuperCallBack<T> superCallBack2 = this.$callBack;
                                if (superCallBack2 != 0) {
                                    superCallBack2.onFailure(th);
                                }
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                iDispatchers = this.$callBack;
                if (iDispatchers == null && (coroutineContext2 = iDispatchers.getCoroutineContext()) != null) {
                    SuperViewModelEngine$launchC$1$1$1 superViewModelEngine$launchC$1$1$1 = new SuperViewModelEngine$launchC$1$1$1(this.$callBack, obj, null);
                    this.L$0 = coroutineScope2;
                    this.L$1 = obj;
                    this.label = 3;
                    if (BuildersKt.withContext(coroutineContext2, superViewModelEngine$launchC$1$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    superCallBack = this.$callBack;
                    if (superCallBack != 0) {
                        superCallBack.onSuccess(obj);
                    }
                }
                return Unit.INSTANCE;
            }
            coroutineScope2 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope4 = (CoroutineScope) this.L$0;
            ILoading iLoading = this.$loading;
            Integer boxInt = Boxing.boxInt(coroutineScope4.hashCode());
            this.L$0 = coroutineScope4;
            this.label = 1;
            if (ILoadingKt.showLoadingInCoroutine$default(iLoading, boxInt, null, this, 2, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
            coroutineScope2 = coroutineScope4;
        }
        Function2<CoroutineScope, Continuation<? super T>, Object> function2 = this.$block;
        this.L$0 = coroutineScope2;
        this.label = 2;
        obj = function2.invoke(coroutineScope2, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        iDispatchers = this.$callBack;
        if (iDispatchers == null) {
        }
        superCallBack = this.$callBack;
        if (superCallBack != 0) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuperViewModelEngine$launchC$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
