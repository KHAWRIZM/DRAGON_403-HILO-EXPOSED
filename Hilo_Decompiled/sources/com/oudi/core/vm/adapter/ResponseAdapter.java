package com.oudi.core.vm.adapter;

import com.oudi.core.model.SuperResponse;
import com.oudi.core.model.SuperResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u0002H\u0003\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00030\b\"\u0004\b\u0000\u0010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0005H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/oudi/core/vm/adapter/ResponseAdapter;", "", "getResponseBody", "T", "response", "Lcom/oudi/core/model/SuperResponse;", "(Lcom/oudi/core/model/SuperResponse;)Ljava/lang/Object;", "responseToResult", "Lcom/oudi/core/model/SuperResult;", "throwableToResult", "", "throwable", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface ResponseAdapter {
    <T> T getResponseBody(@NotNull SuperResponse<? extends T> response);

    @NotNull
    <T> SuperResult<T> responseToResult(@NotNull SuperResponse<? extends T> response);

    @NotNull
    SuperResult throwableToResult(@NotNull Throwable throwable);
}
