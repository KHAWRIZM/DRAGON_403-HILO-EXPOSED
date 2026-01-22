package com.qiahao.nextvideo.ui.promoter;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.promote.PromoteMonth;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.databinding.ActivityPromoterCenterBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.ArrayList;
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
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0003J\b\u0010\u0016\u001a\u00020\u0014H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityPromoterCenterBinding;", "<init>", "()V", "mWeekFragment", "Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterFragment;", "mMonthFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mViewModel", "Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/promoter/PromoterCenterViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPromoterCenterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PromoterCenterActivity.kt\ncom/qiahao/nextvideo/ui/promoter/PromoterCenterActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,128:1\n61#2,9:129\n1#3:138\n1869#4,2:139\n*S KotlinDebug\n*F\n+ 1 PromoterCenterActivity.kt\ncom/qiahao/nextvideo/ui/promoter/PromoterCenterActivity\n*L\n70#1:129,9\n49#1:139,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PromoterCenterActivity extends HiloBaseBindingActivity<ActivityPromoterCenterBinding> {

    @Nullable
    private PromoterCenterFragment mMonthFragment;

    @Nullable
    private PromoterCenterFragment mWeekFragment;

    @NotNull
    private ArrayList<PromoterCenterFragment> mFragmentList = new ArrayList<>();

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.promoter.k
        public final Object invoke() {
            PromoterCenterViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = PromoterCenterActivity.mViewModel_delegate$lambda$0(PromoterCenterActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    private final PromoterCenterViewModel getMViewModel() {
        return (PromoterCenterViewModel) this.mViewModel.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        getMViewModel().getPeriod().observe(this, new PromoterCenterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.l
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = PromoterCenterActivity.initData$lambda$3(PromoterCenterActivity.this, (TransferPeriod) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getTransferMonth().observe(this, new PromoterCenterActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.promoter.m
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = PromoterCenterActivity.initData$lambda$4(PromoterCenterActivity.this, (PromoteMonth) obj);
                return initData$lambda$4;
            }
        }));
        getMViewModel().transferPeriod();
        getMViewModel().transferMonth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(PromoterCenterActivity promoterCenterActivity, TransferPeriod transferPeriod) {
        for (PromoterCenterFragment promoterCenterFragment : promoterCenterActivity.mFragmentList) {
            if (transferPeriod != null) {
                promoterCenterFragment.refreshPeriodData(transferPeriod);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(PromoterCenterActivity promoterCenterActivity, PromoteMonth promoteMonth) {
        Integer num;
        long j;
        Long totalC;
        TextView textView = promoterCenterActivity.getBinding().team.number;
        Integer num2 = null;
        if (promoteMonth != null) {
            num = promoteMonth.getPtNum();
        } else {
            num = null;
        }
        textView.setText(String.valueOf(num));
        TextView textView2 = promoterCenterActivity.getBinding().number.number;
        if (promoteMonth != null) {
            num2 = promoteMonth.getClients();
        }
        textView2.setText(String.valueOf(num2));
        TextView textView3 = promoterCenterActivity.getBinding().rechargeAmount.number;
        if (promoteMonth != null && (totalC = promoteMonth.getTotalC()) != null) {
            j = totalC.longValue();
        } else {
            j = 0;
        }
        textView3.setText("$" + NumberUtilsKt.rankNumberFormat(j / 100));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityPromoterCenterBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.promoter.j
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$5;
                initView$lambda$5 = PromoterCenterActivity.initView$lambda$5(PromoterCenterActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$5;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = ((ActivityPromoterCenterBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterCenterActivity$initView$$inlined$singleClick$default$1
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
        ((ActivityPromoterCenterBinding) getBinding()).team.title.setText(ResourcesKtxKt.getStringById(this, 2131954237));
        ((ActivityPromoterCenterBinding) getBinding()).number.title.setText(ResourcesKtxKt.getStringById(this, 2131953562));
        ((ActivityPromoterCenterBinding) getBinding()).rechargeAmount.title.setText(ResourcesKtxKt.getStringById(this, 2131953856));
        View view2 = ((ActivityPromoterCenterBinding) getBinding()).thisView;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        view2.setBackground(shapeUtil.createShape("#8850f6", "#b043ff", 4, GradientDrawable.Orientation.TOP_BOTTOM));
        ((ActivityPromoterCenterBinding) getBinding()).monthBg.setBackground(ShapeUtil.createShape$default(shapeUtil, this, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        if (this.mWeekFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(PromoterCenterFragment.PROMOTER_TYPE, 0);
            PromoterCenterFragment promoterCenterFragment = new PromoterCenterFragment();
            promoterCenterFragment.setArguments(bundle);
            this.mWeekFragment = promoterCenterFragment;
            this.mFragmentList.add(promoterCenterFragment);
        }
        if (this.mMonthFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt(PromoterCenterFragment.PROMOTER_TYPE, 1);
            PromoterCenterFragment promoterCenterFragment2 = new PromoterCenterFragment();
            promoterCenterFragment2.setArguments(bundle2);
            this.mMonthFragment = promoterCenterFragment2;
            this.mFragmentList.add(promoterCenterFragment2);
        }
        ((ActivityPromoterCenterBinding) getBinding()).viewPager.setOffscreenPageLimit(2);
        ViewPager viewPager = ((ActivityPromoterCenterBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        ((ActivityPromoterCenterBinding) getBinding()).tabLayout.l(((ActivityPromoterCenterBinding) getBinding()).viewPager, new String[]{ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)});
        ((ActivityPromoterCenterBinding) getBinding()).tabLayout.setCurrentTab(0);
        ((ActivityPromoterCenterBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterCenterActivity$initView$7
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityPromoterCenterBinding binding;
                binding = PromoterCenterActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        ((ActivityPromoterCenterBinding) getBinding()).viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.promoter.PromoterCenterActivity$initView$8
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityPromoterCenterBinding binding;
                binding = PromoterCenterActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5(PromoterCenterActivity promoterCenterActivity, int i, int i2) {
        promoterCenterActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PromoterCenterViewModel mViewModel_delegate$lambda$0(PromoterCenterActivity promoterCenterActivity) {
        return new ViewModelProvider(promoterCenterActivity).get(PromoterCenterViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_promoter_center;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
