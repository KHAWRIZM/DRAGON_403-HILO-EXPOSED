package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMyBagBinding extends ViewDataBinding {
    public final ConstraintLayout backContent;
    public final AppCompatImageView delete;
    public final TextView isUsing;
    public final ImageView picGoods;
    public final TextView textTime;
    public final View view;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMyBagBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, ImageView imageView, TextView textView2, View view2) {
        super(obj, view, i);
        this.backContent = constraintLayout;
        this.delete = appCompatImageView;
        this.isUsing = textView;
        this.picGoods = imageView;
        this.textTime = textView2;
        this.view = view2;
    }

    public static ItemMyBagBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMyBagBinding bind(View view, Object obj) {
        return (ItemMyBagBinding) ViewDataBinding.bind(obj, view, R.layout.item_my_bag);
    }

    @Deprecated
    public static ItemMyBagBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_my_bag, viewGroup, z, obj);
    }

    public static ItemMyBagBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMyBagBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMyBagBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_my_bag, (ViewGroup) null, false, obj);
    }
}
