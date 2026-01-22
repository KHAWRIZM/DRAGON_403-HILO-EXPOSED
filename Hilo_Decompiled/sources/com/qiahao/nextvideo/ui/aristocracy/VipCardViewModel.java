package com.qiahao.nextvideo.ui.aristocracy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.noble.NobleCard;
import com.qiahao.nextvideo.data.noble.NobleCardLog;
import com.qiahao.nextvideo.network.AppServer;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00120\u00158F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/VipCardViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "mFragmentType", "", "getMFragmentType", "()Ljava/lang/String;", "setMFragmentType", "(Ljava/lang/String;)V", "vipRecordData", "Lcom/qiahao/base_common/model/BaseListData;", "getVipRecordData", "()Lcom/qiahao/base_common/model/BaseListData;", "setVipRecordData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "vipRecordListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/noble/NobleCardLog;", "vipRecordList", "Landroidx/lifecycle/LiveData;", "getVipRecordList", "()Landroidx/lifecycle/LiveData;", "nobleListData", "getNobleListData", "setNobleListData", "nobleListMutable", "Lcom/qiahao/nextvideo/data/noble/NobleCard;", "nobleList", "getNobleList", "nobleCard", "", "useNobleCard", AgooConstants.MESSAGE_ID, "", "getVipRecord", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VipCardViewModel extends BaseViewModel {

    @NotNull
    public static final String TYPE_NOBLE_USE = "TYPE_NOBLE_USE";

    @NotNull
    private String mFragmentType = VipRecordFragment.TYPE_VIP;

    @NotNull
    private BaseListData vipRecordData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<NobleCardLog>> vipRecordListMutable = new MutableLiveData<>();

    @NotNull
    private BaseListData nobleListData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<NobleCard>> nobleListMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getVipRecord$lambda$6(VipCardViewModel vipCardViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        vipCardViewModel.vipRecordData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            vipCardViewModel.vipRecordListMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getVipRecord$lambda$7(VipCardViewModel vipCardViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        vipCardViewModel.vipRecordData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit nobleCard$lambda$1(VipCardViewModel vipCardViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        vipCardViewModel.nobleListData.setList((List) apiResponse.getData());
        List list = (List) apiResponse.getData();
        if (list != null) {
            vipCardViewModel.nobleListMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit nobleCard$lambda$2(VipCardViewModel vipCardViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        vipCardViewModel.nobleListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useNobleCard$lambda$3(VipCardViewModel vipCardViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        vipCardViewModel.getMSuccess().setValue(new Pair(TYPE_NOBLE_USE, apiResponse.getData()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit useNobleCard$lambda$4(VipCardViewModel vipCardViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        vipCardViewModel.getMException().setValue(new Pair(TYPE_NOBLE_USE, th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final String getMFragmentType() {
        return this.mFragmentType;
    }

    @NotNull
    public final LiveData<List<NobleCard>> getNobleList() {
        return this.nobleListMutable;
    }

    @NotNull
    public final BaseListData getNobleListData() {
        return this.nobleListData;
    }

    public final void getVipRecord() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().nobleCardLog(this.vipRecordData.nextPage(), this.vipRecordData.getPageSize(), Intrinsics.areEqual(this.mFragmentType, VipRecordFragment.TYPE_VIP) ? 1 : 0), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.t0
            public final Object invoke(Object obj) {
                Unit vipRecord$lambda$6;
                vipRecord$lambda$6 = VipCardViewModel.getVipRecord$lambda$6(VipCardViewModel.this, (ApiResponse) obj);
                return vipRecord$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.u0
            public final Object invoke(Object obj) {
                Unit vipRecord$lambda$7;
                vipRecord$lambda$7 = VipCardViewModel.getVipRecord$lambda$7(VipCardViewModel.this, (Throwable) obj);
                return vipRecord$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final BaseListData getVipRecordData() {
        return this.vipRecordData;
    }

    @NotNull
    public final LiveData<List<NobleCardLog>> getVipRecordList() {
        return this.vipRecordListMutable;
    }

    public final void nobleCard() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().nobleCard(), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.v0
            public final Object invoke(Object obj) {
                Unit nobleCard$lambda$1;
                nobleCard$lambda$1 = VipCardViewModel.nobleCard$lambda$1(VipCardViewModel.this, (ApiResponse) obj);
                return nobleCard$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.w0
            public final Object invoke(Object obj) {
                Unit nobleCard$lambda$2;
                nobleCard$lambda$2 = VipCardViewModel.nobleCard$lambda$2(VipCardViewModel.this, (Throwable) obj);
                return nobleCard$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setMFragmentType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mFragmentType = str;
    }

    public final void setNobleListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.nobleListData = baseListData;
    }

    public final void setVipRecordData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.vipRecordData = baseListData;
    }

    public final void useNobleCard(int id2) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().useNobleCard(id2), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.x0
            public final Object invoke(Object obj) {
                Unit useNobleCard$lambda$3;
                useNobleCard$lambda$3 = VipCardViewModel.useNobleCard$lambda$3(VipCardViewModel.this, (ApiResponse) obj);
                return useNobleCard$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.y0
            public final Object invoke(Object obj) {
                Unit useNobleCard$lambda$4;
                useNobleCard$lambda$4 = VipCardViewModel.useNobleCard$lambda$4(VipCardViewModel.this, (Throwable) obj);
                return useNobleCard$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
