package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemSelectImageBinding extends ViewDataBinding {
    public final ImageView deleteImage;
    public final TextView duration;
    public final QMUIRadiusImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemSelectImageBinding(Object obj, View view, int i, ImageView imageView, TextView textView, QMUIRadiusImageView qMUIRadiusImageView) {
        super(obj, view, i);
        this.deleteImage = imageView;
        this.duration = textView;
        this.image = qMUIRadiusImageView;
    }

    public static ItemSelectImageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemSelectImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemSelectImageBinding bind(View view, Object obj) {
        return (ItemSelectImageBinding) ViewDataBinding.bind(obj, view, R.layout.item_select_image);
    }

    @Deprecated
    public static ItemSelectImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemSelectImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_select_image, viewGroup, z, obj);
    }

    public static ItemSelectImageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemSelectImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemSelectImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_select_image, (ViewGroup) null, false, obj);
    }
}
