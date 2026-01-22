package com.qhqc.core.basic.net.flowCallAdapter.sync;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u00030\u0002B\r\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0002\u0010\u0006J\"\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/qhqc/core/basic/net/flowCallAdapter/sync/ResponseFlowCallAdapter;", "R", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/flow/Flow;", "Lretrofit2/Response;", "responseBodyType", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "adapt", "call", "Lretrofit2/Call;", "responseType", "Ljava/lang/reflect/Type;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ResponseFlowCallAdapter<R> implements CallAdapter<R, Flow<? extends Response<R>>> {
    private final R responseBodyType;

    public ResponseFlowCallAdapter(R r10) {
        this.responseBodyType = r10;
    }

    @NotNull
    public Type responseType() {
        R r10 = this.responseBodyType;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.reflect.Type");
        return (Type) r10;
    }

    @NotNull
    public Flow<Response<R>> adapt(@NotNull Call<R> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return ResponseFlowCallAdapterKt.responseFlow(call);
    }
}
