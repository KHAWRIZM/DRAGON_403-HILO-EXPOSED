package com.oudi.utils.log;

import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0005J \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\bJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\bJ*\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0006\u001a\u00020\bJ \u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\bJ \u0010\u0019\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\bJ \u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\bJ \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\bJ.\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0006\u001a\u00020\bJ \u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J \u0010 \u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006!"}, d2 = {"Lcom/oudi/utils/log/LogUtil;", "", "<init>", "()V", "consolePrinter", "Lcom/oudi/utils/log/LogPrinter;", "filePrinter", "consolePrinterEnabled", "", "getConsolePrinterEnabled", "()Z", "setConsolePrinterEnabled", "(Z)V", "filePrinterEnabled", "getFilePrinterEnabled", "setFilePrinterEnabled", "setFilePrinter", "", "e", ViewHierarchyConstants.TAG_KEY, "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "throwable", "", "d", "i", "v", "w", "log", FirebaseAnalytics.Param.LEVEL, "", "logConsole", "logFile", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LogUtil {
    public static final LogUtil INSTANCE = new LogUtil();
    private static LogPrinter consolePrinter = new AndroidLogPrinter();
    private static boolean consolePrinterEnabled = true;
    private static LogPrinter filePrinter;
    private static boolean filePrinterEnabled;

    private LogUtil() {
    }

    public static /* synthetic */ void d$default(LogUtil logUtil, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        logUtil.d(str, str2, z10);
    }

    public static /* synthetic */ void e$default(LogUtil logUtil, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        logUtil.e(str, str2, z10);
    }

    public static /* synthetic */ void i$default(LogUtil logUtil, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        logUtil.i(str, str2, z10);
    }

    public static /* synthetic */ void log$default(LogUtil logUtil, int i10, String str, String str2, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 4;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        logUtil.log(i10, str, str2, z10);
    }

    public static /* synthetic */ void logConsole$default(LogUtil logUtil, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 4;
        }
        logUtil.logConsole(i10, str, str2);
    }

    public static /* synthetic */ void logFile$default(LogUtil logUtil, int i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 4;
        }
        logUtil.logFile(i10, str, str2);
    }

    public static /* synthetic */ void v$default(LogUtil logUtil, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        logUtil.v(str, str2, z10);
    }

    public static /* synthetic */ void w$default(LogUtil logUtil, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        logUtil.w(str, str2, z10);
    }

    public final void d(String tag, String message, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(3, tag, message, filePrinter2);
    }

    public final void e(String tag, String message, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(6, tag, message, filePrinter2);
    }

    public final boolean getConsolePrinterEnabled() {
        return consolePrinterEnabled;
    }

    public final boolean getFilePrinterEnabled() {
        return filePrinterEnabled;
    }

    public final void i(String tag, String message, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(4, tag, message, filePrinter2);
    }

    public final void log(int level, String tag, String message, boolean filePrinter2) {
    }

    public final void logConsole(int level, String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!consolePrinterEnabled || tag.length() == 0 || message.length() == 0) {
            return;
        }
        if (message.length() <= 3072) {
            LogPrinter logPrinter = consolePrinter;
            if (logPrinter != null) {
                logPrinter.println(level, tag, message);
                return;
            }
            return;
        }
        String str = message;
        while (str.length() > 3072) {
            String substring = str.substring(0, 3072);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            str = StringsKt.replace$default(str, substring, "", false, 4, (Object) null);
            LogPrinter logPrinter2 = consolePrinter;
            if (logPrinter2 != null) {
                logPrinter2.println(level, tag, substring);
            }
        }
        LogPrinter logPrinter3 = consolePrinter;
        if (logPrinter3 != null) {
            logPrinter3.println(level, tag, str);
        }
    }

    public final void logFile(int level, String tag, String message) {
        LogPrinter logPrinter;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (filePrinterEnabled && (logPrinter = filePrinter) != null) {
            logPrinter.println(level, tag, message);
        }
    }

    public final void setConsolePrinterEnabled(boolean z10) {
        consolePrinterEnabled = z10;
    }

    public final void setFilePrinter(LogPrinter filePrinter2) {
        Intrinsics.checkNotNullParameter(filePrinter2, "filePrinter");
        filePrinter = filePrinter2;
    }

    public final void setFilePrinterEnabled(boolean z10) {
        filePrinterEnabled = z10;
    }

    public final void v(String tag, String message, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(2, tag, message, filePrinter2);
    }

    public final void w(String tag, String message, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        log(5, tag, message, filePrinter2);
    }

    public static /* synthetic */ void e$default(LogUtil logUtil, String str, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        logUtil.e(str, th, z10);
    }

    public final void e(String tag, Throwable throwable, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String stackTraceString = Log.getStackTraceString(throwable);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(...)");
        if (stackTraceString.length() == 0) {
            return;
        }
        e(tag, stackTraceString, filePrinter2);
    }

    public static /* synthetic */ void e$default(LogUtil logUtil, String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        logUtil.e(str, str2, th, z10);
    }

    public final void e(String tag, String message, Throwable throwable, boolean filePrinter2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String stackTraceString = Log.getStackTraceString(throwable);
        Intrinsics.checkNotNullExpressionValue(stackTraceString, "getStackTraceString(...)");
        if (message == null && stackTraceString.length() == 0) {
            return;
        }
        e(tag, message + "\t\t" + stackTraceString, filePrinter2);
    }
}
