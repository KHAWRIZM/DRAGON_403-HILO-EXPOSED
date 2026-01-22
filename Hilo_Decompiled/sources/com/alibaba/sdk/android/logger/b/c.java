package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.logger.interceptor.ILogInterceptor;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements ILogInterceptor {

    /* renamed from: a, reason: collision with root package name */
    private e f٦٤٣٥a;

    public c(e eVar) {
        this.f٦٤٣٥a = eVar;
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.ILogInterceptor
    public void handle(InterceptorManager interceptorManager, int i10, LogLevel logLevel, String str, Object[] objArr) {
        if (this.f٦٤٣٥a.a(logLevel)) {
            interceptorManager.toNextLogInterceptor(i10, logLevel, str, objArr);
        }
    }
}
