package com.oudi.core.model;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.facebook.login.LoginLogger;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.model.SuperResult;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u001f\u001a\u00020\u001c2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002J\r\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010!J\b\u0010\"\u001a\u0004\u0018\u00010\u0013J`\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010$\u001a\u00020%2#\b\u0002\u0010&\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001c0\b2#\b\u0002\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001c0\bH\u0016JZ\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002%\b\u0002\u0010&\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u001c\u0018\u00010\b2%\b\u0002\u0010(\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u001c\u0018\u00010\bRA\u0010\u0007\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011RA\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R=\u0010\u0018\u001a%\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006+"}, d2 = {"Lcom/oudi/core/model/ResultLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "Lcom/oudi/core/model/SuperResult;", "Lcom/oudi/core/callback/SuperCallBack;", "<init>", "()V", "onSuccessDataInterceptor", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "getOnSuccessDataInterceptor$annotations", "getOnSuccessDataInterceptor", "()Lkotlin/jvm/functions/Function1;", "setOnSuccessDataInterceptor", "(Lkotlin/jvm/functions/Function1;)V", "onFailureDataInterceptor", "", "throwable", "getOnFailureDataInterceptor$annotations", "getOnFailureDataInterceptor", "setOnFailureDataInterceptor", "updateInterceptor", "getUpdateInterceptor", "setUpdateInterceptor", "onSuccess", "", "(Ljava/lang/Object;)V", "onFailure", "postValueInterceptor", "getSuccessValue", "()Ljava/lang/Object;", "getFailureValue", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "success", "value", LoginLogger.EVENT_EXTRAS_FAILURE, "e", "observeForever", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ResultLiveData<T> extends MutableLiveData<SuperResult<? extends T>> implements SuperCallBack<T> {

    @Nullable
    private Function1<? super Throwable, Boolean> onFailureDataInterceptor;

    @Nullable
    private Function1<? super T, Boolean> onSuccessDataInterceptor;

    @Nullable
    private Function1<? super SuperResult<? extends T>, Boolean> updateInterceptor;

    @Deprecated(message = "准备移除，可使用updateInterceptor代替")
    public static /* synthetic */ void getOnFailureDataInterceptor$annotations() {
    }

    @Deprecated(message = "准备移除，可使用updateInterceptor代替")
    public static /* synthetic */ void getOnSuccessDataInterceptor$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResultLiveData observe$default(ResultLiveData resultLiveData, LifecycleOwner lifecycleOwner, Function1 function1, Function1 function12, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 2) != 0) {
                function1 = new Function1() { // from class: com.oudi.core.model.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit observe$lambda$0;
                        observe$lambda$0 = ResultLiveData.observe$lambda$0(obj2);
                        return observe$lambda$0;
                    }
                };
            }
            if ((i10 & 4) != 0) {
                function12 = new Function1() { // from class: com.oudi.core.model.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        Unit observe$lambda$1;
                        observe$lambda$1 = ResultLiveData.observe$lambda$1((Throwable) obj2);
                        return observe$lambda$1;
                    }
                };
            }
            return resultLiveData.observe(lifecycleOwner, function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observe");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$0(Object obj) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observe$lambda$1(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observe$lambda$2(Function1 function1, Function1 function12, SuperResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof SuperResult.Failure) {
            function1.invoke(((SuperResult.Failure) it).getThrowable());
        } else {
            if (it instanceof SuperResult.Success) {
                function12.invoke(((SuperResult.Success) it).getData());
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResultLiveData observeForever$default(ResultLiveData resultLiveData, Function1 function1, Function1 function12, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                function1 = null;
            }
            if ((i10 & 2) != 0) {
                function12 = null;
            }
            return resultLiveData.observeForever(function1, function12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: observeForever");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit observeForever$lambda$3(Function1 function1, Function1 function12, SuperResult superResult) {
        if (superResult instanceof SuperResult.Failure) {
            if (function1 != null) {
                function1.invoke(((SuperResult.Failure) superResult).getThrowable());
            }
        } else if (superResult instanceof SuperResult.Success) {
            if (function12 != null) {
                function12.invoke(((SuperResult.Success) superResult).getData());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void postValueInterceptor(SuperResult<? extends T> result) {
        Function1<? super SuperResult<? extends T>, Boolean> function1 = this.updateInterceptor;
        if (function1 != null && function1.invoke(result).booleanValue()) {
            return;
        }
        postValue(result);
    }

    @Override // com.oudi.core.component.IDispatchers
    @Nullable
    public CoroutineContext getCoroutineContext() {
        return SuperCallBack.DefaultImpls.getCoroutineContext(this);
    }

    @Nullable
    public final Throwable getFailureValue() {
        SuperResult.Failure failure;
        T value = getValue();
        if (value instanceof SuperResult.Failure) {
            failure = (SuperResult.Failure) value;
        } else {
            failure = null;
        }
        if (failure == null) {
            return null;
        }
        return failure.getThrowable();
    }

    @Nullable
    public final Function1<Throwable, Boolean> getOnFailureDataInterceptor() {
        return this.onFailureDataInterceptor;
    }

    @Nullable
    public final Function1<T, Boolean> getOnSuccessDataInterceptor() {
        return this.onSuccessDataInterceptor;
    }

    @Nullable
    public final T getSuccessValue() {
        SuperResult.Success success;
        T value = getValue();
        if (value instanceof SuperResult.Success) {
            success = (SuperResult.Success) value;
        } else {
            success = null;
        }
        if (success == null) {
            return null;
        }
        return (T) success.getData();
    }

    @Nullable
    public final Function1<SuperResult<? extends T>, Boolean> getUpdateInterceptor() {
        return this.updateInterceptor;
    }

    @NotNull
    public ResultLiveData<T> observe(@NotNull LifecycleOwner owner, @NotNull final Function1<? super T, Unit> success, @NotNull final Function1<? super Throwable, Unit> failure) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(failure, "failure");
        super.observe(owner, new Observer() { // from class: com.oudi.core.model.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ResultLiveData.observe$lambda$2(Function1.this, success, (SuperResult) obj);
            }
        });
        return this;
    }

    @NotNull
    public final ResultLiveData<T> observeForever(@Nullable final Function1<? super T, Unit> success, @Nullable final Function1<? super Throwable, Unit> failure) {
        super.observeForever(new ResultLiveData$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.oudi.core.model.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit observeForever$lambda$3;
                observeForever$lambda$3 = ResultLiveData.observeForever$lambda$3(Function1.this, success, (SuperResult) obj);
                return observeForever$lambda$3;
            }
        }));
        return this;
    }

    @Override // com.oudi.core.callback.SuperCallBack
    public void onFailure(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Function1<? super Throwable, Boolean> function1 = this.onFailureDataInterceptor;
        if (function1 != null && function1.invoke(throwable).booleanValue()) {
            return;
        }
        postValueInterceptor(new SuperResult.Failure(throwable));
    }

    @Override // com.oudi.core.callback.SuperCallBack
    public void onSuccess(T result) {
        Function1<? super T, Boolean> function1 = this.onSuccessDataInterceptor;
        if (function1 != null && function1.invoke(result).booleanValue()) {
            return;
        }
        postValueInterceptor(new SuperResult.Success(result));
    }

    public final void setOnFailureDataInterceptor(@Nullable Function1<? super Throwable, Boolean> function1) {
        this.onFailureDataInterceptor = function1;
    }

    public final void setOnSuccessDataInterceptor(@Nullable Function1<? super T, Boolean> function1) {
        this.onSuccessDataInterceptor = function1;
    }

    public final void setUpdateInterceptor(@Nullable Function1<? super SuperResult<? extends T>, Boolean> function1) {
        this.updateInterceptor = function1;
    }
}
