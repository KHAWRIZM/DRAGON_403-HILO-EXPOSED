package com.oudi.core.callback;

import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.CoroutineUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u001aN\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005\u001a0\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00030\u0005\u001a#\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\r\u001a\u0002H\u0003¢\u0006\u0002\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\f\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012\u0006\u0010\u0010\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"map", "Lcom/oudi/core/callback/SuperCallBack;", "R", "T", "successMapper", "Lkotlin/Function1;", "failureMapper", "", "mapSuccess", "transformSuccess", "transform", "onSuccessInContext", "", "result", "(Lcom/oudi/core/callback/SuperCallBack;Ljava/lang/Object;)V", "onFailureInContext", "throwable", "lib_core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperCallBackKt {
    @NotNull
    public static final <T, R> SuperCallBack<R> map(@NotNull final SuperCallBack<T> superCallBack, @NotNull final Function1<? super R, ? extends T> successMapper, @Nullable final Function1<? super Throwable, ? extends Throwable> function1) {
        Intrinsics.checkNotNullParameter(superCallBack, "<this>");
        Intrinsics.checkNotNullParameter(successMapper, "successMapper");
        return new SuperCallBack<R>() { // from class: com.oudi.core.callback.SuperCallBackKt$map$1
            @Override // com.oudi.core.component.IDispatchers
            public CoroutineContext getCoroutineContext() {
                return SuperCallBack.DefaultImpls.getCoroutineContext(this);
            }

            @Override // com.oudi.core.callback.SuperCallBack
            public void onFailure(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                Function1<Throwable, Throwable> function12 = function1;
                if (function12 != null) {
                    superCallBack.onFailure(function12.invoke(throwable));
                } else {
                    superCallBack.onFailure(throwable);
                }
            }

            @Override // com.oudi.core.callback.SuperCallBack
            public void onSuccess(R result) {
                superCallBack.onSuccess(successMapper.invoke(result));
            }
        };
    }

    public static /* synthetic */ SuperCallBack map$default(SuperCallBack superCallBack, Function1 function1, Function1 function12, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            function12 = null;
        }
        return map(superCallBack, function1, function12);
    }

    @NotNull
    public static final <T, R> SuperCallBack<R> mapSuccess(@NotNull SuperCallBack<T> superCallBack, @NotNull Function1<? super R, ? extends T> successMapper) {
        Intrinsics.checkNotNullParameter(superCallBack, "<this>");
        Intrinsics.checkNotNullParameter(successMapper, "successMapper");
        return map(superCallBack, successMapper, null);
    }

    public static final <T> void onFailureInContext(@NotNull SuperCallBack<T> superCallBack, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(superCallBack, "<this>");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        CoroutineContext coroutineContext = superCallBack.getCoroutineContext();
        if (coroutineContext == null || CoroutineUtils.launch$default(CoroutineUtils.INSTANCE, null, coroutineContext, null, new SuperCallBackKt$onFailureInContext$1$1(superCallBack, throwable, null), 5, null) == null) {
            superCallBack.onFailure(throwable);
            Unit unit = Unit.INSTANCE;
        }
    }

    public static final <T> void onSuccessInContext(@NotNull SuperCallBack<T> superCallBack, T t10) {
        Intrinsics.checkNotNullParameter(superCallBack, "<this>");
        CoroutineContext coroutineContext = superCallBack.getCoroutineContext();
        if (coroutineContext == null || CoroutineUtils.launch$default(CoroutineUtils.INSTANCE, null, coroutineContext, null, new SuperCallBackKt$onSuccessInContext$1$1(superCallBack, t10, null), 5, null) == null) {
            superCallBack.onSuccess(t10);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public static final <T> SuperCallBack<T> transformSuccess(@NotNull final SuperCallBack<T> superCallBack, @NotNull final Function1<? super T, ? extends T> transform) {
        Intrinsics.checkNotNullParameter(superCallBack, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        return new SuperCallBack<T>() { // from class: com.oudi.core.callback.SuperCallBackKt$transformSuccess$1
            @Override // com.oudi.core.component.IDispatchers
            public CoroutineContext getCoroutineContext() {
                return SuperCallBack.DefaultImpls.getCoroutineContext(this);
            }

            @Override // com.oudi.core.callback.SuperCallBack
            public void onFailure(Throwable throwable) {
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                superCallBack.onFailure(throwable);
            }

            @Override // com.oudi.core.callback.SuperCallBack
            public void onSuccess(T result) {
                superCallBack.onSuccess(transform.invoke(result));
            }
        };
    }
}
