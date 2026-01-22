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
public abstract class ViewVoteLayoutBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final QMUIRadiusImageView avatar1;
    public final QMUIRadiusImageView avatar2;
    public final QMUIRadiusImageView avatar3;
    public final ImageView avatarHeader;
    public final ConstraintLayout constraint;
    public final TextView name;
    public final ImageView topBg;
    public final TextView voteButton;
    public final TextView voteNumber;
    public final TextView voteText;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewVoteLayoutBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, QMUIRadiusImageView qMUIRadiusImageView3, QMUIRadiusImageView qMUIRadiusImageView4, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.avatar1 = qMUIRadiusImageView2;
        this.avatar2 = qMUIRadiusImageView3;
        this.avatar3 = qMUIRadiusImageView4;
        this.avatarHeader = imageView;
        this.constraint = constraintLayout;
        this.name = textView;
        this.topBg = imageView2;
        this.voteButton = textView2;
        this.voteNumber = textView3;
        this.voteText = textView4;
    }

    public static ViewVoteLayoutBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewVoteLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewVoteLayoutBinding bind(View view, Object obj) {
        return (ViewVoteLayoutBinding) ViewDataBinding.bind(obj, view, R.layout.view_vote_layout);
    }

    @Deprecated
    public static ViewVoteLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewVoteLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_vote_layout, viewGroup, z, obj);
    }

    public static ViewVoteLayoutBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewVoteLayoutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewVoteLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_vote_layout, (ViewGroup) null, false, obj);
    }
}
