package com.qiahao.nextvideo.ui.gem;

import android.widget.Toast;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.w;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserDiamonds;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import io.reactivex.rxjava3.core.i0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.android.agoo.message.MessageService;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"com/qiahao/nextvideo/ui/gem/GemStoreDialog$listener$2$1", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "consumeSuccess", "(Lcom/android/billingclient/api/Purchase;)V", "purchaseSuccess", "startupPurchaseFlow", "()V", "querySkuDetailAsyncDidFailure", "Lcom/android/billingclient/api/w;", "billingResult", "purchasesUpdatedDidFailure", "(Lcom/android/billingclient/api/w;)V", "showUnChargeGoogleToast", "onBillingSetupFinishedDidFailure", "", "isSub", "onInitSKUListSuccess", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemStoreDialog$listener$2$1 implements GooglePayConsumeListener {
    final /* synthetic */ GemStoreDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GemStoreDialog$listener$2$1(GemStoreDialog gemStoreDialog) {
        this.this$0 = gemStoreDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseSuccess$lambda$2(GemStoreDialog gemStoreDialog, Purchase purchase, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserDiamonds userDiamonds = (UserDiamonds) apiResponse.getData();
        if (userDiamonds != null) {
            double pinkDiamondNum = userDiamonds.getPinkDiamondNum();
            UserStore.refreshDiamondOrGem$default(UserStore.INSTANCE.getShared(), 0.0d, pinkDiamondNum, 1, null);
            GemStoreDialog.access$getBinding(gemStoreDialog).gemNumber.setText(String.valueOf(MathKt.roundToLong(pinkDiamondNum)));
        }
        cf.c.c().l(new EventBusKey("refresh_h5", (Object) null, 2, (DefaultConstructorMarker) null));
        BillingRepository mBillingRepository = gemStoreDialog.getMBillingRepository();
        if (mBillingRepository != null) {
            mBillingRepository.handleServerVerifiedOrder(purchase);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseSuccess$lambda$3(GemStoreDialog gemStoreDialog, GemStoreDialog$listener$2$1 gemStoreDialog$listener$2$1, Purchase purchase, Throwable th) {
        BillingRepository mBillingRepository;
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, gemStoreDialog.getContext(), ResourcesKtxKt.getStringById(gemStoreDialog$listener$2$1, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        if ((th instanceof HiloException) && ((HiloException) th).getCode() == 6000 && (mBillingRepository = gemStoreDialog.getMBillingRepository()) != null) {
            mBillingRepository.handleServerVerifiedOrder(purchase);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseSuccess$lambda$4(GemStoreDialog gemStoreDialog) {
        GemStoreDialog.dismissProgressDialog$default(gemStoreDialog, false, null, 3, null);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void consumeSuccess(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final GemStoreDialog gemStoreDialog = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.gem.p
            @Override // java.lang.Runnable
            public final void run() {
                GemStoreDialog.dismissProgressDialog$default(GemStoreDialog.this, false, null, 3, null);
            }
        }, 200L);
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void onBillingSetupFinishedDidFailure(w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final GemStoreDialog gemStoreDialog = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.gem.u
            @Override // java.lang.Runnable
            public final void run() {
                GemStoreDialog.dismissProgressDialog$default(GemStoreDialog.this, false, null, 3, null);
            }
        }, 200L);
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void onInitSKUListSuccess(boolean isSub) {
        if (!isSub) {
            this.this$0.requestData();
        }
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchaseSuccess(final Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        PurchaseService shared = PurchaseService.INSTANCE.getShared();
        String e = purchase.e();
        Intrinsics.checkNotNullExpressionValue(e, "getPurchaseToken(...)");
        String a = purchase.a();
        Object obj = purchase.c().get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        i0 purchaseDiamonds$default = PurchaseService.purchaseDiamonds$default(shared, null, (String) obj, a, e, MessageService.MSG_DB_NOTIFY_REACHED, 1, null);
        final GemStoreDialog gemStoreDialog = this.this$0;
        Function1 function1 = new Function1() { // from class: com.qiahao.nextvideo.ui.gem.q
            public final Object invoke(Object obj2) {
                Unit purchaseSuccess$lambda$2;
                purchaseSuccess$lambda$2 = GemStoreDialog$listener$2$1.purchaseSuccess$lambda$2(GemStoreDialog.this, purchase, (ApiResponse) obj2);
                return purchaseSuccess$lambda$2;
            }
        };
        final GemStoreDialog gemStoreDialog2 = this.this$0;
        Function1 function12 = new Function1() { // from class: com.qiahao.nextvideo.ui.gem.r
            public final Object invoke(Object obj2) {
                Unit purchaseSuccess$lambda$3;
                purchaseSuccess$lambda$3 = GemStoreDialog$listener$2$1.purchaseSuccess$lambda$3(GemStoreDialog.this, this, purchase, (Throwable) obj2);
                return purchaseSuccess$lambda$3;
            }
        };
        final GemStoreDialog gemStoreDialog3 = this.this$0;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(purchaseDiamonds$default, function1, function12, new Function0() { // from class: com.qiahao.nextvideo.ui.gem.s
            public final Object invoke() {
                Unit purchaseSuccess$lambda$4;
                purchaseSuccess$lambda$4 = GemStoreDialog$listener$2$1.purchaseSuccess$lambda$4(GemStoreDialog.this);
                return purchaseSuccess$lambda$4;
            }
        }, false, 8, (Object) null), this.this$0.getMCompositeDisposable());
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void purchasesUpdatedDidFailure(w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final GemStoreDialog gemStoreDialog = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.gem.o
            @Override // java.lang.Runnable
            public final void run() {
                GemStoreDialog.dismissProgressDialog$default(GemStoreDialog.this, false, null, 3, null);
            }
        }, 200L);
    }

    @Override // com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener
    public void querySkuDetailAsyncDidFailure() {
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final GemStoreDialog gemStoreDialog = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.gem.v
            @Override // java.lang.Runnable
            public final void run() {
                GemStoreDialog.dismissProgressDialog$default(GemStoreDialog.this, false, null, 3, null);
            }
        }, 200L);
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
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        final GemStoreDialog gemStoreDialog = this.this$0;
        hiloUtils.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.ui.gem.t
            @Override // java.lang.Runnable
            public final void run() {
                GemStoreDialog.showProgressDialog$default(GemStoreDialog.this, null, false, null, 7, null);
            }
        }, 200L);
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
