package com.qiahao.base_common.network.model;

import com.facebook.share.internal.ShareConstants;
import io.agora.rtc.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 +*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0002:\u0001+B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003JN\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010)\u001a\u00020\u0006HÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/qiahao/base_common/network/model/ApiResponse;", "T", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "code", "", "data", "edata", "messageData", "Lcom/qiahao/base_common/network/model/ErrorResponse;", "<init>", "(Ljava/lang/String;ILjava/lang/Object;Ljava/lang/String;Lcom/qiahao/base_common/network/model/ErrorResponse;)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getCode", "()I", "setCode", "(I)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getEdata", "setEdata", "getMessageData", "()Lcom/qiahao/base_common/network/model/ErrorResponse;", "isOk", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ILjava/lang/Object;Ljava/lang/String;Lcom/qiahao/base_common/network/model/ErrorResponse;)Lcom/qiahao/base_common/network/model/ApiResponse;", "equals", "other", "hashCode", "toString", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final /* data */ class ApiResponse<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int code;

    @Nullable
    private T data;

    @Nullable
    private String edata;

    @Nullable
    private String message;

    @Nullable
    private final ErrorResponse messageData;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\b\b\u0001\u0010\u0006*\u00020\u00012\b\u0010\u0007\u001a\u0004\u0018\u0001H\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/network/model/ApiResponse$Companion;", "", "<init>", "()V", "success", "Lcom/qiahao/base_common/network/model/ApiResponse;", "T", "data", "(Ljava/lang/Object;)Lcom/qiahao/base_common/network/model/ApiResponse;", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> ApiResponse<T> success(@Nullable T data) {
            return new ApiResponse<>(String.valueOf(System.currentTimeMillis()), 200, data, "", new ErrorResponse(null, null, null, null, null, null, null, Constants.ERR_WATERMARKR_INFO, null));
        }

        private Companion() {
        }
    }

    public ApiResponse(@Nullable String str, int i10, @Nullable T t10, @Nullable String str2, @Nullable ErrorResponse errorResponse) {
        this.message = str;
        this.code = i10;
        this.data = t10;
        this.edata = str2;
        this.messageData = errorResponse;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ApiResponse copy$default(ApiResponse apiResponse, String str, int i10, Object obj, String str2, ErrorResponse errorResponse, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            str = apiResponse.message;
        }
        if ((i11 & 2) != 0) {
            i10 = apiResponse.code;
        }
        int i12 = i10;
        T t10 = obj;
        if ((i11 & 4) != 0) {
            t10 = apiResponse.data;
        }
        T t11 = t10;
        if ((i11 & 8) != 0) {
            str2 = apiResponse.edata;
        }
        String str3 = str2;
        if ((i11 & 16) != 0) {
            errorResponse = apiResponse.messageData;
        }
        return apiResponse.copy(str, i12, t11, str3, errorResponse);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T component3() {
        return this.data;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getEdata() {
        return this.edata;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final ErrorResponse getMessageData() {
        return this.messageData;
    }

    @NotNull
    public final ApiResponse<T> copy(@Nullable String message, int code, @Nullable T data, @Nullable String edata, @Nullable ErrorResponse messageData) {
        return new ApiResponse<>(message, code, data, edata, messageData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApiResponse)) {
            return false;
        }
        ApiResponse apiResponse = (ApiResponse) other;
        return Intrinsics.areEqual(this.message, apiResponse.message) && this.code == apiResponse.code && Intrinsics.areEqual(this.data, apiResponse.data) && Intrinsics.areEqual(this.edata, apiResponse.edata) && Intrinsics.areEqual(this.messageData, apiResponse.messageData);
    }

    public final int getCode() {
        return this.code;
    }

    @Nullable
    public final T getData() {
        return this.data;
    }

    @Nullable
    public final String getEdata() {
        return this.edata;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final ErrorResponse getMessageData() {
        return this.messageData;
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.code) * 31;
        T t10 = this.data;
        int hashCode2 = (hashCode + (t10 == null ? 0 : t10.hashCode())) * 31;
        String str2 = this.edata;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        ErrorResponse errorResponse = this.messageData;
        return hashCode3 + (errorResponse != null ? errorResponse.hashCode() : 0);
    }

    public final boolean isOk() {
        if (this.code == 200) {
            return true;
        }
        return false;
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setData(@Nullable T t10) {
        this.data = t10;
    }

    public final void setEdata(@Nullable String str) {
        this.edata = str;
    }

    public final void setMessage(@Nullable String str) {
        this.message = str;
    }

    @NotNull
    public String toString() {
        return "ApiResponse(message=" + this.message + ", code=" + this.code + ", data=" + this.data + ", edata=" + this.edata + ", messageData=" + this.messageData + ")";
    }

    public /* synthetic */ ApiResponse(String str, int i10, Object obj, String str2, ErrorResponse errorResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i10, obj, (i11 & 8) != 0 ? null : str2, errorResponse);
    }
}
