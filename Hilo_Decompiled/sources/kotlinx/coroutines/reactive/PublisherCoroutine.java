package kotlinx.coroutines.reactive;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kf.b;
import kf.c;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@InternalCoroutinesApi
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B7\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00032\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010 \u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b\"\u0010!J\u0019\u0010#\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b#\u0010$J%\u0010(\u001a\u00020'2\u0014\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b(\u0010)J#\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030*2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b+\u0010,J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0014¢\u0006\u0004\b5\u00106J\u001f\u00107\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b7\u0010!J\u000f\u00108\u001a\u00020\u0003H\u0016¢\u0006\u0004\b8\u0010\u001cR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\bX\u0088\u0004¢\u0006\u0006\n\u0004\b\t\u00109R&\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010:R\u0016\u0010;\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R,\u0010E\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000A0@8VX\u0096\u0004¢\u0006\f\u0012\u0004\bD\u0010\u001c\u001a\u0004\bB\u0010CR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000A8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u000b\u0010L\u001a\u00020K8\u0002X\u0082\u0004\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006M"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkf/c;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkf/b;", "subscriber", "Lkotlin/Function2;", "", "exceptionOnCancelHandler", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkf/b;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "", "element", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "selectResult", "processResultSelectSend", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "elem", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "()V", "cause", "", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "signalCompleted", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "n", "request", "(J)V", "value", "onCompleted", "(Lkotlin/Unit;)V", "onCancelled", "cancel", "Lkf/b;", "Lkotlin/jvm/functions/Function2;", "cancelled", "Z", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "onSend", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isClosedForSend", "()Z", "Lkotlinx/atomicfu/AtomicLong;", "_nRequested", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPublish.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Publish.kt\nkotlinx/coroutines/reactive/PublisherCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,336:1\n1#2:337\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class PublisherCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T>, c {
    private static final /* synthetic */ AtomicLongFieldUpdater _nRequested$volatile$FU = AtomicLongFieldUpdater.newUpdater(PublisherCoroutine.class, "_nRequested$volatile");
    private volatile /* synthetic */ long _nRequested$volatile;
    private volatile boolean cancelled;

    @NotNull
    private final Function2<Throwable, CoroutineContext, Unit> exceptionOnCancelHandler;

    @NotNull
    private final Mutex mutex;

    @NotNull
    private final b subscriber;

    /* JADX WARN: Multi-variable type inference failed */
    public PublisherCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull b bVar, @NotNull Function2<? super Throwable, ? super CoroutineContext, Unit> function2) {
        super(coroutineContext, false, true);
        this.subscriber = bVar;
        this.exceptionOnCancelHandler = function2;
        this.mutex = MutexKt.Mutex(true);
    }

    private final Throwable doLockedNext(T elem) {
        if (elem != null) {
            if (!isActive()) {
                unlockAndCheckCompleted();
                return getCancellationException();
            }
            try {
                this.subscriber.onNext(elem);
                while (true) {
                    long j = _nRequested$volatile$FU.get(this);
                    if (j < 0 || j == Long.MAX_VALUE) {
                        break;
                    }
                    long j2 = j - 1;
                    if (_nRequested$volatile$FU.compareAndSet(this, j, j2)) {
                        if (j2 == 0) {
                            return null;
                        }
                    }
                }
                unlockAndCheckCompleted();
                return null;
            } catch (Throwable th) {
                this.cancelled = true;
                boolean close = close(th);
                unlockAndCheckCompleted();
                if (!close) {
                    this.exceptionOnCancelHandler.invoke(th, getContext());
                    return getCancellationException();
                }
                return th;
            }
        }
        unlockAndCheckCompleted();
        throw new NullPointerException("Attempted to emit `null` inside a reactive publisher");
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        if (_nRequested$volatile$FU.get(this) != -2) {
            _nRequested$volatile$FU.set(this, -2L);
            if (this.cancelled) {
                if (cause != null && !handled) {
                    this.exceptionOnCancelHandler.invoke(cause, getContext());
                }
            } else {
                if (cause == null) {
                    try {
                        this.subscriber.onComplete();
                    } catch (Throwable th) {
                        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
                    }
                    return;
                } else {
                    try {
                        this.subscriber.onError(cause);
                    } catch (Throwable th2) {
                        if (th2 != cause) {
                            ExceptionsKt.addSuppressed(cause, th2);
                        }
                        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), cause);
                    }
                    return;
                }
                Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
            }
        }
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ long get_nRequested$volatile() {
        return this._nRequested$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) {
        Throwable doLockedNext = doLockedNext(element);
        if (doLockedNext == null) {
            return this;
        }
        throw doLockedNext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForSend(SelectInstance<?> select, Object element) {
        if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            BuildersKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new PublisherCoroutine$registerSelectForSend$1(this, select, null), 3, (Object) null);
        }
    }

    private final /* synthetic */ void set_nRequested$volatile(long j) {
        this._nRequested$volatile = j;
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        long j;
        do {
            j = _nRequested$volatile$FU.get(this);
            if (j == -2) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("Check failed.");
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, j, -1L));
        if (j == 0) {
            doLockedSignalCompleted(cause, handled);
        } else if (Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(cause, handled);
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (isCompleted() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
    }

    @Override // kf.c
    public void cancel() {
        this.cancelled = true;
        super/*kotlinx.coroutines.JobSupport*/.cancel((CancellationException) null);
    }

    public boolean close(@Nullable Throwable cause) {
        return cancelCoroutine(cause);
    }

    @NotNull
    public SendChannel<T> getChannel() {
        return this;
    }

    @NotNull
    public SelectClause2<T, SendChannel<T>> getOnSend() {
        PublisherCoroutine$onSend$1 publisherCoroutine$onSend$1 = PublisherCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$1, 3);
        PublisherCoroutine$onSend$2 publisherCoroutine$onSend$2 = PublisherCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(publisherCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(publisherCoroutine$onSend$2, 3), null, 8, null);
    }

    /* renamed from: invokeOnClose, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void m٢٤٣invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    public boolean isClosedForSend() {
        return !isActive();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    protected void onCancelled(@NotNull Throwable cause, boolean handled) {
        signalCompleted(cause, handled);
    }

    @Override // kf.c
    public void request(long n) {
        long j;
        long j2;
        if (n <= 0) {
            cancelCoroutine(new IllegalArgumentException("non-positive subscription request " + n));
            return;
        }
        do {
            j = _nRequested$volatile$FU.get(this);
            if (j < 0) {
                return;
            }
            long j3 = j + n;
            j2 = Long.MAX_VALUE;
            if (j3 >= 0 && n != Long.MAX_VALUE) {
                j2 = j3;
            }
            if (j == j2) {
                return;
            }
        } while (!_nRequested$volatile$FU.compareAndSet(this, j, j2));
        if (j == 0) {
            unlockAndCheckCompleted();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(T t, @NotNull Continuation<? super Unit> continuation) {
        PublisherCoroutine$send$1 publisherCoroutine$send$1;
        int i;
        PublisherCoroutine<T> publisherCoroutine;
        Throwable doLockedNext;
        if (continuation instanceof PublisherCoroutine$send$1) {
            publisherCoroutine$send$1 = (PublisherCoroutine$send$1) continuation;
            int i2 = publisherCoroutine$send$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                publisherCoroutine$send$1.label = i2 - Integer.MIN_VALUE;
                Object obj = publisherCoroutine$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = publisherCoroutine$send$1.label;
                if (i == 0) {
                    if (i == 1) {
                        t = (T) publisherCoroutine$send$1.L$1;
                        publisherCoroutine = (PublisherCoroutine) publisherCoroutine$send$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    publisherCoroutine$send$1.L$0 = this;
                    publisherCoroutine$send$1.L$1 = t;
                    publisherCoroutine$send$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, publisherCoroutine$send$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    publisherCoroutine = this;
                }
                doLockedNext = publisherCoroutine.doLockedNext(t);
                if (doLockedNext != null) {
                    return Unit.INSTANCE;
                }
                throw doLockedNext;
            }
        }
        publisherCoroutine$send$1 = new PublisherCoroutine$send$1(this, continuation);
        Object obj2 = publisherCoroutine$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = publisherCoroutine$send$1.label;
        if (i == 0) {
        }
        doLockedNext = publisherCoroutine.doLockedNext(t);
        if (doLockedNext != null) {
        }
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object m٢٤٢trySendJP2dKIU(T element) {
        if (!Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        Throwable doLockedNext = doLockedNext(element);
        if (doLockedNext == null) {
            return ChannelResult.Companion.success-JP2dKIU(Unit.INSTANCE);
        }
        return ChannelResult.Companion.closed-JP2dKIU(doLockedNext);
    }

    @NotNull
    public Void invokeOnClose(@NotNull Function1<? super Throwable, Unit> handler) {
        throw new UnsupportedOperationException("PublisherCoroutine doesn't support invokeOnClose");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCompleted(@NotNull Unit value) {
        signalCompleted(null, false);
    }
}
