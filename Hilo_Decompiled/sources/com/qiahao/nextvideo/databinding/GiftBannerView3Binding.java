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
public abstract class GiftBannerView3Binding extends ViewDataBinding {
    public final TextView addText;
    public final TextView content2;
    public final ConstraintLayout cpUpgradesLayout;
    public final SVGAImageView cpUpgradesSVGA;
    public final QMUIRadiusImageView leftAvatar2;
    public final TextView leftName2;
    public final ImageView model2;
    public final QMUIRadiusImageView rightAvatar2;
    public final TextView rightName2;

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftBannerView3Binding(Object obj, View view, int i, TextView textView, TextView textView2, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, QMUIRadiusImageView qMUIRadiusImageView, TextView textView3, ImageView imageView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView4) {
        super(obj, view, i);
        this.addText = textView;
        this.content2 = textView2;
        this.cpUpgradesLayout = constraintLayout;
        this.cpUpgradesSVGA = sVGAImageView;
        this.leftAvatar2 = qMUIRadiusImageView;
        this.leftName2 = textView3;
        this.model2 = imageView;
        this.rightAvatar2 = qMUIRadiusImageView2;
        this.rightName2 = textView4;
    }

    public static GiftBannerView3Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static GiftBannerView3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static GiftBannerView3Binding bind(View view, Object obj) {
        return (GiftBannerView3Binding) ViewDataBinding.bind(obj, view, R.layout.gift_banner_view3);
    }

    @Deprecated
    public static GiftBannerView3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GiftBannerView3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view3, viewGroup, z, obj);
    }

    public static GiftBannerView3Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static GiftBannerView3Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GiftBannerView3Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view3, (ViewGroup) null, false, obj);
    }
}
