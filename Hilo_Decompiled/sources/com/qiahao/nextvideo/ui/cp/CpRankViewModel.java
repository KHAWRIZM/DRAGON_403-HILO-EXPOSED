package com.qiahao.nextvideo.ui.cp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.cp.CpListData;
import com.qiahao.nextvideo.data.cp.CpRecord;
import com.qiahao.nextvideo.data.service.UserService;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010+\u001a\u00020,J\u000e\u0010\u001e\u001a\u00020,2\u0006\u0010-\u001a\u00020.J\u0006\u0010&\u001a\u00020,J\b\u0010/\u001a\u00020,H\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001a8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00170\u001a8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u001a8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001c¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "mDateType", "", "getMDateType", "()Ljava/lang/String;", "setMDateType", "(Ljava/lang/String;)V", "mRelationShip", "getMRelationShip", "setMRelationShip", "cpListData", "Lcom/qiahao/base_common/model/BaseListData;", "getCpListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setCpListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "cpListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/cp/CpListData;", "cpList", "Landroidx/lifecycle/LiveData;", "getCpList", "()Landroidx/lifecycle/LiveData;", "myCpMutable", "myCp", "getMyCp", "cpRecordData", "getCpRecordData", "setCpRecordData", "cpRecordMutable", "Lcom/qiahao/nextvideo/data/cp/CpRecord;", "cpRecord", "getCpRecord", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "getCpRank", "", "position", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankViewModel extends BaseViewModel {

    @NotNull
    private BaseListData cpListData;

    @NotNull
    private final MutableLiveData<List<CpListData>> cpListMutable;

    @NotNull
    private BaseListData cpRecordData;

    @NotNull
    private final MutableLiveData<List<CpRecord>> cpRecordMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private String mDateType;

    @NotNull
    private String mRelationShip;

    @NotNull
    private final MutableLiveData<CpListData> myCpMutable;

    @Nullable
    private final UserService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CpRankViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpRank$lambda$2(CpRankViewModel cpRankViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpRankViewModel.cpListData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            cpRankViewModel.cpListMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpRank$lambda$3(CpRankViewModel cpRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpRankViewModel.cpListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpRank$lambda$5(CpRankViewModel cpRankViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpRankViewModel.cpListData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            cpRankViewModel.cpListMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpRank$lambda$6(CpRankViewModel cpRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpRankViewModel.cpListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpRecord$lambda$12(CpRankViewModel cpRankViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpRankViewModel.cpRecordData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            cpRankViewModel.cpRecordMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpRecord$lambda$13(CpRankViewModel cpRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpRankViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit myCp$lambda$10(CpRankViewModel cpRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpRankViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit myCp$lambda$7(CpRankViewModel cpRankViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpRankViewModel.myCpMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit myCp$lambda$8(CpRankViewModel cpRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpRankViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit myCp$lambda$9(CpRankViewModel cpRankViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpRankViewModel.myCpMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<List<CpListData>> getCpList() {
        return this.cpListMutable;
    }

    @NotNull
    public final BaseListData getCpListData() {
        return this.cpListData;
    }

    public final void getCpRank() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<CpListData>>> relationRankList;
        nd.c observeOnMainThread$default;
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<CpListData>>> cpRankList;
        nd.c observeOnMainThread$default2;
        if (Intrinsics.areEqual(this.mRelationShip, CpFragment.FRAGMENT_CP)) {
            UserService userService = this.repository;
            if (userService != null && (cpRankList = userService.cpRankList(this.cpListData.nextPage(), this.cpListData.getPageSize(), this.mDateType)) != null && (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(cpRankList, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.v0
                public final Object invoke(Object obj) {
                    Unit cpRank$lambda$2;
                    cpRank$lambda$2 = CpRankViewModel.getCpRank$lambda$2(CpRankViewModel.this, (ApiResponse) obj);
                    return cpRank$lambda$2;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.w0
                public final Object invoke(Object obj) {
                    Unit cpRank$lambda$3;
                    cpRank$lambda$3 = CpRankViewModel.getCpRank$lambda$3(CpRankViewModel.this, (Throwable) obj);
                    return cpRank$lambda$3;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
                return;
            }
            return;
        }
        UserService userService2 = this.repository;
        if (userService2 != null && (relationRankList = userService2.relationRankList(this.cpListData.nextPage(), this.cpListData.getPageSize(), this.mDateType)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(relationRankList, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.x0
            public final Object invoke(Object obj) {
                Unit cpRank$lambda$5;
                cpRank$lambda$5 = CpRankViewModel.getCpRank$lambda$5(CpRankViewModel.this, (ApiResponse) obj);
                return cpRank$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.y0
            public final Object invoke(Object obj) {
                Unit cpRank$lambda$6;
                cpRank$lambda$6 = CpRankViewModel.getCpRank$lambda$6(CpRankViewModel.this, (Throwable) obj);
                return cpRank$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<List<CpRecord>> getCpRecord() {
        return this.cpRecordMutable;
    }

    @NotNull
    public final BaseListData getCpRecordData() {
        return this.cpRecordData;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    @NotNull
    public final String getMRelationShip() {
        return this.mRelationShip;
    }

    @NotNull
    public final LiveData<CpListData> getMyCp() {
        return this.myCpMutable;
    }

    public final void myCp(int position) {
        String str;
        io.reactivex.rxjava3.core.i0<ApiResponse<CpListData>> myRelation;
        nd.c observeOnMainThread$default;
        io.reactivex.rxjava3.core.i0<ApiResponse<CpListData>> myCp;
        nd.c observeOnMainThread$default2;
        if (position != 0) {
            if (position != 1) {
                str = "month";
            } else {
                str = "week";
            }
        } else {
            str = "day";
        }
        if (Intrinsics.areEqual(this.mRelationShip, CpFragment.FRAGMENT_CP)) {
            UserService userService = this.repository;
            if (userService != null && (myCp = userService.myCp(str)) != null && (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(myCp, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.r0
                public final Object invoke(Object obj) {
                    Unit myCp$lambda$7;
                    myCp$lambda$7 = CpRankViewModel.myCp$lambda$7(CpRankViewModel.this, (ApiResponse) obj);
                    return myCp$lambda$7;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.s0
                public final Object invoke(Object obj) {
                    Unit myCp$lambda$8;
                    myCp$lambda$8 = CpRankViewModel.myCp$lambda$8(CpRankViewModel.this, (Throwable) obj);
                    return myCp$lambda$8;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
                return;
            }
            return;
        }
        UserService userService2 = this.repository;
        if (userService2 != null && (myRelation = userService2.myRelation(str)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(myRelation, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.t0
            public final Object invoke(Object obj) {
                Unit myCp$lambda$9;
                myCp$lambda$9 = CpRankViewModel.myCp$lambda$9(CpRankViewModel.this, (ApiResponse) obj);
                return myCp$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.u0
            public final Object invoke(Object obj) {
                Unit myCp$lambda$10;
                myCp$lambda$10 = CpRankViewModel.myCp$lambda$10(CpRankViewModel.this, (Throwable) obj);
                return myCp$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.cpListData.destroy();
    }

    public final void setCpListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.cpListData = baseListData;
    }

    public final void setCpRecordData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.cpRecordData = baseListData;
    }

    public final void setMDateType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mDateType = str;
    }

    public final void setMRelationShip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mRelationShip = str;
    }

    public CpRankViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.mDateType = "";
        this.mRelationShip = CpFragment.FRAGMENT_CP;
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.cpListData = baseListData;
        this.cpListMutable = new MutableLiveData<>();
        this.myCpMutable = new MutableLiveData<>();
        this.cpRecordData = new BaseListData();
        this.cpRecordMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    /* renamed from: getCpRecord, reason: collision with other method in class */
    public final void m٦٧getCpRecord() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<CpRecord>>> cpRecord;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService == null || (cpRecord = userService.cpRecord()) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpRecord, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.z0
            public final Object invoke(Object obj) {
                Unit cpRecord$lambda$12;
                cpRecord$lambda$12 = CpRankViewModel.getCpRecord$lambda$12(CpRankViewModel.this, (ApiResponse) obj);
                return cpRecord$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.a1
            public final Object invoke(Object obj) {
                Unit cpRecord$lambda$13;
                cpRecord$lambda$13 = CpRankViewModel.getCpRecord$lambda$13(CpRankViewModel.this, (Throwable) obj);
                return cpRecord$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    public /* synthetic */ CpRankViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
