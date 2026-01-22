package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.databinding.ActivityWalletBinding;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fR\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0006j\b\u0012\u0004\u0012\u00020\n`\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityWalletBinding;", "<init>", "()V", "mTypeList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "mFragments", "Landroidx/fragment/app/Fragment;", "getLayoutResId", "", "onInitialize", "", "refreshSelect", "position", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nWalletActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WalletActivity.kt\ncom/qiahao/nextvideo/ui/wallet/WalletActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,124:1\n61#2,9:125\n61#2,9:134\n*S KotlinDebug\n*F\n+ 1 WalletActivity.kt\ncom/qiahao/nextvideo/ui/wallet/WalletActivity\n*L\n46#1:125,9\n49#1:134,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletActivity extends HiloBaseBindingActivity<ActivityWalletBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private ArrayList<String> mTypeList = new ArrayList<>();

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) WalletActivity.class));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$0(WalletActivity walletActivity, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = walletActivity.getBinding().bar.getLayoutParams();
        layoutParams.height = i;
        walletActivity.getBinding().bar.setLayoutParams(layoutParams);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_wallet;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        View view = getBinding().bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.wallet.j0
            public final Object invoke(Object obj, Object obj2) {
                Unit onInitialize$lambda$0;
                onInitialize$lambda$0 = WalletActivity.onInitialize$lambda$0(WalletActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return onInitialize$lambda$0;
            }
        });
        setStatusBarIconColor(false);
        final AppCompatImageView appCompatImageView = getBinding().backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletActivity$onInitialize$$inlined$singleClick$default$1
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
        final AppCompatImageView appCompatImageView2 = getBinding().endImage;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.WalletActivity$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    BillActivity.INSTANCE.start(this);
                }
            }
        });
        this.mTypeList.clear();
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952567));
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952458));
        this.mTypeList.add(ResourcesKtxKt.getStringById(this, 2131952924));
        if (this.mFragments.isEmpty()) {
            this.mFragments.add(new WalletDiamondFragment());
            this.mFragments.add(new WalletBeansFragment());
            this.mFragments.add(new WalletGoldFragment());
        }
        getBinding().viewPage.setAdapter(new androidx.viewpager2.adapter.a() { // from class: com.qiahao.nextvideo.ui.wallet.WalletActivity$onInitialize$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(WalletActivity.this);
            }

            public Fragment createFragment(int position) {
                ArrayList arrayList;
                arrayList = WalletActivity.this.mFragments;
                Object obj = arrayList.get(position);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                return (Fragment) obj;
            }

            public int getItemCount() {
                ArrayList arrayList;
                arrayList = WalletActivity.this.mFragments;
                return arrayList.size();
            }
        });
        getBinding().viewPage.setOffscreenPageLimit(3);
        getBinding().viewPage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.qiahao.nextvideo.ui.wallet.WalletActivity$onInitialize$5
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                WalletActivity.this.refreshSelect(position);
            }
        });
        getBinding().tabLayout.setReSetTab(true);
        ViewPage2TabLayout viewPage2TabLayout = getBinding().tabLayout;
        ViewPager2 viewPager2 = getBinding().viewPage;
        Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPage");
        viewPage2TabLayout.setViewPager2(viewPager2, new WalletTabLayoutAdapter(this.mTypeList));
        getBinding().tabLayout.addOnTabSelectedListener(new TabLayout.d() { // from class: com.qiahao.nextvideo.ui.wallet.WalletActivity$onInitialize$6
            public void onTabReselected(TabLayout.f tab) {
            }

            public void onTabSelected(TabLayout.f tab) {
                int i;
                WalletActivity walletActivity = WalletActivity.this;
                if (tab != null) {
                    i = tab.g();
                } else {
                    i = 0;
                }
                walletActivity.refreshSelect(i);
            }

            public void onTabUnselected(TabLayout.f tab) {
            }
        });
        refreshSelect(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void refreshSelect(int position) {
        boolean z;
        if (position != 0) {
            z = true;
        } else {
            z = false;
        }
        setStatusBarIconColor(z);
        if (position == 0) {
            ((ActivityWalletBinding) getBinding()).bgContent.setBackground(androidx.core.content.a.getDrawable(this, R.drawable.bg_purchase_diamond));
            AppCompatImageView appCompatImageView = ((ActivityWalletBinding) getBinding()).endImage;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "endImage");
            ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.wallet_record_w), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ((ActivityWalletBinding) getBinding()).backImageView.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityWalletBinding) getBinding()).getRoot().getContext(), 2131232457));
            return;
        }
        ((ActivityWalletBinding) getBinding()).bgContent.setBackgroundColor(androidx.core.content.a.getColor(this, 2131101214));
        AppCompatImageView appCompatImageView2 = ((ActivityWalletBinding) getBinding()).endImage;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "endImage");
        ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.wallet_record), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ((ActivityWalletBinding) getBinding()).backImageView.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityWalletBinding) getBinding()).getRoot().getContext(), 2131232456));
    }
}
