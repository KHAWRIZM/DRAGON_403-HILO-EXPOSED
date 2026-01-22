package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.answered;

import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/answered/AnsweredListener;", "", "onHangup", "", "onAnswer", "onStartup", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface AnsweredListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void onAnswer(@NotNull AnsweredListener answeredListener) {
        }

        public static void onHangup(@NotNull AnsweredListener answeredListener) {
        }

        public static void onStartup(@NotNull AnsweredListener answeredListener, @NotNull VideoCallPreloadModel videoCallPreloadModel) {
            Intrinsics.checkNotNullParameter(videoCallPreloadModel, "agoraVideoCallConfig");
        }
    }

    void onAnswer();

    void onHangup();

    void onStartup(@NotNull VideoCallPreloadModel agoraVideoCallConfig);
}
