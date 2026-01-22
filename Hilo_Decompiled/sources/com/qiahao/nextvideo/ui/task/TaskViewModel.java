package com.qiahao.nextvideo.ui.task;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.RefreshMoney;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.data.task.GoldTaskData;
import com.qiahao.nextvideo.network.AppServer;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u000f\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0012R(\u0010\u0004\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/TaskViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "taskListMutable", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lkotlin/collections/ArrayList;", "taskList", "Landroidx/lifecycle/LiveData;", "getTaskList", "()Landroidx/lifecycle/LiveData;", "taskProcessMutable", "Lcom/qiahao/nextvideo/data/task/GoldTaskData;", "taskProcess", "getTaskProcess", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "taskGameList", "", "taskSign", "level", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TaskViewModel extends BaseViewModel {
    private int selectPosition;

    @NotNull
    private final MutableLiveData<ArrayList<GameConfiguration>> taskListMutable = new MutableLiveData<>();

    @NotNull
    private final MutableLiveData<GoldTaskData> taskProcessMutable = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit taskGameList$lambda$0(TaskViewModel taskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        taskViewModel.taskListMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit taskGameList$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "失败", false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit taskProcess$lambda$2(TaskViewModel taskViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        taskViewModel.taskProcessMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit taskProcess$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit taskSign$lambda$4(TaskViewModel taskViewModel, ApiResponse apiResponse) {
        double d;
        Double pinkDiamondNum;
        Double diamondNum;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        RefreshMoney refreshMoney = (RefreshMoney) apiResponse.getData();
        double d2 = 0.0d;
        if (refreshMoney != null && (diamondNum = refreshMoney.getDiamondNum()) != null) {
            d = diamondNum.doubleValue();
        } else {
            d = 0.0d;
        }
        RefreshMoney refreshMoney2 = (RefreshMoney) apiResponse.getData();
        if (refreshMoney2 != null && (pinkDiamondNum = refreshMoney2.getPinkDiamondNum()) != null) {
            d2 = pinkDiamondNum.doubleValue();
        }
        shared.refreshDiamondOrGem(d, d2);
        taskViewModel.taskProcess();
        taskViewModel.getMSuccess().postValue(new Pair("taskSign", Boolean.TRUE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit taskSign$lambda$5(TaskViewModel taskViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        taskViewModel.getMException().postValue(new Pair("taskSign", th));
        return Unit.INSTANCE;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    @NotNull
    public final LiveData<ArrayList<GameConfiguration>> getTaskList() {
        return this.taskListMutable;
    }

    @NotNull
    public final LiveData<GoldTaskData> getTaskProcess() {
        return this.taskProcessMutable;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    public final void taskGameList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().taskGameList(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.p1
            public final Object invoke(Object obj) {
                Unit taskGameList$lambda$0;
                taskGameList$lambda$0 = TaskViewModel.taskGameList$lambda$0(TaskViewModel.this, (ApiResponse) obj);
                return taskGameList$lambda$0;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.q1
            public final Object invoke(Object obj) {
                Unit taskGameList$lambda$1;
                taskGameList$lambda$1 = TaskViewModel.taskGameList$lambda$1((Throwable) obj);
                return taskGameList$lambda$1;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void taskProcess() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().taskSign(), new Function1() { // from class: com.qiahao.nextvideo.ui.task.r1
            public final Object invoke(Object obj) {
                Unit taskProcess$lambda$2;
                taskProcess$lambda$2 = TaskViewModel.taskProcess$lambda$2(TaskViewModel.this, (ApiResponse) obj);
                return taskProcess$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.s1
            public final Object invoke(Object obj) {
                Unit taskProcess$lambda$3;
                taskProcess$lambda$3 = TaskViewModel.taskProcess$lambda$3((Throwable) obj);
                return taskProcess$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void taskSign(int level) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().taskSign(level), new Function1() { // from class: com.qiahao.nextvideo.ui.task.n1
            public final Object invoke(Object obj) {
                Unit taskSign$lambda$4;
                taskSign$lambda$4 = TaskViewModel.taskSign$lambda$4(TaskViewModel.this, (ApiResponse) obj);
                return taskSign$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.task.o1
            public final Object invoke(Object obj) {
                Unit taskSign$lambda$5;
                taskSign$lambda$5 = TaskViewModel.taskSign$lambda$5(TaskViewModel.this, (Throwable) obj);
                return taskSign$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
