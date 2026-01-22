package com.qiahao.nextvideo.ui.transfer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.data.transfer.TransferCheckData;
import com.qiahao.nextvideo.databinding.ActivityTransferBinding;
import com.qiahao.nextvideo.ui.promoter.PromoterCenterActivity;
import com.qiahao.nextvideo.ui.webview.DefaultWebActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0007J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000bj\b\u0012\u0004\u0012\u00020\b`\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityTransferBinding;", "<init>", "()V", "mHasInvite", "", "mDiamondFragment", "Lcom/qiahao/nextvideo/ui/transfer/TransferFragment;", "mGemFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTypeList", "", "", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "mViewModel", "Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/TransferViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "onEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "initData", "initView", "onResume", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,293:1\n1#2:294\n61#3,9:295\n61#3,9:304\n61#3,9:313\n61#3,9:322\n61#3,9:331\n61#3,9:340\n61#3,9:349\n61#3,9:358\n61#3,9:367\n61#3,9:376\n61#3,9:385\n*S KotlinDebug\n*F\n+ 1 TransferActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferActivity\n*L\n202#1:295,9\n206#1:304,9\n212#1:313,9\n216#1:322,9\n220#1:331,9\n240#1:340,9\n244#1:349,9\n265#1:358,9\n269#1:367,9\n277#1:376,9\n281#1:385,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferActivity extends HiloBaseBindingActivity<ActivityTransferBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String HAS_INVITE = "HAS_INVITE";

    @Nullable
    private TransferFragment mDiamondFragment;

    @Nullable
    private TransferFragment mGemFragment;
    private boolean mHasInvite;

    @NotNull
    private ArrayList<TransferFragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131954307), ResourcesKtxKt.getStringById(this, 2131954308)};

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.s0
        public final Object invoke() {
            TransferViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = TransferActivity.mViewModel_delegate$lambda$0(TransferActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferActivity$Companion;", "", "<init>", "()V", TransferActivity.HAS_INVITE, "", "start", "", "context", "Landroid/content/Context;", "mHasInvite", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void start$default(Companion companion, Context context, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            companion.start(context, z);
        }

        public final void start(@NotNull Context context, boolean mHasInvite) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) TransferActivity.class);
            intent.putExtra(TransferActivity.HAS_INVITE, mHasInvite);
            context.startActivity(intent);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferViewModel getMViewModel() {
        return (TransferViewModel) this.mViewModel.getValue();
    }

    private final void initData() {
        getMViewModel().getTransferData().observe(this, new TransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.o0
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = TransferActivity.initData$lambda$3(TransferActivity.this, (DealerDetailBean) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getTransferCheck().observe(this, new TransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.p0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = TransferActivity.initData$lambda$4(TransferActivity.this, (TransferCheckData) obj);
                return initData$lambda$4;
            }
        }));
        getMViewModel().getTransferSuccess().observe(this, new TransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.q0
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = TransferActivity.initData$lambda$5(TransferActivity.this, (Boolean) obj);
                return initData$lambda$5;
            }
        }));
        getMViewModel().getError().observe(this, new TransferActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.r0
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = TransferActivity.initData$lambda$6(TransferActivity.this, (Throwable) obj);
                return initData$lambda$6;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(TransferActivity transferActivity, DealerDetailBean dealerDetailBean) {
        TransferFragment transferFragment;
        TransferFragment transferFragment2;
        if (dealerDetailBean == null) {
            return Unit.INSTANCE;
        }
        if (!dealerDetailBean.getIsdl()) {
            transferActivity.finish();
        }
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "availDiamond", Long.valueOf(dealerDetailBean.getAvailDiamond()), (String) null, 4, (Object) null);
        IStore.DefaultImpls.setValue$default(mMKVStore, "availPink", Long.valueOf(dealerDetailBean.getAvailDiamondPink()), (String) null, 4, (Object) null);
        ((ActivityTransferBinding) transferActivity.getBinding()).diamond.setText(String.valueOf(dealerDetailBean.getAvailDiamond()));
        ((ActivityTransferBinding) transferActivity.getBinding()).gem.setText(String.valueOf(dealerDetailBean.getAvailDiamondPink()));
        ArrayList<DealerDiamondConfig> config = dealerDetailBean.getConfig();
        if (config != null && (transferFragment2 = transferActivity.mDiamondFragment) != null) {
            transferFragment2.setListData(config);
        }
        ArrayList<DealerDiamondConfig> configPink = dealerDetailBean.getConfigPink();
        if (configPink != null && (transferFragment = transferActivity.mGemFragment) != null) {
            transferFragment.setListData(configPink);
        }
        if (dealerDetailBean.getHasPt()) {
            ((ActivityTransferBinding) transferActivity.getBinding()).promoter.setVisibility(0);
        }
        if (Intrinsics.areEqual(dealerDetailBean.getHasSecond(), Boolean.TRUE)) {
            ((ActivityTransferBinding) transferActivity.getBinding()).secondLayout.setVisibility(0);
            ((ActivityTransferBinding) transferActivity.getBinding()).diamondLayout.setBackground(androidx.core.content.a.getDrawable(transferActivity, R.drawable.transfer_user_bg_big));
        } else {
            ((ActivityTransferBinding) transferActivity.getBinding()).secondLayout.setVisibility(8);
            ((ActivityTransferBinding) transferActivity.getBinding()).diamondLayout.setBackground(androidx.core.content.a.getDrawable(transferActivity, 2131233562));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$4(TransferActivity transferActivity, TransferCheckData transferCheckData) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, transferActivity, ResourcesKtxKt.getStringById(transferActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$5(TransferActivity transferActivity, Boolean bool) {
        new TipDialog(transferActivity).hideCancel(true).setTipContent(ResourcesKtxKt.getStringById(transferActivity, 2131954177)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$6(TransferActivity transferActivity, Throwable th) {
        if (th instanceof HiloException) {
            TipDialog hideCancel = new TipDialog(transferActivity).hideCancel(true);
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(transferActivity, 2131952667);
            }
            hideCancel.setTipContent(errorMessage).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        int i;
        this.mHasInvite = getIntent().getBooleanExtra(HAS_INVITE, false);
        TextView textView = ((ActivityTransferBinding) getBinding()).transferInvite;
        if (this.mHasInvite) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        View view = ((ActivityTransferBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.l0
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$7;
                initView$lambda$7 = TransferActivity.initView$lambda$7(TransferActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$7;
            }
        });
        setStatusBarIconColor(false);
        ((ActivityTransferBinding) getBinding()).userBg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, this, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        if (this.mDiamondFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("transfer_type", 0);
            TransferFragment transferFragment = new TransferFragment();
            transferFragment.setArguments(bundle);
            transferFragment.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.m0
                public final Object invoke(Object obj) {
                    Unit initView$lambda$9$lambda$8;
                    initView$lambda$9$lambda$8 = TransferActivity.initView$lambda$9$lambda$8(TransferActivity.this, (DealerDiamondConfig) obj);
                    return initView$lambda$9$lambda$8;
                }
            });
            this.mDiamondFragment = transferFragment;
            this.mFragmentList.add(transferFragment);
        }
        if (this.mGemFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("transfer_type", 1);
            TransferFragment transferFragment2 = new TransferFragment();
            transferFragment2.setArguments(bundle2);
            transferFragment2.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.n0
                public final Object invoke(Object obj) {
                    Unit initView$lambda$12$lambda$11;
                    initView$lambda$12$lambda$11 = TransferActivity.initView$lambda$12$lambda$11(TransferActivity.this, (DealerDiamondConfig) obj);
                    return initView$lambda$12$lambda$11;
                }
            });
            this.mGemFragment = transferFragment2;
            this.mFragmentList.add(transferFragment2);
        }
        ViewPager viewPager = ((ActivityTransferBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        ((ActivityTransferBinding) getBinding()).tabLayout.l(((ActivityTransferBinding) getBinding()).viewPager, this.mTypeList);
        ((ActivityTransferBinding) getBinding()).tabLayout.setCurrentTab(0);
        ((ActivityTransferBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$6
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityTransferBinding binding;
                binding = TransferActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        ((ActivityTransferBinding) getBinding()).viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$7
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityTransferBinding binding;
                binding = TransferActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
            }
        });
        final AppCompatTextView appCompatTextView = ((ActivityTransferBinding) getBinding()).rechargeOtherId;
        final long j = 800;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatTextView) > j || (appCompatTextView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatTextView, currentTimeMillis);
                    AppCompatTextView appCompatTextView2 = appCompatTextView;
                    this.startActivity(new Intent((Context) this, (Class<?>) TransferSearchActivity.class));
                }
            }
        });
        final View view2 = ((ActivityTransferBinding) getBinding()).userBg;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TransferViewModel mViewModel;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(view2) > j || (view2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(view2, currentTimeMillis);
                    mViewModel = this.getMViewModel();
                    if (mViewModel.getMUser() == null) {
                        this.startActivity(new Intent((Context) this, (Class<?>) TransferSearchActivity.class));
                    }
                }
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityTransferBinding) getBinding()).promoter;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.startActivity(new Intent((Context) this, (Class<?>) PromoterCenterActivity.class));
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivityTransferBinding) getBinding()).detail;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.startActivity(new Intent((Context) this, (Class<?>) TransferRecordActivity.class));
                }
            }
        });
        final TextView textView2 = ((ActivityTransferBinding) getBinding()).buyDiamond;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TransferViewModel mViewModel;
                Integer level;
                TransferViewModel mViewModel2;
                User user;
                TransferViewModel mViewModel3;
                User plr;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    mViewModel = this.getMViewModel();
                    DealerDetailBean dealerDetailBean = (DealerDetailBean) mViewModel.getTransferData().getValue();
                    if (dealerDetailBean != null && (level = dealerDetailBean.getLevel()) != null && level.intValue() == 2) {
                        mViewModel2 = this.getMViewModel();
                        DealerDetailBean dealerDetailBean2 = (DealerDetailBean) mViewModel2.getTransferData().getValue();
                        String str = null;
                        if (dealerDetailBean2 != null) {
                            user = dealerDetailBean2.getPlr();
                        } else {
                            user = null;
                        }
                        if (user != null) {
                            TipDialog tipDialog = new TipDialog(this);
                            String stringById = ResourcesKtxKt.getStringById(this, 2131954016);
                            mViewModel3 = this.getMViewModel();
                            DealerDetailBean dealerDetailBean3 = (DealerDetailBean) mViewModel3.getTransferData().getValue();
                            if (dealerDetailBean3 != null && (plr = dealerDetailBean3.getPlr()) != null) {
                                str = plr.getCode();
                            }
                            String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            TipDialog tipContent = tipDialog.setTipContent(format);
                            final TransferActivity transferActivity = this;
                            tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$12$1
                                public void cancel() {
                                    OnCommonDialogListener.DefaultImpls.cancel(this);
                                }

                                public void confirm() {
                                    TransferViewModel mViewModel4;
                                    String str2;
                                    User plr2;
                                    AppService service = AppController.INSTANCE.getService();
                                    if (service != null) {
                                        mViewModel4 = TransferActivity.this.getMViewModel();
                                        DealerDetailBean dealerDetailBean4 = (DealerDetailBean) mViewModel4.getTransferData().getValue();
                                        if (dealerDetailBean4 == null || (plr2 = dealerDetailBean4.getPlr()) == null || (str2 = plr2.getExternalId()) == null) {
                                            str2 = "";
                                        }
                                        service.toChat(str2);
                                    }
                                }
                            }).show();
                            return;
                        }
                    }
                    MMKVStore mMKVStore = MMKVStore.INSTANCE;
                    String str2 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, "charge_url", "", (String) null, 4, (Object) null);
                    if (!TextUtils.isEmpty((CharSequence) IStore.DefaultImpls.getValue$default(mMKVStore, "charge_url", "", (String) null, 4, (Object) null))) {
                        DefaultWebActivity.Companion.start$default(DefaultWebActivity.INSTANCE, this, str2, null, 4, null);
                    }
                }
            }
        });
        final AppCompatImageView appCompatImageView3 = ((ActivityTransferBinding) getBinding()).backImageView;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    this.finish();
                }
            }
        });
        final TextView textView3 = ((ActivityTransferBinding) getBinding()).transferSendButton;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TransferViewModel mViewModel;
                TransferViewModel mViewModel2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView3) > j || (textView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView3, currentTimeMillis);
                    mViewModel = this.getMViewModel();
                    if (mViewModel.getMUser() != null) {
                        TipDialog tipDialog = new TipDialog(this);
                        String stringById = ResourcesKtxKt.getStringById(this, 2131952353);
                        mViewModel2 = this.getMViewModel();
                        User mUser = mViewModel2.getMUser();
                        if (mUser != null) {
                            str = mUser.getCode();
                        } else {
                            str = null;
                        }
                        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                        TipDialog tipContent = tipDialog.setTipContent(format);
                        final TransferActivity transferActivity = this;
                        tipContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$14$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                ActivityTransferBinding binding;
                                TransferViewModel mViewModel3;
                                TransferViewModel mViewModel4;
                                TransferViewModel mViewModel5;
                                String externalId;
                                TransferViewModel mViewModel6;
                                TransferViewModel mViewModel7;
                                TransferViewModel mViewModel8;
                                int i2;
                                String externalId2;
                                binding = TransferActivity.this.getBinding();
                                String str2 = "";
                                int i3 = 0;
                                if (binding.viewPager.getCurrentItem() == 0) {
                                    mViewModel6 = TransferActivity.this.getMViewModel();
                                    mViewModel7 = TransferActivity.this.getMViewModel();
                                    User mUser2 = mViewModel7.getMUser();
                                    if (mUser2 != null && (externalId2 = mUser2.getExternalId()) != null) {
                                        str2 = externalId2;
                                    }
                                    mViewModel8 = TransferActivity.this.getMViewModel();
                                    DealerDiamondConfig mDiamondSelect = mViewModel8.getMDiamondSelect();
                                    if (mDiamondSelect != null) {
                                        i2 = mDiamondSelect.getId();
                                    } else {
                                        i2 = 0;
                                    }
                                    mViewModel6.transferToUser(str2, i2, 0);
                                    return;
                                }
                                mViewModel3 = TransferActivity.this.getMViewModel();
                                mViewModel4 = TransferActivity.this.getMViewModel();
                                User mUser3 = mViewModel4.getMUser();
                                if (mUser3 != null && (externalId = mUser3.getExternalId()) != null) {
                                    str2 = externalId;
                                }
                                mViewModel5 = TransferActivity.this.getMViewModel();
                                DealerDiamondConfig mGemSelect = mViewModel5.getMGemSelect();
                                if (mGemSelect != null) {
                                    i3 = mGemSelect.getId();
                                }
                                mViewModel3.transferToUser(str2, i3, 1);
                            }
                        }).show();
                    }
                }
            }
        });
        final TextView textView4 = ((ActivityTransferBinding) getBinding()).agencyCenter;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView4) > j || (textView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView4, currentTimeMillis);
                    this.startActivity(new Intent((Context) this, (Class<?>) TransferCenterActivity.class));
                }
            }
        });
        final TextView textView5 = ((ActivityTransferBinding) getBinding()).transferInvite;
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TransferViewModel mViewModel;
                TransferViewModel mViewModel2;
                TransferViewModel mViewModel3;
                String str;
                ActivityTransferBinding binding;
                int i2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView5) > j || (textView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView5, currentTimeMillis);
                    mViewModel = this.getMViewModel();
                    if (mViewModel.getMUser() != null) {
                        mViewModel2 = this.getMViewModel();
                        mViewModel3 = this.getMViewModel();
                        User mUser = mViewModel3.getMUser();
                        if (mUser == null || (str = mUser.getExternalId()) == null) {
                            str = "";
                        }
                        binding = this.getBinding();
                        if (binding.viewPager.getCurrentItem() == 0) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        mViewModel2.checkTransferShare(str, i2);
                    }
                }
            }
        });
        final TextView textView6 = ((ActivityTransferBinding) getBinding()).secondLayout;
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView6) > j || (textView6 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView6, currentTimeMillis);
                    SecondTFActivity.Companion.startActivity(this);
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView = ((ActivityTransferBinding) getBinding()).avatar;
        qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferActivity$initView$$inlined$singleClick$default$11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TransferViewModel mViewModel;
                TransferViewModel mViewModel2;
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView2 = qMUIRadiusImageView;
                    mViewModel = this.getMViewModel();
                    if (mViewModel.getMUser() != null) {
                        AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
                        mViewModel2 = this.getMViewModel();
                        User mUser = mViewModel2.getMUser();
                        if (mUser != null) {
                            str = mUser.getExternalId();
                        } else {
                            str = null;
                        }
                        AppRequestUtils.openPersonPage$default(appRequestUtils, str, false, 2, null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$12$lambda$11(TransferActivity transferActivity, DealerDiamondConfig dealerDiamondConfig) {
        Intrinsics.checkNotNullParameter(dealerDiamondConfig, "it");
        transferActivity.getMViewModel().setMGemSelect(dealerDiamondConfig);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$7(TransferActivity transferActivity, int i, int i2) {
        transferActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9$lambda$8(TransferActivity transferActivity, DealerDiamondConfig dealerDiamondConfig) {
        Intrinsics.checkNotNullParameter(dealerDiamondConfig, "it");
        transferActivity.getMViewModel().setMDiamondSelect(dealerDiamondConfig);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferViewModel mViewModel_delegate$lambda$0(TransferActivity transferActivity) {
        return new ViewModelProvider(transferActivity).get(TransferViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_transfer;
    }

    @NotNull
    public final String[] getMTypeList() {
        return this.mTypeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull EventBusKey event) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "transfer_user") && (event.getData() instanceof User)) {
            TransferViewModel mViewModel = getMViewModel();
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.common.User");
            mViewModel.setMUser((User) data);
            ((ActivityTransferBinding) getBinding()).userGroup.setVisibility(0);
            ((ActivityTransferBinding) getBinding()).userGroupNo.setVisibility(8);
            QMUIRadiusImageView qMUIRadiusImageView = ((ActivityTransferBinding) getBinding()).avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            User mUser = getMViewModel().getMUser();
            String str3 = null;
            if (mUser != null) {
                str = mUser.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            NickTextView nickTextView = ((ActivityTransferBinding) getBinding()).nickName;
            User mUser2 = getMViewModel().getMUser();
            if (mUser2 == null || (str2 = mUser2.getNick()) == null) {
                str2 = "";
            }
            nickTextView.setText(str2);
            TextView textView = ((ActivityTransferBinding) getBinding()).userId;
            String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
            User mUser3 = getMViewModel().getMUser();
            if (mUser3 != null) {
                str3 = mUser3.getCode();
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            ((ActivityTransferBinding) getBinding()).transferSendButton.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.bg_btn_theme_radius22));
            ((ActivityTransferBinding) getBinding()).transferInvite.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.bg_btn_theme_radius22));
        }
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
        getMViewModel().m٩٣getTransferData();
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }
}
