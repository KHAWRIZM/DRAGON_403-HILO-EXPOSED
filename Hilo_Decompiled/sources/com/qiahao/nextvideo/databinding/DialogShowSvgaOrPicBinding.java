package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogShowSvgaOrPicBinding extends ViewDataBinding {
    public final ImageView bgContent;
    public final ImageView bigPic;
    public final SVGAImageView bigSvga;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogShowSvgaOrPicBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.bgContent = imageView;
        this.bigPic = imageView2;
        this.bigSvga = sVGAImageView;
    }

    public static DialogShowSvgaOrPicBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogShowSvgaOrPicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogShowSvgaOrPicBinding bind(View view, Object obj) {
        return (DialogShowSvgaOrPicBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_show_svga_or_pic);
    }

    @Deprecated
    public static DialogShowSvgaOrPicBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogShowSvgaOrPicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_show_svga_or_pic, viewGroup, z, obj);
    }

    public static DialogShowSvgaOrPicBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogShowSvgaOrPicBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogShowSvgaOrPicBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_show_svga_or_pic, (ViewGroup) null, false, obj);
    }
}
