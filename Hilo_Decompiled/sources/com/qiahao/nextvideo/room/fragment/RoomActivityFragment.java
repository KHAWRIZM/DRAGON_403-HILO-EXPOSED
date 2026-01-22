package com.qiahao.nextvideo.room.fragment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.databinding.FragmentRoomActivityBinding;
import com.qiahao.nextvideo.room.adapter.RoomInfoDialogAdapter;
import com.qiahao.nextvideo.ui.home.discover.ActivitiesDetailActivity;
import com.qiahao.nextvideo.ui.home.discover.viewModel.ActivitiesViewModel;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/room/fragment/RoomActivityFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRoomActivityBinding;", "<init>", "()V", "mGroupDetail", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "getMGroupDetail", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "setMGroupDetail", "(Lcom/qiahao/nextvideo/data/model/GroupDetailBean;)V", "viewModel", "Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/room/adapter/RoomInfoDialogAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/room/adapter/RoomInfoDialogAdapter;", "adapter$delegate", "getLayoutResId", "", "onInitialize", "", "setData", "onResume", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomActivityFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomActivityFragment.kt\ncom/qiahao/nextvideo/room/fragment/RoomActivityFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,112:1\n1#2:113\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomActivityFragment extends BaseBindingFragment<FragmentRoomActivityBinding> {

    @Nullable
    private GroupDetailBean mGroupDetail;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.h0
        public final Object invoke() {
            ActivitiesViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = RoomActivityFragment.viewModel_delegate$lambda$0(RoomActivityFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.fragment.i0
        public final Object invoke() {
            RoomInfoDialogAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = RoomActivityFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomInfoDialogAdapter adapter_delegate$lambda$1() {
        return new RoomInfoDialogAdapter();
    }

    private final ActivitiesViewModel getViewModel() {
        return (ActivitiesViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$11(RoomActivityFragment roomActivityFragment, List list) {
        if (list != null) {
            if (roomActivityFragment.getViewModel().getGroupListData().isOnePage()) {
                roomActivityFragment.getAdapter().setList(list);
            } else {
                roomActivityFragment.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$6(RoomActivityFragment roomActivityFragment, tc.f fVar) {
        String str;
        Intrinsics.checkNotNullParameter(fVar, "it");
        roomActivityFragment.getViewModel().getGroupListData().resetPage();
        ActivitiesViewModel viewModel = roomActivityFragment.getViewModel();
        GroupDetailBean groupDetailBean = roomActivityFragment.mGroupDetail;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        viewModel.requestGroupActivityList(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$7(RoomActivityFragment roomActivityFragment, tc.f fVar) {
        String str;
        Intrinsics.checkNotNullParameter(fVar, "it");
        ActivitiesViewModel viewModel = roomActivityFragment.getViewModel();
        GroupDetailBean groupDetailBean = roomActivityFragment.mGroupDetail;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        viewModel.requestGroupActivityList(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(RoomActivityFragment roomActivityFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            ActivityDetailData activityDetailData = (ActivityDetailData) roomActivityFragment.getAdapter().getData().get(i);
            Context context = roomActivityFragment.getContext();
            if (context != null) {
                Intent intent = new Intent(context, (Class<?>) ActivitiesDetailActivity.class);
                intent.putExtra(ActivitiesDetailActivity.ACTIVITY_ID, activityDetailData.getId());
                context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivitiesViewModel viewModel_delegate$lambda$0(RoomActivityFragment roomActivityFragment) {
        return new ViewModelProvider(roomActivityFragment).get(ActivitiesViewModel.class);
    }

    @NotNull
    public final RoomInfoDialogAdapter getAdapter() {
        return (RoomInfoDialogAdapter) this.adapter.getValue();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_room_activity;
    }

    @Nullable
    public final GroupDetailBean getMGroupDetail() {
        return this.mGroupDetail;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getViewModel().getGroupListData().destroy();
    }

    public void onInitialize() {
        TextView textView;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout5;
        SmartRefreshLayout smartRefreshLayout6;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentRoomActivityBinding fragmentRoomActivityBinding = (FragmentRoomActivityBinding) getBinding();
        SuperStatusView superStatusView = null;
        if (fragmentRoomActivityBinding != null && (smartRefreshLayout6 = fragmentRoomActivityBinding.refreshLayout) != null) {
            textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout6, Status.Empty.INSTANCE, 2131362075);
        } else {
            textView = null;
        }
        Context context = getContext();
        if (context != null && textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
        }
        FragmentRoomActivityBinding fragmentRoomActivityBinding2 = (FragmentRoomActivityBinding) getBinding();
        if (fragmentRoomActivityBinding2 != null && (smartRefreshLayout5 = fragmentRoomActivityBinding2.refreshLayout) != null) {
            textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout5, Status.Error.INSTANCE, 2131362075);
        } else {
            textView2 = null;
        }
        Context context2 = getContext();
        if (context2 != null && textView2 != null) {
            textView2.setTextColor(androidx.core.content.a.getColor(context2, 2131101214));
        }
        FragmentRoomActivityBinding fragmentRoomActivityBinding3 = (FragmentRoomActivityBinding) getBinding();
        if (fragmentRoomActivityBinding3 != null && (recyclerView = fragmentRoomActivityBinding3.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        BaseListData groupListData = getViewModel().getGroupListData();
        FragmentRoomActivityBinding fragmentRoomActivityBinding4 = (FragmentRoomActivityBinding) getBinding();
        if (fragmentRoomActivityBinding4 != null) {
            smartRefreshLayout = fragmentRoomActivityBinding4.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentRoomActivityBinding fragmentRoomActivityBinding5 = (FragmentRoomActivityBinding) getBinding();
        if (fragmentRoomActivityBinding5 != null) {
            superStatusView = fragmentRoomActivityBinding5.statusView;
        }
        groupListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView);
        Context context3 = getContext();
        if (context3 != null) {
            FootLoading footLoading = new FootLoading(context3);
            FragmentRoomActivityBinding fragmentRoomActivityBinding6 = (FragmentRoomActivityBinding) getBinding();
            if (fragmentRoomActivityBinding6 != null && (smartRefreshLayout4 = fragmentRoomActivityBinding6.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        FragmentRoomActivityBinding fragmentRoomActivityBinding7 = (FragmentRoomActivityBinding) getBinding();
        if (fragmentRoomActivityBinding7 != null && (smartRefreshLayout3 = fragmentRoomActivityBinding7.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.fragment.d0
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    RoomActivityFragment.onInitialize$lambda$6(RoomActivityFragment.this, fVar);
                }
            });
        }
        FragmentRoomActivityBinding fragmentRoomActivityBinding8 = (FragmentRoomActivityBinding) getBinding();
        if (fragmentRoomActivityBinding8 != null && (smartRefreshLayout2 = fragmentRoomActivityBinding8.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.room.fragment.e0
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    RoomActivityFragment.onInitialize$lambda$7(RoomActivityFragment.this, fVar);
                }
            });
        }
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.fragment.f0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RoomActivityFragment.onInitialize$lambda$9(RoomActivityFragment.this, baseQuickAdapter, view, i);
            }
        });
        getViewModel().getGroupList().observe(this, new RoomActivityFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.fragment.g0
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$11;
                onInitialize$lambda$11 = RoomActivityFragment.onInitialize$lambda$11(RoomActivityFragment.this, (List) obj);
                return onInitialize$lambda$11;
            }
        }));
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        GroupDetailBean groupDetailBean = this.mGroupDetail;
        if (groupDetailBean != null) {
            getViewModel().getGroupListData().resetPage();
            ActivitiesViewModel viewModel = getViewModel();
            String groupId = groupDetailBean.getGroupId();
            if (groupId == null) {
                groupId = "";
            }
            viewModel.requestGroupActivityList(groupId);
        }
    }

    public final void setData(@Nullable GroupDetailBean mGroupDetail) {
        this.mGroupDetail = mGroupDetail;
    }

    public final void setMGroupDetail(@Nullable GroupDetailBean groupDetailBean) {
        this.mGroupDetail = groupDetailBean;
    }
}
