package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogSuperLikeBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView close;
    public final TextView diamondOne;
    public final TextView diamondTwo;
    public final ImageView head;
    public final ConstraintLayout sendBtn;
    public final TextView superContent;
    public final TextView superLike;
    public final TextView superSubContent;
    public final ImageView superTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogSuperLikeBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView3, TextView textView4, TextView textView5, ImageView imageView3) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.close = imageView;
        this.diamondOne = textView;
        this.diamondTwo = textView2;
        this.head = imageView2;
        this.sendBtn = constraintLayout;
        this.superContent = textView3;
        this.superLike = textView4;
        this.superSubContent = textView5;
        this.superTitle = imageView3;
    }

    public static DialogSuperLikeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogSuperLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogSuperLikeBinding bind(View view, Object obj) {
        return (DialogSuperLikeBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_super_like);
    }

    @Deprecated
    public static DialogSuperLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogSuperLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_super_like, viewGroup, z, obj);
    }

    public static DialogSuperLikeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogSuperLikeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogSuperLikeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_super_like, (ViewGroup) null, false, obj);
    }
}
