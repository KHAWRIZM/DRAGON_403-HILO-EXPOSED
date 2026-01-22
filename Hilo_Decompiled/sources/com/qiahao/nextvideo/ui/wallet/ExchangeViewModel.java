package com.qiahao.nextvideo.ui.wallet;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.network.model.UserCostDiamondsDetail;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.BeanChangeDetail;
import com.qiahao.nextvideo.data.model.ExchangeDetailData;
import com.qiahao.nextvideo.data.model.PurchaseItem;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0017H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/ExchangeViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "exchangeType", "", "getExchangeType", "()Ljava/lang/String;", "setExchangeType", "(Ljava/lang/String;)V", "exchangeData", "Lcom/qiahao/base_common/model/BaseListData;", "getExchangeData", "()Lcom/qiahao/base_common/model/BaseListData;", "exchangeListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/ExchangeDetailData;", "exchangeList", "Landroidx/lifecycle/LiveData;", "getExchangeList", "()Landroidx/lifecycle/LiveData;", "getList", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExchangeViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExchangeViewModel.kt\ncom/qiahao/nextvideo/ui/wallet/ExchangeViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,108:1\n1#2:109\n1869#3,2:110\n1869#3,2:112\n1869#3,2:114\n1869#3,2:116\n*S KotlinDebug\n*F\n+ 1 ExchangeViewModel.kt\ncom/qiahao/nextvideo/ui/wallet/ExchangeViewModel\n*L\n41#1:110,2\n56#1:112,2\n71#1:114,2\n90#1:116,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ExchangeViewModel extends BaseViewModel {

    @NotNull
    private final BaseListData exchangeData;

    @NotNull
    private final MutableLiveData<List<ExchangeDetailData>> exchangeListMutable;

    @NotNull
    private String exchangeType = "";

    public ExchangeViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.exchangeData = baseListData;
        this.exchangeListMutable = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$11(ExchangeViewModel exchangeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        exchangeViewModel.exchangeData.setList((List) apiResponse.getData());
        ArrayList arrayList = new ArrayList();
        List list = (List) apiResponse.getData();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DataExternalKt.toExchangeDetailData((UserCostDiamondsDetail) it.next(), false));
            }
        }
        exchangeViewModel.exchangeListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$12(ExchangeViewModel exchangeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        exchangeViewModel.exchangeData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$2(ExchangeViewModel exchangeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        exchangeViewModel.exchangeData.setList((List) apiResponse.getData());
        ArrayList arrayList = new ArrayList();
        List list = (List) apiResponse.getData();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DataExternalKt.toExchangeDetailData$default((UserCostDiamondsDetail) it.next(), false, 1, null));
            }
        }
        exchangeViewModel.exchangeListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$3(ExchangeViewModel exchangeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        exchangeViewModel.exchangeData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$5(ExchangeViewModel exchangeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        exchangeViewModel.exchangeData.setList((List) apiResponse.getData());
        ArrayList arrayList = new ArrayList();
        List list = (List) apiResponse.getData();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DataExternalKt.toExchangeDetailData((BeanChangeDetail) it.next()));
            }
        }
        exchangeViewModel.exchangeListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$6(ExchangeViewModel exchangeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        exchangeViewModel.exchangeData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$8(ExchangeViewModel exchangeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        exchangeViewModel.exchangeData.setList((List) apiResponse.getData());
        ArrayList arrayList = new ArrayList();
        List list = (List) apiResponse.getData();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DataExternalKt.toExchangeDetailData((PurchaseItem) it.next()));
            }
        }
        exchangeViewModel.exchangeListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getList$lambda$9(ExchangeViewModel exchangeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        exchangeViewModel.exchangeData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final BaseListData getExchangeData() {
        return this.exchangeData;
    }

    @NotNull
    public final LiveData<List<ExchangeDetailData>> getExchangeList() {
        return this.exchangeListMutable;
    }

    @NotNull
    public final String getExchangeType() {
        return this.exchangeType;
    }

    @SuppressLint({"CheckResult"})
    public final void getList() {
        String str = this.exchangeType;
        switch (str.hashCode()) {
            case -806191449:
                if (str.equals(ExchangeDetailActivity.TYPE_RECHARGE)) {
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserPaymentsDetail(this.exchangeData.nextPage(), this.exchangeData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.q
                        public final Object invoke(Object obj) {
                            Unit list$lambda$8;
                            list$lambda$8 = ExchangeViewModel.getList$lambda$8(ExchangeViewModel.this, (ApiResponse) obj);
                            return list$lambda$8;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.r
                        public final Object invoke(Object obj) {
                            Unit list$lambda$9;
                            list$lambda$9 = ExchangeViewModel.getList$lambda$9(ExchangeViewModel.this, (Throwable) obj);
                            return list$lambda$9;
                        }
                    }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                    return;
                }
                return;
            case 93610691:
                if (str.equals(ExchangeDetailActivity.TYPE_BEANS)) {
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getBeanDetail(this.exchangeData.nextPage(), this.exchangeData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.o
                        public final Object invoke(Object obj) {
                            Unit list$lambda$5;
                            list$lambda$5 = ExchangeViewModel.getList$lambda$5(ExchangeViewModel.this, (ApiResponse) obj);
                            return list$lambda$5;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.p
                        public final Object invoke(Object obj) {
                            Unit list$lambda$6;
                            list$lambda$6 = ExchangeViewModel.getList$lambda$6(ExchangeViewModel.this, (Throwable) obj);
                            return list$lambda$6;
                        }
                    }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                    return;
                }
                return;
            case 94839810:
                if (str.equals(ExchangeDetailActivity.TYPE_COINS)) {
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().userDiamondsDetail(this.exchangeData.nextPage(), this.exchangeData.getPageSize(), 1), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.s
                        public final Object invoke(Object obj) {
                            Unit list$lambda$11;
                            list$lambda$11 = ExchangeViewModel.getList$lambda$11(ExchangeViewModel.this, (ApiResponse) obj);
                            return list$lambda$11;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.t
                        public final Object invoke(Object obj) {
                            Unit list$lambda$12;
                            list$lambda$12 = ExchangeViewModel.getList$lambda$12(ExchangeViewModel.this, (Throwable) obj);
                            return list$lambda$12;
                        }
                    }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                    return;
                }
                return;
            case 1655054676:
                if (str.equals(ExchangeDetailActivity.TYPE_DIAMOND)) {
                    RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.userDiamondsDetail$default(UserService.INSTANCE.getShared(), this.exchangeData.nextPage(), this.exchangeData.getPageSize(), 0, 4, null), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.m
                        public final Object invoke(Object obj) {
                            Unit list$lambda$2;
                            list$lambda$2 = ExchangeViewModel.getList$lambda$2(ExchangeViewModel.this, (ApiResponse) obj);
                            return list$lambda$2;
                        }
                    }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.n
                        public final Object invoke(Object obj) {
                            Unit list$lambda$3;
                            list$lambda$3 = ExchangeViewModel.getList$lambda$3(ExchangeViewModel.this, (Throwable) obj);
                            return list$lambda$3;
                        }
                    }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.exchangeData.destroy();
    }

    public final void setExchangeType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.exchangeType = str;
    }
}
