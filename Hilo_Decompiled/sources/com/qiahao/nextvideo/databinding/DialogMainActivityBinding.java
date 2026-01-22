package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.zhpan.bannerview.BannerViewPager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogMainActivityBinding extends ViewDataBinding {
    public final BannerViewPager bannerView;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final FrameLayout frameLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogMainActivityBinding(Object obj, View view, int i, BannerViewPager bannerViewPager, ImageView imageView, ConstraintLayout constraintLayout, FrameLayout frameLayout) {
        super(obj, view, i);
        this.bannerView = bannerViewPager;
        this.close = imageView;
        this.constraint = constraintLayout;
        this.frameLayout = frameLayout;
    }

    public static DialogMainActivityBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogMainActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogMainActivityBinding bind(View view, Object obj) {
        return (DialogMainActivityBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_main_activity);
    }

    @Deprecated
    public static DialogMainActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogMainActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_main_activity, viewGroup, z, obj);
    }

    public static DialogMainActivityBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogMainActivityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogMainActivityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_main_activity, (ViewGroup) null, false, obj);
    }
}
