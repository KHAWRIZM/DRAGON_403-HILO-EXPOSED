package com.qhqc.core.basic.net;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.qhqc.core.basic.net.config.NetWorkConfiguration;
import com.qhqc.core.basic.net.factory.ExGsonConverterFactory;
import com.qhqc.core.basic.net.flowCallAdapter.FlowCallAdapterFactory;
import com.qhqc.core.basic.net.interceptor.LogInterceptor;
import com.qhqc.core.basic.net.interceptor.RequestInterceptor;
import com.qhqc.core.basic.net.interceptor.ResponseInterceptor;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.utils.LogUtil;
import java.net.Proxy;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/qhqc/core/basic/net/HttpUtils;", "", "()V", "httpClient", "Lokhttp3/OkHttpClient;", "logInterceptor", "Lcom/qhqc/core/basic/net/interceptor/LogInterceptor;", "networkCallback", "com/qhqc/core/basic/net/HttpUtils$networkCallback$1", "Lcom/qhqc/core/basic/net/HttpUtils$networkCallback$1;", "build", "T", "clazz", "Ljava/lang/Class;", "community", "", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "resetConnectionPool", "", "Companion", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HttpUtils {
    private static NetWorkConfiguration configuration;

    @NotNull
    private OkHttpClient httpClient;

    @NotNull
    private LogInterceptor logInterceptor = new LogInterceptor();

    @NotNull
    private final HttpUtils$networkCallback$1 networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.qhqc.core.basic.net.HttpUtils$networkCallback$1
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onAvailable(network);
            LogUtil.INSTANCE.d("HttpUtils", "resetConnectionPool");
            HttpUtils.this.resetConnectionPool();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLost(network);
        }
    };

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<HttpUtils> newInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<HttpUtils>() { // from class: com.qhqc.core.basic.net.HttpUtils$Companion$newInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HttpUtils invoke() {
            return new HttpUtils();
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0007R\u0018\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083.¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R!\u0010\u0006\u001a\u00020\u00078FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/qhqc/core/basic/net/HttpUtils$Companion;", "", "()V", "configuration", "Lcom/qhqc/core/basic/net/config/NetWorkConfiguration;", "getConfiguration$annotations", "newInstance", "Lcom/qhqc/core/basic/net/HttpUtils;", "getNewInstance$annotations", "getNewInstance", "()Lcom/qhqc/core/basic/net/HttpUtils;", "newInstance$delegate", "Lkotlin/Lazy;", "getConfiguration", "getInstance", "setConfiguration", "", "config", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        private static /* synthetic */ void getConfiguration$annotations() {
        }

        @JvmStatic
        public static /* synthetic */ void getNewInstance$annotations() {
        }

        @NotNull
        public final NetWorkConfiguration getConfiguration() {
            NetWorkConfiguration netWorkConfiguration;
            if (HttpUtils.configuration != null) {
                netWorkConfiguration = HttpUtils.configuration;
                if (netWorkConfiguration == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configuration");
                    return null;
                }
            } else {
                HttpUtils.configuration = new NetWorkConfiguration(BasicModuleApp.application());
                netWorkConfiguration = HttpUtils.configuration;
                if (netWorkConfiguration == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("configuration");
                    return null;
                }
            }
            return netWorkConfiguration;
        }

        @JvmStatic
        @NotNull
        public final HttpUtils getInstance() {
            return getNewInstance();
        }

        @NotNull
        public final HttpUtils getNewInstance() {
            return (HttpUtils) HttpUtils.newInstance$delegate.getValue();
        }

        @JvmStatic
        public final void setConfiguration(@NotNull NetWorkConfiguration config) {
            Intrinsics.checkNotNullParameter(config, "config");
            HttpUtils.configuration = config;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.qhqc.core.basic.net.HttpUtils$networkCallback$1] */
    public HttpUtils() {
        NetWorkConfiguration configuration2 = INSTANCE.getConfiguration();
        OkHttpClient.Builder newBuilder = new OkHttpClient().newBuilder();
        long connectTimeout = configuration2.getConnectTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder retryOnConnectionFailure = newBuilder.connectTimeout(connectTimeout, timeUnit).readTimeout(configuration2.getConnectTimeout(), timeUnit).writeTimeout(configuration2.getConnectTimeout(), timeUnit).connectionPool(configuration2.getConnectionPool()).retryOnConnectionFailure(true);
        if (configuration2.getIsCache()) {
            retryOnConnectionFailure.addInterceptor(new RequestInterceptor()).addNetworkInterceptor(new ResponseInterceptor()).cache(configuration2.getDiskCache());
        }
        retryOnConnectionFailure.proxy(Proxy.NO_PROXY);
        this.httpClient = retryOnConnectionFailure.build();
        if (configuration2.getCertificates() != null) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        Intrinsics.checkNotNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
                        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
                        OkHttpClient.Builder newBuilder2 = retryOnConnectionFailure.build().newBuilder();
                        Intrinsics.checkNotNull(socketFactory);
                        this.httpClient = newBuilder2.sslSocketFactory(socketFactory, x509TrustManager).build();
                    }
                }
                throw new IllegalStateException(("Unexpected default trust managers:" + Arrays.toString(trustManagers)).toString());
            } catch (Exception unused) {
            }
        }
        Object systemService = BasicModuleApp.application().getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).build();
        if (connectivityManager != null) {
            connectivityManager.registerNetworkCallback(build, this.networkCallback);
        }
    }

    public static /* synthetic */ Object build$default(HttpUtils httpUtils, Class cls, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return httpUtils.build(cls, z10);
    }

    @JvmStatic
    @NotNull
    public static final HttpUtils getInstance() {
        return INSTANCE.getInstance();
    }

    @NotNull
    public static final HttpUtils getNewInstance() {
        return INSTANCE.getNewInstance();
    }

    @JvmStatic
    public static final void setConfiguration(@NotNull NetWorkConfiguration netWorkConfiguration) {
        INSTANCE.setConfiguration(netWorkConfiguration);
    }

    public final <T> T build(@NotNull Class<T> clazz, boolean community) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) new Retrofit.Builder().baseUrl(INSTANCE.getConfiguration().getBaseUrl()).client(this.httpClient).addConverterFactory(ExGsonConverterFactory.INSTANCE.create()).addCallAdapterFactory(FlowCallAdapterFactory.Companion.create$default(FlowCallAdapterFactory.INSTANCE, false, 1, null)).build().create(clazz);
    }

    public final void resetConnectionPool() {
        this.httpClient.connectionPool().evictAll();
    }
}
