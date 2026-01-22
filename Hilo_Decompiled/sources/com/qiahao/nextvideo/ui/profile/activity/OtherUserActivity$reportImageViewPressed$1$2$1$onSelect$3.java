package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.widget.Toast;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3 implements OnCommonDialogListener {
    final /* synthetic */ BlockOrReportDialog $this_apply;
    final /* synthetic */ OtherUserActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3(OtherUserActivity otherUserActivity, BlockOrReportDialog blockOrReportDialog) {
        this.this$0 = otherUserActivity;
        this.$this_apply = blockOrReportDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$3(final OtherUserActivity otherUserActivity, final BlockOrReportDialog blockOrReportDialog, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            otherUserActivity.getUserPhotoData();
            UserService shared = UserService.INSTANCE.getShared();
            User uiModel = otherUserActivity.getUiModel();
            if (uiModel == null || (str = uiModel.getExternalId()) == null) {
                str = "";
            }
            RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(shared, str, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.q0
                public final Object invoke(Object obj) {
                    Unit confirm$lambda$3$lambda$1;
                    confirm$lambda$3$lambda$1 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3.confirm$lambda$3$lambda$1(OtherUserActivity.this, (ApiResponse) obj);
                    return confirm$lambda$3$lambda$1;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.r0
                public final Object invoke(Object obj) {
                    Unit confirm$lambda$3$lambda$2;
                    confirm$lambda$3$lambda$2 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3.confirm$lambda$3$lambda$2(BlockOrReportDialog.this, otherUserActivity, (Throwable) obj);
                    return confirm$lambda$3$lambda$2;
                }
            }, (Function0) null, false, 12, (Object) null);
        } else {
            HiloToasty.Companion companion = HiloToasty.Companion;
            String string = otherUserActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, string, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$3$lambda$1(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = (User) apiResponse.getData();
        if (user != null) {
            otherUserActivity.refreshView(user);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$3$lambda$2(BlockOrReportDialog blockOrReportDialog, OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = blockOrReportDialog.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = otherUserActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$4(OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = otherUserActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User uiModel = this.this$0.getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> resetUserInfo = shared.resetUserInfo(str);
        final OtherUserActivity otherUserActivity = this.this$0;
        final BlockOrReportDialog blockOrReportDialog = this.$this_apply;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.o0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$3;
                confirm$lambda$3 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3.confirm$lambda$3(OtherUserActivity.this, blockOrReportDialog, (ApiResponse) obj);
                return confirm$lambda$3;
            }
        };
        final OtherUserActivity otherUserActivity2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(resetUserInfo, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.p0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$4;
                confirm$lambda$4 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$3.confirm$lambda$4(OtherUserActivity.this, (Throwable) obj);
                return confirm$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
    }
}
