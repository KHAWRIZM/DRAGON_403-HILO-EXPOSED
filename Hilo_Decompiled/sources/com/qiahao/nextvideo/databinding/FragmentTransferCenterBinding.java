package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentTransferCenterBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final BannerViewPager banner;
    public final IncludeTransferTextBinding clients;
    public final IncludeTransferTextBinding diamonds;
    public final View monthBg;
    public final View oneLine;
    public final IncludeTransferTextBinding sales;
    public final SlidingTabLayout tabLayout;
    public final AppCompatTextView thisText;
    public final View thisView;
    public final View twoLine;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentTransferCenterBinding(Object obj, View view, int i, FrameLayout frameLayout, BannerViewPager bannerViewPager, IncludeTransferTextBinding includeTransferTextBinding, IncludeTransferTextBinding includeTransferTextBinding2, View view2, View view3, IncludeTransferTextBinding includeTransferTextBinding3, SlidingTabLayout slidingTabLayout, AppCompatTextView appCompatTextView, View view4, View view5, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.banner = bannerViewPager;
        this.clients = includeTransferTextBinding;
        this.diamonds = includeTransferTextBinding2;
        this.monthBg = view2;
        this.oneLine = view3;
        this.sales = includeTransferTextBinding3;
        this.tabLayout = slidingTabLayout;
        this.thisText = appCompatTextView;
        this.thisView = view4;
        this.twoLine = view5;
        this.viewPager = viewPager;
    }

    public static FragmentTransferCenterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentTransferCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentTransferCenterBinding bind(View view, Object obj) {
        return (FragmentTransferCenterBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_transfer_center);
    }

    @Deprecated
    public static FragmentTransferCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentTransferCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transfer_center, viewGroup, z, obj);
    }

    public static FragmentTransferCenterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentTransferCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentTransferCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_transfer_center, (ViewGroup) null, false, obj);
    }
}
