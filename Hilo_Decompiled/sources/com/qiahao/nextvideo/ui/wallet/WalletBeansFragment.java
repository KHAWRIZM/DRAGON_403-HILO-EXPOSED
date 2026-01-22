package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.FragmentWalletBeansBinding;
import com.qiahao.nextvideo.ui.wallet.ExchangeDiamondsActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletBeansFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentWalletBeansBinding;", "<init>", "()V", "mBeanNumber", "", "getLayoutResId", "", "viewModel", "Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onInitialize", "", "onBeanEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "onResume", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWalletBeansFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WalletBeansFragment.kt\ncom/qiahao/nextvideo/ui/wallet/WalletBeansFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,56:1\n61#2,9:57\n*S KotlinDebug\n*F\n+ 1 WalletBeansFragment.kt\ncom/qiahao/nextvideo/ui/wallet/WalletBeansFragment\n*L\n33#1:57,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletBeansFragment extends BaseBindingFragment<FragmentWalletBeansBinding> {
    private double mBeanNumber;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.l0
        public final Object invoke() {
            WalletViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = WalletBeansFragment.viewModel_delegate$lambda$0(WalletBeansFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    private final WalletViewModel getViewModel() {
        return (WalletViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(WalletBeansFragment walletBeansFragment, Double d) {
        AppCompatTextView appCompatTextView;
        walletBeansFragment.mBeanNumber = d.doubleValue();
        FragmentWalletBeansBinding fragmentWalletBeansBinding = (FragmentWalletBeansBinding) walletBeansFragment.getBinding();
        if (fragmentWalletBeansBinding != null && (appCompatTextView = fragmentWalletBeansBinding.beansCountTickTextView) != null) {
            appCompatTextView.setText(String.valueOf((int) walletBeansFragment.mBeanNumber));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletViewModel viewModel_delegate$lambda$0(WalletBeansFragment walletBeansFragment) {
        return new ViewModelProvider(walletBeansFragment).get(WalletViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_wallet_beans;
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onBeanEvent(@NotNull EventBusKey event) {
        Double d;
        double d2;
        AppCompatTextView appCompatTextView;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "REFRESH_EXCHANGE")) {
            Object data = event.getData();
            if (data instanceof Double) {
                d = (Double) data;
            } else {
                d = null;
            }
            if (d != null) {
                d2 = d.doubleValue();
            } else {
                d2 = 0.0d;
            }
            this.mBeanNumber = d2;
            FragmentWalletBeansBinding fragmentWalletBeansBinding = (FragmentWalletBeansBinding) getBinding();
            if (fragmentWalletBeansBinding != null && (appCompatTextView = fragmentWalletBeansBinding.beansCountTickTextView) != null) {
                appCompatTextView.setText(String.valueOf((int) this.mBeanNumber));
            }
        }
    }

    public void onInitialize() {
        final TextView textView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        getViewModel().getBaseGold().observe(this, new WalletBeansFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.k0
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = WalletBeansFragment.onInitialize$lambda$1(WalletBeansFragment.this, (Double) obj);
                return onInitialize$lambda$1;
            }
        }));
        FragmentWalletBeansBinding fragmentWalletBeansBinding = (FragmentWalletBeansBinding) getBinding();
        if (fragmentWalletBeansBinding != null && (textView = fragmentWalletBeansBinding.exchangeDiamonds) != null) {
            final long j = 800;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletBeansFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    double d;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            ExchangeDiamondsActivity.Companion companion = ExchangeDiamondsActivity.Companion;
                            d = this.mBeanNumber;
                            companion.start(context, d);
                        }
                    }
                }
            });
        }
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        getViewModel().m٩٥getBaseGold();
    }
}
