package com.oudi.utils.log;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J$\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J$\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0011"}, d2 = {"Lcom/oudi/utils/log/ILog;", "", "getLogTag", "", "logI", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, ViewHierarchyConstants.TAG_KEY, "filePrinter", "", "logV", "logW", "logD", "logE", "throwable", "", "Companion", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface ILog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/oudi/utils/log/ILog$Companion;", "", "<init>", "()V", "onCleared", "", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final void onCleared() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        public static String getLogTag(ILog iLog) {
            String simpleName = iLog.getClass().getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
            return simpleName;
        }

        public static void logD(ILog iLog, String message, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.d(tag, message, z10);
        }

        public static /* synthetic */ void logD$default(ILog iLog, String str, String str2, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str2 = iLog.getLogTag();
                }
                if ((i10 & 4) != 0) {
                    z10 = false;
                }
                iLog.logD(str, str2, z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logD");
        }

        public static void logE(ILog iLog, String message, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.e(tag, message, z10);
        }

        public static /* synthetic */ void logE$default(ILog iLog, String str, String str2, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logE");
            }
            if ((i10 & 2) != 0) {
                str2 = iLog.getLogTag();
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            iLog.logE(str, str2, z10);
        }

        public static void logI(ILog iLog, String message, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.i(tag, message, z10);
        }

        public static /* synthetic */ void logI$default(ILog iLog, String str, String str2, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str2 = iLog.getLogTag();
                }
                if ((i10 & 4) != 0) {
                    z10 = false;
                }
                iLog.logI(str, str2, z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logI");
        }

        public static void logV(ILog iLog, String message, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.v(tag, message, z10);
        }

        public static /* synthetic */ void logV$default(ILog iLog, String str, String str2, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str2 = iLog.getLogTag();
                }
                if ((i10 & 4) != 0) {
                    z10 = false;
                }
                iLog.logV(str, str2, z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logV");
        }

        public static void logW(ILog iLog, String message, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.w(tag, message, z10);
        }

        public static /* synthetic */ void logW$default(ILog iLog, String str, String str2, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 2) != 0) {
                    str2 = iLog.getLogTag();
                }
                if ((i10 & 4) != 0) {
                    z10 = false;
                }
                iLog.logW(str, str2, z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logW");
        }

        public static void logE(ILog iLog, Throwable throwable, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.e(tag, throwable, z10);
        }

        public static /* synthetic */ void logE$default(ILog iLog, Throwable th, String str, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logE");
            }
            if ((i10 & 2) != 0) {
                str = iLog.getLogTag();
            }
            if ((i10 & 4) != 0) {
                z10 = false;
            }
            iLog.logE(th, str, z10);
        }

        public static void logE(ILog iLog, String message, Throwable throwable, String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(tag, "tag");
            LogUtil.INSTANCE.e(tag, message, throwable, z10);
        }

        public static /* synthetic */ void logE$default(ILog iLog, String str, Throwable th, String str2, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logE");
            }
            if ((i10 & 4) != 0) {
                str2 = iLog.getLogTag();
            }
            if ((i10 & 8) != 0) {
                z10 = false;
            }
            iLog.logE(str, th, str2, z10);
        }
    }

    String getLogTag();

    void logD(String message, String tag, boolean filePrinter);

    void logE(String message, String tag, boolean filePrinter);

    void logE(String message, Throwable throwable, String tag, boolean filePrinter);

    void logE(Throwable throwable, String tag, boolean filePrinter);

    void logI(String message, String tag, boolean filePrinter);

    void logV(String message, String tag, boolean filePrinter);

    void logW(String message, String tag, boolean filePrinter);
}
