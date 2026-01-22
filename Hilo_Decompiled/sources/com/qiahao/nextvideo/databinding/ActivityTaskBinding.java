package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityTaskBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final ViewPage2TabLayout tabSegment;
    public final View topBg;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityTaskBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ViewPage2TabLayout viewPage2TabLayout, View view2, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.tabSegment = viewPage2TabLayout;
        this.topBg = view2;
        this.viewPage = viewPager2;
    }

    public static ActivityTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityTaskBinding bind(View view, Object obj) {
        return (ActivityTaskBinding) ViewDataBinding.bind(obj, view, R.layout.activity_task);
    }

    @Deprecated
    public static ActivityTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_task, viewGroup, z, obj);
    }

    public static ActivityTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_task, (ViewGroup) null, false, obj);
    }
}
