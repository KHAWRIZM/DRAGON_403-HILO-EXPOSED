package o;

import android.util.Log;
import g1.f;
import g1.h;
import java.io.PrintWriter;
import java.io.StringWriter;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static f f١٦٤٠٨a;

    public static String a(Exception exc) {
        StringBuffer stringBuffer = new StringBuffer();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        stringBuffer.append(stringWriter.toString());
        stringBuffer.append("\n" + Log.getStackTraceString(exc));
        return stringBuffer.toString();
    }

    public static void b(String str) {
        if (f١٦٤٠٨a == null) {
            return;
        }
        LogUtils.file(5, "SudNative", str);
        if (h.f١٤٣٨٤m) {
            SudLogger.w("SudNative", str);
        }
    }

    public static void c(String str, String str2) {
        if (f١٦٤٠٨a == null) {
            return;
        }
        LogUtils.file(6, str, str2);
        if (h.f١٤٣٨٤m) {
            SudLogger.e(str, str2);
        } else {
            SudLogger.e(str, str2);
        }
    }
}
