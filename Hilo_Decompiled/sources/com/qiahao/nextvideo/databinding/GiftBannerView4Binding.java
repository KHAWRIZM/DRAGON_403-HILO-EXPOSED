package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class GiftBannerView4Binding extends ViewDataBinding {
    public final TextView addText2;
    public final ConstraintLayout cpNewLayout;
    public final SVGAImageView cpNewSVGA;
    public final QMUIRadiusImageView leftAvatar3;
    public final TextView leftName3;
    public final QMUIRadiusImageView rightAvatar3;
    public final TextView rightName3;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftBannerView4Binding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, QMUIRadiusImageView qMUIRadiusImageView, TextView textView2, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.addText2 = textView;
        this.cpNewLayout = constraintLayout;
        this.cpNewSVGA = sVGAImageView;
        this.leftAvatar3 = qMUIRadiusImageView;
        this.leftName3 = textView2;
        this.rightAvatar3 = qMUIRadiusImageView2;
        this.rightName3 = textView3;
        this.title = textView4;
    }

    public static GiftBannerView4Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static GiftBannerView4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static GiftBannerView4Binding bind(View view, Object obj) {
        return (GiftBannerView4Binding) ViewDataBinding.bind(obj, view, R.layout.gift_banner_view4);
    }

    @Deprecated
    public static GiftBannerView4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GiftBannerView4Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view4, viewGroup, z, obj);
    }

    public static GiftBannerView4Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static GiftBannerView4Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GiftBannerView4Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view4, (ViewGroup) null, false, obj);
    }
}
