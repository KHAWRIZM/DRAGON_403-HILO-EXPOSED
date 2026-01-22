package com.oudi.widget.input;

import android.view.View;
import com.oudi.utils.ICleared;
import com.oudi.utils.log.ILog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u0000 \u00102\u00020\u00012\u00020\u0002:\u0001\u0010J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0011"}, d2 = {"Lcom/oudi/widget/input/InputPanel;", "Lcom/oudi/utils/log/ILog;", "Lcom/oudi/utils/ICleared;", "getContentView", "Landroid/view/View;", "getPanelType", "", "onAttachInputLayout", "", "inputLayout", "Lcom/oudi/widget/input/InputContext;", "onVisibleChanged", "isVisibleToUser", "", "getPanelHeight", "", "Companion", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public interface InputPanel extends ILog, ICleared {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String PANEL_EMOJI = "emoji";

    @NotNull
    public static final String PANEL_KEY_BOARD = "key_board";

    @NotNull
    public static final String PANEL_MENU = "menu";

    @NotNull
    public static final String PANEL_NONE = "none";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/oudi/widget/input/InputPanel$Companion;", "", "<init>", "()V", "PANEL_KEY_BOARD", "", "PANEL_NONE", "PANEL_MENU", "PANEL_EMOJI", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String PANEL_EMOJI = "emoji";

        @NotNull
        public static final String PANEL_KEY_BOARD = "key_board";

        @NotNull
        public static final String PANEL_MENU = "menu";

        @NotNull
        public static final String PANEL_NONE = "none";

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class DefaultImpls {
        @NotNull
        public static String getLogTag(@NotNull InputPanel inputPanel) {
            return ILog.DefaultImpls.getLogTag(inputPanel);
        }

        public static void logD(@NotNull InputPanel inputPanel, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logD(inputPanel, message, tag, z10);
        }

        public static void logE(@NotNull InputPanel inputPanel, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logE(inputPanel, message, tag, z10);
        }

        public static void logI(@NotNull InputPanel inputPanel, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logI(inputPanel, message, tag, z10);
        }

        public static void logV(@NotNull InputPanel inputPanel, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logV(inputPanel, message, tag, z10);
        }

        public static void logW(@NotNull InputPanel inputPanel, @NotNull String message, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logW(inputPanel, message, tag, z10);
        }

        public static void onCleared(@NotNull InputPanel inputPanel) {
            ICleared.DefaultImpls.onCleared(inputPanel);
        }

        public static void logE(@NotNull InputPanel inputPanel, @NotNull String message, @NotNull Throwable throwable, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logE(inputPanel, message, throwable, tag, z10);
        }

        public static void logE(@NotNull InputPanel inputPanel, @NotNull Throwable throwable, @NotNull String tag, boolean z10) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            Intrinsics.checkNotNullParameter(tag, "tag");
            ILog.DefaultImpls.logE(inputPanel, throwable, tag, z10);
        }
    }

    @NotNull
    View getContentView();

    int getPanelHeight();

    @NotNull
    String getPanelType();

    void onAttachInputLayout(@NotNull InputContext inputLayout);

    void onVisibleChanged(boolean isVisibleToUser);
}
