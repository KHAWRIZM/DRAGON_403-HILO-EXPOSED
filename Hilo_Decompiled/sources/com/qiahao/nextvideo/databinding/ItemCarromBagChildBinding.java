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

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCarromBagChildBinding extends ViewDataBinding {
    public final ConstraintLayout backContent;
    public final ImageView imag;
    public final TextView isUsing;
    public final ImageView timeIcon;
    public final TextView title;
    public final View view;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCarromBagChildBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, View view2) {
        super(obj, view, i);
        this.backContent = constraintLayout;
        this.imag = imageView;
        this.isUsing = textView;
        this.timeIcon = imageView2;
        this.title = textView2;
        this.view = view2;
    }

    public static ItemCarromBagChildBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCarromBagChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCarromBagChildBinding bind(View view, Object obj) {
        return (ItemCarromBagChildBinding) ViewDataBinding.bind(obj, view, R.layout.item_carrom_bag_child);
    }

    @Deprecated
    public static ItemCarromBagChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCarromBagChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_carrom_bag_child, viewGroup, z, obj);
    }

    public static ItemCarromBagChildBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCarromBagChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCarromBagChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_carrom_bag_child, (ViewGroup) null, false, obj);
    }
}
