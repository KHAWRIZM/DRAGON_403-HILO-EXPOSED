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
public abstract class ViewAdvertisingBinding extends ViewDataBinding {
    public final BannerViewPager bannerView;
    public final IndicatorView indicatorView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewAdvertisingBinding(Object obj, View view, int i, BannerViewPager bannerViewPager, IndicatorView indicatorView) {
        super(obj, view, i);
        this.bannerView = bannerViewPager;
        this.indicatorView = indicatorView;
    }

    public static ViewAdvertisingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewAdvertisingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewAdvertisingBinding bind(View view, Object obj) {
        return (ViewAdvertisingBinding) ViewDataBinding.bind(obj, view, R.layout.view_advertising);
    }

    @Deprecated
    public static ViewAdvertisingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewAdvertisingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_advertising, viewGroup, z, obj);
    }

    public static ViewAdvertisingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewAdvertisingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewAdvertisingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_advertising, (ViewGroup) null, false, obj);
    }
}
