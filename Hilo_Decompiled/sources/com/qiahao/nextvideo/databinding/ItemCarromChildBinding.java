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
public abstract class ItemCarromChildBinding extends ViewDataBinding {
    public final ConstraintLayout backContent;
    public final View bg;
    public final ImageView imag;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCarromChildBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, View view2, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.backContent = constraintLayout;
        this.bg = view2;
        this.imag = imageView;
        this.title = textView;
    }

    public static ItemCarromChildBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCarromChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCarromChildBinding bind(View view, Object obj) {
        return (ItemCarromChildBinding) ViewDataBinding.bind(obj, view, R.layout.item_carrom_child);
    }

    @Deprecated
    public static ItemCarromChildBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCarromChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_carrom_child, viewGroup, z, obj);
    }

    public static ItemCarromChildBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCarromChildBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCarromChildBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_carrom_child, (ViewGroup) null, false, obj);
    }
}
