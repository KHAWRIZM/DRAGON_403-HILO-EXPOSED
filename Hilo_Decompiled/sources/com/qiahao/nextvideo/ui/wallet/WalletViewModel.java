package com.qiahao.nextvideo.ui.wallet;

import android.widget.Toast;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.billingclient.api.Purchase;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeData;
import com.qiahao.nextvideo.data.firstCharge.ListData;
import com.qiahao.nextvideo.data.model.BeanBaseBean;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.GoldBanner;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseGem;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.purchase.DiamondCellUIModel;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020;J\u0006\u0010<\u001a\u00020;J\u0006\u0010=\u001a\u00020;J\u000e\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\u0017J\u000e\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020;J\u0006\u00101\u001a\u00020;J\u000e\u0010@\u001a\u00020;2\u0006\u0010D\u001a\u00020\"J\u0006\u0010E\u001a\u00020;R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\rj\b\u0012\u0004\u0012\u00020\u0007`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u00060\t8F¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u001a\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0\u00060\t8F¢\u0006\u0006\u001a\u0004\b-\u0010\u000bR\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/0\t8F¢\u0006\u0006\u001a\u0004\b1\u0010\u000bR\u0014\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u0002030\t8F¢\u0006\u0006\u001a\u0004\b5\u0010\u000bR\u001c\u00106\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000208\u0018\u0001070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u00109\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000208\u0018\u0001070\t8F¢\u0006\u0006\u001a\u0004\b:\u0010\u000b¨\u0006G"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "diamondListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "diamondList", "Landroidx/lifecycle/LiveData;", "getDiamondList", "()Landroidx/lifecycle/LiveData;", "uiModels", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getUiModels", "()Ljava/util/ArrayList;", "selectUiModel", "getSelectUiModel", "()Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "setSelectUiModel", "(Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;)V", "mPurchase", "Lcom/android/billingclient/api/Purchase;", "getMPurchase", "()Lcom/android/billingclient/api/Purchase;", "setMPurchase", "(Lcom/android/billingclient/api/Purchase;)V", "isCharge", "", "()Z", "setCharge", "(Z)V", "selectData", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "getSelectData", "()Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "setSelectData", "(Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;)V", "goldListMutable", "goldList", "getGoldList", "goldBannerMutable", "Lcom/qiahao/nextvideo/data/model/GoldBanner;", "goldBanner", "getGoldBanner", "baseGoldMutable", "", "baseGold", "getBaseGold", "checkChargeMutable", "Lcom/qiahao/nextvideo/data/model/CheckChargeData;", "checkCharge", "getCheckCharge", "firstChargeMutable", "Lcom/qiahao/nextvideo/data/firstCharge/ListData;", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeData;", "firstCharge", "getFirstCharge", "", "refreshDiamond", "vipList", "purchaseDiamonds", "purchase", "checkWriteList", "position", "", "getGoldRechargeList", "data", "getFirstRechargeAward", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWalletViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WalletViewModel.kt\ncom/qiahao/nextvideo/ui/wallet/WalletViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,221:1\n1563#2:222\n1634#2,3:223\n*S KotlinDebug\n*F\n+ 1 WalletViewModel.kt\ncom/qiahao/nextvideo/ui/wallet/WalletViewModel\n*L\n80#1:222\n80#1:223,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletViewModel extends BaseViewModel {

    @NotNull
    public static final String CHECK_WRITE = "checkWrite";

    @NotNull
    public static final String PURCHASE_DIAMONDS_FAIL = "purchaseDiamondsFail";

    @NotNull
    public static final String PURCHASE_DIAMONDS_SUCCESS = "purchaseDiamondsSuccess";

    @NotNull
    public static final String VIP_LIST = "VIP_list";
    private boolean isCharge;

    @Nullable
    private Purchase mPurchase;

    @Nullable
    private PurchaseDiamondDetail selectData;

    @Nullable
    private DiamondCellUIModel selectUiModel;

    @NotNull
    private final MutableLiveData<List<DiamondCellUIModel>> diamondListMutable = new MutableLiveData<>();

    @NotNull
    private final ArrayList<DiamondCellUIModel> uiModels = new ArrayList<>();

    @NotNull
    private final MutableLiveData<List<PurchaseDiamondDetail>> goldListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<GoldBanner>> goldBannerMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<Double> baseGoldMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<CheckChargeData> checkChargeMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<ListData<FirstChargeData>> firstChargeMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$10(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        walletViewModel.getMSuccess().setValue(new Pair(CHECK_WRITE, apiResponse.getData()));
        walletViewModel.isCharge = false;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$11(WalletViewModel walletViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        walletViewModel.isCharge = false;
        walletViewModel.getMException().setValue(new Pair(CHECK_WRITE, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$19(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CheckChargeData checkChargeData = (CheckChargeData) apiResponse.getData();
        if (checkChargeData != null) {
            walletViewModel.checkChargeMutable.setValue(checkChargeData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkWriteList$lambda$20(WalletViewModel walletViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        walletViewModel.getMException().setValue(new Pair(CHECK_WRITE, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBaseGold$lambda$16(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        double d;
        String beanNum;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MutableLiveData<Double> mutableLiveData = walletViewModel.baseGoldMutable;
        BeanBaseBean beanBaseBean = (BeanBaseBean) apiResponse.getData();
        if (beanBaseBean != null && (beanNum = beanBaseBean.getBeanNum()) != null) {
            d = Double.parseDouble(beanNum);
        } else {
            d = 0.0d;
        }
        mutableLiveData.setValue(Double.valueOf(d));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBaseGold$lambda$17(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDiamondList$lambda$2(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PurchaseGem purchaseGem = (PurchaseGem) apiResponse.getData();
        if (purchaseGem != null) {
            walletViewModel.uiModels.clear();
            ArrayList<PurchaseDiamondDetail> buyList = purchaseGem.getBuyList();
            if (buyList != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(buyList, 10));
                Iterator<T> it = buyList.iterator();
                while (it.hasNext()) {
                    arrayList.add(Boolean.valueOf(walletViewModel.uiModels.add(DataExternalKt.toUIModel((PurchaseDiamondDetail) it.next(), R.drawable.icon_giftpanel_diamond_s))));
                }
            }
            walletViewModel.diamondListMutable.setValue(walletViewModel.uiModels);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getDiamondList$lambda$3(WalletViewModel walletViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(walletViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstRechargeAward$lambda$21(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        walletViewModel.firstChargeMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFirstRechargeAward$lambda$22(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGoldRechargeList$lambda$14(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        ArrayList<GoldBanner> banner;
        ArrayList<PurchaseDiamondDetail> buyList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PurchaseGem purchaseGem = (PurchaseGem) apiResponse.getData();
        if (purchaseGem != null && (buyList = purchaseGem.getBuyList()) != null) {
            walletViewModel.goldListMutable.setValue(buyList);
        }
        PurchaseGem purchaseGem2 = (PurchaseGem) apiResponse.getData();
        if (purchaseGem2 != null && (banner = purchaseGem2.getBanner()) != null) {
            walletViewModel.goldBannerMutable.setValue(banner);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGoldRechargeList$lambda$15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseDiamonds$lambda$8(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        walletViewModel.getMSuccess().setValue(new Pair(PURCHASE_DIAMONDS_SUCCESS, apiResponse.getData()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit purchaseDiamonds$lambda$9(WalletViewModel walletViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        walletViewModel.getMException().setValue(new Pair(PURCHASE_DIAMONDS_FAIL, th));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipList$lambda$6(WalletViewModel walletViewModel, ApiResponse apiResponse) {
        PurchaseDiamondDetail purchaseDiamondDetail;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            ma.b mSuccess = walletViewModel.getMSuccess();
            List list = (List) apiResponse.getData();
            if (list != null) {
                purchaseDiamondDetail = (PurchaseDiamondDetail) list.get(0);
            } else {
                purchaseDiamondDetail = null;
            }
            mSuccess.setValue(new Pair(VIP_LIST, purchaseDiamondDetail));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit vipList$lambda$7(WalletViewModel walletViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(walletViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public final void checkWriteList(int position) {
        String str;
        if (this.isCharge) {
            return;
        }
        this.isCharge = true;
        this.selectUiModel = this.uiModels.get(position);
        PurchaseService shared = PurchaseService.INSTANCE.getShared();
        DiamondCellUIModel diamondCellUIModel = this.selectUiModel;
        if (diamondCellUIModel == null || (str = diamondCellUIModel.getProductID()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.checkIsChargeUser(str), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.k1
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$10;
                checkWriteList$lambda$10 = WalletViewModel.checkWriteList$lambda$10(WalletViewModel.this, (ApiResponse) obj);
                return checkWriteList$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.t1
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$11;
                checkWriteList$lambda$11 = WalletViewModel.checkWriteList$lambda$11(WalletViewModel.this, (Throwable) obj);
                return checkWriteList$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<Double> getBaseGold() {
        return this.baseGoldMutable;
    }

    @NotNull
    public final LiveData<CheckChargeData> getCheckCharge() {
        return this.checkChargeMutable;
    }

    @NotNull
    public final LiveData<List<DiamondCellUIModel>> getDiamondList() {
        return this.diamondListMutable;
    }

    @NotNull
    public final LiveData<ListData<FirstChargeData>> getFirstCharge() {
        return this.firstChargeMutable;
    }

    public final void getFirstRechargeAward() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().firstRechargeCard(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.p1
            public final Object invoke(Object obj) {
                Unit firstRechargeAward$lambda$21;
                firstRechargeAward$lambda$21 = WalletViewModel.getFirstRechargeAward$lambda$21(WalletViewModel.this, (ApiResponse) obj);
                return firstRechargeAward$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.q1
            public final Object invoke(Object obj) {
                Unit firstRechargeAward$lambda$22;
                firstRechargeAward$lambda$22 = WalletViewModel.getFirstRechargeAward$lambda$22((Throwable) obj);
                return firstRechargeAward$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<GoldBanner>> getGoldBanner() {
        return this.goldBannerMutable;
    }

    @NotNull
    public final LiveData<List<PurchaseDiamondDetail>> getGoldList() {
        return this.goldListMutable;
    }

    public final void getGoldRechargeList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().requestGemDetails(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.l1
            public final Object invoke(Object obj) {
                Unit goldRechargeList$lambda$14;
                goldRechargeList$lambda$14 = WalletViewModel.getGoldRechargeList$lambda$14(WalletViewModel.this, (ApiResponse) obj);
                return goldRechargeList$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.m1
            public final Object invoke(Object obj) {
                Unit goldRechargeList$lambda$15;
                goldRechargeList$lambda$15 = WalletViewModel.getGoldRechargeList$lambda$15((Throwable) obj);
                return goldRechargeList$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @Nullable
    public final Purchase getMPurchase() {
        return this.mPurchase;
    }

    @Nullable
    public final PurchaseDiamondDetail getSelectData() {
        return this.selectData;
    }

    @Nullable
    public final DiamondCellUIModel getSelectUiModel() {
        return this.selectUiModel;
    }

    @NotNull
    public final ArrayList<DiamondCellUIModel> getUiModels() {
        return this.uiModels;
    }

    /* renamed from: isCharge, reason: from getter */
    public final boolean getIsCharge() {
        return this.isCharge;
    }

    public final void purchaseDiamonds(@NotNull Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        this.mPurchase = purchase;
        PurchaseService shared = PurchaseService.INSTANCE.getShared();
        String e = purchase.e();
        Intrinsics.checkNotNullExpressionValue(e, "getPurchaseToken(...)");
        String a = purchase.a();
        Object obj = purchase.c().get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.purchaseDiamonds$default(shared, null, (String) obj, a, e, null, 17, null), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.r1
            public final Object invoke(Object obj2) {
                Unit purchaseDiamonds$lambda$8;
                purchaseDiamonds$lambda$8 = WalletViewModel.purchaseDiamonds$lambda$8(WalletViewModel.this, (ApiResponse) obj2);
                return purchaseDiamonds$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.s1
            public final Object invoke(Object obj2) {
                Unit purchaseDiamonds$lambda$9;
                purchaseDiamonds$lambda$9 = WalletViewModel.purchaseDiamonds$lambda$9(WalletViewModel.this, (Throwable) obj2);
                return purchaseDiamonds$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void refreshDiamond() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDiamond(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.a2
            public final Object invoke(Object obj) {
                Unit refreshDiamond$lambda$4;
                refreshDiamond$lambda$4 = WalletViewModel.refreshDiamond$lambda$4((ApiResponse) obj);
                return refreshDiamond$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.b2
            public final Object invoke(Object obj) {
                Unit refreshDiamond$lambda$5;
                refreshDiamond$lambda$5 = WalletViewModel.refreshDiamond$lambda$5((Throwable) obj);
                return refreshDiamond$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setCharge(boolean z) {
        this.isCharge = z;
    }

    public final void setMPurchase(@Nullable Purchase purchase) {
        this.mPurchase = purchase;
    }

    public final void setSelectData(@Nullable PurchaseDiamondDetail purchaseDiamondDetail) {
        this.selectData = purchaseDiamondDetail;
    }

    public final void setSelectUiModel(@Nullable DiamondCellUIModel diamondCellUIModel) {
        this.selectUiModel = diamondCellUIModel;
    }

    public final void vipList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().fetchPurchaseVipList(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.y1
            public final Object invoke(Object obj) {
                Unit vipList$lambda$6;
                vipList$lambda$6 = WalletViewModel.vipList$lambda$6(WalletViewModel.this, (ApiResponse) obj);
                return vipList$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.z1
            public final Object invoke(Object obj) {
                Unit vipList$lambda$7;
                vipList$lambda$7 = WalletViewModel.vipList$lambda$7(WalletViewModel.this, (Throwable) obj);
                return vipList$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getBaseGold, reason: collision with other method in class */
    public final void m٩٥getBaseGold() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getBeanBase(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.u1
            public final Object invoke(Object obj) {
                Unit baseGold$lambda$16;
                baseGold$lambda$16 = WalletViewModel.getBaseGold$lambda$16(WalletViewModel.this, (ApiResponse) obj);
                return baseGold$lambda$16;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.v1
            public final Object invoke(Object obj) {
                Unit baseGold$lambda$17;
                baseGold$lambda$17 = WalletViewModel.getBaseGold$lambda$17((Throwable) obj);
                return baseGold$lambda$17;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getDiamondList, reason: collision with other method in class */
    public final void m٩٦getDiamondList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().syncPurchaseDiamondDetails(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.w1
            public final Object invoke(Object obj) {
                Unit diamondList$lambda$2;
                diamondList$lambda$2 = WalletViewModel.getDiamondList$lambda$2(WalletViewModel.this, (ApiResponse) obj);
                return diamondList$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.x1
            public final Object invoke(Object obj) {
                Unit diamondList$lambda$3;
                diamondList$lambda$3 = WalletViewModel.getDiamondList$lambda$3(WalletViewModel.this, (Throwable) obj);
                return diamondList$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void checkWriteList(@NotNull PurchaseDiamondDetail data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.selectData = data;
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().checkIsChargeUser(data.getProductID()), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.n1
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$19;
                checkWriteList$lambda$19 = WalletViewModel.checkWriteList$lambda$19(WalletViewModel.this, (ApiResponse) obj);
                return checkWriteList$lambda$19;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.o1
            public final Object invoke(Object obj) {
                Unit checkWriteList$lambda$20;
                checkWriteList$lambda$20 = WalletViewModel.checkWriteList$lambda$20(WalletViewModel.this, (Throwable) obj);
                return checkWriteList$lambda$20;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
