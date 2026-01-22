package com.qiahao.nextvideo.ui.home.group;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import c5.g;
import cf.m;
import com.flyco.tablayout.SlidingTabLayout;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentHomeRoomBinding;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.qiahao.nextvideo.room.view.HomeRoomBannerView;
import com.qiahao.nextvideo.ui.home.discover.DiscoverFragment;
import com.qiahao.nextvideo.ui.home.group.my.MyRoomFragment;
import com.qiahao.nextvideo.ui.home.group.newCreate.NewRoomFragment;
import com.qiahao.nextvideo.ui.home.group.popular.PopularFragment;
import com.qiahao.nextvideo.ui.home.group.search.SearchActivity;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/HomeRoomFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentHomeRoomBinding;", "<init>", "()V", "getLayoutResId", "", "mViewSize", "mCurrentPosition", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "getMFragments", "()Ljava/util/ArrayList;", "onInitialize", "", "initView", "refreshSkin", "changeFirstInitView", "position", "processStatusBarCover", "updateTextSize", "onEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "onResume", "onPause", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeRoomFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeRoomFragment.kt\ncom/qiahao/nextvideo/ui/home/group/HomeRoomFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,224:1\n61#2,9:225\n1#3:234\n*S KotlinDebug\n*F\n+ 1 HomeRoomFragment.kt\ncom/qiahao/nextvideo/ui/home/group/HomeRoomFragment\n*L\n131#1:225,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeRoomFragment extends BaseBindingFragment<FragmentHomeRoomBinding> {
    private int mCurrentPosition;
    private int mViewSize = 4;

    @NotNull
    private final ArrayList<Fragment> mFragments = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void changeFirstInitView(int position) {
        FragmentHomeRoomBinding fragmentHomeRoomBinding;
        ConstraintLayout constraintLayout;
        FragmentHomeRoomBinding fragmentHomeRoomBinding2;
        ConstraintLayout constraintLayout2;
        FragmentHomeRoomBinding fragmentHomeRoomBinding3;
        ConstraintLayout constraintLayout3;
        FragmentHomeRoomBinding fragmentHomeRoomBinding4;
        ConstraintLayout constraintLayout4;
        if (position == 0 && (fragmentHomeRoomBinding4 = (FragmentHomeRoomBinding) getBinding()) != null && (constraintLayout4 = fragmentHomeRoomBinding4.container) != null) {
            constraintLayout4.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#F2F4F7", "#F2F4F7", 0, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (position == 1 && (fragmentHomeRoomBinding3 = (FragmentHomeRoomBinding) getBinding()) != null && (constraintLayout3 = fragmentHomeRoomBinding3.container) != null) {
            constraintLayout3.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#F2F4F7", "#F2F4F7", 0, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (position == 2 && (fragmentHomeRoomBinding2 = (FragmentHomeRoomBinding) getBinding()) != null && (constraintLayout2 = fragmentHomeRoomBinding2.container) != null) {
            constraintLayout2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 0, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (position == 3 && (fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding()) != null && (constraintLayout = fragmentHomeRoomBinding.container) != null) {
            constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#F2F4F7", "#F2F4F7", 0, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
    }

    private final void processStatusBarCover() {
        ConstraintLayout constraintLayout;
        FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding != null && (constraintLayout = fragmentHomeRoomBinding.title) != null) {
            constraintLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.group.b
                @Override // java.lang.Runnable
                public final void run() {
                    HomeRoomFragment.processStatusBarCover$lambda$7(HomeRoomFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processStatusBarCover$lambda$7(final HomeRoomFragment homeRoomFragment) {
        ConstraintLayout constraintLayout;
        FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) homeRoomFragment.getBinding();
        if (fragmentHomeRoomBinding != null) {
            constraintLayout = fragmentHomeRoomBinding.title;
        } else {
            constraintLayout = null;
        }
        homeRoomFragment.getStatusBarTopOrBottom(constraintLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.home.group.a
            public final Object invoke(Object obj, Object obj2) {
                Unit processStatusBarCover$lambda$7$lambda$6;
                processStatusBarCover$lambda$7$lambda$6 = HomeRoomFragment.processStatusBarCover$lambda$7$lambda$6(HomeRoomFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return processStatusBarCover$lambda$7$lambda$6;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processStatusBarCover$lambda$7$lambda$6(HomeRoomFragment homeRoomFragment, int i, int i2) {
        ConstraintLayout constraintLayout;
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout.b bVar;
        ConstraintLayout constraintLayout2;
        FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) homeRoomFragment.getBinding();
        if (fragmentHomeRoomBinding != null && (constraintLayout = fragmentHomeRoomBinding.title) != null) {
            FragmentHomeRoomBinding fragmentHomeRoomBinding2 = (FragmentHomeRoomBinding) homeRoomFragment.getBinding();
            ConstraintLayout.b bVar2 = null;
            if (fragmentHomeRoomBinding2 != null && (constraintLayout2 = fragmentHomeRoomBinding2.title) != null) {
                layoutParams = constraintLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof ConstraintLayout.b) {
                bVar = (ConstraintLayout.b) layoutParams;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = Dimens.INSTANCE.dpToPx(42);
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = i;
                bVar2 = bVar;
            }
            constraintLayout.setLayoutParams(bVar2);
        }
        return Unit.INSTANCE;
    }

    private final void refreshSkin() {
        String str;
        ImageView imageView;
        Drawable drawable;
        ImageView imageView2;
        SkinMessage skinMessage = SkinMessage.INSTANCE;
        SkinData skinData = skinMessage.skinData();
        if (skinData == null || (str = skinData.getTopBg1()) == null) {
            str = "";
        }
        File file = new File(str);
        if (skinMessage.checkSkin() && file.exists() && file.isFile()) {
            FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding();
            if (fragmentHomeRoomBinding != null && (imageView2 = fragmentHomeRoomBinding.topBg) != null) {
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65531, (Object) null);
                return;
            }
            return;
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding2 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding2 != null && (imageView = fragmentHomeRoomBinding2.topBg) != null) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.ic_group_top_bg_all);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTextSize(int position) {
        TextView textView;
        SlidingTabLayout slidingTabLayout;
        int i = this.mViewSize;
        for (int i2 = 0; i2 < i; i2++) {
            FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding();
            if (fragmentHomeRoomBinding != null && (slidingTabLayout = fragmentHomeRoomBinding.tabLayout) != null) {
                textView = slidingTabLayout.h(i2);
            } else {
                textView = null;
            }
            if (position == i2) {
                if (textView != null) {
                    textView.setTextSize(17.0f);
                }
                if (textView != null) {
                    textView.setTypeface(null, 1);
                }
            } else {
                if (textView != null) {
                    textView.setTextSize(16.0f);
                }
                if (textView != null) {
                    textView.setTypeface(null, 1);
                }
            }
        }
    }

    protected int getLayoutResId() {
        return R.layout.fragment_home_room;
    }

    @NotNull
    public final ArrayList<Fragment> getMFragments() {
        return this.mFragments;
    }

    public final void initView() {
        int i;
        final ImageView imageView;
        ViewPager viewPager;
        ViewPager viewPager2;
        SlidingTabLayout slidingTabLayout;
        SlidingTabLayout slidingTabLayout2;
        ViewPager viewPager3;
        ViewPager viewPager4;
        ViewPager viewPager5;
        if (this.mFragments.isEmpty()) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            MyRoomFragment findFragment = fragmentUtils.findFragment(getChildFragmentManager(), MyRoomFragment.class);
            if (findFragment == null) {
                findFragment = new MyRoomFragment();
            }
            this.mFragments.add(findFragment);
            PopularFragment findFragment2 = fragmentUtils.findFragment(getChildFragmentManager(), PopularFragment.class);
            if (findFragment2 == null) {
                findFragment2 = new PopularFragment();
            }
            this.mFragments.add(findFragment2);
            DiscoverFragment findFragment3 = fragmentUtils.findFragment(getChildFragmentManager(), DiscoverFragment.class);
            if (findFragment3 == null) {
                findFragment3 = new DiscoverFragment();
            }
            this.mFragments.add(findFragment3);
            NewRoomFragment findFragment4 = fragmentUtils.findFragment(getChildFragmentManager(), NewRoomFragment.class);
            if (findFragment4 == null) {
                findFragment4 = new NewRoomFragment();
            }
            this.mFragments.add(findFragment4);
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding != null && (viewPager5 = fragmentHomeRoomBinding.viewPager) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            viewPager5.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, this.mFragments));
        }
        this.mViewSize = this.mFragments.size();
        FragmentHomeRoomBinding fragmentHomeRoomBinding2 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding2 != null && (viewPager4 = fragmentHomeRoomBinding2.viewPager) != null) {
            viewPager4.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.home.group.HomeRoomFragment$initView$1
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                    SlidingTabLayout slidingTabLayout3;
                    FragmentHomeRoomBinding fragmentHomeRoomBinding3 = (FragmentHomeRoomBinding) HomeRoomFragment.this.getBinding();
                    if (fragmentHomeRoomBinding3 != null && (slidingTabLayout3 = fragmentHomeRoomBinding3.tabLayout) != null) {
                        slidingTabLayout3.setCurrentTab(position);
                    }
                    HomeRoomFragment.this.updateTextSize(position);
                    UserService.INSTANCE.setOldSecondPagerTap(position);
                    HomeRoomFragment.this.mCurrentPosition = position;
                    HomeRoomFragment.this.changeFirstInitView(position);
                }
            });
        }
        String[] strArr = {ResourcesKtxKt.getStringById(this, 2131953887), ResourcesKtxKt.getStringById(this, 2131953696), ResourcesKtxKt.getStringById(this, 2131952574), ResourcesKtxKt.getStringById(this, 2131953516)};
        FragmentHomeRoomBinding fragmentHomeRoomBinding3 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding3 != null && (slidingTabLayout2 = fragmentHomeRoomBinding3.tabLayout) != null) {
            FragmentHomeRoomBinding fragmentHomeRoomBinding4 = (FragmentHomeRoomBinding) getBinding();
            if (fragmentHomeRoomBinding4 != null) {
                viewPager3 = fragmentHomeRoomBinding4.viewPager;
            } else {
                viewPager3 = null;
            }
            slidingTabLayout2.l(viewPager3, strArr);
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding5 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding5 != null && (slidingTabLayout = fragmentHomeRoomBinding5.tabLayout) != null) {
            slidingTabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.home.group.HomeRoomFragment$initView$2
                public void onTabReselect(int position) {
                }

                public void onTabSelect(int position) {
                    ViewPager viewPager6;
                    HomeRoomFragment.this.mCurrentPosition = position;
                    FragmentHomeRoomBinding fragmentHomeRoomBinding6 = (FragmentHomeRoomBinding) HomeRoomFragment.this.getBinding();
                    if (fragmentHomeRoomBinding6 != null && (viewPager6 = fragmentHomeRoomBinding6.viewPager) != null) {
                        viewPager6.setCurrentItem(position);
                    }
                }
            });
        }
        UserService.Companion companion = UserService.INSTANCE;
        int i2 = 1;
        if (companion.getOldHomeViewControllerTap() == 1) {
            int oldSecondPagerTap = companion.getOldSecondPagerTap();
            if (oldSecondPagerTap == -1) {
                oldSecondPagerTap = 1;
            }
            if (oldSecondPagerTap < this.mFragments.size()) {
                i2 = oldSecondPagerTap;
            }
            FragmentHomeRoomBinding fragmentHomeRoomBinding6 = (FragmentHomeRoomBinding) getBinding();
            if (fragmentHomeRoomBinding6 != null && (viewPager2 = fragmentHomeRoomBinding6.viewPager) != null) {
                viewPager2.setCurrentItem(i2);
            }
            changeFirstInitView(i2);
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding7 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding7 != null && (viewPager = fragmentHomeRoomBinding7.viewPager) != null) {
            i = viewPager.getCurrentItem();
        } else {
            i = 0;
        }
        updateTextSize(i);
        FragmentHomeRoomBinding fragmentHomeRoomBinding8 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding8 != null && (imageView = fragmentHomeRoomBinding8.search) != null) {
            final long j = 800;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.HomeRoomFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            SearchActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.getCountry() != null) {
            companion.getShared().userAppLanguage();
        }
        refreshSkin();
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull EventBusKey event) {
        FragmentHomeRoomBinding fragmentHomeRoomBinding;
        HomeRoomBannerView homeRoomBannerView;
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "REFRESH_HOME_MAIN_ACTIVITY") && (fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding()) != null && (homeRoomBannerView = fragmentHomeRoomBinding.banner) != null) {
            homeRoomBannerView.refreshData();
        }
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        processStatusBarCover();
    }

    public void onPause() {
        HomeRoomBannerView homeRoomBannerView;
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding != null && (homeRoomBannerView = fragmentHomeRoomBinding.banner) != null) {
            homeRoomBannerView.startOrStopAnimation(false);
        }
    }

    public void onResume() {
        int i;
        ViewPager viewPager;
        HomeRoomBannerView homeRoomBannerView;
        SlidingTabLayout slidingTabLayout;
        ViewPager viewPager2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        int oldSecondPagerTap = UserService.INSTANCE.getOldSecondPagerTap();
        if (oldSecondPagerTap == -1) {
            oldSecondPagerTap = 1;
        }
        if (oldSecondPagerTap >= this.mFragments.size()) {
            oldSecondPagerTap = 1;
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding != null && (viewPager2 = fragmentHomeRoomBinding.viewPager) != null) {
            viewPager2.setCurrentItem(oldSecondPagerTap);
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding2 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding2 != null && (slidingTabLayout = fragmentHomeRoomBinding2.tabLayout) != null) {
            slidingTabLayout.setCurrentTab(oldSecondPagerTap);
        }
        FragmentHomeRoomBinding fragmentHomeRoomBinding3 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding3 != null && (homeRoomBannerView = fragmentHomeRoomBinding3.banner) != null) {
            homeRoomBannerView.startOrStopAnimation(true);
        }
        changeFirstInitView(oldSecondPagerTap);
        FragmentHomeRoomBinding fragmentHomeRoomBinding4 = (FragmentHomeRoomBinding) getBinding();
        if (fragmentHomeRoomBinding4 != null && (viewPager = fragmentHomeRoomBinding4.viewPager) != null) {
            i = viewPager.getCurrentItem();
        } else {
            i = 0;
        }
        updateTextSize(i);
        processStatusBarCover();
    }
}
