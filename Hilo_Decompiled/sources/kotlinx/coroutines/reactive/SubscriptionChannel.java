package kotlinx.coroutines.reactive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kf.b;
import kf.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferedChannel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u000b\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004R\u0013\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001c8\u0002X\u0082\u0004¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", "T", "Lkotlinx/coroutines/channels/BufferedChannel;", "Lkf/b;", "", "request", "<init>", "(I)V", "", "onReceiveEnqueued", "()V", "onReceiveDequeued", "onClosedIdempotent", "Lkf/c;", "s", "onSubscribe", "(Lkf/c;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onComplete", "", "e", "onError", "(Ljava/lang/Throwable;)V", "I", "Lkotlinx/atomicfu/AtomicInt;", "_requested", "Lkotlinx/atomicfu/AtomicRef;", "_subscription", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channel.kt\nkotlinx/coroutines/reactive/SubscriptionChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,107:1\n1#2:108\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class SubscriptionChannel<T> extends BufferedChannel<T> implements b {
    private volatile /* synthetic */ int _requested$volatile;
    private volatile /* synthetic */ Object _subscription$volatile;
    private final int request;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _requested$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested$volatile");

    public SubscriptionChannel(int i) {
        super(Integer.MAX_VALUE, (Function1) null, 2, (DefaultConstructorMarker) null);
        this.request = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Invalid request size: " + i).toString());
    }

    private final /* synthetic */ int get_requested$volatile() {
        return this._requested$volatile;
    }

    private final /* synthetic */ Object get_subscription$volatile() {
        return this._subscription$volatile;
    }

    private final /* synthetic */ void loop$atomicfu(Object obj, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function1) {
        while (true) {
            function1.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    private final /* synthetic */ void set_requested$volatile(int i) {
        this._requested$volatile = i;
    }

    private final /* synthetic */ void set_subscription$volatile(Object obj) {
        this._subscription$volatile = obj;
    }

    public void onClosedIdempotent() {
        c cVar = (c) _subscription$volatile$FU.getAndSet(this, null);
        if (cVar != null) {
            cVar.cancel();
        }
    }

    @Override // kf.b
    public void onComplete() {
        close((Throwable) null);
    }

    @Override // kf.b
    public void onError(@NotNull Throwable e) {
        close(e);
    }

    @Override // kf.b
    public void onNext(T t) {
        _requested$volatile$FU.decrementAndGet(this);
        trySend-JP2dKIU(t);
    }

    public void onReceiveDequeued() {
        _requested$volatile$FU.incrementAndGet(this);
    }

    public void onReceiveEnqueued() {
        c cVar;
        int i;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = _requested$volatile$FU;
        while (true) {
            int i2 = atomicIntegerFieldUpdater.get(this);
            cVar = (c) _subscription$volatile$FU.get(this);
            i = i2 - 1;
            if (cVar != null && i < 0) {
                if (i2 == this.request || _requested$volatile$FU.compareAndSet(this, i2, this.request)) {
                    break;
                }
            } else if (_requested$volatile$FU.compareAndSet(this, i2, i)) {
                return;
            }
        }
        cVar.request(this.request - i);
    }

    @Override // kf.b
    public void onSubscribe(@NotNull c s) {
        _subscription$volatile$FU.set(this, s);
        while (!isClosedForSend()) {
            int i = _requested$volatile$FU.get(this);
            if (i >= this.request) {
                return;
            }
            if (_requested$volatile$FU.compareAndSet(this, i, this.request)) {
                s.request(this.request - i);
                return;
            }
        }
        s.cancel();
    }
}
