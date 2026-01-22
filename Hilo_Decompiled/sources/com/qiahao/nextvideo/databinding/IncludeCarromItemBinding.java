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
public abstract class IncludeCarromItemBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatar;
    public final TextView nickName;

    /* JADX INFO: Access modifiers changed from: protected */
    public IncludeCarromItemBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView) {
        super(obj, view, i);
        this.avatar = qMUIRadiusImageView;
        this.nickName = textView;
    }

    public static IncludeCarromItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static IncludeCarromItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static IncludeCarromItemBinding bind(View view, Object obj) {
        return (IncludeCarromItemBinding) ViewDataBinding.bind(obj, view, R.layout.include_carrom_item);
    }

    @Deprecated
    public static IncludeCarromItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (IncludeCarromItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_carrom_item, viewGroup, z, obj);
    }

    public static IncludeCarromItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static IncludeCarromItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (IncludeCarromItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.include_carrom_item, (ViewGroup) null, false, obj);
    }
}
