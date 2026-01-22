package com.qiahao.nextvideo.ui.cp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.DiamondBean;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cp.CpCheck;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.noble.NobleCard;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 L2\u00020\u0001:\u0001LB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u00109\u001a\u00020:J\u0016\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001cJ\u000e\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020:2\u0006\u0010B\u001a\u00020\u0007J\u0016\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020\u001c2\u0006\u0010B\u001a\u00020\u0007J\u001e\u0010E\u001a\u00020:2\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0007J\u0016\u0010I\u001a\u00020:2\u0006\u0010?\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010J\u001a\u00020:2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010K\u001a\u00020:H\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010\"\u001a\u00020#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020)\u0018\u00010(0+8F¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020/0+8F¢\u0006\u0006\u001a\u0004\b1\u0010-R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020/0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020/0+8F¢\u0006\u0006\u001a\u0004\b4\u0010-R\u0014\u00105\u001a\b\u0012\u0004\u0012\u0002060'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002060+8F¢\u0006\u0006\u001a\u0004\b8\u0010-¨\u0006M"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/SearchViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "mType", "", "getMType", "()Ljava/lang/String;", "setMType", "(Ljava/lang/String;)V", "mData", "getMData", "setMData", "selectNoble", "Lcom/qiahao/nextvideo/data/noble/NobleCard;", "getSelectNoble", "()Lcom/qiahao/nextvideo/data/noble/NobleCard;", "setSelectNoble", "(Lcom/qiahao/nextvideo/data/noble/NobleCard;)V", "selectStoreBean", "Lcom/qiahao/base_common/model/StoreBean;", "getSelectStoreBean", "()Lcom/qiahao/base_common/model/StoreBean;", "setSelectStoreBean", "(Lcom/qiahao/base_common/model/StoreBean;)V", CpSpaceActivity.RELATION_TYPE, "", "getRelationType", "()Ljava/lang/Integer;", "setRelationType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shareListData", "Lcom/qiahao/base_common/model/BaseListData;", "getShareListData", "()Lcom/qiahao/base_common/model/BaseListData;", "shareListDataMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "shareList", "Landroidx/lifecycle/LiveData;", "getShareList", "()Landroidx/lifecycle/LiveData;", "checkCPMutable", "Lcom/qiahao/nextvideo/data/cp/CpCheck;", "checkCP", "getCheckCP", "checkRelationMutable", "checkRelation", "getCheckRelation", "cpBindSuccessMutable", "", "cpBindSuccess", "getCpBindSuccess", "shareFriendsList", "", "searchFriends", "userCode", "type", "checkBindCp", "user", "Lcom/qiahao/base_common/model/common/User;", "cpRelation", SupportGiftRankActivity.EXTERNAL_ID, "sendNobleCard", AgooConstants.MESSAGE_ID, "sendHeadOrMounts", "storeId", "", "extraId", "checkBindRelation", "specialRelation", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSearchViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchViewModel.kt\ncom/qiahao/nextvideo/ui/cp/SearchViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n1#2:230\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchViewModel extends BaseViewModel {

    @NotNull
    public static final String CHECK_RELATION = "CHECK_RELATION";

    @NotNull
    public static final String ERROR_CHECK_CP = "check_cp";

    @NotNull
    public static final String ERROR_CP_SEND = "cp_send";

    @NotNull
    public static final String ERROR_RELATION_SEND = "relation_send";

    @NotNull
    public static final String SEND_CARD = "SEND_CARD";

    @NotNull
    public static final String SEND_STORE = "SEND_STORE";

    @NotNull
    private final MutableLiveData<CpCheck> checkCPMutable;

    @NotNull
    private final MutableLiveData<CpCheck> checkRelationMutable;

    @NotNull
    private final MutableLiveData<Boolean> cpBindSuccessMutable;

    @NotNull
    private String mData;

    @NotNull
    private String mType;

    @Nullable
    private Integer relationType;

    @Nullable
    private final UserService repository;

    @Nullable
    private NobleCard selectNoble;

    @Nullable
    private StoreBean selectStoreBean;

    @NotNull
    private final BaseListData shareListData;

    @NotNull
    private final MutableLiveData<List<ContactsLikeEachItem>> shareListDataMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkBindCp$lambda$6(User user, SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CpCheck cpCheck = (CpCheck) apiResponse.getData();
        if (cpCheck != null) {
            cpCheck.setUser(user);
            searchViewModel.checkCPMutable.setValue(cpCheck);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkBindCp$lambda$7(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair(ERROR_CHECK_CP, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkBindRelation$lambda$17(User user, SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CpCheck cpCheck = (CpCheck) apiResponse.getData();
        if (cpCheck != null) {
            cpCheck.setUser(user);
            searchViewModel.checkRelationMutable.setValue(cpCheck);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkBindRelation$lambda$18(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair(CHECK_RELATION, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpRelation$lambda$8(SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        searchViewModel.cpBindSuccessMutable.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpRelation$lambda$9(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair(ERROR_CP_SEND, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchFriends$lambda$3(SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) apiResponse.getData();
        if (contactsLikeEachItem != null) {
            arrayList.add(contactsLikeEachItem);
        }
        searchViewModel.shareListData.nextPage();
        searchViewModel.shareListData.setList(arrayList);
        searchViewModel.shareListDataMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchFriends$lambda$4(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.shareListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$12(String str, SearchViewModel searchViewModel, ApiResponse apiResponse) {
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
        searchViewModel.getMSuccess().setValue(new Pair("SEND_STORE", Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$13(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair("SEND_STORE", th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$14(String str, SearchViewModel searchViewModel, ApiResponse apiResponse) {
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
        searchViewModel.getMSuccess().setValue(new Pair("SEND_STORE", Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendHeadOrMounts$lambda$15(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair("SEND_STORE", th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendNobleCard$lambda$10(SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        searchViewModel.getMSuccess().setValue(new Pair("SEND_CARD", Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit sendNobleCard$lambda$11(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair("SEND_CARD", th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shareFriendsList$lambda$0(SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        searchViewModel.shareListData.setList((List) apiResponse.getData());
        searchViewModel.shareListDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit shareFriendsList$lambda$1(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.shareListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit specialRelation$lambda$19(SearchViewModel searchViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        searchViewModel.cpBindSuccessMutable.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit specialRelation$lambda$20(SearchViewModel searchViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        searchViewModel.getMException().setValue(new Pair(ERROR_RELATION_SEND, th));
        return Unit.INSTANCE;
    }

    public final void checkBindCp(@NotNull final User user) {
        io.reactivex.rxjava3.core.i0<ApiResponse<CpCheck>> checkBindCp;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(user, "user");
        UserService userService = this.repository;
        if (userService != null && (checkBindCp = userService.checkBindCp(user.getExternalId())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(checkBindCp, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.m3
            public final Object invoke(Object obj) {
                Unit checkBindCp$lambda$6;
                checkBindCp$lambda$6 = SearchViewModel.checkBindCp$lambda$6(user, this, (ApiResponse) obj);
                return checkBindCp$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.n3
            public final Object invoke(Object obj) {
                Unit checkBindCp$lambda$7;
                checkBindCp$lambda$7 = SearchViewModel.checkBindCp$lambda$7(SearchViewModel.this, (Throwable) obj);
                return checkBindCp$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void checkBindRelation(@NotNull final User user, int relationType) {
        io.reactivex.rxjava3.core.i0<ApiResponse<CpCheck>> checkBindRelation;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(user, "user");
        UserService userService = this.repository;
        if (userService != null && (checkBindRelation = userService.checkBindRelation(user.getExternalId(), relationType)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(checkBindRelation, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.d3
            public final Object invoke(Object obj) {
                Unit checkBindRelation$lambda$17;
                checkBindRelation$lambda$17 = SearchViewModel.checkBindRelation$lambda$17(user, this, (ApiResponse) obj);
                return checkBindRelation$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.e3
            public final Object invoke(Object obj) {
                Unit checkBindRelation$lambda$18;
                checkBindRelation$lambda$18 = SearchViewModel.checkBindRelation$lambda$18(SearchViewModel.this, (Throwable) obj);
                return checkBindRelation$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void cpRelation(@NotNull String externalId) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> cpRelation;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        UserService userService = this.repository;
        if (userService != null && (cpRelation = userService.cpRelation(externalId, 1)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpRelation, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.c3
            public final Object invoke(Object obj) {
                Unit cpRelation$lambda$8;
                cpRelation$lambda$8 = SearchViewModel.cpRelation$lambda$8(SearchViewModel.this, (ApiResponse) obj);
                return cpRelation$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.l3
            public final Object invoke(Object obj) {
                Unit cpRelation$lambda$9;
                cpRelation$lambda$9 = SearchViewModel.cpRelation$lambda$9(SearchViewModel.this, (Throwable) obj);
                return cpRelation$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<CpCheck> getCheckCP() {
        return this.checkCPMutable;
    }

    @NotNull
    public final LiveData<CpCheck> getCheckRelation() {
        return this.checkRelationMutable;
    }

    @NotNull
    public final LiveData<Boolean> getCpBindSuccess() {
        return this.cpBindSuccessMutable;
    }

    @NotNull
    public final String getMData() {
        return this.mData;
    }

    @NotNull
    public final String getMType() {
        return this.mType;
    }

    @Nullable
    public final Integer getRelationType() {
        return this.relationType;
    }

    @Nullable
    public final NobleCard getSelectNoble() {
        return this.selectNoble;
    }

    @Nullable
    public final StoreBean getSelectStoreBean() {
        return this.selectStoreBean;
    }

    @NotNull
    public final LiveData<List<ContactsLikeEachItem>> getShareList() {
        return this.shareListDataMutable;
    }

    @NotNull
    public final BaseListData getShareListData() {
        return this.shareListData;
    }

    protected void onCleared() {
        super.onCleared();
        this.shareListData.destroy();
    }

    public final void searchFriends(@NotNull String userCode, int type) {
        io.reactivex.rxjava3.core.i0<ApiResponse<ContactsLikeEachItem>> searchFriends;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(userCode, "userCode");
        UserService userService = this.repository;
        if (userService != null && (searchFriends = userService.searchFriends(userCode, type)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(searchFriends, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.j3
            public final Object invoke(Object obj) {
                Unit searchFriends$lambda$3;
                searchFriends$lambda$3 = SearchViewModel.searchFriends$lambda$3(SearchViewModel.this, (ApiResponse) obj);
                return searchFriends$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.k3
            public final Object invoke(Object obj) {
                Unit searchFriends$lambda$4;
                searchFriends$lambda$4 = SearchViewModel.searchFriends$lambda$4(SearchViewModel.this, (Throwable) obj);
                return searchFriends$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void sendHeadOrMounts(int type, long storeId, @NotNull final String extraId) {
        Intrinsics.checkNotNullParameter(extraId, "extraId");
        if (type != 0) {
            if (type == 1) {
                RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().propertySendOrBuy(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.cp.q3
                    public final Object invoke(Object obj) {
                        Unit sendHeadOrMounts$lambda$14;
                        sendHeadOrMounts$lambda$14 = SearchViewModel.sendHeadOrMounts$lambda$14(extraId, this, (ApiResponse) obj);
                        return sendHeadOrMounts$lambda$14;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.r3
                    public final Object invoke(Object obj) {
                        Unit sendHeadOrMounts$lambda$15;
                        sendHeadOrMounts$lambda$15 = SearchViewModel.sendHeadOrMounts$lambda$15(SearchViewModel.this, (Throwable) obj);
                        return sendHeadOrMounts$lambda$15;
                    }
                }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                return;
            }
            return;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().headWearSendOrBuy(storeId, extraId), new Function1() { // from class: com.qiahao.nextvideo.ui.cp.o3
            public final Object invoke(Object obj) {
                Unit sendHeadOrMounts$lambda$12;
                sendHeadOrMounts$lambda$12 = SearchViewModel.sendHeadOrMounts$lambda$12(extraId, this, (ApiResponse) obj);
                return sendHeadOrMounts$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.p3
            public final Object invoke(Object obj) {
                Unit sendHeadOrMounts$lambda$13;
                sendHeadOrMounts$lambda$13 = SearchViewModel.sendHeadOrMounts$lambda$13(SearchViewModel.this, (Throwable) obj);
                return sendHeadOrMounts$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void sendNobleCard(int id2, @NotNull String externalId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().sendNobleCard(id2, externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.cp.h3
            public final Object invoke(Object obj) {
                Unit sendNobleCard$lambda$10;
                sendNobleCard$lambda$10 = SearchViewModel.sendNobleCard$lambda$10(SearchViewModel.this, (ApiResponse) obj);
                return sendNobleCard$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.i3
            public final Object invoke(Object obj) {
                Unit sendNobleCard$lambda$11;
                sendNobleCard$lambda$11 = SearchViewModel.sendNobleCard$lambda$11(SearchViewModel.this, (Throwable) obj);
                return sendNobleCard$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setMData(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mData = str;
    }

    public final void setMType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mType = str;
    }

    public final void setRelationType(@Nullable Integer num) {
        this.relationType = num;
    }

    public final void setSelectNoble(@Nullable NobleCard nobleCard) {
        this.selectNoble = nobleCard;
    }

    public final void setSelectStoreBean(@Nullable StoreBean storeBean) {
        this.selectStoreBean = storeBean;
    }

    public final void shareFriendsList() {
        io.reactivex.rxjava3.core.i0<ApiResponse<List<ContactsLikeEachItem>>> likeEachOtherContacts;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (likeEachOtherContacts = userService.getLikeEachOtherContacts(this.shareListData.nextPage(), this.shareListData.getPageSize())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(likeEachOtherContacts, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.s3
            public final Object invoke(Object obj) {
                Unit shareFriendsList$lambda$0;
                shareFriendsList$lambda$0 = SearchViewModel.shareFriendsList$lambda$0(SearchViewModel.this, (ApiResponse) obj);
                return shareFriendsList$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.t3
            public final Object invoke(Object obj) {
                Unit shareFriendsList$lambda$1;
                shareFriendsList$lambda$1 = SearchViewModel.shareFriendsList$lambda$1(SearchViewModel.this, (Throwable) obj);
                return shareFriendsList$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void specialRelation(@NotNull String externalId, int relationType) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> specialRelation;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        UserService userService = this.repository;
        if (userService != null && (specialRelation = userService.specialRelation(externalId, 1, relationType)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(specialRelation, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.f3
            public final Object invoke(Object obj) {
                Unit specialRelation$lambda$19;
                specialRelation$lambda$19 = SearchViewModel.specialRelation$lambda$19(SearchViewModel.this, (ApiResponse) obj);
                return specialRelation$lambda$19;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.g3
            public final Object invoke(Object obj) {
                Unit specialRelation$lambda$20;
                specialRelation$lambda$20 = SearchViewModel.specialRelation$lambda$20(SearchViewModel.this, (Throwable) obj);
                return specialRelation$lambda$20;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public SearchViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.mType = "";
        this.mData = "";
        this.shareListData = new BaseListData();
        this.shareListDataMutable = new MutableLiveData<>();
        this.checkCPMutable = new MutableLiveData<>();
        this.checkRelationMutable = new MutableLiveData<>();
        this.cpBindSuccessMutable = new MutableLiveData<>();
    }

    public /* synthetic */ SearchViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
