package com.qiahao.nextvideo.ui.store;

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
import com.qiahao.base_common.model.eventBus.StoreEvent;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.store.StoreCarromData;
import com.qiahao.nextvideo.databinding.FragmentCarromChildBinding;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/CarromChildFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentCarromChildBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mSelectBean", "Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "getMSelectBean", "()Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "setMSelectBean", "(Lcom/qiahao/nextvideo/data/store/StoreCarromData;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/store/CarromChildAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/store/CarromChildAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onResume", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCarromChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CarromChildFragment.kt\ncom/qiahao/nextvideo/ui/store/CarromChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,107:1\n1#2:108\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CarromChildFragment extends BaseBindingFragment<FragmentCarromChildBinding> {

    @NotNull
    public static final String CARROM = "CARROM_TYPE";
    public static final int CARROM_POWERS = 2;
    public static final int CARROM_PUCKS = 3;
    public static final int CARROM_STRIKERS = 1;

    @Nullable
    private StoreCarromData mSelectBean;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.m
        public final Object invoke() {
            StoreViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CarromChildFragment.viewModel_delegate$lambda$0(CarromChildFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.n
        public final Object invoke() {
            CarromChildAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = CarromChildFragment.mAdapter_delegate$lambda$1(CarromChildFragment.this);
            return mAdapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreViewModel getViewModel() {
        return (StoreViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getCarromList().observe(this, new CarromChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.i
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = CarromChildFragment.initData$lambda$3(CarromChildFragment.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getCarromListData().resetPage();
        getViewModel().m٨٥getCarromList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(CarromChildFragment carromChildFragment, List list) {
        long j;
        if (carromChildFragment.getViewModel().getCarromListData().isOnePage()) {
            if (list != null && !list.isEmpty()) {
                CarromChildAdapter mAdapter = carromChildFragment.getMAdapter();
                Long id2 = ((StoreCarromData) list.get(0)).getId();
                if (id2 != null) {
                    j = id2.longValue();
                } else {
                    j = 0;
                }
                mAdapter.setMSelectId(j);
                carromChildFragment.mSelectBean = (StoreCarromData) list.get(0);
                cf.c.c().l(new StoreEvent("CARROM_SELECT", carromChildFragment.mSelectBean));
            }
            carromChildFragment.getMAdapter().setList(list);
        } else if (list != null) {
            carromChildFragment.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        StoreViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("CARROM_TYPE");
        } else {
            i = 1;
        }
        viewModel.setCarromType(i);
        BaseListData carromListData = getViewModel().getCarromListData();
        FragmentCarromChildBinding fragmentCarromChildBinding = (FragmentCarromChildBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentCarromChildBinding != null) {
            smartRefreshLayout = fragmentCarromChildBinding.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentCarromChildBinding fragmentCarromChildBinding2 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding2 != null) {
            superStatusView2 = fragmentCarromChildBinding2.statusView;
        }
        carromListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        FragmentCarromChildBinding fragmentCarromChildBinding3 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding3 != null && (smartRefreshLayout3 = fragmentCarromChildBinding3.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.store.j
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    CarromChildFragment.initView$lambda$4(CarromChildFragment.this, fVar);
                }
            });
        }
        FragmentCarromChildBinding fragmentCarromChildBinding4 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding4 != null && (smartRefreshLayout2 = fragmentCarromChildBinding4.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.store.k
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    CarromChildFragment.initView$lambda$5(CarromChildFragment.this, fVar);
                }
            });
        }
        FragmentCarromChildBinding fragmentCarromChildBinding5 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding5 != null && (superStatusView = fragmentCarromChildBinding5.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.store.CarromChildFragment$initView$3
                public void onRetry(IStatusView statusView, Status status) {
                    StoreViewModel viewModel2;
                    StoreViewModel viewModel3;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel2 = CarromChildFragment.this.getViewModel();
                    viewModel2.getCarromListData().resetPage();
                    viewModel3 = CarromChildFragment.this.getViewModel();
                    viewModel3.m٨٦getStoreList();
                }
            });
        }
        FragmentCarromChildBinding fragmentCarromChildBinding6 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding6 != null && (recyclerView = fragmentCarromChildBinding6.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.store.l
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                CarromChildFragment.initView$lambda$6(CarromChildFragment.this, baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(CarromChildFragment carromChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        carromChildFragment.getViewModel().getCarromListData().resetPage();
        carromChildFragment.getViewModel().m٨٥getCarromList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(CarromChildFragment carromChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        carromChildFragment.getViewModel().m٨٥getCarromList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(CarromChildFragment carromChildFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        long j;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        StoreCarromData storeCarromData = (StoreCarromData) carromChildFragment.getMAdapter().getItem(i);
        long mSelectId = carromChildFragment.getMAdapter().getMSelectId();
        Long id2 = storeCarromData.getId();
        if (id2 != null && mSelectId == id2.longValue()) {
            return;
        }
        CarromChildAdapter mAdapter = carromChildFragment.getMAdapter();
        Long id3 = storeCarromData.getId();
        if (id3 != null) {
            j = id3.longValue();
        } else {
            j = 0;
        }
        mAdapter.setMSelectId(j);
        carromChildFragment.mSelectBean = storeCarromData;
        cf.c.c().l(new StoreEvent("CARROM_SELECT", carromChildFragment.mSelectBean));
        carromChildFragment.getMAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CarromChildAdapter mAdapter_delegate$lambda$1(CarromChildFragment carromChildFragment) {
        return new CarromChildAdapter(R.layout.item_carrom_child, carromChildFragment.getViewModel().getType());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoreViewModel viewModel_delegate$lambda$0(CarromChildFragment carromChildFragment) {
        return new ViewModelProvider(carromChildFragment).get(StoreViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_carrom_child;
    }

    @NotNull
    public final CarromChildAdapter getMAdapter() {
        return (CarromChildAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final StoreCarromData getMSelectBean() {
        return this.mSelectBean;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getViewModel().getCarromListData().destroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onResume() {
        long j;
        Long id2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        if (this.mSelectBean != null) {
            CarromChildAdapter mAdapter = getMAdapter();
            StoreCarromData storeCarromData = this.mSelectBean;
            if (storeCarromData != null && (id2 = storeCarromData.getId()) != null) {
                j = id2.longValue();
            } else {
                j = 0;
            }
            mAdapter.setMSelectId(j);
            cf.c.c().l(new StoreEvent("CARROM_SELECT", this.mSelectBean));
            getMAdapter().notifyDataSetChanged();
        }
    }

    public final void setMSelectBean(@Nullable StoreCarromData storeCarromData) {
        this.mSelectBean = storeCarromData;
    }
}
