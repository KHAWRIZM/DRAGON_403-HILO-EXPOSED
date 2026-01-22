package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.DialogInterface;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.CommonApi;
import com.qiahao.base_common.network.CommonServer;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewModel.ChatViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/home/chat/activity/ChatStrangeActivity$showReportDialog$1", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ChatStrangeActivity$showReportDialog$1 implements ReportDialogListener {
    final /* synthetic */ ChatStrangeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChatStrangeActivity$showReportDialog$1(ChatStrangeActivity chatStrangeActivity) {
        this.this$0 = chatStrangeActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$1(final ChatStrangeActivity chatStrangeActivity, ChatStrangeActivity$showReportDialog$1 chatStrangeActivity$showReportDialog$1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        TipDialog tipDialog = new TipDialog(chatStrangeActivity);
        tipDialog.setTipContent(ResourcesKtxKt.getStringById(chatStrangeActivity$showReportDialog$1, 2131954490));
        tipDialog.setConfirmContent(ResourcesKtxKt.getStringById(chatStrangeActivity$showReportDialog$1, 2131952331));
        tipDialog.hideCancel(true);
        tipDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.p1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ChatStrangeActivity.deleteConversation$default(ChatStrangeActivity.this, true, false, false, 6, null);
            }
        });
        tipDialog.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$2(ChatStrangeActivity chatStrangeActivity, ChatStrangeActivity$showReportDialog$1 chatStrangeActivity$showReportDialog$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatStrangeActivity, ResourcesKtxKt.getStringById(chatStrangeActivity$showReportDialog$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$5(final ChatStrangeActivity chatStrangeActivity, ChatStrangeActivity$showReportDialog$1 chatStrangeActivity$showReportDialog$1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        TipDialog tipDialog = new TipDialog(chatStrangeActivity);
        tipDialog.setTipContent(ResourcesKtxKt.getStringById(chatStrangeActivity$showReportDialog$1, 2131954490));
        tipDialog.setConfirmContent(ResourcesKtxKt.getStringById(chatStrangeActivity$showReportDialog$1, 2131952331));
        tipDialog.hideCancel(true);
        tipDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.q1
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ChatStrangeActivity.deleteConversation$default(ChatStrangeActivity.this, true, false, false, 6, null);
            }
        });
        tipDialog.show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$6(ChatStrangeActivity chatStrangeActivity, ChatStrangeActivity$showReportDialog$1 chatStrangeActivity$showReportDialog$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, chatStrangeActivity, ResourcesKtxKt.getStringById(chatStrangeActivity$showReportDialog$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        User user;
        String str;
        ChatViewModel viewModel;
        User user2;
        String str2;
        ChatViewModel viewModel2;
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        if (this.this$0.getIsStrange()) {
            CommonApi apis = CommonServer.INSTANCE.getApis();
            user2 = this.this$0.mUser;
            if (user2 == null || (str2 = user2.getExternalId()) == null) {
                str2 = "";
            }
            io.reactivex.rxjava3.core.i0 strangeReportUser = apis.strangeReportUser(str2, 3, reportType, reportStr, (String) null, this.this$0.getMGroupId());
            final ChatStrangeActivity chatStrangeActivity = this.this$0;
            Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.j1
                public final Object invoke(Object obj) {
                    Unit reportDialogCheck$lambda$1;
                    reportDialogCheck$lambda$1 = ChatStrangeActivity$showReportDialog$1.reportDialogCheck$lambda$1(ChatStrangeActivity.this, this, (ApiResponse) obj);
                    return reportDialogCheck$lambda$1;
                }
            };
            final ChatStrangeActivity chatStrangeActivity2 = this.this$0;
            nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(strangeReportUser, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.k1
                public final Object invoke(Object obj) {
                    Unit reportDialogCheck$lambda$2;
                    reportDialogCheck$lambda$2 = ChatStrangeActivity$showReportDialog$1.reportDialogCheck$lambda$2(ChatStrangeActivity.this, this, (Throwable) obj);
                    return reportDialogCheck$lambda$2;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.l1
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, false, 8, (Object) null);
            viewModel2 = this.this$0.getViewModel();
            RxUtilsKt.addTo(observeOnMainThread$default, viewModel2.getMCompositeDisposable());
            return;
        }
        CommonApi apis2 = CommonServer.INSTANCE.getApis();
        user = this.this$0.mUser;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0 reportUser = apis2.reportUser(str, 3, reportType, reportStr, (String) null);
        final ChatStrangeActivity chatStrangeActivity3 = this.this$0;
        Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.m1
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$5;
                reportDialogCheck$lambda$5 = ChatStrangeActivity$showReportDialog$1.reportDialogCheck$lambda$5(ChatStrangeActivity.this, this, (ApiResponse) obj);
                return reportDialogCheck$lambda$5;
            }
        };
        final ChatStrangeActivity chatStrangeActivity4 = this.this$0;
        nd.c observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(reportUser, function12, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.n1
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$6;
                reportDialogCheck$lambda$6 = ChatStrangeActivity$showReportDialog$1.reportDialogCheck$lambda$6(ChatStrangeActivity.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$6;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.o1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null);
        viewModel = this.this$0.getViewModel();
        RxUtilsKt.addTo(observeOnMainThread$default2, viewModel.getMCompositeDisposable());
    }
}
