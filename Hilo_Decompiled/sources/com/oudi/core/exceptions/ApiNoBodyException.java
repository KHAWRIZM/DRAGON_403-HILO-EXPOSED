package com.oudi.core.exceptions;

import com.oudi.core.model.SuperResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\b\u0016\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/oudi/core/exceptions/ApiNoBodyException;", "Lcom/oudi/core/exceptions/SuperException;", "response", "Lcom/oudi/core/model/SuperResponse;", "<init>", "(Lcom/oudi/core/model/SuperResponse;)V", "getResponse", "()Lcom/oudi/core/model/SuperResponse;", "setResponse", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class ApiNoBodyException extends SuperException {

    @Nullable
    private SuperResponse<?> response;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ApiNoBodyException(@NotNull SuperResponse<?> response) {
        super(response.getMessage(), r0);
        int i10;
        Intrinsics.checkNotNullParameter(response, "response");
        Integer code = response.getCode();
        if (code != null) {
            i10 = code.intValue();
        } else {
            i10 = 0;
        }
        this.response = response;
    }

    @Nullable
    public final SuperResponse<?> getResponse() {
        return this.response;
    }

    public final void setResponse(@Nullable SuperResponse<?> superResponse) {
        this.response = superResponse;
    }
}
