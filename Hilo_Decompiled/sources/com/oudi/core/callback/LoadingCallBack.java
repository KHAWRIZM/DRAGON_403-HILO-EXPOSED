package com.oudi.core.callback;

import com.oudi.core.callback.SuperCallBack;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/oudi/core/callback/LoadingCallBack;", "T", "Lcom/oudi/core/callback/SuperCallBack;", "isShowLoading", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface LoadingCallBack<T> extends SuperCallBack<T> {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DefaultImpls {
        @Nullable
        public static <T> CoroutineContext getCoroutineContext(@NotNull LoadingCallBack<T> loadingCallBack) {
            return SuperCallBack.DefaultImpls.getCoroutineContext(loadingCallBack);
        }

        public static <T> boolean isShowLoading(@NotNull LoadingCallBack<T> loadingCallBack) {
            return false;
        }
    }

    boolean isShowLoading();
}
