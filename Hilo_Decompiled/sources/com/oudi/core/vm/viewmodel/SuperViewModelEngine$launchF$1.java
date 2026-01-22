package com.oudi.core.vm.viewmodel;

import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.loading.ILoading;
import com.oudi.core.loading.ILoadingKt;
import com.oudi.core.vm.adapter.ExceptionAnalyzer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1", f = "SuperViewModelEngine.kt", i = {0}, l = {58, 73}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperViewModelEngine$launchF$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ExceptionAnalyzer $analyzer;
    final /* synthetic */ Function1<Continuation<? super Flow<? extends T>>, Object> $block;
    final /* synthetic */ SuperCallBack<T> $callBack;
    final /* synthetic */ ILoading $loading;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SuperViewModelEngine this$0;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$1", f = "SuperViewModelEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class AnonymousClass1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ ILoading $loading;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ILoading iLoading, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loading = iLoading;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$loading, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ILoadingKt.showLoadingInMain$default(this.$loading, Boxing.boxInt(((FlowCollector) this.L$0).hashCode()), null, 2, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$2", f = "SuperViewModelEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ ILoading $loading;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ILoading iLoading, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.$loading = iLoading;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                ILoadingKt.dismissLoadingInMain(this.$loading, Boxing.boxInt(((FlowCollector) this.L$0).hashCode()));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$loading, continuation);
            anonymousClass2.L$0 = flowCollector;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$3", f = "SuperViewModelEngine.kt", i = {0, 1, 1}, l = {65, 67}, m = "invokeSuspend", n = {"$this$catch", "$this$catch", "exception"}, s = {"L$0", "L$0", "L$1"})
    /* renamed from: com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$3, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class AnonymousClass3<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ ExceptionAnalyzer $analyzer;
        final /* synthetic */ SuperCallBack<T> $callBack;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ SuperViewModelEngine this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ExceptionAnalyzer exceptionAnalyzer, SuperViewModelEngine superViewModelEngine, SuperCallBack<T> superCallBack, Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
            this.$analyzer = exceptionAnalyzer;
            this.this$0 = superViewModelEngine;
            this.$callBack = superCallBack;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            CoroutineContext coroutineContext;
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
                Throwable th = (Throwable) this.L$1;
                ExceptionAnalyzer exceptionAnalyzer = this.$analyzer;
                SuperViewModelEngine superViewModelEngine = this.this$0;
                this.L$0 = flowCollector;
                this.label = 1;
                obj = exceptionAnalyzer.analysisException(superViewModelEngine, th, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Throwable th2 = (Throwable) obj;
            SuperCallBack<T> superCallBack = this.$callBack;
            if (superCallBack != null && (coroutineContext = superCallBack.getCoroutineContext()) != null) {
                SuperViewModelEngine$launchF$1$3$1$1 superViewModelEngine$launchF$1$3$1$1 = new SuperViewModelEngine$launchF$1$3$1$1(this.$callBack, th2, null);
                this.L$0 = flowCollector;
                this.L$1 = th2;
                this.label = 2;
                if (BuildersKt.withContext(coroutineContext, superViewModelEngine$launchF$1$3$1$1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                SuperCallBack<T> superCallBack2 = this.$callBack;
                if (superCallBack2 != null) {
                    superCallBack2.onFailure(th2);
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$analyzer, this.this$0, this.$callBack, continuation);
            anonymousClass3.L$0 = flowCollector;
            anonymousClass3.L$1 = th;
            return anonymousClass3.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "result"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$4", f = "SuperViewModelEngine.kt", i = {0}, l = {76}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
    /* renamed from: com.oudi.core.vm.viewmodel.SuperViewModelEngine$launchF$1$4, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class AnonymousClass4<T> extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $$this$launch;
        final /* synthetic */ SuperCallBack<T> $callBack;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(SuperCallBack<T> superCallBack, CoroutineScope coroutineScope, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$callBack = superCallBack;
            this.$$this$launch = coroutineScope;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$callBack, this.$$this$launch, continuation);
            anonymousClass4.L$0 = obj;
            return anonymousClass4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
            return invoke2((AnonymousClass4<T>) obj, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineContext coroutineContext;
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
                Object obj2 = this.L$0;
                SuperCallBack<T> superCallBack = this.$callBack;
                if (superCallBack != null && (coroutineContext = superCallBack.getCoroutineContext()) != null) {
                    SuperViewModelEngine$launchF$1$4$1$1 superViewModelEngine$launchF$1$4$1$1 = new SuperViewModelEngine$launchF$1$4$1$1(this.$callBack, obj2, null);
                    this.L$0 = obj2;
                    this.label = 1;
                    if (BuildersKt.withContext(coroutineContext, superViewModelEngine$launchF$1$4$1$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    SuperCallBack<T> superCallBack2 = this.$callBack;
                    if (superCallBack2 != 0) {
                        superCallBack2.onSuccess(obj2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(T t10, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(t10, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SuperViewModelEngine$launchF$1(Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> function1, ILoading iLoading, ExceptionAnalyzer exceptionAnalyzer, SuperViewModelEngine superViewModelEngine, SuperCallBack<T> superCallBack, Continuation<? super SuperViewModelEngine$launchF$1> continuation) {
        super(2, continuation);
        this.$block = function1;
        this.$loading = iLoading;
        this.$analyzer = exceptionAnalyzer;
        this.this$0 = superViewModelEngine;
        this.$callBack = superCallBack;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SuperViewModelEngine$launchF$1 superViewModelEngine$launchF$1 = new SuperViewModelEngine$launchF$1(this.$block, this.$loading, this.$analyzer, this.this$0, this.$callBack, continuation);
        superViewModelEngine$launchF$1.L$0 = obj;
        return superViewModelEngine$launchF$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
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
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            Function1<Continuation<? super Flow<? extends T>>, Object> function1 = this.$block;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj = function1.invoke(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        Flow flow = FlowKt.catch(FlowKt.onCompletion(FlowKt.onStart((Flow) obj, new AnonymousClass1(this.$loading, null)), new AnonymousClass2(this.$loading, null)), new AnonymousClass3(this.$analyzer, this.this$0, this.$callBack, null));
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(this.$callBack, coroutineScope, null);
        this.L$0 = null;
        this.label = 2;
        if (FlowKt.collectLatest(flow, anonymousClass4, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuperViewModelEngine$launchF$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
