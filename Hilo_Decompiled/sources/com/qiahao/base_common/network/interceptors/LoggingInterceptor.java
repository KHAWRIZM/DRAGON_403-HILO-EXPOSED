package com.qiahao.base_common.network.interceptors;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/network/interceptors/LoggingInterceptor;", "Lokhttp3/Interceptor;", "<init>", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LoggingInterceptor implements Interceptor {

    @NotNull
    public static final String TAG = "network";

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        String str;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        System.nanoTime();
        ResponseBody body = proceed.body();
        MediaType mediaType = null;
        if (body != null) {
            str = body.string();
        } else {
            str = null;
        }
        Response.Builder newBuilder = proceed.newBuilder();
        if (str != null) {
            ResponseBody.Companion companion = ResponseBody.Companion;
            ResponseBody body2 = proceed.body();
            if (body2 != null) {
                mediaType = body2.contentType();
            }
            mediaType = companion.create(str, mediaType);
        }
        return newBuilder.body(mediaType).build();
    }
}
