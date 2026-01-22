package com.qiahao.nextvideo.ui.svip;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.svip.UserSvip;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivitySvipPointBinding;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipPointActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySvipPointBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/svip/SvipViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mPointAdapter", "Lcom/qiahao/nextvideo/ui/svip/SvipPointAdapter;", "getMPointAdapter", "()Lcom/qiahao/nextvideo/ui/svip/SvipPointAdapter;", "mPointAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSvipPointActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SvipPointActivity.kt\ncom/qiahao/nextvideo/ui/svip/SvipPointActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n61#2,9:101\n1#3:110\n*S KotlinDebug\n*F\n+ 1 SvipPointActivity.kt\ncom/qiahao/nextvideo/ui/svip/SvipPointActivity\n*L\n91#1:101,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipPointActivity extends HiloBaseBindingActivity<ActivitySvipPointBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.u
        public final Object invoke() {
            SvipViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = SvipPointActivity.viewModel_delegate$lambda$0(SvipPointActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mPointAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPointAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.svip.v
        public final Object invoke() {
            SvipPointAdapter mPointAdapter_delegate$lambda$1;
            mPointAdapter_delegate$lambda$1 = SvipPointActivity.mPointAdapter_delegate$lambda$1();
            return mPointAdapter_delegate$lambda$1;
        }
    });

    private final SvipPointAdapter getMPointAdapter() {
        return (SvipPointAdapter) this.mPointAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SvipViewModel getViewModel() {
        return (SvipViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getSvipDetail().observe(this, new SvipPointActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.s
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = SvipPointActivity.initData$lambda$3(SvipPointActivity.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getSvipPoint().observe(this, new SvipPointActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.svip.t
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = SvipPointActivity.initData$lambda$4(SvipPointActivity.this, (UserSvip) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().m٨٧getSvipDetail();
        getViewModel().m٨٩getSvipPoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(SvipPointActivity svipPointActivity, List list) {
        if (svipPointActivity.getViewModel().getSvipListData().isOnePage()) {
            svipPointActivity.getMPointAdapter().setList(list);
        } else if (list != null) {
            svipPointActivity.getMPointAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(SvipPointActivity svipPointActivity, UserSvip userSvip) {
        svipPointActivity.getBinding().point.setText(String.valueOf(userSvip.getPoints()));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivitySvipPointBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131954201));
        View view = ((ActivitySvipPointBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.svip.n
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$5;
                initView$lambda$5 = SvipPointActivity.initView$lambda$5(SvipPointActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$5;
            }
        });
        ((ActivitySvipPointBinding) getBinding()).titleBar.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SvipPointActivity.this.onBackPressed();
            }
        });
        ((ActivitySvipPointBinding) getBinding()).recyclerView.setAdapter(getMPointAdapter());
        getViewModel().getSvipListData().registerStatusLayoutAndRefreshLayout(((ActivitySvipPointBinding) getBinding()).refreshLayout, ((ActivitySvipPointBinding) getBinding()).statusView);
        ((ActivitySvipPointBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        ((ActivitySvipPointBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.svip.p
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                SvipPointActivity.initView$lambda$7(SvipPointActivity.this, fVar);
            }
        });
        ((ActivitySvipPointBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.svip.q
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                SvipPointActivity.initView$lambda$8(SvipPointActivity.this, fVar);
            }
        });
        ((ActivitySvipPointBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.svip.SvipPointActivity$initView$5
            public void onRetry(IStatusView statusView, Status status) {
                SvipViewModel viewModel;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = SvipPointActivity.this.getViewModel();
                viewModel.m٨٧getSvipDetail();
            }
        });
        final TextView textView = ((ActivitySvipPointBinding) getBinding()).getSvip;
        final long j = 800;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.svip.SvipPointActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    WalletActivity.INSTANCE.start(this);
                }
            }
        });
        getMPointAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.svip.r
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                SvipPointActivity.initView$lambda$10(baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5(SvipPointActivity svipPointActivity, int i, int i2) {
        svipPointActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(SvipPointActivity svipPointActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        svipPointActivity.getViewModel().getSvipListData().resetPage();
        svipPointActivity.getViewModel().m٨٧getSvipDetail();
        svipPointActivity.getViewModel().m٨٩getSvipPoint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(SvipPointActivity svipPointActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        svipPointActivity.getViewModel().m٨٧getSvipDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipPointAdapter mPointAdapter_delegate$lambda$1() {
        return new SvipPointAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SvipViewModel viewModel_delegate$lambda$0(SvipPointActivity svipPointActivity) {
        return new ViewModelProvider(svipPointActivity).get(SvipViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_svip_point;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
