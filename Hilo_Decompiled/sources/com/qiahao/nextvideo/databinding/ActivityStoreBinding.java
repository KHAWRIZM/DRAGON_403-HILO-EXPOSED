package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityStoreBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final ConstraintLayout baseRoot;
    public final View bottomBg;
    public final TextView diamondDay;
    public final ImageView diamondIcon;
    public final ImageView imgAvatarHead;
    public final AppCompatTextView myBag;
    public final TextView relationSend;
    public final SVGAImageView svgaAvatarHead;
    public final SlidingTabLayout tabLayout;
    public final TextView textBay;
    public final TextView textSend;
    public final View titleBgBack;
    public final Toolbar toolbar;
    public final CircleImageView userAvatar;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityStoreBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, View view2, TextView textView, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, TextView textView2, SVGAImageView sVGAImageView, SlidingTabLayout slidingTabLayout, TextView textView3, TextView textView4, View view3, Toolbar toolbar, CircleImageView circleImageView, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.baseRoot = constraintLayout;
        this.bottomBg = view2;
        this.diamondDay = textView;
        this.diamondIcon = imageView;
        this.imgAvatarHead = imageView2;
        this.myBag = appCompatTextView;
        this.relationSend = textView2;
        this.svgaAvatarHead = sVGAImageView;
        this.tabLayout = slidingTabLayout;
        this.textBay = textView3;
        this.textSend = textView4;
        this.titleBgBack = view3;
        this.toolbar = toolbar;
        this.userAvatar = circleImageView;
        this.viewPager = viewPager;
    }

    public static ActivityStoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityStoreBinding bind(View view, Object obj) {
        return (ActivityStoreBinding) ViewDataBinding.bind(obj, view, R.layout.activity_store);
    }

    @Deprecated
    public static ActivityStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_store, viewGroup, z, obj);
    }

    public static ActivityStoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityStoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_store, (ViewGroup) null, false, obj);
    }
}
