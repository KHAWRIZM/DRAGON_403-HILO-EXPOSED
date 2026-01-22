package com.qhqc.core.basic.net.flowCallAdapter.sync;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.CallAdapter;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/qhqc/core/basic/net/flowCallAdapter/sync/BodyFlowCallAdapter;", "R", "Lretrofit2/CallAdapter;", "Lkotlinx/coroutines/flow/Flow;", "responseBodyType", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "adapt", "call", "Lretrofit2/Call;", "responseType", "Ljava/lang/reflect/Type;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BodyFlowCallAdapter<R> implements CallAdapter<R, Flow<? extends R>> {
    private final R responseBodyType;

    public BodyFlowCallAdapter(R r10) {
        this.responseBodyType = r10;
    }

    @NotNull
    public Type responseType() {
        R r10 = this.responseBodyType;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.lang.reflect.Type");
        return (Type) r10;
    }

    @NotNull
    public Flow<R> adapt(@NotNull Call<R> call) {
        Intrinsics.checkNotNullParameter(call, "call");
        return BodyFlowCallAdapterKt.bodyFlow(call);
    }
}
