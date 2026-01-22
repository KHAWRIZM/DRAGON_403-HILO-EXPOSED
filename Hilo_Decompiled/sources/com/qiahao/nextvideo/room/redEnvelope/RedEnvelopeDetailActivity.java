package com.qiahao.nextvideo.room.redEnvelope;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.room.EnvelopeData;
import com.qiahao.nextvideo.databinding.ActivityRedEnvelopDetailHeadBinding;
import com.qiahao.nextvideo.databinding.ActivityRedEnvelopeDetailBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0003J\b\u0010\u001a\u001a\u00020\u0018H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRedEnvelopeDetailBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "headBinding", "Lcom/qiahao/nextvideo/databinding/ActivityRedEnvelopDetailHeadBinding;", "getHeadBinding", "()Lcom/qiahao/nextvideo/databinding/ActivityRedEnvelopDetailHeadBinding;", "headBinding$delegate", "adapter", "Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailAdapter;", "adapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRedEnvelopeDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RedEnvelopeDetailActivity.kt\ncom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,156:1\n61#2,9:157\n1#3:166\n439#4:167\n439#4:168\n*S KotlinDebug\n*F\n+ 1 RedEnvelopeDetailActivity.kt\ncom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailActivity\n*L\n126#1:157,9\n80#1:167\n87#1:168\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RedEnvelopeDetailActivity extends HiloBaseBindingActivity<ActivityRedEnvelopeDetailBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String ENVELOPE_ID = "envelopeId";

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.redEnvelope.p
        public final Object invoke() {
            RedEnvelopeViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = RedEnvelopeDetailActivity.viewModel_delegate$lambda$0(RedEnvelopeDetailActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: headBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy headBinding = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.redEnvelope.q
        public final Object invoke() {
            ActivityRedEnvelopDetailHeadBinding headBinding_delegate$lambda$1;
            headBinding_delegate$lambda$1 = RedEnvelopeDetailActivity.headBinding_delegate$lambda$1(RedEnvelopeDetailActivity.this);
            return headBinding_delegate$lambda$1;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.redEnvelope.r
        public final Object invoke() {
            RedEnvelopeDetailAdapter adapter_delegate$lambda$2;
            adapter_delegate$lambda$2 = RedEnvelopeDetailActivity.adapter_delegate$lambda$2();
            return adapter_delegate$lambda$2;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailActivity$Companion;", "", "<init>", "()V", "ENVELOPE_ID", "", "start", "", "context", "Landroid/content/Context;", RedEnvelopeDetailActivity.ENVELOPE_ID, "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, long envelopeId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) RedEnvelopeDetailActivity.class);
            intent.putExtra(RedEnvelopeDetailActivity.ENVELOPE_ID, envelopeId);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RedEnvelopeDetailAdapter adapter_delegate$lambda$2() {
        return new RedEnvelopeDetailAdapter();
    }

    private final RedEnvelopeDetailAdapter getAdapter() {
        return (RedEnvelopeDetailAdapter) this.adapter.getValue();
    }

    private final ActivityRedEnvelopDetailHeadBinding getHeadBinding() {
        return (ActivityRedEnvelopDetailHeadBinding) this.headBinding.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RedEnvelopeViewModel getViewModel() {
        return (RedEnvelopeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final ActivityRedEnvelopDetailHeadBinding headBinding_delegate$lambda$1(RedEnvelopeDetailActivity redEnvelopeDetailActivity) {
        ActivityRedEnvelopDetailHeadBinding inflate = ActivityRedEnvelopDetailHeadBinding.inflate(redEnvelopeDetailActivity.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        getViewModel().getRedRecord().observe(this, new RedEnvelopeDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.m
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = RedEnvelopeDetailActivity.initData$lambda$4(RedEnvelopeDetailActivity.this, (List) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getRedEnvelopInfo().observe(this, new RedEnvelopeDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.n
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = RedEnvelopeDetailActivity.initData$lambda$10(RedEnvelopeDetailActivity.this, (EnvelopeData) obj);
                return initData$lambda$10;
            }
        }));
        getViewModel().getMException().observe(this, new RedEnvelopeDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.room.redEnvelope.o
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = RedEnvelopeDetailActivity.initData$lambda$11(RedEnvelopeDetailActivity.this, (Pair) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().envelopeRecord(true);
        getViewModel().getEnvelopeInfo(getViewModel().getMEnvelopeId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0127, code lost:
    
        if (r0 == null) goto L٣٢;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initData$lambda$10(RedEnvelopeDetailActivity redEnvelopeDetailActivity, EnvelopeData envelopeData) {
        ActivityRedEnvelopDetailHeadBinding activityRedEnvelopDetailHeadBinding;
        long j;
        long j2;
        Object code;
        Long l;
        if (envelopeData != null) {
            Long end = envelopeData.getEnd();
            if (end != null) {
                if (end.longValue() > System.currentTimeMillis() / 1000) {
                    activityRedEnvelopDetailHeadBinding = redEnvelopeDetailActivity.getHeadBinding();
                    String stringById = ResourcesKtxKt.getStringById(activityRedEnvelopDetailHeadBinding, 2131954279);
                    Long leftDiamond = envelopeData.getLeftDiamond();
                    long j3 = 0;
                    if (leftDiamond != null) {
                        j = leftDiamond.longValue();
                    } else {
                        j = 0;
                    }
                    String str = stringById + " " + j;
                    SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(activityRedEnvelopDetailHeadBinding.tvClaimed);
                    Long leftDiamond2 = envelopeData.getLeftDiamond();
                    if (leftDiamond2 != null) {
                        j2 = leftDiamond2.longValue();
                    } else {
                        j2 = 0;
                    }
                    SpannableTextBuilder.changeTextColor$default(spannableTextBuilder, str, String.valueOf(j2), Integer.valueOf(Color.parseColor("#FBA807")), (Integer) null, 8, (Object) null).apply();
                    Long leftDiamond3 = envelopeData.getLeftDiamond();
                    if (leftDiamond3 != null) {
                        long longValue = leftDiamond3.longValue();
                        Long diamond = envelopeData.getDiamond();
                        if (diamond != null) {
                            l = Long.valueOf(diamond.longValue() - longValue);
                        } else {
                            l = null;
                        }
                        if (l != null) {
                            j3 = l.longValue();
                            SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(activityRedEnvelopDetailHeadBinding.tvToBeClaimed), ResourcesKtxKt.getStringById(activityRedEnvelopDetailHeadBinding, 2131952260) + " " + j3, String.valueOf(j3), Integer.valueOf(Color.parseColor("#FBA807")), (Integer) null, 8, (Object) null).apply();
                            TextView textView = activityRedEnvelopDetailHeadBinding.tvUserNameAndId;
                            String nick = envelopeData.getNick();
                            code = envelopeData.getCode();
                            if (code == null) {
                                code = 0;
                            }
                            textView.setText(nick + " (ID:" + code + ")");
                            HiloImageView.loadImage$default(activityRedEnvelopDetailHeadBinding.headAvatar, ImageSizeKt.image100(envelopeData.getAvatar()), 2131231655, 0, 4, (Object) null);
                        }
                    }
                    Long diamond2 = envelopeData.getDiamond();
                    if (diamond2 != null) {
                        j3 = diamond2.longValue();
                    }
                    SpannableTextBuilder.changeTextColor$default(new SpannableTextBuilder(activityRedEnvelopDetailHeadBinding.tvToBeClaimed), ResourcesKtxKt.getStringById(activityRedEnvelopDetailHeadBinding, 2131952260) + " " + j3, String.valueOf(j3), Integer.valueOf(Color.parseColor("#FBA807")), (Integer) null, 8, (Object) null).apply();
                    TextView textView2 = activityRedEnvelopDetailHeadBinding.tvUserNameAndId;
                    String nick2 = envelopeData.getNick();
                    code = envelopeData.getCode();
                    if (code == null) {
                    }
                    textView2.setText(nick2 + " (ID:" + code + ")");
                    HiloImageView.loadImage$default(activityRedEnvelopDetailHeadBinding.headAvatar, ImageSizeKt.image100(envelopeData.getAvatar()), 2131231655, 0, 4, (Object) null);
                } else {
                    View root = redEnvelopeDetailActivity.getHeadBinding().getRoot();
                    Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
                    ViewKtxKt.visibleOrGone(root, false);
                    activityRedEnvelopDetailHeadBinding = Unit.INSTANCE;
                }
            }
            View root2 = redEnvelopeDetailActivity.getHeadBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "getRoot(...)");
            ViewKtxKt.visibleOrGone(root2, false);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$11(RedEnvelopeDetailActivity redEnvelopeDetailActivity, Pair pair) {
        if (Intrinsics.areEqual(pair.getFirst(), RedEnvelopeViewModel.ENVELOP_INFO)) {
            View root = redEnvelopeDetailActivity.getHeadBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
            ViewKtxKt.visibleOrGone(root, false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(RedEnvelopeDetailActivity redEnvelopeDetailActivity, List list) {
        if (redEnvelopeDetailActivity.getViewModel().getRedRecordBaseData().isOnePage()) {
            redEnvelopeDetailActivity.getAdapter().setList(list);
        } else if (list != null) {
            redEnvelopeDetailActivity.getAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        getViewModel().setMEnvelopeId(getIntent().getLongExtra(ENVELOPE_ID, 0L));
        View view = ((ActivityRedEnvelopeDetailBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.room.redEnvelope.i
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$12;
                initView$lambda$12 = RedEnvelopeDetailActivity.initView$lambda$12(RedEnvelopeDetailActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$12;
            }
        });
        ((ActivityRedEnvelopeDetailBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131953874));
        final AppCompatImageView appCompatImageView = ((ActivityRedEnvelopeDetailBinding) getBinding()).titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeDetailActivity$initView$$inlined$singleClick$default$1
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
        ((ActivityRedEnvelopeDetailBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getRedRecordBaseData().registerStatusLayoutAndRefreshLayout(((ActivityRedEnvelopeDetailBinding) getBinding()).refreshLayout, ((ActivityRedEnvelopeDetailBinding) getBinding()).statusView);
        ((ActivityRedEnvelopeDetailBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.redEnvelope.j
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                RedEnvelopeDetailActivity.initView$lambda$14(RedEnvelopeDetailActivity.this, fVar);
            }
        });
        ((ActivityRedEnvelopeDetailBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.room.redEnvelope.k
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                RedEnvelopeDetailActivity.initView$lambda$15(RedEnvelopeDetailActivity.this, fVar);
            }
        });
        ((ActivityRedEnvelopeDetailBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.RedEnvelopeDetailActivity$initView$5
            public void onRetry(IStatusView statusView, Status status) {
                RedEnvelopeViewModel viewModel;
                RedEnvelopeViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = RedEnvelopeDetailActivity.this.getViewModel();
                viewModel.getRedRecordBaseData().resetPage();
                viewModel2 = RedEnvelopeDetailActivity.this.getViewModel();
                viewModel2.envelopeRecord(true);
            }
        });
        RedEnvelopeDetailAdapter adapter = getAdapter();
        View root = getHeadBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BaseQuickAdapter.setHeaderView$default(adapter, root, 0, 0, 6, (Object) null);
        ((ActivityRedEnvelopeDetailBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.room.redEnvelope.l
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                RedEnvelopeDetailActivity.initView$lambda$16(baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$12(RedEnvelopeDetailActivity redEnvelopeDetailActivity, int i, int i2) {
        redEnvelopeDetailActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$14(RedEnvelopeDetailActivity redEnvelopeDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        redEnvelopeDetailActivity.getViewModel().getRedRecordBaseData().resetPage();
        redEnvelopeDetailActivity.getViewModel().envelopeRecord(true);
        redEnvelopeDetailActivity.getViewModel().getEnvelopeInfo(redEnvelopeDetailActivity.getViewModel().getMEnvelopeId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$15(RedEnvelopeDetailActivity redEnvelopeDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        redEnvelopeDetailActivity.getViewModel().envelopeRecord(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$16(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RedEnvelopeViewModel viewModel_delegate$lambda$0(RedEnvelopeDetailActivity redEnvelopeDetailActivity) {
        return new ViewModelProvider(redEnvelopeDetailActivity).get(RedEnvelopeViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_red_envelope_detail;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
