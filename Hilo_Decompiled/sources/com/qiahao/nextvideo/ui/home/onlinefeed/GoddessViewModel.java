package com.qiahao.nextvideo.ui.home.onlinefeed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.utl.BaseMonitor;
import io.reactivex.rxjava3.core.i0;
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

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/GoddessViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/VideoCallService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/VideoCallService;)V", "goddessBaseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getGoddessBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setGoddessBaseListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "onGoddessListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "goddessList", "Landroidx/lifecycle/LiveData;", "getGoddessList", "()Landroidx/lifecycle/LiveData;", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "externalIdMutable", "", SupportGiftRankActivity.EXTERNAL_ID, "getExternalId", "requestGoddessHistory", "", OnlineCellViewHolder.CLICK_LIKE, "isLike", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoddessViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoddessViewModel.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/GoddessViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,86:1\n1#2:87\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GoddessViewModel extends BaseViewModel {

    @NotNull
    public static final String TYPE_GODDESS = "goddess";

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<String> externalIdMutable;

    @NotNull
    private BaseListData goddessBaseListData;

    @NotNull
    private final MutableLiveData<List<VideoBaseData>> onGoddessListMutable;

    @Nullable
    private final VideoCallService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GoddessViewModel() {
        this(r0, 1, r0);
        VideoCallService videoCallService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$3(GoddessViewModel goddessViewModel, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            goddessViewModel.externalIdMutable.setValue(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$5(GoddessViewModel goddessViewModel, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            goddessViewModel.externalIdMutable.setValue(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGoddessHistory$lambda$1(GoddessViewModel goddessViewModel, ApiResponse apiResponse) {
        List list;
        List<VideoBaseData> data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            MMKVToLocalCache.INSTANCE.saveSayHiCache(data);
        }
        goddessViewModel.goddessBaseListData.setList((ApiList) apiResponse.getData());
        MutableLiveData<List<VideoBaseData>> mutableLiveData = goddessViewModel.onGoddessListMutable;
        ApiList apiList2 = (ApiList) apiResponse.getData();
        if (apiList2 != null) {
            list = apiList2.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGoddessHistory$lambda$2(GoddessViewModel goddessViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        goddessViewModel.goddessBaseListData.requestError();
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<String> getExternalId() {
        return this.externalIdMutable;
    }

    @NotNull
    public final BaseListData getGoddessBaseListData() {
        return this.goddessBaseListData;
    }

    @NotNull
    public final LiveData<List<VideoBaseData>> getGoddessList() {
        return this.onGoddessListMutable;
    }

    public final void like(@NotNull final String externalId, boolean isLike) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        this.externalIdMutable.setValue("");
        if (isLike) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().unlike(externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.n
                public final Object invoke(Object obj) {
                    Unit like$lambda$3;
                    like$lambda$3 = GoddessViewModel.like$lambda$3(GoddessViewModel.this, externalId, (ApiResponse) obj);
                    return like$lambda$3;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.o
                public final Object invoke(Object obj) {
                    Unit like$lambda$4;
                    like$lambda$4 = GoddessViewModel.like$lambda$4((Throwable) obj);
                    return like$lambda$4;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().like(externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.p
                public final Object invoke(Object obj) {
                    Unit like$lambda$5;
                    like$lambda$5 = GoddessViewModel.like$lambda$5(GoddessViewModel.this, externalId, (ApiResponse) obj);
                    return like$lambda$5;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.q
                public final Object invoke(Object obj) {
                    Unit like$lambda$6;
                    like$lambda$6 = GoddessViewModel.like$lambda$6((Throwable) obj);
                    return like$lambda$6;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }

    public final void requestGoddessHistory() {
        i0<ApiResponse<ApiList<VideoBaseData>>> videoGoddessList;
        nd.c observeOnMainThread$default;
        VideoCallService videoCallService = this.repository;
        if (videoCallService != null && (videoGoddessList = videoCallService.videoGoddessList(this.goddessBaseListData.getPageSize(), this.goddessBaseListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(videoGoddessList, new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.l
            public final Object invoke(Object obj) {
                Unit requestGoddessHistory$lambda$1;
                requestGoddessHistory$lambda$1 = GoddessViewModel.requestGoddessHistory$lambda$1(GoddessViewModel.this, (ApiResponse) obj);
                return requestGoddessHistory$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.m
            public final Object invoke(Object obj) {
                Unit requestGoddessHistory$lambda$2;
                requestGoddessHistory$lambda$2 = GoddessViewModel.requestGoddessHistory$lambda$2(GoddessViewModel.this, (Throwable) obj);
                return requestGoddessHistory$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void setGoddessBaseListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.goddessBaseListData = baseListData;
    }

    public GoddessViewModel(@Nullable VideoCallService videoCallService) {
        this.repository = videoCallService;
        this.goddessBaseListData = new BaseListData();
        this.onGoddessListMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.externalIdMutable = new MutableLiveData<>();
    }

    public /* synthetic */ GoddessViewModel(VideoCallService videoCallService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new VideoCallService() : videoCallService);
    }
}
