package com.qhqc.core.basic.net.interceptor;

import com.qhqc.core.basic.utils.NetWorkUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/qhqc/core/basic/net/interceptor/RequestInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RequestInterceptor implements Interceptor {
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request build;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        if (NetWorkUtils.INSTANCE.isNetworkAvailable()) {
            build = request.newBuilder().cacheControl(CacheControl.FORCE_NETWORK).build();
        } else {
            build = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        return chain.proceed(build);
    }
}
