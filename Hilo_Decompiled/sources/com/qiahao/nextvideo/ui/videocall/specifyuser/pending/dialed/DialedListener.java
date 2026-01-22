package com.qiahao.nextvideo.ui.videocall.specifyuser.pending.dialed;

import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/specifyuser/pending/dialed/DialedListener;", "", "onDialedHangup", "", "onDialedStartup", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface DialedListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void onDialedHangup(@NotNull DialedListener dialedListener) {
        }

        public static void onDialedStartup(@NotNull DialedListener dialedListener, @NotNull VideoCallPreloadModel videoCallPreloadModel) {
            Intrinsics.checkNotNullParameter(videoCallPreloadModel, "agoraVideoCallConfig");
        }
    }

    void onDialedHangup();

    void onDialedStartup(@NotNull VideoCallPreloadModel agoraVideoCallConfig);
}
