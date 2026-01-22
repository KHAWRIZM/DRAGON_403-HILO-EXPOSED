package com.qiahao.nextvideo.ui.youtu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.youtube.WatchYouTuListData;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000bJ\u000e\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020\"J\u0006\u0010%\u001a\u00020 J\u0006\u0010&\u001a\u00020 J\u0016\u0010'\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0013\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\u0011j\b\u0012\u0004\u0012\u00020\u000b`\u00120\r8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\r8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\n0\r8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "roomListBaseData", "Lcom/qiahao/base_common/model/BaseListData;", "getRoomListBaseData", "()Lcom/qiahao/base_common/model/BaseListData;", "roomListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "roomList", "Landroidx/lifecycle/LiveData;", "getRoomList", "()Landroidx/lifecycle/LiveData;", "hotListMutable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "hotList", "getHotList", "positionMutable", "", "position", "getPosition", "watchListBaseData", "getWatchListBaseData", "watchListMutable", "Lcom/qiahao/nextvideo/data/model/youtube/WatchYouTuListData;", "watchList", "getWatchList", "deleteYouTuBeVideo", "", "groupId", "", "data", "roomYouTuList", "hotYouTuList", "watchYouTuList", "notRecommendView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuViewModel extends BaseViewModel {

    @NotNull
    public static final String TYPE_DELETE = "TYPE_DELETE";

    @NotNull
    public static final String TYPE_HOT_LIST = "TYPE_HOT_LIST";

    @NotNull
    public static final String TYPE_NOT_RECOMMEND = "TYPE_NOT_RECOMMEND";

    @NotNull
    public static final String TYPE_ROOM_LIST = "TYPE_ROOM_LIST";

    @NotNull
    private final BaseListData roomListBaseData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<YouTuBeData>> roomListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<ArrayList<YouTuBeData>> hotListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<Integer> positionMutable = new MutableLiveData<>();

    @NotNull
    private final BaseListData watchListBaseData = new BaseListData();

    @NotNull
    private final MutableLiveData<List<WatchYouTuListData>> watchListMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteYouTuBeVideo$lambda$0(YouTuViewModel youTuViewModel, YouTuBeData youTuBeData, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        youTuViewModel.getMSuccess().setValue(new Pair(TYPE_DELETE, youTuBeData));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteYouTuBeVideo$lambda$1(YouTuViewModel youTuViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        youTuViewModel.getMException().setValue(new Pair(TYPE_DELETE, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hotYouTuList$lambda$6(YouTuViewModel youTuViewModel, ApiResponse apiResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.getData() != null && ((arrayList = (ArrayList) apiResponse.getData()) == null || !arrayList.isEmpty())) {
            ArrayList arrayList2 = (ArrayList) apiResponse.getData();
            if (arrayList2 != null) {
                youTuViewModel.hotListMutable.setValue(arrayList2);
            }
        } else {
            youTuViewModel.hotListMutable.setValue(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit hotYouTuList$lambda$7(YouTuViewModel youTuViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        youTuViewModel.getMException().setValue(new Pair(TYPE_HOT_LIST, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notRecommendView$lambda$11(YouTuViewModel youTuViewModel, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        youTuViewModel.positionMutable.setValue(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit notRecommendView$lambda$12(YouTuViewModel youTuViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        youTuViewModel.getMException().setValue(new Pair(TYPE_NOT_RECOMMEND, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roomYouTuList$lambda$3(YouTuViewModel youTuViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        youTuViewModel.roomListBaseData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            youTuViewModel.roomListMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit roomYouTuList$lambda$4(YouTuViewModel youTuViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        youTuViewModel.roomListBaseData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit watchYouTuList$lambda$10(YouTuViewModel youTuViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        youTuViewModel.watchListBaseData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit watchYouTuList$lambda$9(YouTuViewModel youTuViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        youTuViewModel.watchListBaseData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            youTuViewModel.watchListMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    public final void deleteYouTuBeVideo(@NotNull String groupId, @NotNull final YouTuBeData data) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(data, "data");
        ServerApi apis = AppServer.INSTANCE.getApis();
        String videoId = data.getVideoId();
        if (videoId == null) {
            videoId = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.deleteYouTuBeVideo(groupId, videoId), new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.a0
            public final Object invoke(Object obj) {
                Unit deleteYouTuBeVideo$lambda$0;
                deleteYouTuBeVideo$lambda$0 = YouTuViewModel.deleteYouTuBeVideo$lambda$0(YouTuViewModel.this, data, (ApiResponse) obj);
                return deleteYouTuBeVideo$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.b0
            public final Object invoke(Object obj) {
                Unit deleteYouTuBeVideo$lambda$1;
                deleteYouTuBeVideo$lambda$1 = YouTuViewModel.deleteYouTuBeVideo$lambda$1(YouTuViewModel.this, (Throwable) obj);
                return deleteYouTuBeVideo$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<ArrayList<YouTuBeData>> getHotList() {
        return this.hotListMutable;
    }

    @NotNull
    public final LiveData<Integer> getPosition() {
        return this.positionMutable;
    }

    @NotNull
    public final LiveData<List<YouTuBeData>> getRoomList() {
        return this.roomListMutable;
    }

    @NotNull
    public final BaseListData getRoomListBaseData() {
        return this.roomListBaseData;
    }

    @NotNull
    public final LiveData<List<WatchYouTuListData>> getWatchList() {
        return this.watchListMutable;
    }

    @NotNull
    public final BaseListData getWatchListBaseData() {
        return this.watchListBaseData;
    }

    public final void hotYouTuList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().hotYouTuList(), new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.w
            public final Object invoke(Object obj) {
                Unit hotYouTuList$lambda$6;
                hotYouTuList$lambda$6 = YouTuViewModel.hotYouTuList$lambda$6(YouTuViewModel.this, (ApiResponse) obj);
                return hotYouTuList$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.x
            public final Object invoke(Object obj) {
                Unit hotYouTuList$lambda$7;
                hotYouTuList$lambda$7 = YouTuViewModel.hotYouTuList$lambda$7(YouTuViewModel.this, (Throwable) obj);
                return hotYouTuList$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void notRecommendView(@NotNull WatchYouTuListData data, final int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        ServerApi apis = AppServer.INSTANCE.getApis();
        String groupId = data.getGroupId();
        String str = "";
        if (groupId == null) {
            groupId = "";
        }
        String videoId = data.getVideoId();
        if (videoId != null) {
            str = videoId;
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.notRecommendVideo(groupId, str), new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.s
            public final Object invoke(Object obj) {
                Unit notRecommendView$lambda$11;
                notRecommendView$lambda$11 = YouTuViewModel.notRecommendView$lambda$11(YouTuViewModel.this, position, (ApiResponse) obj);
                return notRecommendView$lambda$11;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.t
            public final Object invoke(Object obj) {
                Unit notRecommendView$lambda$12;
                notRecommendView$lambda$12 = YouTuViewModel.notRecommendView$lambda$12(YouTuViewModel.this, (Throwable) obj);
                return notRecommendView$lambda$12;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void roomYouTuList(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().roomYouTuList(groupId, this.roomListBaseData.nextPage(), this.roomListBaseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.u
            public final Object invoke(Object obj) {
                Unit roomYouTuList$lambda$3;
                roomYouTuList$lambda$3 = YouTuViewModel.roomYouTuList$lambda$3(YouTuViewModel.this, (ApiResponse) obj);
                return roomYouTuList$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.v
            public final Object invoke(Object obj) {
                Unit roomYouTuList$lambda$4;
                roomYouTuList$lambda$4 = YouTuViewModel.roomYouTuList$lambda$4(YouTuViewModel.this, (Throwable) obj);
                return roomYouTuList$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void watchYouTuList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().watchYouTuList(this.watchListBaseData.nextPage(), this.watchListBaseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.y
            public final Object invoke(Object obj) {
                Unit watchYouTuList$lambda$9;
                watchYouTuList$lambda$9 = YouTuViewModel.watchYouTuList$lambda$9(YouTuViewModel.this, (ApiResponse) obj);
                return watchYouTuList$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.z
            public final Object invoke(Object obj) {
                Unit watchYouTuList$lambda$10;
                watchYouTuList$lambda$10 = YouTuViewModel.watchYouTuList$lambda$10(YouTuViewModel.this, (Throwable) obj);
                return watchYouTuList$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
