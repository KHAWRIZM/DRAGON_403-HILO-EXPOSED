package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class LogFactory {
    private static final String APACHE_COMMONS_LOGGING_LOGFACTORY = "org.apache.commons.logging.LogFactory";
    private static final String TAG = "LogFactory";
    private static Level globalLogLevel;
    private static Map<String, Log> logMap = new HashMap();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Integer.MAX_VALUE);

        private int value;

        Level(int i10) {
            this.value = i10;
        }

        public int getValue() {
            return this.value;
        }
    }

    private static boolean checkApacheCommonsLoggingExists() {
        try {
            Class.forName(APACHE_COMMONS_LOGGING_LOGFACTORY);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        } catch (Exception e10) {
            android.util.Log.e(TAG, e10.getMessage());
            return false;
        }
    }

    public static Level getLevel() {
        return globalLogLevel;
    }

    public static synchronized Log getLog(Class cls) {
        Log log;
        synchronized (LogFactory.class) {
            log = getLog(getTruncatedLogTag(cls.getSimpleName()));
        }
        return log;
    }

    private static String getTruncatedLogTag(String str) {
        if (str.length() > 23) {
            if (checkApacheCommonsLoggingExists()) {
                new ApacheCommonsLogging(TAG).warn("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
            } else {
                android.util.Log.w(TAG, "Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
            }
            return str.substring(0, 23);
        }
        return str;
    }

    public static void setLevel(Level level) {
        globalLogLevel = level;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0035 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0011, B:12:0x0017, B:15:0x001c, B:19:0x002b, B:9:0x0035), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized Log getLog(String str) {
        Log log;
        Log log2;
        Exception e10;
        synchronized (LogFactory.class) {
            String truncatedLogTag = getTruncatedLogTag(str);
            log = logMap.get(truncatedLogTag);
            if (log == null) {
                if (checkApacheCommonsLoggingExists()) {
                    try {
                        log2 = new ApacheCommonsLogging(truncatedLogTag);
                    } catch (Exception e11) {
                        log2 = log;
                        e10 = e11;
                    }
                    try {
                        logMap.put(truncatedLogTag, log2);
                    } catch (Exception e12) {
                        e10 = e12;
                        android.util.Log.w(TAG, "Could not create log from org.apache.commons.logging.LogFactory", e10);
                        log = log2;
                        if (log == null) {
                        }
                        return log;
                    }
                    log = log2;
                }
                if (log == null) {
                    log = new AndroidLog(truncatedLogTag);
                    logMap.put(truncatedLogTag, log);
                }
            }
        }
        return log;
    }
}
