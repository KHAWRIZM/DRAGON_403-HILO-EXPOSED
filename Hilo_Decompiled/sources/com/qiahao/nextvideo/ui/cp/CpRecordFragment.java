package com.qiahao.nextvideo.ui.cp;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cp.CpRecord;
import com.qiahao.nextvideo.databinding.FragmentRecordBinding;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpRecordFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentRecordBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/ui/cp/CpRecordAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/cp/CpRecordAdapter;", "adapter$delegate", "getLayoutResId", "", "onInitialize", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpRecordFragment.kt\ncom/qiahao/nextvideo/ui/cp/CpRecordFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,119:1\n1#2:120\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRecordFragment extends BaseBindingFragment<FragmentRecordBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.f1
        public final Object invoke() {
            CpRankViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CpRecordFragment.viewModel_delegate$lambda$0(CpRecordFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.g1
        public final Object invoke() {
            CpRecordAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = CpRecordFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpRecordAdapter adapter_delegate$lambda$1() {
        return new CpRecordAdapter();
    }

    private final CpRecordAdapter getAdapter() {
        return (CpRecordAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CpRankViewModel getViewModel() {
        return (CpRankViewModel) this.viewModel.getValue();
    }

    private final void initView() {
        TextView textView;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        FragmentRecordBinding fragmentRecordBinding = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding != null && (recyclerView2 = fragmentRecordBinding.recyclerView) != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        FragmentRecordBinding fragmentRecordBinding2 = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding2 != null && (recyclerView = fragmentRecordBinding2.recyclerView) != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.cp.CpRecordFragment$initView$1
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    if (parent.getChildLayoutPosition(view) == 0) {
                        outRect.top = UiKtxKt.toPX(10);
                    }
                }
            });
        }
        FragmentRecordBinding fragmentRecordBinding3 = (FragmentRecordBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentRecordBinding3 != null && (smartRefreshLayout4 = fragmentRecordBinding3.refreshLayout) != null) {
            textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout4, Status.Empty.INSTANCE, 2131362075);
        } else {
            textView = null;
        }
        Context context = getContext();
        if (context != null && textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
        }
        FragmentRecordBinding fragmentRecordBinding4 = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding4 != null && (smartRefreshLayout3 = fragmentRecordBinding4.refreshLayout) != null) {
            textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout3, Status.Error.INSTANCE, 2131362075);
        } else {
            textView2 = null;
        }
        Context context2 = getContext();
        if (context2 != null && textView2 != null) {
            textView2.setTextColor(androidx.core.content.a.getColor(context2, 2131101214));
        }
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.cp.b1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CpRecordFragment.initView$lambda$5(CpRecordFragment.this, baseQuickAdapter, view, i);
            }
        });
        getAdapter().addChildClickViewIds(new int[]{2131362014, 2131362015});
        getAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.cp.c1
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CpRecordFragment.initView$lambda$6(CpRecordFragment.this, baseQuickAdapter, view, i);
            }
        });
        BaseListData cpRecordData = getViewModel().getCpRecordData();
        FragmentRecordBinding fragmentRecordBinding5 = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding5 != null) {
            smartRefreshLayout = fragmentRecordBinding5.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentRecordBinding fragmentRecordBinding6 = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding6 != null) {
            superStatusView2 = fragmentRecordBinding6.statusView;
        }
        cpRecordData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentRecordBinding fragmentRecordBinding7 = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding7 != null && (smartRefreshLayout2 = fragmentRecordBinding7.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.cp.d1
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    CpRecordFragment.initView$lambda$7(CpRecordFragment.this, fVar);
                }
            });
        }
        FragmentRecordBinding fragmentRecordBinding8 = (FragmentRecordBinding) getBinding();
        if (fragmentRecordBinding8 != null && (superStatusView = fragmentRecordBinding8.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpRecordFragment$initView$7
                public void onRetry(IStatusView statusView, Status status) {
                    CpRankViewModel viewModel;
                    CpRankViewModel viewModel2;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = CpRecordFragment.this.getViewModel();
                    viewModel.getCpRecordData().resetPage();
                    viewModel2 = CpRecordFragment.this.getViewModel();
                    viewModel2.m٦٧getCpRecord();
                }
            });
        }
        getViewModel().getCpRecord().observe(this, new CpRecordFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.e1
            public final Object invoke(Object obj) {
                Unit initView$lambda$9;
                initView$lambda$9 = CpRecordFragment.initView$lambda$9(CpRecordFragment.this, (List) obj);
                return initView$lambda$9;
            }
        }));
        getViewModel().m٦٧getCpRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(CpRecordFragment cpRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        int i2;
        Context context;
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        CpRecord cpRecord = (CpRecord) cpRecordFragment.getAdapter().getData().get(i);
        Integer cpLevel = cpRecord.getCpLevel();
        if (cpLevel != null) {
            i2 = cpLevel.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0 && (context = cpRecordFragment.getContext()) != null) {
            CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
            User user1 = cpRecord.getUser1();
            if (user1 == null || (str = user1.getExternalId()) == null) {
                str = "";
            }
            CpSpaceActivity.Companion.startActivity$default(companion, context, str, null, 0, 12, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(CpRecordFragment cpRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        String externalId2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        CpRecord cpRecord = (CpRecord) cpRecordFragment.getAdapter().getData().get(i);
        int id2 = view.getId();
        String str = "";
        switch (id2) {
            case 2131362014:
                if (UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                    BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                    User user1 = cpRecord.getUser1();
                    if (user1 != null && (externalId = user1.getExternalId()) != null) {
                        str = externalId;
                    }
                    baseControlUtils.openPersonPage(str);
                    return;
                }
                return;
            case 2131362015:
                if (UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                    BaseControlUtils baseControlUtils2 = BaseControlUtils.INSTANCE;
                    User user2 = cpRecord.getUser2();
                    if (user2 != null && (externalId2 = user2.getExternalId()) != null) {
                        str = externalId2;
                    }
                    baseControlUtils2.openPersonPage(str);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(CpRecordFragment cpRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        cpRecordFragment.getViewModel().getCpRecordData().resetPage();
        cpRecordFragment.getViewModel().m٦٧getCpRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9(CpRecordFragment cpRecordFragment, List list) {
        if (list != null) {
            cpRecordFragment.getAdapter().setList(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpRankViewModel viewModel_delegate$lambda$0(CpRecordFragment cpRecordFragment) {
        return new ViewModelProvider(cpRecordFragment).get(CpRankViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_record;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
    }
}
