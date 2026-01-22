package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogStrangeLikeBinding extends ViewDataBinding {
    public final ImageView centerImage;
    public final ImageView close;
    public final ConstraintLayout constraint;
    public final TextView content;
    public final FrameLayout frameLayout;
    public final QMUIRadiusImageView leftAvatar;
    public final TextView like;
    public final SVGAImageView likeSvga;
    public final QMUIRadiusImageView rightAvatar;
    public final TextView title;
    public final View topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogStrangeLikeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView, FrameLayout frameLayout, QMUIRadiusImageView qMUIRadiusImageView, TextView textView2, SVGAImageView sVGAImageView, QMUIRadiusImageView qMUIRadiusImageView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.centerImage = imageView;
        this.close = imageView2;
        this.constraint = constraintLayout;
        this.content = textView;
        this.frameLayout = frameLayout;
        this.leftAvatar = qMUIRadiusImageView;
        this.like = textView2;
        this.likeSvga = sVGAImageView;
        this.rightAvatar = qMUIRadiusImageView2;
        this.title = textView3;
        this.topBg = view2;
    }

    public static DialogStrangeLikeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogStrangeLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogStrangeLikeBinding bind(View view, Object obj) {
        return (DialogStrangeLikeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_strange_like);
    }

    @Deprecated
    public static DialogStrangeLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogStrangeLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_strange_like, viewGroup, z, obj);
    }

    public static DialogStrangeLikeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogStrangeLikeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogStrangeLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_strange_like, (ViewGroup) null, false, obj);
    }
}
