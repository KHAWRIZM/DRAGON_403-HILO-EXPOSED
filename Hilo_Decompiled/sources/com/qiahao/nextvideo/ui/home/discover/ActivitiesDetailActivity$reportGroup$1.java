package com.qiahao.nextvideo.ui.home.discover;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.home.discover.viewModel.ActivitiesDetailViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/home/discover/ActivitiesDetailActivity$reportGroup$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesDetailActivity$reportGroup$1 implements ReportDialogListener {
    final /* synthetic */ ActivitiesDetailActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivitiesDetailActivity$reportGroup$1(ActivitiesDetailActivity activitiesDetailActivity) {
        this.this$0 = activitiesDetailActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$0(ActivitiesDetailActivity activitiesDetailActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesDetailActivity.blackOrReport();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$1(ActivitiesDetailActivity activitiesDetailActivity, ActivitiesDetailActivity$reportGroup$1 activitiesDetailActivity$reportGroup$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activitiesDetailActivity, ResourcesKtxKt.getStringById(activitiesDetailActivity$reportGroup$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        ActivitiesDetailViewModel viewModel;
        String str;
        ActivitiesDetailViewModel viewModel2;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        UserService shared = UserService.INSTANCE.getShared();
        viewModel = this.this$0.getViewModel();
        ActivityDetailData activityDetailData = (ActivityDetailData) viewModel.getActivityDetail().getValue();
        if (activityDetailData == null || (str = activityDetailData.getId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> reportActivity = shared.reportActivity(str, reportType, "");
        final ActivitiesDetailActivity activitiesDetailActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.o
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = ActivitiesDetailActivity$reportGroup$1.reportDialogCheck$lambda$0(ActivitiesDetailActivity.this, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final ActivitiesDetailActivity activitiesDetailActivity2 = this.this$0;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(reportActivity, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.p
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = ActivitiesDetailActivity$reportGroup$1.reportDialogCheck$lambda$1(ActivitiesDetailActivity.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.q
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null);
        viewModel2 = this.this$0.getViewModel();
        RxUtilsKt.addTo(observeOnMainThread$default, viewModel2.getMCompositeDisposable());
    }
}
