package com.oudi.core.callback;

import com.oudi.core.callback.SuperCallBack;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/oudi/core/callback/DefaultCallBack;", "T", "Lcom/oudi/core/callback/SuperCallBack;", "<init>", "()V", "onSuccess", "", "result", "(Ljava/lang/Object;)V", "onFailure", "throwable", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DefaultCallBack<T> implements SuperCallBack<T> {
    @Override // com.oudi.core.component.IDispatchers
    @Nullable
    public CoroutineContext getCoroutineContext() {
        return SuperCallBack.DefaultImpls.getCoroutineContext(this);
    }

    @Override // com.oudi.core.callback.SuperCallBack
    public void onFailure(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }

    @Override // com.oudi.core.callback.SuperCallBack
    public void onSuccess(T result) {
    }
}
