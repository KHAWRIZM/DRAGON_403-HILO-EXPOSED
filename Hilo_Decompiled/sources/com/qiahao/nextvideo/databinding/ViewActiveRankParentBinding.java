package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SegmentTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewActiveRankParentBinding extends ViewDataBinding {
    public final SegmentTabLayout segmentTabLayout;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewActiveRankParentBinding(Object obj, View view, int i, SegmentTabLayout segmentTabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.segmentTabLayout = segmentTabLayout;
        this.viewPager = viewPager;
    }

    public static ViewActiveRankParentBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewActiveRankParentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewActiveRankParentBinding bind(View view, Object obj) {
        return (ViewActiveRankParentBinding) ViewDataBinding.bind(obj, view, R.layout.view_active_rank_parent);
    }

    @Deprecated
    public static ViewActiveRankParentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewActiveRankParentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_active_rank_parent, viewGroup, z, obj);
    }

    public static ViewActiveRankParentBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewActiveRankParentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewActiveRankParentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_active_rank_parent, (ViewGroup) null, false, obj);
    }
}
