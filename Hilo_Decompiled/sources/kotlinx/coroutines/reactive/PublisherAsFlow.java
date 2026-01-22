package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B3\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0082@¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0082@¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0096@¢\u0006\u0004\b\u0018\u0010\u0012J\u001e\u0010\u001b\u001a\u00020\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0094@¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u001a\u0010#\u001a\u00020\u001e8BX\u0082\u0004¢\u0006\f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", "", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkf/a;", "publisher", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(Lkf/a;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collectSlowPath", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "injectContext", "collectImpl", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/ChannelFlow;", "collect", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "collectTo", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkf/a;", "", "getRequestSize", "()J", "getRequestSize$annotations", "()V", "requestSize", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactiveFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/PublisherAsFlow\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,269:1\n1#2:270\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class PublisherAsFlow<T> extends ChannelFlow<T> {

    @NotNull
    private final kf.a publisher;

    public /* synthetic */ PublisherAsFlow(kf.a aVar, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c1 A[Catch: all -> 0x0042, TRY_LEAVE, TryCatch #0 {all -> 0x0042, blocks: (B:12:0x003c, B:14:0x00b5, B:16:0x00c1, B:19:0x007f, B:27:0x009d, B:34:0x005b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d A[Catch: all -> 0x0042, TRY_ENTER, TryCatch #0 {all -> 0x0042, blocks: (B:12:0x003c, B:14:0x00b5, B:16:0x00c1, B:19:0x007f, B:27:0x009d, B:34:0x005b), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v8, types: [kotlinx.coroutines.reactive.ReactiveSubscriber] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00b2 -> B:13:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object collectImpl(CoroutineContext coroutineContext, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        PublisherAsFlow$collectImpl$1 publisherAsFlow$collectImpl$1;
        ReactiveSubscriber reactiveSubscriber;
        ReactiveSubscriber reactiveSubscriber2;
        PublisherAsFlow<T> publisherAsFlow;
        long j;
        FlowCollector<? super T> flowCollector2;
        PublisherAsFlow<T> publisherAsFlow2;
        FlowCollector<? super T> flowCollector3;
        long j2;
        ReactiveSubscriber reactiveSubscriber3;
        Object takeNextOrNull;
        try {
            if (continuation instanceof PublisherAsFlow$collectImpl$1) {
                publisherAsFlow$collectImpl$1 = (PublisherAsFlow$collectImpl$1) continuation;
                int i = publisherAsFlow$collectImpl$1.label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    publisherAsFlow$collectImpl$1.label = i - Integer.MIN_VALUE;
                    Object obj = publisherAsFlow$collectImpl$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    reactiveSubscriber = publisherAsFlow$collectImpl$1.label;
                    if (reactiveSubscriber == 0) {
                        if (reactiveSubscriber != 1) {
                            if (reactiveSubscriber == 2) {
                                j2 = publisherAsFlow$collectImpl$1.J$0;
                                ReactiveSubscriber reactiveSubscriber4 = (ReactiveSubscriber) publisherAsFlow$collectImpl$1.L$2;
                                flowCollector3 = (FlowCollector) publisherAsFlow$collectImpl$1.L$1;
                                publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                reactiveSubscriber = reactiveSubscriber4;
                                flowCollector2 = flowCollector3;
                                j = j2 + 1;
                                if (j == publisherAsFlow2.getRequestSize()) {
                                    reactiveSubscriber.makeRequest();
                                    j = 0;
                                }
                                publisherAsFlow = publisherAsFlow2;
                                reactiveSubscriber2 = reactiveSubscriber;
                                publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                                publisherAsFlow$collectImpl$1.L$1 = flowCollector2;
                                publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber2;
                                publisherAsFlow$collectImpl$1.J$0 = j;
                                publisherAsFlow$collectImpl$1.label = 1;
                                takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                                if (takeNextOrNull == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                flowCollector3 = flowCollector2;
                                obj = takeNextOrNull;
                                publisherAsFlow2 = publisherAsFlow;
                                j2 = j;
                                reactiveSubscriber3 = reactiveSubscriber2;
                                if (obj != null) {
                                    reactiveSubscriber3.cancel();
                                    return Unit.INSTANCE;
                                }
                                JobKt.ensureActive(publisherAsFlow$collectImpl$1.getContext());
                                publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow2;
                                publisherAsFlow$collectImpl$1.L$1 = flowCollector3;
                                publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber3;
                                publisherAsFlow$collectImpl$1.J$0 = j2;
                                publisherAsFlow$collectImpl$1.label = 2;
                                reactiveSubscriber = reactiveSubscriber3;
                                if (flowCollector3.emit(obj, publisherAsFlow$collectImpl$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                flowCollector2 = flowCollector3;
                                j = j2 + 1;
                                if (j == publisherAsFlow2.getRequestSize()) {
                                }
                                publisherAsFlow = publisherAsFlow2;
                                reactiveSubscriber2 = reactiveSubscriber;
                                publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                                publisherAsFlow$collectImpl$1.L$1 = flowCollector2;
                                publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber2;
                                publisherAsFlow$collectImpl$1.J$0 = j;
                                publisherAsFlow$collectImpl$1.label = 1;
                                takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                                if (takeNextOrNull == coroutine_suspended) {
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j2 = publisherAsFlow$collectImpl$1.J$0;
                            ReactiveSubscriber reactiveSubscriber5 = (ReactiveSubscriber) publisherAsFlow$collectImpl$1.L$2;
                            flowCollector3 = (FlowCollector) publisherAsFlow$collectImpl$1.L$1;
                            publisherAsFlow2 = (PublisherAsFlow) publisherAsFlow$collectImpl$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            reactiveSubscriber3 = reactiveSubscriber5;
                            if (obj != null) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ReactiveSubscriber reactiveSubscriber6 = new ReactiveSubscriber(this.capacity, this.onBufferOverflow, getRequestSize());
                        ReactiveFlowKt.injectCoroutineContext(this.publisher, coroutineContext).subscribe(reactiveSubscriber6);
                        reactiveSubscriber2 = reactiveSubscriber6;
                        publisherAsFlow = this;
                        j = 0;
                        flowCollector2 = flowCollector;
                        publisherAsFlow$collectImpl$1.L$0 = publisherAsFlow;
                        publisherAsFlow$collectImpl$1.L$1 = flowCollector2;
                        publisherAsFlow$collectImpl$1.L$2 = reactiveSubscriber2;
                        publisherAsFlow$collectImpl$1.J$0 = j;
                        publisherAsFlow$collectImpl$1.label = 1;
                        takeNextOrNull = reactiveSubscriber2.takeNextOrNull(publisherAsFlow$collectImpl$1);
                        if (takeNextOrNull == coroutine_suspended) {
                        }
                    }
                }
            }
            if (reactiveSubscriber == 0) {
            }
        } catch (Throwable th) {
            reactiveSubscriber.cancel();
            throw th;
        }
        publisherAsFlow$collectImpl$1 = new PublisherAsFlow$collectImpl$1(this, continuation);
        Object obj2 = publisherAsFlow$collectImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        reactiveSubscriber = publisherAsFlow$collectImpl$1.label;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object collectSlowPath(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PublisherAsFlow$collectSlowPath$2(flowCollector, this, null), continuation);
        if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    private final long getRequestSize() {
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            return Long.MAX_VALUE;
        }
        int i = this.capacity;
        if (i != -2) {
            if (i == 0) {
                return 1L;
            }
            if (i == Integer.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            long j = i;
            if (j < 1) {
                throw new IllegalStateException("Check failed.");
            }
            return j;
        }
        return Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core();
    }

    private static /* synthetic */ void getRequestSize$annotations() {
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow, kotlinx.coroutines.flow.Flow
    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContext = this.context;
        ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
        ContinuationInterceptor continuationInterceptor = coroutineContext.get(key);
        if (continuationInterceptor != null && !Intrinsics.areEqual(continuationInterceptor, context.get(key))) {
            Object collectSlowPath = collectSlowPath(flowCollector, continuation);
            if (collectSlowPath == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collectSlowPath;
            }
            return Unit.INSTANCE;
        }
        Object collectImpl = collectImpl(context.plus(this.context), flowCollector, continuation);
        if (collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collectImpl;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @Nullable
    public Object collectTo(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        Object collectImpl = collectImpl(producerScope.getCoroutineContext(), new SendingCollector(producerScope.getChannel()), continuation);
        if (collectImpl == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collectImpl;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    protected ChannelFlow<T> create(@NotNull CoroutineContext context, int capacity, @NotNull BufferOverflow onBufferOverflow) {
        return new PublisherAsFlow(this.publisher, context, capacity, onBufferOverflow);
    }

    public PublisherAsFlow(@NotNull kf.a aVar, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i, bufferOverflow);
        this.publisher = aVar;
    }
}
