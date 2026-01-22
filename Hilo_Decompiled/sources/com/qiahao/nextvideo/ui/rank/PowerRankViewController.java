package com.qiahao.nextvideo.ui.rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerPowerAllRankBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.rank.PowerRankWeekWrapper;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001-B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J'\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u0016J\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010\u0016J\u001f\u0010#\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00132\u0006\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0006R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\r0)j\b\u0012\u0004\u0012\u00020\r`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/PowerRankViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lo6/b;", "Landroidx/viewpager/widget/ViewPager$j;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "<init>", "()V", "", "showDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "", "position", "onTabSelect", "(I)V", "onTabReselect", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "state", "onPageScrollStateChanged", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "Lcom/qiahao/nextvideo/databinding/ViewControllerPowerAllRankBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerPowerAllRankBinding;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPowerRankViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PowerRankViewController.kt\ncom/qiahao/nextvideo/ui/rank/PowerRankViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,106:1\n1#2:107\n13472#3,2:108\n*S KotlinDebug\n*F\n+ 1 PowerRankViewController.kt\ncom/qiahao/nextvideo/ui/rank/PowerRankViewController\n*L\n54#1:108,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerRankViewController extends BaseViewController implements o6.b, ViewPager.j, ConfirmTipViewControllerDelegate {

    @NotNull
    private static final String TAG = "PowerRankViewController";
    private ViewControllerPowerAllRankBinding binding;

    @NotNull
    private final ArrayList<View> pageViews = new ArrayList<>();

    public PowerRankViewController() {
        setTag(TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDialog() {
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(ResourcesKtxKt.getStringById(this, 2131953706), BaseViewControllerKt.getString(this, 2131953574, new Object[0]), null), null, 2, null);
        confirmTipViewController.setDelegate(this);
        ViewController.present$default(this, confirmTipViewController, true, null, 4, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(int fromCode, @NotNull Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerPowerAllRankBinding inflate = ViewControllerPowerAllRankBinding.inflate(inflater, container, false);
        this.binding = inflate;
        View root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding = this.binding;
        if (viewControllerPowerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding = null;
        }
        viewControllerPowerAllRankBinding.commonTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding = this.binding;
        if (viewControllerPowerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding = null;
        }
        viewControllerPowerAllRankBinding.viewPager.setCurrentItem(position);
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding = this.binding;
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding2 = null;
        if (viewControllerPowerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding = null;
        }
        Toolbar toolbar = viewControllerPowerAllRankBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        ArrayList<View> arrayList = this.pageViews;
        PowerRankWeekWrapper.Companion companion = PowerRankWeekWrapper.INSTANCE;
        arrayList.add(companion.init(1, this));
        this.pageViews.add(companion.init(2, this));
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding3 = this.binding;
        if (viewControllerPowerAllRankBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding3 = null;
        }
        viewControllerPowerAllRankBinding3.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding4 = this.binding;
        if (viewControllerPowerAllRankBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding4 = null;
        }
        viewControllerPowerAllRankBinding4.viewPager.setOffscreenPageLimit(this.pageViews.size());
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding5 = this.binding;
        if (viewControllerPowerAllRankBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding5 = null;
        }
        viewControllerPowerAllRankBinding5.viewPager.setCurrentItem(0);
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding6 = this.binding;
        if (viewControllerPowerAllRankBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding6 = null;
        }
        viewControllerPowerAllRankBinding6.viewPager.addOnPageChangeListener(this);
        String[] strArr = {ResourcesKtxKt.getStringById(this, 2131954267), ResourcesKtxKt.getStringById(this, 2131953196)};
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 2; i++) {
            arrayList2.add(new TabEntity(strArr[i], 0, 0));
        }
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding7 = this.binding;
        if (viewControllerPowerAllRankBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding7 = null;
        }
        viewControllerPowerAllRankBinding7.commonTabLayout.setTabData(arrayList2);
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding8 = this.binding;
        if (viewControllerPowerAllRankBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding8 = null;
        }
        viewControllerPowerAllRankBinding8.commonTabLayout.setCurrentTab(0);
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding9 = this.binding;
        if (viewControllerPowerAllRankBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding9 = null;
        }
        viewControllerPowerAllRankBinding9.commonTabLayout.setOnTabSelectListener(this);
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding10 = this.binding;
        if (viewControllerPowerAllRankBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerPowerAllRankBinding10 = null;
        }
        viewControllerPowerAllRankBinding10.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(PowerRankViewController.this, true, null, 2, null);
            }
        });
        ViewControllerPowerAllRankBinding viewControllerPowerAllRankBinding11 = this.binding;
        if (viewControllerPowerAllRankBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerPowerAllRankBinding2 = viewControllerPowerAllRankBinding11;
        }
        viewControllerPowerAllRankBinding2.icQuestion.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                PowerRankViewController.this.showDialog();
            }
        });
    }
}
