package com.qiahao.nextvideo.room.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.BlockBean;
import com.qiahao.nextvideo.data.model.BlockListBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0005J\b\u0010\u001c\u001a\u00020\u0017H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/RoomBlockListViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "blockedListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBlockedListData", "()Lcom/qiahao/base_common/model/BaseListData;", "blockedListDataMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/BlockBean;", "blockedList", "Landroidx/lifecycle/LiveData;", "getBlockedList", "()Landroidx/lifecycle/LiveData;", "blockList", "", SupportGiftRankActivity.EXTERNAL_ID, "unmaskUser", "position", "", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomBlockListViewModel extends BaseViewModel {

    @NotNull
    public static final String UNMASK_USER = "取消拉黑";

    @NotNull
    private final BaseListData blockedListData;

    @NotNull
    private final MutableLiveData<List<BlockBean>> blockedListDataMutable;

    @NotNull
    private String mGroupId = "";

    public RoomBlockListViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.blockedListData = baseListData;
        this.blockedListDataMutable = new MutableLiveData<>();
    }

    public static /* synthetic */ void blockList$default(RoomBlockListViewModel roomBlockListViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        roomBlockListViewModel.blockList(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockList$lambda$1(RoomBlockListViewModel roomBlockListViewModel, ApiResponse apiResponse) {
        List<BlockBean> list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseListData baseListData = roomBlockListViewModel.blockedListData;
        BlockListBean blockListBean = (BlockListBean) apiResponse.getData();
        List<BlockBean> list2 = null;
        if (blockListBean != null) {
            list = blockListBean.getData();
        } else {
            list = null;
        }
        baseListData.setList(list);
        MutableLiveData<List<BlockBean>> mutableLiveData = roomBlockListViewModel.blockedListDataMutable;
        BlockListBean blockListBean2 = (BlockListBean) apiResponse.getData();
        if (blockListBean2 != null) {
            list2 = blockListBean2.getData();
        }
        mutableLiveData.setValue(list2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit blockList$lambda$2(RoomBlockListViewModel roomBlockListViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomBlockListViewModel.blockedListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unmaskUser$lambda$3(RoomBlockListViewModel roomBlockListViewModel, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        roomBlockListViewModel.getMSuccess().setValue(new Pair("取消拉黑", Integer.valueOf(i)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit unmaskUser$lambda$4(RoomBlockListViewModel roomBlockListViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomBlockListViewModel.getMException().setValue(new Pair("取消拉黑", th));
        return Unit.INSTANCE;
    }

    public final void blockList(@Nullable String externalId) {
        this.blockedListData.resetPage();
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getRoomBlockMemberList(this.mGroupId, externalId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.o
            public final Object invoke(Object obj) {
                Unit blockList$lambda$1;
                blockList$lambda$1 = RoomBlockListViewModel.blockList$lambda$1(RoomBlockListViewModel.this, (ApiResponse) obj);
                return blockList$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.p
            public final Object invoke(Object obj) {
                Unit blockList$lambda$2;
                blockList$lambda$2 = RoomBlockListViewModel.blockList$lambda$2(RoomBlockListViewModel.this, (Throwable) obj);
                return blockList$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<BlockBean>> getBlockedList() {
        return this.blockedListDataMutable;
    }

    @NotNull
    public final BaseListData getBlockedListData() {
        return this.blockedListData;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    protected void onCleared() {
        super.onCleared();
        this.blockedListData.destroy();
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void unmaskUser(final int position, @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().removeGroupBlockById(this.mGroupId, externalId), new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.m
            public final Object invoke(Object obj) {
                Unit unmaskUser$lambda$3;
                unmaskUser$lambda$3 = RoomBlockListViewModel.unmaskUser$lambda$3(RoomBlockListViewModel.this, position, (ApiResponse) obj);
                return unmaskUser$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.n
            public final Object invoke(Object obj) {
                Unit unmaskUser$lambda$4;
                unmaskUser$lambda$4 = RoomBlockListViewModel.unmaskUser$lambda$4(RoomBlockListViewModel.this, (Throwable) obj);
                return unmaskUser$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
