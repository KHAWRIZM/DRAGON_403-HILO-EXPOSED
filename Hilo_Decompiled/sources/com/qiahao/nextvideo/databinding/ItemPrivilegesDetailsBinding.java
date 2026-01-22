package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemPrivilegesDetailsBinding extends ViewDataBinding {
    public final ImageView image;
    public final View indicator;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemPrivilegesDetailsBinding(Object obj, View view, int i, ImageView imageView, View view2) {
        super(obj, view, i);
        this.image = imageView;
        this.indicator = view2;
    }

    public static ItemPrivilegesDetailsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemPrivilegesDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemPrivilegesDetailsBinding bind(View view, Object obj) {
        return (ItemPrivilegesDetailsBinding) ViewDataBinding.bind(obj, view, R.layout.item_privileges_details);
    }

    @Deprecated
    public static ItemPrivilegesDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemPrivilegesDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_privileges_details, viewGroup, z, obj);
    }

    public static ItemPrivilegesDetailsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemPrivilegesDetailsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemPrivilegesDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_privileges_details, (ViewGroup) null, false, obj);
    }
}
