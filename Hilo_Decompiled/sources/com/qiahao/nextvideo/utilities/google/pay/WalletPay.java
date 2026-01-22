package com.qiahao.nextvideo.utilities.google.pay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.e0;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseGem;
import com.qiahao.nextvideo.data.model.UserDiamonds;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.purchase.DiamondCellUIModel;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ<\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J4\u0010\u0017\u001a\u00020\u00042%\b\u0002\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u0003R\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R6\u0010&\u001a\u0016\u0012\u0004\u0012\u00020$\u0018\u00010#j\n\u0012\u0004\u0012\u00020$\u0018\u0001`%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R?\u00103\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u0010\u0018R\u0014\u00109\u001a\u0002088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:¨\u0006;"}, d2 = {"Lcom/qiahao/nextvideo/utilities/google/pay/WalletPay;", "", "<init>", "()V", "", "getDiamondList", "refreshDiamond", "Lcom/android/billingclient/api/Purchase;", "purchase", "purchaseDiamonds", "(Lcom/android/billingclient/api/Purchase;)V", "", "productID", "checkWriteList", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "listener", "init", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "getProductPrice", "(Ljava/lang/String;)Ljava/lang/String;", "release", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "Lkotlin/collections/ArrayList;", "uiModels", "Ljava/util/ArrayList;", "getUiModels", "()Ljava/util/ArrayList;", "setUiModels", "(Ljava/util/ArrayList;)V", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "mBillingRepository", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "getMBillingRepository", "()Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "setMBillingRepository", "(Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;)V", "mListener", "Lkotlin/jvm/functions/Function1;", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "mGooglePayListener", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWalletPay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WalletPay.kt\ncom/qiahao/nextvideo/utilities/google/pay/WalletPay\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n1869#2:218\n295#2,2:219\n1870#2:221\n1563#2:222\n1634#2,3:223\n*S KotlinDebug\n*F\n+ 1 WalletPay.kt\ncom/qiahao/nextvideo/utilities/google/pay/WalletPay\n*L\n194#1:218\n195#1:219,2\n194#1:221\n85#1:222\n85#1:223,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletPay {

    @SuppressLint({"StaticFieldLeak"})
    @Nullable
    private static BillingRepository mBillingRepository;

    @Nullable
    private static Function1<? super String, Unit> mListener;

    @Nullable
    private static ArrayList<DiamondCellUIModel> uiModels;

    @NotNull
    public static final WalletPay INSTANCE = new WalletPay();

    @NotNull
    private static nd.a mCompositeDisposable = new nd.a();

    @NotNull
    private static final GooglePayConsumeListener mGooglePayListener = new WalletPay$mGooglePayListener$1();

    private WalletPay() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$11(String str, final ApiResponse apiResponse) {
        boolean z;
        BillingRepository billingRepository;
        String str2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CheckChargeData checkChargeData = (CheckChargeData) apiResponse.getData();
        if (checkChargeData != null) {
            z = Intrinsics.areEqual(checkChargeData.getInWhiteList(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z) {
            CheckChargeData checkChargeData2 = (CheckChargeData) apiResponse.getData();
            if (checkChargeData2 != null) {
                str2 = checkChargeData2.getChargeLink();
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                final Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
                if (currentActivity != null) {
                    TipDialog tipDialog = new TipDialog(currentActivity);
                    WalletPay walletPay = INSTANCE;
                    tipDialog.setTipContent(ResourcesKtxKt.getStringById(walletPay, 2131952204)).setConfirmContent(ResourcesKtxKt.getStringById(walletPay, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.utilities.google.pay.WalletPay$checkWriteList$1$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            String str3;
                            DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
                            Activity activity = currentActivity;
                            CheckChargeData checkChargeData3 = (CheckChargeData) apiResponse.getData();
                            if (checkChargeData3 == null || (str3 = checkChargeData3.getChargeLink()) == null) {
                                str3 = "";
                            }
                            DefaultWebActivity.Companion.start$default(companion, activity, str3, null, 4, null);
                        }
                    }).show();
                }
                return Unit.INSTANCE;
            }
        }
        Activity currentActivity2 = ActivityLifecycleManager.INSTANCE.currentActivity();
        if (currentActivity2 != null && (billingRepository = mBillingRepository) != null) {
            BillingRepository.launchBillingFollow$default(billingRepository, currentActivity2, str, null, 4, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$12(Throwable th) {
        HiloException hiloException;
        String stringById;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            if (th instanceof HiloException) {
                hiloException = (HiloException) th;
            } else {
                hiloException = null;
            }
            HiloToasty.Companion companion = HiloToasty.Companion;
            Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
            if (hiloException == null || (stringById = hiloException.getErrorMessage()) == null) {
                stringById = ResourcesKtxKt.getStringById(INSTANCE, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, stringById, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDiamondList$lambda$2(ApiResponse apiResponse) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PurchaseGem purchaseGem = (PurchaseGem) apiResponse.getData();
        if (purchaseGem != null) {
            ArrayList<DiamondCellUIModel> arrayList = new ArrayList<>();
            uiModels = arrayList;
            arrayList.clear();
            ArrayList<PurchaseDiamondDetail> buyList = purchaseGem.getBuyList();
            if (buyList != null) {
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(buyList, 10));
                Iterator<T> it = buyList.iterator();
                while (it.hasNext()) {
                    DiamondCellUIModel uIModel = DataExternalKt.toUIModel((PurchaseDiamondDetail) it.next(), R.drawable.icon_giftpanel_diamond_s);
                    ArrayList<DiamondCellUIModel> arrayList3 = uiModels;
                    if (arrayList3 != null) {
                        bool = Boolean.valueOf(arrayList3.add(uIModel));
                    } else {
                        bool = null;
                    }
                    arrayList2.add(bool);
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDiamondList$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$default(WalletPay walletPay, Context context, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        walletPay.init(context, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseDiamonds$lambda$7(Purchase purchase, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserDiamonds userDiamonds = (UserDiamonds) apiResponse.getData();
        if (userDiamonds != null) {
            UserStore.refreshDiamondOrGem$default(UserStore.INSTANCE.getShared(), userDiamonds.getUserDiamonds(), 0.0d, 2, null);
            cf.c.c().l(new EventBusKey("refresh_h5", (Object) null, 2, (DefaultConstructorMarker) null));
            BillingRepository billingRepository = mBillingRepository;
            if (billingRepository != null) {
                billingRepository.handleServerVerifiedOrder(purchase);
            }
            Function1<? super String, Unit> function1 = mListener;
            if (function1 != null) {
                Object obj = purchase.c().get(0);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                function1.invoke(obj);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseDiamonds$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Activity currentActivity = ActivityLifecycleManager.INSTANCE.currentActivity();
        String message = th.getMessage();
        if (message == null) {
            message = ResourcesKtxKt.getStringById(INSTANCE, 2131952667);
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, currentActivity, message, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDiamond$lambda$4(ApiResponse apiResponse) {
        Double d;
        double d2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Double d3 = null;
        if (user != null) {
            d = Double.valueOf(user.getDiamondNum());
        } else {
            d = null;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d3 = Double.valueOf(channelEventGiftAddTime.getDiamondNum());
        }
        if (!Intrinsics.areEqual(d, d3)) {
            UserStore shared = companion.getShared();
            ChannelEventGiftAddTime channelEventGiftAddTime2 = (ChannelEventGiftAddTime) apiResponse.getData();
            if (channelEventGiftAddTime2 != null) {
                d2 = channelEventGiftAddTime2.getDiamondNum();
            } else {
                d2 = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d2, 0.0d, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit refreshDiamond$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setListener$default(WalletPay walletPay, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        walletPay.setListener(function1);
    }

    public final void checkWriteList(@NotNull final String productID) {
        Intrinsics.checkNotNullParameter(productID, "productID");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().checkIsChargeUser(productID), new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.o
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$11;
                checkWriteList$lambda$11 = WalletPay.checkWriteList$lambda$11(productID, (ApiResponse) obj);
                return checkWriteList$lambda$11;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.p
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$12;
                checkWriteList$lambda$12 = WalletPay.checkWriteList$lambda$12((Throwable) obj);
                return checkWriteList$lambda$12;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void getDiamondList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().syncPurchaseDiamondDetails(), new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.m
            public final Object invoke(Object obj) {
                Unit diamondList$lambda$2;
                diamondList$lambda$2 = WalletPay.getDiamondList$lambda$2((ApiResponse) obj);
                return diamondList$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.n
            public final Object invoke(Object obj) {
                Unit diamondList$lambda$3;
                diamondList$lambda$3 = WalletPay.getDiamondList$lambda$3((Throwable) obj);
                return diamondList$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    @Nullable
    public final BillingRepository getMBillingRepository() {
        return mBillingRepository;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Nullable
    public final Function1<String, Unit> getMListener() {
        return mListener;
    }

    @Nullable
    public final String getProductPrice(@NotNull String productID) {
        List<e0> skuDetailsList;
        DiamondCellUIModel diamondCellUIModel;
        String a;
        Object obj;
        Intrinsics.checkNotNullParameter(productID, "productID");
        BillingRepository billingRepository = mBillingRepository;
        String str = null;
        if (billingRepository != null && (skuDetailsList = billingRepository.getSkuDetailsList()) != null) {
            for (e0 e0Var : skuDetailsList) {
                ArrayList<DiamondCellUIModel> arrayList = uiModels;
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((DiamondCellUIModel) obj).getProductID(), productID)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    diamondCellUIModel = (DiamondCellUIModel) obj;
                } else {
                    diamondCellUIModel = null;
                }
                if (Intrinsics.areEqual(e0Var.b(), productID)) {
                    e0.b a2 = e0Var.a();
                    if (a2 == null || (a = a2.a()) == null) {
                        if (diamondCellUIModel != null) {
                            str = diamondCellUIModel.getPrice();
                        }
                        return "USD " + str;
                    }
                    return a;
                }
            }
        }
        return null;
    }

    @Nullable
    public final ArrayList<DiamondCellUIModel> getUiModels() {
        return uiModels;
    }

    public final void init(@NotNull Context context, @Nullable Function1<? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        mListener = listener;
        BillingRepository billingRepository = new BillingRepository(context);
        billingRepository.setDelegate(mGooglePayListener);
        billingRepository.startDataSourceConnections();
        mBillingRepository = billingRepository;
    }

    public final void purchaseDiamonds(@NotNull final Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        PurchaseService shared = PurchaseService.INSTANCE.getShared();
        String e = purchase.e();
        Intrinsics.checkNotNullExpressionValue(e, "getPurchaseToken(...)");
        String a = purchase.a();
        Object obj = purchase.c().get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.purchaseDiamonds$default(shared, null, (String) obj, a, e, null, 17, null), new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.s
            public final Object invoke(Object obj2) {
                Unit purchaseDiamonds$lambda$7;
                purchaseDiamonds$lambda$7 = WalletPay.purchaseDiamonds$lambda$7(purchase, (ApiResponse) obj2);
                return purchaseDiamonds$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.t
            public final Object invoke(Object obj2) {
                Unit purchaseDiamonds$lambda$8;
                purchaseDiamonds$lambda$8 = WalletPay.purchaseDiamonds$lambda$8((Throwable) obj2);
                return purchaseDiamonds$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void refreshDiamond() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDiamond(), new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.q
            public final Object invoke(Object obj) {
                Unit refreshDiamond$lambda$4;
                refreshDiamond$lambda$4 = WalletPay.refreshDiamond$lambda$4((ApiResponse) obj);
                return refreshDiamond$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.utilities.google.pay.r
            public final Object invoke(Object obj) {
                Unit refreshDiamond$lambda$5;
                refreshDiamond$lambda$5 = WalletPay.refreshDiamond$lambda$5((Throwable) obj);
                return refreshDiamond$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), mCompositeDisposable);
    }

    public final void release() {
        uiModels = null;
        mCompositeDisposable.d();
        BillingRepository billingRepository = mBillingRepository;
        if (billingRepository != null) {
            billingRepository.release();
        }
        mBillingRepository = null;
        mListener = null;
    }

    public final void setListener(@Nullable Function1<? super String, Unit> listener) {
        mListener = listener;
    }

    public final void setMBillingRepository(@Nullable BillingRepository billingRepository) {
        mBillingRepository = billingRepository;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        mCompositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function1<? super String, Unit> function1) {
        mListener = function1;
    }

    public final void setUiModels(@Nullable ArrayList<DiamondCellUIModel> arrayList) {
        uiModels = arrayList;
    }
}
