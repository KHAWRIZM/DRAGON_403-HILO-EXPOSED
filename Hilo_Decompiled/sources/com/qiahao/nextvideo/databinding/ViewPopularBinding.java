package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewPopularBinding extends ViewDataBinding {
    public final BannerViewPager bannerView;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewPopularBinding(Object obj, View view, int i, BannerViewPager bannerViewPager) {
        super(obj, view, i);
        this.bannerView = bannerViewPager;
    }

    public static ViewPopularBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewPopularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewPopularBinding bind(View view, Object obj) {
        return (ViewPopularBinding) ViewDataBinding.bind(obj, view, R.layout.view_popular);
    }

    @Deprecated
    public static ViewPopularBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewPopularBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_popular, viewGroup, z, obj);
    }

    public static ViewPopularBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewPopularBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewPopularBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_popular, (ViewGroup) null, false, obj);
    }
}
