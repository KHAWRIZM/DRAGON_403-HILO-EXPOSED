package com.oudi.core.model;

import com.facebook.login.LoginLogger;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.model.SuperResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a8\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a8\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\bø\u0001\u0000\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\u0002H\u0002¢\u0006\u0002\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\b*\u0002H\u0002¢\u0006\u0002\u0010\u000e\u001a$\u0010\u000f\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\u001a\u000e\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014"}, d2 = {"doSuccess", "Lcom/oudi/core/model/SuperResult;", "T", "success", "Lkotlin/Function1;", "", "doFailure", LoginLogger.EVENT_EXTRAS_FAILURE, "", "toSuccessResult", "Lcom/oudi/core/model/SuperResult$Success;", "(Ljava/lang/Object;)Lcom/oudi/core/model/SuperResult$Success;", "toFailureResult", "Lcom/oudi/core/model/SuperResult$Failure;", "(Ljava/lang/Throwable;)Lcom/oudi/core/model/SuperResult$Failure;", "callback", "callBack", "Lcom/oudi/core/callback/SuperCallBack;", "isSuccess", "", "lib_core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SuperResultKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void callback(@NotNull SuperResult<? extends T> superResult, @NotNull SuperCallBack<T> callBack) {
        Intrinsics.checkNotNullParameter(superResult, "<this>");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        if (superResult instanceof SuperResult.Success) {
            callBack.onSuccess(((SuperResult.Success) superResult).getData());
        } else {
            if (superResult instanceof SuperResult.Failure) {
                callBack.onFailure(((SuperResult.Failure) superResult).getThrowable());
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> SuperResult<T> doFailure(SuperResult<? extends T> superResult, Function1<? super Throwable, Unit> failure) {
        Intrinsics.checkNotNullParameter(superResult, "<this>");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (superResult instanceof SuperResult.Failure) {
            failure.invoke(((SuperResult.Failure) superResult).getThrowable());
        }
        return superResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T> SuperResult<T> doSuccess(SuperResult<? extends T> superResult, Function1<? super T, Unit> success) {
        Intrinsics.checkNotNullParameter(superResult, "<this>");
        Intrinsics.checkNotNullParameter(success, "success");
        if (superResult instanceof SuperResult.Success) {
            success.invoke((Object) ((SuperResult.Success) superResult).getData());
        }
        return superResult;
    }

    public static final boolean isSuccess(@NotNull SuperResult<?> superResult) {
        Intrinsics.checkNotNullParameter(superResult, "<this>");
        return superResult instanceof SuperResult.Success;
    }

    @NotNull
    public static final <T extends Throwable> SuperResult.Failure toFailureResult(@NotNull T t10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        return new SuperResult.Failure(t10);
    }

    @NotNull
    public static final <T> SuperResult.Success<T> toSuccessResult(T t10) {
        return new SuperResult.Success<>(t10);
    }
}
