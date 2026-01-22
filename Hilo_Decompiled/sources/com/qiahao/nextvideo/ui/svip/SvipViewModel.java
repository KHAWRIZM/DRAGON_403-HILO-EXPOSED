package com.qiahao.nextvideo.ui.svip;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.svip.Details;
import com.qiahao.base_common.model.svip.SvipInfo;
import com.qiahao.base_common.model.svip.UserSvip;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.TIMService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
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

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001b\u001a\u00020)J\u0016\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,J\u0006\u0010\u0012\u001a\u00020)J\u0006\u0010\u0017\u001a\u00020)J\u000e\u0010'\u001a\u00020)2\u0006\u0010.\u001a\u00020/J\b\u00100\u001a\u00020)H\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00118F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00118F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0013R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00118F¢\u0006\u0006\u001a\u0004\b#\u0010\u0013R\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0%0\u00118F¢\u0006\u0006\u001a\u0004\b(\u0010\u0013¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "svipListData", "Lcom/qiahao/base_common/model/BaseListData;", "getSvipListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setSvipListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "svipDetailMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/base_common/model/svip/Details;", "svipDetail", "Landroidx/lifecycle/LiveData;", "getSvipDetail", "()Landroidx/lifecycle/LiveData;", "svipPointMutable", "Lcom/qiahao/base_common/model/svip/UserSvip;", "svipPoint", "getSvipPoint", "svipInfoMutable", "Lcom/qiahao/base_common/model/svip/SvipInfo;", "svipInfo", "getSvipInfo", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "successMutable", "", com.taobao.agoo.a.a.b.JSON_SUCCESS, "getSuccess", "receiveSvipTaskAwardMutable", "Lcom/qiahao/base_common/network/model/ApiResponse;", "", "receiveSvipTaskAward", "getReceiveSvipTaskAward", "", "privilegeOpen", "type", "", "openClose", "taskId", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private final MutableLiveData<ApiResponse<Object>> receiveSvipTaskAwardMutable;

    @Nullable
    private final UserService repository;

    @NotNull
    private final MutableLiveData<Boolean> successMutable;

    @NotNull
    private final MutableLiveData<List<Details>> svipDetailMutable;

    @NotNull
    private final MutableLiveData<SvipInfo> svipInfoMutable;

    @NotNull
    private BaseListData svipListData;

    @NotNull
    private final MutableLiveData<UserSvip> svipPointMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SvipViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSvipDetail$lambda$7(SvipViewModel svipViewModel, ApiResponse apiResponse) {
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        svipViewModel.svipListData.setList((ApiList) apiResponse.getData());
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null && (data = apiList.getData()) != null) {
            svipViewModel.svipDetailMutable.setValue(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSvipDetail$lambda$8(SvipViewModel svipViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        svipViewModel.svipListData.requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSvipInfo$lambda$2(SvipViewModel svipViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        SvipInfo svipInfo = (SvipInfo) apiResponse.getData();
        if (svipInfo != null) {
            svipViewModel.svipInfoMutable.setValue(svipInfo);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSvipInfo$lambda$3(SvipViewModel svipViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        svipViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSvipPoint$lambda$10(SvipViewModel svipViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserSvip userSvip = (UserSvip) apiResponse.getData();
        if (userSvip != null) {
            svipViewModel.svipPointMutable.setValue(userSvip);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSvipPoint$lambda$11(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit privilegeOpen$lambda$4(int i, int i2, SvipViewModel svipViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        if (i == 4) {
            TIMService tIMService = TIMService.INSTANCE;
            boolean z = true;
            if (i2 != 1) {
                z = false;
            }
            tIMService.setUserStatus(z);
        }
        svipViewModel.successMutable.setValue(Boolean.TRUE);
        svipViewModel.m٨٨getSvipInfo();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit privilegeOpen$lambda$5(SvipViewModel svipViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        svipViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit receiveSvipTaskAward$lambda$12(SvipViewModel svipViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        svipViewModel.receiveSvipTaskAwardMutable.setValue(apiResponse);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit receiveSvipTaskAward$lambda$13(SvipViewModel svipViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        svipViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final LiveData<ApiResponse<Object>> getReceiveSvipTaskAward() {
        return this.receiveSvipTaskAwardMutable;
    }

    @NotNull
    public final LiveData<Boolean> getSuccess() {
        return this.successMutable;
    }

    @NotNull
    public final LiveData<List<Details>> getSvipDetail() {
        return this.svipDetailMutable;
    }

    @NotNull
    public final LiveData<SvipInfo> getSvipInfo() {
        return this.svipInfoMutable;
    }

    @NotNull
    public final BaseListData getSvipListData() {
        return this.svipListData;
    }

    @NotNull
    public final LiveData<UserSvip> getSvipPoint() {
        return this.svipPointMutable;
    }

    protected void onCleared() {
        super.onCleared();
        this.svipListData.destroy();
    }

    public final void privilegeOpen(final int type, final int openClose) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> privilegeOpen;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (privilegeOpen = userService.privilegeOpen(type, openClose)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(privilegeOpen, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.l0
            public final Object invoke(Object obj) {
                Unit privilegeOpen$lambda$4;
                privilegeOpen$lambda$4 = SvipViewModel.privilegeOpen$lambda$4(type, openClose, this, (ApiResponse) obj);
                return privilegeOpen$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.m0
            public final Object invoke(Object obj) {
                Unit privilegeOpen$lambda$5;
                privilegeOpen$lambda$5 = SvipViewModel.privilegeOpen$lambda$5(SvipViewModel.this, (Throwable) obj);
                return privilegeOpen$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void receiveSvipTaskAward(long taskId) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().receiveSvipTaskAward(taskId), new Function1() { // from class: com.qiahao.nextvideo.ui.svip.p0
            public final Object invoke(Object obj) {
                Unit receiveSvipTaskAward$lambda$12;
                receiveSvipTaskAward$lambda$12 = SvipViewModel.receiveSvipTaskAward$lambda$12(SvipViewModel.this, (ApiResponse) obj);
                return receiveSvipTaskAward$lambda$12;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.q0
            public final Object invoke(Object obj) {
                Unit receiveSvipTaskAward$lambda$13;
                receiveSvipTaskAward$lambda$13 = SvipViewModel.receiveSvipTaskAward$lambda$13(SvipViewModel.this, (Throwable) obj);
                return receiveSvipTaskAward$lambda$13;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void setSvipListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.svipListData = baseListData;
    }

    public SvipViewModel(@Nullable UserService userService) {
        this.repository = userService;
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.svipListData = baseListData;
        this.svipDetailMutable = new MutableLiveData<>();
        this.svipPointMutable = new MutableLiveData<>();
        this.svipInfoMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
        this.successMutable = new MutableLiveData<>();
        this.receiveSvipTaskAwardMutable = new MutableLiveData<>();
    }

    /* renamed from: getSvipDetail, reason: collision with other method in class */
    public final void m٨٧getSvipDetail() {
        io.reactivex.rxjava3.core.i0<ApiResponse<ApiList<Details>>> svipDetail;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService == null || (svipDetail = userService.getSvipDetail(this.svipListData.getPageSize(), this.svipListData.nextPage())) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(svipDetail, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.j0
            public final Object invoke(Object obj) {
                Unit svipDetail$lambda$7;
                svipDetail$lambda$7 = SvipViewModel.getSvipDetail$lambda$7(SvipViewModel.this, (ApiResponse) obj);
                return svipDetail$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.k0
            public final Object invoke(Object obj) {
                Unit svipDetail$lambda$8;
                svipDetail$lambda$8 = SvipViewModel.getSvipDetail$lambda$8(SvipViewModel.this, (Throwable) obj);
                return svipDetail$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    /* renamed from: getSvipInfo, reason: collision with other method in class */
    public final void m٨٨getSvipInfo() {
        io.reactivex.rxjava3.core.i0<ApiResponse<SvipInfo>> svipInfo;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService == null || (svipInfo = userService.getSvipInfo()) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(svipInfo, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.r0
            public final Object invoke(Object obj) {
                Unit svipInfo$lambda$2;
                svipInfo$lambda$2 = SvipViewModel.getSvipInfo$lambda$2(SvipViewModel.this, (ApiResponse) obj);
                return svipInfo$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.s0
            public final Object invoke(Object obj) {
                Unit svipInfo$lambda$3;
                svipInfo$lambda$3 = SvipViewModel.getSvipInfo$lambda$3(SvipViewModel.this, (Throwable) obj);
                return svipInfo$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    /* renamed from: getSvipPoint, reason: collision with other method in class */
    public final void m٨٩getSvipPoint() {
        io.reactivex.rxjava3.core.i0<ApiResponse<UserSvip>> svipPoint;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService == null || (svipPoint = userService.getSvipPoint()) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(svipPoint, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.n0
            public final Object invoke(Object obj) {
                Unit svipPoint$lambda$10;
                svipPoint$lambda$10 = SvipViewModel.getSvipPoint$lambda$10(SvipViewModel.this, (ApiResponse) obj);
                return svipPoint$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.svip.o0
            public final Object invoke(Object obj) {
                Unit svipPoint$lambda$11;
                svipPoint$lambda$11 = SvipViewModel.getSvipPoint$lambda$11((Throwable) obj);
                return svipPoint$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    public /* synthetic */ SvipViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
