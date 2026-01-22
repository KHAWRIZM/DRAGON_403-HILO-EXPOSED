package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class GiftBannerView5Binding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView content;
    public final ImageView model;
    public final TextView nickName;
    public final ImageView svipType;
    public final ConstraintLayout svipUpgradesLayout;
    public final SVGAImageView svipUpgradesSVGA;

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftBannerView5Binding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.content = textView;
        this.model = imageView;
        this.nickName = textView2;
        this.svipType = imageView2;
        this.svipUpgradesLayout = constraintLayout;
        this.svipUpgradesSVGA = sVGAImageView;
    }

    public static GiftBannerView5Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static GiftBannerView5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static GiftBannerView5Binding bind(View view, Object obj) {
        return (GiftBannerView5Binding) ViewDataBinding.bind(obj, view, R.layout.gift_banner_view5);
    }

    @Deprecated
    public static GiftBannerView5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GiftBannerView5Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view5, viewGroup, z, obj);
    }

    public static GiftBannerView5Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static GiftBannerView5Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GiftBannerView5Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view5, (ViewGroup) null, false, obj);
    }
}
