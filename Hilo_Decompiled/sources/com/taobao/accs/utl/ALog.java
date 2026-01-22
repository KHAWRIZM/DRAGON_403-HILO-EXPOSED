package com.taobao.accs.utl;

import anet.channel.util.ALog;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.logger.LogLevel;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ALog {
    private static ILog log = AccsLogger.getLogger("DefaultLog");

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        if (str != null) {
            sb2.append(" ");
            sb2.append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb2.append(" ");
                sb2.append(formatKv(objArr[i], objArr[i2]));
                i += 2;
            }
            if (i == objArr.length - 1) {
                sb2.append(" ");
                sb2.append(objArr[i]);
            }
        }
        return sb2.toString();
    }

    public static void d(String str, String str2, Object... objArr) {
        log.d("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    public static void e(String str, String str2, Object... objArr) {
        log.e("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb2 = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb2.append(obj);
        sb2.append(":");
        if (obj2 == null) {
            obj2 = "";
        }
        sb2.append(obj2);
        return sb2.toString();
    }

    public static void i(String str, String str2, Object... objArr) {
        log.i("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    @Deprecated
    public static void initALog(String str, int i) {
    }

    @Deprecated
    public static boolean isPrintLog() {
        return true;
    }

    @Deprecated
    private static boolean isTLogExist() {
        return false;
    }

    @Deprecated
    public static void setEnableTLog(boolean z) {
    }

    @Deprecated
    public static void setLogLevel(Level level) {
        LogLevel logLevel = LogLevel.ERROR;
        switch (b.b[level.ordinal()]) {
            case 1:
            case 2:
                logLevel = LogLevel.DEBUG;
                break;
            case 3:
                logLevel = LogLevel.INFO;
                break;
            case 4:
                logLevel = LogLevel.WARN;
                break;
        }
        AccsLogger.setLevel(logLevel);
    }

    @Deprecated
    public static void setLogger(ALog.ILog iLog) {
        if (iLog != null) {
            AccsLogger.addILogger(new a(iLog));
        }
    }

    public static void setPrintLog(boolean z) {
        AccsLogger.enable(z);
    }

    @Deprecated
    public static void setUseTlog(boolean z) {
    }

    public static void v(String str, String str2, Object... objArr) {
        log.d("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    public static void w(String str, String str2, Object... objArr) {
        log.w("[" + str + "]" + buildLogMsg(str2, objArr));
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        log.e("[" + str + "]" + buildLogMsg(str2, objArr), th);
    }

    public static boolean isPrintLog(Level level) {
        return true;
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        log.w("[" + str + "]" + buildLogMsg(str2, objArr), th);
    }
}
