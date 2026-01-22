package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemMountsBinding extends ViewDataBinding {
    public final ImageView imagMounts;
    public final ConstraintLayout rootContainer;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemMountsBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.imagMounts = imageView;
        this.rootContainer = constraintLayout;
    }

    public static ItemMountsBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemMountsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemMountsBinding bind(View view, Object obj) {
        return (ItemMountsBinding) ViewDataBinding.bind(obj, view, R.layout.item_mounts);
    }

    @Deprecated
    public static ItemMountsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemMountsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mounts, viewGroup, z, obj);
    }

    public static ItemMountsBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemMountsBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemMountsBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_mounts, (ViewGroup) null, false, obj);
    }
}
