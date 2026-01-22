package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.AbstractTimeSource;
import kotlinx.coroutines.AbstractTimeSourceKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.EventLoop_commonKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a,\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTickerChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TickerChannels.kt\nkotlinx/coroutines/channels/TickerChannelsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,108:1\n1#2:109\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class TickerChannelsKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007d -> B:12:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedDelayTicker(long j10, long j11, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedDelayTicker$1 tickerChannelsKt$fixedDelayTicker$1;
        Object coroutine_suspended;
        int i10;
        SendChannel<? super Unit> sendChannel2;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedDelayTicker$1) {
            tickerChannelsKt$fixedDelayTicker$1 = (TickerChannelsKt$fixedDelayTicker$1) continuation;
            int i11 = tickerChannelsKt$fixedDelayTicker$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedDelayTicker$1.label = i11 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedDelayTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = tickerChannelsKt$fixedDelayTicker$1.label;
                if (i10 == 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                j10 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                                sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                                ResultKt.throwOnFailure(obj);
                                sendChannel = sendChannel2;
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            j10 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                            sendChannel2 = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedDelayTicker$1.J$0 = j10;
                            tickerChannelsKt$fixedDelayTicker$1.label = 3;
                            if (DelayKt.delay(j10, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel = sendChannel2;
                        }
                    } else {
                        j10 = tickerChannelsKt$fixedDelayTicker$1.J$0;
                        sendChannel = (SendChannel) tickerChannelsKt$fixedDelayTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                    tickerChannelsKt$fixedDelayTicker$1.J$0 = j10;
                    tickerChannelsKt$fixedDelayTicker$1.label = 1;
                    if (DelayKt.delay(j11, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j10;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sendChannel2 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j10;
                tickerChannelsKt$fixedDelayTicker$1.label = 3;
                if (DelayKt.delay(j10, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
                sendChannel = sendChannel2;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
                tickerChannelsKt$fixedDelayTicker$1.J$0 = j10;
                tickerChannelsKt$fixedDelayTicker$1.label = 2;
                if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedDelayTicker$1 = new TickerChannelsKt$fixedDelayTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedDelayTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = tickerChannelsKt$fixedDelayTicker$1.label;
        if (i10 == 0) {
        }
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedDelayTicker$1.L$0 = sendChannel;
        tickerChannelsKt$fixedDelayTicker$1.J$0 = j10;
        tickerChannelsKt$fixedDelayTicker$1.label = 2;
        if (sendChannel.send(unit, tickerChannelsKt$fixedDelayTicker$1) == coroutine_suspended) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x010e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00f3 -> B:13:0x0052). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x010c -> B:13:0x0052). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object fixedPeriodTicker(long j10, long j11, SendChannel<? super Unit> sendChannel, Continuation<? super Unit> continuation) {
        TickerChannelsKt$fixedPeriodTicker$1 tickerChannelsKt$fixedPeriodTicker$1;
        Object coroutine_suspended;
        int i10;
        long nanoTime;
        SendChannel sendChannel2;
        long j12;
        long j13;
        long delayToNanos;
        long j14;
        long j15;
        SendChannel sendChannel3;
        AbstractTimeSource abstractTimeSource;
        long nanoTime2;
        long coerceAtLeast;
        long delayNanosToMillis;
        Unit unit;
        if (continuation instanceof TickerChannelsKt$fixedPeriodTicker$1) {
            tickerChannelsKt$fixedPeriodTicker$1 = (TickerChannelsKt$fixedPeriodTicker$1) continuation;
            int i11 = tickerChannelsKt$fixedPeriodTicker$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                tickerChannelsKt$fixedPeriodTicker$1.label = i11 - Integer.MIN_VALUE;
                Object obj = tickerChannelsKt$fixedPeriodTicker$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = tickerChannelsKt$fixedPeriodTicker$1.label;
                if (i10 == 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 == 4) {
                                    j15 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                    j14 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                    sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                    ResultKt.throwOnFailure(obj);
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                j15 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                                j14 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                                sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                                ResultKt.throwOnFailure(obj);
                            }
                            long j16 = j15;
                            j13 = j14;
                            delayToNanos = j16;
                            sendChannel2 = sendChannel3;
                            long j17 = j13 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j17;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            sendChannel3 = sendChannel2;
                            j15 = delayToNanos;
                            j14 = j17;
                            abstractTimeSource = AbstractTimeSourceKt.timeSource;
                            if (abstractTimeSource == null) {
                                nanoTime2 = abstractTimeSource.nanoTime();
                            } else {
                                nanoTime2 = System.nanoTime();
                            }
                            coerceAtLeast = RangesKt.coerceAtLeast(j14 - nanoTime2, 0L);
                            if (coerceAtLeast != 0 && j15 != 0) {
                                long j18 = j15 - ((nanoTime2 - j14) % j15);
                                j14 = nanoTime2 + j18;
                                long delayNanosToMillis2 = EventLoop_commonKt.delayNanosToMillis(j18);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j14;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j15;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 3;
                                if (DelayKt.delay(delayNanosToMillis2, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j14;
                                tickerChannelsKt$fixedPeriodTicker$1.J$1 = j15;
                                tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                                if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            long j162 = j15;
                            j13 = j14;
                            delayToNanos = j162;
                            sendChannel2 = sendChannel3;
                            long j172 = j13 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j172;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                        } else {
                            j15 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                            j14 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                            sendChannel3 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            abstractTimeSource = AbstractTimeSourceKt.timeSource;
                            if (abstractTimeSource == null) {
                            }
                            coerceAtLeast = RangesKt.coerceAtLeast(j14 - nanoTime2, 0L);
                            if (coerceAtLeast != 0) {
                            }
                            delayNanosToMillis = EventLoop_commonKt.delayNanosToMillis(coerceAtLeast);
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel3;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j14;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = j15;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 4;
                            if (DelayKt.delay(delayNanosToMillis, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                            long j1622 = j15;
                            j13 = j14;
                            delayToNanos = j1622;
                            sendChannel2 = sendChannel3;
                            long j1722 = j13 + delayToNanos;
                            unit = Unit.INSTANCE;
                            tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                            tickerChannelsKt$fixedPeriodTicker$1.J$0 = j1722;
                            tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                            tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                            if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                            }
                        }
                    } else {
                        j13 = tickerChannelsKt$fixedPeriodTicker$1.J$1;
                        long j19 = tickerChannelsKt$fixedPeriodTicker$1.J$0;
                        SendChannel sendChannel4 = (SendChannel) tickerChannelsKt$fixedPeriodTicker$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        sendChannel2 = sendChannel4;
                        j12 = j19;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AbstractTimeSource abstractTimeSource2 = AbstractTimeSourceKt.timeSource;
                    if (abstractTimeSource2 != null) {
                        nanoTime = abstractTimeSource2.nanoTime();
                    } else {
                        nanoTime = System.nanoTime();
                    }
                    long delayToNanos2 = nanoTime + EventLoop_commonKt.delayToNanos(j11);
                    sendChannel2 = sendChannel;
                    tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                    j12 = j10;
                    tickerChannelsKt$fixedPeriodTicker$1.J$0 = j12;
                    tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos2;
                    tickerChannelsKt$fixedPeriodTicker$1.label = 1;
                    if (DelayKt.delay(j11, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j13 = delayToNanos2;
                }
                delayToNanos = EventLoop_commonKt.delayToNanos(j12);
                long j17222 = j13 + delayToNanos;
                unit = Unit.INSTANCE;
                tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
                tickerChannelsKt$fixedPeriodTicker$1.J$0 = j17222;
                tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
                tickerChannelsKt$fixedPeriodTicker$1.label = 2;
                if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
                }
            }
        }
        tickerChannelsKt$fixedPeriodTicker$1 = new TickerChannelsKt$fixedPeriodTicker$1(continuation);
        Object obj2 = tickerChannelsKt$fixedPeriodTicker$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = tickerChannelsKt$fixedPeriodTicker$1.label;
        if (i10 == 0) {
        }
        delayToNanos = EventLoop_commonKt.delayToNanos(j12);
        long j172222 = j13 + delayToNanos;
        unit = Unit.INSTANCE;
        tickerChannelsKt$fixedPeriodTicker$1.L$0 = sendChannel2;
        tickerChannelsKt$fixedPeriodTicker$1.J$0 = j172222;
        tickerChannelsKt$fixedPeriodTicker$1.J$1 = delayToNanos;
        tickerChannelsKt$fixedPeriodTicker$1.label = 2;
        if (sendChannel2.send(unit, tickerChannelsKt$fixedPeriodTicker$1) == coroutine_suspended) {
        }
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final ReceiveChannel<Unit> ticker(long j10, long j11, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        if (j10 >= 0) {
            if (j11 >= 0) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), 0, new TickerChannelsKt$ticker$3(tickerMode, j10, j11, null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j11 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j10 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j10, long j11, CoroutineContext coroutineContext, TickerMode tickerMode, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = j10;
        }
        if ((i10 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i10 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j10, j11, coroutineContext, tickerMode);
    }
}
