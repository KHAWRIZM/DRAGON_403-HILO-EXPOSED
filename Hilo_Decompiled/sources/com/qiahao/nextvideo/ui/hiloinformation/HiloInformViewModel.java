package com.qiahao.nextvideo.ui.hiloinformation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.HiloInformationCellUIModel;
import com.qiahao.nextvideo.data.model.HiloInformationItem;
import com.qiahao.nextvideo.network.AppServer;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u000f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e0\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "hiloInfoData", "Lcom/qiahao/base_common/model/BaseListData;", "getHiloInfoData", "()Lcom/qiahao/base_common/model/BaseListData;", "setHiloInfoData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "hiloInfoListMutable", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/HiloInformationCellUIModel;", "Lkotlin/collections/ArrayList;", "hiloInfoList", "Landroidx/lifecycle/LiveData;", "getHiloInfoList", "()Landroidx/lifecycle/LiveData;", "getHiloInfo", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloInformViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloInformViewModel.kt\ncom/qiahao/nextvideo/ui/hiloinformation/HiloInformViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,48:1\n1869#2,2:49\n*S KotlinDebug\n*F\n+ 1 HiloInformViewModel.kt\ncom/qiahao/nextvideo/ui/hiloinformation/HiloInformViewModel\n*L\n32#1:49,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloInformViewModel extends BaseViewModel {

    @NotNull
    private BaseListData hiloInfoData = new BaseListData();

    @NotNull
    private final MutableLiveData<ArrayList<HiloInformationCellUIModel>> hiloInfoListMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getHiloInfo$lambda$1(HiloInformViewModel hiloInformViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        hiloInformViewModel.hiloInfoData.setList((List) apiResponse.getData());
        List list = (List) apiResponse.getData();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(HiloInformationCellUIModel.INSTANCE.init((HiloInformationItem) it.next()));
            }
        }
        hiloInformViewModel.hiloInfoListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getHiloInfo$lambda$2(HiloInformViewModel hiloInformViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        hiloInformViewModel.hiloInfoData.requestError();
        return Unit.INSTANCE;
    }

    public final void getHiloInfo() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().fetchHiloInformations(this.hiloInfoData.getPageSize(), this.hiloInfoData.nextPage()), new Function1() { // from class: com.qiahao.nextvideo.ui.hiloinformation.l
            public final Object invoke(Object obj) {
                Unit hiloInfo$lambda$1;
                hiloInfo$lambda$1 = HiloInformViewModel.getHiloInfo$lambda$1(HiloInformViewModel.this, (ApiResponse) obj);
                return hiloInfo$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.hiloinformation.m
            public final Object invoke(Object obj) {
                Unit hiloInfo$lambda$2;
                hiloInfo$lambda$2 = HiloInformViewModel.getHiloInfo$lambda$2(HiloInformViewModel.this, (Throwable) obj);
                return hiloInfo$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final BaseListData getHiloInfoData() {
        return this.hiloInfoData;
    }

    @NotNull
    public final LiveData<ArrayList<HiloInformationCellUIModel>> getHiloInfoList() {
        return this.hiloInfoListMutable;
    }

    protected void onCleared() {
        super.onCleared();
        this.hiloInfoData.destroy();
    }

    public final void setHiloInfoData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.hiloInfoData = baseListData;
    }
}
