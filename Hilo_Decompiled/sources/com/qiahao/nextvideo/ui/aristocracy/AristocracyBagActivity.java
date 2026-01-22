package com.qiahao.nextvideo.ui.aristocracy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipTitleDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.noble.NobleCard;
import com.qiahao.nextvideo.data.noble.NobleUse;
import com.qiahao.nextvideo.databinding.ActivityAristocracyBagBinding;
import com.qiahao.nextvideo.ui.cp.SearchUserActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.Arrays;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\b\u0010\u0018\u001a\u00020\u0013H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyBagActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityAristocracyBagBinding;", "<init>", "()V", "mAdapter", "Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyBagAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyBagAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/aristocracy/VipCardViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/aristocracy/VipCardViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "refreshView", "position", "onResume", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAristocracyBagActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AristocracyBagActivity.kt\ncom/qiahao/nextvideo/ui/aristocracy/AristocracyBagActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,205:1\n61#2,9:206\n61#2,9:215\n61#2,9:224\n61#2,9:233\n*S KotlinDebug\n*F\n+ 1 AristocracyBagActivity.kt\ncom/qiahao/nextvideo/ui/aristocracy/AristocracyBagActivity\n*L\n108#1:206,9\n116#1:215,9\n150#1:224,9\n162#1:233,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AristocracyBagActivity extends HiloBaseBindingActivity<ActivityAristocracyBagBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.h
        public final Object invoke() {
            AristocracyBagAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = AristocracyBagActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.i
        public final Object invoke() {
            VipCardViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = AristocracyBagActivity.viewModel_delegate$lambda$1();
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyBagActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) AristocracyBagActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AristocracyBagAdapter getMAdapter() {
        return (AristocracyBagAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VipCardViewModel getViewModel() {
        return (VipCardViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getNobleList().observe(this, new AristocracyBagActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.e
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = AristocracyBagActivity.initData$lambda$2(AristocracyBagActivity.this, (List) obj);
                return initData$lambda$2;
            }
        }));
        getViewModel().getMSuccess().observe(this, new AristocracyBagActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = AristocracyBagActivity.initData$lambda$3(AristocracyBagActivity.this, (Pair) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getMException().observe(this, new AristocracyBagActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.g
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = AristocracyBagActivity.initData$lambda$4(AristocracyBagActivity.this, (Pair) obj);
                return initData$lambda$4;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(AristocracyBagActivity aristocracyBagActivity, List list) {
        aristocracyBagActivity.getMAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(AristocracyBagActivity aristocracyBagActivity, Pair pair) {
        if (pair.getSecond() instanceof NobleUse) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.nextvideo.data.noble.NobleUse");
            NobleUse nobleUse = (NobleUse) second;
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, aristocracyBagActivity, ResourcesKtxKt.getStringById(aristocracyBagActivity, 2131954177), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            new AristocracyCardDialog(aristocracyBagActivity, nobleUse).show();
            cf.c.c().l(new EventBusKey("REFRESH_ARISTOCRACY", (Object) null, 2, (DefaultConstructorMarker) null));
            aristocracyBagActivity.getViewModel().nobleCard();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$4(AristocracyBagActivity aristocracyBagActivity, Pair pair) {
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(aristocracyBagActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, aristocracyBagActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityAristocracyBagBinding) getBinding()).titleBar.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.aristocracy.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$5;
                initView$lambda$5 = AristocracyBagActivity.initView$lambda$5(AristocracyBagActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$5;
            }
        });
        SmartRefreshLayout smartRefreshLayout = ((ActivityAristocracyBagBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "refreshLayout");
        TextView textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout, Status.Empty.INSTANCE, 2131362075);
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
        }
        SmartRefreshLayout smartRefreshLayout2 = ((ActivityAristocracyBagBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout2, "refreshLayout");
        TextView textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout2, Status.Error.INSTANCE, 2131362075);
        if (textView2 != null) {
            textView2.setTextColor(androidx.core.content.a.getColor(this, 2131101214));
        }
        final AppCompatImageView appCompatImageView = ((ActivityAristocracyBagBinding) getBinding()).titleBar.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity$initView$$inlined$singleClick$default$1
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
        ((ActivityAristocracyBagBinding) getBinding()).titleBar.endImage.setVisibility(0);
        ((ActivityAristocracyBagBinding) getBinding()).titleBar.endImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.aristocracy_list));
        final AppCompatImageView appCompatImageView2 = ((ActivityAristocracyBagBinding) getBinding()).titleBar.endImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    VipRecordsActivity.INSTANCE.start(this, 0);
                }
            }
        });
        ((ActivityAristocracyBagBinding) getBinding()).titleBar.title.setText(ResourcesKtxKt.getStringById(this, 2131952031));
        TextView textView3 = ((ActivityAristocracyBagBinding) getBinding()).send;
        Intrinsics.checkNotNullExpressionValue(textView3, "send");
        ImageKtxKt.toHorizontalMirror(textView3, R.drawable.aristocracy_send_bg);
        TextView textView4 = ((ActivityAristocracyBagBinding) getBinding()).use;
        Intrinsics.checkNotNullExpressionValue(textView4, "use");
        ImageKtxKt.toHorizontalMirror(textView4, R.drawable.aristocracy_use_bg);
        ((ActivityAristocracyBagBinding) getBinding()).buttonLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#27242B", "#121212", 0, (GradientDrawable.Orientation) null, 8, (Object) null));
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.b
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                AristocracyBagActivity.initView$lambda$8(AristocracyBagActivity.this, baseQuickAdapter, view2, i);
            }
        });
        ((ActivityAristocracyBagBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivityAristocracyBagBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getNobleListData().registerStatusLayoutAndRefreshLayout(((ActivityAristocracyBagBinding) getBinding()).refreshLayout, ((ActivityAristocracyBagBinding) getBinding()).statusView);
        ((ActivityAristocracyBagBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.aristocracy.c
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                AristocracyBagActivity.initView$lambda$9(AristocracyBagActivity.this, fVar);
            }
        });
        ((ActivityAristocracyBagBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.aristocracy.d
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                AristocracyBagActivity.initView$lambda$10(AristocracyBagActivity.this, fVar);
            }
        });
        ((ActivityAristocracyBagBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity$initView$7
            public void onRetry(IStatusView statusView, Status status) {
                VipCardViewModel viewModel;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = AristocracyBagActivity.this.getViewModel();
                viewModel.nobleCard();
            }
        });
        final TextView textView5 = ((ActivityAristocracyBagBinding) getBinding()).send;
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AristocracyBagAdapter mAdapter;
                AristocracyBagAdapter mAdapter2;
                Integer isExclusive;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView5) > j || (textView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView5, currentTimeMillis);
                    mAdapter = this.getMAdapter();
                    NobleCard selectNoble = mAdapter.getSelectNoble();
                    if (selectNoble != null && (isExclusive = selectNoble.isExclusive()) != null && isExclusive.intValue() == 1) {
                        HiloToasty.Companion companion = HiloToasty.Companion;
                        BaseActivity baseActivity = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131952639), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    SearchUserActivity.Companion companion2 = SearchUserActivity.Companion;
                    BaseActivity baseActivity2 = this;
                    com.google.gson.d dVar = new com.google.gson.d();
                    mAdapter2 = this.getMAdapter();
                    companion2.startActivity(baseActivity2, "SEND_CARD", dVar.s(mAdapter2.getSelectNoble()));
                }
            }
        });
        final TextView textView6 = ((ActivityAristocracyBagBinding) getBinding()).use;
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                AristocracyBagAdapter mAdapter;
                Integer num;
                AristocracyBagAdapter mAdapter2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView6) > j || (textView6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView6, currentTimeMillis);
                    TipTitleDialog tipTitleDialog = new TipTitleDialog(this);
                    String stringById = ResourcesKtxKt.getStringById(this, 2131952355);
                    mAdapter = this.getMAdapter();
                    NobleCard selectNoble = mAdapter.getSelectNoble();
                    Integer num2 = null;
                    if (selectNoble != null) {
                        num = selectNoble.getLevel();
                    } else {
                        num = null;
                    }
                    String str = "VIP" + num;
                    String stringById2 = ResourcesKtxKt.getStringById(this, 2131952502);
                    mAdapter2 = this.getMAdapter();
                    NobleCard selectNoble2 = mAdapter2.getSelectNoble();
                    if (selectNoble2 != null) {
                        num2 = selectNoble2.getDay();
                    }
                    String format = String.format(stringById2, Arrays.copyOf(new Object[]{num2}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    String format2 = String.format(stringById, Arrays.copyOf(new Object[]{str, format}, 2));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    TipTitleDialog tipColor = tipTitleDialog.setTitleContent(format2).setTipContent(ResourcesKtxKt.getStringById(this, 2131952187)).setTipColor(Color.parseColor("#ff5273"));
                    final AristocracyBagActivity aristocracyBagActivity = this;
                    tipColor.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.AristocracyBagActivity$initView$9$1
                        public void cancel() {
                            OnCommonDialogListener.DefaultImpls.cancel(this);
                        }

                        public void confirm() {
                            VipCardViewModel viewModel;
                            AristocracyBagAdapter mAdapter3;
                            int i;
                            Integer id2;
                            viewModel = AristocracyBagActivity.this.getViewModel();
                            mAdapter3 = AristocracyBagActivity.this.getMAdapter();
                            NobleCard selectNoble3 = mAdapter3.getSelectNoble();
                            if (selectNoble3 != null && (id2 = selectNoble3.getId()) != null) {
                                i = id2.intValue();
                            } else {
                                i = 0;
                            }
                            viewModel.useNobleCard(i);
                        }
                    }).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(AristocracyBagActivity aristocracyBagActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        aristocracyBagActivity.getViewModel().nobleCard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5(AristocracyBagActivity aristocracyBagActivity, int i, int i2) {
        aristocracyBagActivity.getBinding().titleBar.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(AristocracyBagActivity aristocracyBagActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        aristocracyBagActivity.getMAdapter().setSelectNoble((NobleCard) aristocracyBagActivity.getMAdapter().getData().get(i));
        aristocracyBagActivity.refreshView(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(AristocracyBagActivity aristocracyBagActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        aristocracyBagActivity.getViewModel().getNobleListData().resetPage();
        aristocracyBagActivity.getViewModel().nobleCard();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyBagAdapter mAdapter_delegate$lambda$0() {
        return new AristocracyBagAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VipCardViewModel viewModel_delegate$lambda$1() {
        return new VipCardViewModel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_aristocracy_bag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getViewModel().getNobleListData().destroy();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getViewModel().nobleCard();
    }

    @SuppressLint({"SetTextI18n"})
    public final void refreshView(int position) {
        String str;
        if (getMAdapter().getSelectNoble() != null) {
            getBinding().buttonLayout.setVisibility(0);
            TextView textView = getBinding().cardText;
            NobleCard selectNoble = getMAdapter().getSelectNoble();
            Integer num = null;
            if (selectNoble != null) {
                str = selectNoble.getName();
            } else {
                str = null;
            }
            NobleCard selectNoble2 = getMAdapter().getSelectNoble();
            if (selectNoble2 != null) {
                num = selectNoble2.getDay();
            }
            textView.setText(str + "/" + num + ResourcesKtxKt.getStringById(this, 2131952500));
        } else {
            getBinding().buttonLayout.setVisibility(8);
        }
        int selectPosition = getMAdapter().getSelectPosition();
        getMAdapter().setSelectPosition(position);
        AristocracyBagAdapter mAdapter = getMAdapter();
        Boolean bool = Boolean.TRUE;
        mAdapter.notifyItemChanged(selectPosition, bool);
        getMAdapter().notifyItemChanged(position, bool);
    }
}
