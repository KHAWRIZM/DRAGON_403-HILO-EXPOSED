package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.svip.CustomProgressView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSvipCardBinding extends ViewDataBinding {
    public final ImageView bg;
    public final ConstraintLayout constraint;
    public final TextView date;
    public final TextView defaultText;
    public final TextView grading;
    public final ImageView gradingImage;
    public final Group group;
    public final TextView number;
    public final CustomProgressView progress;
    public final TextView subTitle;
    public final SVGAImageView svga;
    public final TextView tipLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSvipCardBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView2, Group group, TextView textView4, CustomProgressView customProgressView, TextView textView5, SVGAImageView sVGAImageView, TextView textView6) {
        super(obj, view, i);
        this.bg = imageView;
        this.constraint = constraintLayout;
        this.date = textView;
        this.defaultText = textView2;
        this.grading = textView3;
        this.gradingImage = imageView2;
        this.group = group;
        this.number = textView4;
        this.progress = customProgressView;
        this.subTitle = textView5;
        this.svga = sVGAImageView;
        this.tipLayout = textView6;
    }

    public static ItemSvipCardBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSvipCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSvipCardBinding bind(View view, Object obj) {
        return (ItemSvipCardBinding) ViewDataBinding.bind(obj, view, R.layout.item_svip_card);
    }

    @Deprecated
    public static ItemSvipCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSvipCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_svip_card, viewGroup, z, obj);
    }

    public static ItemSvipCardBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSvipCardBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSvipCardBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_svip_card, (ViewGroup) null, false, obj);
    }
}
