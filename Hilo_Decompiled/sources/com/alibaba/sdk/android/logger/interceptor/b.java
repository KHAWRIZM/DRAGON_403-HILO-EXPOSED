package com.alibaba.sdk.android.logger.interceptor;

import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private ILogger f٦٤٥٤a;

    public b(ILogger iLogger) {
        this.f٦٤٥٤a = iLogger;
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.c
    public void a(InterceptorManager interceptorManager, int i10, LogLevel logLevel, String str, String str2) {
        this.f٦٤٥٤a.print(logLevel, str, str2);
    }
}
