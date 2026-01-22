package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityTransferRecordBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final SlidingTabLayout tabLayout;
    public final LinearLayoutCompat topLayout;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTransferRecordBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, SlidingTabLayout slidingTabLayout, LinearLayoutCompat linearLayoutCompat, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.tabLayout = slidingTabLayout;
        this.topLayout = linearLayoutCompat;
        this.viewPager = viewPager;
    }

    public static ActivityTransferRecordBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityTransferRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityTransferRecordBinding bind(View view, Object obj) {
        return (ActivityTransferRecordBinding) ViewDataBinding.bind(obj, view, R.layout.activity_transfer_record);
    }

    @Deprecated
    public static ActivityTransferRecordBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityTransferRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_transfer_record, viewGroup, z, obj);
    }

    public static ActivityTransferRecordBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityTransferRecordBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityTransferRecordBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_transfer_record, (ViewGroup) null, false, obj);
    }
}
