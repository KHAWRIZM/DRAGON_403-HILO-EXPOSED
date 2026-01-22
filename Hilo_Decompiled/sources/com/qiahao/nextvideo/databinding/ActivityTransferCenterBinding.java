package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityTransferCenterBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final ViewPage2TabLayout tabLayout;
    public final LinearLayoutCompat topLayout;
    public final ViewPager2 viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTransferCenterBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, ViewPage2TabLayout viewPage2TabLayout, LinearLayoutCompat linearLayoutCompat, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.tabLayout = viewPage2TabLayout;
        this.topLayout = linearLayoutCompat;
        this.viewPager = viewPager2;
    }

    public static ActivityTransferCenterBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityTransferCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityTransferCenterBinding bind(View view, Object obj) {
        return (ActivityTransferCenterBinding) ViewDataBinding.bind(obj, view, R.layout.activity_transfer_center);
    }

    @Deprecated
    public static ActivityTransferCenterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityTransferCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_transfer_center, viewGroup, z, obj);
    }

    public static ActivityTransferCenterBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityTransferCenterBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityTransferCenterBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_transfer_center, (ViewGroup) null, false, obj);
    }
}
