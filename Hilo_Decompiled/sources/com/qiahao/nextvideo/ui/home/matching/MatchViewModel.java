package com.qiahao.nextvideo.ui.home.matching;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.baishun.HomeMatchGameData;
import com.qiahao.nextvideo.data.model.MissData;
import com.qiahao.nextvideo.data.model.SuperLikeData;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.data.planets.HiloPlanetsData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020)J\u0006\u0010\u0011\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u0006\u0010\u0016\u001a\u00020)J\u0006\u0010\u001a\u001a\u00020)J\u0006\u0010+\u001a\u00020)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\n8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\fR(\u0010\u0012\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00150\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u00150\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\fR\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\n8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\"\u0018\u00010!0\n8F¢\u0006\u0006\u001a\u0004\b$\u0010\fR\u0016\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0\n8F¢\u0006\u0006\u001a\u0004\b(\u0010\f¨\u0006-"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/MatchViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "missNumMutable", "Landroidx/lifecycle/MutableLiveData;", "", "missNum", "Landroidx/lifecycle/LiveData;", "getMissNum", "()Landroidx/lifecycle/LiveData;", "goddessListMutable", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "goddessList", "getGoddessList", "recommendListMutable", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/planets/HiloPlanetsData;", "Lkotlin/collections/ArrayList;", "recommendList", "getRecommendList", "matchGameListMutable", "Lcom/qiahao/nextvideo/data/baishun/HomeMatchGameData;", "matchGameList", "getMatchGameList", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "superLikeMutable", "", "Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "superLike", "getSuperLike", "userInfoMutable", "Lcom/qiahao/base_common/model/common/User;", Constants.KEY_USER_ID, "getUserInfo", "", "getUserInfoForCharge", "superLikeList", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchViewModel extends BaseViewModel {

    @NotNull
    public static final String SUPER_LIKE = "SUPER_LIKE";

    @NotNull
    private final BaseListData baseListData;

    @NotNull
    private final MutableLiveData<ApiList<VideoBaseData>> goddessListMutable;

    @NotNull
    private final MutableLiveData<HomeMatchGameData> matchGameListMutable;

    @NotNull
    private final MutableLiveData<Integer> missNumMutable;

    @NotNull
    private final MutableLiveData<ArrayList<HiloPlanetsData>> recommendListMutable;

    @NotNull
    private final UserService repository;

    @NotNull
    private final MutableLiveData<List<SuperLikeData>> superLikeMutable;

    @NotNull
    private final MutableLiveData<User> userInfoMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MatchViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGoddessList$lambda$3(MatchViewModel matchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        matchViewModel.goddessListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGoddessList$lambda$4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMissNum$lambda$1(MatchViewModel matchViewModel, ApiResponse apiResponse) {
        Integer num;
        Integer missNum;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        MissData missData = (MissData) apiResponse.getData();
        if (missData != null) {
            num = missData.getMissNum();
        } else {
            num = null;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "video_miss_number", num, (String) null, 4, (Object) null);
        MissData missData2 = (MissData) apiResponse.getData();
        if (missData2 != null && (missNum = missData2.getMissNum()) != null) {
            matchViewModel.missNumMutable.setValue(Integer.valueOf(missNum.intValue()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMissNum$lambda$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoForCharge$lambda$5(MatchViewModel matchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        matchViewModel.userInfoMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserInfoForCharge$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchGameList$lambda$10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchGameList$lambda$9(MatchViewModel matchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        matchViewModel.matchGameListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recommendList$lambda$7(MatchViewModel matchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        matchViewModel.recommendListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit recommendList$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit superLikeList$lambda$11(MatchViewModel matchViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        matchViewModel.baseListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<SuperLikeData>> mutableLiveData = matchViewModel.superLikeMutable;
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            list = apiList.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit superLikeList$lambda$12(MatchViewModel matchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        matchViewModel.baseListData.requestError();
        matchViewModel.getMException().setValue(new Pair(SUPER_LIKE, th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    @NotNull
    public final LiveData<ApiList<VideoBaseData>> getGoddessList() {
        return this.goddessListMutable;
    }

    @NotNull
    public final LiveData<HomeMatchGameData> getMatchGameList() {
        return this.matchGameListMutable;
    }

    @NotNull
    public final LiveData<Integer> getMissNum() {
        return this.missNumMutable;
    }

    @NotNull
    public final LiveData<ArrayList<HiloPlanetsData>> getRecommendList() {
        return this.recommendListMutable;
    }

    @NotNull
    public final LiveData<List<SuperLikeData>> getSuperLike() {
        return this.superLikeMutable;
    }

    @NotNull
    public final LiveData<User> getUserInfo() {
        return this.userInfoMutable;
    }

    public final void getUserInfoForCharge() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDetailInfo(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.y
            public final Object invoke(Object obj) {
                Unit userInfoForCharge$lambda$5;
                userInfoForCharge$lambda$5 = MatchViewModel.getUserInfoForCharge$lambda$5(MatchViewModel.this, (ApiResponse) obj);
                return userInfoForCharge$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.b0
            public final Object invoke(Object obj) {
                Unit userInfoForCharge$lambda$6;
                userInfoForCharge$lambda$6 = MatchViewModel.getUserInfoForCharge$lambda$6((Throwable) obj);
                return userInfoForCharge$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void matchGameList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.matchGameList(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.i0
            public final Object invoke(Object obj) {
                Unit matchGameList$lambda$9;
                matchGameList$lambda$9 = MatchViewModel.matchGameList$lambda$9(MatchViewModel.this, (ApiResponse) obj);
                return matchGameList$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.j0
            public final Object invoke(Object obj) {
                Unit matchGameList$lambda$10;
                matchGameList$lambda$10 = MatchViewModel.matchGameList$lambda$10((Throwable) obj);
                return matchGameList$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void recommendList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.recommendList(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.c0
            public final Object invoke(Object obj) {
                Unit recommendList$lambda$7;
                recommendList$lambda$7 = MatchViewModel.recommendList$lambda$7(MatchViewModel.this, (ApiResponse) obj);
                return recommendList$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.d0
            public final Object invoke(Object obj) {
                Unit recommendList$lambda$8;
                recommendList$lambda$8 = MatchViewModel.recommendList$lambda$8((Throwable) obj);
                return recommendList$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void superLikeList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().superLikeList(this.baseListData.nextPage(), this.baseListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.e0
            public final Object invoke(Object obj) {
                Unit superLikeList$lambda$11;
                superLikeList$lambda$11 = MatchViewModel.superLikeList$lambda$11(MatchViewModel.this, (ApiResponse) obj);
                return superLikeList$lambda$11;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.f0
            public final Object invoke(Object obj) {
                Unit superLikeList$lambda$12;
                superLikeList$lambda$12 = MatchViewModel.superLikeList$lambda$12(MatchViewModel.this, (Throwable) obj);
                return superLikeList$lambda$12;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public MatchViewModel(@NotNull UserService userService) {
        Intrinsics.checkNotNullParameter(userService, "repository");
        this.repository = userService;
        this.missNumMutable = new MutableLiveData<>();
        this.goddessListMutable = new MutableLiveData<>();
        this.recommendListMutable = new MutableLiveData<>();
        this.matchGameListMutable = new MutableLiveData<>();
        this.baseListData = new BaseListData();
        this.superLikeMutable = new MutableLiveData<>();
        this.userInfoMutable = new MutableLiveData<>();
    }

    /* renamed from: getGoddessList, reason: collision with other method in class */
    public final void m٧٥getGoddessList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoGoddessList(10, 1), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.z
            public final Object invoke(Object obj) {
                Unit goddessList$lambda$3;
                goddessList$lambda$3 = MatchViewModel.getGoddessList$lambda$3(MatchViewModel.this, (ApiResponse) obj);
                return goddessList$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.a0
            public final Object invoke(Object obj) {
                Unit goddessList$lambda$4;
                goddessList$lambda$4 = MatchViewModel.getGoddessList$lambda$4((Throwable) obj);
                return goddessList$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getMissNum, reason: collision with other method in class */
    public final void m٧٦getMissNum() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().videoMissNum(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.g0
            public final Object invoke(Object obj) {
                Unit missNum$lambda$1;
                missNum$lambda$1 = MatchViewModel.getMissNum$lambda$1(MatchViewModel.this, (ApiResponse) obj);
                return missNum$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.h0
            public final Object invoke(Object obj) {
                Unit missNum$lambda$2;
                missNum$lambda$2 = MatchViewModel.getMissNum$lambda$2((Throwable) obj);
                return missNum$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public /* synthetic */ MatchViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
