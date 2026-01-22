package com.qiahao.nextvideo.ui.store;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.eventBus.BagEvent;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.store.BagCarromData;
import com.qiahao.nextvideo.databinding.FragmentCarromChildBinding;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/CarromBagChildFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentCarromChildBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/store/MyBagViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mSelectBean", "Lcom/qiahao/nextvideo/data/store/BagCarromData;", "getMSelectBean", "()Lcom/qiahao/nextvideo/data/store/BagCarromData;", "setMSelectBean", "(Lcom/qiahao/nextvideo/data/store/BagCarromData;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/store/CarromBagChildAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/store/CarromBagChildAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onResume", "onBagEvent", "event", "Lcom/qiahao/base_common/model/eventBus/BagEvent;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCarromBagChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CarromBagChildFragment.kt\ncom/qiahao/nextvideo/ui/store/CarromBagChildFragment\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,148:1\n1878#2,3:149\n1#3:152\n*S KotlinDebug\n*F\n+ 1 CarromBagChildFragment.kt\ncom/qiahao/nextvideo/ui/store/CarromBagChildFragment\n*L\n58#1:149,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CarromBagChildFragment extends BaseBindingFragment<FragmentCarromChildBinding> {

    @NotNull
    public static final String CARROM = "CARROM_TYPE";
    public static final int CARROM_POWERS = 2;
    public static final int CARROM_PUCKS = 3;
    public static final int CARROM_STRIKERS = 1;

    @Nullable
    private BagCarromData mSelectBean;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.a
        public final Object invoke() {
            MyBagViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = CarromBagChildFragment.viewModel_delegate$lambda$0(CarromBagChildFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.b
        public final Object invoke() {
            CarromBagChildAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = CarromBagChildFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final MyBagViewModel getViewModel() {
        return (MyBagViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getCarromList().observe(this, new CarromBagChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.c
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = CarromBagChildFragment.initData$lambda$4(CarromBagChildFragment.this, (List) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getMSuccess().observe(this, new CarromBagChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.d
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = CarromBagChildFragment.initData$lambda$5(CarromBagChildFragment.this, (Pair) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getMException().observe(this, new CarromBagChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.e
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = CarromBagChildFragment.initData$lambda$6(CarromBagChildFragment.this, (Pair) obj);
                return initData$lambda$6;
            }
        }));
        getViewModel().getCarromListData().resetPage();
        getViewModel().getBagCarromList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(CarromBagChildFragment carromBagChildFragment, List list) {
        if (carromBagChildFragment.getViewModel().getCarromListData().isOnePage()) {
            if (list != null && !list.isEmpty()) {
                int i = 0;
                for (Object obj : list) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((BagCarromData) obj).getUsing(), Boolean.TRUE)) {
                        carromBagChildFragment.getMAdapter().setMSelectId(((BagCarromData) list.get(0)).bagAndResId());
                        carromBagChildFragment.mSelectBean = (BagCarromData) list.get(0);
                    }
                    i = i2;
                }
                BagCarromData bagCarromData = carromBagChildFragment.mSelectBean;
                if (bagCarromData != null) {
                    bagCarromData.setType(Integer.valueOf(carromBagChildFragment.getViewModel().getCarromType()));
                }
            }
            carromBagChildFragment.getMAdapter().setList(list);
            cf.c.c().l(new BagEvent("carrom_select", carromBagChildFragment.mSelectBean));
        } else if (list != null) {
            carromBagChildFragment.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(CarromBagChildFragment carromBagChildFragment, Pair pair) {
        Toast normal$default;
        if (Intrinsics.areEqual(pair.getFirst(), MyBagViewModel.BAG_CARROM) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, carromBagChildFragment.getContext(), ResourcesKtxKt.getStringById(carromBagChildFragment, 2131954177), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(CarromBagChildFragment carromBagChildFragment, Pair pair) {
        String str;
        if (Intrinsics.areEqual(pair.getFirst(), MyBagViewModel.BAG_CARROM) && (pair.getSecond() instanceof HiloException)) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = carromBagChildFragment.getContext();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(carromBagChildFragment, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
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
        MyBagViewModel viewModel = getViewModel();
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
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.store.f
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    CarromBagChildFragment.initView$lambda$7(CarromBagChildFragment.this, fVar);
                }
            });
        }
        FragmentCarromChildBinding fragmentCarromChildBinding4 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding4 != null && (smartRefreshLayout2 = fragmentCarromChildBinding4.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.store.g
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    CarromBagChildFragment.initView$lambda$8(CarromBagChildFragment.this, fVar);
                }
            });
        }
        FragmentCarromChildBinding fragmentCarromChildBinding5 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding5 != null && (superStatusView = fragmentCarromChildBinding5.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.store.CarromBagChildFragment$initView$3
                public void onRetry(IStatusView statusView, Status status) {
                    MyBagViewModel viewModel2;
                    MyBagViewModel viewModel3;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel2 = CarromBagChildFragment.this.getViewModel();
                    viewModel2.getCarromListData().resetPage();
                    viewModel3 = CarromBagChildFragment.this.getViewModel();
                    viewModel3.getBagCarromList();
                }
            });
        }
        FragmentCarromChildBinding fragmentCarromChildBinding6 = (FragmentCarromChildBinding) getBinding();
        if (fragmentCarromChildBinding6 != null && (recyclerView = fragmentCarromChildBinding6.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        getMAdapter().addChildClickViewIds(new int[]{R.id.play_icon, R.id.back_content});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.store.h
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                CarromBagChildFragment.initView$lambda$9(CarromBagChildFragment.this, baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(CarromBagChildFragment carromBagChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        carromBagChildFragment.getViewModel().getCarromListData().resetPage();
        carromBagChildFragment.getViewModel().getBagCarromList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(CarromBagChildFragment carromBagChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        carromBagChildFragment.getViewModel().getBagCarromList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(CarromBagChildFragment carromBagChildFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        BagCarromData bagCarromData = (BagCarromData) carromBagChildFragment.getMAdapter().getItem(i);
        if (Intrinsics.areEqual(carromBagChildFragment.getMAdapter().getMSelectId(), bagCarromData.bagAndResId())) {
            return;
        }
        carromBagChildFragment.getMAdapter().setMSelectId(bagCarromData.bagAndResId());
        carromBagChildFragment.mSelectBean = bagCarromData;
        bagCarromData.setType(Integer.valueOf(carromBagChildFragment.getViewModel().getCarromType()));
        carromBagChildFragment.getMAdapter().notifyDataSetChanged();
        cf.c.c().l(new BagEvent("carrom_select", carromBagChildFragment.mSelectBean));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CarromBagChildAdapter mAdapter_delegate$lambda$1() {
        return new CarromBagChildAdapter(R.layout.item_carrom_bag_child);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagViewModel viewModel_delegate$lambda$0(CarromBagChildFragment carromBagChildFragment) {
        return new ViewModelProvider(carromBagChildFragment).get(MyBagViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_carrom_child;
    }

    @NotNull
    public final CarromBagChildAdapter getMAdapter() {
        return (CarromBagChildAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final BagCarromData getMSelectBean() {
        return this.mSelectBean;
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onBagEvent(@NotNull BagEvent event) {
        final BagCarromData bagCarromData;
        Context context;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "carrom_use") && (event.getData() instanceof BagCarromData)) {
            Object data = event.getData();
            if (data instanceof BagCarromData) {
                bagCarromData = (BagCarromData) data;
            } else {
                bagCarromData = null;
            }
            if (bagCarromData != null) {
                Integer type = bagCarromData.getType();
                int carromType = getViewModel().getCarromType();
                if (type != null && type.intValue() == carromType && (context = getContext()) != null) {
                    TipDialog tipDialog = new TipDialog(context);
                    String string = getString(2131952356);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    tipDialog.setTipContent(string).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.store.CarromBagChildFragment$onBagEvent$1$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            MyBagViewModel viewModel;
                            viewModel = CarromBagChildFragment.this.getViewModel();
                            viewModel.useCarromSkill(bagCarromData);
                        }
                    }).show();
                }
            }
        }
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        cf.c.c().l(new BagEvent("carrom_select", this.mSelectBean));
    }

    public final void setMSelectBean(@Nullable BagCarromData bagCarromData) {
        this.mSelectBean = bagCarromData;
    }
}
