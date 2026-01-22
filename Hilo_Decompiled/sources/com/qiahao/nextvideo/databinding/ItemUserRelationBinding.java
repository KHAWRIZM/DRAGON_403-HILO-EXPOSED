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
public abstract class ItemUserRelationBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final ImageView bg;
    public final ConstraintLayout constraint;
    public final TextView level;
    public final TextView name;
    public final TextView time;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemUserRelationBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.bg = imageView;
        this.constraint = constraintLayout;
        this.level = textView;
        this.name = textView2;
        this.time = textView3;
        this.title = textView4;
    }

    public static ItemUserRelationBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemUserRelationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemUserRelationBinding bind(View view, Object obj) {
        return (ItemUserRelationBinding) ViewDataBinding.bind(obj, view, R.layout.item_user_relation);
    }

    @Deprecated
    public static ItemUserRelationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserRelationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_relation, viewGroup, z, obj);
    }

    public static ItemUserRelationBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemUserRelationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserRelationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_relation, (ViewGroup) null, false, obj);
    }
}
