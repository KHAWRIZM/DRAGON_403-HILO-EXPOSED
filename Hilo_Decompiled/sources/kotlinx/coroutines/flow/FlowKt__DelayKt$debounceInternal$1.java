package kotlinx.coroutines.flow;

import com.qiahao.nextvideo.room.manager.RoomEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.OnTimeoutKt;
import kotlinx.coroutines.selects.SelectImplementation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {RoomEvent.ROOM_FLOAT_CLOSE, 418}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
@SourceDebugExtension({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n14#2:408\n14#2:410\n1#3:409\n51#4,8:411\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n212#1:408\n215#1:410\n222#1:411,8\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00e2 -> B:6:0x001e). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref.ObjectRef objectRef;
        FlowCollector flowCollector;
        ReceiveChannel receiveChannel;
        FlowCollector flowCollector2;
        Ref.LongRef longRef;
        Ref.ObjectRef objectRef2;
        ReceiveChannel receiveChannel2;
        FlowCollector flowCollector3;
        SelectImplementation selectImplementation;
        FlowCollector flowCollector4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    objectRef2 = (Ref.ObjectRef) this.L$2;
                    receiveChannel2 = (ReceiveChannel) this.L$1;
                    flowCollector3 = (FlowCollector) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    flowCollector = flowCollector3;
                    receiveChannel = receiveChannel2;
                    objectRef = objectRef2;
                    if (objectRef.element == NullSurrogateKt.DONE) {
                        longRef = new Ref.LongRef();
                        Object obj2 = objectRef.element;
                        flowCollector2 = flowCollector;
                        if (obj2 != null) {
                            Function1<T, Long> function1 = this.$timeoutMillisSelector;
                            Symbol symbol = NullSurrogateKt.NULL;
                            if (obj2 == symbol) {
                                obj2 = null;
                            }
                            long longValue = ((Number) function1.invoke(obj2)).longValue();
                            longRef.element = longValue;
                            if (longValue >= 0) {
                                flowCollector2 = flowCollector;
                                if (longValue == 0) {
                                    Object obj3 = objectRef.element;
                                    if (obj3 == symbol) {
                                        obj3 = null;
                                    }
                                    this.L$0 = flowCollector;
                                    this.L$1 = receiveChannel;
                                    this.L$2 = objectRef;
                                    this.L$3 = longRef;
                                    this.label = 1;
                                    Object emit = flowCollector.emit(obj3, this);
                                    flowCollector4 = flowCollector;
                                    if (emit == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    objectRef.element = null;
                                    flowCollector2 = flowCollector4;
                                }
                            } else {
                                throw new IllegalArgumentException("Debounce timeout should not be negative");
                            }
                        }
                        Ref.LongRef longRef2 = longRef;
                        objectRef2 = objectRef;
                        receiveChannel2 = receiveChannel;
                        flowCollector3 = flowCollector2;
                        selectImplementation = new SelectImplementation(getContext());
                        if (objectRef2.element != null) {
                            OnTimeoutKt.onTimeout(selectImplementation, longRef2.element, new FlowKt__DelayKt$debounceInternal$1$3$1(flowCollector3, objectRef2, null));
                        }
                        selectImplementation.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector3, null));
                        this.L$0 = flowCollector3;
                        this.L$1 = receiveChannel2;
                        this.L$2 = objectRef2;
                        this.L$3 = null;
                        this.label = 2;
                        if (selectImplementation.doSelect(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector = flowCollector3;
                        receiveChannel = receiveChannel2;
                        objectRef = objectRef2;
                        if (objectRef.element == NullSurrogateKt.DONE) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                longRef = (Ref.LongRef) this.L$3;
                objectRef = (Ref.ObjectRef) this.L$2;
                receiveChannel = (ReceiveChannel) this.L$1;
                FlowCollector flowCollector5 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
                flowCollector4 = flowCollector5;
                objectRef.element = null;
                flowCollector2 = flowCollector4;
                Ref.LongRef longRef22 = longRef;
                objectRef2 = objectRef;
                receiveChannel2 = receiveChannel;
                flowCollector3 = flowCollector2;
                selectImplementation = new SelectImplementation(getContext());
                if (objectRef2.element != null) {
                }
                selectImplementation.invoke(receiveChannel2.getOnReceiveCatching(), new FlowKt__DelayKt$debounceInternal$1$3$2(objectRef2, flowCollector3, null));
                this.L$0 = flowCollector3;
                this.L$1 = receiveChannel2;
                this.L$2 = objectRef2;
                this.L$3 = null;
                this.label = 2;
                if (selectImplementation.doSelect(this) == coroutine_suspended) {
                }
                flowCollector = flowCollector3;
                receiveChannel = receiveChannel2;
                objectRef = objectRef2;
                if (objectRef.element == NullSurrogateKt.DONE) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FlowCollector flowCollector6 = (FlowCollector) this.L$1;
            ReceiveChannel produce$default = ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, 0, new FlowKt__DelayKt$debounceInternal$1$values$1(this.$this_debounceInternal, null), 3, (Object) null);
            objectRef = new Ref.ObjectRef();
            flowCollector = flowCollector6;
            receiveChannel = produce$default;
            if (objectRef.element == NullSurrogateKt.DONE) {
            }
        }
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }
}
