package com.qiahao.nextvideo.ui.transfer;

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
import com.qiahao.nextvideo.databinding.FragmentTransferRecordBinding;
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

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\fH\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferRecordFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentTransferRecordBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mType", "", "getMType", "()I", "setMType", "(I)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentRecordAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentRecordAdapter;", "mAdapter$delegate", "getLayoutResId", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferRecordFragment.kt\ncom/qiahao/nextvideo/ui/transfer/TransferRecordFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,69:1\n1#2:70\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferRecordFragment extends BaseBindingFragment<FragmentTransferRecordBinding> {
    public static final int TRANSFER_DIAMOND = 0;
    public static final int TRANSFER_GEM = 1;

    @NotNull
    public static final String TRANSFER_TYPE = "transfer_type";
    private int mType;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.x1
        public final Object invoke() {
            TransferViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = TransferRecordFragment.viewModel_delegate$lambda$0(TransferRecordFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.y1
        public final Object invoke() {
            TransferFragmentRecordAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = TransferRecordFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final TransferFragmentRecordAdapter getMAdapter() {
        return (TransferFragmentRecordAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferViewModel getViewModel() {
        return (TransferViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferFragmentRecordAdapter mAdapter_delegate$lambda$1() {
        return new TransferFragmentRecordAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(TransferRecordFragment transferRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        transferRecordFragment.getViewModel().getTransferRecordData().resetPage();
        transferRecordFragment.getViewModel().transferDiamondDetail(transferRecordFragment.mType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(TransferRecordFragment transferRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        transferRecordFragment.getViewModel().transferDiamondDetail(transferRecordFragment.mType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(TransferRecordFragment transferRecordFragment, List list) {
        if (transferRecordFragment.getViewModel().getTransferRecordData().isOnePage()) {
            transferRecordFragment.getMAdapter().setList(list);
        } else if (list != null) {
            transferRecordFragment.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferViewModel viewModel_delegate$lambda$0(TransferRecordFragment transferRecordFragment) {
        return new ViewModelProvider(transferRecordFragment).get(TransferViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_transfer_record;
    }

    public final int getMType() {
        return this.mType;
    }

    public void onInitialize() {
        int i;
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
            i = 0;
        }
        this.mType = i;
        FragmentTransferRecordBinding fragmentTransferRecordBinding = (FragmentTransferRecordBinding) getBinding();
        if (fragmentTransferRecordBinding != null && (recyclerView = fragmentTransferRecordBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentTransferRecordBinding fragmentTransferRecordBinding2 = (FragmentTransferRecordBinding) getBinding();
            if (fragmentTransferRecordBinding2 != null && (smartRefreshLayout4 = fragmentTransferRecordBinding2.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        BaseListData transferRecordData = getViewModel().getTransferRecordData();
        FragmentTransferRecordBinding fragmentTransferRecordBinding3 = (FragmentTransferRecordBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentTransferRecordBinding3 != null) {
            smartRefreshLayout = fragmentTransferRecordBinding3.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentTransferRecordBinding fragmentTransferRecordBinding4 = (FragmentTransferRecordBinding) getBinding();
        if (fragmentTransferRecordBinding4 != null) {
            superStatusView2 = fragmentTransferRecordBinding4.statusView;
        }
        transferRecordData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentTransferRecordBinding fragmentTransferRecordBinding5 = (FragmentTransferRecordBinding) getBinding();
        if (fragmentTransferRecordBinding5 != null && (smartRefreshLayout3 = fragmentTransferRecordBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.transfer.u1
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    TransferRecordFragment.onInitialize$lambda$4(TransferRecordFragment.this, fVar);
                }
            });
        }
        FragmentTransferRecordBinding fragmentTransferRecordBinding6 = (FragmentTransferRecordBinding) getBinding();
        if (fragmentTransferRecordBinding6 != null && (smartRefreshLayout2 = fragmentTransferRecordBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.transfer.v1
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    TransferRecordFragment.onInitialize$lambda$5(TransferRecordFragment.this, fVar);
                }
            });
        }
        FragmentTransferRecordBinding fragmentTransferRecordBinding7 = (FragmentTransferRecordBinding) getBinding();
        if (fragmentTransferRecordBinding7 != null && (superStatusView = fragmentTransferRecordBinding7.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferRecordFragment$onInitialize$5
                public void onRetry(IStatusView statusView, Status status) {
                    TransferViewModel viewModel;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = TransferRecordFragment.this.getViewModel();
                    viewModel.transferDiamondDetail(TransferRecordFragment.this.getMType());
                }
            });
        }
        getViewModel().getTransferRecord().observe(this, new TransferRecordFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.w1
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = TransferRecordFragment.onInitialize$lambda$7(TransferRecordFragment.this, (List) obj);
                return onInitialize$lambda$7;
            }
        }));
        getViewModel().transferDiamondDetail(this.mType);
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
