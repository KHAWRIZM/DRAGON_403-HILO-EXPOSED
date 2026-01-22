package com.oudi.core.vm.repository;

import com.oudi.core.component.ICleared;
import com.oudi.core.model.SuperResponse;
import com.oudi.core.model.SuperResult;
import com.oudi.core.vm.adapter.DefaultExceptionConverter;
import com.oudi.core.vm.adapter.DefaultResponseAdapter;
import com.oudi.core.vm.adapter.ExceptionConverter;
import com.oudi.core.vm.adapter.ResponseAdapter;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0005H\u0014J\b\u0010\u0010\u001a\u00020\u000bH\u0014JY\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\u0010\u001dJ_\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001f0\u0012\"\u0004\b\u0000\u0010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\u0010\u001dJR\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00130\u001f\"\u0004\b\u0000\u0010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u00052\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019H\u0086@¢\u0006\u0002\u0010!J0\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00130\u001f\"\u0004\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u001b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u0005JO\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001f0\u0012\"\u0004\b\u0000\u0010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\u0010$JI\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u0004\b\u0000\u0010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u001c\u0010\u0018\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\u0010$R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006&"}, d2 = {"Lcom/oudi/core/vm/repository/SuperRepository;", "Lcom/oudi/core/component/ICleared;", "<init>", "()V", "defaultResponseAdapter", "Lcom/oudi/core/vm/adapter/ResponseAdapter;", "getDefaultResponseAdapter", "()Lcom/oudi/core/vm/adapter/ResponseAdapter;", "defaultResponseAdapter$delegate", "Lkotlin/Lazy;", "defaultExceptionConverter", "Lcom/oudi/core/vm/adapter/ExceptionConverter;", "getDefaultExceptionConverter", "()Lcom/oudi/core/vm/adapter/ExceptionConverter;", "defaultExceptionConverter$delegate", "getResponseAdapter", "getExceptionConverter", "flowApi", "Lkotlinx/coroutines/flow/Flow;", "T", "adapter", "converter", "context", "Lkotlin/coroutines/CoroutineContext;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/oudi/core/model/SuperResponse;", "", "(Lcom/oudi/core/vm/adapter/ResponseAdapter;Lcom/oudi/core/vm/adapter/ExceptionConverter;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "flowApiResult", "Lcom/oudi/core/model/SuperResult;", "apiResult", "(Lcom/oudi/core/vm/adapter/ExceptionConverter;Lcom/oudi/core/vm/adapter/ResponseAdapter;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asApiResult", "flowResult", "(Lcom/oudi/core/vm/adapter/ExceptionConverter;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "flowSafety", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperRepository implements ICleared {

    /* renamed from: defaultResponseAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultResponseAdapter = LazyKt.lazy(new Function0() { // from class: com.oudi.core.vm.repository.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DefaultResponseAdapter defaultResponseAdapter_delegate$lambda$0;
            defaultResponseAdapter_delegate$lambda$0 = SuperRepository.defaultResponseAdapter_delegate$lambda$0();
            return defaultResponseAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: defaultExceptionConverter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy defaultExceptionConverter = LazyKt.lazy(new Function0() { // from class: com.oudi.core.vm.repository.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            DefaultExceptionConverter defaultExceptionConverter_delegate$lambda$1;
            defaultExceptionConverter_delegate$lambda$1 = SuperRepository.defaultExceptionConverter_delegate$lambda$1();
            return defaultExceptionConverter_delegate$lambda$1;
        }
    });

    public static /* synthetic */ Object apiResult$default(SuperRepository superRepository, ExceptionConverter exceptionConverter, ResponseAdapter responseAdapter, Function1 function1, Continuation continuation, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                exceptionConverter = superRepository.getExceptionConverter();
            }
            if ((i10 & 2) != 0) {
                responseAdapter = superRepository.getResponseAdapter();
            }
            return superRepository.apiResult(exceptionConverter, responseAdapter, function1, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: apiResult");
    }

    public static /* synthetic */ SuperResult asApiResult$default(SuperRepository superRepository, SuperResponse superResponse, ExceptionConverter exceptionConverter, ResponseAdapter responseAdapter, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                exceptionConverter = superRepository.getExceptionConverter();
            }
            if ((i10 & 2) != 0) {
                responseAdapter = superRepository.getResponseAdapter();
            }
            return superRepository.asApiResult(superResponse, exceptionConverter, responseAdapter);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asApiResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultExceptionConverter defaultExceptionConverter_delegate$lambda$1() {
        return new DefaultExceptionConverter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultResponseAdapter defaultResponseAdapter_delegate$lambda$0() {
        return new DefaultResponseAdapter();
    }

    public static /* synthetic */ Flow flowApi$default(SuperRepository superRepository, ResponseAdapter responseAdapter, ExceptionConverter exceptionConverter, CoroutineContext coroutineContext, Function1 function1, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                responseAdapter = superRepository.getResponseAdapter();
            }
            if ((i10 & 2) != 0) {
                exceptionConverter = superRepository.getExceptionConverter();
            }
            if ((i10 & 4) != 0) {
                coroutineContext = Dispatchers.getIO();
            }
            return superRepository.flowApi(responseAdapter, exceptionConverter, coroutineContext, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowApi");
    }

    public static /* synthetic */ Flow flowApiResult$default(SuperRepository superRepository, ResponseAdapter responseAdapter, ExceptionConverter exceptionConverter, CoroutineContext coroutineContext, Function1 function1, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                responseAdapter = superRepository.getResponseAdapter();
            }
            if ((i10 & 2) != 0) {
                exceptionConverter = superRepository.getExceptionConverter();
            }
            if ((i10 & 4) != 0) {
                coroutineContext = Dispatchers.getIO();
            }
            return superRepository.flowApiResult(responseAdapter, exceptionConverter, coroutineContext, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowApiResult");
    }

    public static /* synthetic */ Flow flowResult$default(SuperRepository superRepository, ExceptionConverter exceptionConverter, CoroutineContext coroutineContext, Function1 function1, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                exceptionConverter = superRepository.getExceptionConverter();
            }
            if ((i10 & 2) != 0) {
                coroutineContext = Dispatchers.getIO();
            }
            return superRepository.flowResult(exceptionConverter, coroutineContext, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowResult");
    }

    public static /* synthetic */ Flow flowSafety$default(SuperRepository superRepository, ExceptionConverter exceptionConverter, CoroutineContext coroutineContext, Function1 function1, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                exceptionConverter = superRepository.getExceptionConverter();
            }
            if ((i10 & 2) != 0) {
                coroutineContext = Dispatchers.getIO();
            }
            return superRepository.flowSafety(exceptionConverter, coroutineContext, function1);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flowSafety");
    }

    private final ExceptionConverter getDefaultExceptionConverter() {
        return (ExceptionConverter) this.defaultExceptionConverter.getValue();
    }

    private final ResponseAdapter getDefaultResponseAdapter() {
        return (ResponseAdapter) this.defaultResponseAdapter.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object apiResult(@NotNull ExceptionConverter exceptionConverter, @NotNull ResponseAdapter responseAdapter, @NotNull Function1<? super Continuation<? super SuperResponse<? extends T>>, ? extends Object> function1, @NotNull Continuation<? super SuperResult<? extends T>> continuation) {
        SuperRepository$apiResult$1 superRepository$apiResult$1;
        int i10;
        ResponseAdapter responseAdapter2;
        try {
            if (continuation instanceof SuperRepository$apiResult$1) {
                superRepository$apiResult$1 = (SuperRepository$apiResult$1) continuation;
                int i11 = superRepository$apiResult$1.label;
                if ((i11 & Integer.MIN_VALUE) != 0) {
                    superRepository$apiResult$1.label = i11 - Integer.MIN_VALUE;
                    Object obj = superRepository$apiResult$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i10 = superRepository$apiResult$1.label;
                    if (i10 == 0) {
                        if (i10 == 1) {
                            responseAdapter = (ResponseAdapter) superRepository$apiResult$1.L$2;
                            ResponseAdapter responseAdapter3 = (ResponseAdapter) superRepository$apiResult$1.L$1;
                            ExceptionConverter exceptionConverter2 = (ExceptionConverter) superRepository$apiResult$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                responseAdapter2 = responseAdapter3;
                                exceptionConverter = exceptionConverter2;
                            } catch (Exception e10) {
                                responseAdapter = responseAdapter3;
                                exceptionConverter = exceptionConverter2;
                                e = e10;
                                return responseAdapter.throwableToResult(exceptionConverter.convert(e));
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        try {
                            superRepository$apiResult$1.L$0 = exceptionConverter;
                            superRepository$apiResult$1.L$1 = responseAdapter;
                            superRepository$apiResult$1.L$2 = responseAdapter;
                            superRepository$apiResult$1.label = 1;
                            obj = function1.invoke(superRepository$apiResult$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            responseAdapter2 = responseAdapter;
                        } catch (Exception e11) {
                            e = e11;
                            return responseAdapter.throwableToResult(exceptionConverter.convert(e));
                        }
                    }
                    return responseAdapter.responseToResult((SuperResponse) obj);
                }
            }
            return responseAdapter.responseToResult((SuperResponse) obj);
        } catch (Exception e12) {
            ResponseAdapter responseAdapter4 = responseAdapter2;
            e = e12;
            responseAdapter = responseAdapter4;
            return responseAdapter.throwableToResult(exceptionConverter.convert(e));
        }
        superRepository$apiResult$1 = new SuperRepository$apiResult$1(this, continuation);
        Object obj2 = superRepository$apiResult$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = superRepository$apiResult$1.label;
        if (i10 == 0) {
        }
    }

    @NotNull
    public final <T> SuperResult<T> asApiResult(@NotNull SuperResponse<? extends T> superResponse, @NotNull ExceptionConverter converter, @NotNull ResponseAdapter adapter) {
        Intrinsics.checkNotNullParameter(superResponse, "<this>");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        try {
            return adapter.responseToResult(superResponse);
        } catch (Exception e10) {
            return adapter.throwableToResult(converter.convert(e10));
        }
    }

    @NotNull
    public final <T> Flow<T> flowApi(@NotNull ResponseAdapter adapter, @NotNull ExceptionConverter converter, @NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super SuperResponse<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flowOn(FlowKt.catch(FlowKt.flow(new SuperRepository$flowApi$1(block, adapter, null)), new SuperRepository$flowApi$2(converter, null)), context);
    }

    @NotNull
    public final <T> Flow<SuperResult<T>> flowApiResult(@NotNull ResponseAdapter adapter, @NotNull ExceptionConverter converter, @NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super SuperResponse<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flowOn(FlowKt.catch(FlowKt.flow(new SuperRepository$flowApiResult$1(adapter, block, null)), new SuperRepository$flowApiResult$2(adapter, converter, null)), context);
    }

    @NotNull
    public final <T> Flow<SuperResult<T>> flowResult(@NotNull ExceptionConverter converter, @NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flowOn(FlowKt.catch(FlowKt.flow(new SuperRepository$flowResult$1(block, null)), new SuperRepository$flowResult$2(converter, null)), context);
    }

    @NotNull
    public final <T> Flow<T> flowSafety(@NotNull ExceptionConverter converter, @NotNull CoroutineContext context, @NotNull Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(converter, "converter");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        return FlowKt.flowOn(FlowKt.catch(FlowKt.flow(new SuperRepository$flowSafety$1(block, null)), new SuperRepository$flowSafety$2(converter, null)), context);
    }

    @NotNull
    public ExceptionConverter getExceptionConverter() {
        return getDefaultExceptionConverter();
    }

    @NotNull
    public ResponseAdapter getResponseAdapter() {
        return getDefaultResponseAdapter();
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        ICleared.DefaultImpls.onCleared(this);
    }
}
