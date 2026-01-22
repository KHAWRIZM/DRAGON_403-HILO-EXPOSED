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
public abstract class ActivityPromoterCenterBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final View monthBg;
    public final IncludeTransferTextBinding number;
    public final View oneLine;
    public final IncludeTransferTextBinding rechargeAmount;
    public final SlidingTabLayout tabLayout;
    public final IncludeTransferTextBinding team;
    public final AppCompatTextView thisText;
    public final View thisView;
    public final AppCompatTextView title;
    public final LinearLayoutCompat topLayout;
    public final View twoLine;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityPromoterCenterBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, View view3, IncludeTransferTextBinding includeTransferTextBinding, View view4, IncludeTransferTextBinding includeTransferTextBinding2, SlidingTabLayout slidingTabLayout, IncludeTransferTextBinding includeTransferTextBinding3, AppCompatTextView appCompatTextView, View view5, AppCompatTextView appCompatTextView2, LinearLayoutCompat linearLayoutCompat, View view6, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.monthBg = view3;
        this.number = includeTransferTextBinding;
        this.oneLine = view4;
        this.rechargeAmount = includeTransferTextBinding2;
        this.tabLayout = slidingTabLayout;
        this.team = includeTransferTextBinding3;
        this.thisText = appCompatTextView;
        this.thisView = view5;
        this.title = appCompatTextView2;
        this.topLayout = linearLayoutCompat;
        this.twoLine = view6;
        this.viewPager = viewPager;
    }

    public static ActivityPromoterCenterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityPromoterCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityPromoterCenterBinding bind(View view, Object obj) {
        return (ActivityPromoterCenterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_promoter_center);
    }

    @Deprecated
    public static ActivityPromoterCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityPromoterCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_promoter_center, viewGroup, z, obj);
    }

    public static ActivityPromoterCenterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityPromoterCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityPromoterCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_promoter_center, (ViewGroup) null, false, obj);
    }
}
