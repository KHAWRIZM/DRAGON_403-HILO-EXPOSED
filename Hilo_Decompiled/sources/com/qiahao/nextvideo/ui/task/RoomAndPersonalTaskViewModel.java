package com.qiahao.nextvideo.ui.task;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.CreateGroupBean;
import com.qiahao.nextvideo.data.model.GetTaskRewardBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.model.RoomAndPersonalBannerBean;
import com.qiahao.nextvideo.data.model.RoomAndPersonalTaskBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.room.StartRoomUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\u0014J\u0006\u0010\u000f\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0014J\b\u0010\u001b\u001a\u00020\u0014H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\b8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "personalAndRoomTaskListMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/nextvideo/data/model/RoomAndPersonalTaskBean;", "personalAndRoomTaskList", "Landroidx/lifecycle/LiveData;", "getPersonalAndRoomTaskList", "()Landroidx/lifecycle/LiveData;", "personalAndRoomBannerMutable", "", "Lcom/qiahao/nextvideo/data/model/RoomAndPersonalBannerBean;", "personalAndRoomBanner", "getPersonalAndRoomBanner", "personalAndRoomAwardMutable", "Lcom/qiahao/nextvideo/data/model/GetTaskRewardBean;", "personalAndRoomAward", "getPersonalAndRoomAward", "", "getPersonalAndRoomTaskAward", "taskId", "", "position", "", "getMyGroup", "createRoomAndEnterRoom", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomAndPersonalTaskViewModel extends BaseViewModel {

    @NotNull
    public static final String COMMON_TIP = "common_tip";

    @NotNull
    private final MutableLiveData<RoomAndPersonalTaskBean> personalAndRoomTaskListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<List<RoomAndPersonalBannerBean>> personalAndRoomBannerMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<GetTaskRewardBean> personalAndRoomAwardMutable = new MutableLiveData<>();

    private final void createRoomAndEnterRoom() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().createGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.d1
            public final Object invoke(Object obj) {
                Unit createRoomAndEnterRoom$lambda$12;
                createRoomAndEnterRoom$lambda$12 = RoomAndPersonalTaskViewModel.createRoomAndEnterRoom$lambda$12((ApiResponse) obj);
                return createRoomAndEnterRoom$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.e1
            public final Object invoke(Object obj) {
                Unit createRoomAndEnterRoom$lambda$13;
                createRoomAndEnterRoom$lambda$13 = RoomAndPersonalTaskViewModel.createRoomAndEnterRoom$lambda$13(RoomAndPersonalTaskViewModel.this, (Throwable) obj);
                return createRoomAndEnterRoom$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoomAndEnterRoom$lambda$12(ApiResponse apiResponse) {
        String str;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        CreateGroupBean createGroupBean = (CreateGroupBean) apiResponse.getData();
        if (createGroupBean == null || (str = createGroupBean.getImGroupId()) == null) {
            str = "";
        }
        StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createRoomAndEnterRoom$lambda$13(RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomAndPersonalTaskViewModel.getMException().setValue(new Pair(COMMON_TIP, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGroup$lambda$10(RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "list");
        if (((List) apiResponse.getData()) != null && (!r0.isEmpty())) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, ((HotGroupBean) list.get(0)).getGroupId(), ((HotGroupBean) list.get(0)).getCode(), ((HotGroupBean) list.get(0)).getFaceUrl(), ((HotGroupBean) list.get(0)).getName(), Boolean.valueOf(((HotGroupBean) list.get(0)).getHasPassWord()), ((HotGroupBean) list.get(0)).getCountryIcon(), ((HotGroupBean) list.get(0)).getIntroduction(), ((HotGroupBean) list.get(0)).getNotification(), 0, 0, null, 0, false, 7936, null);
            }
        } else {
            roomAndPersonalTaskViewModel.createRoomAndEnterRoom();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMyGroup$lambda$11(RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomAndPersonalTaskViewModel.getMException().setValue(new Pair(COMMON_TIP, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPersonalAndRoomBanner$lambda$4(RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            roomAndPersonalTaskViewModel.personalAndRoomBannerMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPersonalAndRoomBanner$lambda$5(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPersonalAndRoomTaskAward$lambda$7(int i, RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, ApiResponse apiResponse) {
        Long l;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (apiResponse.getCode() == 200 && (l = (Long) apiResponse.getData()) != null) {
            roomAndPersonalTaskViewModel.personalAndRoomAwardMutable.setValue(new GetTaskRewardBean(l.longValue(), i));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPersonalAndRoomTaskAward$lambda$8(RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        roomAndPersonalTaskViewModel.getMException().setValue(new Pair(COMMON_TIP, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPersonalAndRoomTaskList$lambda$1(RoomAndPersonalTaskViewModel roomAndPersonalTaskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        RoomAndPersonalTaskBean roomAndPersonalTaskBean = (RoomAndPersonalTaskBean) apiResponse.getData();
        if (roomAndPersonalTaskBean != null) {
            roomAndPersonalTaskViewModel.personalAndRoomTaskListMutable.setValue(roomAndPersonalTaskBean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPersonalAndRoomTaskList$lambda$2(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    public final void getMyGroup() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getOwnGroup(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.f1
            public final Object invoke(Object obj) {
                Unit myGroup$lambda$10;
                myGroup$lambda$10 = RoomAndPersonalTaskViewModel.getMyGroup$lambda$10(RoomAndPersonalTaskViewModel.this, (ApiResponse) obj);
                return myGroup$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.g1
            public final Object invoke(Object obj) {
                Unit myGroup$lambda$11;
                myGroup$lambda$11 = RoomAndPersonalTaskViewModel.getMyGroup$lambda$11(RoomAndPersonalTaskViewModel.this, (Throwable) obj);
                return myGroup$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<GetTaskRewardBean> getPersonalAndRoomAward() {
        return this.personalAndRoomAwardMutable;
    }

    @NotNull
    public final LiveData<List<RoomAndPersonalBannerBean>> getPersonalAndRoomBanner() {
        return this.personalAndRoomBannerMutable;
    }

    public final void getPersonalAndRoomTaskAward(long taskId, final int position) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPersonalAndRoomTaskAward(String.valueOf(taskId)), new Function1() { // from class: com.qiahao.nextvideo.ui.task.z0
            public final Object invoke(Object obj) {
                Unit personalAndRoomTaskAward$lambda$7;
                personalAndRoomTaskAward$lambda$7 = RoomAndPersonalTaskViewModel.getPersonalAndRoomTaskAward$lambda$7(position, this, (ApiResponse) obj);
                return personalAndRoomTaskAward$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.a1
            public final Object invoke(Object obj) {
                Unit personalAndRoomTaskAward$lambda$8;
                personalAndRoomTaskAward$lambda$8 = RoomAndPersonalTaskViewModel.getPersonalAndRoomTaskAward$lambda$8(RoomAndPersonalTaskViewModel.this, (Throwable) obj);
                return personalAndRoomTaskAward$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final LiveData<RoomAndPersonalTaskBean> getPersonalAndRoomTaskList() {
        return this.personalAndRoomTaskListMutable;
    }

    /* renamed from: getPersonalAndRoomBanner, reason: collision with other method in class */
    public final void m٩٠getPersonalAndRoomBanner() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPersonalAndRoomBanner(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.b1
            public final Object invoke(Object obj) {
                Unit personalAndRoomBanner$lambda$4;
                personalAndRoomBanner$lambda$4 = RoomAndPersonalTaskViewModel.getPersonalAndRoomBanner$lambda$4(RoomAndPersonalTaskViewModel.this, (ApiResponse) obj);
                return personalAndRoomBanner$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.c1
            public final Object invoke(Object obj) {
                Unit personalAndRoomBanner$lambda$5;
                personalAndRoomBanner$lambda$5 = RoomAndPersonalTaskViewModel.getPersonalAndRoomBanner$lambda$5((Throwable) obj);
                return personalAndRoomBanner$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    /* renamed from: getPersonalAndRoomTaskList, reason: collision with other method in class */
    public final void m٩١getPersonalAndRoomTaskList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getPersonalAndRoomTaskList(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.x0
            public final Object invoke(Object obj) {
                Unit personalAndRoomTaskList$lambda$1;
                personalAndRoomTaskList$lambda$1 = RoomAndPersonalTaskViewModel.getPersonalAndRoomTaskList$lambda$1(RoomAndPersonalTaskViewModel.this, (ApiResponse) obj);
                return personalAndRoomTaskList$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.y0
            public final Object invoke(Object obj) {
                Unit personalAndRoomTaskList$lambda$2;
                personalAndRoomTaskList$lambda$2 = RoomAndPersonalTaskViewModel.getPersonalAndRoomTaskList$lambda$2((Throwable) obj);
                return personalAndRoomTaskList$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
