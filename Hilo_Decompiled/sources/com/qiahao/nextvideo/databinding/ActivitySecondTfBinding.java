package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivitySecondTfBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final AppCompatImageView detail;
    public final SlidingTabLayout tabLayout;
    public final AppCompatTextView title;
    public final LinearLayoutCompat topLayout;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySecondTfBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, AppCompatImageView appCompatImageView2, SlidingTabLayout slidingTabLayout, AppCompatTextView appCompatTextView, LinearLayoutCompat linearLayoutCompat, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.detail = appCompatImageView2;
        this.tabLayout = slidingTabLayout;
        this.title = appCompatTextView;
        this.topLayout = linearLayoutCompat;
        this.viewPager = viewPager;
    }

    public static ActivitySecondTfBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivitySecondTfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivitySecondTfBinding bind(View view, Object obj) {
        return (ActivitySecondTfBinding) ViewDataBinding.bind(obj, view, R.layout.activity_second_tf);
    }

    @Deprecated
    public static ActivitySecondTfBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivitySecondTfBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_second_tf, viewGroup, z, obj);
    }

    public static ActivitySecondTfBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivitySecondTfBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivitySecondTfBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_second_tf, (ViewGroup) null, false, obj);
    }
}
