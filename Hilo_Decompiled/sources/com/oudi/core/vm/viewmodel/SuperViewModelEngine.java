package com.oudi.core.vm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginLogger;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.component.bridge.ComponentActionBridge;
import com.oudi.core.loading.ILoading;
import com.oudi.core.loading.ILoadingKt;
import com.oudi.core.vm.adapter.DefaultResultAnalyzer;
import com.oudi.core.vm.adapter.ExceptionAnalyzer;
import com.oudi.core.vm.adapter.ResultAnalyzer;
import com.oudi.core.vm.viewmodel.ViewModelEngine;
import com.oudi.utils.CloseableCoroutineScope;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000e\u001a\u00020\u0002H\u0014J\b\u0010\u000f\u001a\u00020\u0004H\u0016Ji\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\"\u0010\u001d\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120 0\u001f\u0012\u0006\u0012\u0004\u0018\u00010!0\u001eH\u0016¢\u0006\u0002\u0010\"J¥\u0001\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00122$\u0010#\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010$2$\u0010&\u001a \b\u0001\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010$2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\"\u0010\u001d\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120 0\u001f\u0012\u0006\u0012\u0004\u0018\u00010!0\u001eH\u0016¢\u0006\u0002\u0010(Jz\u0010)\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2(\u0010*\u001a$\b\u0001\u0012\b\u0012\u00060+j\u0002`,\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010$2'\u0010\u001d\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001f\u0012\u0006\u0012\u0004\u0018\u00010!0$¢\u0006\u0002\b-H\u0016¢\u0006\u0002\u0010.Jn\u0010/\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0012\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2'\u0010\u001d\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u001f\u0012\u0006\u0012\u0004\u0018\u00010!0$¢\u0006\u0002\b-H\u0016¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020%2\u0006\u00102\u001a\u00020\tH\u0016J\u001e\u00103\u001a\u00020%2\u0006\u00104\u001a\u0002052\f\u00106\u001a\b\u0012\u0004\u0012\u00020\t07H\u0016J\b\u00108\u001a\u00020%H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0012\u00109\u001a\u00020\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006<"}, d2 = {"Lcom/oudi/core/vm/viewmodel/SuperViewModelEngine;", "Lcom/oudi/core/vm/viewmodel/ViewModelEngine;", "Lkotlinx/coroutines/CoroutineScope;", "resultAnalyzer", "Lcom/oudi/core/vm/adapter/ResultAnalyzer;", "<init>", "(Lcom/oudi/core/vm/adapter/ResultAnalyzer;)V", "componentBridgeLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/oudi/core/component/bridge/ComponentAction;", "getComponentBridgeLiveData", "()Landroidx/lifecycle/MutableLiveData;", "componentBridgeLiveData$delegate", "Lkotlin/Lazy;", "getCoroutineScope", "getResultAnalyzer", "launchF", "Lkotlinx/coroutines/Job;", "T", "callBack", "Lcom/oudi/core/callback/SuperCallBack;", "loading", "Lcom/oudi/core/loading/ILoading;", "analyzer", "Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", ChatMenuDialog.CLICK_BLOCK, "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/Flow;", "", "(Lcom/oudi/core/callback/SuperCallBack;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "success", "Lkotlin/Function2;", "", LoginLogger.EVENT_EXTRAS_FAILURE, "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "launch", "catch", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/ExtensionFunctionType;", "(Lcom/oudi/core/loading/ILoading;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchC", "(Lcom/oudi/core/callback/SuperCallBack;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "sendAction", NativeProtocol.WEB_DIALOG_ACTION, "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "onCleared", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperViewModelEngine implements ViewModelEngine, CoroutineScope {
    private final /* synthetic */ CloseableCoroutineScope $$delegate_0;

    /* renamed from: componentBridgeLiveData$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy componentBridgeLiveData;

    @NotNull
    private final ResultAnalyzer resultAnalyzer;

    /* JADX WARN: Multi-variable type inference failed */
    public SuperViewModelEngine() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableLiveData componentBridgeLiveData_delegate$lambda$0() {
        return new MutableLiveData();
    }

    private final MutableLiveData<ComponentAction> getComponentBridgeLiveData() {
        return (MutableLiveData) this.componentBridgeLiveData.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launch$lambda$4$lambda$3$lambda$1(ILoading iLoading, Throwable th) {
        ILoadingKt.dismissLoadingInMain(iLoading, Integer.valueOf(iLoading.hashCode()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launch$lambda$4$lambda$3$lambda$2(ILoading iLoading, Throwable th) {
        ILoadingKt.dismissLoadingInMain(iLoading, Integer.valueOf(iLoading.hashCode()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launchC$lambda$8$lambda$7$lambda$5(ILoading iLoading, Throwable th) {
        ILoadingKt.dismissLoadingInMain(iLoading, Integer.valueOf(iLoading.hashCode()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit launchC$lambda$8$lambda$7$lambda$6(ILoading iLoading, Throwable th) {
        ILoadingKt.dismissLoadingInMain(iLoading, Integer.valueOf(iLoading.hashCode()));
        return Unit.INSTANCE;
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @Nullable
    public Object analysisException(@NotNull Throwable th, @NotNull Continuation<? super Throwable> continuation) {
        return ViewModelEngine.DefaultImpls.analysisException(this, th, continuation);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine, com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer num) {
        ViewModelEngine.DefaultImpls.dismissLoading(this, num);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public ComponentActionBridge getComponentActionBridge() {
        return ViewModelEngine.DefaultImpls.getComponentActionBridge(this);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    @NotNull
    public CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.getCoroutineContext();
    }

    @NotNull
    public CoroutineScope getCoroutineScope() {
        return this;
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public ViewModelEngine getEngine() {
        return ViewModelEngine.DefaultImpls.getEngine(this);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public ResultAnalyzer getResultAnalyzer() {
        return this.resultAnalyzer;
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public Job launch(@Nullable final ILoading loading, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @Nullable Function2<? super Exception, ? super Continuation<? super Unit>, ? extends Object> r72, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        Job launch = BuildersKt.launch(getCoroutineScope(), context, start, new SuperViewModelEngine$launch$1(loading, block, r72, null));
        if (loading != null) {
            launch.invokeOnCompletion(true, true, new Function1() { // from class: com.oudi.core.vm.viewmodel.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit launch$lambda$4$lambda$3$lambda$1;
                    launch$lambda$4$lambda$3$lambda$1 = SuperViewModelEngine.launch$lambda$4$lambda$3$lambda$1(ILoading.this, (Throwable) obj);
                    return launch$lambda$4$lambda$3$lambda$1;
                }
            });
            launch.invokeOnCompletion(false, true, new Function1() { // from class: com.oudi.core.vm.viewmodel.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit launch$lambda$4$lambda$3$lambda$2;
                    launch$lambda$4$lambda$3$lambda$2 = SuperViewModelEngine.launch$lambda$4$lambda$3$lambda$2(ILoading.this, (Throwable) obj);
                    return launch$lambda$4$lambda$3$lambda$2;
                }
            });
        }
        return launch;
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public <T> Job launchC(@Nullable SuperCallBack<T> callBack, @Nullable final ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        Job launch = BuildersKt.launch(getCoroutineScope(), context, start, new SuperViewModelEngine$launchC$1(loading, block, callBack, analyzer, this, null));
        if (loading != null) {
            launch.invokeOnCompletion(true, true, new Function1() { // from class: com.oudi.core.vm.viewmodel.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit launchC$lambda$8$lambda$7$lambda$5;
                    launchC$lambda$8$lambda$7$lambda$5 = SuperViewModelEngine.launchC$lambda$8$lambda$7$lambda$5(ILoading.this, (Throwable) obj);
                    return launchC$lambda$8$lambda$7$lambda$5;
                }
            });
            launch.invokeOnCompletion(false, true, new Function1() { // from class: com.oudi.core.vm.viewmodel.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit launchC$lambda$8$lambda$7$lambda$6;
                    launchC$lambda$8$lambda$7$lambda$6 = SuperViewModelEngine.launchC$lambda$8$lambda$7$lambda$6(ILoading.this, (Throwable) obj);
                    return launchC$lambda$8$lambda$7$lambda$6;
                }
            });
        }
        return launch;
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public <T> Job launchF(@Nullable SuperCallBack<T> callBack, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt.launch(getCoroutineScope(), context, start, new SuperViewModelEngine$launchF$1(block, loading, analyzer, this, callBack, null));
    }

    @Override // com.oudi.core.component.bridge.ComponentActionBridge
    public void observe(@NotNull LifecycleOwner owner, @NotNull Observer<ComponentAction> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        getComponentBridgeLiveData().observe(owner, observer);
    }

    @Override // com.oudi.utils.ICleared
    public void onCleared() {
        ViewModelEngine.DefaultImpls.onCleared(this);
        try {
            JobKt__JobKt.cancel$default(getCoroutineScope().getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        } catch (Exception unused) {
        }
    }

    @Override // com.oudi.core.component.bridge.ComponentActionBridge
    public void sendAction(@NotNull ComponentAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        getComponentBridgeLiveData().setValue(action);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine, com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer num, @Nullable CharSequence charSequence) {
        ViewModelEngine.DefaultImpls.showLoading(this, num, charSequence);
    }

    public SuperViewModelEngine(@NotNull ResultAnalyzer resultAnalyzer) {
        Intrinsics.checkNotNullParameter(resultAnalyzer, "resultAnalyzer");
        this.$$delegate_0 = new CloseableCoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain().getImmediate()));
        this.resultAnalyzer = resultAnalyzer;
        this.componentBridgeLiveData = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.oudi.core.vm.viewmodel.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MutableLiveData componentBridgeLiveData_delegate$lambda$0;
                componentBridgeLiveData_delegate$lambda$0 = SuperViewModelEngine.componentBridgeLiveData_delegate$lambda$0();
                return componentBridgeLiveData_delegate$lambda$0;
            }
        });
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public <T> Job launchF(@Nullable Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> success, @Nullable Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> failure, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return BuildersKt.launch(getCoroutineScope(), context, start, new SuperViewModelEngine$launchF$2(block, loading, analyzer, this, failure, success, null));
    }

    public /* synthetic */ SuperViewModelEngine(ResultAnalyzer resultAnalyzer, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? new DefaultResultAnalyzer() : resultAnalyzer);
    }
}
