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
public abstract class GiftBannerView6Binding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView content;
    public final ConstraintLayout countryLayout;
    public final SVGAImageView countrySVGA;
    public final TextView nickName;

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftBannerView6Binding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView, ConstraintLayout constraintLayout, SVGAImageView sVGAImageView, TextView textView2) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.content = textView;
        this.countryLayout = constraintLayout;
        this.countrySVGA = sVGAImageView;
        this.nickName = textView2;
    }

    public static GiftBannerView6Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static GiftBannerView6Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static GiftBannerView6Binding bind(View view, Object obj) {
        return (GiftBannerView6Binding) ViewDataBinding.bind(obj, view, R.layout.gift_banner_view6);
    }

    @Deprecated
    public static GiftBannerView6Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GiftBannerView6Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view6, viewGroup, z, obj);
    }

    public static GiftBannerView6Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static GiftBannerView6Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GiftBannerView6Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view6, (ViewGroup) null, false, obj);
    }
}
