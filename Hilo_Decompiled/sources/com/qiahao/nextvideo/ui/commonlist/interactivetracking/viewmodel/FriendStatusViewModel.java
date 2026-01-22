package com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.viewmodel.BaseViewModel;
import com.qiahao.nextvideo.data.model.ILikeGuyItem;
import com.qiahao.nextvideo.data.model.LikeMeGuyItem;
import com.qiahao.nextvideo.data.model.PraiseGuyItem;
import com.qiahao.nextvideo.data.model.VisitGuyItem;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.ILikeCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.InteractiveTrackingType;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.LikeMeCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.PraiseCellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.VisitorCellUIModel;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import io.reactivex.rxjava3.core.i0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u000e\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0014R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/viewmodel/FriendStatusViewModel;", "Lcom/qiahao/base_common/viewmodel/BaseViewModel;", "repository", "Lcom/qiahao/nextvideo/data/service/UserService;", "<init>", "(Lcom/qiahao/nextvideo/data/service/UserService;)V", "mCurStatusType", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "getMCurStatusType", "()Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "setMCurStatusType", "(Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;)V", "listData", "Lcom/qiahao/base_common/model/BaseListData;", "getListData", "()Lcom/qiahao/base_common/model/BaseListData;", "listData$delegate", "Lkotlin/Lazy;", "listMutable", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;", "friendList", "Landroidx/lifecycle/LiveData;", "getFriendList", "()Landroidx/lifecycle/LiveData;", "reportEvent", "", "onCleared", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFriendStatusViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendStatusViewModel.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/viewmodel/FriendStatusViewModel\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,151:1\n774#2:152\n865#2,2:153\n1563#2:155\n1634#2,3:156\n774#2:159\n865#2,2:160\n1563#2:162\n1634#2,3:163\n774#2:166\n865#2,2:167\n1563#2:169\n1634#2,3:170\n774#2:173\n865#2,2:174\n1563#2:176\n1634#2,3:177\n*S KotlinDebug\n*F\n+ 1 FriendStatusViewModel.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/viewmodel/FriendStatusViewModel\n*L\n70#1:152\n70#1:153,2\n71#1:155\n71#1:156,3\n92#1:159\n92#1:160,2\n93#1:162\n93#1:163,3\n113#1:166\n113#1:167,2\n114#1:169\n114#1:170,3\n132#1:173\n132#1:174,2\n132#1:176\n132#1:177,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendStatusViewModel extends BaseViewModel {

    /* renamed from: listData$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listData;

    @NotNull
    private final MutableLiveData<List<CellUIModel>> listMutable;

    @NotNull
    private InteractiveTrackingType mCurStatusType;

    @Nullable
    private final UserService repository;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InteractiveTrackingType.values().length];
            try {
                iArr[InteractiveTrackingType.ILike.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InteractiveTrackingType.Follow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InteractiveTrackingType.Visitor.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InteractiveTrackingType.Praise.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FriendStatusViewModel() {
        this(r0, 1, r0);
        UserService userService = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$10(FriendStatusViewModel friendStatusViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((LikeMeGuyItem) obj).getUser() != null) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(LikeMeCellUIModel.INSTANCE.init((LikeMeGuyItem) it.next()));
                }
                friendStatusViewModel.getListData().setList(arrayList2);
                friendStatusViewModel.listMutable.setValue(arrayList2);
            }
        } else {
            friendStatusViewModel.getListData().setList(new ArrayList());
            friendStatusViewModel.listMutable.setValue(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$11(FriendStatusViewModel friendStatusViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        friendStatusViewModel.getListData().requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$15(FriendStatusViewModel friendStatusViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((VisitGuyItem) obj).getUser() != null) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(VisitorCellUIModel.INSTANCE.init((VisitGuyItem) it.next()));
                }
                friendStatusViewModel.getListData().setList(arrayList2);
                friendStatusViewModel.listMutable.setValue(arrayList2);
            }
        } else {
            friendStatusViewModel.getListData().setList(new ArrayList());
            friendStatusViewModel.listMutable.setValue(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$16(FriendStatusViewModel friendStatusViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        friendStatusViewModel.getListData().requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$20(FriendStatusViewModel friendStatusViewModel, ApiResponse apiResponse) {
        List list;
        List data;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ApiList apiList = (ApiList) apiResponse.getData();
        if (apiList != null) {
            list = apiList.getData();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            ApiList apiList2 = (ApiList) apiResponse.getData();
            if (apiList2 != null && (data = apiList2.getData()) != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    if (((PraiseGuyItem) obj).getUser() != null) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(PraiseCellUIModel.INSTANCE.init((PraiseGuyItem) it.next()));
                }
                friendStatusViewModel.getListData().setList(arrayList2);
                friendStatusViewModel.listMutable.setValue(arrayList2);
            }
        } else {
            friendStatusViewModel.getListData().setList(new ArrayList());
            friendStatusViewModel.listMutable.setValue(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$21(FriendStatusViewModel friendStatusViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        friendStatusViewModel.getListData().requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$5(FriendStatusViewModel friendStatusViewModel, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            List list = (List) apiResponse.getData();
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((ILikeGuyItem) obj).getUser() != null) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(ILikeCellUIModel.INSTANCE.init((ILikeGuyItem) it.next()));
                }
                friendStatusViewModel.getListData().setList(arrayList2);
                friendStatusViewModel.listMutable.setValue(arrayList2);
            }
        } else {
            friendStatusViewModel.getListData().setList(new ArrayList());
            friendStatusViewModel.listMutable.setValue(new ArrayList());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getListData$lambda$6(FriendStatusViewModel friendStatusViewModel, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        friendStatusViewModel.getListData().requestError();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseListData listData_delegate$lambda$1() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        return baseListData;
    }

    @NotNull
    public final LiveData<List<CellUIModel>> getFriendList() {
        return this.listMutable;
    }

    @NotNull
    public final BaseListData getListData() {
        return (BaseListData) this.listData.getValue();
    }

    @NotNull
    public final InteractiveTrackingType getMCurStatusType() {
        return this.mCurStatusType;
    }

    protected void onCleared() {
        super.onCleared();
        getListData().destroy();
    }

    public final void reportEvent() {
        nd.c subscribe = FeedbackService.INSTANCE.getShared().getReportEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.FriendStatusViewModel$reportEvent$1
            public final void accept(String str) {
                try {
                    FriendStatusViewModel.this.getListData().resetPage();
                    FriendStatusViewModel.this.m٦٥getListData();
                } catch (Exception e) {
                    DebugToolsKt.printfE("FriendStatusFragment", "reportEventRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getMCompositeDisposable());
    }

    public final void setMCurStatusType(@NotNull InteractiveTrackingType interactiveTrackingType) {
        Intrinsics.checkNotNullParameter(interactiveTrackingType, "<set-?>");
        this.mCurStatusType = interactiveTrackingType;
    }

    public /* synthetic */ FriendStatusViewModel(UserService userService, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UserService() : userService);
    }

    /* renamed from: getListData, reason: collision with other method in class */
    public final void m٦٥getListData() {
        i0<ApiResponse<List<ILikeGuyItem>>> fetchILikeList;
        nd.c observeOnMainThread$default;
        i0 fetchLikeMeList$default;
        nd.c observeOnMainThread$default2;
        i0<ApiResponse<List<VisitGuyItem>>> fetchVisitorList;
        nd.c observeOnMainThread$default3;
        i0<ApiResponse<ApiList<PraiseGuyItem>>> fetchUserPraiseList;
        nd.c observeOnMainThread$default4;
        int i = WhenMappings.$EnumSwitchMapping$0[this.mCurStatusType.ordinal()];
        if (i == 1) {
            UserService userService = this.repository;
            if (userService == null || (fetchILikeList = userService.fetchILikeList(getListData().nextPage(), getListData().getPageSize())) == null || (observeOnMainThread$default = RxUtilsKt.observeOnMainThread$default(fetchILikeList, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.b
                public final Object invoke(Object obj) {
                    Unit listData$lambda$5;
                    listData$lambda$5 = FriendStatusViewModel.getListData$lambda$5(FriendStatusViewModel.this, (ApiResponse) obj);
                    return listData$lambda$5;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.c
                public final Object invoke(Object obj) {
                    Unit listData$lambda$6;
                    listData$lambda$6 = FriendStatusViewModel.getListData$lambda$6(FriendStatusViewModel.this, (Throwable) obj);
                    return listData$lambda$6;
                }
            }, (Function0) null, false, 12, (Object) null)) == null) {
                return;
            }
            RxUtilsKt.addTo(observeOnMainThread$default, getMCompositeDisposable());
            return;
        }
        if (i == 2) {
            UserService userService2 = this.repository;
            if (userService2 == null || (fetchLikeMeList$default = UserService.fetchLikeMeList$default(userService2, getListData().nextPage(), getListData().getPageSize(), false, 4, null)) == null || (observeOnMainThread$default2 = RxUtilsKt.observeOnMainThread$default(fetchLikeMeList$default, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.d
                public final Object invoke(Object obj) {
                    Unit listData$lambda$10;
                    listData$lambda$10 = FriendStatusViewModel.getListData$lambda$10(FriendStatusViewModel.this, (ApiResponse) obj);
                    return listData$lambda$10;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.e
                public final Object invoke(Object obj) {
                    Unit listData$lambda$11;
                    listData$lambda$11 = FriendStatusViewModel.getListData$lambda$11(FriendStatusViewModel.this, (Throwable) obj);
                    return listData$lambda$11;
                }
            }, (Function0) null, false, 12, (Object) null)) == null) {
                return;
            }
            RxUtilsKt.addTo(observeOnMainThread$default2, getMCompositeDisposable());
            return;
        }
        if (i == 3) {
            UserService userService3 = this.repository;
            if (userService3 == null || (fetchVisitorList = userService3.fetchVisitorList(getListData().nextPage(), getListData().getPageSize())) == null || (observeOnMainThread$default3 = RxUtilsKt.observeOnMainThread$default(fetchVisitorList, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.f
                public final Object invoke(Object obj) {
                    Unit listData$lambda$15;
                    listData$lambda$15 = FriendStatusViewModel.getListData$lambda$15(FriendStatusViewModel.this, (ApiResponse) obj);
                    return listData$lambda$15;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.g
                public final Object invoke(Object obj) {
                    Unit listData$lambda$16;
                    listData$lambda$16 = FriendStatusViewModel.getListData$lambda$16(FriendStatusViewModel.this, (Throwable) obj);
                    return listData$lambda$16;
                }
            }, (Function0) null, false, 12, (Object) null)) == null) {
                return;
            }
            RxUtilsKt.addTo(observeOnMainThread$default3, getMCompositeDisposable());
            return;
        }
        if (i == 4) {
            UserService userService4 = this.repository;
            if (userService4 == null || (fetchUserPraiseList = userService4.fetchUserPraiseList(getListData().nextPage(), getListData().getPageSize())) == null || (observeOnMainThread$default4 = RxUtilsKt.observeOnMainThread$default(fetchUserPraiseList, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.h
                public final Object invoke(Object obj) {
                    Unit listData$lambda$20;
                    listData$lambda$20 = FriendStatusViewModel.getListData$lambda$20(FriendStatusViewModel.this, (ApiResponse) obj);
                    return listData$lambda$20;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.i
                public final Object invoke(Object obj) {
                    Unit listData$lambda$21;
                    listData$lambda$21 = FriendStatusViewModel.getListData$lambda$21(FriendStatusViewModel.this, (Throwable) obj);
                    return listData$lambda$21;
                }
            }, (Function0) null, false, 12, (Object) null)) == null) {
                return;
            }
            RxUtilsKt.addTo(observeOnMainThread$default4, getMCompositeDisposable());
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    public FriendStatusViewModel(@Nullable UserService userService) {
        this.repository = userService;
        this.mCurStatusType = InteractiveTrackingType.Follow;
        this.listData = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.a
            public final Object invoke() {
                BaseListData listData_delegate$lambda$1;
                listData_delegate$lambda$1 = FriendStatusViewModel.listData_delegate$lambda$1();
                return listData_delegate$lambda$1;
            }
        });
        this.listMutable = new MutableLiveData<>();
    }
}
