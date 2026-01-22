package kotlinx.coroutines.rx3;

import com.taobao.accs.common.Constants;
import io.reactivex.rxjava3.core.e0;
import io.reactivex.rxjava3.core.g0;
import io.reactivex.rxjava3.core.k0;
import io.reactivex.rxjava3.core.l;
import io.reactivex.rxjava3.core.m0;
import io.reactivex.rxjava3.core.n;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086@¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a%\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a'\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0007\u001a-\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u00052\u0006\u0010\t\u001a\u00028\u0000H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a%\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\r\u001a%\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000e2\u0006\u0010\t\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0010\u001a3\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a%\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0010\u001a%\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000eH\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0010\u001a\u001f\u0010\u001c\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010 \u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0006\u0012\u0004\b\u00028\u00000\u000e2\u0006\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b9¨\u0006\""}, d2 = {"Lio/reactivex/rxjava3/core/f;", "", "await", "(Lio/reactivex/rxjava3/core/f;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "T", "Lio/reactivex/rxjava3/core/n;", "awaitSingleOrNull", "(Lio/reactivex/rxjava3/core/n;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSingle", "default", "awaitOrDefault", "(Lio/reactivex/rxjava3/core/n;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/rxjava3/core/m0;", "(Lio/reactivex/rxjava3/core/m0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/reactivex/rxjava3/core/e0;", "awaitFirst", "(Lio/reactivex/rxjava3/core/e0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrDefault", "(Lio/reactivex/rxjava3/core/e0;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitFirstOrNull", "Lkotlin/Function0;", "defaultValue", "awaitFirstOrElse", "(Lio/reactivex/rxjava3/core/e0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLast", "Lkotlinx/coroutines/CancellableContinuation;", "Lnd/c;", "d", "disposeOnCancellation", "(Lkotlinx/coroutines/CancellableContinuation;Lnd/c;)V", "Lkotlinx/coroutines/rx3/Mode;", Constants.KEY_MODE, "awaitOne", "(Lio/reactivex/rxjava3/core/e0;Lkotlinx/coroutines/rx3/Mode;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-rx3"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRxAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RxAwait.kt\nkotlinx/coroutines/rx3/RxAwaitKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,274:1\n318#2,11:275\n318#2,11:286\n318#2,11:297\n318#2,11:308\n*S KotlinDebug\n*F\n+ 1 RxAwait.kt\nkotlinx/coroutines/rx3/RxAwaitKt\n*L\n21#1:275,11\n40#1:286,11\n117#1:297,11\n219#1:308,11\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RxAwaitKt {
    @Nullable
    public static final <T> Object awaitFirst(@NotNull e0 e0Var, @NotNull Continuation<? super T> continuation) {
        Object awaitOne$default = awaitOne$default(e0Var, Mode.FIRST, null, continuation, 2, null);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne$default;
    }

    @Nullable
    public static final <T> Object awaitFirstOrDefault(@NotNull e0 e0Var, T t, @NotNull Continuation<? super T> continuation) {
        Object awaitOne = awaitOne(e0Var, Mode.FIRST_OR_DEFAULT, t, continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitFirstOrElse(@NotNull e0 e0Var, @NotNull Function0<? extends T> function0, @NotNull Continuation<? super T> continuation) {
        RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$1;
        Object obj;
        int i;
        if (continuation instanceof RxAwaitKt$awaitFirstOrElse$1) {
            rxAwaitKt$awaitFirstOrElse$1 = (RxAwaitKt$awaitFirstOrElse$1) continuation;
            int i2 = rxAwaitKt$awaitFirstOrElse$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rxAwaitKt$awaitFirstOrElse$1.label = i2 - Integer.MIN_VALUE;
                RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$12 = rxAwaitKt$awaitFirstOrElse$1;
                obj = rxAwaitKt$awaitFirstOrElse$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxAwaitKt$awaitFirstOrElse$12.label;
                if (i == 0) {
                    if (i == 1) {
                        function0 = (Function0) rxAwaitKt$awaitFirstOrElse$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Mode mode = Mode.FIRST_OR_DEFAULT;
                    rxAwaitKt$awaitFirstOrElse$12.L$0 = function0;
                    rxAwaitKt$awaitFirstOrElse$12.label = 1;
                    obj = awaitOne$default(e0Var, mode, null, rxAwaitKt$awaitFirstOrElse$12, 2, null);
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
        rxAwaitKt$awaitFirstOrElse$1 = new RxAwaitKt$awaitFirstOrElse$1(continuation);
        RxAwaitKt$awaitFirstOrElse$1 rxAwaitKt$awaitFirstOrElse$122 = rxAwaitKt$awaitFirstOrElse$1;
        obj = rxAwaitKt$awaitFirstOrElse$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxAwaitKt$awaitFirstOrElse$122.label;
        if (i == 0) {
        }
        if (obj != null) {
        }
    }

    @Nullable
    public static final <T> Object awaitFirstOrNull(@NotNull e0 e0Var, @NotNull Continuation<? super T> continuation) {
        return awaitOne$default(e0Var, Mode.FIRST_OR_DEFAULT, null, continuation, 2, null);
    }

    @Nullable
    public static final <T> Object awaitLast(@NotNull e0 e0Var, @NotNull Continuation<? super T> continuation) {
        Object awaitOne$default = awaitOne$default(e0Var, Mode.LAST, null, continuation, 2, null);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> Object awaitOne(e0 e0Var, final Mode mode, final T t, Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        e0Var.subscribe(new g0() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$awaitOne$2$1
            private boolean seenValue;
            private nd.c subscription;

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
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public void onComplete() {
                if (this.seenValue) {
                    if (cancellableContinuationImpl.isActive()) {
                        CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                        Result.Companion companion = Result.Companion;
                        cancellableContinuation.resumeWith(Result.constructor-impl(this.value));
                        return;
                    }
                    return;
                }
                if (mode == Mode.FIRST_OR_DEFAULT) {
                    CancellableContinuation<T> cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.Companion;
                    cancellableContinuation2.resumeWith(Result.constructor-impl(t));
                } else if (cancellableContinuationImpl.isActive()) {
                    CancellableContinuation<T> cancellableContinuation3 = cancellableContinuationImpl;
                    Result.Companion companion3 = Result.Companion;
                    cancellableContinuation3.resumeWith(Result.constructor-impl(ResultKt.createFailure(new NoSuchElementException("No value received via onNext for " + mode))));
                }
            }

            public void onError(@NotNull Throwable e) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
            }

            public void onNext(@NotNull T t2) {
                int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
                nd.c cVar = null;
                if (i != 1 && i != 2) {
                    if (i == 3 || i == 4) {
                        if (mode == Mode.SINGLE && this.seenValue) {
                            if (cancellableContinuationImpl.isActive()) {
                                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                                Result.Companion companion = Result.Companion;
                                cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("More than one onNext value for " + mode))));
                            }
                            nd.c cVar2 = this.subscription;
                            if (cVar2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("subscription");
                            } else {
                                cVar = cVar2;
                            }
                            cVar.dispose();
                            return;
                        }
                        this.value = t2;
                        this.seenValue = true;
                        return;
                    }
                    return;
                }
                if (!this.seenValue) {
                    this.seenValue = true;
                    cancellableContinuationImpl.resumeWith(Result.constructor-impl(t2));
                    nd.c cVar3 = this.subscription;
                    if (cVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("subscription");
                    } else {
                        cVar = cVar3;
                    }
                    cVar.dispose();
                }
            }

            public void onSubscribe(@NotNull final nd.c sub) {
                this.subscription = sub;
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$awaitOne$2$1$onSubscribe$1
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
                        sub.dispose();
                    }
                });
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    static /* synthetic */ Object awaitOne$default(e0 e0Var, Mode mode, Object obj, Continuation continuation, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        return awaitOne(e0Var, mode, obj, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Deprecated in favor of awaitSingleOrNull()", replaceWith = @ReplaceWith(expression = "this.awaitSingleOrNull() ?: default", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ Object awaitOrDefault(n nVar, Object obj, Continuation continuation) {
        RxAwaitKt$awaitOrDefault$1 rxAwaitKt$awaitOrDefault$1;
        Object obj2;
        int i;
        if (continuation instanceof RxAwaitKt$awaitOrDefault$1) {
            rxAwaitKt$awaitOrDefault$1 = (RxAwaitKt$awaitOrDefault$1) continuation;
            int i2 = rxAwaitKt$awaitOrDefault$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rxAwaitKt$awaitOrDefault$1.label = i2 - Integer.MIN_VALUE;
                obj2 = rxAwaitKt$awaitOrDefault$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxAwaitKt$awaitOrDefault$1.label;
                if (i == 0) {
                    if (i == 1) {
                        obj = rxAwaitKt$awaitOrDefault$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    rxAwaitKt$awaitOrDefault$1.L$0 = obj;
                    rxAwaitKt$awaitOrDefault$1.label = 1;
                    obj2 = awaitSingleOrNull(nVar, rxAwaitKt$awaitOrDefault$1);
                    if (obj2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (obj2 == null) {
                    return obj2;
                }
                return obj;
            }
        }
        rxAwaitKt$awaitOrDefault$1 = new RxAwaitKt$awaitOrDefault$1(continuation);
        obj2 = rxAwaitKt$awaitOrDefault$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxAwaitKt$awaitOrDefault$1.label;
        if (i == 0) {
        }
        if (obj2 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitSingle(@NotNull n nVar, @NotNull Continuation<? super T> continuation) {
        RxAwaitKt$awaitSingle$1 rxAwaitKt$awaitSingle$1;
        Object obj;
        int i;
        if (continuation instanceof RxAwaitKt$awaitSingle$1) {
            rxAwaitKt$awaitSingle$1 = (RxAwaitKt$awaitSingle$1) continuation;
            int i2 = rxAwaitKt$awaitSingle$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rxAwaitKt$awaitSingle$1.label = i2 - Integer.MIN_VALUE;
                obj = rxAwaitKt$awaitSingle$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = rxAwaitKt$awaitSingle$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    rxAwaitKt$awaitSingle$1.label = 1;
                    obj = awaitSingleOrNull(nVar, rxAwaitKt$awaitSingle$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (obj == null) {
                    return obj;
                }
                throw new NoSuchElementException();
            }
        }
        rxAwaitKt$awaitSingle$1 = new RxAwaitKt$awaitSingle$1(continuation);
        obj = rxAwaitKt$awaitSingle$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = rxAwaitKt$awaitSingle$1.label;
        if (i != 0) {
        }
        if (obj == null) {
        }
    }

    @Nullable
    public static final <T> Object awaitSingleOrNull(@NotNull n nVar, @NotNull Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        nVar.a(new l() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$awaitSingleOrNull$2$1
            public void onComplete() {
                cancellableContinuationImpl.resumeWith(Result.constructor-impl((Object) null));
            }

            public void onError(@NotNull Throwable error) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(error)));
            }

            public void onSubscribe(@NotNull nd.c d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl, d);
            }

            public void onSuccess(@NotNull T t) {
                cancellableContinuationImpl.resumeWith(Result.constructor-impl(t));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final void disposeOnCancellation(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull final nd.c cVar) {
        cancellableContinuation.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$disposeOnCancellation$1
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
                cVar.dispose();
            }
        });
    }

    @Nullable
    public static final Object await(@NotNull io.reactivex.rxjava3.core.f fVar, @NotNull Continuation<? super Unit> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        fVar.a(new io.reactivex.rxjava3.core.d() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$await$2$1
            public void onComplete() {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            }

            public void onError(@NotNull Throwable e) {
                CancellableContinuation<Unit> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(e)));
            }

            public void onSubscribe(@NotNull nd.c d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl, d);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    @Nullable
    public static final <T> Object awaitSingle(@NotNull e0 e0Var, @NotNull Continuation<? super T> continuation) {
        Object awaitOne$default = awaitOne$default(e0Var, Mode.SINGLE, null, continuation, 2, null);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return awaitOne$default;
    }

    @Nullable
    public static final <T> Object await(@NotNull m0 m0Var, @NotNull Continuation<? super T> continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        m0Var.a(new k0() { // from class: kotlinx.coroutines.rx3.RxAwaitKt$await$5$1
            public void onError(@NotNull Throwable error) {
                CancellableContinuation<T> cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(error)));
            }

            public void onSubscribe(@NotNull nd.c d) {
                RxAwaitKt.disposeOnCancellation(cancellableContinuationImpl, d);
            }

            public void onSuccess(@NotNull T t) {
                cancellableContinuationImpl.resumeWith(Result.constructor-impl(t));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
