package com.qiahao.nextvideo.ui.cp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.cp.CpMemorial;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.taobao.accs.utl.BaseMonitor;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J\u0016\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u0015J&\u0010'\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0015J\b\u0010(\u001a\u00020\u001cH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpMemorialViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "cpMemorialData", "Lcom/qiahao/base_common/model/BaseListData;", "getCpMemorialData", "()Lcom/qiahao/base_common/model/BaseListData;", "setCpMemorialData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "cpMemorialMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/base_common/model/cp/CpMemorial;", "cpMemorial", "Landroidx/lifecycle/LiveData;", "getCpMemorial", "()Landroidx/lifecycle/LiveData;", "deleteSuccessMutable", "", "deleteSuccess", "getDeleteSuccess", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "", CpMemorialViewModel.POST_MEMORIAL, "content", "", "timestamp", "", "isRemind", "", CpMemorialViewModel.DELETE_MEMORIAL, AgooConstants.MESSAGE_ID, "position", CpMemorialViewModel.UPDATE_MEMORIAL, "onCleared", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpMemorialViewModel extends BaseViewModel {

    @NotNull
    public static final String DELETE_MEMORIAL = "deleteCpMemorial";

    @NotNull
    public static final String POST_MEMORIAL = "postCpMemorial";

    @NotNull
    public static final String UPDATE_MEMORIAL = "updateCpMemorial";

    @NotNull
    private BaseListData cpMemorialData;

    @NotNull
    private final MutableLiveData<List<CpMemorial>> cpMemorialMutable;

    @NotNull
    private final MutableLiveData<Integer> deleteSuccessMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @Nullable
    private final UserService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CpMemorialViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteCpMemorial$lambda$5(CpMemorialViewModel cpMemorialViewModel, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpMemorialViewModel.deleteSuccessMutable.setValue(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteCpMemorial$lambda$6(CpMemorialViewModel cpMemorialViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpMemorialViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpMemorial$lambda$1(CpMemorialViewModel cpMemorialViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpMemorialViewModel.cpMemorialData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            cpMemorialViewModel.cpMemorialMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCpMemorial$lambda$2(CpMemorialViewModel cpMemorialViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpMemorialViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postCpMemorial$lambda$3(CpMemorialViewModel cpMemorialViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpMemorialViewModel.getMSuccess().setValue(new Pair(POST_MEMORIAL, ""));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit postCpMemorial$lambda$4(CpMemorialViewModel cpMemorialViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpMemorialViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCpMemorial$lambda$7(CpMemorialViewModel cpMemorialViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpMemorialViewModel.getMSuccess().setValue(new Pair(UPDATE_MEMORIAL, ""));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCpMemorial$lambda$8(CpMemorialViewModel cpMemorialViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpMemorialViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public final void deleteCpMemorial(int id2, final int position) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> deleteCpMemorial;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (deleteCpMemorial = userService.deleteCpMemorial(id2)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(deleteCpMemorial, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.l0
            public final Object invoke(Object obj) {
                Unit deleteCpMemorial$lambda$5;
                deleteCpMemorial$lambda$5 = CpMemorialViewModel.deleteCpMemorial$lambda$5(CpMemorialViewModel.this, position, (ApiResponse) obj);
                return deleteCpMemorial$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.m0
            public final Object invoke(Object obj) {
                Unit deleteCpMemorial$lambda$6;
                deleteCpMemorial$lambda$6 = CpMemorialViewModel.deleteCpMemorial$lambda$6(CpMemorialViewModel.this, (Throwable) obj);
                return deleteCpMemorial$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<List<CpMemorial>> getCpMemorial() {
        return this.cpMemorialMutable;
    }

    @NotNull
    public final BaseListData getCpMemorialData() {
        return this.cpMemorialData;
    }

    @NotNull
    public final LiveData<Integer> getDeleteSuccess() {
        return this.deleteSuccessMutable;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    protected void onCleared() {
        super.onCleared();
        this.cpMemorialData.destroy();
    }

    public final void postCpMemorial(@NotNull String content, long timestamp, boolean isRemind) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> postCpMemorial;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(content, "content");
        UserService userService = this.repository;
        if (userService != null && (postCpMemorial = userService.postCpMemorial(content, timestamp, isRemind)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(postCpMemorial, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.j0
            public final Object invoke(Object obj) {
                Unit postCpMemorial$lambda$3;
                postCpMemorial$lambda$3 = CpMemorialViewModel.postCpMemorial$lambda$3(CpMemorialViewModel.this, (ApiResponse) obj);
                return postCpMemorial$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.k0
            public final Object invoke(Object obj) {
                Unit postCpMemorial$lambda$4;
                postCpMemorial$lambda$4 = CpMemorialViewModel.postCpMemorial$lambda$4(CpMemorialViewModel.this, (Throwable) obj);
                return postCpMemorial$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void setCpMemorialData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.cpMemorialData = baseListData;
    }

    public final void updateCpMemorial(@NotNull String content, long timestamp, boolean isRemind, int id2) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> updateCpMemorial;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(content, "content");
        UserService userService = this.repository;
        if (userService != null && (updateCpMemorial = userService.updateCpMemorial(content, timestamp, isRemind, id2)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(updateCpMemorial, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.f0
            public final Object invoke(Object obj) {
                Unit updateCpMemorial$lambda$7;
                updateCpMemorial$lambda$7 = CpMemorialViewModel.updateCpMemorial$lambda$7(CpMemorialViewModel.this, (ApiResponse) obj);
                return updateCpMemorial$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.g0
            public final Object invoke(Object obj) {
                Unit updateCpMemorial$lambda$8;
                updateCpMemorial$lambda$8 = CpMemorialViewModel.updateCpMemorial$lambda$8(CpMemorialViewModel.this, (Throwable) obj);
                return updateCpMemorial$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public CpMemorialViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.cpMemorialData = new BaseListData();
        this.cpMemorialMutable = new MutableLiveData<>();
        this.deleteSuccessMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    /* renamed from: getCpMemorial, reason: collision with other method in class */
    public final void m٦٦getCpMemorial() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<CpMemorial>>> cpMemorial;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService == null || (cpMemorial = userService.cpMemorial(this.cpMemorialData.nextPage(), this.cpMemorialData.getPageSize())) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpMemorial, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.h0
            public final Object invoke(Object obj) {
                Unit cpMemorial$lambda$1;
                cpMemorial$lambda$1 = CpMemorialViewModel.getCpMemorial$lambda$1(CpMemorialViewModel.this, (ApiResponse) obj);
                return cpMemorial$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.i0
            public final Object invoke(Object obj) {
                Unit cpMemorial$lambda$2;
                cpMemorial$lambda$2 = CpMemorialViewModel.getCpMemorial$lambda$2(CpMemorialViewModel.this, (Throwable) obj);
                return cpMemorial$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    public /* synthetic */ CpMemorialViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
