package com.qiahao.nextvideo.ui.home.community;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import c5.g;
import cf.m;
import com.google.android.material.tabs.TabLayout;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.widget.CustomTabLayout;
import com.qhqc.core.feature.community.ui.activity.PostsCreateActivity;
import com.qhqc.core.feature.community.ui.fragment.PostsSquareFragment;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.CommunityDoubleTabEvent;
import com.qiahao.base_common.model.eventBus.HomePageEvent;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.game.SkinData;
import com.qiahao.nextvideo.databinding.FragmentHomeCommunityBinding;
import com.qiahao.nextvideo.room.SkinMessage;
import com.qiahao.nextvideo.room.adapter.ViewPagerFragmentAdapter;
import com.tencent.qcloud.tuicore.TUIConstants;
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
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0012\u001a\u00020\nH\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020 H\u0007J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\"H\u0007R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/community/HomeCommunityFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentHomeCommunityBinding;", "<init>", "()V", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "pageViewSize", "", TUIConstants.TUILive.USER_ID, "", "globalFollowFragment", "Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;", "globalPlazaFragment", "mAnimator", "Landroid/animation/ValueAnimator;", "getLayoutResId", "onInitialize", "", "initView", "processStatusBarCover", "refreshSkin", "btnCreateAnim", "isShow", "", "cancelAnim", "scrollToTop", "event", "Lcom/qiahao/base_common/model/eventBus/CommunityDoubleTabEvent;", "setFollowUnRead", "Lcom/qiahao/nextvideo/ui/home/community/CommunityFollowUnReadEvent;", "onHomePageEvent", "Lcom/qiahao/base_common/model/eventBus/HomePageEvent;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHomeCommunityFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HomeCommunityFragment.kt\ncom/qiahao/nextvideo/ui/home/community/HomeCommunityFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,229:1\n61#2,9:230\n1#3:239\n*S KotlinDebug\n*F\n+ 1 HomeCommunityFragment.kt\ncom/qiahao/nextvideo/ui/home/community/HomeCommunityFragment\n*L\n100#1:230,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeCommunityFragment extends BaseBindingFragment<FragmentHomeCommunityBinding> {

    @Nullable
    private PostsSquareFragment globalFollowFragment;

    @Nullable
    private PostsSquareFragment globalPlazaFragment;

    @Nullable
    private ValueAnimator mAnimator;

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final int pageViewSize = 2;
    private long userId;

    /* JADX INFO: Access modifiers changed from: private */
    public final void btnCreateAnim(boolean isShow) {
        AppCompatImageView appCompatImageView;
        float f;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        float f2 = 0.1f;
        float f3 = 0.0f;
        if (isShow) {
            cancelAnim();
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding();
            if (fragmentHomeCommunityBinding != null && (appCompatImageView3 = fragmentHomeCommunityBinding.postBtn) != null) {
                f = appCompatImageView3.getAlpha();
            } else {
                f = 0.0f;
            }
            if (f < 1.0f) {
                FragmentHomeCommunityBinding fragmentHomeCommunityBinding2 = (FragmentHomeCommunityBinding) getBinding();
                if (fragmentHomeCommunityBinding2 != null && (appCompatImageView2 = fragmentHomeCommunityBinding2.postBtn) != null) {
                    f2 = appCompatImageView2.getAlpha();
                } else {
                    f2 = 0.0f;
                }
            }
            this.mAnimator = ValueAnimator.ofFloat(f2, 1.0f);
        } else {
            cancelAnim();
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding3 = (FragmentHomeCommunityBinding) getBinding();
            if (fragmentHomeCommunityBinding3 != null && (appCompatImageView = fragmentHomeCommunityBinding3.postBtn) != null) {
                f3 = appCompatImageView.getAlpha();
            }
            this.mAnimator = ValueAnimator.ofFloat(f3, 0.1f);
        }
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(500L);
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.home.community.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    HomeCommunityFragment.btnCreateAnim$lambda$12$lambda$11(HomeCommunityFragment.this, valueAnimator2);
                }
            });
            valueAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void btnCreateAnim$lambda$12$lambda$11(HomeCommunityFragment homeCommunityFragment, ValueAnimator valueAnimator) {
        AppCompatImageView appCompatImageView;
        Intrinsics.checkNotNullParameter(valueAnimator, "mVa");
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) homeCommunityFragment.getBinding();
        if (fragmentHomeCommunityBinding != null && (appCompatImageView = fragmentHomeCommunityBinding.postBtn) != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            appCompatImageView.setAlpha(((Float) animatedValue).floatValue());
        }
    }

    private final void cancelAnim() {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.mAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.mAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.mAnimator = null;
    }

    private final void initView() {
        ViewPager viewPager;
        CustomTabLayout customTabLayout;
        ViewPager viewPager2;
        final AppCompatImageView appCompatImageView;
        PostsSquareFragment postsSquareFragment;
        PostsSquareFragment postsSquareFragment2;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            this.userId = user.getId();
        }
        ViewPager viewPager3 = null;
        if (this.mFragments.isEmpty()) {
            FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
            PostsSquareFragment findFragment = fragmentUtils.findFragment(getChildFragmentManager(), PostsSquareFragment.class);
            if (findFragment == null) {
                findFragment = PostsSquareFragment.Companion.newInstance(2, this.userId);
                findFragment.setChangePostBtnListener(new PostsSquareFragment.ChangePostCreateBtnStyleListener() { // from class: com.qiahao.nextvideo.ui.home.community.HomeCommunityFragment$initView$2$1
                    public void noShowBtnAnim() {
                        HomeCommunityFragment.this.btnCreateAnim(false);
                    }

                    public void showBtnAnim() {
                        HomeCommunityFragment.this.btnCreateAnim(true);
                    }
                });
            }
            if (findFragment instanceof PostsSquareFragment) {
                postsSquareFragment = findFragment;
            } else {
                postsSquareFragment = null;
            }
            this.globalFollowFragment = postsSquareFragment;
            this.mFragments.add(findFragment);
            PostsSquareFragment findFragment2 = fragmentUtils.findFragment(getChildFragmentManager(), PostsSquareFragment.class);
            if (findFragment2 == null) {
                findFragment2 = PostsSquareFragment.Companion.newInstance(1, this.userId);
                findFragment2.setChangePostBtnListener(new PostsSquareFragment.ChangePostCreateBtnStyleListener() { // from class: com.qiahao.nextvideo.ui.home.community.HomeCommunityFragment$initView$3$1
                    public void noShowBtnAnim() {
                        HomeCommunityFragment.this.btnCreateAnim(false);
                    }

                    public void showBtnAnim() {
                        HomeCommunityFragment.this.btnCreateAnim(true);
                    }
                });
            }
            if (findFragment2 instanceof PostsSquareFragment) {
                postsSquareFragment2 = findFragment2;
            } else {
                postsSquareFragment2 = null;
            }
            this.globalPlazaFragment = postsSquareFragment2;
            this.mFragments.add(findFragment2);
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding != null && (appCompatImageView = fragmentHomeCommunityBinding.postBtn) != null) {
            final long j = 800;
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.community.HomeCommunityFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        FragmentActivity activity = this.getActivity();
                        if (activity != null) {
                            PostsCreateActivity.Companion.start(activity);
                        }
                    }
                }
            });
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding2 = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding2 != null && (viewPager2 = fragmentHomeCommunityBinding2.communityViewPager) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            viewPager2.setAdapter(new ViewPagerFragmentAdapter(childFragmentManager, this.mFragments));
            viewPager2.setOffscreenPageLimit(this.mFragments.size());
            viewPager2.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.home.community.HomeCommunityFragment$initView$5$1
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                }
            });
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding3 = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding3 != null && (customTabLayout = fragmentHomeCommunityBinding3.communityTabLayout) != null) {
            customTabLayout.setReSetTab(true);
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding4 = (FragmentHomeCommunityBinding) getBinding();
            if (fragmentHomeCommunityBinding4 != null) {
                viewPager3 = fragmentHomeCommunityBinding4.communityViewPager;
            }
            customTabLayout.setupWithViewPager(viewPager3, new CommunityTabLayoutAdapter());
            com.oudi.widget.ViewKtxKt.disableTooltipText(customTabLayout);
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding5 = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding5 != null && (viewPager = fragmentHomeCommunityBinding5.communityViewPager) != null) {
            viewPager.setCurrentItem(1);
        }
        refreshSkin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHomePageEvent$lambda$13(HomeCommunityFragment homeCommunityFragment, HomePageEvent homePageEvent) {
        ViewPager viewPager;
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) homeCommunityFragment.getBinding();
        if (fragmentHomeCommunityBinding != null && (viewPager = fragmentHomeCommunityBinding.communityViewPager) != null) {
            viewPager.setCurrentItem(homePageEvent.getTwoPosition());
        }
    }

    private final void processStatusBarCover() {
        LinearLayout linearLayout;
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding != null && (linearLayout = fragmentHomeCommunityBinding.container) != null) {
            linearLayout.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.community.c
                @Override // java.lang.Runnable
                public final void run() {
                    HomeCommunityFragment.processStatusBarCover$lambda$9(HomeCommunityFragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processStatusBarCover$lambda$9(final HomeCommunityFragment homeCommunityFragment) {
        ConstraintLayout constraintLayout;
        ViewGroup.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        ConstraintLayout constraintLayout2;
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) homeCommunityFragment.getBinding();
        LinearLayout linearLayout = null;
        if (fragmentHomeCommunityBinding != null && (constraintLayout = fragmentHomeCommunityBinding.topNav) != null) {
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding2 = (FragmentHomeCommunityBinding) homeCommunityFragment.getBinding();
            if (fragmentHomeCommunityBinding2 != null && (constraintLayout2 = fragmentHomeCommunityBinding2.topNav) != null) {
                layoutParams = constraintLayout2.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            } else {
                layoutParams2 = null;
            }
            if (layoutParams2 != null) {
                layoutParams2.height = Dimens.INSTANCE.dpToPx(42);
            } else {
                layoutParams2 = null;
            }
            constraintLayout.setLayoutParams(layoutParams2);
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding3 = (FragmentHomeCommunityBinding) homeCommunityFragment.getBinding();
        if (fragmentHomeCommunityBinding3 != null) {
            linearLayout = fragmentHomeCommunityBinding3.container;
        }
        homeCommunityFragment.getStatusBarTopOrBottom(linearLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.home.community.e
            public final Object invoke(Object obj, Object obj2) {
                Unit processStatusBarCover$lambda$9$lambda$8;
                processStatusBarCover$lambda$9$lambda$8 = HomeCommunityFragment.processStatusBarCover$lambda$9$lambda$8(HomeCommunityFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return processStatusBarCover$lambda$9$lambda$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processStatusBarCover$lambda$9$lambda$8(HomeCommunityFragment homeCommunityFragment, int i, int i2) {
        LinearLayout linearLayout;
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) homeCommunityFragment.getBinding();
        if (fragmentHomeCommunityBinding != null && (linearLayout = fragmentHomeCommunityBinding.container) != null) {
            linearLayout.setPadding(0, i, 0, 0);
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
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding();
            if (fragmentHomeCommunityBinding != null && (imageView2 = fragmentHomeCommunityBinding.topBg) != null) {
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, file, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65531, (Object) null);
                return;
            }
            return;
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding2 = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding2 != null && (imageView = fragmentHomeCommunityBinding2.topBg) != null) {
            Context context = getContext();
            if (context != null) {
                drawable = androidx.core.content.a.getDrawable(context, R.drawable.ic_group_top_bg_all);
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    protected int getLayoutResId() {
        return R.layout.fragment_home_community;
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onHomePageEvent(@NotNull final HomePageEvent event) {
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding;
        ViewPager viewPager;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getTwoPosition() > -1 && event.getTwoPosition() < this.mFragments.size() && (fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding()) != null && (viewPager = fragmentHomeCommunityBinding.communityViewPager) != null) {
            viewPager.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.home.community.d
                @Override // java.lang.Runnable
                public final void run() {
                    HomeCommunityFragment.onHomePageEvent$lambda$13(HomeCommunityFragment.this, event);
                }
            });
        }
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        processStatusBarCover();
        initView();
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void scrollToTop(@NotNull CommunityDoubleTabEvent event) {
        ViewPager viewPager;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getType().length() > 0) {
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding();
            if (fragmentHomeCommunityBinding != null && (viewPager = fragmentHomeCommunityBinding.communityViewPager) != null && viewPager.getCurrentItem() == 1) {
                PostsSquareFragment postsSquareFragment = this.globalPlazaFragment;
                if (postsSquareFragment != null) {
                    postsSquareFragment.scrollToTop();
                    return;
                }
                return;
            }
            PostsSquareFragment postsSquareFragment2 = this.globalFollowFragment;
            if (postsSquareFragment2 != null) {
                postsSquareFragment2.scrollToTop();
            }
        }
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void setFollowUnRead(@NotNull CommunityFollowUnReadEvent event) {
        View view;
        CommunityTabView communityTabView;
        CustomTabLayout customTabLayout;
        TabLayout.f tabAt;
        KeyEvent.Callback callback;
        CustomTabLayout customTabLayout2;
        TabLayout.f tabAt2;
        Intrinsics.checkNotNullParameter(event, "event");
        CommunityTabView communityTabView2 = null;
        if (event.getPostsNoticeUnReadBean().getFollowPostCnt() > 0) {
            FragmentHomeCommunityBinding fragmentHomeCommunityBinding = (FragmentHomeCommunityBinding) getBinding();
            if (fragmentHomeCommunityBinding != null && (customTabLayout2 = fragmentHomeCommunityBinding.communityTabLayout) != null && (tabAt2 = customTabLayout2.getTabAt(0)) != null) {
                callback = tabAt2.e();
            } else {
                callback = null;
            }
            if (callback instanceof CommunityTabView) {
                communityTabView2 = (CommunityTabView) callback;
            }
            if (communityTabView2 != null) {
                communityTabView2.setRedPointShow();
                return;
            }
            return;
        }
        FragmentHomeCommunityBinding fragmentHomeCommunityBinding2 = (FragmentHomeCommunityBinding) getBinding();
        if (fragmentHomeCommunityBinding2 != null && (customTabLayout = fragmentHomeCommunityBinding2.communityTabLayout) != null && (tabAt = customTabLayout.getTabAt(0)) != null) {
            view = tabAt.e();
        } else {
            view = null;
        }
        if (view instanceof CommunityTabView) {
            communityTabView = (CommunityTabView) view;
        } else {
            communityTabView = null;
        }
        if (communityTabView != null) {
            communityTabView.setRedPoints(null);
        }
    }
}
