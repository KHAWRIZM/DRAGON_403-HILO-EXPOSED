package com.qiahao.nextvideo.ui.promoter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.data.model.IsDealerBean;
import com.qiahao.nextvideo.data.promote.PromoteData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.transfer.TransferCheckData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020,J\u0016\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0006\u0010\u001f\u001a\u00020,R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u00198F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00198F¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u00198F¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u00198F¢\u0006\u0006\u001a\u0004\b+\u0010\u001b¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "mDiamondSelect", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "getMDiamondSelect", "()Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "setMDiamondSelect", "(Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;)V", "mGemSelect", "getMGemSelect", "setMGemSelect", "mUser", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "(Lcom/qiahao/base_common/model/common/User;)V", "transferDataMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/DealerDetailBean;", "transferData", "Landroidx/lifecycle/LiveData;", "getTransferData", "()Landroidx/lifecycle/LiveData;", "promoteDataMutable", "Lcom/qiahao/nextvideo/data/promote/PromoteData;", "promoteData", "getPromoteData", "transferSuccessMutable", "", "transferSuccess", "getTransferSuccess", "transferCheckMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferCheckData;", "transferCheck", "getTransferCheck", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "", "checkTransferShare", SupportGiftRankActivity.EXTERNAL_ID, "", "type", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PromoterViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @Nullable
    private DealerDiamondConfig mDiamondSelect;

    @Nullable
    private DealerDiamondConfig mGemSelect;

    @Nullable
    private User mUser;

    @NotNull
    private final MutableLiveData<PromoteData> promoteDataMutable;

    @NotNull
    private final UserService repository;

    @NotNull
    private final MutableLiveData<TransferCheckData> transferCheckMutable;

    @NotNull
    private final MutableLiveData<DealerDetailBean> transferDataMutable;

    @NotNull
    private final MutableLiveData<Boolean> transferSuccessMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PromoterViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkTransferShare$lambda$3(PromoterViewModel promoterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        TransferCheckData transferCheckData = (TransferCheckData) apiResponse.getData();
        if (transferCheckData != null) {
            promoterViewModel.transferCheckMutable.setValue(transferCheckData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkTransferShare$lambda$4(PromoterViewModel promoterViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        promoterViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPromoteData$lambda$5(PromoterViewModel promoterViewModel, ApiResponse apiResponse) {
        PromoteData promoteData;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MutableLiveData<PromoteData> mutableLiveData = promoterViewModel.promoteDataMutable;
        IsDealerBean isDealerBean = (IsDealerBean) apiResponse.getData();
        if (isDealerBean != null) {
            promoteData = isDealerBean.getPt();
        } else {
            promoteData = null;
        }
        mutableLiveData.setValue(promoteData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPromoteData$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTransferData$lambda$0(PromoterViewModel promoterViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        promoterViewModel.transferDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTransferData$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void checkTransferShare(@NotNull String externalId, int type) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.checkShare(externalId, type, 1), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.c0
            public final Object invoke(Object obj) {
                Unit checkTransferShare$lambda$3;
                checkTransferShare$lambda$3 = PromoterViewModel.checkTransferShare$lambda$3(PromoterViewModel.this, (ApiResponse) obj);
                return checkTransferShare$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.d0
            public final Object invoke(Object obj) {
                Unit checkTransferShare$lambda$4;
                checkTransferShare$lambda$4 = PromoterViewModel.checkTransferShare$lambda$4(PromoterViewModel.this, (Throwable) obj);
                return checkTransferShare$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @Nullable
    public final DealerDiamondConfig getMDiamondSelect() {
        return this.mDiamondSelect;
    }

    @Nullable
    public final DealerDiamondConfig getMGemSelect() {
        return this.mGemSelect;
    }

    @Nullable
    public final User getMUser() {
        return this.mUser;
    }

    @NotNull
    public final LiveData<PromoteData> getPromoteData() {
        return this.promoteDataMutable;
    }

    @NotNull
    public final LiveData<TransferCheckData> getTransferCheck() {
        return this.transferCheckMutable;
    }

    @NotNull
    public final LiveData<DealerDetailBean> getTransferData() {
        return this.transferDataMutable;
    }

    @NotNull
    public final LiveData<Boolean> getTransferSuccess() {
        return this.transferSuccessMutable;
    }

    public final void setMDiamondSelect(@Nullable DealerDiamondConfig dealerDiamondConfig) {
        this.mDiamondSelect = dealerDiamondConfig;
    }

    public final void setMGemSelect(@Nullable DealerDiamondConfig dealerDiamondConfig) {
        this.mGemSelect = dealerDiamondConfig;
    }

    public final void setMUser(@Nullable User user) {
        this.mUser = user;
    }

    public PromoterViewModel(@NotNull UserService userService) {
        Intrinsics.checkNotNullParameter(userService, "repository");
        this.repository = userService;
        this.transferDataMutable = new MutableLiveData<>();
        this.promoteDataMutable = new MutableLiveData<>();
        this.transferSuccessMutable = new MutableLiveData<>();
        this.transferCheckMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    /* renamed from: getPromoteData, reason: collision with other method in class */
    public final void m٧٩getPromoteData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getIsDealer(), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.g0
            public final Object invoke(Object obj) {
                Unit promoteData$lambda$5;
                promoteData$lambda$5 = PromoterViewModel.getPromoteData$lambda$5(PromoterViewModel.this, (ApiResponse) obj);
                return promoteData$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.h0
            public final Object invoke(Object obj) {
                Unit promoteData$lambda$6;
                promoteData$lambda$6 = PromoterViewModel.getPromoteData$lambda$6((Throwable) obj);
                return promoteData$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getTransferData, reason: collision with other method in class */
    public final void m٨٠getTransferData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ServerApi.DefaultImpls.getPromoteDetail$default(AppServer.INSTANCE.getApis(), 0, 1, null), new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.e0
            public final Object invoke(Object obj) {
                Unit transferData$lambda$0;
                transferData$lambda$0 = PromoterViewModel.getTransferData$lambda$0(PromoterViewModel.this, (ApiResponse) obj);
                return transferData$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.f0
            public final Object invoke(Object obj) {
                Unit transferData$lambda$1;
                transferData$lambda$1 = PromoterViewModel.getTransferData$lambda$1((Throwable) obj);
                return transferData$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public /* synthetic */ PromoterViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
