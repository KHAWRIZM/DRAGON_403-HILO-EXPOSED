package com.qiahao.nextvideo.ui.baishun;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.baishun.BaiShunActivityData;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.network.AppServer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0015\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00130\tX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0014\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00130\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/baishun/BaiShunViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "baiShunBaseData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaiShunBaseData", "()Lcom/qiahao/base_common/model/BaseListData;", "baiShunListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/baishun/BaiShunActivityData;", "baiShunList", "Landroidx/lifecycle/LiveData;", "getBaiShunList", "()Landroidx/lifecycle/LiveData;", "gameListMutable", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lkotlin/collections/ArrayList;", "gameList", "getGameList", "getGameActivity", "", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BaiShunViewModel extends BaseViewModel {

    @NotNull
    public static final String GAME_ACTIVITY = "game_activity";

    @NotNull
    private final BaseListData baiShunBaseData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<BaiShunActivityData>> baiShunListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<ArrayList<GameConfiguration>> gameListMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameActivity$lambda$0(BaiShunViewModel baiShunViewModel, ApiResponse apiResponse) {
        Object arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        baiShunViewModel.baiShunBaseData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<BaiShunActivityData>> mutableLiveData = baiShunViewModel.baiShunListMutable;
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList == null || (arrayList = apiList.getData()) == null) {
            arrayList = new ArrayList();
        }
        mutableLiveData.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameActivity$lambda$1(BaiShunViewModel baiShunViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        baiShunViewModel.getMException().setValue(new Pair(GAME_ACTIVITY, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameList$lambda$3(BaiShunViewModel baiShunViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            baiShunViewModel.gameListMutable.setValue(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGameList$lambda$4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @NotNull
    public final BaseListData getBaiShunBaseData() {
        return this.baiShunBaseData;
    }

    @NotNull
    public final LiveData<List<BaiShunActivityData>> getBaiShunList() {
        return this.baiShunListMutable;
    }

    public final void getGameActivity() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().baiShunBannerList(this.baiShunBaseData.nextPage(), this.baiShunBaseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.n
            public final Object invoke(Object obj) {
                Unit gameActivity$lambda$0;
                gameActivity$lambda$0 = BaiShunViewModel.getGameActivity$lambda$0(BaiShunViewModel.this, (ApiResponse) obj);
                return gameActivity$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.o
            public final Object invoke(Object obj) {
                Unit gameActivity$lambda$1;
                gameActivity$lambda$1 = BaiShunViewModel.getGameActivity$lambda$1(BaiShunViewModel.this, (Throwable) obj);
                return gameActivity$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<ArrayList<GameConfiguration>> getGameList() {
        return this.gameListMutable;
    }

    protected void onCleared() {
        super.onCleared();
        this.baiShunBaseData.destroy();
    }

    /* renamed from: getGameList, reason: collision with other method in class */
    public final void m٦٤getGameList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().baiShunGameList(), new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.l
            public final Object invoke(Object obj) {
                Unit gameList$lambda$3;
                gameList$lambda$3 = BaiShunViewModel.getGameList$lambda$3(BaiShunViewModel.this, (ApiResponse) obj);
                return gameList$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.baishun.m
            public final Object invoke(Object obj) {
                Unit gameList$lambda$4;
                gameList$lambda$4 = BaiShunViewModel.getGameList$lambda$4((Throwable) obj);
                return gameList$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
