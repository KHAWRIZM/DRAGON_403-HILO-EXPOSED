package com.qiahao.nextvideo.ui.home;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/home/GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1 implements ReportDialogListener {
    final /* synthetic */ String $uid;
    final /* synthetic */ GlobalBroadCastViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1(GlobalBroadCastViewController globalBroadCastViewController, String str) {
        this.this$0 = globalBroadCastViewController;
        this.$uid = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$0(final GlobalBroadCastViewController globalBroadCastViewController, GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1 globalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1, final String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        new TipDialog(globalBroadCastViewController.getRequireActivity()).setTipContent(ResourcesKtxKt.getStringById(globalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1, 2131954490)).setConfirmContent(ResourcesKtxKt.getStringById(globalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1, 2131952331)).hideCancel(true).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1$reportDialogCheck$1$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                if (GlobalBroadCastViewController.this.getMCurrentSelectIndex() != -1) {
                    GlobalBroadCastViewController.this.getMAdapter().removeAt(GlobalBroadCastViewController.this.getMCurrentSelectIndex());
                    GlobalBroadCastViewController.this.setMCurrentSelectIndex(-1);
                    GlobalBroadCastViewController.this.setMCurrentSelectGlobalBroadCastId(-1L);
                }
            }
        }).show();
        i0 j = FeedbackService.INSTANCE.getShared().blockUser(str).j(new pd.o() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1$reportDialogCheck$1$2
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                apply((ApiResponse<Object>) obj);
                return Unit.INSTANCE;
            }

            public final void apply(ApiResponse<Object> apiResponse2) {
                Intrinsics.checkNotNullParameter(apiResponse2, "it");
                V2TIMManager.getConversationManager().deleteConversation(str, new V2TIMCallback() { // from class: com.qiahao.nextvideo.ui.home.GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1$reportDialogCheck$1$2.1
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
        RxUtilsKt.observeOnMainThread$default(j, (Function1) null, (Function1) null, (Function0) null, false, 15, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit reportDialogCheck$lambda$1(GlobalBroadCastViewController globalBroadCastViewController, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, globalBroadCastViewController.getRequireContext(), BaseViewControllerKt.getString(globalBroadCastViewController, 2131952667, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        i0<ApiResponse<String>> prohibitBroadCastMessage = AppServer.INSTANCE.getApis().prohibitBroadCastMessage(this.this$0.getMCurrentSelectGlobalBroadCastId(), "", reportStr);
        final GlobalBroadCastViewController globalBroadCastViewController = this.this$0;
        final String str = this.$uid;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.s
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1.reportDialogCheck$lambda$0(GlobalBroadCastViewController.this, this, str, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final GlobalBroadCastViewController globalBroadCastViewController2 = this.this$0;
        RxUtilsKt.observeOnMainThread$default(prohibitBroadCastMessage, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.home.t
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = GlobalBroadCastViewController$showUserMenuDialog$1$1$2$onClickReport$1.reportDialogCheck$lambda$1(GlobalBroadCastViewController.this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
    }
}
