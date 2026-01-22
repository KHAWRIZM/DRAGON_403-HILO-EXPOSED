package com.qiahao.nextvideo.ui.promoter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
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
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DealerDetailBean;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.data.promote.PromoteData;
import com.qiahao.nextvideo.data.transfer.TransferCheckData;
import com.qiahao.nextvideo.databinding.ActivityPromoterBinding;
import com.qiahao.nextvideo.ui.transfer.TransferFragment;
import com.qiahao.nextvideo.ui.transfer.TransferSearchActivity;
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

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityPromoterBinding;", "<init>", "()V", "mDiamondFragment", "Lcom/qiahao/nextvideo/ui/transfer/TransferFragment;", "mGemFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mTypeList", "", "", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "mViewModel", "Lcom/qiahao/nextvideo/ui/promoter/PromoterViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/promoter/PromoterViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "onEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "initData", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPromoterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PromoterActivity.kt\ncom/qiahao/nextvideo/ui/promoter/PromoterActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,215:1\n1#2:216\n61#3,9:217\n61#3,9:226\n61#3,9:235\n61#3,9:244\n61#3,9:253\n61#3,9:262\n61#3,9:271\n*S KotlinDebug\n*F\n+ 1 PromoterActivity.kt\ncom/qiahao/nextvideo/ui/promoter/PromoterActivity\n*L\n181#1:217,9\n185#1:226,9\n191#1:235,9\n195#1:244,9\n200#1:253,9\n205#1:262,9\n209#1:271,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PromoterActivity extends HiloBaseBindingActivity<ActivityPromoterBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String PROMOTE_DATA = "promote_data";

    @Nullable
    private TransferFragment mDiamondFragment;

    @Nullable
    private TransferFragment mGemFragment;

    @NotNull
    private ArrayList<TransferFragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131954307), ResourcesKtxKt.getStringById(this, 2131954308)};

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.promoter.d
        public final Object invoke() {
            PromoterViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = PromoterActivity.mViewModel_delegate$lambda$0(PromoterActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterActivity$Companion;", "", "<init>", "()V", "PROMOTE_DATA", "", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PromoterActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PromoterViewModel getMViewModel() {
        return (PromoterViewModel) this.mViewModel.getValue();
    }

    private final void initData() {
        getMViewModel().getTransferData().observe(this, new PromoterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.e
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = PromoterActivity.initData$lambda$3(PromoterActivity.this, (DealerDetailBean) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getPromoteData().observe(this, new PromoterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = PromoterActivity.initData$lambda$5(PromoterActivity.this, (PromoteData) obj);
                return initData$lambda$5;
            }
        }));
        getMViewModel().getTransferCheck().observe(this, new PromoterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.g
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = PromoterActivity.initData$lambda$6(PromoterActivity.this, (TransferCheckData) obj);
                return initData$lambda$6;
            }
        }));
        getMViewModel().getTransferSuccess().observe(this, new PromoterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.h
            public final Object invoke(Object obj) {
                Unit initData$lambda$7;
                initData$lambda$7 = PromoterActivity.initData$lambda$7(PromoterActivity.this, (Boolean) obj);
                return initData$lambda$7;
            }
        }));
        getMViewModel().getError().observe(this, new PromoterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.i
            public final Object invoke(Object obj) {
                Unit initData$lambda$8;
                initData$lambda$8 = PromoterActivity.initData$lambda$8(PromoterActivity.this, (Throwable) obj);
                return initData$lambda$8;
            }
        }));
        getMViewModel().m٨٠getTransferData();
        getMViewModel().m٧٩getPromoteData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(PromoterActivity promoterActivity, DealerDetailBean dealerDetailBean) {
        TransferFragment transferFragment;
        TransferFragment transferFragment2;
        if (dealerDetailBean == null) {
            return Unit.INSTANCE;
        }
        UserStore.INSTANCE.getShared().refreshDiamondOrGem(dealerDetailBean.getAvailDiamond(), dealerDetailBean.getAvailDiamondPink());
        ArrayList<DealerDiamondConfig> config = dealerDetailBean.getConfig();
        if (config != null && (transferFragment2 = promoterActivity.mDiamondFragment) != null) {
            transferFragment2.setListData(config);
        }
        ArrayList<DealerDiamondConfig> configPink = dealerDetailBean.getConfigPink();
        if (configPink != null && (transferFragment = promoterActivity.mGemFragment) != null) {
            transferFragment.setListData(configPink);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(PromoterActivity promoterActivity, PromoteData promoteData) {
        User dl;
        if (promoteData != null && (dl = promoteData.getDl()) != null) {
            QMUIRadiusImageView qMUIRadiusImageView = promoterActivity.getBinding().leaderAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leaderAvatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(dl.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            promoterActivity.getBinding().leaderName.setText(dl.getNick());
            TextView textView = promoterActivity.getBinding().leaderID;
            String format = String.format(ResourcesKtxKt.getStringById(promoterActivity, 2131953102), Arrays.copyOf(new Object[]{dl.getCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$6(PromoterActivity promoterActivity, TransferCheckData transferCheckData) {
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, promoterActivity, ResourcesKtxKt.getStringById(promoterActivity, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$7(PromoterActivity promoterActivity, Boolean bool) {
        new TipDialog(promoterActivity).hideCancel(true).setTipContent(ResourcesKtxKt.getStringById(promoterActivity, 2131954177)).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$8(PromoterActivity promoterActivity, Throwable th) {
        if (th instanceof HiloException) {
            TipDialog hideCancel = new TipDialog(promoterActivity).hideCancel(true);
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(promoterActivity, 2131952667);
            }
            hideCancel.setTipContent(errorMessage).show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityPromoterBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.promoter.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$9;
                initView$lambda$9 = PromoterActivity.initView$lambda$9(PromoterActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$9;
            }
        });
        ((ActivityPromoterBinding) getBinding()).userBg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, this, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        if (this.mDiamondFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("transfer_type", 0);
            TransferFragment transferFragment = new TransferFragment();
            transferFragment.setArguments(bundle);
            transferFragment.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.b
                public final Object invoke(Object obj) {
                    Unit initView$lambda$11$lambda$10;
                    initView$lambda$11$lambda$10 = PromoterActivity.initView$lambda$11$lambda$10(PromoterActivity.this, (DealerDiamondConfig) obj);
                    return initView$lambda$11$lambda$10;
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
            transferFragment2.setMListener(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.c
                public final Object invoke(Object obj) {
                    Unit initView$lambda$14$lambda$13;
                    initView$lambda$14$lambda$13 = PromoterActivity.initView$lambda$14$lambda$13(PromoterActivity.this, (DealerDiamondConfig) obj);
                    return initView$lambda$14$lambda$13;
                }
            });
            this.mGemFragment = transferFragment2;
            this.mFragmentList.add(transferFragment2);
        }
        ViewPager viewPager = ((ActivityPromoterBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        ((ActivityPromoterBinding) getBinding()).tabLayout.l(((ActivityPromoterBinding) getBinding()).viewPager, this.mTypeList);
        ((ActivityPromoterBinding) getBinding()).tabLayout.setCurrentTab(0);
        ((ActivityPromoterBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$6
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityPromoterBinding binding;
                binding = PromoterActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        ((ActivityPromoterBinding) getBinding()).viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$7
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityPromoterBinding binding;
                binding = PromoterActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
            }
        });
        final AppCompatTextView appCompatTextView = ((ActivityPromoterBinding) getBinding()).rechargeOtherId;
        final long j = 800;
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$1
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
        final View view2 = ((ActivityPromoterBinding) getBinding()).userBg;
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PromoterViewModel mViewModel;
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
        final AppCompatImageView appCompatImageView = ((ActivityPromoterBinding) getBinding()).backImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final TextView textView = ((ActivityPromoterBinding) getBinding()).transferInvite;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PromoterViewModel mViewModel;
                PromoterViewModel mViewModel2;
                PromoterViewModel mViewModel3;
                String str;
                ActivityPromoterBinding binding;
                int i;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
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
                            i = 0;
                        } else {
                            i = 1;
                        }
                        mViewModel2.checkTransferShare(str, i);
                    }
                }
            }
        });
        final QMUIRadiusImageView qMUIRadiusImageView = ((ActivityPromoterBinding) getBinding()).avatar;
        qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PromoterViewModel mViewModel;
                PromoterViewModel mViewModel2;
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
        final QMUIRadiusImageView qMUIRadiusImageView2 = ((ActivityPromoterBinding) getBinding()).leaderAvatar;
        qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PromoterViewModel mViewModel;
                String str;
                User dl;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                    QMUIRadiusImageView qMUIRadiusImageView3 = qMUIRadiusImageView2;
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        mViewModel = this.getMViewModel();
                        PromoteData promoteData = (PromoteData) mViewModel.getPromoteData().getValue();
                        if (promoteData == null || (dl = promoteData.getDl()) == null || (str = dl.getExternalId()) == null) {
                            str = "";
                        }
                        service.openPersonPage(str);
                    }
                }
            }
        });
        final TextView textView2 = ((ActivityPromoterBinding) getBinding()).connect;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterActivity$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                PromoterViewModel mViewModel;
                String str;
                User dl;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                    AppService service = AppController.INSTANCE.getService();
                    if (service != null) {
                        mViewModel = this.getMViewModel();
                        PromoteData promoteData = (PromoteData) mViewModel.getPromoteData().getValue();
                        if (promoteData == null || (dl = promoteData.getDl()) == null || (str = dl.getExternalId()) == null) {
                            str = "";
                        }
                        service.toChat(str);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$11$lambda$10(PromoterActivity promoterActivity, DealerDiamondConfig dealerDiamondConfig) {
        Intrinsics.checkNotNullParameter(dealerDiamondConfig, "it");
        promoterActivity.getMViewModel().setMDiamondSelect(dealerDiamondConfig);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$14$lambda$13(PromoterActivity promoterActivity, DealerDiamondConfig dealerDiamondConfig) {
        Intrinsics.checkNotNullParameter(dealerDiamondConfig, "it");
        promoterActivity.getMViewModel().setMGemSelect(dealerDiamondConfig);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9(PromoterActivity promoterActivity, int i, int i2) {
        promoterActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PromoterViewModel mViewModel_delegate$lambda$0(PromoterActivity promoterActivity) {
        return new ViewModelProvider(promoterActivity).get(PromoterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_promoter;
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
            PromoterViewModel mViewModel = getMViewModel();
            Object data = event.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.base_common.model.common.User");
            mViewModel.setMUser((User) data);
            ((ActivityPromoterBinding) getBinding()).userGroup.setVisibility(0);
            ((ActivityPromoterBinding) getBinding()).userGroupNo.setVisibility(8);
            QMUIRadiusImageView qMUIRadiusImageView = ((ActivityPromoterBinding) getBinding()).avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            User mUser = getMViewModel().getMUser();
            String str3 = null;
            if (mUser != null) {
                str = mUser.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            NickTextView nickTextView = ((ActivityPromoterBinding) getBinding()).nickName;
            User mUser2 = getMViewModel().getMUser();
            if (mUser2 == null || (str2 = mUser2.getNick()) == null) {
                str2 = "";
            }
            nickTextView.setText(str2);
            TextView textView = ((ActivityPromoterBinding) getBinding()).userId;
            String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
            User mUser3 = getMViewModel().getMUser();
            if (mUser3 != null) {
                str3 = mUser3.getCode();
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            ((ActivityPromoterBinding) getBinding()).transferInvite.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.bg_btn_theme_radius22));
        }
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }
}
