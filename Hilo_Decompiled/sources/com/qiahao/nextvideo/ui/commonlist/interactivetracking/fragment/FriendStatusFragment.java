package com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.LikeResult;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.UserSummaryInfo;
import com.qiahao.nextvideo.data.service.FeedbackService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentInteractiveTrackingBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.CellUIModel;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.InteractiveTrackingType;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.activity.FriendStatusListActivity;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.adapter.CellFriendStatusAdapter;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.viewmodel.FriendStatusViewModel;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.matchinghistoric.ProfileDetailUIModel;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.FastClickUtils;
import com.qiahao.nextvideo.utilities.PermissionRequester;
import com.qiahao.nextvideo.utilities.PermissionUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001f\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004J\r\u0010\u001c\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u0004J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\u0004R\u001b\u0010'\u001a\u00020\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010$\u001a\u0004\b/\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/fragment/FriendStatusFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentInteractiveTrackingBinding;", "<init>", "()V", "", "initView", "initData", "setupObserver", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;", "item", "", "position", "onClickItem", "(Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;I)V", "Landroid/view/View;", "view", "onChildClickItem", "(Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;Landroid/view/View;I)V", "Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;", "data", "clickVideo", "(Lcom/qiahao/nextvideo/ui/matchinghistoric/ProfileDetailUIModel;I)V", "likedImageViewPressed", "(I)V", "getLayoutResId", "()I", "onInitialize", "loadListData", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onLikeChange", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "onDestroy", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/viewmodel/FriendStatusViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/viewmodel/FriendStatusViewModel;", "viewModel", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/adapter/CellFriendStatusAdapter;", "mAdapter$delegate", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/adapter/CellFriendStatusAdapter;", "mAdapter", "Lnd/a;", "compositeDisposable$delegate", "getCompositeDisposable", "()Lnd/a;", "compositeDisposable", "selectedCellUIModel", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/CellUIModel;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFriendStatusFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FriendStatusFragment.kt\ncom/qiahao/nextvideo/ui/commonlist/interactivetracking/fragment/FriendStatusFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,425:1\n1#2:426\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendStatusFragment extends BaseBindingFragment<FragmentInteractiveTrackingBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private CellUIModel selectedCellUIModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.i
        public final Object invoke() {
            FriendStatusViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = FriendStatusFragment.viewModel_delegate$lambda$0(FriendStatusFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.j
        public final Object invoke() {
            CellFriendStatusAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = FriendStatusFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: compositeDisposable$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy compositeDisposable = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.k
        public final Object invoke() {
            nd.a compositeDisposable_delegate$lambda$2;
            compositeDisposable_delegate$lambda$2 = FriendStatusFragment.compositeDisposable_delegate$lambda$2();
            return compositeDisposable_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/fragment/FriendStatusFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/fragment/FriendStatusFragment;", "type", "Lcom/qiahao/nextvideo/ui/commonlist/interactivetracking/InteractiveTrackingType;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FriendStatusFragment newInstance(@NotNull InteractiveTrackingType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            FriendStatusFragment friendStatusFragment = new FriendStatusFragment();
            Bundle bundle = new Bundle();
            bundle.putString(FriendStatusListActivity.KEY_TYPE, type.name());
            friendStatusFragment.setArguments(bundle);
            return friendStatusFragment;
        }

        private Companion() {
        }
    }

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

    private final void clickVideo(ProfileDetailUIModel data, final int position) {
        if (getContext() != null && FastClickUtils.INSTANCE.isFastClick()) {
            PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (permissionUtils.checkPermission(requireContext)) {
                VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                VideoCallMessage.newStartVideo$default(videoCallMessage, requireContext2, data.getUid(), new Function2() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.f
                    public final Object invoke(Object obj, Object obj2) {
                        Unit clickVideo$lambda$18;
                        clickVideo$lambda$18 = FriendStatusFragment.clickVideo$lambda$18(FriendStatusFragment.this, position, (String) obj, ((Boolean) obj2).booleanValue());
                        return clickVideo$lambda$18;
                    }
                }, null, 8, null);
                return;
            }
            PermissionRequester permissionRequester = PermissionRequester.INSTANCE;
            Context requireContext3 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
            nd.c subscribe = permissionRequester.get(requireContext3, permissionUtils.getNeededPermissions()).observeOn(RxUtilsKt.getMainThread()).subscribe(new FriendStatusFragment$clickVideo$2(this, data, position));
            Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
            RxUtilsKt.addTo(subscribe, getCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickVideo$lambda$18(FriendStatusFragment friendStatusFragment, int i, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        friendStatusFragment.likedImageViewPressed(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final nd.a compositeDisposable_delegate$lambda$2() {
        return new nd.a();
    }

    private final nd.a getCompositeDisposable() {
        return (nd.a) this.compositeDisposable.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CellFriendStatusAdapter getMAdapter() {
        return (CellFriendStatusAdapter) this.mAdapter.getValue();
    }

    private final void initData() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding != null && (smartRefreshLayout = fragmentInteractiveTrackingBinding.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
        getViewModel().getFriendList().observe(this, new FriendStatusFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.l
            public final Object invoke(Object obj) {
                Unit initData$lambda$12;
                initData$lambda$12 = FriendStatusFragment.initData$lambda$12(FriendStatusFragment.this, (List) obj);
                return initData$lambda$12;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$12(FriendStatusFragment friendStatusFragment, List list) {
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SuperStatusView superStatusView3;
        if (friendStatusFragment.getViewModel().getListData().isOnePage()) {
            CellFriendStatusAdapter mAdapter = friendStatusFragment.getMAdapter();
            if (list != null && !list.isEmpty()) {
                FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
                if (fragmentInteractiveTrackingBinding != null && (superStatusView3 = fragmentInteractiveTrackingBinding.statusView) != null) {
                    superStatusView3.showContent();
                }
            } else {
                FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding2 = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
                if (fragmentInteractiveTrackingBinding2 != null && (superStatusView2 = fragmentInteractiveTrackingBinding2.statusView) != null) {
                    superStatusView2.showEmpty();
                }
                list = null;
            }
            mAdapter.setList(list);
        } else {
            CellFriendStatusAdapter mAdapter2 = friendStatusFragment.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter2.addData(list);
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding3 = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
            if (fragmentInteractiveTrackingBinding3 != null && (superStatusView = fragmentInteractiveTrackingBinding3.statusView) != null) {
                superStatusView.showContent();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        String str;
        LinearLayout linearLayout;
        View view;
        TextView textView;
        SmartRefreshLayout smartRefreshLayout;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout2;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        LinearLayout linearLayout2;
        View view2;
        TextView textView3;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Bundle arguments = getArguments();
        SuperStatusView superStatusView2 = null;
        if (arguments != null) {
            str = arguments.getString(FriendStatusListActivity.KEY_TYPE);
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            getViewModel().setMCurStatusType(InteractiveTrackingType.valueOf(str));
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding != null && (recyclerView3 = fragmentInteractiveTrackingBinding.commonIdRecyclerView) != null) {
            recyclerView3.setLayoutManager(linearLayoutManager);
        }
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding2 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding2 != null && (recyclerView2 = fragmentInteractiveTrackingBinding2.commonIdRecyclerView) != null) {
            recyclerView2.setHasFixedSize(true);
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && !user.isVip() && getViewModel().getMCurStatusType() == InteractiveTrackingType.Visitor) {
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding3 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding3 != null && (textView3 = fragmentInteractiveTrackingBinding3.unlock) != null) {
                textView3.setVisibility(0);
            }
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding4 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding4 != null && (view2 = fragmentInteractiveTrackingBinding4.unlockLine) != null) {
                view2.setVisibility(0);
            }
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding5 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding5 != null && (linearLayout2 = fragmentInteractiveTrackingBinding5.unlockLayout) != null) {
                linearLayout2.setVisibility(0);
            }
        } else {
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding6 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding6 != null && (textView = fragmentInteractiveTrackingBinding6.unlock) != null) {
                textView.setVisibility(8);
            }
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding7 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding7 != null && (view = fragmentInteractiveTrackingBinding7.unlockLine) != null) {
                view.setVisibility(8);
            }
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding8 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding8 != null && (linearLayout = fragmentInteractiveTrackingBinding8.unlockLayout) != null) {
                linearLayout.setVisibility(8);
            }
        }
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding9 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding9 != null && (recyclerView = fragmentInteractiveTrackingBinding9.commonIdRecyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            footLoading.setRootBackgroundColor(2131101214);
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding10 = (FragmentInteractiveTrackingBinding) getBinding();
            if (fragmentInteractiveTrackingBinding10 != null && (smartRefreshLayout4 = fragmentInteractiveTrackingBinding10.commonIdSwipeRefreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding11 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding11 != null && (smartRefreshLayout3 = fragmentInteractiveTrackingBinding11.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.m
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    FriendStatusFragment.initView$lambda$6(FriendStatusFragment.this, fVar);
                }
            });
        }
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding12 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding12 != null && (superStatusView = fragmentInteractiveTrackingBinding12.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.FriendStatusFragment$initView$4
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    FriendStatusFragment.this.loadListData();
                }
            });
        }
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding13 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding13 != null && (smartRefreshLayout2 = fragmentInteractiveTrackingBinding13.commonIdSwipeRefreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.n
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    FriendStatusFragment.initView$lambda$7(FriendStatusFragment.this, fVar);
                }
            });
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.o
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view3, int i) {
                FriendStatusFragment.initView$lambda$8(FriendStatusFragment.this, baseQuickAdapter, view3, i);
            }
        });
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.b
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view3, int i) {
                FriendStatusFragment.initView$lambda$9(FriendStatusFragment.this, baseQuickAdapter, view3, i);
            }
        });
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding14 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding14 != null && (textView2 = fragmentInteractiveTrackingBinding14.unlock) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FriendStatusFragment.initView$lambda$11(FriendStatusFragment.this, view3);
                }
            });
        }
        getViewModel().reportEvent();
        BaseListData listData = getViewModel().getListData();
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding15 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding15 != null) {
            smartRefreshLayout = fragmentInteractiveTrackingBinding15.commonIdSwipeRefreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding16 = (FragmentInteractiveTrackingBinding) getBinding();
        if (fragmentInteractiveTrackingBinding16 != null) {
            superStatusView2 = fragmentInteractiveTrackingBinding16.statusView;
        }
        listData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v4, types: [android.app.Dialog, com.qiahao.nextvideo.ui.vip.VipViewDialog] */
    public static final void initView$lambda$11(final FriendStatusFragment friendStatusFragment, View view) {
        if (HiloUtils.INSTANCE.notFastClick() && friendStatusFragment.getContext() != null) {
            Context requireContext = friendStatusFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            ?? vipViewDialog = new VipViewDialog(9, requireContext);
            vipViewDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.h
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    FriendStatusFragment.initView$lambda$11$lambda$10(FriendStatusFragment.this, dialogInterface);
                }
            });
            vipViewDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11$lambda$10(FriendStatusFragment friendStatusFragment, DialogInterface dialogInterface) {
        View view;
        TextView textView;
        View view2;
        TextView textView2;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && !user.isVip() && friendStatusFragment.getViewModel().getMCurStatusType() == InteractiveTrackingType.Visitor) {
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
            if (fragmentInteractiveTrackingBinding != null && (textView2 = fragmentInteractiveTrackingBinding.unlock) != null) {
                textView2.setVisibility(0);
            }
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding2 = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
            if (fragmentInteractiveTrackingBinding2 != null && (view2 = fragmentInteractiveTrackingBinding2.unlockLine) != null) {
                view2.setVisibility(0);
            }
        } else {
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding3 = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
            if (fragmentInteractiveTrackingBinding3 != null && (textView = fragmentInteractiveTrackingBinding3.unlock) != null) {
                textView.setVisibility(8);
            }
            FragmentInteractiveTrackingBinding fragmentInteractiveTrackingBinding4 = (FragmentInteractiveTrackingBinding) friendStatusFragment.getBinding();
            if (fragmentInteractiveTrackingBinding4 != null && (view = fragmentInteractiveTrackingBinding4.unlockLine) != null) {
                view.setVisibility(8);
            }
        }
        friendStatusFragment.loadListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(FriendStatusFragment friendStatusFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        friendStatusFragment.loadListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(FriendStatusFragment friendStatusFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        friendStatusFragment.getViewModel().m٦٥getListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(FriendStatusFragment friendStatusFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        CellUIModel cellUIModel = (CellUIModel) friendStatusFragment.getMAdapter().getItemOrNull(i);
        if (cellUIModel != null) {
            friendStatusFragment.onClickItem(cellUIModel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(FriendStatusFragment friendStatusFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        CellUIModel cellUIModel = (CellUIModel) friendStatusFragment.getMAdapter().getItemOrNull(i);
        if (cellUIModel != null) {
            friendStatusFragment.onChildClickItem(cellUIModel, view, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void likedImageViewPressed(final int position) {
        final CellUIModel cellUIModel;
        final ProfileDetailUIModel nextUIModel;
        if (getContext() != null && (cellUIModel = (CellUIModel) getMAdapter().getItemOrNull(position)) != null && (nextUIModel = cellUIModel.getNextUIModel()) != null) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.like$default(UserService.INSTANCE.getShared(), nextUIModel.getUid(), nextUIModel.isLike(), false, 4, null), new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.d
                public final Object invoke(Object obj) {
                    Unit likedImageViewPressed$lambda$23$lambda$22$lambda$19;
                    likedImageViewPressed$lambda$23$lambda$22$lambda$19 = FriendStatusFragment.likedImageViewPressed$lambda$23$lambda$22$lambda$19(ProfileDetailUIModel.this, cellUIModel, this, position, (ApiResponse) obj);
                    return likedImageViewPressed$lambda$23$lambda$22$lambda$19;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.e
                public final Object invoke(Object obj) {
                    Unit likedImageViewPressed$lambda$23$lambda$22$lambda$21;
                    likedImageViewPressed$lambda$23$lambda$22$lambda$21 = FriendStatusFragment.likedImageViewPressed$lambda$23$lambda$22$lambda$21(FriendStatusFragment.this, (Throwable) obj);
                    return likedImageViewPressed$lambda$23$lambda$22$lambda$21;
                }
            }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit likedImageViewPressed$lambda$23$lambda$22$lambda$19(ProfileDetailUIModel profileDetailUIModel, CellUIModel cellUIModel, FriendStatusFragment friendStatusFragment, int i, ApiResponse apiResponse) {
        boolean z;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LikeResult likeResult = (LikeResult) apiResponse.getData();
        boolean z2 = false;
        if (likeResult != null) {
            z = likeResult.getStatus();
        } else {
            z = false;
        }
        profileDetailUIModel.setLike(z);
        ProfileDetailUIModel nextUIModel = cellUIModel.getNextUIModel();
        if (nextUIModel != null) {
            LikeResult likeResult2 = (LikeResult) apiResponse.getData();
            if (likeResult2 != null) {
                z2 = likeResult2.getStatus();
            }
            nextUIModel.setLike(z2);
        }
        friendStatusFragment.getMAdapter().notifyItemChanged(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit likedImageViewPressed$lambda$23$lambda$22$lambda$21(FriendStatusFragment friendStatusFragment, Throwable th) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    Context requireContext = friendStatusFragment.requireContext();
                    String localizedMessage = hiloException.getLocalizedMessage();
                    if (localizedMessage == null) {
                        String string = friendStatusFragment.requireContext().getString(2131952667);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        str2 = string;
                    } else {
                        str2 = localizedMessage;
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, requireContext, str2, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    HiloToasty.Companion companion2 = HiloToasty.Companion;
                    Context requireContext2 = friendStatusFragment.requireContext();
                    String string2 = friendStatusFragment.requireContext().getString(2131953231);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    Toast normal$default2 = HiloToasty.Companion.normal$default(companion2, requireContext2, string2, false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                Context context = friendStatusFragment.getContext();
                if (context != null) {
                    new VipViewDialog(5, context).show();
                }
            }
        } else {
            HiloToasty.Companion companion3 = HiloToasty.Companion;
            Context requireContext3 = friendStatusFragment.requireContext();
            String localizedMessage2 = th.getLocalizedMessage();
            if (localizedMessage2 == null) {
                str = friendStatusFragment.requireContext().getString(2131952667);
                Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            } else {
                str = localizedMessage2;
            }
            Toast normal$default3 = HiloToasty.Companion.normal$default(companion3, requireContext3, str, false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CellFriendStatusAdapter mAdapter_delegate$lambda$1() {
        return new CellFriendStatusAdapter();
    }

    private final void onChildClickItem(CellUIModel item, View view, int position) {
        ProfileDetailUIModel nextUIModel;
        int id2 = view.getId();
        if (id2 != 2131363490) {
            if (id2 == 2131365597 && (nextUIModel = item.getNextUIModel()) != null) {
                clickVideo(nextUIModel, position);
                return;
            }
            return;
        }
        likedImageViewPressed(position);
    }

    private final void onClickItem(CellUIModel item, final int position) {
        UserService.ReadNoCountType readNoCountType;
        ProfileDetailUIModel nextUIModel = item.getNextUIModel();
        if (nextUIModel != null) {
            UserService.ReadNoCountType readNoCountType2 = UserService.ReadNoCountType.ILIKE;
            int i = WhenMappings.$EnumSwitchMapping$0[item.getInteractiveTrackingType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            AppService service = AppController.INSTANCE.getService();
                            if (service != null) {
                                service.openPersonPage(item.getItemId());
                                return;
                            }
                            return;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user == null || user.isVip()) {
                        readNoCountType = UserService.ReadNoCountType.VISITOR;
                        this.selectedCellUIModel = item;
                    } else {
                        return;
                    }
                } else {
                    readNoCountType = UserService.ReadNoCountType.LIKEME;
                    this.selectedCellUIModel = item;
                }
            } else {
                readNoCountType = UserService.ReadNoCountType.ILIKE;
                this.selectedCellUIModel = item;
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().readHas(item.getItemId(), readNoCountType), new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.a
                public final Object invoke(Object obj) {
                    Unit onClickItem$lambda$16$lambda$14;
                    onClickItem$lambda$16$lambda$14 = FriendStatusFragment.onClickItem$lambda$16$lambda$14(FriendStatusFragment.this, position, (ApiResponse) obj);
                    return onClickItem$lambda$16$lambda$14;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.g
                public final Object invoke(Object obj) {
                    Unit onClickItem$lambda$16$lambda$15;
                    onClickItem$lambda$16$lambda$15 = FriendStatusFragment.onClickItem$lambda$16$lambda$15((Throwable) obj);
                    return onClickItem$lambda$16$lambda$15;
                }
            }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, nextUIModel.getUid(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickItem$lambda$16$lambda$14(FriendStatusFragment friendStatusFragment, int i, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        CellUIModel cellUIModel = (CellUIModel) friendStatusFragment.getMAdapter().getItemOrNull(i);
        if (cellUIModel != null) {
            cellUIModel.setHasRead(true);
        }
        friendStatusFragment.getMAdapter().notifyItemChanged(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickItem$lambda$16$lambda$15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void setupObserver() {
        nd.c subscribe = FeedbackService.INSTANCE.getShared().getReportEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.FriendStatusFragment$setupObserver$1
            public final void accept(String str) {
                CellFriendStatusAdapter mAdapter;
                CellFriendStatusAdapter mAdapter2;
                try {
                    mAdapter = FriendStatusFragment.this.getMAdapter();
                    Iterator it = mAdapter.getData().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        CellUIModel cellUIModel = (CellUIModel) it.next();
                        if (Intrinsics.areEqual(cellUIModel.getItemId(), str)) {
                            mAdapter2 = FriendStatusFragment.this.getMAdapter();
                            mAdapter2.remove(cellUIModel);
                            break;
                        }
                    }
                    MessageProvide.INSTANCE.displayData(MessageProvide.MESSAGE_DEFAULT);
                } catch (Exception e) {
                    DebugToolsKt.printfE("FriendStatusFragment", "reportEventRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getCompositeDisposable());
        UserStore.Companion companion = UserStore.INSTANCE;
        nd.c subscribe2 = companion.getShared().getForeverHeartRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.FriendStatusFragment$setupObserver$2
            public final void accept(Pair<String, Integer> pair) {
                CellFriendStatusAdapter mAdapter;
                CellFriendStatusAdapter mAdapter2;
                CellFriendStatusAdapter mAdapter3;
                try {
                    mAdapter = FriendStatusFragment.this.getMAdapter();
                    int size = mAdapter.getData().size();
                    for (int i = 0; i < size; i++) {
                        mAdapter2 = FriendStatusFragment.this.getMAdapter();
                        CellUIModel cellUIModel = (CellUIModel) mAdapter2.getData().get(i);
                        if (Intrinsics.areEqual(cellUIModel.getItemId(), pair.getFirst())) {
                            cellUIModel.setHeartPer(((Number) pair.getSecond()).intValue());
                            mAdapter3 = FriendStatusFragment.this.getMAdapter();
                            mAdapter3.notifyItemChanged(i);
                            return;
                        }
                    }
                } catch (Exception e) {
                    DebugToolsKt.printfE("FriendStatusFragment", "foreverHeartRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe2, "subscribe(...)");
        RxUtilsKt.addTo(subscribe2, getCompositeDisposable());
        nd.c subscribe3 = companion.getShared().getCreatedSessionEventRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.commonlist.interactivetracking.fragment.FriendStatusFragment$setupObserver$3
            public final void accept(UserSummaryInfo userSummaryInfo) {
                CellFriendStatusAdapter mAdapter;
                CellFriendStatusAdapter mAdapter2;
                CellFriendStatusAdapter mAdapter3;
                try {
                    mAdapter = FriendStatusFragment.this.getMAdapter();
                    int size = mAdapter.getData().size();
                    for (int i = 0; i < size; i++) {
                        mAdapter2 = FriendStatusFragment.this.getMAdapter();
                        CellUIModel cellUIModel = (CellUIModel) mAdapter2.getData().get(i);
                        if (Intrinsics.areEqual(cellUIModel.getItemId(), userSummaryInfo.getExternalId())) {
                            ProfileDetailUIModel nextUIModel = cellUIModel.getNextUIModel();
                            if (nextUIModel != null) {
                                nextUIModel.setFreeMessage(true);
                            }
                            mAdapter3 = FriendStatusFragment.this.getMAdapter();
                            mAdapter3.notifyItemChanged(i);
                            return;
                        }
                    }
                } catch (Exception e) {
                    DebugToolsKt.printfE("FriendStatusFragment", "createdSessionEventRelay 内部try()catch{}" + e.getLocalizedMessage());
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe3, "subscribe(...)");
        RxUtilsKt.addTo(subscribe3, getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FriendStatusViewModel viewModel_delegate$lambda$0(FriendStatusFragment friendStatusFragment) {
        return new ViewModelProvider(friendStatusFragment).get(FriendStatusViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_interactive_tracking;
    }

    @NotNull
    public final FriendStatusViewModel getViewModel() {
        return (FriendStatusViewModel) this.viewModel.getValue();
    }

    public final void loadListData() {
        getViewModel().getListData().resetPage();
        getViewModel().m٦٥getListData();
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getCompositeDisposable().d();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
        setupObserver();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onLikeChange(@NotNull EventBusKey event) {
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        try {
            if (!Intrinsics.areEqual(event.getType(), "like_status") || !(event.getData() instanceof LikeResult)) {
                return;
            }
            int size = getMAdapter().getData().size();
            for (int i = 0; i < size; i++) {
                CellUIModel cellUIModel = (CellUIModel) getMAdapter().getData().get(i);
                String itemId = cellUIModel.getItemId();
                CellUIModel cellUIModel2 = this.selectedCellUIModel;
                if (cellUIModel2 != null) {
                    str = cellUIModel2.getItemId();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(itemId, str)) {
                    Object data = event.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.common.LikeResult");
                    LikeResult likeResult = (LikeResult) data;
                    ProfileDetailUIModel nextUIModel = cellUIModel.getNextUIModel();
                    if (nextUIModel != null) {
                        nextUIModel.setLike(likeResult.getStatus());
                    }
                    getMAdapter().notifyItemChanged(i);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
