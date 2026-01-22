package com.qiahao.nextvideo.room.redEnvelope;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.room.EnvelopeRecordData;
import com.qiahao.nextvideo.databinding.ActivityRedEnvelopeRecordBinding;
import com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeDetailActivity;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRedEnvelopeRecordBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordAdapter;", "adapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRedEnvelopeRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RedEnvelopeRecordActivity.kt\ncom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,101:1\n61#2,9:102\n1#3:111\n*S KotlinDebug\n*F\n+ 1 RedEnvelopeRecordActivity.kt\ncom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordActivity\n*L\n69#1:102,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RedEnvelopeRecordActivity extends HiloBaseBindingActivity<ActivityRedEnvelopeRecordBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.redEnvelope.s
        public final Object invoke() {
            RedEnvelopeViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = RedEnvelopeRecordActivity.viewModel_delegate$lambda$0(RedEnvelopeRecordActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.redEnvelope.t
        public final Object invoke() {
            RedEnvelopeRecordAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = RedEnvelopeRecordActivity.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) RedEnvelopeRecordActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RedEnvelopeRecordAdapter adapter_delegate$lambda$1() {
        return new RedEnvelopeRecordAdapter();
    }

    private final RedEnvelopeRecordAdapter getAdapter() {
        return (RedEnvelopeRecordAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RedEnvelopeViewModel getViewModel() {
        return (RedEnvelopeViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getRedRecord().observe(this, new RedEnvelopeRecordActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.y
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = RedEnvelopeRecordActivity.initData$lambda$3(RedEnvelopeRecordActivity.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        RedEnvelopeViewModel.envelopeRecord$default(getViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(RedEnvelopeRecordActivity redEnvelopeRecordActivity, List list) {
        if (redEnvelopeRecordActivity.getViewModel().getRedRecordBaseData().isOnePage()) {
            redEnvelopeRecordActivity.getAdapter().setList(list);
        } else if (list != null) {
            redEnvelopeRecordActivity.getAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityRedEnvelopeRecordBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.room.redEnvelope.u
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$4;
                initView$lambda$4 = RedEnvelopeRecordActivity.initView$lambda$4(RedEnvelopeRecordActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$4;
            }
        });
        ((ActivityRedEnvelopeRecordBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131953875));
        final AppCompatImageView appCompatImageView = ((ActivityRedEnvelopeRecordBinding) getBinding()).titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeRecordActivity$initView$$inlined$singleClick$default$1
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
        ((ActivityRedEnvelopeRecordBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getRedRecordBaseData().registerStatusLayoutAndRefreshLayout(((ActivityRedEnvelopeRecordBinding) getBinding()).refreshLayout, ((ActivityRedEnvelopeRecordBinding) getBinding()).statusView);
        ((ActivityRedEnvelopeRecordBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.redEnvelope.v
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                RedEnvelopeRecordActivity.initView$lambda$6(RedEnvelopeRecordActivity.this, fVar);
            }
        });
        ((ActivityRedEnvelopeRecordBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.room.redEnvelope.w
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                RedEnvelopeRecordActivity.initView$lambda$7(RedEnvelopeRecordActivity.this, fVar);
            }
        });
        ((ActivityRedEnvelopeRecordBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeRecordActivity$initView$5
            public void onRetry(IStatusView statusView, Status status) {
                RedEnvelopeViewModel viewModel;
                RedEnvelopeViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = RedEnvelopeRecordActivity.this.getViewModel();
                viewModel.getRedRecordBaseData().resetPage();
                viewModel2 = RedEnvelopeRecordActivity.this.getViewModel();
                RedEnvelopeViewModel.envelopeRecord$default(viewModel2, false, 1, null);
            }
        });
        ((ActivityRedEnvelopeRecordBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.x
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                RedEnvelopeRecordActivity.initView$lambda$8(RedEnvelopeRecordActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4(RedEnvelopeRecordActivity redEnvelopeRecordActivity, int i, int i2) {
        redEnvelopeRecordActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(RedEnvelopeRecordActivity redEnvelopeRecordActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        redEnvelopeRecordActivity.getViewModel().getRedRecordBaseData().resetPage();
        RedEnvelopeViewModel.envelopeRecord$default(redEnvelopeRecordActivity.getViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(RedEnvelopeRecordActivity redEnvelopeRecordActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        RedEnvelopeViewModel.envelopeRecord$default(redEnvelopeRecordActivity.getViewModel(), false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$8(RedEnvelopeRecordActivity redEnvelopeRecordActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        long j;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        EnvelopeRecordData envelopeRecordData = (EnvelopeRecordData) redEnvelopeRecordActivity.getAdapter().getData().get(i);
        Integer type = envelopeRecordData.getType();
        if (type != null && type.intValue() == 1) {
            RedEnvelopeDetailActivity.Companion companion = RedEnvelopeDetailActivity.INSTANCE;
            Long luckyBagId = envelopeRecordData.getLuckyBagId();
            if (luckyBagId != null) {
                j = luckyBagId.longValue();
            } else {
                j = 0;
            }
            companion.start(redEnvelopeRecordActivity, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RedEnvelopeViewModel viewModel_delegate$lambda$0(RedEnvelopeRecordActivity redEnvelopeRecordActivity) {
        return new ViewModelProvider(redEnvelopeRecordActivity).get(RedEnvelopeViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_red_envelope_record;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
