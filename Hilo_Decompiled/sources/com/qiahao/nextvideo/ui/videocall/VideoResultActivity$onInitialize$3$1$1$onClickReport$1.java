package com.qiahao.nextvideo.ui.videocall;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.VideoResultData;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.room.dialog.UserMenuDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/videocall/VideoResultActivity$onInitialize$3$1$1$onClickReport$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoResultActivity$onInitialize$3$1$1$onClickReport$1 implements ReportDialogListener {
    final /* synthetic */ UserMenuDialog $this_apply;
    final /* synthetic */ VideoResultActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoResultActivity$onInitialize$3$1$1$onClickReport$1(VideoResultActivity videoResultActivity, UserMenuDialog userMenuDialog) {
        this.this$0 = videoResultActivity;
        this.$this_apply = userMenuDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$0(VideoResultActivity videoResultActivity, VideoResultActivity$onInitialize$3$1$1$onClickReport$1 videoResultActivity$onInitialize$3$1$1$onClickReport$1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        new TipDialog(videoResultActivity).setTipContent(ResourcesKtxKt.getStringById(videoResultActivity$onInitialize$3$1$1$onClickReport$1, 2131954490)).setConfirmContent(ResourcesKtxKt.getStringById(videoResultActivity$onInitialize$3$1$1$onClickReport$1, 2131952331)).hideCancel(true).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$1(VideoResultActivity videoResultActivity, VideoResultActivity$onInitialize$3$1$1$onClickReport$1 videoResultActivity$onInitialize$3$1$1$onClickReport$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, videoResultActivity, ResourcesKtxKt.getStringById(videoResultActivity$onInitialize$3$1$1$onClickReport$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        String str;
        User otherUser;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        FeedbackService shared = FeedbackService.INSTANCE.getShared();
        VideoResultData resultData = this.this$0.getResultData();
        if (resultData == null || (otherUser = resultData.getOtherUser()) == null || (str = otherUser.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0 reportUser$default = FeedbackService.reportUser$default(shared, 1, str, reportType, reportStr, null, 16, null);
        final VideoResultActivity videoResultActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.i0
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = VideoResultActivity$onInitialize$3$1$1$onClickReport$1.reportDialogCheck$lambda$0(VideoResultActivity.this, this, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final VideoResultActivity videoResultActivity2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(reportUser$default, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.j0
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = VideoResultActivity$onInitialize$3$1$1$onClickReport$1.reportDialogCheck$lambda$1(VideoResultActivity.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.k0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null), this.$this_apply.getCompositeDisposable());
    }
}
