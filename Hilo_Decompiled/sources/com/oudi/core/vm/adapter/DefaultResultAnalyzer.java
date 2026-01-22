package com.oudi.core.vm.adapter;

import com.oudi.core.component.bridge.ComponentActionBridge;
import com.oudi.core.model.SuperResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005H\u0096@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/oudi/core/vm/adapter/DefaultResultAnalyzer;", "Lcom/oudi/core/vm/adapter/ResultAnalyzer;", "<init>", "()V", "analysisResult", "Lcom/oudi/core/model/SuperResult;", "T", "bridge", "Lcom/oudi/core/component/bridge/ComponentActionBridge;", "result", "(Lcom/oudi/core/component/bridge/ComponentActionBridge;Lcom/oudi/core/model/SuperResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analysisException", "", "throwable", "(Lcom/oudi/core/component/bridge/ComponentActionBridge;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DefaultResultAnalyzer implements ResultAnalyzer {
    public static /* synthetic */ Object analysisException$suspendImpl(DefaultResultAnalyzer defaultResultAnalyzer, ComponentActionBridge componentActionBridge, Throwable th, Continuation<? super Throwable> continuation) {
        return th;
    }

    public static /* synthetic */ <T> Object analysisResult$suspendImpl(DefaultResultAnalyzer defaultResultAnalyzer, ComponentActionBridge componentActionBridge, SuperResult<? extends T> superResult, Continuation<? super SuperResult<? extends T>> continuation) {
        return superResult;
    }

    @Override // com.oudi.core.vm.adapter.ExceptionAnalyzer
    @Nullable
    public Object analysisException(@NotNull ComponentActionBridge componentActionBridge, @NotNull Throwable th, @NotNull Continuation<? super Throwable> continuation) {
        return analysisException$suspendImpl(this, componentActionBridge, th, continuation);
    }

    @Override // com.oudi.core.vm.adapter.ResultAnalyzer
    @Nullable
    public <T> Object analysisResult(@NotNull ComponentActionBridge componentActionBridge, @NotNull SuperResult<? extends T> superResult, @NotNull Continuation<? super SuperResult<? extends T>> continuation) {
        return analysisResult$suspendImpl(this, componentActionBridge, superResult, continuation);
    }
}
