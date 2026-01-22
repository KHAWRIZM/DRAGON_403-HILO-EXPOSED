package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewPopularChilderAllGroupBinding extends ViewDataBinding {
    public final SlidingTabLayout segmentTabLayout;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewPopularChilderAllGroupBinding(Object obj, View view, int i, SlidingTabLayout slidingTabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.segmentTabLayout = slidingTabLayout;
        this.viewPager = viewPager;
    }

    public static ViewPopularChilderAllGroupBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewPopularChilderAllGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewPopularChilderAllGroupBinding bind(View view, Object obj) {
        return (ViewPopularChilderAllGroupBinding) ViewDataBinding.bind(obj, view, R.layout.view_popular_childer_all_group);
    }

    @Deprecated
    public static ViewPopularChilderAllGroupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewPopularChilderAllGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_popular_childer_all_group, viewGroup, z, obj);
    }

    public static ViewPopularChilderAllGroupBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewPopularChilderAllGroupBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewPopularChilderAllGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_popular_childer_all_group, (ViewGroup) null, false, obj);
    }
}
