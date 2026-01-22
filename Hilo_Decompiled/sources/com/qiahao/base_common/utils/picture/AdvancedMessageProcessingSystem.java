package com.qiahao.base_common.utils.picture;

import androidx.collection.c;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.model.MessageTaskData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u00014Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u00126\b\u0002\u0010\t\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010!\u001a\u00020\rJ\u001c\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0086@¢\u0006\u0002\u0010%J\"\u0010&\u001a\u00020\u00062\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0'H\u0086@¢\u0006\u0002\u0010(J,\u0010)\u001a\u00020\r2\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010,J\u0006\u0010-\u001a\u00020.J\u001a\u0010/\u001a\u00020\r2\b\b\u0002\u00100\u001a\u000201H\u0086@¢\u0006\u0004\b2\u00103R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\t\u001a0\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\u00170\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem;", "T", "", "name", "", "concurrency", "", "bufferSize", "priorityLevels", "messageHandler", "Lkotlin/Function4;", "Lcom/qiahao/base_common/model/MessageTaskData;", "Lkotlin/coroutines/Continuation;", "", "<init>", "(Ljava/lang/String;IIILkotlin/jvm/functions/Function4;)V", "Lkotlin/jvm/functions/Function4;", "job", "Lkotlinx/coroutines/CompletableJob;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "priorityChannels", "", "Lkotlinx/coroutines/channels/Channel;", "[Lkotlinx/coroutines/channels/Channel;", "channelMessageCounts", "Ljava/util/concurrent/atomic/AtomicInteger;", "[Ljava/util/concurrent/atomic/AtomicInteger;", "isStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "processedCount", "Ljava/util/concurrent/atomic/AtomicLong;", "failedCount", "start", "submitMessage", "", "messageTaskData", "(Lcom/qiahao/base_common/model/MessageTaskData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "submitMessages", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processMessage", "workerId", "priority", "(Lcom/qiahao/base_common/model/MessageTaskData;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStatus", "Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem$SystemStatus;", "shutdown", "timeout", "Lkotlin/time/Duration;", "shutdown-VtjQ1oo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SystemStatus", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAdvancedMessageProcessingSystem.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdvancedMessageProcessingSystem.kt\ncom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,250:1\n1869#2,2:251\n11228#3:253\n11563#3,3:254\n13472#3,2:257\n*S KotlinDebug\n*F\n+ 1 AdvancedMessageProcessingSystem.kt\ncom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem\n*L\n119#1:251,2\n144#1:253\n144#1:254,3\n160#1:257,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AdvancedMessageProcessingSystem<T> {
    private final int bufferSize;

    @NotNull
    private final AtomicInteger[] channelMessageCounts;
    private final int concurrency;

    @NotNull
    private final AtomicLong failedCount;

    @NotNull
    private final AtomicBoolean isStarted;

    @NotNull
    private CompletableJob job;

    @NotNull
    private final Function4<MessageTaskData<T>, Integer, Integer, Continuation<? super Unit>, Object> messageHandler;

    @NotNull
    private final String name;

    @NotNull
    private Channel<MessageTaskData<T>>[] priorityChannels;
    private final int priorityLevels;

    @NotNull
    private final AtomicLong processedCount;

    @NotNull
    private CoroutineScope scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "T", "messageTaskData", "Lcom/qiahao/base_common/model/MessageTaskData;", "workerId", "", "priority"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem$1", f = "AdvancedMessageProcessingSystem.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function4<MessageTaskData<T>, Integer, Integer, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(4, continuation);
        }

        public final Object invoke(MessageTaskData<T> messageTaskData, int i10, int i11, Continuation<? super Unit> continuation) {
            return new AnonymousClass1(continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Integer num, Integer num2, Continuation<? super Unit> continuation) {
            return invoke((MessageTaskData) obj, num.intValue(), num2.intValue(), continuation);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\nH\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J;\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/utils/picture/AdvancedMessageProcessingSystem$SystemStatus;", "", "name", "", "processed", "", "failed", "queueSizes", "", "activeWorkers", "", "<init>", "(Ljava/lang/String;JJ[II)V", "getName", "()Ljava/lang/String;", "getProcessed", "()J", "getFailed", "getQueueSizes", "()[I", "getActiveWorkers", "()I", "equals", "", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "copy", "toString", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final /* data */ class SystemStatus {
        private final int activeWorkers;
        private final long failed;

        @NotNull
        private final String name;
        private final long processed;

        @NotNull
        private final int[] queueSizes;

        public SystemStatus(@NotNull String name, long j10, long j11, @NotNull int[] queueSizes, int i10) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(queueSizes, "queueSizes");
            this.name = name;
            this.processed = j10;
            this.failed = j11;
            this.queueSizes = queueSizes;
            this.activeWorkers = i10;
        }

        public static /* synthetic */ SystemStatus copy$default(SystemStatus systemStatus, String str, long j10, long j11, int[] iArr, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = systemStatus.name;
            }
            if ((i11 & 2) != 0) {
                j10 = systemStatus.processed;
            }
            long j12 = j10;
            if ((i11 & 4) != 0) {
                j11 = systemStatus.failed;
            }
            long j13 = j11;
            if ((i11 & 8) != 0) {
                iArr = systemStatus.queueSizes;
            }
            int[] iArr2 = iArr;
            if ((i11 & 16) != 0) {
                i10 = systemStatus.activeWorkers;
            }
            return systemStatus.copy(str, j12, j13, iArr2, i10);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final long getProcessed() {
            return this.processed;
        }

        /* renamed from: component3, reason: from getter */
        public final long getFailed() {
            return this.failed;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final int[] getQueueSizes() {
            return this.queueSizes;
        }

        /* renamed from: component5, reason: from getter */
        public final int getActiveWorkers() {
            return this.activeWorkers;
        }

        @NotNull
        public final SystemStatus copy(@NotNull String name, long processed, long failed, @NotNull int[] queueSizes, int activeWorkers) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(queueSizes, "queueSizes");
            return new SystemStatus(name, processed, failed, queueSizes, activeWorkers);
        }

        public boolean equals(@Nullable Object other) {
            Class<?> cls;
            if (this == other) {
                return true;
            }
            if (other != null) {
                cls = other.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(SystemStatus.class, cls)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.qiahao.base_common.utils.picture.AdvancedMessageProcessingSystem.SystemStatus");
            SystemStatus systemStatus = (SystemStatus) other;
            if (Intrinsics.areEqual(this.name, systemStatus.name) && this.processed == systemStatus.processed && this.failed == systemStatus.failed && Arrays.equals(this.queueSizes, systemStatus.queueSizes) && this.activeWorkers == systemStatus.activeWorkers) {
                return true;
            }
            return false;
        }

        public final int getActiveWorkers() {
            return this.activeWorkers;
        }

        public final long getFailed() {
            return this.failed;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final long getProcessed() {
            return this.processed;
        }

        @NotNull
        public final int[] getQueueSizes() {
            return this.queueSizes;
        }

        public int hashCode() {
            return (((((((this.name.hashCode() * 31) + c.a(this.processed)) * 31) + c.a(this.failed)) * 31) + Arrays.hashCode(this.queueSizes)) * 31) + this.activeWorkers;
        }

        @NotNull
        public String toString() {
            return "SystemStatus(name=" + this.name + ", processed=" + this.processed + ", failed=" + this.failed + ", queueSizes=" + Arrays.toString(this.queueSizes) + ", activeWorkers=" + this.activeWorkers + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdvancedMessageProcessingSystem(@NotNull String name, int i10, int i11, int i12, @NotNull Function4<? super MessageTaskData<T>, ? super Integer, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> messageHandler) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(messageHandler, "messageHandler");
        this.name = name;
        this.concurrency = i10;
        this.bufferSize = i11;
        this.priorityLevels = i12;
        this.messageHandler = messageHandler;
        this.job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(this.job));
        Channel<MessageTaskData<T>>[] channelArr = new Channel[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            channelArr[i13] = ChannelKt.Channel$default(this.bufferSize, null, null, 6, null);
        }
        this.priorityChannels = channelArr;
        int i14 = this.priorityLevels;
        AtomicInteger[] atomicIntegerArr = new AtomicInteger[i14];
        for (int i15 = 0; i15 < i14; i15++) {
            atomicIntegerArr[i15] = new AtomicInteger(0);
        }
        this.channelMessageCounts = atomicIntegerArr;
        this.isStarted = new AtomicBoolean(false);
        this.processedCount = new AtomicLong(0L);
        this.failedCount = new AtomicLong(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object processMessage(MessageTaskData<T> messageTaskData, int i10, int i11, Continuation<? super Unit> continuation) {
        AdvancedMessageProcessingSystem$processMessage$1 advancedMessageProcessingSystem$processMessage$1;
        int i12;
        AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem;
        if (continuation instanceof AdvancedMessageProcessingSystem$processMessage$1) {
            advancedMessageProcessingSystem$processMessage$1 = (AdvancedMessageProcessingSystem$processMessage$1) continuation;
            int i13 = advancedMessageProcessingSystem$processMessage$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                advancedMessageProcessingSystem$processMessage$1.label = i13 - Integer.MIN_VALUE;
                Object obj = advancedMessageProcessingSystem$processMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i12 = advancedMessageProcessingSystem$processMessage$1.label;
                if (i12 == 0) {
                    if (i12 == 1) {
                        i11 = advancedMessageProcessingSystem$processMessage$1.I$0;
                        advancedMessageProcessingSystem = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$processMessage$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception unused) {
                            advancedMessageProcessingSystem.failedCount.incrementAndGet();
                            advancedMessageProcessingSystem.channelMessageCounts[i11].decrementAndGet();
                            return Unit.INSTANCE;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Function4<MessageTaskData<T>, Integer, Integer, Continuation<? super Unit>, Object> function4 = this.messageHandler;
                        Integer boxInt = Boxing.boxInt(i10);
                        Integer boxInt2 = Boxing.boxInt(i11);
                        advancedMessageProcessingSystem$processMessage$1.L$0 = this;
                        advancedMessageProcessingSystem$processMessage$1.I$0 = i11;
                        advancedMessageProcessingSystem$processMessage$1.label = 1;
                        if (function4.invoke(messageTaskData, boxInt, boxInt2, advancedMessageProcessingSystem$processMessage$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        advancedMessageProcessingSystem = this;
                    } catch (Exception unused2) {
                        advancedMessageProcessingSystem = this;
                        advancedMessageProcessingSystem.failedCount.incrementAndGet();
                        advancedMessageProcessingSystem.channelMessageCounts[i11].decrementAndGet();
                        return Unit.INSTANCE;
                    }
                }
                advancedMessageProcessingSystem.processedCount.incrementAndGet();
                advancedMessageProcessingSystem.channelMessageCounts[i11].decrementAndGet();
                return Unit.INSTANCE;
            }
        }
        advancedMessageProcessingSystem$processMessage$1 = new AdvancedMessageProcessingSystem$processMessage$1(this, continuation);
        Object obj2 = advancedMessageProcessingSystem$processMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i12 = advancedMessageProcessingSystem$processMessage$1.label;
        if (i12 == 0) {
        }
        advancedMessageProcessingSystem.processedCount.incrementAndGet();
        advancedMessageProcessingSystem.channelMessageCounts[i11].decrementAndGet();
        return Unit.INSTANCE;
    }

    /* renamed from: shutdown-VtjQ1oo$default, reason: not valid java name */
    public static /* synthetic */ Object m٥٢٩shutdownVtjQ1oo$default(AdvancedMessageProcessingSystem advancedMessageProcessingSystem, long j10, Continuation continuation, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            Duration.Companion companion = Duration.INSTANCE;
            j10 = DurationKt.toDuration(5, DurationUnit.SECONDS);
        }
        return advancedMessageProcessingSystem.m٥٣٠shutdownVtjQ1oo(j10, continuation);
    }

    @NotNull
    public final SystemStatus getStatus() {
        AtomicInteger[] atomicIntegerArr = this.channelMessageCounts;
        ArrayList arrayList = new ArrayList(atomicIntegerArr.length);
        for (AtomicInteger atomicInteger : atomicIntegerArr) {
            arrayList.add(Integer.valueOf(atomicInteger.get()));
        }
        return new SystemStatus(this.name, this.processedCount.get(), this.failedCount.get(), CollectionsKt.toIntArray(arrayList), this.concurrency);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(8:5|6|7|(1:(1:(1:(1:(1:(2:14|15)(5:17|18|19|20|21))(6:25|26|27|28|29|30))(6:34|35|36|37|29|30))(6:41|42|43|44|29|30))(3:48|49|50))(5:83|(1:85)|86|87|(1:89)(1:90))|51|52|53|(1:55)(4:56|44|29|30)))|109|6|7|(0)(0)|51|52|53|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0080, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0081, code lost:
    
        r5 = r0;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c2, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c3, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0141 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033  */
    @Nullable
    /* renamed from: shutdown-VtjQ1oo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m٥٣٠shutdownVtjQ1oo(long j10, @NotNull Continuation<? super Unit> continuation) {
        AdvancedMessageProcessingSystem$shutdown$1 advancedMessageProcessingSystem$shutdown$1;
        Object coroutine_suspended;
        int i10;
        AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem;
        Throwable th;
        CompletableJob completableJob;
        AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem2;
        AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem3;
        CompletableJob completableJob2;
        CompletableJob completableJob3;
        CompletableJob completableJob4;
        if (continuation instanceof AdvancedMessageProcessingSystem$shutdown$1) {
            advancedMessageProcessingSystem$shutdown$1 = (AdvancedMessageProcessingSystem$shutdown$1) continuation;
            int i11 = advancedMessageProcessingSystem$shutdown$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                advancedMessageProcessingSystem$shutdown$1.label = i11 - Integer.MIN_VALUE;
                Object obj = advancedMessageProcessingSystem$shutdown$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = advancedMessageProcessingSystem$shutdown$1.label;
                if (i10 == 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 != 4) {
                                    if (i10 != 5) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    th = (Throwable) advancedMessageProcessingSystem$shutdown$1.L$1;
                                    advancedMessageProcessingSystem = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$shutdown$1.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                    } catch (Exception e10) {
                                        e = e10;
                                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem.name, false, 4, (Object) null);
                                        throw th;
                                    }
                                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem.name, false, 4, (Object) null);
                                    throw th;
                                }
                                advancedMessageProcessingSystem3 = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$shutdown$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj);
                                } catch (Exception e11) {
                                    e = e11;
                                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                                    LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                                    advancedMessageProcessingSystem3.isStarted.set(false);
                                    return Unit.INSTANCE;
                                }
                                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                                advancedMessageProcessingSystem3.isStarted.set(false);
                                return Unit.INSTANCE;
                            }
                            advancedMessageProcessingSystem3 = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$shutdown$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                            } catch (Exception e12) {
                                e = e12;
                                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                                advancedMessageProcessingSystem3.isStarted.set(false);
                                return Unit.INSTANCE;
                            }
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                            advancedMessageProcessingSystem3.isStarted.set(false);
                            return Unit.INSTANCE;
                        }
                        advancedMessageProcessingSystem3 = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$shutdown$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e13) {
                            e = e13;
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                            advancedMessageProcessingSystem3.isStarted.set(false);
                            return Unit.INSTANCE;
                        }
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                        advancedMessageProcessingSystem3.isStarted.set(false);
                        return Unit.INSTANCE;
                    }
                    advancedMessageProcessingSystem2 = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$shutdown$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (TimeoutCancellationException e14) {
                        e = e14;
                        LogUtil.w$default(LogUtil.INSTANCE, "eTag", "关闭消息处理系统超时: " + advancedMessageProcessingSystem2.name + "  错误信息：" + e.getMessage(), false, 4, null);
                        Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem2.job, (CancellationException) null, 1, (Object) null);
                        try {
                            completableJob3 = advancedMessageProcessingSystem2.job;
                            advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem2;
                            advancedMessageProcessingSystem$shutdown$1.label = 3;
                        } catch (Exception e15) {
                            e = e15;
                            advancedMessageProcessingSystem3 = advancedMessageProcessingSystem2;
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                            advancedMessageProcessingSystem3.isStarted.set(false);
                            return Unit.INSTANCE;
                        }
                        if (completableJob3.join(advancedMessageProcessingSystem$shutdown$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        advancedMessageProcessingSystem3 = advancedMessageProcessingSystem2;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                        advancedMessageProcessingSystem3.isStarted.set(false);
                        return Unit.INSTANCE;
                    } catch (Exception e16) {
                        e = e16;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "关闭消息处理系统时出错: " + e.getMessage(), false, 4, (Object) null);
                        Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem2.job, (CancellationException) null, 1, (Object) null);
                        try {
                            completableJob2 = advancedMessageProcessingSystem2.job;
                            advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem2;
                            advancedMessageProcessingSystem$shutdown$1.label = 4;
                        } catch (Exception e17) {
                            e = e17;
                            advancedMessageProcessingSystem3 = advancedMessageProcessingSystem2;
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                            advancedMessageProcessingSystem3.isStarted.set(false);
                            return Unit.INSTANCE;
                        }
                        if (completableJob2.join(advancedMessageProcessingSystem$shutdown$1) != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        advancedMessageProcessingSystem3 = advancedMessageProcessingSystem2;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                        advancedMessageProcessingSystem3.isStarted.set(false);
                        return Unit.INSTANCE;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    for (Channel<MessageTaskData<T>> channel : this.priorityChannels) {
                        SendChannel.DefaultImpls.close$default(channel, null, 1, null);
                    }
                    try {
                        AdvancedMessageProcessingSystem$shutdown$3 advancedMessageProcessingSystem$shutdown$3 = new AdvancedMessageProcessingSystem$shutdown$3(this, null);
                        advancedMessageProcessingSystem$shutdown$1.L$0 = this;
                        advancedMessageProcessingSystem$shutdown$1.label = 1;
                        if (TimeoutKt.m٢١٥٣withTimeoutKLykuaI(j10, advancedMessageProcessingSystem$shutdown$3, advancedMessageProcessingSystem$shutdown$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        advancedMessageProcessingSystem2 = this;
                    } catch (TimeoutCancellationException e18) {
                        e = e18;
                        advancedMessageProcessingSystem2 = this;
                        LogUtil.w$default(LogUtil.INSTANCE, "eTag", "关闭消息处理系统超时: " + advancedMessageProcessingSystem2.name + "  错误信息：" + e.getMessage(), false, 4, null);
                        Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem2.job, (CancellationException) null, 1, (Object) null);
                        completableJob3 = advancedMessageProcessingSystem2.job;
                        advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem2;
                        advancedMessageProcessingSystem$shutdown$1.label = 3;
                        if (completableJob3.join(advancedMessageProcessingSystem$shutdown$1) != coroutine_suspended) {
                        }
                    } catch (Exception e19) {
                        e = e19;
                        advancedMessageProcessingSystem2 = this;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "关闭消息处理系统时出错: " + e.getMessage(), false, 4, (Object) null);
                        Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem2.job, (CancellationException) null, 1, (Object) null);
                        completableJob2 = advancedMessageProcessingSystem2.job;
                        advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem2;
                        advancedMessageProcessingSystem$shutdown$1.label = 4;
                        if (completableJob2.join(advancedMessageProcessingSystem$shutdown$1) != coroutine_suspended) {
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        AdvancedMessageProcessingSystem<T> advancedMessageProcessingSystem4 = this;
                        Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem4.job, (CancellationException) null, 1, (Object) null);
                        try {
                            completableJob = advancedMessageProcessingSystem4.job;
                            advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem4;
                            advancedMessageProcessingSystem$shutdown$1.L$1 = th3;
                            advancedMessageProcessingSystem$shutdown$1.label = 5;
                        } catch (Exception e20) {
                            e = e20;
                            advancedMessageProcessingSystem = advancedMessageProcessingSystem4;
                            th = th3;
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "等待Job取消时出错: " + e.getMessage(), false, 4, (Object) null);
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem.name, false, 4, (Object) null);
                            throw th;
                        }
                        if (completableJob.join(advancedMessageProcessingSystem$shutdown$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        advancedMessageProcessingSystem = advancedMessageProcessingSystem4;
                        th = th3;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem.name, false, 4, (Object) null);
                        throw th;
                    }
                }
                Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem2.job, (CancellationException) null, 1, (Object) null);
                completableJob4 = advancedMessageProcessingSystem2.job;
                advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem2;
                advancedMessageProcessingSystem$shutdown$1.label = 2;
                if (completableJob4.join(advancedMessageProcessingSystem$shutdown$1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                advancedMessageProcessingSystem3 = advancedMessageProcessingSystem2;
                LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已关闭: " + advancedMessageProcessingSystem3.name, false, 4, (Object) null);
                advancedMessageProcessingSystem3.isStarted.set(false);
                return Unit.INSTANCE;
            }
        }
        advancedMessageProcessingSystem$shutdown$1 = new AdvancedMessageProcessingSystem$shutdown$1(this, continuation);
        Object obj2 = advancedMessageProcessingSystem$shutdown$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = advancedMessageProcessingSystem$shutdown$1.label;
        if (i10 == 0) {
        }
        Job.DefaultImpls.cancel$default((Job) advancedMessageProcessingSystem2.job, (CancellationException) null, 1, (Object) null);
        completableJob4 = advancedMessageProcessingSystem2.job;
        advancedMessageProcessingSystem$shutdown$1.L$0 = advancedMessageProcessingSystem2;
        advancedMessageProcessingSystem$shutdown$1.label = 2;
        if (completableJob4.join(advancedMessageProcessingSystem$shutdown$1) != coroutine_suspended) {
        }
    }

    public final void start() {
        if (!this.isStarted.compareAndSet(false, true)) {
            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "消息处理系统已启动: " + this.name, false, 4, (Object) null);
            return;
        }
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "启动消息处理系统: " + this.name, false, 4, (Object) null);
        if (!this.job.isActive()) {
            this.job = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
            this.scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(this.job));
            int i10 = this.priorityLevels;
            Channel<MessageTaskData<T>>[] channelArr = new Channel[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                channelArr[i11] = ChannelKt.Channel$default(this.bufferSize, null, null, 6, null);
            }
            this.priorityChannels = channelArr;
        }
        int i12 = this.concurrency;
        for (int i13 = 0; i13 < i12; i13++) {
            BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AdvancedMessageProcessingSystem$start$2$1(this, i13, null), 3, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object submitMessage(@NotNull MessageTaskData<T> messageTaskData, @NotNull Continuation<? super Boolean> continuation) {
        AdvancedMessageProcessingSystem$submitMessage$1 advancedMessageProcessingSystem$submitMessage$1;
        int i10;
        int coerceIn;
        MessageTaskData<T> messageTaskData2;
        Exception e10;
        int i11;
        if (continuation instanceof AdvancedMessageProcessingSystem$submitMessage$1) {
            advancedMessageProcessingSystem$submitMessage$1 = (AdvancedMessageProcessingSystem$submitMessage$1) continuation;
            int i12 = advancedMessageProcessingSystem$submitMessage$1.label;
            if ((i12 & Integer.MIN_VALUE) != 0) {
                advancedMessageProcessingSystem$submitMessage$1.label = i12 - Integer.MIN_VALUE;
                Object obj = advancedMessageProcessingSystem$submitMessage$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = advancedMessageProcessingSystem$submitMessage$1.label;
                boolean z10 = false;
                if (i10 == 0) {
                    if (i10 == 1) {
                        i11 = advancedMessageProcessingSystem$submitMessage$1.I$0;
                        messageTaskData2 = (MessageTaskData) advancedMessageProcessingSystem$submitMessage$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (TimeoutCancellationException e11) {
                            coerceIn = i11;
                            messageTaskData = messageTaskData2;
                            e = e11;
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "提交消息 " + messageTaskData.getId() + " 超时，优先级: " + coerceIn + "  出错信息：" + e.getMessage(), false, 4, (Object) null);
                            return Boxing.boxBoolean(z10);
                        } catch (Exception e12) {
                            e10 = e12;
                            LogUtil.e$default(LogUtil.INSTANCE, "eTag", "提交消息 " + messageTaskData2.getId() + " 时出错: " + e10.getMessage(), false, 4, (Object) null);
                            return Boxing.boxBoolean(z10);
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    coerceIn = RangesKt.coerceIn(messageTaskData.getPriority(), 0, this.priorityLevels - 1);
                    try {
                        AdvancedMessageProcessingSystem$submitMessage$2 advancedMessageProcessingSystem$submitMessage$2 = new AdvancedMessageProcessingSystem$submitMessage$2(this, coerceIn, messageTaskData, null);
                        advancedMessageProcessingSystem$submitMessage$1.L$0 = messageTaskData;
                        advancedMessageProcessingSystem$submitMessage$1.I$0 = coerceIn;
                        advancedMessageProcessingSystem$submitMessage$1.label = 1;
                        Object withTimeout = TimeoutKt.withTimeout(500L, advancedMessageProcessingSystem$submitMessage$2, advancedMessageProcessingSystem$submitMessage$1);
                        if (withTimeout == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        messageTaskData2 = messageTaskData;
                        i11 = coerceIn;
                        obj = withTimeout;
                    } catch (TimeoutCancellationException e13) {
                        e = e13;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "提交消息 " + messageTaskData.getId() + " 超时，优先级: " + coerceIn + "  出错信息：" + e.getMessage(), false, 4, (Object) null);
                        return Boxing.boxBoolean(z10);
                    } catch (Exception e14) {
                        messageTaskData2 = messageTaskData;
                        e10 = e14;
                        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "提交消息 " + messageTaskData2.getId() + " 时出错: " + e10.getMessage(), false, 4, (Object) null);
                        return Boxing.boxBoolean(z10);
                    }
                }
                z10 = ((Boolean) obj).booleanValue();
                return Boxing.boxBoolean(z10);
            }
        }
        advancedMessageProcessingSystem$submitMessage$1 = new AdvancedMessageProcessingSystem$submitMessage$1(this, continuation);
        Object obj2 = advancedMessageProcessingSystem$submitMessage$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = advancedMessageProcessingSystem$submitMessage$1.label;
        boolean z102 = false;
        if (i10 == 0) {
        }
        z102 = ((Boolean) obj2).booleanValue();
        return Boxing.boxBoolean(z102);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0063 -> B:10:0x0066). Please report as a decompilation issue!!! */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object submitMessages(@NotNull List<MessageTaskData<T>> list, @NotNull Continuation<? super Integer> continuation) {
        AdvancedMessageProcessingSystem$submitMessages$1 advancedMessageProcessingSystem$submitMessages$1;
        int i10;
        Iterator<T> it;
        AdvancedMessageProcessingSystem advancedMessageProcessingSystem;
        Ref.IntRef intRef;
        if (continuation instanceof AdvancedMessageProcessingSystem$submitMessages$1) {
            advancedMessageProcessingSystem$submitMessages$1 = (AdvancedMessageProcessingSystem$submitMessages$1) continuation;
            int i11 = advancedMessageProcessingSystem$submitMessages$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                advancedMessageProcessingSystem$submitMessages$1.label = i11 - Integer.MIN_VALUE;
                Object obj = advancedMessageProcessingSystem$submitMessages$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i10 = advancedMessageProcessingSystem$submitMessages$1.label;
                if (i10 == 0) {
                    if (i10 == 1) {
                        it = (Iterator) advancedMessageProcessingSystem$submitMessages$1.L$2;
                        intRef = (Ref.IntRef) advancedMessageProcessingSystem$submitMessages$1.L$1;
                        advancedMessageProcessingSystem = (AdvancedMessageProcessingSystem) advancedMessageProcessingSystem$submitMessages$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (((Boolean) obj).booleanValue()) {
                            intRef.element++;
                        }
                        if (it.hasNext()) {
                            MessageTaskData<T> messageTaskData = (MessageTaskData) it.next();
                            advancedMessageProcessingSystem$submitMessages$1.L$0 = advancedMessageProcessingSystem;
                            advancedMessageProcessingSystem$submitMessages$1.L$1 = intRef;
                            advancedMessageProcessingSystem$submitMessages$1.L$2 = it;
                            advancedMessageProcessingSystem$submitMessages$1.label = 1;
                            obj = advancedMessageProcessingSystem.submitMessage(messageTaskData, advancedMessageProcessingSystem$submitMessages$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            if (((Boolean) obj).booleanValue()) {
                            }
                            if (it.hasNext()) {
                                return Boxing.boxInt(intRef.element);
                            }
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    it = list.iterator();
                    advancedMessageProcessingSystem = this;
                    intRef = intRef2;
                    if (it.hasNext()) {
                    }
                }
            }
        }
        advancedMessageProcessingSystem$submitMessages$1 = new AdvancedMessageProcessingSystem$submitMessages$1(this, continuation);
        Object obj2 = advancedMessageProcessingSystem$submitMessages$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i10 = advancedMessageProcessingSystem$submitMessages$1.label;
        if (i10 == 0) {
        }
    }

    public /* synthetic */ AdvancedMessageProcessingSystem(String str, int i10, int i11, int i12, Function4 function4, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i13 & 2) != 0 ? 20 : i10, (i13 & 4) != 0 ? 10000 : i11, (i13 & 8) != 0 ? 5 : i12, (i13 & 16) != 0 ? new AnonymousClass1(null) : function4);
    }
}
