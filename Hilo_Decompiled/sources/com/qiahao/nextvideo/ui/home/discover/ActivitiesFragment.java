package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.databinding.FragmentActivitiesBinding;
import com.qiahao.nextvideo.ui.home.discover.viewModel.ActivitiesViewModel;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0006\u0010\u0018\u001a\u00020\u0013J\b\u0010\u0019\u001a\u00020\u0013H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentActivitiesBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/discover/viewModel/ActivitiesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesFragmentAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesFragmentAdapter;", "adapter$delegate", "getLayoutResId", "", "onInitialize", "", "getStatusView", "Lcom/oudi/core/status/IStatusView;", "initView", "initData", "requestList", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nActivitiesFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivitiesFragment.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,203:1\n1#2:204\n1878#3,3:205\n1878#3,3:208\n*S KotlinDebug\n*F\n+ 1 ActivitiesFragment.kt\ncom/qiahao/nextvideo/ui/home/discover/ActivitiesFragment\n*L\n160#1:205,3\n175#1:208,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesFragment extends BaseBindingFragment<FragmentActivitiesBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.z
        public final Object invoke() {
            ActivitiesViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = ActivitiesFragment.viewModel_delegate$lambda$0(ActivitiesFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.a0
        public final Object invoke() {
            ActivitiesFragmentAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = ActivitiesFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivitiesFragmentAdapter adapter_delegate$lambda$1() {
        return new ActivitiesFragmentAdapter();
    }

    private final ActivitiesFragmentAdapter getAdapter() {
        return (ActivitiesFragmentAdapter) this.adapter.getValue();
    }

    private final IStatusView getStatusView() {
        FragmentActivitiesBinding fragmentActivitiesBinding = (FragmentActivitiesBinding) getBinding();
        if (fragmentActivitiesBinding != null) {
            return fragmentActivitiesBinding.statusView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivitiesViewModel getViewModel() {
        return (ActivitiesViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        SmartRefreshLayout smartRefreshLayout;
        getViewModel().getSquareList().observe(this, new ActivitiesFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.s
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = ActivitiesFragment.initData$lambda$11(ActivitiesFragment.this, (List) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().getSubscribedList().observe(this, new ActivitiesFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.t
            public final Object invoke(Object obj) {
                Unit initData$lambda$13;
                initData$lambda$13 = ActivitiesFragment.initData$lambda$13(ActivitiesFragment.this, (List) obj);
                return initData$lambda$13;
            }
        }));
        getViewModel().getActivityId().observe(this, new ActivitiesFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.u
            public final Object invoke(Object obj) {
                Unit initData$lambda$16;
                initData$lambda$16 = ActivitiesFragment.initData$lambda$16(ActivitiesFragment.this, (String) obj);
                return initData$lambda$16;
            }
        }));
        FragmentActivitiesBinding fragmentActivitiesBinding = (FragmentActivitiesBinding) getBinding();
        if (fragmentActivitiesBinding != null && (smartRefreshLayout = fragmentActivitiesBinding.refreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$11(ActivitiesFragment activitiesFragment, List list) {
        if (list != null) {
            if (activitiesFragment.getViewModel().getSquareListData().isOnePage()) {
                activitiesFragment.getAdapter().setList(list);
            } else {
                activitiesFragment.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$13(ActivitiesFragment activitiesFragment, List list) {
        if (list != null) {
            if (activitiesFragment.getViewModel().getSubscribedListData().isOnePage()) {
                activitiesFragment.getAdapter().setList(list);
            } else {
                activitiesFragment.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$16(ActivitiesFragment activitiesFragment, String str) {
        if (!TextUtils.isEmpty(str)) {
            int i = 0;
            if (Intrinsics.areEqual(activitiesFragment.getViewModel().getFragmentType(), ActivitiesActivity.TYPE_SQUARE)) {
                for (Object obj : activitiesFragment.getAdapter().getData()) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    ActivityDetailData activityDetailData = (ActivityDetailData) obj;
                    if (Intrinsics.areEqual(activityDetailData.getId(), str)) {
                        Boolean isSubscribe = activityDetailData.isSubscribe();
                        Boolean bool = Boolean.TRUE;
                        if (Intrinsics.areEqual(isSubscribe, bool)) {
                            ((ActivityDetailData) activitiesFragment.getAdapter().getData().get(i)).setSubscribe(Boolean.FALSE);
                            ((ActivityDetailData) activitiesFragment.getAdapter().getData().get(i)).setPersonNum(((ActivityDetailData) activitiesFragment.getAdapter().getData().get(i)).getPersonNum() - 1);
                        } else {
                            ((ActivityDetailData) activitiesFragment.getAdapter().getData().get(i)).setSubscribe(bool);
                            ((ActivityDetailData) activitiesFragment.getAdapter().getData().get(i)).setPersonNum(((ActivityDetailData) activitiesFragment.getAdapter().getData().get(i)).getPersonNum() + 1);
                            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, activitiesFragment.getContext(), ResourcesKtxKt.getStringById(activitiesFragment, 2131954177), false, 4, (Object) null);
                            if (normal$default != null) {
                                normal$default.show();
                            }
                        }
                        activitiesFragment.getAdapter().notifyItemChanged(i, Boolean.valueOf(Intrinsics.areEqual(activityDetailData.isSubscribe(), Boolean.FALSE)));
                    }
                    i = i2;
                }
            } else {
                for (Object obj2 : activitiesFragment.getAdapter().getData()) {
                    int i3 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    if (Intrinsics.areEqual(((ActivityDetailData) obj2).getId(), str)) {
                        activitiesFragment.getAdapter().removeAt(i);
                        return Unit.INSTANCE;
                    }
                    i = i3;
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        SmartRefreshLayout smartRefreshLayout5;
        RecyclerView recyclerView;
        FragmentActivitiesBinding fragmentActivitiesBinding = (FragmentActivitiesBinding) getBinding();
        if (fragmentActivitiesBinding != null && (recyclerView = fragmentActivitiesBinding.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        SuperStatusView superStatusView2 = null;
        if (Intrinsics.areEqual(getViewModel().getFragmentType(), ActivitiesActivity.TYPE_SQUARE)) {
            BaseListData squareListData = getViewModel().getSquareListData();
            FragmentActivitiesBinding fragmentActivitiesBinding2 = (FragmentActivitiesBinding) getBinding();
            if (fragmentActivitiesBinding2 != null) {
                smartRefreshLayout5 = fragmentActivitiesBinding2.refreshLayout;
            } else {
                smartRefreshLayout5 = null;
            }
            FragmentActivitiesBinding fragmentActivitiesBinding3 = (FragmentActivitiesBinding) getBinding();
            if (fragmentActivitiesBinding3 != null) {
                superStatusView2 = fragmentActivitiesBinding3.statusView;
            }
            squareListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout5, superStatusView2);
        } else {
            BaseListData subscribedListData = getViewModel().getSubscribedListData();
            FragmentActivitiesBinding fragmentActivitiesBinding4 = (FragmentActivitiesBinding) getBinding();
            if (fragmentActivitiesBinding4 != null) {
                smartRefreshLayout = fragmentActivitiesBinding4.refreshLayout;
            } else {
                smartRefreshLayout = null;
            }
            FragmentActivitiesBinding fragmentActivitiesBinding5 = (FragmentActivitiesBinding) getBinding();
            if (fragmentActivitiesBinding5 != null) {
                superStatusView2 = fragmentActivitiesBinding5.statusView;
            }
            subscribedListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        }
        FragmentActivitiesBinding fragmentActivitiesBinding6 = (FragmentActivitiesBinding) getBinding();
        if (fragmentActivitiesBinding6 != null && (smartRefreshLayout4 = fragmentActivitiesBinding6.refreshLayout) != null) {
            smartRefreshLayout4.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.discover.v
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    ActivitiesFragment.initView$lambda$2(ActivitiesFragment.this, fVar);
                }
            });
        }
        FragmentActivitiesBinding fragmentActivitiesBinding7 = (FragmentActivitiesBinding) getBinding();
        if (fragmentActivitiesBinding7 != null && (smartRefreshLayout3 = fragmentActivitiesBinding7.refreshLayout) != null) {
            smartRefreshLayout3.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.discover.w
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    ActivitiesFragment.initView$lambda$3(ActivitiesFragment.this, fVar);
                }
            });
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentActivitiesBinding fragmentActivitiesBinding8 = (FragmentActivitiesBinding) getBinding();
            if (fragmentActivitiesBinding8 != null && (smartRefreshLayout2 = fragmentActivitiesBinding8.refreshLayout) != null) {
                smartRefreshLayout2.setRefreshFooter(footLoading);
            }
        }
        FragmentActivitiesBinding fragmentActivitiesBinding9 = (FragmentActivitiesBinding) getBinding();
        if (fragmentActivitiesBinding9 != null && (superStatusView = fragmentActivitiesBinding9.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesFragment$initView$5
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    ActivitiesFragment.this.requestList();
                }
            });
        }
        getAdapter().addChildClickViewIds(new int[]{2131363295});
        getAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.x
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActivitiesFragment.initView$lambda$7(ActivitiesFragment.this, baseQuickAdapter, view, i);
            }
        });
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.y
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ActivitiesFragment.initView$lambda$9(ActivitiesFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(ActivitiesFragment activitiesFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (Intrinsics.areEqual(activitiesFragment.getViewModel().getFragmentType(), ActivitiesActivity.TYPE_SQUARE)) {
            activitiesFragment.getViewModel().getSquareListData().resetPage();
        } else {
            activitiesFragment.getViewModel().getSubscribedListData().resetPage();
        }
        activitiesFragment.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(ActivitiesFragment activitiesFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        activitiesFragment.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(final ActivitiesFragment activitiesFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        long j;
        boolean z;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        final ActivityDetailData activityDetailData = (ActivityDetailData) activitiesFragment.getAdapter().getData().get(i);
        if (view.getId() == 2131363295) {
            HiloUtils hiloUtils = HiloUtils.INSTANCE;
            Long startAt = activityDetailData.getStartAt();
            long j2 = 0;
            if (startAt != null) {
                j = startAt.longValue();
            } else {
                j = 0;
            }
            Long endAt = activityDetailData.getEndAt();
            if (endAt != null) {
                j2 = endAt.longValue();
            }
            if (hiloUtils.checkActivityStart(j, j2) == 0) {
                if (Intrinsics.areEqual(activityDetailData.isSubscribe(), Boolean.TRUE)) {
                    Context context = activitiesFragment.getContext();
                    if (context != null) {
                        new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(activitiesFragment, 2131951950)).setConfirmContent(ResourcesKtxKt.getStringById(activitiesFragment, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.home.discover.ActivitiesFragment$initView$6$1$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                ActivitiesViewModel viewModel;
                                boolean z2;
                                viewModel = ActivitiesFragment.this.getViewModel();
                                String id2 = activityDetailData.getId();
                                if (id2 == null) {
                                    id2 = "";
                                }
                                Boolean isSubscribe = activityDetailData.isSubscribe();
                                if (isSubscribe != null) {
                                    z2 = isSubscribe.booleanValue();
                                } else {
                                    z2 = false;
                                }
                                viewModel.activitySubscribe(id2, z2);
                            }
                        }).show();
                        return;
                    }
                    return;
                }
                ActivitiesViewModel viewModel = activitiesFragment.getViewModel();
                String id2 = activityDetailData.getId();
                if (id2 == null) {
                    id2 = "";
                }
                Boolean isSubscribe = activityDetailData.isSubscribe();
                if (isSubscribe != null) {
                    z = isSubscribe.booleanValue();
                } else {
                    z = false;
                }
                viewModel.activitySubscribe(id2, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(ActivitiesFragment activitiesFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            ActivityDetailData activityDetailData = (ActivityDetailData) activitiesFragment.getAdapter().getData().get(i);
            Context context = activitiesFragment.getContext();
            if (context != null) {
                Intent intent = new Intent(context, (Class<?>) ActivitiesDetailActivity.class);
                intent.putExtra(ActivitiesDetailActivity.ACTIVITY_ID, activityDetailData.getId());
                context.startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ActivitiesViewModel viewModel_delegate$lambda$0(ActivitiesFragment activitiesFragment) {
        return new ViewModelProvider(activitiesFragment).get(ActivitiesViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_activities;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getViewModel().getSquareListData().destroy();
        getViewModel().getSubscribedListData().destroy();
    }

    public void onInitialize() {
        String str;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        ActivitiesViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("fragment_type")) == null) {
            str = ActivitiesActivity.TYPE_SQUARE;
        }
        viewModel.setFragmentType(str);
        initView();
        initData();
    }

    public final void requestList() {
        if (Intrinsics.areEqual(getViewModel().getFragmentType(), ActivitiesActivity.TYPE_SQUARE)) {
            getViewModel().requestSquareList();
        } else {
            getViewModel().requestSubscribedHistory();
        }
    }
}
