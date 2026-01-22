package com.qiahao.nextvideo.ui.home.medal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MedalAllTypeBean;
import com.qiahao.nextvideo.databinding.FragmentBaseListBinding;
import com.qiahao.nextvideo.ui.videocall.PreviewDialog;
import com.qiahao.nextvideo.utilities.decorate.GridSpacingItemMulityCountryDecoration;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/medal/MedalFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentBaseListBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/home/medal/MedalViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/medal/MedalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/medal/AllTypeMedalAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/medal/AllTypeMedalAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "getStatusView", "Lcom/oudi/core/status/IStatusView;", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMedalFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MedalFragment.kt\ncom/qiahao/nextvideo/ui/home/medal/MedalFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,113:1\n1#2:114\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MedalFragment extends BaseBindingFragment<FragmentBaseListBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.h
        public final Object invoke() {
            MedalViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = MedalFragment.viewModel_delegate$lambda$0(MedalFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.i
        public final Object invoke() {
            AllTypeMedalAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = MedalFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final IStatusView getStatusView() {
        FragmentBaseListBinding fragmentBaseListBinding = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding != null) {
            return fragmentBaseListBinding.statusView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MedalViewModel getViewModel() {
        return (MedalViewModel) this.viewModel.getValue();
    }

    private final void initView() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        TextView textView;
        SmartRefreshLayout smartRefreshLayout5;
        TextView textView2;
        FragmentBaseListBinding fragmentBaseListBinding = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding != null && (smartRefreshLayout5 = fragmentBaseListBinding.refreshLayout) != null && (textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout5, Status.Empty.INSTANCE, 2131362075)) != null) {
            textView2.setTextColor(ResourcesKtxKt.getColorById(this, 2131101214));
        }
        FragmentBaseListBinding fragmentBaseListBinding2 = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding2 != null && (smartRefreshLayout4 = fragmentBaseListBinding2.refreshLayout) != null && (textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout4, Status.Error.INSTANCE, 2131362075)) != null) {
            textView.setTextColor(ResourcesKtxKt.getColorById(this, 2131101214));
        }
        FragmentBaseListBinding fragmentBaseListBinding3 = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding3 != null && (smartRefreshLayout3 = fragmentBaseListBinding3.refreshLayout) != null) {
            smartRefreshLayout3.setEnableLoadMore(false);
        }
        getMAdapter().setFragmentType(getViewModel().getFragmentType());
        FragmentBaseListBinding fragmentBaseListBinding4 = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding4 != null && (recyclerView = fragmentBaseListBinding4.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
            recyclerView.addItemDecoration(new GridSpacingItemMulityCountryDecoration(2, Dimens.INSTANCE.dpToPx(33), true));
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.c
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MedalFragment.initView$lambda$7(MedalFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentBaseListBinding fragmentBaseListBinding5 = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding5 != null && (smartRefreshLayout2 = fragmentBaseListBinding5.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.medal.d
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    MedalFragment.initView$lambda$8(MedalFragment.this, fVar);
                }
            });
        }
        FragmentBaseListBinding fragmentBaseListBinding6 = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding6 != null && (superStatusView = fragmentBaseListBinding6.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.home.medal.MedalFragment$initView$4
                public void onRetry(IStatusView statusView, Status status) {
                    MedalViewModel viewModel;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = MedalFragment.this.getViewModel();
                    viewModel.m٧٧getModelList();
                }
            });
        }
        getViewModel().getModelList().observe(this, new MedalFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.e
            public final Object invoke(Object obj) {
                Unit initView$lambda$9;
                initView$lambda$9 = MedalFragment.initView$lambda$9(MedalFragment.this, (List) obj);
                return initView$lambda$9;
            }
        }));
        getViewModel().getError().observe(this, new MedalFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.medal.f
            public final Object invoke(Object obj) {
                Unit initView$lambda$10;
                initView$lambda$10 = MedalFragment.initView$lambda$10(MedalFragment.this, (Throwable) obj);
                return initView$lambda$10;
            }
        }));
        FragmentBaseListBinding fragmentBaseListBinding7 = (FragmentBaseListBinding) getBinding();
        if (fragmentBaseListBinding7 != null && (smartRefreshLayout = fragmentBaseListBinding7.refreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$10(MedalFragment medalFragment, Throwable th) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentBaseListBinding fragmentBaseListBinding = (FragmentBaseListBinding) medalFragment.getBinding();
        if (fragmentBaseListBinding != null && (smartRefreshLayout = fragmentBaseListBinding.refreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        StatusKtxKtKt.showEmpty$default(medalFragment.getStatusView(), 0L, 1, (Object) null);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = medalFragment.getContext();
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, message, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(final MedalFragment medalFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MedalAllTypeBean medalAllTypeBean = (MedalAllTypeBean) medalFragment.getMAdapter().getItem(i);
        if (Intrinsics.areEqual(medalFragment.getViewModel().getFragmentType(), MedalActivity.TYPE_PERSONAL)) {
            Context context = medalFragment.getContext();
            if (context != null) {
                MedalLevelDialog medalLevelDialog = new MedalLevelDialog(context, medalAllTypeBean.getType());
                medalLevelDialog.setListener(new Function0() { // from class: com.qiahao.nextvideo.ui.home.medal.g
                    public final Object invoke() {
                        Unit initView$lambda$7$lambda$5$lambda$4$lambda$3;
                        initView$lambda$7$lambda$5$lambda$4$lambda$3 = MedalFragment.initView$lambda$7$lambda$5$lambda$4$lambda$3(MedalFragment.this);
                        return initView$lambda$7$lambda$5$lambda$4$lambda$3;
                    }
                });
                medalLevelDialog.show();
                return;
            }
            return;
        }
        FragmentActivity activity = medalFragment.getActivity();
        if (activity != null) {
            new PreviewDialog(activity, medalAllTypeBean.getPicUrl()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$7$lambda$5$lambda$4$lambda$3(MedalFragment medalFragment) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentBaseListBinding fragmentBaseListBinding = (FragmentBaseListBinding) medalFragment.getBinding();
        if (fragmentBaseListBinding != null && (smartRefreshLayout = fragmentBaseListBinding.refreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(MedalFragment medalFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        medalFragment.getViewModel().m٧٧getModelList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9(MedalFragment medalFragment, List list) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentBaseListBinding fragmentBaseListBinding = (FragmentBaseListBinding) medalFragment.getBinding();
        if (fragmentBaseListBinding != null && (smartRefreshLayout2 = fragmentBaseListBinding.refreshLayout) != null) {
            smartRefreshLayout2.finishRefresh();
        }
        FragmentBaseListBinding fragmentBaseListBinding2 = (FragmentBaseListBinding) medalFragment.getBinding();
        if (fragmentBaseListBinding2 != null && (smartRefreshLayout = fragmentBaseListBinding2.refreshLayout) != null) {
            smartRefreshLayout.setNoMoreData(true);
        }
        if (list != null && !list.isEmpty()) {
            StatusKtxKtKt.showContent$default(medalFragment.getStatusView(), 0L, 1, (Object) null);
            medalFragment.getMAdapter().setList(list);
        } else {
            StatusKtxKtKt.showEmpty$default(medalFragment.getStatusView(), 0L, 1, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AllTypeMedalAdapter mAdapter_delegate$lambda$1() {
        return new AllTypeMedalAdapter(R.layout.item_all_medal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalViewModel viewModel_delegate$lambda$0(MedalFragment medalFragment) {
        return new ViewModelProvider(medalFragment).get(MedalViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_base_list;
    }

    @NotNull
    public final AllTypeMedalAdapter getMAdapter() {
        return (AllTypeMedalAdapter) this.mAdapter.getValue();
    }

    public void onInitialize() {
        String str;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        MedalViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("fragment_type")) == null) {
            str = MedalActivity.TYPE_PERSONAL;
        }
        viewModel.setFragmentType(str);
        initView();
    }
}
