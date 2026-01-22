package com.oudi.widget.input;

import com.oudi.utils.ICleared;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/oudi/widget/input/InputContext;", "Lcom/oudi/utils/log/ILog;", "Lcom/oudi/utils/ICleared;", "onReset", "", "switchPanel", "type", "", "getInputBar", "Lcom/oudi/widget/input/InputBar;", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface InputContext extends ILog, ICleared {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        @NotNull
        public static String getLogTag(@NotNull InputContext inputContext) {
            return ILog.DefaultImpls.getLogTag(inputContext);
        }

        public static void logD(@NotNull InputContext inputContext, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logD(inputContext, message, tag, z10);
        }

        public static void logE(@NotNull InputContext inputContext, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logE(inputContext, message, tag, z10);
        }

        public static void logI(@NotNull InputContext inputContext, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logI(inputContext, message, tag, z10);
        }

        public static void logV(@NotNull InputContext inputContext, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logV(inputContext, message, tag, z10);
        }

        public static void logW(@NotNull InputContext inputContext, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logW(inputContext, message, tag, z10);
        }

        public static void onCleared(@NotNull InputContext inputContext) {
            ICleared.DefaultImpls.onCleared(inputContext);
        }

        public static void onReset(@NotNull InputContext inputContext) {
        }

        public static void logE(@NotNull InputContext inputContext, @NotNull String message, @NotNull Throwable throwable, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logE(inputContext, message, throwable, tag, z10);
        }

        public static void logE(@NotNull InputContext inputContext, @NotNull Throwable throwable, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logE(inputContext, throwable, tag, z10);
        }
    }

    @NotNull
    InputBar getInputBar();

    void onReset();

    void switchPanel(@NotNull String type);
}
