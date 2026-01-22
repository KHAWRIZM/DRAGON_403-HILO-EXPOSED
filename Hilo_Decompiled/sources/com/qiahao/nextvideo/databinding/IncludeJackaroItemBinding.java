package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class IncludeJackaroItemBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView nickName;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeJackaroItemBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.nickName = textView;
    }

    public static IncludeJackaroItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeJackaroItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeJackaroItemBinding bind(View view, Object obj) {
        return (IncludeJackaroItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_jackaro_item);
    }

    @Deprecated
    public static IncludeJackaroItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeJackaroItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_jackaro_item, viewGroup, z, obj);
    }

    public static IncludeJackaroItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeJackaroItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeJackaroItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_jackaro_item, (ViewGroup) null, false, obj);
    }
}
