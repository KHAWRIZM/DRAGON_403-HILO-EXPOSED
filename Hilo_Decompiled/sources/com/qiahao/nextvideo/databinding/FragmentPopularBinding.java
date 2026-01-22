package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentPopularBinding extends ViewDataBinding {
    public final BannerViewPager bannerView;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final CoordinatorLayout commonIdContentContainer;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final SuperStatusView statusView;
    public final AppBarLayout toolbar;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentPopularBinding(Object obj, View view, int i, BannerViewPager bannerViewPager, CollapsingToolbarLayout collapsingToolbarLayout, CoordinatorLayout coordinatorLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, SuperStatusView superStatusView, AppBarLayout appBarLayout) {
        super(obj, view, i);
        this.bannerView = bannerViewPager;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.commonIdContentContainer = coordinatorLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.statusView = superStatusView;
        this.toolbar = appBarLayout;
    }

    public static FragmentPopularBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentPopularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentPopularBinding bind(View view, Object obj) {
        return (FragmentPopularBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_popular);
    }

    @Deprecated
    public static FragmentPopularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentPopularBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_popular, viewGroup, z, obj);
    }

    public static FragmentPopularBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentPopularBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentPopularBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_popular, (ViewGroup) null, false, obj);
    }
}
