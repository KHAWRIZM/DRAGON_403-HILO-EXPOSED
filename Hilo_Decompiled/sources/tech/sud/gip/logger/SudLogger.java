package tech.sud.gip.logger;

import b.a;
import tech.sud.gip.core.ISudLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class SudLogger {
    private static ISudLogger impl = new a();

    private SudLogger() {
    }

    public static void d(String str, String str2) {
        impl.log(3, str, str2);
    }

    public static void e(String str, String str2) {
        impl.log(6, str, str2);
    }

    public static void i(String str, String str2) {
        impl.log(4, str, str2);
    }

    public static void setLogLevel(int i) {
        impl.setLogLevel(i);
    }

    public static void setLogger(ISudLogger iSudLogger) {
        if (iSudLogger != null) {
            impl = iSudLogger;
        }
    }

    public static void v(String str, String str2) {
        impl.log(2, str, str2);
    }

    public static void w(String str, String str2) {
        impl.log(5, str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        impl.log(3, str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        impl.log(6, str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        impl.log(4, str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        impl.log(2, str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        impl.log(5, str, str2, th);
    }
}
