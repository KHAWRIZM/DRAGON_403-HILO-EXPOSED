package com.qiahao.nextvideo.ui.profile.activity;

import android.content.Context;
import android.widget.Toast;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.ui.base.BlockTextDialog;
import com.qiahao.nextvideo.ui.base.OnBlockCommonDialogListener;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversationManager;
import com.tencent.imsdk.v2.V2TIMManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/ui/profile/activity/OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1", "Lcom/qiahao/nextvideo/ui/base/OnBlockCommonDialogListener;", "blockTextDialogConfirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1 implements OnBlockCommonDialogListener {
    final /* synthetic */ BlockTextDialog $this_apply;
    final /* synthetic */ OtherUserActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1(OtherUserActivity otherUserActivity, BlockTextDialog blockTextDialog) {
        this.this$0 = otherUserActivity;
        this.$this_apply = blockTextDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockTextDialogConfirm$lambda$0(OtherUserActivity otherUserActivity, Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        otherUserActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit blockTextDialogConfirm$lambda$1(BlockTextDialog blockTextDialog, OtherUserActivity otherUserActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = blockTextDialog.getContext();
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
    public static final Unit blockTextDialogConfirm$lambda$2(OtherUserActivity otherUserActivity) {
        String str;
        la.c reportEventRelay = FeedbackService.INSTANCE.getShared().getReportEventRelay();
        User uiModel = otherUserActivity.getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        reportEventRelay.accept(str);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.base.OnBlockCommonDialogListener
    public void blockTextCancel() {
        OnBlockCommonDialogListener.DefaultImpls.blockTextCancel(this);
    }

    @Override // com.qiahao.nextvideo.ui.base.OnBlockCommonDialogListener
    public void blockTextDialogConfirm() {
        String str;
        FeedbackService shared = FeedbackService.INSTANCE.getShared();
        User uiModel = this.this$0.getUiModel();
        if (uiModel == null || (str = uiModel.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> blockUser = shared.blockUser(str);
        final OtherUserActivity otherUserActivity = this.this$0;
        io.reactivex.rxjava3.core.i0 j = blockUser.j(new pd.o() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1$blockTextDialogConfirm$1
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                V2TIMConversationManager conversationManager = V2TIMManager.getConversationManager();
                User uiModel2 = OtherUserActivity.this.getUiModel();
                conversationManager.deleteConversation(uiModel2 != null ? uiModel2.getExternalId() : null, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.profile.activity.OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1$blockTextDialogConfirm$1.1
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
        final OtherUserActivity otherUserActivity2 = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.l0
            public final Object invoke(Object obj) {
                Unit blockTextDialogConfirm$lambda$0;
                blockTextDialogConfirm$lambda$0 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1.blockTextDialogConfirm$lambda$0(OtherUserActivity.this, (Unit) obj);
                return blockTextDialogConfirm$lambda$0;
            }
        };
        final BlockTextDialog blockTextDialog = this.$this_apply;
        final OtherUserActivity otherUserActivity3 = this.this$0;
        Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.m0
            public final Object invoke(Object obj) {
                Unit blockTextDialogConfirm$lambda$1;
                blockTextDialogConfirm$lambda$1 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1.blockTextDialogConfirm$lambda$1(BlockTextDialog.this, otherUserActivity3, (Throwable) obj);
                return blockTextDialogConfirm$lambda$1;
            }
        };
        final OtherUserActivity otherUserActivity4 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(j, function1, function12, new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.n0
            public final Object invoke() {
                Unit blockTextDialogConfirm$lambda$2;
                blockTextDialogConfirm$lambda$2 = OtherUserActivity$reportImageViewPressed$1$2$1$onSelect$2$1.blockTextDialogConfirm$lambda$2(OtherUserActivity.this);
                return blockTextDialogConfirm$lambda$2;
            }
        }, false, 8, (Object) null), this.this$0.getCompositeDisposable());
    }
}
