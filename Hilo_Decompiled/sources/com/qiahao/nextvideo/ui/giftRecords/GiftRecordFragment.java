package com.qiahao.nextvideo.ui.giftRecords;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
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
import com.qiahao.nextvideo.data.giftRecord.GiftRecordData;
import com.qiahao.nextvideo.databinding.FragmentGiftRecordBinding;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentGiftRecordBinding;", "<init>", "()V", "adapter", "Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordListAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordListAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/giftRecords/GiftRecordViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initView", "initData", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftRecordFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftRecordFragment.kt\ncom/qiahao/nextvideo/ui/giftRecords/GiftRecordFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftRecordFragment extends BaseBindingFragment<FragmentGiftRecordBinding> {
    public static final int GIFT_RECEIVE = 1;
    public static final int GIFT_SEND = 2;

    @NotNull
    public static final String GIFT_TYPE = "gift_type";

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.giftRecords.h
        public final Object invoke() {
            GiftRecordListAdapter adapter_delegate$lambda$0;
            adapter_delegate$lambda$0 = GiftRecordFragment.adapter_delegate$lambda$0();
            return adapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.giftRecords.i
        public final Object invoke() {
            GiftRecordViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = GiftRecordFragment.viewModel_delegate$lambda$1(GiftRecordFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final GiftRecordListAdapter adapter_delegate$lambda$0() {
        return new GiftRecordListAdapter();
    }

    private final void initData() {
        getViewModel().getGiftList().observe(this, new GiftRecordFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.giftRecords.d
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = GiftRecordFragment.initData$lambda$8(GiftRecordFragment.this, (List) obj);
                return initData$lambda$8;
            }
        }));
        getViewModel().getGiftRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$8(GiftRecordFragment giftRecordFragment, List list) {
        if (giftRecordFragment.getViewModel().getBaseListData().isOnePage()) {
            giftRecordFragment.getAdapter().setList(list);
        } else if (list != null) {
            giftRecordFragment.getAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        RecyclerView recyclerView;
        GiftRecordViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("gift_type");
        } else {
            i = 1;
        }
        viewModel.setGiftType(i);
        FragmentGiftRecordBinding fragmentGiftRecordBinding = (FragmentGiftRecordBinding) getBinding();
        if (fragmentGiftRecordBinding != null && (recyclerView = fragmentGiftRecordBinding.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().addChildClickViewIds(new int[]{2131362013});
        getAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.giftRecords.e
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                GiftRecordFragment.initView$lambda$2(GiftRecordFragment.this, baseQuickAdapter, view, i2);
            }
        });
        BaseListData baseListData = getViewModel().getBaseListData();
        FragmentGiftRecordBinding fragmentGiftRecordBinding2 = (FragmentGiftRecordBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentGiftRecordBinding2 != null) {
            smartRefreshLayout = fragmentGiftRecordBinding2.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentGiftRecordBinding fragmentGiftRecordBinding3 = (FragmentGiftRecordBinding) getBinding();
        if (fragmentGiftRecordBinding3 != null) {
            superStatusView2 = fragmentGiftRecordBinding3.statusView;
        }
        baseListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentGiftRecordBinding fragmentGiftRecordBinding4 = (FragmentGiftRecordBinding) getBinding();
            if (fragmentGiftRecordBinding4 != null && (smartRefreshLayout4 = fragmentGiftRecordBinding4.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        FragmentGiftRecordBinding fragmentGiftRecordBinding5 = (FragmentGiftRecordBinding) getBinding();
        if (fragmentGiftRecordBinding5 != null && (smartRefreshLayout3 = fragmentGiftRecordBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.giftRecords.f
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    GiftRecordFragment.initView$lambda$5(GiftRecordFragment.this, fVar);
                }
            });
        }
        FragmentGiftRecordBinding fragmentGiftRecordBinding6 = (FragmentGiftRecordBinding) getBinding();
        if (fragmentGiftRecordBinding6 != null && (smartRefreshLayout2 = fragmentGiftRecordBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.giftRecords.g
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    GiftRecordFragment.initView$lambda$6(GiftRecordFragment.this, fVar);
                }
            });
        }
        FragmentGiftRecordBinding fragmentGiftRecordBinding7 = (FragmentGiftRecordBinding) getBinding();
        if (fragmentGiftRecordBinding7 != null && (superStatusView = fragmentGiftRecordBinding7.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.giftRecords.GiftRecordFragment$initView$6
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    GiftRecordFragment.this.getViewModel().getBaseListData().resetPage();
                    GiftRecordFragment.this.getViewModel().getGiftRecord();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2(GiftRecordFragment giftRecordFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GiftRecordData giftRecordData = (GiftRecordData) giftRecordFragment.getAdapter().getData().get(i);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            User user = giftRecordData.getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            service.openPersonPage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(GiftRecordFragment giftRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        giftRecordFragment.getViewModel().getBaseListData().resetPage();
        giftRecordFragment.getViewModel().getGiftRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(GiftRecordFragment giftRecordFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        giftRecordFragment.getViewModel().getGiftRecord();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GiftRecordViewModel viewModel_delegate$lambda$1(GiftRecordFragment giftRecordFragment) {
        return new ViewModelProvider(giftRecordFragment).get(GiftRecordViewModel.class);
    }

    @NotNull
    public final GiftRecordListAdapter getAdapter() {
        return (GiftRecordListAdapter) this.adapter.getValue();
    }

    protected int getLayoutResId() {
        return R.layout.fragment_gift_record;
    }

    @NotNull
    public final GiftRecordViewModel getViewModel() {
        return (GiftRecordViewModel) this.viewModel.getValue();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }
}
