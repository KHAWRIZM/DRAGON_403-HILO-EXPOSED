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
public abstract class ViewCharmRankParentBinding extends ViewDataBinding {
    public final SegmentTabLayout segmentTabLayout;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewCharmRankParentBinding(Object obj, View view, int i, SegmentTabLayout segmentTabLayout, ViewPager viewPager) {
        super(obj, view, i);
        this.segmentTabLayout = segmentTabLayout;
        this.viewPager = viewPager;
    }

    public static ViewCharmRankParentBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewCharmRankParentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewCharmRankParentBinding bind(View view, Object obj) {
        return (ViewCharmRankParentBinding) ViewDataBinding.bind(obj, view, R.layout.view_charm_rank_parent);
    }

    @Deprecated
    public static ViewCharmRankParentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewCharmRankParentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_charm_rank_parent, viewGroup, z, obj);
    }

    public static ViewCharmRankParentBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewCharmRankParentBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewCharmRankParentBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_charm_rank_parent, (ViewGroup) null, false, obj);
    }
}
