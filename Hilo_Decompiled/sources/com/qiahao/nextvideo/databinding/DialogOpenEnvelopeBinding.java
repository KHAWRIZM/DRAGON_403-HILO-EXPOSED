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
public abstract class DialogOpenEnvelopeBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView bg;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final TextView envelopeDetail;
    public final SVGAImageView flipSvga;
    public final SVGAImageView lightSvga;
    public final TextView okBtn;
    public final TextView openDiamond;
    public final ImageView openDiamondImg;
    public final TextView openName;
    public final TextView openSubTitle;
    public final SVGAImageView openSvga;
    public final TextView time;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogOpenEnvelopeBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, SVGAImageView sVGAImageView, SVGAImageView sVGAImageView2, TextView textView2, TextView textView3, ImageView imageView3, TextView textView4, TextView textView5, SVGAImageView sVGAImageView3, TextView textView6) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.bg = imageView;
        this.close = imageView2;
        this.constraint = constraintLayout;
        this.envelopeDetail = textView;
        this.flipSvga = sVGAImageView;
        this.lightSvga = sVGAImageView2;
        this.okBtn = textView2;
        this.openDiamond = textView3;
        this.openDiamondImg = imageView3;
        this.openName = textView4;
        this.openSubTitle = textView5;
        this.openSvga = sVGAImageView3;
        this.time = textView6;
    }

    public static DialogOpenEnvelopeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogOpenEnvelopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogOpenEnvelopeBinding bind(View view, Object obj) {
        return (DialogOpenEnvelopeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_open_envelope);
    }

    @Deprecated
    public static DialogOpenEnvelopeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogOpenEnvelopeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_open_envelope, viewGroup, z, obj);
    }

    public static DialogOpenEnvelopeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogOpenEnvelopeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogOpenEnvelopeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_open_envelope, (ViewGroup) null, false, obj);
    }
}
