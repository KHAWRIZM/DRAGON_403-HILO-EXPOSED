package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ItemAddImageBinding extends ViewDataBinding {
    public final ImageView addImage;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemAddImageBinding(Object obj, View view, int i, ImageView imageView) {
        super(obj, view, i);
        this.addImage = imageView;
    }

    public static ItemAddImageBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemAddImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemAddImageBinding bind(View view, Object obj) {
        return (ItemAddImageBinding) ViewDataBinding.bind(obj, view, R.layout.item_add_image);
    }

    @Deprecated
    public static ItemAddImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemAddImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_add_image, viewGroup, z, obj);
    }

    public static ItemAddImageBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemAddImageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemAddImageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_add_image, (ViewGroup) null, false, obj);
    }
}
