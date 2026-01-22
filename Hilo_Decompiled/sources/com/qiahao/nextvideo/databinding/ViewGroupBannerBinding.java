package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.IndicatorView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewGroupBannerBinding extends ViewDataBinding {
    public final BannerViewPager bannerView;
    public final IndicatorView indicatorView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGroupBannerBinding(Object obj, View view, int i, BannerViewPager bannerViewPager, IndicatorView indicatorView) {
        super(obj, view, i);
        this.bannerView = bannerViewPager;
        this.indicatorView = indicatorView;
    }

    public static ViewGroupBannerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGroupBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGroupBannerBinding bind(View view, Object obj) {
        return (ViewGroupBannerBinding) ViewDataBinding.bind(obj, view, R.layout.view_group_banner);
    }

    @Deprecated
    public static ViewGroupBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGroupBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_group_banner, viewGroup, z, obj);
    }

    public static ViewGroupBannerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGroupBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGroupBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_group_banner, (ViewGroup) null, false, obj);
    }
}
