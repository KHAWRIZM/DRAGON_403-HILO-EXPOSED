package com.qiahao.nextvideo.room.fragment;

import android.widget.Toast;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.GroupThemesBean;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.room.viewmodel.GroupThemesViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\bR8\u0010\u001e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d0\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R8\u0010%\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020$0\u001bj\b\u0012\u0004\u0012\u00020$`\u001d0\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#¨\u0006("}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/GroupThemeViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "<init>", "()V", "Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;", "groupThemesViewModel", "", "setActivityViewModel", "(Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;)V", "getAllCommonThemeData", "", "groupId", "getAllCustomThemeData", "(Ljava/lang/String;)V", "mGroupId", "", "themeId", "themeUrl", "updateCommonThemes", "(Ljava/lang/String;ILjava/lang/String;)V", "usingCustomThemes", "mActivityViewModel", "Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;", "getMActivityViewModel", "()Lcom/qiahao/nextvideo/room/viewmodel/GroupThemesViewModel;", "setMActivityViewModel", "Lma/b;", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/GroupThemesBean;", "Lkotlin/collections/ArrayList;", "mGroupThemeListUnPeekLiveData", "Lma/b;", "getMGroupThemeListUnPeekLiveData", "()Lma/b;", "setMGroupThemeListUnPeekLiveData", "(Lma/b;)V", "Lcom/qiahao/nextvideo/data/model/CustomThemeBean;", "mCustomThemeListUnPeekLiveData", "getMCustomThemeListUnPeekLiveData", "setMCustomThemeListUnPeekLiveData", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupThemeViewModel extends BaseViewModel {
    public GroupThemesViewModel mActivityViewModel;

    @NotNull
    private ma.b mGroupThemeListUnPeekLiveData = new ma.b();

    @NotNull
    private ma.b mCustomThemeListUnPeekLiveData = new ma.b();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAllCommonThemeData$lambda$1(GroupThemeViewModel groupThemeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        List list = (List) apiResponse.getData();
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new GroupThemesBean(0, ""));
        groupThemeViewModel.mGroupThemeListUnPeekLiveData.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAllCommonThemeData$lambda$2(GroupThemeViewModel groupThemeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupThemeViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAllCustomThemeData$lambda$4(GroupThemeViewModel groupThemeViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            groupThemeViewModel.mCustomThemeListUnPeekLiveData.setValue(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAllCustomThemeData$lambda$5(GroupThemeViewModel groupThemeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupThemeViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCommonThemes$lambda$6(GroupThemeViewModel groupThemeViewModel, int i, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupThemeViewModel, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        cf.c.c().l(new RoomEvent().updateGroupBackGroup(i, str, 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateCommonThemes$lambda$7(GroupThemeViewModel groupThemeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupThemeViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usingCustomThemes$lambda$8(GroupThemeViewModel groupThemeViewModel, int i, String str, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupThemeViewModel, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        cf.c.c().l(new RoomEvent().updateGroupBackGroup(i, str, 2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit usingCustomThemes$lambda$9(GroupThemeViewModel groupThemeViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ActivityLifecycleManager.INSTANCE.currentActivity(), ResourcesKtxKt.getStringById(groupThemeViewModel, 2131952667), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    public final void getAllCommonThemeData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getGroupThemes(), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.z
            public final Object invoke(Object obj) {
                Unit allCommonThemeData$lambda$1;
                allCommonThemeData$lambda$1 = GroupThemeViewModel.getAllCommonThemeData$lambda$1(GroupThemeViewModel.this, (ApiResponse) obj);
                return allCommonThemeData$lambda$1;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.a0
            public final Object invoke(Object obj) {
                Unit allCommonThemeData$lambda$2;
                allCommonThemeData$lambda$2 = GroupThemeViewModel.getAllCommonThemeData$lambda$2(GroupThemeViewModel.this, (Throwable) obj);
                return allCommonThemeData$lambda$2;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void getAllCustomThemeData(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getAllCustomTheme(groupId), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.x
            public final Object invoke(Object obj) {
                Unit allCustomThemeData$lambda$4;
                allCustomThemeData$lambda$4 = GroupThemeViewModel.getAllCustomThemeData$lambda$4(GroupThemeViewModel.this, (ApiResponse) obj);
                return allCustomThemeData$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.y
            public final Object invoke(Object obj) {
                Unit allCustomThemeData$lambda$5;
                allCustomThemeData$lambda$5 = GroupThemeViewModel.getAllCustomThemeData$lambda$5(GroupThemeViewModel.this, (Throwable) obj);
                return allCustomThemeData$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    @NotNull
    public final GroupThemesViewModel getMActivityViewModel() {
        GroupThemesViewModel groupThemesViewModel = this.mActivityViewModel;
        if (groupThemesViewModel != null) {
            return groupThemesViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mActivityViewModel");
        return null;
    }

    @NotNull
    public final ma.b getMCustomThemeListUnPeekLiveData() {
        return this.mCustomThemeListUnPeekLiveData;
    }

    @NotNull
    public final ma.b getMGroupThemeListUnPeekLiveData() {
        return this.mGroupThemeListUnPeekLiveData;
    }

    public final void setActivityViewModel(@NotNull GroupThemesViewModel groupThemesViewModel) {
        Intrinsics.checkNotNullParameter(groupThemesViewModel, "groupThemesViewModel");
        setMActivityViewModel(groupThemesViewModel);
    }

    public final void setMActivityViewModel(@NotNull GroupThemesViewModel groupThemesViewModel) {
        Intrinsics.checkNotNullParameter(groupThemesViewModel, "<set-?>");
        this.mActivityViewModel = groupThemesViewModel;
    }

    public final void setMCustomThemeListUnPeekLiveData(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mCustomThemeListUnPeekLiveData = bVar;
    }

    public final void setMGroupThemeListUnPeekLiveData(@NotNull ma.b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.mGroupThemeListUnPeekLiveData = bVar;
    }

    public final void updateCommonThemes(@NotNull String mGroupId, final int themeId, @NotNull final String themeUrl) {
        Intrinsics.checkNotNullParameter(mGroupId, "mGroupId");
        Intrinsics.checkNotNullParameter(themeUrl, "themeUrl");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(ServerApi.DefaultImpls.updateGroupInfo$default(AppServer.INSTANCE.getApis(), mGroupId, null, null, null, null, null, null, null, Integer.valueOf(themeId), null, null, null, null, null, null, null, null, 130814, null), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.b0
            public final Object invoke(Object obj) {
                Unit updateCommonThemes$lambda$6;
                updateCommonThemes$lambda$6 = GroupThemeViewModel.updateCommonThemes$lambda$6(GroupThemeViewModel.this, themeId, themeUrl, (ApiResponse) obj);
                return updateCommonThemes$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.c0
            public final Object invoke(Object obj) {
                Unit updateCommonThemes$lambda$7;
                updateCommonThemes$lambda$7 = GroupThemeViewModel.updateCommonThemes$lambda$7(GroupThemeViewModel.this, (Throwable) obj);
                return updateCommonThemes$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }

    public final void usingCustomThemes(@NotNull String mGroupId, final int themeId, @NotNull final String themeUrl) {
        Intrinsics.checkNotNullParameter(mGroupId, "mGroupId");
        Intrinsics.checkNotNullParameter(themeUrl, "themeUrl");
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().usingCustomTheme(themeId, mGroupId), new Function1() { // from class: com.qiahao.nextvideo.room.fragment.v
            public final Object invoke(Object obj) {
                Unit usingCustomThemes$lambda$8;
                usingCustomThemes$lambda$8 = GroupThemeViewModel.usingCustomThemes$lambda$8(GroupThemeViewModel.this, themeId, themeUrl, (ApiResponse) obj);
                return usingCustomThemes$lambda$8;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.fragment.w
            public final Object invoke(Object obj) {
                Unit usingCustomThemes$lambda$9;
                usingCustomThemes$lambda$9 = GroupThemeViewModel.usingCustomThemes$lambda$9(GroupThemeViewModel.this, (Throwable) obj);
                return usingCustomThemes$lambda$9;
            }
        }, (Function0) null, false, 12, (Object) null), getMCompositeDisposable());
    }
}
