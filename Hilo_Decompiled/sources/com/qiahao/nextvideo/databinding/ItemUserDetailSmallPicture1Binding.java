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
public abstract class ItemUserDetailSmallPicture1Binding extends ViewDataBinding {
    public final ConstraintLayout bodyView;
    public final ImageView image;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemUserDetailSmallPicture1Binding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView) {
        super(obj, view, i);
        this.bodyView = constraintLayout;
        this.image = imageView;
    }

    public static ItemUserDetailSmallPicture1Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ItemUserDetailSmallPicture1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ItemUserDetailSmallPicture1Binding bind(View view, Object obj) {
        return (ItemUserDetailSmallPicture1Binding) ViewDataBinding.bind(obj, view, R.layout.item_user_detail_small_picture1);
    }

    @Deprecated
    public static ItemUserDetailSmallPicture1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ItemUserDetailSmallPicture1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_detail_small_picture1, viewGroup, z, obj);
    }

    public static ItemUserDetailSmallPicture1Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ItemUserDetailSmallPicture1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ItemUserDetailSmallPicture1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_user_detail_small_picture1, (ViewGroup) null, false, obj);
    }
}
