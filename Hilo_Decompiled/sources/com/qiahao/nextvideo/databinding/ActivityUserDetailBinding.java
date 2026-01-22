package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.view.SlidingTabLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityUserDetailBinding extends ViewDataBinding {
    public final HiloGradeView activityLevel;
    public final FrameLayout activityMainContainer;
    public final GenderAgeTextView ageTextView;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final HiloGradeView charmLevel;
    public final AppCompatImageView chatImageButton;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final AppCompatImageView countryFlagImageView;
    public final CountryIDView countryID;
    public final SVGAImageView countrySVGA;
    public final AppCompatTextView des;
    public final TextView fans;
    public final TextView follow;
    public final ImageView iconVip;
    public final SVGAImageView likeSvgaImageView;
    public final AppCompatImageView likedImageButton;
    public final Toolbar margeTop;
    public final LinearLayoutCompat nameLinear;
    public final ImageView newUser;
    public final NickTextView nicknameTextView;
    public final LightQueueCombinationPlayer nobleBg;
    public final ConstraintLayout otherProfileView;
    public final View photoBg;
    public final AppCompatImageView postBtn;
    public final LightQueueCombinationPlayer queuePlayer;
    public final RecyclerView recyclerSmallPhoto;
    public final RecyclerView recyclerSmallPhoto1;
    public final SmartRefreshLayout refreshLayout;
    public final AppCompatImageView report;
    public final AppCompatImageButton roomImageButton;
    public final AppCompatImageView setting;
    public final SVGAImageView svipSVGA;
    public final ImageView svipType;
    public final ImageView svipType1;
    public final View tabBg;
    public final SlidingTabLayout tabLayout;
    public final AppCompatTextView title;
    public final AppBarLayout toolbar;
    public final ConstraintLayout topWhiteBg;
    public final HiloImageView userAvatar;
    public final ImageView userHeadImg;
    public final SVGAImageView userHeadSvga;
    public final AppCompatImageButton videoCallImageButton;
    public final ViewPager viewPager;
    public final BannerViewPager viewpagerPhoto;
    public final TextView visitor;
    public final HiloGradeView wealthLevel;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityUserDetailBinding(Object obj, View view, int i, HiloGradeView hiloGradeView, FrameLayout frameLayout, GenderAgeTextView genderAgeTextView, AppCompatImageView appCompatImageView, View view2, HiloGradeView hiloGradeView2, AppCompatImageView appCompatImageView2, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView3, CountryIDView countryIDView, SVGAImageView sVGAImageView, AppCompatTextView appCompatTextView, TextView textView, TextView textView2, ImageView imageView, SVGAImageView sVGAImageView2, AppCompatImageView appCompatImageView4, Toolbar toolbar, LinearLayoutCompat linearLayoutCompat, ImageView imageView2, NickTextView nickTextView, LightQueueCombinationPlayer lightQueueCombinationPlayer, ConstraintLayout constraintLayout, View view3, AppCompatImageView appCompatImageView5, LightQueueCombinationPlayer lightQueueCombinationPlayer2, RecyclerView recyclerView, RecyclerView recyclerView2, SmartRefreshLayout smartRefreshLayout, AppCompatImageView appCompatImageView6, AppCompatImageButton appCompatImageButton, AppCompatImageView appCompatImageView7, SVGAImageView sVGAImageView3, ImageView imageView3, ImageView imageView4, View view4, SlidingTabLayout slidingTabLayout, AppCompatTextView appCompatTextView2, AppBarLayout appBarLayout, ConstraintLayout constraintLayout2, HiloImageView hiloImageView, ImageView imageView5, SVGAImageView sVGAImageView4, AppCompatImageButton appCompatImageButton2, ViewPager viewPager, BannerViewPager bannerViewPager, TextView textView3, HiloGradeView hiloGradeView3) {
        super(obj, view, i);
        this.activityLevel = hiloGradeView;
        this.activityMainContainer = frameLayout;
        this.ageTextView = genderAgeTextView;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.charmLevel = hiloGradeView2;
        this.chatImageButton = appCompatImageView2;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.countryFlagImageView = appCompatImageView3;
        this.countryID = countryIDView;
        this.countrySVGA = sVGAImageView;
        this.des = appCompatTextView;
        this.fans = textView;
        this.follow = textView2;
        this.iconVip = imageView;
        this.likeSvgaImageView = sVGAImageView2;
        this.likedImageButton = appCompatImageView4;
        this.margeTop = toolbar;
        this.nameLinear = linearLayoutCompat;
        this.newUser = imageView2;
        this.nicknameTextView = nickTextView;
        this.nobleBg = lightQueueCombinationPlayer;
        this.otherProfileView = constraintLayout;
        this.photoBg = view3;
        this.postBtn = appCompatImageView5;
        this.queuePlayer = lightQueueCombinationPlayer2;
        this.recyclerSmallPhoto = recyclerView;
        this.recyclerSmallPhoto1 = recyclerView2;
        this.refreshLayout = smartRefreshLayout;
        this.report = appCompatImageView6;
        this.roomImageButton = appCompatImageButton;
        this.setting = appCompatImageView7;
        this.svipSVGA = sVGAImageView3;
        this.svipType = imageView3;
        this.svipType1 = imageView4;
        this.tabBg = view4;
        this.tabLayout = slidingTabLayout;
        this.title = appCompatTextView2;
        this.toolbar = appBarLayout;
        this.topWhiteBg = constraintLayout2;
        this.userAvatar = hiloImageView;
        this.userHeadImg = imageView5;
        this.userHeadSvga = sVGAImageView4;
        this.videoCallImageButton = appCompatImageButton2;
        this.viewPager = viewPager;
        this.viewpagerPhoto = bannerViewPager;
        this.visitor = textView3;
        this.wealthLevel = hiloGradeView3;
    }

    public static ActivityUserDetailBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityUserDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityUserDetailBinding bind(View view, Object obj) {
        return (ActivityUserDetailBinding) ViewDataBinding.bind(obj, view, R.layout.activity_user_detail);
    }

    @Deprecated
    public static ActivityUserDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityUserDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_user_detail, viewGroup, z, obj);
    }

    public static ActivityUserDetailBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityUserDetailBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityUserDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_user_detail, (ViewGroup) null, false, obj);
    }
}
