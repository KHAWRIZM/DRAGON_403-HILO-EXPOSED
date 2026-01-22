package com.qiahao.nextvideo.ui.home.discover.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity;
import com.taobao.accs.utl.BaseMonitor;
import io.reactivex.rxjava3.core.i0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 72\u00020\u0001:\u00017B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010.\u001a\u00020/J\u0006\u00100\u001a\u00020/J\u000e\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u0013J\u000e\u00103\u001a\u00020/2\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u00104\u001a\u00020/2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u00105\u001a\u00020/J\b\u00106\u001a\u00020/H\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010 0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020!\u0018\u00010 0\u001c8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u001c8F¢\u0006\u0006\u001a\u0004\b'\u0010\u001eR\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u001c8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001eR\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u001c8F¢\u0006\u0006\u001a\u0004\b-\u0010\u001e¨\u00068"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesDetailViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", ActivitiesDetailActivity.ACTIVITY_ID, "", "getActivityId", "()Ljava/lang/String;", "setActivityId", "(Ljava/lang/String;)V", "subscribeUserListData", "Lcom/qiahao/base_common/model/BaseListData;", "getSubscribeUserListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setSubscribeUserListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "activityIsEndOrRunning", "", "getActivityIsEndOrRunning", "()Z", "setActivityIsEndOrRunning", "(Z)V", "onActivityDetailMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/base_common/model/ActivityDetailData;", "activityDetail", "Landroidx/lifecycle/LiveData;", "getActivityDetail", "()Landroidx/lifecycle/LiveData;", "onSubscribeUserListMutable", "", "Lcom/qiahao/base_common/model/common/User;", "subscribeUserList", "getSubscribeUserList", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "subscribeMutable", "subscribe", "getSubscribe", "deleteMutable", "delete", "getDelete", "requestSquareList", "", "requestActivityDetail", "activitySubscribe", "isSubscribe", "deleteActivity", "resetActivity", "changeRecommendState", "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesDetailViewModel extends BaseViewModel {

    @NotNull
    public static final String ACTIVITY_DETAIL = "activity_detail";

    @NotNull
    public static final String ACTIVITY_RESET = "activity_reset";

    @NotNull
    private String activityId;
    private boolean activityIsEndOrRunning;

    @NotNull
    private final MutableLiveData<Boolean> deleteMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<ActivityDetailData> onActivityDetailMutable;

    @NotNull
    private final MutableLiveData<List<User>> onSubscribeUserListMutable;

    @Nullable
    private final UserService repository;

    @NotNull
    private final MutableLiveData<String> subscribeMutable;

    @NotNull
    private BaseListData subscribeUserListData;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActivitiesDetailViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activitySubscribe$lambda$5(ActivitiesDetailViewModel activitiesDetailViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesDetailViewModel.subscribeMutable.setValue(activitiesDetailViewModel.activityId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activitySubscribe$lambda$6(ActivitiesDetailViewModel activitiesDetailViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesDetailViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteActivity$lambda$7(ActivitiesDetailViewModel activitiesDetailViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesDetailViewModel.deleteMutable.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteActivity$lambda$8(ActivitiesDetailViewModel activitiesDetailViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesDetailViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestActivityDetail$lambda$3(ActivitiesDetailViewModel activitiesDetailViewModel, ApiResponse apiResponse) {
        long j;
        Long endAt;
        Long startAt;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        ActivityDetailData activityDetailData = (ActivityDetailData) apiResponse.getData();
        long j2 = 0;
        if (activityDetailData != null && (startAt = activityDetailData.getStartAt()) != null) {
            j = startAt.longValue();
        } else {
            j = 0;
        }
        ActivityDetailData activityDetailData2 = (ActivityDetailData) apiResponse.getData();
        if (activityDetailData2 != null && (endAt = activityDetailData2.getEndAt()) != null) {
            j2 = endAt.longValue();
        }
        int checkActivityStart = hiloUtils.checkActivityStart(j, j2);
        boolean z = true;
        if (checkActivityStart != 2 && checkActivityStart != 1) {
            z = false;
        }
        activitiesDetailViewModel.activityIsEndOrRunning = z;
        activitiesDetailViewModel.onActivityDetailMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestActivityDetail$lambda$4(ActivitiesDetailViewModel activitiesDetailViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesDetailViewModel.getMException().setValue(new Pair(ACTIVITY_DETAIL, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSquareList$lambda$2$lambda$0(ActivitiesDetailViewModel activitiesDetailViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesDetailViewModel.subscribeUserListData.setList((List) apiResponse.getData());
        activitiesDetailViewModel.onSubscribeUserListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSquareList$lambda$2$lambda$1(ActivitiesDetailViewModel activitiesDetailViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesDetailViewModel.subscribeUserListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetActivity$lambda$10(ActivitiesDetailViewModel activitiesDetailViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesDetailViewModel.getMException().setValue(new Pair(ACTIVITY_RESET, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit resetActivity$lambda$9(ActivitiesDetailViewModel activitiesDetailViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesDetailViewModel.getMSuccess().setValue(new Pair(ACTIVITY_RESET, apiResponse));
        activitiesDetailViewModel.requestActivityDetail();
        return Unit.INSTANCE;
    }

    public final void activitySubscribe(boolean isSubscribe) {
        int i;
        nd.c observeOnMainThread$default;
        this.subscribeMutable.setValue("");
        UserService userService = this.repository;
        if (userService != null) {
            String str = this.activityId;
            if (isSubscribe) {
                i = 2;
            } else {
                i = 1;
            }
            i0<ApiResponse<Object>> activitySubscribe = userService.activitySubscribe(str, i);
            if (activitySubscribe != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(activitySubscribe, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.a
                public final Object invoke(Object obj) {
                    Unit activitySubscribe$lambda$5;
                    activitySubscribe$lambda$5 = ActivitiesDetailViewModel.activitySubscribe$lambda$5(ActivitiesDetailViewModel.this, (ApiResponse) obj);
                    return activitySubscribe$lambda$5;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.b
                public final Object invoke(Object obj) {
                    Unit activitySubscribe$lambda$6;
                    activitySubscribe$lambda$6 = ActivitiesDetailViewModel.activitySubscribe$lambda$6(ActivitiesDetailViewModel.this, (Throwable) obj);
                    return activitySubscribe$lambda$6;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
            }
        }
    }

    public final void changeRecommendState() {
        ActivityDetailData activityDetailData = (ActivityDetailData) this.onActivityDetailMutable.getValue();
        if (activityDetailData != null) {
            ActivityDetailData activityDetailData2 = (ActivityDetailData) this.onActivityDetailMutable.getValue();
            int i = 0;
            if (activityDetailData2 != null && activityDetailData2.getNotRecommend() == 0) {
                i = 1;
            }
            activityDetailData.setNotRecommend(i);
        }
    }

    public final void deleteActivity(@NotNull String activityId) {
        i0<ApiResponse<Object>> deleteGroupActivity;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(activityId, ActivitiesDetailActivity.ACTIVITY_ID);
        UserService userService = this.repository;
        if (userService != null && (deleteGroupActivity = userService.deleteGroupActivity(activityId)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(deleteGroupActivity, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.e
            public final Object invoke(Object obj) {
                Unit deleteActivity$lambda$7;
                deleteActivity$lambda$7 = ActivitiesDetailViewModel.deleteActivity$lambda$7(ActivitiesDetailViewModel.this, (ApiResponse) obj);
                return deleteActivity$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.f
            public final Object invoke(Object obj) {
                Unit deleteActivity$lambda$8;
                deleteActivity$lambda$8 = ActivitiesDetailViewModel.deleteActivity$lambda$8(ActivitiesDetailViewModel.this, (Throwable) obj);
                return deleteActivity$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<ActivityDetailData> getActivityDetail() {
        return this.onActivityDetailMutable;
    }

    @NotNull
    public final String getActivityId() {
        return this.activityId;
    }

    public final boolean getActivityIsEndOrRunning() {
        return this.activityIsEndOrRunning;
    }

    @NotNull
    public final LiveData<Boolean> getDelete() {
        return this.deleteMutable;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<String> getSubscribe() {
        return this.subscribeMutable;
    }

    @NotNull
    public final LiveData<List<User>> getSubscribeUserList() {
        return this.onSubscribeUserListMutable;
    }

    @NotNull
    public final BaseListData getSubscribeUserListData() {
        return this.subscribeUserListData;
    }

    protected void onCleared() {
        super.onCleared();
        this.subscribeUserListData.destroy();
    }

    public final void requestActivityDetail() {
        i0<ApiResponse<ActivityDetailData>> activityDetail;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (activityDetail = userService.activityDetail(this.activityId)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(activityDetail, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.c
            public final Object invoke(Object obj) {
                Unit requestActivityDetail$lambda$3;
                requestActivityDetail$lambda$3 = ActivitiesDetailViewModel.requestActivityDetail$lambda$3(ActivitiesDetailViewModel.this, (ApiResponse) obj);
                return requestActivityDetail$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.d
            public final Object invoke(Object obj) {
                Unit requestActivityDetail$lambda$4;
                requestActivityDetail$lambda$4 = ActivitiesDetailViewModel.requestActivityDetail$lambda$4(ActivitiesDetailViewModel.this, (Throwable) obj);
                return requestActivityDetail$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void requestSquareList() {
        UserService userService;
        int i;
        nd.c observeOnMainThread$default;
        if (((ActivityDetailData) getActivityDetail().getValue()) != null && (userService = this.repository) != null) {
            if (this.activityIsEndOrRunning) {
                i = 2;
            } else {
                i = 1;
            }
            i0<ApiResponse<List<User>>> subscribeList = userService.subscribeList(i, this.subscribeUserListData.getPageSize(), this.subscribeUserListData.nextPage(), this.activityId);
            if (subscribeList != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(subscribeList, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.i
                public final Object invoke(Object obj) {
                    Unit requestSquareList$lambda$2$lambda$0;
                    requestSquareList$lambda$2$lambda$0 = ActivitiesDetailViewModel.requestSquareList$lambda$2$lambda$0(ActivitiesDetailViewModel.this, (ApiResponse) obj);
                    return requestSquareList$lambda$2$lambda$0;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.j
                public final Object invoke(Object obj) {
                    Unit requestSquareList$lambda$2$lambda$1;
                    requestSquareList$lambda$2$lambda$1 = ActivitiesDetailViewModel.requestSquareList$lambda$2$lambda$1(ActivitiesDetailViewModel.this, (Throwable) obj);
                    return requestSquareList$lambda$2$lambda$1;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
            }
        }
    }

    public final void resetActivity(@NotNull String activityId) {
        Intrinsics.checkNotNullParameter(activityId, ActivitiesDetailActivity.ACTIVITY_ID);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().resetActivity(activityId), new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.g
            public final Object invoke(Object obj) {
                Unit resetActivity$lambda$9;
                resetActivity$lambda$9 = ActivitiesDetailViewModel.resetActivity$lambda$9(ActivitiesDetailViewModel.this, (ApiResponse) obj);
                return resetActivity$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.h
            public final Object invoke(Object obj) {
                Unit resetActivity$lambda$10;
                resetActivity$lambda$10 = ActivitiesDetailViewModel.resetActivity$lambda$10(ActivitiesDetailViewModel.this, (Throwable) obj);
                return resetActivity$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setActivityId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.activityId = str;
    }

    public final void setActivityIsEndOrRunning(boolean z) {
        this.activityIsEndOrRunning = z;
    }

    public final void setSubscribeUserListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.subscribeUserListData = baseListData;
    }

    public ActivitiesDetailViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.activityId = "";
        this.subscribeUserListData = new BaseListData();
        this.onActivityDetailMutable = new MutableLiveData<>();
        this.onSubscribeUserListMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.subscribeMutable = new MutableLiveData<>();
        this.deleteMutable = new MutableLiveData<>();
    }

    public /* synthetic */ ActivitiesDetailViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
