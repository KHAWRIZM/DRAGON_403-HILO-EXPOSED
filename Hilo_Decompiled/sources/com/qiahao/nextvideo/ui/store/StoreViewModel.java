package com.qiahao.nextvideo.ui.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.CustomData;
import com.qiahao.base_common.model.DiamondBean;
import com.qiahao.base_common.model.RelationStoreData;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.store.StoreCarromData;
import com.qiahao.nextvideo.network.AppServer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020(J\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-J\u0006\u0010'\u001a\u00020(R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b0\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001c\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020%\u0018\u00010\u001b0\u001e8F¢\u0006\u0006\u001a\u0004\b'\u0010 ¨\u0006/"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "type", "", "getType", "()I", "setType", "(I)V", "carromType", "getCarromType", "setCarromType", "storeListData", "Lcom/qiahao/base_common/model/BaseListData;", "getStoreListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setStoreListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "relationStoreData", "Lcom/qiahao/base_common/model/RelationStoreData;", "getRelationStoreData", "()Lcom/qiahao/base_common/model/RelationStoreData;", "setRelationStoreData", "(Lcom/qiahao/base_common/model/RelationStoreData;)V", "storeListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/base_common/model/StoreBean;", "storeList", "Landroidx/lifecycle/LiveData;", "getStoreList", "()Landroidx/lifecycle/LiveData;", "carromListData", "getCarromListData", "setCarromListData", "carromListMutable", "Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "carromList", "getCarromList", "", "sendHeadOrMounts", "storeId", "", "extraId", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StoreViewModel extends BaseViewModel {

    @NotNull
    public static final String BUY_STORE = "BUY_STORE";

    @NotNull
    private BaseListData carromListData;

    @NotNull
    private final MutableLiveData<List<StoreCarromData>> carromListMutable;
    private int carromType = 1;

    @Nullable
    private RelationStoreData relationStoreData;

    @NotNull
    private BaseListData storeListData;

    @NotNull
    private final MutableLiveData<List<StoreBean>> storeListMutable;
    private int type;

    public StoreViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(12);
        this.storeListData = baseListData;
        this.storeListMutable = new MutableLiveData<>();
        BaseListData baseListData2 = new BaseListData();
        baseListData2.setPageSize(50);
        this.carromListData = baseListData2;
        this.carromListMutable = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCarromList$lambda$12(StoreViewModel storeViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseListData baseListData = storeViewModel.carromListData;
        CustomData customData = (CustomData) apiResponse.getData();
        List list2 = null;
        if (customData != null) {
            list = customData.getList();
        } else {
            list = null;
        }
        baseListData.setList(list);
        MutableLiveData<List<StoreCarromData>> mutableLiveData = storeViewModel.carromListMutable;
        CustomData customData2 = (CustomData) apiResponse.getData();
        if (customData2 != null) {
            list2 = customData2.getList();
        }
        mutableLiveData.setValue(list2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCarromList$lambda$13(StoreViewModel storeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        storeViewModel.carromListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStoreList$lambda$2(StoreViewModel storeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        storeViewModel.storeListData.setList((List) apiResponse.getData());
        storeViewModel.storeListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStoreList$lambda$3(StoreViewModel storeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        storeViewModel.storeListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStoreList$lambda$4(StoreViewModel storeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        storeViewModel.storeListData.setList((List) apiResponse.getData());
        storeViewModel.storeListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStoreList$lambda$5(StoreViewModel storeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        storeViewModel.storeListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStoreList$lambda$6(StoreViewModel storeViewModel, ApiResponse apiResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        storeViewModel.relationStoreData = (RelationStoreData) apiResponse.getData();
        BaseListData baseListData = storeViewModel.storeListData;
        RelationStoreData relationStoreData = (RelationStoreData) apiResponse.getData();
        ArrayList arrayList2 = null;
        if (relationStoreData != null) {
            arrayList = relationStoreData.getItems();
        } else {
            arrayList = null;
        }
        baseListData.setList(arrayList);
        MutableLiveData<List<StoreBean>> mutableLiveData = storeViewModel.storeListMutable;
        RelationStoreData relationStoreData2 = (RelationStoreData) apiResponse.getData();
        if (relationStoreData2 != null) {
            arrayList2 = relationStoreData2.getItems();
        }
        mutableLiveData.setValue(arrayList2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getStoreList$lambda$7(StoreViewModel storeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        storeViewModel.storeListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$10(String str, StoreViewModel storeViewModel, ApiResponse apiResponse) {
        Object obj;
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user == null || (obj = user.getExternalId()) == null) {
            obj = 0;
        }
        if (Intrinsics.areEqual(str, obj)) {
            UserStore.fetchUserDetailInfo$default(companion.getShared(), false, 1, null);
        } else {
            UserStore shared = companion.getShared();
            DiamondBean diamondBean = (DiamondBean) apiResponse.getData();
            if (diamondBean != null) {
                d = diamondBean.getDiamondNum();
            } else {
                d = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        }
        storeViewModel.getMSuccess().setValue(new Pair(BUY_STORE, Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$11(StoreViewModel storeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        storeViewModel.getMException().setValue(new Pair(BUY_STORE, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$8(String str, StoreViewModel storeViewModel, ApiResponse apiResponse) {
        Object obj;
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user == null || (obj = user.getExternalId()) == null) {
            obj = 0;
        }
        if (Intrinsics.areEqual(str, obj)) {
            UserStore.fetchUserDetailInfo$default(companion.getShared(), false, 1, null);
        } else {
            UserStore shared = companion.getShared();
            DiamondBean diamondBean = (DiamondBean) apiResponse.getData();
            if (diamondBean != null) {
                d = diamondBean.getDiamondNum();
            } else {
                d = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        }
        storeViewModel.getMSuccess().setValue(new Pair(BUY_STORE, Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$9(StoreViewModel storeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        storeViewModel.getMException().setValue(new Pair(BUY_STORE, th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<List<StoreCarromData>> getCarromList() {
        return this.carromListMutable;
    }

    @NotNull
    public final BaseListData getCarromListData() {
        return this.carromListData;
    }

    public final int getCarromType() {
        return this.carromType;
    }

    @Nullable
    public final RelationStoreData getRelationStoreData() {
        return this.relationStoreData;
    }

    @NotNull
    public final LiveData<List<StoreBean>> getStoreList() {
        return this.storeListMutable;
    }

    @NotNull
    public final BaseListData getStoreListData() {
        return this.storeListData;
    }

    public final int getType() {
        return this.type;
    }

    public final void sendHeadOrMounts(int type, long storeId, @NotNull final String extraId) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        if (type != 0) {
            if (type == 1) {
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().propertySendOrBuy(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.store.s2
                    public final Object invoke(Object obj) {
                        Unit sendHeadOrMounts$lambda$10;
                        sendHeadOrMounts$lambda$10 = StoreViewModel.sendHeadOrMounts$lambda$10(extraId, this, (ApiResponse) obj);
                        return sendHeadOrMounts$lambda$10;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.t2
                    public final Object invoke(Object obj) {
                        Unit sendHeadOrMounts$lambda$11;
                        sendHeadOrMounts$lambda$11 = StoreViewModel.sendHeadOrMounts$lambda$11(StoreViewModel.this, (Throwable) obj);
                        return sendHeadOrMounts$lambda$11;
                    }
                }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                return;
            }
            return;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().headWearSendOrBuy(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.store.q2
            public final Object invoke(Object obj) {
                Unit sendHeadOrMounts$lambda$8;
                sendHeadOrMounts$lambda$8 = StoreViewModel.sendHeadOrMounts$lambda$8(extraId, this, (ApiResponse) obj);
                return sendHeadOrMounts$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.r2
            public final Object invoke(Object obj) {
                Unit sendHeadOrMounts$lambda$9;
                sendHeadOrMounts$lambda$9 = StoreViewModel.sendHeadOrMounts$lambda$9(StoreViewModel.this, (Throwable) obj);
                return sendHeadOrMounts$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setCarromListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.carromListData = baseListData;
    }

    public final void setCarromType(int i) {
        this.carromType = i;
    }

    public final void setRelationStoreData(@Nullable RelationStoreData relationStoreData) {
        this.relationStoreData = relationStoreData;
    }

    public final void setStoreListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.storeListData = baseListData;
    }

    public final void setType(int i) {
        this.type = i;
    }

    /* renamed from: getCarromList, reason: collision with other method in class */
    public final void m٨٥getCarromList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().storeCarromSkin(41, this.carromType), new Function1() { // from class: com.qiahao.nextvideo.ui.store.j2
            public final Object invoke(Object obj) {
                Unit carromList$lambda$12;
                carromList$lambda$12 = StoreViewModel.getCarromList$lambda$12(StoreViewModel.this, (ApiResponse) obj);
                return carromList$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.k2
            public final Object invoke(Object obj) {
                Unit carromList$lambda$13;
                carromList$lambda$13 = StoreViewModel.getCarromList$lambda$13(StoreViewModel.this, (Throwable) obj);
                return carromList$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getStoreList, reason: collision with other method in class */
    public final void m٨٦getStoreList() {
        int i = this.type;
        if (i == 0) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getHeadWearList(this.storeListData.nextPage(), this.storeListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.m2
                public final Object invoke(Object obj) {
                    Unit storeList$lambda$4;
                    storeList$lambda$4 = StoreViewModel.getStoreList$lambda$4(StoreViewModel.this, (ApiResponse) obj);
                    return storeList$lambda$4;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.n2
                public final Object invoke(Object obj) {
                    Unit storeList$lambda$5;
                    storeList$lambda$5 = StoreViewModel.getStoreList$lambda$5(StoreViewModel.this, (Throwable) obj);
                    return storeList$lambda$5;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else if (i == 1) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPropertyList(this.storeListData.nextPage(), this.storeListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.i2
                public final Object invoke(Object obj) {
                    Unit storeList$lambda$2;
                    storeList$lambda$2 = StoreViewModel.getStoreList$lambda$2(StoreViewModel.this, (ApiResponse) obj);
                    return storeList$lambda$2;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.l2
                public final Object invoke(Object obj) {
                    Unit storeList$lambda$3;
                    storeList$lambda$3 = StoreViewModel.getStoreList$lambda$3(StoreViewModel.this, (Throwable) obj);
                    return storeList$lambda$3;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else {
            if (i != 3) {
                return;
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getRelationList(this.storeListData.nextPage(), this.storeListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.o2
                public final Object invoke(Object obj) {
                    Unit storeList$lambda$6;
                    storeList$lambda$6 = StoreViewModel.getStoreList$lambda$6(StoreViewModel.this, (ApiResponse) obj);
                    return storeList$lambda$6;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.p2
                public final Object invoke(Object obj) {
                    Unit storeList$lambda$7;
                    storeList$lambda$7 = StoreViewModel.getStoreList$lambda$7(StoreViewModel.this, (Throwable) obj);
                    return storeList$lambda$7;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }
}
