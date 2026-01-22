package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCurrentlyPkBinding extends ViewDataBinding {
    public final View blueClick;
    public final ImageView centerBg;
    public final TextView diamond;
    public final QMUIRadiusImageView leftAvatar;
    public final ImageView leftAvatarBg;
    public final TextView leftId;
    public final TextView leftName;
    public final View redClick;
    public final QMUIRadiusImageView rightAvatar;
    public final ImageView rightAvatarBg;
    public final TextView rightId;
    public final TextView rightName;
    public final LinearLayout topLinearLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCurrentlyPkBinding(Object obj, View view, int i, View view2, ImageView imageView, TextView textView, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView2, TextView textView2, TextView textView3, View view3, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView3, TextView textView4, TextView textView5, LinearLayout linearLayout) {
        super(obj, view, i);
        this.blueClick = view2;
        this.centerBg = imageView;
        this.diamond = textView;
        this.leftAvatar = qMUIRadiusImageView;
        this.leftAvatarBg = imageView2;
        this.leftId = textView2;
        this.leftName = textView3;
        this.redClick = view3;
        this.rightAvatar = qMUIRadiusImageView2;
        this.rightAvatarBg = imageView3;
        this.rightId = textView4;
        this.rightName = textView5;
        this.topLinearLayout = linearLayout;
    }

    public static ItemCurrentlyPkBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCurrentlyPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCurrentlyPkBinding bind(View view, Object obj) {
        return (ItemCurrentlyPkBinding) ViewDataBinding.bind(obj, view, R.layout.item_currently_pk);
    }

    @Deprecated
    public static ItemCurrentlyPkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCurrentlyPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_currently_pk, viewGroup, z, obj);
    }

    public static ItemCurrentlyPkBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCurrentlyPkBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCurrentlyPkBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_currently_pk, (ViewGroup) null, false, obj);
    }
}
