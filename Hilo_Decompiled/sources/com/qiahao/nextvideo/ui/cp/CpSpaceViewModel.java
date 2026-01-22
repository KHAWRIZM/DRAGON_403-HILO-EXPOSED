package com.qiahao.nextvideo.ui.cp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpInfo;
import com.qiahao.base_common.model.cp.CpSpace;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.taobao.accs.utl.BaseMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010*\u001a\u00020\u001dJ\u0006\u0010\u0018\u001a\u00020+J\u0016\u0010$\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0007J\u000e\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0007R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00198F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00198F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00100\u00198F¢\u0006\u0006\u001a\u0004\b%\u0010\u001bR\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020'0\u00198F¢\u0006\u0006\u001a\u0004\b)\u0010\u001b¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpSpaceViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "mExternalId1", "", "getMExternalId1", "()Ljava/lang/String;", "setMExternalId1", "(Ljava/lang/String;)V", "mExternalId2", "getMExternalId2", "setMExternalId2", "mRelationType", "", "getMRelationType", "()I", "setMRelationType", "(I)V", "cpSpaceMutable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qiahao/base_common/model/cp/CpSpace;", "cpSpace", "Landroidx/lifecycle/LiveData;", "getCpSpace", "()Landroidx/lifecycle/LiveData;", "cpExitMutable", "", "cpExit", "getCpExit", "successMutable", com.taobao.agoo.a.a.b.JSON_SUCCESS, "getSuccess", "privilegeOpenMutable", "privilegeOpen", "getPrivilegeOpen", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "checkMySpace", "", "type", "openClose", "cpRelation", SupportGiftRankActivity.EXTERNAL_ID, "cpReply", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpSpaceViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Boolean> cpExitMutable;

    @NotNull
    private final MutableLiveData<CpSpace> cpSpaceMutable;

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @Nullable
    private String mExternalId1;

    @Nullable
    private String mExternalId2;
    private int mRelationType;

    @NotNull
    private final MutableLiveData<Integer> privilegeOpenMutable;

    @Nullable
    private final UserService repository;

    @NotNull
    private final MutableLiveData<Boolean> successMutable;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CpSpaceViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpRelation$lambda$6(CpSpaceViewModel cpSpaceViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.cpExitMutable.setValue(Boolean.TRUE);
        cpSpaceViewModel.cpSpace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpRelation$lambda$7(CpSpaceViewModel cpSpaceViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpSpaceViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpRelation$lambda$8(CpSpaceViewModel cpSpaceViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.cpExitMutable.setValue(Boolean.TRUE);
        cpSpaceViewModel.cpSpace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpRelation$lambda$9(CpSpaceViewModel cpSpaceViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpSpaceViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpReply$lambda$10(CpSpaceViewModel cpSpaceViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.successMutable.setValue(Boolean.TRUE);
        cpSpaceViewModel.cpSpace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpReply$lambda$11(CpSpaceViewModel cpSpaceViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpSpaceViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpReply$lambda$12(CpSpaceViewModel cpSpaceViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.successMutable.setValue(Boolean.TRUE);
        cpSpaceViewModel.cpSpace();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpReply$lambda$13(CpSpaceViewModel cpSpaceViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpSpaceViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpSpace$lambda$0(CpSpaceViewModel cpSpaceViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.cpSpaceMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpSpace$lambda$1(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpSpace$lambda$2(CpSpaceViewModel cpSpaceViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.cpSpaceMutable.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cpSpace$lambda$3(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit privilegeOpen$lambda$4(CpSpaceViewModel cpSpaceViewModel, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        cpSpaceViewModel.privilegeOpenMutable.setValue(Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit privilegeOpen$lambda$5(CpSpaceViewModel cpSpaceViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        cpSpaceViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public final boolean checkMySpace() {
        String str;
        String str2;
        String str3;
        CpInfo cpInfo;
        User cpUserInfo;
        CpInfo cpInfo2;
        User userInfo;
        CpSpace cpSpace = (CpSpace) getCpSpace().getValue();
        String str4 = null;
        if (cpSpace != null && (cpInfo2 = cpSpace.getCpInfo()) != null && (userInfo = cpInfo2.getUserInfo()) != null) {
            str = userInfo.getExternalId();
        } else {
            str = null;
        }
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        if (user != null) {
            str2 = user.getExternalId();
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str, str2)) {
            CpSpace cpSpace2 = (CpSpace) getCpSpace().getValue();
            if (cpSpace2 != null && (cpInfo = cpSpace2.getCpInfo()) != null && (cpUserInfo = cpInfo.getCpUserInfo()) != null) {
                str3 = cpUserInfo.getExternalId();
            } else {
                str3 = null;
            }
            User user2 = companion.getShared().getUser();
            if (user2 != null) {
                str4 = user2.getExternalId();
            }
            if (!Intrinsics.areEqual(str3, str4)) {
                return false;
            }
        }
        return true;
    }

    public final void cpRelation(@NotNull String externalId) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> cpRelation;
        nd.c observeOnMainThread$default;
        UserService userService;
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> specialRelation;
        nd.c observeOnMainThread$default2;
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        int i = this.mRelationType;
        if (i != 1) {
            if ((i == 2 || i == 3 || i == 4) && (userService = this.repository) != null && (specialRelation = userService.specialRelation(externalId, 2, i)) != null && (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(specialRelation, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.g2
                public final Object invoke(Object obj) {
                    Unit cpRelation$lambda$8;
                    cpRelation$lambda$8 = CpSpaceViewModel.cpRelation$lambda$8(CpSpaceViewModel.this, (ApiResponse) obj);
                    return cpRelation$lambda$8;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.h2
                public final Object invoke(Object obj) {
                    Unit cpRelation$lambda$9;
                    cpRelation$lambda$9 = CpSpaceViewModel.cpRelation$lambda$9(CpSpaceViewModel.this, (Throwable) obj);
                    return cpRelation$lambda$9;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
                return;
            }
            return;
        }
        UserService userService2 = this.repository;
        if (userService2 != null && (cpRelation = userService2.cpRelation(externalId, 2)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpRelation, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.e2
            public final Object invoke(Object obj) {
                Unit cpRelation$lambda$6;
                cpRelation$lambda$6 = CpSpaceViewModel.cpRelation$lambda$6(CpSpaceViewModel.this, (ApiResponse) obj);
                return cpRelation$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.f2
            public final Object invoke(Object obj) {
                Unit cpRelation$lambda$7;
                cpRelation$lambda$7 = CpSpaceViewModel.cpRelation$lambda$7(CpSpaceViewModel.this, (Throwable) obj);
                return cpRelation$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void cpReply(@NotNull String externalId) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> cpReply;
        nd.c observeOnMainThread$default;
        UserService userService;
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> relationReply;
        nd.c observeOnMainThread$default2;
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        int i = this.mRelationType;
        if (i != 1) {
            if ((i == 2 || i == 3 || i == 4) && (userService = this.repository) != null && (relationReply = userService.relationReply(externalId, 1, i)) != null && (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(relationReply, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.x1
                public final Object invoke(Object obj) {
                    Unit cpReply$lambda$12;
                    cpReply$lambda$12 = CpSpaceViewModel.cpReply$lambda$12(CpSpaceViewModel.this, (ApiResponse) obj);
                    return cpReply$lambda$12;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.y1
                public final Object invoke(Object obj) {
                    Unit cpReply$lambda$13;
                    cpReply$lambda$13 = CpSpaceViewModel.cpReply$lambda$13(CpSpaceViewModel.this, (Throwable) obj);
                    return cpReply$lambda$13;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
                return;
            }
            return;
        }
        UserService userService2 = this.repository;
        if (userService2 != null && (cpReply = userService2.cpReply(externalId, 1)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpReply, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.i2
            public final Object invoke(Object obj) {
                Unit cpReply$lambda$10;
                cpReply$lambda$10 = CpSpaceViewModel.cpReply$lambda$10(CpSpaceViewModel.this, (ApiResponse) obj);
                return cpReply$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.j2
            public final Object invoke(Object obj) {
                Unit cpReply$lambda$11;
                cpReply$lambda$11 = CpSpaceViewModel.cpReply$lambda$11(CpSpaceViewModel.this, (Throwable) obj);
                return cpReply$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void cpSpace() {
        nd.c observeOnMainThread$default;
        UserService userService;
        nd.c observeOnMainThread$default2;
        int i = this.mRelationType;
        String str = "";
        if (i != 1) {
            if ((i == 2 || i == 3 || i == 4) && (userService = this.repository) != null) {
                String str2 = this.mExternalId1;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = this.mExternalId2;
                if (str3 != null) {
                    str = str3;
                }
                io.reactivex.rxjava3.core.i0<ApiResponse<CpSpace>> relationSpace = userService.relationSpace(str2, str, i);
                if (relationSpace != null && (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(relationSpace, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.c2
                    public final Object invoke(Object obj) {
                        Unit cpSpace$lambda$2;
                        cpSpace$lambda$2 = CpSpaceViewModel.cpSpace$lambda$2(CpSpaceViewModel.this, (ApiResponse) obj);
                        return cpSpace$lambda$2;
                    }
                }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.d2
                    public final Object invoke(Object obj) {
                        Unit cpSpace$lambda$3;
                        cpSpace$lambda$3 = CpSpaceViewModel.cpSpace$lambda$3((Throwable) obj);
                        return cpSpace$lambda$3;
                    }
                }, (Function0) null, false, 12, (Object) null)) != null) {
                    RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
                    return;
                }
                return;
            }
            return;
        }
        UserService userService2 = this.repository;
        if (userService2 != null) {
            String str4 = this.mExternalId1;
            if (str4 != null) {
                str = str4;
            }
            io.reactivex.rxjava3.core.i0<ApiResponse<CpSpace>> cpSpace = userService2.cpSpace(str);
            if (cpSpace != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpSpace, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.w1
                public final Object invoke(Object obj) {
                    Unit cpSpace$lambda$0;
                    cpSpace$lambda$0 = CpSpaceViewModel.cpSpace$lambda$0(CpSpaceViewModel.this, (ApiResponse) obj);
                    return cpSpace$lambda$0;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.b2
                public final Object invoke(Object obj) {
                    Unit cpSpace$lambda$1;
                    cpSpace$lambda$1 = CpSpaceViewModel.cpSpace$lambda$1((Throwable) obj);
                    return cpSpace$lambda$1;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
            }
        }
    }

    @NotNull
    public final LiveData<Boolean> getCpExit() {
        return this.cpExitMutable;
    }

    @NotNull
    public final LiveData<CpSpace> getCpSpace() {
        return this.cpSpaceMutable;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @Nullable
    public final String getMExternalId1() {
        return this.mExternalId1;
    }

    @Nullable
    public final String getMExternalId2() {
        return this.mExternalId2;
    }

    public final int getMRelationType() {
        return this.mRelationType;
    }

    @NotNull
    public final LiveData<Integer> getPrivilegeOpen() {
        return this.privilegeOpenMutable;
    }

    @NotNull
    public final LiveData<Boolean> getSuccess() {
        return this.successMutable;
    }

    public final void privilegeOpen(final int type, int openClose) {
        io.reactivex.rxjava3.core.i0<ApiResponse<Object>> cpOpenClose;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (cpOpenClose = userService.cpOpenClose(type, openClose, this.mRelationType)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(cpOpenClose, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.z1
            public final Object invoke(Object obj) {
                Unit privilegeOpen$lambda$4;
                privilegeOpen$lambda$4 = CpSpaceViewModel.privilegeOpen$lambda$4(CpSpaceViewModel.this, type, (ApiResponse) obj);
                return privilegeOpen$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.cp.a2
            public final Object invoke(Object obj) {
                Unit privilegeOpen$lambda$5;
                privilegeOpen$lambda$5 = CpSpaceViewModel.privilegeOpen$lambda$5(CpSpaceViewModel.this, (Throwable) obj);
                return privilegeOpen$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public final void setMExternalId1(@Nullable String str) {
        this.mExternalId1 = str;
    }

    public final void setMExternalId2(@Nullable String str) {
        this.mExternalId2 = str;
    }

    public final void setMRelationType(int i) {
        this.mRelationType = i;
    }

    public CpSpaceViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.cpSpaceMutable = new MutableLiveData<>();
        this.cpExitMutable = new MutableLiveData<>();
        this.successMutable = new MutableLiveData<>();
        this.privilegeOpenMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    public /* synthetic */ CpSpaceViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
