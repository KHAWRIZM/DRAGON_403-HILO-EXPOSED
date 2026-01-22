package com.alibaba.sdk.android.tool;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ExceptionUtils {
    public static String getStackMsg(Throwable th) {
        StringBuilder sb = new StringBuilder();
        try {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace.length > 0) {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Exception unused) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
