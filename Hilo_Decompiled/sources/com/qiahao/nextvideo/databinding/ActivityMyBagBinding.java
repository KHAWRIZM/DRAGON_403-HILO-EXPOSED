package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityMyBagBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final View bottomBg;
    public final SlidingTabLayout tabLayout;
    public final TextView textSend;
    public final TextView textUse;
    public final IncludeTitleBinding titleLayout;
    public final TextView use;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMyBagBinding(Object obj, View view, int i, FrameLayout frameLayout, View view2, SlidingTabLayout slidingTabLayout, TextView textView, TextView textView2, IncludeTitleBinding includeTitleBinding, TextView textView3, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.bottomBg = view2;
        this.tabLayout = slidingTabLayout;
        this.textSend = textView;
        this.textUse = textView2;
        this.titleLayout = includeTitleBinding;
        this.use = textView3;
        this.viewPager = viewPager;
    }

    public static ActivityMyBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityMyBagBinding bind(View view, Object obj) {
        return (ActivityMyBagBinding) ViewDataBinding.bind(obj, view, R.layout.activity_my_bag);
    }

    @Deprecated
    public static ActivityMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_my_bag, viewGroup, z, obj);
    }

    public static ActivityMyBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityMyBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_my_bag, (ViewGroup) null, false, obj);
    }
}
