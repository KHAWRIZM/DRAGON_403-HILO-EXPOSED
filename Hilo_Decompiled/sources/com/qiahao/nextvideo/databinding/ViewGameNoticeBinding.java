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
public abstract class ViewGameNoticeBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ConstraintLayout constraintLayout;
    public final TextView diamond;
    public final ImageView diamondImage;
    public final TextView title;
    public final ImageView topImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewGameNoticeBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ConstraintLayout constraintLayout, TextView textView, ImageView imageView, TextView textView2, ImageView imageView2) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.constraintLayout = constraintLayout;
        this.diamond = textView;
        this.diamondImage = imageView;
        this.title = textView2;
        this.topImage = imageView2;
    }

    public static ViewGameNoticeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewGameNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewGameNoticeBinding bind(View view, Object obj) {
        return (ViewGameNoticeBinding) ViewDataBinding.bind(obj, view, R.layout.view_game_notice);
    }

    @Deprecated
    public static ViewGameNoticeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewGameNoticeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_notice, viewGroup, z, obj);
    }

    public static ViewGameNoticeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewGameNoticeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewGameNoticeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_game_notice, (ViewGroup) null, false, obj);
    }
}
