package io.agora.rtc.internal;

import android.annotation.SuppressLint;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class ATrace {
    public static final boolean ENABLE_TRACE = false;
    private static final String TAG = "ATrace";
    private static final long TRACE_TAG_APP = 4096;
    public static final boolean VERBOSE_LOG = false;
    private static Method traceCounterMethod;
    private static boolean traceCounterMethodFailed;

    public static void beginSection(String str) {
    }

    public static void endSection() {
    }

    @SuppressLint({"PrivateApi"})
    public static void traceCounter(String str, int i10) {
    }
}
