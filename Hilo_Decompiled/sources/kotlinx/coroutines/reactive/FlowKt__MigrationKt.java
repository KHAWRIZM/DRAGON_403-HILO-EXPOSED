package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ContextKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\u001a)\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a)\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0004\u0010\f¨\u0006\r"}, d2 = {"", "T", "Lkf/a;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lkf/a;)Lkotlinx/coroutines/flow/Flow;", "asFlowDeprecated", "asPublisher", "(Lkotlinx/coroutines/flow/Flow;)Lkf/a;", "asPublisherDeprecated", "", "batchSize", "(Lkf/a;I)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-reactive"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/coroutines/reactive/FlowKt")
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class FlowKt__MigrationKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "batchSize parameter is deprecated, use .buffer() instead to control the backpressure", replaceWith = @ReplaceWith(expression = "asFlow().buffer(batchSize)", imports = {"kotlinx.coroutines.flow.*"}))
    public static final /* synthetic */ Flow asFlow(kf.a aVar, int i) {
        Flow buffer$default;
        buffer$default = FlowKt__ContextKt.buffer$default(ReactiveFlowKt.asFlow(aVar), i, null, 2, null);
        return buffer$default;
    }
}
