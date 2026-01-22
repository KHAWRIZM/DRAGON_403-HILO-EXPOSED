package com.alibaba.sdk.android.push.utils;

import com.alibaba.sdk.android.logger.BaseSdkLogApi;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ThirdPushLogger {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class Holder {
        private static final BaseSdkLogApi instance = new BaseSdkLogApi("ThirdPush", false);

        private Holder() {
        }
    }

    public static void addILogger(ILogger iLogger) {
        Holder.instance.addILogger(iLogger);
    }

    public static void enable(boolean z10) {
        Holder.instance.enable(z10);
    }

    public static ILog getLogger(Object obj) {
        return Holder.instance.getLogger(obj);
    }

    public static void removeILogger(ILogger iLogger) {
        Holder.instance.removeILogger(iLogger);
    }

    public static void setILogger(ILogger iLogger) {
        Holder.instance.setILogger(iLogger);
    }

    public static void setLevel(LogLevel logLevel) {
        Holder.instance.setLevel(logLevel);
    }
}
