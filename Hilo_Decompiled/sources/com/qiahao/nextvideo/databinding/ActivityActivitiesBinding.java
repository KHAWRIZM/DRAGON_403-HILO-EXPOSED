package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityActivitiesBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final View bar;
    public final ImageView createActivity;
    public final ViewPage2TabLayout tabLayout;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityActivitiesBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, View view2, ImageView imageView, ViewPage2TabLayout viewPage2TabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bar = view2;
        this.createActivity = imageView;
        this.tabLayout = viewPage2TabLayout;
        this.viewPage = viewPager2;
    }

    public static ActivityActivitiesBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityActivitiesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityActivitiesBinding bind(View view, Object obj) {
        return (ActivityActivitiesBinding) ViewDataBinding.bind(obj, view, R.layout.activity_activities);
    }

    @Deprecated
    public static ActivityActivitiesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityActivitiesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_activities, viewGroup, z, obj);
    }

    public static ActivityActivitiesBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityActivitiesBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityActivitiesBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_activities, (ViewGroup) null, false, obj);
    }
}
