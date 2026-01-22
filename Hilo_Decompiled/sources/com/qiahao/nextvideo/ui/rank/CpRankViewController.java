package com.qiahao.nextvideo.ui.rank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerCpRankBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00013B\u001b\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\"J\u0017\u0010%\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\"J\u0017\u0010&\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b&\u0010\"R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)R\"\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010'\u001a\u0004\b*\u0010)\"\u0004\b+\u0010\"R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.R$\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000e0/j\b\u0012\u0004\u0012\u00020\u000e`08\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpRankViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "", "position", "initChildPosition", "<init>", "(II)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "viewDidLoad", "(Landroid/view/View;)V", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "()V", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "I", "getPosition", "()I", "getInitChildPosition", "setInitChildPosition", "Lcom/qiahao/nextvideo/databinding/ViewControllerCpRankBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerCpRankBinding;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpRankViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpRankViewController.kt\ncom/qiahao/nextvideo/ui/rank/CpRankViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,117:1\n1#2:118\n13472#3,2:119\n*S KotlinDebug\n*F\n+ 1 CpRankViewController.kt\ncom/qiahao/nextvideo/ui/rank/CpRankViewController\n*L\n76#1:119,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankViewController extends BaseViewController implements ConfirmTipViewControllerDelegate, ViewPager.j, o6.b {

    @NotNull
    private static final String TAG = "CPRankViewController";
    private ViewControllerCpRankBinding binding;
    private int initChildPosition;

    @NotNull
    private final ArrayList<View> pageViews;
    private final int position;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CpRankViewController() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$3(CpRankViewController cpRankViewController, View view) {
        String string;
        ViewControllerCpRankBinding viewControllerCpRankBinding = cpRankViewController.binding;
        if (viewControllerCpRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding = null;
        }
        int currentTab = viewControllerCpRankBinding.commonTabLayout.getCurrentTab();
        if (currentTab != 0) {
            if (currentTab != 1) {
                string = BaseViewControllerKt.getString(cpRankViewController, 2131952431, new Object[0]);
            } else {
                string = BaseViewControllerKt.getString(cpRankViewController, 2131953500, new Object[0]);
            }
        } else {
            string = BaseViewControllerKt.getString(cpRankViewController, 2131952431, new Object[0]);
        }
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(ConfirmPreloadModel.INSTANCE.init(string, BaseViewControllerKt.getString(cpRankViewController, 2131953574, new Object[0]), null), null, 2, null);
        confirmTipViewController.setDelegate(cpRankViewController);
        ViewController.present$default(cpRankViewController, confirmTipViewController, true, null, 4, null);
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

    public final int getInitChildPosition() {
        return this.initChildPosition;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerCpRankBinding inflate = ViewControllerCpRankBinding.inflate(inflater, container, false);
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
        ViewControllerCpRankBinding viewControllerCpRankBinding = this.binding;
        if (viewControllerCpRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding = null;
        }
        viewControllerCpRankBinding.commonTabLayout.setCurrentTab(position);
        if (position == 0) {
            View view = this.pageViews.get(0);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CpRankWrapper");
            ((CpRankWrapper) view).initView();
        }
        if (position == 1) {
            View view2 = this.pageViews.get(1);
            Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CpMyRankWrapper");
            ((CpMyRankWrapper) view2).initView();
        }
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        ViewControllerCpRankBinding viewControllerCpRankBinding = this.binding;
        if (viewControllerCpRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding = null;
        }
        viewControllerCpRankBinding.viewPager.setCurrentItem(position);
    }

    public final void setInitChildPosition(int i) {
        this.initChildPosition = i;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerCpRankBinding viewControllerCpRankBinding = this.binding;
        ViewControllerCpRankBinding viewControllerCpRankBinding2 = null;
        if (viewControllerCpRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding = null;
        }
        Toolbar toolbar = viewControllerCpRankBinding.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        requireActivity.setStatusBarTopOrBottom(toolbar, false);
        this.pageViews.add(CpRankWrapper.INSTANCE.init(this.initChildPosition, this));
        this.pageViews.add(CpMyRankWrapper.INSTANCE.init(this));
        ViewControllerCpRankBinding viewControllerCpRankBinding3 = this.binding;
        if (viewControllerCpRankBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding3 = null;
        }
        viewControllerCpRankBinding3.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        ViewControllerCpRankBinding viewControllerCpRankBinding4 = this.binding;
        if (viewControllerCpRankBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding4 = null;
        }
        viewControllerCpRankBinding4.viewPager.setOffscreenPageLimit(this.pageViews.size());
        ViewControllerCpRankBinding viewControllerCpRankBinding5 = this.binding;
        if (viewControllerCpRankBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding5 = null;
        }
        viewControllerCpRankBinding5.viewPager.setCurrentItem(this.position);
        ViewControllerCpRankBinding viewControllerCpRankBinding6 = this.binding;
        if (viewControllerCpRankBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding6 = null;
        }
        viewControllerCpRankBinding6.viewPager.addOnPageChangeListener(this);
        ViewControllerCpRankBinding viewControllerCpRankBinding7 = this.binding;
        if (viewControllerCpRankBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding7 = null;
        }
        viewControllerCpRankBinding7.backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(CpRankViewController.this, true, null, 2, null);
            }
        });
        ViewControllerCpRankBinding viewControllerCpRankBinding8 = this.binding;
        if (viewControllerCpRankBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding8 = null;
        }
        viewControllerCpRankBinding8.icQuestion.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CpRankViewController.viewDidLoad$lambda$3(CpRankViewController.this, view2);
            }
        });
        String[] strArr = {BaseViewControllerKt.getString(this, 2131952430, new Object[0]), BaseViewControllerKt.getString(this, 2131953490, new Object[0])};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            arrayList.add(new TabEntity(strArr[i], 0, 0));
        }
        ViewControllerCpRankBinding viewControllerCpRankBinding9 = this.binding;
        if (viewControllerCpRankBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding9 = null;
        }
        viewControllerCpRankBinding9.commonTabLayout.setTabData(arrayList);
        ViewControllerCpRankBinding viewControllerCpRankBinding10 = this.binding;
        if (viewControllerCpRankBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerCpRankBinding10 = null;
        }
        viewControllerCpRankBinding10.commonTabLayout.setCurrentTab(0);
        View view2 = this.pageViews.get(0);
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CpRankWrapper");
        ((CpRankWrapper) view2).initView();
        ViewControllerCpRankBinding viewControllerCpRankBinding11 = this.binding;
        if (viewControllerCpRankBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerCpRankBinding2 = viewControllerCpRankBinding11;
        }
        viewControllerCpRankBinding2.commonTabLayout.setOnTabSelectListener(this);
    }

    public CpRankViewController(int i, int i2) {
        this.position = i;
        this.initChildPosition = i2;
        this.pageViews = new ArrayList<>();
        setTag(TAG);
    }

    public /* synthetic */ CpRankViewController(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }
}
