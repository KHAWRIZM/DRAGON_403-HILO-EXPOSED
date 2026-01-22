package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f implements ILog {

    /* renamed from: a, reason: collision with root package name */
    private String f٦٤٤١a;

    /* renamed from: b, reason: collision with root package name */
    private InterceptorManager f٦٤٤٢b;

    public f(String str, InterceptorManager interceptorManager) {
        this.f٦٤٤١a = str;
        this.f٦٤٤٢b = interceptorManager;
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void d(String str) {
        d(str);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void e(String str) {
        e(str);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void i(String str) {
        i(str);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void w(String str) {
        w(str);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void d(Object... objArr) {
        this.f٦٤٤٢b.a(LogLevel.DEBUG, this.f٦٤٤١a, objArr);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void e(String str, Throwable th) {
        e(str, th);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void i(Object... objArr) {
        this.f٦٤٤٢b.a(LogLevel.INFO, this.f٦٤٤١a, objArr);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void w(String str, Throwable th) {
        w(str, th);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void e(Object... objArr) {
        this.f٦٤٤٢b.a(LogLevel.ERROR, this.f٦٤٤١a, objArr);
    }

    @Override // com.alibaba.sdk.android.logger.ILog
    public void w(Object... objArr) {
        this.f٦٤٤٢b.a(LogLevel.WARN, this.f٦٤٤١a, objArr);
    }
}
