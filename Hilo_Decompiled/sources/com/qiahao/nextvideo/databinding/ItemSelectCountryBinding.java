package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSelectCountryBinding extends ViewDataBinding {
    public final QMUIRadiusImageView2 image;
    public final TextView name;
    public final TextView phoneNumber;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSelectCountryBinding(Object obj, View view, int i, QMUIRadiusImageView2 qMUIRadiusImageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView2;
        this.name = textView;
        this.phoneNumber = textView2;
    }

    public static ItemSelectCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSelectCountryBinding bind(View view, Object obj) {
        return (ItemSelectCountryBinding) ViewDataBinding.bind(obj, view, R.layout.item_select_country);
    }

    @Deprecated
    public static ItemSelectCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSelectCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_select_country, viewGroup, z, obj);
    }

    public static ItemSelectCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSelectCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSelectCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_select_country, (ViewGroup) null, false, obj);
    }
}
