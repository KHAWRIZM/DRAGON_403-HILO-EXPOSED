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
import com.qiahao.nextvideo.ui.reusable.CircleImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class EnvelopeBannerBinding extends ViewDataBinding {
    public final ConstraintLayout contentClick;
    public final TextView contentText;
    public final ConstraintLayout defaultLayout;
    public final SVGAImageView defaultSVGA;
    public final TextView diamond;
    public final CircleImageView sendAvatar;
    public final TextView userCode;
    public final TextView userName;

    /* JADX INFO: Access modifiers changed from: protected */
    public EnvelopeBannerBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, SVGAImageView sVGAImageView, TextView textView2, CircleImageView circleImageView, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.contentClick = constraintLayout;
        this.contentText = textView;
        this.defaultLayout = constraintLayout2;
        this.defaultSVGA = sVGAImageView;
        this.diamond = textView2;
        this.sendAvatar = circleImageView;
        this.userCode = textView3;
        this.userName = textView4;
    }

    public static EnvelopeBannerBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static EnvelopeBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static EnvelopeBannerBinding bind(View view, Object obj) {
        return (EnvelopeBannerBinding) ViewDataBinding.bind(obj, view, R.layout.envelope_banner);
    }

    @Deprecated
    public static EnvelopeBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EnvelopeBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.envelope_banner, viewGroup, z, obj);
    }

    public static EnvelopeBannerBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static EnvelopeBannerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EnvelopeBannerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.envelope_banner, (ViewGroup) null, false, obj);
    }
}
