package com.qhqc.core.basic.uiframe.viewmodel;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.gson.j;
import com.google.gson.m;
import com.qhqc.core.basic.net.HttpUtils;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.apache.http.conn.ConnectTimeoutException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/qhqc/core/basic/uiframe/viewmodel/CoroutineExceptionHandlerImpl;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", TransferTable.COLUMN_KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "throwable", "", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CoroutineExceptionHandlerImpl implements CoroutineExceptionHandler {
    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) CoroutineExceptionHandler.DefaultImpls.fold(this, r10, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) CoroutineExceptionHandler.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return CoroutineExceptionHandler.INSTANCE;
    }

    @Override // kotlinx.coroutines.CoroutineExceptionHandler
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable throwable) {
        boolean z10;
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        if (!(throwable instanceof ApiErrorException)) {
            if (throwable instanceof HttpException) {
                int code = ((HttpException) throwable).code();
                if (code == 401 || code == 408 || code == 500 || code == 403 || code == 404 || code == 502 || code == 503) {
                    HttpUtils.INSTANCE.getConfiguration().changeBaseUrl();
                    return;
                }
                return;
            }
            boolean z12 = true;
            if (throwable instanceof UnknownHostException) {
                z10 = true;
            } else {
                z10 = throwable instanceof ConnectException;
            }
            if (!z10 && !(throwable instanceof SSLHandshakeException)) {
                if (throwable instanceof j) {
                    z11 = true;
                } else {
                    z11 = throwable instanceof JSONException;
                }
                if (!z11) {
                    z12 = throwable instanceof m;
                }
                if (!z12 && !(throwable instanceof SocketTimeoutException)) {
                    boolean z13 = throwable instanceof ConnectTimeoutException;
                }
            }
        }
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return CoroutineExceptionHandler.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.DefaultImpls.plus(this, coroutineContext);
    }
}
