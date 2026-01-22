package com.qiahao.nextvideo.ui.home.chat.dialog;

import android.content.Context;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialogListener;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.service.FeedbackService;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/qiahao/nextvideo/ui/home/chat/dialog/ContactRoomDialog$showMenu$1$1$1$2", "Lcom/qiahao/base_common/ui/dialog/ReportDialogListener;", "reportDialogCheck", "", "reportType", "", "reportStr", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ContactRoomDialog$showMenu$1$1$1$2 implements ReportDialogListener {
    final /* synthetic */ String $externalId;
    final /* synthetic */ MessageMenuDialog $this_apply;
    final /* synthetic */ ContactRoomDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContactRoomDialog$showMenu$1$1$1$2(String str, MessageMenuDialog messageMenuDialog, ContactRoomDialog contactRoomDialog) {
        this.$externalId = str;
        this.$this_apply = messageMenuDialog;
        this.this$0 = contactRoomDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$0(ContactRoomDialog contactRoomDialog, String str, MessageMenuDialog messageMenuDialog, ContactRoomDialog$showMenu$1$1$1$2 contactRoomDialog$showMenu$1$1$1$2, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        contactRoomDialog.deleteSession(str);
        Context context = messageMenuDialog.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(contactRoomDialog$showMenu$1$1$1$2, 2131954490)).hideCancel(true).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit reportDialogCheck$lambda$1(MessageMenuDialog messageMenuDialog, ContactRoomDialog$showMenu$1$1$1$2 contactRoomDialog$showMenu$1$1$1$2, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, messageMenuDialog.getContext(), ResourcesKtxKt.getStringById(contactRoomDialog$showMenu$1$1$1$2, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public void reportDialogCheck(int reportType, String reportStr) {
        Intrinsics.checkNotNullParameter(reportStr, "reportStr");
        i0 reportUser$default = FeedbackService.reportUser$default(FeedbackService.INSTANCE.getShared(), 3, this.$externalId, reportType, reportStr, null, 16, null);
        final ContactRoomDialog contactRoomDialog = this.this$0;
        final String str = this.$externalId;
        final MessageMenuDialog messageMenuDialog = this.$this_apply;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.i
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$0;
                reportDialogCheck$lambda$0 = ContactRoomDialog$showMenu$1$1$1$2.reportDialogCheck$lambda$0(ContactRoomDialog.this, str, messageMenuDialog, this, (ApiResponse) obj);
                return reportDialogCheck$lambda$0;
            }
        };
        final MessageMenuDialog messageMenuDialog2 = this.$this_apply;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(reportUser$default, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.j
            public final Object invoke(Object obj) {
                Unit reportDialogCheck$lambda$1;
                reportDialogCheck$lambda$1 = ContactRoomDialog$showMenu$1$1$1$2.reportDialogCheck$lambda$1(MessageMenuDialog.this, this, (Throwable) obj);
                return reportDialogCheck$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.dialog.k
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null), this.$this_apply.getCompositeDisposable());
    }
}
