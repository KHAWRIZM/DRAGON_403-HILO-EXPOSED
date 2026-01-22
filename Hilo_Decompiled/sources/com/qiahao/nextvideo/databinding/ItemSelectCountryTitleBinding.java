package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSelectCountryTitleBinding extends ViewDataBinding {
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSelectCountryTitleBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.title = textView;
    }

    public static ItemSelectCountryTitleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSelectCountryTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSelectCountryTitleBinding bind(View view, Object obj) {
        return (ItemSelectCountryTitleBinding) ViewDataBinding.bind(obj, view, R.layout.item_select_country_title);
    }

    @Deprecated
    public static ItemSelectCountryTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSelectCountryTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_select_country_title, viewGroup, z, obj);
    }

    public static ItemSelectCountryTitleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSelectCountryTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSelectCountryTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_select_country_title, (ViewGroup) null, false, obj);
    }
}
