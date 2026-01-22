package kotlinx.coroutines.rx3;

import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import io.reactivex.rxjava3.core.h0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.rx3.DispatcherScheduler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J+\u0010\u000e\u001a\u00020\r2\n\u0010\b\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u000b\u0010!\u001a\u00020 8\u0002X\u0082\u0004¨\u0006#"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler;", "Lio/reactivex/rxjava3/core/h0;", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", MessageMenuDialog.BLOCK, "", "delay", "Ljava/util/concurrent/TimeUnit;", "unit", "Lnd/c;", "scheduleDirect", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lnd/c;", "Lio/reactivex/rxjava3/core/h0$c;", "createWorker", "()Lio/reactivex/rxjava3/core/h0$c;", "", "shutdown", "()V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "schedulerJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/atomicfu/AtomicLong;", "workerCounter", "DispatcherWorker", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final class DispatcherScheduler extends h0 {
    private static final /* synthetic */ AtomicLongFieldUpdater workerCounter$volatile$FU = AtomicLongFieldUpdater.newUpdater(DispatcherScheduler.class, "workerCounter$volatile");

    @JvmField
    @NotNull
    public final CoroutineDispatcher dispatcher;

    @NotNull
    private final CompletableJob schedulerJob;

    @NotNull
    private final CoroutineScope scope;
    private volatile /* synthetic */ long workerCounter$volatile;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0011\u001a\u00020\u00102\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R0\u0010(\u001a\u001e\u0012\u001a\u0012\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160&\u0012\u0006\u0012\u0004\u0018\u00010'0%0$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006*"}, d2 = {"Lkotlinx/coroutines/rx3/DispatcherScheduler$DispatcherWorker;", "Lio/reactivex/rxjava3/core/h0$c;", "", "counter", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlinx/coroutines/Job;", "parentJob", "<init>", "(JLkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/Job;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", MessageMenuDialog.BLOCK, "delay", "Ljava/util/concurrent/TimeUnit;", "unit", "Lnd/c;", "schedule", "(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Lnd/c;", "", "isDisposed", "()Z", "", "dispose", "()V", "", "toString", "()Ljava/lang/String;", "J", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/CompletableJob;", "workerJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/CoroutineScope;", "workerScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "blockChannel", "Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DispatcherWorker extends h0.c {

        @NotNull
        private final Channel<Function1<Continuation<? super Unit>, Object>> blockChannel;
        private final long counter;

        @NotNull
        private final CoroutineDispatcher dispatcher;

        @NotNull
        private final CompletableJob workerJob;

        @NotNull
        private final CoroutineScope workerScope;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$1", f = "RxScheduler.kt", i = {0, 1}, l = {UserProxyUtility.surePKMicChange, 78}, m = "invokeSuspend", n = {"$this$consume$iv$iv", "$this$consume$iv$iv"}, s = {"L$0", "L$0"})
        @SourceDebugExtension({"SMAP\nRxScheduler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxScheduler.kt\nkotlinx/coroutines/rx3/DispatcherScheduler$DispatcherWorker$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,178:1\n81#2:179\n58#2,6:180\n82#2,2:186\n68#2:188\n64#2,3:189\n*S KotlinDebug\n*F\n+ 1 RxScheduler.kt\nkotlinx/coroutines/rx3/DispatcherScheduler$DispatcherWorker$1\n*L\n77#1:179\n77#1:180,6\n77#1:186,2\n77#1:188\n77#1:189,3\n*E\n"})
        /* renamed from: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$1, reason: invalid class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            Object L$1;
            int label;

            AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
            }

            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new AnonymousClass1(continuation);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:13:0x004b  */
            /* JADX WARN: Removed duplicated region for block: B:16:0x0056 A[Catch: all -> 0x001b, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0016, B:9:0x003e, B:14:0x004e, B:16:0x0056, B:19:0x0069, B:26:0x002d, B:28:0x003a), top: B:2:0x0008 }] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0069 A[Catch: all -> 0x001b, TRY_LEAVE, TryCatch #1 {all -> 0x001b, blocks: (B:7:0x0016, B:9:0x003e, B:14:0x004e, B:16:0x0056, B:19:0x0069, B:26:0x002d, B:28:0x003a), top: B:2:0x0008 }] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0066 -> B:8:0x0019). Please report as a decompilation issue!!! */
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(@NotNull Object obj) {
                ReceiveChannel receiveChannel;
                ChannelIterator it;
                ChannelIterator channelIterator;
                Object hasNext;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                channelIterator = (ChannelIterator) this.L$1;
                                receiveChannel = (ReceiveChannel) this.L$0;
                                ResultKt.throwOnFailure(obj);
                                it = channelIterator;
                                this.L$0 = receiveChannel;
                                this.L$1 = it;
                                this.label = 1;
                                hasNext = it.hasNext(this);
                                if (hasNext == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator = it;
                                obj = hasNext;
                                if (!((Boolean) obj).booleanValue()) {
                                    Function1 function1 = (Function1) channelIterator.next();
                                    this.L$0 = receiveChannel;
                                    this.L$1 = channelIterator;
                                    this.label = 2;
                                    if (function1.invoke(this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    it = channelIterator;
                                    this.L$0 = receiveChannel;
                                    this.L$1 = it;
                                    this.label = 1;
                                    hasNext = it.hasNext(this);
                                    if (hasNext == coroutine_suspended) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel, (Throwable) null);
                                    return Unit.INSTANCE;
                                }
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            channelIterator = (ChannelIterator) this.L$1;
                            receiveChannel = (ReceiveChannel) this.L$0;
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                            }
                        }
                    } else {
                        ResultKt.throwOnFailure(obj);
                        receiveChannel = DispatcherWorker.this.blockChannel;
                        it = receiveChannel.iterator();
                        this.L$0 = receiveChannel;
                        this.L$1 = it;
                        this.label = 1;
                        hasNext = it.hasNext(this);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        throw th2;
                    }
                }
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }
        }

        public DispatcherWorker(long j, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Job job) {
            this.counter = j;
            this.dispatcher = coroutineDispatcher;
            CompletableJob SupervisorJob = SupervisorKt.SupervisorJob(job);
            this.workerJob = SupervisorJob;
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(SupervisorJob.plus(coroutineDispatcher));
            this.workerScope = CoroutineScope;
            this.blockChannel = ChannelKt.Channel$default(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
            BuildersKt.launch$default(CoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        }

        public void dispose() {
            SendChannel.DefaultImpls.close$default(this.blockChannel, (Throwable) null, 1, (Object) null);
            Job.DefaultImpls.cancel$default(this.workerJob, (CancellationException) null, 1, (Object) null);
        }

        public boolean isDisposed() {
            return !CoroutineScopeKt.isActive(this.workerScope);
        }

        @NotNull
        public nd.c schedule(@NotNull Runnable block, long delay, @NotNull TimeUnit unit) {
            nd.c scheduleTask;
            scheduleTask = RxSchedulerKt.scheduleTask(this.workerScope, block, unit.toMillis(delay), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$schedule$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @NotNull
                public final Runnable invoke(@NotNull final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                    final DispatcherScheduler.DispatcherWorker dispatcherWorker = DispatcherScheduler.DispatcherWorker.this;
                    return new Runnable() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$DispatcherWorker$schedule$1$invoke$$inlined$Runnable$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            DispatcherScheduler.DispatcherWorker.this.blockChannel.trySend-JP2dKIU(function1);
                        }
                    };
                }
            });
            return scheduleTask;
        }

        @NotNull
        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.dispatcher);
            sb2.append(" (worker ");
            sb2.append(this.counter);
            sb2.append(", ");
            if (isDisposed()) {
                str = "disposed";
            } else {
                str = "active";
            }
            sb2.append(str);
            sb2.append(')');
            return sb2.toString();
        }
    }

    public DispatcherScheduler(@NotNull CoroutineDispatcher coroutineDispatcher) {
        this.dispatcher = coroutineDispatcher;
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        this.schedulerJob = SupervisorJob$default;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(coroutineDispatcher));
        this.workerCounter$volatile = 1L;
    }

    private final /* synthetic */ long getWorkerCounter$volatile() {
        return this.workerCounter$volatile;
    }

    private final /* synthetic */ void setWorkerCounter$volatile(long j) {
        this.workerCounter$volatile = j;
    }

    @NotNull
    public h0.c createWorker() {
        return new DispatcherWorker(workerCounter$volatile$FU.getAndIncrement(this), this.dispatcher, this.schedulerJob);
    }

    @NotNull
    public nd.c scheduleDirect(@NotNull Runnable block, long delay, @NotNull TimeUnit unit) {
        nd.c scheduleTask;
        scheduleTask = RxSchedulerKt.scheduleTask(this.scope, block, unit.toMillis(delay), new Function1<Function1<? super Continuation<? super Unit>, ? extends Object>, Runnable>() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$scheduleDirect$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @NotNull
            public final Runnable invoke(@NotNull final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
                final DispatcherScheduler dispatcherScheduler = DispatcherScheduler.this;
                return new Runnable() { // from class: kotlinx.coroutines.rx3.DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        CoroutineScope coroutineScope;
                        coroutineScope = DispatcherScheduler.this.scope;
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new DispatcherScheduler$scheduleDirect$1$1$1(function1, null), 3, (Object) null);
                    }
                };
            }
        });
        return scheduleTask;
    }

    public void shutdown() {
        Job.DefaultImpls.cancel$default(this.schedulerJob, (CancellationException) null, 1, (Object) null);
    }

    @NotNull
    public String toString() {
        return this.dispatcher.toString();
    }
}
