package com.qiahao.nextvideo.ui.family;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.data.family.FamilyCenterData;
import com.qiahao.nextvideo.data.family.FamilyCenterMember;
import com.qiahao.nextvideo.data.family.FamilyRoomInfo;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.HashMap;
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

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 K2\u00020\u0001:\u0001KB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ\u000e\u00107\u001a\u00020A2\u0006\u0010B\u001a\u00020CJ\u0018\u0010\u0016\u001a\u00020A2\b\b\u0002\u0010D\u001a\u0002012\u0006\u0010B\u001a\u00020CJ\u0006\u0010\u001c\u001a\u00020AJ\u0006\u0010!\u001a\u00020AJ\u001e\u0010E\u001a\u00020A2\u0006\u0010F\u001a\u0002012\u0006\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020>J\u0006\u0010'\u001a\u00020AJ\u0016\u0010I\u001a\u00020A2\u0006\u0010D\u001a\u0002012\u0006\u0010G\u001a\u00020>J\u0006\u0010J\u001a\u00020AR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u000e8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\tR\u001c\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00140\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00140\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010R\u0011\u0010\u001e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR\u001c\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00140\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u00140\u000e8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0010R\u0011\u0010#\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\tR\u001c\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00140\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020&\u0018\u00010\u00140\u000e8F¢\u0006\u0006\u001a\u0004\b(\u0010\u0010R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R-\u0010/\u001a\u001e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&00j\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020&`2¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010\u00140\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000206\u0018\u00010\u00140\u000e8F¢\u0006\u0006\u001a\u0004\b8\u0010\u0010R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u000e8F¢\u0006\u0006\u001a\u0004\b<\u0010\u0010R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020>0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u000e8F¢\u0006\u0006\u001a\u0004\b@\u0010\u0010¨\u0006L"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyCenterViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "familyRoomListData", "Lcom/qiahao/base_common/model/BaseListData;", "getFamilyRoomListData", "()Lcom/qiahao/base_common/model/BaseListData;", "onFamilyInfoMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/family/FamilyCenterData;", "familyInfo", "Landroidx/lifecycle/LiveData;", "getFamilyInfo", "()Landroidx/lifecycle/LiveData;", "familyMemberListData", "getFamilyMemberListData", "onFamilyMemberListMutable", "", "Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "familyMemberList", "getFamilyMemberList", "familyApplyListData", "getFamilyApplyListData", "familyApplyListDataMutable", "Lcom/qiahao/nextvideo/data/family/FamilyApplicationData;", "familyApplyList", "getFamilyApplyList", "familyExitListData", "getFamilyExitListData", "familyExitListDataMutable", "familyExitList", "getFamilyExitList", "familyShareListData", "getFamilyShareListData", "familyShareListDataMutable", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "familyShareList", "getFamilyShareList", "familyInfoData", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "getFamilyInfoData", "()Lcom/qiahao/base_common/model/common/FamilyInfo;", "setFamilyInfoData", "(Lcom/qiahao/base_common/model/common/FamilyInfo;)V", "selectData", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSelectData", "()Ljava/util/HashMap;", "onFamilyRoomListMutable", "Lcom/qiahao/nextvideo/data/family/FamilyRoomInfo;", "familyRoomList", "getFamilyRoomList", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "familyNumberMutable", "", "familyNumber", "getFamilyNumber", "", AgooConstants.MESSAGE_ID, "", "userCode", "applyFamily", "userExtId", "type", "position", "searchFriends", "familyApplicationNumber", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyCenterViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyCenterViewModel.kt\ncom/qiahao/nextvideo/ui/family/FamilyCenterViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,227:1\n1#2:228\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyCenterViewModel extends BaseViewModel {

    @NotNull
    public static final String AGREE = "AGREE";

    @NotNull
    public static final String REFUSE = "REFUSE";

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final BaseListData familyApplyListData;

    @NotNull
    private final MutableLiveData<List<FamilyApplicationData>> familyApplyListDataMutable;

    @NotNull
    private final BaseListData familyExitListData;

    @NotNull
    private final MutableLiveData<List<FamilyApplicationData>> familyExitListDataMutable;

    @Nullable
    private FamilyInfo familyInfoData;

    @NotNull
    private final BaseListData familyMemberListData;

    @NotNull
    private final MutableLiveData<Integer> familyNumberMutable;

    @NotNull
    private final BaseListData familyRoomListData;

    @NotNull
    private final BaseListData familyShareListData;

    @NotNull
    private final MutableLiveData<List<ContactsLikeEachItem>> familyShareListDataMutable;

    @NotNull
    private final MutableLiveData<FamilyCenterData> onFamilyInfoMutable;

    @NotNull
    private final MutableLiveData<List<FamilyCenterMember>> onFamilyMemberListMutable;

    @NotNull
    private final MutableLiveData<List<FamilyRoomInfo>> onFamilyRoomListMutable;

    @Nullable
    private final UserService repository;

    @NotNull
    private final HashMap<String, ContactsLikeEachItem> selectData;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FamilyCenterViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyFamily$lambda$10(FamilyCenterViewModel familyCenterViewModel, int i, int i2, ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ma.b mSuccess = familyCenterViewModel.getMSuccess();
        if (i == 1) {
            str = AGREE;
        } else {
            str = REFUSE;
        }
        mSuccess.setValue(new Pair(str, Integer.valueOf(i2)));
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        messageProvide.setHasNewSystemMessage(true);
        messageProvide.displayData(MessageProvide.MESSAGE_DEFAULT);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit applyFamily$lambda$11(FamilyCenterViewModel familyCenterViewModel, int i, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        ma.b mException = familyCenterViewModel.getMException();
        if (i == 1) {
            str = AGREE;
        } else {
            str = REFUSE;
        }
        mException.setValue(new Pair(str, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyApplicationNumber$lambda$17(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MutableLiveData<Integer> mutableLiveData = familyCenterViewModel.familyNumberMutable;
        int i = (Integer) apiResponse.getData();
        if (i == null) {
            i = 0;
        }
        mutableLiveData.setValue(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyApplicationNumber$lambda$18(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyApplyList$lambda$6(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterViewModel.familyApplyListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<FamilyApplicationData>> mutableLiveData = familyCenterViewModel.familyApplyListDataMutable;
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
    public static final Unit familyApplyList$lambda$7(FamilyCenterViewModel familyCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyCenterViewModel.familyApplyListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyExitList$lambda$8(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterViewModel.familyExitListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<FamilyApplicationData>> mutableLiveData = familyCenterViewModel.familyExitListDataMutable;
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
    public static final Unit familyExitList$lambda$9(FamilyCenterViewModel familyCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyCenterViewModel.familyExitListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyInfo$lambda$0(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterViewModel.onFamilyInfoMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyInfo$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void familyMemberList$default(FamilyCenterViewModel familyCenterViewModel, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        familyCenterViewModel.familyMemberList(str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyMemberList$lambda$4(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterViewModel.familyMemberListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<FamilyCenterMember>> mutableLiveData = familyCenterViewModel.onFamilyMemberListMutable;
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
    public static final Unit familyMemberList$lambda$5(FamilyCenterViewModel familyCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyCenterViewModel.familyMemberListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyRoomList$lambda$2(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterViewModel.familyRoomListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<FamilyRoomInfo>> mutableLiveData = familyCenterViewModel.onFamilyRoomListMutable;
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
    public static final Unit familyRoomList$lambda$3(FamilyCenterViewModel familyCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyCenterViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyShareList$lambda$12(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyCenterViewModel.familyShareListData.setList((List) apiResponse.getData());
        familyCenterViewModel.familyShareListDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familyShareList$lambda$13(FamilyCenterViewModel familyCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyCenterViewModel.familyShareListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchFriends$lambda$15(FamilyCenterViewModel familyCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        ContactsLikeEachItem contactsLikeEachItem = (ContactsLikeEachItem) apiResponse.getData();
        if (contactsLikeEachItem != null) {
            arrayList.add(contactsLikeEachItem);
        }
        familyCenterViewModel.familyShareListData.nextPage();
        familyCenterViewModel.familyShareListData.setList(arrayList);
        familyCenterViewModel.familyShareListDataMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit searchFriends$lambda$16(FamilyCenterViewModel familyCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyCenterViewModel.familyShareListData.requestError();
        return Unit.INSTANCE;
    }

    public final void applyFamily(@NotNull String userExtId, final int type, final int position) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> applyFamily;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(userExtId, "userExtId");
        UserService userService = this.repository;
        if (userService != null && (applyFamily = userService.applyFamily(userExtId, type)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(applyFamily, new Function1() { // from class: com.qiahao.nextvideo.ui.family.v0
            public final Object invoke(Object obj) {
                Unit applyFamily$lambda$10;
                applyFamily$lambda$10 = FamilyCenterViewModel.applyFamily$lambda$10(FamilyCenterViewModel.this, type, position, (ApiResponse) obj);
                return applyFamily$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.w0
            public final Object invoke(Object obj) {
                Unit applyFamily$lambda$11;
                applyFamily$lambda$11 = FamilyCenterViewModel.applyFamily$lambda$11(FamilyCenterViewModel.this, type, (Throwable) obj);
                return applyFamily$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyApplicationNumber() {
        io.reactivex.rxjava3.core.i0<ApiResponse<Integer>> familyApplicationNumber;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (familyApplicationNumber = userService.familyApplicationNumber()) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyApplicationNumber, new Function1() { // from class: com.qiahao.nextvideo.ui.family.a1
            public final Object invoke(Object obj) {
                Unit familyApplicationNumber$lambda$17;
                familyApplicationNumber$lambda$17 = FamilyCenterViewModel.familyApplicationNumber$lambda$17(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyApplicationNumber$lambda$17;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.b1
            public final Object invoke(Object obj) {
                Unit familyApplicationNumber$lambda$18;
                familyApplicationNumber$lambda$18 = FamilyCenterViewModel.familyApplicationNumber$lambda$18((Throwable) obj);
                return familyApplicationNumber$lambda$18;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyApplyList() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<FamilyApplicationData>>> familyApplyList;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (familyApplyList = userService.familyApplyList(this.familyApplyListData.getPageSize(), this.familyApplyListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyApplyList, new Function1() { // from class: com.qiahao.nextvideo.ui.family.r0
            public final Object invoke(Object obj) {
                Unit familyApplyList$lambda$6;
                familyApplyList$lambda$6 = FamilyCenterViewModel.familyApplyList$lambda$6(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyApplyList$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.s0
            public final Object invoke(Object obj) {
                Unit familyApplyList$lambda$7;
                familyApplyList$lambda$7 = FamilyCenterViewModel.familyApplyList$lambda$7(FamilyCenterViewModel.this, (Throwable) obj);
                return familyApplyList$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyExitList() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<FamilyApplicationData>>> familyQuitList;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (familyQuitList = userService.familyQuitList(this.familyExitListData.getPageSize(), this.familyExitListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyQuitList, new Function1() { // from class: com.qiahao.nextvideo.ui.family.e1
            public final Object invoke(Object obj) {
                Unit familyExitList$lambda$8;
                familyExitList$lambda$8 = FamilyCenterViewModel.familyExitList$lambda$8(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyExitList$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.f1
            public final Object invoke(Object obj) {
                Unit familyExitList$lambda$9;
                familyExitList$lambda$9 = FamilyCenterViewModel.familyExitList$lambda$9(FamilyCenterViewModel.this, (Throwable) obj);
                return familyExitList$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyInfo(long id2) {
        io.reactivex.rxjava3.core.i0<ApiResponse<FamilyCenterData>> familyInfo;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (familyInfo = userService.familyInfo(id2)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyInfo, new Function1() { // from class: com.qiahao.nextvideo.ui.family.c1
            public final Object invoke(Object obj) {
                Unit familyInfo$lambda$0;
                familyInfo$lambda$0 = FamilyCenterViewModel.familyInfo$lambda$0(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyInfo$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.d1
            public final Object invoke(Object obj) {
                Unit familyInfo$lambda$1;
                familyInfo$lambda$1 = FamilyCenterViewModel.familyInfo$lambda$1((Throwable) obj);
                return familyInfo$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyMemberList(@NotNull String userCode, long id2) {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<FamilyCenterMember>>> familyMemberList;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(userCode, "userCode");
        UserService userService = this.repository;
        if (userService != null && (familyMemberList = userService.familyMemberList(userCode, id2, this.familyMemberListData.getPageSize(), this.familyMemberListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyMemberList, new Function1() { // from class: com.qiahao.nextvideo.ui.family.t0
            public final Object invoke(Object obj) {
                Unit familyMemberList$lambda$4;
                familyMemberList$lambda$4 = FamilyCenterViewModel.familyMemberList$lambda$4(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyMemberList$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.u0
            public final Object invoke(Object obj) {
                Unit familyMemberList$lambda$5;
                familyMemberList$lambda$5 = FamilyCenterViewModel.familyMemberList$lambda$5(FamilyCenterViewModel.this, (Throwable) obj);
                return familyMemberList$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyRoomList(long id2) {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<FamilyRoomInfo>>> familyRoomList;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (familyRoomList = userService.familyRoomList(id2, this.familyRoomListData.getPageSize(), this.familyRoomListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyRoomList, new Function1() { // from class: com.qiahao.nextvideo.ui.family.q0
            public final Object invoke(Object obj) {
                Unit familyRoomList$lambda$2;
                familyRoomList$lambda$2 = FamilyCenterViewModel.familyRoomList$lambda$2(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyRoomList$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.z0
            public final Object invoke(Object obj) {
                Unit familyRoomList$lambda$3;
                familyRoomList$lambda$3 = FamilyCenterViewModel.familyRoomList$lambda$3(FamilyCenterViewModel.this, (Throwable) obj);
                return familyRoomList$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void familyShareList() {
        io.reactivex.rxjava3.core.i0<ApiResponse<List<ContactsLikeEachItem>>> likeEachOtherContacts;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (likeEachOtherContacts = userService.getLikeEachOtherContacts(this.familyShareListData.nextPage(), this.familyShareListData.getPageSize())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(likeEachOtherContacts, new Function1() { // from class: com.qiahao.nextvideo.ui.family.g1
            public final Object invoke(Object obj) {
                Unit familyShareList$lambda$12;
                familyShareList$lambda$12 = FamilyCenterViewModel.familyShareList$lambda$12(FamilyCenterViewModel.this, (ApiResponse) obj);
                return familyShareList$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.h1
            public final Object invoke(Object obj) {
                Unit familyShareList$lambda$13;
                familyShareList$lambda$13 = FamilyCenterViewModel.familyShareList$lambda$13(FamilyCenterViewModel.this, (Throwable) obj);
                return familyShareList$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<List<FamilyApplicationData>> getFamilyApplyList() {
        return this.familyApplyListDataMutable;
    }

    @NotNull
    public final BaseListData getFamilyApplyListData() {
        return this.familyApplyListData;
    }

    @NotNull
    public final LiveData<List<FamilyApplicationData>> getFamilyExitList() {
        return this.familyExitListDataMutable;
    }

    @NotNull
    public final BaseListData getFamilyExitListData() {
        return this.familyExitListData;
    }

    @NotNull
    public final LiveData<FamilyCenterData> getFamilyInfo() {
        return this.onFamilyInfoMutable;
    }

    @Nullable
    public final FamilyInfo getFamilyInfoData() {
        return this.familyInfoData;
    }

    @NotNull
    public final LiveData<List<FamilyCenterMember>> getFamilyMemberList() {
        return this.onFamilyMemberListMutable;
    }

    @NotNull
    public final BaseListData getFamilyMemberListData() {
        return this.familyMemberListData;
    }

    @NotNull
    public final LiveData<Integer> getFamilyNumber() {
        return this.familyNumberMutable;
    }

    @NotNull
    public final LiveData<List<FamilyRoomInfo>> getFamilyRoomList() {
        return this.onFamilyRoomListMutable;
    }

    @NotNull
    public final BaseListData getFamilyRoomListData() {
        return this.familyRoomListData;
    }

    @NotNull
    public final LiveData<List<ContactsLikeEachItem>> getFamilyShareList() {
        return this.familyShareListDataMutable;
    }

    @NotNull
    public final BaseListData getFamilyShareListData() {
        return this.familyShareListData;
    }

    @NotNull
    public final HashMap<String, ContactsLikeEachItem> getSelectData() {
        return this.selectData;
    }

    public final void searchFriends(@NotNull String userCode, int type) {
        io.reactivex.rxjava3.core.i0<ApiResponse<ContactsLikeEachItem>> searchFriends;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(userCode, "userCode");
        UserService userService = this.repository;
        if (userService != null && (searchFriends = userService.searchFriends(userCode, type)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(searchFriends, new Function1() { // from class: com.qiahao.nextvideo.ui.family.x0
            public final Object invoke(Object obj) {
                Unit searchFriends$lambda$15;
                searchFriends$lambda$15 = FamilyCenterViewModel.searchFriends$lambda$15(FamilyCenterViewModel.this, (ApiResponse) obj);
                return searchFriends$lambda$15;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.y0
            public final Object invoke(Object obj) {
                Unit searchFriends$lambda$16;
                searchFriends$lambda$16 = FamilyCenterViewModel.searchFriends$lambda$16(FamilyCenterViewModel.this, (Throwable) obj);
                return searchFriends$lambda$16;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void setFamilyInfoData(@Nullable FamilyInfo familyInfo) {
        this.familyInfoData = familyInfo;
    }

    public FamilyCenterViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.familyRoomListData = new BaseListData();
        this.onFamilyInfoMutable = new MutableLiveData<>();
        this.familyMemberListData = new BaseListData();
        this.onFamilyMemberListMutable = new MutableLiveData<>();
        this.familyApplyListData = new BaseListData();
        this.familyApplyListDataMutable = new MutableLiveData<>();
        this.familyExitListData = new BaseListData();
        this.familyExitListDataMutable = new MutableLiveData<>();
        this.familyShareListData = new BaseListData();
        this.familyShareListDataMutable = new MutableLiveData<>();
        this.selectData = new HashMap<>();
        this.onFamilyRoomListMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.familyNumberMutable = new MutableLiveData<>();
    }

    public /* synthetic */ FamilyCenterViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
