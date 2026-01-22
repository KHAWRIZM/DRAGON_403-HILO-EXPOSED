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
public abstract class ItemCountryBinding extends ViewDataBinding {
    public final ImageView countryPic;
    public final TextView shortCountyName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCountryBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.countryPic = imageView;
        this.shortCountyName = textView;
    }

    public static ItemCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCountryBinding bind(View view, Object obj) {
        return (ItemCountryBinding) ViewDataBinding.bind(obj, view, R.layout.item_country);
    }

    @Deprecated
    public static ItemCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_country, viewGroup, z, obj);
    }

    public static ItemCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_country, (ViewGroup) null, false, obj);
    }
}
