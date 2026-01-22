package com.qiahao.nextvideo.ui.rank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.ViewPager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.ControllerListener;
import com.qiahao.base_common.ui.dialog.TipDialog;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.databinding.ViewControllerAllRankBinding;
import com.qiahao.nextvideo.ui.commonlist.interactivetracking.TabEntity;
import com.qiahao.nextvideo.ui.rank.CommonRankWrapper;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.BaseViewController;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u00012\u00020\u00022\u00020\u0003:\u00014B\u0011\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\u0007J\u0017\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u0017\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u0017\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\u0007J'\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001d2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020&8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\f0)j\b\u0012\u0004\u0012\u00020\f`*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/AllRankViewController;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/BaseViewController;", "Landroidx/viewpager/widget/ViewPager$j;", "Lo6/b;", "", "position", "<init>", "(I)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;", "view", "", "viewDidLoad", "(Landroid/view/View;)V", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "state", "onPageScrollStateChanged", "onTabSelect", "onTabReselect", "", "animated", "Lkotlin/Function0;", "completion", "dismiss", "(ZLkotlin/jvm/functions/Function0;)V", "I", "getPosition", "()I", "Lcom/qiahao/nextvideo/databinding/ViewControllerAllRankBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewControllerAllRankBinding;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "pageViews", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "mListener", "Lcom/qiahao/base_common/interfaceing/ControllerListener;", "getMListener", "()Lcom/qiahao/base_common/interfaceing/ControllerListener;", "setMListener", "(Lcom/qiahao/base_common/interfaceing/ControllerListener;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAllRankViewController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AllRankViewController.kt\ncom/qiahao/nextvideo/ui/rank/AllRankViewController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,144:1\n1#2:145\n61#3,9:146\n61#3,9:155\n13472#4,2:164\n*S KotlinDebug\n*F\n+ 1 AllRankViewController.kt\ncom/qiahao/nextvideo/ui/rank/AllRankViewController\n*L\n61#1:146,9\n64#1:155,9\n80#1:164,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AllRankViewController extends BaseViewController implements ViewPager.j, o6.b {

    @NotNull
    private static final String TAG = "AllRankViewController";
    private ViewControllerAllRankBinding binding;

    @Nullable
    private ControllerListener mListener;

    @NotNull
    private final ArrayList<View> pageViews;
    private final int position;

    public AllRankViewController() {
        this(0, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit viewDidLoad$lambda$1(AllRankViewController allRankViewController, int i, int i2) {
        ViewControllerAllRankBinding viewControllerAllRankBinding = allRankViewController.binding;
        if (viewControllerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding = null;
        }
        ViewKtxKt.setMargin(viewControllerAllRankBinding.toolbar, 0, Integer.valueOf(i), 0, 0);
        return Unit.INSTANCE;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void dismiss(boolean animated, @Nullable Function0<Unit> completion) {
        super.dismiss(animated, completion);
        this.mListener = null;
    }

    @Nullable
    public final ControllerListener getMListener() {
        return this.mListener;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @NotNull ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Intrinsics.checkNotNullParameter(container, "container");
        ViewControllerAllRankBinding inflate = ViewControllerAllRankBinding.inflate(inflater, container, false);
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
        ViewControllerAllRankBinding viewControllerAllRankBinding = this.binding;
        ViewControllerAllRankBinding viewControllerAllRankBinding2 = null;
        if (viewControllerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding = null;
        }
        viewControllerAllRankBinding.commonTabLayout.setCurrentTab(position);
        if (position != 0) {
            if (position != 1) {
                if (position == 2) {
                    ViewControllerAllRankBinding viewControllerAllRankBinding3 = this.binding;
                    if (viewControllerAllRankBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        viewControllerAllRankBinding2 = viewControllerAllRankBinding3;
                    }
                    viewControllerAllRankBinding2.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_room));
                }
            } else {
                ViewControllerAllRankBinding viewControllerAllRankBinding4 = this.binding;
                if (viewControllerAllRankBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    viewControllerAllRankBinding2 = viewControllerAllRankBinding4;
                }
                viewControllerAllRankBinding2.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_famous));
            }
        } else {
            ViewControllerAllRankBinding viewControllerAllRankBinding5 = this.binding;
            if (viewControllerAllRankBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewControllerAllRankBinding2 = viewControllerAllRankBinding5;
            }
            viewControllerAllRankBinding2.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_charm));
        }
        if (position != 0) {
            View view = this.pageViews.get(position);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CommonRankWrapper");
            ((CommonRankWrapper) view).initView();
        }
    }

    public void onTabReselect(int position) {
    }

    public void onTabSelect(int position) {
        ViewControllerAllRankBinding viewControllerAllRankBinding = this.binding;
        ViewControllerAllRankBinding viewControllerAllRankBinding2 = null;
        if (viewControllerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding = null;
        }
        viewControllerAllRankBinding.viewPager.setCurrentItem(position);
        if (position != 0) {
            if (position != 1) {
                if (position == 2) {
                    ViewControllerAllRankBinding viewControllerAllRankBinding3 = this.binding;
                    if (viewControllerAllRankBinding3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    } else {
                        viewControllerAllRankBinding2 = viewControllerAllRankBinding3;
                    }
                    viewControllerAllRankBinding2.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_room));
                    return;
                }
                return;
            }
            ViewControllerAllRankBinding viewControllerAllRankBinding4 = this.binding;
            if (viewControllerAllRankBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                viewControllerAllRankBinding2 = viewControllerAllRankBinding4;
            }
            viewControllerAllRankBinding2.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_famous));
            return;
        }
        ViewControllerAllRankBinding viewControllerAllRankBinding5 = this.binding;
        if (viewControllerAllRankBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerAllRankBinding2 = viewControllerAllRankBinding5;
        }
        viewControllerAllRankBinding2.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_charm));
    }

    public final void setMListener(@Nullable ControllerListener controllerListener) {
        this.mListener = controllerListener;
    }

    @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController
    public void viewDidLoad(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.viewDidLoad(view);
        HiloBaseActivity requireActivity = getRequireActivity();
        ViewControllerAllRankBinding viewControllerAllRankBinding = this.binding;
        ViewControllerAllRankBinding viewControllerAllRankBinding2 = null;
        if (viewControllerAllRankBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding = null;
        }
        FrameLayout frameLayout = viewControllerAllRankBinding.activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        requireActivity.getStatusBarTopOrBottom(frameLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.rank.a
            public final Object invoke(Object obj, Object obj2) {
                Unit viewDidLoad$lambda$1;
                viewDidLoad$lambda$1 = AllRankViewController.viewDidLoad$lambda$1(AllRankViewController.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return viewDidLoad$lambda$1;
            }
        });
        getRequireActivity().setStatusBarIconColor(false);
        ArrayList<View> arrayList = this.pageViews;
        CommonRankWrapper.Companion companion = CommonRankWrapper.INSTANCE;
        arrayList.add(companion.init(0, this));
        this.pageViews.add(companion.init(1, this));
        this.pageViews.add(companion.init(2, this));
        ViewControllerAllRankBinding viewControllerAllRankBinding3 = this.binding;
        if (viewControllerAllRankBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding3 = null;
        }
        viewControllerAllRankBinding3.viewPager.setAdapter(new CommonViewPagerAdapter(this.pageViews));
        ViewControllerAllRankBinding viewControllerAllRankBinding4 = this.binding;
        if (viewControllerAllRankBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding4 = null;
        }
        viewControllerAllRankBinding4.viewPager.setCurrentItem(this.position);
        ViewControllerAllRankBinding viewControllerAllRankBinding5 = this.binding;
        if (viewControllerAllRankBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding5 = null;
        }
        viewControllerAllRankBinding5.viewPager.addOnPageChangeListener(this);
        ViewControllerAllRankBinding viewControllerAllRankBinding6 = this.binding;
        if (viewControllerAllRankBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding6 = null;
        }
        final AppCompatImageView appCompatImageView = viewControllerAllRankBinding6.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.AllRankViewController$viewDidLoad$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    ControllerListener mListener = this.getMListener();
                    if (mListener != null) {
                        mListener.onBackPress();
                    }
                }
            }
        });
        ViewControllerAllRankBinding viewControllerAllRankBinding7 = this.binding;
        if (viewControllerAllRankBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding7 = null;
        }
        final ImageView imageView = viewControllerAllRankBinding7.icQuestion;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.rank.AllRankViewController$viewDidLoad$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ViewControllerAllRankBinding viewControllerAllRankBinding8;
                String stringById;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    viewControllerAllRankBinding8 = this.binding;
                    if (viewControllerAllRankBinding8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        viewControllerAllRankBinding8 = null;
                    }
                    int currentTab = viewControllerAllRankBinding8.commonTabLayout.getCurrentTab();
                    if (currentTab != 0) {
                        if (currentTab != 1) {
                            if (currentTab != 2) {
                                stringById = ResourcesKtxKt.getStringById(this, 2131953832);
                            } else {
                                stringById = ResourcesKtxKt.getStringById(this, 2131953830);
                            }
                        } else {
                            stringById = ResourcesKtxKt.getStringById(this, 2131953832);
                        }
                    } else {
                        stringById = ResourcesKtxKt.getStringById(this, 2131953831);
                    }
                    new TipDialog(this.getRequireContext()).setTipContent(stringById).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131953574)).hideCancel(true).show();
                }
            }
        });
        String[] strArr = {ResourcesKtxKt.getStringById(this, 2131952206), ResourcesKtxKt.getStringById(this, 2131952697), ResourcesKtxKt.getStringById(this, 2131952940)};
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < 3; i++) {
            arrayList2.add(new TabEntity(strArr[i], 0, 0));
        }
        ViewControllerAllRankBinding viewControllerAllRankBinding8 = this.binding;
        if (viewControllerAllRankBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding8 = null;
        }
        viewControllerAllRankBinding8.bgContent.setBackground(androidx.core.content.a.getDrawable(getRequireContext(), R.drawable.bg_rank_charm));
        ViewControllerAllRankBinding viewControllerAllRankBinding9 = this.binding;
        if (viewControllerAllRankBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding9 = null;
        }
        viewControllerAllRankBinding9.commonTabLayout.setTabData(arrayList2);
        ViewControllerAllRankBinding viewControllerAllRankBinding10 = this.binding;
        if (viewControllerAllRankBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            viewControllerAllRankBinding10 = null;
        }
        viewControllerAllRankBinding10.commonTabLayout.setCurrentTab(0);
        View view2 = this.pageViews.get(0);
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.qiahao.nextvideo.ui.rank.CommonRankWrapper");
        ((CommonRankWrapper) view2).initView();
        ViewControllerAllRankBinding viewControllerAllRankBinding11 = this.binding;
        if (viewControllerAllRankBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            viewControllerAllRankBinding2 = viewControllerAllRankBinding11;
        }
        viewControllerAllRankBinding2.commonTabLayout.setOnTabSelectListener(this);
    }

    public AllRankViewController(int i) {
        this.position = i;
        this.pageViews = new ArrayList<>();
        setTag(TAG);
    }

    public /* synthetic */ AllRankViewController(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }
}
