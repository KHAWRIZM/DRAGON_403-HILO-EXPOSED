package com.qiahao.nextvideo.ui.power;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.PowerDetailViewControllerBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/qiahao/nextvideo/ui/power/PowerDetailViewController$joinPowerDialog$controller$1$1", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "confirmTipViewControllerDidConfirm", "", "fromCode", "", "extra", "Landroid/os/Bundle;", "confirmTipViewControllerDidCancel", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerDetailViewController$joinPowerDialog$controller$1$1 implements ConfirmTipViewControllerDelegate {
    final /* synthetic */ ConfirmTipViewController $this_apply;
    final /* synthetic */ PowerDetailViewController this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PowerDetailViewController$joinPowerDialog$controller$1$1(ConfirmTipViewController confirmTipViewController, PowerDetailViewController powerDetailViewController) {
        this.$this_apply = confirmTipViewController;
        this.this$0 = powerDetailViewController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$0(ConfirmTipViewController confirmTipViewController, PowerDetailViewController$joinPowerDialog$controller$1$1 powerDetailViewController$joinPowerDialog$controller$1$1, PowerDetailViewController powerDetailViewController, ApiResponse apiResponse) {
        PowerDetailViewControllerBinding powerDetailViewControllerBinding;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding2;
        PowerDetailViewControllerBinding powerDetailViewControllerBinding3;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, confirmTipViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController$joinPowerDialog$controller$1$1, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            powerDetailViewControllerBinding = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding = null;
            }
            powerDetailViewControllerBinding.join.setText(ResourcesKtxKt.getStringById(powerDetailViewController$joinPowerDialog$controller$1$1, 2131953165));
            powerDetailViewControllerBinding2 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding2 = null;
            }
            powerDetailViewControllerBinding2.join.setClickable(false);
            powerDetailViewControllerBinding3 = powerDetailViewController.binding;
            if (powerDetailViewControllerBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                powerDetailViewControllerBinding3 = null;
            }
            powerDetailViewControllerBinding3.moreBtn.setVisibility(0);
            UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        } else {
            Log.d("PowerDetailViewControll", "confirmTipViewControllerDidConfirm: " + apiResponse.getMessage());
            if (apiResponse.getCode() == 15002) {
                Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, confirmTipViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController$joinPowerDialog$controller$1$1, 2131953040), false, 4, (Object) null);
                if (normal$default2 != null) {
                    normal$default2.show();
                }
            } else {
                Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, confirmTipViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController$joinPowerDialog$controller$1$1, 2131952667), false, 4, (Object) null);
                if (normal$default3 != null) {
                    normal$default3.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$1(ConfirmTipViewController confirmTipViewController, PowerDetailViewController$joinPowerDialog$controller$1$1 powerDetailViewController$joinPowerDialog$controller$1$1, Throwable th) {
        Toast normal$default;
        Intrinsics.checkNotNullParameter(th, "it");
        if ((th instanceof HiloException) && ((HiloException) th).getCode() == 15002 && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, confirmTipViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController$joinPowerDialog$controller$1$1, 2131953040), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        Log.d("PowerDetailViewControll", "confirmTipViewControllerDidConfirm: " + th.getLocalizedMessage());
        Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, confirmTipViewController.getContext(), ResourcesKtxKt.getStringById(powerDetailViewController$joinPowerDialog$controller$1$1, 2131952667), false, 4, (Object) null);
        if (normal$default2 != null) {
            normal$default2.show();
        }
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this.$this_apply, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        ViewController.dismiss$default(this.$this_apply, true, null, 2, null);
        i0<ApiResponse<Object>> joinGroupPower = AppServer.INSTANCE.getApis().joinGroupPower(this.this$0.getPowerId());
        final ConfirmTipViewController confirmTipViewController = this.$this_apply;
        final PowerDetailViewController powerDetailViewController = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.power.p
            public final Object invoke(Object obj) {
                Unit confirmTipViewControllerDidConfirm$lambda$0;
                confirmTipViewControllerDidConfirm$lambda$0 = PowerDetailViewController$joinPowerDialog$controller$1$1.confirmTipViewControllerDidConfirm$lambda$0(ConfirmTipViewController.this, this, powerDetailViewController, (ApiResponse) obj);
                return confirmTipViewControllerDidConfirm$lambda$0;
            }
        };
        final ConfirmTipViewController confirmTipViewController2 = this.$this_apply;
        RxUtilsKt.observeOnMainThread$default(joinGroupPower, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.power.q
            public final Object invoke(Object obj) {
                Unit confirmTipViewControllerDidConfirm$lambda$1;
                confirmTipViewControllerDidConfirm$lambda$1 = PowerDetailViewController$joinPowerDialog$controller$1$1.confirmTipViewControllerDidConfirm$lambda$1(ConfirmTipViewController.this, this, (Throwable) obj);
                return confirmTipViewControllerDidConfirm$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null);
        Log.d("PowerDetailViewControll", "confirmTipViewControllerDidConfirm: 加入势力");
    }
}
