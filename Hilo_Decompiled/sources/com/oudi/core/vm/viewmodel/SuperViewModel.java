package com.oudi.core.vm.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.facebook.internal.NativeProtocol;
import com.facebook.login.LoginLogger;
import com.facebook.share.internal.ShareConstants;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.component.ICleared;
import com.oudi.core.component.bridge.ComponentAction;
import com.oudi.core.component.bridge.ComponentActionBridge;
import com.oudi.core.loading.ILoading;
import com.oudi.core.vm.adapter.ExceptionAnalyzer;
import com.oudi.core.vm.adapter.ResultAnalyzer;
import com.oudi.core.vm.viewmodel.ViewModelEngine;
import com.qiahao.base_common.ui.dialog.ChatMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0096A¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010\u0010J\t\u0010\u0011\u001a\u00020\u0012H\u0096\u0001J\t\u0010\u0013\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J{\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2(\u0010\u001e\u001a$\b\u0001\u0012\b\u0012\u00060 j\u0002`!\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\"\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\u001f2'\u0010$\u001a#\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\"\u0012\u0006\u0012\u0004\u0018\u00010#0\u001f¢\u0006\u0002\b&H\u0096\u0001¢\u0006\u0002\u0010'Ju\u0010(\u001a\u00020\u0017\"\n\b\u0000\u0010)*\u0004\u0018\u00010#2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u0002H)\u0018\u00010+2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2'\u0010$\u001a#\b\u0001\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)0\"\u0012\u0006\u0012\u0004\u0018\u00010#0\u001f¢\u0006\u0002\b&H\u0096\u0001¢\u0006\u0002\u0010.Jp\u0010/\u001a\u00020\u0017\"\n\b\u0000\u0010)*\u0004\u0018\u00010#2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u0002H)\u0018\u00010+2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\"\u0010$\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)010\"\u0012\u0006\u0012\u0004\u0018\u00010#00H\u0096\u0001¢\u0006\u0002\u00102J¬\u0001\u0010/\u001a\u00020\u0017\"\n\b\u0000\u0010)*\u0004\u0018\u00010#2$\u00103\u001a \b\u0001\u0012\u0004\u0012\u0002H)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\"\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\u001f2$\u00104\u001a \b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\"\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\"\u0010$\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)010\"\u0012\u0006\u0012\u0004\u0018\u00010#00H\u0096\u0001¢\u0006\u0002\u00105J\u001f\u00106\u001a\u00020\b2\u0006\u00107\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0096\u0001J\u0011\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020;H\u0096\u0001J\"\u0010>\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010?\u001a\u0004\u0018\u00010@H\u0096\u0001¢\u0006\u0002\u0010A¨\u0006B"}, d2 = {"Lcom/oudi/core/vm/viewmodel/SuperViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/oudi/core/vm/viewmodel/ViewModelEngine;", "Lcom/oudi/core/component/ICleared;", "viewModelGear", "<init>", "(Lcom/oudi/core/vm/viewmodel/ViewModelEngine;)V", "onCleared", "", "analysisException", "", "throwable", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissLoading", "id", "", "(Ljava/lang/Integer;)V", "getComponentActionBridge", "Lcom/oudi/core/component/bridge/ComponentActionBridge;", "getEngine", "getResultAnalyzer", "Lcom/oudi/core/vm/adapter/ResultAnalyzer;", "launch", "Lkotlinx/coroutines/Job;", "loading", "Lcom/oudi/core/loading/ILoading;", "context", "Lkotlin/coroutines/CoroutineContext;", "start", "Lkotlinx/coroutines/CoroutineStart;", "catch", "Lkotlin/Function2;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/coroutines/Continuation;", "", ChatMenuDialog.CLICK_BLOCK, "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "(Lcom/oudi/core/loading/ILoading;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchC", "T", "callBack", "Lcom/oudi/core/callback/SuperCallBack;", "analyzer", "Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;", "(Lcom/oudi/core/callback/SuperCallBack;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "launchF", "Lkotlin/Function1;", "Lkotlinx/coroutines/flow/Flow;", "(Lcom/oudi/core/callback/SuperCallBack;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "success", LoginLogger.EVENT_EXTRAS_FAILURE, "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/oudi/core/loading/ILoading;Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "Lcom/oudi/core/component/bridge/ComponentAction;", "sendAction", NativeProtocol.WEB_DIALOG_ACTION, "showLoading", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperViewModel extends ViewModel implements ViewModelEngine, ICleared {
    private final /* synthetic */ ViewModelEngine $$delegate_0;

    public SuperViewModel(@NotNull ViewModelEngine viewModelGear) {
        Intrinsics.checkNotNullParameter(viewModelGear, "viewModelGear");
        this.$$delegate_0 = viewModelGear;
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @Nullable
    public Object analysisException(@NotNull Throwable th, @NotNull Continuation<? super Throwable> continuation) {
        return this.$$delegate_0.analysisException(th, continuation);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine, com.oudi.core.loading.ILoading
    public void dismissLoading(@Nullable Integer id) {
        this.$$delegate_0.dismissLoading(id);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public ComponentActionBridge getComponentActionBridge() {
        return this.$$delegate_0.getComponentActionBridge();
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public ViewModelEngine getEngine() {
        return this.$$delegate_0.getEngine();
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public ResultAnalyzer getResultAnalyzer() {
        return this.$$delegate_0.getResultAnalyzer();
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public Job launch(@Nullable ILoading loading, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @Nullable Function2<? super Exception, ? super Continuation<? super Unit>, ? extends Object> r11, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return this.$$delegate_0.launch(loading, context, start, r11, block);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public <T> Job launchC(@Nullable SuperCallBack<T> callBack, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return this.$$delegate_0.launchC(callBack, loading, analyzer, context, start, block);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public <T> Job launchF(@Nullable SuperCallBack<T> callBack, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return this.$$delegate_0.launchF(callBack, loading, analyzer, context, start, block);
    }

    @Override // com.oudi.core.component.bridge.ComponentActionBridge
    public void observe(@NotNull LifecycleOwner owner, @NotNull Observer<ComponentAction> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.$$delegate_0.observe(owner, observer);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        ICleared.DefaultImpls.onCleared(this);
        ViewModelEngine.DefaultImpls.onCleared(this);
    }

    @Override // com.oudi.core.component.bridge.ComponentActionBridge
    public void sendAction(@NotNull ComponentAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.$$delegate_0.sendAction(action);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine, com.oudi.core.loading.ILoading
    public void showLoading(@Nullable Integer id, @Nullable CharSequence message) {
        this.$$delegate_0.showLoading(id, message);
    }

    @Override // com.oudi.core.vm.viewmodel.ViewModelEngine
    @NotNull
    public <T> Job launchF(@Nullable Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> success, @Nullable Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> failure, @Nullable ILoading loading, @NotNull ExceptionAnalyzer analyzer, @NotNull CoroutineContext context, @NotNull CoroutineStart start, @NotNull Function1<? super Continuation<? super Flow<? extends T>>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(analyzer, "analyzer");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        return this.$$delegate_0.launchF(success, failure, loading, analyzer, context, start, block);
    }
}
