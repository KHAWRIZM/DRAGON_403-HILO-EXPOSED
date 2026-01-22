package kotlinx.coroutines.reactive;

import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import java.util.NoSuchElementException;
import kf.b;
import kf.c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001e¨\u0006 "}, d2 = {"kotlinx/coroutines/reactive/AwaitKt$awaitOne$2$1", "Lkf/b;", "", "signalName", "", "tryEnterTerminalState", "(Ljava/lang/String;)Z", "Lkotlin/Function0;", "", MessageMenuDialog.BLOCK, "withSubscriptionLock", "(Lkotlin/jvm/functions/Function0;)V", "Lkf/c;", "sub", "onSubscribe", "(Lkf/c;)V", "t", "onNext", "(Ljava/lang/Object;)V", "onComplete", "()V", "", "e", "onError", "(Ljava/lang/Throwable;)V", "subscription", "Lkf/c;", "value", "Ljava/lang/Object;", "seenValue", "Z", "inTerminalState", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AwaitKt$awaitOne$2$1 implements b {
    final /* synthetic */ CancellableContinuation<T> $cont;
    final /* synthetic */ T $default;
    final /* synthetic */ Mode $mode;
    private boolean inTerminalState;
    private boolean seenValue;

    @Nullable
    private c subscription;

    @Nullable
    private T value;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.FIRST_OR_DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.LAST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Mode.SINGLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Mode.SINGLE_OR_DEFAULT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public AwaitKt$awaitOne$2$1(CancellableContinuation<? super T> cancellableContinuation, Mode mode, T t) {
        this.$cont = cancellableContinuation;
        this.$mode = mode;
        this.$default = t;
    }

    private final boolean tryEnterTerminalState(String signalName) {
        if (this.inTerminalState) {
            AwaitKt.gotSignalInTerminalStateException(this.$cont.getContext(), signalName);
            return false;
        }
        this.inTerminalState = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void withSubscriptionLock(Function0<Unit> block) {
        block.invoke();
    }

    @Override // kf.b
    public void onComplete() {
        if (!tryEnterTerminalState("onComplete")) {
            return;
        }
        if (this.seenValue) {
            Mode mode = this.$mode;
            if (mode != Mode.FIRST_OR_DEFAULT && mode != Mode.FIRST && this.$cont.isActive()) {
                CancellableContinuation<T> cancellableContinuation = this.$cont;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(this.value));
                return;
            }
            return;
        }
        Mode mode2 = this.$mode;
        if (mode2 != Mode.FIRST_OR_DEFAULT && mode2 != Mode.SINGLE_OR_DEFAULT) {
            if (this.$cont.isActive()) {
                CancellableContinuation<T> cancellableContinuation2 = this.$cont;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + this.$mode))));
                return;
            }
            return;
        }
        CancellableContinuation<T> cancellableContinuation3 = this.$cont;
        Result.Companion companion3 = Result.Companion;
        cancellableContinuation3.resumeWith(Result.constructor-impl(this.$default));
    }

    @Override // kf.b
    public void onError(@NotNull Throwable e) {
        if (tryEnterTerminalState("onError")) {
            CancellableContinuation<T> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
        }
    }

    @Override // kf.b
    public void onNext(T t) {
        final c cVar = this.subscription;
        CancellableContinuation<T> cancellableContinuation = this.$cont;
        if (cVar == null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(cancellableContinuation.getContext(), new IllegalStateException("'onNext' was called before 'onSubscribe'"));
            return;
        }
        if (this.inTerminalState) {
            AwaitKt.gotSignalInTerminalStateException(cancellableContinuation.getContext(), "onNext");
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3 || i == 4 || i == 5) {
                Mode mode = this.$mode;
                if ((mode == Mode.SINGLE || mode == Mode.SINGLE_OR_DEFAULT) && this.seenValue) {
                    withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onNext$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m٢٣٨invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m٢٣٨invoke() {
                            c.this.cancel();
                        }
                    });
                    if (this.$cont.isActive()) {
                        CancellableContinuation<T> cancellableContinuation2 = this.$cont;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation2.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + this.$mode))));
                        return;
                    }
                    return;
                }
                this.value = t;
                this.seenValue = true;
                return;
            }
            return;
        }
        if (this.seenValue) {
            AwaitKt.moreThanOneValueProvidedException(this.$cont.getContext(), this.$mode);
            return;
        }
        this.seenValue = true;
        withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onNext$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m٢٣٧invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m٢٣٧invoke() {
                c.this.cancel();
            }
        });
        this.$cont.resumeWith(Result.constructor-impl(t));
    }

    @Override // kf.b
    public void onSubscribe(@NotNull final c sub) {
        if (this.subscription != null) {
            withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m٢٣٩invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m٢٣٩invoke() {
                    c.this.cancel();
                }
            });
            return;
        }
        this.subscription = sub;
        this.$cont.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Throwable th) {
                AwaitKt$awaitOne$2$1 awaitKt$awaitOne$2$1 = AwaitKt$awaitOne$2$1.this;
                final c cVar = sub;
                awaitKt$awaitOne$2$1.withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$2.1
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m٢٤٠invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m٢٤٠invoke() {
                        c.this.cancel();
                    }
                });
            }
        });
        final Mode mode = this.$mode;
        withSubscriptionLock(new Function0<Unit>() { // from class: kotlinx.coroutines.reactive.AwaitKt$awaitOne$2$1$onSubscribe$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m٢٤١invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m٢٤١invoke() {
                c cVar = c.this;
                Mode mode2 = mode;
                cVar.request((mode2 == Mode.FIRST || mode2 == Mode.FIRST_OR_DEFAULT) ? 1L : Long.MAX_VALUE);
            }
        });
    }
}
