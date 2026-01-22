package com.qiahao.nextvideo.ui.wallet;

import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.billingclient.api.Purchase;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserDiamonds;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.FragmentWalletGoldBinding;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.android.agoo.message.MessageService;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/qiahao/nextvideo/ui/wallet/WalletGoldFragment$listener$2$1", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "consumeSuccess", "(Lcom/android/billingclient/api/Purchase;)V", "purchaseSuccess", "startupPurchaseFlow", "()V", "querySkuDetailAsyncDidFailure", "Lcom/android/billingclient/api/w;", "billingResult", "purchasesUpdatedDidFailure", "(Lcom/android/billingclient/api/w;)V", "showUnChargeGoogleToast", "onBillingSetupFinishedDidFailure", "", "isSub", "onInitSKUListSuccess", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletGoldFragment$listener$2$1 implements GooglePayConsumeListener {
    final /* synthetic */ WalletGoldFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WalletGoldFragment$listener$2$1(WalletGoldFragment walletGoldFragment) {
        this.this$0 = walletGoldFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseSuccess$lambda$1(WalletGoldFragment walletGoldFragment, Purchase purchase, ApiResponse apiResponse) {
        AppCompatTextView appCompatTextView;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserDiamonds userDiamonds = (UserDiamonds) apiResponse.getData();
        if (userDiamonds != null) {
            double pinkDiamondNum = userDiamonds.getPinkDiamondNum();
            walletGoldFragment.mBeanNumber = pinkDiamondNum;
            UserStore.refreshDiamondOrGem$default(UserStore.INSTANCE.getShared(), 0.0d, pinkDiamondNum, 1, null);
            FragmentWalletGoldBinding fragmentWalletGoldBinding = (FragmentWalletGoldBinding) walletGoldFragment.getBinding();
            if (fragmentWalletGoldBinding != null && (appCompatTextView = fragmentWalletGoldBinding.beansCountTickTextView) != null) {
                appCompatTextView.setText(String.valueOf(MathKt.roundToLong(pinkDiamondNum)));
            }
        }
        cf.c.c().l(new EventBusKey("refresh_h5", (Object) null, 2, (DefaultConstructorMarker) null));
        BillingRepository mBillingRepository = walletGoldFragment.getMBillingRepository();
        if (mBillingRepository != null) {
            mBillingRepository.handleServerVerifiedOrder(purchase);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseSuccess$lambda$2(WalletGoldFragment walletGoldFragment, WalletGoldFragment$listener$2$1 walletGoldFragment$listener$2$1, Purchase purchase, Throwable th) {
        BillingRepository mBillingRepository;
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, walletGoldFragment.getContext(), ResourcesKtxKt.getStringById(walletGoldFragment$listener$2$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        if ((th instanceof HiloException) && ((HiloException) th).getCode() == 6000 && (mBillingRepository = walletGoldFragment.getMBillingRepository()) != null) {
            mBillingRepository.handleServerVerifiedOrder(purchase);
        }
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void consumeSuccess(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void onBillingSetupFinishedDidFailure(com.android.billingclient.api.w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void onInitSKUListSuccess(boolean isSub) {
        WalletViewModel viewModel;
        if (!isSub) {
            viewModel = this.this$0.getViewModel();
            viewModel.getGoldRechargeList();
        }
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchaseSuccess(final Purchase purchase) {
        WalletViewModel viewModel;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        PurchaseService shared = PurchaseService.INSTANCE.getShared();
        String e = purchase.e();
        Intrinsics.checkNotNullExpressionValue(e, "getPurchaseToken(...)");
        String a = purchase.a();
        Object obj = purchase.c().get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        io.reactivex.rxjava3.core.i0 purchaseDiamonds$default = PurchaseService.purchaseDiamonds$default(shared, null, (String) obj, a, e, MessageService.MSG_DB_NOTIFY_REACHED, 1, null);
        final WalletGoldFragment walletGoldFragment = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.h1
            public final Object invoke(Object obj2) {
                Unit purchaseSuccess$lambda$1;
                purchaseSuccess$lambda$1 = WalletGoldFragment$listener$2$1.purchaseSuccess$lambda$1(WalletGoldFragment.this, purchase, (ApiResponse) obj2);
                return purchaseSuccess$lambda$1;
            }
        };
        final WalletGoldFragment walletGoldFragment2 = this.this$0;
        nd.c observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(purchaseDiamonds$default, function1, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.i1
            public final Object invoke(Object obj2) {
                Unit purchaseSuccess$lambda$2;
                purchaseSuccess$lambda$2 = WalletGoldFragment$listener$2$1.purchaseSuccess$lambda$2(WalletGoldFragment.this, this, purchase, (Throwable) obj2);
                return purchaseSuccess$lambda$2;
            }
        }, new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.j1
            public final Object invoke() {
                Unit unit;
                unit = Unit.INSTANCE;
                return unit;
            }
        }, false, 8, (Object) null);
        viewModel = this.this$0.getViewModel();
        RxUtilsKt.addTo(observeOnMainThread$default, viewModel.getMCompositeDisposable());
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchasesUpdatedDidFailure(com.android.billingclient.api.w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void querySkuDetailAsyncDidFailure() {
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void showUnChargeGoogleToast() {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, this.this$0.getContext(), ResourcesKtxKt.getStringById(this, 2131952929), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void startupPurchaseFlow() {
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void subSuccess(Purchase purchase, long j) {
        GooglePayConsumeListener.DefaultImpls.subSuccess(this, purchase, j);
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void subTerminateSuccess() {
        GooglePayConsumeListener.DefaultImpls.subTerminateSuccess(this);
    }
}
