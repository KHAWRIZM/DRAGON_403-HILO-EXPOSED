package com.qiahao.nextvideo.utilities.google.pay;

import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0004H&¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\rJ\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "", "Lcom/android/billingclient/api/Purchase;", "purchase", "", "consumeSuccess", "(Lcom/android/billingclient/api/Purchase;)V", "purchaseSuccess", "", "endTime", "subSuccess", "(Lcom/android/billingclient/api/Purchase;J)V", "subTerminateSuccess", "()V", "startupPurchaseFlow", "querySkuDetailAsyncDidFailure", "Lcom/android/billingclient/api/w;", "billingResult", "purchasesUpdatedDidFailure", "(Lcom/android/billingclient/api/w;)V", "showUnChargeGoogleToast", "onBillingSetupFinishedDidFailure", "", "isSub", "onInitSKUListSuccess", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface GooglePayConsumeListener {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class DefaultImpls {
        public static void subSuccess(@NotNull GooglePayConsumeListener googlePayConsumeListener, @NotNull Purchase purchase, long j) {
            Intrinsics.checkNotNullParameter(purchase, "purchase");
        }

        public static void subTerminateSuccess(@NotNull GooglePayConsumeListener googlePayConsumeListener) {
        }
    }

    void consumeSuccess(@NotNull Purchase purchase);

    void onBillingSetupFinishedDidFailure(@NotNull w billingResult);

    void onInitSKUListSuccess(boolean isSub);

    void purchaseSuccess(@NotNull Purchase purchase);

    void purchasesUpdatedDidFailure(@NotNull w billingResult);

    void querySkuDetailAsyncDidFailure();

    void showUnChargeGoogleToast();

    void startupPurchaseFlow();

    void subSuccess(@NotNull Purchase purchase, long endTime);

    void subTerminateSuccess();
}
