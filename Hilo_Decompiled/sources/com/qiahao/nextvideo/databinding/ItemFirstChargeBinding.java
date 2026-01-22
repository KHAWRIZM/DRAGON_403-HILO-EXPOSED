package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemFirstChargeBinding extends ViewDataBinding {
    public final View bg;
    public final TextView day;
    public final TextView diamond;
    public final ImageView gift;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemFirstChargeBinding(Object obj, View view, int i, View view2, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.bg = view2;
        this.day = textView;
        this.diamond = textView2;
        this.gift = imageView;
        this.image = imageView2;
    }

    public static ItemFirstChargeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemFirstChargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemFirstChargeBinding bind(View view, Object obj) {
        return (ItemFirstChargeBinding) ViewDataBinding.bind(obj, view, R.layout.item_first_charge);
    }

    @Deprecated
    public static ItemFirstChargeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemFirstChargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_first_charge, viewGroup, z, obj);
    }

    public static ItemFirstChargeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemFirstChargeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemFirstChargeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_first_charge, (ViewGroup) null, false, obj);
    }
}
