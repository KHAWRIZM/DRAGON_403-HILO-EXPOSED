package com.qiahao.nextvideo.ui.home.discover.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.ApiListData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity;
import com.taobao.accs.utl.BaseMonitor;
import io.reactivex.rxjava3.core.i0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u00020.J\u0016\u00100\u001a\u00020.2\u0006\u0010+\u001a\u00020\u00072\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u001d8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010$\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a0\u001d8F¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u001d8F¢\u0006\u0006\u001a\u0004\b)\u0010\u001fR\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070\u001d8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001f¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "fragmentType", "", "getFragmentType", "()Ljava/lang/String;", "setFragmentType", "(Ljava/lang/String;)V", "squareListData", "Lcom/qiahao/base_common/model/BaseListData;", "getSquareListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setSquareListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "subscribedListData", "getSubscribedListData", "setSubscribedListData", "groupListData", "getGroupListData", "setGroupListData", "onSquareListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/base_common/model/ActivityDetailData;", "squareList", "Landroidx/lifecycle/LiveData;", "getSquareList", "()Landroidx/lifecycle/LiveData;", "onSubscribedListMutable", "subscribedList", "getSubscribedList", "onGroupListMutable", "groupList", "getGroupList", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "activityIdMutable", ActivitiesDetailActivity.ACTIVITY_ID, "getActivityId", "requestSquareList", "", "requestSubscribedHistory", "activitySubscribe", "isSubscribe", "", "requestGroupActivityList", "groupId", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<String> activityIdMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private String fragmentType;

    @NotNull
    private BaseListData groupListData;

    @NotNull
    private final MutableLiveData<List<ActivityDetailData>> onGroupListMutable;

    @NotNull
    private final MutableLiveData<List<ActivityDetailData>> onSquareListMutable;

    @NotNull
    private final MutableLiveData<List<ActivityDetailData>> onSubscribedListMutable;

    @Nullable
    private final UserService repository;

    @NotNull
    private BaseListData squareListData;

    @NotNull
    private BaseListData subscribedListData;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ActivitiesViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activitySubscribe$lambda$4(ActivitiesViewModel activitiesViewModel, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesViewModel.activityIdMutable.setValue(str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit activitySubscribe$lambda$5(ActivitiesViewModel activitiesViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGroupActivityList$lambda$6(ActivitiesViewModel activitiesViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesViewModel.groupListData.setList((ApiListData) apiResponse.getData());
        MutableLiveData<List<ActivityDetailData>> mutableLiveData = activitiesViewModel.onGroupListMutable;
        ApiListData apiListData = (ApiListData) apiResponse.getData();
        if (apiListData != null) {
            list = apiListData.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestGroupActivityList$lambda$7(ActivitiesViewModel activitiesViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesViewModel.groupListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSquareList$lambda$0(ActivitiesViewModel activitiesViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesViewModel.squareListData.setList((ApiListData) apiResponse.getData());
        MutableLiveData<List<ActivityDetailData>> mutableLiveData = activitiesViewModel.onSquareListMutable;
        ApiListData apiListData = (ApiListData) apiResponse.getData();
        if (apiListData != null) {
            list = apiListData.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSquareList$lambda$1(ActivitiesViewModel activitiesViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesViewModel.squareListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSubscribedHistory$lambda$2(ActivitiesViewModel activitiesViewModel, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        activitiesViewModel.subscribedListData.setList((ApiListData) apiResponse.getData());
        MutableLiveData<List<ActivityDetailData>> mutableLiveData = activitiesViewModel.onSubscribedListMutable;
        ApiListData apiListData = (ApiListData) apiResponse.getData();
        if (apiListData != null) {
            list = apiListData.getData();
        } else {
            list = null;
        }
        mutableLiveData.setValue(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestSubscribedHistory$lambda$3(ActivitiesViewModel activitiesViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        activitiesViewModel.subscribedListData.requestError();
        return Unit.INSTANCE;
    }

    public final void activitySubscribe(@NotNull final String activityId, boolean isSubscribe) {
        int i;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(activityId, ActivitiesDetailActivity.ACTIVITY_ID);
        this.activityIdMutable.setValue("");
        UserService userService = this.repository;
        if (userService != null) {
            if (isSubscribe) {
                i = 2;
            } else {
                i = 1;
            }
            i0<ApiResponse<Object>> activitySubscribe = userService.activitySubscribe(activityId, i);
            if (activitySubscribe != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(activitySubscribe, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.m
                public final Object invoke(Object obj) {
                    Unit activitySubscribe$lambda$4;
                    activitySubscribe$lambda$4 = ActivitiesViewModel.activitySubscribe$lambda$4(ActivitiesViewModel.this, activityId, (ApiResponse) obj);
                    return activitySubscribe$lambda$4;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.n
                public final Object invoke(Object obj) {
                    Unit activitySubscribe$lambda$5;
                    activitySubscribe$lambda$5 = ActivitiesViewModel.activitySubscribe$lambda$5(ActivitiesViewModel.this, (Throwable) obj);
                    return activitySubscribe$lambda$5;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
            }
        }
    }

    @NotNull
    public final LiveData<String> getActivityId() {
        return this.activityIdMutable;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final String getFragmentType() {
        return this.fragmentType;
    }

    @NotNull
    public final LiveData<List<ActivityDetailData>> getGroupList() {
        return this.onGroupListMutable;
    }

    @NotNull
    public final BaseListData getGroupListData() {
        return this.groupListData;
    }

    @NotNull
    public final LiveData<List<ActivityDetailData>> getSquareList() {
        return this.onSquareListMutable;
    }

    @NotNull
    public final BaseListData getSquareListData() {
        return this.squareListData;
    }

    @NotNull
    public final LiveData<List<ActivityDetailData>> getSubscribedList() {
        return this.onSubscribedListMutable;
    }

    @NotNull
    public final BaseListData getSubscribedListData() {
        return this.subscribedListData;
    }

    public final void requestGroupActivityList(@NotNull String groupId) {
        i0<ApiResponse<ApiListData<ActivityDetailData>>> activityList;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        UserService userService = this.repository;
        if (userService != null && (activityList = userService.activityList(0, this.groupListData.getPageSize(), this.groupListData.nextPage(), groupId)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(activityList, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.q
            public final Object invoke(Object obj) {
                Unit requestGroupActivityList$lambda$6;
                requestGroupActivityList$lambda$6 = ActivitiesViewModel.requestGroupActivityList$lambda$6(ActivitiesViewModel.this, (ApiResponse) obj);
                return requestGroupActivityList$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.r
            public final Object invoke(Object obj) {
                Unit requestGroupActivityList$lambda$7;
                requestGroupActivityList$lambda$7 = ActivitiesViewModel.requestGroupActivityList$lambda$7(ActivitiesViewModel.this, (Throwable) obj);
                return requestGroupActivityList$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void requestSquareList() {
        i0<ApiResponse<ApiListData<ActivityDetailData>>> activityList;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (activityList = userService.activityList(0, this.squareListData.getPageSize(), this.squareListData.nextPage(), "")) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(activityList, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.o
            public final Object invoke(Object obj) {
                Unit requestSquareList$lambda$0;
                requestSquareList$lambda$0 = ActivitiesViewModel.requestSquareList$lambda$0(ActivitiesViewModel.this, (ApiResponse) obj);
                return requestSquareList$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.p
            public final Object invoke(Object obj) {
                Unit requestSquareList$lambda$1;
                requestSquareList$lambda$1 = ActivitiesViewModel.requestSquareList$lambda$1(ActivitiesViewModel.this, (Throwable) obj);
                return requestSquareList$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void requestSubscribedHistory() {
        i0<ApiResponse<ApiListData<ActivityDetailData>>> activityList;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (activityList = userService.activityList(1, this.subscribedListData.getPageSize(), this.subscribedListData.nextPage(), "")) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(activityList, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.k
            public final Object invoke(Object obj) {
                Unit requestSubscribedHistory$lambda$2;
                requestSubscribedHistory$lambda$2 = ActivitiesViewModel.requestSubscribedHistory$lambda$2(ActivitiesViewModel.this, (ApiResponse) obj);
                return requestSubscribedHistory$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.viewModel.l
            public final Object invoke(Object obj) {
                Unit requestSubscribedHistory$lambda$3;
                requestSubscribedHistory$lambda$3 = ActivitiesViewModel.requestSubscribedHistory$lambda$3(ActivitiesViewModel.this, (Throwable) obj);
                return requestSubscribedHistory$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void setFragmentType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fragmentType = str;
    }

    public final void setGroupListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.groupListData = baseListData;
    }

    public final void setSquareListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.squareListData = baseListData;
    }

    public final void setSubscribedListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.subscribedListData = baseListData;
    }

    public ActivitiesViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.fragmentType = "";
        this.squareListData = new BaseListData();
        this.subscribedListData = new BaseListData();
        this.groupListData = new BaseListData();
        this.onSquareListMutable = new MutableLiveData<>();
        this.onSubscribedListMutable = new MutableLiveData<>();
        this.onGroupListMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.activityIdMutable = new MutableLiveData<>();
    }

    public /* synthetic */ ActivitiesViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
