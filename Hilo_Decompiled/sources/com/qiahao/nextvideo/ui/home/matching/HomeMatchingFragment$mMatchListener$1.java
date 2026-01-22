package com.qiahao.nextvideo.ui.home.matching;

import android.content.Context;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.ui.home.matching.view.MatchingDelegate;
import com.qiahao.nextvideo.ui.paired.DoneType;
import com.qiahao.nextvideo.ui.paired.MatchingActionPendingUIModel;
import com.qiahao.nextvideo.ui.reusable.views.MatchingFloatView;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\r"}, d2 = {"com/qiahao/nextvideo/ui/home/matching/HomeMatchingFragment$mMatchListener$1", "Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingDelegate;", "matchingStartup", "", "agoraVideoCallConfig", "Lcom/qiahao/nextvideo/ui/videocall/VideoCallPreloadModel;", "matchingNext", "uiModel", "Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "task", "Lkotlin/Function0;", "matchingAccept", "matchingFloatView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeMatchingFragment$mMatchListener$1 implements MatchingDelegate {
    final /* synthetic */ HomeMatchingFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeMatchingFragment$mMatchListener$1(HomeMatchingFragment homeMatchingFragment) {
        this.this$0 = homeMatchingFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchingNext$lambda$0(ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        n5.e.c("matchingActionPendingViewWrapperDelegateDidNext 调用拒绝接口成功");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchingNext$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        n5.e.c("matchingActionPendingViewWrapperDelegateDidNext 调用拒绝接口失败");
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.home.matching.view.MatchingDelegate
    public void matchingAccept(MatchingActionPendingUIModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        String avatar = uiModel.getToUser().getAvatar();
        if (avatar == null) {
            avatar = "";
        }
        matchingProvide.refreshMatchingFloatView(avatar, MatchingFloatView.Mode.WAITING, uiModel.getMatchUniqueID());
    }

    @Override // com.qiahao.nextvideo.ui.home.matching.view.MatchingDelegate
    public void matchingFloatView(MatchingActionPendingUIModel uiModel) {
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        String avatar = uiModel.getToUser().getAvatar();
        if (avatar == null) {
            avatar = "";
        }
        matchingProvide.refreshMatchingFloatView(avatar, MatchingFloatView.Mode.CONNECTING, uiModel.getMatchUniqueID());
    }

    @Override // com.qiahao.nextvideo.ui.home.matching.view.MatchingDelegate
    public void matchingNext(MatchingActionPendingUIModel uiModel, Function0<Unit> task) {
        String str;
        int i;
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        Intrinsics.checkNotNullParameter(task, "task");
        this.this$0.clearMatchingView();
        task.invoke();
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        matchingProvide.sendEventAndEnterMatchPool();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getAvatar()) == null) {
            str = "";
        }
        MatchingProvide.refreshMatchingFloatView$default(matchingProvide, str, MatchingFloatView.Mode.NORMAL, null, 4, null);
        if (uiModel.isOnlineUser()) {
            if (uiModel.getDoneType() == DoneType.PENDING_COUNTDOWN_DONE) {
                i = 1;
            } else {
                i = 2;
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(matchingProvide.rejectInvite(uiModel.getMatchUniqueID(), uiModel.getToUser().getExternalId(), uiModel.getFrom(), i), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.w
                public final Object invoke(Object obj) {
                    Unit matchingNext$lambda$0;
                    matchingNext$lambda$0 = HomeMatchingFragment$mMatchListener$1.matchingNext$lambda$0((ApiResponse) obj);
                    return matchingNext$lambda$0;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.x
                public final Object invoke(Object obj) {
                    Unit matchingNext$lambda$1;
                    matchingNext$lambda$1 = HomeMatchingFragment$mMatchListener$1.matchingNext$lambda$1((Throwable) obj);
                    return matchingNext$lambda$1;
                }
            }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
        }
        this.this$0.clearMatchingView();
        this.this$0.showFoundGuysAnimation();
    }

    @Override // com.qiahao.nextvideo.ui.home.matching.view.MatchingDelegate
    public void matchingStartup(VideoCallPreloadModel agoraVideoCallConfig) {
        String str;
        Intrinsics.checkNotNullParameter(agoraVideoCallConfig, "agoraVideoCallConfig");
        this.this$0.clearMatchingView();
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getAvatar()) == null) {
            str = "";
        }
        MatchingProvide.refreshMatchingFloatView$default(matchingProvide, str, MatchingFloatView.Mode.NORMAL, null, 4, null);
        MatchVideoActivity.Companion companion = MatchVideoActivity.INSTANCE;
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        companion.start(requireContext, agoraVideoCallConfig);
    }
}
