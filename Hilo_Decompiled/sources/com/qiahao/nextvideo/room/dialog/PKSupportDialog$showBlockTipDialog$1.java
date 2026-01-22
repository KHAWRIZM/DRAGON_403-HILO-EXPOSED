package com.qiahao.nextvideo.room.dialog;

import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.service.GroupService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/qiahao/nextvideo/room/dialog/PKSupportDialog$showBlockTipDialog$1", "Lcom/qiahao/base_common/interfaceing/OnCommonDialogListener;", "confirm", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKSupportDialog$showBlockTipDialog$1 implements OnCommonDialogListener {
    final /* synthetic */ PKSupportDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PKSupportDialog$showBlockTipDialog$1(PKSupportDialog pKSupportDialog) {
        this.this$0 = pKSupportDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$0(PKSupportDialog pKSupportDialog, PKSupportDialog$showBlockTipDialog$1 pKSupportDialog$showBlockTipDialog$1, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, pKSupportDialog.getContext(), ResourcesKtxKt.getStringById(pKSupportDialog$showBlockTipDialog$1, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit confirm$lambda$1(PKSupportDialog pKSupportDialog, PKSupportDialog$showBlockTipDialog$1 pKSupportDialog$showBlockTipDialog$1, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, pKSupportDialog.getContext(), ResourcesKtxKt.getStringById(pKSupportDialog$showBlockTipDialog$1, 2131952667), false, 4, (Object) null);
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
        GroupService companion = GroupService.INSTANCE.getInstance();
        GroupDetailBean group = this.this$0.getGroup();
        if (group == null || (str = group.getGroupId()) == null) {
            str = "";
        }
        io.reactivex.rxjava3.core.i0<ApiResponse<String>> reportGroup = companion.reportGroup(str, 0, true, true);
        final PKSupportDialog pKSupportDialog = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.room.dialog.s1
            public final Object invoke(Object obj) {
                Unit confirm$lambda$0;
                confirm$lambda$0 = PKSupportDialog$showBlockTipDialog$1.confirm$lambda$0(PKSupportDialog.this, this, (ApiResponse) obj);
                return confirm$lambda$0;
            }
        };
        final PKSupportDialog pKSupportDialog2 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(reportGroup, function1, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.t1
            public final Object invoke(Object obj) {
                Unit confirm$lambda$1;
                confirm$lambda$1 = PKSupportDialog$showBlockTipDialog$1.confirm$lambda$1(PKSupportDialog.this, this, (Throwable) obj);
                return confirm$lambda$1;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.room.dialog.u1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null), this.this$0.getMCompositeDisposable());
    }
}
