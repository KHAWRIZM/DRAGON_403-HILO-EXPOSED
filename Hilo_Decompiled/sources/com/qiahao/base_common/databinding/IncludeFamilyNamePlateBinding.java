package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.base_common.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class IncludeFamilyNamePlateBinding extends ViewDataBinding {
    public final ImageView medal;
    public final TextView namePlate;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeFamilyNamePlateBinding(Object obj, View view, int i10, ImageView imageView, TextView textView) {
        super(obj, view, i10);
        this.medal = imageView;
        this.namePlate = textView;
    }

    public static IncludeFamilyNamePlateBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeFamilyNamePlateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        g.g();
        return inflate(layoutInflater, viewGroup, z10, null);
    }

    @Deprecated
    public static IncludeFamilyNamePlateBinding bind(View view, Object obj) {
        return (IncludeFamilyNamePlateBinding) ViewDataBinding.bind(obj, view, R.layout.include_family_name_plate);
    }

    @Deprecated
    public static IncludeFamilyNamePlateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10, Object obj) {
        return (IncludeFamilyNamePlateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_family_name_plate, viewGroup, z10, obj);
    }

    public static IncludeFamilyNamePlateBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeFamilyNamePlateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeFamilyNamePlateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_family_name_plate, null, false, obj);
    }
}
