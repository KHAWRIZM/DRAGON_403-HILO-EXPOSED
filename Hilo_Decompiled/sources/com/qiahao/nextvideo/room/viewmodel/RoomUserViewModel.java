package com.qiahao.nextvideo.room.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.GroupMemberListBean;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.network.AppServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u00101\u001a\u0002022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0005J\b\u00104\u001a\u000202H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0.8F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/room/viewmodel/RoomUserViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "mIsVisitorUser", "", "getMIsVisitorUser", "()Z", "setMIsVisitorUser", "(Z)V", "mIsAtUser", "getMIsAtUser", "setMIsAtUser", "mOnLine", "", "getMOnLine", "()I", "setMOnLine", "(I)V", "mTotal", "getMTotal", "setMTotal", "mTitle", "getMTitle", "setMTitle", "mRole", "getMRole", "()Ljava/lang/Integer;", "setMRole", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "userListData", "Lcom/qiahao/base_common/model/BaseListData;", "getUserListData", "()Lcom/qiahao/base_common/model/BaseListData;", "userListDataMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "userList", "Landroidx/lifecycle/LiveData;", "getUserList", "()Landroidx/lifecycle/LiveData;", "requestUserList", "", "searchText", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomUserViewModel extends BaseViewModel {
    private boolean mIsAtUser;
    private boolean mIsVisitorUser;
    private int mOnLine;
    private int mTotal;

    @NotNull
    private final BaseListData userListData;

    @NotNull
    private final MutableLiveData<List<MemberBean>> userListDataMutable;

    @NotNull
    private String mGroupId = "";

    @NotNull
    private String mTitle = "";

    @Nullable
    private Integer mRole = 0;

    public RoomUserViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.userListData = baseListData;
        this.userListDataMutable = new MutableLiveData<>();
    }

    public static /* synthetic */ void requestUserList$default(RoomUserViewModel roomUserViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        roomUserViewModel.requestUserList(str);
    }

    public static final Unit requestUserList$lambda$1(RoomUserViewModel roomUserViewModel, ApiResponse apiResponse) {
        int i;
        List<MemberBean> list;
        List<MemberBean> emptyList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        GroupMemberListBean groupMemberListBean = (GroupMemberListBean) apiResponse.getData();
        int i2 = 0;
        if (groupMemberListBean != null) {
            i = groupMemberListBean.getOnline();
        } else {
            i = 0;
        }
        roomUserViewModel.mOnLine = i;
        GroupMemberListBean groupMemberListBean2 = (GroupMemberListBean) apiResponse.getData();
        if (groupMemberListBean2 != null) {
            i2 = groupMemberListBean2.getTotal();
        }
        roomUserViewModel.mTotal = i2;
        BaseListData baseListData = roomUserViewModel.userListData;
        GroupMemberListBean groupMemberListBean3 = (GroupMemberListBean) apiResponse.getData();
        if (groupMemberListBean3 != null) {
            list = groupMemberListBean3.getMembers();
        } else {
            list = null;
        }
        baseListData.setList(list);
        MutableLiveData<List<MemberBean>> mutableLiveData = roomUserViewModel.userListDataMutable;
        GroupMemberListBean groupMemberListBean4 = (GroupMemberListBean) apiResponse.getData();
        if (groupMemberListBean4 == null || (emptyList = groupMemberListBean4.getMembers()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        mutableLiveData.setValue(emptyList);
        return Unit.INSTANCE;
    }

    public static final Unit requestUserList$lambda$2(RoomUserViewModel roomUserViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomUserViewModel.userListData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final boolean getMIsAtUser() {
        return this.mIsAtUser;
    }

    public final boolean getMIsVisitorUser() {
        return this.mIsVisitorUser;
    }

    public final int getMOnLine() {
        return this.mOnLine;
    }

    @Nullable
    public final Integer getMRole() {
        return this.mRole;
    }

    @NotNull
    public final String getMTitle() {
        return this.mTitle;
    }

    public final int getMTotal() {
        return this.mTotal;
    }

    @NotNull
    public final LiveData<List<MemberBean>> getUserList() {
        return this.userListDataMutable;
    }

    @NotNull
    public final BaseListData getUserListData() {
        return this.userListData;
    }

    protected void onCleared() {
        super.onCleared();
        this.userListData.destroy();
    }

    public final void requestUserList(@Nullable String searchText) {
        io.reactivex.rxjava3.core.i0<ApiResponse<GroupMemberListBean>> groupMember;
        if (this.mIsVisitorUser) {
            Integer num = this.mRole;
            if (num != null && num.intValue() == 0) {
                groupMember = AppServer.INSTANCE.getApis().getGroupVisitor(this.mGroupId, this.userListData.nextPage(), this.userListData.getPageSize(), searchText);
            } else {
                groupMember = AppServer.INSTANCE.getApis().getGroupMemberByRole(this.mGroupId, this.mRole, this.userListData.nextPage(), this.userListData.getPageSize());
            }
        } else {
            groupMember = AppServer.INSTANCE.getApis().getGroupMember(this.mGroupId, this.userListData.nextPage(), this.userListData.getPageSize());
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(groupMember, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.c0
            public final Object invoke(Object obj) {
                Unit requestUserList$lambda$1;
                requestUserList$lambda$1 = RoomUserViewModel.requestUserList$lambda$1(RoomUserViewModel.this, (ApiResponse) obj);
                return requestUserList$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.viewmodel.d0
            public final Object invoke(Object obj) {
                Unit requestUserList$lambda$2;
                requestUserList$lambda$2 = RoomUserViewModel.requestUserList$lambda$2(RoomUserViewModel.this, (Throwable) obj);
                return requestUserList$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMIsAtUser(boolean z) {
        this.mIsAtUser = z;
    }

    public final void setMIsVisitorUser(boolean z) {
        this.mIsVisitorUser = z;
    }

    public final void setMOnLine(int i) {
        this.mOnLine = i;
    }

    public final void setMRole(@Nullable Integer num) {
        this.mRole = num;
    }

    public final void setMTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mTitle = str;
    }

    public final void setMTotal(int i) {
        this.mTotal = i;
    }
}
