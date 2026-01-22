package com.qiahao.nextvideo.ui.wallet;

import android.widget.Toast;
import com.android.billingclient.api.Purchase;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/qiahao/nextvideo/ui/wallet/WalletDiamondFragment$mGooglePayListener$1", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "consumeSuccess", "(Lcom/android/billingclient/api/Purchase;)V", "purchaseSuccess", "startupPurchaseFlow", "()V", "querySkuDetailAsyncDidFailure", "Lcom/android/billingclient/api/w;", "billingResult", "purchasesUpdatedDidFailure", "(Lcom/android/billingclient/api/w;)V", "showUnChargeGoogleToast", "onBillingSetupFinishedDidFailure", "", "isSub", "onInitSKUListSuccess", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletDiamondFragment$mGooglePayListener$1 implements GooglePayConsumeListener {
    final /* synthetic */ WalletDiamondFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WalletDiamondFragment$mGooglePayListener$1(WalletDiamondFragment walletDiamondFragment) {
        this.this$0 = walletDiamondFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void purchaseSuccess$lambda$0(WalletDiamondFragment walletDiamondFragment, Purchase purchase) {
        walletDiamondFragment.getViewModel().purchaseDiamonds(purchase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showUnChargeGoogleToast$lambda$1(WalletDiamondFragment walletDiamondFragment, WalletDiamondFragment$mGooglePayListener$1 walletDiamondFragment$mGooglePayListener$1) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, walletDiamondFragment.getContext(), ResourcesKtxKt.getStringById(walletDiamondFragment$mGooglePayListener$1, 2131952929), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
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
        if (isSub) {
            this.this$0.getViewModel().vipList();
        } else {
            this.this$0.getViewModel().m٩٦getDiamondList();
        }
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchaseSuccess(final Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final WalletDiamondFragment walletDiamondFragment = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.wallet.v0
            @Override // java.lang.Runnable
            public final void run() {
                WalletDiamondFragment$mGooglePayListener$1.purchaseSuccess$lambda$0(WalletDiamondFragment.this, purchase);
            }
        });
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
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final WalletDiamondFragment walletDiamondFragment = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.wallet.w0
            @Override // java.lang.Runnable
            public final void run() {
                WalletDiamondFragment$mGooglePayListener$1.showUnChargeGoogleToast$lambda$1(WalletDiamondFragment.this, this);
            }
        });
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
