package com.oudi.core.vm.adapter;

import com.oudi.core.component.bridge.ComponentActionBridge;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;", "", "analysisException", "", "bridge", "Lcom/oudi/core/component/bridge/ComponentActionBridge;", "throwable", "(Lcom/oudi/core/component/bridge/ComponentActionBridge;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ExceptionAnalyzer {
    @Nullable
    Object analysisException(@NotNull ComponentActionBridge componentActionBridge, @NotNull Throwable th, @NotNull Continuation<? super Throwable> continuation);
}
