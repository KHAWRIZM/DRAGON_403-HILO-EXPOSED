package com.qiahao.base_common.network.interceptors;

import android.os.Bundle;
import com.qiahao.base_common.network.model.ErrorResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013¨\u0006 "}, d2 = {"Lcom/qiahao/base_common/network/interceptors/HiloException;", "Ljava/lang/Exception;", "code", "", "errorMessage", "", "bundle", "Landroid/os/Bundle;", "messageData", "Lcom/qiahao/base_common/network/model/ErrorResponse;", "<init>", "(ILjava/lang/String;Landroid/os/Bundle;Lcom/qiahao/base_common/network/model/ErrorResponse;)V", "getCode", "()I", "setCode", "(I)V", "getErrorMessage", "()Ljava/lang/String;", "setErrorMessage", "(Ljava/lang/String;)V", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "getMessageData", "()Lcom/qiahao/base_common/network/model/ErrorResponse;", "setMessageData", "(Lcom/qiahao/base_common/network/model/ErrorResponse;)V", "customMessage", "getCustomMessage", "setCustomMessage", "getLocalizedMessage", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloException extends Exception {

    @Nullable
    private Bundle bundle;
    private int code;

    @Nullable
    private String customMessage;

    @Nullable
    private String errorMessage;

    @Nullable
    private ErrorResponse messageData;

    public HiloException(int i10, @Nullable String str, @Nullable Bundle bundle, @Nullable ErrorResponse errorResponse) {
        this.code = i10;
        this.errorMessage = str;
        this.bundle = bundle;
        this.messageData = errorResponse;
    }

    @Nullable
    public final Bundle getBundle() {
        return this.bundle;
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final String getCustomMessage() {
        return this.customMessage;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    @Override // java.lang.Throwable
    @Nullable
    public String getLocalizedMessage() {
        return this.errorMessage;
    }

    @Nullable
    public final ErrorResponse getMessageData() {
        return this.messageData;
    }

    public final void setBundle(@Nullable Bundle bundle) {
        this.bundle = bundle;
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setCustomMessage(@Nullable String str) {
        this.customMessage = str;
    }

    public final void setErrorMessage(@Nullable String str) {
        this.errorMessage = str;
    }

    public final void setMessageData(@Nullable ErrorResponse errorResponse) {
        this.messageData = errorResponse;
    }

    public /* synthetic */ HiloException(int i10, String str, Bundle bundle, ErrorResponse errorResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, (i11 & 4) != 0 ? null : bundle, (i11 & 8) != 0 ? null : errorResponse);
    }
}
