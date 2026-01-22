package com.qhqc.core.basic.net.exception;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000e\u0018\u0000 \u00172\u00060\u0001j\u0002`\u0002:\u0001\u0017B\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0005R\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0005¨\u0006\u0018"}, d2 = {"Lcom/qhqc/core/basic/net/exception/ApiErrorException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "(Ljava/lang/String;)V", "code", "", "(ILjava/lang/String;)V", "cause", "", "(ILjava/lang/Throwable;)V", "getCode", "()I", "setCode", "(I)V", "errorData", "getErrorData", "()Ljava/lang/String;", "setErrorData", "msg", "getMsg", "setMsg", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ApiErrorException extends RuntimeException {
    public static final int BAD_GATEWAY = 502;
    public static final int FORBIDDEN = 403;
    public static final int HTTP_ERROR = 1003;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final int NET_WORD_ERROR = 1002;
    public static final int NOT_FOUND = 404;
    public static final int PARSE_ERROR = 1001;
    public static final int REQUEST_TIMEOUT = 408;
    public static final int SERVICE_UNAVAILABLE = 503;
    public static final int SIGN_CHECK_ERROR = 405;
    public static final int SSL_ERROR = 1005;
    public static final int TIMEOUT_ERROR = 1006;
    public static final int UNAUTHORIZED = 401;
    public static final int UNKNOWN = 1000;
    public static final int UNKNOWN_LOGIN = 1000;
    private int code;

    @NotNull
    private String errorData;

    @NotNull
    private String msg;

    public ApiErrorException(@Nullable String str) {
        super(str);
        String message = getMessage();
        this.msg = message == null ? "" : message;
        this.errorData = "";
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getErrorData() {
        return this.errorData;
    }

    @NotNull
    public final String getMsg() {
        return this.msg;
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setErrorData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorData = str;
    }

    public final void setMsg(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msg = str;
    }

    public ApiErrorException(int i10, @Nullable String str) {
        this(str);
        this.code = i10;
    }

    public ApiErrorException(int i10, @Nullable Throwable th) {
        super(th);
        String message = getMessage();
        this.msg = message == null ? "" : message;
        this.errorData = "";
        this.code = i10;
    }
}
