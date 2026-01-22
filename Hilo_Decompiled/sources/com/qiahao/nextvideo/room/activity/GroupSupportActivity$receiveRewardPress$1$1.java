package com.qiahao.nextvideo.room.activity;

import android.content.Context;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.app.base.CommonTextDialog;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.data.model.SupportAwardResponseBean;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/qiahao/nextvideo/room/activity/GroupSupportActivity$receiveRewardPress$1$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "cancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupSupportActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupSupportActivity.kt\ncom/qiahao/nextvideo/room/activity/GroupSupportActivity$receiveRewardPress$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,400:1\n1869#2,2:401\n*S KotlinDebug\n*F\n+ 1 GroupSupportActivity.kt\ncom/qiahao/nextvideo/room/activity/GroupSupportActivity$receiveRewardPress$1$1\n*L\n313#1:401,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSupportActivity$receiveRewardPress$1$1 implements OnCommonDialogListener {
    final /* synthetic */ CommonTextDialog $this_apply;
    final /* synthetic */ GroupSupportActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GroupSupportActivity$receiveRewardPress$1$1(GroupSupportActivity groupSupportActivity, CommonTextDialog commonTextDialog) {
        this.this$0 = groupSupportActivity;
        this.$this_apply = commonTextDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(GroupSupportActivity groupSupportActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        groupSupportActivity.initData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$2(CommonTextDialog commonTextDialog, GroupSupportActivity$receiveRewardPress$1$1 groupSupportActivity$receiveRewardPress$1$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = commonTextDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(groupSupportActivity$receiveRewardPress$1$1, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
    }

    public void confirm() {
        StringBuilder sb2 = new StringBuilder();
        for (MemberBean memberBean : this.this$0.getMSupporters()) {
            if (memberBean.getExternalId().length() > 0) {
                sb2.append(memberBean.getExternalId());
                sb2.append(",");
            }
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        String mGroupId = this.this$0.getMGroupId();
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
        io.reactivex.rxjava3.core.i0<ApiResponse<SupportAwardResponseBean>> supportAward = apis.getSupportAward(mGroupId, sb3);
        final GroupSupportActivity groupSupportActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.activity.l0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = GroupSupportActivity$receiveRewardPress$1$1.confirm$lambda$1(GroupSupportActivity.this, (ApiResponse) obj);
                return confirm$lambda$1;
            }
        };
        final CommonTextDialog commonTextDialog = this.$this_apply;
        RxUtilsKt.observeOnMainThread$default(supportAward, function1, new Function1() { // from class: com.qiahao.nextvideo.room.activity.m0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$2;
                confirm$lambda$2 = GroupSupportActivity$receiveRewardPress$1$1.confirm$lambda$2(CommonTextDialog.this, this, (Throwable) obj);
                return confirm$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null);
    }
}
