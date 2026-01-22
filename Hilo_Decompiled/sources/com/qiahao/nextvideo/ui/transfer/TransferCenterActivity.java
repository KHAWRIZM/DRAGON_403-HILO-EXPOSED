package com.qiahao.nextvideo.ui.transfer;

import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityTransferCenterBinding;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferCenterActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityTransferCenterBinding;", "<init>", "()V", "mDiamondFragment", "Lcom/qiahao/nextvideo/ui/transfer/TransferCenterFragment;", "mGemFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLayoutResId", "", "onInitialize", "", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferCenterActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferCenterActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferCenterActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,76:1\n1#2:77\n61#3,9:78\n*S KotlinDebug\n*F\n+ 1 TransferCenterActivity.kt\ncom/qiahao/nextvideo/ui/transfer/TransferCenterActivity\n*L\n71#1:78,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferCenterActivity extends HiloBaseBindingActivity<ActivityTransferCenterBinding> {

    @Nullable
    private TransferCenterFragment mDiamondFragment;

    @NotNull
    private ArrayList<TransferCenterFragment> mFragmentList = new ArrayList<>();

    @Nullable
    private TransferCenterFragment mGemFragment;

    private final void initView() {
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.transfer.t0
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$0;
                initView$lambda$0 = TransferCenterActivity.initView$lambda$0(TransferCenterActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        if (this.mDiamondFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putString(TransferCenterFragment.CENTER_TYPE, TransferCenterFragment.TYPE_DIAMONDS);
            TransferCenterFragment transferCenterFragment = new TransferCenterFragment();
            transferCenterFragment.setArguments(bundle);
            this.mDiamondFragment = transferCenterFragment;
            this.mFragmentList.add(transferCenterFragment);
        }
        if (this.mGemFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(TransferCenterFragment.CENTER_TYPE, TransferCenterFragment.TYPE_GOLDS);
            TransferCenterFragment transferCenterFragment2 = new TransferCenterFragment();
            transferCenterFragment2.setArguments(bundle2);
            this.mGemFragment = transferCenterFragment2;
            this.mFragmentList.add(transferCenterFragment2);
        }
        getBinding().viewPager.setOffscreenPageLimit(2);
        getBinding().viewPager.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.transfer.TransferCenterActivity$initView$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(TransferCenterActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = TransferCenterActivity.this.mFragmentList;
                Object obj = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = TransferCenterActivity.this.mFragmentList;
                return arrayList.size();
            }
        });
        ViewPage2TabLayout viewPage2TabLayout = getBinding().tabLayout;
        ViewPager2 viewPager2 = getBinding().viewPager;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPager");
        viewPage2TabLayout.setViewPager2(viewPager2, new TransferTitleAdapter());
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.transfer.TransferCenterActivity$initView$$inlined$singleClick$default$1
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
    public static final Unit initView$lambda$0(TransferCenterActivity transferCenterActivity, int i, int i2) {
        transferCenterActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_transfer_center;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }
}
