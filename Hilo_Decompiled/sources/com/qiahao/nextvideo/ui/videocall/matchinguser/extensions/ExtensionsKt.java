package com.qiahao.nextvideo.ui.videocall.matchinguser.extensions;

import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import io.agora.rtc.RtcEngine;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0007*\u0016\u0010\u0002\"\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\b"}, d2 = {"setupConfigureRtcEngine", "", "DuetFreeAddTimeValidator", "Ljava/util/TreeSet;", "", "isDuetAgreed", "", "Lcom/qiahao/nextvideo/ui/videocall/matchinguser/extensions/DuetFreeAddTimeValidator;", "app_googleRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ExtensionsKt {
    public static final boolean isDuetAgreed(@NotNull TreeSet<Integer> treeSet) {
        Intrinsics.checkNotNullParameter(treeSet, "<this>");
        if (treeSet.size() == 2) {
            return true;
        }
        return false;
    }

    public static final void setupConfigureRtcEngine() {
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        agoraRtcService.enableLocalVideo(true);
        RtcEngine rtcEngine = agoraRtcService.getRtcEngine();
        if (rtcEngine != null) {
            rtcEngine.muteAllRemoteAudioStreams(false);
        }
        RtcEngine rtcEngine2 = agoraRtcService.getRtcEngine();
        if (rtcEngine2 != null) {
            rtcEngine2.muteLocalAudioStream(false);
        }
        RtcEngine rtcEngine3 = agoraRtcService.getRtcEngine();
        if (rtcEngine3 != null) {
            rtcEngine3.enableFaceDetection(true);
        }
    }
}
