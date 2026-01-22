package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityControllerInteractiveTrackingListBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final FrameLayout commonIdContentContainer;
    public final RecyclerView commonIdRecyclerView;
    public final SlidingTabLayout commonTabLayout;
    public final AppCompatTextView emptyTipTextView;
    public final SVGAImageView likeSvgaImageView;
    public final LinearLayout linearLayout;
    public final Toolbar toolbar;
    public final ViewPager viewPager2;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityControllerInteractiveTrackingListBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, RecyclerView recyclerView, SlidingTabLayout slidingTabLayout, AppCompatTextView appCompatTextView, SVGAImageView sVGAImageView, LinearLayout linearLayout, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.commonIdContentContainer = frameLayout2;
        this.commonIdRecyclerView = recyclerView;
        this.commonTabLayout = slidingTabLayout;
        this.emptyTipTextView = appCompatTextView;
        this.likeSvgaImageView = sVGAImageView;
        this.linearLayout = linearLayout;
        this.toolbar = toolbar;
        this.viewPager2 = viewPager;
    }

    public static ActivityControllerInteractiveTrackingListBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityControllerInteractiveTrackingListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityControllerInteractiveTrackingListBinding bind(View view, Object obj) {
        return (ActivityControllerInteractiveTrackingListBinding) ViewDataBinding.bind(obj, view, R.layout.activity_controller_interactive_tracking_list);
    }

    @Deprecated
    public static ActivityControllerInteractiveTrackingListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityControllerInteractiveTrackingListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_controller_interactive_tracking_list, viewGroup, z, obj);
    }

    public static ActivityControllerInteractiveTrackingListBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityControllerInteractiveTrackingListBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityControllerInteractiveTrackingListBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_controller_interactive_tracking_list, (ViewGroup) null, false, obj);
    }
}
