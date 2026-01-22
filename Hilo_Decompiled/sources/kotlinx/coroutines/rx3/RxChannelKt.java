package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.n;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a*\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0006\u001a9\u0010\n\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a9\u0010\n\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\f\u0082\u0002\u0004\n\u0002\b9¨\u0006\r"}, d2 = {"T", "Lio/reactivex/rxjava3/core/n;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "(Lio/reactivex/rxjava3/core/n;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lio/reactivex/rxjava3/core/e0;", "(Lio/reactivex/rxjava3/core/e0;)Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlin/Function1;", "", "action", "collect", "(Lio/reactivex/rxjava3/core/n;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/reactivex/rxjava3/core/e0;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRxChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxChannel.kt\nkotlinx/coroutines/rx3/RxChannelKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,87:1\n81#2:88\n58#2,6:89\n82#2,2:95\n68#2:97\n64#2,3:98\n58#2,6:101\n82#2,2:107\n68#2:109\n64#2,3:110\n81#2:113\n58#2,6:114\n82#2,2:120\n68#2:122\n64#2,3:123\n81#2:126\n58#2,6:127\n82#2,2:133\n68#2:135\n64#2,3:136\n*S KotlinDebug\n*F\n+ 1 RxChannel.kt\nkotlinx/coroutines/rx3/RxChannelKt\n*L\n44#1:88\n44#1:89,6\n44#1:95,2\n44#1:97\n44#1:98,3\n44#1:101,6\n44#1:107,2\n44#1:109\n44#1:110,3\n52#1:113\n52#1:114,6\n52#1:120,2\n52#1:122\n52#1:123,3\n52#1:126\n52#1:127,6\n52#1:133,2\n52#1:135\n52#1:136,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RxChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:15:0x0064, B:17:0x006c, B:33:0x0079), top: B:14:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #1 {all -> 0x0076, blocks: (B:15:0x0064, B:17:0x006c, B:33:0x0079), top: B:14:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0060 -> B:13:0x0037). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(@NotNull n nVar, @NotNull Function1<? super T, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        RxChannelKt$collect$1 rxChannelKt$collect$1;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        Object hasNext;
        try {
            if (continuation instanceof RxChannelKt$collect$1) {
                rxChannelKt$collect$1 = (RxChannelKt$collect$1) continuation;
                int i2 = rxChannelKt$collect$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    rxChannelKt$collect$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = rxChannelKt$collect$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = rxChannelKt$collect$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel openSubscription = openSubscription(nVar);
                        try {
                            receiveChannel2 = openSubscription;
                            it = openSubscription.iterator();
                            rxChannelKt$collect$1.L$0 = function1;
                            rxChannelKt$collect$1.L$1 = receiveChannel2;
                            rxChannelKt$collect$1.L$2 = it;
                            rxChannelKt$collect$1.label = 1;
                            hasNext = it.hasNext(rxChannelKt$collect$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th2) {
                            receiveChannel = openSubscription;
                            th = th2;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (ChannelIterator) rxChannelKt$collect$1.L$2;
                        receiveChannel = (ReceiveChannel) rxChannelKt$collect$1.L$1;
                        Function1<? super T, Unit> function12 = (Function1) rxChannelKt$collect$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            RxChannelKt$collect$1 rxChannelKt$collect$12 = rxChannelKt$collect$1;
                            ReceiveChannel receiveChannel3 = receiveChannel;
                            function1 = function12;
                            RxChannelKt$collect$1 rxChannelKt$collect$13 = rxChannelKt$collect$12;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function1.invoke(it.next());
                                    receiveChannel2 = receiveChannel3;
                                    rxChannelKt$collect$1 = rxChannelKt$collect$13;
                                    try {
                                        rxChannelKt$collect$1.L$0 = function1;
                                        rxChannelKt$collect$1.L$1 = receiveChannel2;
                                        rxChannelKt$collect$1.L$2 = it;
                                        rxChannelKt$collect$1.label = 1;
                                        hasNext = it.hasNext(rxChannelKt$collect$1);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        rxChannelKt$collect$12 = rxChannelKt$collect$1;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        RxChannelKt$collect$1 rxChannelKt$collect$132 = rxChannelKt$collect$12;
                                        if (!((Boolean) obj).booleanValue()) {
                                            Unit unit = Unit.INSTANCE;
                                            InlineMarker.finallyStart(1);
                                            ChannelsKt.cancelConsumed(receiveChannel3, (Throwable) null);
                                            InlineMarker.finallyEnd(1);
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        receiveChannel = receiveChannel2;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                receiveChannel = receiveChannel3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th6) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(1);
            throw th6;
        }
        rxChannelKt$collect$1 = new RxChannelKt$collect$1(continuation);
        Object obj2 = rxChannelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxChannelKt$collect$1.label;
        if (i != 0) {
        }
    }

    private static final <T> Object collect$$forInline(n nVar, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel openSubscription = openSubscription(nVar);
        try {
            ChannelIterator it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext((Continuation) null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(openSubscription, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    @PublishedApi
    @NotNull
    public static final <T> ReceiveChannel<T> openSubscription(@NotNull n nVar) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        nVar.a(subscriptionChannel);
        return subscriptionChannel;
    }

    @PublishedApi
    @NotNull
    public static final <T> ReceiveChannel<T> openSubscription(@NotNull e0 e0Var) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel();
        e0Var.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    private static final <T> Object collect$$forInline(e0 e0Var, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel openSubscription = openSubscription(e0Var);
        try {
            ChannelIterator it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext((Continuation) null);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(openSubscription, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006c A[Catch: all -> 0x0076, TryCatch #1 {all -> 0x0076, blocks: (B:15:0x0064, B:17:0x006c, B:33:0x0079), top: B:14:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #1 {all -> 0x0076, blocks: (B:15:0x0064, B:17:0x006c, B:33:0x0079), top: B:14:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0060 -> B:13:0x0037). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(@NotNull e0 e0Var, @NotNull Function1<? super T, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        RxChannelKt$collect$2 rxChannelKt$collect$2;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        Object hasNext;
        try {
            if (continuation instanceof RxChannelKt$collect$2) {
                rxChannelKt$collect$2 = (RxChannelKt$collect$2) continuation;
                int i2 = rxChannelKt$collect$2.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    rxChannelKt$collect$2.label = i2 - Integer.MIN_VALUE;
                    Object obj = rxChannelKt$collect$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = rxChannelKt$collect$2.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel openSubscription = openSubscription(e0Var);
                        try {
                            receiveChannel2 = openSubscription;
                            it = openSubscription.iterator();
                            rxChannelKt$collect$2.L$0 = function1;
                            rxChannelKt$collect$2.L$1 = receiveChannel2;
                            rxChannelKt$collect$2.L$2 = it;
                            rxChannelKt$collect$2.label = 1;
                            hasNext = it.hasNext(rxChannelKt$collect$2);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th2) {
                            receiveChannel = openSubscription;
                            th = th2;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        it = (ChannelIterator) rxChannelKt$collect$2.L$2;
                        receiveChannel = (ReceiveChannel) rxChannelKt$collect$2.L$1;
                        Function1<? super T, Unit> function12 = (Function1) rxChannelKt$collect$2.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            RxChannelKt$collect$2 rxChannelKt$collect$22 = rxChannelKt$collect$2;
                            ReceiveChannel receiveChannel3 = receiveChannel;
                            function1 = function12;
                            RxChannelKt$collect$2 rxChannelKt$collect$23 = rxChannelKt$collect$22;
                            try {
                                if (!((Boolean) obj).booleanValue()) {
                                    function1.invoke(it.next());
                                    receiveChannel2 = receiveChannel3;
                                    rxChannelKt$collect$2 = rxChannelKt$collect$23;
                                    try {
                                        rxChannelKt$collect$2.L$0 = function1;
                                        rxChannelKt$collect$2.L$1 = receiveChannel2;
                                        rxChannelKt$collect$2.L$2 = it;
                                        rxChannelKt$collect$2.label = 1;
                                        hasNext = it.hasNext(rxChannelKt$collect$2);
                                        if (hasNext != coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        rxChannelKt$collect$22 = rxChannelKt$collect$2;
                                        receiveChannel3 = receiveChannel2;
                                        obj = hasNext;
                                        RxChannelKt$collect$2 rxChannelKt$collect$232 = rxChannelKt$collect$22;
                                        if (!((Boolean) obj).booleanValue()) {
                                            Unit unit = Unit.INSTANCE;
                                            InlineMarker.finallyStart(1);
                                            ChannelsKt.cancelConsumed(receiveChannel3, (Throwable) null);
                                            InlineMarker.finallyEnd(1);
                                            return Unit.INSTANCE;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        receiveChannel = receiveChannel2;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                receiveChannel = receiveChannel3;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th6) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(1);
            throw th6;
        }
        rxChannelKt$collect$2 = new RxChannelKt$collect$2(continuation);
        Object obj2 = rxChannelKt$collect$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxChannelKt$collect$2.label;
        if (i != 0) {
        }
    }
}
