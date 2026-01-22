package com.taobao.accs.utl;

import com.alibaba.sdk.android.logger.BaseSdkLogApi;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class AccsLogger {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    private static class a {
        private static final BaseSdkLogApi a = new BaseSdkLogApi("EMASNAccs", false);

        private a() {
        }
    }

    public static void addILogger(ILogger iLogger) {
        a.a.addILogger(iLogger);
    }

    public static void enable(boolean z) {
        a.a.enable(z);
    }

    public static ILog getLogger(Object obj) {
        return a.a.getLogger(obj);
    }

    public static void removeILogger(ILogger iLogger) {
        a.a.removeILogger(iLogger);
    }

    public static void setILogger(ILogger iLogger) {
        a.a.setILogger(iLogger);
    }

    public static void setLevel(LogLevel logLevel) {
        a.a.setLevel(logLevel);
    }
}
