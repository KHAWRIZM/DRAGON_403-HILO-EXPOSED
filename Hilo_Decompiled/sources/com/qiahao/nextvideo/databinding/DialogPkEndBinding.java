package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.widget.text.GradientTextView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogPkEndBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView bg;
    public final ImageView close;
    public final GradientTextView diamond;
    public final TextView name;
    public final QMUIRadiusImageView oneAvatar;
    public final TextView oneDiamond;
    public final SVGAImageView pkSvga;
    public final ImageView roomBg;
    public final QMUIRadiusImageView threeAvatar;
    public final TextView threeDiamond;
    public final QMUIRadiusImageView twoAvatar;
    public final TextView twoDiamond;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPkEndBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ImageView imageView2, GradientTextView gradientTextView, TextView textView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView2, SVGAImageView sVGAImageView, ImageView imageView3, QMUIRadiusImageView qMUIRadiusImageView3, TextView textView3, QMUIRadiusImageView qMUIRadiusImageView4, TextView textView4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.bg = imageView;
        this.close = imageView2;
        this.diamond = gradientTextView;
        this.name = textView;
        this.oneAvatar = qMUIRadiusImageView2;
        this.oneDiamond = textView2;
        this.pkSvga = sVGAImageView;
        this.roomBg = imageView3;
        this.threeAvatar = qMUIRadiusImageView3;
        this.threeDiamond = textView3;
        this.twoAvatar = qMUIRadiusImageView4;
        this.twoDiamond = textView4;
    }

    public static DialogPkEndBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogPkEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogPkEndBinding bind(View view, Object obj) {
        return (DialogPkEndBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_pk_end);
    }

    @Deprecated
    public static DialogPkEndBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPkEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pk_end, viewGroup, z, obj);
    }

    public static DialogPkEndBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogPkEndBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPkEndBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pk_end, (ViewGroup) null, false, obj);
    }
}
