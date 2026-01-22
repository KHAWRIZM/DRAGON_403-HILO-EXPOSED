package com.alibaba.sdk.android.sender;

import com.alibaba.sdk.android.logger.BaseSdkLogApi;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SenderLog {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final BaseSdkLogApi f٦٨٠٩a = new BaseSdkLogApi("Sender", false);
    }

    private SenderLog() {
    }

    public static void addILogger(ILogger iLogger) {
        a.f٦٨٠٩a.addILogger(iLogger);
    }

    public static void enable(boolean z10) {
        a.f٦٨٠٩a.enable(z10);
    }

    public static ILog getLogger(Object obj) {
        return a.f٦٨٠٩a.getLogger(obj);
    }

    public static void removeILogger(ILogger iLogger) {
        a.f٦٨٠٩a.removeILogger(iLogger);
    }

    public static void setILogger(ILogger iLogger) {
        a.f٦٨٠٩a.setILogger(iLogger);
    }

    public static void setLevel(LogLevel logLevel) {
        a.f٦٨٠٩a.setLevel(logLevel);
    }
}
