package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerBuyAristocracyIdentityBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final ImageView bag;
    public final SVGAImageView buttonSvga;
    public final ImageView card;
    public final ConstraintLayout clBuy;
    public final SlidingTabLayout commonTabLayout;
    public final TextView days;
    public final ImageView delete;
    public final TextView diamondText;
    public final TextView exclusivePrivileges;
    protected View.OnClickListener mClick;
    public final TextView nobleLevel;
    public final TextView remainTime;
    public final TextView textBay;
    public final TextView textSend;
    public final TextView tip;
    public final TextView tip1;
    public final ImageView tipIcon;
    public final Toolbar toolbar;
    public final SVGAImageView topSvga;
    public final ViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerBuyAristocracyIdentityBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ImageView imageView, SVGAImageView sVGAImageView, ImageView imageView2, ConstraintLayout constraintLayout, SlidingTabLayout slidingTabLayout, TextView textView, ImageView imageView3, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageView imageView4, Toolbar toolbar, SVGAImageView sVGAImageView2, ViewPager viewPager) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.bag = imageView;
        this.buttonSvga = sVGAImageView;
        this.card = imageView2;
        this.clBuy = constraintLayout;
        this.commonTabLayout = slidingTabLayout;
        this.days = textView;
        this.delete = imageView3;
        this.diamondText = textView2;
        this.exclusivePrivileges = textView3;
        this.nobleLevel = textView4;
        this.remainTime = textView5;
        this.textBay = textView6;
        this.textSend = textView7;
        this.tip = textView8;
        this.tip1 = textView9;
        this.tipIcon = imageView4;
        this.toolbar = toolbar;
        this.topSvga = sVGAImageView2;
        this.viewPager = viewPager;
    }

    public static ViewControllerBuyAristocracyIdentityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerBuyAristocracyIdentityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static ViewControllerBuyAristocracyIdentityBinding bind(View view, Object obj) {
        return (ViewControllerBuyAristocracyIdentityBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_buy_aristocracy_identity);
    }

    @Deprecated
    public static ViewControllerBuyAristocracyIdentityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerBuyAristocracyIdentityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_buy_aristocracy_identity, viewGroup, z, obj);
    }

    public static ViewControllerBuyAristocracyIdentityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerBuyAristocracyIdentityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerBuyAristocracyIdentityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_buy_aristocracy_identity, (ViewGroup) null, false, obj);
    }
}
