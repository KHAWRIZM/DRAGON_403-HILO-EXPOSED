package com.qiahao.nextvideo.ui.videocall.matchinguser;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.room.dialog.UserMenuDialog;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/videocall/matchinguser/MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1 implements ReportDialogListener {
    final /* synthetic */ UserMenuDialog $this_apply;
    final /* synthetic */ String $uid;
    final /* synthetic */ MatchVideoActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1(MatchVideoActivity matchVideoActivity, String str, UserMenuDialog userMenuDialog) {
        this.this$0 = matchVideoActivity;
        this.$uid = str;
        this.$this_apply = userMenuDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$1(final String str, MatchVideoActivity matchVideoActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        i0 j = FeedbackService.INSTANCE.getShared().blockUser(str).j(new pd.o() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1$reportDialogCheck$1$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse2) {
                Intrinsics.checkNotNullParameter(apiResponse2, "it");
                V2TIMManager.getConversationManager().deleteConversation(str, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1$reportDialogCheck$1$1.1
                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onError(int code, String desc) {
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMCallback
                    public void onSuccess() {
                        MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                    }
                });
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        RxUtilsKt.observeOnMainThread$default(j, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.r
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1$lambda$0;
                reportDialogCheck$lambda$1$lambda$0 = MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1.reportDialogCheck$lambda$1$lambda$0(str, (Unit) obj);
                return reportDialogCheck$lambda$1$lambda$0;
            }
        }, (Function1) null, (Function0) null, false, 14, (Object) null);
        matchVideoActivity.exitVideo(2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$1$lambda$0(String str, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        FeedbackService.INSTANCE.getShared().getReportEventRelay().accept(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$2(UserMenuDialog userMenuDialog, MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1 matchVideoActivity$reportImageViewPressed$1$1$onClickReport$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, userMenuDialog.getContext(), ResourcesKtxKt.getStringById(matchVideoActivity$reportImageViewPressed$1$1$onClickReport$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        FeedbackService shared = FeedbackService.INSTANCE.getShared();
        VideoCallPreloadModel videoCallPreloadModel = this.this$0.preloadModel;
        if (videoCallPreloadModel == null || (str = videoCallPreloadModel.getToUID()) == null) {
            str = "";
        }
        String str3 = str;
        str2 = this.this$0.reportImageUrl;
        i0<ApiResponse<Object>> reportUser = shared.reportUser(1, str3, reportType, reportStr, str2);
        final String str4 = this.$uid;
        final MatchVideoActivity matchVideoActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.s
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1.reportDialogCheck$lambda$1(str4, matchVideoActivity, (ApiResponse) obj);
                return reportDialogCheck$lambda$1;
            }
        };
        final UserMenuDialog userMenuDialog = this.$this_apply;
        RxUtilsKt.observeOnMainThread$default(reportUser, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.t
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$2;
                reportDialogCheck$lambda$2 = MatchVideoActivity$reportImageViewPressed$1$1$onClickReport$1.reportDialogCheck$lambda$2(UserMenuDialog.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$2;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.matchinguser.u
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null);
    }
}
