package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
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

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/room/dialog/RoomInfoFragment$reportGroup$1$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomInfoFragment$reportGroup$1$1 implements ReportDialogListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ RoomInfoFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomInfoFragment$reportGroup$1$1(RoomInfoFragment roomInfoFragment, Context context) {
        this.this$0 = roomInfoFragment;
        this.$context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$0(RoomInfoFragment roomInfoFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomInfoFragment.blackOrReport(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$1(Context context, RoomInfoFragment$reportGroup$1$1 roomInfoFragment$reportGroup$1$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, context, ResourcesKtxKt.getStringById(roomInfoFragment$reportGroup$1$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        GroupDetailBean groupDetailBean;
        String str;
        nd.a aVar;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        GroupService companion = GroupService.INSTANCE.getInstance();
        groupDetailBean = this.this$0.mGroupDetail;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0 reportGroup$default = GroupService.reportGroup$default(companion, str, reportType, false, false, 12, null);
        final RoomInfoFragment roomInfoFragment = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.dialog.g3
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = RoomInfoFragment$reportGroup$1$1.reportDialogCheck$lambda$0(RoomInfoFragment.this, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final Context context = this.$context;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(reportGroup$default, function1, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.h3
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = RoomInfoFragment$reportGroup$1$1.reportDialogCheck$lambda$1(context, this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.i3
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null);
        aVar = this.this$0.mCompositeDisposable;
        RxUtilsKt.addTo(observeOnMainThread$default, aVar);
    }
}
