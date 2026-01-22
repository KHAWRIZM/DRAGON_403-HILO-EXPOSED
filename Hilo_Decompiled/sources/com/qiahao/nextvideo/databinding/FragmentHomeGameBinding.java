package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.nextvideo.R;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentHomeGameBinding extends ViewDataBinding {
    public final ImageView add;
    public final BannerViewPager bannerBroadcast;
    public final ImageView chest;
    public final ImageView diamond;
    public final TextView diamondText;
    public final ConstraintLayout moneyLayout;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final ConstraintLayout rootContainer;
    public final SuperStatusView statusView;
    public final ImageView topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentHomeGameBinding(Object obj, View view, int i, ImageView imageView, BannerViewPager bannerViewPager, ImageView imageView2, ImageView imageView3, TextView textView, ConstraintLayout constraintLayout, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, ConstraintLayout constraintLayout2, SuperStatusView superStatusView, ImageView imageView4) {
        super(obj, view, i);
        this.add = imageView;
        this.bannerBroadcast = bannerViewPager;
        this.chest = imageView2;
        this.diamond = imageView3;
        this.diamondText = textView;
        this.moneyLayout = constraintLayout;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.rootContainer = constraintLayout2;
        this.statusView = superStatusView;
        this.topBg = imageView4;
    }

    public static FragmentHomeGameBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentHomeGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentHomeGameBinding bind(View view, Object obj) {
        return (FragmentHomeGameBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_home_game);
    }

    @Deprecated
    public static FragmentHomeGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentHomeGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_game, viewGroup, z, obj);
    }

    public static FragmentHomeGameBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentHomeGameBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentHomeGameBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_home_game, (ViewGroup) null, false, obj);
    }
}
