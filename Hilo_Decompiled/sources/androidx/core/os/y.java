package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    private static long f٢٨٨٣a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f٢٨٨٤b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f٢٨٨٥c;

    /* renamed from: d, reason: collision with root package name */
    private static Method f٢٨٨٦d;

    /* renamed from: e, reason: collision with root package name */
    private static Method f٢٨٨٧e;

    static {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f٢٨٨٣a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                Class cls = Long.TYPE;
                f٢٨٨٤b = Trace.class.getMethod("isTagEnabled", cls);
                Class cls2 = Integer.TYPE;
                f٢٨٨٥c = Trace.class.getMethod("asyncTraceBegin", cls, String.class, cls2);
                f٢٨٨٦d = Trace.class.getMethod("asyncTraceEnd", cls, String.class, cls2);
                f٢٨٨٧e = Trace.class.getMethod("traceCounter", cls, String.class, cls2);
            } catch (Exception e10) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e10);
            }
        }
    }

    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
