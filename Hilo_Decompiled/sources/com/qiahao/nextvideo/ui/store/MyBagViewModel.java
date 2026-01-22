package com.qiahao.nextvideo.ui.store;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.CustomData;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.store.BagCarromData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\u000bJ\u000e\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u000bJ\u0016\u00102\u001a\u00020-2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0005J\u0006\u00106\u001a\u00020-J\u000e\u00107\u001a\u00020-2\u0006\u00101\u001a\u00020\u0011J\b\u00108\u001a\u00020-H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00180\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00180\u001a8F¢\u0006\u0006\u001a\u0004\b+\u0010\u001c¨\u0006:"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "mType", "", "getMType", "()Ljava/lang/String;", "setMType", "(Ljava/lang/String;)V", "mSelectData", "Lcom/qiahao/base_common/model/MyBagBean;", "getMSelectData", "()Lcom/qiahao/base_common/model/MyBagBean;", "setMSelectData", "(Lcom/qiahao/base_common/model/MyBagBean;)V", "mSelectCarrom", "Lcom/qiahao/nextvideo/data/store/BagCarromData;", "getMSelectCarrom", "()Lcom/qiahao/nextvideo/data/store/BagCarromData;", "setMSelectCarrom", "(Lcom/qiahao/nextvideo/data/store/BagCarromData;)V", "bagListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "bagList", "Landroidx/lifecycle/LiveData;", "getBagList", "()Landroidx/lifecycle/LiveData;", "carromType", "", "getCarromType", "()I", "setCarromType", "(I)V", "carromListData", "Lcom/qiahao/base_common/model/BaseListData;", "getCarromListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setCarromListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "carromListMutable", "carromList", "getCarromList", "getList", "", "useBagGoods", "myBagBean", "deleteBagGoods", "data", "sendBagGoods", "storeId", "", "extraId", "getBagCarromList", "useCarromSkill", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyBagViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyBagViewModel.kt\ncom/qiahao/nextvideo/ui/store/MyBagViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,196:1\n774#2:197\n865#2,2:198\n774#2:200\n865#2,2:201\n*S KotlinDebug\n*F\n+ 1 MyBagViewModel.kt\ncom/qiahao/nextvideo/ui/store/MyBagViewModel\n*L\n57#1:197\n57#1:198,2\n66#1:200\n66#1:201,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyBagViewModel extends BaseViewModel {

    @NotNull
    public static final String BAG_CARROM = "CARROM";

    @NotNull
    public static final String BAG_HEAD = "head";

    @NotNull
    public static final String BAG_HEAD_LIST = "head_list";

    @NotNull
    public static final String BAG_MOUNTS = "mounts";

    @NotNull
    public static final String BAG_MOUNTS_LIST = "mounts_list";

    @NotNull
    public static final String BAG_TYPE = "type";

    @NotNull
    private BaseListData carromListData;

    @NotNull
    private final MutableLiveData<List<BagCarromData>> carromListMutable;

    @Nullable
    private BagCarromData mSelectCarrom;

    @Nullable
    private MyBagBean mSelectData;

    @NotNull
    private String mType = BAG_HEAD;

    @NotNull
    private final MutableLiveData<List<MyBagBean>> bagListMutable = new MutableLiveData<>();
    private int carromType = 1;

    public MyBagViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(50);
        this.carromListData = baseListData;
        this.carromListMutable = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteBagGoods$lambda$11(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_HEAD, apiResponse));
        myBagViewModel.getList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteBagGoods$lambda$12(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_HEAD, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteBagGoods$lambda$13(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_MOUNTS, apiResponse));
        myBagViewModel.getList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteBagGoods$lambda$14(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_MOUNTS, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBagCarromList$lambda$19(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseListData baseListData = myBagViewModel.carromListData;
        CustomData customData = (CustomData) apiResponse.getData();
        List list2 = null;
        if (customData != null) {
            list = customData.getList();
        } else {
            list = null;
        }
        baseListData.setList(list);
        MutableLiveData<List<BagCarromData>> mutableLiveData = myBagViewModel.carromListMutable;
        CustomData customData2 = (CustomData) apiResponse.getData();
        if (customData2 != null) {
            list2 = customData2.getList();
        }
        mutableLiveData.setValue(list2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBagCarromList$lambda$20(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.carromListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$2(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MutableLiveData<List<MyBagBean>> mutableLiveData = myBagViewModel.bagListMutable;
        List list = (List) apiResponse.getData();
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                if (((MyBagBean) obj).getTimeLeft() > 0) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        mutableLiveData.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$3(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_HEAD_LIST, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$5(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MutableLiveData<List<MyBagBean>> mutableLiveData = myBagViewModel.bagListMutable;
        List list = (List) apiResponse.getData();
        if (list != null) {
            arrayList = new ArrayList();
            for (Object obj : list) {
                if (((MyBagBean) obj).getTimeLeft() > 0) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        mutableLiveData.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$6(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_MOUNTS_LIST, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGoods$lambda$15(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_HEAD, apiResponse));
        myBagViewModel.getList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGoods$lambda$16(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_HEAD, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGoods$lambda$17(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_MOUNTS, apiResponse));
        myBagViewModel.getList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendBagGoods$lambda$18(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_MOUNTS, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useBagGoods$lambda$10(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_MOUNTS, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useBagGoods$lambda$7(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.INSTANCE.getShared().fetchUserDetailInfo(true);
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_HEAD, apiResponse));
        myBagViewModel.getList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useBagGoods$lambda$8(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_HEAD, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useBagGoods$lambda$9(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.INSTANCE.getShared().fetchUserDetailInfo(true);
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_MOUNTS, apiResponse));
        myBagViewModel.getList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useCarromSkill$lambda$21(MyBagViewModel myBagViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        myBagViewModel.getMSuccess().setValue(new Pair(BAG_CARROM, apiResponse));
        myBagViewModel.getBagCarromList();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useCarromSkill$lambda$22(MyBagViewModel myBagViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        myBagViewModel.getMException().setValue(new Pair(BAG_CARROM, th));
        return Unit.INSTANCE;
    }

    public final void deleteBagGoods(@NotNull MyBagBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (Intrinsics.areEqual(this.mType, BAG_HEAD)) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().deleteHeadWear((int) data.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.t0
                public final Object invoke(Object obj) {
                    Unit deleteBagGoods$lambda$11;
                    deleteBagGoods$lambda$11 = MyBagViewModel.deleteBagGoods$lambda$11(MyBagViewModel.this, (ApiResponse) obj);
                    return deleteBagGoods$lambda$11;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.u0
                public final Object invoke(Object obj) {
                    Unit deleteBagGoods$lambda$12;
                    deleteBagGoods$lambda$12 = MyBagViewModel.deleteBagGoods$lambda$12(MyBagViewModel.this, (Throwable) obj);
                    return deleteBagGoods$lambda$12;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().deleteProperty((int) data.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.v0
                public final Object invoke(Object obj) {
                    Unit deleteBagGoods$lambda$13;
                    deleteBagGoods$lambda$13 = MyBagViewModel.deleteBagGoods$lambda$13(MyBagViewModel.this, (ApiResponse) obj);
                    return deleteBagGoods$lambda$13;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.w0
                public final Object invoke(Object obj) {
                    Unit deleteBagGoods$lambda$14;
                    deleteBagGoods$lambda$14 = MyBagViewModel.deleteBagGoods$lambda$14(MyBagViewModel.this, (Throwable) obj);
                    return deleteBagGoods$lambda$14;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }

    public final void getBagCarromList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().bagCarromSkin(41, this.carromType), new Function1() { // from class: com.qiahao.nextvideo.ui.store.h0
            public final Object invoke(Object obj) {
                Unit bagCarromList$lambda$19;
                bagCarromList$lambda$19 = MyBagViewModel.getBagCarromList$lambda$19(MyBagViewModel.this, (ApiResponse) obj);
                return bagCarromList$lambda$19;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.s0
            public final Object invoke(Object obj) {
                Unit bagCarromList$lambda$20;
                bagCarromList$lambda$20 = MyBagViewModel.getBagCarromList$lambda$20(MyBagViewModel.this, (Throwable) obj);
                return bagCarromList$lambda$20;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<MyBagBean>> getBagList() {
        return this.bagListMutable;
    }

    @NotNull
    public final LiveData<List<BagCarromData>> getCarromList() {
        return this.carromListMutable;
    }

    @NotNull
    public final BaseListData getCarromListData() {
        return this.carromListData;
    }

    public final int getCarromType() {
        return this.carromType;
    }

    public final void getList() {
        String str;
        if (Intrinsics.areEqual(this.mType, BAG_HEAD)) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getMyHeadWear(), new Function1() { // from class: com.qiahao.nextvideo.ui.store.i0
                public final Object invoke(Object obj) {
                    Unit list$lambda$2;
                    list$lambda$2 = MyBagViewModel.getList$lambda$2(MyBagViewModel.this, (ApiResponse) obj);
                    return list$lambda$2;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.j0
                public final Object invoke(Object obj) {
                    Unit list$lambda$3;
                    list$lambda$3 = MyBagViewModel.getList$lambda$3(MyBagViewModel.this, (Throwable) obj);
                    return list$lambda$3;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
            return;
        }
        UserService shared = UserService.INSTANCE.getShared();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getMyProperty(str), new Function1() { // from class: com.qiahao.nextvideo.ui.store.k0
            public final Object invoke(Object obj) {
                Unit list$lambda$5;
                list$lambda$5 = MyBagViewModel.getList$lambda$5(MyBagViewModel.this, (ApiResponse) obj);
                return list$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.l0
            public final Object invoke(Object obj) {
                Unit list$lambda$6;
                list$lambda$6 = MyBagViewModel.getList$lambda$6(MyBagViewModel.this, (Throwable) obj);
                return list$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @Nullable
    public final BagCarromData getMSelectCarrom() {
        return this.mSelectCarrom;
    }

    @Nullable
    public final MyBagBean getMSelectData() {
        return this.mSelectData;
    }

    @NotNull
    public final String getMType() {
        return this.mType;
    }

    protected void onCleared() {
        super.onCleared();
        this.carromListData.destroy();
    }

    public final void sendBagGoods(long storeId, @NotNull String extraId) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        if (Intrinsics.areEqual(this.mType, BAG_HEAD)) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().headWearSend(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.store.o0
                public final Object invoke(Object obj) {
                    Unit sendBagGoods$lambda$15;
                    sendBagGoods$lambda$15 = MyBagViewModel.sendBagGoods$lambda$15(MyBagViewModel.this, (ApiResponse) obj);
                    return sendBagGoods$lambda$15;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.p0
                public final Object invoke(Object obj) {
                    Unit sendBagGoods$lambda$16;
                    sendBagGoods$lambda$16 = MyBagViewModel.sendBagGoods$lambda$16(MyBagViewModel.this, (Throwable) obj);
                    return sendBagGoods$lambda$16;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().propertySend(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.store.q0
                public final Object invoke(Object obj) {
                    Unit sendBagGoods$lambda$17;
                    sendBagGoods$lambda$17 = MyBagViewModel.sendBagGoods$lambda$17(MyBagViewModel.this, (ApiResponse) obj);
                    return sendBagGoods$lambda$17;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.r0
                public final Object invoke(Object obj) {
                    Unit sendBagGoods$lambda$18;
                    sendBagGoods$lambda$18 = MyBagViewModel.sendBagGoods$lambda$18(MyBagViewModel.this, (Throwable) obj);
                    return sendBagGoods$lambda$18;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }

    public final void setCarromListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.carromListData = baseListData;
    }

    public final void setCarromType(int i) {
        this.carromType = i;
    }

    public final void setMSelectCarrom(@Nullable BagCarromData bagCarromData) {
        this.mSelectCarrom = bagCarromData;
    }

    public final void setMSelectData(@Nullable MyBagBean myBagBean) {
        this.mSelectData = myBagBean;
    }

    public final void setMType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mType = str;
    }

    public final void useBagGoods(@NotNull MyBagBean myBagBean) {
        Intrinsics.checkNotNullParameter(myBagBean, "myBagBean");
        if (Intrinsics.areEqual(this.mType, BAG_HEAD)) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().setHeadWearUsing(myBagBean.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.x0
                public final Object invoke(Object obj) {
                    Unit useBagGoods$lambda$7;
                    useBagGoods$lambda$7 = MyBagViewModel.useBagGoods$lambda$7(MyBagViewModel.this, (ApiResponse) obj);
                    return useBagGoods$lambda$7;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.y0
                public final Object invoke(Object obj) {
                    Unit useBagGoods$lambda$8;
                    useBagGoods$lambda$8 = MyBagViewModel.useBagGoods$lambda$8(MyBagViewModel.this, (Throwable) obj);
                    return useBagGoods$lambda$8;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().setPropertyUsing(myBagBean.getId()), new Function1() { // from class: com.qiahao.nextvideo.ui.store.z0
                public final Object invoke(Object obj) {
                    Unit useBagGoods$lambda$9;
                    useBagGoods$lambda$9 = MyBagViewModel.useBagGoods$lambda$9(MyBagViewModel.this, (ApiResponse) obj);
                    return useBagGoods$lambda$9;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.a1
                public final Object invoke(Object obj) {
                    Unit useBagGoods$lambda$10;
                    useBagGoods$lambda$10 = MyBagViewModel.useBagGoods$lambda$10(MyBagViewModel.this, (Throwable) obj);
                    return useBagGoods$lambda$10;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }

    public final void useCarromSkill(@NotNull BagCarromData data) {
        long j;
        Intrinsics.checkNotNullParameter(data, "data");
        ServerApi apis = AppServer.INSTANCE.getApis();
        Long resId = data.getResId();
        long j2 = 0;
        if (resId != null) {
            j = resId.longValue();
        } else {
            j = 0;
        }
        Long bagId = data.getBagId();
        if (bagId != null) {
            j2 = bagId.longValue();
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.useCarromSkin(j, j2), new Function1() { // from class: com.qiahao.nextvideo.ui.store.m0
            public final Object invoke(Object obj) {
                Unit useCarromSkill$lambda$21;
                useCarromSkill$lambda$21 = MyBagViewModel.useCarromSkill$lambda$21(MyBagViewModel.this, (ApiResponse) obj);
                return useCarromSkill$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.store.n0
            public final Object invoke(Object obj) {
                Unit useCarromSkill$lambda$22;
                useCarromSkill$lambda$22 = MyBagViewModel.useCarromSkill$lambda$22(MyBagViewModel.this, (Throwable) obj);
                return useCarromSkill$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
