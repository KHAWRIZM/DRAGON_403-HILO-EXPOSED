package com.alibaba.sdk.android.logger.interceptor;

import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface ILogInterceptor {
    void handle(InterceptorManager interceptorManager, int i10, LogLevel logLevel, String str, Object[] objArr);
}
