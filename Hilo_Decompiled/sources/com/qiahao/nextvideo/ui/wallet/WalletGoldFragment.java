package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.e0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.GoldBanner;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.databinding.FragmentWalletGoldBinding;
import com.qiahao.nextvideo.ui.feedback.FeedbackActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010'\u001a\u00020(H\u0014J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020*H\u0002J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020*H\u0016J\b\u0010/\u001a\u00020*H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0017\u001a\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletGoldFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentWalletGoldBinding;", "<init>", "()V", "mBeanNumber", "", "mBillingRepository", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "getMBillingRepository", "()Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "setMBillingRepository", "(Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;)V", "isClickPlay", "", "()Z", "setClickPlay", "(Z)V", "listener", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "getListener", "()Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "listener$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/ui/wallet/WalletGoldAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/wallet/WalletGoldAdapter;", "adapter$delegate", "bannerAdapter", "Lcom/qiahao/nextvideo/ui/wallet/WalletGoldBannerAdapter;", "getBannerAdapter", "()Lcom/qiahao/nextvideo/ui/wallet/WalletGoldBannerAdapter;", "bannerAdapter$delegate", "viewModel", "Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onResume", "onPause", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWalletGoldFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WalletGoldFragment.kt\ncom/qiahao/nextvideo/ui/wallet/WalletGoldFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,231:1\n61#2,9:232\n1563#3:241\n1634#3,2:242\n1869#3,2:244\n1636#3:246\n*S KotlinDebug\n*F\n+ 1 WalletGoldFragment.kt\ncom/qiahao/nextvideo/ui/wallet/WalletGoldFragment\n*L\n185#1:232,9\n130#1:241\n130#1:242,2\n132#1:244,2\n130#1:246\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletGoldFragment extends BaseBindingFragment<FragmentWalletGoldBinding> {
    private boolean isClickPlay;
    private double mBeanNumber;

    @Nullable
    private BillingRepository mBillingRepository;

    /* renamed from: listener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy listener = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.d1
        public final Object invoke() {
            WalletGoldFragment$listener$2$1 listener_delegate$lambda$0;
            listener_delegate$lambda$0 = WalletGoldFragment.listener_delegate$lambda$0(WalletGoldFragment.this);
            return listener_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.e1
        public final Object invoke() {
            WalletGoldAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = WalletGoldFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* renamed from: bannerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bannerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.f1
        public final Object invoke() {
            WalletGoldBannerAdapter bannerAdapter_delegate$lambda$2;
            bannerAdapter_delegate$lambda$2 = WalletGoldFragment.bannerAdapter_delegate$lambda$2();
            return bannerAdapter_delegate$lambda$2;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.g1
        public final Object invoke() {
            WalletViewModel viewModel_delegate$lambda$3;
            viewModel_delegate$lambda$3 = WalletGoldFragment.viewModel_delegate$lambda$3(WalletGoldFragment.this);
            return viewModel_delegate$lambda$3;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletGoldAdapter adapter_delegate$lambda$1() {
        return new WalletGoldAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletGoldBannerAdapter bannerAdapter_delegate$lambda$2() {
        return new WalletGoldBannerAdapter();
    }

    private final WalletGoldAdapter getAdapter() {
        return (WalletGoldAdapter) this.adapter.getValue();
    }

    private final WalletGoldBannerAdapter getBannerAdapter() {
        return (WalletGoldBannerAdapter) this.bannerAdapter.getValue();
    }

    private final GooglePayConsumeListener getListener() {
        return (GooglePayConsumeListener) this.listener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WalletViewModel getViewModel() {
        return (WalletViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getGoldList().observe(this, new WalletGoldFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.z0
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = WalletGoldFragment.initData$lambda$6(WalletGoldFragment.this, (List) obj);
                return initData$lambda$6;
            }
        }));
        getViewModel().getGoldBanner().observe(this, new WalletGoldFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.a1
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = WalletGoldFragment.initData$lambda$7(WalletGoldFragment.this, (List) obj);
                return initData$lambda$7;
            }
        }));
        getViewModel().getCheckCharge().observe(this, new WalletGoldFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.b1
            public final Object invoke(Object obj) {
                Unit initData$lambda$10;
                initData$lambda$10 = WalletGoldFragment.initData$lambda$10(WalletGoldFragment.this, (CheckChargeData) obj);
                return initData$lambda$10;
            }
        }));
        getViewModel().getMException().observe(this, new WalletGoldFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.c1
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = WalletGoldFragment.initData$lambda$11(WalletGoldFragment.this, (Pair) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().getGoldRechargeList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$10(WalletGoldFragment walletGoldFragment, final CheckChargeData checkChargeData) {
        boolean z;
        BillingRepository billingRepository;
        String str;
        if (checkChargeData != null) {
            z = Intrinsics.areEqual(checkChargeData.getInWhiteList(), Boolean.TRUE);
        } else {
            z = false;
        }
        if (z && !TextUtils.isEmpty(checkChargeData.getChargeLink())) {
            final BaseActivity activity = HiloUtils.INSTANCE.getActivity(walletGoldFragment.getContext());
            if (activity != null) {
                new TipDialog(activity).setTipContent(ResourcesKtxKt.getStringById(walletGoldFragment, 2131952204)).setConfirmContent(ResourcesKtxKt.getStringById(walletGoldFragment, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletGoldFragment$initData$3$1$1
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
                        BaseActivity baseActivity = activity;
                        String chargeLink = checkChargeData.getChargeLink();
                        if (chargeLink == null) {
                            chargeLink = "";
                        }
                        DefaultWebActivity.Companion.start$default(companion, baseActivity, chargeLink, null, 4, null);
                    }
                }).show();
            }
        } else {
            BaseActivity activity2 = HiloUtils.INSTANCE.getActivity(walletGoldFragment.getContext());
            if (activity2 != null && (billingRepository = walletGoldFragment.mBillingRepository) != null) {
                PurchaseDiamondDetail selectData = walletGoldFragment.getViewModel().getSelectData();
                if (selectData == null || (str = selectData.getProductID()) == null) {
                    str = "";
                }
                BillingRepository.launchBillingFollow$default(billingRepository, activity2, str, null, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$11(WalletGoldFragment walletGoldFragment, Pair pair) {
        String str;
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = walletGoldFragment.getContext();
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(walletGoldFragment, 2131952667);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(WalletGoldFragment walletGoldFragment, List list) {
        Unit unit;
        List<com.android.billingclient.api.e0> skuDetailsList;
        String str;
        Intrinsics.checkNotNull(list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PurchaseDiamondDetail purchaseDiamondDetail = (PurchaseDiamondDetail) it.next();
            purchaseDiamondDetail.setShowPrice("USD " + purchaseDiamondDetail.getPrice());
            BillingRepository billingRepository = walletGoldFragment.mBillingRepository;
            if (billingRepository != null && (skuDetailsList = billingRepository.getSkuDetailsList()) != null) {
                for (com.android.billingclient.api.e0 e0Var : skuDetailsList) {
                    if (Intrinsics.areEqual(e0Var.b(), purchaseDiamondDetail.getProductID())) {
                        e0.b a = e0Var.a();
                        if (a == null || (str = a.a()) == null) {
                            str = "USD " + purchaseDiamondDetail.getPrice();
                        }
                        purchaseDiamondDetail.setShowPrice(str);
                    }
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            arrayList.add(unit);
        }
        walletGoldFragment.getAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$7(WalletGoldFragment walletGoldFragment, List list) {
        BannerViewPager bannerViewPager;
        BannerViewPager bannerViewPager2;
        BannerViewPager bannerViewPager3;
        if (list.isEmpty()) {
            FragmentWalletGoldBinding fragmentWalletGoldBinding = (FragmentWalletGoldBinding) walletGoldFragment.getBinding();
            if (fragmentWalletGoldBinding != null && (bannerViewPager3 = fragmentWalletGoldBinding.banner) != null) {
                bannerViewPager3.setVisibility(8);
            }
        } else {
            FragmentWalletGoldBinding fragmentWalletGoldBinding2 = (FragmentWalletGoldBinding) walletGoldFragment.getBinding();
            if (fragmentWalletGoldBinding2 != null && (bannerViewPager2 = fragmentWalletGoldBinding2.banner) != null) {
                bannerViewPager2.setVisibility(0);
            }
            FragmentWalletGoldBinding fragmentWalletGoldBinding3 = (FragmentWalletGoldBinding) walletGoldFragment.getBinding();
            if (fragmentWalletGoldBinding3 != null && (bannerViewPager = fragmentWalletGoldBinding3.banner) != null) {
                bannerViewPager.C(list);
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        double d;
        final BannerViewPager bannerViewPager;
        RecyclerView recyclerView;
        final AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        Double pinkDiamondNum;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (pinkDiamondNum = user.getPinkDiamondNum()) != null) {
            d = pinkDiamondNum.doubleValue();
        } else {
            d = 0.0d;
        }
        this.mBeanNumber = d;
        FragmentWalletGoldBinding fragmentWalletGoldBinding = (FragmentWalletGoldBinding) getBinding();
        if (fragmentWalletGoldBinding != null && (appCompatTextView2 = fragmentWalletGoldBinding.beansCountTickTextView) != null) {
            appCompatTextView2.setText(String.valueOf(MathKt.roundToLong(this.mBeanNumber)));
        }
        FragmentWalletGoldBinding fragmentWalletGoldBinding2 = (FragmentWalletGoldBinding) getBinding();
        if (fragmentWalletGoldBinding2 != null && (appCompatTextView = fragmentWalletGoldBinding2.contactUsTextView) != null) {
            final long j = 800;
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletGoldFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                        AppCompatTextView appCompatTextView3 = appCompatTextView;
                        this.startActivity(new Intent(this.getContext(), (Class<?>) FeedbackActivity.class));
                    }
                }
            });
        }
        FragmentWalletGoldBinding fragmentWalletGoldBinding3 = (FragmentWalletGoldBinding) getBinding();
        if (fragmentWalletGoldBinding3 != null && (recyclerView = fragmentWalletGoldBinding3.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.x0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                WalletGoldFragment.initView$lambda$13(WalletGoldFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentWalletGoldBinding fragmentWalletGoldBinding4 = (FragmentWalletGoldBinding) getBinding();
        if (fragmentWalletGoldBinding4 != null) {
            bannerViewPager = fragmentWalletGoldBinding4.banner;
        } else {
            bannerViewPager = null;
        }
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.GoldBanner>");
        bannerViewPager.G(getBannerAdapter());
        bannerViewPager.T(new BannerViewPager.b() { // from class: com.qiahao.nextvideo.ui.wallet.y0
            @Override // com.zhpan.bannerview.BannerViewPager.b
            public final void a(View view, int i) {
                WalletGoldFragment.initView$lambda$14(BannerViewPager.this, view, i);
            }
        });
        bannerViewPager.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$13(WalletGoldFragment walletGoldFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.isFastClick()) {
            return;
        }
        walletGoldFragment.getViewModel().checkWriteList((PurchaseDiamondDetail) walletGoldFragment.getAdapter().getData().get(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$14(BannerViewPager bannerViewPager, View view, int i) {
        NavigationHelper.jump$default(NavigationHelper.INSTANCE, ((GoldBanner) bannerViewPager.getData().get(i)).getJumpUrl(), (SuperCallBack) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletGoldFragment$listener$2$1 listener_delegate$lambda$0(WalletGoldFragment walletGoldFragment) {
        return new WalletGoldFragment$listener$2$1(walletGoldFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletViewModel viewModel_delegate$lambda$3(WalletGoldFragment walletGoldFragment) {
        return new ViewModelProvider(walletGoldFragment).get(WalletViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_wallet_gold;
    }

    @Nullable
    public final BillingRepository getMBillingRepository() {
        return this.mBillingRepository;
    }

    /* renamed from: isClickPlay, reason: from getter */
    public final boolean getIsClickPlay() {
        return this.isClickPlay;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        BillingRepository billingRepository = this.mBillingRepository;
        if (billingRepository != null) {
            billingRepository.release();
        }
        this.mBillingRepository = null;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onPause() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        if (!this.isClickPlay) {
            BillingRepository billingRepository = this.mBillingRepository;
            if (billingRepository != null) {
                billingRepository.release();
            }
            this.mBillingRepository = null;
        }
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        if (this.isClickPlay) {
            this.isClickPlay = false;
            return;
        }
        Context context = getContext();
        if (context != null) {
            BillingRepository billingRepository = new BillingRepository(context);
            billingRepository.setDelegate(getListener());
            billingRepository.startDataSourceConnections();
            this.mBillingRepository = billingRepository;
        }
    }

    public final void setClickPlay(boolean z) {
        this.isClickPlay = z;
    }

    public final void setMBillingRepository(@Nullable BillingRepository billingRepository) {
        this.mBillingRepository = billingRepository;
    }
}
