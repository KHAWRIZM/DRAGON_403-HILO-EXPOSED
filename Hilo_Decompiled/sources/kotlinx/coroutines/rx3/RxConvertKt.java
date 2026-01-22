package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.b0;
import io.reactivex.rxjava3.core.c0;
import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.i0;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.z;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.reactive.ReactiveFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a2\u0010\t\u001a\n\u0012\u0006\u0012\u0004\b\u00028\u00000\b\"\u0004\b\u0000\u0010\u0006*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00072\u0006\u0010\u0002\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\b\b\u0000\u0010\u0006*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\b\b\u0000\u0010\u0006*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012\u001a1\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\b\b\u0000\u0010\u0006*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0006*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a3\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\b\b\u0000\u0010\u0006*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0019\u0010\u0018\u001a3\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\b\b\u0000\u0010\u0006*\u00020\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00102\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0019\u0010\u0015\u0082\u0002\u0004\n\u0002\b9¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext;", "context", "Lio/reactivex/rxjava3/core/b;", "asCompletable", "(Lkotlinx/coroutines/Job;Lkotlin/coroutines/CoroutineContext;)Lio/reactivex/rxjava3/core/b;", "T", "Lkotlinx/coroutines/Deferred;", "Lio/reactivex/rxjava3/core/j;", "asMaybe", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/CoroutineContext;)Lio/reactivex/rxjava3/core/j;", "", "Lio/reactivex/rxjava3/core/i0;", "asSingle", "(Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/CoroutineContext;)Lio/reactivex/rxjava3/core/i0;", "Lio/reactivex/rxjava3/core/e0;", "Lkotlinx/coroutines/flow/Flow;", "asFlow", "(Lio/reactivex/rxjava3/core/e0;)Lkotlinx/coroutines/flow/Flow;", "Lio/reactivex/rxjava3/core/z;", "asObservable", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lio/reactivex/rxjava3/core/z;", "Lio/reactivex/rxjava3/core/h;", "asFlowable", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/coroutines/CoroutineContext;)Lio/reactivex/rxjava3/core/h;", "from", "_asFlowable", "_asObservable", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RxConvertKt {
    @NotNull
    public static final io.reactivex.rxjava3.core.b asCompletable(@NotNull Job job, @NotNull CoroutineContext coroutineContext) {
        return RxCompletableKt.rxCompletable(coroutineContext, new RxConvertKt$asCompletable$1(job, null));
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull e0 e0Var) {
        return FlowKt.callbackFlow(new RxConvertKt$asFlow$1(e0Var, null));
    }

    @NotNull
    public static final <T> io.reactivex.rxjava3.core.h<T> asFlowable(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return io.reactivex.rxjava3.core.h.d(ReactiveFlowKt.asPublisher(flow, coroutineContext));
    }

    public static /* synthetic */ io.reactivex.rxjava3.core.h asFlowable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    @NotNull
    public static final <T> j<T> asMaybe(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext coroutineContext) {
        return RxMaybeKt.rxMaybe(coroutineContext, new RxConvertKt$asMaybe$1(deferred, null));
    }

    @NotNull
    public static final <T> z<T> asObservable(@NotNull final Flow<? extends T> flow, @NotNull final CoroutineContext coroutineContext) {
        return z.create(new c0() { // from class: kotlinx.coroutines.rx3.b
            public final void a(b0 b0Var) {
                RxConvertKt.asObservable$lambda$0(coroutineContext, flow, b0Var);
            }
        });
    }

    public static /* synthetic */ z asObservable$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asObservable$lambda$0(CoroutineContext coroutineContext, Flow flow, b0 b0Var) {
        b0Var.a(new RxCancellable(BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), CoroutineStart.ATOMIC, new RxConvertKt$asObservable$1$job$1(flow, b0Var, null))));
    }

    @NotNull
    public static final <T> i0<T> asSingle(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext coroutineContext) {
        return RxSingleKt.rxSingle(coroutineContext, new RxConvertKt$asSingle$1(deferred, null));
    }

    public static /* synthetic */ io.reactivex.rxjava3.core.h from$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    /* renamed from: from$default, reason: collision with other method in class */
    public static /* synthetic */ z m٢٤٦from$default(Flow flow, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }
}
