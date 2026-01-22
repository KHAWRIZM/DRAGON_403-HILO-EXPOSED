package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemStoreBinding extends ViewDataBinding {
    public final ConstraintLayout backContent;
    public final TextView diamond;
    public final LinearLayout diamondLayout;
    public final ImageView imagMounts;
    public final ImageView playIcon;
    public final View view;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemStoreBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, View view2) {
        super(obj, view, i);
        this.backContent = constraintLayout;
        this.diamond = textView;
        this.diamondLayout = linearLayout;
        this.imagMounts = imageView;
        this.playIcon = imageView2;
        this.view = view2;
    }

    public static ItemStoreBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemStoreBinding bind(View view, Object obj) {
        return (ItemStoreBinding) ViewDataBinding.bind(obj, view, R.layout.item_store);
    }

    @Deprecated
    public static ItemStoreBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_store, viewGroup, z, obj);
    }

    public static ItemStoreBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemStoreBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemStoreBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_store, (ViewGroup) null, false, obj);
    }
}
