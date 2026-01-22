package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {211, 212, 213, 217, 218}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class ChannelsKt__DeprecatedKt$dropWhile$1 extends SuspendLambda implements Function2 {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ ReceiveChannel $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_dropWhile = receiveChannel;
        this.$predicate = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelsKt__DeprecatedKt$dropWhile$1 channelsKt__DeprecatedKt$dropWhile$1 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, continuation);
        channelsKt__DeprecatedKt$dropWhile$1.L$0 = obj;
        return channelsKt__DeprecatedKt$dropWhile$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00d1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00ec -> B:9:0x0023). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x009f -> B:28:0x0054). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        ChannelIterator it;
        ProducerScope producerScope;
        ProducerScope producerScope2;
        ChannelIterator it2;
        ProducerScope producerScope3;
        ChannelIterator channelIterator;
        Object hasNext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                channelIterator = (ChannelIterator) this.L$1;
                                producerScope3 = (ProducerScope) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                it2 = channelIterator;
                                producerScope2 = producerScope3;
                                this.L$0 = producerScope2;
                                this.L$1 = it2;
                                this.label = 4;
                                hasNext = it2.hasNext(this);
                                if (hasNext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ProducerScope producerScope4 = producerScope2;
                                channelIterator = it2;
                                obj = hasNext;
                                producerScope3 = producerScope4;
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = channelIterator.next();
                                    this.L$0 = producerScope3;
                                    this.L$1 = channelIterator;
                                    this.label = 5;
                                    if (producerScope3.send(next, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it2 = channelIterator;
                                    producerScope2 = producerScope3;
                                    this.L$0 = producerScope2;
                                    this.L$1 = it2;
                                    this.label = 4;
                                    hasNext = it2.hasNext(this);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } else {
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            channelIterator = (ChannelIterator) this.L$1;
                            producerScope3 = (ProducerScope) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    } else {
                        producerScope2 = (ProducerScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        it2 = this.$this_dropWhile.iterator();
                        this.L$0 = producerScope2;
                        this.L$1 = it2;
                        this.label = 4;
                        hasNext = it2.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                } else {
                    Object obj2 = this.L$2;
                    ChannelIterator channelIterator2 = (ChannelIterator) this.L$1;
                    ProducerScope producerScope5 = (ProducerScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    ChannelIterator channelIterator3 = channelIterator2;
                    Object obj3 = obj2;
                    it = channelIterator3;
                    if (((Boolean) obj).booleanValue()) {
                        this.L$0 = producerScope5;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 3;
                        if (producerScope5.send(obj3, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        producerScope2 = producerScope5;
                        it2 = this.$this_dropWhile.iterator();
                        this.L$0 = producerScope2;
                        this.L$1 = it2;
                        this.label = 4;
                        hasNext = it2.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else {
                        producerScope = producerScope5;
                        this.L$0 = producerScope;
                        this.L$1 = it;
                        this.L$2 = null;
                        this.label = 1;
                        obj = it.hasNext(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ProducerScope producerScope6 = producerScope;
                        ChannelIterator channelIterator4 = it;
                        producerScope2 = producerScope6;
                        if (((Boolean) obj).booleanValue()) {
                            Object next2 = channelIterator4.next();
                            Function2 function2 = this.$predicate;
                            this.L$0 = producerScope2;
                            this.L$1 = channelIterator4;
                            this.L$2 = next2;
                            this.label = 2;
                            Object invoke = function2.invoke(next2, this);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channelIterator3 = channelIterator4;
                            obj3 = next2;
                            obj = invoke;
                            producerScope5 = producerScope2;
                            it = channelIterator3;
                            if (((Boolean) obj).booleanValue()) {
                            }
                        }
                        it2 = this.$this_dropWhile.iterator();
                        this.L$0 = producerScope2;
                        this.L$1 = it2;
                        this.label = 4;
                        hasNext = it2.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            } else {
                it = (ChannelIterator) this.L$1;
                producerScope = (ProducerScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ProducerScope producerScope62 = producerScope;
                ChannelIterator channelIterator42 = it;
                producerScope2 = producerScope62;
                if (((Boolean) obj).booleanValue()) {
                }
                it2 = this.$this_dropWhile.iterator();
                this.L$0 = producerScope2;
                this.L$1 = it2;
                this.label = 4;
                hasNext = it2.hasNext(this);
                if (hasNext == coroutine_suspended) {
                }
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope7 = (ProducerScope) this.L$0;
            it = this.$this_dropWhile.iterator();
            producerScope = producerScope7;
            this.L$0 = producerScope;
            this.L$1 = it;
            this.L$2 = null;
            this.label = 1;
            obj = it.hasNext(this);
            if (obj == coroutine_suspended) {
            }
            ProducerScope producerScope622 = producerScope;
            ChannelIterator channelIterator422 = it;
            producerScope2 = producerScope622;
            if (((Boolean) obj).booleanValue()) {
            }
            it2 = this.$this_dropWhile.iterator();
            this.L$0 = producerScope2;
            this.L$1 = it2;
            this.label = 4;
            hasNext = it2.hasNext(this);
            if (hasNext == coroutine_suspended) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull ProducerScope producerScope, @Nullable Continuation continuation) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
