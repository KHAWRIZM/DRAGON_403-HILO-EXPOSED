package com.qiahao.nextvideo.utilities.google.pay;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.d0;
import com.android.billingclient.api.e0;
import com.android.billingclient.api.f0;
import com.android.billingclient.api.h0;
import com.android.billingclient.api.i0;
import com.android.billingclient.api.j0;
import com.android.billingclient.api.l0;
import com.android.billingclient.api.v;
import com.android.billingclient.api.w;
import com.android.billingclient.api.x;
import com.android.billingclient.api.y;
import com.google.gson.reflect.TypeToken;
import com.oudi.utils.log.LogUtil;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseGem;
import com.qiahao.nextvideo.data.service.PurchaseService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\tJ%\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u001d\u0010!\u001a\u00020\u00072\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00170\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b%\u0010$J\u0017\u0010&\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0017H\u0002¢\u0006\u0004\b&\u0010$J)\u0010+\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\u0007¢\u0006\u0004\b-\u0010\tJ\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\tJ\u0017\u00101\u001a\u00020\u00072\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0017¢\u0006\u0004\b4\u0010$J'\u00106\u001a\u00020\u00072\u0006\u00100\u001a\u00020/2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\rH\u0016¢\u0006\u0004\b6\u00107J'\u00109\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u00108\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b9\u0010:J\r\u0010;\u001a\u00020\u0007¢\u0006\u0004\b;\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010<\u001a\u0004\b=\u0010>R+\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0?j\b\u0012\u0004\u0012\u00020\u000e`@8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR(\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010\"R*\u0010J\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010F\u001a\u0004\bK\u0010H\"\u0004\bL\u0010\"R*\u0010M\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010F\u001a\u0004\bN\u0010H\"\u0004\bO\u0010\"R\u0018\u0010Q\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR$\u0010T\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006["}, d2 = {"Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "Lcom/android/billingclient/api/i0;", "Lcom/android/billingclient/api/u;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "instantiateAndConnectToPlayBillingService", "()V", "connectToPlayBillingService", "", "skuType", "", "Lcom/android/billingclient/api/j0$b;", "skuList", "querySkuDetailAsync", "(Ljava/lang/String;Ljava/util/List;)V", "queryPurchasesAsync", "", "isSubscriptionSupported", "()Z", "", "Lcom/android/billingclient/api/Purchase;", "purchasesResult", "processPurchases", "(Ljava/util/Set;)V", "purchase", "isConsumable", "(Lcom/android/billingclient/api/Purchase;)Z", "isSignatureValid", "", "nonConsumables", "askResponsePurchaseThenAcknowledge", "(Ljava/util/List;)V", "acknowledgePurchase", "(Lcom/android/billingclient/api/Purchase;)V", "disburseConsumableEntitlements", "disburseNonConsumableEntitlement", "Landroid/app/Activity;", AgooConstants.OPEN_ACTIIVTY_NAME, "Lcom/android/billingclient/api/e0;", "skuDetails", "launchBillingFollow2", "(Landroid/app/Activity;Lcom/android/billingclient/api/e0;Ljava/lang/String;)V", "startDataSourceConnections", "onBillingServiceDisconnected", "Lcom/android/billingclient/api/w;", "billingResult", "onBillingSetupFinished", "(Lcom/android/billingclient/api/w;)V", "consumable", "handleServerVerifiedOrder", "purchases", "onPurchasesUpdated", "(Lcom/android/billingclient/api/w;Ljava/util/List;)V", "productId", "launchBillingFollow", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "release", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "skuList$delegate", "Lkotlin/Lazy;", "getSkuList", "()Ljava/util/ArrayList;", "skuSubList", "Ljava/util/List;", "getSkuSubList", "()Ljava/util/List;", "setSkuSubList", "skuSubsDetailsList", "getSkuSubsDetailsList", "setSkuSubsDetailsList", "skuDetailsList", "getSkuDetailsList", "setSkuDetailsList", "Lcom/android/billingclient/api/g;", "playStoreBillingClient", "Lcom/android/billingclient/api/g;", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "delegate", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "getDelegate", "()Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "setDelegate", "(Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBillingRepository.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BillingRepository.kt\ncom/qiahao/nextvideo/utilities/google/pay/BillingRepository\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,538:1\n1869#2,2:539\n1869#2,2:541\n1869#2,2:544\n1869#2,2:546\n1#3:543\n*S KotlinDebug\n*F\n+ 1 BillingRepository.kt\ncom/qiahao/nextvideo/utilities/google/pay/BillingRepository\n*L\n313#1:539,2\n356#1:541,2\n71#1:544,2\n82#1:546,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BillingRepository implements i0, com.android.billingclient.api.u {

    @NotNull
    private static final String TAG = "BillingRepository";

    @NotNull
    public static final String VIP_PRODUCT_ID = "hilo_vip_monthly";

    @NotNull
    private final Context context;

    @Nullable
    private GooglePayConsumeListener delegate;

    @Nullable
    private com.android.billingclient.api.g playStoreBillingClient;

    @Nullable
    private List<e0> skuDetailsList;

    /* renamed from: skuList$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy skuList;

    @NotNull
    private List<j0.b> skuSubList;

    @Nullable
    private List<e0> skuSubsDetailsList;

    public BillingRepository(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.skuList = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.utilities.google.pay.b
            public final Object invoke() {
                ArrayList skuList_delegate$lambda$2;
                skuList_delegate$lambda$2 = BillingRepository.skuList_delegate$lambda$2();
                return skuList_delegate$lambda$2;
            }
        });
        ArrayList arrayList = new ArrayList();
        j0.b.a a = j0.b.a();
        Intrinsics.checkNotNullExpressionValue(a, "newBuilder(...)");
        a.b(VIP_PRODUCT_ID);
        a.c("subs");
        arrayList.add(a.a());
        this.skuSubList = arrayList;
    }

    private final void acknowledgePurchase(final Purchase purchase) {
        com.android.billingclient.api.a a = com.android.billingclient.api.a.b().b(purchase.e()).a();
        Intrinsics.checkNotNullExpressionValue(a, "build(...)");
        com.android.billingclient.api.g gVar = this.playStoreBillingClient;
        if (gVar != null) {
            gVar.a(a, new com.android.billingclient.api.b() { // from class: com.qiahao.nextvideo.utilities.google.pay.k
                public final void a(w wVar) {
                    BillingRepository.acknowledgePurchase$lambda$20(BillingRepository.this, purchase, wVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void acknowledgePurchase$lambda$20(BillingRepository billingRepository, Purchase purchase, w wVar) {
        Intrinsics.checkNotNullParameter(wVar, "billingResult");
        if (wVar.b() == 0) {
            billingRepository.disburseNonConsumableEntitlement(purchase);
            return;
        }
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "承认订阅报错回调acknowledgeNonConsumablePurchasesAsync response is" + wVar.b() + " " + wVar.a(), false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void askResponsePurchaseThenAcknowledge(List<? extends Purchase> nonConsumables) {
        for (final Purchase purchase : nonConsumables) {
            if (!purchase.h()) {
                PurchaseService shared = PurchaseService.INSTANCE.getShared();
                String e = purchase.e();
                Intrinsics.checkNotNullExpressionValue(e, "getPurchaseToken(...)");
                RxUtilsKt.observeOnMainThread$default(PurchaseService.subscribeVip$default(shared, null, e, purchase.a(), 1, null), new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.a
                    public final Object invoke(Object obj) {
                        Unit askResponsePurchaseThenAcknowledge$lambda$18$lambda$15;
                        askResponsePurchaseThenAcknowledge$lambda$18$lambda$15 = BillingRepository.askResponsePurchaseThenAcknowledge$lambda$18$lambda$15(BillingRepository.this, purchase, (ApiResponse) obj);
                        return askResponsePurchaseThenAcknowledge$lambda$18$lambda$15;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.d
                    public final Object invoke(Object obj) {
                        Unit askResponsePurchaseThenAcknowledge$lambda$18$lambda$16;
                        askResponsePurchaseThenAcknowledge$lambda$18$lambda$16 = BillingRepository.askResponsePurchaseThenAcknowledge$lambda$18$lambda$16(purchase, this, (Throwable) obj);
                        return askResponsePurchaseThenAcknowledge$lambda$18$lambda$16;
                    }
                }, new Function0() { // from class: com.qiahao.nextvideo.utilities.google.pay.e
                    public final Object invoke() {
                        Unit askResponsePurchaseThenAcknowledge$lambda$18$lambda$17;
                        askResponsePurchaseThenAcknowledge$lambda$18$lambda$17 = BillingRepository.askResponsePurchaseThenAcknowledge$lambda$18$lambda$17(BillingRepository.this);
                        return askResponsePurchaseThenAcknowledge$lambda$18$lambda$17;
                    }
                }, false, 8, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askResponsePurchaseThenAcknowledge$lambda$18$lambda$15(BillingRepository billingRepository, Purchase purchase, ApiResponse apiResponse) {
        long j;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        billingRepository.acknowledgePurchase(purchase);
        GooglePayConsumeListener googlePayConsumeListener = billingRepository.delegate;
        if (googlePayConsumeListener != null) {
            Long l = (Long) apiResponse.getData();
            if (l != null) {
                j = l.longValue();
            } else {
                j = 0;
            }
            googlePayConsumeListener.subSuccess(purchase, j);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askResponsePurchaseThenAcknowledge$lambda$18$lambda$16(Purchase purchase, BillingRepository billingRepository, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "承认订阅成功后 上报给后端报错了 purchaseToken:" + purchase.e() + "                    " + purchase.a() + " onError: " + th.getLocalizedMessage(), false, 4, (Object) null);
        if ((th instanceof HiloException) && ((HiloException) th).getCode() == 6000) {
            billingRepository.acknowledgePurchase(purchase);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit askResponsePurchaseThenAcknowledge$lambda$18$lambda$17(BillingRepository billingRepository) {
        GooglePayConsumeListener googlePayConsumeListener = billingRepository.delegate;
        if (googlePayConsumeListener != null) {
            googlePayConsumeListener.subTerminateSuccess();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectToPlayBillingService() {
        com.android.billingclient.api.g gVar;
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "connectToPlayBillingService", false, 4, (Object) null);
        com.android.billingclient.api.g gVar2 = this.playStoreBillingClient;
        if (gVar2 != null && !gVar2.g() && (gVar = this.playStoreBillingClient) != null) {
            gVar.p(this);
        }
    }

    private final void disburseConsumableEntitlements(Purchase purchase) {
        GooglePayConsumeListener googlePayConsumeListener = this.delegate;
        if (googlePayConsumeListener != null) {
            googlePayConsumeListener.consumeSuccess(purchase);
        }
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "disburseConsumableEntitlements for " + purchase + ".sku", false, 4, (Object) null);
    }

    private final void disburseNonConsumableEntitlement(Purchase purchase) {
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "disburseNonConsumableEntitlement for " + purchase + ".sku", false, 4, (Object) null);
    }

    private final ArrayList<j0.b> getSkuList() {
        return (ArrayList) this.skuList.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleServerVerifiedOrder$lambda$14(BillingRepository billingRepository, Purchase purchase, w wVar, String str) {
        Intrinsics.checkNotNullParameter(wVar, "billingResult");
        Intrinsics.checkNotNullParameter(str, "purchaseToken");
        if (wVar.b() == 0) {
            billingRepository.disburseConsumableEntitlements(purchase);
            return;
        }
        LogUtil logUtil = LogUtil.INSTANCE;
        String a = wVar.a();
        Intrinsics.checkNotNullExpressionValue(a, "getDebugMessage(...)");
        LogUtil.e$default(logUtil, TAG, a, false, 4, (Object) null);
    }

    private final void instantiateAndConnectToPlayBillingService() {
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "初始化Google结算服务instantiateAndConnectToPlayBillingService", false, 4, (Object) null);
        d0.a b = d0.c().b();
        Intrinsics.checkNotNullExpressionValue(b, "enableOneTimeProducts(...)");
        this.playStoreBillingClient = com.android.billingclient.api.g.i(this.context).b(b.a()).c(this).a();
        connectToPlayBillingService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isConsumable(Purchase purchase) {
        boolean z = false;
        for (String str : purchase.c()) {
            for (j0.b bVar : getSkuList()) {
                if (Intrinsics.areEqual(bVar.b(), str) && Intrinsics.areEqual(bVar.c(), "inapp")) {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isSignatureValid(Purchase purchase) {
        Security security = Security.INSTANCE;
        String base_64_encoded_public_key = security.getBASE_64_ENCODED_PUBLIC_KEY();
        String b = purchase.b();
        Intrinsics.checkNotNullExpressionValue(b, "getOriginalJson(...)");
        String f = purchase.f();
        Intrinsics.checkNotNullExpressionValue(f, "getSignature(...)");
        return security.verifyPurchase(base_64_encoded_public_key, b, f);
    }

    private final boolean isSubscriptionSupported() {
        w wVar;
        Integer num;
        com.android.billingclient.api.g gVar = this.playStoreBillingClient;
        String str = null;
        if (gVar != null) {
            wVar = gVar.f("subscriptions");
        } else {
            wVar = null;
        }
        if (wVar != null) {
            num = Integer.valueOf(wVar.b());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == -1) {
            connectToPlayBillingService();
        } else {
            if (num != null && num.intValue() == 0) {
                return true;
            }
            LogUtil logUtil = LogUtil.INSTANCE;
            if (wVar != null) {
                str = wVar.a();
            }
            LogUtil.e$default(logUtil, TAG, "isSubscriptionSupported() error:" + str, false, 4, (Object) null);
        }
        return false;
    }

    public static /* synthetic */ void launchBillingFollow$default(BillingRepository billingRepository, Activity activity, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "inapp";
        }
        billingRepository.launchBillingFollow(activity, str, str2);
    }

    private final void launchBillingFollow2(Activity activity, e0 skuDetails, String skuType) {
        String externalId;
        String str;
        e0.e eVar;
        v.b.a c = v.b.a().c(skuDetails);
        String str2 = "";
        if (Intrinsics.areEqual(skuType, "subs")) {
            List d = skuDetails.d();
            if (d == null || (eVar = (e0.e) d.get(0)) == null || (str = eVar.a()) == null) {
                str = "";
            }
            c.b(str);
        }
        v.a c2 = com.android.billingclient.api.v.a().c(CollectionsKt.listOf(c.a()));
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (externalId = user.getExternalId()) != null) {
            str2 = externalId;
        }
        com.android.billingclient.api.v a = c2.b(str2).a();
        Intrinsics.checkNotNullExpressionValue(a, "build(...)");
        com.android.billingclient.api.g gVar = this.playStoreBillingClient;
        if (gVar != null) {
            gVar.h(activity, a);
        }
    }

    static /* synthetic */ void launchBillingFollow2$default(BillingRepository billingRepository, Activity activity, e0 e0Var, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "inapp";
        }
        billingRepository.launchBillingFollow2(activity, e0Var, str);
    }

    private final void processPurchases(Set<? extends Purchase> purchasesResult) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(JobKt.Job$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO())), (CoroutineContext) null, (CoroutineStart) null, new BillingRepository$processPurchases$1(purchasesResult, this, null), 3, (Object) null);
    }

    private final void queryPurchasesAsync() {
        com.android.billingclient.api.g gVar;
        com.android.billingclient.api.g gVar2 = this.playStoreBillingClient;
        if (gVar2 != null) {
            gVar2.m(l0.a().b("inapp").a(), new h0() { // from class: com.qiahao.nextvideo.utilities.google.pay.f
                public final void a(w wVar, List list) {
                    BillingRepository.queryPurchasesAsync$lambda$10(BillingRepository.this, wVar, list);
                }
            });
        }
        if (isSubscriptionSupported() && (gVar = this.playStoreBillingClient) != null) {
            gVar.m(l0.a().b("subs").a(), new h0() { // from class: com.qiahao.nextvideo.utilities.google.pay.g
                public final void a(w wVar, List list) {
                    BillingRepository.queryPurchasesAsync$lambda$11(BillingRepository.this, wVar, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchasesAsync$lambda$10(BillingRepository billingRepository, w wVar, List list) {
        Intrinsics.checkNotNullParameter(wVar, "result");
        Intrinsics.checkNotNullParameter(list, "purchases");
        if (wVar.b() == 0) {
            LogUtil.e$default(LogUtil.INSTANCE, TAG, "queryPurchasesAsync INAPP results: " + list.size(), false, 4, (Object) null);
            billingRepository.processPurchases(CollectionsKt.toSet(list));
            return;
        }
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "Problem getting purchases: " + wVar.a(), false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryPurchasesAsync$lambda$11(BillingRepository billingRepository, w wVar, List list) {
        Intrinsics.checkNotNullParameter(wVar, "result");
        Intrinsics.checkNotNullParameter(list, "purchases");
        if (wVar.b() == 0) {
            LogUtil.e$default(LogUtil.INSTANCE, TAG, "queryPurchasesAsync SUBS results: " + list.size(), false, 4, (Object) null);
            billingRepository.processPurchases(CollectionsKt.toSet(list));
            return;
        }
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "Problem getting purchases: " + wVar.a(), false, 4, (Object) null);
    }

    private final void querySkuDetailAsync(final String skuType, List<j0.b> skuList) {
        j0 a = j0.a().b(skuList).a();
        Intrinsics.checkNotNullExpressionValue(a, "build(...)");
        com.android.billingclient.api.g gVar = this.playStoreBillingClient;
        if (gVar != null) {
            gVar.j(a, new f0() { // from class: com.qiahao.nextvideo.utilities.google.pay.c
                public final void a(w wVar, List list) {
                    BillingRepository.querySkuDetailAsync$lambda$9(skuType, this, wVar, list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void querySkuDetailAsync$lambda$9(String str, final BillingRepository billingRepository, w wVar, List list) {
        Intrinsics.checkNotNullParameter(wVar, "billingResult");
        Intrinsics.checkNotNullParameter(list, "queryProductDetailsResult");
        if (wVar.b() == 0) {
            if (!list.isEmpty()) {
                if (StringsKt.contains$default("inapp", str, false, 2, (Object) null)) {
                    billingRepository.skuDetailsList = list;
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.google.pay.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            BillingRepository.querySkuDetailAsync$lambda$9$lambda$8$lambda$6(BillingRepository.this);
                        }
                    });
                    return;
                } else if (StringsKt.contains$default("subs", str, false, 2, (Object) null)) {
                    billingRepository.skuSubsDetailsList = list;
                    HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.google.pay.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            BillingRepository.querySkuDetailAsync$lambda$9$lambda$8$lambda$7(BillingRepository.this);
                        }
                    });
                    return;
                } else {
                    GooglePayConsumeListener googlePayConsumeListener = billingRepository.delegate;
                    if (googlePayConsumeListener != null) {
                        googlePayConsumeListener.querySkuDetailAsyncDidFailure();
                        return;
                    }
                    return;
                }
            }
            return;
        }
        GooglePayConsumeListener googlePayConsumeListener2 = billingRepository.delegate;
        if (googlePayConsumeListener2 != null) {
            googlePayConsumeListener2.querySkuDetailAsyncDidFailure();
        }
        LogUtil logUtil = LogUtil.INSTANCE;
        String a = wVar.a();
        Intrinsics.checkNotNullExpressionValue(a, "getDebugMessage(...)");
        LogUtil.e$default(logUtil, TAG, a, false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void querySkuDetailAsync$lambda$9$lambda$8$lambda$6(BillingRepository billingRepository) {
        GooglePayConsumeListener googlePayConsumeListener = billingRepository.delegate;
        if (googlePayConsumeListener != null) {
            googlePayConsumeListener.onInitSKUListSuccess(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void querySkuDetailAsync$lambda$9$lambda$8$lambda$7(BillingRepository billingRepository) {
        GooglePayConsumeListener googlePayConsumeListener = billingRepository.delegate;
        if (googlePayConsumeListener != null) {
            googlePayConsumeListener.onInitSKUListSuccess(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList skuList_delegate$lambda$2() {
        ArrayList arrayList = new ArrayList();
        String str = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "DiamondsKey", "", (String) null, 4, (Object) null);
        if (!TextUtils.isEmpty(str)) {
            ArrayList<PurchaseDiamondDetail> buyList = ((PurchaseGem) BaseApplication.Companion.getGSON().k(str, new TypeToken<PurchaseGem>() { // from class: com.qiahao.nextvideo.utilities.google.pay.BillingRepository$skuList$2$typeToken$1
            }.getType())).getBuyList();
            if (buyList != null) {
                for (PurchaseDiamondDetail purchaseDiamondDetail : buyList) {
                    j0.b.a a = j0.b.a();
                    Intrinsics.checkNotNullExpressionValue(a, "newBuilder(...)");
                    a.b(purchaseDiamondDetail.getProductID());
                    a.c("inapp");
                    arrayList.add(a.a());
                }
            }
        }
        String str2 = (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "GEM_LIST_KEY", "", (String) null, 4, (Object) null);
        if (!TextUtils.isEmpty(str)) {
            ArrayList<PurchaseDiamondDetail> buyList2 = ((PurchaseGem) BaseApplication.Companion.getGSON().k(str2, new TypeToken<PurchaseGem>() { // from class: com.qiahao.nextvideo.utilities.google.pay.BillingRepository$skuList$2$typeToken$2
            }.getType())).getBuyList();
            if (buyList2 != null) {
                for (PurchaseDiamondDetail purchaseDiamondDetail2 : buyList2) {
                    j0.b.a a2 = j0.b.a();
                    Intrinsics.checkNotNullExpressionValue(a2, "newBuilder(...)");
                    a2.b(purchaseDiamondDetail2.getProductID());
                    a2.c("inapp");
                    arrayList.add(a2.a());
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final GooglePayConsumeListener getDelegate() {
        return this.delegate;
    }

    @Nullable
    public final List<e0> getSkuDetailsList() {
        return this.skuDetailsList;
    }

    @NotNull
    public final List<j0.b> getSkuSubList() {
        return this.skuSubList;
    }

    @Nullable
    public final List<e0> getSkuSubsDetailsList() {
        return this.skuSubsDetailsList;
    }

    public final void handleServerVerifiedOrder(@NotNull final Purchase consumable) {
        Intrinsics.checkNotNullParameter(consumable, "consumable");
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "handleConsumablePurchasesAsync it is " + consumable, false, 4, (Object) null);
        x a = x.b().b(consumable.e()).a();
        Intrinsics.checkNotNullExpressionValue(a, "build(...)");
        com.android.billingclient.api.g gVar = this.playStoreBillingClient;
        if (gVar != null) {
            gVar.b(a, new y() { // from class: com.qiahao.nextvideo.utilities.google.pay.h
                public final void a(w wVar, String str) {
                    BillingRepository.handleServerVerifiedOrder$lambda$14(BillingRepository.this, consumable, wVar, str);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void launchBillingFollow(@NotNull Activity activity, @NotNull String productId, @NotNull String skuType) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(skuType, "skuType");
        e0 e0Var = null;
        if (Intrinsics.areEqual(skuType, "inapp")) {
            List<e0> list = this.skuDetailsList;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (Intrinsics.areEqual(productId, ((e0) next).b())) {
                        e0Var = next;
                        break;
                    }
                }
                e0Var = e0Var;
            }
            if (e0Var != null) {
                launchBillingFollow2(activity, e0Var, skuType);
                return;
            }
            GooglePayConsumeListener googlePayConsumeListener = this.delegate;
            if (googlePayConsumeListener != null) {
                googlePayConsumeListener.querySkuDetailAsyncDidFailure();
            }
            GooglePayConsumeListener googlePayConsumeListener2 = this.delegate;
            if (googlePayConsumeListener2 != null) {
                googlePayConsumeListener2.showUnChargeGoogleToast();
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(skuType, "subs")) {
            List<e0> list2 = this.skuSubsDetailsList;
            if (list2 != null) {
                Iterator<T> it2 = list2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next2 = it2.next();
                    if (Intrinsics.areEqual(productId, ((e0) next2).b())) {
                        e0Var = next2;
                        break;
                    }
                }
                e0Var = e0Var;
            }
            if (e0Var != null) {
                launchBillingFollow2(activity, e0Var, skuType);
                return;
            }
            GooglePayConsumeListener googlePayConsumeListener3 = this.delegate;
            if (googlePayConsumeListener3 != null) {
                googlePayConsumeListener3.querySkuDetailAsyncDidFailure();
            }
            GooglePayConsumeListener googlePayConsumeListener4 = this.delegate;
            if (googlePayConsumeListener4 != null) {
                googlePayConsumeListener4.showUnChargeGoogleToast();
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void onBillingServiceDisconnected() {
        GooglePayConsumeListener googlePayConsumeListener = this.delegate;
        if (googlePayConsumeListener != null) {
            w a = w.c().c(-1).b("BillingResponseCode.SERVICE_DISCONNECTED").a();
            Intrinsics.checkNotNullExpressionValue(a, "build(...)");
            googlePayConsumeListener.onBillingSetupFinishedDidFailure(a);
        }
        HiloUtils.INSTANCE.runInMainThread(new Runnable() { // from class: com.qiahao.nextvideo.utilities.google.pay.l
            @Override // java.lang.Runnable
            public final void run() {
                BillingRepository.this.connectToPlayBillingService();
            }
        }, 500L);
    }

    public void onBillingSetupFinished(@NotNull w billingResult) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (billingResult.b() == 0) {
            LogUtil.e$default(LogUtil.INSTANCE, TAG, "onBillingSetupFinished successfully", false, 4, (Object) null);
            querySkuDetailAsync("inapp", getSkuList());
            querySkuDetailAsync("subs", this.skuSubList);
            queryPurchasesAsync();
            return;
        }
        LogUtil.e$default(LogUtil.INSTANCE, TAG, "onBillingSetupFinished false " + billingResult.b() + ", " + billingResult.a(), false, 4, (Object) null);
        GooglePayConsumeListener googlePayConsumeListener = this.delegate;
        if (googlePayConsumeListener != null) {
            googlePayConsumeListener.onBillingSetupFinishedDidFailure(billingResult);
        }
    }

    public void onPurchasesUpdated(@NotNull w billingResult, @Nullable List<Purchase> purchases) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        LogUtil logUtil = LogUtil.INSTANCE;
        LogUtil.e$default(logUtil, TAG, billingResult.b() + billingResult.a(), false, 4, (Object) null);
        int b = billingResult.b();
        if (b != -1) {
            if (b != 0) {
                if (b != 7) {
                    LogUtil.e$default(logUtil, TAG, "支付报错！！！！ " + billingResult.b() + "  " + billingResult.a(), false, 4, (Object) null);
                    GooglePayConsumeListener googlePayConsumeListener = this.delegate;
                    if (googlePayConsumeListener != null) {
                        googlePayConsumeListener.purchasesUpdatedDidFailure(billingResult);
                        return;
                    }
                    return;
                }
                queryPurchasesAsync();
                return;
            }
            GooglePayConsumeListener googlePayConsumeListener2 = this.delegate;
            if (googlePayConsumeListener2 != null) {
                googlePayConsumeListener2.startupPurchaseFlow();
            }
            if (purchases != null) {
                processPurchases(CollectionsKt.toSet(purchases));
                return;
            }
            return;
        }
        connectToPlayBillingService();
    }

    public final void release() {
        com.android.billingclient.api.g gVar = this.playStoreBillingClient;
        if (gVar != null) {
            gVar.d();
        }
        this.delegate = null;
    }

    public final void setDelegate(@Nullable GooglePayConsumeListener googlePayConsumeListener) {
        this.delegate = googlePayConsumeListener;
    }

    public final void setSkuDetailsList(@Nullable List<e0> list) {
        this.skuDetailsList = list;
    }

    public final void setSkuSubList(@NotNull List<j0.b> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.skuSubList = list;
    }

    public final void setSkuSubsDetailsList(@Nullable List<e0> list) {
        this.skuSubsDetailsList = list;
    }

    public final void startDataSourceConnections() {
        instantiateAndConnectToPlayBillingService();
    }
}
