package com.qiahao.nextvideo.ui.transfer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.transfer.TransferCheckData;
import com.qiahao.nextvideo.data.transfer.TransferRecordData;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u000204J\u0006\u00105\u001a\u000204J\u000e\u00106\u001a\u0002042\u0006\u00107\u001a\u000208J\u001e\u00109\u001a\u0002042\u0006\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<J\u0016\u0010>\u001a\u0002042\u0006\u0010:\u001a\u0002082\u0006\u0010?\u001a\u00020<J\u000e\u0010@\u001a\u0002042\u0006\u0010=\u001a\u00020<J\b\u0010A\u001a\u000204H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001d0\u00198F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u001d0\u00198F¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u00198F¢\u0006\u0006\u001a\u0004\b+\u0010\u001bR\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u00198F¢\u0006\u0006\u001a\u0004\b/\u0010\u001bR\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002010\u00198F¢\u0006\u0006\u001a\u0004\b3\u0010\u001b¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "mDiamondSelect", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "getMDiamondSelect", "()Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "setMDiamondSelect", "(Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;)V", "mGemSelect", "getMGemSelect", "setMGemSelect", "mUser", "Lcom/qiahao/base_common/model/common/User;", "getMUser", "()Lcom/qiahao/base_common/model/common/User;", "setMUser", "(Lcom/qiahao/base_common/model/common/User;)V", "transferDataMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/DealerDetailBean;", "transferData", "Landroidx/lifecycle/LiveData;", "getTransferData", "()Landroidx/lifecycle/LiveData;", "transferUserMutable", "", "transferUser", "getTransferUser", "transferRecordData", "Lcom/qiahao/base_common/model/BaseListData;", "getTransferRecordData", "()Lcom/qiahao/base_common/model/BaseListData;", "transferRecordMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferRecordData;", "transferRecord", "getTransferRecord", "transferSuccessMutable", "", "transferSuccess", "getTransferSuccess", "transferCheckMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferCheckData;", "transferCheck", "getTransferCheck", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "", "transferUserList", "transferSearchUser", Constants.KEY_HTTP_CODE, "", "transferToUser", SupportGiftRankActivity.EXTERNAL_ID, "productId", "", "isPink", "checkTransferShare", "type", "transferDiamondDetail", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferViewModel.kt\ncom/qiahao/nextvideo/ui/transfer/TransferViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,160:1\n1#2:161\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @Nullable
    private DealerDiamondConfig mDiamondSelect;

    @Nullable
    private DealerDiamondConfig mGemSelect;

    @Nullable
    private User mUser;

    @NotNull
    private final UserService repository;

    @NotNull
    private final MutableLiveData<TransferCheckData> transferCheckMutable;

    @NotNull
    private final MutableLiveData<DealerDetailBean> transferDataMutable;

    @NotNull
    private final BaseListData transferRecordData;

    @NotNull
    private final MutableLiveData<List<TransferRecordData>> transferRecordMutable;

    @NotNull
    private final MutableLiveData<Boolean> transferSuccessMutable;

    @NotNull
    private final MutableLiveData<List<User>> transferUserMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransferViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkTransferShare$lambda$12(TransferViewModel transferViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        TransferCheckData transferCheckData = (TransferCheckData) apiResponse.getData();
        if (transferCheckData != null) {
            transferViewModel.transferCheckMutable.setValue(transferCheckData);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkTransferShare$lambda$13(TransferViewModel transferViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTransferData$lambda$1(TransferViewModel transferViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferViewModel.transferDataMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getTransferData$lambda$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferDiamondDetail$lambda$15(TransferViewModel transferViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferViewModel.transferRecordData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            transferViewModel.transferRecordMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferDiamondDetail$lambda$16(TransferViewModel transferViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferViewModel.transferRecordData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferSearchUser$lambda$7(TransferViewModel transferViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        User user = (User) apiResponse.getData();
        if (user != null) {
            arrayList.add(user);
        }
        transferViewModel.transferUserMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferSearchUser$lambda$8(TransferViewModel transferViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferToUser$lambda$10(TransferViewModel transferViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferToUser$lambda$9(TransferViewModel transferViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        transferViewModel.transferSuccessMutable.setValue(Boolean.TRUE);
        transferViewModel.m٩٣getTransferData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferUserList$lambda$4(TransferViewModel transferViewModel, ApiList apiList) {
        Intrinsics.checkNotNullParameter(apiList, "it");
        List data = apiList.getData();
        if (data != null) {
            transferViewModel.transferUserMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit transferUserList$lambda$5(TransferViewModel transferViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        transferViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public final void checkTransferShare(@NotNull String externalId, int type) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.checkShare(externalId, type, 1), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.n2
            public final Object invoke(Object obj) {
                Unit checkTransferShare$lambda$12;
                checkTransferShare$lambda$12 = TransferViewModel.checkTransferShare$lambda$12(TransferViewModel.this, (ApiResponse) obj);
                return checkTransferShare$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.o2
            public final Object invoke(Object obj) {
                Unit checkTransferShare$lambda$13;
                checkTransferShare$lambda$13 = TransferViewModel.checkTransferShare$lambda$13(TransferViewModel.this, (Throwable) obj);
                return checkTransferShare$lambda$13;
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
    public final LiveData<TransferCheckData> getTransferCheck() {
        return this.transferCheckMutable;
    }

    @NotNull
    public final LiveData<DealerDetailBean> getTransferData() {
        return this.transferDataMutable;
    }

    @NotNull
    public final LiveData<List<TransferRecordData>> getTransferRecord() {
        return this.transferRecordMutable;
    }

    @NotNull
    public final BaseListData getTransferRecordData() {
        return this.transferRecordData;
    }

    @NotNull
    public final LiveData<Boolean> getTransferSuccess() {
        return this.transferSuccessMutable;
    }

    @NotNull
    public final LiveData<List<User>> getTransferUser() {
        return this.transferUserMutable;
    }

    protected void onCleared() {
        super.onCleared();
        this.transferRecordData.destroy();
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

    public final void transferDiamondDetail(int isPink) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferDiamondDetail(this.transferRecordData.getPageSize(), this.transferRecordData.nextPage(), isPink), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.r2
            public final Object invoke(Object obj) {
                Unit transferDiamondDetail$lambda$15;
                transferDiamondDetail$lambda$15 = TransferViewModel.transferDiamondDetail$lambda$15(TransferViewModel.this, (ApiResponse) obj);
                return transferDiamondDetail$lambda$15;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.s2
            public final Object invoke(Object obj) {
                Unit transferDiamondDetail$lambda$16;
                transferDiamondDetail$lambda$16 = TransferViewModel.transferDiamondDetail$lambda$16(TransferViewModel.this, (Throwable) obj);
                return transferDiamondDetail$lambda$16;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferSearchUser(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, Constants.KEY_HTTP_CODE);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferSearchUser(code), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.p2
            public final Object invoke(Object obj) {
                Unit transferSearchUser$lambda$7;
                transferSearchUser$lambda$7 = TransferViewModel.transferSearchUser$lambda$7(TransferViewModel.this, (ApiResponse) obj);
                return transferSearchUser$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.q2
            public final Object invoke(Object obj) {
                Unit transferSearchUser$lambda$8;
                transferSearchUser$lambda$8 = TransferViewModel.transferSearchUser$lambda$8(TransferViewModel.this, (Throwable) obj);
                return transferSearchUser$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferToUser(@NotNull String externalId, int productId, int isPink) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.sendDiamondToUser(externalId, productId, isPink), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.k2
            public final Object invoke(Object obj) {
                Unit transferToUser$lambda$9;
                transferToUser$lambda$9 = TransferViewModel.transferToUser$lambda$9(TransferViewModel.this, (ApiResponse) obj);
                return transferToUser$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.l2
            public final Object invoke(Object obj) {
                Unit transferToUser$lambda$10;
                transferToUser$lambda$10 = TransferViewModel.transferToUser$lambda$10(TransferViewModel.this, (Throwable) obj);
                return transferToUser$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void transferUserList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.transferUserList(), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.t2
            public final Object invoke(Object obj) {
                Unit transferUserList$lambda$4;
                transferUserList$lambda$4 = TransferViewModel.transferUserList$lambda$4(TransferViewModel.this, (ApiList) obj);
                return transferUserList$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.u2
            public final Object invoke(Object obj) {
                Unit transferUserList$lambda$5;
                transferUserList$lambda$5 = TransferViewModel.transferUserList$lambda$5(TransferViewModel.this, (Throwable) obj);
                return transferUserList$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public TransferViewModel(@NotNull UserService userService) {
        Intrinsics.checkNotNullParameter(userService, "repository");
        this.repository = userService;
        this.transferDataMutable = new MutableLiveData<>();
        this.transferUserMutable = new MutableLiveData<>();
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.transferRecordData = baseListData;
        this.transferRecordMutable = new MutableLiveData<>();
        this.transferSuccessMutable = new MutableLiveData<>();
        this.transferCheckMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    /* renamed from: getTransferData, reason: collision with other method in class */
    public final void m٩٣getTransferData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(this.repository.getDealerDetail(), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.j2
            public final Object invoke(Object obj) {
                Unit transferData$lambda$1;
                transferData$lambda$1 = TransferViewModel.getTransferData$lambda$1(TransferViewModel.this, (ApiResponse) obj);
                return transferData$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.m2
            public final Object invoke(Object obj) {
                Unit transferData$lambda$2;
                transferData$lambda$2 = TransferViewModel.getTransferData$lambda$2((Throwable) obj);
                return transferData$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public /* synthetic */ TransferViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
