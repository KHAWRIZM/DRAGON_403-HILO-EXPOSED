package kotlinx.coroutines.reactive;

import kf.b;
import kf.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00018\u0000H\u0086@¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000f¢\u0006\u0004\b\u001c\u0010\u0013J\r\u0010\u001d\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u0013R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lkotlinx/coroutines/reactive/ReactiveSubscriber;", "", "T", "Lkf/b;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "", "requestSize", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;J)V", "takeNextOrNull", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "onNext", "(Ljava/lang/Object;)V", "onComplete", "()V", "", "t", "onError", "(Ljava/lang/Throwable;)V", "Lkf/c;", "s", "onSubscribe", "(Lkf/c;)V", "makeRequest", "cancel", "J", "subscription", "Lkf/c;", "Lkotlinx/coroutines/channels/Channel;", "channel", "Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nReactiveFlow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/ReactiveSubscriber\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Channel.kt\nkotlinx/coroutines/channels/ChannelKt\n*L\n1#1,269:1\n1#2:270\n509#3,5:271\n*S KotlinDebug\n*F\n+ 1 ReactiveFlow.kt\nkotlinx/coroutines/reactive/ReactiveSubscriber\n*L\n127#1:271,5\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class ReactiveSubscriber<T> implements b {

    @NotNull
    private final Channel<T> channel;
    private final long requestSize;
    private c subscription;

    public ReactiveSubscriber(int i, @NotNull BufferOverflow bufferOverflow, long j) {
        this.requestSize = j;
        this.channel = kotlinx.coroutines.channels.ChannelKt.Channel$default(i == 0 ? 1 : i, bufferOverflow, (Function1) null, 4, (Object) null);
    }

    public final void cancel() {
        c cVar = this.subscription;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            cVar = null;
        }
        cVar.cancel();
    }

    public final void makeRequest() {
        c cVar = this.subscription;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("subscription");
            cVar = null;
        }
        cVar.request(this.requestSize);
    }

    @Override // kf.b
    public void onComplete() {
        SendChannel.DefaultImpls.close$default(this.channel, (Throwable) null, 1, (Object) null);
    }

    @Override // kf.b
    public void onError(@Nullable Throwable t) {
        this.channel.close(t);
    }

    @Override // kf.b
    public void onNext(@NotNull T value) {
        if (ChannelResult.isSuccess-impl(this.channel.trySend-JP2dKIU(value))) {
            return;
        }
        throw new IllegalArgumentException(("Element " + value + " was not added to channel because it was full, " + this.channel).toString());
    }

    @Override // kf.b
    public void onSubscribe(@NotNull c s) {
        this.subscription = s;
        makeRequest();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object takeNextOrNull(@NotNull Continuation<? super T> continuation) {
        ReactiveSubscriber$takeNextOrNull$1 reactiveSubscriber$takeNextOrNull$1;
        int i;
        Object obj;
        Throwable th;
        if (continuation instanceof ReactiveSubscriber$takeNextOrNull$1) {
            reactiveSubscriber$takeNextOrNull$1 = (ReactiveSubscriber$takeNextOrNull$1) continuation;
            int i2 = reactiveSubscriber$takeNextOrNull$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                reactiveSubscriber$takeNextOrNull$1.label = i2 - Integer.MIN_VALUE;
                Object obj2 = reactiveSubscriber$takeNextOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = reactiveSubscriber$takeNextOrNull$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj2);
                        obj = ((ChannelResult) obj2).unbox-impl();
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    Channel<T> channel = this.channel;
                    reactiveSubscriber$takeNextOrNull$1.label = 1;
                    obj = channel.receiveCatching-JP2dKIU(reactiveSubscriber$takeNextOrNull$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                th = ChannelResult.exceptionOrNull-impl(obj);
                if (th != null) {
                    if (obj instanceof ChannelResult.Failed) {
                        ChannelResult.exceptionOrNull-impl(obj);
                        return null;
                    }
                    return obj;
                }
                throw th;
            }
        }
        reactiveSubscriber$takeNextOrNull$1 = new ReactiveSubscriber$takeNextOrNull$1(this, continuation);
        Object obj22 = reactiveSubscriber$takeNextOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = reactiveSubscriber$takeNextOrNull$1.label;
        if (i == 0) {
        }
        th = ChannelResult.exceptionOrNull-impl(obj);
        if (th != null) {
        }
    }
}
