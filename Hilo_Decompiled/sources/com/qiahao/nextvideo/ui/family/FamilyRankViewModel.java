package com.qiahao.nextvideo.ui.family;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.family.FamilyRankData;
import com.qiahao.nextvideo.data.family.FamilyStarData;
import com.qiahao.nextvideo.data.service.UserService;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\u001e\u0010\u0017\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00140\u00108F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00108F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0012¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRankViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "familyStarListData", "Lcom/qiahao/base_common/model/BaseListData;", "getFamilyStarListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setFamilyStarListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "onFamilyDataMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/family/FamilyRankData;", "familyData", "Landroidx/lifecycle/LiveData;", "getFamilyData", "()Landroidx/lifecycle/LiveData;", "onFamilyStarMutable", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/family/FamilyStarData;", "familyStar", "getFamilyStar", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "getFamilyRank", "", "period", "", "groupPowerId", "", "type", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyRankViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private BaseListData familyStarListData;

    @NotNull
    private final MutableLiveData<FamilyRankData> onFamilyDataMutable;

    @NotNull
    private final MutableLiveData<ApiList<FamilyStarData>> onFamilyStarMutable;

    @Nullable
    private final UserService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FamilyRankViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFamilyRank$lambda$0(FamilyRankViewModel familyRankViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyRankViewModel.onFamilyDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFamilyRank$lambda$1(FamilyRankViewModel familyRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyRankViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFamilyStar$lambda$2(FamilyRankViewModel familyRankViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familyRankViewModel.onFamilyStarMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getFamilyStar$lambda$3(FamilyRankViewModel familyRankViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familyRankViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<FamilyRankData> getFamilyData() {
        return this.onFamilyDataMutable;
    }

    public final void getFamilyRank(@NotNull String period) {
        io.reactivex.rxjava3.core.i0<ApiResponse<FamilyRankData>> familyRank;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(period, "period");
        UserService userService = this.repository;
        if (userService != null && (familyRank = userService.familyRank(period)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyRank, new Function1() { // from class: com.qiahao.nextvideo.ui.family.x2
            public final Object invoke(Object obj) {
                Unit familyRank$lambda$0;
                familyRank$lambda$0 = FamilyRankViewModel.getFamilyRank$lambda$0(FamilyRankViewModel.this, (ApiResponse) obj);
                return familyRank$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.y2
            public final Object invoke(Object obj) {
                Unit familyRank$lambda$1;
                familyRank$lambda$1 = FamilyRankViewModel.getFamilyRank$lambda$1(FamilyRankViewModel.this, (Throwable) obj);
                return familyRank$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<ApiList<FamilyStarData>> getFamilyStar() {
        return this.onFamilyStarMutable;
    }

    @NotNull
    public final BaseListData getFamilyStarListData() {
        return this.familyStarListData;
    }

    public final void setFamilyStarListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.familyStarListData = baseListData;
    }

    public FamilyRankViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.familyStarListData = new BaseListData();
        this.onFamilyDataMutable = new MutableLiveData<>();
        this.onFamilyStarMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    public final void getFamilyStar(@NotNull String period, long groupPowerId, int type) {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<FamilyStarData>>> familyStar;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(period, "period");
        UserService userService = this.repository;
        if (userService == null || (familyStar = userService.familyStar(period, groupPowerId, type, 30, 1)) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familyStar, new Function1() { // from class: com.qiahao.nextvideo.ui.family.z2
            public final Object invoke(Object obj) {
                Unit familyStar$lambda$2;
                familyStar$lambda$2 = FamilyRankViewModel.getFamilyStar$lambda$2(FamilyRankViewModel.this, (ApiResponse) obj);
                return familyStar$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.a3
            public final Object invoke(Object obj) {
                Unit familyStar$lambda$3;
                familyStar$lambda$3 = FamilyRankViewModel.getFamilyStar$lambda$3(FamilyRankViewModel.this, (Throwable) obj);
                return familyStar$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    public /* synthetic */ FamilyRankViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
