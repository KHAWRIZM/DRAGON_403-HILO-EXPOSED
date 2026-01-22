package com.qiahao.nextvideo.ui.aristocracy;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.databinding.FragmentVipRecordBinding;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/VipRecordFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentVipRecordBinding;", "<init>", "()V", "mAdapter", "Lcom/qiahao/nextvideo/ui/aristocracy/VipRecordAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/aristocracy/VipRecordAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/aristocracy/VipCardViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/aristocracy/VipCardViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVipRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VipRecordFragment.kt\ncom/qiahao/nextvideo/ui/aristocracy/VipRecordFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,83:1\n1#2:84\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VipRecordFragment extends BaseBindingFragment<FragmentVipRecordBinding> {

    @NotNull
    public static final String FRAGMENT_TYPE = "FRAGMENT_TYPE";

    @NotNull
    public static final String TYPE_VIP = "TYPE_VIP";

    @NotNull
    public static final String TYPE_VIP_CARD = "TYPE_VIP_CARD";

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.z0
        public final Object invoke() {
            VipRecordAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = VipRecordFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.a1
        public final Object invoke() {
            VipCardViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = VipRecordFragment.viewModel_delegate$lambda$1(VipRecordFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    private final VipRecordAdapter getMAdapter() {
        return (VipRecordAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VipCardViewModel getViewModel() {
        return (VipCardViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getVipRecordList().observe(this, new VipRecordFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.b1
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = VipRecordFragment.initData$lambda$2(VipRecordFragment.this, (List) obj);
                return initData$lambda$2;
            }
        }));
        getViewModel().getVipRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(VipRecordFragment vipRecordFragment, List list) {
        if (vipRecordFragment.getViewModel().getVipRecordData().isOnePage()) {
            vipRecordFragment.getMAdapter().setList(list);
        } else {
            VipRecordAdapter mAdapter = vipRecordFragment.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter.addData(list);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        String str;
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        VipCardViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(FRAGMENT_TYPE)) == null) {
            str = TYPE_VIP;
        }
        viewModel.setMFragmentType(str);
        getMAdapter().setMFragmentType(getViewModel().getMFragmentType());
        FragmentVipRecordBinding fragmentVipRecordBinding = (FragmentVipRecordBinding) getBinding();
        if (fragmentVipRecordBinding != null && (recyclerView = fragmentVipRecordBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentVipRecordBinding fragmentVipRecordBinding2 = (FragmentVipRecordBinding) getBinding();
            if (fragmentVipRecordBinding2 != null && (smartRefreshLayout4 = fragmentVipRecordBinding2.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        BaseListData vipRecordData = getViewModel().getVipRecordData();
        FragmentVipRecordBinding fragmentVipRecordBinding3 = (FragmentVipRecordBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentVipRecordBinding3 != null) {
            smartRefreshLayout = fragmentVipRecordBinding3.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentVipRecordBinding fragmentVipRecordBinding4 = (FragmentVipRecordBinding) getBinding();
        if (fragmentVipRecordBinding4 != null) {
            superStatusView2 = fragmentVipRecordBinding4.statusView;
        }
        vipRecordData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentVipRecordBinding fragmentVipRecordBinding5 = (FragmentVipRecordBinding) getBinding();
        if (fragmentVipRecordBinding5 != null && (smartRefreshLayout3 = fragmentVipRecordBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.aristocracy.c1
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    VipRecordFragment.initView$lambda$5(VipRecordFragment.this, fVar);
                }
            });
        }
        FragmentVipRecordBinding fragmentVipRecordBinding6 = (FragmentVipRecordBinding) getBinding();
        if (fragmentVipRecordBinding6 != null && (smartRefreshLayout2 = fragmentVipRecordBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.aristocracy.d1
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    VipRecordFragment.initView$lambda$6(VipRecordFragment.this, fVar);
                }
            });
        }
        FragmentVipRecordBinding fragmentVipRecordBinding7 = (FragmentVipRecordBinding) getBinding();
        if (fragmentVipRecordBinding7 != null && (superStatusView = fragmentVipRecordBinding7.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.VipRecordFragment$initView$5
                public void onRetry(IStatusView statusView, Status status) {
                    VipCardViewModel viewModel2;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel2 = VipRecordFragment.this.getViewModel();
                    viewModel2.getVipRecord();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(VipRecordFragment vipRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        vipRecordFragment.getViewModel().getVipRecordData().resetPage();
        vipRecordFragment.getViewModel().getVipRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(VipRecordFragment vipRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        vipRecordFragment.getViewModel().getVipRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VipRecordAdapter mAdapter_delegate$lambda$0() {
        return new VipRecordAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VipCardViewModel viewModel_delegate$lambda$1(VipRecordFragment vipRecordFragment) {
        return new ViewModelProvider(vipRecordFragment).get(VipCardViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_vip_record;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getViewModel().getVipRecordData().destroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }
}
