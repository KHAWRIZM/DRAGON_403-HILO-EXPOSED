package com.alibaba.sdk.android.logger;

import com.alibaba.sdk.android.logger.a.a;
import com.alibaba.sdk.android.logger.b.b;
import com.alibaba.sdk.android.logger.b.c;
import com.alibaba.sdk.android.logger.b.e;
import com.alibaba.sdk.android.logger.b.f;
import com.alibaba.sdk.android.logger.b.g;
import com.alibaba.sdk.android.logger.b.h;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class BaseSdkLogApi {

    /* renamed from: a, reason: collision with root package name */
    private g f٦٤٢٦a;

    /* renamed from: d, reason: collision with root package name */
    private InterceptorManager f٦٤٢٩d;

    /* renamed from: c, reason: collision with root package name */
    private a f٦٤٢٨c = new a();

    /* renamed from: e, reason: collision with root package name */
    private b f٦٤٣٠e = new b();

    /* renamed from: b, reason: collision with root package name */
    private e f٦٤٢٧b = new e(this.f٦٤٣٠e);

    public BaseSdkLogApi(String str, boolean z10) {
        this.f٦٤٢٦a = new g(str);
        InterceptorManager interceptorManager = new InterceptorManager(new com.alibaba.sdk.android.logger.interceptor.a(new h(this.f٦٤٢٨c)), new com.alibaba.sdk.android.logger.interceptor.b(this.f٦٤٢٧b));
        this.f٦٤٢٩d = interceptorManager;
        interceptorManager.a(new c(this.f٦٤٢٧b));
        if (z10) {
            this.f٦٤٣٠e.a(LogLevel.DEBUG);
            this.f٦٤٢٩d.a(new com.alibaba.sdk.android.logger.b.a());
        }
    }

    public void addILogger(ILogger iLogger) {
        this.f٦٤٢٧b.b(iLogger);
    }

    public <T> void addObjectFormat(Class<T> cls, IObjectLogFormat<T> iObjectLogFormat) {
        this.f٦٤٢٨c.a(cls, iObjectLogFormat);
    }

    public void enable(boolean z10) {
        this.f٦٤٣٠e.a(z10);
    }

    public LogBuilder getLogBuilder(Object obj) {
        return new LogBuilder(this.f٦٤٢٩d, obj, this.f٦٤٢٦a);
    }

    public ILog getLogger(Object obj) {
        return new f(this.f٦٤٢٦a.a(obj), this.f٦٤٢٩d);
    }

    public void removeILogger(ILogger iLogger) {
        this.f٦٤٢٧b.c(iLogger);
    }

    public void setILogger(ILogger iLogger) {
        this.f٦٤٢٧b.a(iLogger);
    }

    public void setLevel(LogLevel logLevel) {
        this.f٦٤٣٠e.a(logLevel);
    }
}
