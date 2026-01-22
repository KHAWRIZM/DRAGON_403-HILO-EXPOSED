package kotlinx.coroutines.reactive;

import com.taobao.accs.common.Constants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a \u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a(\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0086@¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\u0007\u0010\u0003\u001a.\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@¢\u0006\u0004\b\n\u0010\u000b\u001a \u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\f\u0010\u0003\u001a \u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@¢\u0006\u0004\b\r\u0010\u0003\u001a(\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0004\u001a\u00028\u0000H\u0087@¢\u0006\u0004\b\u000e\u0010\u0006\u001a\"\u0010\u000f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087@¢\u0006\u0004\b\u000f\u0010\u0003\u001a.\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0087@¢\u0006\u0004\b\u0010\u0010\u000b\u001a4\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0082@¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"T", "Lkf/a;", "awaitFirst", "(Lkf/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "default", "awaitFirstOrDefault", "(Lkf/a;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "Lkotlin/Function0;", "defaultValue", "awaitFirstOrElse", "(Lkf/a;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLast", "awaitSingle", "awaitSingleOrDefault", "awaitSingleOrNull", "awaitSingleOrElse", "Lkotlinx/coroutines/reactive/Mode;", Constants.KEY_MODE, "awaitOne", "(Lkf/a;Lkotlinx/coroutines/reactive/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "signalName", "", "gotSignalInTerminalStateException", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;)V", "moreThanOneValueProvidedException", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/reactive/Mode;)V", "kotlinx-coroutines-reactive"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/reactive/AwaitKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,325:1\n318#2,11:326\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/reactive/AwaitKt\n*L\n182#1:326,11\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AwaitKt {
    @Nullable
    public static final <T> Object awaitFirst(@NotNull kf.a aVar, @NotNull Continuation<? super T> continuation) {
        return awaitOne$default(aVar, Mode.FIRST, null, continuation, 2, null);
    }

    @Nullable
    public static final <T> Object awaitFirstOrDefault(@NotNull kf.a aVar, T t, @NotNull Continuation<? super T> continuation) {
        return awaitOne(aVar, Mode.FIRST_OR_DEFAULT, t, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitFirstOrElse(@NotNull kf.a aVar, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$1;
        Object obj;
        int i;
        if (continuation instanceof AwaitKt$awaitFirstOrElse$1) {
            awaitKt$awaitFirstOrElse$1 = (AwaitKt$awaitFirstOrElse$1) continuation;
            int i2 = awaitKt$awaitFirstOrElse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitFirstOrElse$1.label = i2 - Integer.MIN_VALUE;
                AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$12 = awaitKt$awaitFirstOrElse$1;
                obj = awaitKt$awaitFirstOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitFirstOrElse$12.label;
                if (i == 0) {
                    if (i == 1) {
                        function0 = (Function0) awaitKt$awaitFirstOrElse$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.FIRST_OR_DEFAULT;
                    awaitKt$awaitFirstOrElse$12.L$0 = function0;
                    awaitKt$awaitFirstOrElse$12.label = 1;
                    obj = awaitOne$default(aVar, mode, null, awaitKt$awaitFirstOrElse$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj != null) {
                    return function0.invoke();
                }
                return obj;
            }
        }
        awaitKt$awaitFirstOrElse$1 = new AwaitKt$awaitFirstOrElse$1(continuation);
        AwaitKt$awaitFirstOrElse$1 awaitKt$awaitFirstOrElse$122 = awaitKt$awaitFirstOrElse$1;
        obj = awaitKt$awaitFirstOrElse$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitFirstOrElse$122.label;
        if (i == 0) {
        }
        if (obj != null) {
        }
    }

    @Nullable
    public static final <T> Object awaitFirstOrNull(@NotNull kf.a aVar, @NotNull Continuation<? super T> continuation) {
        return awaitOne$default(aVar, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    @Nullable
    public static final <T> Object awaitLast(@NotNull kf.a aVar, @NotNull Continuation<? super T> continuation) {
        return awaitOne$default(aVar, Mode.LAST, null, continuation, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitOne(kf.a aVar, Mode mode, T t, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        ReactiveFlowKt.injectCoroutineContext(aVar, cancellableContinuationImpl.getContext()).subscribe(new AwaitKt$awaitOne$2$1(cancellableContinuationImpl, mode, t));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object awaitOne$default(kf.a aVar, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(aVar, mode, obj, continuation);
    }

    @Nullable
    public static final <T> Object awaitSingle(@NotNull kf.a aVar, @NotNull Continuation<? super T> continuation) {
        return awaitOne$default(aVar, Mode.SINGLE, null, continuation, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated without a replacement due to its name incorrectly conveying the behavior. Please consider using awaitFirstOrElse().")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitSingleOrElse(kf.a aVar, Function0 function0, Continuation continuation) {
        AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$1;
        Object obj;
        int i;
        if (continuation instanceof AwaitKt$awaitSingleOrElse$1) {
            awaitKt$awaitSingleOrElse$1 = (AwaitKt$awaitSingleOrElse$1) continuation;
            int i2 = awaitKt$awaitSingleOrElse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitSingleOrElse$1.label = i2 - Integer.MIN_VALUE;
                AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$12 = awaitKt$awaitSingleOrElse$1;
                obj = awaitKt$awaitSingleOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitSingleOrElse$12.label;
                if (i == 0) {
                    if (i == 1) {
                        function0 = (Function0) awaitKt$awaitSingleOrElse$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.SINGLE_OR_DEFAULT;
                    awaitKt$awaitSingleOrElse$12.L$0 = function0;
                    awaitKt$awaitSingleOrElse$12.label = 1;
                    obj = awaitOne$default(aVar, mode, null, awaitKt$awaitSingleOrElse$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj != null) {
                    return function0.invoke();
                }
                return obj;
            }
        }
        awaitKt$awaitSingleOrElse$1 = new AwaitKt$awaitSingleOrElse$1(continuation);
        AwaitKt$awaitSingleOrElse$1 awaitKt$awaitSingleOrElse$122 = awaitKt$awaitSingleOrElse$1;
        obj = awaitKt$awaitSingleOrElse$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitSingleOrElse$122.label;
        if (i == 0) {
        }
        if (obj != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gotSignalInTerminalStateException(CoroutineContext coroutineContext, String str) {
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException('\'' + str + "' was called after the publisher already signalled being in a terminal state"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moreThanOneValueProvidedException(CoroutineContext coroutineContext, Mode mode) {
        CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, new IllegalStateException("Only a single value was requested in '" + mode + "', but the publisher provided more"));
    }
}
