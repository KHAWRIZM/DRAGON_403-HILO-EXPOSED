package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityRoomAndPersonalTaskBinding extends ViewDataBinding {
    public final AppBarLayout appBarLayout;
    public final BannerViewPager bannerView;
    public final CollapsingToolbarLayout collapsingToolbarLayout;
    public final ConstraintLayout listContainer;
    public final ViewPage2TabLayout segmentTabLayout;
    public final ViewPager2 viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityRoomAndPersonalTaskBinding(Object obj, View view, int i, AppBarLayout appBarLayout, BannerViewPager bannerViewPager, CollapsingToolbarLayout collapsingToolbarLayout, ConstraintLayout constraintLayout, ViewPage2TabLayout viewPage2TabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.appBarLayout = appBarLayout;
        this.bannerView = bannerViewPager;
        this.collapsingToolbarLayout = collapsingToolbarLayout;
        this.listContainer = constraintLayout;
        this.segmentTabLayout = viewPage2TabLayout;
        this.viewPager = viewPager2;
    }

    public static ActivityRoomAndPersonalTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityRoomAndPersonalTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityRoomAndPersonalTaskBinding bind(View view, Object obj) {
        return (ActivityRoomAndPersonalTaskBinding) ViewDataBinding.bind(obj, view, R.layout.activity_room_and_personal_task);
    }

    @Deprecated
    public static ActivityRoomAndPersonalTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityRoomAndPersonalTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_and_personal_task, viewGroup, z, obj);
    }

    public static ActivityRoomAndPersonalTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityRoomAndPersonalTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityRoomAndPersonalTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_room_and_personal_task, (ViewGroup) null, false, obj);
    }
}
