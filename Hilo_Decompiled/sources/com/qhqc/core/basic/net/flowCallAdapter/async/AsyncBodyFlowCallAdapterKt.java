package com.qhqc.core.basic.net.flowCallAdapter.async;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004¨\u0006\u0005"}, d2 = {"asyncBodyFlow", "Lkotlinx/coroutines/flow/Flow;", "R", "call", "Lretrofit2/Call;", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AsyncBodyFlowCallAdapterKt {
    @NotNull
    public static final <R> Flow<R> asyncBodyFlow(@NotNull Call<R> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return FlowKt.flow(new AsyncBodyFlowCallAdapterKt$asyncBodyFlow$1(call, null));
    }
}
