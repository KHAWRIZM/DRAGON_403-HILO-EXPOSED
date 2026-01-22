package com.qiahao.nextvideo.ui.transfer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.databinding.ActivitySecondTfBinding;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTFActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivitySecondTfBinding;", "<init>", "()V", "mFragmentList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/transfer/SecondTFFragment;", "Lkotlin/collections/ArrayList;", "mWeekFragment", "mMonthFragment", "mViewModel", "Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/SecondViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSecondTFActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SecondTFActivity.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTFActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,125:1\n61#2,9:126\n61#2,9:135\n1#3:144\n*S KotlinDebug\n*F\n+ 1 SecondTFActivity.kt\ncom/qiahao/nextvideo/ui/transfer/SecondTFActivity\n*L\n68#1:126,9\n71#1:135,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondTFActivity extends HiloBaseBindingActivity<ActivitySecondTfBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private SecondTFFragment mMonthFragment;

    @Nullable
    private SecondTFFragment mWeekFragment;

    @NotNull
    private ArrayList<SecondTFFragment> mFragmentList = new ArrayList<>();

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.b
        public final Object invoke() {
            SecondViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = SecondTFActivity.mViewModel_delegate$lambda$0(SecondTFActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondTFActivity$Companion;", "", "<init>", "()V", "startActivity", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startActivity(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) SecondTFActivity.class));
        }

        private Companion() {
        }
    }

    private final SecondViewModel getMViewModel() {
        return (SecondViewModel) this.mViewModel.getValue();
    }

    private final void initData() {
        getMViewModel().getPeriod().observe(this, new SecondTFActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.a
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = SecondTFActivity.initData$lambda$2(SecondTFActivity.this, (TransferPeriod) obj);
                return initData$lambda$2;
            }
        }));
        getMViewModel().secondPeriod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(SecondTFActivity secondTFActivity, TransferPeriod transferPeriod) {
        SecondTFFragment secondTFFragment = secondTFActivity.mWeekFragment;
        if (secondTFFragment != null) {
            secondTFFragment.refreshPeriodData(transferPeriod);
        }
        SecondTFFragment secondTFFragment2 = secondTFActivity.mMonthFragment;
        if (secondTFFragment2 != null) {
            secondTFFragment2.refreshPeriodData(transferPeriod);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTFActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = getBinding().detail;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTFActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    SecondTfDiamondActivity.Companion.startActivity(this);
                }
            }
        });
        if (this.mWeekFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("transfer_type", 0);
            SecondTFFragment secondTFFragment = new SecondTFFragment();
            secondTFFragment.setArguments(bundle);
            this.mWeekFragment = secondTFFragment;
            this.mFragmentList.add(secondTFFragment);
        }
        if (this.mMonthFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("transfer_type", 1);
            SecondTFFragment secondTFFragment2 = new SecondTFFragment();
            secondTFFragment2.setArguments(bundle2);
            this.mMonthFragment = secondTFFragment2;
            this.mFragmentList.add(secondTFFragment2);
        }
        getBinding().viewPager.setOffscreenPageLimit(2);
        ViewPager viewPager = getBinding().viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        getBinding().tabLayout.l(getBinding().viewPager, new String[]{ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)});
        getBinding().tabLayout.setCurrentTab(0);
        getBinding().tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTFActivity$initView$7
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivitySecondTfBinding binding;
                binding = SecondTFActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        getBinding().viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.transfer.SecondTFActivity$initView$8
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivitySecondTfBinding binding;
                binding = SecondTFActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SecondViewModel mViewModel_delegate$lambda$0(SecondTFActivity secondTFActivity) {
        return new ViewModelProvider(secondTFActivity).get(SecondViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$1(SecondTFActivity secondTFActivity, int i, int i2) {
        secondTFActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_second_tf;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.c
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$1;
                onInitialize$lambda$1 = SecondTFActivity.onInitialize$lambda$1(SecondTFActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$1;
            }
        });
        setStatusBarIconColor(false);
        initView();
        initData();
    }
}
