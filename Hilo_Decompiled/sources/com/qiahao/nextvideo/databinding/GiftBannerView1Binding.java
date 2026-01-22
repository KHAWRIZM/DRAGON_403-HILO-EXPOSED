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
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class GiftBannerView1Binding extends ViewDataBinding {
    public final ConstraintLayout contentClick;
    public final TextView contentText;
    public final ConstraintLayout defaultLayout;
    public final SVGAImageView defaultSVGA;
    public final ImageView giftPic;
    public final CircleImageView sendAvatar;
    public final TextView userCode;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public GiftBannerView1Binding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, SVGAImageView sVGAImageView, ImageView imageView, CircleImageView circleImageView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.contentClick = constraintLayout;
        this.contentText = textView;
        this.defaultLayout = constraintLayout2;
        this.defaultSVGA = sVGAImageView;
        this.giftPic = imageView;
        this.sendAvatar = circleImageView;
        this.userCode = textView2;
        this.userName = textView3;
    }

    public static GiftBannerView1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static GiftBannerView1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static GiftBannerView1Binding bind(View view, Object obj) {
        return (GiftBannerView1Binding) ViewDataBinding.bind(obj, view, R.layout.gift_banner_view1);
    }

    @Deprecated
    public static GiftBannerView1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (GiftBannerView1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view1, viewGroup, z, obj);
    }

    public static GiftBannerView1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static GiftBannerView1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (GiftBannerView1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.gift_banner_view1, (ViewGroup) null, false, obj);
    }
}
