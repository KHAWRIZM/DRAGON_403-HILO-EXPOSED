package com.qiahao.nextvideo.room.record;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.room.RoomRecordData;
import com.qiahao.nextvideo.databinding.FragmentRoomRecordBinding;
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

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\fH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/room/record/RoomRecordFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRoomRecordBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/room/record/RoomRecordViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/record/RoomRecordViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mType", "", "getMType", "()I", "setMType", "(I)V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "mAdapter", "Lcom/qiahao/nextvideo/room/record/RoomRecordAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/record/RoomRecordAdapter;", "mAdapter$delegate", "getLayoutResId", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomRecordFragment.kt\ncom/qiahao/nextvideo/room/record/RoomRecordFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,77:1\n1#2:78\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRecordFragment extends BaseBindingFragment<FragmentRoomRecordBinding> {

    @NotNull
    public static final String GROUP_ID = "group_id";
    public static final int KICK_MIC = 1;
    public static final int KICK_ROOM = 2;

    @NotNull
    public static final String RECORD_TYPE = "transfer_type";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.record.g
        public final Object invoke() {
            RoomRecordViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = RoomRecordFragment.viewModel_delegate$lambda$0(RoomRecordFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });
    private int mType = 1;

    @NotNull
    private String mGroupId = "";

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.record.h
        public final Object invoke() {
            RoomRecordAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = RoomRecordFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final RoomRecordAdapter getMAdapter() {
        return (RoomRecordAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RoomRecordViewModel getViewModel() {
        return (RoomRecordViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomRecordAdapter mAdapter_delegate$lambda$1() {
        return new RoomRecordAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(RoomRecordFragment roomRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        roomRecordFragment.getViewModel().getRoomRecordData().resetPage();
        roomRecordFragment.getViewModel().roomRecord(roomRecordFragment.mGroupId, roomRecordFragment.mType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(RoomRecordFragment roomRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        roomRecordFragment.getViewModel().roomRecord(roomRecordFragment.mGroupId, roomRecordFragment.mType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$6(RoomRecordFragment roomRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            User beOperUser = ((RoomRecordData) roomRecordFragment.getMAdapter().getData().get(i)).getBeOperUser();
            if (beOperUser == null || (str = beOperUser.getExternalId()) == null) {
                str = "";
            }
            service.openPersonPage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$8(RoomRecordFragment roomRecordFragment, List list) {
        if (roomRecordFragment.getViewModel().getRoomRecordData().isOnePage()) {
            roomRecordFragment.getMAdapter().setList(list);
        } else if (list != null) {
            roomRecordFragment.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomRecordViewModel viewModel_delegate$lambda$0(RoomRecordFragment roomRecordFragment) {
        return new ViewModelProvider(roomRecordFragment).get(RoomRecordViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_room_record;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMType() {
        return this.mType;
    }

    public void onInitialize() {
        int i;
        String str;
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("transfer_type");
        } else {
            i = 1;
        }
        this.mType = i;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("group_id")) == null) {
            str = "";
        }
        this.mGroupId = str;
        FragmentRoomRecordBinding fragmentRoomRecordBinding = (FragmentRoomRecordBinding) getBinding();
        if (fragmentRoomRecordBinding != null && (recyclerView = fragmentRoomRecordBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentRoomRecordBinding fragmentRoomRecordBinding2 = (FragmentRoomRecordBinding) getBinding();
            if (fragmentRoomRecordBinding2 != null && (smartRefreshLayout4 = fragmentRoomRecordBinding2.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        BaseListData roomRecordData = getViewModel().getRoomRecordData();
        FragmentRoomRecordBinding fragmentRoomRecordBinding3 = (FragmentRoomRecordBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentRoomRecordBinding3 != null) {
            smartRefreshLayout = fragmentRoomRecordBinding3.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentRoomRecordBinding fragmentRoomRecordBinding4 = (FragmentRoomRecordBinding) getBinding();
        if (fragmentRoomRecordBinding4 != null) {
            superStatusView2 = fragmentRoomRecordBinding4.statusView;
        }
        roomRecordData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentRoomRecordBinding fragmentRoomRecordBinding5 = (FragmentRoomRecordBinding) getBinding();
        if (fragmentRoomRecordBinding5 != null && (smartRefreshLayout3 = fragmentRoomRecordBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.record.c
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    RoomRecordFragment.onInitialize$lambda$4(RoomRecordFragment.this, fVar);
                }
            });
        }
        FragmentRoomRecordBinding fragmentRoomRecordBinding6 = (FragmentRoomRecordBinding) getBinding();
        if (fragmentRoomRecordBinding6 != null && (smartRefreshLayout2 = fragmentRoomRecordBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.room.record.d
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    RoomRecordFragment.onInitialize$lambda$5(RoomRecordFragment.this, fVar);
                }
            });
        }
        FragmentRoomRecordBinding fragmentRoomRecordBinding7 = (FragmentRoomRecordBinding) getBinding();
        if (fragmentRoomRecordBinding7 != null && (superStatusView = fragmentRoomRecordBinding7.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.record.RoomRecordFragment$onInitialize$5
                public void onRetry(IStatusView statusView, Status status) {
                    RoomRecordViewModel viewModel;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = RoomRecordFragment.this.getViewModel();
                    viewModel.roomRecord(RoomRecordFragment.this.getMGroupId(), RoomRecordFragment.this.getMType());
                }
            });
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.record.e
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                RoomRecordFragment.onInitialize$lambda$6(RoomRecordFragment.this, baseQuickAdapter, view, i2);
            }
        });
        getViewModel().getRoomRecord().observe(this, new RoomRecordFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.record.f
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$8;
                onInitialize$lambda$8 = RoomRecordFragment.onInitialize$lambda$8(RoomRecordFragment.this, (List) obj);
                return onInitialize$lambda$8;
            }
        }));
        getViewModel().roomRecord(this.mGroupId, this.mType);
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
