package com.qiahao.nextvideo.ui.aristocracy;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.base_common.ui.dialog.TipTitleDialog;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.CheckNobleAward;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.AristocracyPermissionBean;
import com.qiahao.nextvideo.data.model.MyNobleBeanItem;
import com.qiahao.nextvideo.data.model.NobleBeanConfig;
import com.qiahao.nextvideo.data.service.OutPutOtherModuleService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ViewControllerBuyAristocracyIdentityBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.home.group.GroupViewPagerAdapter;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewControllerKt;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.share.ShareLikeMeOrContactsListener;
import com.qiahao.nextvideo.ui.share.ShareLikeMeOrContactsViewController;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u0007J\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\u0007J\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u0007J\u001f\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0007J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u0007J\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\u0007J\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u0007J\u0019\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001f\u0010\u0015J\u001f\u0010%\u001a\u00020$2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020$H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020*H\u0007¢\u0006\u0004\b,\u0010-J\r\u0010.\u001a\u00020\b¢\u0006\u0004\b.\u0010\u0007J'\u00102\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u0012H\u0016¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b4\u0010\u0015J\u0017\u00106\u001a\u00020\b2\u0006\u00105\u001a\u00020\u0012H\u0016¢\u0006\u0004\b6\u0010\u0015J\u0017\u00108\u001a\u00020\b2\u0006\u00107\u001a\u00020$H\u0016¢\u0006\u0004\b8\u0010)J\u0017\u00109\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b9\u0010\u0015J\u0017\u0010:\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b:\u0010\u0015J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u00020\b2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b@\u0010\u001aR$\u0010B\u001a\u0004\u0018\u00010A8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u001b\u0010^\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010X\u001a\u0004\b]\u0010ZR\u001b\u0010a\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b_\u0010X\u001a\u0004\b`\u0010ZR\u001b\u0010d\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010X\u001a\u0004\bc\u0010ZR\u001b\u0010g\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010X\u001a\u0004\bf\u0010ZR\u001b\u0010j\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010X\u001a\u0004\bi\u0010ZR\u001b\u0010m\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010X\u001a\u0004\bl\u0010ZR\u001b\u0010p\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bn\u0010X\u001a\u0004\bo\u0010ZR\u001b\u0010s\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bq\u0010X\u001a\u0004\br\u0010ZR\u001b\u0010v\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010X\u001a\u0004\bu\u0010ZR'\u0010w\u001a\u0012\u0012\u0004\u0012\u00020$0\rj\b\u0012\u0004\u0012\u00020$`\u000f8\u0006¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010\u0011R2\u0010{\u001a\u0012\u0012\u0004\u0012\u00020z0\rj\b\u0012\u0004\u0012\u00020z`\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b{\u0010x\u001a\u0004\b|\u0010\u0011\"\u0004\b}\u0010~R6\u0010\u0080\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u007f0\rj\b\u0012\u0004\u0012\u00020\u007f`\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010x\u001a\u0005\b\u0081\u0001\u0010\u0011\"\u0005\b\u0082\u0001\u0010~R+\u0010\u0083\u0001\u001a\u0004\u0018\u00010z8\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R(\u0010\u0089\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0005\b\u008d\u0001\u0010\u0015R\u001d\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0006¢\u0006\u0010\n\u0006\b\u008f\u0001\u0010\u0090\u0001\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001R1\u0010\u0095\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001\"\u0006\b\u0099\u0001\u0010\u009a\u0001¨\u0006\u009b\u0001"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/BuyAristocracyViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroidx/viewpager/widget/ViewPager$j;", "Landroid/view/View$OnClickListener;", "Lo6/b;", "Lcom/qiahao/nextvideo/ui/share/ShareLikeMeOrContactsListener;", "<init>", "()V", "", "registerEventBus", "unRegisterEventBus", "getNobleConfigDataFromCache", "getNobleConfigData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/AristocracyPermissionBean;", "Lkotlin/collections/ArrayList;", "getNobilityListView", "()Ljava/util/ArrayList;", "", "position", "refreshShowView", "(I)V", "confirmBuy", "Lcom/qiahao/base_common/model/common/User;", "user", "confirmUserSend", "(Lcom/qiahao/base_common/model/common/User;)V", "confirmPurchase", "deleteNoble", "checkNoble", "level", "getNoble8", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "viewDidLoad", "(Landroid/view/View;)V", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "event", "onRefreshEvent", "(Lcom/qiahao/base_common/model/eventBus/EventBusKey;)V", "confirmToBuy", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "state", "onPageScrollStateChanged", "v", "onClick", "onTabSelect", "onTabReselect", "", "onBackPressed", "()Z", "doDestroyView", "(Landroid/view/ViewGroup;)V", "selectUser", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "mListener", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/ControllerListener;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/ControllerListener;)V", "Landroid/animation/ValueAnimator;", "mAnimator", "Landroid/animation/ValueAnimator;", "getMAnimator", "()Landroid/animation/ValueAnimator;", "setMAnimator", "(Landroid/animation/ValueAnimator;)V", "Lcom/qiahao/nextvideo/databinding/ViewControllerBuyAristocracyIdentityBinding;", "mDataBinding", "Lcom/qiahao/nextvideo/databinding/ViewControllerBuyAristocracyIdentityBinding;", "getMDataBinding", "()Lcom/qiahao/nextvideo/databinding/ViewControllerBuyAristocracyIdentityBinding;", "setMDataBinding", "(Lcom/qiahao/nextvideo/databinding/ViewControllerBuyAristocracyIdentityBinding;)V", "Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyWrapper;", "mAristocracyWrapper1$delegate", "Lkotlin/Lazy;", "getMAristocracyWrapper1", "()Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyWrapper;", "mAristocracyWrapper1", "mAristocracyWrapper2$delegate", "getMAristocracyWrapper2", "mAristocracyWrapper2", "mAristocracyWrapper3$delegate", "getMAristocracyWrapper3", "mAristocracyWrapper3", "mAristocracyWrapper4$delegate", "getMAristocracyWrapper4", "mAristocracyWrapper4", "mAristocracyWrapper5$delegate", "getMAristocracyWrapper5", "mAristocracyWrapper5", "mAristocracyWrapper6$delegate", "getMAristocracyWrapper6", "mAristocracyWrapper6", "mAristocracyWrapper7$delegate", "getMAristocracyWrapper7", "mAristocracyWrapper7", "mAristocracyWrapper8$delegate", "getMAristocracyWrapper8", "mAristocracyWrapper8", "mAristocracyWrapper9$delegate", "getMAristocracyWrapper9", "mAristocracyWrapper9", "mAristocracyWrapper10$delegate", "getMAristocracyWrapper10", "mAristocracyWrapper10", "viewPagerViews", "Ljava/util/ArrayList;", "getViewPagerViews", "Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "mNobleBeanConfigList", "getMNobleBeanConfigList", "setMNobleBeanConfigList", "(Ljava/util/ArrayList;)V", "Lcom/qiahao/nextvideo/data/model/MyNobleBeanItem;", "mMyNobleBeanItemList", "getMMyNobleBeanItemList", "setMMyNobleBeanItemList", "mCurrentNobleBeanConfig", "Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "getMCurrentNobleBeanConfig", "()Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;", "setMCurrentNobleBeanConfig", "(Lcom/qiahao/nextvideo/data/model/NobleBeanConfig;)V", "mSelectNobleLevel", "I", "getMSelectNobleLevel", "()I", "setMSelectNobleLevel", "Lcom/qiahao/nextvideo/data/service/OutPutOtherModuleService;", "outPutOtherModuleService", "Lcom/qiahao/nextvideo/data/service/OutPutOtherModuleService;", "getOutPutOtherModuleService", "()Lcom/qiahao/nextvideo/data/service/OutPutOtherModuleService;", "", "", "titles", "[Ljava/lang/String;", "getTitles", "()[Ljava/lang/String;", "setTitles", "([Ljava/lang/String;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBuyAristocracyViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BuyAristocracyViewController.kt\ncom/qiahao/nextvideo/ui/aristocracy/BuyAristocracyViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,849:1\n1#2:850\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BuyAristocracyViewController extends BaseViewController implements ViewPager.j, View.OnClickListener, o6.b, ShareLikeMeOrContactsListener {

    @Nullable
    private ValueAnimator mAnimator;

    @Nullable
    private NobleBeanConfig mCurrentNobleBeanConfig;
    public ViewControllerBuyAristocracyIdentityBinding mDataBinding;

    @Nullable
    private ControllerListener mListener;
    private int mSelectNobleLevel;

    @NotNull
    private final OutPutOtherModuleService outPutOtherModuleService;

    @NotNull
    private String[] titles;

    /* renamed from: mAristocracyWrapper1$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper1 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.j0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper1_delegate$lambda$0;
            mAristocracyWrapper1_delegate$lambda$0 = BuyAristocracyViewController.mAristocracyWrapper1_delegate$lambda$0(BuyAristocracyViewController.this);
            return mAristocracyWrapper1_delegate$lambda$0;
        }
    });

    /* renamed from: mAristocracyWrapper2$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper2 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.k0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper2_delegate$lambda$1;
            mAristocracyWrapper2_delegate$lambda$1 = BuyAristocracyViewController.mAristocracyWrapper2_delegate$lambda$1(BuyAristocracyViewController.this);
            return mAristocracyWrapper2_delegate$lambda$1;
        }
    });

    /* renamed from: mAristocracyWrapper3$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper3 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.l0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper3_delegate$lambda$2;
            mAristocracyWrapper3_delegate$lambda$2 = BuyAristocracyViewController.mAristocracyWrapper3_delegate$lambda$2(BuyAristocracyViewController.this);
            return mAristocracyWrapper3_delegate$lambda$2;
        }
    });

    /* renamed from: mAristocracyWrapper4$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper4 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.m0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper4_delegate$lambda$3;
            mAristocracyWrapper4_delegate$lambda$3 = BuyAristocracyViewController.mAristocracyWrapper4_delegate$lambda$3(BuyAristocracyViewController.this);
            return mAristocracyWrapper4_delegate$lambda$3;
        }
    });

    /* renamed from: mAristocracyWrapper5$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper5 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.n0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper5_delegate$lambda$4;
            mAristocracyWrapper5_delegate$lambda$4 = BuyAristocracyViewController.mAristocracyWrapper5_delegate$lambda$4(BuyAristocracyViewController.this);
            return mAristocracyWrapper5_delegate$lambda$4;
        }
    });

    /* renamed from: mAristocracyWrapper6$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper6 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.o0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper6_delegate$lambda$5;
            mAristocracyWrapper6_delegate$lambda$5 = BuyAristocracyViewController.mAristocracyWrapper6_delegate$lambda$5(BuyAristocracyViewController.this);
            return mAristocracyWrapper6_delegate$lambda$5;
        }
    });

    /* renamed from: mAristocracyWrapper7$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper7 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.p0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper7_delegate$lambda$6;
            mAristocracyWrapper7_delegate$lambda$6 = BuyAristocracyViewController.mAristocracyWrapper7_delegate$lambda$6(BuyAristocracyViewController.this);
            return mAristocracyWrapper7_delegate$lambda$6;
        }
    });

    /* renamed from: mAristocracyWrapper8$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper8 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.q0
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper8_delegate$lambda$8;
            mAristocracyWrapper8_delegate$lambda$8 = BuyAristocracyViewController.mAristocracyWrapper8_delegate$lambda$8(BuyAristocracyViewController.this);
            return mAristocracyWrapper8_delegate$lambda$8;
        }
    });

    /* renamed from: mAristocracyWrapper9$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper9 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.o
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper9_delegate$lambda$10;
            mAristocracyWrapper9_delegate$lambda$10 = BuyAristocracyViewController.mAristocracyWrapper9_delegate$lambda$10(BuyAristocracyViewController.this);
            return mAristocracyWrapper9_delegate$lambda$10;
        }
    });

    /* renamed from: mAristocracyWrapper10$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAristocracyWrapper10 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.p
        public final Object invoke() {
            AristocracyWrapper mAristocracyWrapper10_delegate$lambda$12;
            mAristocracyWrapper10_delegate$lambda$12 = BuyAristocracyViewController.mAristocracyWrapper10_delegate$lambda$12(BuyAristocracyViewController.this);
            return mAristocracyWrapper10_delegate$lambda$12;
        }
    });

    @NotNull
    private final ArrayList<View> viewPagerViews = new ArrayList<>();

    @NotNull
    private ArrayList<NobleBeanConfig> mNobleBeanConfigList = new ArrayList<>();

    @NotNull
    private ArrayList<MyNobleBeanItem> mMyNobleBeanItemList = new ArrayList<>();

    public BuyAristocracyViewController() {
        BaseService appService = AllModuleServiceManager.Companion.get().getAppService();
        Intrinsics.checkNotNull(appService, "null cannot be cast to non-null type com.qiahao.nextvideo.data.service.OutPutOtherModuleService");
        this.outPutOtherModuleService = (OutPutOtherModuleService) appService;
        this.titles = new String[]{ResourcesKtxKt.getStringById(this, 2131954459), ResourcesKtxKt.getStringById(this, 2131952389), ResourcesKtxKt.getStringById(this, 2131953322), ResourcesKtxKt.getStringById(this, 2131952596), ResourcesKtxKt.getStringById(this, 2131953183), ResourcesKtxKt.getStringById(this, 2131952607), ResourcesKtxKt.getStringById(this, 2131954112), ResourcesKtxKt.getStringById(this, 2131951907), ResourcesKtxKt.getStringById(this, 2131952038), ResourcesKtxKt.getStringById(this, 2131952037)};
    }

    private final void checkNoble() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().checkNobleAward(), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.x
            public final Object invoke(Object obj) {
                Unit checkNoble$lambda$38;
                checkNoble$lambda$38 = BuyAristocracyViewController.checkNoble$lambda$38(BuyAristocracyViewController.this, (ApiResponse) obj);
                return checkNoble$lambda$38;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.z
            public final Object invoke(Object obj) {
                Unit checkNoble$lambda$39;
                checkNoble$lambda$39 = BuyAristocracyViewController.checkNoble$lambda$39((Throwable) obj);
                return checkNoble$lambda$39;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$38(final BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        int i;
        int i2;
        int i3;
        int i4;
        Integer statusNoble9;
        Integer status;
        Integer statusNoble92;
        Integer status2;
        Integer status3;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        AristocracyWrapper mAristocracyWrapper8 = buyAristocracyViewController.getMAristocracyWrapper8();
        CheckNobleAward checkNobleAward = (CheckNobleAward) apiResponse.getData();
        int i5 = 0;
        if (checkNobleAward != null && (status3 = checkNobleAward.getStatus()) != null) {
            i = status3.intValue();
        } else {
            i = 0;
        }
        mAristocracyWrapper8.refreshNoble8(i, new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.q
            public final Object invoke() {
                Unit checkNoble$lambda$38$lambda$33;
                checkNoble$lambda$38$lambda$33 = BuyAristocracyViewController.checkNoble$lambda$38$lambda$33(BuyAristocracyViewController.this);
                return checkNoble$lambda$38$lambda$33;
            }
        });
        AristocracyWrapper mAristocracyWrapper9 = buyAristocracyViewController.getMAristocracyWrapper9();
        CheckNobleAward checkNobleAward2 = (CheckNobleAward) apiResponse.getData();
        if (checkNobleAward2 != null && (status2 = checkNobleAward2.getStatus()) != null) {
            i2 = status2.intValue();
        } else {
            i2 = 0;
        }
        mAristocracyWrapper9.refreshNoble8(i2, new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.r
            public final Object invoke() {
                Unit checkNoble$lambda$38$lambda$34;
                checkNoble$lambda$38$lambda$34 = BuyAristocracyViewController.checkNoble$lambda$38$lambda$34(BuyAristocracyViewController.this);
                return checkNoble$lambda$38$lambda$34;
            }
        });
        AristocracyWrapper mAristocracyWrapper92 = buyAristocracyViewController.getMAristocracyWrapper9();
        CheckNobleAward checkNobleAward3 = (CheckNobleAward) apiResponse.getData();
        if (checkNobleAward3 != null && (statusNoble92 = checkNobleAward3.getStatusNoble9()) != null) {
            i3 = statusNoble92.intValue();
        } else {
            i3 = 0;
        }
        mAristocracyWrapper92.refreshNoble9(i3, new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.s
            public final Object invoke() {
                Unit checkNoble$lambda$38$lambda$35;
                checkNoble$lambda$38$lambda$35 = BuyAristocracyViewController.checkNoble$lambda$38$lambda$35(BuyAristocracyViewController.this);
                return checkNoble$lambda$38$lambda$35;
            }
        });
        AristocracyWrapper mAristocracyWrapper10 = buyAristocracyViewController.getMAristocracyWrapper10();
        CheckNobleAward checkNobleAward4 = (CheckNobleAward) apiResponse.getData();
        if (checkNobleAward4 != null && (status = checkNobleAward4.getStatus()) != null) {
            i4 = status.intValue();
        } else {
            i4 = 0;
        }
        mAristocracyWrapper10.refreshNoble8(i4, new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.t
            public final Object invoke() {
                Unit checkNoble$lambda$38$lambda$36;
                checkNoble$lambda$38$lambda$36 = BuyAristocracyViewController.checkNoble$lambda$38$lambda$36(BuyAristocracyViewController.this);
                return checkNoble$lambda$38$lambda$36;
            }
        });
        AristocracyWrapper mAristocracyWrapper102 = buyAristocracyViewController.getMAristocracyWrapper10();
        CheckNobleAward checkNobleAward5 = (CheckNobleAward) apiResponse.getData();
        if (checkNobleAward5 != null && (statusNoble9 = checkNobleAward5.getStatusNoble9()) != null) {
            i5 = statusNoble9.intValue();
        }
        mAristocracyWrapper102.refreshNoble9(i5, new Function0() { // from class: com.qiahao.nextvideo.ui.aristocracy.u
            public final Object invoke() {
                Unit checkNoble$lambda$38$lambda$37;
                checkNoble$lambda$38$lambda$37 = BuyAristocracyViewController.checkNoble$lambda$38$lambda$37(BuyAristocracyViewController.this);
                return checkNoble$lambda$38$lambda$37;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$38$lambda$33(BuyAristocracyViewController buyAristocracyViewController) {
        buyAristocracyViewController.getNoble8(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$38$lambda$34(BuyAristocracyViewController buyAristocracyViewController) {
        buyAristocracyViewController.getNoble8(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$38$lambda$35(BuyAristocracyViewController buyAristocracyViewController) {
        buyAristocracyViewController.getNoble8(9);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$38$lambda$36(BuyAristocracyViewController buyAristocracyViewController) {
        buyAristocracyViewController.getNoble8(8);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$38$lambda$37(BuyAristocracyViewController buyAristocracyViewController) {
        buyAristocracyViewController.getNoble8(9);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkNoble$lambda$39(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void confirmBuy() {
        if (HiloUtils.INSTANCE.isFastClick()) {
            return;
        }
        int size = this.mMyNobleBeanItemList.size();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            NobleBeanConfig nobleBeanConfig = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig != null && this.mMyNobleBeanItemList.get(i2).getLevel() == nobleBeanConfig.getLevel()) {
                i = this.mMyNobleBeanItemList.get(i2).getPrice();
                z = true;
            }
        }
        if (!z) {
            NobleBeanConfig nobleBeanConfig2 = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig2 != null) {
                i = nobleBeanConfig2.getPurchasePrice();
            } else {
                i = 0;
            }
        }
        TipTitleDialog tipTitleDialog = new TipTitleDialog(getRequireContext());
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131952347), Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        tipTitleDialog.setTitleContent(format).setTipContent(ResourcesKtxKt.getStringById(this, 2131952032)).setTipColor(Color.parseColor("#ff5273")).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.BuyAristocracyViewController$confirmBuy$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                BuyAristocracyViewController.this.confirmToBuy();
            }
        }).show();
    }

    private final void confirmPurchase() {
        new TipDialog(getRequireActivity()).setTipContent(ResourcesKtxKt.getStringById(this, 2131953126)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.BuyAristocracyViewController$confirmPurchase$1
            public void cancel() {
                OnCommonDialogListener.DefaultImpls.cancel(this);
            }

            public void confirm() {
                WalletActivity.INSTANCE.start(BuyAristocracyViewController.this.getRequireContext());
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmToBuy$lambda$28(BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        buyAristocracyViewController.getNobleConfigData();
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, buyAristocracyViewController.getContext(), BaseViewControllerKt.getString(buyAristocracyViewController, 2131954176, new Object[0]), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit confirmToBuy$lambda$29(BuyAristocracyViewController buyAristocracyViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = buyAristocracyViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(buyAristocracyViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void confirmUserSend(User user) {
        int i;
        TipDialog tipDialog = new TipDialog(getRequireActivity());
        String stringById = ResourcesKtxKt.getStringById(this, 2131952346);
        NobleBeanConfig nobleBeanConfig = this.mCurrentNobleBeanConfig;
        if (nobleBeanConfig != null) {
            i = nobleBeanConfig.getPurchasePrice();
        } else {
            i = 0;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{Integer.valueOf(i), user.getNick()}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        tipDialog.setTipContent(format).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131953574)).setDialogListener(new BuyAristocracyViewController$confirmUserSend$1(user, this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteNoble() {
        if (this.mSelectNobleLevel > 0) {
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().deleteNoble(this.mSelectNobleLevel), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.a0
                public final Object invoke(Object obj) {
                    Unit deleteNoble$lambda$31;
                    deleteNoble$lambda$31 = BuyAristocracyViewController.deleteNoble$lambda$31(BuyAristocracyViewController.this, (ApiResponse) obj);
                    return deleteNoble$lambda$31;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.b0
                public final Object invoke(Object obj) {
                    Unit deleteNoble$lambda$32;
                    deleteNoble$lambda$32 = BuyAristocracyViewController.deleteNoble$lambda$32(BuyAristocracyViewController.this, (Throwable) obj);
                    return deleteNoble$lambda$32;
                }
            }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteNoble$lambda$31(BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        buyAristocracyViewController.getNobleConfigData();
        UserStore.fetchUserDetailInfo$default(UserStore.INSTANCE.getShared(), false, 1, null);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, buyAristocracyViewController.getRequireActivity(), ResourcesKtxKt.getStringById(buyAristocracyViewController, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deleteNoble$lambda$32(BuyAristocracyViewController buyAristocracyViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            BaseActivity requireActivity = buyAristocracyViewController.getRequireActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(buyAristocracyViewController, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, requireActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final AristocracyWrapper getMAristocracyWrapper1() {
        return (AristocracyWrapper) this.mAristocracyWrapper1.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper10() {
        return (AristocracyWrapper) this.mAristocracyWrapper10.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper2() {
        return (AristocracyWrapper) this.mAristocracyWrapper2.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper3() {
        return (AristocracyWrapper) this.mAristocracyWrapper3.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper4() {
        return (AristocracyWrapper) this.mAristocracyWrapper4.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper5() {
        return (AristocracyWrapper) this.mAristocracyWrapper5.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper6() {
        return (AristocracyWrapper) this.mAristocracyWrapper6.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper7() {
        return (AristocracyWrapper) this.mAristocracyWrapper7.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper8() {
        return (AristocracyWrapper) this.mAristocracyWrapper8.getValue();
    }

    private final AristocracyWrapper getMAristocracyWrapper9() {
        return (AristocracyWrapper) this.mAristocracyWrapper9.getValue();
    }

    private final ArrayList<AristocracyPermissionBean> getNobilityListView() {
        ArrayList<AristocracyPermissionBean> arrayList = new ArrayList<>();
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy1, R.drawable.ic_aristocracy1_2, false, BaseViewControllerKt.getString(this, 2131952041, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy2, R.drawable.ic_aristocracy2_2, false, BaseViewControllerKt.getString(this, 2131952637, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy3, R.drawable.ic_aristocracy3_2, false, BaseViewControllerKt.getString(this, 2131953564, 100)));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy4, R.drawable.ic_aristocracy4_2, false, BaseViewControllerKt.getString(this, 2131954114, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy5, R.drawable.ic_aristocracy5_2, false, BaseViewControllerKt.getString(this, 2131952635, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy6, R.drawable.ic_aristocracy6_2, false, BaseViewControllerKt.getString(this, 2131953389, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy7, R.drawable.ic_aristocracy7_2, false, BaseViewControllerKt.getString(this, 2131953833, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy8, R.drawable.ic_aristocracy8_2, false, BaseViewControllerKt.getString(this, 2131952636, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy9, R.drawable.ic_aristocracy9_2, false, BaseViewControllerKt.getString(this, 2131952279, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy10, R.drawable.ic_aristocracy10_2, false, BaseViewControllerKt.getString(this, 2131954371, 1000)));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy11, R.drawable.ic_aristocracy11_2, false, BaseViewControllerKt.getString(this, 2131954370, 1000)));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy12, R.drawable.ic_aristocracy12_2, false, BaseViewControllerKt.getString(this, 2131954354, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy13, R.drawable.ic_aristocracy13_2, false, BaseViewControllerKt.getString(this, 2131954355, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy14, R.drawable.ic_aristocracy14_2, false, BaseViewControllerKt.getString(this, 2131954357, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy15, R.drawable.ic_aristocracy15_2, false, BaseViewControllerKt.getString(this, 2131954356, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy16, R.drawable.ic_aristocracy16_2, false, BaseViewControllerKt.getString(this, 2131952633, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy17, R.drawable.ic_aristocracy17_2, false, BaseViewControllerKt.getString(this, 2131953119, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy18, R.drawable.ic_aristocracy18_2, false, BaseViewControllerKt.getString(this, 2131952884, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy20, R.drawable.ic_aristocracy20_2, false, BaseViewControllerKt.getString(this, 2131952604, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy21, R.drawable.ic_aristocracy21_2, false, BaseViewControllerKt.getString(this, 2131952186, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy22, R.drawable.ic_aristocracy22_2, false, BaseViewControllerKt.getString(this, 2131952125, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy23, R.drawable.ic_aristocracy23_2, false, BaseViewControllerKt.getString(this, 2131953954, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy24, R.drawable.ic_aristocracy24_2, false, BaseViewControllerKt.getString(this, 2131953944, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy25, R.drawable.ic_aristocracy25_2, false, BaseViewControllerKt.getString(this, 2131953960, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy26, R.drawable.ic_aristocracy26_2, false, BaseViewControllerKt.getString(this, 2131953961, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy27, R.drawable.ic_aristocracy27_2, false, BaseViewControllerKt.getString(this, 2131952034, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy28, R.drawable.ic_aristocracy28_2, false, BaseViewControllerKt.getString(this, 2131952035, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy29, R.drawable.ic_aristocracy29_2, false, BaseViewControllerKt.getString(this, 2131952036, new Object[0])));
        arrayList.add(new AristocracyPermissionBean(R.drawable.ic_aristocracy30, R.drawable.ic_aristocracy30_2, false, BaseViewControllerKt.getString(this, 2131952039, new Object[0])));
        return arrayList;
    }

    private final void getNoble8(int level) {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getNobleAward(level), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.c0
            public final Object invoke(Object obj) {
                Unit noble8$lambda$40;
                noble8$lambda$40 = BuyAristocracyViewController.getNoble8$lambda$40(BuyAristocracyViewController.this, (ApiResponse) obj);
                return noble8$lambda$40;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.d0
            public final Object invoke(Object obj) {
                Unit noble8$lambda$41;
                noble8$lambda$41 = BuyAristocracyViewController.getNoble8$lambda$41(BuyAristocracyViewController.this, (Throwable) obj);
                return noble8$lambda$41;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    static /* synthetic */ void getNoble8$default(BuyAristocracyViewController buyAristocracyViewController, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8;
        }
        buyAristocracyViewController.getNoble8(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNoble8$lambda$40(BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, buyAristocracyViewController.getRequireActivity(), ResourcesKtxKt.getStringById(buyAristocracyViewController, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        buyAristocracyViewController.checkNoble();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNoble8$lambda$41(BuyAristocracyViewController buyAristocracyViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            BaseActivity requireActivity = buyAristocracyViewController.getRequireActivity();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(buyAristocracyViewController, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, requireActivity, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void getNobleConfigData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getNobleConfig(), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.f0
            public final Object invoke(Object obj) {
                Unit nobleConfigData$lambda$23;
                nobleConfigData$lambda$23 = BuyAristocracyViewController.getNobleConfigData$lambda$23(BuyAristocracyViewController.this, (ApiResponse) obj);
                return nobleConfigData$lambda$23;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.g0
            public final Object invoke(Object obj) {
                Unit nobleConfigData$lambda$24;
                nobleConfigData$lambda$24 = BuyAristocracyViewController.getNobleConfigData$lambda$24(BuyAristocracyViewController.this, (Throwable) obj);
                return nobleConfigData$lambda$24;
            }
        }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNobleConfigData$lambda$23(final BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        buyAristocracyViewController.mNobleBeanConfigList.clear();
        buyAristocracyViewController.mMyNobleBeanItemList.clear();
        List list = (List) apiResponse.getData();
        if (list != null) {
            if (list.size() > 10) {
                buyAristocracyViewController.mNobleBeanConfigList.addAll(list.subList(0, 10));
            } else {
                buyAristocracyViewController.mNobleBeanConfigList.addAll(list);
            }
        }
        buyAristocracyViewController.outPutOtherModuleService.setMNobleBeanConfigList(buyAristocracyViewController.mNobleBeanConfigList);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getMyNobleDetail(), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.v
            public final Object invoke(Object obj) {
                Unit nobleConfigData$lambda$23$lambda$21;
                nobleConfigData$lambda$23$lambda$21 = BuyAristocracyViewController.getNobleConfigData$lambda$23$lambda$21(BuyAristocracyViewController.this, (ApiResponse) obj);
                return nobleConfigData$lambda$23$lambda$21;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.w
            public final Object invoke(Object obj) {
                Unit nobleConfigData$lambda$23$lambda$22;
                nobleConfigData$lambda$23$lambda$22 = BuyAristocracyViewController.getNobleConfigData$lambda$23$lambda$22(BuyAristocracyViewController.this, (Throwable) obj);
                return nobleConfigData$lambda$23$lambda$22;
            }
        }, (Function0) null, false, 12, (Object) null), buyAristocracyViewController.getCompositeDisposable());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNobleConfigData$lambda$23$lambda$21(BuyAristocracyViewController buyAristocracyViewController, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List list = (List) apiResponse.getData();
        if (list != null) {
            buyAristocracyViewController.mMyNobleBeanItemList.addAll(list);
        }
        if (!buyAristocracyViewController.mNobleBeanConfigList.isEmpty() && !buyAristocracyViewController.mMyNobleBeanItemList.isEmpty()) {
            if (buyAristocracyViewController.mNobleBeanConfigList.size() == 10) {
                buyAristocracyViewController.mCurrentNobleBeanConfig = buyAristocracyViewController.mNobleBeanConfigList.get(buyAristocracyViewController.getMDataBinding().viewPager.getCurrentItem());
                int size = buyAristocracyViewController.mNobleBeanConfigList.size();
                for (int i = 0; i < size; i++) {
                    View view = buyAristocracyViewController.viewPagerViews.get(i);
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.aristocracy.AristocracyWrapper");
                    NobleBeanConfig nobleBeanConfig = buyAristocracyViewController.mNobleBeanConfigList.get(i);
                    Intrinsics.checkNotNullExpressionValue(nobleBeanConfig, "get(...)");
                    ((AristocracyWrapper) view).setDataAndShowView(nobleBeanConfig, buyAristocracyViewController.getNobilityListView(), buyAristocracyViewController.mMyNobleBeanItemList);
                }
                int level = buyAristocracyViewController.mMyNobleBeanItemList.get(0).getLevel();
                if (level <= 10) {
                    buyAristocracyViewController.getMDataBinding().viewPager.setCurrentItem(level - 1);
                }
                buyAristocracyViewController.refreshShowView(buyAristocracyViewController.getMDataBinding().viewPager.getCurrentItem());
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNobleConfigData$lambda$23$lambda$22(BuyAristocracyViewController buyAristocracyViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = buyAristocracyViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(buyAristocracyViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNobleConfigData$lambda$24(BuyAristocracyViewController buyAristocracyViewController, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = buyAristocracyViewController.getContext();
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            str = BaseViewControllerKt.getString(buyAristocracyViewController, 2131952667, new Object[0]);
        } else {
            str = localizedMessage;
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    private final void getNobleConfigDataFromCache() {
        if (!this.outPutOtherModuleService.getMNobleBeanConfigList().isEmpty()) {
            ArrayList<NobleBeanConfig> mNobleBeanConfigList = this.outPutOtherModuleService.getMNobleBeanConfigList();
            this.mNobleBeanConfigList = mNobleBeanConfigList;
            if (mNobleBeanConfigList.size() == 10) {
                this.mCurrentNobleBeanConfig = this.mNobleBeanConfigList.get(getMDataBinding().viewPager.getCurrentItem());
                int size = this.mNobleBeanConfigList.size();
                for (int i = 0; i < size; i++) {
                    View view = this.viewPagerViews.get(i);
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.aristocracy.AristocracyWrapper");
                    NobleBeanConfig nobleBeanConfig = this.mNobleBeanConfigList.get(i);
                    Intrinsics.checkNotNullExpressionValue(nobleBeanConfig, "get(...)");
                    ((AristocracyWrapper) view).setDataAndShowView(nobleBeanConfig, getNobilityListView(), this.mMyNobleBeanItemList);
                }
                refreshShowView(getMDataBinding().viewPager.getCurrentItem());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper10_delegate$lambda$12(BuyAristocracyViewController buyAristocracyViewController) {
        AristocracyWrapper aristocracyWrapper = new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
        aristocracyWrapper.setMNobelPosition(10);
        return aristocracyWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper1_delegate$lambda$0(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper2_delegate$lambda$1(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper3_delegate$lambda$2(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper4_delegate$lambda$3(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper5_delegate$lambda$4(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper6_delegate$lambda$5(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper7_delegate$lambda$6(BuyAristocracyViewController buyAristocracyViewController) {
        return new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper8_delegate$lambda$8(BuyAristocracyViewController buyAristocracyViewController) {
        AristocracyWrapper aristocracyWrapper = new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
        aristocracyWrapper.setMNobelPosition(8);
        return aristocracyWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AristocracyWrapper mAristocracyWrapper9_delegate$lambda$10(BuyAristocracyViewController buyAristocracyViewController) {
        AristocracyWrapper aristocracyWrapper = new AristocracyWrapper(buyAristocracyViewController.getRequireContext());
        aristocracyWrapper.setMNobelPosition(9);
        return aristocracyWrapper;
    }

    private final void refreshShowView(int position) {
        String picUrl;
        if (this.mNobleBeanConfigList.size() != 0 && position < this.mNobleBeanConfigList.size()) {
            this.mCurrentNobleBeanConfig = this.mNobleBeanConfigList.get(position);
            this.mSelectNobleLevel = 0;
            int level = this.mNobleBeanConfigList.get(position).getLevel();
            getMDataBinding().delete.setVisibility(8);
            if (this.mMyNobleBeanItemList.isEmpty()) {
                getMDataBinding().remainTime.setVisibility(4);
            } else {
                int size = this.mMyNobleBeanItemList.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    MyNobleBeanItem myNobleBeanItem = this.mMyNobleBeanItemList.get(i);
                    Intrinsics.checkNotNullExpressionValue(myNobleBeanItem, "get(...)");
                    MyNobleBeanItem myNobleBeanItem2 = myNobleBeanItem;
                    if (myNobleBeanItem2.getLevel() == level) {
                        this.mSelectNobleLevel = level;
                        if (myNobleBeanItem2.getRemainTime() >= 0) {
                            getMDataBinding().remainTime.setVisibility(0);
                            getMDataBinding().delete.setVisibility(0);
                            getMDataBinding().remainTime.setText(DateTimeUtilityKt.changeSecondsToDay(myNobleBeanItem2.getRemainTime()) + BaseViewControllerKt.getString(this, 2131952503, new Object[0]));
                            z = true;
                        }
                    }
                }
                if (!z) {
                    getMDataBinding().remainTime.setVisibility(4);
                }
            }
            getMDataBinding().nobleLevel.setText(this.titles[position]);
            getMDataBinding().diamondText.setText(String.valueOf(this.mNobleBeanConfigList.get(position).getPurchasePrice()));
            getMDataBinding().tip.setText(String.valueOf(this.mNobleBeanConfigList.get(position).getRenewalPrice()));
            getMDataBinding().tip1.setText("/" + BaseViewControllerKt.getString(this, 2131953414, new Object[0]));
            getMDataBinding().days.setText("/30" + BaseViewControllerKt.getString(this, 2131952501, new Object[0]));
            NobleBeanConfig nobleBeanConfig = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig != null && (picUrl = nobleBeanConfig.getPicUrl()) != null) {
                ImageView imageView = getMDataBinding().tipIcon;
                Intrinsics.checkNotNullExpressionValue(imageView, "tipIcon");
                ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
                Dimens dimens = Dimens.INSTANCE;
                lfit.setWidth(dimens.dpToPx(UserProxyUtility.roomAllGift));
                lfit.setHeight(dimens.dpToPx(UserProxyUtility.exitRoom));
                Unit unit = Unit.INSTANCE;
                ImageUIModel displayImage = companion.displayImage(picUrl, lfit);
                displayImage.setPlaceholder(null);
                ViewUtilitiesKt.bind(imageView, displayImage);
            }
        }
    }

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    private final void unRegisterEventBus() {
        if (cf.c.c().j(this)) {
            cf.c.c().r(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$13(BuyAristocracyViewController buyAristocracyViewController, int i, int i2) {
        ViewKtxKt.setMargin(buyAristocracyViewController.getMDataBinding().toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$16(final BuyAristocracyViewController buyAristocracyViewController) {
        buyAristocracyViewController.getNobleConfigDataFromCache();
        buyAristocracyViewController.getNobleConfigData();
        buyAristocracyViewController.checkNoble();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, -50.0f, 0.0f);
        ofFloat.setDuration(2500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.e0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BuyAristocracyViewController.viewDidLoad$lambda$16$lambda$15$lambda$14(BuyAristocracyViewController.this, valueAnimator);
            }
        });
        buyAristocracyViewController.mAnimator = ofFloat;
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewDidLoad$lambda$16$lambda$15$lambda$14(BuyAristocracyViewController buyAristocracyViewController, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        buyAristocracyViewController.getMDataBinding().tipIcon.setTranslationY(((Float) animatedValue).floatValue());
    }

    public final void confirmToBuy() {
        int purchasePrice;
        double d;
        int size = this.mMyNobleBeanItemList.size();
        int i = 0;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            NobleBeanConfig nobleBeanConfig = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig != null && this.mMyNobleBeanItemList.get(i2).getLevel() == nobleBeanConfig.getLevel()) {
                z = true;
            }
        }
        if (z) {
            NobleBeanConfig nobleBeanConfig2 = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig2 != null) {
                purchasePrice = nobleBeanConfig2.getRenewalPrice();
            }
            purchasePrice = 0;
        } else {
            NobleBeanConfig nobleBeanConfig3 = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig3 != null) {
                purchasePrice = nobleBeanConfig3.getPurchasePrice();
            }
            purchasePrice = 0;
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (d > purchasePrice) {
            UserService shared = UserService.INSTANCE.getShared();
            NobleBeanConfig nobleBeanConfig4 = this.mCurrentNobleBeanConfig;
            if (nobleBeanConfig4 != null) {
                i = nobleBeanConfig4.getLevel();
            }
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.buyNoble(i), new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.n
                public final Object invoke(Object obj) {
                    Unit confirmToBuy$lambda$28;
                    confirmToBuy$lambda$28 = BuyAristocracyViewController.confirmToBuy$lambda$28(BuyAristocracyViewController.this, (ApiResponse) obj);
                    return confirmToBuy$lambda$28;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.aristocracy.y
                public final Object invoke(Object obj) {
                    Unit confirmToBuy$lambda$29;
                    confirmToBuy$lambda$29 = BuyAristocracyViewController.confirmToBuy$lambda$29(BuyAristocracyViewController.this, (Throwable) obj);
                    return confirmToBuy$lambda$29;
                }
            }, (Function0) null, false, 12, (Object) null), getCompositeDisposable());
            return;
        }
        confirmPurchase();
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void doDestroyView(@NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        super.doDestroyView(container);
        getMDataBinding().topSvga.clear();
        getMDataBinding().buttonSvga.clear();
        unRegisterEventBus();
        this.mListener = null;
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Nullable
    public final ValueAnimator getMAnimator() {
        return this.mAnimator;
    }

    @Nullable
    public final NobleBeanConfig getMCurrentNobleBeanConfig() {
        return this.mCurrentNobleBeanConfig;
    }

    @NotNull
    public final ViewControllerBuyAristocracyIdentityBinding getMDataBinding() {
        ViewControllerBuyAristocracyIdentityBinding viewControllerBuyAristocracyIdentityBinding = this.mDataBinding;
        if (viewControllerBuyAristocracyIdentityBinding != null) {
            return viewControllerBuyAristocracyIdentityBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mDataBinding");
        return null;
    }

    @Nullable
    public final ControllerListener getMListener() {
        return this.mListener;
    }

    @NotNull
    public final ArrayList<MyNobleBeanItem> getMMyNobleBeanItemList() {
        return this.mMyNobleBeanItemList;
    }

    @NotNull
    public final ArrayList<NobleBeanConfig> getMNobleBeanConfigList() {
        return this.mNobleBeanConfigList;
    }

    public final int getMSelectNobleLevel() {
        return this.mSelectNobleLevel;
    }

    @NotNull
    public final OutPutOtherModuleService getOutPutOtherModuleService() {
        return this.outPutOtherModuleService;
    }

    @NotNull
    public final String[] getTitles() {
        return this.titles;
    }

    @NotNull
    public final ArrayList<View> getViewPagerViews() {
        return this.viewPagerViews;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public boolean onBackPressed() {
        getCompositeDisposable().d();
        return super.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        double d;
        Intrinsics.checkNotNullParameter(v, "v");
        int i = 0;
        switch (v.getId()) {
            case R.id.back_image_view /* 2131362039 */:
                ControllerListener controllerListener = this.mListener;
                if (controllerListener != null) {
                    controllerListener.onBackPress();
                    return;
                }
                return;
            case R.id.bag /* 2131362048 */:
                AristocracyBagActivity.INSTANCE.start(getRequireContext());
                return;
            case R.id.card /* 2131362228 */:
                VipRecordsActivity.INSTANCE.start(getRequireContext(), 0);
                return;
            case 2131362625:
                new TipDialog(getRequireContext()).setTipContent(ResourcesKtxKt.getStringById(this, 2131952335)).setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.aristocracy.BuyAristocracyViewController$onClick$2
                    public void cancel() {
                        OnCommonDialogListener.DefaultImpls.cancel(this);
                    }

                    public void confirm() {
                        BuyAristocracyViewController.this.deleteNoble();
                    }
                }).show();
                return;
            case R.id.text_bay /* 2131365082 */:
                confirmBuy();
                return;
            case R.id.text_send /* 2131365108 */:
                if (this.mCurrentNobleBeanConfig == null) {
                    return;
                }
                User user = UserStore.INSTANCE.getShared().getUser();
                if (user != null) {
                    d = user.getDiamondNum();
                } else {
                    d = 0.0d;
                }
                NobleBeanConfig nobleBeanConfig = this.mCurrentNobleBeanConfig;
                if (nobleBeanConfig != null) {
                    i = nobleBeanConfig.getPurchasePrice();
                }
                if (d > i) {
                    ShareLikeMeOrContactsViewController shareLikeMeOrContactsViewController = new ShareLikeMeOrContactsViewController();
                    shareLikeMeOrContactsViewController.setDelegate(this);
                    ViewController.present$default(this, shareLikeMeOrContactsViewController, true, null, 4, null);
                    return;
                }
                confirmPurchase();
                return;
            default:
                return;
        }
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        setMDataBinding(ViewControllerBuyAristocracyIdentityBinding.inflate(inflater, container, false));
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
        refreshShowView(position);
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRefreshEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "REFRESH_ARISTOCRACY")) {
            getNobleConfigData();
        }
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        getMDataBinding().viewPager.setCurrentItem(position);
    }

    @Override // com.qiahao.nextvideo.ui.share.ShareLikeMeOrContactsListener
    public void selectUser(@NotNull User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        if (this.mCurrentNobleBeanConfig != null) {
            confirmUserSend(user);
        }
    }

    public final void setMAnimator(@Nullable ValueAnimator valueAnimator) {
        this.mAnimator = valueAnimator;
    }

    public final void setMCurrentNobleBeanConfig(@Nullable NobleBeanConfig nobleBeanConfig) {
        this.mCurrentNobleBeanConfig = nobleBeanConfig;
    }

    public final void setMDataBinding(@NotNull ViewControllerBuyAristocracyIdentityBinding viewControllerBuyAristocracyIdentityBinding) {
        Intrinsics.checkNotNullParameter(viewControllerBuyAristocracyIdentityBinding, "<set-?>");
        this.mDataBinding = viewControllerBuyAristocracyIdentityBinding;
    }

    public final void setMListener(@Nullable ControllerListener controllerListener) {
        this.mListener = controllerListener;
    }

    public final void setMMyNobleBeanItemList(@NotNull ArrayList<MyNobleBeanItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mMyNobleBeanItemList = arrayList;
    }

    public final void setMNobleBeanConfigList(@NotNull ArrayList<NobleBeanConfig> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mNobleBeanConfigList = arrayList;
    }

    public final void setMSelectNobleLevel(int i) {
        this.mSelectNobleLevel = i;
    }

    public final void setTitles(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.titles = strArr;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        registerEventBus();
        HiloBaseActivity hiloBaseActivity = get_activity();
        if (hiloBaseActivity != null) {
            AppCompatImageView appCompatImageView = getMDataBinding().backImageView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "backImageView");
            hiloBaseActivity.getStatusBarTopOrBottom(appCompatImageView, new Function2() { // from class: com.qiahao.nextvideo.ui.aristocracy.h0
                public final Object invoke(Object obj, Object obj2) {
                    Unit viewDidLoad$lambda$13;
                    viewDidLoad$lambda$13 = BuyAristocracyViewController.viewDidLoad$lambda$13(BuyAristocracyViewController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                    return viewDidLoad$lambda$13;
                }
            });
        }
        HiloBaseActivity hiloBaseActivity2 = get_activity();
        if (hiloBaseActivity2 != null) {
            hiloBaseActivity2.setStatusBarIconColor(false);
        }
        this.viewPagerViews.add(getMAristocracyWrapper1());
        this.viewPagerViews.add(getMAristocracyWrapper2());
        this.viewPagerViews.add(getMAristocracyWrapper3());
        this.viewPagerViews.add(getMAristocracyWrapper4());
        this.viewPagerViews.add(getMAristocracyWrapper5());
        this.viewPagerViews.add(getMAristocracyWrapper6());
        this.viewPagerViews.add(getMAristocracyWrapper7());
        this.viewPagerViews.add(getMAristocracyWrapper8());
        this.viewPagerViews.add(getMAristocracyWrapper9());
        this.viewPagerViews.add(getMAristocracyWrapper10());
        getMDataBinding().viewPager.setAdapter(new GroupViewPagerAdapter(this.viewPagerViews));
        getMDataBinding().viewPager.setOffscreenPageLimit(this.viewPagerViews.size());
        getMDataBinding().viewPager.setCurrentItem(0);
        getMDataBinding().viewPager.addOnPageChangeListener(this);
        getMDataBinding().setClick(this);
        getMDataBinding().commonTabLayout.l(getMDataBinding().viewPager, this.titles);
        getMDataBinding().commonTabLayout.setCurrentTab(0);
        getMDataBinding().commonTabLayout.setOnTabSelectListener(this);
        getMDataBinding().commonTabLayout.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.aristocracy.i0
            @Override // java.lang.Runnable
            public final void run() {
                BuyAristocracyViewController.viewDidLoad$lambda$16(BuyAristocracyViewController.this);
            }
        }, 350L);
    }
}
