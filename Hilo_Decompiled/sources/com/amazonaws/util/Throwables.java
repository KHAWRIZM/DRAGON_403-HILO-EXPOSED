package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum Throwables {
    ;

    private static final int MAX_RETRY = 1000;

    public static Throwable getRootCause(Throwable th) {
        if (th == null) {
            return th;
        }
        int i10 = 0;
        Throwable th2 = th;
        while (i10 < 1000) {
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            i10++;
            th2 = cause;
        }
        LogFactory.getLog(Throwables.class).debug("Possible circular reference detected on " + th.getClass() + ": [" + th + "]");
        return th;
    }
}
