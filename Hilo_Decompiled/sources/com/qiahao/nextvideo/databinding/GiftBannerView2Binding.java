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
public abstract class GiftBannerView2Binding extends ViewDataBinding {
    public final TextView content1;
    public final ConstraintLayout cpGiftLayout;
    public final SVGAImageView cpGiftSVGA;
    public final ImageView cpModel1;
    public final ImageView gift1;
    public final TextView giftNumber1;
    public final TextView id1;
    public final QMUIRadiusImageView leftAvatar1;
    public final TextView name1;
    public final QMUIRadiusImageView rightAvatar1;

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftBannerView2Binding(Object obj, View view, int i, TextView textView, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, ImageView imageView, ImageView imageView2, TextView textView2, TextView textView3, QMUIRadiusImageView qMUIRadiusImageView, TextView textView4, QMUIRadiusImageView qMUIRadiusImageView2) {
        super(obj, view, i);
        this.content1 = textView;
        this.cpGiftLayout = constraintLayout;
        this.cpGiftSVGA = sVGAImageView;
        this.cpModel1 = imageView;
        this.gift1 = imageView2;
        this.giftNumber1 = textView2;
        this.id1 = textView3;
        this.leftAvatar1 = qMUIRadiusImageView;
        this.name1 = textView4;
        this.rightAvatar1 = qMUIRadiusImageView2;
    }

    public static GiftBannerView2Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static GiftBannerView2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static GiftBannerView2Binding bind(View view, Object obj) {
        return (GiftBannerView2Binding) ViewDataBinding.bind(obj, view, R.layout.gift_banner_view2);
    }

    @Deprecated
    public static GiftBannerView2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GiftBannerView2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view2, viewGroup, z, obj);
    }

    public static GiftBannerView2Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static GiftBannerView2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GiftBannerView2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view2, (ViewGroup) null, false, obj);
    }
}
