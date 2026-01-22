package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class EditCountryBinding extends ViewDataBinding {
    public final AppCompatTextView countryNameTextView;
    public final AppCompatImageView countryTagImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditCountryBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.countryNameTextView = appCompatTextView;
        this.countryTagImageView = appCompatImageView;
    }

    public static EditCountryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static EditCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static EditCountryBinding bind(View view, Object obj) {
        return (EditCountryBinding) ViewDataBinding.bind(obj, view, R.layout.edit_country);
    }

    @Deprecated
    public static EditCountryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EditCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.edit_country, viewGroup, z, obj);
    }

    public static EditCountryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static EditCountryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EditCountryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.edit_country, (ViewGroup) null, false, obj);
    }
}
