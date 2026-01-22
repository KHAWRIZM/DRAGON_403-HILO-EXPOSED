package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeFamilyItemBinding extends ViewDataBinding {
    public final ConstraintLayout constraintLayout;
    public final QMUIRadiusImageView header;
    public final AppCompatImageView headerBg;
    public final TextView name;
    public final TextView typeText;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeFamilyItemBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, QMUIRadiusImageView qMUIRadiusImageView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout;
        this.header = qMUIRadiusImageView;
        this.headerBg = appCompatImageView;
        this.name = textView;
        this.typeText = textView2;
    }

    public static IncludeFamilyItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeFamilyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeFamilyItemBinding bind(View view, Object obj) {
        return (IncludeFamilyItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_family_item);
    }

    @Deprecated
    public static IncludeFamilyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeFamilyItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_family_item, viewGroup, z, obj);
    }

    public static IncludeFamilyItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeFamilyItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeFamilyItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_family_item, (ViewGroup) null, false, obj);
    }
}
