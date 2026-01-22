package com.oudi.core.vm.adapter;

import com.oudi.core.component.bridge.ComponentActionBridge;
import com.oudi.core.model.SuperResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H¦@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/oudi/core/vm/adapter/ResultAnalyzer;", "Lcom/oudi/core/vm/adapter/ExceptionAnalyzer;", "analysisResult", "Lcom/oudi/core/model/SuperResult;", "T", "bridge", "Lcom/oudi/core/component/bridge/ComponentActionBridge;", "result", "(Lcom/oudi/core/component/bridge/ComponentActionBridge;Lcom/oudi/core/model/SuperResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ResultAnalyzer extends ExceptionAnalyzer {
    @Nullable
    <T> Object analysisResult(@NotNull ComponentActionBridge componentActionBridge, @NotNull SuperResult<? extends T> superResult, @NotNull Continuation<? super SuperResult<? extends T>> continuation);
}
