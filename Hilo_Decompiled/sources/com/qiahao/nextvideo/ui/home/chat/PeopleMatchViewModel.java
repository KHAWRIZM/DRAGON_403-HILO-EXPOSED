package com.qiahao.nextvideo.ui.home.chat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.game.MatchRecent;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0018H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\r8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\r8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/PeopleMatchViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "matchListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/game/MatchRecent;", "matchList", "Landroidx/lifecycle/LiveData;", "getMatchList", "()Landroidx/lifecycle/LiveData;", "likeDataMutable", "likeData", "getLikeData", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "matchRecentList", "", "likeUser", "data", "position", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PeopleMatchViewModel extends BaseViewModel {

    @NotNull
    private final BaseListData baseListData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<MatchRecent>> matchListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<MatchRecent> likeDataMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<Throwable> errorMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit likeUser$lambda$2(MatchRecent matchRecent, int i, PeopleMatchViewModel peopleMatchViewModel, ApiResponse apiResponse) {
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = matchRecent.getUser();
        if (user != null) {
            LikeResult likeResult = (LikeResult) apiResponse.getData();
            if (likeResult != null) {
                bool2 = Boolean.valueOf(likeResult.getStatus());
            } else {
                bool2 = Boolean.FALSE;
            }
            user.setLike(bool2);
        }
        User user2 = matchRecent.getUser();
        if (user2 != null) {
            LikeResult likeResult2 = (LikeResult) apiResponse.getData();
            if (likeResult2 != null) {
                bool = Boolean.valueOf(likeResult2.isLikeEach());
            } else {
                bool = Boolean.FALSE;
            }
            user2.setLikeMe(bool);
        }
        matchRecent.setPosition(i);
        peopleMatchViewModel.likeDataMutable.setValue(matchRecent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit likeUser$lambda$3(PeopleMatchViewModel peopleMatchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        peopleMatchViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit matchRecentList$lambda$0(PeopleMatchViewModel peopleMatchViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        peopleMatchViewModel.baseListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<MatchRecent>> mutableLiveData = peopleMatchViewModel.matchListMutable;
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
    public static final Unit matchRecentList$lambda$1(PeopleMatchViewModel peopleMatchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        peopleMatchViewModel.baseListData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<MatchRecent> getLikeData() {
        return this.likeDataMutable;
    }

    @NotNull
    public final LiveData<List<MatchRecent>> getMatchList() {
        return this.matchListMutable;
    }

    public final void likeUser(@NotNull final MatchRecent data, final int position) {
        String str;
        boolean z;
        Boolean isLike;
        Intrinsics.checkNotNullParameter(data, "data");
        UserService shared = UserService.INSTANCE.getShared();
        User user = data.getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        String str2 = str;
        User user2 = data.getUser();
        if (user2 != null && (isLike = user2.isLike()) != null) {
            z = isLike.booleanValue();
        } else {
            z = false;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.like$default(shared, str2, z, false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.n0
            public final Object invoke(Object obj) {
                Unit likeUser$lambda$2;
                likeUser$lambda$2 = PeopleMatchViewModel.likeUser$lambda$2(MatchRecent.this, position, this, (ApiResponse) obj);
                return likeUser$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.o0
            public final Object invoke(Object obj) {
                Unit likeUser$lambda$3;
                likeUser$lambda$3 = PeopleMatchViewModel.likeUser$lambda$3(PeopleMatchViewModel.this, (Throwable) obj);
                return likeUser$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void matchRecentList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().matchRecentList(this.baseListData.nextPage(), this.baseListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.l0
            public final Object invoke(Object obj) {
                Unit matchRecentList$lambda$0;
                matchRecentList$lambda$0 = PeopleMatchViewModel.matchRecentList$lambda$0(PeopleMatchViewModel.this, (ApiResponse) obj);
                return matchRecentList$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.m0
            public final Object invoke(Object obj) {
                Unit matchRecentList$lambda$1;
                matchRecentList$lambda$1 = PeopleMatchViewModel.matchRecentList$lambda$1(PeopleMatchViewModel.this, (Throwable) obj);
                return matchRecentList$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    protected void onCleared() {
        super.onCleared();
        this.baseListData.destroy();
    }
}
