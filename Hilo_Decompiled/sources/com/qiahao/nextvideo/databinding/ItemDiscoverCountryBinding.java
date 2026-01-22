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
public abstract class ItemDiscoverCountryBinding extends ViewDataBinding {
    public final ConstraintLayout constraint;
    public final ImageView countryPic;
    public final TextView shortCountyName;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemDiscoverCountryBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.constraint = constraintLayout;
        this.countryPic = imageView;
        this.shortCountyName = textView;
    }

    public static ItemDiscoverCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemDiscoverCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemDiscoverCountryBinding bind(View view, Object obj) {
        return (ItemDiscoverCountryBinding) ViewDataBinding.bind(obj, view, R.layout.item_discover_country);
    }

    @Deprecated
    public static ItemDiscoverCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemDiscoverCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_discover_country, viewGroup, z, obj);
    }

    public static ItemDiscoverCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemDiscoverCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemDiscoverCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_discover_country, (ViewGroup) null, false, obj);
    }
}
