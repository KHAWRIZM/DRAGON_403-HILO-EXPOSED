package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.logger.interceptor.InterceptorManager;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements com.alibaba.sdk.android.logger.interceptor.c {
    private String a() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        for (int i10 = 1; i10 < stackTrace.length; i10++) {
            if (!stackTrace[i10].getClassName().startsWith("com.alibaba.sdk.android.logger")) {
                return "(" + stackTrace[i10].getFileName() + CertificateUtil.DELIMITER + stackTrace[i10].getLineNumber() + ")";
            }
        }
        return "";
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.c
    public void a(InterceptorManager interceptorManager, int i10, LogLevel logLevel, String str, String str2) {
        interceptorManager.toNextLoggerInterceptor(i10, logLevel, str, str2 + a());
    }
}
