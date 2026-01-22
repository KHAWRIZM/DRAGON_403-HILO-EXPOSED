package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.CommonTabLayout;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerMyBagBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final LinearLayout bgContent;
    public final View bottomBg;
    public final CommonTabLayout commonTabLayout;
    public final ConstraintLayout container;
    public final TextView textSnd;
    public final TextView textUse;
    public final Toolbar toolbar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerMyBagBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, LinearLayout linearLayout, View view2, CommonTabLayout commonTabLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, Toolbar toolbar, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bgContent = linearLayout;
        this.bottomBg = view2;
        this.commonTabLayout = commonTabLayout;
        this.container = constraintLayout;
        this.textSnd = textView;
        this.textUse = textView2;
        this.toolbar = toolbar;
        this.viewPager = viewPager;
    }

    public static ViewControllerMyBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerMyBagBinding bind(View view, Object obj) {
        return (ViewControllerMyBagBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_my_bag);
    }

    @Deprecated
    public static ViewControllerMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_my_bag, viewGroup, z, obj);
    }

    public static ViewControllerMyBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerMyBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_my_bag, (ViewGroup) null, false, obj);
    }
}
