package com.oudi.core.vm.viewmodel;

import com.facebook.login.LoginLogger;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.callback.LoadingCallBack;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.component.bridge.ComponentActionBridge;
import com.oudi.core.loading.ILoading;
import com.oudi.core.vm.adapter.ExceptionAnalyzer;
import com.oudi.core.vm.adapter.ResultAnalyzer;
import com.oudi.utils.ICleared;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016J\b\u0010\u0005\u001a\u00020\u0001H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&Js\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H&¢\u0006\u0002\u0010\u0019J±\u0001\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2&\b\u0002\u0010\u001a\u001a \b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001b2&\b\u0002\u0010\u001d\u001a \b\u0001\u0012\u0004\u0012\u00020\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H&¢\u0006\u0002\u0010\u001fJ\u0082\u0001\u0010 \u001a\u00020\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132*\b\u0002\u0010!\u001a$\b\u0001\u0012\b\u0012\u00060\"j\u0002`#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u001b2'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001b¢\u0006\u0002\b%H&¢\u0006\u0002\u0010&Jx\u0010'\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001b¢\u0006\u0002\b%H&¢\u0006\u0002\u0010(J!\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0002\u0010.J\u0017\u0010/\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0002\u00100J\u0016\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001eH\u0096@¢\u0006\u0002\u00103¨\u00064"}, d2 = {"Lcom/oudi/core/vm/viewmodel/ViewModelEngine;", "Lcom/oudi/core/component/bridge/ComponentActionBridge;", "Lcom/oudi/core/loading/ILoading;", "Lcom/oudi/utils/ICleared;", "getEngine", "getComponentActionBridge", "getResultAnalyzer", "Lcom/oudi/core/vm/adapter/ResultAnalyzer;", "launchF", "Lkotlinx/coroutines/Job;", "T", "callBack", "Lcom/oudi/core/callback/SuperCallBack;", "loading", "analyzer", "Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/Flow;", "", "(Lcom/oudi/core/callback/SuperCallBack;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "success", "Lkotlin/Function2;", "", LoginLogger.EVENT_EXTRAS_FAILURE, "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "launch", "catch", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "(Lcom/oudi/core/loading/ILoading;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchC", "(Lcom/oudi/core/callback/SuperCallBack;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "showLoading", "id", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoading", "(Ljava/lang/Integer;)V", "analysisException", "throwable", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ViewModelEngine extends ComponentActionBridge, ILoading, ICleared {
    @Nullable
    Object analysisException(@NotNull Throwable th, @NotNull Continuation<? super Throwable> continuation);

    void dismissLoading(@Nullable Integer id);

    @NotNull
    ComponentActionBridge getComponentActionBridge();

    @NotNull
    ViewModelEngine getEngine();

    @NotNull
    ResultAnalyzer getResultAnalyzer();

    @NotNull
    Job launch(@Nullable ILoading loading, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @Nullable Function2<? super Exception, ? super Continuation<? super Unit>, ? extends Object> r42, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block);

    @NotNull
    <T> Job launchC(@Nullable SuperCallBack<T> callBack, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block);

    @NotNull
    <T> Job launchF(@Nullable SuperCallBack<T> callBack, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> block);

    @NotNull
    <T> Job launchF(@Nullable Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> success, @Nullable Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> failure, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> block);

    void showLoading(@Nullable Integer id, @Nullable CharSequence message);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Object analysisException(@NotNull ViewModelEngine viewModelEngine, @NotNull Throwable th, @NotNull Continuation<? super Throwable> continuation) {
            return viewModelEngine.getResultAnalyzer().analysisException(viewModelEngine.getComponentActionBridge(), th, continuation);
        }

        public static void dismissLoading(@NotNull ViewModelEngine viewModelEngine, @Nullable Integer num) {
            viewModelEngine.sendAction(new ComponentAction.DismissLoading(num));
        }

        @NotNull
        public static ComponentActionBridge getComponentActionBridge(@NotNull ViewModelEngine viewModelEngine) {
            return viewModelEngine;
        }

        @NotNull
        public static ViewModelEngine getEngine(@NotNull ViewModelEngine viewModelEngine) {
            return viewModelEngine;
        }

        public static /* synthetic */ Job launch$default(ViewModelEngine viewModelEngine, ILoading iLoading, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, Function2 function22, int i10, Object obj) {
            ILoading iLoading2;
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    iLoading2 = viewModelEngine;
                } else {
                    iLoading2 = iLoading;
                }
                if ((i10 & 2) != 0) {
                    coroutineContext = Dispatchers.getIO();
                }
                CoroutineContext coroutineContext2 = coroutineContext;
                if ((i10 & 4) != 0) {
                    coroutineStart = CoroutineStart.DEFAULT;
                }
                CoroutineStart coroutineStart2 = coroutineStart;
                if ((i10 & 8) != 0) {
                    function2 = null;
                }
                return viewModelEngine.launch(iLoading2, coroutineContext2, coroutineStart2, function2, function22);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
        }

        public static /* synthetic */ Job launchC$default(ViewModelEngine viewModelEngine, SuperCallBack superCallBack, ILoading iLoading, ExceptionAnalyzer exceptionAnalyzer, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i10, Object obj) {
            SuperCallBack superCallBack2;
            ILoading iLoading2;
            ExceptionAnalyzer exceptionAnalyzer2;
            CoroutineContext coroutineContext2;
            CoroutineStart coroutineStart2;
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    superCallBack2 = null;
                } else {
                    superCallBack2 = superCallBack;
                }
                if ((i10 & 2) != 0) {
                    if ((superCallBack2 instanceof LoadingCallBack) && ((LoadingCallBack) superCallBack2).isShowLoading()) {
                        iLoading2 = viewModelEngine;
                    } else {
                        iLoading2 = null;
                    }
                } else {
                    iLoading2 = iLoading;
                }
                if ((i10 & 4) != 0) {
                    exceptionAnalyzer2 = viewModelEngine.getResultAnalyzer();
                } else {
                    exceptionAnalyzer2 = exceptionAnalyzer;
                }
                if ((i10 & 8) != 0) {
                    coroutineContext2 = Dispatchers.getIO();
                } else {
                    coroutineContext2 = coroutineContext;
                }
                if ((i10 & 16) != 0) {
                    coroutineStart2 = CoroutineStart.DEFAULT;
                } else {
                    coroutineStart2 = coroutineStart;
                }
                return viewModelEngine.launchC(superCallBack2, iLoading2, exceptionAnalyzer2, coroutineContext2, coroutineStart2, function2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchC");
        }

        public static /* synthetic */ Job launchF$default(ViewModelEngine viewModelEngine, SuperCallBack superCallBack, ILoading iLoading, ExceptionAnalyzer exceptionAnalyzer, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1 function1, int i10, Object obj) {
            ILoading iLoading2;
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchF");
            }
            SuperCallBack superCallBack2 = (i10 & 1) != 0 ? null : superCallBack;
            if ((i10 & 2) != 0) {
                iLoading2 = ((superCallBack2 instanceof LoadingCallBack) && ((LoadingCallBack) superCallBack2).isShowLoading()) ? viewModelEngine : null;
            } else {
                iLoading2 = iLoading;
            }
            return viewModelEngine.launchF(superCallBack2, iLoading2, (i10 & 4) != 0 ? viewModelEngine.getResultAnalyzer() : exceptionAnalyzer, (i10 & 8) != 0 ? Dispatchers.getIO() : coroutineContext, (i10 & 16) != 0 ? CoroutineStart.DEFAULT : coroutineStart, function1);
        }

        public static void onCleared(@NotNull ViewModelEngine viewModelEngine) {
            ICleared.DefaultImpls.onCleared(viewModelEngine);
        }

        public static void showLoading(@NotNull ViewModelEngine viewModelEngine, @Nullable Integer num, @Nullable CharSequence charSequence) {
            viewModelEngine.sendAction(new ComponentAction.ShowLoading(num, charSequence));
        }

        public static /* synthetic */ Job launchF$default(ViewModelEngine viewModelEngine, Function2 function2, Function2 function22, ILoading iLoading, ExceptionAnalyzer exceptionAnalyzer, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function1 function1, int i10, Object obj) {
            if (obj == null) {
                return viewModelEngine.launchF((i10 & 1) != 0 ? null : function2, (i10 & 2) != 0 ? null : function22, (i10 & 4) != 0 ? viewModelEngine : iLoading, (i10 & 8) != 0 ? viewModelEngine.getResultAnalyzer() : exceptionAnalyzer, (i10 & 16) != 0 ? Dispatchers.getIO() : coroutineContext, (i10 & 32) != 0 ? CoroutineStart.DEFAULT : coroutineStart, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchF");
        }
    }
}
