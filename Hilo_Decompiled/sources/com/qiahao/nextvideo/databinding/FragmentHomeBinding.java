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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.oudi.widget.CustomTabLayout;
import com.oudi.widget.NoScrollViewPager;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.flowingdrawer.FlowingDrawer;
import com.qiahao.nextvideo.flowingdrawer.FlowingMenuLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeBinding extends ViewDataBinding {
    public final HiloImageView avatar;
    public final ImageView backGround;
    public final FrameLayout backGroup;
    public final AppCompatImageView coverImageView;
    public final AppCompatImageButton debugButton;
    public final ViewControllerHomeDrawerHeadLayoutBinding drawerHeadLayout;
    public final FlowingDrawer drawerlayout;
    public final FrameLayout earnDiamond;
    public final LinearLayoutCompat flowingMenuLayoutContainer;
    public final FrameLayout gameLayout;
    public final FrameLayout giftRecord;
    public final FrameLayout historyPairedContainer;
    public final AppCompatTextView historyPairedCountTextView;
    public final FrameLayout levelContent;
    public final FrameLayout likeContainer;
    public final FrameLayout medalContent;
    public final FlowingMenuLayout menuLayout;
    public final FrameLayout nobilityContainer;
    public final FrameLayout powerContent;
    public final ConstraintLayout purchaseDiamondContainer;
    public final LightQueueCombinationPlayer queuePlayer;
    public final TextView recharge;
    public final FrameLayout settingContainer;
    public final FrameLayout storeContent;
    public final FrameLayout svip;
    public final ImageView tabBg;
    public final CustomTabLayout tabLayout;
    public final FrameLayout videoPreviewContainer;
    public final NoScrollViewPager viewPager;
    public final FrameLayout vipContainer;
    public final AppCompatTextView walletIcon;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeBinding(Object obj, View view, int i, HiloImageView hiloImageView, ImageView imageView, FrameLayout frameLayout, AppCompatImageView appCompatImageView, AppCompatImageButton appCompatImageButton, ViewControllerHomeDrawerHeadLayoutBinding viewControllerHomeDrawerHeadLayoutBinding, FlowingDrawer flowingDrawer, FrameLayout frameLayout2, LinearLayoutCompat linearLayoutCompat, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, AppCompatTextView appCompatTextView, FrameLayout frameLayout6, FrameLayout frameLayout7, FrameLayout frameLayout8, FlowingMenuLayout flowingMenuLayout, FrameLayout frameLayout9, FrameLayout frameLayout10, ConstraintLayout constraintLayout, LightQueueCombinationPlayer lightQueueCombinationPlayer, TextView textView, FrameLayout frameLayout11, FrameLayout frameLayout12, FrameLayout frameLayout13, ImageView imageView2, CustomTabLayout customTabLayout, FrameLayout frameLayout14, NoScrollViewPager noScrollViewPager, FrameLayout frameLayout15, AppCompatTextView appCompatTextView2) {
        super(obj, view, i);
        this.avatar = hiloImageView;
        this.backGround = imageView;
        this.backGroup = frameLayout;
        this.coverImageView = appCompatImageView;
        this.debugButton = appCompatImageButton;
        this.drawerHeadLayout = viewControllerHomeDrawerHeadLayoutBinding;
        this.drawerlayout = flowingDrawer;
        this.earnDiamond = frameLayout2;
        this.flowingMenuLayoutContainer = linearLayoutCompat;
        this.gameLayout = frameLayout3;
        this.giftRecord = frameLayout4;
        this.historyPairedContainer = frameLayout5;
        this.historyPairedCountTextView = appCompatTextView;
        this.levelContent = frameLayout6;
        this.likeContainer = frameLayout7;
        this.medalContent = frameLayout8;
        this.menuLayout = flowingMenuLayout;
        this.nobilityContainer = frameLayout9;
        this.powerContent = frameLayout10;
        this.purchaseDiamondContainer = constraintLayout;
        this.queuePlayer = lightQueueCombinationPlayer;
        this.recharge = textView;
        this.settingContainer = frameLayout11;
        this.storeContent = frameLayout12;
        this.svip = frameLayout13;
        this.tabBg = imageView2;
        this.tabLayout = customTabLayout;
        this.videoPreviewContainer = frameLayout14;
        this.viewPager = noScrollViewPager;
        this.vipContainer = frameLayout15;
        this.walletIcon = appCompatTextView2;
    }

    public static FragmentHomeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeBinding bind(View view, Object obj) {
        return (FragmentHomeBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home);
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home, viewGroup, z, obj);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home, (ViewGroup) null, false, obj);
    }
}
