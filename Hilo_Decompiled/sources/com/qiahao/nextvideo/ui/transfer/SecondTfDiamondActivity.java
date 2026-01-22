package com.qiahao.nextvideo.ui.transfer;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivitySecondTfDiamondBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTfDiamondActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySecondTfDiamondBinding;", "<init>", "()V", "mType", "", "getMType", "()I", "setMType", "(I)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/transfer/SecondRecordAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/SecondRecordAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "viewModel$delegate", "getLayoutResId", "onInitialize", "", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSecondTfDiamondActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SecondTfDiamondActivity.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTfDiamondActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,88:1\n61#2,9:89\n1#3:98\n*S KotlinDebug\n*F\n+ 1 SecondTfDiamondActivity.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTfDiamondActivity\n*L\n50#1:89,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondTfDiamondActivity extends HiloBaseBindingActivity<ActivitySecondTfDiamondBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private int mType;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.l
        public final Object invoke() {
            SecondRecordAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = SecondTfDiamondActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.m
        public final Object invoke() {
            SecondViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = SecondTfDiamondActivity.viewModel_delegate$lambda$1(SecondTfDiamondActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTfDiamondActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) SecondTfDiamondActivity.class));
        }

        private Companion() {
        }
    }

    private final SecondRecordAdapter getMAdapter() {
        return (SecondRecordAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SecondViewModel getViewModel() {
        return (SecondViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecondRecordAdapter mAdapter_delegate$lambda$0() {
        return new SecondRecordAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(SecondTfDiamondActivity secondTfDiamondActivity, int i, int i2) {
        secondTfDiamondActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(SecondTfDiamondActivity secondTfDiamondActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        secondTfDiamondActivity.getViewModel().getSecondDetailData().resetPage();
        secondTfDiamondActivity.getViewModel().secondDiamondDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(SecondTfDiamondActivity secondTfDiamondActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        secondTfDiamondActivity.getViewModel().secondDiamondDetail();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(SecondTfDiamondActivity secondTfDiamondActivity, ApiList apiList) {
        List data;
        if (secondTfDiamondActivity.getViewModel().getSecondDetailData().isOnePage()) {
            secondTfDiamondActivity.getMAdapter().setList(apiList.getData());
        } else if (apiList != null && (data = apiList.getData()) != null) {
            secondTfDiamondActivity.getMAdapter().addData(data);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecondViewModel viewModel_delegate$lambda$1(SecondTfDiamondActivity secondTfDiamondActivity) {
        return new ViewModelProvider(secondTfDiamondActivity).get(SecondViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_second_tf_diamond;
    }

    public final int getMType() {
        return this.mType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getSecondDetailData().destroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = ((ActivitySecondTfDiamondBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.n
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = SecondTfDiamondActivity.onInitialize$lambda$2(SecondTfDiamondActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = ((ActivitySecondTfDiamondBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTfDiamondActivity$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        ((ActivitySecondTfDiamondBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivitySecondTfDiamondBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getSecondDetailData().registerStatusLayoutAndRefreshLayout(((ActivitySecondTfDiamondBinding) getBinding()).refreshLayout, ((ActivitySecondTfDiamondBinding) getBinding()).statusView);
        ((ActivitySecondTfDiamondBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.transfer.o
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                SecondTfDiamondActivity.onInitialize$lambda$4(SecondTfDiamondActivity.this, fVar);
            }
        });
        ((ActivitySecondTfDiamondBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.transfer.p
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                SecondTfDiamondActivity.onInitialize$lambda$5(SecondTfDiamondActivity.this, fVar);
            }
        });
        ((ActivitySecondTfDiamondBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTfDiamondActivity$onInitialize$5
            public void onRetry(IStatusView statusView, Status status) {
                SecondViewModel viewModel;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = SecondTfDiamondActivity.this.getViewModel();
                viewModel.secondDiamondDetail();
            }
        });
        getViewModel().getSecondDetail().observe(this, new SecondTfDiamondActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.q
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = SecondTfDiamondActivity.onInitialize$lambda$7(SecondTfDiamondActivity.this, (ApiList) obj);
                return onInitialize$lambda$7;
            }
        }));
        getViewModel().secondDiamondDetail();
    }

    public final void setMType(int i) {
        this.mType = i;
    }
}
