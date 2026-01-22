package com.qiahao.nextvideo.ui.home.discover.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.ApiListData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.AllRankTop3Bean;
import com.qiahao.nextvideo.data.model.CountryTop3ContributeAllBean;
import com.qiahao.nextvideo.data.model.CpTop3Bean;
import com.qiahao.nextvideo.data.model.GiftWallBean;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.WeekPowerTop3Bean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 82\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200J\u0006\u0010\u0019\u001a\u000200J\u0006\u00102\u001a\u000200J\u0006\u00103\u001a\u000200J\u0006\u00104\u001a\u000200J\u0006\u00105\u001a\u000200J\u0006\u00106\u001a\u000200J\b\u00107\u001a\u000200H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u000e8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00120\u000e8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00120\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00120\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010R\u001c\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f0\u000e8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u0016\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u000e8F¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u0016\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0\u000e8F¢\u0006\u0006\u001a\u0004\b*\u0010\u0010R\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0\u000e8F¢\u0006\u0006\u001a\u0004\b.\u0010\u0010¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/viewModel/DiscoverViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "eventListData", "Lcom/qiahao/base_common/model/BaseListData;", "getEventListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setEventListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "top3CountryMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/CountryTop3ContributeAllBean;", "top3Country", "Landroidx/lifecycle/LiveData;", "getTop3Country", "()Landroidx/lifecycle/LiveData;", "giftWallMutable", "", "Lcom/qiahao/nextvideo/data/model/GiftWallBean;", "giftWall", "getGiftWall", "activityListMutable", "Lcom/qiahao/base_common/model/ActivityDetailData;", "activityList", "getActivityList", "top7CountryMutable", "Lcom/qiahao/base_common/model/common/Country;", "top7Country", "getTop7Country", "eventListMutable", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "eventList", "getEventList", "allRankMutable", "Lcom/qiahao/nextvideo/data/model/AllRankTop3Bean;", "allRank", "getAllRank", "powerRankMutable", "Lcom/qiahao/nextvideo/data/model/WeekPowerTop3Bean;", "powerRank", "getPowerRank", "cpRankMutable", "Lcom/qiahao/nextvideo/data/model/CpTop3Bean;", "cpRank", "getCpRank", "getTop3CountryUser", "", "getGiftWallList", "getTop7CountryUser", "getBannerListData", "getRankFlipperData", "getPowerRankFlipperData", "getTop3CpRank", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverViewModel extends BaseViewModel {

    @NotNull
    public static final String EVENT_LIST = "EVENT_LIST";

    @NotNull
    private BaseListData eventListData = new BaseListData();

    @NotNull
    private final MutableLiveData<CountryTop3ContributeAllBean> top3CountryMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<GiftWallBean>> giftWallMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<ActivityDetailData>> activityListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<Country>> top7CountryMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<ArrayList<GroupTopBannerBean>> eventListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<AllRankTop3Bean> allRankMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<WeekPowerTop3Bean> powerRankMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<CpTop3Bean> cpRankMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getActivityList$lambda$4(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MutableLiveData<List<ActivityDetailData>> mutableLiveData = discoverViewModel.activityListMutable;
        ApiListData apiListData = (ApiListData) apiResponse.getData();
        if (apiListData != null) {
            list = apiListData.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getActivityList$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBannerListData$lambda$10(DiscoverViewModel discoverViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        discoverViewModel.getMException().setValue(new Pair(EVENT_LIST, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getBannerListData$lambda$9(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        discoverViewModel.eventListData.setList((List) apiResponse.getData());
        discoverViewModel.eventListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGiftWallList$lambda$2(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        discoverViewModel.giftWallMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGiftWallList$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPowerRankFlipperData$lambda$15(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        try {
            WeekPowerTop3Bean weekPowerTop3Bean = (WeekPowerTop3Bean) apiResponse.getData();
            if (weekPowerTop3Bean != null) {
                MMKVToLocalCache.INSTANCE.savePopularPowerFlipperCache(weekPowerTop3Bean);
                discoverViewModel.powerRankMutable.setValue(weekPowerTop3Bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPowerRankFlipperData$lambda$16(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getRankFlipperData$lambda$12(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        AllRankTop3Bean allRankTop3Bean = (AllRankTop3Bean) apiResponse.getData();
        if (allRankTop3Bean != null) {
            MMKVToLocalCache.INSTANCE.savePopularRankFlipperCache(allRankTop3Bean);
            discoverViewModel.allRankMutable.setValue(allRankTop3Bean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getRankFlipperData$lambda$13(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop3CountryUser$lambda$0(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        discoverViewModel.top3CountryMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop3CountryUser$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop3CpRank$lambda$18(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CpTop3Bean cpTop3Bean = (CpTop3Bean) apiResponse.getData();
        if (cpTop3Bean != null) {
            MMKVToLocalCache.INSTANCE.saveCpTop3Cache(cpTop3Bean);
            discoverViewModel.cpRankMutable.setValue(cpTop3Bean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop3CpRank$lambda$19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop7CountryUser$lambda$7(DiscoverViewModel discoverViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<Country> list = (List) apiResponse.getData();
        if (list != null) {
            if (list.size() >= 7) {
                list = list.subList(0, 6);
            }
            MMKVToLocalCache.INSTANCE.saveDiscoverTop7CountryCache(list);
            discoverViewModel.top7CountryMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTop7CountryUser$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<List<ActivityDetailData>> getActivityList() {
        return this.activityListMutable;
    }

    @NotNull
    public final LiveData<AllRankTop3Bean> getAllRank() {
        return this.allRankMutable;
    }

    public final void getBannerListData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getDiscoverBannerList(this.eventListData.nextPage(), this.eventListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.e0
            public final Object invoke(Object obj) {
                Unit bannerListData$lambda$9;
                bannerListData$lambda$9 = DiscoverViewModel.getBannerListData$lambda$9(DiscoverViewModel.this, (ApiResponse) obj);
                return bannerListData$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.f0
            public final Object invoke(Object obj) {
                Unit bannerListData$lambda$10;
                bannerListData$lambda$10 = DiscoverViewModel.getBannerListData$lambda$10(DiscoverViewModel.this, (Throwable) obj);
                return bannerListData$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<CpTop3Bean> getCpRank() {
        return this.cpRankMutable;
    }

    @NotNull
    public final LiveData<ArrayList<GroupTopBannerBean>> getEventList() {
        return this.eventListMutable;
    }

    @NotNull
    public final BaseListData getEventListData() {
        return this.eventListData;
    }

    @NotNull
    public final LiveData<List<GiftWallBean>> getGiftWall() {
        return this.giftWallMutable;
    }

    public final void getGiftWallList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getGiftWall(1, 3), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.s
            public final Object invoke(Object obj) {
                Unit giftWallList$lambda$2;
                giftWallList$lambda$2 = DiscoverViewModel.getGiftWallList$lambda$2(DiscoverViewModel.this, (ApiResponse) obj);
                return giftWallList$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.z
            public final Object invoke(Object obj) {
                Unit giftWallList$lambda$3;
                giftWallList$lambda$3 = DiscoverViewModel.getGiftWallList$lambda$3((Throwable) obj);
                return giftWallList$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<WeekPowerTop3Bean> getPowerRank() {
        return this.powerRankMutable;
    }

    public final void getPowerRankFlipperData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getPowerTop3Avatar(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.t
            public final Object invoke(Object obj) {
                Unit powerRankFlipperData$lambda$15;
                powerRankFlipperData$lambda$15 = DiscoverViewModel.getPowerRankFlipperData$lambda$15(DiscoverViewModel.this, (ApiResponse) obj);
                return powerRankFlipperData$lambda$15;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.u
            public final Object invoke(Object obj) {
                Unit powerRankFlipperData$lambda$16;
                powerRankFlipperData$lambda$16 = DiscoverViewModel.getPowerRankFlipperData$lambda$16((Throwable) obj);
                return powerRankFlipperData$lambda$16;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getRankFlipperData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getAllRankTop3Aavatar(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.g0
            public final Object invoke(Object obj) {
                Unit rankFlipperData$lambda$12;
                rankFlipperData$lambda$12 = DiscoverViewModel.getRankFlipperData$lambda$12(DiscoverViewModel.this, (ApiResponse) obj);
                return rankFlipperData$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.h0
            public final Object invoke(Object obj) {
                Unit rankFlipperData$lambda$13;
                rankFlipperData$lambda$13 = DiscoverViewModel.getRankFlipperData$lambda$13((Throwable) obj);
                return rankFlipperData$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<CountryTop3ContributeAllBean> getTop3Country() {
        return this.top3CountryMutable;
    }

    public final void getTop3CountryUser() {
        String str;
        Country countryInfo;
        UserService shared = UserService.INSTANCE.getShared();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (countryInfo = user.getCountryInfo()) == null || (str = countryInfo.getShortName()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getCountryTop3Contribute(str), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.c0
            public final Object invoke(Object obj) {
                Unit top3CountryUser$lambda$0;
                top3CountryUser$lambda$0 = DiscoverViewModel.getTop3CountryUser$lambda$0(DiscoverViewModel.this, (ApiResponse) obj);
                return top3CountryUser$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.d0
            public final Object invoke(Object obj) {
                Unit top3CountryUser$lambda$1;
                top3CountryUser$lambda$1 = DiscoverViewModel.getTop3CountryUser$lambda$1((Throwable) obj);
                return top3CountryUser$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getTop3CpRank() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getTop3CpRank(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.v
            public final Object invoke(Object obj) {
                Unit top3CpRank$lambda$18;
                top3CpRank$lambda$18 = DiscoverViewModel.getTop3CpRank$lambda$18(DiscoverViewModel.this, (ApiResponse) obj);
                return top3CpRank$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.w
            public final Object invoke(Object obj) {
                Unit top3CpRank$lambda$19;
                top3CpRank$lambda$19 = DiscoverViewModel.getTop3CpRank$lambda$19((Throwable) obj);
                return top3CpRank$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<Country>> getTop7Country() {
        return this.top7CountryMutable;
    }

    public final void getTop7CountryUser() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getTop7Country(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.x
            public final Object invoke(Object obj) {
                Unit top7CountryUser$lambda$7;
                top7CountryUser$lambda$7 = DiscoverViewModel.getTop7CountryUser$lambda$7(DiscoverViewModel.this, (ApiResponse) obj);
                return top7CountryUser$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.y
            public final Object invoke(Object obj) {
                Unit top7CountryUser$lambda$8;
                top7CountryUser$lambda$8 = DiscoverViewModel.getTop7CountryUser$lambda$8((Throwable) obj);
                return top7CountryUser$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    protected void onCleared() {
        super.onCleared();
        this.eventListData.destroy();
    }

    public final void setEventListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.eventListData = baseListData;
    }

    /* renamed from: getActivityList, reason: collision with other method in class */
    public final void m٧٣getActivityList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().activityList(0, 12, 1, ""), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.a0
            public final Object invoke(Object obj) {
                Unit activityList$lambda$4;
                activityList$lambda$4 = DiscoverViewModel.getActivityList$lambda$4(DiscoverViewModel.this, (ApiResponse) obj);
                return activityList$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.b0
            public final Object invoke(Object obj) {
                Unit activityList$lambda$5;
                activityList$lambda$5 = DiscoverViewModel.getActivityList$lambda$5((Throwable) obj);
                return activityList$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
