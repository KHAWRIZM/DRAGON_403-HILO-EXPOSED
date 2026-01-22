package com.qiahao.nextvideo.ui.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerShareContactsBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.rank.CommonViewPagerAdapter;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\f0,j\b\u0012\u0004\u0012\u00020\f`-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "Lcom/qiahao/nextvideo/ui/share/ShareContactsChildListener;", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeChildListener;", "<init>", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "viewDidLoad", "(Landroid/view/View;)V", "", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "Lcom/qiahao/base_common/model/common/User;", "user", "selectContactsUser", "(Lcom/qiahao/base_common/model/common/User;)V", "selectShareLikeMeUser", "Lcom/qiahao/nextvideo/databinding/ViewControllerShareContactsBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerShareContactsBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerShareContactsBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerShareContactsBinding;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/share/ShareContactsChildView;", "mShareContactsChildView", "Lcom/qiahao/nextvideo/ui/share/ShareContactsChildView;", "getMShareContactsChildView", "()Lcom/qiahao/nextvideo/ui/share/ShareContactsChildView;", "setMShareContactsChildView", "(Lcom/qiahao/nextvideo/ui/share/ShareContactsChildView;)V", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsListener;", "delegate", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsListener;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsListener;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsListener;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nShareLikeMeOrContactsViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ShareLikeMeOrContactsViewController.kt\ncom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,97:1\n1#2:98\n13472#3,2:99\n*S KotlinDebug\n*F\n+ 1 ShareLikeMeOrContactsViewController.kt\ncom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsViewController\n*L\n57#1:99,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ShareLikeMeOrContactsViewController extends BaseViewController implements ViewPager.j, o6.b, ShareContactsChildListener, ShareLikeMeChildListener {
    public ViewControllerShareContactsBinding binding;

    @Nullable
    private ShareLikeMeOrContactsListener delegate;
    public ShareContactsChildView mShareContactsChildView;

    @NotNull
    private final ArrayList<View> pageViews = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$0(ShareLikeMeOrContactsViewController shareLikeMeOrContactsViewController, int i, int i2) {
        ViewKtxKt.setMargin(shareLikeMeOrContactsViewController.getBinding().titleBar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    @NotNull
    public final ViewControllerShareContactsBinding getBinding() {
        ViewControllerShareContactsBinding viewControllerShareContactsBinding = this.binding;
        if (viewControllerShareContactsBinding != null) {
            return viewControllerShareContactsBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    @Nullable
    public final ShareLikeMeOrContactsListener getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final ShareContactsChildView getMShareContactsChildView() {
        ShareContactsChildView shareContactsChildView = this.mShareContactsChildView;
        if (shareContactsChildView != null) {
            return shareContactsChildView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mShareContactsChildView");
        return null;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        setBinding(ViewControllerShareContactsBinding.inflate(inflater, container, false));
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        getBinding().commonTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        getBinding().viewPager.setCurrentItem(position);
    }

    @Override // com.qiahao.nextvideo.ui.share.ShareContactsChildListener
    public void selectContactsUser(@NotNull User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        ShareLikeMeOrContactsListener shareLikeMeOrContactsListener = this.delegate;
        if (shareLikeMeOrContactsListener != null) {
            shareLikeMeOrContactsListener.selectUser(user);
        }
    }

    @Override // com.qiahao.nextvideo.ui.share.ShareLikeMeChildListener
    public void selectShareLikeMeUser(@NotNull User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        ShareLikeMeOrContactsListener shareLikeMeOrContactsListener = this.delegate;
        if (shareLikeMeOrContactsListener != null) {
            shareLikeMeOrContactsListener.selectUser(user);
        }
    }

    public final void setBinding(@NotNull ViewControllerShareContactsBinding viewControllerShareContactsBinding) {
        Intrinsics.checkNotNullParameter(viewControllerShareContactsBinding, "<set-?>");
        this.binding = viewControllerShareContactsBinding;
    }

    public final void setDelegate(@Nullable ShareLikeMeOrContactsListener shareLikeMeOrContactsListener) {
        this.delegate = shareLikeMeOrContactsListener;
    }

    public final void setMShareContactsChildView(@NotNull ShareContactsChildView shareContactsChildView) {
        Intrinsics.checkNotNullParameter(shareContactsChildView, "<set-?>");
        this.mShareContactsChildView = shareContactsChildView;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        Toolbar toolbar = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "titleBar");
        requireActivity.getStatusBarTopOrBottom(toolbar, new Function2() { // from class: com.qiahao.nextvideo.ui.share.m
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$0;
                viewDidLoad$lambda$0 = ShareLikeMeOrContactsViewController.viewDidLoad$lambda$0(ShareLikeMeOrContactsViewController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return viewDidLoad$lambda$0;
            }
        });
        ShareContactsChildView shareContactsChildView = new ShareContactsChildView(this, getRequireContext());
        shareContactsChildView.setDelegate(this);
        setMShareContactsChildView(shareContactsChildView);
        this.pageViews.add(getMShareContactsChildView());
        getBinding().viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        getBinding().viewPager.setOffscreenPageLimit(this.pageViews.size());
        getBinding().viewPager.setCurrentItem(0);
        getBinding().viewPager.addOnPageChangeListener(this);
        String[] strArr = {BaseViewControllerKt.getString(this, 2131952370, new Object[0])};
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TabEntity(strArr[0], 0, 0));
        getBinding().commonTabLayout.setTabData(arrayList);
        getBinding().commonTabLayout.setCurrentTab(0);
        getBinding().commonTabLayout.setOnTabSelectListener(this);
        getBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.share.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewController.dismiss$default(ShareLikeMeOrContactsViewController.this, true, null, 2, null);
            }
        });
    }
}
