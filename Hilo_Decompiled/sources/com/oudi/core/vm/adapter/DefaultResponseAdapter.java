package com.oudi.core.vm.adapter;

import com.oudi.core.exceptions.ApiException;
import com.oudi.core.model.SuperResponse;
import com.oudi.core.model.SuperResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0016¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00050\n\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0007H\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/oudi/core/vm/adapter/DefaultResponseAdapter;", "Lcom/oudi/core/vm/adapter/ResponseAdapter;", "<init>", "()V", "getResponseBody", "T", "response", "Lcom/oudi/core/model/SuperResponse;", "(Lcom/oudi/core/model/SuperResponse;)Ljava/lang/Object;", "responseToResult", "Lcom/oudi/core/model/SuperResult;", "throwableToResult", "", "throwable", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class DefaultResponseAdapter implements ResponseAdapter {
    @Override // com.oudi.core.vm.adapter.ResponseAdapter
    public <T> T getResponseBody(@NotNull SuperResponse<? extends T> response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccess()) {
            T body = response.getBody();
            if (body != null) {
                return body;
            }
            throw new NullPointerException("response body is Null");
        }
        throw new ApiException(response);
    }

    @Override // com.oudi.core.vm.adapter.ResponseAdapter
    @NotNull
    public <T> SuperResult<T> responseToResult(@NotNull SuperResponse<? extends T> response) {
        Intrinsics.checkNotNullParameter(response, "response");
        try {
            return new SuperResult.Success(getResponseBody(response));
        } catch (Exception e10) {
            return throwableToResult(e10);
        }
    }

    @Override // com.oudi.core.vm.adapter.ResponseAdapter
    @NotNull
    public SuperResult throwableToResult(@NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return new SuperResult.Failure(throwable);
    }
}
