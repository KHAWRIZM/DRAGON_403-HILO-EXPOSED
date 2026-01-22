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
public abstract class ItemUserDetailSmallPictureBinding extends ViewDataBinding {
    public final ConstraintLayout bodyView;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemUserDetailSmallPictureBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.bodyView = constraintLayout;
        this.image = imageView;
    }

    public static ItemUserDetailSmallPictureBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemUserDetailSmallPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemUserDetailSmallPictureBinding bind(View view, Object obj) {
        return (ItemUserDetailSmallPictureBinding) ViewDataBinding.bind(obj, view, R.layout.item_user_detail_small_picture);
    }

    @Deprecated
    public static ItemUserDetailSmallPictureBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserDetailSmallPictureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_detail_small_picture, viewGroup, z, obj);
    }

    public static ItemUserDetailSmallPictureBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemUserDetailSmallPictureBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserDetailSmallPictureBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_detail_small_picture, (ViewGroup) null, false, obj);
    }
}
