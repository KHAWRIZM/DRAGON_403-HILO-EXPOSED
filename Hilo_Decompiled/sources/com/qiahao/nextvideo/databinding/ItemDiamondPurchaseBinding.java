package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemDiamondPurchaseBinding extends ViewDataBinding {
    public final ImageView bg;
    public final FrameLayout buttonLayout;
    public final TextView diamond;
    public final AppCompatImageView diamondImg;
    public final AppCompatButton diamondPriceText;
    public final AppCompatTextView diamondText;
    public final LinearLayout linearLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDiamondPurchaseBinding(Object obj, View view, int i, ImageView imageView, FrameLayout frameLayout, TextView textView, AppCompatImageView appCompatImageView, AppCompatButton appCompatButton, AppCompatTextView appCompatTextView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.bg = imageView;
        this.buttonLayout = frameLayout;
        this.diamond = textView;
        this.diamondImg = appCompatImageView;
        this.diamondPriceText = appCompatButton;
        this.diamondText = appCompatTextView;
        this.linearLayout = linearLayout;
    }

    public static ItemDiamondPurchaseBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDiamondPurchaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDiamondPurchaseBinding bind(View view, Object obj) {
        return (ItemDiamondPurchaseBinding) ViewDataBinding.bind(obj, view, R.layout.item_diamond_purchase);
    }

    @Deprecated
    public static ItemDiamondPurchaseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDiamondPurchaseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_diamond_purchase, viewGroup, z, obj);
    }

    public static ItemDiamondPurchaseBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDiamondPurchaseBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDiamondPurchaseBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_diamond_purchase, (ViewGroup) null, false, obj);
    }
}
