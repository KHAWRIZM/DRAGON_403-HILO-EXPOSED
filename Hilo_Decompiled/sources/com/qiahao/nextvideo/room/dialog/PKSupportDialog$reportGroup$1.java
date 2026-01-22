package com.qiahao.nextvideo.room.dialog;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.service.GroupService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/room/dialog/PKSupportDialog$reportGroup$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKSupportDialog$reportGroup$1 implements ReportDialogListener {
    final /* synthetic */ PKSupportDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PKSupportDialog$reportGroup$1(PKSupportDialog pKSupportDialog) {
        this.this$0 = pKSupportDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$0(PKSupportDialog pKSupportDialog, PKSupportDialog$reportGroup$1 pKSupportDialog$reportGroup$1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, pKSupportDialog.getContext(), ResourcesKtxKt.getStringById(pKSupportDialog$reportGroup$1, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$1(PKSupportDialog pKSupportDialog, PKSupportDialog$reportGroup$1 pKSupportDialog$reportGroup$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, pKSupportDialog.getContext(), ResourcesKtxKt.getStringById(pKSupportDialog$reportGroup$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        String str;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        GroupService companion = GroupService.INSTANCE.getInstance();
        GroupDetailBean group = this.this$0.getGroup();
        if (group == null || (str = group.getGroupId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<String>> reportGroup = companion.reportGroup(str, reportType, false, true);
        final PKSupportDialog pKSupportDialog = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.dialog.p1
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = PKSupportDialog$reportGroup$1.reportDialogCheck$lambda$0(PKSupportDialog.this, this, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final PKSupportDialog pKSupportDialog2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(reportGroup, function1, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.q1
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = PKSupportDialog$reportGroup$1.reportDialogCheck$lambda$1(PKSupportDialog.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.r1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null), this.this$0.getMCompositeDisposable());
    }
}
