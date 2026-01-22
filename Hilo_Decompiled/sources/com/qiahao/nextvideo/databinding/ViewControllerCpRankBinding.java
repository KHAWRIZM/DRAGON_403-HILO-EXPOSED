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
public abstract class ViewControllerCpRankBinding extends ViewDataBinding {
    public final AppCompatImageView backImageView;
    public final LinearLayout bgContent;
    public final CommonTabLayout commonTabLayout;
    public final ImageView icQuestion;
    public final Toolbar toolbar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerCpRankBinding(Object obj, View view, int i, AppCompatImageView appCompatImageView, LinearLayout linearLayout, CommonTabLayout commonTabLayout, ImageView imageView, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.backImageView = appCompatImageView;
        this.bgContent = linearLayout;
        this.commonTabLayout = commonTabLayout;
        this.icQuestion = imageView;
        this.toolbar = toolbar;
        this.viewPager = viewPager;
    }

    public static ViewControllerCpRankBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerCpRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerCpRankBinding bind(View view, Object obj) {
        return (ViewControllerCpRankBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_cp_rank);
    }

    @Deprecated
    public static ViewControllerCpRankBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerCpRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_cp_rank, viewGroup, z, obj);
    }

    public static ViewControllerCpRankBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerCpRankBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerCpRankBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_cp_rank, (ViewGroup) null, false, obj);
    }
}
