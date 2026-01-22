package com.oudi.core.callback;

import com.oudi.core.component.IDispatchers;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/oudi/core/callback/SuperCallBack;", "T", "Lcom/oudi/core/component/IDispatchers;", "onSuccess", "", "result", "(Ljava/lang/Object;)V", "onFailure", "throwable", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface SuperCallBack<T> extends IDispatchers {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        @Nullable
        public static <T> CoroutineContext getCoroutineContext(@NotNull SuperCallBack<T> superCallBack) {
            return IDispatchers.DefaultImpls.getCoroutineContext(superCallBack);
        }
    }

    void onFailure(@NotNull Throwable throwable);

    void onSuccess(T result);
}
