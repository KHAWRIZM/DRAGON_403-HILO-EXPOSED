package com.qhqc.core.basic.net;

import com.qhqc.core.basic.net.exception.ApiErrorException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aV\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u001au\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u001a(\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\u0004¨\u0006\u0015"}, d2 = {"flowRequest", "Lkotlinx/coroutines/flow/Flow;", "T", "throwError", "", "showLoading", "Lkotlin/Function1;", "", "onError", "Lcom/qhqc/core/basic/net/exception/ApiErrorException;", "request", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "onFailure", "onSuccess", "Lkotlin/ParameterName;", "name", "data", "startIn", "crashReport", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ResponseUtilsKt {
    @NotNull
    public static final <T> Flow<T> flowRequest(@NotNull Flow<? extends T> flow, boolean z10, @Nullable Function1<? super Boolean, Unit> function1, @Nullable Function1<? super ApiErrorException, Unit> function12) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return FlowKt.catch(FlowKt.onCompletion(FlowKt.onStart(FlowKt.flowOn(flow, Dispatchers.getIO()), new ResponseUtilsKt$flowRequest$1(function1, null)), new ResponseUtilsKt$flowRequest$2(function1, null)), new ResponseUtilsKt$flowRequest$3(function12, z10, null));
    }

    public static /* synthetic */ Flow flowRequest$default(Flow flow, boolean z10, Function1 function1, Function1 function12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        if ((i10 & 4) != 0) {
            function12 = null;
        }
        return flowRequest(flow, z10, function1, function12);
    }

    @NotNull
    public static final <T> Job request(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope scope, @Nullable Function1<? super ApiErrorException, Unit> function1, @Nullable Function1<? super Boolean, Unit> function12, @Nullable Function1<? super T, Unit> function13) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return startIn$default(FlowKt.onEach(flowRequest(flow, false, function12, function1), new ResponseUtilsKt$request$1(function13, null)), scope, false, 2, null);
    }

    public static /* synthetic */ Job request$default(Flow flow, CoroutineScope coroutineScope, Function1 function1, Function1 function12, Function1 function13, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function1 = null;
        }
        if ((i10 & 4) != 0) {
            function12 = null;
        }
        if ((i10 & 8) != 0) {
            function13 = null;
        }
        return request(flow, coroutineScope, function1, function12, function13);
    }

    @NotNull
    public static final <T> Job startIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope scope, boolean z10) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return FlowKt.launchIn(FlowKt.catch(flow, new ResponseUtilsKt$startIn$1(z10, null)), scope);
    }

    public static /* synthetic */ Job startIn$default(Flow flow, CoroutineScope coroutineScope, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return startIn(flow, coroutineScope, z10);
    }
}
