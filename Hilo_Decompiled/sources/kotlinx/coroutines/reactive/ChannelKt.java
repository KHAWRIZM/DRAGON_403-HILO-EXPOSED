package kotlinx.coroutines.reactive;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a4\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0086H¢\u0006\u0004\b\u0005\u0010\u0006\u001a/\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000b¨\u0006\r"}, d2 = {"T", "Lkf/a;", "Lkotlin/Function1;", "", "action", "collect", "(Lkf/a;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "request", "Lkotlinx/coroutines/channels/ReceiveChannel;", "toChannel", "(Lkf/a;I)Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channel.kt\nkotlinx/coroutines/reactive/ChannelKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,107:1\n81#2:108\n58#2,6:109\n82#2,2:115\n68#2:117\n64#2,3:118\n58#2,6:121\n82#2,2:127\n68#2:129\n64#2,3:130\n*S KotlinDebug\n*F\n+ 1 Channel.kt\nkotlinx/coroutines/reactive/ChannelKt\n*L\n15#1:108\n15#1:109,6\n15#1:115,2\n15#1:117\n15#1:118,3\n15#1:121,6\n15#1:127,2\n15#1:129\n15#1:130,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ChannelKt {
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[Catch: all -> 0x0078, TryCatch #1 {all -> 0x0078, blocks: (B:15:0x0066, B:17:0x006e, B:33:0x007b), top: B:14:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b A[Catch: all -> 0x0078, TRY_LEAVE, TryCatch #1 {all -> 0x0078, blocks: (B:15:0x0066, B:17:0x006e, B:33:0x007b), top: B:14:0x0066 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0062 -> B:13:0x0038). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object collect(@NotNull kf.a aVar, @NotNull Function1<? super T, Unit> function1, @NotNull Continuation<? super Unit> continuation) {
        ChannelKt$collect$1 channelKt$collect$1;
        int i;
        ReceiveChannel receiveChannel;
        Throwable th;
        ReceiveChannel receiveChannel2;
        ChannelIterator it;
        Object hasNext;
        try {
            if (continuation instanceof ChannelKt$collect$1) {
                channelKt$collect$1 = (ChannelKt$collect$1) continuation;
                int i2 = channelKt$collect$1.label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    channelKt$collect$1.label = i2 - Integer.MIN_VALUE;
                    Object obj = channelKt$collect$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelKt$collect$1.label;
                    if (i == 0) {
                        if (i == 1) {
                            it = (ChannelIterator) channelKt$collect$1.L$2;
                            receiveChannel = (ReceiveChannel) channelKt$collect$1.L$1;
                            Function1<? super T, Unit> function12 = (Function1) channelKt$collect$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                ChannelKt$collect$1 channelKt$collect$12 = channelKt$collect$1;
                                ReceiveChannel receiveChannel3 = receiveChannel;
                                function1 = function12;
                                ChannelKt$collect$1 channelKt$collect$13 = channelKt$collect$12;
                                try {
                                    if (!((Boolean) obj).booleanValue()) {
                                        function1.invoke(it.next());
                                        receiveChannel2 = receiveChannel3;
                                        channelKt$collect$1 = channelKt$collect$13;
                                        try {
                                            channelKt$collect$1.L$0 = function1;
                                            channelKt$collect$1.L$1 = receiveChannel2;
                                            channelKt$collect$1.L$2 = it;
                                            channelKt$collect$1.label = 1;
                                            hasNext = it.hasNext(channelKt$collect$1);
                                            if (hasNext != coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            channelKt$collect$12 = channelKt$collect$1;
                                            receiveChannel3 = receiveChannel2;
                                            obj = hasNext;
                                            ChannelKt$collect$1 channelKt$collect$132 = channelKt$collect$12;
                                            if (!((Boolean) obj).booleanValue()) {
                                                Unit unit = Unit.INSTANCE;
                                                InlineMarker.finallyStart(1);
                                                ChannelsKt.cancelConsumed(receiveChannel3, (Throwable) null);
                                                InlineMarker.finallyEnd(1);
                                                return Unit.INSTANCE;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            receiveChannel = receiveChannel2;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    receiveChannel = receiveChannel3;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        ReceiveChannel channel$default = toChannel$default(aVar, 0, 1, null);
                        try {
                            receiveChannel2 = channel$default;
                            it = channel$default.iterator();
                            channelKt$collect$1.L$0 = function1;
                            channelKt$collect$1.L$1 = receiveChannel2;
                            channelKt$collect$1.L$2 = it;
                            channelKt$collect$1.label = 1;
                            hasNext = it.hasNext(channelKt$collect$1);
                            if (hasNext != coroutine_suspended) {
                            }
                        } catch (Throwable th5) {
                            receiveChannel = channel$default;
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
        channelKt$collect$1 = new ChannelKt$collect$1(continuation);
        Object obj2 = channelKt$collect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelKt$collect$1.label;
        if (i == 0) {
        }
    }

    private static final <T> Object collect$$forInline(kf.a aVar, Function1<? super T, Unit> function1, Continuation<? super Unit> continuation) {
        ReceiveChannel channel$default = toChannel$default(aVar, 0, 1, null);
        try {
            ChannelIterator it = channel$default.iterator();
            while (true) {
                InlineMarker.mark(3);
                InlineMarker.mark(0);
                Object hasNext = it.hasNext((Continuation) null);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    function1.invoke(it.next());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(channel$default, (Throwable) null);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
            }
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Transforming publisher to channel is deprecated, use asFlow() instead")
    public static final /* synthetic */ ReceiveChannel openSubscription(kf.a aVar, int i) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i);
        aVar.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel openSubscription$default(kf.a aVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return openSubscription(aVar, i);
    }

    @PublishedApi
    @NotNull
    public static final <T> ReceiveChannel<T> toChannel(@NotNull kf.a aVar, int i) {
        SubscriptionChannel subscriptionChannel = new SubscriptionChannel(i);
        aVar.subscribe(subscriptionChannel);
        return subscriptionChannel;
    }

    public static /* synthetic */ ReceiveChannel toChannel$default(kf.a aVar, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return toChannel(aVar, i);
    }
}
