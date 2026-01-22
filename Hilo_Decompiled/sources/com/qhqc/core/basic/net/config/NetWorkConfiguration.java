package com.qhqc.core.basic.net.config;

import android.content.Context;
import com.qiahao.base_common.network.interceptors.LoggingInterceptor;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0006J\u0019\u0010\r\u001a\u00020\u00002\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\u0010:J\u001f\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u000e\"\u00020\u0016¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020=J\u001e\u0010\"\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\f2\u0006\u0010?\u001a\u00020\u001d2\u0006\u0010@\u001a\u00020AJ\u000e\u00101\u001a\u00020\u00002\u0006\u00109\u001a\u000202R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0016\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u000e\u00108\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/qhqc/core/basic/net/config/NetWorkConfiguration;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "baseUrlIndex", "", "baseUrls", "", "[Ljava/lang/String;", "cacheTime", "getCacheTime", "()I", "setCacheTime", "(I)V", "certificates", "Ljava/io/InputStream;", "getCertificates", "()[Ljava/io/InputStream;", "setCertificates", "([Ljava/io/InputStream;)V", "[Ljava/io/InputStream;", "connectTimeout", "", "getConnectTimeout", "()J", "setConnectTimeout", "(J)V", "connectionPool", "Lokhttp3/ConnectionPool;", "getConnectionPool", "()Lokhttp3/ConnectionPool;", "setConnectionPool", "(Lokhttp3/ConnectionPool;)V", "diskCache", "Lokhttp3/Cache;", "getDiskCache", "()Lokhttp3/Cache;", "setDiskCache", "(Lokhttp3/Cache;)V", "expiredTime", "getExpiredTime", "setExpiredTime", "isCache", "", "()Z", "setCache", "(Z)V", "isMemoryCache", "setMemoryCache", "maxDiskCacheSize", "value", "([Ljava/lang/String;)Lcom/qhqc/core/basic/net/config/NetWorkConfiguration;", "([Ljava/io/InputStream;)Lcom/qhqc/core/basic/net/config/NetWorkConfiguration;", "changeBaseUrl", "", "count", "time", "unit", "Ljava/util/concurrent/TimeUnit;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class NetWorkConfiguration {
    private int baseUrlIndex;

    @Nullable
    private String[] baseUrls;
    private int cacheTime;

    @Nullable
    private InputStream[] certificates;

    @Nullable
    private Cache diskCache;
    private int expiredTime;
    private boolean isCache;
    private boolean isMemoryCache;

    @NotNull
    private String baseUrl = "";
    private long connectTimeout = 15000;

    @NotNull
    private ConnectionPool connectionPool = new ConnectionPool(50, 60, TimeUnit.SECONDS);
    private long maxDiskCacheSize = 31457280;

    public NetWorkConfiguration(@Nullable Context context) {
        if (context != null) {
            this.diskCache = new Cache(new File(context.getApplicationContext().getCacheDir(), LoggingInterceptor.TAG), this.maxDiskCacheSize);
        }
    }

    @NotNull
    public final NetWorkConfiguration baseUrl(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.baseUrl = value;
        return this;
    }

    @NotNull
    public final NetWorkConfiguration baseUrls(@NotNull String[] value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.baseUrl = value[0];
        this.baseUrlIndex = 0;
        this.baseUrls = value;
        return this;
    }

    @NotNull
    public final NetWorkConfiguration certificates(@NotNull InputStream... certificates) {
        Intrinsics.checkNotNullParameter(certificates, "certificates");
        this.certificates = certificates;
        return this;
    }

    public final void changeBaseUrl() {
        String[] strArr = this.baseUrls;
        if (strArr == null) {
            return;
        }
        int i10 = this.baseUrlIndex + 1;
        this.baseUrlIndex = i10;
        this.baseUrl = strArr[i10 % strArr.length];
    }

    @NotNull
    public final NetWorkConfiguration connectionPool(int count, long time, @NotNull TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (time <= 0 && time <= 0) {
            return this;
        }
        this.connectionPool = new ConnectionPool(count, time, unit);
        return this;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final int getCacheTime() {
        return this.cacheTime;
    }

    @Nullable
    public final InputStream[] getCertificates() {
        return this.certificates;
    }

    public final long getConnectTimeout() {
        return this.connectTimeout;
    }

    @NotNull
    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Nullable
    public final Cache getDiskCache() {
        return this.diskCache;
    }

    public final int getExpiredTime() {
        return this.expiredTime;
    }

    /* renamed from: isCache, reason: from getter */
    public final boolean getIsCache() {
        return this.isCache;
    }

    /* renamed from: isMemoryCache, reason: from getter */
    public final boolean getIsMemoryCache() {
        return this.isMemoryCache;
    }

    public final void setBaseUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.baseUrl = str;
    }

    public final void setCache(boolean z10) {
        this.isCache = z10;
    }

    public final void setCacheTime(int i10) {
        this.cacheTime = i10;
    }

    public final void setCertificates(@Nullable InputStream[] inputStreamArr) {
        this.certificates = inputStreamArr;
    }

    public final void setConnectTimeout(long j10) {
        this.connectTimeout = j10;
    }

    public final void setConnectionPool(@NotNull ConnectionPool connectionPool) {
        Intrinsics.checkNotNullParameter(connectionPool, "<set-?>");
        this.connectionPool = connectionPool;
    }

    public final void setDiskCache(@Nullable Cache cache) {
        this.diskCache = cache;
    }

    public final void setExpiredTime(int i10) {
        this.expiredTime = i10;
    }

    public final void setMemoryCache(boolean z10) {
        this.isMemoryCache = z10;
    }

    @NotNull
    public final NetWorkConfiguration isCache(boolean value) {
        this.isCache = value;
        return this;
    }
}
