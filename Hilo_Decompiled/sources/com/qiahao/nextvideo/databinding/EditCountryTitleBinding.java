package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class EditCountryTitleBinding extends ViewDataBinding {
    public final AppCompatTextView countryTagTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    public EditCountryTitleBinding(Object obj, View view, int i, AppCompatTextView appCompatTextView) {
        super(obj, view, i);
        this.countryTagTextView = appCompatTextView;
    }

    public static EditCountryTitleBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static EditCountryTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static EditCountryTitleBinding bind(View view, Object obj) {
        return (EditCountryTitleBinding) ViewDataBinding.bind(obj, view, R.layout.edit_country_title);
    }

    @Deprecated
    public static EditCountryTitleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (EditCountryTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.edit_country_title, viewGroup, z, obj);
    }

    public static EditCountryTitleBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static EditCountryTitleBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (EditCountryTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.edit_country_title, (ViewGroup) null, false, obj);
    }
}
