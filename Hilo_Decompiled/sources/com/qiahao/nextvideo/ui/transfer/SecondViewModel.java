package com.qiahao.nextvideo.ui.transfer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.transfer.SecondMonth;
import com.qiahao.nextvideo.data.transfer.SecondRank;
import com.qiahao.nextvideo.data.transfer.TransferMonth;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.data.transfer.TransferRecordData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020'J\u0016\u0010\u0012\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u0016\u0010+\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)J\u0016\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/J\u0006\u0010%\u001a\u00020'J\u0006\u00100\u001a\u00020'R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\nR\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\b8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\nR\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\nR\u0011\u0010 \u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\u00100\b8F¢\u0006\u0006\u001a\u0004\b%\u0010\n¨\u00062"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "periodMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/transfer/TransferPeriod;", "period", "Landroidx/lifecycle/LiveData;", "getPeriod", "()Landroidx/lifecycle/LiveData;", "secondRankData", "Lcom/qiahao/base_common/model/BaseListData;", "getSecondRankData", "()Lcom/qiahao/base_common/model/BaseListData;", "secondRankMutable", "Lcom/qiahao/base_common/model/ApiList;", "Lcom/qiahao/nextvideo/data/transfer/SecondRank;", "secondRank", "getSecondRank", "transferMonthMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferMonth;", "transferMonth", "getTransferMonth", "searchMutable", "Lcom/qiahao/nextvideo/data/transfer/SecondMonth;", "search", "getSearch", "promoteMutable", "Lcom/qiahao/nextvideo/data/model/DealerDetailBean;", "promote", "getPromote", "secondDetailData", "getSecondDetailData", "secondDetailMutable", "Lcom/qiahao/nextvideo/data/transfer/TransferRecordData;", "secondDetail", "getSecondDetail", "secondPeriod", "", "beginDate", "", "endDate", "secondRange", "secondShift", SupportGiftRankActivity.EXTERNAL_ID, "resId", "", "secondDiamondDetail", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondViewModel extends BaseViewModel {

    @NotNull
    public static final String SECOND_SHIFT = "SECOND_SHIFT";

    @NotNull
    private final MutableLiveData<TransferPeriod> periodMutable = new MutableLiveData<>();

    @NotNull
    private final BaseListData secondRankData = new BaseListData();

    @NotNull
    private final MutableLiveData<ApiList<SecondRank>> secondRankMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<TransferMonth> transferMonthMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<SecondMonth> searchMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<DealerDetailBean> promoteMutable = new MutableLiveData<>();

    @NotNull
    private final BaseListData secondDetailData = new BaseListData();

    @NotNull
    private final MutableLiveData<ApiList<TransferRecordData>> secondDetailMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSecondDetail$lambda$10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSecondDetail$lambda$9(SecondViewModel secondViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        secondViewModel.promoteMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondDiamondDetail$lambda$12(SecondViewModel secondViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        secondViewModel.secondDetailData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            secondViewModel.secondDetailMutable.setValue(apiList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondDiamondDetail$lambda$13(SecondViewModel secondViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        secondViewModel.secondDetailData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondPeriod$lambda$0(SecondViewModel secondViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        secondViewModel.periodMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondPeriod$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondRange$lambda$5(SecondViewModel secondViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        secondViewModel.searchMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondRange$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondRank$lambda$3(SecondViewModel secondViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        secondViewModel.secondRankData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            secondViewModel.secondRankMutable.setValue(apiList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondRank$lambda$4(SecondViewModel secondViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        secondViewModel.secondRankData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondShift$lambda$7(SecondViewModel secondViewModel, ApiResponse apiResponse) {
        Long l;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            l = Long.valueOf((long) channelEventGiftAddTime.getDiamondNum());
        } else {
            l = null;
        }
        IStore.DefaultImpls.setValue$default(mMKVStore, "availDiamond", l, (String) null, 4, (Object) null);
        secondViewModel.getMSuccess().setValue(new Pair(SECOND_SHIFT, Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit secondShift$lambda$8(SecondViewModel secondViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        secondViewModel.getMException().setValue(new Pair(SECOND_SHIFT, th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<TransferPeriod> getPeriod() {
        return this.periodMutable;
    }

    @NotNull
    public final LiveData<DealerDetailBean> getPromote() {
        return this.promoteMutable;
    }

    @NotNull
    public final LiveData<SecondMonth> getSearch() {
        return this.searchMutable;
    }

    @NotNull
    public final LiveData<ApiList<TransferRecordData>> getSecondDetail() {
        return this.secondDetailMutable;
    }

    @NotNull
    public final BaseListData getSecondDetailData() {
        return this.secondDetailData;
    }

    @NotNull
    public final LiveData<ApiList<SecondRank>> getSecondRank() {
        return this.secondRankMutable;
    }

    @NotNull
    public final BaseListData getSecondRankData() {
        return this.secondRankData;
    }

    @NotNull
    public final LiveData<TransferMonth> getTransferMonth() {
        return this.transferMonthMutable;
    }

    public final void secondDiamondDetail() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().secondDiamondDetail(this.secondDetailData.getPageSize(), this.secondDetailData.nextPage()), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.a0
            public final Object invoke(Object obj) {
                Unit secondDiamondDetail$lambda$12;
                secondDiamondDetail$lambda$12 = SecondViewModel.secondDiamondDetail$lambda$12(SecondViewModel.this, (ApiResponse) obj);
                return secondDiamondDetail$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.b0
            public final Object invoke(Object obj) {
                Unit secondDiamondDetail$lambda$13;
                secondDiamondDetail$lambda$13 = SecondViewModel.secondDiamondDetail$lambda$13(SecondViewModel.this, (Throwable) obj);
                return secondDiamondDetail$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void secondPeriod() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().transferPeriod(), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.j0
            public final Object invoke(Object obj) {
                Unit secondPeriod$lambda$0;
                secondPeriod$lambda$0 = SecondViewModel.secondPeriod$lambda$0(SecondViewModel.this, (ApiResponse) obj);
                return secondPeriod$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.k0
            public final Object invoke(Object obj) {
                Unit secondPeriod$lambda$1;
                secondPeriod$lambda$1 = SecondViewModel.secondPeriod$lambda$1((Throwable) obj);
                return secondPeriod$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void secondRange(@NotNull String beginDate, @NotNull String endDate) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().secondRange(beginDate, endDate), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.z
            public final Object invoke(Object obj) {
                Unit secondRange$lambda$5;
                secondRange$lambda$5 = SecondViewModel.secondRange$lambda$5(SecondViewModel.this, (ApiResponse) obj);
                return secondRange$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.c0
            public final Object invoke(Object obj) {
                Unit secondRange$lambda$6;
                secondRange$lambda$6 = SecondViewModel.secondRange$lambda$6((Throwable) obj);
                return secondRange$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void secondRank(@NotNull String beginDate, @NotNull String endDate) {
        Intrinsics.checkNotNullParameter(beginDate, "beginDate");
        Intrinsics.checkNotNullParameter(endDate, "endDate");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().secondRank(beginDate, endDate, this.secondRankData.nextPage(), this.secondRankData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.h0
            public final Object invoke(Object obj) {
                Unit secondRank$lambda$3;
                secondRank$lambda$3 = SecondViewModel.secondRank$lambda$3(SecondViewModel.this, (ApiResponse) obj);
                return secondRank$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.i0
            public final Object invoke(Object obj) {
                Unit secondRank$lambda$4;
                secondRank$lambda$4 = SecondViewModel.secondRank$lambda$4(SecondViewModel.this, (Throwable) obj);
                return secondRank$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void secondShift(@NotNull String externalId, int resId) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().secondShift(externalId, resId), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.f0
            public final Object invoke(Object obj) {
                Unit secondShift$lambda$7;
                secondShift$lambda$7 = SecondViewModel.secondShift$lambda$7(SecondViewModel.this, (ApiResponse) obj);
                return secondShift$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.g0
            public final Object invoke(Object obj) {
                Unit secondShift$lambda$8;
                secondShift$lambda$8 = SecondViewModel.secondShift$lambda$8(SecondViewModel.this, (Throwable) obj);
                return secondShift$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getSecondDetail, reason: collision with other method in class */
    public final void m٩٢getSecondDetail() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPromoteDetail(2), new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.d0
            public final Object invoke(Object obj) {
                Unit secondDetail$lambda$9;
                secondDetail$lambda$9 = SecondViewModel.getSecondDetail$lambda$9(SecondViewModel.this, (ApiResponse) obj);
                return secondDetail$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.e0
            public final Object invoke(Object obj) {
                Unit secondDetail$lambda$10;
                secondDetail$lambda$10 = SecondViewModel.getSecondDetail$lambda$10((Throwable) obj);
                return secondDetail$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
