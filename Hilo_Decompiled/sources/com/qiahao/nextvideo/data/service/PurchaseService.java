package com.qiahao.nextvideo.data.service;

import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.EarnDiamondBean;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.model.PurchaseGem;
import com.qiahao.nextvideo.data.model.SurplusDiamonds;
import com.qiahao.nextvideo.data.model.UserDiamonds;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.task.RoomAndPersonalTaskFragment;
import com.qiahao.nextvideo.ui.videocall.VideoResultActivity;
import com.qiahao.nextvideo.utilities.NotificationKt;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.taobao.accs.common.Constants;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 H2\u00020\u0001:\u0001HB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\u0003J!\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00050\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J=\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00050\u00042\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018JO\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u00042\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u00122\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b \u0010!JI\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00050\u00042\b\b\u0002\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010%\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020\f¢\u0006\u0004\b(\u0010)J7\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00050\u00042\b\b\u0002\u0010\"\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\n¢\u0006\u0004\b-\u0010\u0003J\u0019\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00050\u0004¢\u0006\u0004\b/\u0010\tJ\u0019\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00050\u0004¢\u0006\u0004\b0\u0010\tJ\r\u00101\u001a\u00020\n¢\u0006\u0004\b1\u0010\u0003J9\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002040\u00060\u00050\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u0012¢\u0006\u0004\b5\u00106J#\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00050\u00042\b\b\u0002\u00107\u001a\u00020\u0012¢\u0006\u0004\b9\u0010:J+\u0010<\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u00042\u0006\u0010;\u001a\u00020\u00122\b\b\u0002\u00107\u001a\u00020\u0012¢\u0006\u0004\b<\u0010=J!\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0\u00050\u00042\u0006\u0010>\u001a\u00020\f¢\u0006\u0004\b@\u0010\u0010R$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/qiahao/nextvideo/data/service/PurchaseService;", "", "<init>", "()V", "Lio/reactivex/rxjava3/core/i0;", "Lcom/qiahao/base_common/network/model/ApiResponse;", "", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "fetchPurchaseVipList", "()Lio/reactivex/rxjava3/core/i0;", "", "syncPurchaseFeeDetails", "", "uid", "Lcom/qiahao/base_common/model/common/User;", "testPurchaseVip", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "toUID", "", "type", "originId", "originType", "Lcom/qiahao/nextvideo/data/model/SurplusDiamonds;", "userCostMessage", "(Ljava/lang/String;III)Lio/reactivex/rxjava3/core/i0;", "", "giftID", "sceneType", VideoResultActivity.VIDEO_MATCH_UNIQUE_ID, "giftNumber", "giftText", "Lcom/qiahao/base_common/model/common/ChannelEventGiftAddTime;", "sendGift", "(Ljava/lang/String;JILjava/lang/String;ILjava/lang/String;)Lio/reactivex/rxjava3/core/i0;", Constants.KEY_PACKAGE_NAME, "productID", "orderID", "purchaseToken", "buyType", "Lcom/qiahao/nextvideo/data/model/UserDiamonds;", "purchaseDiamonds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "purchaseOrderId", "subscribeVip", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/i0;", "updatePurchaseDiamondsList", "Lcom/qiahao/nextvideo/data/model/PurchaseGem;", "syncPurchaseDiamondDetails", "requestGemDetails", "updateGemDiamondsList", "pageIndex", "pageSize", "Lcom/qiahao/base_common/model/StoreBean;", "getStoreList", "(III)Lio/reactivex/rxjava3/core/i0;", RoomAndPersonalTaskFragment.TASK_TYPE, "Lcom/qiahao/nextvideo/data/model/EarnDiamondBean;", "getEarnDiamondTaskList", "(I)Lio/reactivex/rxjava3/core/i0;", "taskConfigId", "awardEarnDiamondTask", "(II)Lio/reactivex/rxjava3/core/i0;", "productId", "Lcom/qiahao/nextvideo/data/model/CheckChargeData;", "checkIsChargeUser", "Lcom/qiahao/nextvideo/data/model/PurchaseFeeDetailsX;", "purchaseFeeDetail", "Lcom/qiahao/nextvideo/data/model/PurchaseFeeDetailsX;", "getPurchaseFeeDetail", "()Lcom/qiahao/nextvideo/data/model/PurchaseFeeDetailsX;", "setPurchaseFeeDetail", "(Lcom/qiahao/nextvideo/data/model/PurchaseFeeDetailsX;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PurchaseService {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final PurchaseService shared = new PurchaseService();

    @Nullable
    private PurchaseFeeDetailsX purchaseFeeDetail;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/data/service/PurchaseService$Companion;", "", "<init>", "()V", "shared", "Lcom/qiahao/nextvideo/data/service/PurchaseService;", "getShared", "()Lcom/qiahao/nextvideo/data/service/PurchaseService;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PurchaseService getShared() {
            return PurchaseService.shared;
        }

        private Companion() {
        }
    }

    public PurchaseService() {
        try {
            this.purchaseFeeDetail = (PurchaseFeeDetailsX) BaseApplication.Companion.getGSON().j((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "kPurchaseFeeDetailsKey", "", (String) null, 4, (Object) null), PurchaseFeeDetailsX.class);
        } catch (com.google.gson.r unused) {
        }
    }

    public static /* synthetic */ i0 awardEarnDiamondTask$default(PurchaseService purchaseService, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return purchaseService.awardEarnDiamondTask(i, i2);
    }

    public static /* synthetic */ i0 getEarnDiamondTaskList$default(PurchaseService purchaseService, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return purchaseService.getEarnDiamondTaskList(i);
    }

    public static /* synthetic */ i0 getStoreList$default(PurchaseService purchaseService, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        return purchaseService.getStoreList(i, i2, i3);
    }

    public static /* synthetic */ i0 purchaseDiamonds$default(PurchaseService purchaseService, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = NotificationKt.NOTIFICATION_CHANNEL_ID;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str3 = null;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str5 = "";
        }
        return purchaseService.purchaseDiamonds(str6, str2, str7, str4, str5);
    }

    public static /* synthetic */ i0 sendGift$default(PurchaseService purchaseService, String str, long j, int i, String str2, int i2, String str3, int i3, Object obj) {
        int i4;
        String str4;
        if ((i3 & 4) != 0) {
            i4 = 1;
        } else {
            i4 = i;
        }
        if ((i3 & 32) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        return purchaseService.sendGift(str, j, i4, str2, i2, str4);
    }

    public static /* synthetic */ i0 subscribeVip$default(PurchaseService purchaseService, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = NotificationKt.NOTIFICATION_CHANNEL_ID;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return purchaseService.subscribeVip(str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncPurchaseFeeDetails$lambda$1(PurchaseService purchaseService, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        PurchaseFeeDetailsX purchaseFeeDetailsX = (PurchaseFeeDetailsX) apiResponse.getData();
        if (purchaseFeeDetailsX != null) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "kPurchaseFeeDetailsKey", BaseApplication.Companion.getGSON().s(purchaseFeeDetailsX), (String) null, 4, (Object) null);
            purchaseService.purchaseFeeDetail = purchaseFeeDetailsX;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit syncPurchaseFeeDetails$lambda$2(PurchaseService purchaseService, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        purchaseService.purchaseFeeDetail = (PurchaseFeeDetailsX) BaseApplication.Companion.getGSON().j((String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "kPurchaseFeeDetailsKey", "", (String) null, 4, (Object) null), PurchaseFeeDetailsX.class);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ i0 userCostMessage$default(PurchaseService purchaseService, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 11;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        return purchaseService.userCostMessage(str, i, i2, i3);
    }

    @NotNull
    public final i0<ApiResponse<ChannelEventGiftAddTime>> awardEarnDiamondTask(int taskConfigId, int taskType) {
        return AppServer.INSTANCE.getApis().awardEarnDiamondTask(taskConfigId, taskType);
    }

    @NotNull
    public final i0<ApiResponse<CheckChargeData>> checkIsChargeUser(@NotNull String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        return AppServer.INSTANCE.getApis().checkIsChargeUser(2, productId);
    }

    @NotNull
    public final i0<ApiResponse<List<PurchaseDiamondDetail>>> fetchPurchaseVipList() {
        return ServerApi.DefaultImpls.fetchVipDetail$default(AppServer.INSTANCE.getApis(), null, 1, null);
    }

    @NotNull
    public final i0<ApiResponse<EarnDiamondBean>> getEarnDiamondTaskList(int taskType) {
        return AppServer.INSTANCE.getApis().getEarnDiamondTaskList(taskType);
    }

    @Nullable
    public final PurchaseFeeDetailsX getPurchaseFeeDetail() {
        return this.purchaseFeeDetail;
    }

    @NotNull
    public final i0<ApiResponse<List<StoreBean>>> getStoreList(int type, int pageIndex, int pageSize) {
        if (type != 0) {
            if (type != 1) {
                return AppServer.INSTANCE.getApis().getPropertyList(pageIndex, pageSize);
            }
            return AppServer.INSTANCE.getApis().getHeadWearList(pageIndex, pageSize);
        }
        return AppServer.INSTANCE.getApis().getPropertyList(pageIndex, pageSize);
    }

    @NotNull
    public final i0<ApiResponse<UserDiamonds>> purchaseDiamonds(@NotNull String packageName, @NotNull String productID, @Nullable String orderID, @NotNull String purchaseToken, @NotNull String buyType) {
        Intrinsics.checkNotNullParameter(packageName, Constants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(productID, "productID");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        Intrinsics.checkNotNullParameter(buyType, "buyType");
        return ServerApi.DefaultImpls.buyDiamonds$default(AppServer.INSTANCE.getApis(), 0, packageName, productID, orderID, purchaseToken, buyType, 1, null);
    }

    @NotNull
    public final i0<ApiResponse<PurchaseGem>> requestGemDetails() {
        i0<ApiResponse<PurchaseGem>> j = AppServer.INSTANCE.getApis().fetchDiamondList("32").j(new pd.o() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$requestGemDetails$1
            public final ApiResponse<PurchaseGem> apply(ApiResponse<PurchaseGem> apiResponse) {
                ArrayList<PurchaseDiamondDetail> buyList;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                PurchaseGem purchaseGem = (PurchaseGem) apiResponse.getData();
                if (purchaseGem != null && (buyList = purchaseGem.getBuyList()) != null) {
                    Iterator<T> it = buyList.iterator();
                    while (it.hasNext()) {
                        ((PurchaseDiamondDetail) it.next()).setResId(2131231913);
                    }
                }
                return apiResponse;
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        return j;
    }

    @NotNull
    public final i0<ApiResponse<ChannelEventGiftAddTime>> sendGift(@NotNull String toUID, long giftID, int sceneType, @NotNull String matchUniqueID, int giftNumber, @Nullable String giftText) {
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        Intrinsics.checkNotNullParameter(matchUniqueID, VideoResultActivity.VIDEO_MATCH_UNIQUE_ID);
        return AppServer.INSTANCE.getApis().sendGift(toUID, giftID, sceneType, matchUniqueID, giftNumber, giftText);
    }

    public final void setPurchaseFeeDetail(@Nullable PurchaseFeeDetailsX purchaseFeeDetailsX) {
        this.purchaseFeeDetail = purchaseFeeDetailsX;
    }

    @NotNull
    public final i0<ApiResponse<Long>> subscribeVip(@NotNull String packageName, @NotNull String purchaseToken, @Nullable String purchaseOrderId) {
        Intrinsics.checkNotNullParameter(packageName, Constants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        return AppServer.INSTANCE.getApis().subscribeVip(packageName, BillingRepository.VIP_PRODUCT_ID, purchaseToken, purchaseOrderId);
    }

    @NotNull
    public final i0<ApiResponse<PurchaseGem>> syncPurchaseDiamondDetails() {
        return ServerApi.DefaultImpls.fetchDiamondList$default(AppServer.INSTANCE.getApis(), null, 1, null);
    }

    public final void syncPurchaseFeeDetails() {
        RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().fetchPurchaseFeeDetails(), new Function1() { // from class: com.qiahao.nextvideo.data.service.l
            public final Object invoke(Object obj) {
                Unit syncPurchaseFeeDetails$lambda$1;
                syncPurchaseFeeDetails$lambda$1 = PurchaseService.syncPurchaseFeeDetails$lambda$1(PurchaseService.this, (ApiResponse) obj);
                return syncPurchaseFeeDetails$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.data.service.m
            public final Object invoke(Object obj) {
                Unit syncPurchaseFeeDetails$lambda$2;
                syncPurchaseFeeDetails$lambda$2 = PurchaseService.syncPurchaseFeeDetails$lambda$2(PurchaseService.this, (Throwable) obj);
                return syncPurchaseFeeDetails$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null);
    }

    @NotNull
    public final i0<ApiResponse<User>> testPurchaseVip(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        return AppServer.INSTANCE.getApis().testPurchasePrivilege(uid);
    }

    public final void updateGemDiamondsList() {
        nd.c n = AppServer.INSTANCE.getApis().fetchDiamondList("32").j(new pd.o() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$updateGemDiamondsList$1
            public final ApiResponse<PurchaseGem> apply(ApiResponse<PurchaseGem> apiResponse) {
                ArrayList<PurchaseDiamondDetail> buyList;
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                PurchaseGem purchaseGem = (PurchaseGem) apiResponse.getData();
                if (purchaseGem != null && (buyList = purchaseGem.getBuyList()) != null) {
                    Iterator<T> it = buyList.iterator();
                    while (it.hasNext()) {
                        ((PurchaseDiamondDetail) it.next()).setResId(2131231913);
                    }
                }
                return apiResponse;
            }
        }).p(ke.a.b()).n(new pd.g() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$updateGemDiamondsList$2
            public final void accept(ApiResponse<PurchaseGem> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "GEM_LIST_KEY", BaseApplication.Companion.getGSON().s(apiResponse.getData()), (String) null, 4, (Object) null);
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$updateGemDiamondsList$3
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
            }
        });
        Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
        RxUtilsKt.addTo(n, new nd.a());
    }

    public final void updatePurchaseDiamondsList() {
        nd.c n = ServerApi.DefaultImpls.fetchDiamondList$default(AppServer.INSTANCE.getApis(), null, 1, null).p(ke.a.b()).n(new pd.g() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$updatePurchaseDiamondsList$1
            public final void accept(ApiResponse<PurchaseGem> apiResponse) {
                Intrinsics.checkNotNullParameter(apiResponse, "it");
                IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "DiamondsKey", BaseApplication.Companion.getGSON().s(apiResponse.getData()), (String) null, 4, (Object) null);
            }
        }, new pd.g() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$updatePurchaseDiamondsList$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "it");
            }
        });
        Intrinsics.checkNotNullExpressionValue(n, "subscribe(...)");
        RxUtilsKt.addTo(n, new nd.a());
    }

    @NotNull
    public final i0<ApiResponse<SurplusDiamonds>> userCostMessage(@NotNull String toUID, int type, int originId, int originType) {
        Intrinsics.checkNotNullParameter(toUID, "toUID");
        i0<ApiResponse<SurplusDiamonds>> j = AppServer.INSTANCE.getApis().userCostMessage(toUID, type, originType, originId).j(new pd.o() { // from class: com.qiahao.nextvideo.data.service.PurchaseService$userCostMessage$1
            public final ApiResponse<SurplusDiamonds> apply(ApiResponse<SurplusDiamonds> apiResponse) {
                UserSummaryInfo user;
                Intrinsics.checkNotNullParameter(apiResponse, "apiResponse");
                SurplusDiamonds surplusDiamonds = (SurplusDiamonds) apiResponse.getData();
                if (surplusDiamonds != null && (user = surplusDiamonds.getUser()) != null) {
                    UserStore.INSTANCE.getShared().getCreatedSessionEventRelay().accept(user);
                }
                return apiResponse;
            }
        });
        Intrinsics.checkNotNullExpressionValue(j, "map(...)");
        return j;
    }
}
