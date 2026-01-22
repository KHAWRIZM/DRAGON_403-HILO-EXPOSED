package com.qiahao.nextvideo.ui.wallet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.e0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserObjectEvent;
import com.qiahao.nextvideo.data.UserObjectEventType;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.firstCharge.ListData;
import com.qiahao.nextvideo.data.model.CheckChargeData;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.data.model.UserDiamonds;
import com.qiahao.nextvideo.databinding.FragmentWalletDiamondBinding;
import com.qiahao.nextvideo.ui.feedback.FeedbackActivity;
import com.qiahao.nextvideo.ui.firstCharge.FirstChargeDialog;
import com.qiahao.nextvideo.ui.purchase.DiamondCellUIModel;
import com.qiahao.nextvideo.ui.purchase.WalletDiamondAdapter;
import com.qiahao.nextvideo.ui.reusable.views.DiamondTickTextView;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.google.pay.BillingRepository;
import com.qiahao.nextvideo.utilities.google.pay.GooglePayConsumeListener;
import java.util.ArrayList;
import java.util.Arrays;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020 H\u0003J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020 H\u0016J\b\u0010&\u001a\u00020 H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletDiamondFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentWalletDiamondBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/wallet/WalletViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mBillingRepository", "Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "getMBillingRepository", "()Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;", "setMBillingRepository", "(Lcom/qiahao/nextvideo/utilities/google/pay/BillingRepository;)V", "isClickPlay", "", "()Z", "setClickPlay", "(Z)V", "adapter", "Lcom/qiahao/nextvideo/ui/purchase/WalletDiamondAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/purchase/WalletDiamondAdapter;", "adapter$delegate", "mGooglePayListener", "Lcom/qiahao/nextvideo/utilities/google/pay/GooglePayConsumeListener;", "getLayoutResId", "", "onInitialize", "", "initView", "initData", "initRecyclerView", "onResume", "onPause", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWalletDiamondFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WalletDiamondFragment.kt\ncom/qiahao/nextvideo/ui/wallet/WalletDiamondFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,332:1\n61#2,9:333\n61#2,9:342\n61#2,9:351\n61#2,9:360\n1563#3:369\n1634#3,2:370\n1869#3,2:372\n1636#3:374\n1869#3,2:375\n1878#3,3:377\n1#4:380\n*S KotlinDebug\n*F\n+ 1 WalletDiamondFragment.kt\ncom/qiahao/nextvideo/ui/wallet/WalletDiamondFragment\n*L\n112#1:333,9\n117#1:342,9\n120#1:351,9\n143#1:360,9\n172#1:369\n172#1:370,2\n175#1:372,2\n172#1:374\n194#1:375,2\n278#1:377,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletDiamondFragment extends BaseBindingFragment<FragmentWalletDiamondBinding> {
    private boolean isClickPlay;

    @Nullable
    private BillingRepository mBillingRepository;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.s0
        public final Object invoke() {
            WalletViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = WalletDiamondFragment.viewModel_delegate$lambda$0(WalletDiamondFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.t0
        public final Object invoke() {
            WalletDiamondAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = WalletDiamondFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    @NotNull
    private final GooglePayConsumeListener mGooglePayListener = new WalletDiamondFragment$mGooglePayListener$1(this);

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletDiamondAdapter adapter_delegate$lambda$1() {
        return new WalletDiamondAdapter();
    }

    private final WalletDiamondAdapter getAdapter() {
        return (WalletDiamondAdapter) this.adapter.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        getViewModel().getDiamondList().observe(this, new WalletDiamondFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.o0
            public final Object invoke(Object obj) {
                Unit initData$lambda$14;
                initData$lambda$14 = WalletDiamondFragment.initData$lambda$14(WalletDiamondFragment.this, (List) obj);
                return initData$lambda$14;
            }
        }));
        getViewModel().getMSuccess().observe(this, new WalletDiamondFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.p0
            public final Object invoke(Object obj) {
                Unit initData$lambda$20;
                initData$lambda$20 = WalletDiamondFragment.initData$lambda$20(WalletDiamondFragment.this, (Pair) obj);
                return initData$lambda$20;
            }
        }));
        getViewModel().getMException().observe(this, new WalletDiamondFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.q0
            public final Object invoke(Object obj) {
                Unit initData$lambda$22;
                initData$lambda$22 = WalletDiamondFragment.initData$lambda$22(WalletDiamondFragment.this, (Pair) obj);
                return initData$lambda$22;
            }
        }));
        getViewModel().getFirstCharge().observe(this, new WalletDiamondFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.r0
            public final Object invoke(Object obj) {
                Unit initData$lambda$27;
                initData$lambda$27 = WalletDiamondFragment.initData$lambda$27(WalletDiamondFragment.this, (ListData) obj);
                return initData$lambda$27;
            }
        }));
        nd.c subscribe = UserStore.INSTANCE.getShared().getUserObjectRelay().filter(new pd.q() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initData$5
            public final boolean test(UserObjectEvent userObjectEvent) {
                return userObjectEvent.isAuthenticated() && (userObjectEvent.getType() == UserObjectEventType.REFRESH || userObjectEvent.getType() == UserObjectEventType.REFRESH_MONEY);
            }
        }).observeOn(RxUtilsKt.getMainThread()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initData$6
            public final void accept(UserObjectEvent userObjectEvent) {
                DiamondTickTextView diamondTickTextView;
                FragmentWalletDiamondBinding fragmentWalletDiamondBinding = (FragmentWalletDiamondBinding) WalletDiamondFragment.this.getBinding();
                if (fragmentWalletDiamondBinding == null || (diamondTickTextView = fragmentWalletDiamondBinding.diamondCountTickTextView) == null) {
                    return;
                }
                User user = userObjectEvent.getUser();
                diamondTickTextView.setText(user != null ? (long) user.getDiamondNum() : 0L);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, getViewModel().getMCompositeDisposable());
        getViewModel().refreshDiamond();
        getViewModel().vipList();
        getViewModel().m٩٦getDiamondList();
        getViewModel().getFirstRechargeAward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$14(WalletDiamondFragment walletDiamondFragment, List list) {
        BillingRepository billingRepository;
        List<com.android.billingclient.api.e0> skuDetailsList;
        String str;
        Intrinsics.checkNotNull(list);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DiamondCellUIModel diamondCellUIModel = (DiamondCellUIModel) it.next();
            diamondCellUIModel.setPrice("USD " + diamondCellUIModel.getPrice());
            Unit unit = null;
            if (walletDiamondFragment.getContext() != null && (billingRepository = walletDiamondFragment.mBillingRepository) != null && (skuDetailsList = billingRepository.getSkuDetailsList()) != null) {
                for (com.android.billingclient.api.e0 e0Var : skuDetailsList) {
                    if (Intrinsics.areEqual(e0Var.b(), diamondCellUIModel.getProductID())) {
                        e0.b a = e0Var.a();
                        if (a == null || (str = a.a()) == null) {
                            str = "USD " + diamondCellUIModel.getPrice();
                        }
                        diamondCellUIModel.setPrice(str);
                    }
                }
                unit = Unit.INSTANCE;
            }
            arrayList.add(unit);
        }
        walletDiamondFragment.getAdapter().setList(list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$20(WalletDiamondFragment walletDiamondFragment, Pair pair) {
        TextView textView;
        BillingRepository billingRepository;
        List<com.android.billingclient.api.e0> skuSubsDetailsList;
        List d;
        e0.e eVar;
        e0.d b;
        List a;
        e0.c cVar;
        BillingRepository billingRepository2;
        DiamondTickTextView diamondTickTextView;
        String str;
        String str2 = (String) pair.getFirst();
        int hashCode = str2.hashCode();
        if (hashCode != -1992485984) {
            if (hashCode != -1678803421) {
                if (hashCode == -525768777 && str2.equals(WalletViewModel.CHECK_WRITE) && (pair.getSecond() instanceof CheckChargeData)) {
                    Object second = pair.getSecond();
                    Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.CheckChargeData");
                    final CheckChargeData checkChargeData = (CheckChargeData) second;
                    final Context context = walletDiamondFragment.getContext();
                    if (context != null) {
                        if (Intrinsics.areEqual(checkChargeData.getInWhiteList(), Boolean.TRUE) && !TextUtils.isEmpty(checkChargeData.getChargeLink())) {
                            new TipDialog(context).setTipContent(ResourcesKtxKt.getStringById(walletDiamondFragment, 2131952204)).setConfirmContent(ResourcesKtxKt.getStringById(walletDiamondFragment, 2131952331)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initData$2$3$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    DefaultWebActivity.Companion companion = DefaultWebActivity.INSTANCE;
                                    Context context2 = context;
                                    String chargeLink = checkChargeData.getChargeLink();
                                    if (chargeLink == null) {
                                        chargeLink = "";
                                    }
                                    DefaultWebActivity.Companion.start$default(companion, context2, chargeLink, null, 4, null);
                                }
                            }).show();
                        } else {
                            BaseActivity activity = HiloUtils.INSTANCE.getActivity(context);
                            if (activity != null) {
                                walletDiamondFragment.isClickPlay = true;
                                BillingRepository billingRepository3 = walletDiamondFragment.mBillingRepository;
                                if (billingRepository3 != null) {
                                    DiamondCellUIModel selectUiModel = walletDiamondFragment.getViewModel().getSelectUiModel();
                                    if (selectUiModel == null || (str = selectUiModel.getProductID()) == null) {
                                        str = "";
                                    }
                                    BillingRepository.launchBillingFollow$default(billingRepository3, activity, str, null, 4, null);
                                }
                            }
                        }
                    }
                }
            } else if (str2.equals(WalletViewModel.PURCHASE_DIAMONDS_SUCCESS) && (pair.getSecond() instanceof UserDiamonds)) {
                Object second2 = pair.getSecond();
                Intrinsics.checkNotNull(second2, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.UserDiamonds");
                UserDiamonds userDiamonds = (UserDiamonds) second2;
                FragmentWalletDiamondBinding fragmentWalletDiamondBinding = (FragmentWalletDiamondBinding) walletDiamondFragment.getBinding();
                if (fragmentWalletDiamondBinding != null && (diamondTickTextView = fragmentWalletDiamondBinding.diamondCountTickTextView) != null) {
                    diamondTickTextView.setText((long) userDiamonds.getUserDiamonds());
                }
                UserStore.refreshDiamondOrGem$default(UserStore.INSTANCE.getShared(), userDiamonds.getUserDiamonds(), 0.0d, 2, null);
                cf.c.c().l(new EventBusKey("refresh_h5", (Object) null, 2, (DefaultConstructorMarker) null));
                Purchase mPurchase = walletDiamondFragment.getViewModel().getMPurchase();
                if (mPurchase != null && (billingRepository2 = walletDiamondFragment.mBillingRepository) != null) {
                    billingRepository2.handleServerVerifiedOrder(mPurchase);
                }
            }
        } else if (str2.equals(WalletViewModel.VIP_LIST) && (pair.getSecond() instanceof PurchaseDiamondDetail)) {
            Object second3 = pair.getSecond();
            Intrinsics.checkNotNull(second3, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.PurchaseDiamondDetail");
            PurchaseDiamondDetail purchaseDiamondDetail = (PurchaseDiamondDetail) second3;
            String str3 = "USD " + purchaseDiamondDetail.getPrice();
            if (walletDiamondFragment.getContext() != null && (billingRepository = walletDiamondFragment.mBillingRepository) != null && (skuSubsDetailsList = billingRepository.getSkuSubsDetailsList()) != null) {
                for (com.android.billingclient.api.e0 e0Var : skuSubsDetailsList) {
                    if (Intrinsics.areEqual(e0Var.b(), purchaseDiamondDetail.getProductID()) && ((d = e0Var.d()) == null || (eVar = (e0.e) d.get(0)) == null || (b = eVar.b()) == null || (a = b.a()) == null || (cVar = (e0.c) a.get(0)) == null || (str3 = cVar.a()) == null)) {
                        str3 = "USD " + purchaseDiamondDetail.getPrice();
                    }
                }
            }
            FragmentWalletDiamondBinding fragmentWalletDiamondBinding2 = (FragmentWalletDiamondBinding) walletDiamondFragment.getBinding();
            if (fragmentWalletDiamondBinding2 != null && (textView = fragmentWalletDiamondBinding2.purchaseVip) != null) {
                textView.setText(((Object) str3) + "/" + ResourcesKtxKt.getStringById(walletDiamondFragment, 2131953580));
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$22(WalletDiamondFragment walletDiamondFragment, Pair pair) {
        String str;
        BillingRepository billingRepository;
        if (pair.getSecond() instanceof HiloException) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloException hiloException = (HiloException) second;
            if (hiloException.getCode() == 6000) {
                Purchase mPurchase = walletDiamondFragment.getViewModel().getMPurchase();
                if (mPurchase != null && (billingRepository = walletDiamondFragment.mBillingRepository) != null) {
                    billingRepository.handleServerVerifiedOrder(mPurchase);
                }
            } else {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = walletDiamondFragment.getContext();
                String errorMessage = hiloException.getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(walletDiamondFragment, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        } else {
            Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, walletDiamondFragment.getContext(), ResourcesKtxKt.getStringById(walletDiamondFragment, 2131952667), false, 4, (Object) null);
            if (normal$default2 != null) {
                normal$default2.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$27(final WalletDiamondFragment walletDiamondFragment, ListData listData) {
        ArrayList list;
        Context context;
        if (listData != null && (list = listData.getList()) != null && (!list.isEmpty()) && (context = walletDiamondFragment.getContext()) != null) {
            FirstChargeDialog firstChargeDialog = new FirstChargeDialog(listData.getList(), true, context);
            firstChargeDialog.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.u0
                public final Object invoke(Object obj) {
                    Unit initData$lambda$27$lambda$26$lambda$25$lambda$24;
                    initData$lambda$27$lambda$26$lambda$25$lambda$24 = WalletDiamondFragment.initData$lambda$27$lambda$26$lambda$25$lambda$24(WalletDiamondFragment.this, (String) obj);
                    return initData$lambda$27$lambda$26$lambda$25$lambda$24;
                }
            });
            firstChargeDialog.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$27$lambda$26$lambda$25$lambda$24(WalletDiamondFragment walletDiamondFragment, String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        int i = 0;
        for (Object obj : walletDiamondFragment.getAdapter().getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (Intrinsics.areEqual(((DiamondCellUIModel) obj).getProductID(), str)) {
                walletDiamondFragment.getViewModel().checkWriteList(i);
            }
            i = i2;
        }
        return Unit.INSTANCE;
    }

    private final void initRecyclerView() {
        RecyclerView recyclerView;
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding != null && (recyclerView = fragmentWalletDiamondBinding.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
    }

    private final void initView() {
        final TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        final LinearLayout linearLayout3;
        final LinearLayout linearLayout4;
        DiamondTickTextView diamondTickTextView;
        long j;
        final AppCompatTextView appCompatTextView;
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding = (FragmentWalletDiamondBinding) getBinding();
        final long j2 = 800;
        if (fragmentWalletDiamondBinding != null && (appCompatTextView = fragmentWalletDiamondBinding.contactUsTextView) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j2 || (appCompatTextView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                        AppCompatTextView appCompatTextView2 = appCompatTextView;
                        this.startActivity(new Intent(this.getContext(), (Class<?>) FeedbackActivity.class));
                    }
                }
            });
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding2 = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding2 != null && (diamondTickTextView = fragmentWalletDiamondBinding2.diamondCountTickTextView) != null) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                j = (long) user.getDiamondNum();
            } else {
                j = 0;
            }
            diamondTickTextView.setText(j);
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding3 = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding3 != null && (linearLayout4 = fragmentWalletDiamondBinding3.rechargeAgent) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout4) > j2 || (linearLayout4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout4, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            RechargeListActivity.Companion.start(context);
                        }
                    }
                }
            });
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding4 = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding4 != null && (linearLayout3 = fragmentWalletDiamondBinding4.chargeAgent) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout3) > j2 || (linearLayout3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout3, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, context, (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "charge_url", "", (String) null, 4, (Object) null), null, 4, null);
                        }
                    }
                }
            });
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding5 = (FragmentWalletDiamondBinding) getBinding();
        int i2 = 8;
        if (fragmentWalletDiamondBinding5 != null && (linearLayout2 = fragmentWalletDiamondBinding5.rechargeAgent) != null) {
            if (((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "vc_allow", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue()) {
                i = 0;
            } else {
                i = 8;
            }
            linearLayout2.setVisibility(i);
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding6 = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding6 != null && (linearLayout = fragmentWalletDiamondBinding6.chargeAgent) != null) {
            if (!TextUtils.isEmpty((CharSequence) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "charge_url", "", (String) null, 4, (Object) null))) {
                i2 = 0;
            }
            linearLayout.setVisibility(i2);
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding7 = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding7 != null && (textView2 = fragmentWalletDiamondBinding7.vipContent) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952612), Arrays.copyOf(new Object[]{AgooConstants.ACK_PACK_NULL}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
        }
        FragmentWalletDiamondBinding fragmentWalletDiamondBinding8 = (FragmentWalletDiamondBinding) getBinding();
        if (fragmentWalletDiamondBinding8 != null && (textView = fragmentWalletDiamondBinding8.purchaseVip) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initView$$inlined$singleClick$default$4
                /* JADX WARN: Type inference failed for: r0v4, types: [android.app.Dialog, com.qiahao.nextvideo.ui.vip.VipViewDialog] */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j2 || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            BillingRepository mBillingRepository = this.getMBillingRepository();
                            if (mBillingRepository != null) {
                                mBillingRepository.release();
                            }
                            this.setMBillingRepository(null);
                            ?? vipViewDialog = new VipViewDialog(0, context, 1, null);
                            final WalletDiamondFragment walletDiamondFragment = this;
                            vipViewDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletDiamondFragment$initView$4$1$1
                                @Override // android.content.DialogInterface.OnDismissListener
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    GooglePayConsumeListener googlePayConsumeListener;
                                    Context context2 = WalletDiamondFragment.this.getContext();
                                    if (context2 != null) {
                                        WalletDiamondFragment walletDiamondFragment2 = WalletDiamondFragment.this;
                                        BillingRepository billingRepository = new BillingRepository(context2);
                                        googlePayConsumeListener = walletDiamondFragment2.mGooglePayListener;
                                        billingRepository.setDelegate(googlePayConsumeListener);
                                        billingRepository.startDataSourceConnections();
                                        walletDiamondFragment2.setMBillingRepository(billingRepository);
                                    }
                                }
                            });
                            vipViewDialog.show();
                        }
                    }
                }
            });
        }
        getAdapter().addChildClickViewIds(new int[]{R.id.diamondPriceText});
        getAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.m0
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                WalletDiamondFragment.initView$lambda$9(WalletDiamondFragment.this, baseQuickAdapter, view, i3);
            }
        });
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.n0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i3) {
                WalletDiamondFragment.initView$lambda$10(WalletDiamondFragment.this, baseQuickAdapter, view, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(WalletDiamondFragment walletDiamondFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        walletDiamondFragment.getViewModel().checkWriteList(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(WalletDiamondFragment walletDiamondFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        walletDiamondFragment.getViewModel().checkWriteList(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WalletViewModel viewModel_delegate$lambda$0(WalletDiamondFragment walletDiamondFragment) {
        return new ViewModelProvider(walletDiamondFragment).get(WalletViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_wallet_diamond;
    }

    @Nullable
    public final BillingRepository getMBillingRepository() {
        return this.mBillingRepository;
    }

    @NotNull
    public final WalletViewModel getViewModel() {
        return (WalletViewModel) this.viewModel.getValue();
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
        initRecyclerView();
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
            billingRepository.setDelegate(this.mGooglePayListener);
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
