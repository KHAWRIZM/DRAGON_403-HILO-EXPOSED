package com.qiahao.nextvideo.ui.friends;

import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0003R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR#\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/friends/FriendsChoseViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "", "getFriendData", "onCleared", "Lcom/qiahao/base_common/model/BaseListData;", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "Lma/b;", "", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "listLiveData", "Lma/b;", "getListLiveData", "()Lma/b;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendsChoseViewModel extends BaseViewModel {

    @NotNull
    private final BaseListData baseListData = new BaseListData();

    @NotNull
    private final ma.b listLiveData = new ma.b();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFriendData$lambda$1(FriendsChoseViewModel friendsChoseViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        friendsChoseViewModel.baseListData.setList((List) apiResponse.getData());
        List list = (List) apiResponse.getData();
        if (list != null) {
            friendsChoseViewModel.listLiveData.postValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFriendData$lambda$2(FriendsChoseViewModel friendsChoseViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        friendsChoseViewModel.baseListData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    public final void getFriendData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getLikeEachOtherContacts(this.baseListData.nextPage(), this.baseListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.friends.k
            public final Object invoke(Object obj) {
                Unit friendData$lambda$1;
                friendData$lambda$1 = FriendsChoseViewModel.getFriendData$lambda$1(FriendsChoseViewModel.this, (ApiResponse) obj);
                return friendData$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.friends.l
            public final Object invoke(Object obj) {
                Unit friendData$lambda$2;
                friendData$lambda$2 = FriendsChoseViewModel.getFriendData$lambda$2(FriendsChoseViewModel.this, (Throwable) obj);
                return friendData$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final ma.b getListLiveData() {
        return this.listLiveData;
    }

    protected void onCleared() {
        super.onCleared();
        this.baseListData.destroy();
    }
}
