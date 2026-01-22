package com.tencent.qcloud.tuikit.tuichat.interfaces;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \r2\u00020\u0001:\u0001\rJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/interfaces/IMCheckDataListener;", "", "checkBoolean", "", "type", "", "checkInt", "", "checkString", "sendMessageSuccess", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "Companion", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface IMCheckDataListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @NotNull
    public static final String IM_TYPE_AVATAR_MY = "avatarMy";

    @NotNull
    public static final String IM_TYPE_AVATAR_RECEIVE = "avatarReceive";

    @NotNull
    public static final String IM_TYPE_IS_STRANGE = "isStrange";

    @NotNull
    public static final String IM_TYPE_IS_STRANGE_GROUP = "isStrangeGroup";

    @NotNull
    public static final String IM_TYPE_PROCESS = "process";

    @NotNull
    public static final String IM_TYPE_TEXT_COLOR = "textColor";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/interfaces/IMCheckDataListener$Companion;", "", "<init>", "()V", "IM_TYPE_IS_STRANGE", "", "IM_TYPE_IS_STRANGE_GROUP", "IM_TYPE_TEXT_COLOR", "IM_TYPE_AVATAR_MY", "IM_TYPE_AVATAR_RECEIVE", "IM_TYPE_PROCESS", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        public static final String IM_TYPE_AVATAR_MY = "avatarMy";

        @NotNull
        public static final String IM_TYPE_AVATAR_RECEIVE = "avatarReceive";

        @NotNull
        public static final String IM_TYPE_IS_STRANGE = "isStrange";

        @NotNull
        public static final String IM_TYPE_IS_STRANGE_GROUP = "isStrangeGroup";

        @NotNull
        public static final String IM_TYPE_PROCESS = "process";

        @NotNull
        public static final String IM_TYPE_TEXT_COLOR = "textColor";

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class DefaultImpls {
        public static boolean checkBoolean(@NotNull IMCheckDataListener iMCheckDataListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            return false;
        }

        public static int checkInt(@NotNull IMCheckDataListener iMCheckDataListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            return 0;
        }

        @NotNull
        public static String checkString(@NotNull IMCheckDataListener iMCheckDataListener, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            return "";
        }

        public static void sendMessageSuccess(@NotNull IMCheckDataListener iMCheckDataListener, @Nullable TUIMessageBean tUIMessageBean) {
        }
    }

    boolean checkBoolean(@NotNull String type);

    int checkInt(@NotNull String type);

    @NotNull
    String checkString(@NotNull String type);

    void sendMessageSuccess(@Nullable TUIMessageBean msg);
}
