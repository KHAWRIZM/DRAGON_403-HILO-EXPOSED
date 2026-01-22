package com.qiahao.nextvideo.ui.transfer;

import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityTransferRecordBinding;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0014J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR*\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferRecordActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityTransferRecordBinding;", "<init>", "()V", "mDiamondFragment", "Lcom/qiahao/nextvideo/ui/transfer/TransferRecordFragment;", "getMDiamondFragment", "()Lcom/qiahao/nextvideo/ui/transfer/TransferRecordFragment;", "setMDiamondFragment", "(Lcom/qiahao/nextvideo/ui/transfer/TransferRecordFragment;)V", "mGemFragment", "getMGemFragment", "setMGemFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMFragmentList", "()Ljava/util/ArrayList;", "setMFragmentList", "(Ljava/util/ArrayList;)V", "mTypeList", "", "", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getLayoutResId", "", "onInitialize", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferRecordActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferRecordActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferRecordActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,95:1\n1#2:96\n61#3,9:97\n*S KotlinDebug\n*F\n+ 1 TransferRecordActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferRecordActivity\n*L\n89#1:97,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferRecordActivity extends HiloBaseBindingActivity<ActivityTransferRecordBinding> {

    @Nullable
    private TransferRecordFragment mDiamondFragment;

    @Nullable
    private TransferRecordFragment mGemFragment;

    @NotNull
    private ArrayList<TransferRecordFragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131952567), ResourcesKtxKt.getStringById(this, 2131952860)};

    private final void initView() {
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.t1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = TransferRecordActivity.initView$lambda$0(TransferRecordActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        if (this.mDiamondFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("transfer_type", 0);
            TransferRecordFragment transferRecordFragment = new TransferRecordFragment();
            transferRecordFragment.setArguments(bundle);
            this.mDiamondFragment = transferRecordFragment;
            this.mFragmentList.add(transferRecordFragment);
        }
        if (this.mGemFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("transfer_type", 1);
            TransferRecordFragment transferRecordFragment2 = new TransferRecordFragment();
            transferRecordFragment2.setArguments(bundle2);
            this.mGemFragment = transferRecordFragment2;
            this.mFragmentList.add(transferRecordFragment2);
        }
        ViewPager viewPager = getBinding().viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        getBinding().tabLayout.l(getBinding().viewPager, this.mTypeList);
        getBinding().tabLayout.setCurrentTab(0);
        getBinding().tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.transfer.TransferRecordActivity$initView$6
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityTransferRecordBinding binding;
                binding = TransferRecordActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        getBinding().viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.transfer.TransferRecordActivity$initView$7
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityTransferRecordBinding binding;
                binding = TransferRecordActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
            }
        });
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferRecordActivity$initView$$inlined$singleClick$default$1
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$0(TransferRecordActivity transferRecordActivity, int i, int i2) {
        transferRecordActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_transfer_record;
    }

    @Nullable
    public final TransferRecordFragment getMDiamondFragment() {
        return this.mDiamondFragment;
    }

    @NotNull
    public final ArrayList<TransferRecordFragment> getMFragmentList() {
        return this.mFragmentList;
    }

    @Nullable
    public final TransferRecordFragment getMGemFragment() {
        return this.mGemFragment;
    }

    @NotNull
    public final String[] getMTypeList() {
        return this.mTypeList;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    public final void setMDiamondFragment(@Nullable TransferRecordFragment transferRecordFragment) {
        this.mDiamondFragment = transferRecordFragment;
    }

    public final void setMFragmentList(@NotNull ArrayList<TransferRecordFragment> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mFragmentList = arrayList;
    }

    public final void setMGemFragment(@Nullable TransferRecordFragment transferRecordFragment) {
        this.mGemFragment = transferRecordFragment;
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }
}
