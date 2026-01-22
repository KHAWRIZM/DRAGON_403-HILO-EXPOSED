package com.qiahao.base_common.network;

import android.os.Build;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.network.gson.GsonConverterFactoryConstructer;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import com.qiahao.base_common.network.model.DownloadProgressModel;
import com.qiahao.base_common.support.BaseControlUtils;
import io.reactivex.rxjava3.core.b0;
import io.reactivex.rxjava3.core.c0;
import io.reactivex.rxjava3.core.z;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pd.f;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0003J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\bJ#\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00148\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010 \u001a\u00020\u001f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010!R\"\u0010#\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010!\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R0\u0010*\u001a\u0010\u0012\f\u0012\n )*\u0004\u0018\u00010\u00140\u00140(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u0011¨\u00065"}, d2 = {"Lcom/qiahao/base_common/network/BaseServer;", "", "<init>", "()V", "", "checkBaseUrl", "", "checkTime", "()Z", "T", "Ljava/lang/Class;", "apis", "createApis", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lcom/qiahao/base_common/network/ServerInfo;", "serverInfo", "switchToServer", "(Lcom/qiahao/base_common/network/ServerInfo;)V", "changProductionServer", "checkServerDebug", "", "url", "Ljava/io/File;", "target", "Lio/reactivex/rxjava3/core/z;", "Lcom/qiahao/base_common/network/model/DownloadProgressModel;", "download", "(Ljava/lang/String;Ljava/io/File;)Lio/reactivex/rxjava3/core/z;", "KEY_SELECTED_SERVER", "Ljava/lang/String;", "COMMUNITY_SELECTED_SERVER", "", "TIMEOUT_DEBUG", "J", "TIMEOUT_PROD", "mChangeTime", "getMChangeTime", "()J", "setMChangeTime", "(J)V", "Lla/b;", "kotlin.jvm.PlatformType", "selectedServerChange", "Lla/b;", "getSelectedServerChange", "()Lla/b;", "setSelectedServerChange", "(Lla/b;)V", "selectedServerInfo", "Lcom/qiahao/base_common/network/ServerInfo;", "getSelectedServerInfo", "()Lcom/qiahao/base_common/network/ServerInfo;", "setSelectedServerInfo", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BaseServer {

    @NotNull
    public static final String COMMUNITY_SELECTED_SERVER = "communitySelectedServer";

    @NotNull
    public static final BaseServer INSTANCE;

    @NotNull
    public static final String KEY_SELECTED_SERVER = "keySelectedServer";
    public static final long TIMEOUT_DEBUG = 10000;
    public static final long TIMEOUT_PROD = 20000;
    private static long mChangeTime;

    @NotNull
    private static la.b selectedServerChange;

    @Nullable
    private static ServerInfo selectedServerInfo;

    static {
        BaseServer baseServer = new BaseServer();
        INSTANCE = baseServer;
        la.b f10 = la.b.f("");
        Intrinsics.checkNotNullExpressionValue(f10, "createDefault(...)");
        selectedServerChange = f10;
        baseServer.checkBaseUrl();
    }

    private BaseServer() {
    }

    private final void checkBaseUrl() {
        String baseUrl;
        CommunityServerInfo communityServerInfo = ServerConfigureKt.getCommunityServers().get(ServerConfigureKt.communityProductionServer);
        if (communityServerInfo != null && (baseUrl = communityServerInfo.getBaseUrl()) != null) {
            BaseControlUtils.INSTANCE.changeCommunityServer(baseUrl);
        }
        selectedServerInfo = ServerConfigureKt.getAvailableServers().get(ServerConfigureKt.kProductionServer);
        selectedServerChange.accept(ServerConfigureKt.kProductionServer);
    }

    private final boolean checkTime() {
        long time = new Date().getTime();
        if (time - mChangeTime > 5000) {
            mChangeTime = time;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void download$lambda$2(String str, File file, b0 it) {
        InputStream inputStream;
        long j10;
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            Response execute = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
            if (execute.body() == null) {
                it.onError(new FileNotFoundException("download failed."));
                return;
            }
            ResponseBody body = execute.body();
            if (body != null) {
                inputStream = body.byteStream();
            } else {
                inputStream = null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            it.a(new f() { // from class: com.qiahao.base_common.network.b
                @Override // pd.f
                public final void cancel() {
                    Ref.BooleanRef.this.element = true;
                }
            });
            byte[] bArr = new byte[2048];
            int i10 = 0;
            for (int read = bufferedInputStream.read(bArr); read != -1 && !booleanRef.element; read = bufferedInputStream.read(bArr)) {
                float f10 = i10;
                ResponseBody body2 = execute.body();
                if (body2 != null) {
                    j10 = body2.contentLength();
                } else {
                    j10 = 1;
                }
                it.onNext(new DownloadProgressModel(f10 / ((float) j10), null));
                i10 += read;
                try {
                    fileOutputStream.write(bArr, 0, read);
                } catch (IOException e10) {
                    if (!it.isDisposed()) {
                        it.onError(e10);
                    }
                }
            }
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
                bufferedInputStream.close();
                it.onNext(new DownloadProgressModel(1.0f, file));
                it.onComplete();
            } catch (IOException e11) {
                if (!it.isDisposed()) {
                    it.onError(e11);
                }
            }
        } catch (IOException e12) {
            if (!it.isDisposed()) {
                it.onError(e12);
            }
        }
    }

    public final void changProductionServer() {
        if (!checkServerDebug() && checkTime()) {
            ServerConfigureKt.changProductionHttps();
            selectedServerInfo = ServerConfigureKt.getAvailableServers().get(ServerConfigureKt.kProductionServer);
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, KEY_SELECTED_SERVER, ServerConfigureKt.kProductionServer, null, 4, null);
            selectedServerChange.accept(ServerConfigureKt.kProductionServer + RangesKt.random(new IntRange(10000000, 99999999), Random.INSTANCE));
        }
    }

    public final boolean checkServerDebug() {
        String str;
        ServerInfo serverInfo = selectedServerInfo;
        if (serverInfo != null) {
            str = serverInfo.getKey();
        } else {
            str = null;
        }
        return Intrinsics.areEqual(str, "test");
    }

    public final <T> T createApis(@Nullable Class<T> apis) {
        String str;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient.Builder addInterceptor = builder.addInterceptor(new HeaderInterceptor());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        addInterceptor.connectTimeout(TIMEOUT_PROD, timeUnit).readTimeout(TIMEOUT_PROD, timeUnit);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            SSLSocketFactory sSLSocketFactory = MySSLSocketClient.getSSLSocketFactory();
            Intrinsics.checkNotNullExpressionValue(sSLSocketFactory, "getSSLSocketFactory(...)");
            X509ExtendedTrustManager X509 = MySSLSocketClient.X509;
            Intrinsics.checkNotNullExpressionValue(X509, "X509");
            builder.sslSocketFactory(sSLSocketFactory, X509);
            HostnameVerifier hostnameVerifier = MySSLSocketClient.getHostnameVerifier();
            Intrinsics.checkNotNullExpressionValue(hostnameVerifier, "getHostnameVerifier(...)");
            builder.hostnameVerifier(hostnameVerifier);
        } else if (i10 > 23 && i10 < 24) {
            SSLSocketFactory sSLSocketFactory2 = MySSLSocketClient.getSSLSocketFactory();
            Intrinsics.checkNotNullExpressionValue(sSLSocketFactory2, "getSSLSocketFactory(...)");
            X509TrustManager X5090 = MySSLSocketClient.X5090;
            Intrinsics.checkNotNullExpressionValue(X5090, "X5090");
            builder.sslSocketFactory(sSLSocketFactory2, X5090);
            HostnameVerifier hostnameVerifier2 = MySSLSocketClient.getHostnameVerifier();
            Intrinsics.checkNotNullExpressionValue(hostnameVerifier2, "getHostnameVerifier(...)");
            builder.hostnameVerifier(hostnameVerifier2);
        }
        builder.proxy(Proxy.NO_PROXY);
        OkHttpClient build = builder.build();
        Retrofit.Builder builder2 = new Retrofit.Builder();
        ServerInfo serverInfo = selectedServerInfo;
        if (serverInfo == null || (str = serverInfo.getBaseUrl()) == null) {
            str = "";
        }
        return (T) builder2.baseUrl(str).client(build).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).addConverterFactory(GsonConverterFactoryConstructer.INSTANCE.create(BaseApplication.INSTANCE.getGSON())).build().create(apis);
    }

    @NotNull
    public final z<DownloadProgressModel> download(@NotNull final String url, @NotNull final File target) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(target, "target");
        z<DownloadProgressModel> create = z.create(new c0() { // from class: com.qiahao.base_common.network.a
            @Override // io.reactivex.rxjava3.core.c0
            public final void a(b0 b0Var) {
                BaseServer.download$lambda$2(url, target, b0Var);
            }
        });
        Intrinsics.checkNotNullExpressionValue(create, "create(...)");
        return create;
    }

    public final long getMChangeTime() {
        return mChangeTime;
    }

    @NotNull
    public final la.b getSelectedServerChange() {
        return selectedServerChange;
    }

    @Nullable
    public final ServerInfo getSelectedServerInfo() {
        return selectedServerInfo;
    }

    public final void setMChangeTime(long j10) {
        mChangeTime = j10;
    }

    public final void setSelectedServerChange(@NotNull la.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        selectedServerChange = bVar;
    }

    public final void setSelectedServerInfo(@Nullable ServerInfo serverInfo) {
        selectedServerInfo = serverInfo;
    }

    public final void switchToServer(@NotNull ServerInfo serverInfo) {
        String str;
        Intrinsics.checkNotNullParameter(serverInfo, "serverInfo");
        String baseUrl = serverInfo.getBaseUrl();
        ServerInfo serverInfo2 = selectedServerInfo;
        if (serverInfo2 != null) {
            str = serverInfo2.getBaseUrl();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(baseUrl, str)) {
            return;
        }
        selectedServerInfo = ServerConfigureKt.getAvailableServers().get(serverInfo.getKey());
        IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, KEY_SELECTED_SERVER, serverInfo.getKey(), null, 4, null);
        selectedServerChange.accept(serverInfo.getKey());
    }
}
