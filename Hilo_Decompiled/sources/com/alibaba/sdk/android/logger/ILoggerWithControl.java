package com.alibaba.sdk.android.logger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface ILoggerWithControl extends ILogger {
    boolean isEnabled();

    boolean isPrint(LogLevel logLevel);
}
