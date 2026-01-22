package com.taobao.accs.utl;

import com.alibaba.sdk.android.logger.LogLevel;
import com.taobao.accs.utl.ALog;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
/* synthetic */ class b {
    static final /* synthetic */ int[] a;
    static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[ALog.Level.values().length];
        b = iArr;
        try {
            iArr[ALog.Level.D.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[ALog.Level.V.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[ALog.Level.I.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            b[ALog.Level.W.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[ALog.Level.E.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[ALog.Level.L.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr2 = new int[LogLevel.values().length];
        a = iArr2;
        try {
            iArr2[LogLevel.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            a[LogLevel.INFO.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            a[LogLevel.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[LogLevel.ERROR.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
