package com.qiahao.nextvideo.ui.profile.activity;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$chatImageViewPressed$1$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity$chatImageViewPressed$1$1 implements OnCommonDialogListener {
    final /* synthetic */ OtherUserActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtherUserActivity$chatImageViewPressed$1$1(OtherUserActivity otherUserActivity) {
        this.this$0 = otherUserActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirm$lambda$1(OtherUserActivity otherUserActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LikeResult likeResult = (LikeResult) apiResponse.getData();
        if (likeResult != null) {
            User uiModel = otherUserActivity.getUiModel();
            if (uiModel != null) {
                uiModel.setLike(Boolean.valueOf(likeResult.isLikeEach()));
            }
            User uiModel2 = otherUserActivity.getUiModel();
            if (uiModel2 != null) {
                uiModel2.setLike(Boolean.valueOf(likeResult.getStatus()));
            }
            User uiModel3 = otherUserActivity.getUiModel();
            if (uiModel3 != null) {
                uiModel3.setLikeMe(Boolean.valueOf(likeResult.isLikeEach()));
            }
            otherUserActivity.showLikedStatus();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$2(OtherUserActivity otherUserActivity, OtherUserActivity$chatImageViewPressed$1$1 otherUserActivity$chatImageViewPressed$1$1, Throwable th) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        str2 = ResourcesKtxKt.getStringById(otherUserActivity$chatImageViewPressed$1$1, 2131952667);
                    } else {
                        str2 = localizedMessage;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, otherUserActivity, str2, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, otherUserActivity, ResourcesKtxKt.getStringById(otherUserActivity$chatImageViewPressed$1$1, 2131953231), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                new VipViewDialog(5, otherUserActivity).show();
            }
        } else {
            HiloToasty.Companion companion2 = HiloToasty.Companion;
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                str = ResourcesKtxKt.getStringById(otherUserActivity$chatImageViewPressed$1$1, 2131952667);
            } else {
                str = localizedMessage2;
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion2, otherUserActivity, str, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    public void cancel() {
        OnCommonDialogListener.DefaultImpls.cancel(this);
    }

    public void confirm() {
        String str;
        boolean z;
        UserService shared = UserService.INSTANCE.getShared();
        User uiModel = this.this$0.getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        User uiModel2 = this.this$0.getUiModel();
        if (uiModel2 != null) {
            z = Intrinsics.areEqual(uiModel2.isLike(), Boolean.TRUE);
        } else {
            z = false;
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<LikeResult>> like = shared.like(str, z, true);
        final OtherUserActivity otherUserActivity = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.f0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = OtherUserActivity$chatImageViewPressed$1$1.confirm$lambda$1(OtherUserActivity.this, (ApiResponse) obj);
                return confirm$lambda$1;
            }
        };
        final OtherUserActivity otherUserActivity2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(like, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.g0
            public final Object invoke(Object obj) {
                Unit confirm$lambda$2;
                confirm$lambda$2 = OtherUserActivity$chatImageViewPressed$1$1.confirm$lambda$2(OtherUserActivity.this, this, (Throwable) obj);
                return confirm$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), this.this$0.getCompositeDisposable());
    }
}
