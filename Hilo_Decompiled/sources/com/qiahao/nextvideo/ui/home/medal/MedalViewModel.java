package com.qiahao.nextvideo.ui.home.medal;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.medal.MedalSort;
import com.qiahao.nextvideo.data.model.MedalAllTypeBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.taobao.accs.utl.BaseMonitor;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0014\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ*\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\"R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00100\u00138F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/MedalViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "getRepository", "()Lcom/qiahao/nextvideo/data/service/UserService;", "fragmentType", "", "getFragmentType", "()Ljava/lang/String;", "setFragmentType", "(Ljava/lang/String;)V", "onModelListMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/data/model/MedalAllTypeBean;", "modelList", "Landroidx/lifecycle/LiveData;", "getModelList", "()Landroidx/lifecycle/LiveData;", "onModelSortListMutable", "Lcom/qiahao/nextvideo/data/medal/MedalSort;", "modelSortList", "getModelSortList", "errorMutable", "", BaseMonitor.COUNT_ERROR, "getError", "", "getMedalSort", "setMedalSort", "pos", "", "medalId", "data", "Lcom/qiahao/base_common/model/common/MedalInfo;", "isHas", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMedalViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MedalViewModel.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalViewModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,126:1\n1#2:127\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MedalViewModel extends BaseViewModel {

    @NotNull
    private final MutableLiveData<Throwable> errorMutable;

    @NotNull
    private String fragmentType;

    @NotNull
    private final MutableLiveData<List<MedalAllTypeBean>> onModelListMutable;

    @NotNull
    private final MutableLiveData<List<MedalSort>> onModelSortListMutable;

    @Nullable
    private final UserService repository;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MedalViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMedalSort$lambda$6(MedalViewModel medalViewModel, ApiResponse apiResponse) {
        int i;
        MedalSort medalSort;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 8; i2++) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            if (i > i2) {
                List list2 = (List) apiResponse.getData();
                if (list2 == null || (medalSort = (MedalSort) list2.get(i2)) == null) {
                    medalSort = new MedalSort(0, null, Integer.valueOf(i2 + 1), 2, null);
                }
                arrayList.add(medalSort);
            } else {
                arrayList.add(new MedalSort(0, null, Integer.valueOf(i2 + 1), 2, null));
            }
        }
        medalViewModel.onModelSortListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getMedalSort$lambda$7(MedalViewModel medalViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        medalViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getModelList$lambda$1(MedalViewModel medalViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            medalViewModel.onModelListMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getModelList$lambda$2(MedalViewModel medalViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        medalViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getModelList$lambda$4(MedalViewModel medalViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            medalViewModel.onModelListMutable.setValue(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getModelList$lambda$5(MedalViewModel medalViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        medalViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void setMedalSort$default(MedalViewModel medalViewModel, int i, int i2, MedalInfo medalInfo, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = -1;
        }
        medalViewModel.setMedalSort(i, i2, medalInfo, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMedalSort$lambda$10(MedalViewModel medalViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        medalViewModel.errorMutable.setValue(th);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMedalSort$lambda$9(MedalViewModel medalViewModel, int i, int i2, int i3, MedalInfo medalInfo, ApiResponse apiResponse) {
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        List list2 = null;
        if (user != null) {
            User user2 = (User) apiResponse.getData();
            if (user2 != null) {
                list = user2.getMedalInfo();
            } else {
                list = null;
            }
            user.setMedalInfo(list);
        }
        if (user != null) {
            User user3 = (User) apiResponse.getData();
            if (user3 != null) {
                list2 = user3.getMedals();
            }
            user.setMedals(list2);
        }
        UserStore.refreshUserInfo$default(companion.getShared(), user, null, null, false, 14, null);
        ArrayList arrayList = new ArrayList();
        List list3 = (List) medalViewModel.onModelSortListMutable.getValue();
        if (list3 != null) {
            arrayList.addAll(list3);
        }
        if (i != -1) {
            arrayList.set(i, new MedalSort(0, null, Integer.valueOf(i2 + 1), 2, null));
        }
        if (i3 == 0) {
            arrayList.set(i2, new MedalSort(0, null, Integer.valueOf(i2 + 1), 2, null));
        } else {
            arrayList.set(i2, new MedalSort(Integer.valueOf(medalInfo.getId()), medalInfo.getPicUrl(), Integer.valueOf(i2 + 1)));
        }
        medalViewModel.onModelSortListMutable.setValue(arrayList);
        return Unit.INSTANCE;
    }

    @NotNull
    public final LiveData<Throwable> getError() {
        return this.errorMutable;
    }

    @NotNull
    public final String getFragmentType() {
        return this.fragmentType;
    }

    public final void getMedalSort() {
        i0<ApiResponse<List<MedalSort>>> medalSort;
        nd.c observeOnMainThread$default;
        UserService userService = this.repository;
        if (userService != null && (medalSort = userService.getMedalSort()) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(medalSort, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.a0
            public final Object invoke(Object obj) {
                Unit medalSort$lambda$6;
                medalSort$lambda$6 = MedalViewModel.getMedalSort$lambda$6(MedalViewModel.this, (ApiResponse) obj);
                return medalSort$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.b0
            public final Object invoke(Object obj) {
                Unit medalSort$lambda$7;
                medalSort$lambda$7 = MedalViewModel.getMedalSort$lambda$7(MedalViewModel.this, (Throwable) obj);
                return medalSort$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    @NotNull
    public final LiveData<List<MedalAllTypeBean>> getModelList() {
        return this.onModelListMutable;
    }

    @NotNull
    public final LiveData<List<MedalSort>> getModelSortList() {
        return this.onModelSortListMutable;
    }

    @Nullable
    public final UserService getRepository() {
        return this.repository;
    }

    public final void setFragmentType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fragmentType = str;
    }

    public final void setMedalSort(final int pos, final int medalId, @NotNull final MedalInfo data, final int isHas) {
        i0<ApiResponse<User>> medalSort;
        nd.c observeOnMainThread$default;
        Intrinsics.checkNotNullParameter(data, "data");
        UserService userService = this.repository;
        if (userService != null && (medalSort = userService.setMedalSort(pos + 1, medalId)) != null && (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(medalSort, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.y
            public final Object invoke(Object obj) {
                Unit medalSort$lambda$9;
                medalSort$lambda$9 = MedalViewModel.setMedalSort$lambda$9(MedalViewModel.this, isHas, pos, medalId, data, (ApiResponse) obj);
                return medalSort$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.z
            public final Object invoke(Object obj) {
                Unit medalSort$lambda$10;
                medalSort$lambda$10 = MedalViewModel.setMedalSort$lambda$10(MedalViewModel.this, (Throwable) obj);
                return medalSort$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null)) != null) {
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
        }
    }

    public MedalViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.fragmentType = "";
        this.onModelListMutable = new MutableLiveData<>();
        this.onModelSortListMutable = new MutableLiveData<>();
        this.errorMutable = new MutableLiveData<>();
    }

    /* renamed from: getModelList, reason: collision with other method in class */
    public final void m٧٧getModelList() {
        i0<ApiResponse<List<MedalAllTypeBean>>> roomMedal;
        nd.c observeOnMainThread$default;
        i0<ApiResponse<List<MedalAllTypeBean>>> allPublicMedalType;
        nd.c observeOnMainThread$default2;
        if (Intrinsics.areEqual(this.fragmentType, MedalActivity.TYPE_PERSONAL)) {
            UserService userService = this.repository;
            if (userService == null || (allPublicMedalType = userService.getAllPublicMedalType()) == null || (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(allPublicMedalType, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.c0
                public final Object invoke(Object obj) {
                    Unit modelList$lambda$1;
                    modelList$lambda$1 = MedalViewModel.getModelList$lambda$1(MedalViewModel.this, (ApiResponse) obj);
                    return modelList$lambda$1;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.d0
                public final Object invoke(Object obj) {
                    Unit modelList$lambda$2;
                    modelList$lambda$2 = MedalViewModel.getModelList$lambda$2(MedalViewModel.this, (Throwable) obj);
                    return modelList$lambda$2;
                }
            }, (Function0) null, false, 12, (Object) null)) == null) {
                return;
            }
            RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
            return;
        }
        UserService userService2 = this.repository;
        if (userService2 == null || (roomMedal = userService2.getRoomMedal()) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(roomMedal, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.e0
            public final Object invoke(Object obj) {
                Unit modelList$lambda$4;
                modelList$lambda$4 = MedalViewModel.getModelList$lambda$4(MedalViewModel.this, (ApiResponse) obj);
                return modelList$lambda$4;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.f0
            public final Object invoke(Object obj) {
                Unit modelList$lambda$5;
                modelList$lambda$5 = MedalViewModel.getModelList$lambda$5(MedalViewModel.this, (Throwable) obj);
                return modelList$lambda$5;
            }
        }, (Function0) null, false, 12, (Object) null)) == null) {
            return;
        }
        RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
    }

    public /* synthetic */ MedalViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }
}
