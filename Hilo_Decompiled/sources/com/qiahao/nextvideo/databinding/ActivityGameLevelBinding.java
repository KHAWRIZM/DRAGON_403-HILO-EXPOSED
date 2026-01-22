package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGameLevelBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppBarLayout appbar;
    public final AppCompatImageView backImageView;
    public final BannerViewPager bannerView;
    public final ImageView buttonBg;
    public final Toolbar collapseToolbar;
    public final CoordinatorLayout constraint;
    public final AppCompatImageView help;
    public final RecyclerView recyclerView;
    public final AppCompatTextView svipPrivileges;
    public final AppCompatTextView title;
    public final ImageView topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGameLevelBinding(Object obj, View view, int i, FrameLayout frameLayout, AppBarLayout appBarLayout, AppCompatImageView appCompatImageView, BannerViewPager bannerViewPager, ImageView imageView, Toolbar toolbar, CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView2, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ImageView imageView2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.appbar = appBarLayout;
        this.backImageView = appCompatImageView;
        this.bannerView = bannerViewPager;
        this.buttonBg = imageView;
        this.collapseToolbar = toolbar;
        this.constraint = coordinatorLayout;
        this.help = appCompatImageView2;
        this.recyclerView = recyclerView;
        this.svipPrivileges = appCompatTextView;
        this.title = appCompatTextView2;
        this.topBg = imageView2;
    }

    public static ActivityGameLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGameLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityGameLevelBinding bind(View view, Object obj) {
        return (ActivityGameLevelBinding) ViewDataBinding.bind(obj, view, R.layout.activity_game_level);
    }

    @Deprecated
    public static ActivityGameLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGameLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_game_level, viewGroup, z, obj);
    }

    public static ActivityGameLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGameLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGameLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_game_level, (ViewGroup) null, false, obj);
    }
}
