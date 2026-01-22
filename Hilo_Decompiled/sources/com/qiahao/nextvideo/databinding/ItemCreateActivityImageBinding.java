package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemCreateActivityImageBinding extends ViewDataBinding {
    public final QMUIRadiusImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemCreateActivityImageBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView) {
        super(obj, view, i);
        this.image = qMUIRadiusImageView;
    }

    public static ItemCreateActivityImageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemCreateActivityImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemCreateActivityImageBinding bind(View view, Object obj) {
        return (ItemCreateActivityImageBinding) ViewDataBinding.bind(obj, view, R.layout.item_create_activity_image);
    }

    @Deprecated
    public static ItemCreateActivityImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemCreateActivityImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_create_activity_image, viewGroup, z, obj);
    }

    public static ItemCreateActivityImageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemCreateActivityImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemCreateActivityImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_create_activity_image, (ViewGroup) null, false, obj);
    }
}
