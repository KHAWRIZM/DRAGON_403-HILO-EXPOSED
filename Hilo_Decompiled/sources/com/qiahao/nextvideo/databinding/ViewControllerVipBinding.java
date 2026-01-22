package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewControllerVipBinding extends ViewDataBinding {
    public final BannerViewPager bannerView;
    public final ConstraintLayout clRoot;
    public final LinearLayout content;
    public final TextView descriptionText;
    public final FrameLayout frameLayout;
    public final LinearLayout getVip;
    public final TextView getVipOrVipEndTime;
    public final TextView monthMoneyOrEndTime;
    public final TextView nextTime;
    public final TextView text1;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewControllerVipBinding(Object obj, View view, int i, BannerViewPager bannerViewPager, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout2, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.bannerView = bannerViewPager;
        this.clRoot = constraintLayout;
        this.content = linearLayout;
        this.descriptionText = textView;
        this.frameLayout = frameLayout;
        this.getVip = linearLayout2;
        this.getVipOrVipEndTime = textView2;
        this.monthMoneyOrEndTime = textView3;
        this.nextTime = textView4;
        this.text1 = textView5;
    }

    public static ViewControllerVipBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewControllerVipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewControllerVipBinding bind(View view, Object obj) {
        return (ViewControllerVipBinding) ViewDataBinding.bind(obj, view, R.layout.view_controller_vip);
    }

    @Deprecated
    public static ViewControllerVipBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewControllerVipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_vip, viewGroup, z, obj);
    }

    public static ViewControllerVipBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewControllerVipBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewControllerVipBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_controller_vip, (ViewGroup) null, false, obj);
    }
}
