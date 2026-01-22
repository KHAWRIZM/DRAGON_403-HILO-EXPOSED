package com.qiahao.nextvideo.ui.transfer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.transfer.TransferBanner;
import com.qiahao.nextvideo.data.transfer.TransferMonth;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.data.transfer.TransferRank;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020'J \u0010\u0019\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010(\u001a\u00020)J\u0010\u0010\u001d\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)J \u0010.\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010(\u001a\u00020)J\b\u0010/\u001a\u00020'H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u000b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0016\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000b8F¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000b8F¢\u0006\u0006\u001a\u0004\b%\u0010\r¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferCenterViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "bannerDataMutable", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/transfer/TransferBanner;", "bannerData", "Landroidx/lifecycle/LiveData;", "getBannerData", "()Landroidx/lifecycle/LiveData;", "periodMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "period", "getPeriod", "transferRankData", "Lcom/qiahao/base_common/model/BaseListData;", "getTransferRankData", "()Lcom/qiahao/base_common/model/BaseListData;", "transferRankMutable", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/transfer/TransferRank;", "transferRank", "getTransferRank", "transferMonthMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferMonth;", "transferMonth", "getTransferMonth", "searchMutable", "search", "getSearch", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "transferBanners", "", "isG", "", "transferPeriod", "beginDate", "", "endDate", "transferRange", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferCenterViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<ArrayList<TransferBanner>> bannerDataMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<TransferPeriod> periodMutable;

    @NotNull
    private final UserService repository;

    @NotNull
    private final MutableLiveData<TransferMonth> searchMutable;

    @NotNull
    private final MutableLiveData<TransferMonth> transferMonthMutable;

    @NotNull
    private final BaseListData transferRankData;

    @NotNull
    private final MutableLiveData<ApiList<TransferRank>> transferRankMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransferCenterViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    public static /* synthetic */ void transferBanners$default(TransferCenterViewModel transferCenterViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        transferCenterViewModel.transferBanners(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferBanners$lambda$0(TransferCenterViewModel transferCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferCenterViewModel.bannerDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferBanners$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void transferMonth$default(TransferCenterViewModel transferCenterViewModel, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        transferCenterViewModel.transferMonth(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferMonth$lambda$7(TransferCenterViewModel transferCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferCenterViewModel.transferMonthMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferMonth$lambda$8(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferPeriod$lambda$2(TransferCenterViewModel transferCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferCenterViewModel.periodMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferPeriod$lambda$3(TransferCenterViewModel transferCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferCenterViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void transferRange$default(TransferCenterViewModel transferCenterViewModel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        transferCenterViewModel.transferRange(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRange$lambda$10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRange$lambda$9(TransferCenterViewModel transferCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferCenterViewModel.searchMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void transferRank$default(TransferCenterViewModel transferCenterViewModel, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        transferCenterViewModel.transferRank(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRank$lambda$5(TransferCenterViewModel transferCenterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferCenterViewModel.transferRankData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            transferCenterViewModel.transferRankMutable.setValue(apiList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferRank$lambda$6(TransferCenterViewModel transferCenterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferCenterViewModel.transferRankData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<ArrayList<TransferBanner>> getBannerData() {
        return this.bannerDataMutable;
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
    public final LiveData<TransferMonth> getSearch() {
        return this.searchMutable;
    }

    @NotNull
    public final LiveData<TransferMonth> getTransferMonth() {
        return this.transferMonthMutable;
    }

    @NotNull
    public final LiveData<ApiList<TransferRank>> getTransferRank() {
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

    public final void transferBanners(int isG) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferBanners(Integer.valueOf(isG)), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.p1
            public final Object invoke(Object obj) {
                Unit transferBanners$lambda$0;
                transferBanners$lambda$0 = TransferCenterViewModel.transferBanners$lambda$0(TransferCenterViewModel.this, (ApiResponse) obj);
                return transferBanners$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.q1
            public final Object invoke(Object obj) {
                Unit transferBanners$lambda$1;
                transferBanners$lambda$1 = TransferCenterViewModel.transferBanners$lambda$1((Throwable) obj);
                return transferBanners$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferMonth(int isG) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferMonth(Integer.valueOf(isG)), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.j1
            public final Object invoke(Object obj) {
                Unit transferMonth$lambda$7;
                transferMonth$lambda$7 = TransferCenterViewModel.transferMonth$lambda$7(TransferCenterViewModel.this, (ApiResponse) obj);
                return transferMonth$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.k1
            public final Object invoke(Object obj) {
                Unit transferMonth$lambda$8;
                transferMonth$lambda$8 = TransferCenterViewModel.transferMonth$lambda$8((Throwable) obj);
                return transferMonth$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferPeriod() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferPeriod(), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.h1
            public final Object invoke(Object obj) {
                Unit transferPeriod$lambda$2;
                transferPeriod$lambda$2 = TransferCenterViewModel.transferPeriod$lambda$2(TransferCenterViewModel.this, (ApiResponse) obj);
                return transferPeriod$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.i1
            public final Object invoke(Object obj) {
                Unit transferPeriod$lambda$3;
                transferPeriod$lambda$3 = TransferCenterViewModel.transferPeriod$lambda$3(TransferCenterViewModel.this, (Throwable) obj);
                return transferPeriod$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferRange(@NotNull String beginDate, @NotNull String endDate, int isG) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferRange(beginDate, endDate, Integer.valueOf(isG)), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.n1
            public final Object invoke(Object obj) {
                Unit transferRange$lambda$9;
                transferRange$lambda$9 = TransferCenterViewModel.transferRange$lambda$9(TransferCenterViewModel.this, (ApiResponse) obj);
                return transferRange$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.o1
            public final Object invoke(Object obj) {
                Unit transferRange$lambda$10;
                transferRange$lambda$10 = TransferCenterViewModel.transferRange$lambda$10((Throwable) obj);
                return transferRange$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferRank(@NotNull String beginDate, @NotNull String endDate, int isG) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferRank(beginDate, endDate, this.transferRankData.nextPage(), this.transferRankData.getPageSize(), Integer.valueOf(isG)), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.l1
            public final Object invoke(Object obj) {
                Unit transferRank$lambda$5;
                transferRank$lambda$5 = TransferCenterViewModel.transferRank$lambda$5(TransferCenterViewModel.this, (ApiResponse) obj);
                return transferRank$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.m1
            public final Object invoke(Object obj) {
                Unit transferRank$lambda$6;
                transferRank$lambda$6 = TransferCenterViewModel.transferRank$lambda$6(TransferCenterViewModel.this, (Throwable) obj);
                return transferRank$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public TransferCenterViewModel(@NotNull UserService userService) {
        Intrinsics.checkNotNullParameter(userService, "repository");
        this.repository = userService;
        this.bannerDataMutable = new MutableLiveData<>();
        this.periodMutable = new MutableLiveData<>();
        this.transferRankData = new BaseListData();
        this.transferRankMutable = new MutableLiveData<>();
        this.transferMonthMutable = new MutableLiveData<>();
        this.searchMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    public /* synthetic */ TransferCenterViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
