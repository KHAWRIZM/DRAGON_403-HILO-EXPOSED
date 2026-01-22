package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySvipBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppBarLayout appbar;
    public final AppCompatImageView backImageView;
    public final BannerViewPager bannerView;
    public final Toolbar collapseToolbar;
    public final CoordinatorLayout container;
    public final ConstraintLayout gift1Container;
    public final ConstraintLayout gift2Container;
    public final ConstraintLayout gift3Container;
    public final TextView gift3ReceiveBtn;
    public final AppCompatImageView help;
    public final SVGAImageView ivGift1;
    public final SVGAImageView ivGift2;
    public final SVGAImageView ivGift3;
    public final RecyclerView recyclerView;
    public final AppCompatTextView svipNumber;
    public final AppCompatTextView svipPrivileges;
    public final AppCompatTextView title;
    public final SVGAImageView topBg;
    public final TextView tvGiftCollectionTime1;
    public final TextView tvGiftCollectionTime2;
    public final TextView tvGiftCollectionTime3;
    public final TextView tvGiftNumber1;
    public final TextView tvGiftNumber2;
    public final TextView tvGiftNumber3;
    public final TextView tvGiftSubTitle1;
    public final TextView tvGiftSubTitle2;
    public final TextView tvGiftSubTitle3;
    public final TextView tvGiftTitle1;
    public final TextView tvGiftTitle2;
    public final TextView tvGiftTitle3;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySvipBinding(Object obj, View view, int i, FrameLayout frameLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, BannerViewPager bannerViewPager, Toolbar toolbar, CoordinatorLayout coordinatorLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, AppCompatImageView appCompatImageView2, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, SVGAImageView sVGAImageView3, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, SVGAImageView sVGAImageView4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.appbar = appBarLayout;
        this.backImageView = appCompatImageView;
        this.bannerView = bannerViewPager;
        this.collapseToolbar = toolbar;
        this.container = coordinatorLayout;
        this.gift1Container = constraintLayout;
        this.gift2Container = constraintLayout2;
        this.gift3Container = constraintLayout3;
        this.gift3ReceiveBtn = textView;
        this.help = appCompatImageView2;
        this.ivGift1 = sVGAImageView;
        this.ivGift2 = sVGAImageView2;
        this.ivGift3 = sVGAImageView3;
        this.recyclerView = recyclerView;
        this.svipNumber = appCompatTextView;
        this.svipPrivileges = appCompatTextView2;
        this.title = appCompatTextView3;
        this.topBg = sVGAImageView4;
        this.tvGiftCollectionTime1 = textView2;
        this.tvGiftCollectionTime2 = textView3;
        this.tvGiftCollectionTime3 = textView4;
        this.tvGiftNumber1 = textView5;
        this.tvGiftNumber2 = textView6;
        this.tvGiftNumber3 = textView7;
        this.tvGiftSubTitle1 = textView8;
        this.tvGiftSubTitle2 = textView9;
        this.tvGiftSubTitle3 = textView10;
        this.tvGiftTitle1 = textView11;
        this.tvGiftTitle2 = textView12;
        this.tvGiftTitle3 = textView13;
    }

    public static ActivitySvipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySvipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySvipBinding bind(View view, Object obj) {
        return (ActivitySvipBinding) ViewDataBinding.bind(obj, view, R.layout.activity_svip);
    }

    @Deprecated
    public static ActivitySvipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySvipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip, viewGroup, z, obj);
    }

    public static ActivitySvipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySvipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySvipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_svip, (ViewGroup) null, false, obj);
    }
}
