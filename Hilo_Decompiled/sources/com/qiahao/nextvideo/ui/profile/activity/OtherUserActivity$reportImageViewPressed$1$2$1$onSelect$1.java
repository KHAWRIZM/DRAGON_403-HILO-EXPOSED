package com.qiahao.nextvideo.ui.profile.activity;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1 implements ReportDialogListener {
    final /* synthetic */ BlockOrReportDialog $this_apply;
    final /* synthetic */ OtherUserActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1(OtherUserActivity otherUserActivity, BlockOrReportDialog blockOrReportDialog) {
        this.this$0 = otherUserActivity;
        this.$this_apply = blockOrReportDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$0(OtherUserActivity otherUserActivity, OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1 otherUserActivity$reportImageViewPressed$1$2$1$onSelect$1, final BlockOrReportDialog blockOrReportDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        new TipDialog(otherUserActivity).setTipContent(ResourcesKtxKt.getStringById(otherUserActivity$reportImageViewPressed$1$2$1$onSelect$1, 2131954490)).setConfirmContent(ResourcesKtxKt.getStringById(otherUserActivity$reportImageViewPressed$1$2$1$onSelect$1, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1$reportDialogCheck$1$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, BlockOrReportDialog.this.getContext(), ResourcesKtxKt.getStringById(this, 2131954177), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$1(BlockOrReportDialog blockOrReportDialog, OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1 otherUserActivity$reportImageViewPressed$1$2$1$onSelect$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, blockOrReportDialog.getContext(), ResourcesKtxKt.getStringById(otherUserActivity$reportImageViewPressed$1$2$1$onSelect$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        String str;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        FeedbackService shared = FeedbackService.INSTANCE.getShared();
        User uiModel = this.this$0.getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0 reportUser$default = FeedbackService.reportUser$default(shared, 3, str, reportType, reportStr, null, 16, null);
        final OtherUserActivity otherUserActivity = this.this$0;
        final BlockOrReportDialog blockOrReportDialog = this.$this_apply;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.i0
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1.reportDialogCheck$lambda$0(OtherUserActivity.this, this, blockOrReportDialog, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final BlockOrReportDialog blockOrReportDialog2 = this.$this_apply;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(reportUser$default, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.j0
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$1.reportDialogCheck$lambda$1(BlockOrReportDialog.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.k0
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null), this.this$0.getCompositeDisposable());
    }
}
