package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public abstract class ViewControllerPowerAllRankBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final LinearLayout bgContent;
    public final CommonTabLayout commonTabLayout;
    public final ImageView icQuestion;
    public final Toolbar toolbar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerPowerAllRankBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CommonTabLayout commonTabLayout, ImageView imageView, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.bgContent = linearLayout;
        this.commonTabLayout = commonTabLayout;
        this.icQuestion = imageView;
        this.toolbar = toolbar;
        this.viewPager = viewPager;
    }

    public static ViewControllerPowerAllRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerPowerAllRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerPowerAllRankBinding bind(View view, Object obj) {
        return (ViewControllerPowerAllRankBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_power_all_rank);
    }

    @Deprecated
    public static ViewControllerPowerAllRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerPowerAllRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_power_all_rank, viewGroup, z, obj);
    }

    public static ViewControllerPowerAllRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerPowerAllRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerPowerAllRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_power_all_rank, (ViewGroup) null, false, obj);
    }
}
