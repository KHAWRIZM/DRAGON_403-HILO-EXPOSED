package com.qiahao.nextvideo.ui.promoter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.promote.PromoteMonth;
import com.qiahao.nextvideo.data.promote.PromoteRank;
import com.qiahao.nextvideo.data.promote.PromoteRankData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.network.AppServer;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\"\u001a\u00020#J\u0016\u0010\u0014\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\u0006\u0010\u0018\u001a\u00020#J\u0016\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\b\u0010(\u001a\u00020#H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\n8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\fR\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\n8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\fR\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\n8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\n8F¢\u0006\u0006\u001a\u0004\b!\u0010\f¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "periodMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "period", "Landroidx/lifecycle/LiveData;", "getPeriod", "()Landroidx/lifecycle/LiveData;", "transferRankData", "Lcom/qiahao/base_common/model/BaseListData;", "getTransferRankData", "()Lcom/qiahao/base_common/model/BaseListData;", "transferRankMutable", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/promote/PromoteRank;", "transferRank", "getTransferRank", "transferMonthMutable", "Lcom/qiahao/nextvideo/data/promote/PromoteMonth;", "transferMonth", "getTransferMonth", "searchMutable", "Lcom/qiahao/nextvideo/data/promote/PromoteRankData;", "search", "getSearch", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "transferPeriod", "", "beginDate", "", "endDate", "transferRange", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PromoterCenterViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<TransferPeriod> periodMutable;

    @NotNull
    private final UserService repository;

    @NotNull
    private final MutableLiveData<PromoteRankData> searchMutable;

    @NotNull
    private final MutableLiveData<PromoteMonth> transferMonthMutable;

    @NotNull
    private final BaseListData transferRankData;

    @NotNull
    private final MutableLiveData<ApiList<PromoteRank>> transferRankMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PromoterCenterViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferMonth$lambda$5(PromoterCenterViewModel promoterCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        promoterCenterViewModel.transferMonthMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferMonth$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferPeriod$lambda$0(PromoterCenterViewModel promoterCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        promoterCenterViewModel.periodMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferPeriod$lambda$1(PromoterCenterViewModel promoterCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        promoterCenterViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRange$lambda$7(PromoterCenterViewModel promoterCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        promoterCenterViewModel.searchMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRange$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRank$lambda$3(PromoterCenterViewModel promoterCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        promoterCenterViewModel.transferRankData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            promoterCenterViewModel.transferRankMutable.setValue(apiList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRank$lambda$4(PromoterCenterViewModel promoterCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        promoterCenterViewModel.transferRankData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<TransferPeriod> getPeriod() {
        return this.periodMutable;
    }

    @NotNull
    public final LiveData<PromoteRankData> getSearch() {
        return this.searchMutable;
    }

    @NotNull
    public final LiveData<PromoteMonth> getTransferMonth() {
        return this.transferMonthMutable;
    }

    @NotNull
    public final LiveData<ApiList<PromoteRank>> getTransferRank() {
        return this.transferRankMutable;
    }

    @NotNull
    public final BaseListData getTransferRankData() {
        return this.transferRankData;
    }

    protected void onCleared() {
        super.onCleared();
        this.transferRankData.destroy();
    }

    public final void transferMonth() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().promoteMonth(), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.w
            public final Object invoke(Object obj) {
                Unit transferMonth$lambda$5;
                transferMonth$lambda$5 = PromoterCenterViewModel.transferMonth$lambda$5(PromoterCenterViewModel.this, (ApiResponse) obj);
                return transferMonth$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.x
            public final Object invoke(Object obj) {
                Unit transferMonth$lambda$6;
                transferMonth$lambda$6 = PromoterCenterViewModel.transferMonth$lambda$6((Throwable) obj);
                return transferMonth$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferPeriod() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferPeriod(), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.u
            public final Object invoke(Object obj) {
                Unit transferPeriod$lambda$0;
                transferPeriod$lambda$0 = PromoterCenterViewModel.transferPeriod$lambda$0(PromoterCenterViewModel.this, (ApiResponse) obj);
                return transferPeriod$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.v
            public final Object invoke(Object obj) {
                Unit transferPeriod$lambda$1;
                transferPeriod$lambda$1 = PromoterCenterViewModel.transferPeriod$lambda$1(PromoterCenterViewModel.this, (Throwable) obj);
                return transferPeriod$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferRange(@NotNull String beginDate, @NotNull String endDate) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().promoteRange(beginDate, endDate), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.a0
            public final Object invoke(Object obj) {
                Unit transferRange$lambda$7;
                transferRange$lambda$7 = PromoterCenterViewModel.transferRange$lambda$7(PromoterCenterViewModel.this, (ApiResponse) obj);
                return transferRange$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.b0
            public final Object invoke(Object obj) {
                Unit transferRange$lambda$8;
                transferRange$lambda$8 = PromoterCenterViewModel.transferRange$lambda$8((Throwable) obj);
                return transferRange$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferRank(@NotNull String beginDate, @NotNull String endDate) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().promoteRank(beginDate, endDate, this.transferRankData.nextPage(), this.transferRankData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.y
            public final Object invoke(Object obj) {
                Unit transferRank$lambda$3;
                transferRank$lambda$3 = PromoterCenterViewModel.transferRank$lambda$3(PromoterCenterViewModel.this, (ApiResponse) obj);
                return transferRank$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.z
            public final Object invoke(Object obj) {
                Unit transferRank$lambda$4;
                transferRank$lambda$4 = PromoterCenterViewModel.transferRank$lambda$4(PromoterCenterViewModel.this, (Throwable) obj);
                return transferRank$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public PromoterCenterViewModel(@NotNull UserService userService) {
        Intrinsics.checkNotNullParameter(userService, "repository");
        this.repository = userService;
        this.periodMutable = new MutableLiveData<>();
        this.transferRankData = new BaseListData();
        this.transferRankMutable = new MutableLiveData<>();
        this.transferMonthMutable = new MutableLiveData<>();
        this.searchMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    public /* synthetic */ PromoterCenterViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
