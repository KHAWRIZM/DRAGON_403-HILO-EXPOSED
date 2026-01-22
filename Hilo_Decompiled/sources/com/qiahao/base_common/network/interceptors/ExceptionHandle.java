package com.qiahao.base_common.network.interceptors;

import android.net.ParseException;
import com.google.gson.m;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.interceptors.ExceptionHandle;
import com.qiahao.base_common.utils.HiloUtils;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.http.conn.ConnectTimeoutException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/base_common/network/interceptors/ExceptionHandle;", "", "<init>", "()V", "UNAUTHORIZED", "", "FORBIDDEN", "NOT_FOUND", "REQUEST_TIMEOUT", "INTERNAL_SERVER_ERROR", "BAD_GATEWAY", "SERVICE_UNAVAILABLE", "handleException", "Lcom/qiahao/base_common/network/interceptors/HiloException;", "e", "", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ExceptionHandle {
    private static final int BAD_GATEWAY = 502;
    private static final int FORBIDDEN = 403;

    @NotNull
    public static final ExceptionHandle INSTANCE = new ExceptionHandle();
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int UNAUTHORIZED = 401;

    private ExceptionHandle() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleException$lambda$0() {
        BaseServer.INSTANCE.changProductionServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleException$lambda$1() {
        BaseServer.INSTANCE.changProductionServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleException$lambda$2() {
        BaseServer.INSTANCE.changProductionServer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleException$lambda$3() {
        BaseServer.INSTANCE.changProductionServer();
    }

    @NotNull
    public final HiloException handleException(@NotNull Throwable e10) {
        Intrinsics.checkNotNullParameter(e10, "e");
        HiloException hiloException = new HiloException(500, e10.getMessage(), null, null, 12, null);
        if (e10 instanceof HiloException) {
            HiloException hiloException2 = (HiloException) e10;
            hiloException.setCode(hiloException2.getCode());
            hiloException.setErrorMessage(hiloException2.getErrorMessage());
            hiloException.setCustomMessage(hiloException2.getErrorMessage());
            hiloException.setMessageData(hiloException2.getMessageData());
        } else if (e10 instanceof HttpException) {
            int code = ((HttpException) e10).code();
            if (code == 401 || code == 408 || code == 500 || code == 403 || code == 404 || code == 502 || code == 503) {
                int i10 = R.string.the_network_error1;
                hiloException.setErrorMessage(ResourcesKtxKt.getStringById(this, i10));
                hiloException.setCustomMessage(ResourcesKtxKt.getStringById(this, i10));
                HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: eb.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExceptionHandle.handleException$lambda$0();
                    }
                });
            }
        } else if (!(e10 instanceof m) && !(e10 instanceof JSONException) && !(e10 instanceof ParseException)) {
            if (!(e10 instanceof ConnectException) && !(e10 instanceof UnknownHostException)) {
                if (e10 instanceof SSLHandshakeException) {
                    hiloException.setErrorMessage(ResourcesKtxKt.getStringById(this, R.string.the_network_error1));
                    hiloException.setCustomMessage("证书验证异常");
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: eb.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ExceptionHandle.handleException$lambda$2();
                        }
                    });
                } else if (!(e10 instanceof ConnectTimeoutException) && !(e10 instanceof SocketTimeoutException)) {
                    hiloException.setCustomMessage("不知道的异常" + e10.getMessage());
                } else {
                    hiloException.setErrorMessage(ResourcesKtxKt.getStringById(this, R.string.the_network_error1));
                    hiloException.setCustomMessage("请求超时");
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: eb.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            ExceptionHandle.handleException$lambda$3();
                        }
                    });
                }
            } else {
                hiloException.setErrorMessage(ResourcesKtxKt.getStringById(this, R.string.the_network_error1));
                hiloException.setCustomMessage("网络连接异常");
                HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: eb.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExceptionHandle.handleException$lambda$1();
                    }
                });
            }
        } else {
            hiloException.setErrorMessage(ResourcesKtxKt.getStringById(this, R.string.the_network_error1));
            hiloException.setCustomMessage("数据解析错误");
        }
        return hiloException;
    }
}
