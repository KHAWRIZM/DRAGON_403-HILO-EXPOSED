package h3;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import io.agora.rtc.Constants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f١٤٥٠٥a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f١٤٥٠٦b;

    public static void a(String str) {
        b.a(f(str));
    }

    public static void b() {
        b.b();
    }

    private static void c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT >= 29) {
            return c.a();
        }
        return e();
    }

    private static boolean e() {
        try {
            if (f١٤٥٠٦b == null) {
                f١٤٥٠٥a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f١٤٥٠٦b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f١٤٥٠٦b.invoke(null, Long.valueOf(f١٤٥٠٥a))).booleanValue();
        } catch (Exception e10) {
            c("isTagEnabled", e10);
            return false;
        }
    }

    private static String f(String str) {
        if (str.length() <= 127) {
            return str;
        }
        return str.substring(0, Constants.ERR_WATERMARKR_INFO);
    }
}
