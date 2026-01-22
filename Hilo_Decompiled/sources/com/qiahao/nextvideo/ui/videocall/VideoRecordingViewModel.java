package com.qiahao.nextvideo.ui.videocall;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.data.service.VideoCallService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.home.onlinefeed.OnlineCellViewHolder;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\u0006\u0010*\u001a\u00020(J\u0016\u0010+\u001a\u00020(2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020(H\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00170\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00170\u001a8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001cR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001a8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001cR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001c¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/VideoCallService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/VideoCallService;)V", "fragmentType", "", "getFragmentType", "()Ljava/lang/String;", "setFragmentType", "(Ljava/lang/String;)V", "matchBaseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getMatchBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setMatchBaseListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "missBaseListData", "getMissBaseListData", "setMissBaseListData", "onMatchListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/VideoBaseData;", "matchList", "Landroidx/lifecycle/LiveData;", "getMatchList", "()Landroidx/lifecycle/LiveData;", "onMissListMutable", "missList", "getMissList", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "externalIdMutable", SupportGiftRankActivity.EXTERNAL_ID, "getExternalId", "requestMatchHistory", "", "requestMissHistory", "requestHistory", OnlineCellViewHolder.CLICK_LIKE, "isLike", "", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoRecordingViewModel extends BaseViewModel {

    @NotNull
    public static final String TYPE_MATCH = "match";

    @NotNull
    public static final String TYPE_MISS = "miss";

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<String> externalIdMutable;

    @NotNull
    private String fragmentType;

    @NotNull
    private BaseListData matchBaseListData;

    @NotNull
    private BaseListData missBaseListData;

    @NotNull
    private final MutableLiveData<List<VideoBaseData>> onMatchListMutable;

    @NotNull
    private final MutableLiveData<List<VideoBaseData>> onMissListMutable;

    @Nullable
    private final VideoCallService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoRecordingViewModel() {
        this(r0, 1, r0);
        VideoCallService videoCallService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$4(VideoRecordingViewModel videoRecordingViewModel, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            videoRecordingViewModel.externalIdMutable.setValue(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$6(VideoRecordingViewModel videoRecordingViewModel, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.isOk()) {
            videoRecordingViewModel.externalIdMutable.setValue(str);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit like$lambda$7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void requestMatchHistory() {
        io.reactivex.rxjava3.core.i0<ApiResponse<List<VideoBaseData>>> videoMatchingHistory;
        nd.c observeOnMainThread$default;
        VideoCallService videoCallService = this.repository;
        if (videoCallService != null && (videoMatchingHistory = videoCallService.videoMatchingHistory("match", this.matchBaseListData.getPageSize(), this.matchBaseListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(videoMatchingHistory, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.x
            public final Object invoke(Object obj) {
                Unit requestMatchHistory$lambda$0;
                requestMatchHistory$lambda$0 = VideoRecordingViewModel.requestMatchHistory$lambda$0(VideoRecordingViewModel.this, (ApiResponse) obj);
                return requestMatchHistory$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.y
            public final Object invoke(Object obj) {
                Unit requestMatchHistory$lambda$1;
                requestMatchHistory$lambda$1 = VideoRecordingViewModel.requestMatchHistory$lambda$1(VideoRecordingViewModel.this, (Throwable) obj);
                return requestMatchHistory$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMatchHistory$lambda$0(VideoRecordingViewModel videoRecordingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        videoRecordingViewModel.matchBaseListData.setList((List) apiResponse.getData());
        videoRecordingViewModel.onMatchListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMatchHistory$lambda$1(VideoRecordingViewModel videoRecordingViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        videoRecordingViewModel.matchBaseListData.requestError();
        return Unit.INSTANCE;
    }

    private final void requestMissHistory() {
        io.reactivex.rxjava3.core.i0<ApiResponse<List<VideoBaseData>>> videoMatchingHistory;
        nd.c observeOnMainThread$default;
        VideoCallService videoCallService = this.repository;
        if (videoCallService != null && (videoMatchingHistory = videoCallService.videoMatchingHistory(TYPE_MISS, this.missBaseListData.getPageSize(), this.missBaseListData.nextPage())) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(videoMatchingHistory, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.z
            public final Object invoke(Object obj) {
                Unit requestMissHistory$lambda$2;
                requestMissHistory$lambda$2 = VideoRecordingViewModel.requestMissHistory$lambda$2(VideoRecordingViewModel.this, (ApiResponse) obj);
                return requestMissHistory$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.a0
            public final Object invoke(Object obj) {
                Unit requestMissHistory$lambda$3;
                requestMissHistory$lambda$3 = VideoRecordingViewModel.requestMissHistory$lambda$3(VideoRecordingViewModel.this, (Throwable) obj);
                return requestMissHistory$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMissHistory$lambda$2(VideoRecordingViewModel videoRecordingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        videoRecordingViewModel.missBaseListData.setList((List) apiResponse.getData());
        videoRecordingViewModel.onMissListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestMissHistory$lambda$3(VideoRecordingViewModel videoRecordingViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        videoRecordingViewModel.missBaseListData.requestError();
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
    public final String getFragmentType() {
        return this.fragmentType;
    }

    @NotNull
    public final BaseListData getMatchBaseListData() {
        return this.matchBaseListData;
    }

    @NotNull
    public final LiveData<List<VideoBaseData>> getMatchList() {
        return this.onMatchListMutable;
    }

    @NotNull
    public final BaseListData getMissBaseListData() {
        return this.missBaseListData;
    }

    @NotNull
    public final LiveData<List<VideoBaseData>> getMissList() {
        return this.onMissListMutable;
    }

    public final void like(@NotNull final String externalId, boolean isLike) {
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        this.externalIdMutable.setValue("");
        if (isLike) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().unlike(externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.t
                public final Object invoke(Object obj) {
                    Unit like$lambda$4;
                    like$lambda$4 = VideoRecordingViewModel.like$lambda$4(VideoRecordingViewModel.this, externalId, (ApiResponse) obj);
                    return like$lambda$4;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.u
                public final Object invoke(Object obj) {
                    Unit like$lambda$5;
                    like$lambda$5 = VideoRecordingViewModel.like$lambda$5((Throwable) obj);
                    return like$lambda$5;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        } else {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().like(externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.v
                public final Object invoke(Object obj) {
                    Unit like$lambda$6;
                    like$lambda$6 = VideoRecordingViewModel.like$lambda$6(VideoRecordingViewModel.this, externalId, (ApiResponse) obj);
                    return like$lambda$6;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.w
                public final Object invoke(Object obj) {
                    Unit like$lambda$7;
                    like$lambda$7 = VideoRecordingViewModel.like$lambda$7((Throwable) obj);
                    return like$lambda$7;
                }
            }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
        }
    }

    protected void onCleared() {
        super.onCleared();
        this.matchBaseListData.destroy();
        this.missBaseListData.destroy();
    }

    public final void requestHistory() {
        if (Intrinsics.areEqual(this.fragmentType, VideoRecordingActivity.TYPE_PAIR)) {
            requestMatchHistory();
        } else {
            requestMissHistory();
        }
    }

    public final void setFragmentType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fragmentType = str;
    }

    public final void setMatchBaseListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.matchBaseListData = baseListData;
    }

    public final void setMissBaseListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.missBaseListData = baseListData;
    }

    public /* synthetic */ VideoRecordingViewModel(VideoCallService videoCallService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new VideoCallService() : videoCallService);
    }

    public VideoRecordingViewModel(@Nullable VideoCallService videoCallService) {
        this.repository = videoCallService;
        this.fragmentType = "";
        this.matchBaseListData = new BaseListData();
        this.missBaseListData = new BaseListData();
        this.onMatchListMutable = new MutableLiveData<>();
        this.onMissListMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.externalIdMutable = new MutableLiveData<>();
    }
}
