package com.qhqc.core.basic.net.flowCallAdapter.sync;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a&\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005¨\u0006\u0006"}, d2 = {"responseFlow", "Lkotlinx/coroutines/flow/Flow;", "Lretrofit2/Response;", "T", "call", "Lretrofit2/Call;", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ResponseFlowCallAdapterKt {
    @NotNull
    public static final <T> Flow<Response<T>> responseFlow(@NotNull Call<T> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return FlowKt.flow(new ResponseFlowCallAdapterKt$responseFlow$1(call, null));
    }
}
