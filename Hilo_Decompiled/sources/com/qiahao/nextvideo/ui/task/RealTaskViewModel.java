package com.qiahao.nextvideo.ui.task;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.EarnDiamondBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.data.task.RealCertificationResult;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.home.medal.MedalActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0006\u0010\u001f\u001a\u00020\u0019R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00100\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\n¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RealTaskViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "taskListMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/EarnDiamondBean;", "taskList", "Landroidx/lifecycle/LiveData;", "getTaskList", "()Landroidx/lifecycle/LiveData;", "createRoomMutable", "Lcom/qiahao/nextvideo/data/model/CreateGroupBean;", "createRoom", "getCreateRoom", "roomMutable", "", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", MedalActivity.TYPE_ROOM, "getRoom", "realStatusMutable", "Lcom/qiahao/nextvideo/data/task/RealCertificationResult;", "realStatus", "getRealStatus", "getReward", "", "taskConfigId", "", "getData", "getMyGroup", "createRoomAndEnterRoom", "realCertification", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RealTaskViewModel extends BaseViewModel {

    @NotNull
    public static final String AWARD_EARN = "AWARD_EARN";

    @NotNull
    public static final String CREATE_ROOM = "CREATE_ROOM";

    @NotNull
    public static final String EARN_DIAMOND = "EARN_DIAMOND";

    @NotNull
    public static final String MY_GROUP = "MY_GROUP";

    @NotNull
    public static final String REAL_STATUS = "REAL_STATUS";

    @NotNull
    private final MutableLiveData<EarnDiamondBean> taskListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<CreateGroupBean> createRoomMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<HotGroupBean>> roomMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<RealCertificationResult> realStatusMutable = new MutableLiveData<>();

    private final void createRoomAndEnterRoom() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().createGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.l0
            public final Object invoke(Object obj) {
                Unit createRoomAndEnterRoom$lambda$6;
                createRoomAndEnterRoom$lambda$6 = RealTaskViewModel.createRoomAndEnterRoom$lambda$6(RealTaskViewModel.this, (ApiResponse) obj);
                return createRoomAndEnterRoom$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.m0
            public final Object invoke(Object obj) {
                Unit createRoomAndEnterRoom$lambda$7;
                createRoomAndEnterRoom$lambda$7 = RealTaskViewModel.createRoomAndEnterRoom$lambda$7(RealTaskViewModel.this, (Throwable) obj);
                return createRoomAndEnterRoom$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoomAndEnterRoom$lambda$6(RealTaskViewModel realTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        realTaskViewModel.createRoomMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoomAndEnterRoom$lambda$7(RealTaskViewModel realTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        realTaskViewModel.getMException().postValue(new Pair("CREATE_ROOM", th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$2(RealTaskViewModel realTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        realTaskViewModel.taskListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getData$lambda$3(RealTaskViewModel realTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        realTaskViewModel.getMException().postValue(new Pair(EARN_DIAMOND, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGroup$lambda$4(RealTaskViewModel realTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "list");
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            realTaskViewModel.roomMutable.setValue(apiResponse.getData());
        } else {
            realTaskViewModel.createRoomAndEnterRoom();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGroup$lambda$5(RealTaskViewModel realTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        realTaskViewModel.getMException().postValue(new Pair(MY_GROUP, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getReward$lambda$0(RealTaskViewModel realTaskViewModel, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d = channelEventGiftAddTime.getDiamondNum();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, d, 0.0d, 2, null);
        realTaskViewModel.getData();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getReward$lambda$1(RealTaskViewModel realTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        realTaskViewModel.getMException().postValue(new Pair(AWARD_EARN, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit realCertification$lambda$8(RealTaskViewModel realTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        realTaskViewModel.realStatusMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit realCertification$lambda$9(RealTaskViewModel realTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        realTaskViewModel.getMException().postValue(new Pair(REAL_STATUS, th));
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<CreateGroupBean> getCreateRoom() {
        return this.createRoomMutable;
    }

    public final void getData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().getEarnDiamondTaskList(1), new Function1() { // from class: com.qiahao.nextvideo.ui.task.j0
            public final Object invoke(Object obj) {
                Unit data$lambda$2;
                data$lambda$2 = RealTaskViewModel.getData$lambda$2(RealTaskViewModel.this, (ApiResponse) obj);
                return data$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.k0
            public final Object invoke(Object obj) {
                Unit data$lambda$3;
                data$lambda$3 = RealTaskViewModel.getData$lambda$3(RealTaskViewModel.this, (Throwable) obj);
                return data$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getMyGroup() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getOwnGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.f0
            public final Object invoke(Object obj) {
                Unit myGroup$lambda$4;
                myGroup$lambda$4 = RealTaskViewModel.getMyGroup$lambda$4(RealTaskViewModel.this, (ApiResponse) obj);
                return myGroup$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.g0
            public final Object invoke(Object obj) {
                Unit myGroup$lambda$5;
                myGroup$lambda$5 = RealTaskViewModel.getMyGroup$lambda$5(RealTaskViewModel.this, (Throwable) obj);
                return myGroup$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<RealCertificationResult> getRealStatus() {
        return this.realStatusMutable;
    }

    public final void getReward(int taskConfigId) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(PurchaseService.INSTANCE.getShared().awardEarnDiamondTask(taskConfigId, 1), new Function1() { // from class: com.qiahao.nextvideo.ui.task.d0
            public final Object invoke(Object obj) {
                Unit reward$lambda$0;
                reward$lambda$0 = RealTaskViewModel.getReward$lambda$0(RealTaskViewModel.this, (ApiResponse) obj);
                return reward$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.e0
            public final Object invoke(Object obj) {
                Unit reward$lambda$1;
                reward$lambda$1 = RealTaskViewModel.getReward$lambda$1(RealTaskViewModel.this, (Throwable) obj);
                return reward$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<List<HotGroupBean>> getRoom() {
        return this.roomMutable;
    }

    @NotNull
    public final LiveData<EarnDiamondBean> getTaskList() {
        return this.taskListMutable;
    }

    public final void realCertification() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().realCertification(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.h0
            public final Object invoke(Object obj) {
                Unit realCertification$lambda$8;
                realCertification$lambda$8 = RealTaskViewModel.realCertification$lambda$8(RealTaskViewModel.this, (ApiResponse) obj);
                return realCertification$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.i0
            public final Object invoke(Object obj) {
                Unit realCertification$lambda$9;
                realCertification$lambda$9 = RealTaskViewModel.realCertification$lambda$9(RealTaskViewModel.this, (Throwable) obj);
                return realCertification$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
