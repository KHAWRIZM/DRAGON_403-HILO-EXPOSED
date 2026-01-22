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
public abstract class ItemPrivilegesImageBinding extends ViewDataBinding {
    public final QMUIRadiusImageView image;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPrivilegesImageBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, TextView textView) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView;
        this.title = textView;
    }

    public static ItemPrivilegesImageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPrivilegesImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPrivilegesImageBinding bind(View view, Object obj) {
        return (ItemPrivilegesImageBinding) ViewDataBinding.bind(obj, view, R.layout.item_privileges_image);
    }

    @Deprecated
    public static ItemPrivilegesImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPrivilegesImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_privileges_image, viewGroup, z, obj);
    }

    public static ItemPrivilegesImageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPrivilegesImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPrivilegesImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_privileges_image, (ViewGroup) null, false, obj);
    }
}
