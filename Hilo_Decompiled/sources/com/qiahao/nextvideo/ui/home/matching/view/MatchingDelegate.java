package com.qiahao.nextvideo.ui.home.matching.view;

import com.qiahao.nextvideo.ui.paired.MatchingActionPendingUIModel;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingDelegate;", "", "matchingStartup", "", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "matchingNext", "uiModel", "Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "task", "Lkotlin/Function0;", "matchingAccept", "matchingFloatView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface MatchingDelegate {
    void matchingAccept(@NotNull MatchingActionPendingUIModel uiModel);

    void matchingFloatView(@NotNull MatchingActionPendingUIModel uiModel);

    void matchingNext(@NotNull MatchingActionPendingUIModel uiModel, @NotNull Function0<Unit> task);

    void matchingStartup(@NotNull VideoCallPreloadModel agoraVideoCallConfig);
}
