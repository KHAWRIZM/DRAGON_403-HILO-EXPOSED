package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerAllRankBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final LinearLayout bgContent;
    public final CommonTabLayout commonTabLayout;
    public final ImageView icQuestion;
    public final Toolbar toolbar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerAllRankBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CommonTabLayout commonTabLayout, ImageView imageView, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bgContent = linearLayout;
        this.commonTabLayout = commonTabLayout;
        this.icQuestion = imageView;
        this.toolbar = toolbar;
        this.viewPager = viewPager;
    }

    public static ViewControllerAllRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerAllRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerAllRankBinding bind(View view, Object obj) {
        return (ViewControllerAllRankBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_all_rank);
    }

    @Deprecated
    public static ViewControllerAllRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerAllRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_all_rank, viewGroup, z, obj);
    }

    public static ViewControllerAllRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerAllRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerAllRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_all_rank, (ViewGroup) null, false, obj);
    }
}
