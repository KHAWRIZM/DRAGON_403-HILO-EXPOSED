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
public abstract class ItemMedalManegeBinding extends ViewDataBinding {
    public final ImageView medalDefault;
    public final ImageView medalImage;
    public final TextView number;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMedalManegeBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, i);
        this.medalDefault = imageView;
        this.medalImage = imageView2;
        this.number = textView;
    }

    public static ItemMedalManegeBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMedalManegeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMedalManegeBinding bind(View view, Object obj) {
        return (ItemMedalManegeBinding) ViewDataBinding.bind(obj, view, R.layout.item_medal_manege);
    }

    @Deprecated
    public static ItemMedalManegeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMedalManegeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_medal_manege, viewGroup, z, obj);
    }

    public static ItemMedalManegeBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMedalManegeBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMedalManegeBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_medal_manege, (ViewGroup) null, false, obj);
    }
}
