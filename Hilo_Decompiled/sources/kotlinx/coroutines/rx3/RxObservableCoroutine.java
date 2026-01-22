package kotlinx.coroutines.rx3;

import io.reactivex.rxjava3.core.b0;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
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

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u000f\u001a\u00020\u00042\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001d\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0019\u0010 \u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b \u0010!J%\u0010%\u001a\u00020$2\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00040\"H\u0016¢\u0006\u0004\b%\u0010&J#\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040'2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H\u0096@¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u0004H\u0014¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0014¢\u0006\u0004\b0\u0010\u001eR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00101R\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R,\u0010:\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u000006058VX\u0096\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0019\u001a\u0004\b7\u00108R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00028\u0000068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u000b\u0010A\u001a\u00020@8\u0002X\u0082\u0004\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {"Lkotlinx/coroutines/rx3/RxObservableCoroutine;", "", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lio/reactivex/rxjava3/core/b0;", "subscriber", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lio/reactivex/rxjava3/core/b0;)V", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "element", "registerSelectForSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", "selectResult", "processResultSelectSend", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "elem", "", "doLockedNext", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "unlockAndCheckCompleted", "()V", "cause", "", "handled", "doLockedSignalCompleted", "(Ljava/lang/Throwable;Z)V", "signalCompleted", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "onCompleted", "(Lkotlin/Unit;)V", "onCancelled", "Lio/reactivex/rxjava3/core/b0;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/selects/SelectClause2;", "Lkotlinx/coroutines/channels/SendChannel;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "onSend", "getChannel", "()Lkotlinx/coroutines/channels/SendChannel;", "channel", "isClosedForSend", "()Z", "Lkotlinx/atomicfu/AtomicInt;", "_signal", "kotlinx-coroutines-rx3"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRxObservable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxObservable.kt\nkotlinx/coroutines/rx3/RxObservableCoroutine\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n*L\n1#1,207:1\n1#2:208\n159#3:209\n*S KotlinDebug\n*F\n+ 1 RxObservable.kt\nkotlinx/coroutines/rx3/RxObservableCoroutine\n*L\n165#1:209\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RxObservableCoroutine<T> extends AbstractCoroutine<Unit> implements ProducerScope<T> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater _signal$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(RxObservableCoroutine.class, "_signal$volatile");
    private volatile /* synthetic */ int _signal$volatile;

    @NotNull
    private final Mutex mutex;

    @NotNull
    private final b0 subscriber;

    public RxObservableCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull b0 b0Var) {
        super(coroutineContext, false, true);
        this.subscriber = b0Var;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final Throwable doLockedNext(T elem) {
        if (!isActive()) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
            return getCancellationException();
        }
        try {
            this.subscriber.onNext(elem);
            unlockAndCheckCompleted();
            return null;
        } catch (Throwable th) {
            od.f fVar = new od.f(th);
            boolean close = close(fVar);
            unlockAndCheckCompleted();
            if (!close) {
                RxCancellableKt.handleUndeliverableException(fVar, getContext());
                return getCancellationException();
            }
            return fVar;
        }
    }

    private final void doLockedSignalCompleted(Throwable cause, boolean handled) {
        Throwable th;
        if (_signal$volatile$FU.get(this) == -2) {
            return;
        }
        _signal$volatile$FU.set(this, -2);
        if (cause != null) {
            th = cause;
        } else {
            th = null;
        }
        if (th == null) {
            try {
                this.subscriber.onComplete();
            } catch (Exception e) {
                RxCancellableKt.handleUndeliverableException(e, getContext());
            }
            return;
        }
        if ((th instanceof od.f) && !handled) {
            RxCancellableKt.handleUndeliverableException(cause, getContext());
        } else if (th != getCancellationException() || !this.subscriber.isDisposed()) {
            try {
                this.subscriber.onError(cause);
            } catch (Exception e2) {
                ExceptionsKt.addSuppressed(cause, e2);
                RxCancellableKt.handleUndeliverableException(cause, getContext());
            }
        }
        return;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private final /* synthetic */ int get_signal$volatile() {
        return this._signal$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object processResultSelectSend(Object element, Object selectResult) {
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type T of kotlinx.coroutines.rx3.RxObservableCoroutine");
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
            BuildersKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new RxObservableCoroutine$registerSelectForSend$1(this, select, null), 3, (Object) null);
        }
    }

    private final /* synthetic */ void set_signal$volatile(int i) {
        this._signal$volatile = i;
    }

    private final void signalCompleted(Throwable cause, boolean handled) {
        if (_signal$volatile$FU.compareAndSet(this, 0, -1) && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(cause, handled);
        }
    }

    private final void unlockAndCheckCompleted() {
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
        if (!isActive() && Mutex.DefaultImpls.tryLock$default(this.mutex, null, 1, null)) {
            doLockedSignalCompleted(getCompletionCause(), getCompletionCauseHandled());
        }
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
        RxObservableCoroutine$onSend$1 rxObservableCoroutine$onSend$1 = RxObservableCoroutine$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$1, 3);
        RxObservableCoroutine$onSend$2 rxObservableCoroutine$onSend$2 = RxObservableCoroutine$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(rxObservableCoroutine$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(rxObservableCoroutine$onSend$2, 3), null, 8, null);
    }

    /* renamed from: invokeOnClose, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ void m٢٤٩invokeOnClose(Function1 function1) {
        invokeOnClose((Function1<? super Throwable, Unit>) function1);
    }

    public boolean isClosedForSend() {
        return !isActive();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(@NotNull T t) {
        return ProducerScope.DefaultImpls.offer(this, t);
    }

    protected void onCancelled(@NotNull Throwable cause, boolean handled) {
        signalCompleted(cause, handled);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object send(@NotNull T t, @NotNull Continuation<? super Unit> continuation) {
        RxObservableCoroutine$send$1 rxObservableCoroutine$send$1;
        int i;
        RxObservableCoroutine<T> rxObservableCoroutine;
        Throwable doLockedNext;
        if (continuation instanceof RxObservableCoroutine$send$1) {
            rxObservableCoroutine$send$1 = (RxObservableCoroutine$send$1) continuation;
            int i2 = rxObservableCoroutine$send$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rxObservableCoroutine$send$1.label = i2 - Integer.MIN_VALUE;
                Object obj = rxObservableCoroutine$send$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxObservableCoroutine$send$1.label;
                if (i == 0) {
                    if (i == 1) {
                        t = (T) rxObservableCoroutine$send$1.L$1;
                        rxObservableCoroutine = (RxObservableCoroutine) rxObservableCoroutine$send$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    rxObservableCoroutine$send$1.L$0 = this;
                    rxObservableCoroutine$send$1.L$1 = t;
                    rxObservableCoroutine$send$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, rxObservableCoroutine$send$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    rxObservableCoroutine = this;
                }
                doLockedNext = rxObservableCoroutine.doLockedNext(t);
                if (doLockedNext != null) {
                    return Unit.INSTANCE;
                }
                throw doLockedNext;
            }
        }
        rxObservableCoroutine$send$1 = new RxObservableCoroutine$send$1(this, continuation);
        Object obj2 = rxObservableCoroutine$send$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxObservableCoroutine$send$1.label;
        if (i == 0) {
        }
        doLockedNext = rxObservableCoroutine.doLockedNext(t);
        if (doLockedNext != null) {
        }
    }

    @NotNull
    /* renamed from: trySend-JP2dKIU, reason: not valid java name */
    public Object m٢٤٨trySendJP2dKIU(@NotNull T element) {
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
        throw new UnsupportedOperationException("RxObservableCoroutine doesn't support invokeOnClose");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCompleted(@NotNull Unit value) {
        signalCompleted(null, false);
    }
}
