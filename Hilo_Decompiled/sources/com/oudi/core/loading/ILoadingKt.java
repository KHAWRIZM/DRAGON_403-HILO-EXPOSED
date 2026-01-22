package com.oudi.core.loading;

import com.facebook.share.internal.ShareConstants;
import com.oudi.utils.ktx.CoroutineKtxKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\u001a,\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a \u0010\b\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086@¢\u0006\u0002\u0010\t\u001a)\u0010\n\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"showLoadingInCoroutine", "", "Lcom/oudi/core/loading/ILoading;", "id", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Lcom/oudi/core/loading/ILoading;Ljava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissLoadingInCoroutine", "(Lcom/oudi/core/loading/ILoading;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showLoadingInMain", "(Lcom/oudi/core/loading/ILoading;Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "dismissLoadingInMain", "(Lcom/oudi/core/loading/ILoading;Ljava/lang/Integer;)V", "lib_core_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ILoadingKt {
    @Nullable
    public static final Object dismissLoadingInCoroutine(@Nullable ILoading iLoading, @Nullable Integer num, @NotNull Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new ILoadingKt$dismissLoadingInCoroutine$2(iLoading, num, null), continuation);
    }

    public static /* synthetic */ Object dismissLoadingInCoroutine$default(ILoading iLoading, Integer num, Continuation continuation, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        return dismissLoadingInCoroutine(iLoading, num, continuation);
    }

    public static final void dismissLoadingInMain(@Nullable ILoading iLoading, @Nullable Integer num) {
        CoroutineKtxKt.main$default(iLoading, null, new ILoadingKt$dismissLoadingInMain$1(iLoading, num, null), 1, null);
    }

    public static /* synthetic */ void dismissLoadingInMain$default(ILoading iLoading, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        dismissLoadingInMain(iLoading, num);
    }

    @Nullable
    public static final Object showLoadingInCoroutine(@Nullable ILoading iLoading, @Nullable Integer num, @Nullable CharSequence charSequence, @NotNull Continuation<? super Unit> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new ILoadingKt$showLoadingInCoroutine$2(iLoading, num, charSequence, null), continuation);
    }

    public static /* synthetic */ Object showLoadingInCoroutine$default(ILoading iLoading, Integer num, CharSequence charSequence, Continuation continuation, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            charSequence = null;
        }
        return showLoadingInCoroutine(iLoading, num, charSequence, continuation);
    }

    public static final void showLoadingInMain(@Nullable ILoading iLoading, @Nullable Integer num, @Nullable CharSequence charSequence) {
        CoroutineKtxKt.main$default(iLoading, null, new ILoadingKt$showLoadingInMain$1(iLoading, num, charSequence, null), 1, null);
    }

    public static /* synthetic */ void showLoadingInMain$default(ILoading iLoading, Integer num, CharSequence charSequence, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = null;
        }
        if ((i10 & 2) != 0) {
            charSequence = null;
        }
        showLoadingInMain(iLoading, num, charSequence);
    }
}
