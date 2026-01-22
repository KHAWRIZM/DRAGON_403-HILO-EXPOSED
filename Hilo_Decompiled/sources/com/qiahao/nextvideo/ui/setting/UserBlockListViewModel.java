package com.qiahao.nextvideo.ui.setting;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.BlockedInfo;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0013J\b\u0010\u0018\u001a\u00020\u0011H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/UserBlockListViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "blockedListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBlockedListData", "()Lcom/qiahao/base_common/model/BaseListData;", "blockedListDataMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/BlockedInfo;", "blockedList", "Landroidx/lifecycle/LiveData;", "getBlockedList", "()Landroidx/lifecycle/LiveData;", "blockList", "", Constants.KEY_HTTP_CODE, "", "unmaskUser", "position", "", SupportGiftRankActivity.EXTERNAL_ID, "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserBlockListViewModel extends BaseViewModel {

    @NotNull
    public static final String UNMASK_USER = "取消拉黑";

    @NotNull
    private final BaseListData blockedListData;

    @NotNull
    private final MutableLiveData<List<BlockedInfo>> blockedListDataMutable;

    public UserBlockListViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.blockedListData = baseListData;
        this.blockedListDataMutable = new MutableLiveData<>();
    }

    public static /* synthetic */ void blockList$default(UserBlockListViewModel userBlockListViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        userBlockListViewModel.blockList(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockList$lambda$1(UserBlockListViewModel userBlockListViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        userBlockListViewModel.blockedListData.setList((List) apiResponse.getData());
        MutableLiveData<List<BlockedInfo>> mutableLiveData = userBlockListViewModel.blockedListDataMutable;
        Object obj = (List) apiResponse.getData();
        if (obj == null) {
            obj = new ArrayList();
        }
        mutableLiveData.setValue(obj);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockList$lambda$2(UserBlockListViewModel userBlockListViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        userBlockListViewModel.blockedListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unmaskUser$lambda$3(UserBlockListViewModel userBlockListViewModel, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        userBlockListViewModel.getMSuccess().setValue(new Pair("取消拉黑", Integer.valueOf(i)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unmaskUser$lambda$4(UserBlockListViewModel userBlockListViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        userBlockListViewModel.getMException().setValue(new Pair("取消拉黑", th));
        return Unit.INSTANCE;
    }

    public final void blockList(@Nullable String code) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserBlacklist(this.blockedListData.nextPage(), this.blockedListData.getPageSize(), code), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.v0
            public final Object invoke(Object obj) {
                Unit blockList$lambda$1;
                blockList$lambda$1 = UserBlockListViewModel.blockList$lambda$1(UserBlockListViewModel.this, (ApiResponse) obj);
                return blockList$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.w0
            public final Object invoke(Object obj) {
                Unit blockList$lambda$2;
                blockList$lambda$2 = UserBlockListViewModel.blockList$lambda$2(UserBlockListViewModel.this, (Throwable) obj);
                return blockList$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<BlockedInfo>> getBlockedList() {
        return this.blockedListDataMutable;
    }

    @NotNull
    public final BaseListData getBlockedListData() {
        return this.blockedListData;
    }

    protected void onCleared() {
        super.onCleared();
        this.blockedListData.destroy();
    }

    public final void unmaskUser(final int position, @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().unblockUser(externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.setting.t0
            public final Object invoke(Object obj) {
                Unit unmaskUser$lambda$3;
                unmaskUser$lambda$3 = UserBlockListViewModel.unmaskUser$lambda$3(UserBlockListViewModel.this, position, (ApiResponse) obj);
                return unmaskUser$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.setting.u0
            public final Object invoke(Object obj) {
                Unit unmaskUser$lambda$4;
                unmaskUser$lambda$4 = UserBlockListViewModel.unmaskUser$lambda$4(UserBlockListViewModel.this, (Throwable) obj);
                return unmaskUser$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
