package com.qiahao.nextvideo.ui.family;

import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.network.AppServer;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005JI\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R*\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001a¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilySettingViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "Lcom/qiahao/nextvideo/data/service/UserService;", "repository", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "", TUIConstants.TUIChat.INPUT_MORE_ICON, "name", "nameplate", "declaration", "md5", "", "familySetting", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "checkDeleteFamily", "()V", "deleteFamily", "Lcom/qiahao/nextvideo/data/service/UserService;", "Lma/b;", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "familyInfo", "Lma/b;", "getFamilyInfo", "()Lma/b;", "setFamilyInfo", "(Lma/b;)V", "", BaseMonitor.COUNT_ERROR, "getError", "setError", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilySettingViewModel extends BaseViewModel {

    @NotNull
    public static final String CHECK_DELETE_FAMILY = "CHECK_DELETE_FAMILY";

    @NotNull
    public static final String DELETE_FAMILY = "DELETE_FAMILY";

    @NotNull
    private ma.b error;

    @NotNull
    private ma.b familyInfo;

    @Nullable
    private final UserService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FamilySettingViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkDeleteFamily$lambda$2(FamilySettingViewModel familySettingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familySettingViewModel.getMSuccess().setValue(new Pair(CHECK_DELETE_FAMILY, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkDeleteFamily$lambda$3(FamilySettingViewModel familySettingViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familySettingViewModel.getMException().setValue(new Pair(CHECK_DELETE_FAMILY, th));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteFamily$lambda$4(FamilySettingViewModel familySettingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familySettingViewModel.getMSuccess().setValue(new Pair(DELETE_FAMILY, apiResponse));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteFamily$lambda$5(FamilySettingViewModel familySettingViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familySettingViewModel.getMException().setValue(new Pair(DELETE_FAMILY, th));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void familySetting$default(FamilySettingViewModel familySettingViewModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        if ((i & 16) != 0) {
            str5 = null;
        }
        familySettingViewModel.familySetting(str, str2, str3, str4, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familySetting$lambda$0(FamilySettingViewModel familySettingViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        familySettingViewModel.familyInfo.setValue(apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit familySetting$lambda$1(FamilySettingViewModel familySettingViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        familySettingViewModel.error.setValue(th);
        return Unit.INSTANCE;
    }

    public final void checkDeleteFamily() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkDeleteFamily(), new Function1() { // from class: com.qiahao.nextvideo.ui.family.s3
            public final Object invoke(Object obj) {
                Unit checkDeleteFamily$lambda$2;
                checkDeleteFamily$lambda$2 = FamilySettingViewModel.checkDeleteFamily$lambda$2(FamilySettingViewModel.this, (ApiResponse) obj);
                return checkDeleteFamily$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.t3
            public final Object invoke(Object obj) {
                Unit checkDeleteFamily$lambda$3;
                checkDeleteFamily$lambda$3 = FamilySettingViewModel.checkDeleteFamily$lambda$3(FamilySettingViewModel.this, (Throwable) obj);
                return checkDeleteFamily$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void deleteFamily() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().deleteFamily(), new Function1() { // from class: com.qiahao.nextvideo.ui.family.q3
            public final Object invoke(Object obj) {
                Unit deleteFamily$lambda$4;
                deleteFamily$lambda$4 = FamilySettingViewModel.deleteFamily$lambda$4(FamilySettingViewModel.this, (ApiResponse) obj);
                return deleteFamily$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.r3
            public final Object invoke(Object obj) {
                Unit deleteFamily$lambda$5;
                deleteFamily$lambda$5 = FamilySettingViewModel.deleteFamily$lambda$5(FamilySettingViewModel.this, (Throwable) obj);
                return deleteFamily$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void familySetting(@Nullable String icon, @Nullable String name, @Nullable String nameplate, @Nullable String declaration, @Nullable String md5) {
        long j;
        nd.c observeOnMainThread$default;
        Long id2;
        UserService userService = this.repository;
        if (userService != null) {
            FamilyInfo familyInfo = (FamilyInfo) this.familyInfo.getValue();
            if (familyInfo != null && (id2 = familyInfo.getId()) != null) {
                j = id2.longValue();
            } else {
                j = 0;
            }
            io.reactivex.rxjava3.core.i0<ApiResponse<FamilyInfo>> familySetting = userService.familySetting(j, icon, name, nameplate, declaration, md5);
            if (familySetting != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(familySetting, new Function1() { // from class: com.qiahao.nextvideo.ui.family.o3
                public final Object invoke(Object obj) {
                    Unit familySetting$lambda$0;
                    familySetting$lambda$0 = FamilySettingViewModel.familySetting$lambda$0(FamilySettingViewModel.this, (ApiResponse) obj);
                    return familySetting$lambda$0;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.p3
                public final Object invoke(Object obj) {
                    Unit familySetting$lambda$1;
                    familySetting$lambda$1 = FamilySettingViewModel.familySetting$lambda$1(FamilySettingViewModel.this, (Throwable) obj);
                    return familySetting$lambda$1;
                }
            }, (Function0) null, false, 12, (Object) null)) != null) {
                RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
            }
        }
    }

    @NotNull
    public final ma.b getError() {
        return this.error;
    }

    @NotNull
    public final ma.b getFamilyInfo() {
        return this.familyInfo;
    }

    public final void setError(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.error = bVar;
    }

    public final void setFamilyInfo(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.familyInfo = bVar;
    }

    public /* synthetic */ FamilySettingViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }

    public FamilySettingViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.familyInfo = new ma.b();
        this.error = new ma.b();
    }
}
