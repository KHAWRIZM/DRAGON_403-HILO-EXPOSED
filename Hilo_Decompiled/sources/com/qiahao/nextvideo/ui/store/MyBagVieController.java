package com.qiahao.nextvideo.ui.store;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerMyBagBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmPreloadModel;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewController;
import com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate;
import com.qiahao.nextvideo.ui.home.group.GroupViewPagerAdapter;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.share.ShareLikeMeOrContactsListener;
import com.qiahao.nextvideo.ui.share.ShareLikeMeOrContactsViewController;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001AB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ'\u0010!\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001cH\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010$J\u0017\u0010'\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010$J\u0017\u0010(\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b(\u0010$J\u0017\u0010)\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\fH\u0016¢\u0006\u0004\b0\u0010\u0007R\"\u00102\u001a\u0002018\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001b\u0010=\u001a\u0002088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001b\u0010@\u001a\u0002088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010:\u001a\u0004\b?\u0010<¨\u0006B"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagVieController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroidx/viewpager/widget/ViewPager$j;", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsListener;", "Lo6/b;", "Lcom/qiahao/nextvideo/ui/edition/country/confirmtip/ConfirmTipViewControllerDelegate;", "<init>", "()V", "Lcom/qiahao/base_common/model/common/User;", "user", "Lcom/qiahao/base_common/model/MyBagBean;", "bagBean", "", "confirmUserSend", "(Lcom/qiahao/base_common/model/common/User;Lcom/qiahao/base_common/model/MyBagBean;)V", "", "checkCanSend", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "selectUser", "(Lcom/qiahao/base_common/model/common/User;)V", "fromCode", "Landroid/os/Bundle;", "extra", "confirmTipViewControllerDidConfirm", "(ILandroid/os/Bundle;)V", "confirmTipViewControllerDidCancel", "Lcom/qiahao/nextvideo/databinding/ViewControllerMyBagBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewControllerMyBagBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerMyBagBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerMyBagBinding;)V", "Lcom/qiahao/nextvideo/ui/store/MyBagWrapper;", "headWearWrapper$delegate", "Lkotlin/Lazy;", "getHeadWearWrapper", "()Lcom/qiahao/nextvideo/ui/store/MyBagWrapper;", "headWearWrapper", "mountsWrapper$delegate", "getMountsWrapper", "mountsWrapper", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMyBagVieController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MyBagVieController.kt\ncom/qiahao/nextvideo/ui/store/MyBagVieController\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,191:1\n13472#2,2:192\n1#3:194\n*S KotlinDebug\n*F\n+ 1 MyBagVieController.kt\ncom/qiahao/nextvideo/ui/store/MyBagVieController\n*L\n68#1:192,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyBagVieController extends BaseViewController implements ViewPager.j, ShareLikeMeOrContactsListener, o6.b, ConfirmTipViewControllerDelegate {

    @NotNull
    private static final String TAG = "MyBagVieController";

    /* renamed from: headWearWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy headWearWrapper;
    public ViewControllerMyBagBinding mDataBinding;

    /* renamed from: mountsWrapper$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mountsWrapper;

    public MyBagVieController() {
        setTag(TAG);
        this.headWearWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.c0
            public final Object invoke() {
                MyBagWrapper headWearWrapper_delegate$lambda$0;
                headWearWrapper_delegate$lambda$0 = MyBagVieController.headWearWrapper_delegate$lambda$0(MyBagVieController.this);
                return headWearWrapper_delegate$lambda$0;
            }
        });
        this.mountsWrapper = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.d0
            public final Object invoke() {
                MyBagWrapper mountsWrapper_delegate$lambda$1;
                mountsWrapper_delegate$lambda$1 = MyBagVieController.mountsWrapper_delegate$lambda$1(MyBagVieController.this);
                return mountsWrapper_delegate$lambda$1;
            }
        });
    }

    private final boolean checkCanSend() {
        int currentItem = getMDataBinding().viewPager.getCurrentItem();
        if (currentItem != 0) {
            if (currentItem != 1) {
                return false;
            }
            return getMountsWrapper().checkCanSend();
        }
        return getHeadWearWrapper().checkCanSend();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$15(int i, Bundle bundle, final MyBagVieController myBagVieController) {
        if (i == 26) {
            long j = bundle.getLong("BagBeanId");
            String string = bundle.getString("UserExtraId");
            if (string == null) {
                string = "";
            }
            if (myBagVieController.getMDataBinding().viewPager.getCurrentItem() == 0) {
                myBagVieController.getHeadWearWrapper().send(j, string, new Function0() { // from class: com.qiahao.nextvideo.ui.store.f0
                    public final Object invoke() {
                        Unit confirmTipViewControllerDidConfirm$lambda$15$lambda$13;
                        confirmTipViewControllerDidConfirm$lambda$15$lambda$13 = MyBagVieController.confirmTipViewControllerDidConfirm$lambda$15$lambda$13(MyBagVieController.this);
                        return confirmTipViewControllerDidConfirm$lambda$15$lambda$13;
                    }
                });
            } else if (myBagVieController.getMDataBinding().viewPager.getCurrentItem() == 1) {
                myBagVieController.getMountsWrapper().send(j, string, new Function0() { // from class: com.qiahao.nextvideo.ui.store.g0
                    public final Object invoke() {
                        Unit confirmTipViewControllerDidConfirm$lambda$15$lambda$14;
                        confirmTipViewControllerDidConfirm$lambda$15$lambda$14 = MyBagVieController.confirmTipViewControllerDidConfirm$lambda$15$lambda$14(MyBagVieController.this);
                        return confirmTipViewControllerDidConfirm$lambda$15$lambda$14;
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$15$lambda$13(MyBagVieController myBagVieController) {
        ViewController.dismiss$default(myBagVieController, true, null, 2, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmTipViewControllerDidConfirm$lambda$15$lambda$14(MyBagVieController myBagVieController) {
        ViewController.dismiss$default(myBagVieController, true, null, 2, null);
        return Unit.INSTANCE;
    }

    private final void confirmUserSend(User user, MyBagBean bagBean) {
        String nick = user.getNick();
        if (nick == null) {
            nick = "";
        }
        String string = BaseViewControllerKt.getString(this, 2131952345, nick);
        String string2 = BaseViewControllerKt.getString(this, 2131953574, new Object[0]);
        String string3 = BaseViewControllerKt.getString(this, 2131952171, new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putString("UserExtraId", user.getExternalId());
        bundle.putLong("BagBeanId", bagBean.getId());
        ConfirmTipViewController confirmTipViewController = new ConfirmTipViewController(new ConfirmPreloadModel(string, string3, string2, 26, bundle), null, 2, null);
        confirmTipViewController.setDelegate(this);
        ViewController.present$default(this, confirmTipViewController, true, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagWrapper headWearWrapper_delegate$lambda$0(MyBagVieController myBagVieController) {
        return new MyBagWrapper(myBagVieController.getRequireContext(), myBagVieController, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MyBagWrapper mountsWrapper_delegate$lambda$1(MyBagVieController myBagVieController) {
        return new MyBagWrapper(myBagVieController.getRequireContext(), myBagVieController, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$2(MyBagVieController myBagVieController, int i, int i2) {
        ViewKtxKt.setMargin(myBagVieController.getMDataBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$5(MyBagVieController myBagVieController, View view) {
        if (myBagVieController.getRequireActivity().getControllerWindowNotNull().getControllers().size() <= 1) {
            myBagVieController.getRequireActivity().finish();
        } else {
            ViewController.dismiss$default(myBagVieController, true, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$7(MyBagVieController myBagVieController, View view) {
        if (myBagVieController.checkCanSend()) {
            ShareLikeMeOrContactsViewController shareLikeMeOrContactsViewController = new ShareLikeMeOrContactsViewController();
            shareLikeMeOrContactsViewController.setDelegate(myBagVieController);
            ViewController.present$default(myBagVieController, shareLikeMeOrContactsViewController, true, null, 4, null);
        } else {
            Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, myBagVieController.getContext(), ResourcesKtxKt.getStringById(myBagVieController, 2131953145), false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$8(MyBagVieController myBagVieController, View view) {
        if (myBagVieController.getMDataBinding().viewPager.getCurrentItem() == 0) {
            myBagVieController.getHeadWearWrapper().confirmUsing();
        } else if (myBagVieController.getMDataBinding().viewPager.getCurrentItem() == 1) {
            myBagVieController.getMountsWrapper().confirmUsing();
        }
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidCancel() {
        ViewController.dismiss$default(this, true, null, 2, null);
    }

    @Override // com.qiahao.nextvideo.ui.edition.country.confirmtip.ConfirmTipViewControllerDelegate
    public void confirmTipViewControllerDidConfirm(final int fromCode, @NotNull final Bundle extra) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        dismiss(true, new Function0() { // from class: com.qiahao.nextvideo.ui.store.e0
            public final Object invoke() {
                Unit confirmTipViewControllerDidConfirm$lambda$15;
                confirmTipViewControllerDidConfirm$lambda$15 = MyBagVieController.confirmTipViewControllerDidConfirm$lambda$15(fromCode, extra, this);
                return confirmTipViewControllerDidConfirm$lambda$15;
            }
        });
    }

    @NotNull
    public final MyBagWrapper getHeadWearWrapper() {
        return (MyBagWrapper) this.headWearWrapper.getValue();
    }

    @NotNull
    public final ViewControllerMyBagBinding getMDataBinding() {
        ViewControllerMyBagBinding viewControllerMyBagBinding = this.mDataBinding;
        if (viewControllerMyBagBinding != null) {
            return viewControllerMyBagBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @NotNull
    public final MyBagWrapper getMountsWrapper() {
        return (MyBagWrapper) this.mountsWrapper.getValue();
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        setMDataBinding(ViewControllerMyBagBinding.inflate(inflater, container, false));
        View root = getMDataBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onPageScrollStateChanged(int state) {
    }

    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    public void onPageSelected(int position) {
        getMDataBinding().commonTabLayout.setCurrentTab(position);
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        getMDataBinding().viewPager.setCurrentItem(position);
    }

    @Override // com.qiahao.nextvideo.ui.share.ShareLikeMeOrContactsListener
    public void selectUser(@NotNull User user) {
        MyBagBean bagBean;
        Intrinsics.checkNotNullParameter(user, "user");
        if (getMDataBinding().viewPager.getCurrentItem() == 0) {
            MyBagBean bagBean2 = getHeadWearWrapper().getBagBean();
            if (bagBean2 != null) {
                confirmUserSend(user, bagBean2);
                return;
            }
            return;
        }
        if (getMDataBinding().viewPager.getCurrentItem() == 1 && (bagBean = getMountsWrapper().getBagBean()) != null) {
            confirmUserSend(user, bagBean);
        }
    }

    public final void setMDataBinding(@NotNull ViewControllerMyBagBinding viewControllerMyBagBinding) {
        Intrinsics.checkNotNullParameter(viewControllerMyBagBinding, "<set-?>");
        this.mDataBinding = viewControllerMyBagBinding;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ConstraintLayout constraintLayout = getMDataBinding().container;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "container");
        requireActivity.getStatusBarTopOrBottom(constraintLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.store.y
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$2;
                viewDidLoad$lambda$2 = MyBagVieController.viewDidLoad$lambda$2(MyBagVieController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return viewDidLoad$lambda$2;
            }
        });
        ArrayList arrayList = new ArrayList();
        arrayList.add(getHeadWearWrapper());
        arrayList.add(getMountsWrapper());
        getMDataBinding().viewPager.setAdapter(new GroupViewPagerAdapter(arrayList));
        getMDataBinding().viewPager.setOffscreenPageLimit(arrayList.size());
        getMDataBinding().viewPager.setCurrentItem(0);
        getMDataBinding().viewPager.addOnPageChangeListener(this);
        String[] strArr = {BaseViewControllerKt.getString(this, 2131953047, new Object[0]), BaseViewControllerKt.getString(this, 2131953421, new Object[0])};
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 2; i++) {
            arrayList2.add(new TabEntity(strArr[i], 0, 0));
        }
        getMDataBinding().commonTabLayout.setTabData(arrayList2);
        getMDataBinding().commonTabLayout.setCurrentTab(0);
        getMDataBinding().commonTabLayout.setOnTabSelectListener(this);
        getMDataBinding().backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MyBagVieController.viewDidLoad$lambda$5(MyBagVieController.this, view2);
            }
        });
        getMDataBinding().textSnd.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MyBagVieController.viewDidLoad$lambda$7(MyBagVieController.this, view2);
            }
        });
        getMDataBinding().textUse.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.store.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MyBagVieController.viewDidLoad$lambda$8(MyBagVieController.this, view2);
            }
        });
    }
}
