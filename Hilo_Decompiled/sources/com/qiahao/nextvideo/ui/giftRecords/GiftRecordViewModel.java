package com.qiahao.nextvideo.ui.giftRecords;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.giftRecord.GiftRecordData;
import com.qiahao.nextvideo.network.AppServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "giftType", "", "getGiftType", "()I", "setGiftType", "(I)V", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "giftListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/giftRecord/GiftRecordData;", "giftList", "Landroidx/lifecycle/LiveData;", "getGiftList", "()Landroidx/lifecycle/LiveData;", "getGiftRecord", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftRecordViewModel extends BaseViewModel {

    @NotNull
    private final BaseListData baseListData;

    @NotNull
    private final MutableLiveData<List<GiftRecordData>> giftListMutable;
    private int giftType = 1;

    public GiftRecordViewModel() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.baseListData = baseListData;
        this.giftListMutable = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGiftRecord$lambda$1(GiftRecordViewModel giftRecordViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        BaseListData baseListData = giftRecordViewModel.baseListData;
        ApiList apiList = (ApiList) apiResponse.getData();
        List list2 = null;
        if (apiList != null) {
            list = apiList.getData();
        } else {
            list = null;
        }
        baseListData.setList(list);
        MutableLiveData<List<GiftRecordData>> mutableLiveData = giftRecordViewModel.giftListMutable;
        ApiList apiList2 = (ApiList) apiResponse.getData();
        if (apiList2 != null) {
            list2 = apiList2.getData();
        }
        mutableLiveData.setValue(list2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGiftRecord$lambda$2(GiftRecordViewModel giftRecordViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        giftRecordViewModel.baseListData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    @NotNull
    public final LiveData<List<GiftRecordData>> getGiftList() {
        return this.giftListMutable;
    }

    public final void getGiftRecord() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().giftRecord(this.baseListData.nextPage(), this.baseListData.getPageSize(), this.giftType), new Function1() { // from class: com.qiahao.nextvideo.ui.giftRecords.j
            public final Object invoke(Object obj) {
                Unit giftRecord$lambda$1;
                giftRecord$lambda$1 = GiftRecordViewModel.getGiftRecord$lambda$1(GiftRecordViewModel.this, (ApiResponse) obj);
                return giftRecord$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.giftRecords.k
            public final Object invoke(Object obj) {
                Unit giftRecord$lambda$2;
                giftRecord$lambda$2 = GiftRecordViewModel.getGiftRecord$lambda$2(GiftRecordViewModel.this, (Throwable) obj);
                return giftRecord$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final int getGiftType() {
        return this.giftType;
    }

    protected void onCleared() {
        super.onCleared();
        this.baseListData.destroy();
    }

    public final void setGiftType(int i) {
        this.giftType = i;
    }
}
