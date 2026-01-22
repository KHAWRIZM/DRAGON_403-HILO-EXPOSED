package com.qiahao.nextvideo.ui.profile.activity;

import android.widget.Toast;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$4", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$4 implements OnCommonDialogListener {
    final /* synthetic */ OtherUserActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$4(OtherUserActivity otherUserActivity) {
        this.this$0 = otherUserActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$0(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String string = otherUserActivity.getString(2131954177);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$1(OtherUserActivity otherUserActivity, Throwable th) {
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
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> resetRoomInfo = shared.resetRoomInfo(str);
        final OtherUserActivity otherUserActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.s0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$4.confirm$lambda$0(OtherUserActivity.this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final OtherUserActivity otherUserActivity2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(resetRoomInfo, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.t0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$4.confirm$lambda$1(OtherUserActivity.this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
    }
}
