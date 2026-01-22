package com.alibaba.sdk.android.tool;

import java.util.Locale;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ThreadUtils {
    public static String dumpThread(Thread thread) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("Thread Name: '%s'\n", thread.getName()));
            sb.append(String.format(Locale.ENGLISH, "\"%s\" prio=%d tid=%d %s\n", thread.getName(), Integer.valueOf(thread.getPriority()), Long.valueOf(thread.getId()), thread.getState()));
            for (StackTraceElement stackTraceElement : thread.getStackTrace()) {
                sb.append(String.format("\tat %s\n", stackTraceElement.toString()));
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return sb.toString();
    }

    public static void threadWaitForSec(double d10) {
        try {
            Thread.sleep(((long) d10) * 1000);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
