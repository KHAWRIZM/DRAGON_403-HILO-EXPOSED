package com.qiahao.nextvideo.ui.wallet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.ActivityExchangeDetailBinding;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0017R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/ExchangeDetailActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityExchangeDetailBinding;", "<init>", "()V", "getLayoutResId", "", "mAdapter", "Lcom/qiahao/nextvideo/ui/wallet/ExchangeDetailAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/wallet/ExchangeDetailAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/wallet/ExchangeViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/wallet/ExchangeViewModel;", "viewModel$delegate", "onInitialize", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nExchangeDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExchangeDetailActivity.kt\ncom/qiahao/nextvideo/ui/wallet/ExchangeDetailActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n61#2,9:112\n1#3:121\n*S KotlinDebug\n*F\n+ 1 ExchangeDetailActivity.kt\ncom/qiahao/nextvideo/ui/wallet/ExchangeDetailActivity\n*L\n77#1:112,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ExchangeDetailActivity extends HiloBaseBindingActivity<ActivityExchangeDetailBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TYPE_BEANS = "beans";

    @NotNull
    public static final String TYPE_COINS = "coins";

    @NotNull
    public static final String TYPE_DIAMOND = "diamond";

    @NotNull
    public static final String TYPE_EXCHANGE = "type";

    @NotNull
    public static final String TYPE_RECHARGE = "recharge";

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.f
        public final Object invoke() {
            ExchangeDetailAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = ExchangeDetailActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.g
        public final Object invoke() {
            ExchangeViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = ExchangeDetailActivity.viewModel_delegate$lambda$1(ExchangeDetailActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/ExchangeDetailActivity$Companion;", "", "<init>", "()V", "TYPE_DIAMOND", "", "TYPE_BEANS", "TYPE_RECHARGE", "TYPE_COINS", "TYPE_EXCHANGE", "start", "", "context", "Landroid/content/Context;", "type", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context, @NotNull String type) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intent intent = new Intent(context, (Class<?>) ExchangeDetailActivity.class);
            intent.putExtra("type", type);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    private final ExchangeDetailAdapter getMAdapter() {
        return (ExchangeDetailAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ExchangeViewModel getViewModel() {
        return (ExchangeViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExchangeDetailAdapter mAdapter_delegate$lambda$0() {
        return new ExchangeDetailAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$2(ExchangeDetailActivity exchangeDetailActivity, int i, int i2) {
        exchangeDetailActivity.getBinding().titleLayout.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(ExchangeDetailActivity exchangeDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        exchangeDetailActivity.getViewModel().getExchangeData().resetPage();
        exchangeDetailActivity.getViewModel().getList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(ExchangeDetailActivity exchangeDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        exchangeDetailActivity.getViewModel().getList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(ExchangeDetailActivity exchangeDetailActivity, List list) {
        if (exchangeDetailActivity.getViewModel().getExchangeData().isOnePage()) {
            exchangeDetailActivity.getMAdapter().setList(list);
        } else if (list != null) {
            exchangeDetailActivity.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExchangeViewModel viewModel_delegate$lambda$1(ExchangeDetailActivity exchangeDetailActivity) {
        return new ViewModelProvider(exchangeDetailActivity).get(ExchangeViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_exchange_detail;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    @SuppressLint({"SetTextI18n"})
    public void onInitialize() {
        String str;
        super.onInitialize();
        ExchangeViewModel viewModel = getViewModel();
        String stringExtra = getIntent().getStringExtra("type");
        if (stringExtra == null) {
            stringExtra = TYPE_DIAMOND;
        }
        viewModel.setExchangeType(stringExtra);
        String exchangeType = getViewModel().getExchangeType();
        switch (exchangeType.hashCode()) {
            case -806191449:
                if (exchangeType.equals(TYPE_RECHARGE)) {
                    AppCompatTextView appCompatTextView = ((ActivityExchangeDetailBinding) getBinding()).titleLayout.title;
                    String stringById = ResourcesKtxKt.getStringById(this, 2131953857);
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user != null) {
                        str = user.getCode();
                    } else {
                        str = null;
                    }
                    appCompatTextView.setText(stringById + "(" + str + ")");
                    break;
                }
                break;
            case 93610691:
                if (exchangeType.equals(TYPE_BEANS)) {
                    ((ActivityExchangeDetailBinding) getBinding()).titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131952098));
                    break;
                }
                break;
            case 94839810:
                if (exchangeType.equals(TYPE_COINS)) {
                    ((ActivityExchangeDetailBinding) getBinding()).titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131952277));
                    break;
                }
                break;
            case 1655054676:
                if (exchangeType.equals(TYPE_DIAMOND)) {
                    ((ActivityExchangeDetailBinding) getBinding()).titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131952560));
                    break;
                }
                break;
        }
        View view = ((ActivityExchangeDetailBinding) getBinding()).titleLayout.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.wallet.b
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$2;
                onInitialize$lambda$2 = ExchangeDetailActivity.onInitialize$lambda$2(ExchangeDetailActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$2;
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityExchangeDetailBinding) getBinding()).titleLayout.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity$onInitialize$$inlined$singleClick$default$1
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
        ((ActivityExchangeDetailBinding) getBinding()).activityMainContainer.setBackgroundColor(androidx.core.content.a.getColor(this, 2131101214));
        ((ActivityExchangeDetailBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ActivityExchangeDetailBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        getViewModel().getExchangeData().registerStatusLayoutAndRefreshLayout(((ActivityExchangeDetailBinding) getBinding()).refreshLayout, ((ActivityExchangeDetailBinding) getBinding()).statusView);
        ((ActivityExchangeDetailBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.wallet.c
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                ExchangeDetailActivity.onInitialize$lambda$4(ExchangeDetailActivity.this, fVar);
            }
        });
        ((ActivityExchangeDetailBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.wallet.d
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                ExchangeDetailActivity.onInitialize$lambda$5(ExchangeDetailActivity.this, fVar);
            }
        });
        ((ActivityExchangeDetailBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity$onInitialize$5
            public void onRetry(IStatusView statusView, Status status) {
                ExchangeViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel2 = ExchangeDetailActivity.this.getViewModel();
                viewModel2.getList();
            }
        });
        getViewModel().getExchangeList().observe(this, new ExchangeDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.e
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = ExchangeDetailActivity.onInitialize$lambda$7(ExchangeDetailActivity.this, (List) obj);
                return onInitialize$lambda$7;
            }
        }));
        getViewModel().getList();
    }
}
