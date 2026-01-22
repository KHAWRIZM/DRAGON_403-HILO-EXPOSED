package com.qhqc.core.basic.net.handler;

import com.google.gson.j;
import com.google.gson.m;
import com.qhqc.core.basic.R;
import com.qhqc.core.basic.net.HttpUtils;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IApiExceptionHandler;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import org.apache.http.conn.ConnectTimeoutException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/qhqc/core/basic/net/handler/ExceptionHandler;", "", "()V", "handleApiException", "", "exception", "Lcom/qhqc/core/basic/net/exception/ApiErrorException;", "handleException", "throwable", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ExceptionHandler {

    @NotNull
    public static final ExceptionHandler INSTANCE = new ExceptionHandler();

    private ExceptionHandler() {
    }

    private final void handleApiException(ApiErrorException exception) {
        IApiExceptionHandler apiExceptionHandler = BasicModuleApp.INSTANCE.apiExceptionHandler();
        if (apiExceptionHandler != null) {
            apiExceptionHandler.handleException(exception);
        }
    }

    @NotNull
    public final ApiErrorException handleException(@Nullable Throwable throwable) {
        boolean z10;
        boolean z11;
        if (throwable instanceof ApiErrorException) {
            ApiErrorException apiErrorException = (ApiErrorException) throwable;
            handleApiException(apiErrorException);
            return apiErrorException;
        }
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            int code = httpException.code();
            if (code == 401 || code == 408 || code == 500 || code == 403 || code == 404 || code == 502 || code == 503) {
                HttpUtils.INSTANCE.getConfiguration().changeBaseUrl();
            }
            return new ApiErrorException(1003, BasicModuleApp.application().getString(R.string.basic_m_no_network) + httpException.code());
        }
        if (throwable instanceof UnknownHostException) {
            return new ApiErrorException(1002, BasicModuleApp.application().getString(R.string.basic_m_no_network) + " UnknownHostException");
        }
        if (throwable instanceof ConnectException) {
            return new ApiErrorException(1002, BasicModuleApp.application().getString(R.string.basic_m_no_network) + " ApiErrorException");
        }
        if (throwable instanceof SSLHandshakeException) {
            return new ApiErrorException(1005, "Certificate verification exception");
        }
        boolean z12 = true;
        if (throwable instanceof j) {
            z10 = true;
        } else {
            z10 = throwable instanceof JSONException;
        }
        if (z10) {
            z11 = true;
        } else {
            z11 = throwable instanceof m;
        }
        if (z11) {
            return new ApiErrorException(1001, "parse error");
        }
        if (!(throwable instanceof SocketTimeoutException)) {
            z12 = throwable instanceof ConnectTimeoutException;
        }
        if (z12) {
            return new ApiErrorException(1006, BasicModuleApp.application().getString(R.string.basic_m_connect_timeout));
        }
        return new ApiErrorException(1000, BasicModuleApp.application().getString(R.string.basic_m_unknown_error));
    }
}
